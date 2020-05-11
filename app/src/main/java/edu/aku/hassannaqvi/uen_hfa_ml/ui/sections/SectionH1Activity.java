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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH1Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionH1Activity extends AppCompatActivity {

    ActivitySectionH1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1);
        bi.setCallback(this);
        //setTitle(R.string.sssec);
        setupSkips();


    }


    private void setupSkips() {

        /*bi.ss04.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss04b.getId()) {
                Clear.clearAllFields(bi.ss05cv, false);
            } else {
                Clear.clearAllFields(bi.ss05cv, true);
            }
        }));*/


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


        /*bi.ss09.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss09b.getId()) {
                Clear.clearAllFields(bi.ss10cv, false);
                Clear.clearAllFields(bi.ss11cv, false);
                Clear.clearAllFields(bi.ss12cv, false);

            } else {
                Clear.clearAllFields(bi.ss10cv, true);
                Clear.clearAllFields(bi.ss11cv, true);
                Clear.clearAllFields(bi.ss12cv, true);

            }
        }));*/


        /*bi.ss11.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss11b.getId()) {
                Clear.clearAllFields(bi.ss12cv, false);
                Clear.clearAllFields(bi.ss13cv, false);
            } else {
                Clear.clearAllFields(bi.ss12cv, true);
                Clear.clearAllFields(bi.ss13cv, true);
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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
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

        json.put("h0101", bi.h0101.getText().toString());

        json.put("h0101aa", bi.h0101aa.getText().toString());

        json.put("h0101ab", bi.h0101ab.getText().toString());

        json.put("h0101ba", bi.h0101ba.getText().toString());

        json.put("h0101bb", bi.h0101bb.getText().toString());

        json.put("h0101ca", bi.h0101ca.getText().toString());

        json.put("h0101cb", bi.h0101cb.getText().toString());


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
