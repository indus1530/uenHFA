package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE5Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE5Activity extends AppCompatActivity {

    ActivitySectionE5Binding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e5);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupListeners();
    }

    private void setupListeners() {


        /*bi.im01.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.im011.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02, false);
                Clear.clearAllFields(bi.fldGrpCVim02a, false);
            } else if (i == bi.im012.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02, false);
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim02, true);
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
            }

        }));*/

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

        json.put("e0501", bi.e0501a.isChecked() ? "1"
                : bi.e0501b.isChecked() ? "2"
                : "-1");

        json.put("e0502", "-1");

        json.put("e0502a", bi.e0502aa.isChecked() ? "1"
                : bi.e0502ab.isChecked() ? "2"
                : "-1");

        json.put("e0502b", bi.e0502ba.isChecked() ? "1"
                : bi.e0502bb.isChecked() ? "2"
                : "-1");

        json.put("e0502c", bi.e0502ca.isChecked() ? "1"
                : bi.e0502cb.isChecked() ? "2"
                : "-1");

        json.put("e0502d", bi.e0502da.isChecked() ? "1"
                : bi.e0502db.isChecked() ? "2"
                : "-1");

        json.put("e0502e", bi.e0502ea.isChecked() ? "1"
                : bi.e0502eb.isChecked() ? "2"
                : "-1");

        json.put("e0502f", bi.e0502fa.isChecked() ? "1"
                : bi.e0502fb.isChecked() ? "2"
                : "-1");

        json.put("e0502g", bi.e0502ga.isChecked() ? "1"
                : bi.e0502gb.isChecked() ? "2"
                : "-1");

        json.put("e0502h", bi.e0502ha.isChecked() ? "1"
                : bi.e0502hb.isChecked() ? "2"
                : "-1");

        json.put("e0502i", bi.e0502ia.isChecked() ? "1"
                : bi.e0502ib.isChecked() ? "2"
                : "-1");

        json.put("e0503", bi.e0503a.isChecked() ? "1"
                : bi.e0503b.isChecked() ? "2"
                : bi.e0503c.isChecked() ? "3"
                : "-1");

        json.put("e0504", bi.e0504a.isChecked() ? "1"
                : bi.e0504b.isChecked() ? "2"
                : "-1");

        json.put("e0505", bi.e0505a.isChecked() ? "1"
                : bi.e0505b.isChecked() ? "2"
                : bi.e0505c.isChecked() ? "3"
                : "-1");

        json.put("e0506", bi.e0506a.isChecked() ? "1"
                : bi.e0506b.isChecked() ? "2"
                : "-1");

        json.put("e0507", bi.e0507a.isChecked() ? "1"
                : bi.e0507b.isChecked() ? "2"
                : "-1");

        json.put("e0508", bi.e0508a.isChecked() ? "1"
                : bi.e0508b.isChecked() ? "2"
                : "-1");

        json.put("e0509", bi.e0509a.isChecked() ? "1"
                : bi.e0509b.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionE6Activity.class).putExtra(IM02FLAG, !im02Flag));

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
