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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG421Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG421Activity extends AppCompatActivity {

    ActivitySectionG421Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g421);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040210s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040210sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040210so);
            }
        }));

        bi.g040220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040220so);
            }
        }));

        bi.g040230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040230so);
            }
        }));

        bi.g040240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040240so);
            }
        }));

        bi.g040250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040250so);
            }
        }));

        bi.g040260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040260so);
            }
        }));

        bi.g040270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040270so);
            }
        }));

        bi.g040280s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040280sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040280so);
            }
        }));

        bi.g040290s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040290sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040290so);
            }
        }));

        bi.g0402100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0402100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0402100so);
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


        MainApp.fc.g040210a = bi.g040210ay.isChecked() ? "1"
                : bi.g040210an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040210s = bi.g040210sy.isChecked() ? "1"
                : bi.g040210sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040210sd = bi.g040210sd.getText().toString().trim().length() > 0 ? bi.g040210sd.getText().toString() : "-1";
        MainApp.fc.g040210sm = bi.g040210sm.getText().toString().trim().length() > 0 ? bi.g040210sm.getText().toString() : "-1";

        MainApp.fc.g040210p = bi.g040210py.isChecked() ? "1"
                : bi.g040210pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040220a = bi.g040220ay.isChecked() ? "1"
                : bi.g040220an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040220s = bi.g040220sy.isChecked() ? "1"
                : bi.g040220sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040220sd = bi.g040220sd.getText().toString().trim().length() > 0 ? bi.g040220sd.getText().toString() : "-1";
        MainApp.fc.g040220sm = bi.g040220sm.getText().toString().trim().length() > 0 ? bi.g040220sm.getText().toString() : "-1";

        MainApp.fc.g040220p = bi.g040220py.isChecked() ? "1"
                : bi.g040220pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040230a = bi.g040230ay.isChecked() ? "1"
                : bi.g040230an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040230s = bi.g040230sy.isChecked() ? "1"
                : bi.g040230sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040230sd = bi.g040230sd.getText().toString().trim().length() > 0 ? bi.g040230sd.getText().toString() : "-1";
        MainApp.fc.g040230sm = bi.g040230sm.getText().toString().trim().length() > 0 ? bi.g040230sm.getText().toString() : "-1";

        MainApp.fc.g040230p = bi.g040230py.isChecked() ? "1"
                : bi.g040230pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040240a = bi.g040240ay.isChecked() ? "1"
                : bi.g040240an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040240s = bi.g040240sy.isChecked() ? "1"
                : bi.g040240sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040240sd = bi.g040240sd.getText().toString().trim().length() > 0 ? bi.g040240sd.getText().toString() : "-1";
        MainApp.fc.g040240sm = bi.g040240sm.getText().toString().trim().length() > 0 ? bi.g040240sm.getText().toString() : "-1";

        MainApp.fc.g040240p = bi.g040240py.isChecked() ? "1"
                : bi.g040240pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040250a = bi.g040250ay.isChecked() ? "1"
                : bi.g040250an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040250s = bi.g040250sy.isChecked() ? "1"
                : bi.g040250sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040250sd = bi.g040250sd.getText().toString().trim().length() > 0 ? bi.g040250sd.getText().toString() : "-1";
        MainApp.fc.g040250sm = bi.g040250sm.getText().toString().trim().length() > 0 ? bi.g040250sm.getText().toString() : "-1";

        MainApp.fc.g040250p = bi.g040250py.isChecked() ? "1"
                : bi.g040250pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040260a = bi.g040260ay.isChecked() ? "1"
                : bi.g040260an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040260s = bi.g040260sy.isChecked() ? "1"
                : bi.g040260sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040260sd = bi.g040260sd.getText().toString().trim().length() > 0 ? bi.g040260sd.getText().toString() : "-1";
        MainApp.fc.g040260sm = bi.g040260sm.getText().toString().trim().length() > 0 ? bi.g040260sm.getText().toString() : "-1";

        MainApp.fc.g040260p = bi.g040260py.isChecked() ? "1"
                : bi.g040260pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040270a = bi.g040270ay.isChecked() ? "1"
                : bi.g040270an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040270s = bi.g040270sy.isChecked() ? "1"
                : bi.g040270sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040270sd = bi.g040270sd.getText().toString().trim().length() > 0 ? bi.g040270sd.getText().toString() : "-1";
        MainApp.fc.g040270sm = bi.g040270sm.getText().toString().trim().length() > 0 ? bi.g040270sm.getText().toString() : "-1";

        MainApp.fc.g040270p = bi.g040270py.isChecked() ? "1"
                : bi.g040270pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040280a = bi.g040280ay.isChecked() ? "1"
                : bi.g040280an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040280s = bi.g040280sy.isChecked() ? "1"
                : bi.g040280sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040280sd = bi.g040280sd.getText().toString().trim().length() > 0 ? bi.g040280sd.getText().toString() : "-1";
        MainApp.fc.g040280sm = bi.g040280sm.getText().toString().trim().length() > 0 ? bi.g040280sm.getText().toString() : "-1";

        MainApp.fc.g040280p = bi.g040280py.isChecked() ? "1"
                : bi.g040280pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040290a = bi.g040290ay.isChecked() ? "1"
                : bi.g040290an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040290s = bi.g040290sy.isChecked() ? "1"
                : bi.g040290sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040290sd = bi.g040290sd.getText().toString().trim().length() > 0 ? bi.g040290sd.getText().toString() : "-1";
        MainApp.fc.g040290sm = bi.g040290sm.getText().toString().trim().length() > 0 ? bi.g040290sm.getText().toString() : "-1";

        MainApp.fc.g040290p = bi.g040290py.isChecked() ? "1"
                : bi.g040290pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g0402100a = bi.g0402100ay.isChecked() ? "1"
                : bi.g0402100an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0402100s = bi.g0402100sy.isChecked() ? "1"
                : bi.g0402100sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0402100sd = bi.g0402100sd.getText().toString().trim().length() > 0 ? bi.g0402100sd.getText().toString() : "-1";
        MainApp.fc.g0402100sm = bi.g0402100sm.getText().toString().trim().length() > 0 ? bi.g0402100sm.getText().toString() : "-1";

        MainApp.fc.g0402100p = bi.g0402100py.isChecked() ? "1"
                : bi.g0402100pn.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionG422Activity.class));
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
