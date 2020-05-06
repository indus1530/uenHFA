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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionIBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionIActivity extends AppCompatActivity {

    ActivitySectionIBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i);
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
        json.put("i11",
                bi.i11a.isChecked() ? "1" :
                        bi.i11b.isChecked() ? "2" :
                                "-1");
        json.put("i12", bi.i12.getText().toString());
        //json.put("i12a", bi.i12a.getText().toString());
        json.put("i12aa", bi.i12aa.getText().toString());
        json.put("i12ab", bi.i12ab.getText().toString());
        json.put("i12ac", bi.i12ac.getText().toString());
        //json.put("i12b", bi.i12b.getText().toString());
        json.put("i12ba", bi.i12ba.getText().toString());
        json.put("i12bb", bi.i12bb.getText().toString());
        json.put("i13",
                bi.i13a.isChecked() ? "1" :
                        bi.i13b.isChecked() ? "2" :
                                "-1");
        json.put("i14",
                bi.i14a.isChecked() ? "1" :
                        bi.i14b.isChecked() ? "2" :
                                bi.i14c.isChecked() ? "3" :
                                        bi.i14d.isChecked() ? "4" :
                                                "-1");
        json.put("i15",
                bi.i15a.isChecked() ? "1" :
                        bi.i15b.isChecked() ? "2" :
                                "-1");
        //json.put("i16", bi.i16.getText().toString());
        json.put("i16a", bi.i16a.getText().toString());
        json.put("i16b", bi.i16b.getText().toString());
        json.put("i17",
                bi.i17a.isChecked() ? "1" :
                        bi.i17b.isChecked() ? "2" :
                                "-1");
        json.put("i18",
                bi.i18a.isChecked() ? "1" :
                        bi.i18b.isChecked() ? "2" :
                                "-1");
        json.put("i19a",
                bi.i19aa.isChecked() ? "1" :
                        bi.i19ab.isChecked() ? "2" :
                                "-1");
        json.put("i19b",
                bi.i19ba.isChecked() ? "1" :
                        bi.i19bb.isChecked() ? "2" :
                                "-1");
        json.put("i19c",
                bi.i19ca.isChecked() ? "1" :
                        bi.i19cb.isChecked() ? "2" :
                                "-1");
        json.put("i19d",
                bi.i19da.isChecked() ? "1" :
                        bi.i19db.isChecked() ? "2" :
                                "-1");
        json.put("i19e",
                bi.i19ea.isChecked() ? "1" :
                        bi.i19eb.isChecked() ? "2" :
                                "-1");
        json.put("i19f",
                "-1");
        json.put("i19fa",
                bi.i19fb.isChecked() ? "2" :
                        bi.i19g.isChecked() ? "" :
                                "-1");
        json.put("i19ga",
                "-1");
        json.put("i19gb",
                "-1");
        json.put("i19h",
                bi.i19ha.isChecked() ? "1" :
                        bi.i19hb.isChecked() ? "2" :
                                "-1");
        json.put("i19i",
                bi.i19ia.isChecked() ? "1" :
                        bi.i19ib.isChecked() ? "2" :
                                bi.i19ic.isChecked() ? "3" :
                                        "-1");
        json.put("i19ja", bi.i19ja.isChecked() ? "1" : "-1");
        json.put("i19jb", bi.i19jb.isChecked() ? "2" : "-1");
        json.put("i19jc", bi.i19jc.isChecked() ? "3" : "-1");
        json.put("i19jd", bi.i19jd.isChecked() ? "4" : "-1");
        json.put("i19je", bi.i19je.isChecked() ? "5" : "-1");
        json.put("i19k",
                bi.i19ka.isChecked() ? "1" :
                        bi.i19kb.isChecked() ? "2" :
                                bi.i19kc.isChecked() ? "3" :
                                        "-1");
        json.put("i19la", bi.i19la.isChecked() ? "1" : "-1");
        json.put("i19lb", bi.i19lb.isChecked() ? "2" : "-1");
        json.put("i19lc", bi.i19lc.isChecked() ? "3" : "-1");
        json.put("i19m",
                bi.i19ma.isChecked() ? "1" :
                        bi.i19mb.isChecked() ? "2" :
                                "-1");
        json.put("i19n",
                bi.i19na.isChecked() ? "1" :
                        bi.i19nb.isChecked() ? "2" :
                                "-1");
        json.put("i19o",
                bi.i19oa.isChecked() ? "1" :
                        bi.i19ob.isChecked() ? "2" :
                                "-1");
        json.put("i19pa", bi.i19pa.isChecked() ? "1" : "-1");
        json.put("i19pb", bi.i19pb.isChecked() ? "2" : "-1");
        json.put("i19pc", bi.i19pc.isChecked() ? "3" : "-1");
        json.put("i19pd", bi.i19pd.isChecked() ? "4" : "-1");
        json.put("i19pe", bi.i19pe.isChecked() ? "5" : "-1");
        json.put("i19pf", bi.i19pf.isChecked() ? "6" : "-1");
        json.put("i19q",
                bi.i19qa.isChecked() ? "1" :
                        bi.i19qb.isChecked() ? "2" :
                                "-1");
        json.put("i110a",
                bi.i110aa.isChecked() ? "1" :
                        bi.i110ab.isChecked() ? "2" :
                                "-1");
        json.put("i110b",
                bi.i110ba.isChecked() ? "1" :
                        bi.i110bb.isChecked() ? "2" :
                                "-1");
        json.put("i110c",
                bi.i110ca.isChecked() ? "1" :
                        bi.i110cb.isChecked() ? "2" :
                                "-1");
        json.put("i110d",
                bi.i110da.isChecked() ? "1" :
                        bi.i110db.isChecked() ? "2" :
                                "-1");
        json.put("i110e",
                bi.i110ea.isChecked() ? "1" :
                        bi.i110eb.isChecked() ? "2" :
                                "-1");
        json.put("i110f",
                bi.i110fa.isChecked() ? "1" :
                        bi.i110fb.isChecked() ? "2" :
                                "-1");
        json.put("i110g",
                bi.i110ga.isChecked() ? "1" :
                        bi.i110gb.isChecked() ? "2" :
                                "-1");
        json.put("i110h",
                bi.i110ha.isChecked() ? "1" :
                        bi.i110hb.isChecked() ? "2" :
                                "-1");
        json.put("i110i",
                bi.i110ia.isChecked() ? "1" :
                        bi.i110ib.isChecked() ? "2" :
                                "-1");
        json.put("i110j",
                bi.i110ja.isChecked() ? "1" :
                        bi.i110jb.isChecked() ? "2" :
                                "-1");
        json.put("i110k",
                bi.i110ka.isChecked() ? "1" :
                        bi.i110kb.isChecked() ? "2" :
                                "-1");
        json.put("i111a",
                bi.i111aa.isChecked() ? "1" :
                        bi.i111ab.isChecked() ? "2" :
                                bi.i111ac.isChecked() ? "3" :
                                        bi.i111ad.isChecked() ? "4" :
                                                "-1");
        json.put("i111b",
                bi.i111ba.isChecked() ? "1" :
                        bi.i111bb.isChecked() ? "2" :
                                bi.i111bc.isChecked() ? "3" :
                                        bi.i111bd.isChecked() ? "4" :
                                                "-1");
        json.put("i111c",
                bi.i111ca.isChecked() ? "1" :
                        bi.i111cb.isChecked() ? "2" :
                                bi.i111cc.isChecked() ? "3" :
                                        bi.i111cd.isChecked() ? "4" :
                                                "-1");
        json.put("i111d",
                bi.i111da.isChecked() ? "1" :
                        bi.i111db.isChecked() ? "2" :
                                bi.i111dc.isChecked() ? "3" :
                                        bi.i111dd.isChecked() ? "4" :
                                                "-1");
        json.put("i111e",
                bi.i111ea.isChecked() ? "1" :
                        bi.i111eb.isChecked() ? "2" :
                                bi.i111ec.isChecked() ? "3" :
                                        bi.i111ed.isChecked() ? "4" :
                                                "-1");
        json.put("i111f",
                bi.i111fa.isChecked() ? "1" :
                        bi.i111fb.isChecked() ? "2" :
                                bi.i111fc.isChecked() ? "3" :
                                        bi.i111fd.isChecked() ? "4" :
                                                "-1");
        json.put("i111g",
                bi.i111ga.isChecked() ? "1" :
                        bi.i111gb.isChecked() ? "2" :
                                bi.i111gc.isChecked() ? "3" :
                                        bi.i111gd.isChecked() ? "4" :
                                                "-1");

        MainApp.fc.setsE(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionI);

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
