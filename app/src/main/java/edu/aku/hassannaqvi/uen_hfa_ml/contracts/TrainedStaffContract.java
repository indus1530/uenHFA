package edu.aku.hassannaqvi.uen_hfa_ml.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class TrainedStaffContract {


    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String serialno = "";
    private String deviceID = "";
    private String status = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    private String devicetagID = "";
    private String districtID = "";
    private String tehsilID = "";
    private String ucID = "";
    private String hfID = "";
    private String sC2;


    public TrainedStaffContract() {
    }


    public TrainedStaffContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(SingleTSC.COLUMN_ID);
        this._UID = jsonObject.getString(SingleTSC.COLUMN_UID);
        this._UUID = jsonObject.getString(SingleTSC.COLUMN_UUID);
        this.formDate = jsonObject.getString(SingleTSC.COLUMN_FORMDATE);
        this.serialno = jsonObject.getString(SingleTSC.COLUMN_SERIALNO);
        this.districtID = jsonObject.getString(SingleTSC.COLUMN_DISTRICTID);
        this.tehsilID = jsonObject.getString(SingleTSC.COLUMN_TEHSILID);
        this.ucID = jsonObject.getString(SingleTSC.COLUMN_UCID);
        this.hfID = jsonObject.getString(SingleTSC.COLUMN_HFID);
        this.sC2 = jsonObject.getString(SingleTSC.COLUMN_SC2);
        this.deviceID = jsonObject.getString(SingleTSC.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(SingleTSC.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(SingleTSC.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(SingleTSC.COLUMN_SYNCED_DATE);
        this.status = jsonObject.getString(SingleTSC.COLUMN_STATUS);
        this.appversion = jsonObject.getString(SingleTSC.COLUMN_APPVERSION);

        return this;

    }


    public TrainedStaffContract hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_FORMDATE));
        this.serialno = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_SERIALNO));
        this.districtID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_DISTRICTID));
        this.tehsilID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_TEHSILID));
        this.ucID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_UCID));
        this.hfID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_HFID));
        this.sC2 = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_SC2));
        this.deviceID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_SYNCED_DATE));
        this.status = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_STATUS));
        this.appversion = cursor.getString(cursor.getColumnIndex(SingleTSC.COLUMN_APPVERSION));

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(SingleTSC.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(SingleTSC.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(SingleTSC.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(SingleTSC.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(SingleTSC.COLUMN_SERIALNO, this.serialno == null ? JSONObject.NULL : this.serialno);
        json.put(SingleTSC.COLUMN_DISTRICTID, this.districtID == null ? JSONObject.NULL : this.districtID);
        json.put(SingleTSC.COLUMN_TEHSILID, this.tehsilID == null ? JSONObject.NULL : this.tehsilID);
        json.put(SingleTSC.COLUMN_UCID, this.ucID == null ? JSONObject.NULL : this.ucID);
        json.put(SingleTSC.COLUMN_HFID, this.hfID == null ? JSONObject.NULL : this.hfID);
        json.put(SingleTSC.COLUMN_SC2, this.sC2 == null ? JSONObject.NULL : this.sC2);
        json.put(SingleTSC.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(SingleTSC.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(SingleTSC.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(SingleTSC.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(SingleTSC.COLUMN_STATUS, this.status == null ? JSONObject.NULL : this.status);
        json.put(SingleTSC.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

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


    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }


    public String getTehsilID() {
        return tehsilID;
    }

    public void setTehsilID(String tehsilID) {
        this.tehsilID = tehsilID;
    }


    public String getUcID() {
        return ucID;
    }

    public void setUcID(String ucID) {
        this.ucID = ucID;
    }


    public String getHfID() {
        return hfID;
    }

    public void setHfID(String hfID) {
        this.hfID = hfID;
    }


    public String getsC2() {
        return sC2;
    }

    public void setsC2(String sC2) {
        this.sC2 = sC2;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static abstract class SingleTSC implements BaseColumns {

        public static final String TABLE_NAME = "C2SECTION";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_SERIALNO = "serialno";
        public static final String COLUMN_DISTRICTID = "districtID";
        public static final String COLUMN_TEHSILID = "tehsilID";
        public static final String COLUMN_UCID = "ucID";
        public static final String COLUMN_HFID = "hfID";
        public static final String COLUMN_SC2 = "sC2";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";


        public static String _URL = "sync.php";
    }
}
