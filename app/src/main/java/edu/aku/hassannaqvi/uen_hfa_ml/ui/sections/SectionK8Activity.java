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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK8Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

public class SectionK8Activity extends AppCompatActivity {

    ActivitySectionK8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k8);
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
            startActivity(new Intent(this, SectionK9Activity.class));
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

        json.put("k0801a", bi.k0801aa.isChecked() ? "11"
                : bi.k0801ab.isChecked() ? "12"
                : bi.k0801ac.isChecked() ? "13"
                : "-1");

        json.put("k0801b", bi.k0801ba.isChecked() ? "21"
                : bi.k0801bb.isChecked() ? "22"
                : bi.k0801bc.isChecked() ? "23"
                : "-1");


        json.put("k0802a", bi.k0802aa.isChecked() ? "11"
                : bi.k0802ab.isChecked() ? "12"
                : bi.k0802ac.isChecked() ? "13"
                : "-1");

        json.put("k0802b", bi.k0802ba.isChecked() ? "21"
                : bi.k0802bb.isChecked() ? "22"
                : bi.k0802bc.isChecked() ? "23"
                : "-1");


        json.put("k0803a", bi.k0803aa.isChecked() ? "11"
                : bi.k0803ab.isChecked() ? "12"
                : bi.k0803ac.isChecked() ? "13"
                : "-1");

        json.put("k0803b", bi.k0803ba.isChecked() ? "21"
                : bi.k0803bb.isChecked() ? "22"
                : bi.k0803bc.isChecked() ? "23"
                : "-1");


        json.put("k0804a", bi.k0804aa.isChecked() ? "11"
                : bi.k0804ab.isChecked() ? "12"
                : bi.k0804ac.isChecked() ? "13"
                : "-1");

        json.put("k0804b", bi.k0804ba.isChecked() ? "21"
                : bi.k0804bb.isChecked() ? "22"
                : bi.k0804bc.isChecked() ? "23"
                : "-1");


        json.put("k0805a", bi.k0805aa.isChecked() ? "11"
                : bi.k0805ab.isChecked() ? "12"
                : bi.k0805ac.isChecked() ? "13"
                : "-1");

        json.put("k0805b", bi.k0805ba.isChecked() ? "21"
                : bi.k0805bb.isChecked() ? "22"
                : bi.k0805bc.isChecked() ? "23"
                : "-1");


        json.put("k0806a", bi.k0806aa.isChecked() ? "11"
                : bi.k0806ab.isChecked() ? "12"
                : bi.k0806ac.isChecked() ? "13"
                : "-1");

        json.put("k0806b", bi.k0806ba.isChecked() ? "21"
                : bi.k0806bb.isChecked() ? "22"
                : bi.k0806bc.isChecked() ? "23"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK8);
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
