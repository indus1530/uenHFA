package edu.aku.hassannaqvi.uen_hfa_ml.utils;

import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.TalukasContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UsersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.VersionAppContract;

public final class CreateTable {

    public static final String DATABASE_NAME = "uen_hfa_ml.db";
    public static final String DB_NAME = "uen_hfa_ml_copy.db";
    public static final String PROJECT_NAME = "UEN_HFA_ML2020";
    public static final int DATABASE_VERSION = 1;

    public static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsContract.FormsTable.TABLE_NAME + "("
            + FormsContract.FormsTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsContract.FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_UID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A1 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A3 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A4 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A5 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A6 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A7 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A8 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A9 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A10 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A11 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A12 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_A13 + " TEXT,"
            + FormsContract.FormsTable.COLUMN_APPVERSION + " TEXT,"
            + FormsContract.FormsTable.COLUMN_LUID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SA + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SB + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SD + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SF + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SH + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SI + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SJ + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ISTATUS88x + " TEXT,"
            + FormsContract.FormsTable.COLUMN_ENDINGDATETIME + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLAT + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSLNG + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSDATE + " TEXT,"
            + FormsContract.FormsTable.COLUMN_GPSACC + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICEID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_DEVICETAGID + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED + " TEXT,"
            + FormsContract.FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.singleUser.TABLE_NAME + "("
            + UsersContract.singleUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersContract.singleUser.ROW_USERNAME + " TEXT,"
            + UsersContract.singleUser.ROW_PASSWORD + " TEXT,"
            + UsersContract.singleUser.DIST_ID + " TEXT"
            + " );";

    public static final String SQL_CREATE_VERSIONAPP = "CREATE TABLE " + VersionAppContract.VersionAppTable.TABLE_NAME + " (" +
            VersionAppContract.VersionAppTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_CODE + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_VERSION_NAME + " TEXT, " +
            VersionAppContract.VersionAppTable.COLUMN_PATH_NAME + " TEXT " +
            ");";
    public static final String SQL_CREATE_TALUKAS = "CREATE TABLE " + TalukasContract.singleTalukas.TABLE_NAME + "("
            + TalukasContract.singleTalukas._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA_CODE + " TEXT,"
            + TalukasContract.singleTalukas.COLUMN_TALUKA + " TEXT );";


    public static final String SQL_CREATE_UCS = "CREATE TABLE " + UCsContract.singleUCs.TABLE_NAME + "("
            + UCsContract.singleUCs._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UCsContract.singleUCs.COLUMN_UCCODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_TALUKA_CODE + " TEXT,"
            + UCsContract.singleUCs.COLUMN_UCS + " TEXT );";

}
