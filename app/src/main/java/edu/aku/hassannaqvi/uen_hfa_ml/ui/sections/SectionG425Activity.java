package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG425Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG425Activity extends AppCompatActivity {

    ActivitySectionG425Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g425);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040410so);
            }
        }));

        bi.g040420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040420so);
            }
        }));

        bi.g040430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040430so);
            }
        }));

        bi.g040440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040440so);
            }
        }));

        bi.g040450s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040450sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040450so);
            }
        }));

        bi.g040460s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040460sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040460so);
            }
        }));
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() {


        MainApp.fc.g040410a = bi.g040410ay.isChecked() ? "1"
                : bi.g040410an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040410s = bi.g040410sy.isChecked() ? "1"
                : bi.g040410sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040410sd = bi.g040410sd.getText().toString().trim().length() > 0 ? bi.g040410sd.getText().toString() : "-1";
        MainApp.fc.g040410sm = bi.g040410sm.getText().toString().trim().length() > 0 ? bi.g040410sm.getText().toString() : "-1";

        MainApp.fc.g040410p = bi.g040410py.isChecked() ? "1"
                : bi.g040410pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040420a = bi.g040420ay.isChecked() ? "1"
                : bi.g040420an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040420s = bi.g040420sy.isChecked() ? "1"
                : bi.g040420sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040420sd = bi.g040420sd.getText().toString().trim().length() > 0 ? bi.g040420sd.getText().toString() : "-1";
        MainApp.fc.g040420sm = bi.g040420sm.getText().toString().trim().length() > 0 ? bi.g040420sm.getText().toString() : "-1";

        MainApp.fc.g040420p = bi.g040420py.isChecked() ? "1"
                : bi.g040420pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040430a = bi.g040430ay.isChecked() ? "1"
                : bi.g040430an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040430s = bi.g040430sy.isChecked() ? "1"
                : bi.g040430sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040430sd = bi.g040430sd.getText().toString().trim().length() > 0 ? bi.g040430sd.getText().toString() : "-1";
        MainApp.fc.g040430sm = bi.g040430sm.getText().toString().trim().length() > 0 ? bi.g040430sm.getText().toString() : "-1";

        MainApp.fc.g040430p = bi.g040430py.isChecked() ? "1"
                : bi.g040430pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040440a = bi.g040440ay.isChecked() ? "1"
                : bi.g040440an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040440s = bi.g040440sy.isChecked() ? "1"
                : bi.g040440sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040440sd = bi.g040440sd.getText().toString().trim().length() > 0 ? bi.g040440sd.getText().toString() : "-1";
        MainApp.fc.g040440sm = bi.g040440sm.getText().toString().trim().length() > 0 ? bi.g040440sm.getText().toString() : "-1";

        MainApp.fc.g040440p = bi.g040440py.isChecked() ? "1"
                : bi.g040440pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040450a = bi.g040450ay.isChecked() ? "1"
                : bi.g040450an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040450s = bi.g040450sy.isChecked() ? "1"
                : bi.g040450sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040450sd = bi.g040450sd.getText().toString().trim().length() > 0 ? bi.g040450sd.getText().toString() : "-1";
        MainApp.fc.g040450sm = bi.g040450sm.getText().toString().trim().length() > 0 ? bi.g040450sm.getText().toString() : "-1";

        MainApp.fc.g040450p = bi.g040450py.isChecked() ? "1"
                : bi.g040450pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040460a = bi.g040460ay.isChecked() ? "1"
                : bi.g040460an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040460s = bi.g040460sy.isChecked() ? "1"
                : bi.g040460sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040460sd = bi.g040460sd.getText().toString().trim().length() > 0 ? bi.g040460sd.getText().toString() : "-1";
        MainApp.fc.g040460sm = bi.g040460sm.getText().toString().trim().length() > 0 ? bi.g040460sm.getText().toString() : "-1";

        MainApp.fc.g040460p = bi.g040460py.isChecked() ? "1"
                : bi.g040460pn.isChecked() ? "2"
                : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionMainActivity.class));
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
