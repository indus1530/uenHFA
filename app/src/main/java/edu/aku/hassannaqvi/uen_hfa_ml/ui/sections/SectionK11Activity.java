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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK11Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK11Activity extends AppCompatActivity {

    ActivitySectionK11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k11);
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

        json.put("k1101", bi.k1101a.isChecked() ? "1"
                : bi.k1101b.isChecked() ? "2"
                : "-1");

        json.put("k1102", bi.k1102a.isChecked() ? "1"
                : bi.k1102b.isChecked() ? "2"
                : "-1");

        json.put("k1103", bi.k1103a.isChecked() ? "1"
                : bi.k1103b.isChecked() ? "2"
                : "-1");

        json.put("k1104", bi.k1104a.isChecked() ? "1"
                : bi.k1104b.isChecked() ? "2"
                : "-1");

        json.put("k1105", bi.k1105a.isChecked() ? "1"
                : bi.k1105b.isChecked() ? "2"
                : "-1");

        json.put("k1106", bi.k1106a.isChecked() ? "1"
                : bi.k1106b.isChecked() ? "2"
                : "-1");

        json.put("k1107", bi.k1107a.isChecked() ? "1"
                : bi.k1107b.isChecked() ? "2"
                : "-1");

        json.put("k1108", bi.k1108a.isChecked() ? "1"
                : bi.k1108b.isChecked() ? "2"
                : "-1");

        json.put("k1109", bi.k1109a.isChecked() ? "1"
                : bi.k1109b.isChecked() ? "2"
                : "-1");

        json.put("k1110", bi.k1110a.isChecked() ? "1"
                : bi.k1110b.isChecked() ? "2"
                : "-1");

        json.put("k1111", bi.k1111a.isChecked() ? "1"
                : bi.k1111b.isChecked() ? "2"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK11);
    }


    public void BtnEnd() {
        finish();
        startActivity(new Intent(this, SectionMainActivity.class));
        openEndActivity(this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
