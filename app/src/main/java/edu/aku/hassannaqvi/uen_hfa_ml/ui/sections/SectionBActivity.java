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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionBActivity extends AppCompatActivity {

    ActivitySectionBBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.a18.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i != bi.a18b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVa19);
            }
        }));

        /*bi.b01.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.b01b.getId()) {
                Clear.clearAllFields(bi.fldGrpS01);
            }
        }));*/

        bi.b02.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.b02b.getId()) {
                Clear.clearAllFields(bi.fldGrpS01);
            }
        }));

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            startActivity(new Intent(this, SectionMainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SA, fc.getsA());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("a14", bi.a14a.isChecked() ? "1"
                : bi.a14b.isChecked() ? "2"
                : "-1");

        json.put("a15", bi.a15a.isChecked() ? "1"
                : bi.a15b.isChecked() ? "2"
                : "-1");

        json.put("a16", bi.a16.getText().toString().trim().isEmpty() ? "-1" : bi.a16.getText().toString());

        json.put("a17", bi.a17a.isChecked() ? "1"
                : bi.a17b.isChecked() ? "2"
                : bi.a17c.isChecked() ? "3"
                : bi.a17d.isChecked() ? "4"
                : bi.a17e.isChecked() ? "5"
                : bi.a17f.isChecked() ? "6"
                : bi.a17g.isChecked() ? "7"
                : bi.a17h.isChecked() ? "8"
                : bi.a17i.isChecked() ? "9"
                : bi.a17j.isChecked() ? "10"
                : "-1");

        json.put("a18", bi.a18a.isChecked() ? "1"
                : bi.a18b.isChecked() ? "2"
                : bi.a18c.isChecked() ? "3"
                : bi.a18d.isChecked() ? "4"
                : bi.a18x.isChecked() ? "96"
                : "-1");
        json.put("a18xx", bi.a18xx.getText().toString().trim().isEmpty() ? "-1" : bi.a18xx.getText().toString());

        json.put("a19", bi.a19a.isChecked() ? "1"
                : bi.a19b.isChecked() ? "2"
                : bi.a19c.isChecked() ? "3"
                : bi.a19d.isChecked() ? "4"
                : bi.a19e.isChecked() ? "5"
                : bi.a19f.isChecked() ? "6"
                : bi.a19g.isChecked() ? "7"
                : bi.a19x.isChecked() ? "96"
                : "-1");
        json.put("a19xx", bi.a19xx.getText().toString().trim().isEmpty() ? "-1" : bi.a19xx.getText().toString());

        json.put("a20", bi.a20a.isChecked() ? "1"
                : bi.a20b.isChecked() ? "2"
                : "-1");

        json.put("a21", bi.a21.getText().toString().trim().isEmpty() ? "-1" : bi.a21.getText().toString());

        json.put("a22", bi.a22a.isChecked() ? "1"
                : bi.a22b.isChecked() ? "2"
                : bi.a22c.isChecked() ? "3"
                : bi.a22d.isChecked() ? "4"
                : bi.a22e.isChecked() ? "5"
                : "-1");

        json.put("b01", bi.b01a.isChecked() ? "1"
                : bi.b01b.isChecked() ? "2"
                : "-1");

        json.put("b02", bi.b02a.isChecked() ? "1"
                : bi.b02b.isChecked() ? "2"
                : "-1");

        json.put("b03", bi.b03.getText().toString().trim().isEmpty() ? "-1" : bi.b03.getText().toString());

        json.put("b04", bi.b04.getText().toString().trim().isEmpty() ? "-1" : bi.b04.getText().toString());

        json.put("b05", bi.b05.getText().toString().trim().isEmpty() ? "-1" : bi.b05.getText().toString());

        MainApp.fc.setsA(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

}
