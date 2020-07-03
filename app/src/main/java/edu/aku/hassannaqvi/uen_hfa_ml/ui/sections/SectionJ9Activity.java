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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleJContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ9Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.modj;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionJ9Activity extends AppCompatActivity {

    ActivitySectionJ9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j9);
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
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesMJColumn(ModuleJContract.ModuleJ.COLUMN_SJ, modj.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0900a", bi.j0900a.getText().toString().trim().length() > 0 ? bi.j0900a.getText().toString() : "-1");
        json.put("j0900b", bi.j0900b.getText().toString().trim().length() > 0 ? bi.j0900b.getText().toString() : "-1");

        json.put("j0900c", bi.j0900ca.isChecked() ? "1"
                : bi.j0900cb.isChecked() ? "2"
                : "-1");

        json.put("j0901a", bi.j0901aa.isChecked() ? "1"
                : bi.j0901ab.isChecked() ? "2"
                : "-1");

        json.put("j0901b", bi.j0901ba.isChecked() ? "1"
                : bi.j0901bb.isChecked() ? "2"
                : "-1");

        json.put("j0901c", bi.j0901ca.isChecked() ? "1"
                : bi.j0901cb.isChecked() ? "2"
                : "-1");

        json.put("j0901d", bi.j0901da.isChecked() ? "1"
                : bi.j0901db.isChecked() ? "2"
                : "-1");

        json.put("j0901e", bi.j0901ea.isChecked() ? "1"
                : bi.j0901eb.isChecked() ? "2"
                : "-1");

        json.put("j0901fa", bi.j0901fa.isChecked() ? "1" : "-1");
        json.put("j0901fb", bi.j0901fb.isChecked() ? "2" : "-1");
        json.put("j0901fc", bi.j0901fc.isChecked() ? "3" : "-1");
        json.put("j0901fd", bi.j0901fd.isChecked() ? "4" : "-1");
        json.put("j0901fe", bi.j0901fe.isChecked() ? "5" : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(modj.getsJ()), json);

            modj.setsJ(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ9);
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
