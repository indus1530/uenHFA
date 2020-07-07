package edu.aku.hassannaqvi.uen_hfa_ml.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class PatientsContract {


    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String serialno = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String districtCode = "";
    private String tehsilCode = "";
    private String ucCode = "";
    private String hfCode = "";
    private String status = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String sI1;
    private String sI2;
    private String sI3;
    private String sI4;


    public PatientsContract() {
    }


    public PatientsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(PatientsTable.COLUMN_ID);
        this._UID = jsonObject.getString(PatientsTable.COLUMN_UID);
        this._UUID = jsonObject.getString(PatientsTable.COLUMN_UUID);
        this.formDate = jsonObject.getString(PatientsTable.COLUMN_FORMDATE);
        this.serialno = jsonObject.getString(PatientsTable.COLUMN_SERIALNO);
        this.districtCode = jsonObject.getString(PatientsTable.COLUMN_DISTRICT_CODE);
        this.tehsilCode = jsonObject.getString(PatientsTable.COLUMN_TEHSIL_CODE);
        this.ucCode = jsonObject.getString(PatientsTable.COLUMN_UC_CODE);
        this.hfCode = jsonObject.getString(PatientsTable.COLUMN_HF_CODE);
        this.sI1 = jsonObject.getString(PatientsTable.COLUMN_SI1);
        this.sI2 = jsonObject.getString(PatientsTable.COLUMN_SI2);
        this.sI3 = jsonObject.getString(PatientsTable.COLUMN_SI3);
        this.sI4 = jsonObject.getString(PatientsTable.COLUMN_SI4);
        this.deviceID = jsonObject.getString(PatientsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(PatientsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(PatientsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(PatientsTable.COLUMN_SYNCED_DATE);
        this.status = jsonObject.getString(PatientsTable.COLUMN_STATUS);
        this.appversion = jsonObject.getString(PatientsTable.COLUMN_APPVERSION);

        return this;

    }


    public PatientsContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_FORMDATE));
        this.serialno = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SERIALNO));
        this.districtCode = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_DISTRICT_CODE));
        this.tehsilCode = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_TEHSIL_CODE));
        this.ucCode = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_UC_CODE));
        this.hfCode = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_HF_CODE));
        this.sI1 = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SI1));
        this.sI2 = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SI2));
        this.sI3 = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SI3));
        this.sI4 = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SI4));
        this.deviceID = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_SYNCED_DATE));
        this.status = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_STATUS));
        this.appversion = cursor.getString(cursor.getColumnIndex(PatientsTable.COLUMN_APPVERSION));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(PatientsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(PatientsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(PatientsTable.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(PatientsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(PatientsTable.COLUMN_SERIALNO, this.serialno == null ? JSONObject.NULL : this.serialno);
        json.put(PatientsTable.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(PatientsTable.COLUMN_TEHSIL_CODE, this.tehsilCode == null ? JSONObject.NULL : this.tehsilCode);
        json.put(PatientsTable.COLUMN_UC_CODE, this.ucCode == null ? JSONObject.NULL : this.ucCode);
        json.put(PatientsTable.COLUMN_HF_CODE, this.hfCode == null ? JSONObject.NULL : this.hfCode);

        if (this.sI1 != null && !this.sI1.equals("")) {
            json.put(PatientsTable.COLUMN_SI1, new JSONObject(this.sI1));
        }

        if (this.sI2 != null && !this.sI2.equals("")) {
            json.put(PatientsTable.COLUMN_SI2, new JSONObject(this.sI2));
        }

        if (this.sI3 != null && !this.sI3.equals("")) {
            json.put(PatientsTable.COLUMN_SI3, new JSONObject(this.sI3));
        }

        if (this.sI4 != null && !this.sI4.equals("")) {
            json.put(PatientsTable.COLUMN_SI4, new JSONObject(this.sI4));
        }

        json.put(PatientsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(PatientsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(PatientsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(PatientsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(PatientsTable.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
        json.put(PatientsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
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


    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }


    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }


    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }


    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }


    public String getTehsilCode() {
        return tehsilCode;
    }

    public void setTehsilCode(String tehsilCode) {
        this.tehsilCode = tehsilCode;
    }


    public String getUcCode() {
        return ucCode;
    }

    public void setUcCode(String ucCode) {
        this.ucCode = ucCode;
    }


    public String getHfCode() {
        return hfCode;
    }

    public void setHfCode(String hfCode) {
        this.hfCode = hfCode;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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


    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }


    public String getsI1() {
        return sI1;
    }

    public void setsI1(String sI1) {
        this.sI1 = sI1;
    }


    public String getsI2() {
        return sI2;
    }

    public void setsI2(String sI2) {
        this.sI2 = sI2;
    }


    public String getsI3() {
        return sI3;
    }

    public void setsI3(String sI3) {
        this.sI3 = sI3;
    }


    public String getsI4() {
        return sI4;
    }

    public void setsI4(String sI4) {
        this.sI4 = sI4;
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


    public static abstract class PatientsTable implements BaseColumns {

        public static final String TABLE_NAME = "patients";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_SERIALNO = "serialno";
        public static final String COLUMN_DISTRICT_CODE = "districtCode";
        public static final String COLUMN_TEHSIL_CODE = "tehsilCode";
        public static final String COLUMN_UC_CODE = "ucCode";
        public static final String COLUMN_HF_CODE = "hfCode";
        public static final String COLUMN_SI1 = "sI1";
        public static final String COLUMN_SI2 = "sI2";
        public static final String COLUMN_SI3 = "sI3";
        public static final String COLUMN_SI4 = "sI4";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";


        public static String _URL = "sync.php";
    }
}
