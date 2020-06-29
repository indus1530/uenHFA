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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK9Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

public class SectionK9Activity extends AppCompatActivity {

    ActivitySectionK9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k9);
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
            startActivity(new Intent(this, SectionK10Activity.class));
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

        json.put("k0901a", bi.k0901aa.isChecked() ? "11"
                : bi.k0901ab.isChecked() ? "12"
                : bi.k0901ac.isChecked() ? "13"
                : "-1");

        json.put("k0901b", bi.k0901ba.isChecked() ? "21"
                : bi.k0901bb.isChecked() ? "22"
                : bi.k0901bc.isChecked() ? "23"
                : bi.k0901c.isChecked() ? "3"
                : "-1");


        json.put("k0902a", bi.k0902aa.isChecked() ? "11"
                : bi.k0902ab.isChecked() ? "12"
                : bi.k0902ac.isChecked() ? "13"
                : "-1");

        json.put("k0902b", bi.k0902ba.isChecked() ? "21"
                : bi.k0902bb.isChecked() ? "22"
                : bi.k0902bc.isChecked() ? "23"
                : bi.k0902c.isChecked() ? "3"
                : "-1");


        json.put("k0903a", bi.k0903aa.isChecked() ? "11"
                : bi.k0903ab.isChecked() ? "12"
                : bi.k0903ac.isChecked() ? "13"
                : "-1");

        json.put("k0903b", bi.k0903ba.isChecked() ? "21"
                : bi.k0903bb.isChecked() ? "22"
                : bi.k0903bc.isChecked() ? "23"
                : bi.k0903c.isChecked() ? "3"
                : "-1");


        json.put("k0904a", bi.k0904aa.isChecked() ? "11"
                : bi.k0904ab.isChecked() ? "12"
                : bi.k0904ac.isChecked() ? "13"
                : "-1");

        json.put("k0904b", bi.k0904ba.isChecked() ? "21"
                : bi.k0904bb.isChecked() ? "22"
                : bi.k0904bc.isChecked() ? "23"
                : bi.k0904c.isChecked() ? "3"
                : "-1");


        json.put("k0905a", bi.k0905aa.isChecked() ? "11"
                : bi.k0905ab.isChecked() ? "12"
                : bi.k0905ac.isChecked() ? "13"
                : "-1");

        json.put("k0905b", bi.k0905ba.isChecked() ? "21"
                : bi.k0905bb.isChecked() ? "22"
                : bi.k0905bc.isChecked() ? "23"
                : bi.k0905c.isChecked() ? "3"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK9);
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
