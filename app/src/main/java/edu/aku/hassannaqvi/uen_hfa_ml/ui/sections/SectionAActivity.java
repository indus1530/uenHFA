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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionABinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        setTitle(R.string.modatitle);
        setupSkips();

    }


    private void setupSkips() {

        /*bi.ss07.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss07h.getId() || i == bi.ss07i.getId()) {
                Clear.clearAllFields(bi.ss08cv, false);
                Clear.clearAllFields(bi.ss09cv, false);
                Clear.clearAllFields(bi.ss10cv, false);
                Clear.clearAllFields(bi.ss11cv, false);
                Clear.clearAllFields(bi.ss12cv, false);
            } else {
                Clear.clearAllFields(bi.ss08cv, true);
                Clear.clearAllFields(bi.ss09cv, true);
                Clear.clearAllFields(bi.ss10cv, true);
                Clear.clearAllFields(bi.ss11cv, true);
                Clear.clearAllFields(bi.ss12cv, true);
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
                startActivity(new Intent(this, SectionJ01Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, MainApp.fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("a01", bi.a01.getText().toString());

        json.put("a02", bi.a02.getText().toString());

        json.put("a03", bi.a03.getText().toString());

        json.put("a04", bi.a04.getText().toString());

        json.put("a05", bi.a05.getText().toString());

        json.put("a06", bi.a06a.isChecked() ? "1"
                : bi.a06b.isChecked() ? "2"
                : bi.a06c.isChecked() ? "3"
                : "-1");

        json.put("a07", bi.a07a.isChecked() ? "1"
                : bi.a07b.isChecked() ? "2"
                : bi.a07c.isChecked() ? "3"
                : bi.a07d.isChecked() ? "4"
                : bi.a07e.isChecked() ? "5"
                : bi.a07f.isChecked() ? "6"
                : bi.a07g.isChecked() ? "7"
                : bi.a07h.isChecked() ? "8"
                : "-1");

        json.put("a08", "-1");

        json.put("a09", "-1");

        json.put("a10", bi.a10a.isChecked() ? "1"
                : bi.a10b.isChecked() ? "2"
                : "-1");

        json.put("a11", bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1");

        json.put("a12", bi.a12.getText().toString());

        json.put("a13", bi.a13.getText().toString());

        json.put("a14", bi.a14a.isChecked() ? "1"
                : bi.a14b.isChecked() ? "2"
                : "-1");

        json.put("a15", bi.a15a.isChecked() ? "1"
                : bi.a15b.isChecked() ? "2"
                : "-1");

        json.put("a16", bi.a16.getText().toString());

        json.put("a17", bi.a17a.isChecked() ? "1"
                : bi.a17b.isChecked() ? "2"
                : bi.a17c.isChecked() ? "3"
                : bi.a17d.isChecked() ? "4"
                : bi.a17e.isChecked() ? "5"
                : bi.a17f.isChecked() ? "6"
                : bi.a17g.isChecked() ? "7"
                : bi.a17h.isChecked() ? "8"
                : bi.a17i.isChecked() ? "9"
                : bi.a17j.isChecked() ? "10"
                : "-1");

        json.put("a18", bi.a18a.isChecked() ? "1"
                : bi.a18b.isChecked() ? "2"
                : bi.a18c.isChecked() ? "3"
                : bi.a18d.isChecked() ? "4"
                : bi.a18x.isChecked() ? "96"
                : "-1");

        json.put("a18xx", bi.a18xx.getText().toString());
        json.put("a19", bi.a19a.isChecked() ? "1"
                : bi.a19b.isChecked() ? "2"
                : bi.a19c.isChecked() ? "3"
                : bi.a19d.isChecked() ? "4"
                : bi.a19e.isChecked() ? "5"
                : bi.a19f.isChecked() ? "6"
                : bi.a19g.isChecked() ? "7"
                : bi.a19x.isChecked() ? "96"
                : "-1");
        json.put("a19xx", bi.a19xx.getText().toString());

        json.put("a20", bi.a20a.isChecked() ? "1"
                : bi.a20b.isChecked() ? "2"
                : "-1");

        json.put("a21", bi.a21.getText().toString());

        json.put("a22", bi.a22a.isChecked() ? "1"
                : bi.a22b.isChecked() ? "2"
                : bi.a22c.isChecked() ? "3"
                : bi.a22d.isChecked() ? "4"
                : bi.a22e.isChecked() ? "5"
                : "-1");

        MainApp.fc.setsE(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

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
