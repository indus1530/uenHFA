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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH15Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionH15Activity extends AppCompatActivity {

    ActivitySectionH15Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h15);
        bi.setCallback(this);
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

        json.put("h1501", "-1");

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

        json.put("h1501i0a", bi.h1501i0ay.isChecked() ? "1"
                : bi.h1501i0an.isChecked() ? "2"
                : "-1");

        json.put("h1501i0b", bi.h1501i0by.isChecked() ? "1"
                : bi.h1501i0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501i0c", bi.h1501i0cy.isChecked() ? "1"
                : bi.h1501i0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501i0dy", bi.h1501i0dy.getText().toString());

        json.put("h1501i0dn", bi.h1501i0dn.getText().toString());

        json.put("h1501j0a", bi.h1501j0ay.isChecked() ? "1"
                : bi.h1501j0an.isChecked() ? "2"
                : "-1");

        json.put("h1501j0b", bi.h1501j0by.isChecked() ? "1"
                : bi.h1501j0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501j0c", bi.h1501j0cy.isChecked() ? "1"
                : bi.h1501j0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501j0dy", bi.h1501j0dy.getText().toString());

        json.put("h1501j0dn", bi.h1501j0dn.getText().toString());

        json.put("h1501k0a", bi.h1501k0ay.isChecked() ? "1"
                : bi.h1501k0an.isChecked() ? "2"
                : "-1");

        json.put("h1501k0b", bi.h1501k0by.isChecked() ? "1"
                : bi.h1501k0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501k0c", bi.h1501k0cy.isChecked() ? "1"
                : bi.h1501k0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501k0dy", bi.h1501k0dy.getText().toString());

        json.put("h1501k0dn", bi.h1501k0dn.getText().toString());

        json.put("h1501l0a", bi.h1501l0ay.isChecked() ? "1"
                : bi.h1501l0an.isChecked() ? "2"
                : "-1");

        json.put("h1501l0b", bi.h1501l0by.isChecked() ? "1"
                : bi.h1501l0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501l0c", bi.h1501l0cy.isChecked() ? "1"
                : bi.h1501l0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501l0dy", bi.h1501l0dy.getText().toString());

        json.put("h1501l0dn", bi.h1501l0dn.getText().toString());

        json.put("h1501m0a", bi.h1501m0ay.isChecked() ? "1"
                : bi.h1501m0an.isChecked() ? "2"
                : "-1");

        json.put("h1501m0b", bi.h1501m0by.isChecked() ? "1"
                : bi.h1501m0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501m0c", bi.h1501m0cy.isChecked() ? "1"
                : bi.h1501m0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501m0dy", bi.h1501m0dy.getText().toString());

        json.put("h1501m0dn", bi.h1501m0dn.getText().toString());

        json.put("h1501n0a", bi.h1501n0ay.isChecked() ? "1"
                : bi.h1501n0an.isChecked() ? "2"
                : "-1");

        json.put("h1501n0b", bi.h1501n0by.isChecked() ? "1"
                : bi.h1501n0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501n0c", bi.h1501n0cy.isChecked() ? "1"
                : bi.h1501n0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501n0dy", bi.h1501n0dy.getText().toString());

        json.put("h1501n0dn", bi.h1501n0dn.getText().toString());

        json.put("h1501o0a", bi.h1501o0ay.isChecked() ? "1"
                : bi.h1501o0an.isChecked() ? "2"
                : "-1");

        json.put("h1501o0b", bi.h1501o0by.isChecked() ? "1"
                : bi.h1501o0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501o0c", bi.h1501o0cy.isChecked() ? "1"
                : bi.h1501o0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501o0dy", bi.h1501o0dy.getText().toString());

        json.put("h1501o0dn", bi.h1501o0dn.getText().toString());

        json.put("h1501p0a", bi.h1501p0ay.isChecked() ? "1"
                : bi.h1501p0an.isChecked() ? "2"
                : "-1");

        json.put("h1501p0b", bi.h1501p0by.isChecked() ? "1"
                : bi.h1501p0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501p0c", bi.h1501p0cy.isChecked() ? "1"
                : bi.h1501p0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501p0dy", bi.h1501p0dy.getText().toString());

        json.put("h1501p0dn", bi.h1501p0dn.getText().toString());

        json.put("h1501q0a", bi.h1501q0ay.isChecked() ? "1"
                : bi.h1501q0an.isChecked() ? "2"
                : "-1");

        json.put("h1501q0b", bi.h1501q0by.isChecked() ? "1"
                : bi.h1501q0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501q0c", bi.h1501q0cy.isChecked() ? "1"
                : bi.h1501q0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501q0dy", bi.h1501q0dy.getText().toString());

        json.put("h1501q0dn", bi.h1501q0dn.getText().toString());

        json.put("h1501r0a", bi.h1501r0ay.isChecked() ? "1"
                : bi.h1501r0an.isChecked() ? "2"
                : "-1");

        json.put("h1501r0b", bi.h1501r0by.isChecked() ? "1"
                : bi.h1501r0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501r0c", bi.h1501r0cy.isChecked() ? "1"
                : bi.h1501r0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501r0dy", bi.h1501r0dy.getText().toString());

        json.put("h1501r0dn", bi.h1501r0dn.getText().toString());

        json.put("h1501s0a", bi.h1501s0ay.isChecked() ? "1"
                : bi.h1501s0an.isChecked() ? "2"
                : "-1");

        json.put("h1501s0b", bi.h1501s0by.isChecked() ? "1"
                : bi.h1501s0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501s0c", bi.h1501s0cy.isChecked() ? "1"
                : bi.h1501s0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501s0dy", bi.h1501s0dy.getText().toString());

        json.put("h1501s0dn", bi.h1501s0dn.getText().toString());

        json.put("h1501t0a", bi.h1501t0ay.isChecked() ? "1"
                : bi.h1501t0an.isChecked() ? "2"
                : "-1");

        json.put("h1501t0b", bi.h1501t0by.isChecked() ? "1"
                : bi.h1501t0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501t0c", bi.h1501t0cy.isChecked() ? "1"
                : bi.h1501t0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501t0dy", bi.h1501t0dy.getText().toString());

        json.put("h1501t0dn", bi.h1501t0dn.getText().toString());

        json.put("h1501u0a", bi.h1501u0ay.isChecked() ? "1"
                : bi.h1501u0an.isChecked() ? "2"
                : "-1");

        json.put("h1501u0b", bi.h1501u0by.isChecked() ? "1"
                : bi.h1501u0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501u0c", bi.h1501u0cy.isChecked() ? "1"
                : bi.h1501u0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501u0dy", bi.h1501u0dy.getText().toString());

        json.put("h1501u0dn", bi.h1501u0dn.getText().toString());

        json.put("h1501v0a", bi.h1501v0ay.isChecked() ? "1"
                : bi.h1501v0an.isChecked() ? "2"
                : "-1");

        json.put("h1501v0b", bi.h1501v0by.isChecked() ? "1"
                : bi.h1501v0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501v0c", bi.h1501v0cy.isChecked() ? "1"
                : bi.h1501v0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501v0dy", bi.h1501v0dy.getText().toString());

        json.put("h1501v0dn", bi.h1501v0dn.getText().toString());

        json.put("h1501w0a", bi.h1501w0ay.isChecked() ? "1"
                : bi.h1501w0an.isChecked() ? "2"
                : "-1");

        json.put("h1501w0b", bi.h1501w0by.isChecked() ? "1"
                : bi.h1501w0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501w0c", bi.h1501w0cy.isChecked() ? "1"
                : bi.h1501w0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501w0dy", bi.h1501w0dy.getText().toString());

        json.put("h1501w0dn", bi.h1501w0dn.getText().toString());

        json.put("h1501x0a", bi.h1501x0ay.isChecked() ? "1"
                : bi.h1501x0an.isChecked() ? "2"
                : "-1");

        json.put("h1501x0b", bi.h1501x0by.isChecked() ? "1"
                : bi.h1501x0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501x0c", bi.h1501x0cy.isChecked() ? "1"
                : bi.h1501x0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501x0dy", bi.h1501x0dy.getText().toString());

        json.put("h1501x0dn", bi.h1501x0dn.getText().toString());

        json.put("h1501y0a", bi.h1501y0ay.isChecked() ? "1"
                : bi.h1501y0an.isChecked() ? "2"
                : "-1");

        json.put("h1501y0b", bi.h1501y0by.isChecked() ? "1"
                : bi.h1501y0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501y0c", bi.h1501y0cy.isChecked() ? "1"
                : bi.h1501y0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501y0dy", bi.h1501y0dy.getText().toString());

        json.put("h1501y0dn", bi.h1501y0dn.getText().toString());

        json.put("h1501z0a", bi.h1501z0ay.isChecked() ? "1"
                : bi.h1501z0an.isChecked() ? "2"
                : "-1");

        json.put("h1501z0b", bi.h1501z0by.isChecked() ? "1"
                : bi.h1501z0bn.isChecked() ? "2"
                : "-1");

        json.put("h1501z0c", bi.h1501z0cy.isChecked() ? "1"
                : bi.h1501z0cn.isChecked() ? "2"
                : "-1");

        json.put("h1501z0dy", bi.h1501z0dy.getText().toString());

        json.put("h1501z0dn", bi.h1501z0dn.getText().toString());

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
