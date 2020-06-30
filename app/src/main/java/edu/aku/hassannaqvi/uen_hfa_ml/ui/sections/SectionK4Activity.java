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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK4Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionK4Activity extends AppCompatActivity {

    ActivitySectionK4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k4);
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
            startActivity(new Intent(this, SectionK5Activity.class));
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

        json.put("k0401", bi.k0401a.isChecked() ? "1"
                : bi.k0401b.isChecked() ? "2"
                : bi.k0401c.isChecked() ? "3"
                : bi.k0401d.isChecked() ? "4"
                : bi.k0401e.isChecked() ? "5"
                : bi.k0401f.isChecked() ? "6"
                : bi.k0401g.isChecked() ? "7"
                : "-1");

        json.put("k0402", bi.k0402a.isChecked() ? "1"
                : bi.k0402b.isChecked() ? "2"
                : "-1");

        json.put("k0403", bi.k0403a.isChecked() ? "1"
                : bi.k0403b.isChecked() ? "2"
                : "-1");

        json.put("k0404", bi.k0404a.isChecked() ? "1"
                : bi.k0404b.isChecked() ? "2"
                : bi.k0404c.isChecked() ? "3"
                : "-1");

        json.put("k0405", bi.k0405a.isChecked() ? "1"
                : bi.k0405b.isChecked() ? "2"
                : bi.k0405c.isChecked() ? "3"
                : bi.k0405d.isChecked() ? "4"
                : "-1");

        json.put("k0406", bi.k0406a.isChecked() ? "1"
                : bi.k0406b.isChecked() ? "2"
                : bi.k0406c.isChecked() ? "3"
                : bi.k0406d.isChecked() ? "4"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK4);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
