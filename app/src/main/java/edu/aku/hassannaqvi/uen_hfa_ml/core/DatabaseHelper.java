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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleCContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleGContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleHContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleIContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleJContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleKContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.TehsilsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.VersionAppContract;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_DISTRICTS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_HF;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEC;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEG;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEH;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEI;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEJ;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_MODULEK;
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
        db.execSQL(SQL_CREATE_MODULEC);
        db.execSQL(SQL_CREATE_MODULEG);
        db.execSQL(SQL_CREATE_MODULEH);
        db.execSQL(SQL_CREATE_MODULEI);
        db.execSQL(SQL_CREATE_MODULEJ);
        db.execSQL(SQL_CREATE_MODULEK);
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
                values.put(DistrictContract.singleDistrict.COLUMN_DISTRICT_TYPE, Vc.getDistrictType());

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
                DistrictContract.singleDistrict.COLUMN_DISTRICT_NAME,
                DistrictContract.singleDistrict.COLUMN_DISTRICT_TYPE
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


    public FormsContract CheckHF(String hfCode, String status) throws SQLException {
        SQLiteDatabase db = this.getReadableDatabase();
        FormsContract form = null;
        Cursor mCursor = db.rawQuery("SELECT * FROM " + FormsTable.TABLE_NAME + " WHERE " + FormsTable.COLUMN_A12 + "=? AND " + FormsTable.COLUMN_ISTATUS + " != ?", new String[]{hfCode, status});
        if (mCursor != null) {
            if (mCursor.getCount() == 0) return new FormsContract();
            if (mCursor.moveToFirst()) {
                form = new FormsContract().hydrate(mCursor);
            }
        }
        return form;
    }


    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.get_UID());
        values.put(FormsTable.COLUMN_USERNAME, fc.getUserName());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormdate());
        values.put(FormsTable.COLUMN_DISTRICT_CODE, fc.getDistrictCode());
        values.put(FormsTable.COLUMN_DISTRICT_TYPE, fc.getDistrictType());
        values.put(FormsTable.COLUMN_TEHSIL_CODE, fc.getTehsilCode());
        values.put(FormsTable.COLUMN_UC_CODE, fc.getUcCode());
        values.put(FormsTable.COLUMN_HF_CODE, fc.getHfCode());
        values.put(FormsTable.COLUMN_HF_NAME, fc.getHfName());
        values.put(FormsTable.COLUMN_A01, fc.getA01());
        values.put(FormsTable.COLUMN_A03D, fc.getA03d());
        values.put(FormsTable.COLUMN_A03M, fc.getA03m());
        values.put(FormsTable.COLUMN_A03Y, fc.getA03y());
        values.put(FormsTable.COLUMN_A07, fc.getA07());
        values.put(FormsTable.COLUMN_A08, fc.getA08());
        values.put(FormsTable.COLUMN_A09, fc.getA09());
        values.put(FormsTable.COLUMN_A10, fc.getA10());
        values.put(FormsTable.COLUMN_A11, fc.getA11());
        values.put(FormsTable.COLUMN_A12, fc.getA12());
        values.put(FormsTable.COLUMN_A13, fc.getA13());
        values.put(FormsTable.COLUMN_SB, fc.getsB());
        values.put(FormsTable.COLUMN_SC, fc.getsC());
        values.put(FormsTable.COLUMN_SD, fc.getsD());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleC(ModuleCContract modc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleCContract.ModuleC.COLUMN_UID, modc.get_UID());
        values.put(ModuleCContract.ModuleC.COLUMN_UUID, modc.get_UUID());
        values.put(ModuleCContract.ModuleC.COLUMN_FORMDATE, modc.getFormDate());
        values.put(ModuleCContract.ModuleC.COLUMN_SERIALNO, modc.getSerialno());
        values.put(ModuleCContract.ModuleC.COLUMN_DISTRICT_CODE, modc.getDistrictCode());
        values.put(ModuleCContract.ModuleC.COLUMN_TEHSIL_CODE, modc.getTehsilCode());
        values.put(ModuleCContract.ModuleC.COLUMN_UC_CODE, modc.getUcCode());
        values.put(ModuleCContract.ModuleC.COLUMN_HF_CODE, modc.getHfCode());
        values.put(ModuleCContract.ModuleC.COLUMN_SC2, modc.getsC2());
        values.put(ModuleCContract.ModuleC.COLUMN_DEVICEID, modc.getDeviceID());
        values.put(ModuleCContract.ModuleC.COLUMN_DEVICETAGID, modc.getDevicetagID());
        values.put(ModuleCContract.ModuleC.COLUMN_STATUS, modc.getStatus());
        values.put(ModuleCContract.ModuleC.COLUMN_SYNCED, modc.getSynced());
        values.put(ModuleCContract.ModuleC.COLUMN_SYNCED_DATE, modc.getSynced_date());
        values.put(ModuleCContract.ModuleC.COLUMN_APPVERSION, modc.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleCContract.ModuleC.TABLE_NAME,
                ModuleCContract.ModuleC.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleG(ModuleGContract modg) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleGContract.ModuleG.COLUMN_UID, modg.get_UID());
        values.put(ModuleGContract.ModuleG.COLUMN_UUID, modg.get_UUID());
        values.put(ModuleGContract.ModuleG.COLUMN_FORMDATE, modg.getFormDate());
        values.put(ModuleGContract.ModuleG.COLUMN_SERIALNO, modg.getSerialno());
        values.put(ModuleGContract.ModuleG.COLUMN_DISTRICT_CODE, modg.getDistrictCode());
        values.put(ModuleGContract.ModuleG.COLUMN_TEHSIL_CODE, modg.getTehsilCode());
        values.put(ModuleGContract.ModuleG.COLUMN_UC_CODE, modg.getUcCode());
        values.put(ModuleGContract.ModuleG.COLUMN_HF_CODE, modg.getHfCode());
        values.put(ModuleGContract.ModuleG.COLUMN_SG, modg.getsG());
        values.put(ModuleGContract.ModuleG.COLUMN_DEVICEID, modg.getDeviceID());
        values.put(ModuleGContract.ModuleG.COLUMN_DEVICETAGID, modg.getDevicetagID());
        values.put(ModuleGContract.ModuleG.COLUMN_STATUS, modg.getStatus());
        values.put(ModuleGContract.ModuleG.COLUMN_SYNCED, modg.getSynced());
        values.put(ModuleGContract.ModuleG.COLUMN_SYNCED_DATE, modg.getSynced_date());
        values.put(ModuleGContract.ModuleG.COLUMN_APPVERSION, modg.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleGContract.ModuleG.TABLE_NAME,
                ModuleGContract.ModuleG.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleH(ModuleHContract modh) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleHContract.ModuleH.COLUMN_UID, modh.get_UID());
        values.put(ModuleHContract.ModuleH.COLUMN_UUID, modh.get_UUID());
        values.put(ModuleHContract.ModuleH.COLUMN_FORMDATE, modh.getFormDate());
        values.put(ModuleHContract.ModuleH.COLUMN_SERIALNO, modh.getSerialno());
        values.put(ModuleHContract.ModuleH.COLUMN_DISTRICT_CODE, modh.getDistrictCode());
        values.put(ModuleHContract.ModuleH.COLUMN_TEHSIL_CODE, modh.getTehsilCode());
        values.put(ModuleHContract.ModuleH.COLUMN_UC_CODE, modh.getUcCode());
        values.put(ModuleHContract.ModuleH.COLUMN_HF_CODE, modh.getHfCode());
        values.put(ModuleHContract.ModuleH.COLUMN_SH, modh.getsH());
        values.put(ModuleHContract.ModuleH.COLUMN_DEVICEID, modh.getDeviceID());
        values.put(ModuleHContract.ModuleH.COLUMN_DEVICETAGID, modh.getDevicetagID());
        values.put(ModuleHContract.ModuleH.COLUMN_STATUS, modh.getStatus());
        values.put(ModuleHContract.ModuleH.COLUMN_SYNCED, modh.getSynced());
        values.put(ModuleHContract.ModuleH.COLUMN_SYNCED_DATE, modh.getSynced_date());
        values.put(ModuleHContract.ModuleH.COLUMN_APPVERSION, modh.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleHContract.ModuleH.TABLE_NAME,
                ModuleHContract.ModuleH.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleI(ModuleIContract modi) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleIContract.ModuleI.COLUMN_UID, modi.get_UID());
        values.put(ModuleIContract.ModuleI.COLUMN_UUID, modi.get_UUID());
        values.put(ModuleIContract.ModuleI.COLUMN_FORMDATE, modi.getFormDate());
        values.put(ModuleIContract.ModuleI.COLUMN_SERIALNO, modi.getSerialno());
        values.put(ModuleIContract.ModuleI.COLUMN_DISTRICT_CODE, modi.getDistrictCode());
        values.put(ModuleIContract.ModuleI.COLUMN_TEHSIL_CODE, modi.getTehsilCode());
        values.put(ModuleIContract.ModuleI.COLUMN_UC_CODE, modi.getUcCode());
        values.put(ModuleIContract.ModuleI.COLUMN_HF_CODE, modi.getHfCode());
        values.put(ModuleIContract.ModuleI.COLUMN_SI1, modi.getsI1());
        values.put(ModuleIContract.ModuleI.COLUMN_SI2, modi.getsI2());
        values.put(ModuleIContract.ModuleI.COLUMN_SI3, modi.getsI3());
        values.put(ModuleIContract.ModuleI.COLUMN_SI4, modi.getsI4());
        values.put(ModuleIContract.ModuleI.COLUMN_DEVICEID, modi.getDeviceID());
        values.put(ModuleIContract.ModuleI.COLUMN_DEVICETAGID, modi.getDevicetagID());
        values.put(ModuleIContract.ModuleI.COLUMN_STATUS, modi.getStatus());
        values.put(ModuleIContract.ModuleI.COLUMN_SYNCED, modi.getSynced());
        values.put(ModuleIContract.ModuleI.COLUMN_SYNCED_DATE, modi.getSynced_date());
        values.put(ModuleIContract.ModuleI.COLUMN_APPVERSION, modi.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleIContract.ModuleI.TABLE_NAME,
                ModuleIContract.ModuleI.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleJ(ModuleJContract modj) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleJContract.ModuleJ.COLUMN_UID, modj.get_UID());
        values.put(ModuleJContract.ModuleJ.COLUMN_UUID, modj.get_UUID());
        values.put(ModuleJContract.ModuleJ.COLUMN_FORMDATE, modj.getFormDate());
        values.put(ModuleJContract.ModuleJ.COLUMN_SERIALNO, modj.getSerialno());
        values.put(ModuleJContract.ModuleJ.COLUMN_DISTRICT_CODE, modj.getDistrictCode());
        values.put(ModuleJContract.ModuleJ.COLUMN_TEHSIL_CODE, modj.getTehsilCode());
        values.put(ModuleJContract.ModuleJ.COLUMN_UC_CODE, modj.getUcCode());
        values.put(ModuleJContract.ModuleJ.COLUMN_HF_CODE, modj.getHfCode());
        values.put(ModuleJContract.ModuleJ.COLUMN_SJ, modj.getsJ());
        values.put(ModuleJContract.ModuleJ.COLUMN_DEVICEID, modj.getDeviceID());
        values.put(ModuleJContract.ModuleJ.COLUMN_DEVICETAGID, modj.getDevicetagID());
        values.put(ModuleJContract.ModuleJ.COLUMN_STATUS, modj.getStatus());
        values.put(ModuleJContract.ModuleJ.COLUMN_SYNCED, modj.getSynced());
        values.put(ModuleJContract.ModuleJ.COLUMN_SYNCED_DATE, modj.getSynced_date());
        values.put(ModuleJContract.ModuleJ.COLUMN_APPVERSION, modj.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleJContract.ModuleJ.TABLE_NAME,
                ModuleJContract.ModuleJ.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addModuleK(ModuleKContract modk) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ModuleKContract.ModuleK.COLUMN_UID, modk.get_UID());
        values.put(ModuleKContract.ModuleK.COLUMN_UUID, modk.get_UUID());
        values.put(ModuleKContract.ModuleK.COLUMN_FORMDATE, modk.getFormDate());
        values.put(ModuleKContract.ModuleK.COLUMN_SERIALNO, modk.getSerialno());
        values.put(ModuleKContract.ModuleK.COLUMN_DISTRICT_CODE, modk.getDistrictCode());
        values.put(ModuleKContract.ModuleK.COLUMN_TEHSIL_CODE, modk.getTehsilCode());
        values.put(ModuleKContract.ModuleK.COLUMN_UC_CODE, modk.getUcCode());
        values.put(ModuleKContract.ModuleK.COLUMN_HF_CODE, modk.getHfCode());
        values.put(ModuleKContract.ModuleK.COLUMN_SK, modk.getsK());
        values.put(ModuleKContract.ModuleK.COLUMN_DEVICEID, modk.getDeviceID());
        values.put(ModuleKContract.ModuleK.COLUMN_DEVICETAGID, modk.getDevicetagID());
        values.put(ModuleKContract.ModuleK.COLUMN_STATUS, modk.getStatus());
        values.put(ModuleKContract.ModuleK.COLUMN_SYNCED, modk.getSynced());
        values.put(ModuleKContract.ModuleK.COLUMN_SYNCED_DATE, modk.getSynced_date());
        values.put(ModuleKContract.ModuleK.COLUMN_APPVERSION, modk.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ModuleKContract.ModuleK.TABLE_NAME,
                ModuleKContract.ModuleK.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public FormsContract isDataExists(String studyId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;

// New value for one column
        String[] columns = {
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_ISTATUS,

        };

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_UID + " = ? AND "
                + FormsTable.COLUMN_ISTATUS + " = ?";
        String[] selectionArgs = new String[]{studyId, "1"};

        FormsContract allFC = new FormsContract();
        try {
            c = db.query(FormsTable.TABLE_NAME, //Table to query
                    columns,                    //columns to return
                    selection,                  //columns for the WHERE clause
                    selectionArgs,              //The values for the WHERE clause
                    null,                       //group the rows
                    null,                       //filter by row groups
                    null);                   // The sort order

            while (c.moveToNext()) {
                allFC.set_UID(c.getString(c.getColumnIndex(FormsTable.COLUMN_UID)));
                allFC.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
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


    public void updateSyncedModuleC(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleCContract.ModuleC.COLUMN_SYNCED, true);
        values.put(ModuleCContract.ModuleC.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleCContract.ModuleC.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleCContract.ModuleC.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedModuleG(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleGContract.ModuleG.COLUMN_SYNCED, true);
        values.put(ModuleGContract.ModuleG.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleGContract.ModuleG.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleGContract.ModuleG.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedModuleH(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleHContract.ModuleH.COLUMN_SYNCED, true);
        values.put(ModuleHContract.ModuleH.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleHContract.ModuleH.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleHContract.ModuleH.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedModuleI(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleIContract.ModuleI.COLUMN_SYNCED, true);
        values.put(ModuleIContract.ModuleI.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleIContract.ModuleI.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleIContract.ModuleI.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedModuleJ(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleJContract.ModuleJ.COLUMN_SYNCED, true);
        values.put(ModuleJContract.ModuleJ.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleJContract.ModuleJ.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleJContract.ModuleJ.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedModuleK(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ModuleKContract.ModuleK.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ModuleKContract.ModuleK.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ModuleKContract.ModuleK.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.get_UID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

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
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_DISTRICT_CODE,
                FormsTable.COLUMN_DISTRICT_TYPE,
                FormsTable.COLUMN_TEHSIL_CODE,
                FormsTable.COLUMN_UC_CODE,
                FormsTable.COLUMN_HF_CODE,
                FormsTable.COLUMN_HF_NAME,
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
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
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
                allFC.add(fc.hydrate(c));
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
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_DISTRICT_CODE,
                FormsTable.COLUMN_DISTRICT_TYPE,
                FormsTable.COLUMN_TEHSIL_CODE,
                FormsTable.COLUMN_UC_CODE,
                FormsTable.COLUMN_HF_CODE,
                FormsTable.COLUMN_HF_NAME,
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
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
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
                allFC.add(fc.hydrate(c));
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
                FormsTable.COLUMN_USERNAME,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_DISTRICT_CODE,
                FormsTable.COLUMN_DISTRICT_TYPE,
                FormsTable.COLUMN_TEHSIL_CODE,
                FormsTable.COLUMN_UC_CODE,
                FormsTable.COLUMN_HF_CODE,
                FormsTable.COLUMN_HF_NAME,
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
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
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

        String whereClause = FormsTable.COLUMN_SYNCED + " is null AND " + FormsTable.COLUMN_ISTATUS + " =?";

        String[] whereArgs = new String[]{"1"};

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
                allFC.add(fc.hydrate(c));
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


    public Collection<ModuleCContract> getUnsyncedModuleC() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleCContract.ModuleC._ID,
                ModuleCContract.ModuleC.COLUMN_UID,
                ModuleCContract.ModuleC.COLUMN_UUID,
                ModuleCContract.ModuleC.COLUMN_FORMDATE,
                ModuleCContract.ModuleC.COLUMN_SERIALNO,
                ModuleCContract.ModuleC.COLUMN_DISTRICT_CODE,
                ModuleCContract.ModuleC.COLUMN_TEHSIL_CODE,
                ModuleCContract.ModuleC.COLUMN_UC_CODE,
                ModuleCContract.ModuleC.COLUMN_HF_CODE,
                ModuleCContract.ModuleC.COLUMN_SC2,
                ModuleCContract.ModuleC.COLUMN_DEVICEID,
                ModuleCContract.ModuleC.COLUMN_DEVICETAGID,
                ModuleCContract.ModuleC.COLUMN_STATUS,
                ModuleCContract.ModuleC.COLUMN_SYNCED,
                ModuleCContract.ModuleC.COLUMN_SYNCED_DATE,
                ModuleCContract.ModuleC.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleCContract.ModuleC.COLUMN_SYNCED + " is null or " + ModuleCContract.ModuleC.COLUMN_SYNCED + " ='')  AND " + ModuleCContract.ModuleC.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleCContract.ModuleC.COLUMN_ID + " ASC";

        Collection<ModuleCContract> allFC = new ArrayList<ModuleCContract>();
        try {
            c = db.query(
                    ModuleCContract.ModuleC.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleCContract tsc = new ModuleCContract();
                allFC.add(tsc.hydrate(c));
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


    public Collection<ModuleGContract> getUnsyncedModuleG() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleGContract.ModuleG._ID,
                ModuleGContract.ModuleG.COLUMN_UID,
                ModuleGContract.ModuleG.COLUMN_UUID,
                ModuleGContract.ModuleG.COLUMN_FORMDATE,
                ModuleGContract.ModuleG.COLUMN_SERIALNO,
                ModuleGContract.ModuleG.COLUMN_DISTRICT_CODE,
                ModuleGContract.ModuleG.COLUMN_TEHSIL_CODE,
                ModuleGContract.ModuleG.COLUMN_UC_CODE,
                ModuleGContract.ModuleG.COLUMN_HF_CODE,
                ModuleGContract.ModuleG.COLUMN_SG,
                ModuleGContract.ModuleG.COLUMN_DEVICEID,
                ModuleGContract.ModuleG.COLUMN_DEVICETAGID,
                ModuleGContract.ModuleG.COLUMN_STATUS,
                ModuleGContract.ModuleG.COLUMN_SYNCED,
                ModuleGContract.ModuleG.COLUMN_SYNCED_DATE,
                ModuleGContract.ModuleG.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleGContract.ModuleG.COLUMN_SYNCED + " is null or " + ModuleGContract.ModuleG.COLUMN_SYNCED + " ='')  AND " + ModuleGContract.ModuleG.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleGContract.ModuleG.COLUMN_ID + " ASC";

        Collection<ModuleGContract> allMGC = new ArrayList<ModuleGContract>();
        try {
            c = db.query(
                    ModuleGContract.ModuleG.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleGContract modg = new ModuleGContract();
                allMGC.add(modg.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMGC;
    }


    public Collection<ModuleHContract> getUnsyncedModuleH() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleHContract.ModuleH._ID,
                ModuleHContract.ModuleH.COLUMN_UID,
                ModuleHContract.ModuleH.COLUMN_UUID,
                ModuleHContract.ModuleH.COLUMN_FORMDATE,
                ModuleHContract.ModuleH.COLUMN_SERIALNO,
                ModuleHContract.ModuleH.COLUMN_DISTRICT_CODE,
                ModuleHContract.ModuleH.COLUMN_TEHSIL_CODE,
                ModuleHContract.ModuleH.COLUMN_UC_CODE,
                ModuleHContract.ModuleH.COLUMN_HF_CODE,
                ModuleHContract.ModuleH.COLUMN_SH,
                ModuleHContract.ModuleH.COLUMN_DEVICEID,
                ModuleHContract.ModuleH.COLUMN_DEVICETAGID,
                ModuleHContract.ModuleH.COLUMN_STATUS,
                ModuleHContract.ModuleH.COLUMN_SYNCED,
                ModuleHContract.ModuleH.COLUMN_SYNCED_DATE,
                ModuleHContract.ModuleH.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleHContract.ModuleH.COLUMN_SYNCED + " is null or " + ModuleHContract.ModuleH.COLUMN_SYNCED + " ='')  AND " + ModuleHContract.ModuleH.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleHContract.ModuleH.COLUMN_ID + " ASC";

        Collection<ModuleHContract> allMHC = new ArrayList<ModuleHContract>();
        try {
            c = db.query(
                    ModuleHContract.ModuleH.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleHContract modh = new ModuleHContract();
                allMHC.add(modh.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMHC;
    }


    public Collection<ModuleIContract> getUnsyncedModuleI() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleIContract.ModuleI._ID,
                ModuleIContract.ModuleI.COLUMN_UID,
                ModuleIContract.ModuleI.COLUMN_UUID,
                ModuleIContract.ModuleI.COLUMN_FORMDATE,
                ModuleIContract.ModuleI.COLUMN_SERIALNO,
                ModuleIContract.ModuleI.COLUMN_DISTRICT_CODE,
                ModuleIContract.ModuleI.COLUMN_TEHSIL_CODE,
                ModuleIContract.ModuleI.COLUMN_UC_CODE,
                ModuleIContract.ModuleI.COLUMN_HF_CODE,
                ModuleIContract.ModuleI.COLUMN_SI1,
                ModuleIContract.ModuleI.COLUMN_SI2,
                ModuleIContract.ModuleI.COLUMN_SI3,
                ModuleIContract.ModuleI.COLUMN_SI4,
                ModuleIContract.ModuleI.COLUMN_DEVICEID,
                ModuleIContract.ModuleI.COLUMN_DEVICETAGID,
                ModuleIContract.ModuleI.COLUMN_STATUS,
                ModuleIContract.ModuleI.COLUMN_SYNCED,
                ModuleIContract.ModuleI.COLUMN_SYNCED_DATE,
                ModuleIContract.ModuleI.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleIContract.ModuleI.COLUMN_SYNCED + " is null or " + ModuleIContract.ModuleI.COLUMN_SYNCED + " ='')  AND " + ModuleIContract.ModuleI.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleIContract.ModuleI.COLUMN_ID + " ASC";

        Collection<ModuleIContract> allFC = new ArrayList<ModuleIContract>();
        try {
            c = db.query(
                    ModuleIContract.ModuleI.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleIContract psc = new ModuleIContract();
                allFC.add(psc.hydrate(c));
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


    public Collection<ModuleJContract> getUnsyncedModuleJ() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleJContract.ModuleJ._ID,
                ModuleJContract.ModuleJ.COLUMN_UID,
                ModuleJContract.ModuleJ.COLUMN_UUID,
                ModuleJContract.ModuleJ.COLUMN_FORMDATE,
                ModuleJContract.ModuleJ.COLUMN_SERIALNO,
                ModuleJContract.ModuleJ.COLUMN_DISTRICT_CODE,
                ModuleJContract.ModuleJ.COLUMN_TEHSIL_CODE,
                ModuleJContract.ModuleJ.COLUMN_UC_CODE,
                ModuleJContract.ModuleJ.COLUMN_HF_CODE,
                ModuleJContract.ModuleJ.COLUMN_SJ,
                ModuleJContract.ModuleJ.COLUMN_DEVICEID,
                ModuleJContract.ModuleJ.COLUMN_DEVICETAGID,
                ModuleJContract.ModuleJ.COLUMN_STATUS,
                ModuleJContract.ModuleJ.COLUMN_SYNCED,
                ModuleJContract.ModuleJ.COLUMN_SYNCED_DATE,
                ModuleJContract.ModuleJ.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleJContract.ModuleJ.COLUMN_SYNCED + " is null or " + ModuleJContract.ModuleJ.COLUMN_SYNCED + " ='')  AND " + ModuleJContract.ModuleJ.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleJContract.ModuleJ.COLUMN_ID + " ASC";

        Collection<ModuleJContract> allMJC = new ArrayList<ModuleJContract>();
        try {
            c = db.query(
                    ModuleJContract.ModuleJ.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleJContract modj = new ModuleJContract();
                allMJC.add(modj.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMJC;
    }


    public Collection<ModuleKContract> getUnsyncedModuleK() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ModuleKContract.ModuleK._ID,
                ModuleKContract.ModuleK.COLUMN_UID,
                ModuleKContract.ModuleK.COLUMN_UUID,
                ModuleKContract.ModuleK.COLUMN_FORMDATE,
                ModuleKContract.ModuleK.COLUMN_SERIALNO,
                ModuleKContract.ModuleK.COLUMN_DISTRICT_CODE,
                ModuleKContract.ModuleK.COLUMN_TEHSIL_CODE,
                ModuleKContract.ModuleK.COLUMN_UC_CODE,
                ModuleKContract.ModuleK.COLUMN_HF_CODE,
                ModuleKContract.ModuleK.COLUMN_SK,
                ModuleKContract.ModuleK.COLUMN_DEVICEID,
                ModuleKContract.ModuleK.COLUMN_DEVICETAGID,
                ModuleKContract.ModuleK.COLUMN_STATUS,
                ModuleKContract.ModuleK.COLUMN_SYNCED,
                ModuleKContract.ModuleK.COLUMN_SYNCED_DATE,
                ModuleKContract.ModuleK.COLUMN_APPVERSION,
        };

        String whereClause = "(" + ModuleKContract.ModuleK.COLUMN_SYNCED + " is null or " + ModuleKContract.ModuleK.COLUMN_SYNCED + " ='')  AND " + ModuleKContract.ModuleK.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                ModuleKContract.ModuleK.COLUMN_ID + " ASC";

        Collection<ModuleKContract> allMKC = new ArrayList<ModuleKContract>();
        try {
            c = db.query(
                    ModuleKContract.ModuleK.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ModuleKContract modk = new ModuleKContract();
                allMKC.add(modk.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allMKC;
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
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
/*
                fc.setA3(c.getString(c.getColumnIndex(FormsTable.COLUMN_A3)));
*/
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
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


    public Collection<FormsContract> getHfs() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_A12,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_A12 + " Like ? ";
        String[] whereArgs = new String[]{/*"%" + spDateT.substring(0, 8).trim() + "%"*/};
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
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable.COLUMN_ID)));
/*
                fc.setA12(c.getString(c.getColumnIndex(FormsTable.COLUMN_A12)));
*/
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
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

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.getIstatus88x());
//        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());
//        values.put(FormsTable.COLUMN_STATUS, MainApp.fc.getStatus());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.getEndingdatetime());


// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

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
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MCColumn
    public int updatesMCColumn(ModuleCContract modc, String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleCContract.ModuleC._ID + " =? ";
        String[] selectionArgs = {String.valueOf(modc.get_ID())};

        return db.update(ModuleCContract.ModuleC.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MGColumn
    public int updatesMGColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleGContract.ModuleG._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.modg.get_ID())};

        return db.update(ModuleGContract.ModuleG.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MHColumn
    public int updatesMHColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleHContract.ModuleH._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.modh.get_ID())};

        return db.update(ModuleHContract.ModuleH.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MIColumn
    public int updatesMIColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleIContract.ModuleI._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.modi.get_ID())};

        return db.update(ModuleIContract.ModuleI.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MJColumn
    public int updatesMJColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleJContract.ModuleJ._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.modj.get_ID())};

        return db.update(ModuleJContract.ModuleJ.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update MKColumn
    public int updatesMKColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = ModuleKContract.ModuleK._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.modk.get_ID())};

        return db.update(ModuleKContract.ModuleK.TABLE_NAME,
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