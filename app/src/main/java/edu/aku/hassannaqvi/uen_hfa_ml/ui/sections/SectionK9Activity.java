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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK9Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK9Activity extends AppCompatActivity {

    ActivitySectionK9Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k9);
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
                startActivity(new Intent(this, SectionK10Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
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
                : "-1");

        json.put("k0901c", "-1");

        json.put("k0902a", bi.k0902aa.isChecked() ? "11"
                : bi.k0902ab.isChecked() ? "12"
                : bi.k0902ac.isChecked() ? "13"
                : "-1");

        json.put("k0902b", bi.k0902ba.isChecked() ? "21"
                : bi.k0902bb.isChecked() ? "22"
                : bi.k0902bc.isChecked() ? "23"
                : "-1");

        json.put("k0902c", "-1");

        json.put("k0903a", bi.k0903aa.isChecked() ? "11"
                : bi.k0903ab.isChecked() ? "12"
                : bi.k0903ac.isChecked() ? "13"
                : "-1");

        json.put("k0903b", bi.k0903ba.isChecked() ? "21"
                : bi.k0903bb.isChecked() ? "22"
                : bi.k0903bc.isChecked() ? "23"
                : "-1");

        json.put("k0903c", "-1");

        json.put("k0904a", bi.k0904aa.isChecked() ? "11"
                : bi.k0904ab.isChecked() ? "12"
                : bi.k0904ac.isChecked() ? "13"
                : "-1");

        json.put("k0904b", bi.k0904ba.isChecked() ? "21"
                : bi.k0904bb.isChecked() ? "22"
                : bi.k0904bc.isChecked() ? "23"
                : "-1");

        json.put("k0904c", "-1");

        json.put("k0905a", bi.k0905aa.isChecked() ? "11"
                : bi.k0905ab.isChecked() ? "12"
                : bi.k0905ac.isChecked() ? "13"
                : "-1");

        json.put("k0905b", bi.k0905ba.isChecked() ? "21"
                : bi.k0905bb.isChecked() ? "22"
                : bi.k0905bc.isChecked() ? "23"
                : "-1");

        json.put("k0905c", "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK9);
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
