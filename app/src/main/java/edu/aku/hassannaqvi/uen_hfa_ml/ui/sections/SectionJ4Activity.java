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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ4Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionJ4Activity extends AppCompatActivity {

    ActivitySectionJ4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j4);
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
            startActivity(new Intent(this, SectionJ5Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
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

        json.put("j0400a", bi.j0400a.getText().toString().trim().length() > 0 ? bi.j0400a.getText().toString() : "-1");
        json.put("j0400b", bi.j0400b.getText().toString().trim().length() > 0 ? bi.j0400b.getText().toString() : "-1");

        json.put("j0400c", bi.j0400ca.isChecked() ? "1"
                : bi.j0400cb.isChecked() ? "2"
                : "-1");

        json.put("j0401a", bi.j0401aa.isChecked() ? "1"
                : bi.j0401ab.isChecked() ? "2"
                : "-1");

        json.put("j0401b", bi.j0401ba.isChecked() ? "1"
                : bi.j0401bb.isChecked() ? "2"
                : "-1");

        json.put("j0401c", bi.j0401ca.isChecked() ? "1"
                : bi.j0401cb.isChecked() ? "2"
                : "-1");

        json.put("j0401d", bi.j0401da.isChecked() ? "1"
                : bi.j0401db.isChecked() ? "2"
                : "-1");

        json.put("j0401e", bi.j0401ea.isChecked() ? "1"
                : bi.j0401eb.isChecked() ? "2"
                : "-1");

        json.put("j0401f", bi.j0401fa.isChecked() ? "1"
                : bi.j0401fb.isChecked() ? "2"
                : "-1");

        json.put("j0401g", bi.j0401ga.isChecked() ? "1"
                : bi.j0401gb.isChecked() ? "2"
                : "-1");

        json.put("j0401h", bi.j0401ha.isChecked() ? "1"
                : bi.j0401hb.isChecked() ? "2"
                : "-1");

        json.put("j0401i", bi.j0401ia.isChecked() ? "1"
                : bi.j0401ib.isChecked() ? "2"
                : "-1");

        json.put("j0401j", bi.j0401ja.isChecked() ? "1"
                : bi.j0401jb.isChecked() ? "2"
                : "-1");

        json.put("j0401k", bi.j0401ka.isChecked() ? "1"
                : bi.j0401kb.isChecked() ? "2"
                : "-1");

        json.put("j0401l", bi.j0401la.isChecked() ? "1"
                : bi.j0401lb.isChecked() ? "2"
                : "-1");

        json.put("j0401ma", bi.j0401ma.isChecked() ? "1" : "-1");
        json.put("j0401mb", bi.j0401mb.isChecked() ? "2" : "-1");
        json.put("j0401mc", bi.j0401mc.isChecked() ? "3" : "-1");
        json.put("j0401md", bi.j0401md.isChecked() ? "4" : "-1");
        json.put("j0401me", bi.j0401me.isChecked() ? "5" : "-1");
        json.put("j0401mf", bi.j0401mf.isChecked() ? "6" : "-1");
        json.put("j0401mx", bi.j0401mx.isChecked() ? "96" : "-1");
        json.put("j0401mxx", bi.j0401mxx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsJ()), json);

            MainApp.fc.setsJ(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ4);
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "J");
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
