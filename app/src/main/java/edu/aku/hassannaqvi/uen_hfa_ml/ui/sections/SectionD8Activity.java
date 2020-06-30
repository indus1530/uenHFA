package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionD8Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionD8Activity extends AppCompatActivity {

    ActivitySectionD8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d8);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        /*bi.d0801a0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801a0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801a0fq);
            }
        }));

        bi.d0801b0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801b0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801b0fq);
            }
        }));

        bi.d0801c0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801c0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801c0fq);
            }
        }));

        bi.d0801d0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801d0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801d0fq);
            }
        }));

        bi.d0801e0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801e0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801e0fq);
            }
        }));

        bi.d0801f0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801f0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801f0fq);
            }
        }));

        bi.d0801g0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801g0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801g0fq);
            }
        }));

        bi.d0801h0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801h0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801h0fq);
            }
        }));

        bi.d0801i0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801i0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801i0fq);
            }
        }));

        bi.d0801j0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.d0801j0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVd0801j0fq);
            }
        }));*/

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SD, fc.getsD());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d0801a0a", bi.d0801a0ay.isChecked() ? "1"
                : bi.d0801a0an.isChecked() ? "2"
                : "-1");
        json.put("d0801a0fq", bi.d0801a0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801a0fq.getText().toString());


        json.put("d0801b0a", bi.d0801b0ay.isChecked() ? "1"
                : bi.d0801b0an.isChecked() ? "2"
                : "-1");
        json.put("d0801b0fq", bi.d0801b0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801b0fq.getText().toString());


        json.put("d0801c0a", bi.d0801c0ay.isChecked() ? "1"
                : bi.d0801c0an.isChecked() ? "2"
                : "-1");
        json.put("d0801c0fq", bi.d0801c0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801c0fq.getText().toString());


        json.put("d0801d0a", bi.d0801d0ay.isChecked() ? "1"
                : bi.d0801d0an.isChecked() ? "2"
                : "-1");
        json.put("d0801d0fq", bi.d0801d0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801d0fq.getText().toString());


        json.put("d0801e0a", bi.d0801e0ay.isChecked() ? "1"
                : bi.d0801e0an.isChecked() ? "2"
                : "-1");
        json.put("d0801e0fq", bi.d0801e0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801e0fq.getText().toString());


        json.put("d0801f0a", bi.d0801f0ay.isChecked() ? "1"
                : bi.d0801f0an.isChecked() ? "2"
                : "-1");
        json.put("d0801f0fq", bi.d0801f0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801f0fq.getText().toString());


        json.put("d0801g0a", bi.d0801g0ay.isChecked() ? "1"
                : bi.d0801g0an.isChecked() ? "2"
                : "-1");
        json.put("d0801g0fq", bi.d0801g0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801g0fq.getText().toString());


        json.put("d0801h0a", bi.d0801h0ay.isChecked() ? "1"
                : bi.d0801h0an.isChecked() ? "2"
                : "-1");
        json.put("d0801h0fq", bi.d0801h0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801h0fq.getText().toString());


        json.put("d0801i0a", bi.d0801i0ay.isChecked() ? "1"
                : bi.d0801i0an.isChecked() ? "2"
                : "-1");
        json.put("d0801i0fq", bi.d0801i0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801i0fq.getText().toString());


        json.put("d0801j0a", bi.d0801j0ay.isChecked() ? "1"
                : bi.d0801j0an.isChecked() ? "2"
                : "-1");
        json.put("d0801j0fq", bi.d0801j0fq.getText().toString().trim().isEmpty() ? "-1" : bi.d0801j0fq.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsD()), json);

            fc.setsD(String.valueOf(json_merge));

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
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "D");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }


    public void showTooltip(@NotNull View view) {
        if (view.getId() != View.NO_ID) {
            String package_name = getApplicationContext().getPackageName();

            // Question Number Textview ID must be prefixed with q_ e.g.: 'q_aa12a'
            String infoid = view.getResources().getResourceName(view.getId()).replace(package_name + ":id/q_", "");

            // Question info text must be suffixed with _info e.g.: aa12a_info
            int stringRes = this.getResources().getIdentifier(infoid + "_info", "string", getApplicationContext().getPackageName());

            // Fetch info text from strings.xml
            //String infoText = (String) getResources().getText(stringRes);

            // Check if string resource exists to avoid crash on missing info string
            if (stringRes != 0) {

                // Fetch info text from strings.xml
                String infoText = (String) getResources().getText(stringRes);

                new AlertDialog.Builder(this)
                        .setTitle("Info: " + infoid.toUpperCase())
                        .setMessage(infoText)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            } else {
                Toast.makeText(this, "No information available on this question.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No ID Associated with this question.", Toast.LENGTH_SHORT).show();

        }
    }


}
