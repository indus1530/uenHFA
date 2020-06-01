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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE32Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE32Activity extends AppCompatActivity {

    ActivitySectionE32Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e32);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupSkips();
    }

    private void setupSkips() {

        bi.e0306a0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306a0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306a0f);
            }
        }));

        bi.e0306b0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306b0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306b0f);
            }
        }));

        bi.e0306c0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306c0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306c0f);
            }
        }));

        bi.e0306d0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306d0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306d0f);
            }
        }));

        bi.e0306e0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306e0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306e0f);
            }
        }));

        bi.e0306f0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306f0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306f0f);
            }
        }));

        bi.e0306g0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306g0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306g0f);
            }
        }));

        bi.e0306h0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306h0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306h0f);
            }
        }));

        bi.e0306i0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306i0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306i0f);
            }
        }));

        bi.e0306j0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306j0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306j0f);
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


        json.put("e0306a0a", bi.e0306a0ay.isChecked() ? "1"
                : bi.e0306a0an.isChecked() ? "2"
                : "-1");
        json.put("e0306a0ayx", bi.e0306a0ayx.getText().toString());

        json.put("e0306a0f", bi.e0306a0fy.isChecked() ? "1"
                : bi.e0306a0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306a0fyx", bi.e0306a0fyx.getText().toString());

        json.put("e0306b0a", bi.e0306b0ay.isChecked() ? "1"
                : bi.e0306b0an.isChecked() ? "2"
                : "-1");
        json.put("e0306b0ayx", bi.e0306b0ayx.getText().toString());

        json.put("e0306b0f", bi.e0306b0fy.isChecked() ? "1"
                : bi.e0306b0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306b0fyx", bi.e0306b0fyx.getText().toString());

        json.put("e0306c0a", bi.e0306c0ay.isChecked() ? "1"
                : bi.e0306c0an.isChecked() ? "2"
                : "-1");
        json.put("e0306c0ayx", bi.e0306c0ayx.getText().toString());

        json.put("e0306c0f", bi.e0306c0fy.isChecked() ? "1"
                : bi.e0306c0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306c0fyx", bi.e0306c0fyx.getText().toString());

        json.put("e0306d0a", bi.e0306d0ay.isChecked() ? "1"
                : bi.e0306d0an.isChecked() ? "2"
                : "-1");
        json.put("e0306d0ayx", bi.e0306d0ayx.getText().toString());

        json.put("e0306d0f", bi.e0306d0fy.isChecked() ? "1"
                : bi.e0306d0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306d0fyx", bi.e0306d0fyx.getText().toString());

        json.put("e0306e0a", bi.e0306e0ay.isChecked() ? "1"
                : bi.e0306e0an.isChecked() ? "2"
                : "-1");
        json.put("e0306e0ayx", bi.e0306e0ayx.getText().toString());

        json.put("e0306e0f", bi.e0306e0fy.isChecked() ? "1"
                : bi.e0306e0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306e0fyx", bi.e0306e0fyx.getText().toString());

        json.put("e0306f0a", bi.e0306f0ay.isChecked() ? "1"
                : bi.e0306f0an.isChecked() ? "2"
                : "-1");
        json.put("e0306f0ayx", bi.e0306f0ayx.getText().toString());

        json.put("e0306f0f", bi.e0306f0fy.isChecked() ? "1"
                : bi.e0306f0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306f0fyx", bi.e0306f0fyx.getText().toString());

        json.put("e0306g0a", bi.e0306g0ay.isChecked() ? "1"
                : bi.e0306g0an.isChecked() ? "2"
                : "-1");
        json.put("e0306g0ayx", bi.e0306g0ayx.getText().toString());

        json.put("e0306g0f", bi.e0306g0fy.isChecked() ? "1"
                : bi.e0306g0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306g0fyx", bi.e0306g0fyx.getText().toString());

        json.put("e0306h0a", bi.e0306h0ay.isChecked() ? "1"
                : bi.e0306h0an.isChecked() ? "2"
                : "-1");
        json.put("e0306h0ayx", bi.e0306h0ayx.getText().toString());

        json.put("e0306h0f", bi.e0306h0fy.isChecked() ? "1"
                : bi.e0306h0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306h0fyx", bi.e0306h0fyx.getText().toString());

        json.put("e0306i0a", bi.e0306i0ay.isChecked() ? "1"
                : bi.e0306i0an.isChecked() ? "2"
                : "-1");
        json.put("e0306i0ayx", bi.e0306i0ayx.getText().toString());

        json.put("e0306i0f", bi.e0306i0fy.isChecked() ? "1"
                : bi.e0306i0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306i0fyx", bi.e0306i0fyx.getText().toString());

        json.put("e0306j0a", bi.e0306j0ay.isChecked() ? "1"
                : bi.e0306j0an.isChecked() ? "2"
                : "-1");
        json.put("e0306j0ayx", bi.e0306j0ayx.getText().toString());

        json.put("e0306j0f", bi.e0306j0fy.isChecked() ? "1"
                : bi.e0306j0fn.isChecked() ? "2"
                : "-1");
        json.put("e0306j0fyx", bi.e0306j0fyx.getText().toString());


        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsE()), json);

            MainApp.fc.setsE(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
                startActivity(new Intent(this, SectionE33Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
