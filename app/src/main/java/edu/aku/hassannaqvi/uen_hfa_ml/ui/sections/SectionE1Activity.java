package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE1Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionE1Activity extends AppCompatActivity {

    ActivitySectionE1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0101.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0101b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece101);
            }

        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0101", bi.e0101a.isChecked() ? "1"
                : bi.e0101b.isChecked() ? "2"
                : "-1");

        //json.put("e0102", "-1");

        json.put("e0102a", bi.e0102aa.isChecked() ? "1"
                : bi.e0102ab.isChecked() ? "2"
                : "-1");

        json.put("e0102b", bi.e0102ba.isChecked() ? "1"
                : bi.e0102bb.isChecked() ? "2"
                : "-1");

        json.put("e0102c", bi.e0102ca.isChecked() ? "1"
                : bi.e0102cb.isChecked() ? "2"
                : "-1");

        json.put("e0102d", bi.e0102da.isChecked() ? "1"
                : bi.e0102db.isChecked() ? "2"
                : "-1");

        json.put("e0102e", bi.e0102ea.isChecked() ? "1"
                : bi.e0102eb.isChecked() ? "2"
                : "-1");

        json.put("e0102f", bi.e0102fa.isChecked() ? "1"
                : bi.e0102fb.isChecked() ? "2"
                : "-1");

        json.put("e0102g", bi.e0102ga.isChecked() ? "1"
                : bi.e0102gb.isChecked() ? "2"
                : "-1");

        json.put("e0102h", bi.e0102ha.isChecked() ? "1"
                : bi.e0102hb.isChecked() ? "2"
                : "-1");

        json.put("e0102i", bi.e0102ia.isChecked() ? "1"
                : bi.e0102ib.isChecked() ? "2"
                : "-1");

        json.put("e0102j", bi.e0102ja.isChecked() ? "1"
                : bi.e0102jb.isChecked() ? "2"
                : "-1");

        //json.put("e0103", "-1");

        json.put("e0103a", bi.e0103aa.isChecked() ? "1"
                : bi.e0103ab.isChecked() ? "2"
                : bi.e0103ac.isChecked() ? "3"
                : "-1");

        json.put("e0103b", bi.e0103ba.isChecked() ? "1"
                : bi.e0103bb.isChecked() ? "2"
                : bi.e0103bc.isChecked() ? "3"
                : "-1");

        //json.put("e0104", "-1");

        json.put("e0104a", bi.e0104aa.isChecked() ? "1"
                : bi.e0104ab.isChecked() ? "2"
                : "-1");

        json.put("e0104b", bi.e0104ba.isChecked() ? "1"
                : bi.e0104bb.isChecked() ? "2"
                : "-1");

        json.put("e0104c", bi.e0104c.getText().toString().trim().length() > 0 ? bi.e0104c.getText().toString() : "-1");

        json.put("e0104d", bi.e0104da.isChecked() ? "1"
                : bi.e0104db.isChecked() ? "2"
                : bi.e0104dc.isChecked() ? "3"
                : bi.e0104dd.isChecked() ? "4"
                : "-1");

        json.put("e0104e", bi.e0104ea.isChecked() ? "1"
                : bi.e0104ex.isChecked() ? "2"
                : "-1");
        json.put("e0104exx", bi.e0104exx.getText().toString().trim().length() > 0 ? bi.e0104exx.getText().toString() : "-1");

        MainApp.fc.setsE(String.valueOf(json));

    }



    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionE2Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

}
