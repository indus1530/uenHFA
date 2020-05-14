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

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ4Activity extends AppCompatActivity {

    ActivitySectionJ4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j4);
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
                startActivity(new Intent(this, SectionJ5Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SB, MainApp.fc.getsB());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0400", bi.j0400a.isChecked() ? "1"
                : bi.j0400b.isChecked() ? "2"
                : "-1");

        json.put("j0400aa", bi.j0400aaa.isChecked() ? "1"
                : bi.j0400aab.isChecked() ? "2"
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

        MainApp.fc.setsB(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ4);

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
