package edu.aku.hassannaqvi.uen_hfa_ml.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class DistrictContract {

    private static final String TAG = "District_CONTRACT";
    String districtCode;
    String districtName;

    public DistrictContract() {
        // Default Constructor
    }

    public DistrictContract Sync(JSONObject jsonObject) throws JSONException {
        this.districtCode = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_NAME);
        return this;
    }

    public DistrictContract HydrateDistrict(Cursor cursor) {
        this.districtCode = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_NAME));
        return this;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleDistrict.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(singleDistrict.COLUMN_DISTRICT_NAME, this.districtName == null ? JSONObject.NULL : this.districtName);
        return json;
    }


    public static abstract class singleDistrict implements BaseColumns {

        public static final String TABLE_NAME = "districts";
        public static final String COLUMN_DISTRICT_CODE = "district_code";
        public static final String COLUMN_DISTRICT_NAME = "district_name";

        public static final String _URI = "districts.php";
    }
}