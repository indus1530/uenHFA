package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE33Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE33Activity extends AppCompatActivity {

    ActivitySectionE33Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e33);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0306k0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306k0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306k0f);
            }
        }));

        bi.e0306l0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306l0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306l0f);
            }
        }));

        bi.e0306m0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306m0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306m0f);
            }
        }));

        bi.e0306n0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306n0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306n0f);
            }
        }));

        bi.e0306o0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306o0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306o0f);
            }
        }));

        bi.e0306p0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306p0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306p0f);
            }
        }));

        bi.e0306q0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306q0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306q0f);
            }
        }));

        bi.e0306r0a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0306r0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVe0306r0f);
            }
        }));

    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() {

        MainApp.fc.e0306k0a = bi.e0306k0ay.isChecked() ? "1"
                : bi.e0306k0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306k0ayx = bi.e0306k0ayx.getText().toString().trim().length() > 0 ? bi.e0306k0ayx.getText().toString() : "-1";

        MainApp.fc.e0306k0f = bi.e0306k0fy.isChecked() ? "1"
                : bi.e0306k0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306k0fyx = bi.e0306k0fyx.getText().toString().trim().length() > 0 ? bi.e0306k0fyx.getText().toString() : "-1";


        MainApp.fc.e0306l0a = bi.e0306l0ay.isChecked() ? "1"
                : bi.e0306l0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306l0ayx = bi.e0306l0ayx.getText().toString().trim().length() > 0 ? bi.e0306l0ayx.getText().toString() : "-1";

        MainApp.fc.e0306l0f = bi.e0306l0fy.isChecked() ? "1"
                : bi.e0306l0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306l0fyx = bi.e0306l0fyx.getText().toString().trim().length() > 0 ? bi.e0306l0fyx.getText().toString() : "-1";


        MainApp.fc.e0306m0a = bi.e0306m0ay.isChecked() ? "1"
                : bi.e0306m0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306m0ayx = bi.e0306m0ayx.getText().toString().trim().length() > 0 ? bi.e0306m0ayx.getText().toString() : "-1";

        MainApp.fc.e0306m0f = bi.e0306m0fy.isChecked() ? "1"
                : bi.e0306m0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306m0fyx = bi.e0306m0fyx.getText().toString().trim().length() > 0 ? bi.e0306m0fyx.getText().toString() : "-1";


        MainApp.fc.e0306n0a = bi.e0306n0ay.isChecked() ? "1"
                : bi.e0306n0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306n0ayx = bi.e0306n0ayx.getText().toString().trim().length() > 0 ? bi.e0306n0ayx.getText().toString() : "-1";

        MainApp.fc.e0306n0f = bi.e0306n0fy.isChecked() ? "1"
                : bi.e0306n0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306n0fyx = bi.e0306n0fyx.getText().toString().trim().length() > 0 ? bi.e0306n0fyx.getText().toString() : "-1";


        MainApp.fc.e0306o0a = bi.e0306o0ay.isChecked() ? "1"
                : bi.e0306o0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306o0ayx = bi.e0306o0ayx.getText().toString().trim().length() > 0 ? bi.e0306o0ayx.getText().toString() : "-1";

        MainApp.fc.e0306o0f = bi.e0306o0fy.isChecked() ? "1"
                : bi.e0306o0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306o0fyx = bi.e0306o0fyx.getText().toString().trim().length() > 0 ? bi.e0306o0fyx.getText().toString() : "-1";


        MainApp.fc.e0306p0a = bi.e0306p0ay.isChecked() ? "1"
                : bi.e0306p0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306p0ayx = bi.e0306p0ayx.getText().toString().trim().length() > 0 ? bi.e0306p0ayx.getText().toString() : "-1";

        MainApp.fc.e0306p0f = bi.e0306p0fy.isChecked() ? "1"
                : bi.e0306p0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306p0fyx = bi.e0306p0fyx.getText().toString().trim().length() > 0 ? bi.e0306p0fyx.getText().toString() : "-1";


        MainApp.fc.e0306q0a = bi.e0306q0ay.isChecked() ? "1"
                : bi.e0306q0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306q0ayx = bi.e0306q0ayx.getText().toString().trim().length() > 0 ? bi.e0306q0ayx.getText().toString() : "-1";

        MainApp.fc.e0306q0f = bi.e0306q0fy.isChecked() ? "1"
                : bi.e0306q0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306q0fyx = bi.e0306q0fyx.getText().toString().trim().length() > 0 ? bi.e0306q0fyx.getText().toString() : "-1";


        MainApp.fc.e0306r0a = bi.e0306r0ay.isChecked() ? "1"
                : bi.e0306r0an.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306r0ayx = bi.e0306r0ayx.getText().toString().trim().length() > 0 ? bi.e0306r0ayx.getText().toString() : "-1";

        MainApp.fc.e0306r0f = bi.e0306r0fy.isChecked() ? "1"
                : bi.e0306r0fn.isChecked() ? "2"
                : "-1";
        MainApp.fc.e0306r0fyx = bi.e0306r0fyx.getText().toString().trim().length() > 0 ? bi.e0306r0fyx.getText().toString() : "-1";


        MainApp.fc.e0307 = bi.e0307a.isChecked() ? "1"
                : bi.e0307b.isChecked() ? "2"
                : "-1";

        MainApp.fc.e0308 = bi.e0308a.isChecked() ? "1"
                : bi.e0308b.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionE4Activity.class));
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
