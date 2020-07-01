package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.PatientSatisfactionContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionI1Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.EndSectionActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.validator.ValidatorClass;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.SECTION_MAIN_CHECK_FOR_END;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.psc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.contextEndActivity;


public class SectionI1Activity extends AppCompatActivity implements EndSectionActivity {

    ActivitySectionI1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i1);
        bi.setCallback(this);
        setupSkips();
        setupContent();
    }


    private void setupContent() {
        bi.hfType.setText(MainApp.fc.getA10().equals("1") ? getString(R.string.publicHF) : getString(R.string.privateHF));
        bi.maternalCount.setText(new StringBuilder("Maternal Entries: ").append(SectionMainActivity.maternalCount));
        bi.paedsCount.setText(new StringBuilder("Paeds Entries: ").append(SectionMainActivity.paedsCount));

        if (MainApp.fc.getA10().equals("1")) {
            if (SectionMainActivity.paedsCount == 3) bi.i0108a.setEnabled(false);
            else if (SectionMainActivity.maternalCount == 3) bi.i0108b.setEnabled(false);
        }
    }


    private void setupSkips() {
        bi.i0103.setOnCheckedChangeListener(((radioGroup, i) -> Clear.clearAllFields(bi.fldGrpCVi0104)));

        bi.i0108.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.i0108a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVi0105);
                bi.i0105a.setEnabled(true);
                Clear.clearAllFields(bi.fldGrpCVi0106);
                bi.i0106a.setMaxvalue(5);
                bi.i0106a.setMinvalue(0);
            } else if (i == bi.i0108b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVi0105);
                bi.i0105a.setEnabled(false);
                bi.i0105b.setChecked(true);
                Clear.clearAllFields(bi.fldGrpCVi0106);
                bi.i0106a.setMaxvalue(49);
                bi.i0106a.setMinvalue(15);
            }

        }));


        bi.i0106a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(bi.i0106a.getText()))
                    return;
                if (bi.i0108a.isChecked() && Integer.parseInt(bi.i0106a.getText().toString()) == 49) {
                    bi.i0106b.setMaxvalue(0);
                }
                if (bi.i0108b.isChecked() && Integer.parseInt(bi.i0106a.getText().toString()) == 5) {
                    bi.i0106b.setMaxvalue(0);
                }
            }
        });


    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();

            if (bi.i0108a.isChecked()) SectionMainActivity.paedsCount++;
            else if (bi.i0108b.isChecked()) SectionMainActivity.maternalCount++;

            startActivity(new Intent(this, bi.i0108b.isChecked() ? SectionI3Activity.class : SectionI2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }



    public void BtnEnd() {
        if (!Validator.emptyCheckingContainer(this, bi.fldGrpEndForm)) return;
        contextEndActivity(this);
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addPSC(psc);
        psc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            psc.set_UID(psc.getDeviceID() + psc.get_ID());
            db.updatesPSCColumn(PatientSatisfactionContract.SinglePSC.COLUMN_UID, psc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        psc = new PatientSatisfactionContract();
        psc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        psc.setDeviceID(MainApp.appInfo.getDeviceID());
        psc.setDevicetagID(MainApp.appInfo.getTagName());
        psc.setAppversion(MainApp.appInfo.getAppVersion());
        psc.set_UUID(MainApp.fc.get_UID());
        psc.setDistrictCode(MainApp.fc.getDistrictCode());
        psc.setTehsilCode(MainApp.fc.getTehsilCode());
        psc.setUcCode(MainApp.fc.getUcCode());
        psc.setHfCode(MainApp.fc.getHfCode());
//        psc.serialno = serial.toString()

        JSONObject json = new JSONObject();

        json.put("i0101", bi.i0101a.isChecked() ? "1"
                : bi.i0101b.isChecked() ? "2"
                : "-1");

        json.put("i0102a", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("i0102b", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("i0103", bi.i0103a.isChecked() ? "1"
                : bi.i0103b.isChecked() ? "2"
                : "-1");

        json.put("i0104", bi.i0104a.isChecked() ? "1"
                : bi.i0104b.isChecked() ? "2"
                : bi.i0104c.isChecked() ? "3"
                : bi.i0104d.isChecked() ? "4"
                : "-1");

        json.put("i0105", bi.i0105a.isChecked() ? "1"
                : bi.i0105b.isChecked() ? "2"
                : "-1");

        json.put("i0106a", bi.i0106a.getText().toString().trim().isEmpty() ? "-1" : bi.i0106a.getText().toString());
        json.put("i0106b", bi.i0106b.getText().toString().trim().isEmpty() ? "-1" : bi.i0106b.getText().toString());

        json.put("i0107", bi.i0107a.isChecked() ? "1"
                : bi.i0107b.isChecked() ? "2"
                : "-1");

        json.put("i0108", bi.i0108a.isChecked() ? "1"
                : bi.i0108b.isChecked() ? "2"
                : "-1");

        psc.setsI1(String.valueOf(json));

    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.i0106a.getText().toString().trim().length() > 0 && bi.i0106b.getText().toString().trim().length() > 0) {
            if (Integer.parseInt(bi.i0106a.getText().toString().trim()) + Integer.parseInt(bi.i0106a.getText().toString().trim()) == 0) {
                return ValidatorClass.EmptyCustomeTextBox(this, bi.i0106a, "Both!! Month & Year Can't be Zero!");
                //return Validator.emptyCheckingContainer(this, bi.i0106a);
            }
        }
        return true;
    }


    @Override
    public void endSecActivity(boolean flag) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();

            if (bi.i0108a.isChecked()) SectionMainActivity.paedsCount++;
            else if (bi.i0108b.isChecked()) SectionMainActivity.maternalCount++;

            startActivity(new Intent(this, EndingActivity.class).putExtra(SECTION_MAIN_CHECK_FOR_END, true)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
