package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH151Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionH151Activity extends AppCompatActivity {

    ActivitySectionH151Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h151);
        bi.setCallback(this);
        setupSkips();

    }

    private void setupSkips() {

        bi.h1501a0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501a0ay.getId()) {
                bi.fldGrpCVh1501a0b.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501a0c.setVisibility(View.VISIBLE);
                bi.fldGrpCVh1501a0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501a0b);
                Clear.clearAllFields(bi.fldGrpCVh1501a0c);
                Clear.clearAllFields(bi.fldGrpCVh1501a0d);
                bi.fldGrpCVh1501a0b.setVisibility(View.GONE);
                bi.fldGrpCVh1501a0c.setVisibility(View.GONE);
                bi.fldGrpCVh1501a0d.setVisibility(View.GONE);
            }
        }));

        bi.h1501a0c.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1501a0cy.getId()) {
                bi.fldGrpCVh1501a0d.setVisibility(View.VISIBLE);
            } else {
                Clear.clearAllFields(bi.fldGrpCVh1501a0d);
                bi.fldGrpCVh1501a0d.setVisibility(View.GONE);
            }
        }));

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
                startActivity(new Intent(this, SectionH152Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, fc.getsH());
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

        json.put("h1501a0a", bi.h1501a0ay.isChecked() ? "1"
                : bi.h1501a0an.isChecked() ? "2"
                : "-1");

        json.put("h1501a0b", bi.h1501a0by.isChecked() ? "1"
                : bi.h1501a0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501a0c", bi.h1501a0cy.isChecked() ? "1"
                : bi.h1501a0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501a0dy", bi.h1501a0dy.getText().toString());

        json.put("h1501a0dn", bi.h1501a0dn.getText().toString());

        json.put("h1501b0a", bi.h1501b0ay.isChecked() ? "1"
                : bi.h1501b0an.isChecked() ? "2"
                : "-1");

        json.put("h1501b0b", bi.h1501b0by.isChecked() ? "1"
                : bi.h1501b0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501b0c", bi.h1501b0cy.isChecked() ? "1"
                : bi.h1501b0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501b0dy", bi.h1501b0dy.getText().toString());

        json.put("h1501b0dn", bi.h1501b0dn.getText().toString());

        json.put("h1501c0a", bi.h1501c0ay.isChecked() ? "1"
                : bi.h1501c0an.isChecked() ? "2"
                : "-1");

        json.put("h1501c0b", bi.h1501c0by.isChecked() ? "1"
                : bi.h1501c0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501c0c", bi.h1501c0cy.isChecked() ? "1"
                : bi.h1501c0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501c0dy", bi.h1501c0dy.getText().toString());

        json.put("h1501c0dn", bi.h1501c0dn.getText().toString());

        json.put("h1501d0a", bi.h1501d0ay.isChecked() ? "1"
                : bi.h1501d0an.isChecked() ? "2"
                : "-1");

        json.put("h1501d0b", bi.h1501d0by.isChecked() ? "1"
                : bi.h1501d0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501d0c", bi.h1501d0cy.isChecked() ? "1"
                : bi.h1501d0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501d0dy", bi.h1501d0dy.getText().toString());

        json.put("h1501d0dn", bi.h1501d0dn.getText().toString());

        json.put("h1501e0a", bi.h1501e0ay.isChecked() ? "1"
                : bi.h1501e0an.isChecked() ? "2"
                : "-1");

        json.put("h1501e0b", bi.h1501e0by.isChecked() ? "1"
                : bi.h1501e0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501e0c", bi.h1501e0cy.isChecked() ? "1"
                : bi.h1501e0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501e0dy", bi.h1501e0dy.getText().toString());

        json.put("h1501e0dn", bi.h1501e0dn.getText().toString());

        json.put("h1501f0a", bi.h1501f0ay.isChecked() ? "1"
                : bi.h1501f0an.isChecked() ? "2"
                : "-1");

        json.put("h1501f0b", bi.h1501f0by.isChecked() ? "1"
                : bi.h1501f0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501f0c", bi.h1501f0cy.isChecked() ? "1"
                : bi.h1501f0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501f0dy", bi.h1501f0dy.getText().toString());

        json.put("h1501f0dn", bi.h1501f0dn.getText().toString());

        json.put("h1501g0a", bi.h1501g0ay.isChecked() ? "1"
                : bi.h1501g0an.isChecked() ? "2"
                : "-1");

        json.put("h1501g0b", bi.h1501g0by.isChecked() ? "1"
                : bi.h1501g0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501g0c", bi.h1501g0cy.isChecked() ? "1"
                : bi.h1501g0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501g0dy", bi.h1501g0dy.getText().toString());

        json.put("h1501g0dn", bi.h1501g0dn.getText().toString());

        json.put("h1501h0a", bi.h1501h0ay.isChecked() ? "1"
                : bi.h1501h0an.isChecked() ? "2"
                : "-1");

        json.put("h1501h0b", bi.h1501h0by.isChecked() ? "1"
                : bi.h1501h0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501h0c", bi.h1501h0cy.isChecked() ? "1"
                : bi.h1501h0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501h0dy", bi.h1501h0dy.getText().toString());

        json.put("h1501h0dn", bi.h1501h0dn.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH15);
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
