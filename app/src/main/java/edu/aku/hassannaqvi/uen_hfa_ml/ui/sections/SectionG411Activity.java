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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG411Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG411Activity extends AppCompatActivity {

    ActivitySectionG411Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g411);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040110s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040110sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040110so);
            }
        }));


        bi.g040120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040120so);
            }
        }));

        bi.g04010s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g04010sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg04010so);
            }
        }));

        bi.g040150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040150so);
            }
        }));

        bi.g040160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040160so);
            }
        }));

        bi.g040170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040170so);
            }
        }));

        bi.g040180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040180so);
            }
        }));

        bi.g040190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040190so);
            }
        }));

        bi.g0401100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401100so);
            }
        }));

        bi.g0401110s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401110sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401110so);
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


        MainApp.fc.g040110a = bi.g040110ay.isChecked() ? "1"
                : bi.g040110an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040110s = bi.g040110sy.isChecked() ? "1"
                : bi.g040110sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040110sd = bi.g040110sd.getText().toString().trim().length() > 0 ? bi.g040110sd.getText().toString() : "-1";
        MainApp.fc.g040110sm = bi.g040110sm.getText().toString().trim().length() > 0 ? bi.g040110sm.getText().toString() : "-1";

        MainApp.fc.g040110p = bi.g040110py.isChecked() ? "1"
                : bi.g040110pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040120a = bi.g040120ay.isChecked() ? "1"
                : bi.g040120an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040120s = bi.g040120sy.isChecked() ? "1"
                : bi.g040120sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040120sd = bi.g040120sd.getText().toString().trim().length() > 0 ? bi.g040120sd.getText().toString() : "-1";
        MainApp.fc.g040120sm = bi.g040120sm.getText().toString().trim().length() > 0 ? bi.g040120sm.getText().toString() : "-1";

        MainApp.fc.g040120p = bi.g040120py.isChecked() ? "1"
                : bi.g040120pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g04013 = bi.g04013a.isChecked() ? "1"
                : bi.g04013b.isChecked() ? "2"
                : "-1";


        MainApp.fc.g04010a = bi.g04010ay.isChecked() ? "1"
                : bi.g04010an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g04010s = bi.g04010sy.isChecked() ? "1"
                : bi.g04010sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g04010sd = bi.g04010sd.getText().toString().trim().length() > 0 ? bi.g04010sd.getText().toString() : "-1";
        MainApp.fc.g04010sm = bi.g04010sm.getText().toString().trim().length() > 0 ? bi.g04010sm.getText().toString() : "-1";

        MainApp.fc.g04010p = bi.g04010py.isChecked() ? "1"
                : bi.g04010pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040150a = bi.g040150ay.isChecked() ? "1"
                : bi.g040150an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040150s = bi.g040150sy.isChecked() ? "1"
                : bi.g040150sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040150sd = bi.g040150sd.getText().toString().trim().length() > 0 ? bi.g040150sd.getText().toString() : "-1";
        MainApp.fc.g040150sm = bi.g040150sm.getText().toString().trim().length() > 0 ? bi.g040150sm.getText().toString() : "-1";

        MainApp.fc.g040150p = bi.g040150py.isChecked() ? "1"
                : bi.g040150pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040160a = bi.g040160ay.isChecked() ? "1"
                : bi.g040160an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040160s = bi.g040160sy.isChecked() ? "1"
                : bi.g040160sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040160sd = bi.g040160sd.getText().toString().trim().length() > 0 ? bi.g040160sd.getText().toString() : "-1";
        MainApp.fc.g040160sm = bi.g040160sm.getText().toString().trim().length() > 0 ? bi.g040160sm.getText().toString() : "-1";

        MainApp.fc.g040160p = bi.g040160py.isChecked() ? "1"
                : bi.g040160pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040170a = bi.g040170ay.isChecked() ? "1"
                : bi.g040170an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040170s = bi.g040170sy.isChecked() ? "1"
                : bi.g040170sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040170sd = bi.g040170sd.getText().toString().trim().length() > 0 ? bi.g040170sd.getText().toString() : "-1";
        MainApp.fc.g040170sm = bi.g040170sm.getText().toString().trim().length() > 0 ? bi.g040170sm.getText().toString() : "-1";

        MainApp.fc.g040170p = bi.g040170py.isChecked() ? "1"
                : bi.g040170pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040180a = bi.g040180ay.isChecked() ? "1"
                : bi.g040180an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040180s = bi.g040180sy.isChecked() ? "1"
                : bi.g040180sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040180sd = bi.g040180sd.getText().toString().trim().length() > 0 ? bi.g040180sd.getText().toString() : "-1";
        MainApp.fc.g040180sm = bi.g040180sm.getText().toString().trim().length() > 0 ? bi.g040180sm.getText().toString() : "-1";

        MainApp.fc.g040180p = bi.g040180py.isChecked() ? "1"
                : bi.g040180pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g040190a = bi.g040190ay.isChecked() ? "1"
                : bi.g040190an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040190s = bi.g040190sy.isChecked() ? "1"
                : bi.g040190sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g040190sd = bi.g040190sd.getText().toString().trim().length() > 0 ? bi.g040190sd.getText().toString() : "-1";
        MainApp.fc.g040190sm = bi.g040190sm.getText().toString().trim().length() > 0 ? bi.g040190sm.getText().toString() : "-1";

        MainApp.fc.g040190p = bi.g040190py.isChecked() ? "1"
                : bi.g040190pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g0401100a = bi.g0401100ay.isChecked() ? "1"
                : bi.g0401100an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0401100s = bi.g0401100sy.isChecked() ? "1"
                : bi.g0401100sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0401100sd = bi.g0401100sd.getText().toString().trim().length() > 0 ? bi.g0401100sd.getText().toString() : "-1";
        MainApp.fc.g0401100sm = bi.g0401100sm.getText().toString().trim().length() > 0 ? bi.g0401100sm.getText().toString() : "-1";

        MainApp.fc.g0401100p = bi.g0401100py.isChecked() ? "1"
                : bi.g0401100pn.isChecked() ? "2"
                : "-1";


        MainApp.fc.g0401110a = bi.g0401110ay.isChecked() ? "1"
                : bi.g0401110an.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0401110s = bi.g0401110sy.isChecked() ? "1"
                : bi.g0401110sn.isChecked() ? "2"
                : "-1";

        MainApp.fc.g0401110sd = bi.g0401110sd.getText().toString().trim().length() > 0 ? bi.g0401110sd.getText().toString() : "-1";
        MainApp.fc.g0401110sm = bi.g0401110sm.getText().toString().trim().length() > 0 ? bi.g0401110sm.getText().toString() : "-1";

        MainApp.fc.g0401110p = bi.g0401110py.isChecked() ? "1"
                : bi.g0401110pn.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionG412Activity.class));

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
