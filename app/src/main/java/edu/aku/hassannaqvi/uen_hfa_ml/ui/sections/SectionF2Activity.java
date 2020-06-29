package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionF2Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionF2Activity extends AppCompatActivity {

    ActivitySectionF2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f2);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.f0201.setOnCheckedChangeListener((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSecf201);
        });

        bi.f0201aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0201aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0201aaa0f);
            }
        });

        bi.f0201aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0201aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0201aab0f);
            }
        });

        bi.f0202.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0202b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf202);
            }
        });

        bi.f0202aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0202aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0202aaa0f);
            }
        });

        bi.f0202aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0202aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0202aab0f);
            }
        });

        bi.f0203.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0203b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf202);
            }
        });

        bi.f0203aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0203aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0203aaa0f);
            }
        });

        bi.f0203aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0203aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0203aab0f);
            }
        });

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SF, fc.getsF());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("f0201", bi.f0201a.isChecked() ? "1"
                : bi.f0201b.isChecked() ? "2"
                : "-1");


        json.put("f0201aaa0a", bi.f0201aaa0ay.isChecked() ? "1"
                : bi.f0201aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0201aaa0ayx", bi.f0201aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0201aaa0ayx.getText().toString());


        json.put("f0201aaa0f", bi.f0201aaa0fy.isChecked() ? "1"
                : bi.f0201aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0201aaa0fyx", bi.f0201aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0201aaa0fyx.getText().toString());


        json.put("f0201aab0a", bi.f0201aab0ay.isChecked() ? "1"
                : bi.f0201aab0an.isChecked() ? "2"
                : "-1");
        json.put("f0201aab0ayx", bi.f0201aab0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0201aab0ayx.getText().toString());


        json.put("f0201aab0f", bi.f0201aab0fy.isChecked() ? "1"
                : bi.f0201aab0fn.isChecked() ? "2"
                : "-1");
        json.put("f0201aab0fyx", bi.f0201aab0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0201aab0fyx.getText().toString());


        json.put("f0202", bi.f0202a.isChecked() ? "1"
                : bi.f0202b.isChecked() ? "2"
                : "-1");

        json.put("f0202aaa0a", bi.f0202aaa0ay.isChecked() ? "1"
                : bi.f0202aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0202aaa0ayx", bi.f0202aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0202aaa0ayx.getText().toString());

        json.put("f0202aaa0f", bi.f0202aaa0fy.isChecked() ? "1"
                : bi.f0202aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0202aaa0fyx", bi.f0202aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0202aaa0fyx.getText().toString());

        json.put("f0202aab0a", bi.f0202aab0ay.isChecked() ? "1"
                : bi.f0202aab0an.isChecked() ? "2"
                : "-1");
        json.put("f0202aab0ayx", bi.f0202aab0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0202aab0ayx.getText().toString());

        json.put("f0202aab0f", bi.f0202aab0fy.isChecked() ? "1"
                : bi.f0202aab0fn.isChecked() ? "2"
                : "-1");
        json.put("f0202aab0fyx", bi.f0202aab0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0202aab0fyx.getText().toString());

        json.put("f0203", bi.f0203a.isChecked() ? "1"
                : bi.f0203b.isChecked() ? "2"
                : "-1");


        json.put("f0203aaa0a", bi.f0203aaa0ay.isChecked() ? "1"
                : bi.f0203aaa0an.isChecked() ? "2"
                : "-1");
        json.put("f0203aaa0ayx", bi.f0203aaa0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0203aaa0ayx.getText().toString());

        json.put("f0203aaa0f", bi.f0203aaa0fy.isChecked() ? "1"
                : bi.f0203aaa0fn.isChecked() ? "2"
                : "-1");
        json.put("f0203aaa0fyx", bi.f0203aaa0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0203aaa0fyx.getText().toString());

        json.put("f0203aab0a", bi.f0203aab0ay.isChecked() ? "1"
                : bi.f0203aab0an.isChecked() ? "2"
                : "-1");
        json.put("f0203aab0ayx", bi.f0203aab0ayx.getText().toString().trim().isEmpty() ? "-1" : bi.f0203aab0ayx.getText().toString());

        json.put("f0203aab0f", bi.f0203aab0fy.isChecked() ? "1"
                : bi.f0203aab0fn.isChecked() ? "2"
                : "-1");
        json.put("f0203aab0fyx", bi.f0203aab0fyx.getText().toString().trim().isEmpty() ? "-1" : bi.f0203aab0fyx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsF()), json);

            MainApp.fc.setsF(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
            startActivity(new Intent(this, SectionF3Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        finish();
        startActivity(new Intent(this, SectionMainActivity.class));
        //openEndActivity(this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
