package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK10Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionK10Activity extends AppCompatActivity {

    ActivitySectionK10Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k10);
        bi.setCallback(this);

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionK11Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k1001", bi.k1001a.isChecked() ? "1"
                : bi.k1001b.isChecked() ? "2"
                : bi.k1001c.isChecked() ? "3"
                : "-1");

        json.put("k1002", bi.k1002a.isChecked() ? "1"
                : bi.k1002b.isChecked() ? "2"
                : bi.k1002c.isChecked() ? "3"
                : "-1");

        json.put("k1003", bi.k1003a.isChecked() ? "1"
                : bi.k1003b.isChecked() ? "2"
                : bi.k1003c.isChecked() ? "3"
                : "-1");

        json.put("k1004", bi.k1004a.isChecked() ? "1"
                : bi.k1004b.isChecked() ? "2"
                : bi.k1004c.isChecked() ? "3"
                : "-1");

        json.put("k1005", bi.k1005a.isChecked() ? "1"
                : bi.k1005b.isChecked() ? "2"
                : bi.k1005c.isChecked() ? "3"
                : "-1");

        json.put("k1006", bi.k1006a.isChecked() ? "1"
                : bi.k1006b.isChecked() ? "2"
                : bi.k1006c.isChecked() ? "3"
                : "-1");

        json.put("k1007", bi.k1007a.isChecked() ? "1"
                : bi.k1007b.isChecked() ? "2"
                : bi.k1007c.isChecked() ? "3"
                : "-1");

        json.put("k1008", bi.k1008a.isChecked() ? "1"
                : bi.k1008b.isChecked() ? "2"
                : bi.k1008c.isChecked() ? "3"
                : "-1");

        json.put("k1009", bi.k1009a.isChecked() ? "1"
                : bi.k1009b.isChecked() ? "2"
                : bi.k1009c.isChecked() ? "3"
                : "-1");

        json.put("k1010", bi.k1010a.isChecked() ? "1"
                : bi.k1010b.isChecked() ? "2"
                : bi.k1010c.isChecked() ? "3"
                : "-1");

        json.put("k1011", bi.k1011a.isChecked() ? "1"
                : bi.k1011b.isChecked() ? "2"
                : bi.k1011c.isChecked() ? "3"
                : "-1");

        json.put("k1012", bi.k1012a.isChecked() ? "1"
                : bi.k1012b.isChecked() ? "2"
                : bi.k1012c.isChecked() ? "3"
                : "-1");

        json.put("k1013", bi.k1013a.isChecked() ? "1"
                : bi.k1013b.isChecked() ? "2"
                : bi.k1013c.isChecked() ? "3"
                : "-1");

        json.put("k1014", bi.k1014a.isChecked() ? "1"
                : bi.k1014b.isChecked() ? "2"
                : bi.k1014c.isChecked() ? "3"
                : "-1");

        json.put("k1015", bi.k1015a.isChecked() ? "1"
                : bi.k1015b.isChecked() ? "2"
                : bi.k1015c.isChecked() ? "3"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK10);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
