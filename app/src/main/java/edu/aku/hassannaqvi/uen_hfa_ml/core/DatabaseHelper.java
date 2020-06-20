package edu.aku.hassannaqvi.uen_hfa_ml.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import edu.aku.hassannaqvi.uen_hfa_ml.contracts.DistrictContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.HFContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.TehsilsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.VersionAppContract;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_DISTRICTS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_HF;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_TEHSILS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_UCS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_VERSIONAPP;


/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String SQL_DELETE_DISTRICTS = "DROP TABLE IF EXISTS " + DistrictContract.singleDistrict.TABLE_NAME;
    private static final String SQL_DELETE_TALUKAS = "DROP TABLE IF EXISTS " + TehsilsContract.singleTehsil.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + UCsContract.singleUCs.TABLE_NAME;

    private final String TAG = "DatabaseHelper";

    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_DISTRICTS);
        db.execSQL(SQL_CREATE_TEHSILS);
        db.execSQL(SQL_CREATE_UCS);
        db.execSQL(SQL_CREATE_HF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }


    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersContract.singleUser.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.singleUser.ROW_USERNAME, user.getUserName());
                values.put(UsersContract.singleUser.ROW_PASSWORD, user.getPassword());
                db.insert(UsersContract.singleUser.TABLE_NAME, null, values);
            }

        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }


    public void syncDistricts(JSONArray Districtslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DistrictContract.singleDistrict.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Districtslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                DistrictContract Vc = new DistrictContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(DistrictContract.singleDistrict.COLUMN_DISTRICT_CODE, Vc.getDistrictCode());
                values.put(DistrictContract.singleDistrict.COLUMN_DISTRICT_NAME, Vc.getDistrictName());

                db.insert(DistrictContract.singleDistrict.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }


    public void syncTehsils(JSONArray Tehsilslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TehsilsContract.singleTehsil.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Tehsilslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                TehsilsContract Vc = new TehsilsContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(TehsilsContract.singleTehsil.COLUMN_TEHSIL_CODE, Vc.getTehsilCode());
                values.put(TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME, Vc.getTehsilName());
                values.put(TehsilsContract.singleTehsil.COLUMN_DISTRICT_CODE, Vc.getDistrictcode());

                db.insert(TehsilsContract.singleTehsil.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }


    public void syncUCs(JSONArray UCslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UCsContract.singleUCs.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = UCslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                UCsContract Vc = new UCsContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(UCsContract.singleUCs.COLUMN_UC_CODE, Vc.getUc_code());
                values.put(UCsContract.singleUCs.COLUMN_UC_NAME, Vc.getUc_name());
                values.put(UCsContract.singleUCs.COLUMN_TEHSIL_CODE, Vc.getTehsil_code());

                db.insert(UCsContract.singleUCs.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }


    public void syncHF(JSONArray HFlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(HFContract.singleHF.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = HFlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                HFContract Vc = new HFContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(HFContract.singleHF.COLUMN_HF_CODE, Vc.getHf_code());
                values.put(HFContract.singleHF.COLUMN_HF_NAME, Vc.getHf_name());
                values.put(HFContract.singleHF.COLUMN_HF_TYPE, Vc.getHf_type());
                values.put(HFContract.singleHF.COLUMN_TEHSIL_CODE, Vc.getTehsil_code());

                db.insert(HFContract.singleHF.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }


    public Collection<DistrictContract> getAllDistricts() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                DistrictContract.singleDistrict.COLUMN_DISTRICT_CODE,
                DistrictContract.singleDistrict.COLUMN_DISTRICT_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                DistrictContract.singleDistrict.COLUMN_DISTRICT_NAME + " ASC";

        Collection<DistrictContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    DistrictContract.singleDistrict.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                DistrictContract dc = new DistrictContract();
                allDC.add(dc.HydrateDistrict(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<TehsilsContract> getAllTehsils() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_CODE,
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME,
                TehsilsContract.singleTehsil.COLUMN_DISTRICT_CODE
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME + " ASC";

        Collection<TehsilsContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    TehsilsContract.singleTehsil.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TehsilsContract dc = new TehsilsContract();
                allDC.add(dc.HydrateTehsils(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<TehsilsContract> getAllTehsils(String districtCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_CODE,
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME,
                TehsilsContract.singleTehsil.COLUMN_DISTRICT_CODE
        };

        String whereClause = TehsilsContract.singleTehsil.COLUMN_DISTRICT_CODE + "=?";
        String[] whereArgs = new String[]{districtCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                TehsilsContract.singleTehsil.COLUMN_TEHSIL_NAME + " ASC";

        Collection<TehsilsContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    TehsilsContract.singleTehsil.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TehsilsContract dc = new TehsilsContract();
                allDC.add(dc.HydrateTehsils(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<UCsContract> getAllUCs(String tehsilCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UCsContract.singleUCs.COLUMN_UC_CODE,
                UCsContract.singleUCs.COLUMN_UC_NAME,
                UCsContract.singleUCs.COLUMN_TEHSIL_CODE
        };

        String whereClause = UCsContract.singleUCs.COLUMN_TEHSIL_CODE + "=?";
        String[] whereArgs = new String[]{tehsilCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                UCsContract.singleUCs.COLUMN_UC_NAME + " ASC";

        Collection<UCsContract> allDC = new ArrayList<>();
        try {
            c = db.query(
                    UCsContract.singleUCs.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract dc = new UCsContract();
                allDC.add(dc.HydrateUCs(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }


    public Collection<HFContract> getAllHFs(String tehsilCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                HFContract.singleHF.COLUMN_TEHSIL_CODE,
                HFContract.singleHF.COLUMN_HF_TYPE,
                HFContract.singleHF.COLUMN_HF_CODE,
                HFContract.singleHF.COLUMN_HF_NAME
        };

        String whereClause = HFContract.singleHF.COLUMN_TEHSIL_CODE + "=?";
        String[] whereArgs = new String[]{tehsilCode};
        String groupBy = null;
        String having = null;

        String orderBy =
                HFContract.singleHF.COLUMN_HF_NAME + " ASC";

        Collection<HFContract> allHF = new ArrayList<>();
        try {
            c = db.query(
                    HFContract.singleHF.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HFContract hf = new HFContract();
                allHF.add(hf.HydrateHF(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allHF;
    }


    public Collection<HFContract> getAllHFs(String tehsilCode, String hfType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                HFContract.singleHF.COLUMN_TEHSIL_CODE,
                HFContract.singleHF.COLUMN_HF_TYPE,
                HFContract.singleHF.COLUMN_HF_CODE,
                HFContract.singleHF.COLUMN_HF_NAME
        };

        String whereClause = HFContract.singleHF.COLUMN_TEHSIL_CODE + "=?" + " AND " + HFContract.singleHF.COLUMN_HF_TYPE + "=?";
        String[] whereArgs = new String[]{tehsilCode, hfType};
        String groupBy = null;
        String having = null;

        String orderBy =
                HFContract.singleHF.COLUMN_HF_NAME + " ASC";

        Collection<HFContract> allHF = new ArrayList<>();
        try {
            c = db.query(
                    HFContract.singleHF.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                HFContract hf = new HFContract();
                allHF.add(hf.HydrateHF(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allHF;
    }


    public void syncVersionApp(JSONArray Versionlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(VersionAppContract.VersionAppTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Versionlist;
            JSONObject jsonObjectCC = jsonArray.getJSONObject(0);

            VersionAppContract Vc = new VersionAppContract();
            Vc.Sync(jsonObjectCC);

            ContentValues values = new ContentValues();

            values.put(VersionAppContract.VersionAppTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            db.insert(VersionAppContract.VersionAppTable.TABLE_NAME, null, values);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }


    public VersionAppContract getVersionApp() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                VersionAppContract.VersionAppTable._ID,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE,
                VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME,
                VersionAppContract.VersionAppTable.COLUMN_PATH_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = null;

        VersionAppContract allVC = new VersionAppContract();
        try {
            c = db.query(
                    VersionAppContract.VersionAppTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allVC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allVC;
    }


    public boolean Login(String username, String password) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + UsersContract.singleUser.TABLE_NAME + " WHERE " + UsersContract.singleUser.ROW_USERNAME + "=? AND " + UsersContract.singleUser.ROW_PASSWORD + "=?", new String[]{username, password});
        if (mCursor != null) {

            /*if (mCursor.moveToFirst()) {
                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(UsersContract.singleUser.DIST_ID));
                }*/
            return mCursor.getCount() > 0;
        }
        return false;
    }


    public boolean CheckHF(String hfCode) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + FormsTable.TABLE_NAME + " WHERE " + FormsTable.COLUMN_A12 + "=? AND " + FormsTable.COLUMN_ISTATUS + "=?", new String[]{hfCode, "1"});
        if (mCursor != null) {

            /*if (mCursor.moveToFirst()) {
                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(UsersContract.singleUser.DIST_ID));
                }*/
            return mCursor.getCount() > 0;
        }
        return false;
    }


    public boolean CheckHF(String hfCode, String status) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.rawQuery("SELECT * FROM " + FormsTable.TABLE_NAME + " WHERE " + FormsTable.COLUMN_A12 + "=? AND " + FormsTable.COLUMN_ISTATUS + "=?", new String[]{hfCode, status});
        if (mCursor != null) {

            /*if (mCursor.moveToFirst()) {
                    MainApp.DIST_ID = mCursor.getString(mCursor.getColumnIndex(UsersContract.singleUser.DIST_ID));
                }*/
            return mCursor.getCount() > 0;
        }
        return false;
    }


    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, FormsContract.projectName);
        values.put(FormsTable.COLUMN_UID, fc.uid);
        values.put(FormsTable.COLUMN_UUID, fc.uuid);
        values.put(FormsTable.COLUMN_FORMDATE, fc.formdate);
        values.put(FormsTable.COLUMN_SERIALNO, fc.serialno);
        values.put(FormsTable.COLUMN_A01, fc.a01);
        values.put(FormsTable.COLUMN_A03D, fc.a03d);
        values.put(FormsTable.COLUMN_A03M, fc.a03m);
        values.put(FormsTable.COLUMN_A03Y, fc.a03y);
        values.put(FormsTable.COLUMN_A07, fc.a07);
        values.put(FormsTable.COLUMN_A08, fc.a08);
        values.put(FormsTable.COLUMN_A09, fc.a09);
        values.put(FormsTable.COLUMN_A10, fc.a10);
        values.put(FormsTable.COLUMN_A11, fc.a11);
        values.put(FormsTable.COLUMN_A12, fc.a12);
        values.put(FormsTable.COLUMN_A13, fc.a13);
        values.put(FormsTable.COLUMN_A14, fc.a14);
        values.put(FormsTable.COLUMN_A15, fc.a15);
        values.put(FormsTable.COLUMN_A16, fc.a16);
        values.put(FormsTable.COLUMN_A17, fc.a17);
        values.put(FormsTable.COLUMN_A18, fc.a18);
        values.put(FormsTable.COLUMN_A18XX, fc.a18xx);
        values.put(FormsTable.COLUMN_A19, fc.a19);
        values.put(FormsTable.COLUMN_A19XX, fc.a19xx);
        values.put(FormsTable.COLUMN_A20, fc.a20);
        values.put(FormsTable.COLUMN_A21, fc.a21);
        values.put(FormsTable.COLUMN_A22, fc.a22);
        values.put(FormsTable.COLUMN_B01, fc.b01);
        values.put(FormsTable.COLUMN_B02, fc.b02);
        values.put(FormsTable.COLUMN_B03, fc.b03);
        values.put(FormsTable.COLUMN_B04, fc.b04);
        values.put(FormsTable.COLUMN_B05, fc.b05);
        values.put(FormsTable.COLUMN_C01AA, fc.c01aa);
        values.put(FormsTable.COLUMN_C01AB, fc.c01ab);
        values.put(FormsTable.COLUMN_C01AC, fc.c01ac);
        values.put(FormsTable.COLUMN_C01AD, fc.c01ad);
        values.put(FormsTable.COLUMN_C01AE, fc.c01ae);
        values.put(FormsTable.COLUMN_C01BA, fc.c01ba);
        values.put(FormsTable.COLUMN_C01BB, fc.c01bb);
        values.put(FormsTable.COLUMN_C01BC, fc.c01bc);
        values.put(FormsTable.COLUMN_C01BD, fc.c01bd);
        values.put(FormsTable.COLUMN_C01BE, fc.c01be);
        values.put(FormsTable.COLUMN_C01CA, fc.c01ca);
        values.put(FormsTable.COLUMN_C01CB, fc.c01cb);
        values.put(FormsTable.COLUMN_C01CC, fc.c01cc);
        values.put(FormsTable.COLUMN_C01CD, fc.c01cd);
        values.put(FormsTable.COLUMN_C01CE, fc.c01ce);
        values.put(FormsTable.COLUMN_C01DA, fc.c01da);
        values.put(FormsTable.COLUMN_C01DB, fc.c01db);
        values.put(FormsTable.COLUMN_C01DC, fc.c01dc);
        values.put(FormsTable.COLUMN_C01DD, fc.c01dd);
        values.put(FormsTable.COLUMN_C01DE, fc.c01de);
        values.put(FormsTable.COLUMN_C01EA, fc.c01ea);
        values.put(FormsTable.COLUMN_C01EB, fc.c01eb);
        values.put(FormsTable.COLUMN_C01EC, fc.c01ec);
        values.put(FormsTable.COLUMN_C01ED, fc.c01ed);
        values.put(FormsTable.COLUMN_C01EE, fc.c01ee);
        values.put(FormsTable.COLUMN_C01FA, fc.c01fa);
        values.put(FormsTable.COLUMN_C01FB, fc.c01fb);
        values.put(FormsTable.COLUMN_C01FC, fc.c01fc);
        values.put(FormsTable.COLUMN_C01FD, fc.c01fd);
        values.put(FormsTable.COLUMN_C01FE, fc.c01fe);
        values.put(FormsTable.COLUMN_C01GA, fc.c01ga);
        values.put(FormsTable.COLUMN_C01GB, fc.c01gb);
        values.put(FormsTable.COLUMN_C01GC, fc.c01gc);
        values.put(FormsTable.COLUMN_C01GD, fc.c01gd);
        values.put(FormsTable.COLUMN_C01GE, fc.c01ge);
        values.put(FormsTable.COLUMN_C01HA, fc.c01ha);
        values.put(FormsTable.COLUMN_C01HB, fc.c01hb);
        values.put(FormsTable.COLUMN_C01HC, fc.c01hc);
        values.put(FormsTable.COLUMN_C01HD, fc.c01hd);
        values.put(FormsTable.COLUMN_C01HE, fc.c01he);
        values.put(FormsTable.COLUMN_C01IA, fc.c01ia);
        values.put(FormsTable.COLUMN_C01IB, fc.c01ib);
        values.put(FormsTable.COLUMN_C01IC, fc.c01ic);
        values.put(FormsTable.COLUMN_C01ID, fc.c01id);
        values.put(FormsTable.COLUMN_C01IE, fc.c01ie);
        values.put(FormsTable.COLUMN_C01JA, fc.c01ja);
        values.put(FormsTable.COLUMN_C01JB, fc.c01jb);
        values.put(FormsTable.COLUMN_C01JC, fc.c01jc);
        values.put(FormsTable.COLUMN_C01JD, fc.c01jd);
        values.put(FormsTable.COLUMN_C01JE, fc.c01je);
        values.put(FormsTable.COLUMN_C01KA, fc.c01ka);
        values.put(FormsTable.COLUMN_C01KB, fc.c01kb);
        values.put(FormsTable.COLUMN_C01KC, fc.c01kc);
        values.put(FormsTable.COLUMN_C01KD, fc.c01kd);
        values.put(FormsTable.COLUMN_C01KE, fc.c01ke);
        values.put(FormsTable.COLUMN_C021A, fc.c021a);
        values.put(FormsTable.COLUMN_C021B, fc.c021b);
        values.put(FormsTable.COLUMN_C021BFX, fc.c021bfx);
        values.put(FormsTable.COLUMN_C021C, fc.c021c);
        values.put(FormsTable.COLUMN_C021D, fc.c021d);
        values.put(FormsTable.COLUMN_C021DGX, fc.c021dgx);
        values.put(FormsTable.COLUMN_C021E, fc.c021e);
        values.put(FormsTable.COLUMN_D0101, fc.d0101);
        values.put(FormsTable.COLUMN_D0102, fc.d0102);
        values.put(FormsTable.COLUMN_D0201, fc.d0201);
        values.put(FormsTable.COLUMN_D0202, fc.d0202);
        values.put(FormsTable.COLUMN_D0203, fc.d0203);
        values.put(FormsTable.COLUMN_D0301, fc.d0301);
        values.put(FormsTable.COLUMN_D0302, fc.d0302);
        values.put(FormsTable.COLUMN_D0303, fc.d0303);
        values.put(FormsTable.COLUMN_D0304, fc.d0304);
        values.put(FormsTable.COLUMN_D0401, fc.d0401);
        values.put(FormsTable.COLUMN_D0402, fc.d0402);
        values.put(FormsTable.COLUMN_D0403, fc.d0403);
        values.put(FormsTable.COLUMN_D0404, fc.d0404);
        values.put(FormsTable.COLUMN_D0501, fc.d0501);
        values.put(FormsTable.COLUMN_D0502A0A, fc.d0502a0a);
        values.put(FormsTable.COLUMN_D0502A0AYX, fc.d0502a0ayx);
        values.put(FormsTable.COLUMN_D0502A0F, fc.d0502a0f);
        values.put(FormsTable.COLUMN_D0502A0FYX, fc.d0502a0fyx);
        values.put(FormsTable.COLUMN_D0502B0A, fc.d0502b0a);
        values.put(FormsTable.COLUMN_D0502B0AYX, fc.d0502b0ayx);
        values.put(FormsTable.COLUMN_D0502B0F, fc.d0502b0f);
        values.put(FormsTable.COLUMN_D0502B0FYX, fc.d0502b0fyx);
        values.put(FormsTable.COLUMN_D0502C0A, fc.d0502c0a);
        values.put(FormsTable.COLUMN_D0502C0AYX, fc.d0502c0ayx);
        values.put(FormsTable.COLUMN_D0502C0F, fc.d0502c0f);
        values.put(FormsTable.COLUMN_D0502C0FYX, fc.d0502c0fyx);
        values.put(FormsTable.COLUMN_D0502D0A, fc.d0502d0a);
        values.put(FormsTable.COLUMN_D0502D0AYX, fc.d0502d0ayx);
        values.put(FormsTable.COLUMN_D0502D0F, fc.d0502d0f);
        values.put(FormsTable.COLUMN_D0502D0FYX, fc.d0502d0fyx);
        values.put(FormsTable.COLUMN_D0503A, fc.d0503a);
        values.put(FormsTable.COLUMN_D0503B, fc.d0503b);
        values.put(FormsTable.COLUMN_D0503C, fc.d0503c);
        values.put(FormsTable.COLUMN_D0503D, fc.d0503d);
        values.put(FormsTable.COLUMN_D0503E, fc.d0503e);
        values.put(FormsTable.COLUMN_D0503F, fc.d0503f);
        values.put(FormsTable.COLUMN_D0503G, fc.d0503g);
        values.put(FormsTable.COLUMN_D0503H, fc.d0503h);
        values.put(FormsTable.COLUMN_D0601A, fc.d0601a);
        values.put(FormsTable.COLUMN_D0601B, fc.d0601b);
        values.put(FormsTable.COLUMN_D0601C, fc.d0601c);
        values.put(FormsTable.COLUMN_D0601D, fc.d0601d);
        values.put(FormsTable.COLUMN_D0602, fc.d0602);
        values.put(FormsTable.COLUMN_D0603, fc.d0603);
        values.put(FormsTable.COLUMN_D0604, fc.d0604);
        values.put(FormsTable.COLUMN_D0605, fc.d0605);
        values.put(FormsTable.COLUMN_D0701, fc.d0701);
        values.put(FormsTable.COLUMN_D0701XX, fc.d0701xx);
        values.put(FormsTable.COLUMN_D0702, fc.d0702);
        values.put(FormsTable.COLUMN_D0702XX, fc.d0702xx);
        values.put(FormsTable.COLUMN_D0703, fc.d0703);
        values.put(FormsTable.COLUMN_D0704A, fc.d0704a);
        values.put(FormsTable.COLUMN_D0704B, fc.d0704b);
        values.put(FormsTable.COLUMN_D0704C, fc.d0704c);
        values.put(FormsTable.COLUMN_D0704D, fc.d0704d);
        values.put(FormsTable.COLUMN_D0704E, fc.d0704e);
        values.put(FormsTable.COLUMN_D0801A0A, fc.d0801a0a);
        values.put(FormsTable.COLUMN_D0801A0FQ, fc.d0801a0fq);
        values.put(FormsTable.COLUMN_D0801B0A, fc.d0801b0a);
        values.put(FormsTable.COLUMN_D0801B0FQ, fc.d0801b0fq);
        values.put(FormsTable.COLUMN_D0801C0A, fc.d0801c0a);
        values.put(FormsTable.COLUMN_D0801C0FQ, fc.d0801c0fq);
        values.put(FormsTable.COLUMN_D0801D0A, fc.d0801d0a);
        values.put(FormsTable.COLUMN_D0801D0FQ, fc.d0801d0fq);
        values.put(FormsTable.COLUMN_D0801E0A, fc.d0801e0a);
        values.put(FormsTable.COLUMN_D0801E0FQ, fc.d0801e0fq);
        values.put(FormsTable.COLUMN_D0801F0A, fc.d0801f0a);
        values.put(FormsTable.COLUMN_D0801F0FQ, fc.d0801f0fq);
        values.put(FormsTable.COLUMN_D0801G0A, fc.d0801g0a);
        values.put(FormsTable.COLUMN_D0801G0FQ, fc.d0801g0fq);
        values.put(FormsTable.COLUMN_D0801H0A, fc.d0801h0a);
        values.put(FormsTable.COLUMN_D0801H0FQ, fc.d0801h0fq);
        values.put(FormsTable.COLUMN_D0801I0A, fc.d0801i0a);
        values.put(FormsTable.COLUMN_D0801I0FQ, fc.d0801i0fq);
        values.put(FormsTable.COLUMN_D0801J0A, fc.d0801j0a);
        values.put(FormsTable.COLUMN_D0801J0FQ, fc.d0801j0fq);
        values.put(FormsTable.COLUMN_E0101, fc.e0101);
        values.put(FormsTable.COLUMN_E0102A, fc.e0102a);
        values.put(FormsTable.COLUMN_E0102B, fc.e0102b);
        values.put(FormsTable.COLUMN_E0102C, fc.e0102c);
        values.put(FormsTable.COLUMN_E0102D, fc.e0102d);
        values.put(FormsTable.COLUMN_E0102E, fc.e0102e);
        values.put(FormsTable.COLUMN_E0102F, fc.e0102f);
        values.put(FormsTable.COLUMN_E0102G, fc.e0102g);
        values.put(FormsTable.COLUMN_E0102H, fc.e0102h);
        values.put(FormsTable.COLUMN_E0102I, fc.e0102i);
        values.put(FormsTable.COLUMN_E0102J, fc.e0102j);
        values.put(FormsTable.COLUMN_E0103A, fc.e0103a);
        values.put(FormsTable.COLUMN_E0103B, fc.e0103b);
        values.put(FormsTable.COLUMN_E0104A, fc.e0104a);
        values.put(FormsTable.COLUMN_E0104B, fc.e0104b);
        values.put(FormsTable.COLUMN_E0104C, fc.e0104c);
        values.put(FormsTable.COLUMN_E0104D, fc.e0104d);
        values.put(FormsTable.COLUMN_E0104E, fc.e0104e);
        values.put(FormsTable.COLUMN_E0104EXX, fc.e0104exx);
        values.put(FormsTable.COLUMN_E0201, fc.e0201);
        values.put(FormsTable.COLUMN_E0202A, fc.e0202a);
        values.put(FormsTable.COLUMN_E0202B, fc.e0202b);
        values.put(FormsTable.COLUMN_E0202C, fc.e0202c);
        values.put(FormsTable.COLUMN_E0202D, fc.e0202d);
        values.put(FormsTable.COLUMN_E0202E, fc.e0202e);
        values.put(FormsTable.COLUMN_E0202F, fc.e0202f);
        values.put(FormsTable.COLUMN_E0203A, fc.e0203a);
        values.put(FormsTable.COLUMN_E0203B, fc.e0203b);
        values.put(FormsTable.COLUMN_E0204A, fc.e0204a);
        values.put(FormsTable.COLUMN_E0204B, fc.e0204b);
        values.put(FormsTable.COLUMN_E0204C, fc.e0204c);
        values.put(FormsTable.COLUMN_E0204D, fc.e0204d);
        values.put(FormsTable.COLUMN_E0204DXX, fc.e0204dxx);
        values.put(FormsTable.COLUMN_E0301, fc.e0301);
        values.put(FormsTable.COLUMN_E0302A, fc.e0302a);
        values.put(FormsTable.COLUMN_E0302B, fc.e0302b);
        values.put(FormsTable.COLUMN_E0302C, fc.e0302c);
        values.put(FormsTable.COLUMN_E0302D, fc.e0302d);
        values.put(FormsTable.COLUMN_E0302E, fc.e0302e);
        values.put(FormsTable.COLUMN_E0303A, fc.e0303a);
        values.put(FormsTable.COLUMN_E0303B, fc.e0303b);
        values.put(FormsTable.COLUMN_E0303C, fc.e0303c);
        values.put(FormsTable.COLUMN_E0303D, fc.e0303d);
        values.put(FormsTable.COLUMN_E0303E, fc.e0303e);
        values.put(FormsTable.COLUMN_E0303F, fc.e0303f);
        values.put(FormsTable.COLUMN_E0303G, fc.e0303g);
        values.put(FormsTable.COLUMN_E0303H, fc.e0303h);
        values.put(FormsTable.COLUMN_E0303I, fc.e0303i);
        values.put(FormsTable.COLUMN_E0303J, fc.e0303j);
        values.put(FormsTable.COLUMN_E0303K, fc.e0303k);
        values.put(FormsTable.COLUMN_E0303L, fc.e0303l);
        values.put(FormsTable.COLUMN_E0303M, fc.e0303m);
        values.put(FormsTable.COLUMN_E0303N, fc.e0303n);
        values.put(FormsTable.COLUMN_E0304A, fc.e0304a);
        values.put(FormsTable.COLUMN_E0304B, fc.e0304b);
        values.put(FormsTable.COLUMN_E0304C, fc.e0304c);
        values.put(FormsTable.COLUMN_E0304D, fc.e0304d);
        values.put(FormsTable.COLUMN_E0305A, fc.e0305a);
        values.put(FormsTable.COLUMN_E0305B, fc.e0305b);
        values.put(FormsTable.COLUMN_E0305C, fc.e0305c);
        values.put(FormsTable.COLUMN_E0305D, fc.e0305d);
        values.put(FormsTable.COLUMN_E0305E, fc.e0305e);
        values.put(FormsTable.COLUMN_E0305EXX, fc.e0305exx);
        values.put(FormsTable.COLUMN_E0306A0A, fc.e0306a0a);
        values.put(FormsTable.COLUMN_E0306A0AYX, fc.e0306a0ayx);
        values.put(FormsTable.COLUMN_E0306A0F, fc.e0306a0f);
        values.put(FormsTable.COLUMN_E0306A0FYX, fc.e0306a0fyx);
        values.put(FormsTable.COLUMN_E0306B0A, fc.e0306b0a);
        values.put(FormsTable.COLUMN_E0306B0AYX, fc.e0306b0ayx);
        values.put(FormsTable.COLUMN_E0306B0F, fc.e0306b0f);
        values.put(FormsTable.COLUMN_E0306B0FYX, fc.e0306b0fyx);
        values.put(FormsTable.COLUMN_E0306C0A, fc.e0306c0a);
        values.put(FormsTable.COLUMN_E0306C0AYX, fc.e0306c0ayx);
        values.put(FormsTable.COLUMN_E0306C0F, fc.e0306c0f);
        values.put(FormsTable.COLUMN_E0306C0FYX, fc.e0306c0fyx);
        values.put(FormsTable.COLUMN_E0306D0A, fc.e0306d0a);
        values.put(FormsTable.COLUMN_E0306D0AYX, fc.e0306d0ayx);
        values.put(FormsTable.COLUMN_E0306D0F, fc.e0306d0f);
        values.put(FormsTable.COLUMN_E0306D0FYX, fc.e0306d0fyx);
        values.put(FormsTable.COLUMN_E0306E0A, fc.e0306e0a);
        values.put(FormsTable.COLUMN_E0306E0AYX, fc.e0306e0ayx);
        values.put(FormsTable.COLUMN_E0306E0F, fc.e0306e0f);
        values.put(FormsTable.COLUMN_E0306E0FYX, fc.e0306e0fyx);
        values.put(FormsTable.COLUMN_E0306F0A, fc.e0306f0a);
        values.put(FormsTable.COLUMN_E0306F0AYX, fc.e0306f0ayx);
        values.put(FormsTable.COLUMN_E0306F0F, fc.e0306f0f);
        values.put(FormsTable.COLUMN_E0306F0FYX, fc.e0306f0fyx);
        values.put(FormsTable.COLUMN_E0306G0A, fc.e0306g0a);
        values.put(FormsTable.COLUMN_E0306G0AYX, fc.e0306g0ayx);
        values.put(FormsTable.COLUMN_E0306G0F, fc.e0306g0f);
        values.put(FormsTable.COLUMN_E0306G0FYX, fc.e0306g0fyx);
        values.put(FormsTable.COLUMN_E0306H0A, fc.e0306h0a);
        values.put(FormsTable.COLUMN_E0306H0AYX, fc.e0306h0ayx);
        values.put(FormsTable.COLUMN_E0306H0F, fc.e0306h0f);
        values.put(FormsTable.COLUMN_E0306H0FYX, fc.e0306h0fyx);
        values.put(FormsTable.COLUMN_E0306I0A, fc.e0306i0a);
        values.put(FormsTable.COLUMN_E0306I0AYX, fc.e0306i0ayx);
        values.put(FormsTable.COLUMN_E0306I0F, fc.e0306i0f);
        values.put(FormsTable.COLUMN_E0306I0FYX, fc.e0306i0fyx);
        values.put(FormsTable.COLUMN_E0306J0A, fc.e0306j0a);
        values.put(FormsTable.COLUMN_E0306J0AYX, fc.e0306j0ayx);
        values.put(FormsTable.COLUMN_E0306J0F, fc.e0306j0f);
        values.put(FormsTable.COLUMN_E0306J0FYX, fc.e0306j0fyx);
        values.put(FormsTable.COLUMN_E0306K0A, fc.e0306k0a);
        values.put(FormsTable.COLUMN_E0306K0AYX, fc.e0306k0ayx);
        values.put(FormsTable.COLUMN_E0306K0F, fc.e0306k0f);
        values.put(FormsTable.COLUMN_E0306K0FYX, fc.e0306k0fyx);
        values.put(FormsTable.COLUMN_E0306L0A, fc.e0306l0a);
        values.put(FormsTable.COLUMN_E0306L0AYX, fc.e0306l0ayx);
        values.put(FormsTable.COLUMN_E0306L0F, fc.e0306l0f);
        values.put(FormsTable.COLUMN_E0306L0FYX, fc.e0306l0fyx);
        values.put(FormsTable.COLUMN_E0306M0A, fc.e0306m0a);
        values.put(FormsTable.COLUMN_E0306M0AYX, fc.e0306m0ayx);
        values.put(FormsTable.COLUMN_E0306M0F, fc.e0306m0f);
        values.put(FormsTable.COLUMN_E0306M0FYX, fc.e0306m0fyx);
        values.put(FormsTable.COLUMN_E0306N0A, fc.e0306n0a);
        values.put(FormsTable.COLUMN_E0306N0AYX, fc.e0306n0ayx);
        values.put(FormsTable.COLUMN_E0306N0F, fc.e0306n0f);
        values.put(FormsTable.COLUMN_E0306N0FYX, fc.e0306n0fyx);
        values.put(FormsTable.COLUMN_E0306O0A, fc.e0306o0a);
        values.put(FormsTable.COLUMN_E0306O0AYX, fc.e0306o0ayx);
        values.put(FormsTable.COLUMN_E0306O0F, fc.e0306o0f);
        values.put(FormsTable.COLUMN_E0306O0FYX, fc.e0306o0fyx);
        values.put(FormsTable.COLUMN_E0306P0A, fc.e0306p0a);
        values.put(FormsTable.COLUMN_E0306P0AYX, fc.e0306p0ayx);
        values.put(FormsTable.COLUMN_E0306P0F, fc.e0306p0f);
        values.put(FormsTable.COLUMN_E0306P0FYX, fc.e0306p0fyx);
        values.put(FormsTable.COLUMN_E0306Q0A, fc.e0306q0a);
        values.put(FormsTable.COLUMN_E0306Q0AYX, fc.e0306q0ayx);
        values.put(FormsTable.COLUMN_E0306Q0F, fc.e0306q0f);
        values.put(FormsTable.COLUMN_E0306Q0FYX, fc.e0306q0fyx);
        values.put(FormsTable.COLUMN_E0306R0A, fc.e0306r0a);
        values.put(FormsTable.COLUMN_E0306R0AYX, fc.e0306r0ayx);
        values.put(FormsTable.COLUMN_E0306R0F, fc.e0306r0f);
        values.put(FormsTable.COLUMN_E0306R0FYX, fc.e0306r0fyx);
        values.put(FormsTable.COLUMN_E0307, fc.e0307);
        values.put(FormsTable.COLUMN_E0308, fc.e0308);
        values.put(FormsTable.COLUMN_E0401, fc.e0401);
        values.put(FormsTable.COLUMN_E0402, fc.e0402);
        values.put(FormsTable.COLUMN_E0403A, fc.e0403a);
        values.put(FormsTable.COLUMN_E0403B, fc.e0403b);
        values.put(FormsTable.COLUMN_E0403C, fc.e0403c);
        values.put(FormsTable.COLUMN_E0404, fc.e0404);
        values.put(FormsTable.COLUMN_E0405, fc.e0405);
        values.put(FormsTable.COLUMN_E0406, fc.e0406);
        values.put(FormsTable.COLUMN_E0407A, fc.e0407a);
        values.put(FormsTable.COLUMN_E0407B, fc.e0407b);
        values.put(FormsTable.COLUMN_E0407C, fc.e0407c);
        values.put(FormsTable.COLUMN_E0407D, fc.e0407d);
        values.put(FormsTable.COLUMN_E0408, fc.e0408);
        values.put(FormsTable.COLUMN_E0409, fc.e0409);
        values.put(FormsTable.COLUMN_E0410A, fc.e0410a);
        values.put(FormsTable.COLUMN_E0410B, fc.e0410b);
        values.put(FormsTable.COLUMN_E0410C, fc.e0410c);
        values.put(FormsTable.COLUMN_E0410D, fc.e0410d);
        values.put(FormsTable.COLUMN_E0410E, fc.e0410e);
        values.put(FormsTable.COLUMN_E0410F, fc.e0410f);
        values.put(FormsTable.COLUMN_E0411, fc.e0411);
        values.put(FormsTable.COLUMN_E0412, fc.e0412);
        values.put(FormsTable.COLUMN_E0413, fc.e0413);
        values.put(FormsTable.COLUMN_E0414, fc.e0414);
        values.put(FormsTable.COLUMN_E0415, fc.e0415);
        values.put(FormsTable.COLUMN_E0416, fc.e0416);
        values.put(FormsTable.COLUMN_E0501, fc.e0501);
        values.put(FormsTable.COLUMN_E0502A, fc.e0502a);
        values.put(FormsTable.COLUMN_E0502B, fc.e0502b);
        values.put(FormsTable.COLUMN_E0502C, fc.e0502c);
        values.put(FormsTable.COLUMN_E0502D, fc.e0502d);
        values.put(FormsTable.COLUMN_E0502E, fc.e0502e);
        values.put(FormsTable.COLUMN_E0502F, fc.e0502f);
        values.put(FormsTable.COLUMN_E0502G, fc.e0502g);
        values.put(FormsTable.COLUMN_E0502H, fc.e0502h);
        values.put(FormsTable.COLUMN_E0502I, fc.e0502i);
        values.put(FormsTable.COLUMN_E0503, fc.e0503);
        values.put(FormsTable.COLUMN_E0504, fc.e0504);
        values.put(FormsTable.COLUMN_E0505, fc.e0505);
        values.put(FormsTable.COLUMN_E0506, fc.e0506);
        values.put(FormsTable.COLUMN_E0507, fc.e0507);
        values.put(FormsTable.COLUMN_E0508, fc.e0508);
        values.put(FormsTable.COLUMN_E0509, fc.e0509);
        values.put(FormsTable.COLUMN_E0601, fc.e0601);
        values.put(FormsTable.COLUMN_E0602, fc.e0602);
        values.put(FormsTable.COLUMN_E0603, fc.e0603);
        values.put(FormsTable.COLUMN_E0604, fc.e0604);
        values.put(FormsTable.COLUMN_E0605A, fc.e0605a);
        values.put(FormsTable.COLUMN_E0605B, fc.e0605b);
        values.put(FormsTable.COLUMN_E0605C, fc.e0605c);
        values.put(FormsTable.COLUMN_E0605D, fc.e0605d);
        values.put(FormsTable.COLUMN_E0606, fc.e0606);
        values.put(FormsTable.COLUMN_E0607, fc.e0607);
        values.put(FormsTable.COLUMN_E0608, fc.e0608);
        values.put(FormsTable.COLUMN_E0609, fc.e0609);
        values.put(FormsTable.COLUMN_E0610, fc.e0610);
        values.put(FormsTable.COLUMN_E0611, fc.e0611);
        values.put(FormsTable.COLUMN_E0701, fc.e0701);
        values.put(FormsTable.COLUMN_E0702A, fc.e0702a);
        values.put(FormsTable.COLUMN_E0702B, fc.e0702b);
        values.put(FormsTable.COLUMN_E0702C, fc.e0702c);
        values.put(FormsTable.COLUMN_E0702D, fc.e0702d);
        values.put(FormsTable.COLUMN_E0702E, fc.e0702e);
        values.put(FormsTable.COLUMN_E0702F, fc.e0702f);
        values.put(FormsTable.COLUMN_E0702G, fc.e0702g);
        values.put(FormsTable.COLUMN_E0702H, fc.e0702h);
        values.put(FormsTable.COLUMN_E0702I, fc.e0702i);
        values.put(FormsTable.COLUMN_E0702J, fc.e0702j);
        values.put(FormsTable.COLUMN_E0702K, fc.e0702k);
        values.put(FormsTable.COLUMN_E0702L, fc.e0702l);
        values.put(FormsTable.COLUMN_E0703A, fc.e0703a);
        values.put(FormsTable.COLUMN_E0703B, fc.e0703b);
        values.put(FormsTable.COLUMN_E0703C, fc.e0703c);
        values.put(FormsTable.COLUMN_E0703D, fc.e0703d);
        values.put(FormsTable.COLUMN_E0704A, fc.e0704a);
        values.put(FormsTable.COLUMN_E0704B, fc.e0704b);
        values.put(FormsTable.COLUMN_E0704C, fc.e0704c);
        values.put(FormsTable.COLUMN_E0704D, fc.e0704d);
        values.put(FormsTable.COLUMN_E0704E, fc.e0704e);
        values.put(FormsTable.COLUMN_E0704F, fc.e0704f);
        values.put(FormsTable.COLUMN_E0704G, fc.e0704g);
        values.put(FormsTable.COLUMN_E0704GXX, fc.e0704gxx);
        values.put(FormsTable.COLUMN_E0705A0A, fc.e0705a0a);
        values.put(FormsTable.COLUMN_E0705A0AYX, fc.e0705a0ayx);
        values.put(FormsTable.COLUMN_E0705A0F, fc.e0705a0f);
        values.put(FormsTable.COLUMN_E0705A0FYX, fc.e0705a0fyx);
        values.put(FormsTable.COLUMN_E0705B0A, fc.e0705b0a);
        values.put(FormsTable.COLUMN_E0705B0AYX, fc.e0705b0ayx);
        values.put(FormsTable.COLUMN_E0705B0F, fc.e0705b0f);
        values.put(FormsTable.COLUMN_E0705B0FYX, fc.e0705b0fyx);
        values.put(FormsTable.COLUMN_E0705C0A, fc.e0705c0a);
        values.put(FormsTable.COLUMN_E0705C0AYX, fc.e0705c0ayx);
        values.put(FormsTable.COLUMN_E0705C0F, fc.e0705c0f);
        values.put(FormsTable.COLUMN_E0705C0FYX, fc.e0705c0fyx);
        values.put(FormsTable.COLUMN_E0705D0A, fc.e0705d0a);
        values.put(FormsTable.COLUMN_E0705D0AYX, fc.e0705d0ayx);
        values.put(FormsTable.COLUMN_E0705D0F, fc.e0705d0f);
        values.put(FormsTable.COLUMN_E0705D0FYX, fc.e0705d0fyx);
        values.put(FormsTable.COLUMN_E0705E0A, fc.e0705e0a);
        values.put(FormsTable.COLUMN_E0705E0AYX, fc.e0705e0ayx);
        values.put(FormsTable.COLUMN_E0705E0F, fc.e0705e0f);
        values.put(FormsTable.COLUMN_E0705E0FYX, fc.e0705e0fyx);
        values.put(FormsTable.COLUMN_E0801, fc.e0801);
        values.put(FormsTable.COLUMN_E0802, fc.e0802);
        values.put(FormsTable.COLUMN_E0803, fc.e0803);
        values.put(FormsTable.COLUMN_E0804, fc.e0804);
        values.put(FormsTable.COLUMN_E0805, fc.e0805);
        values.put(FormsTable.COLUMN_E0806, fc.e0806);
        values.put(FormsTable.COLUMN_E0807, fc.e0807);
        values.put(FormsTable.COLUMN_E0808, fc.e0808);
        values.put(FormsTable.COLUMN_E0809, fc.e0809);
        values.put(FormsTable.COLUMN_E0810, fc.e0810);
        values.put(FormsTable.COLUMN_E0811, fc.e0811);
        values.put(FormsTable.COLUMN_E0812, fc.e0812);
        values.put(FormsTable.COLUMN_E0813, fc.e0813);
        values.put(FormsTable.COLUMN_E0814, fc.e0814);
        values.put(FormsTable.COLUMN_F0100, fc.f0100);
        values.put(FormsTable.COLUMN_F01001, fc.f01001);
        values.put(FormsTable.COLUMN_F0101AA0A, fc.f0101aa0a);
        values.put(FormsTable.COLUMN_F0101AA0AYX, fc.f0101aa0ayx);
        values.put(FormsTable.COLUMN_F0101AA0F, fc.f0101aa0f);
        values.put(FormsTable.COLUMN_F0101AA0FYX, fc.f0101aa0fyx);
        values.put(FormsTable.COLUMN_F0101AB0A, fc.f0101ab0a);
        values.put(FormsTable.COLUMN_F0101AB0AYX, fc.f0101ab0ayx);
        values.put(FormsTable.COLUMN_F0101AB0F, fc.f0101ab0f);
        values.put(FormsTable.COLUMN_F0101AB0FYX, fc.f0101ab0fyx);
        values.put(FormsTable.COLUMN_F0102, fc.f0102);
        values.put(FormsTable.COLUMN_F0103, fc.f0103);
        values.put(FormsTable.COLUMN_F0104, fc.f0104);
        values.put(FormsTable.COLUMN_F0105, fc.f0105);
        values.put(FormsTable.COLUMN_F0105AAA0A, fc.f0105aaa0a);
        values.put(FormsTable.COLUMN_F0105AAA0AYX, fc.f0105aaa0ayx);
        values.put(FormsTable.COLUMN_F0105AAA0F, fc.f0105aaa0f);
        values.put(FormsTable.COLUMN_F0105AAA0FYX, fc.f0105aaa0fyx);
        values.put(FormsTable.COLUMN_F0105AAB0A, fc.f0105aab0a);
        values.put(FormsTable.COLUMN_F0105AAB0AYX, fc.f0105aab0ayx);
        values.put(FormsTable.COLUMN_F0105AAB0F, fc.f0105aab0f);
        values.put(FormsTable.COLUMN_F0105AAB0FYX, fc.f0105aab0fyx);
        values.put(FormsTable.COLUMN_F0105AAC0A, fc.f0105aac0a);
        values.put(FormsTable.COLUMN_F0105AAC0AYX, fc.f0105aac0ayx);
        values.put(FormsTable.COLUMN_F0105AAC0F, fc.f0105aac0f);
        values.put(FormsTable.COLUMN_F0105AAC0FYX, fc.f0105aac0fyx);
        values.put(FormsTable.COLUMN_F0106, fc.f0106);
        values.put(FormsTable.COLUMN_F0106AAA0A, fc.f0106aaa0a);
        values.put(FormsTable.COLUMN_F0106AAA0AYX, fc.f0106aaa0ayx);
        values.put(FormsTable.COLUMN_F0106AAA0F, fc.f0106aaa0f);
        values.put(FormsTable.COLUMN_F0106AAA0FYX, fc.f0106aaa0fyx);
        values.put(FormsTable.COLUMN_F0107, fc.f0107);
        values.put(FormsTable.COLUMN_F0108, fc.f0108);
        values.put(FormsTable.COLUMN_F0109, fc.f0109);
        values.put(FormsTable.COLUMN_F0110, fc.f0110);
        values.put(FormsTable.COLUMN_F0110AAA0A, fc.f0110aaa0a);
        values.put(FormsTable.COLUMN_F0110AAA0AYX, fc.f0110aaa0ayx);
        values.put(FormsTable.COLUMN_F0110AAA0F, fc.f0110aaa0f);
        values.put(FormsTable.COLUMN_F0110AAA0FYX, fc.f0110aaa0fyx);
        values.put(FormsTable.COLUMN_F0110AAB0A, fc.f0110aab0a);
        values.put(FormsTable.COLUMN_F0110AAB0AYX, fc.f0110aab0ayx);
        values.put(FormsTable.COLUMN_F0110AAB0F, fc.f0110aab0f);
        values.put(FormsTable.COLUMN_F0110AAB0FYX, fc.f0110aab0fyx);
        values.put(FormsTable.COLUMN_F0110AAC0A, fc.f0110aac0a);
        values.put(FormsTable.COLUMN_F0110AAC0AYX, fc.f0110aac0ayx);
        values.put(FormsTable.COLUMN_F0110AAC0F, fc.f0110aac0f);
        values.put(FormsTable.COLUMN_F0110AAC0FYX, fc.f0110aac0fyx);
        values.put(FormsTable.COLUMN_F0110AAD0A, fc.f0110aad0a);
        values.put(FormsTable.COLUMN_F0110AAD0AYX, fc.f0110aad0ayx);
        values.put(FormsTable.COLUMN_F0110AAD0F, fc.f0110aad0f);
        values.put(FormsTable.COLUMN_F0110AAD0FYX, fc.f0110aad0fyx);
        values.put(FormsTable.COLUMN_F0110AAE0A, fc.f0110aae0a);
        values.put(FormsTable.COLUMN_F0110AAE0AYX, fc.f0110aae0ayx);
        values.put(FormsTable.COLUMN_F0110AAE0F, fc.f0110aae0f);
        values.put(FormsTable.COLUMN_F0110AAE0FYX, fc.f0110aae0fyx);
        values.put(FormsTable.COLUMN_F0201, fc.f0201);
        values.put(FormsTable.COLUMN_F0201AAA0A, fc.f0201aaa0a);
        values.put(FormsTable.COLUMN_F0201AAA0AYX, fc.f0201aaa0ayx);
        values.put(FormsTable.COLUMN_F0201AAA0F, fc.f0201aaa0f);
        values.put(FormsTable.COLUMN_F0201AAA0FYX, fc.f0201aaa0fyx);
        values.put(FormsTable.COLUMN_F0201AAB0A, fc.f0201aab0a);
        values.put(FormsTable.COLUMN_F0201AAB0AYX, fc.f0201aab0ayx);
        values.put(FormsTable.COLUMN_F0201AAB0F, fc.f0201aab0f);
        values.put(FormsTable.COLUMN_F0201AAB0FYX, fc.f0201aab0fyx);
        values.put(FormsTable.COLUMN_F0202, fc.f0202);
        values.put(FormsTable.COLUMN_F0202AAA0A, fc.f0202aaa0a);
        values.put(FormsTable.COLUMN_F0202AAA0AYX, fc.f0202aaa0ayx);
        values.put(FormsTable.COLUMN_F0202AAA0F, fc.f0202aaa0f);
        values.put(FormsTable.COLUMN_F0202AAA0FYX, fc.f0202aaa0fyx);
        values.put(FormsTable.COLUMN_F0202AAB0A, fc.f0202aab0a);
        values.put(FormsTable.COLUMN_F0202AAB0AYX, fc.f0202aab0ayx);
        values.put(FormsTable.COLUMN_F0202AAB0F, fc.f0202aab0f);
        values.put(FormsTable.COLUMN_F0202AAB0FYX, fc.f0202aab0fyx);
        values.put(FormsTable.COLUMN_F0203, fc.f0203);
        values.put(FormsTable.COLUMN_F0203AAA0A, fc.f0203aaa0a);
        values.put(FormsTable.COLUMN_F0203AAA0AYX, fc.f0203aaa0ayx);
        values.put(FormsTable.COLUMN_F0203AAA0F, fc.f0203aaa0f);
        values.put(FormsTable.COLUMN_F0203AAA0FYX, fc.f0203aaa0fyx);
        values.put(FormsTable.COLUMN_F0203AAB0A, fc.f0203aab0a);
        values.put(FormsTable.COLUMN_F0203AAB0AYX, fc.f0203aab0ayx);
        values.put(FormsTable.COLUMN_F0203AAB0F, fc.f0203aab0f);
        values.put(FormsTable.COLUMN_F0203AAB0FYX, fc.f0203aab0fyx);
        values.put(FormsTable.COLUMN_F0301, fc.f0301);
        values.put(FormsTable.COLUMN_F0301AAA0A, fc.f0301aaa0a);
        values.put(FormsTable.COLUMN_F0301AAA0AYX, fc.f0301aaa0ayx);
        values.put(FormsTable.COLUMN_F0301AAA0F, fc.f0301aaa0f);
        values.put(FormsTable.COLUMN_F0301AAA0FYX, fc.f0301aaa0fyx);
        values.put(FormsTable.COLUMN_F0302, fc.f0302);
        values.put(FormsTable.COLUMN_F0302AAA0A, fc.f0302aaa0a);
        values.put(FormsTable.COLUMN_F0302AAA0AYX, fc.f0302aaa0ayx);
        values.put(FormsTable.COLUMN_F0302AAA0F, fc.f0302aaa0f);
        values.put(FormsTable.COLUMN_F0302AAA0FYX, fc.f0302aaa0fyx);
        values.put(FormsTable.COLUMN_F0401, fc.f0401);
        values.put(FormsTable.COLUMN_F0401AAA0A, fc.f0401aaa0a);
        values.put(FormsTable.COLUMN_F0401AAA0AYX, fc.f0401aaa0ayx);
        values.put(FormsTable.COLUMN_F0401AAA0F, fc.f0401aaa0f);
        values.put(FormsTable.COLUMN_F0401AAA0FYX, fc.f0401aaa0fyx);
        values.put(FormsTable.COLUMN_F0401AAB0A, fc.f0401aab0a);
        values.put(FormsTable.COLUMN_F0401AAB0AYX, fc.f0401aab0ayx);
        values.put(FormsTable.COLUMN_F0401AAB0F, fc.f0401aab0f);
        values.put(FormsTable.COLUMN_F0401AAB0FYX, fc.f0401aab0fyx);
        values.put(FormsTable.COLUMN_F0401AAC0A, fc.f0401aac0a);
        values.put(FormsTable.COLUMN_F0401AAC0AYX, fc.f0401aac0ayx);
        values.put(FormsTable.COLUMN_F0401AAC0F, fc.f0401aac0f);
        values.put(FormsTable.COLUMN_F0401AAC0FYX, fc.f0401aac0fyx);
        values.put(FormsTable.COLUMN_F0402, fc.f0402);
        values.put(FormsTable.COLUMN_F0402AAA0A, fc.f0402aaa0a);
        values.put(FormsTable.COLUMN_F0402AAA0AYX, fc.f0402aaa0ayx);
        values.put(FormsTable.COLUMN_F0402AAA0F, fc.f0402aaa0f);
        values.put(FormsTable.COLUMN_F0402AAA0FYX, fc.f0402aaa0fyx);
        values.put(FormsTable.COLUMN_F0403, fc.f0403);
        values.put(FormsTable.COLUMN_F0403AAA0A, fc.f0403aaa0a);
        values.put(FormsTable.COLUMN_F0403AAA0AYX, fc.f0403aaa0ayx);
        values.put(FormsTable.COLUMN_F0403AAA0F, fc.f0403aaa0f);
        values.put(FormsTable.COLUMN_F0403AAA0FYX, fc.f0403aaa0fyx);
        values.put(FormsTable.COLUMN_F0404, fc.f0404);
        values.put(FormsTable.COLUMN_F0404AAA0A, fc.f0404aaa0a);
        values.put(FormsTable.COLUMN_F0404AAA0AYX, fc.f0404aaa0ayx);
        values.put(FormsTable.COLUMN_F0404AAA0F, fc.f0404aaa0f);
        values.put(FormsTable.COLUMN_F0404AAA0FYX, fc.f0404aaa0fyx);
        values.put(FormsTable.COLUMN_G0101, fc.g0101);
        values.put(FormsTable.COLUMN_G0101XX, fc.g0101xx);
        values.put(FormsTable.COLUMN_G0102A, fc.g0102a);
        values.put(FormsTable.COLUMN_G0102B, fc.g0102b);
        values.put(FormsTable.COLUMN_G0103, fc.g0103);
        values.put(FormsTable.COLUMN_G0103XX, fc.g0103xx);
        values.put(FormsTable.COLUMN_G0104, fc.g0104);
        values.put(FormsTable.COLUMN_G0105AX, fc.g0105ax);
        values.put(FormsTable.COLUMN_G0105BX, fc.g0105bx);
        values.put(FormsTable.COLUMN_G0105CX, fc.g0105cx);
        values.put(FormsTable.COLUMN_G0106, fc.g0106);
        values.put(FormsTable.COLUMN_G0106XX, fc.g0106xx);
        values.put(FormsTable.COLUMN_G0107, fc.g0107);
        values.put(FormsTable.COLUMN_G0107XX, fc.g0107xx);
        values.put(FormsTable.COLUMN_G0108A, fc.g0108a);
        values.put(FormsTable.COLUMN_G0108B, fc.g0108b);
        values.put(FormsTable.COLUMN_G0108C, fc.g0108c);
        values.put(FormsTable.COLUMN_G0109, fc.g0109);
        values.put(FormsTable.COLUMN_G0110AX, fc.g0110ax);
        values.put(FormsTable.COLUMN_G0110BX, fc.g0110bx);
        values.put(FormsTable.COLUMN_G0110CX, fc.g0110cx);
        values.put(FormsTable.COLUMN_G0111, fc.g0111);
        values.put(FormsTable.COLUMN_G01112, fc.g01112);
        values.put(FormsTable.COLUMN_G01112XX, fc.g01112xx);
        values.put(FormsTable.COLUMN_G01113, fc.g01113);
        values.put(FormsTable.COLUMN_G01114, fc.g01114);
        values.put(FormsTable.COLUMN_G01115, fc.g01115);
        values.put(FormsTable.COLUMN_G01116, fc.g01116);
        values.put(FormsTable.COLUMN_G01117, fc.g01117);
        values.put(FormsTable.COLUMN_G0201, fc.g0201);
        values.put(FormsTable.COLUMN_G0202, fc.g0202);
        values.put(FormsTable.COLUMN_G0203, fc.g0203);
        values.put(FormsTable.COLUMN_G0203X, fc.g0203x);
        values.put(FormsTable.COLUMN_G0204, fc.g0204);
        values.put(FormsTable.COLUMN_G0205, fc.g0205);
        values.put(FormsTable.COLUMN_G0206, fc.g0206);
        values.put(FormsTable.COLUMN_G0207, fc.g0207);
        values.put(FormsTable.COLUMN_G0208, fc.g0208);
        values.put(FormsTable.COLUMN_G0301AA, fc.g0301aa);
        values.put(FormsTable.COLUMN_G0301AB, fc.g0301ab);
        values.put(FormsTable.COLUMN_G0301BA, fc.g0301ba);
        values.put(FormsTable.COLUMN_G0301BB, fc.g0301bb);
        values.put(FormsTable.COLUMN_G0301CA, fc.g0301ca);
        values.put(FormsTable.COLUMN_G0301CB, fc.g0301cb);
        values.put(FormsTable.COLUMN_G0302A10R, fc.g0302a10r);
        values.put(FormsTable.COLUMN_G0302A10I, fc.g0302a10i);
        values.put(FormsTable.COLUMN_G0302A10D, fc.g0302a10d);
        values.put(FormsTable.COLUMN_G0302A10B, fc.g0302a10b);
        values.put(FormsTable.COLUMN_G0302A20R, fc.g0302a20r);
        values.put(FormsTable.COLUMN_G0302A20I, fc.g0302a20i);
        values.put(FormsTable.COLUMN_G0302A20D, fc.g0302a20d);
        values.put(FormsTable.COLUMN_G0302A20B, fc.g0302a20b);
        values.put(FormsTable.COLUMN_G0302A30R, fc.g0302a30r);
        values.put(FormsTable.COLUMN_G0302A30I, fc.g0302a30i);
        values.put(FormsTable.COLUMN_G0302A30D, fc.g0302a30d);
        values.put(FormsTable.COLUMN_G0302A30B, fc.g0302a30b);
        values.put(FormsTable.COLUMN_G0302A40R, fc.g0302a40r);
        values.put(FormsTable.COLUMN_G0302A40I, fc.g0302a40i);
        values.put(FormsTable.COLUMN_G0302A40D, fc.g0302a40d);
        values.put(FormsTable.COLUMN_G0302A40B, fc.g0302a40b);
        values.put(FormsTable.COLUMN_G0302A50R, fc.g0302a50r);
        values.put(FormsTable.COLUMN_G0302A50I, fc.g0302a50i);
        values.put(FormsTable.COLUMN_G0302A50D, fc.g0302a50d);
        values.put(FormsTable.COLUMN_G0302A50B, fc.g0302a50b);
        values.put(FormsTable.COLUMN_G0302A60R, fc.g0302a60r);
        values.put(FormsTable.COLUMN_G0302A60I, fc.g0302a60i);
        values.put(FormsTable.COLUMN_G0302A60D, fc.g0302a60d);
        values.put(FormsTable.COLUMN_G0302A60B, fc.g0302a60b);
        values.put(FormsTable.COLUMN_G0302A70R, fc.g0302a70r);
        values.put(FormsTable.COLUMN_G0302A70I, fc.g0302a70i);
        values.put(FormsTable.COLUMN_G0302A70D, fc.g0302a70d);
        values.put(FormsTable.COLUMN_G0302A70B, fc.g0302a70b);
        values.put(FormsTable.COLUMN_G0302B10R, fc.g0302b10r);
        values.put(FormsTable.COLUMN_G0302B10I, fc.g0302b10i);
        values.put(FormsTable.COLUMN_G0302B10D, fc.g0302b10d);
        values.put(FormsTable.COLUMN_G0302B10B, fc.g0302b10b);
        values.put(FormsTable.COLUMN_G0302B20R, fc.g0302b20r);
        values.put(FormsTable.COLUMN_G0302B20I, fc.g0302b20i);
        values.put(FormsTable.COLUMN_G0302B20D, fc.g0302b20d);
        values.put(FormsTable.COLUMN_G0302B20B, fc.g0302b20b);
        values.put(FormsTable.COLUMN_G0302B30R, fc.g0302b30r);
        values.put(FormsTable.COLUMN_G0302B30I, fc.g0302b30i);
        values.put(FormsTable.COLUMN_G0302B30D, fc.g0302b30d);
        values.put(FormsTable.COLUMN_G0302B30B, fc.g0302b30b);
        values.put(FormsTable.COLUMN_G0302B40R, fc.g0302b40r);
        values.put(FormsTable.COLUMN_G0302B40I, fc.g0302b40i);
        values.put(FormsTable.COLUMN_G0302B40D, fc.g0302b40d);
        values.put(FormsTable.COLUMN_G0302B40B, fc.g0302b40b);
        values.put(FormsTable.COLUMN_G0302B50R, fc.g0302b50r);
        values.put(FormsTable.COLUMN_G0302B50I, fc.g0302b50i);
        values.put(FormsTable.COLUMN_G0302B50D, fc.g0302b50d);
        values.put(FormsTable.COLUMN_G0302B50B, fc.g0302b50b);
        values.put(FormsTable.COLUMN_G0302B60R, fc.g0302b60r);
        values.put(FormsTable.COLUMN_G0302B60I, fc.g0302b60i);
        values.put(FormsTable.COLUMN_G0302B60D, fc.g0302b60d);
        values.put(FormsTable.COLUMN_G0302B60B, fc.g0302b60b);
        values.put(FormsTable.COLUMN_G0302B70R, fc.g0302b70r);
        values.put(FormsTable.COLUMN_G0302B70I, fc.g0302b70i);
        values.put(FormsTable.COLUMN_G0302B70D, fc.g0302b70d);
        values.put(FormsTable.COLUMN_G0302B70B, fc.g0302b70b);
        values.put(FormsTable.COLUMN_G0302C10R, fc.g0302c10r);
        values.put(FormsTable.COLUMN_G0302C10I, fc.g0302c10i);
        values.put(FormsTable.COLUMN_G0302C10D, fc.g0302c10d);
        values.put(FormsTable.COLUMN_G0302C10B, fc.g0302c10b);
        values.put(FormsTable.COLUMN_G0302C20R, fc.g0302c20r);
        values.put(FormsTable.COLUMN_G0302C20I, fc.g0302c20i);
        values.put(FormsTable.COLUMN_G0302C20D, fc.g0302c20d);
        values.put(FormsTable.COLUMN_G0302C20B, fc.g0302c20b);
        values.put(FormsTable.COLUMN_G0302C30R, fc.g0302c30r);
        values.put(FormsTable.COLUMN_G0302C30I, fc.g0302c30i);
        values.put(FormsTable.COLUMN_G0302C30D, fc.g0302c30d);
        values.put(FormsTable.COLUMN_G0302C30B, fc.g0302c30b);
        values.put(FormsTable.COLUMN_G0302C40R, fc.g0302c40r);
        values.put(FormsTable.COLUMN_G0302C40I, fc.g0302c40i);
        values.put(FormsTable.COLUMN_G0302C40D, fc.g0302c40d);
        values.put(FormsTable.COLUMN_G0302C40B, fc.g0302c40b);
        values.put(FormsTable.COLUMN_G0302C50R, fc.g0302c50r);
        values.put(FormsTable.COLUMN_G0302C50I, fc.g0302c50i);
        values.put(FormsTable.COLUMN_G0302C50D, fc.g0302c50d);
        values.put(FormsTable.COLUMN_G0302C50B, fc.g0302c50b);
        values.put(FormsTable.COLUMN_G0302C60R, fc.g0302c60r);
        values.put(FormsTable.COLUMN_G0302C60I, fc.g0302c60i);
        values.put(FormsTable.COLUMN_G0302C60D, fc.g0302c60d);
        values.put(FormsTable.COLUMN_G0302C60B, fc.g0302c60b);
        values.put(FormsTable.COLUMN_G0302C70R, fc.g0302c70r);
        values.put(FormsTable.COLUMN_G0302C70I, fc.g0302c70i);
        values.put(FormsTable.COLUMN_G0302C70D, fc.g0302c70d);
        values.put(FormsTable.COLUMN_G0302C70B, fc.g0302c70b);
        values.put(FormsTable.COLUMN_G040110A, fc.g040110a);
        values.put(FormsTable.COLUMN_G040110S, fc.g040110s);
        values.put(FormsTable.COLUMN_G040110SD, fc.g040110sd);
        values.put(FormsTable.COLUMN_G040110SM, fc.g040110sm);
        values.put(FormsTable.COLUMN_G040110P, fc.g040110p);
        values.put(FormsTable.COLUMN_G040120A, fc.g040120a);
        values.put(FormsTable.COLUMN_G040120S, fc.g040120s);
        values.put(FormsTable.COLUMN_G040120SM, fc.g040120sm);
        values.put(FormsTable.COLUMN_G040120SD, fc.g040120sd);
        values.put(FormsTable.COLUMN_G040120P, fc.g040120p);
        values.put(FormsTable.COLUMN_G04013, fc.g04013);
        values.put(FormsTable.COLUMN_G04010A, fc.g04010a);
        values.put(FormsTable.COLUMN_G04010S, fc.g04010s);
        values.put(FormsTable.COLUMN_G04010SD, fc.g04010sd);
        values.put(FormsTable.COLUMN_G04010SM, fc.g04010sm);
        values.put(FormsTable.COLUMN_G04010P, fc.g04010p);
        values.put(FormsTable.COLUMN_G040150A, fc.g040150a);
        values.put(FormsTable.COLUMN_G040150S, fc.g040150s);
        values.put(FormsTable.COLUMN_G040150SD, fc.g040150sd);
        values.put(FormsTable.COLUMN_G040150SM, fc.g040150sm);
        values.put(FormsTable.COLUMN_G040150P, fc.g040150p);
        values.put(FormsTable.COLUMN_G040160A, fc.g040160a);
        values.put(FormsTable.COLUMN_G040160S, fc.g040160s);
        values.put(FormsTable.COLUMN_G040160SD, fc.g040160sd);
        values.put(FormsTable.COLUMN_G040160SM, fc.g040160sm);
        values.put(FormsTable.COLUMN_G040160P, fc.g040160p);
        values.put(FormsTable.COLUMN_G040170A, fc.g040170a);
        values.put(FormsTable.COLUMN_G040170S, fc.g040170s);
        values.put(FormsTable.COLUMN_G040170SD, fc.g040170sd);
        values.put(FormsTable.COLUMN_G040170SM, fc.g040170sm);
        values.put(FormsTable.COLUMN_G040170P, fc.g040170p);
        values.put(FormsTable.COLUMN_G040180A, fc.g040180a);
        values.put(FormsTable.COLUMN_G040180S, fc.g040180s);
        values.put(FormsTable.COLUMN_G040180SD, fc.g040180sd);
        values.put(FormsTable.COLUMN_G040180SM, fc.g040180sm);
        values.put(FormsTable.COLUMN_G040180P, fc.g040180p);
        values.put(FormsTable.COLUMN_G040190A, fc.g040190a);
        values.put(FormsTable.COLUMN_G040190S, fc.g040190s);
        values.put(FormsTable.COLUMN_G040190SD, fc.g040190sd);
        values.put(FormsTable.COLUMN_G040190SM, fc.g040190sm);
        values.put(FormsTable.COLUMN_G040190P, fc.g040190p);
        values.put(FormsTable.COLUMN_G0401100A, fc.g0401100a);
        values.put(FormsTable.COLUMN_G0401100S, fc.g0401100s);
        values.put(FormsTable.COLUMN_G0401100SD, fc.g0401100sd);
        values.put(FormsTable.COLUMN_G0401100SM, fc.g0401100sm);
        values.put(FormsTable.COLUMN_G0401100P, fc.g0401100p);
        values.put(FormsTable.COLUMN_G0401110A, fc.g0401110a);
        values.put(FormsTable.COLUMN_G0401110S, fc.g0401110s);
        values.put(FormsTable.COLUMN_G0401110SD, fc.g0401110sd);
        values.put(FormsTable.COLUMN_G0401110SM, fc.g0401110sm);
        values.put(FormsTable.COLUMN_G0401110P, fc.g0401110p);
        values.put(FormsTable.COLUMN_G0401120A, fc.g0401120a);
        values.put(FormsTable.COLUMN_G0401120S, fc.g0401120s);
        values.put(FormsTable.COLUMN_G0401120SD, fc.g0401120sd);
        values.put(FormsTable.COLUMN_G0401120SM, fc.g0401120sm);
        values.put(FormsTable.COLUMN_G0401120P, fc.g0401120p);
        values.put(FormsTable.COLUMN_G0401130A, fc.g0401130a);
        values.put(FormsTable.COLUMN_G0401130S, fc.g0401130s);
        values.put(FormsTable.COLUMN_G0401130SD, fc.g0401130sd);
        values.put(FormsTable.COLUMN_G0401130SM, fc.g0401130sm);
        values.put(FormsTable.COLUMN_G0401130P, fc.g0401130p);
        values.put(FormsTable.COLUMN_G0401140A, fc.g0401140a);
        values.put(FormsTable.COLUMN_G0401140S, fc.g0401140s);
        values.put(FormsTable.COLUMN_G0401140SD, fc.g0401140sd);
        values.put(FormsTable.COLUMN_G0401140SM, fc.g0401140sm);
        values.put(FormsTable.COLUMN_G0401140P, fc.g0401140p);
        values.put(FormsTable.COLUMN_G0401150A, fc.g0401150a);
        values.put(FormsTable.COLUMN_G0401150S, fc.g0401150s);
        values.put(FormsTable.COLUMN_G0401150SD, fc.g0401150sd);
        values.put(FormsTable.COLUMN_G0401150SM, fc.g0401150sm);
        values.put(FormsTable.COLUMN_G0401150P, fc.g0401150p);
        values.put(FormsTable.COLUMN_G0401160A, fc.g0401160a);
        values.put(FormsTable.COLUMN_G0401160S, fc.g0401160s);
        values.put(FormsTable.COLUMN_G0401160SD, fc.g0401160sd);
        values.put(FormsTable.COLUMN_G0401160SM, fc.g0401160sm);
        values.put(FormsTable.COLUMN_G0401160P, fc.g0401160p);
        values.put(FormsTable.COLUMN_G0401170A, fc.g0401170a);
        values.put(FormsTable.COLUMN_G0401170S, fc.g0401170s);
        values.put(FormsTable.COLUMN_G0401170SD, fc.g0401170sd);
        values.put(FormsTable.COLUMN_G0401170SM, fc.g0401170sm);
        values.put(FormsTable.COLUMN_G0401170P, fc.g0401170p);
        values.put(FormsTable.COLUMN_G0401180A, fc.g0401180a);
        values.put(FormsTable.COLUMN_G0401180S, fc.g0401180s);
        values.put(FormsTable.COLUMN_G0401180SD, fc.g0401180sd);
        values.put(FormsTable.COLUMN_G0401180SM, fc.g0401180sm);
        values.put(FormsTable.COLUMN_G0401180P, fc.g0401180p);
        values.put(FormsTable.COLUMN_G0401190A, fc.g0401190a);
        values.put(FormsTable.COLUMN_G0401190S, fc.g0401190s);
        values.put(FormsTable.COLUMN_G0401190SD, fc.g0401190sd);
        values.put(FormsTable.COLUMN_G0401190SM, fc.g0401190sm);
        values.put(FormsTable.COLUMN_G0401190P, fc.g0401190p);
        values.put(FormsTable.COLUMN_G0401200A, fc.g0401200a);
        values.put(FormsTable.COLUMN_G0401200S, fc.g0401200s);
        values.put(FormsTable.COLUMN_G0401200SD, fc.g0401200sd);
        values.put(FormsTable.COLUMN_G0401200SM, fc.g0401200sm);
        values.put(FormsTable.COLUMN_G0401200P, fc.g0401200p);
        values.put(FormsTable.COLUMN_G0401210A, fc.g0401210a);
        values.put(FormsTable.COLUMN_G0401210S, fc.g0401210s);
        values.put(FormsTable.COLUMN_G0401210SD, fc.g0401210sd);
        values.put(FormsTable.COLUMN_G0401210SM, fc.g0401210sm);
        values.put(FormsTable.COLUMN_G0401210P, fc.g0401210p);
        values.put(FormsTable.COLUMN_G0401220A, fc.g0401220a);
        values.put(FormsTable.COLUMN_G0401220S, fc.g0401220s);
        values.put(FormsTable.COLUMN_G0401220SD, fc.g0401220sd);
        values.put(FormsTable.COLUMN_G0401220SM, fc.g0401220sm);
        values.put(FormsTable.COLUMN_G0401220P, fc.g0401220p);
        values.put(FormsTable.COLUMN_G0401230A, fc.g0401230a);
        values.put(FormsTable.COLUMN_G0401230S, fc.g0401230s);
        values.put(FormsTable.COLUMN_G0401230SD, fc.g0401230sd);
        values.put(FormsTable.COLUMN_G0401230SM, fc.g0401230sm);
        values.put(FormsTable.COLUMN_G0401230P, fc.g0401230p);
        values.put(FormsTable.COLUMN_G0401240A, fc.g0401240a);
        values.put(FormsTable.COLUMN_G0401240S, fc.g0401240s);
        values.put(FormsTable.COLUMN_G0401240SD, fc.g0401240sd);
        values.put(FormsTable.COLUMN_G0401240SM, fc.g0401240sm);
        values.put(FormsTable.COLUMN_G0401240P, fc.g0401240p);
        values.put(FormsTable.COLUMN_G0401250A, fc.g0401250a);
        values.put(FormsTable.COLUMN_G0401250S, fc.g0401250s);
        values.put(FormsTable.COLUMN_G0401250SD, fc.g0401250sd);
        values.put(FormsTable.COLUMN_G0401250SM, fc.g0401250sm);
        values.put(FormsTable.COLUMN_G0401250P, fc.g0401250p);
        values.put(FormsTable.COLUMN_G0401260A, fc.g0401260a);
        values.put(FormsTable.COLUMN_G0401260S, fc.g0401260s);
        values.put(FormsTable.COLUMN_G0401260SD, fc.g0401260sd);
        values.put(FormsTable.COLUMN_G0401260SM, fc.g0401260sm);
        values.put(FormsTable.COLUMN_G0401260P, fc.g0401260p);
        values.put(FormsTable.COLUMN_G0401270A, fc.g0401270a);
        values.put(FormsTable.COLUMN_G0401270S, fc.g0401270s);
        values.put(FormsTable.COLUMN_G0401270SD, fc.g0401270sd);
        values.put(FormsTable.COLUMN_G0401270SM, fc.g0401270sm);
        values.put(FormsTable.COLUMN_G0401270P, fc.g0401270p);
        values.put(FormsTable.COLUMN_G0401280A, fc.g0401280a);
        values.put(FormsTable.COLUMN_G0401280S, fc.g0401280s);
        values.put(FormsTable.COLUMN_G0401280SD, fc.g0401280sd);
        values.put(FormsTable.COLUMN_G0401280SM, fc.g0401280sm);
        values.put(FormsTable.COLUMN_G0401280P, fc.g0401280p);
        values.put(FormsTable.COLUMN_G0401290A, fc.g0401290a);
        values.put(FormsTable.COLUMN_G0401290S, fc.g0401290s);
        values.put(FormsTable.COLUMN_G0401290SD, fc.g0401290sd);
        values.put(FormsTable.COLUMN_G0401290SM, fc.g0401290sm);
        values.put(FormsTable.COLUMN_G0401290P, fc.g0401290p);
        values.put(FormsTable.COLUMN_G0401300A, fc.g0401300a);
        values.put(FormsTable.COLUMN_G0401300S, fc.g0401300s);
        values.put(FormsTable.COLUMN_G0401300SD, fc.g0401300sd);
        values.put(FormsTable.COLUMN_G0401300SM, fc.g0401300sm);
        values.put(FormsTable.COLUMN_G0401300P, fc.g0401300p);
        values.put(FormsTable.COLUMN_G0401310A, fc.g0401310a);
        values.put(FormsTable.COLUMN_G0401310S, fc.g0401310s);
        values.put(FormsTable.COLUMN_G0401310SD, fc.g0401310sd);
        values.put(FormsTable.COLUMN_G0401310SM, fc.g0401310sm);
        values.put(FormsTable.COLUMN_G0401310P, fc.g0401310p);
        values.put(FormsTable.COLUMN_G0401320A, fc.g0401320a);
        values.put(FormsTable.COLUMN_G0401320S, fc.g0401320s);
        values.put(FormsTable.COLUMN_G0401320SD, fc.g0401320sd);
        values.put(FormsTable.COLUMN_G0401320SM, fc.g0401320sm);
        values.put(FormsTable.COLUMN_G0401320P, fc.g0401320p);
        values.put(FormsTable.COLUMN_G0401330A, fc.g0401330a);
        values.put(FormsTable.COLUMN_G0401330S, fc.g0401330s);
        values.put(FormsTable.COLUMN_G0401330SD, fc.g0401330sd);
        values.put(FormsTable.COLUMN_G0401330SM, fc.g0401330sm);
        values.put(FormsTable.COLUMN_G0401330P, fc.g0401330p);
        values.put(FormsTable.COLUMN_G0401340A, fc.g0401340a);
        values.put(FormsTable.COLUMN_G0401340S, fc.g0401340s);
        values.put(FormsTable.COLUMN_G0401340SD, fc.g0401340sd);
        values.put(FormsTable.COLUMN_G0401340SM, fc.g0401340sm);
        values.put(FormsTable.COLUMN_G0401340P, fc.g0401340p);
        values.put(FormsTable.COLUMN_G0401350A, fc.g0401350a);
        values.put(FormsTable.COLUMN_G0401350S, fc.g0401350s);
        values.put(FormsTable.COLUMN_G0401350SD, fc.g0401350sd);
        values.put(FormsTable.COLUMN_G0401350SM, fc.g0401350sm);
        values.put(FormsTable.COLUMN_G0401350P, fc.g0401350p);
        values.put(FormsTable.COLUMN_G0401360A, fc.g0401360a);
        values.put(FormsTable.COLUMN_G0401360S, fc.g0401360s);
        values.put(FormsTable.COLUMN_G0401360SD, fc.g0401360sd);
        values.put(FormsTable.COLUMN_G0401360SM, fc.g0401360sm);
        values.put(FormsTable.COLUMN_G0401360P, fc.g0401360p);
        values.put(FormsTable.COLUMN_G0401370A, fc.g0401370a);
        values.put(FormsTable.COLUMN_G0401370S, fc.g0401370s);
        values.put(FormsTable.COLUMN_G0401370SD, fc.g0401370sd);
        values.put(FormsTable.COLUMN_G0401370SM, fc.g0401370sm);
        values.put(FormsTable.COLUMN_G0401370P, fc.g0401370p);
        values.put(FormsTable.COLUMN_G0401380A, fc.g0401380a);
        values.put(FormsTable.COLUMN_G0401380S, fc.g0401380s);
        values.put(FormsTable.COLUMN_G0401380SD, fc.g0401380sd);
        values.put(FormsTable.COLUMN_G0401380SM, fc.g0401380sm);
        values.put(FormsTable.COLUMN_G0401380P, fc.g0401380p);
        values.put(FormsTable.COLUMN_G0401390A, fc.g0401390a);
        values.put(FormsTable.COLUMN_G0401390S, fc.g0401390s);
        values.put(FormsTable.COLUMN_G0401390SD, fc.g0401390sd);
        values.put(FormsTable.COLUMN_G0401390SM, fc.g0401390sm);
        values.put(FormsTable.COLUMN_G0401390P, fc.g0401390p);
        values.put(FormsTable.COLUMN_G0401400A, fc.g0401400a);
        values.put(FormsTable.COLUMN_G0401400S, fc.g0401400s);
        values.put(FormsTable.COLUMN_G0401400SD, fc.g0401400sd);
        values.put(FormsTable.COLUMN_G0401400SM, fc.g0401400sm);
        values.put(FormsTable.COLUMN_G0401400P, fc.g0401400p);
        values.put(FormsTable.COLUMN_G0401410A, fc.g0401410a);
        values.put(FormsTable.COLUMN_G0401410S, fc.g0401410s);
        values.put(FormsTable.COLUMN_G0401410SD, fc.g0401410sd);
        values.put(FormsTable.COLUMN_G0401410SM, fc.g0401410sm);
        values.put(FormsTable.COLUMN_G0401410P, fc.g0401410p);
        values.put(FormsTable.COLUMN_G0401420A, fc.g0401420a);
        values.put(FormsTable.COLUMN_G0401420S, fc.g0401420s);
        values.put(FormsTable.COLUMN_G0401420SD, fc.g0401420sd);
        values.put(FormsTable.COLUMN_G0401420SM, fc.g0401420sm);
        values.put(FormsTable.COLUMN_G0401420P, fc.g0401420p);
        values.put(FormsTable.COLUMN_G0401430A, fc.g0401430a);
        values.put(FormsTable.COLUMN_G0401430S, fc.g0401430s);
        values.put(FormsTable.COLUMN_G0401430SD, fc.g0401430sd);
        values.put(FormsTable.COLUMN_G0401430SM, fc.g0401430sm);
        values.put(FormsTable.COLUMN_G0401430P, fc.g0401430p);
        values.put(FormsTable.COLUMN_G0401440A, fc.g0401440a);
        values.put(FormsTable.COLUMN_G0401440S, fc.g0401440s);
        values.put(FormsTable.COLUMN_G0401440SD, fc.g0401440sd);
        values.put(FormsTable.COLUMN_G0401440SM, fc.g0401440sm);
        values.put(FormsTable.COLUMN_G0401440P, fc.g0401440p);
        values.put(FormsTable.COLUMN_G040210A, fc.g040210a);
        values.put(FormsTable.COLUMN_G040210S, fc.g040210s);
        values.put(FormsTable.COLUMN_G040210SD, fc.g040210sd);
        values.put(FormsTable.COLUMN_G040210SM, fc.g040210sm);
        values.put(FormsTable.COLUMN_G040210P, fc.g040210p);
        values.put(FormsTable.COLUMN_G040220A, fc.g040220a);
        values.put(FormsTable.COLUMN_G040220S, fc.g040220s);
        values.put(FormsTable.COLUMN_G040220SD, fc.g040220sd);
        values.put(FormsTable.COLUMN_G040220SM, fc.g040220sm);
        values.put(FormsTable.COLUMN_G040220P, fc.g040220p);
        values.put(FormsTable.COLUMN_G040230A, fc.g040230a);
        values.put(FormsTable.COLUMN_G040230S, fc.g040230s);
        values.put(FormsTable.COLUMN_G040230SD, fc.g040230sd);
        values.put(FormsTable.COLUMN_G040230SM, fc.g040230sm);
        values.put(FormsTable.COLUMN_G040230P, fc.g040230p);
        values.put(FormsTable.COLUMN_G040240A, fc.g040240a);
        values.put(FormsTable.COLUMN_G040240S, fc.g040240s);
        values.put(FormsTable.COLUMN_G040240SD, fc.g040240sd);
        values.put(FormsTable.COLUMN_G040240SM, fc.g040240sm);
        values.put(FormsTable.COLUMN_G040240P, fc.g040240p);
        values.put(FormsTable.COLUMN_G040250A, fc.g040250a);
        values.put(FormsTable.COLUMN_G040250S, fc.g040250s);
        values.put(FormsTable.COLUMN_G040250SD, fc.g040250sd);
        values.put(FormsTable.COLUMN_G040250SM, fc.g040250sm);
        values.put(FormsTable.COLUMN_G040250P, fc.g040250p);
        values.put(FormsTable.COLUMN_G040260A, fc.g040260a);
        values.put(FormsTable.COLUMN_G040260S, fc.g040260s);
        values.put(FormsTable.COLUMN_G040260SD, fc.g040260sd);
        values.put(FormsTable.COLUMN_G040260SM, fc.g040260sm);
        values.put(FormsTable.COLUMN_G040260P, fc.g040260p);
        values.put(FormsTable.COLUMN_G040270A, fc.g040270a);
        values.put(FormsTable.COLUMN_G040270S, fc.g040270s);
        values.put(FormsTable.COLUMN_G040270SD, fc.g040270sd);
        values.put(FormsTable.COLUMN_G040270SM, fc.g040270sm);
        values.put(FormsTable.COLUMN_G040270P, fc.g040270p);
        values.put(FormsTable.COLUMN_G040280A, fc.g040280a);
        values.put(FormsTable.COLUMN_G040280S, fc.g040280s);
        values.put(FormsTable.COLUMN_G040280SD, fc.g040280sd);
        values.put(FormsTable.COLUMN_G040280SM, fc.g040280sm);
        values.put(FormsTable.COLUMN_G040280P, fc.g040280p);
        values.put(FormsTable.COLUMN_G040290A, fc.g040290a);
        values.put(FormsTable.COLUMN_G040290S, fc.g040290s);
        values.put(FormsTable.COLUMN_G040290SD, fc.g040290sd);
        values.put(FormsTable.COLUMN_G040290SM, fc.g040290sm);
        values.put(FormsTable.COLUMN_G040290P, fc.g040290p);
        values.put(FormsTable.COLUMN_G0402100A, fc.g0402100a);
        values.put(FormsTable.COLUMN_G0402100S, fc.g0402100s);
        values.put(FormsTable.COLUMN_G0402100SD, fc.g0402100sd);
        values.put(FormsTable.COLUMN_G0402100SM, fc.g0402100sm);
        values.put(FormsTable.COLUMN_G0402100P, fc.g0402100p);
        values.put(FormsTable.COLUMN_G040310A, fc.g040310a);
        values.put(FormsTable.COLUMN_G040310S, fc.g040310s);
        values.put(FormsTable.COLUMN_G040310SD, fc.g040310sd);
        values.put(FormsTable.COLUMN_G040310SM, fc.g040310sm);
        values.put(FormsTable.COLUMN_G040310P, fc.g040310p);
        values.put(FormsTable.COLUMN_G040320A, fc.g040320a);
        values.put(FormsTable.COLUMN_G040320S, fc.g040320s);
        values.put(FormsTable.COLUMN_G040320SD, fc.g040320sd);
        values.put(FormsTable.COLUMN_G040320SM, fc.g040320sm);
        values.put(FormsTable.COLUMN_G040320P, fc.g040320p);
        values.put(FormsTable.COLUMN_G040330A, fc.g040330a);
        values.put(FormsTable.COLUMN_G040330S, fc.g040330s);
        values.put(FormsTable.COLUMN_G040330SD, fc.g040330sd);
        values.put(FormsTable.COLUMN_G040330SM, fc.g040330sm);
        values.put(FormsTable.COLUMN_G040330P, fc.g040330p);
        values.put(FormsTable.COLUMN_G040340A, fc.g040340a);
        values.put(FormsTable.COLUMN_G040340S, fc.g040340s);
        values.put(FormsTable.COLUMN_G040340SD, fc.g040340sd);
        values.put(FormsTable.COLUMN_G040340SM, fc.g040340sm);
        values.put(FormsTable.COLUMN_G040340P, fc.g040340p);
        values.put(FormsTable.COLUMN_G040350A, fc.g040350a);
        values.put(FormsTable.COLUMN_G040350S, fc.g040350s);
        values.put(FormsTable.COLUMN_G040350SD, fc.g040350sd);
        values.put(FormsTable.COLUMN_G040350SM, fc.g040350sm);
        values.put(FormsTable.COLUMN_G040350P, fc.g040350p);
        values.put(FormsTable.COLUMN_G040360A, fc.g040360a);
        values.put(FormsTable.COLUMN_G040360S, fc.g040360s);
        values.put(FormsTable.COLUMN_G040360SD, fc.g040360sd);
        values.put(FormsTable.COLUMN_G040360SM, fc.g040360sm);
        values.put(FormsTable.COLUMN_G040360P, fc.g040360p);
        values.put(FormsTable.COLUMN_G040370A, fc.g040370a);
        values.put(FormsTable.COLUMN_G040370S, fc.g040370s);
        values.put(FormsTable.COLUMN_G040370SD, fc.g040370sd);
        values.put(FormsTable.COLUMN_G040370SM, fc.g040370sm);
        values.put(FormsTable.COLUMN_G040370P, fc.g040370p);
        values.put(FormsTable.COLUMN_G040380A, fc.g040380a);
        values.put(FormsTable.COLUMN_G040380S, fc.g040380s);
        values.put(FormsTable.COLUMN_G040380SD, fc.g040380sd);
        values.put(FormsTable.COLUMN_G040380SM, fc.g040380sm);
        values.put(FormsTable.COLUMN_G040380P, fc.g040380p);
        values.put(FormsTable.COLUMN_G040390A, fc.g040390a);
        values.put(FormsTable.COLUMN_G040390S, fc.g040390s);
        values.put(FormsTable.COLUMN_G040390SD, fc.g040390sd);
        values.put(FormsTable.COLUMN_G040390SM, fc.g040390sm);
        values.put(FormsTable.COLUMN_G040390P, fc.g040390p);
        values.put(FormsTable.COLUMN_G0403100A, fc.g0403100a);
        values.put(FormsTable.COLUMN_G0403100S, fc.g0403100s);
        values.put(FormsTable.COLUMN_G0403100SD, fc.g0403100sd);
        values.put(FormsTable.COLUMN_G0403100SM, fc.g0403100sm);
        values.put(FormsTable.COLUMN_G0403100P, fc.g0403100p);
        values.put(FormsTable.COLUMN_G0403110A, fc.g0403110a);
        values.put(FormsTable.COLUMN_G0403110S, fc.g0403110s);
        values.put(FormsTable.COLUMN_G0403110SD, fc.g0403110sd);
        values.put(FormsTable.COLUMN_G0403110SM, fc.g0403110sm);
        values.put(FormsTable.COLUMN_G0403110P, fc.g0403110p);
        values.put(FormsTable.COLUMN_G0403120A, fc.g0403120a);
        values.put(FormsTable.COLUMN_G0403120S, fc.g0403120s);
        values.put(FormsTable.COLUMN_G0403120SD, fc.g0403120sd);
        values.put(FormsTable.COLUMN_G0403120SM, fc.g0403120sm);
        values.put(FormsTable.COLUMN_G0403120P, fc.g0403120p);
        values.put(FormsTable.COLUMN_G0403130A, fc.g0403130a);
        values.put(FormsTable.COLUMN_G0403130S, fc.g0403130s);
        values.put(FormsTable.COLUMN_G0403130SD, fc.g0403130sd);
        values.put(FormsTable.COLUMN_G0403130SM, fc.g0403130sm);
        values.put(FormsTable.COLUMN_G0403130P, fc.g0403130p);
        values.put(FormsTable.COLUMN_G0403140A, fc.g0403140a);
        values.put(FormsTable.COLUMN_G0403140S, fc.g0403140s);
        values.put(FormsTable.COLUMN_G0403140SD, fc.g0403140sd);
        values.put(FormsTable.COLUMN_G0403140SM, fc.g0403140sm);
        values.put(FormsTable.COLUMN_G0403140P, fc.g0403140p);
        values.put(FormsTable.COLUMN_G0403150A, fc.g0403150a);
        values.put(FormsTable.COLUMN_G0403150S, fc.g0403150s);
        values.put(FormsTable.COLUMN_G0403150SD, fc.g0403150sd);
        values.put(FormsTable.COLUMN_G0403150SM, fc.g0403150sm);
        values.put(FormsTable.COLUMN_G0403150P, fc.g0403150p);
        values.put(FormsTable.COLUMN_G0403160A, fc.g0403160a);
        values.put(FormsTable.COLUMN_G0403160S, fc.g0403160s);
        values.put(FormsTable.COLUMN_G0403160SD, fc.g0403160sd);
        values.put(FormsTable.COLUMN_G0403160SM, fc.g0403160sm);
        values.put(FormsTable.COLUMN_G0403160P, fc.g0403160p);
        values.put(FormsTable.COLUMN_G0403170A, fc.g0403170a);
        values.put(FormsTable.COLUMN_G0403170S, fc.g0403170s);
        values.put(FormsTable.COLUMN_G0403170SD, fc.g0403170sd);
        values.put(FormsTable.COLUMN_G0403170SM, fc.g0403170sm);
        values.put(FormsTable.COLUMN_G0403170P, fc.g0403170p);
        values.put(FormsTable.COLUMN_G0403180A, fc.g0403180a);
        values.put(FormsTable.COLUMN_G0403180S, fc.g0403180s);
        values.put(FormsTable.COLUMN_G0403180SD, fc.g0403180sd);
        values.put(FormsTable.COLUMN_G0403180SM, fc.g0403180sm);
        values.put(FormsTable.COLUMN_G0403180P, fc.g0403180p);
        values.put(FormsTable.COLUMN_G0403190A, fc.g0403190a);
        values.put(FormsTable.COLUMN_G0403190S, fc.g0403190s);
        values.put(FormsTable.COLUMN_G0403190SD, fc.g0403190sd);
        values.put(FormsTable.COLUMN_G0403190SM, fc.g0403190sm);
        values.put(FormsTable.COLUMN_G0403190P, fc.g0403190p);
        values.put(FormsTable.COLUMN_G0403200A, fc.g0403200a);
        values.put(FormsTable.COLUMN_G0403200S, fc.g0403200s);
        values.put(FormsTable.COLUMN_G0403200SD, fc.g0403200sd);
        values.put(FormsTable.COLUMN_G0403200SM, fc.g0403200sm);
        values.put(FormsTable.COLUMN_G0403200P, fc.g0403200p);
        values.put(FormsTable.COLUMN_G0403210A, fc.g0403210a);
        values.put(FormsTable.COLUMN_G0403210S, fc.g0403210s);
        values.put(FormsTable.COLUMN_G0403210SD, fc.g0403210sd);
        values.put(FormsTable.COLUMN_G0403210SM, fc.g0403210sm);
        values.put(FormsTable.COLUMN_G0403210P, fc.g0403210p);
        values.put(FormsTable.COLUMN_G0403220A, fc.g0403220a);
        values.put(FormsTable.COLUMN_G0403220S, fc.g0403220s);
        values.put(FormsTable.COLUMN_G0403220SD, fc.g0403220sd);
        values.put(FormsTable.COLUMN_G0403220SM, fc.g0403220sm);
        values.put(FormsTable.COLUMN_G0403220P, fc.g0403220p);
        values.put(FormsTable.COLUMN_G0403230A, fc.g0403230a);
        values.put(FormsTable.COLUMN_G0403230S, fc.g0403230s);
        values.put(FormsTable.COLUMN_G0403230SD, fc.g0403230sd);
        values.put(FormsTable.COLUMN_G0403230SM, fc.g0403230sm);
        values.put(FormsTable.COLUMN_G0403230P, fc.g0403230p);
        values.put(FormsTable.COLUMN_G0403240A, fc.g0403240a);
        values.put(FormsTable.COLUMN_G0403240S, fc.g0403240s);
        values.put(FormsTable.COLUMN_G0403240SD, fc.g0403240sd);
        values.put(FormsTable.COLUMN_G0403240SM, fc.g0403240sm);
        values.put(FormsTable.COLUMN_G0403240P, fc.g0403240p);
        values.put(FormsTable.COLUMN_G0403250A, fc.g0403250a);
        values.put(FormsTable.COLUMN_G0403250S, fc.g0403250s);
        values.put(FormsTable.COLUMN_G0403250SD, fc.g0403250sd);
        values.put(FormsTable.COLUMN_G0403250SM, fc.g0403250sm);
        values.put(FormsTable.COLUMN_G0403250P, fc.g0403250p);
        values.put(FormsTable.COLUMN_G0403260A, fc.g0403260a);
        values.put(FormsTable.COLUMN_G0403260S, fc.g0403260s);
        values.put(FormsTable.COLUMN_G0403260SD, fc.g0403260sd);
        values.put(FormsTable.COLUMN_G0403260SM, fc.g0403260sm);
        values.put(FormsTable.COLUMN_G0403260P, fc.g0403260p);
        values.put(FormsTable.COLUMN_G0403270A, fc.g0403270a);
        values.put(FormsTable.COLUMN_G0403270S, fc.g0403270s);
        values.put(FormsTable.COLUMN_G0403270SD, fc.g0403270sd);
        values.put(FormsTable.COLUMN_G0403270SM, fc.g0403270sm);
        values.put(FormsTable.COLUMN_G0403270P, fc.g0403270p);
        values.put(FormsTable.COLUMN_G040410A, fc.g040410a);
        values.put(FormsTable.COLUMN_G040410S, fc.g040410s);
        values.put(FormsTable.COLUMN_G040410SD, fc.g040410sd);
        values.put(FormsTable.COLUMN_G040410SM, fc.g040410sm);
        values.put(FormsTable.COLUMN_G040410P, fc.g040410p);
        values.put(FormsTable.COLUMN_G040420A, fc.g040420a);
        values.put(FormsTable.COLUMN_G040420S, fc.g040420s);
        values.put(FormsTable.COLUMN_G040420SD, fc.g040420sd);
        values.put(FormsTable.COLUMN_G040420SM, fc.g040420sm);
        values.put(FormsTable.COLUMN_G040420P, fc.g040420p);
        values.put(FormsTable.COLUMN_G040430A, fc.g040430a);
        values.put(FormsTable.COLUMN_G040430S, fc.g040430s);
        values.put(FormsTable.COLUMN_G040430SD, fc.g040430sd);
        values.put(FormsTable.COLUMN_G040430SM, fc.g040430sm);
        values.put(FormsTable.COLUMN_G040430P, fc.g040430p);
        values.put(FormsTable.COLUMN_G040440A, fc.g040440a);
        values.put(FormsTable.COLUMN_G040440S, fc.g040440s);
        values.put(FormsTable.COLUMN_G040440SD, fc.g040440sd);
        values.put(FormsTable.COLUMN_G040440SM, fc.g040440sm);
        values.put(FormsTable.COLUMN_G040440P, fc.g040440p);
        values.put(FormsTable.COLUMN_G040450A, fc.g040450a);
        values.put(FormsTable.COLUMN_G040450S, fc.g040450s);
        values.put(FormsTable.COLUMN_G040450SD, fc.g040450sd);
        values.put(FormsTable.COLUMN_G040450SM, fc.g040450sm);
        values.put(FormsTable.COLUMN_G040450P, fc.g040450p);
        values.put(FormsTable.COLUMN_G040460A, fc.g040460a);
        values.put(FormsTable.COLUMN_G040460S, fc.g040460s);
        values.put(FormsTable.COLUMN_G040460SD, fc.g040460sd);
        values.put(FormsTable.COLUMN_G040460SM, fc.g040460sm);
        values.put(FormsTable.COLUMN_G040460P, fc.g040460p);
        values.put(FormsTable.COLUMN_H0201, fc.h0201);
        values.put(FormsTable.COLUMN_H0202, fc.h0202);
        values.put(FormsTable.COLUMN_H0203A, fc.h0203a);
        values.put(FormsTable.COLUMN_H0203B, fc.h0203b);
        values.put(FormsTable.COLUMN_H0301A0A, fc.h0301a0a);
        values.put(FormsTable.COLUMN_H0301A0B, fc.h0301a0b);
        values.put(FormsTable.COLUMN_H0301A0C, fc.h0301a0c);
        values.put(FormsTable.COLUMN_H0301B0A, fc.h0301b0a);
        values.put(FormsTable.COLUMN_H0301B0B, fc.h0301b0b);
        values.put(FormsTable.COLUMN_H0301B0C, fc.h0301b0c);
        values.put(FormsTable.COLUMN_H0301C0A, fc.h0301c0a);
        values.put(FormsTable.COLUMN_H0301C0B, fc.h0301c0b);
        values.put(FormsTable.COLUMN_H0301C0C, fc.h0301c0c);
        values.put(FormsTable.COLUMN_H0301D0A, fc.h0301d0a);
        values.put(FormsTable.COLUMN_H0301D0B, fc.h0301d0b);
        values.put(FormsTable.COLUMN_H0301D0C, fc.h0301d0c);
        values.put(FormsTable.COLUMN_H0301E0A, fc.h0301e0a);
        values.put(FormsTable.COLUMN_H0301E0B, fc.h0301e0b);
        values.put(FormsTable.COLUMN_H0301E0C, fc.h0301e0c);
        values.put(FormsTable.COLUMN_H0301F0A, fc.h0301f0a);
        values.put(FormsTable.COLUMN_H0301F0B, fc.h0301f0b);
        values.put(FormsTable.COLUMN_H0301F0C, fc.h0301f0c);
        values.put(FormsTable.COLUMN_H0301G0A, fc.h0301g0a);
        values.put(FormsTable.COLUMN_H0301G0B, fc.h0301g0b);
        values.put(FormsTable.COLUMN_H0301G0C, fc.h0301g0c);
        values.put(FormsTable.COLUMN_H0301H0A, fc.h0301h0a);
        values.put(FormsTable.COLUMN_H0301H0B, fc.h0301h0b);
        values.put(FormsTable.COLUMN_H0301H0C, fc.h0301h0c);
        values.put(FormsTable.COLUMN_H0301I0A, fc.h0301i0a);
        values.put(FormsTable.COLUMN_H0301I0B, fc.h0301i0b);
        values.put(FormsTable.COLUMN_H0301I0C, fc.h0301i0c);
        values.put(FormsTable.COLUMN_H0301J0A, fc.h0301j0a);
        values.put(FormsTable.COLUMN_H0301J0B, fc.h0301j0b);
        values.put(FormsTable.COLUMN_H0301J0C, fc.h0301j0c);
        values.put(FormsTable.COLUMN_H0301K0A, fc.h0301k0a);
        values.put(FormsTable.COLUMN_H0301K0B, fc.h0301k0b);
        values.put(FormsTable.COLUMN_H0301K0C, fc.h0301k0c);
        values.put(FormsTable.COLUMN_H0301L0A, fc.h0301l0a);
        values.put(FormsTable.COLUMN_H0301L0B, fc.h0301l0b);
        values.put(FormsTable.COLUMN_H0301L0C, fc.h0301l0c);
        values.put(FormsTable.COLUMN_H0301M0A, fc.h0301m0a);
        values.put(FormsTable.COLUMN_H0301M0B, fc.h0301m0b);
        values.put(FormsTable.COLUMN_H0301M0C, fc.h0301m0c);
        values.put(FormsTable.COLUMN_H0401, fc.h0401);
        values.put(FormsTable.COLUMN_H0401XX, fc.h0401xx);
        values.put(FormsTable.COLUMN_H0501, fc.h0501);
        values.put(FormsTable.COLUMN_H0501XX, fc.h0501xx);
        values.put(FormsTable.COLUMN_H0601, fc.h0601);
        values.put(FormsTable.COLUMN_H0601AA, fc.h0601aa);
        values.put(FormsTable.COLUMN_H0602, fc.h0602);
        values.put(FormsTable.COLUMN_H0603A, fc.h0603a);
        values.put(FormsTable.COLUMN_H0603B, fc.h0603b);
        values.put(FormsTable.COLUMN_H0603C, fc.h0603c);
        values.put(FormsTable.COLUMN_H0701A, fc.h0701a);
        values.put(FormsTable.COLUMN_H0701B, fc.h0701b);
        values.put(FormsTable.COLUMN_H0701C, fc.h0701c);
        values.put(FormsTable.COLUMN_H0701D, fc.h0701d);
        values.put(FormsTable.COLUMN_H0701E, fc.h0701e);
        values.put(FormsTable.COLUMN_H0701F, fc.h0701f);
        values.put(FormsTable.COLUMN_H0701G, fc.h0701g);
        values.put(FormsTable.COLUMN_H0801, fc.h0801);
        values.put(FormsTable.COLUMN_H0802, fc.h0802);
        values.put(FormsTable.COLUMN_H0901, fc.h0901);
        values.put(FormsTable.COLUMN_H0902A, fc.h0902a);
        values.put(FormsTable.COLUMN_H0902B, fc.h0902b);
        values.put(FormsTable.COLUMN_H0902C, fc.h0902c);
        values.put(FormsTable.COLUMN_H1001, fc.h1001);
        values.put(FormsTable.COLUMN_H1002A, fc.h1002a);
        values.put(FormsTable.COLUMN_H1002B, fc.h1002b);
        values.put(FormsTable.COLUMN_H1101, fc.h1101);
        values.put(FormsTable.COLUMN_H1102, fc.h1102);
        values.put(FormsTable.COLUMN_H1103, fc.h1103);
        values.put(FormsTable.COLUMN_H1104, fc.h1104);
        values.put(FormsTable.COLUMN_H1105, fc.h1105);
        values.put(FormsTable.COLUMN_H1106, fc.h1106);
        values.put(FormsTable.COLUMN_H1107, fc.h1107);
        values.put(FormsTable.COLUMN_H1201, fc.h1201);
        values.put(FormsTable.COLUMN_H1202, fc.h1202);
        values.put(FormsTable.COLUMN_H1203A, fc.h1203a);
        values.put(FormsTable.COLUMN_H1203B, fc.h1203b);
        values.put(FormsTable.COLUMN_H1203C, fc.h1203c);
        values.put(FormsTable.COLUMN_H1203D, fc.h1203d);
        values.put(FormsTable.COLUMN_H1203E, fc.h1203e);
        values.put(FormsTable.COLUMN_H1203F, fc.h1203f);
        values.put(FormsTable.COLUMN_H1203G, fc.h1203g);
        values.put(FormsTable.COLUMN_H1301, fc.h1301);
        values.put(FormsTable.COLUMN_H1302, fc.h1302);
        values.put(FormsTable.COLUMN_H1303, fc.h1303);
        values.put(FormsTable.COLUMN_H1401AA, fc.h1401aa);
        values.put(FormsTable.COLUMN_H1401AB, fc.h1401ab);
        values.put(FormsTable.COLUMN_H1401BA, fc.h1401ba);
        values.put(FormsTable.COLUMN_H1401BB, fc.h1401bb);
        values.put(FormsTable.COLUMN_H1401CA, fc.h1401ca);
        values.put(FormsTable.COLUMN_H1401CB, fc.h1401cb);
        values.put(FormsTable.COLUMN_H1401DA, fc.h1401da);
        values.put(FormsTable.COLUMN_H1401DB, fc.h1401db);
        values.put(FormsTable.COLUMN_H1401EA, fc.h1401ea);
        values.put(FormsTable.COLUMN_H1401EB, fc.h1401eb);
        values.put(FormsTable.COLUMN_H1501A0A, fc.h1501a0a);
        values.put(FormsTable.COLUMN_H1501A0B, fc.h1501a0b);
        values.put(FormsTable.COLUMN_H1501A0C, fc.h1501a0c);
        values.put(FormsTable.COLUMN_H1501A0DY, fc.h1501a0dy);
        values.put(FormsTable.COLUMN_H1501A0DN, fc.h1501a0dn);
        values.put(FormsTable.COLUMN_H1501B0A, fc.h1501b0a);
        values.put(FormsTable.COLUMN_H1501B0B, fc.h1501b0b);
        values.put(FormsTable.COLUMN_H1501B0C, fc.h1501b0c);
        values.put(FormsTable.COLUMN_H1501B0DY, fc.h1501b0dy);
        values.put(FormsTable.COLUMN_H1501B0DN, fc.h1501b0dn);
        values.put(FormsTable.COLUMN_H1501C0A, fc.h1501c0a);
        values.put(FormsTable.COLUMN_H1501C0B, fc.h1501c0b);
        values.put(FormsTable.COLUMN_H1501C0C, fc.h1501c0c);
        values.put(FormsTable.COLUMN_H1501C0DY, fc.h1501c0dy);
        values.put(FormsTable.COLUMN_H1501C0DN, fc.h1501c0dn);
        values.put(FormsTable.COLUMN_H1501D0A, fc.h1501d0a);
        values.put(FormsTable.COLUMN_H1501D0B, fc.h1501d0b);
        values.put(FormsTable.COLUMN_H1501D0C, fc.h1501d0c);
        values.put(FormsTable.COLUMN_H1501D0DY, fc.h1501d0dy);
        values.put(FormsTable.COLUMN_H1501D0DN, fc.h1501d0dn);
        values.put(FormsTable.COLUMN_H1501E0A, fc.h1501e0a);
        values.put(FormsTable.COLUMN_H1501E0B, fc.h1501e0b);
        values.put(FormsTable.COLUMN_H1501E0C, fc.h1501e0c);
        values.put(FormsTable.COLUMN_H1501E0DY, fc.h1501e0dy);
        values.put(FormsTable.COLUMN_H1501E0DN, fc.h1501e0dn);
        values.put(FormsTable.COLUMN_H1501F0A, fc.h1501f0a);
        values.put(FormsTable.COLUMN_H1501F0B, fc.h1501f0b);
        values.put(FormsTable.COLUMN_H1501F0C, fc.h1501f0c);
        values.put(FormsTable.COLUMN_H1501F0DY, fc.h1501f0dy);
        values.put(FormsTable.COLUMN_H1501F0DN, fc.h1501f0dn);
        values.put(FormsTable.COLUMN_H1501G0A, fc.h1501g0a);
        values.put(FormsTable.COLUMN_H1501G0B, fc.h1501g0b);
        values.put(FormsTable.COLUMN_H1501G0C, fc.h1501g0c);
        values.put(FormsTable.COLUMN_H1501G0DY, fc.h1501g0dy);
        values.put(FormsTable.COLUMN_H1501G0DN, fc.h1501g0dn);
        values.put(FormsTable.COLUMN_H1501H0A, fc.h1501h0a);
        values.put(FormsTable.COLUMN_H1501H0B, fc.h1501h0b);
        values.put(FormsTable.COLUMN_H1501H0C, fc.h1501h0c);
        values.put(FormsTable.COLUMN_H1501H0DY, fc.h1501h0dy);
        values.put(FormsTable.COLUMN_H1501H0DN, fc.h1501h0dn);
        values.put(FormsTable.COLUMN_H1501I0A, fc.h1501i0a);
        values.put(FormsTable.COLUMN_H1501I0B, fc.h1501i0b);
        values.put(FormsTable.COLUMN_H1501I0C, fc.h1501i0c);
        values.put(FormsTable.COLUMN_H1501I0DY, fc.h1501i0dy);
        values.put(FormsTable.COLUMN_H1501I0DN, fc.h1501i0dn);
        values.put(FormsTable.COLUMN_H1501J0A, fc.h1501j0a);
        values.put(FormsTable.COLUMN_H1501J0B, fc.h1501j0b);
        values.put(FormsTable.COLUMN_H1501J0C, fc.h1501j0c);
        values.put(FormsTable.COLUMN_H1501J0DY, fc.h1501j0dy);
        values.put(FormsTable.COLUMN_H1501J0DN, fc.h1501j0dn);
        values.put(FormsTable.COLUMN_H1501K0A, fc.h1501k0a);
        values.put(FormsTable.COLUMN_H1501K0B, fc.h1501k0b);
        values.put(FormsTable.COLUMN_H1501K0C, fc.h1501k0c);
        values.put(FormsTable.COLUMN_H1501K0DY, fc.h1501k0dy);
        values.put(FormsTable.COLUMN_H1501K0DN, fc.h1501k0dn);
        values.put(FormsTable.COLUMN_H1501L0A, fc.h1501l0a);
        values.put(FormsTable.COLUMN_H1501L0B, fc.h1501l0b);
        values.put(FormsTable.COLUMN_H1501L0C, fc.h1501l0c);
        values.put(FormsTable.COLUMN_H1501L0DY, fc.h1501l0dy);
        values.put(FormsTable.COLUMN_H1501L0DN, fc.h1501l0dn);
        values.put(FormsTable.COLUMN_H1501M0A, fc.h1501m0a);
        values.put(FormsTable.COLUMN_H1501M0B, fc.h1501m0b);
        values.put(FormsTable.COLUMN_H1501M0C, fc.h1501m0c);
        values.put(FormsTable.COLUMN_H1501M0DY, fc.h1501m0dy);
        values.put(FormsTable.COLUMN_H1501M0DN, fc.h1501m0dn);
        values.put(FormsTable.COLUMN_H1501N0A, fc.h1501n0a);
        values.put(FormsTable.COLUMN_H1501N0B, fc.h1501n0b);
        values.put(FormsTable.COLUMN_H1501N0C, fc.h1501n0c);
        values.put(FormsTable.COLUMN_H1501N0DY, fc.h1501n0dy);
        values.put(FormsTable.COLUMN_H1501N0DN, fc.h1501n0dn);
        values.put(FormsTable.COLUMN_H1501O0A, fc.h1501o0a);
        values.put(FormsTable.COLUMN_H1501O0B, fc.h1501o0b);
        values.put(FormsTable.COLUMN_H1501O0C, fc.h1501o0c);
        values.put(FormsTable.COLUMN_H1501O0DY, fc.h1501o0dy);
        values.put(FormsTable.COLUMN_H1501O0DN, fc.h1501o0dn);
        values.put(FormsTable.COLUMN_H1501P0A, fc.h1501p0a);
        values.put(FormsTable.COLUMN_H1501P0B, fc.h1501p0b);
        values.put(FormsTable.COLUMN_H1501P0C, fc.h1501p0c);
        values.put(FormsTable.COLUMN_H1501P0DY, fc.h1501p0dy);
        values.put(FormsTable.COLUMN_H1501P0DN, fc.h1501p0dn);
        values.put(FormsTable.COLUMN_H1501Q0A, fc.h1501q0a);
        values.put(FormsTable.COLUMN_H1501Q0B, fc.h1501q0b);
        values.put(FormsTable.COLUMN_H1501Q0C, fc.h1501q0c);
        values.put(FormsTable.COLUMN_H1501Q0DY, fc.h1501q0dy);
        values.put(FormsTable.COLUMN_H1501Q0DN, fc.h1501q0dn);
        values.put(FormsTable.COLUMN_H1501R0A, fc.h1501r0a);
        values.put(FormsTable.COLUMN_H1501R0B, fc.h1501r0b);
        values.put(FormsTable.COLUMN_H1501R0C, fc.h1501r0c);
        values.put(FormsTable.COLUMN_H1501R0DY, fc.h1501r0dy);
        values.put(FormsTable.COLUMN_H1501R0DN, fc.h1501r0dn);
        values.put(FormsTable.COLUMN_H1501S0A, fc.h1501s0a);
        values.put(FormsTable.COLUMN_H1501S0B, fc.h1501s0b);
        values.put(FormsTable.COLUMN_H1501S0C, fc.h1501s0c);
        values.put(FormsTable.COLUMN_H1501S0DY, fc.h1501s0dy);
        values.put(FormsTable.COLUMN_H1501S0DN, fc.h1501s0dn);
        values.put(FormsTable.COLUMN_H1501T0A, fc.h1501t0a);
        values.put(FormsTable.COLUMN_H1501T0B, fc.h1501t0b);
        values.put(FormsTable.COLUMN_H1501T0C, fc.h1501t0c);
        values.put(FormsTable.COLUMN_H1501T0DY, fc.h1501t0dy);
        values.put(FormsTable.COLUMN_H1501T0DN, fc.h1501t0dn);
        values.put(FormsTable.COLUMN_H1501U0A, fc.h1501u0a);
        values.put(FormsTable.COLUMN_H1501U0B, fc.h1501u0b);
        values.put(FormsTable.COLUMN_H1501U0C, fc.h1501u0c);
        values.put(FormsTable.COLUMN_H1501U0DY, fc.h1501u0dy);
        values.put(FormsTable.COLUMN_H1501U0DN, fc.h1501u0dn);
        values.put(FormsTable.COLUMN_H1501V0A, fc.h1501v0a);
        values.put(FormsTable.COLUMN_H1501V0B, fc.h1501v0b);
        values.put(FormsTable.COLUMN_H1501V0C, fc.h1501v0c);
        values.put(FormsTable.COLUMN_H1501V0DY, fc.h1501v0dy);
        values.put(FormsTable.COLUMN_H1501V0DN, fc.h1501v0dn);
        values.put(FormsTable.COLUMN_H1501W0A, fc.h1501w0a);
        values.put(FormsTable.COLUMN_H1501W0B, fc.h1501w0b);
        values.put(FormsTable.COLUMN_H1501W0C, fc.h1501w0c);
        values.put(FormsTable.COLUMN_H1501W0DY, fc.h1501w0dy);
        values.put(FormsTable.COLUMN_H1501W0DN, fc.h1501w0dn);
        values.put(FormsTable.COLUMN_H1501X0A, fc.h1501x0a);
        values.put(FormsTable.COLUMN_H1501X0B, fc.h1501x0b);
        values.put(FormsTable.COLUMN_H1501X0C, fc.h1501x0c);
        values.put(FormsTable.COLUMN_H1501X0DY, fc.h1501x0dy);
        values.put(FormsTable.COLUMN_H1501X0DN, fc.h1501x0dn);
        values.put(FormsTable.COLUMN_H1501Y0A, fc.h1501y0a);
        values.put(FormsTable.COLUMN_H1501Y0B, fc.h1501y0b);
        values.put(FormsTable.COLUMN_H1501Y0C, fc.h1501y0c);
        values.put(FormsTable.COLUMN_H1501Y0DY, fc.h1501y0dy);
        values.put(FormsTable.COLUMN_H1501Y0DN, fc.h1501y0dn);
        values.put(FormsTable.COLUMN_H1501Z0A, fc.h1501z0a);
        values.put(FormsTable.COLUMN_H1501Z0B, fc.h1501z0b);
        values.put(FormsTable.COLUMN_H1501Z0C, fc.h1501z0c);
        values.put(FormsTable.COLUMN_H1501Z0DY, fc.h1501z0dy);
        values.put(FormsTable.COLUMN_H1501Z0DN, fc.h1501z0dn);
        values.put(FormsTable.COLUMN_H1601, fc.h1601);
        values.put(FormsTable.COLUMN_H1602, fc.h1602);
        values.put(FormsTable.COLUMN_H1602XX, fc.h1602xx);
        values.put(FormsTable.COLUMN_H1603, fc.h1603);
        values.put(FormsTable.COLUMN_H1603XX, fc.h1603xx);
        values.put(FormsTable.COLUMN_H1604, fc.h1604);
        values.put(FormsTable.COLUMN_H1605, fc.h1605);
        values.put(FormsTable.COLUMN_H1605XX, fc.h1605xx);
        values.put(FormsTable.COLUMN_I0101, fc.i0101);
        values.put(FormsTable.COLUMN_I0102A, fc.i0102a);
        values.put(FormsTable.COLUMN_I0102B, fc.i0102b);
        values.put(FormsTable.COLUMN_I0103, fc.i0103);
        values.put(FormsTable.COLUMN_I0104, fc.i0104);
        values.put(FormsTable.COLUMN_I0105, fc.i0105);
        values.put(FormsTable.COLUMN_I0106A, fc.i0106a);
        values.put(FormsTable.COLUMN_I0106B, fc.i0106b);
        values.put(FormsTable.COLUMN_I0107, fc.i0107);
        values.put(FormsTable.COLUMN_I0108, fc.i0108);
        values.put(FormsTable.COLUMN_I0201A, fc.i0201a);
        values.put(FormsTable.COLUMN_I0201B, fc.i0201b);
        values.put(FormsTable.COLUMN_I0201C, fc.i0201c);
        values.put(FormsTable.COLUMN_I0201D, fc.i0201d);
        values.put(FormsTable.COLUMN_I0201E, fc.i0201e);
        values.put(FormsTable.COLUMN_I0201F, fc.i0201f);
        values.put(FormsTable.COLUMN_I0201G, fc.i0201g);
        values.put(FormsTable.COLUMN_I0201H, fc.i0201h);
        values.put(FormsTable.COLUMN_I0201I, fc.i0201i);
        values.put(FormsTable.COLUMN_I0201JA, fc.i0201ja);
        values.put(FormsTable.COLUMN_I0201JB, fc.i0201jb);
        values.put(FormsTable.COLUMN_I0201JC, fc.i0201jc);
        values.put(FormsTable.COLUMN_I0201JD, fc.i0201jd);
        values.put(FormsTable.COLUMN_I0201JE, fc.i0201je);
        values.put(FormsTable.COLUMN_I0201K, fc.i0201k);
        values.put(FormsTable.COLUMN_I0201LA, fc.i0201la);
        values.put(FormsTable.COLUMN_I0201LB, fc.i0201lb);
        values.put(FormsTable.COLUMN_I0201LC, fc.i0201lc);
        values.put(FormsTable.COLUMN_I0201M, fc.i0201m);
        values.put(FormsTable.COLUMN_I0201N, fc.i0201n);
        values.put(FormsTable.COLUMN_I0201O, fc.i0201o);
        values.put(FormsTable.COLUMN_I0201PA, fc.i0201pa);
        values.put(FormsTable.COLUMN_I0201PB, fc.i0201pb);
        values.put(FormsTable.COLUMN_I0201PC, fc.i0201pc);
        values.put(FormsTable.COLUMN_I0201PD, fc.i0201pd);
        values.put(FormsTable.COLUMN_I0201PE, fc.i0201pe);
        values.put(FormsTable.COLUMN_I0201PF, fc.i0201pf);
        values.put(FormsTable.COLUMN_I0201Q, fc.i0201q);
        values.put(FormsTable.COLUMN_I0301A, fc.i0301a);
        values.put(FormsTable.COLUMN_I0301B, fc.i0301b);
        values.put(FormsTable.COLUMN_I0301C, fc.i0301c);
        values.put(FormsTable.COLUMN_I0301D, fc.i0301d);
        values.put(FormsTable.COLUMN_I0301E, fc.i0301e);
        values.put(FormsTable.COLUMN_I0301F, fc.i0301f);
        values.put(FormsTable.COLUMN_I0301G, fc.i0301g);
        values.put(FormsTable.COLUMN_I0301H, fc.i0301h);
        values.put(FormsTable.COLUMN_I0301I, fc.i0301i);
        values.put(FormsTable.COLUMN_I0301J, fc.i0301j);
        values.put(FormsTable.COLUMN_I0301K, fc.i0301k);
        values.put(FormsTable.COLUMN_I0401A, fc.i0401a);
        values.put(FormsTable.COLUMN_I0401B, fc.i0401b);
        values.put(FormsTable.COLUMN_I0401C, fc.i0401c);
        values.put(FormsTable.COLUMN_I0401D, fc.i0401d);
        values.put(FormsTable.COLUMN_I0401E, fc.i0401e);
        values.put(FormsTable.COLUMN_I0401F, fc.i0401f);
        values.put(FormsTable.COLUMN_I0401G, fc.i0401g);
        values.put(FormsTable.COLUMN_J0100A, fc.j0100a);
        values.put(FormsTable.COLUMN_J0100B, fc.j0100b);
        values.put(FormsTable.COLUMN_J0100C, fc.j0100c);
        values.put(FormsTable.COLUMN_J0101A, fc.j0101a);
        values.put(FormsTable.COLUMN_J0101B, fc.j0101b);
        values.put(FormsTable.COLUMN_J0101C, fc.j0101c);
        values.put(FormsTable.COLUMN_J0101D, fc.j0101d);
        values.put(FormsTable.COLUMN_J0101E, fc.j0101e);
        values.put(FormsTable.COLUMN_J0101F, fc.j0101f);
        values.put(FormsTable.COLUMN_J0101G, fc.j0101g);
        values.put(FormsTable.COLUMN_J0101H, fc.j0101h);
        values.put(FormsTable.COLUMN_J0101IA, fc.j0101ia);
        values.put(FormsTable.COLUMN_J0101IB, fc.j0101ib);
        values.put(FormsTable.COLUMN_J0101J, fc.j0101j);
        values.put(FormsTable.COLUMN_J0101K, fc.j0101k);
        values.put(FormsTable.COLUMN_J0101L, fc.j0101l);
        values.put(FormsTable.COLUMN_J0101MA, fc.j0101ma);
        values.put(FormsTable.COLUMN_J0101MB, fc.j0101mb);
        values.put(FormsTable.COLUMN_J0101MC, fc.j0101mc);
        values.put(FormsTable.COLUMN_J0101MD, fc.j0101md);
        values.put(FormsTable.COLUMN_J0101ME, fc.j0101me);
        values.put(FormsTable.COLUMN_J0101MF, fc.j0101mf);
        values.put(FormsTable.COLUMN_J0101MX, fc.j0101mx);
        values.put(FormsTable.COLUMN_J0101MXX, fc.j0101mxx);
        values.put(FormsTable.COLUMN_J0200A, fc.j0200a);
        values.put(FormsTable.COLUMN_J0200B, fc.j0200b);
        values.put(FormsTable.COLUMN_J0200C, fc.j0200c);
        values.put(FormsTable.COLUMN_J0201A, fc.j0201a);
        values.put(FormsTable.COLUMN_J0201B, fc.j0201b);
        values.put(FormsTable.COLUMN_J0201C, fc.j0201c);
        values.put(FormsTable.COLUMN_J0201D, fc.j0201d);
        values.put(FormsTable.COLUMN_J0201E, fc.j0201e);
        values.put(FormsTable.COLUMN_J0201F, fc.j0201f);
        values.put(FormsTable.COLUMN_J0201GA, fc.j0201ga);
        values.put(FormsTable.COLUMN_J0201GB, fc.j0201gb);
        values.put(FormsTable.COLUMN_J0201GC, fc.j0201gc);
        values.put(FormsTable.COLUMN_J0201GD, fc.j0201gd);
        values.put(FormsTable.COLUMN_J0201GE, fc.j0201ge);
        values.put(FormsTable.COLUMN_J0201GF, fc.j0201gf);
        values.put(FormsTable.COLUMN_J0201GX, fc.j0201gx);
        values.put(FormsTable.COLUMN_J0201GXX, fc.j0201gxx);
        values.put(FormsTable.COLUMN_J0300A, fc.j0300a);
        values.put(FormsTable.COLUMN_J0300B, fc.j0300b);
        values.put(FormsTable.COLUMN_J0300C, fc.j0300c);
        values.put(FormsTable.COLUMN_J0301A, fc.j0301a);
        values.put(FormsTable.COLUMN_J0301B, fc.j0301b);
        values.put(FormsTable.COLUMN_J0301C, fc.j0301c);
        values.put(FormsTable.COLUMN_J0301D, fc.j0301d);
        values.put(FormsTable.COLUMN_J0301E, fc.j0301e);
        values.put(FormsTable.COLUMN_J0301F, fc.j0301f);
        values.put(FormsTable.COLUMN_J0301G, fc.j0301g);
        values.put(FormsTable.COLUMN_J0301H, fc.j0301h);
        values.put(FormsTable.COLUMN_J0301I, fc.j0301i);
        values.put(FormsTable.COLUMN_J0301J, fc.j0301j);
        values.put(FormsTable.COLUMN_J0301K, fc.j0301k);
        values.put(FormsTable.COLUMN_J0301L, fc.j0301l);
        values.put(FormsTable.COLUMN_J0301M, fc.j0301m);
        values.put(FormsTable.COLUMN_J0301N, fc.j0301n);
        values.put(FormsTable.COLUMN_J0301O, fc.j0301o);
        values.put(FormsTable.COLUMN_J0301P, fc.j0301p);
        values.put(FormsTable.COLUMN_J0301Q, fc.j0301q);
        values.put(FormsTable.COLUMN_J0301R, fc.j0301r);
        values.put(FormsTable.COLUMN_J0301S, fc.j0301s);
        values.put(FormsTable.COLUMN_J0301T, fc.j0301t);
        values.put(FormsTable.COLUMN_J0301U, fc.j0301u);
        values.put(FormsTable.COLUMN_J0301V, fc.j0301v);
        values.put(FormsTable.COLUMN_J0301WA, fc.j0301wa);
        values.put(FormsTable.COLUMN_J0301WB, fc.j0301wb);
        values.put(FormsTable.COLUMN_J0301WC, fc.j0301wc);
        values.put(FormsTable.COLUMN_J0301WD, fc.j0301wd);
        values.put(FormsTable.COLUMN_J0301WE, fc.j0301we);
        values.put(FormsTable.COLUMN_J0301WF, fc.j0301wf);
        values.put(FormsTable.COLUMN_J0301WX, fc.j0301wx);
        values.put(FormsTable.COLUMN_J0301WXX, fc.j0301wxx);
        values.put(FormsTable.COLUMN_J0400A, fc.j0400a);
        values.put(FormsTable.COLUMN_J0400B, fc.j0400b);
        values.put(FormsTable.COLUMN_J0400C, fc.j0400c);
        values.put(FormsTable.COLUMN_J0401A, fc.j0401a);
        values.put(FormsTable.COLUMN_J0401B, fc.j0401b);
        values.put(FormsTable.COLUMN_J0401C, fc.j0401c);
        values.put(FormsTable.COLUMN_J0401D, fc.j0401d);
        values.put(FormsTable.COLUMN_J0401E, fc.j0401e);
        values.put(FormsTable.COLUMN_J0401F, fc.j0401f);
        values.put(FormsTable.COLUMN_J0401G, fc.j0401g);
        values.put(FormsTable.COLUMN_J0401H, fc.j0401h);
        values.put(FormsTable.COLUMN_J0401I, fc.j0401i);
        values.put(FormsTable.COLUMN_J0401J, fc.j0401j);
        values.put(FormsTable.COLUMN_J0401K, fc.j0401k);
        values.put(FormsTable.COLUMN_J0401L, fc.j0401l);
        values.put(FormsTable.COLUMN_J0401MA, fc.j0401ma);
        values.put(FormsTable.COLUMN_J0401MB, fc.j0401mb);
        values.put(FormsTable.COLUMN_J0401MC, fc.j0401mc);
        values.put(FormsTable.COLUMN_J0401MD, fc.j0401md);
        values.put(FormsTable.COLUMN_J0401ME, fc.j0401me);
        values.put(FormsTable.COLUMN_J0401MF, fc.j0401mf);
        values.put(FormsTable.COLUMN_J0401MX, fc.j0401mx);
        values.put(FormsTable.COLUMN_J0401MXX, fc.j0401mxx);
        values.put(FormsTable.COLUMN_J0500A, fc.j0500a);
        values.put(FormsTable.COLUMN_J0500B, fc.j0500b);
        values.put(FormsTable.COLUMN_J0500C, fc.j0500c);
        values.put(FormsTable.COLUMN_J0501A, fc.j0501a);
        values.put(FormsTable.COLUMN_J0501B, fc.j0501b);
        values.put(FormsTable.COLUMN_J0501C, fc.j0501c);
        values.put(FormsTable.COLUMN_J0501D, fc.j0501d);
        values.put(FormsTable.COLUMN_J0501E, fc.j0501e);
        values.put(FormsTable.COLUMN_J0501F, fc.j0501f);
        values.put(FormsTable.COLUMN_J0501G, fc.j0501g);
        values.put(FormsTable.COLUMN_J0501H, fc.j0501h);
        values.put(FormsTable.COLUMN_J0501I, fc.j0501i);
        values.put(FormsTable.COLUMN_J0501J, fc.j0501j);
        values.put(FormsTable.COLUMN_J0501K, fc.j0501k);
        values.put(FormsTable.COLUMN_J0501L, fc.j0501l);
        values.put(FormsTable.COLUMN_J0501M, fc.j0501m);
        values.put(FormsTable.COLUMN_J0501NA, fc.j0501na);
        values.put(FormsTable.COLUMN_J0501NB, fc.j0501nb);
        values.put(FormsTable.COLUMN_J0501NC, fc.j0501nc);
        values.put(FormsTable.COLUMN_J0501ND, fc.j0501nd);
        values.put(FormsTable.COLUMN_J0501NE, fc.j0501ne);
        values.put(FormsTable.COLUMN_J0501NF, fc.j0501nf);
        values.put(FormsTable.COLUMN_J0501NX, fc.j0501nx);
        values.put(FormsTable.COLUMN_J0501NXX, fc.j0501nxx);
        values.put(FormsTable.COLUMN_J0600A, fc.j0600a);
        values.put(FormsTable.COLUMN_J0600B, fc.j0600b);
        values.put(FormsTable.COLUMN_J0600C, fc.j0600c);
        values.put(FormsTable.COLUMN_J0601A, fc.j0601a);
        values.put(FormsTable.COLUMN_J0601B, fc.j0601b);
        values.put(FormsTable.COLUMN_J0601C, fc.j0601c);
        values.put(FormsTable.COLUMN_J0601D, fc.j0601d);
        values.put(FormsTable.COLUMN_J0601E, fc.j0601e);
        values.put(FormsTable.COLUMN_J0601F, fc.j0601f);
        values.put(FormsTable.COLUMN_J0601G, fc.j0601g);
        values.put(FormsTable.COLUMN_J0601H, fc.j0601h);
        values.put(FormsTable.COLUMN_J0601I, fc.j0601i);
        values.put(FormsTable.COLUMN_J0601J, fc.j0601j);
        values.put(FormsTable.COLUMN_J0601K, fc.j0601k);
        values.put(FormsTable.COLUMN_J0601L, fc.j0601l);
        values.put(FormsTable.COLUMN_J0601MA, fc.j0601ma);
        values.put(FormsTable.COLUMN_J0601MB, fc.j0601mb);
        values.put(FormsTable.COLUMN_J0601MC, fc.j0601mc);
        values.put(FormsTable.COLUMN_J0601MD, fc.j0601md);
        values.put(FormsTable.COLUMN_J0601ME, fc.j0601me);
        values.put(FormsTable.COLUMN_J0601MF, fc.j0601mf);
        values.put(FormsTable.COLUMN_J0601MX, fc.j0601mx);
        values.put(FormsTable.COLUMN_J0601MXX, fc.j0601mxx);
        values.put(FormsTable.COLUMN_J0700A, fc.j0700a);
        values.put(FormsTable.COLUMN_J0700B, fc.j0700b);
        values.put(FormsTable.COLUMN_J0700C, fc.j0700c);
        values.put(FormsTable.COLUMN_J0701A, fc.j0701a);
        values.put(FormsTable.COLUMN_J0701B, fc.j0701b);
        values.put(FormsTable.COLUMN_J0701C, fc.j0701c);
        values.put(FormsTable.COLUMN_J0701D, fc.j0701d);
        values.put(FormsTable.COLUMN_J0701E, fc.j0701e);
        values.put(FormsTable.COLUMN_J0701F, fc.j0701f);
        values.put(FormsTable.COLUMN_J0701GA, fc.j0701ga);
        values.put(FormsTable.COLUMN_J0701GB, fc.j0701gb);
        values.put(FormsTable.COLUMN_J0701GC, fc.j0701gc);
        values.put(FormsTable.COLUMN_J0701GD, fc.j0701gd);
        values.put(FormsTable.COLUMN_J0701GE, fc.j0701ge);
        values.put(FormsTable.COLUMN_J0701GF, fc.j0701gf);
        values.put(FormsTable.COLUMN_J0701GX, fc.j0701gx);
        values.put(FormsTable.COLUMN_J0701GXX, fc.j0701gxx);
        values.put(FormsTable.COLUMN_J0800A, fc.j0800a);
        values.put(FormsTable.COLUMN_J0800B, fc.j0800b);
        values.put(FormsTable.COLUMN_J0800C, fc.j0800c);
        values.put(FormsTable.COLUMN_J0801A, fc.j0801a);
        values.put(FormsTable.COLUMN_J0801B, fc.j0801b);
        values.put(FormsTable.COLUMN_J0801C, fc.j0801c);
        values.put(FormsTable.COLUMN_J0801D, fc.j0801d);
        values.put(FormsTable.COLUMN_J0801E, fc.j0801e);
        values.put(FormsTable.COLUMN_J0801F, fc.j0801f);
        values.put(FormsTable.COLUMN_J0801GA, fc.j0801ga);
        values.put(FormsTable.COLUMN_J0801GB, fc.j0801gb);
        values.put(FormsTable.COLUMN_J0801GC, fc.j0801gc);
        values.put(FormsTable.COLUMN_J0801GD, fc.j0801gd);
        values.put(FormsTable.COLUMN_J0900A, fc.j0900a);
        values.put(FormsTable.COLUMN_J0900B, fc.j0900b);
        values.put(FormsTable.COLUMN_J0900C, fc.j0900c);
        values.put(FormsTable.COLUMN_J0901A, fc.j0901a);
        values.put(FormsTable.COLUMN_J0901B, fc.j0901b);
        values.put(FormsTable.COLUMN_J0901C, fc.j0901c);
        values.put(FormsTable.COLUMN_J0901D, fc.j0901d);
        values.put(FormsTable.COLUMN_J0901E, fc.j0901e);
        values.put(FormsTable.COLUMN_J0901FA, fc.j0901fa);
        values.put(FormsTable.COLUMN_J0901FB, fc.j0901fb);
        values.put(FormsTable.COLUMN_J0901FC, fc.j0901fc);
        values.put(FormsTable.COLUMN_J0901FD, fc.j0901fd);
        values.put(FormsTable.COLUMN_J0901FE, fc.j0901fe);
        values.put(FormsTable.COLUMN_K0101A, fc.k0101a);
        values.put(FormsTable.COLUMN_K0101B, fc.k0101b);
        values.put(FormsTable.COLUMN_K0101C, fc.k0101c);
        values.put(FormsTable.COLUMN_K0101CXX, fc.k0101cxx);
        values.put(FormsTable.COLUMN_K0102, fc.k0102);
        values.put(FormsTable.COLUMN_K0103, fc.k0103);
        values.put(FormsTable.COLUMN_K0104, fc.k0104);
        values.put(FormsTable.COLUMN_K0104AA, fc.k0104aa);
        values.put(FormsTable.COLUMN_K0104AAXX, fc.k0104aaxx);
        values.put(FormsTable.COLUMN_K0105, fc.k0105);
        values.put(FormsTable.COLUMN_K0201A, fc.k0201a);
        values.put(FormsTable.COLUMN_K0201B, fc.k0201b);
        values.put(FormsTable.COLUMN_K0202, fc.k0202);
        values.put(FormsTable.COLUMN_K0203, fc.k0203);
        values.put(FormsTable.COLUMN_K0204, fc.k0204);
        values.put(FormsTable.COLUMN_K0301, fc.k0301);
        values.put(FormsTable.COLUMN_K0302, fc.k0302);
        values.put(FormsTable.COLUMN_K0303, fc.k0303);
        values.put(FormsTable.COLUMN_K0304, fc.k0304);
        values.put(FormsTable.COLUMN_K0305, fc.k0305);
        values.put(FormsTable.COLUMN_K0401, fc.k0401);
        values.put(FormsTable.COLUMN_K0402, fc.k0402);
        values.put(FormsTable.COLUMN_K0403, fc.k0403);
        values.put(FormsTable.COLUMN_K0404, fc.k0404);
        values.put(FormsTable.COLUMN_K0405, fc.k0405);
        values.put(FormsTable.COLUMN_K0406, fc.k0406);
        values.put(FormsTable.COLUMN_K0501, fc.k0501);
        values.put(FormsTable.COLUMN_K0502, fc.k0502);
        values.put(FormsTable.COLUMN_K0503, fc.k0503);
        values.put(FormsTable.COLUMN_K0504, fc.k0504);
        values.put(FormsTable.COLUMN_K0505, fc.k0505);
        values.put(FormsTable.COLUMN_K0506, fc.k0506);
        values.put(FormsTable.COLUMN_K060101A, fc.k060101a);
        values.put(FormsTable.COLUMN_K060101B, fc.k060101b);
        values.put(FormsTable.COLUMN_K060102A, fc.k060102a);
        values.put(FormsTable.COLUMN_K060102B, fc.k060102b);
        values.put(FormsTable.COLUMN_K060103A, fc.k060103a);
        values.put(FormsTable.COLUMN_K060103B, fc.k060103b);
        values.put(FormsTable.COLUMN_K060104A, fc.k060104a);
        values.put(FormsTable.COLUMN_K060104B, fc.k060104b);
        values.put(FormsTable.COLUMN_K060105A, fc.k060105a);
        values.put(FormsTable.COLUMN_K060105B, fc.k060105b);
        values.put(FormsTable.COLUMN_K060201A, fc.k060201a);
        values.put(FormsTable.COLUMN_K060201B, fc.k060201b);
        values.put(FormsTable.COLUMN_K060202A, fc.k060202a);
        values.put(FormsTable.COLUMN_K060202B, fc.k060202b);
        values.put(FormsTable.COLUMN_K060203A, fc.k060203a);
        values.put(FormsTable.COLUMN_K060203B, fc.k060203b);
        values.put(FormsTable.COLUMN_K060204A, fc.k060204a);
        values.put(FormsTable.COLUMN_K060204B, fc.k060204b);
        values.put(FormsTable.COLUMN_K060205A, fc.k060205a);
        values.put(FormsTable.COLUMN_K060205B, fc.k060205b);
        values.put(FormsTable.COLUMN_K060206A, fc.k060206a);
        values.put(FormsTable.COLUMN_K060206B, fc.k060206b);
        values.put(FormsTable.COLUMN_K0701A, fc.k0701a);
        values.put(FormsTable.COLUMN_K0701B, fc.k0701b);
        values.put(FormsTable.COLUMN_K0702A, fc.k0702a);
        values.put(FormsTable.COLUMN_K0702B, fc.k0702b);
        values.put(FormsTable.COLUMN_K0801A, fc.k0801a);
        values.put(FormsTable.COLUMN_K0801B, fc.k0801b);
        values.put(FormsTable.COLUMN_K0802A, fc.k0802a);
        values.put(FormsTable.COLUMN_K0802B, fc.k0802b);
        values.put(FormsTable.COLUMN_K0803A, fc.k0803a);
        values.put(FormsTable.COLUMN_K0803B, fc.k0803b);
        values.put(FormsTable.COLUMN_K0804A, fc.k0804a);
        values.put(FormsTable.COLUMN_K0804B, fc.k0804b);
        values.put(FormsTable.COLUMN_K0805A, fc.k0805a);
        values.put(FormsTable.COLUMN_K0805B, fc.k0805b);
        values.put(FormsTable.COLUMN_K0806A, fc.k0806a);
        values.put(FormsTable.COLUMN_K0806B, fc.k0806b);
        values.put(FormsTable.COLUMN_K0901A, fc.k0901a);
        values.put(FormsTable.COLUMN_K0901B, fc.k0901b);
        values.put(FormsTable.COLUMN_K0902A, fc.k0902a);
        values.put(FormsTable.COLUMN_K0902B, fc.k0902b);
        values.put(FormsTable.COLUMN_K0903A, fc.k0903a);
        values.put(FormsTable.COLUMN_K0903B, fc.k0903b);
        values.put(FormsTable.COLUMN_K0904A, fc.k0904a);
        values.put(FormsTable.COLUMN_K0904B, fc.k0904b);
        values.put(FormsTable.COLUMN_K0905A, fc.k0905a);
        values.put(FormsTable.COLUMN_K0905B, fc.k0905b);
        values.put(FormsTable.COLUMN_K1001, fc.k1001);
        values.put(FormsTable.COLUMN_K1002, fc.k1002);
        values.put(FormsTable.COLUMN_K1003, fc.k1003);
        values.put(FormsTable.COLUMN_K1004, fc.k1004);
        values.put(FormsTable.COLUMN_K1005, fc.k1005);
        values.put(FormsTable.COLUMN_K1006, fc.k1006);
        values.put(FormsTable.COLUMN_K1007, fc.k1007);
        values.put(FormsTable.COLUMN_K1008, fc.k1008);
        values.put(FormsTable.COLUMN_K1009, fc.k1009);
        values.put(FormsTable.COLUMN_K1010, fc.k1010);
        values.put(FormsTable.COLUMN_K1011, fc.k1011);
        values.put(FormsTable.COLUMN_K1012, fc.k1012);
        values.put(FormsTable.COLUMN_K1013, fc.k1013);
        values.put(FormsTable.COLUMN_K1014, fc.k1014);
        values.put(FormsTable.COLUMN_K1015, fc.k1015);
        values.put(FormsTable.COLUMN_K1101, fc.k1101);
        values.put(FormsTable.COLUMN_K1102, fc.k1102);
        values.put(FormsTable.COLUMN_K1103, fc.k1103);
        values.put(FormsTable.COLUMN_K1104, fc.k1104);
        values.put(FormsTable.COLUMN_K1105, fc.k1105);
        values.put(FormsTable.COLUMN_K1106, fc.k1106);
        values.put(FormsTable.COLUMN_K1107, fc.k1107);
        values.put(FormsTable.COLUMN_K1108, fc.k1108);
        values.put(FormsTable.COLUMN_K1109, fc.k1109);
        values.put(FormsTable.COLUMN_K1110, fc.k1110);
        values.put(FormsTable.COLUMN_K1111, fc.k1111);
        values.put(FormsTable.COLUMN_ISTATUS, fc.istatus);
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.istatus88x);
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.endingdatetime);
        values.put(FormsTable.COLUMN_GPSLAT, fc.gpsLat);
        values.put(FormsTable.COLUMN_GPSLNG, fc.gpsLng);
        values.put(FormsTable.COLUMN_GPSDATE, fc.gpsDT);
        values.put(FormsTable.COLUMN_GPSACC, fc.gpsAcc);
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.devicetagID);
        values.put(FormsTable.COLUMN_DEVICEID, fc.deviceID);
        values.put(FormsTable.COLUMN_APPVERSION, fc.appversion);

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.uid);

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc._id)};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public Collection<FormsContract> getAllForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_A01,
                FormsTable.COLUMN_A03D,
                FormsTable.COLUMN_A03M,
                FormsTable.COLUMN_A03Y,
                FormsTable.COLUMN_A07,
                FormsTable.COLUMN_A08,
                FormsTable.COLUMN_A09,
                FormsTable.COLUMN_A10,
                FormsTable.COLUMN_A11,
                FormsTable.COLUMN_A12,
                FormsTable.COLUMN_A13,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> checkFormExist() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_A01,
                FormsTable.COLUMN_A03D,
                FormsTable.COLUMN_A03M,
                FormsTable.COLUMN_A03Y,
                FormsTable.COLUMN_A07,
                FormsTable.COLUMN_A08,
                FormsTable.COLUMN_A09,
                FormsTable.COLUMN_A10,
                FormsTable.COLUMN_A11,
                FormsTable.COLUMN_A12,
                FormsTable.COLUMN_A13,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,

        };
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_A01,
                FormsTable.COLUMN_A03D,
                FormsTable.COLUMN_A03M,
                FormsTable.COLUMN_A03Y,
                FormsTable.COLUMN_A07,
                FormsTable.COLUMN_A08,
                FormsTable.COLUMN_A09,
                FormsTable.COLUMN_A10,
                FormsTable.COLUMN_A11,
                FormsTable.COLUMN_A12,
                FormsTable.COLUMN_A13,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_APPVERSION,
        };


        String whereClause = FormsTable.COLUMN_SYNCED + " is null";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN_ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc._id = c.getString(c.getColumnIndex(FormsTable.COLUMN_ID));
                fc.formdate = c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE));
                fc.istatus = c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS));
                fc.synced = c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.istatus);
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.istatus88x);
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.endingdatetime);

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc._id)};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    //Generic update FormColumn
    public int updatesFormColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc._id)};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


}