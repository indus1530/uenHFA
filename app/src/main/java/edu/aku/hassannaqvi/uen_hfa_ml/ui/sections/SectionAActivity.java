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
        setTitle(R.string.sssec);
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
                startActivity(new Intent(this, SectionSS2Activity.class));
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

        JSONObject f1 = new JSONObject();
        f1.put("101", bi .101.getText().toString())
        f1.put("102", bi .102.getText().toString())
        f1.put("103", bi .103.getText().toString())
        f1.put("104",
                bi .104 a.isChecked() ? "1" :
                bi .104 b.isChecked() ? "2" :
                bi .104 c.isChecked() ? "3" :
                "0")
        f1.put("105", bi .105 a.isChecked() ? "1"
                : bi .105 b.isChecked() ? "2"
                : bi .105 c.isChecked() ? "3"
                : bi .105d.isChecked() ? "4" : bi .105e.isChecked() ? "5" : bi
        .105f.isChecked() ? "6" : bi .105 g.isChecked() ? "7" : bi .105 h.isChecked() ? "8" : "0")
        f1.put("106",
                "0");
        f1.put("107",
                "0");
        f1.put("108",
                bi .108 a.isChecked() ? "1" :
                bi .108 b.isChecked() ? "2" :
                "0")
        f1.put("109",
                bi .109 a.isChecked() ? "1" :
                bi .109 b.isChecked() ? "2" :
                "0")
        f1.put("110", bi .110.getText().toString())
        f1.put("111", bi .111.getText().toString())
        f1.put("112",
                bi .112 a.isChecked() ? "1" :
                bi .112 b.isChecked() ? "2" :
                "0")
        f1.put("113",
                bi .113 a.isChecked() ? "1" :
                bi .113 b.isChecked() ? "2" :
                "0")
        f1.put("114", bi .114.getText().toString())
        f1.put("115",
                bi .115 a.isChecked() ? "1" :
                bi .115 b.isChecked() ? "2" :
                bi .115 c.isChecked() ? "3" :
                bi .115d.isChecked() ? "4" :
                bi .115e.isChecked() ? "5" :
                bi .115f.isChecked() ? "6" :
                bi .115 g.isChecked() ? "7" :
                bi .115 h.isChecked() ? "8" :
                bi .115 i.isChecked() ? "9" :
                bi .115 j.isChecked() ? "10" :
                "0")
        f1.put("116",
                bi .116 a.isChecked() ? "1" :
                bi .116 b.isChecked() ? "2" :
                bi .116 c.isChecked() ? "3" :
                bi .116d.isChecked() ? "4" :
                bi .116 x.isChecked() ? "96" :
                "0")
        f1.put("116xx", bi .116 xx.getText().toString())
        f1.put("11601",
                bi .11601 a.isChecked() ? "1" :
                bi .11601 b.isChecked() ? "2" :
                bi .11601 c.isChecked() ? "3" :
                bi .11601d.isChecked() ? "4" :
                bi .11601e.isChecked() ? "5" :
                bi .11601f.isChecked() ? "6" :
                bi .11601 g.isChecked() ? "7" :
                bi .11601 h.isChecked() ? "96" :
                "0")
        f1.put("11601hx", bi .11601 hx.getText().toString())
        f1.put("117",
                bi .117 a.isChecked() ? "1" :
                bi .117 b.isChecked() ? "2" :
                "0")
        f1.put("118", bi .118.getText().toString())
        f1.put("119",
                bi .119 a.isChecked() ? "1" :
                bi .119 b.isChecked() ? "2" :
                bi .119 c.isChecked() ? "3" :
                bi .119d.isChecked() ? "4" :
                bi .119e.isChecked() ? "5" :
                "0")

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
