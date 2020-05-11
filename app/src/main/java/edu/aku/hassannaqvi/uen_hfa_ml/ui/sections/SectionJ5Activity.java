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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ5Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ5Activity extends AppCompatActivity {

    ActivitySectionJ5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j5);
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
                /*selectedChildren = FamilyMembersListActivity.mainVModel.getAllUnder12();
                Class<?> T = EndingActivity.class;
                if (selectedChildren.getFirst().size() > 0) T = SectionCHAActivity.class;*/
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SM, MainApp.fc.getsM());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j0500", bi.j0500a.isChecked() ? "1"
                : bi.j0500b.isChecked() ? "2"
                : "-1");

        json.put("j0500aa", bi.j0500aaa.isChecked() ? "1"
                : bi.j0500aab.isChecked() ? "2"
                : "-1");

        json.put("j0501a", bi.j0501aa.isChecked() ? "1"
                : bi.j0501ab.isChecked() ? "2"
                : "-1");

        json.put("j0501b", bi.j0501ba.isChecked() ? "1"
                : bi.j0501bb.isChecked() ? "2"
                : "-1");

        json.put("j0501c", bi.j0501ca.isChecked() ? "1"
                : bi.j0501cb.isChecked() ? "2"
                : "-1");

        json.put("j0501d", bi.j0501da.isChecked() ? "1"
                : bi.j0501db.isChecked() ? "2"
                : "-1");

        json.put("j0501e", bi.j0501ea.isChecked() ? "1"
                : bi.j0501eb.isChecked() ? "2"
                : "-1");

        json.put("j0501f", bi.j0501fa.isChecked() ? "1"
                : bi.j0501fb.isChecked() ? "2"
                : "-1");

        json.put("j0501g", bi.j0501ga.isChecked() ? "1"
                : bi.j0501gb.isChecked() ? "2"
                : "-1");

        json.put("j0501h", bi.j0501ha.isChecked() ? "1"
                : bi.j0501hb.isChecked() ? "2"
                : "-1");

        json.put("j0501i", bi.j0501ia.isChecked() ? "1"
                : bi.j0501ib.isChecked() ? "2"
                : "-1");

        json.put("j0501j", bi.j0501ja.isChecked() ? "1"
                : bi.j0501jb.isChecked() ? "2"
                : "-1");

        json.put("j0501k", bi.j0501ka.isChecked() ? "1"
                : bi.j0501kb.isChecked() ? "2"
                : "-1");

        json.put("j0501l", bi.j0501la.isChecked() ? "1"
                : bi.j0501lb.isChecked() ? "2"
                : "-1");

        json.put("j0501m", bi.j0501ma.isChecked() ? "1"
                : bi.j0501mb.isChecked() ? "2"
                : "-1");

        json.put("j0501na", bi.j0501na.isChecked() ? "1" : "-1");
        json.put("j0501nb", bi.j0501nb.isChecked() ? "2" : "-1");
        json.put("j0501nc", bi.j0501nc.isChecked() ? "3" : "-1");
        json.put("j0501nd", bi.j0501nd.isChecked() ? "4" : "-1");
        json.put("j0501ne", bi.j0501ne.isChecked() ? "5" : "-1");
        json.put("j0501nf", bi.j0501nf.isChecked() ? "6" : "-1");
        json.put("j0501nx", bi.j0501nx.isChecked() ? "96" : "-1");
        json.put("j0501nxx", bi.j0501nxx.getText().toString());

        MainApp.fc.setsM(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ5);

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
