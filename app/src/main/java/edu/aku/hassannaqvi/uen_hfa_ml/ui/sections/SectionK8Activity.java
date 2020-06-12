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
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK8Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK8Activity extends AppCompatActivity {

    ActivitySectionK8Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k8);
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
                startActivity(new Intent(this, SectionK9Activity.class));
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


    private void SaveDraft() {

        JSONObject json = new JSONObject();

        MainApp.fc.k0801a = bi.k0801aa.isChecked() ? "11"
                : bi.k0801ab.isChecked() ? "12"
                : bi.k0801ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0801b = bi.k0801ba.isChecked() ? "21"
                : bi.k0801bb.isChecked() ? "22"
                : bi.k0801bc.isChecked() ? "23"
                : bi.k0801c.isChecked() ? "3"
                : "-1";


        MainApp.fc.k0802a = bi.k0802aa.isChecked() ? "11"
                : bi.k0802ab.isChecked() ? "12"
                : bi.k0802ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0802b = bi.k0802ba.isChecked() ? "21"
                : bi.k0802bb.isChecked() ? "22"
                : bi.k0802bc.isChecked() ? "23"
                : bi.k0802c.isChecked() ? "3"
                : "-1";


        MainApp.fc.k0803a = bi.k0803aa.isChecked() ? "11"
                : bi.k0803ab.isChecked() ? "12"
                : bi.k0803ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0803b = bi.k0803ba.isChecked() ? "21"
                : bi.k0803bb.isChecked() ? "22"
                : bi.k0803bc.isChecked() ? "23"
                : bi.k0803c.isChecked() ? "3"
                : "-1";


        MainApp.fc.k0804a = bi.k0804aa.isChecked() ? "11"
                : bi.k0804ab.isChecked() ? "12"
                : bi.k0804ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0804b = bi.k0804ba.isChecked() ? "21"
                : bi.k0804bb.isChecked() ? "22"
                : bi.k0804bc.isChecked() ? "23"
                : bi.k0804c.isChecked() ? "3"
                : "-1";


        MainApp.fc.k0805a = bi.k0805aa.isChecked() ? "11"
                : bi.k0805ab.isChecked() ? "12"
                : bi.k0805ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0805b = bi.k0805ba.isChecked() ? "21"
                : bi.k0805bb.isChecked() ? "22"
                : bi.k0805bc.isChecked() ? "23"
                : bi.k0805c.isChecked() ? "3"
                : "-1";


        MainApp.fc.k0806a = bi.k0806aa.isChecked() ? "11"
                : bi.k0806ab.isChecked() ? "12"
                : bi.k0806ac.isChecked() ? "13"
                : "-1";

        MainApp.fc.k0806b = bi.k0806ba.isChecked() ? "21"
                : bi.k0806bb.isChecked() ? "22"
                : bi.k0806bc.isChecked() ? "23"
                : bi.k0806c.isChecked() ? "3"
                : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK8);
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
