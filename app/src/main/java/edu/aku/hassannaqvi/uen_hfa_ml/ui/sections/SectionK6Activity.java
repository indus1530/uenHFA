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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK6Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK6Activity extends AppCompatActivity {

    ActivitySectionK6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k6);
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
                startActivity(new Intent(this, SectionK7Activity.class));
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

        json.put("k060101a", bi.k060101aa.isChecked() ? "11"
                : bi.k060101ab.isChecked() ? "12"
                : bi.k060101ac.isChecked() ? "13"
                : "-1");

        json.put("k060101b", bi.k060101ba.isChecked() ? "21"
                : bi.k060101bb.isChecked() ? "22"
                : bi.k060101bc.isChecked() ? "23"
                : "-1");

        json.put("k060101c", "-1");

        json.put("k060102a", bi.k060102aa.isChecked() ? "11"
                : bi.k060102ab.isChecked() ? "12"
                : bi.k060102ac.isChecked() ? "13"
                : "-1");

        json.put("k060102b", bi.k060102ba.isChecked() ? "21"
                : bi.k060102bb.isChecked() ? "22"
                : bi.k060102bc.isChecked() ? "23"
                : "-1");

        json.put("k060102c", "-1");

        json.put("k060103a", bi.k060103aa.isChecked() ? "11"
                : bi.k060103ab.isChecked() ? "12"
                : bi.k060103ac.isChecked() ? "13"
                : "-1");

        json.put("k060103b", bi.k060103ba.isChecked() ? "21"
                : bi.k060103bb.isChecked() ? "22"
                : bi.k060103bc.isChecked() ? "23"
                : "-1");

        json.put("k060103c", "-1");

        json.put("k060104a", bi.k060104aa.isChecked() ? "11"
                : bi.k060104ab.isChecked() ? "12"
                : bi.k060104ac.isChecked() ? "13"
                : "-1");

        json.put("k060104b", bi.k060104ba.isChecked() ? "21"
                : bi.k060104bb.isChecked() ? "22"
                : bi.k060104bc.isChecked() ? "23"
                : "-1");

        json.put("k060104c", "-1");

        json.put("k060105a", bi.k060105aa.isChecked() ? "11"
                : bi.k060105ab.isChecked() ? "12"
                : bi.k060105ac.isChecked() ? "13"
                : "-1");

        json.put("k060105b", bi.k060105ba.isChecked() ? "21"
                : bi.k060105bb.isChecked() ? "22"
                : bi.k060105bc.isChecked() ? "23"
                : "-1");

        json.put("k060105c", "-1");

        json.put("k060201a", bi.k060201aa.isChecked() ? "11"
                : bi.k060201ab.isChecked() ? "12"
                : bi.k060201ac.isChecked() ? "13"
                : "-1");

        json.put("k060201b", bi.k060201ba.isChecked() ? "21"
                : bi.k060201bb.isChecked() ? "22"
                : bi.k060201bc.isChecked() ? "23"
                : "-1");

        json.put("k060201c", "-1");

        json.put("k060202a", bi.k060202aa.isChecked() ? "11"
                : bi.k060202ab.isChecked() ? "12"
                : bi.k060202ac.isChecked() ? "13"
                : "-1");

        json.put("k060202b", bi.k060202ba.isChecked() ? "21"
                : bi.k060202bb.isChecked() ? "22"
                : bi.k060202bc.isChecked() ? "23"
                : "-1");

        json.put("k060202c", "-1");

        json.put("k060203a", bi.k060203aa.isChecked() ? "11"
                : bi.k060203ab.isChecked() ? "12"
                : bi.k060203ac.isChecked() ? "13"
                : "-1");

        json.put("k060203b", bi.k060203ba.isChecked() ? "21"
                : bi.k060203bb.isChecked() ? "22"
                : bi.k060203bc.isChecked() ? "23"
                : "-1");

        json.put("k060203c", "-1");

        json.put("k060204a", bi.k060204aa.isChecked() ? "11"
                : bi.k060204ab.isChecked() ? "12"
                : bi.k060204ac.isChecked() ? "13"
                : "-1");

        json.put("k060204b", bi.k060204ba.isChecked() ? "21"
                : bi.k060204bb.isChecked() ? "22"
                : bi.k060204bc.isChecked() ? "23"
                : "-1");

        json.put("k060204c", "-1");

        json.put("k060205a", bi.k060205aa.isChecked() ? "11"
                : bi.k060205ab.isChecked() ? "12"
                : bi.k060205ac.isChecked() ? "13"
                : "-1");

        json.put("k060205b", bi.k060205ba.isChecked() ? "21"
                : bi.k060205bb.isChecked() ? "22"
                : bi.k060205bc.isChecked() ? "23"
                : "-1");

        json.put("k060205c", "-1");

        json.put("k060206a", bi.k060206aa.isChecked() ? "11"
                : bi.k060206ab.isChecked() ? "12"
                : bi.k060206ac.isChecked() ? "13"
                : "-1");

        json.put("k060206b", bi.k060206ba.isChecked() ? "21"
                : bi.k060206bb.isChecked() ? "22"
                : bi.k060206bc.isChecked() ? "23"
                : "-1");

        json.put("k060206c", "-1");


    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK6);
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
