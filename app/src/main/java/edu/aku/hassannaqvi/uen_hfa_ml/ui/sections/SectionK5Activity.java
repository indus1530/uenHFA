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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK5Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionK5Activity extends AppCompatActivity {

    ActivitySectionK5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k5);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

        bi.k0051.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.llk0051);
        }));

        bi.k0053.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.cvk0054);
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
            finish();
            startActivity(new Intent(this, SectionK6Activity.class));
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

        json.put("k0051", bi.k0051a.isChecked() ? "1"
                : bi.k0051b.isChecked() ? "2"
                : "-1");

        json.put("k0052", bi.k0052a.isChecked() ? "1"
                : bi.k0052b.isChecked() ? "2"
                : bi.k0052c.isChecked() ? "3"
                : bi.k0052d.isChecked() ? "4"
                : "-1");

        json.put("k0053", bi.k0053a.isChecked() ? "1"
                : bi.k0053b.isChecked() ? "2"
                : "-1");

        json.put("k0054", bi.k0054a.isChecked() ? "1"
                : bi.k0054b.isChecked() ? "2"
                : "-1");

        json.put("k0055", bi.k0055a.isChecked() ? "1"
                : bi.k0055b.isChecked() ? "2"
                : bi.k0055c.isChecked() ? "3"
                : bi.k0055d.isChecked() ? "4"
                : bi.k0055e.isChecked() ? "5"
                : "-1");

        json.put("k0056", bi.k0056a.isChecked() ? "1"
                : bi.k0056b.isChecked() ? "2"
                : bi.k0056c.isChecked() ? "3"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsK()), json);

            MainApp.fc.setsK(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "K");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


}
