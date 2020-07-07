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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.PatientsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.StaffingContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.TehsilsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.VersionAppContract;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_ALTER_FORMS01;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_ALTER_FORMS02;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_DISTRICTS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_FORMS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_HF;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_PSCONTRACT;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_TEHSILS;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.CreateTable.SQL_CREATE_TSCONTRACT;
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
        db.execSQL(SQL_CREATE_TSCONTRACT);
        db.execSQL(SQL_CREATE_PSCONTRACT);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_DISTRICTS);
        db.execSQL(SQL_CREATE_TEHSILS);
        db.execSQL(SQL_CREATE_UCS);
        db.execSQL(SQL_CREATE_HF);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        switch (i) {
            case 1:
                db.execSQL(SQL_ALTER_FORMS01);
                db.execSQL(SQL_ALTER_FORMS02);
        }
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
        values.put(FormsTable.COLUMN_SG, fc.getsG());
        values.put(FormsTable.COLUMN_SH, fc.getsH());
        values.put(FormsTable.COLUMN_SI, fc.getsI());
        values.put(FormsTable.COLUMN_SJ, fc.getsJ());
        values.put(FormsTable.COLUMN_SK, fc.getsK());
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


    public Long addTSC(StaffingContract tsc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(StaffingContract.StaffingTable.COLUMN_UID, tsc.get_UID());
        values.put(StaffingContract.StaffingTable.COLUMN_UUID, tsc.get_UUID());
        values.put(StaffingContract.StaffingTable.COLUMN_FORMDATE, tsc.getFormDate());
        values.put(StaffingContract.StaffingTable.COLUMN_SERIALNO, tsc.getSerialno());
        values.put(StaffingContract.StaffingTable.COLUMN_DISTRICT_CODE, tsc.getDistrictCode());
        values.put(StaffingContract.StaffingTable.COLUMN_TEHSIL_CODE, tsc.getTehsilCode());
        values.put(StaffingContract.StaffingTable.COLUMN_UC_CODE, tsc.getUcCode());
        values.put(StaffingContract.StaffingTable.COLUMN_HF_CODE, tsc.getHfCode());
        values.put(StaffingContract.StaffingTable.COLUMN_SC2, tsc.getsC2());
        values.put(StaffingContract.StaffingTable.COLUMN_DEVICEID, tsc.getDeviceID());
        values.put(StaffingContract.StaffingTable.COLUMN_DEVICETAGID, tsc.getDevicetagID());
        values.put(StaffingContract.StaffingTable.COLUMN_STATUS, tsc.getStatus());
        values.put(StaffingContract.StaffingTable.COLUMN_SYNCED, tsc.getSynced());
        values.put(StaffingContract.StaffingTable.COLUMN_SYNCED_DATE, tsc.getSynced_date());
        values.put(StaffingContract.StaffingTable.COLUMN_APPVERSION, tsc.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                StaffingContract.StaffingTable.TABLE_NAME,
                StaffingContract.StaffingTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addPSC(PatientsContract psc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(PatientsContract.PatientsTable.COLUMN_UID, psc.get_UID());
        values.put(PatientsContract.PatientsTable.COLUMN_UUID, psc.get_UUID());
        values.put(PatientsContract.PatientsTable.COLUMN_FORMDATE, psc.getFormDate());
        values.put(PatientsContract.PatientsTable.COLUMN_SERIALNO, psc.getSerialno());
        values.put(PatientsContract.PatientsTable.COLUMN_DISTRICT_CODE, psc.getDistrictCode());
        values.put(PatientsContract.PatientsTable.COLUMN_TEHSIL_CODE, psc.getTehsilCode());
        values.put(PatientsContract.PatientsTable.COLUMN_UC_CODE, psc.getUcCode());
        values.put(PatientsContract.PatientsTable.COLUMN_HF_CODE, psc.getHfCode());
        values.put(PatientsContract.PatientsTable.COLUMN_SI1, psc.getsI1());
        values.put(PatientsContract.PatientsTable.COLUMN_SI2, psc.getsI2());
        values.put(PatientsContract.PatientsTable.COLUMN_SI3, psc.getsI3());
        values.put(PatientsContract.PatientsTable.COLUMN_SI4, psc.getsI4());
        values.put(PatientsContract.PatientsTable.COLUMN_DEVICEID, psc.getDeviceID());
        values.put(PatientsContract.PatientsTable.COLUMN_DEVICETAGID, psc.getDevicetagID());
        values.put(PatientsContract.PatientsTable.COLUMN_STATUS, psc.getStatus());
        values.put(PatientsContract.PatientsTable.COLUMN_SYNCED, psc.getSynced());
        values.put(PatientsContract.PatientsTable.COLUMN_SYNCED_DATE, psc.getSynced_date());
        values.put(PatientsContract.PatientsTable.COLUMN_APPVERSION, psc.getAppversion());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                PatientsContract.PatientsTable.TABLE_NAME,
                PatientsContract.PatientsTable.COLUMN_NAME_NULLABLE,
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


    public void updateSyncedForms02(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED_02, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE_02, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedForms03(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED_03, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE_03, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedC2Section(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(StaffingContract.StaffingTable.COLUMN_SYNCED, true);
        values.put(StaffingContract.StaffingTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = StaffingContract.StaffingTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                StaffingContract.StaffingTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedISection(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(PatientsContract.PatientsTable.COLUMN_SYNCED, true);
        values.put(PatientsContract.PatientsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = PatientsContract.PatientsTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                PatientsContract.PatientsTable.TABLE_NAME,
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
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
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
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
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


    public Collection<FormsContract> getUnsyncedForms(int formType) {
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
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_SH,
                FormsTable.COLUMN_SI,
                FormsTable.COLUMN_SJ,
                FormsTable.COLUMN_SK,
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

        String whereClause;
        switch (formType) {
            case 1:
                whereClause = FormsTable.COLUMN_SYNCED + " is null AND " + FormsTable.COLUMN_ISTATUS + "=?";
                break;
            case 2:
                whereClause = FormsTable.COLUMN_SYNCED_02 + " is null AND " + FormsTable.COLUMN_ISTATUS + "=?";
                break;
            case 3:
                whereClause = FormsTable.COLUMN_SYNCED_03 + " is null AND " + FormsTable.COLUMN_ISTATUS + "=?";
                break;
            default:
                whereClause = "(" + FormsTable.COLUMN_SYNCED + " is null or " + FormsTable.COLUMN_SYNCED_02 + " is null or " + FormsTable.COLUMN_SYNCED_03 + " is null) AND " + FormsTable.COLUMN_ISTATUS + "=?";

        }
//        String whereClause = "(" + FormsTable.COLUMN_SYNCED + " is null or " + FormsTable.COLUMN_SYNCED_02 + " is null) " + " AND FormsTable.COLUMN_ISTATUS =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_ID + " ASC";

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


    public Collection<StaffingContract> getUnsyncedStaffing() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                StaffingContract.StaffingTable._ID,
                StaffingContract.StaffingTable.COLUMN_UID,
                StaffingContract.StaffingTable.COLUMN_UUID,
                StaffingContract.StaffingTable.COLUMN_FORMDATE,
                StaffingContract.StaffingTable.COLUMN_SERIALNO,
                StaffingContract.StaffingTable.COLUMN_DISTRICT_CODE,
                StaffingContract.StaffingTable.COLUMN_TEHSIL_CODE,
                StaffingContract.StaffingTable.COLUMN_UC_CODE,
                StaffingContract.StaffingTable.COLUMN_HF_CODE,
                StaffingContract.StaffingTable.COLUMN_SC2,
                StaffingContract.StaffingTable.COLUMN_DEVICEID,
                StaffingContract.StaffingTable.COLUMN_DEVICETAGID,
                StaffingContract.StaffingTable.COLUMN_STATUS,
                StaffingContract.StaffingTable.COLUMN_SYNCED,
                StaffingContract.StaffingTable.COLUMN_SYNCED_DATE,
                StaffingContract.StaffingTable.COLUMN_APPVERSION,
        };

        String whereClause = "(" + StaffingContract.StaffingTable.COLUMN_SYNCED + " is null or " + StaffingContract.StaffingTable.COLUMN_SYNCED + " ='')  AND " + StaffingContract.StaffingTable.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                StaffingContract.StaffingTable.COLUMN_ID + " ASC";

        Collection<StaffingContract> allFC = new ArrayList<StaffingContract>();
        try {
            c = db.query(
                    StaffingContract.StaffingTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                StaffingContract tsc = new StaffingContract();
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


    public Collection<PatientsContract> getUnsyncedPatients() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                PatientsContract.PatientsTable._ID,
                PatientsContract.PatientsTable.COLUMN_UID,
                PatientsContract.PatientsTable.COLUMN_UUID,
                PatientsContract.PatientsTable.COLUMN_FORMDATE,
                PatientsContract.PatientsTable.COLUMN_SERIALNO,
                PatientsContract.PatientsTable.COLUMN_DISTRICT_CODE,
                PatientsContract.PatientsTable.COLUMN_TEHSIL_CODE,
                PatientsContract.PatientsTable.COLUMN_UC_CODE,
                PatientsContract.PatientsTable.COLUMN_HF_CODE,
                PatientsContract.PatientsTable.COLUMN_SI1,
                PatientsContract.PatientsTable.COLUMN_SI2,
                PatientsContract.PatientsTable.COLUMN_SI3,
                PatientsContract.PatientsTable.COLUMN_SI4,
                PatientsContract.PatientsTable.COLUMN_DEVICEID,
                PatientsContract.PatientsTable.COLUMN_DEVICETAGID,
                PatientsContract.PatientsTable.COLUMN_STATUS,
                PatientsContract.PatientsTable.COLUMN_SYNCED,
                PatientsContract.PatientsTable.COLUMN_SYNCED_DATE,
                PatientsContract.PatientsTable.COLUMN_APPVERSION,
        };

        String whereClause = "(" + PatientsContract.PatientsTable.COLUMN_SYNCED + " is null or " + PatientsContract.PatientsTable.COLUMN_SYNCED + " ='')  AND " + PatientsContract.PatientsTable.COLUMN_STATUS + " =?";

        String[] whereArgs = new String[]{"1"};

        String groupBy = null;
        String having = null;

        String orderBy =
                PatientsContract.PatientsTable.COLUMN_ID + " ASC";

        Collection<PatientsContract> allFC = new ArrayList<PatientsContract>();
        try {
            c = db.query(
                    PatientsContract.PatientsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                PatientsContract psc = new PatientsContract();
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


    //Generic update TSCColumn
    public int updatesTSCColumn(StaffingContract tsc, String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = StaffingContract.StaffingTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(tsc.get_ID())};

        return db.update(StaffingContract.StaffingTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    //Generic update PSCColumn
    public int updatesPSCColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = PatientsContract.PatientsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.psc.get_ID())};

        return db.update(PatientsContract.PatientsTable.TABLE_NAME,
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