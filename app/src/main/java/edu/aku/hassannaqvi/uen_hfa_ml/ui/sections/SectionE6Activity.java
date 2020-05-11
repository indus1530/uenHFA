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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE6Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE6Activity extends AppCompatActivity {

    ActivitySectionE6Binding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e6);
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

        json.put("e0601", bi.e0601a.isChecked() ? "1"
                : bi.e0601b.isChecked() ? "2"
                : "-1");

        json.put("e0602", bi.e0602a.isChecked() ? "1"
                : bi.e0602b.isChecked() ? "2"
                : "-1");

        json.put("e0603", bi.e0603a.isChecked() ? "1"
                : bi.e0603b.isChecked() ? "2"
                : "-1");

        json.put("e0604", bi.e0604a.isChecked() ? "1"
                : bi.e0604b.isChecked() ? "2"
                : "-1");

        json.put("e0605", "-1");

        json.put("e0605a", bi.e0605aa.isChecked() ? "1"
                : bi.e0605ab.isChecked() ? "2"
                : bi.e0605ac.isChecked() ? "3"
                : bi.e0605ad.isChecked() ? "4"
                : "-1");

        json.put("e0605b", bi.e0605ba.isChecked() ? "1"
                : bi.e0605bb.isChecked() ? "2"
                : bi.e0605bc.isChecked() ? "3"
                : bi.e0605bd.isChecked() ? "4"
                : "-1");

        json.put("e0605c", bi.e0605ca.isChecked() ? "1"
                : bi.e0605cb.isChecked() ? "2"
                : bi.e0605cc.isChecked() ? "3"
                : bi.e0605cd.isChecked() ? "4"
                : "-1");

        json.put("e0605d", bi.e0605da.isChecked() ? "1"
                : bi.e0605db.isChecked() ? "2"
                : bi.e0605dc.isChecked() ? "3"
                : bi.e0605dd.isChecked() ? "4"
                : "-1");

        json.put("e0606", bi.e0606a.isChecked() ? "1"
                : bi.e0606b.isChecked() ? "2"
                : bi.e0606c.isChecked() ? "3"
                : bi.e0606d.isChecked() ? "4"
                : "-1");

        json.put("e0607", bi.e0607a.isChecked() ? "1"
                : bi.e0607b.isChecked() ? "2"
                : bi.e0607c.isChecked() ? "3"
                : "-1");

        json.put("e0608", bi.e0608a.isChecked() ? "1"
                : bi.e0608b.isChecked() ? "2"
                : bi.e0608c.isChecked() ? "3"
                : "-1");

        json.put("e0609", bi.e0609a.isChecked() ? "1"
                : bi.e0609b.isChecked() ? "2"
                : bi.e0609c.isChecked() ? "3"
                : bi.e0609d.isChecked() ? "4"
                : "-1");

        json.put("e0610", bi.e0610a.isChecked() ? "1"
                : bi.e0610b.isChecked() ? "2"
                : bi.e0610c.isChecked() ? "3"
                : "-1");

        json.put("e0611", bi.e0611a.isChecked() ? "1"
                : bi.e0611b.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionFActivity.class).putExtra(IM02FLAG, !im02Flag));

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
