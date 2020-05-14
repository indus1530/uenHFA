package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE2Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE2Activity extends AppCompatActivity {

    ActivitySectionE2Binding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e2);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupSkips();
    }

    private void setupSkips() {


        bi.e0201.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0201b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece201);
            }
        }));

        /*bi.im02.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im021.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02a, false);
//                Clear.clearAllFields(bi.fldGrpSecChc2, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
//                Clear.clearAllFields(bi.fldGrpSecChc2, true);
            }

            Clear.clearAllFields(bi.fldGrpCVim02a, i == bi.im022.getId());
            im02Flag = i == bi.im021.getId();

        });*/

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SCC, child.getsCC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0201", bi.e0201a.isChecked() ? "1"
                : bi.e0201b.isChecked() ? "2"
                : "-1");

        json.put("e0202", "-1");

        json.put("e0202a", bi.e0202aa.isChecked() ? "1"
                : bi.e0202ab.isChecked() ? "2"
                : "-1");

        json.put("e0202b", bi.e0202ba.isChecked() ? "1"
                : bi.e0202bb.isChecked() ? "2"
                : "-1");

        json.put("e0202c", bi.e0202ca.isChecked() ? "1"
                : bi.e0202cb.isChecked() ? "2"
                : "-1");

        json.put("e0202d", bi.e0202da.isChecked() ? "1"
                : bi.e0202db.isChecked() ? "2"
                : "-1");

        json.put("e0202e", bi.e0202ea.isChecked() ? "1"
                : bi.e0203eb.isChecked() ? "2"
                : "-1");

        json.put("e0202f", bi.e0202fa.isChecked() ? "1"
                : bi.e0202fb.isChecked() ? "2"
                : "-1");

        json.put("e0203efb", "-1");

        json.put("e0203a", bi.e0203aa.isChecked() ? "1"
                : bi.e0203ab.isChecked() ? "2"
                : bi.e0203.isChecked() ? "3"
                : "-1");

        json.put("e0203b", bi.e0203ba.isChecked() ? "1"
                : bi.e0203bb.isChecked() ? "2"
                : bi.e0203bc.isChecked() ? "3"
                : "-1");

        json.put("e0204", "-1");

        json.put("e0204a", bi.e0204aa.isChecked() ? "1"
                : bi.e0204ab.isChecked() ? "2"
                : "-1");

        json.put("e0204b", bi.e0204b.getText().toString());

        json.put("e0204c", bi.e0204ca.isChecked() ? "1"
                : bi.e0204cb.isChecked() ? "2"
                : bi.e0204cc.isChecked() ? "3"
                : bi.e0204cd.isChecked() ? "4"
                : "-1");

        json.put("e0204d", bi.e0204da.isChecked() ? "1"
                : bi.e0204dx.isChecked() ? "96"
                : "-1");

        child.setsCC(String.valueOf(json));

    }

    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionE3Activity.class).putExtra(IM02FLAG, !im02Flag));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
