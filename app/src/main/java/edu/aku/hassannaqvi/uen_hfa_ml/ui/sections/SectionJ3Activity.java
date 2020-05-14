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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ3Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ3Activity extends AppCompatActivity {

    ActivitySectionJ3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j3);
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
                startActivity(new Intent(this, SectionJ4Activity.class));
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

        json.put("j0300", bi.j0300a.isChecked() ? "1"
                : bi.j0300b.isChecked() ? "2"
                : "-1");

        json.put("j0300aa", bi.j0300aaa.isChecked() ? "1"
                : bi.j0300aab.isChecked() ? "2"
                : "-1");

        json.put("j0301a", bi.j0301aa.isChecked() ? "1"
                : bi.j0301ab.isChecked() ? "2"
                : "-1");

        json.put("j0301b", bi.j0301ba.isChecked() ? "1"
                : bi.j0301bb.isChecked() ? "2"
                : "-1");

        json.put("j0301c", bi.j0301ca.isChecked() ? "1"
                : bi.j0301cb.isChecked() ? "2"
                : "-1");

        json.put("j0301d", bi.j0301da.isChecked() ? "1"
                : bi.j0301db.isChecked() ? "2"
                : "-1");

        json.put("j0301e", bi.j0301ea.isChecked() ? "1"
                : bi.j0301eb.isChecked() ? "2"
                : "-1");

        json.put("j0301f", bi.j0301fa.isChecked() ? "1"
                : bi.j0301fb.isChecked() ? "2"
                : "-1");

        json.put("j0301g", bi.j0301ga.isChecked() ? "1"
                : bi.j0301gb.isChecked() ? "2"
                : "-1");

        json.put("j0301h", bi.j0301ha.isChecked() ? "1"
                : bi.j0301hb.isChecked() ? "2"
                : "-1");

        json.put("j0301i", bi.j0301ia.isChecked() ? "1"
                : bi.j0301ib.isChecked() ? "2"
                : "-1");

        json.put("j0301j", bi.j0301ja.isChecked() ? "1"
                : bi.j0301jb.isChecked() ? "2"
                : "-1");

        json.put("j0301k", bi.j0301ka.isChecked() ? "1"
                : bi.j0301kb.isChecked() ? "2"
                : "-1");

        json.put("j0301l", bi.j0301la.isChecked() ? "1"
                : bi.j0301lb.isChecked() ? "2"
                : "-1");

        json.put("j0301m", bi.j0301ma.isChecked() ? "1"
                : bi.j0301mb.isChecked() ? "2"
                : "-1");

        json.put("j0301n", bi.j0301na.isChecked() ? "1"
                : bi.j0301nb.isChecked() ? "2"
                : "-1");

        json.put("j0301o", bi.j0301oa.isChecked() ? "1"
                : bi.j0301ob.isChecked() ? "2"
                : "-1");

        json.put("j0301p", bi.j0301pa.isChecked() ? "1"
                : bi.j0301pb.isChecked() ? "2"
                : "-1");

        json.put("j0301q", bi.j0301qa.isChecked() ? "1"
                : bi.j0301qb.isChecked() ? "2"
                : "-1");

        json.put("j0301r", bi.j0301ra.isChecked() ? "1"
                : bi.j0301rb.isChecked() ? "2"
                : "-1");

        json.put("j0301s", bi.j0301sa.isChecked() ? "1"
                : bi.j0301sb.isChecked() ? "2"
                : "-1");

        json.put("j0301t", bi.j0301ta.isChecked() ? "1"
                : bi.j0301tb.isChecked() ? "2"
                : "-1");

        json.put("j0301u", bi.j0301ua.isChecked() ? "1"
                : bi.j0301ub.isChecked() ? "2"
                : "-1");

        json.put("j0301v", bi.j0301va.isChecked() ? "1"
                : bi.j0301vb.isChecked() ? "2"
                : "-1");

        json.put("j0301wa", bi.j0301wa.isChecked() ? "1" : "-1");
        json.put("j0301wb", bi.j0301wb.isChecked() ? "2" : "-1");
        json.put("j0301wc", bi.j0301wc.isChecked() ? "3" : "-1");
        json.put("j0301wd", bi.j0301wd.isChecked() ? "4" : "-1");
        json.put("j0301we", bi.j0301we.isChecked() ? "5" : "-1");
        json.put("j0301wf", bi.j0301wf.isChecked() ? "6" : "-1");
        json.put("j0301wx", bi.j0301wx.isChecked() ? "96" : "-1");
        json.put("j0301wxx", bi.j0301wxx.getText().toString());

        MainApp.fc.setsB(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionj3);

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
