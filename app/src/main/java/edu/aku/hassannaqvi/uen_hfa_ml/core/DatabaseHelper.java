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

        Cursor mCursor = db.rawQuery("SELECT * FROM " + FormsTable.TABLE_NAME + " WHERE " + FormsTable.COLUMN_A12 + "=? AND " + FormsTable.COLUMN_ISTATUS + "=1", new String[]{hfCode});
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
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
       /* values.put(FormsTable.COLUMN_UID, fc.UID());
        values.put(FormsTable.COLUMN_A1, fc.A1());
        values.put(FormsTable.COLUMN_A3, fc.A3());
        values.put(FormsTable.COLUMN_A4, fc.A4());
        values.put(FormsTable.COLUMN_A5, fc.A5());
        values.put(FormsTable.COLUMN_A6, fc.A6());
        values.put(FormsTable.COLUMN_A7, fc.A7());
        values.put(FormsTable.COLUMN_A8, fc.A8());
        values.put(FormsTable.COLUMN_A9, fc.A9());
        values.put(FormsTable.COLUMN_A10, fc.A10());
        values.put(FormsTable.COLUMN_A11, fc.A11());
        values.put(FormsTable.COLUMN_A12, fc.A12());
        values.put(FormsTable.COLUMN_A13, fc.A13());
        values.put(FormsTable.COLUMN_LUID, fc.Luid());*/
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


    public FormsContract isDataExists(String studyId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = null;

// New value for one column
        String[] columns = {
                FormsTable.COLUMN_LUID,
                FormsTable.COLUMN_ISTATUS,

        };

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN_LUID + " = ? AND "
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
                allFC.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_LUID)));
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
                FormsTable.COLUMN_A1,
                FormsTable.COLUMN_A3,
                FormsTable.COLUMN_A4,
                FormsTable.COLUMN_A5,
                FormsTable.COLUMN_A6,
                FormsTable.COLUMN_A7,
                FormsTable.COLUMN_A8,
                FormsTable.COLUMN_A9,
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
                FormsTable.COLUMN_A1,
                FormsTable.COLUMN_A3,
                FormsTable.COLUMN_A4,
                FormsTable.COLUMN_A5,
                FormsTable.COLUMN_A6,
                FormsTable.COLUMN_A7,
                FormsTable.COLUMN_A8,
                FormsTable.COLUMN_A9,
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
                FormsTable.COLUMN_A1,
                FormsTable.COLUMN_A3,
                FormsTable.COLUMN_A4,
                FormsTable.COLUMN_A5,
                FormsTable.COLUMN_A6,
                FormsTable.COLUMN_A7,
                FormsTable.COLUMN_A8,
                FormsTable.COLUMN_A9,
                FormsTable.COLUMN_A10,
                FormsTable.COLUMN_A11,
                FormsTable.COLUMN_A12,
                FormsTable.COLUMN_A13,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88x,
                FormsTable.COLUMN_LUID,
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
                FormsTable.COLUMN_LUID,
                FormsTable.COLUMN_A3,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_A3 + " Like ? ";
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
                fc.setLuid(c.getString(c.getColumnIndex(FormsTable.COLUMN_LUID)));
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