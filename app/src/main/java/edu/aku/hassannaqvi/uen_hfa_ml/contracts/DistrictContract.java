package edu.aku.hassannaqvi.uen_hfa_ml.contracts;


import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class DistrictContract {

    private static final String TAG = "District_CONTRACT";
    String districtCode;
    String district;

    public DistrictContract() {
        // Default Constructor
    }

    public DistrictContract Sync(JSONObject jsonObject) throws JSONException {
        this.districtCode = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_CODE);
        this.district = jsonObject.getString(singleDistrict.COLUMN_DISTRICT);
        return this;
    }

    public DistrictContract HydrateDistrict(Cursor cursor) {
        this.districtCode = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_CODE));
        this.district = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT));
        return this;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();
        json.put(singleDistrict.COLUMN_DISTRICT_CODE, this.districtCode == null ? JSONObject.NULL : this.districtCode);
        json.put(singleDistrict.COLUMN_DISTRICT, this.district == null ? JSONObject.NULL : this.district);
        return json;
    }


    public static abstract class singleDistrict implements BaseColumns {

        public static final String TABLE_NAME = "district";
        public static final String COLUMN_DISTRICT_CODE = "district_code";
        public static final String COLUMN_DISTRICT = "district_name";

        public static final String _URI = "district.php";
    }
}