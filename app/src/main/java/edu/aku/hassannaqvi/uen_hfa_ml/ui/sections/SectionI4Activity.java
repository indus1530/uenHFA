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

import edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleIContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionI4Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.modi;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivityI;


public class SectionI4Activity extends AppCompatActivity {

    ActivitySectionI4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i4);
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
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true).putExtra(CONSTANTS.SECTION_MAIN_CHECK_FOR_END, true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesMIColumn(ModuleIContract.ModuleI.COLUMN_SI4, modi.getsI4());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("i0401a", bi.i0401aa.isChecked() ? "1"
                : bi.i0401ab.isChecked() ? "2"
                : bi.i0401ac.isChecked() ? "3"
                : bi.i0401ad.isChecked() ? "4"
                : "-1");

        json.put("i0401b", bi.i0401ba.isChecked() ? "1"
                : bi.i0401bb.isChecked() ? "2"
                : bi.i0401bc.isChecked() ? "3"
                : bi.i0401bd.isChecked() ? "4"
                : "-1");

        json.put("i0401c", bi.i0401ca.isChecked() ? "1"
                : bi.i0401cb.isChecked() ? "2"
                : bi.i0401cc.isChecked() ? "3"
                : bi.i0401cd.isChecked() ? "4"
                : "-1");

        json.put("i0401d", bi.i0401da.isChecked() ? "1"
                : bi.i0401db.isChecked() ? "2"
                : bi.i0401dc.isChecked() ? "3"
                : bi.i0401dd.isChecked() ? "4"
                : "-1");

        json.put("i0401e", bi.i0401ea.isChecked() ? "1"
                : bi.i0401eb.isChecked() ? "2"
                : bi.i0401ec.isChecked() ? "3"
                : bi.i0401ed.isChecked() ? "4"
                : "-1");

        json.put("i0401f", bi.i0401fa.isChecked() ? "1"
                : bi.i0401fb.isChecked() ? "2"
                : bi.i0401fc.isChecked() ? "3"
                : bi.i0401fd.isChecked() ? "4"
                : "-1");

        json.put("i0401g", bi.i0401ga.isChecked() ? "1"
                : bi.i0401gb.isChecked() ? "2"
                : bi.i0401gc.isChecked() ? "3"
                : bi.i0401gd.isChecked() ? "4"
                : "-1");


        modi.setsI4(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnEnd() {
        openSectionMainActivityI(this);
        /*openEndActivity(this, true);*/
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
