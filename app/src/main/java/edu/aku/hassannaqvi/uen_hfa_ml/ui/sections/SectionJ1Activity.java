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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ1Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJ1Activity extends AppCompatActivity {

    ActivitySectionJ1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j1);
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

        json.put("j0100", bi.j0100a.isChecked() ? "1"
                : bi.j0100b.isChecked() ? "2"
                : "-1");

        json.put("j0100aa", bi.j0100aaa.isChecked() ? "1"
                : bi.j0100aab.isChecked() ? "2"
                : "-1");

        json.put("j0101a", bi.j0101aa.isChecked() ? "1"
                : bi.j0101ab.isChecked() ? "2"
                : "-1");

        json.put("j0101b", bi.j0101ba.isChecked() ? "1"
                : bi.j0101bb.isChecked() ? "2"
                : "-1");

        json.put("j0101c", bi.j0101ca.isChecked() ? "1"
                : bi.j0101cb.isChecked() ? "2"
                : "-1");

        json.put("j0101d", bi.j0101da.isChecked() ? "1"
                : bi.j0101db.isChecked() ? "2"
                : "-1");

        json.put("j0101e", bi.j0101ea.isChecked() ? "1"
                : bi.j0101eb.isChecked() ? "2"
                : "-1");

        json.put("j0101f", bi.j0101fa.isChecked() ? "1"
                : bi.j0101fb.isChecked() ? "2"
                : "-1");

        json.put("j0101g", bi.j0101ga.isChecked() ? "1"
                : bi.j0101gb.isChecked() ? "2"
                : "-1");

        json.put("j0101h", bi.j0101ha.isChecked() ? "1"
                : bi.j0101hb.isChecked() ? "2"
                : "-1");

        json.put("j0101i", "-1");

        json.put("j0101ia", bi.j0101iaa.isChecked() ? "1"
                : bi.j0101iab.isChecked() ? "2"
                : "-1");

        json.put("j0101ib", bi.j0101iba.isChecked() ? "1"
                : bi.j0101ibb.isChecked() ? "2"
                : "-1");

        json.put("j0101j", bi.j0101ja.isChecked() ? "1"
                : bi.j0101jb.isChecked() ? "2"
                : "-1");

        json.put("j0101k", bi.j0101ka.isChecked() ? "1"
                : bi.j0101kb.isChecked() ? "2"
                : "-1");

        json.put("j0101l", bi.j0101la.isChecked() ? "1"
                : bi.j0101lb.isChecked() ? "2"
                : "-1");

        json.put("j0101ma", bi.j0101ma.isChecked() ? "1" : "-1");
        json.put("j0101mb", bi.j0101mb.isChecked() ? "2" : "-1");
        json.put("j0101mc", bi.j0101mc.isChecked() ? "3" : "-1");
        json.put("j0101md", bi.j0101md.isChecked() ? "4" : "-1");
        json.put("j0101me", bi.j0101me.isChecked() ? "5" : "-1");
        json.put("j0101mf", bi.j0101mf.isChecked() ? "6" : "-1");
        json.put("j0101mx", bi.j0101mx.isChecked() ? "96" : "-1");
        json.put("j0101mxx", bi.j0101mxx.getText().toString());

        MainApp.fc.setsM(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ1);

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