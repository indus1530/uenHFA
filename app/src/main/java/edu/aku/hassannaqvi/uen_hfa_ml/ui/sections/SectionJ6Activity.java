package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ6Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ6Activity extends AppCompatActivity {

    ActivitySectionJ6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j6);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

        /*bi.ss22.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss22b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVss23, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVss23, true);
            }
        }));*/


        /*bi.ss24.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss24b.getId()) {
                Clear.clearAllFields(bi.ss25cvall, false);
            } else {
                Clear.clearAllFields(bi.ss25cvall, true);
            }
        }));*/

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionJ7Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0600a", bi.j0600a.getText().toString().trim().length() > 0 ? bi.j0600a.getText().toString() : "-1");
        json.put("j0600b", bi.j0600b.getText().toString().trim().length() > 0 ? bi.j0600b.getText().toString() : "-1");

        json.put("j0600aa", bi.j0600aaa.isChecked() ? "1"
                : bi.j0600aab.isChecked() ? "2"
                : "-1");

        json.put("j0601a", bi.j0601aa.isChecked() ? "1"
                : bi.j0601ab.isChecked() ? "2"
                : "-1");

        json.put("j0601b", bi.j0601ba.isChecked() ? "1"
                : bi.j0601bb.isChecked() ? "2"
                : "-1");

        json.put("j0601c", bi.j0601ca.isChecked() ? "1"
                : bi.j0601cb.isChecked() ? "2"
                : "-1");

        json.put("j0601d", bi.j0601da.isChecked() ? "1"
                : bi.j0601db.isChecked() ? "2"
                : "-1");

        json.put("j0601e", bi.j0601ea.isChecked() ? "1"
                : bi.j0601eb.isChecked() ? "2"
                : "-1");

        json.put("j0601f", bi.j0601fa.isChecked() ? "1"
                : bi.j0601fb.isChecked() ? "2"
                : "-1");

        json.put("j0601g", bi.j0601ga.isChecked() ? "1"
                : bi.j0601gb.isChecked() ? "2"
                : "-1");

        json.put("j0601h", bi.j0601ha.isChecked() ? "1"
                : bi.j0601hb.isChecked() ? "2"
                : "-1");

        json.put("j0601i", bi.j0601ia.isChecked() ? "1"
                : bi.j0601ib.isChecked() ? "2"
                : "-1");

        json.put("j0601j", bi.j0601ja.isChecked() ? "1"
                : bi.j0601jb.isChecked() ? "2"
                : "-1");

        json.put("j0601k", bi.j0601ka.isChecked() ? "1"
                : bi.j0601kb.isChecked() ? "2"
                : "-1");

        json.put("j0601l", bi.j0601la.isChecked() ? "1"
                : bi.j0601lb.isChecked() ? "2"
                : "-1");

        json.put("j0601ma", bi.j0601ma.isChecked() ? "1" : "-1");
        json.put("j0601mb", bi.j0601mb.isChecked() ? "2" : "-1");
        json.put("j0601mc", bi.j0601mc.isChecked() ? "3" : "-1");
        json.put("j0601md", bi.j0601md.isChecked() ? "4" : "-1");
        json.put("j0601me", bi.j0601me.isChecked() ? "5" : "-1");
        json.put("j0601mf", bi.j0601mf.isChecked() ? "6" : "-1");
        json.put("j0601mx", bi.j0601mx.isChecked() ? "96" : "-1");
        json.put("j0601mxx", bi.j0601mxx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsJ()), json);

            MainApp.fc.setsJ(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ6);

    }


    public void BtnEnd() {
        openEndActivity(this);
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
