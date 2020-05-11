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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE8Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE8Activity extends AppCompatActivity {

    ActivitySectionE8Binding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e8);
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
        json.put("e0801", bi.e0801a.isChecked() ? "1"
                : bi.e0801b.isChecked() ? "2"
                : "-1");

        json.put("e0802", bi.e0802a.isChecked() ? "1"
                : bi.e0802b.isChecked() ? "2"
                : "-1");

        json.put("e0803", bi.e0803a.isChecked() ? "1"
                : bi.e0803b.isChecked() ? "2"
                : "-1");

        json.put("e0804", bi.e0804a.isChecked() ? "1"
                : bi.e0804b.isChecked() ? "2"
                : "-1");

        json.put("e0805", bi.e0805a.isChecked() ? "1"
                : bi.e0805b.isChecked() ? "2"
                : "-1");

        json.put("e0806", bi.e0806a.isChecked() ? "1"
                : bi.e0806b.isChecked() ? "2"
                : "-1");

        json.put("e0807", bi.e0807a.isChecked() ? "1"
                : bi.e0807b.isChecked() ? "2"
                : "-1");

        json.put("e0808", bi.e0808a.isChecked() ? "1"
                : bi.e0808b.isChecked() ? "2"
                : "-1");

        json.put("e0809", bi.e0809a.isChecked() ? "1"
                : bi.e0809b.isChecked() ? "2"
                : "-1");

        json.put("e0810", bi.e0810a.isChecked() ? "1"
                : bi.e0810b.isChecked() ? "2"
                : "-1");

        json.put("e0811", bi.e0811a.isChecked() ? "1"
                : bi.e0811b.isChecked() ? "2"
                : "-1");

        json.put("e0812", bi.e0812a.isChecked() ? "1"
                : bi.e0812b.isChecked() ? "2"
                : "-1");

        json.put("e0813", bi.e0813a.isChecked() ? "1"
                : bi.e0813b.isChecked() ? "2"
                : "-1");

        json.put("e0814", bi.e0814a.isChecked() ? "1"
                : bi.e0814b.isChecked() ? "2"
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
