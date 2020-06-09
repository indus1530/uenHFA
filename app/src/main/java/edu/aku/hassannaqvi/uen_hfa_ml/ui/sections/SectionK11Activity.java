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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK11Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK11Activity extends AppCompatActivity {

    ActivitySectionK11Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k11);
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
                startActivity(new Intent(this, SectionMainActivity.class));
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

        json.put("k1101", bi.k1101a.isChecked() ? "1"
                : bi.k1101b.isChecked() ? "2"
                : "-1");

        json.put("k1102", bi.k1102a.isChecked() ? "1"
                : bi.k1102b.isChecked() ? "2"
                : "-1");

        json.put("k1103", bi.k1103a.isChecked() ? "1"
                : bi.k1103b.isChecked() ? "2"
                : "-1");

        json.put("k1104", bi.k1104a.isChecked() ? "1"
                : bi.k1104b.isChecked() ? "2"
                : "-1");

        json.put("k1105", bi.k1105a.isChecked() ? "1"
                : bi.k1105b.isChecked() ? "2"
                : "-1");

        json.put("k1106", bi.k1106a.isChecked() ? "1"
                : bi.k1106b.isChecked() ? "2"
                : "-1");

        json.put("k1107", bi.k1107a.isChecked() ? "1"
                : bi.k1107b.isChecked() ? "2"
                : "-1");

        json.put("k1108", bi.k1108a.isChecked() ? "1"
                : bi.k1108b.isChecked() ? "2"
                : "-1");

        json.put("k1109", bi.k1109a.isChecked() ? "1"
                : bi.k1109b.isChecked() ? "2"
                : "-1");

        json.put("k1110", bi.k1110a.isChecked() ? "1"
                : bi.k1110b.isChecked() ? "2"
                : "-1");

        json.put("k1111", bi.k1111a.isChecked() ? "1"
                : bi.k1111b.isChecked() ? "2"
                : "-1");

        json.put("k0905c", "-1");

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK11);
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
