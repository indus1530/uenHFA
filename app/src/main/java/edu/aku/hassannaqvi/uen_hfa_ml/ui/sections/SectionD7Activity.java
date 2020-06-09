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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionD7Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionD7Activity extends AppCompatActivity {

    ActivitySectionD7Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d7);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        /*if (fc.getA10().equals("2")) {
            bi.lld0704.setVisibility(View.GONE);
        }*/

    }


    private boolean UpdateDB() {

        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SD, fc.getsD());
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

        json.put("d0701", bi.d0701a.isChecked() ? "1"
                : bi.d0701b.isChecked() ? "2"
                : bi.d0701c.isChecked() ? "3"
                : bi.d0701x.isChecked() ? "96"
                : "-1");
        json.put("d0701xx", bi.d0701xx.getText().toString());

        json.put("d0702", bi.d0702a.isChecked() ? "1"
                : bi.d0702b.isChecked() ? "2"
                : bi.d0702c.isChecked() ? "3"
                : bi.d0702d.isChecked() ? "4"
                : bi.d0702e.isChecked() ? "5"
                : bi.d0702x.isChecked() ? "96"
                : "-1");
        json.put("d0702xx", bi.d0702xx.getText().toString());

        json.put("d0703", bi.d0703a.isChecked() ? "1"
                : bi.d0703b.isChecked() ? "2"
                : bi.d0703c.isChecked() ? "3"
                : bi.d0703x.isChecked() ? "98"
                : "-1");

        json.put("d0704a", bi.d0704aa.isChecked() ? "1"
                : bi.d0704ab.isChecked() ? "2"
                : "-1");

        json.put("d0704b", bi.d0704ba.isChecked() ? "1"
                : bi.d0704bb.isChecked() ? "2"
                : "-1");

        json.put("d0704c", bi.d0704ca.isChecked() ? "1"
                : bi.d0704cb.isChecked() ? "2"
                : "-1");

        json.put("d0704d", bi.d0704da.isChecked() ? "1"
                : bi.d0704db.isChecked() ? "2"
                : "-1");

        json.put("d0704e", bi.d0704ea.isChecked() ? "1"
                : bi.d0704eb.isChecked() ? "2"
                : "-1");

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
                startActivity(new Intent(this, SectionD8Activity.class));
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
