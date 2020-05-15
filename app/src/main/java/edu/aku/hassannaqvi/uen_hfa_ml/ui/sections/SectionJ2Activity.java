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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ2Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ2Activity extends AppCompatActivity {

    ActivitySectionJ2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j2);
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
                startActivity(new Intent(this, SectionJ3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0200", bi.j0200a.isChecked() ? "1"
                : bi.j0200b.isChecked() ? "2"
                : "-1");

        json.put("j0200aa", bi.j0200aaa.isChecked() ? "1"
                : bi.j0200aab.isChecked() ? "2"
                : "-1");

        json.put("j0201a", bi.j0201aa.isChecked() ? "1"
                : bi.j0201ab.isChecked() ? "2"
                : "-1");

        json.put("j0201b", bi.j0201ba.isChecked() ? "1"
                : bi.j0201bb.isChecked() ? "2"
                : "-1");

        json.put("j0201c", bi.j0201ca.isChecked() ? "1"
                : bi.j0201cb.isChecked() ? "2"
                : "-1");

        json.put("j0201d", bi.j0201da.isChecked() ? "1"
                : bi.j0201db.isChecked() ? "2"
                : "-1");

        json.put("j0201e", bi.j0201ea.isChecked() ? "1"
                : bi.j0201eb.isChecked() ? "2"
                : "-1");

        json.put("j0201f", bi.j0201fa.isChecked() ? "1"
                : bi.j0201fb.isChecked() ? "2"
                : "-1");

        json.put("j0201ga", bi.j0201ga.isChecked() ? "1" : "-1");
        json.put("j0201gb", bi.j0201gb.isChecked() ? "2" : "-1");
        json.put("j0201gc", bi.j0201gc.isChecked() ? "3" : "-1");
        json.put("j0201gd", bi.j0201gd.isChecked() ? "4" : "-1");
        json.put("j0201ge", bi.j0201ge.isChecked() ? "5" : "-1");
        json.put("j0201gf", bi.j0201gf.isChecked() ? "6" : "-1");
        json.put("j0201gx", bi.j0201gx.isChecked() ? "96" : "-1");
        json.put("j0201gxx", bi.j0201gxx.getText().toString());

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsJ()), json);

            MainApp.fc.setsJ(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ2);

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
