package edu.aku.hassannaqvi.uen_hfa_ml.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.uen_hfa_ml";
    public static final String PATH_FORMS = "forms";
    private final String projectName = "UEN_HFA_ML2020";
    private String _ID = "";
    private String _UID = "";
    private String a1 = ""; // Interviewer
    private String a3 = ""; // Date
    private String a4 = ""; // gpsLat
    private String a5 = ""; // gpsLng
    private String a6 = ""; // Province
    private String a7 = ""; // District
    private String a8 = ""; // Tehsil
    private String a9 = ""; // Union Council
    private String a10 = ""; // HF Type
    private String a12 = ""; // DHIS Code
    private String a13 = ""; // HF Name
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String luid = "";
    private String endingdatetime = "";
    private String gpsLat = ""; // gpsLat
    private String gpsLng = ""; // gpsLng
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String sA = "";
    private String sB = "";
    private String sC = "";
    private String sD = "";
    private String sE = "";
    private String sF = "";
    private String sG = "";
    private String sH = "";
    private String sI = "";
    private String sJ = "";

    public FormsContract() {
    }

    public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }


    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }


    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }


    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }


    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }


    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }


    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }


    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }


    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }
    

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.a1 = jsonObject.getString(FormsTable.COLUMN_A1);
        this.a3 = jsonObject.getString(FormsTable.COLUMN_A3);
        this.a4 = jsonObject.getString(FormsTable.COLUMN_A4);
        this.a5 = jsonObject.getString(FormsTable.COLUMN_A5);
        this.a6 = jsonObject.getString(FormsTable.COLUMN_A6);
        this.a7 = jsonObject.getString(FormsTable.COLUMN_A7);
        this.a8 = jsonObject.getString(FormsTable.COLUMN_A8);
        this.a9 = jsonObject.getString(FormsTable.COLUMN_A9);
        this.a10 = jsonObject.getString(FormsTable.COLUMN_A10);
        this.a12 = jsonObject.getString(FormsTable.COLUMN_A12);
        this.a13 = jsonObject.getString(FormsTable.COLUMN_A13);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88x);
        this.luid = jsonObject.getString(FormsTable.COLUMN_LUID);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.sA = jsonObject.getString(FormsTable.COLUMN_SA);
        this.sB = jsonObject.getString(FormsTable.COLUMN_SB);
        this.sC = jsonObject.getString(FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sF = jsonObject.getString(FormsTable.COLUMN_SF);
        this.sG = jsonObject.getString(FormsTable.COLUMN_SG);
        this.sH = jsonObject.getString(FormsTable.COLUMN_SH);
        this.sI = jsonObject.getString(FormsTable.COLUMN_SI);
        this.sJ = jsonObject.getString(FormsTable.COLUMN_SJ);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.a1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A1));
        this.a3 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A3));
        this.a4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A4));
        this.a5 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A5));
        this.a6 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A6));
        this.a7 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A7));
        this.a8 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A8));
        this.a9 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A9));
        this.a10 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A10));
        this.a12 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A12));
        this.a13 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A13));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88x));
        this.luid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_LUID));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
        this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SJ));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_A1, this.a1 == null ? JSONObject.NULL : this.a1);
        json.put(FormsTable.COLUMN_A3, this.a3 == null ? JSONObject.NULL : this.a3);
        json.put(FormsTable.COLUMN_A4, this.a4 == null ? JSONObject.NULL : this.a4);
        json.put(FormsTable.COLUMN_A5, this.a5 == null ? JSONObject.NULL : this.a5);
        json.put(FormsTable.COLUMN_A6, this.a6 == null ? JSONObject.NULL : this.a6);
        json.put(FormsTable.COLUMN_A7, this.a7 == null ? JSONObject.NULL : this.a7);
        json.put(FormsTable.COLUMN_A8, this.a8 == null ? JSONObject.NULL : this.a8);
        json.put(FormsTable.COLUMN_A9, this.a9 == null ? JSONObject.NULL : this.a9);
        json.put(FormsTable.COLUMN_A10, this.a10 == null ? JSONObject.NULL : this.a10);
        json.put(FormsTable.COLUMN_A12, this.a12 == null ? JSONObject.NULL : this.a12);
        json.put(FormsTable.COLUMN_A13, this.a13 == null ? JSONObject.NULL : this.a13);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_LUID, this.luid == null ? JSONObject.NULL : this.luid);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);

        if (!this.sA.equals("")) {
            json.put(FormsTable.COLUMN_SA, this.sA.equals("") ? JSONObject.NULL : new JSONObject(this.sA));
        }

        if (!this.sB.equals("")) {
            json.put(FormsTable.COLUMN_SB, this.sB.equals("") ? JSONObject.NULL : new JSONObject(this.sB));
        }

        if (!this.sC.equals("")) {
            json.put(FormsTable.COLUMN_SC, this.sC.equals("") ? JSONObject.NULL : new JSONObject(this.sC));
        }

        if (!this.sD.equals("")) {
            json.put(FormsTable.COLUMN_SD, this.sD.equals("") ? JSONObject.NULL : new JSONObject(this.sD));
        }

        if (!this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
        }

        if (!this.sF.equals("")) {
            json.put(FormsTable.COLUMN_SF, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sF));
        }

        if (!this.sG.equals("")) {
            json.put(FormsTable.COLUMN_SG, this.sG.equals("") ? JSONObject.NULL : new JSONObject(this.sG));
        }

        if (!this.sH.equals("")) {
            json.put(FormsTable.COLUMN_SH, this.sH.equals("") ? JSONObject.NULL : new JSONObject(this.sH));
        }

        if (!this.sI.equals("")) {
            json.put(FormsTable.COLUMN_SI, this.sI.equals("") ? JSONObject.NULL : new JSONObject(this.sI));
        }

        if (!this.sJ.equals("")) {
            json.put(FormsTable.COLUMN_SJ, this.sJ.equals("") ? JSONObject.NULL : new JSONObject(this.sJ));
        }

        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }


    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }


    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }


    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }


    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }


    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }


    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }


    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }


    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }


    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }


    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }


    public String getA13() {
        return a13;
    }

    public void setA13(String a13) {
        this.a13 = a13;
    }
    

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String Study_Id) {
        this.luid = Study_Id;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }


    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_A1 = "a1";
        public static final String COLUMN_A3 = "a3";
        public static final String COLUMN_A4 = "a4";
        public static final String COLUMN_A5 = "a5";
        public static final String COLUMN_A6 = "a6";
        public static final String COLUMN_A7 = "a7";
        public static final String COLUMN_A8 = "a8";
        public static final String COLUMN_A9 = "a9";
        public static final String COLUMN_A10 = "a10";
        public static final String COLUMN_A12 = "a12";
        public static final String COLUMN_A13 = "a13";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";
        public static final String COLUMN_LUID = "_luid";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_SB = "sB";
        public static final String COLUMN_SC = "sC";
        public static final String COLUMN_SD = "sD";
        public static final String COLUMN_SE = "sE";
        public static final String COLUMN_SF = "sF";
        public static final String COLUMN_SG = "sG";
        public static final String COLUMN_SH = "sH";
        public static final String COLUMN_SI = "sI";
        public static final String COLUMN_SJ = "sJ";

        public static String _URL = "sync.php";
    }
}
