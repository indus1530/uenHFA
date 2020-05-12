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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionBBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.viewmodel.MainVModel;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.SERIAL_EXTRA;

public class SectionBActivity extends AppCompatActivity {

    ActivitySectionBBinding bi;
    private MainVModel mainVModel;
    private FamilyMembersContract fmc;
    private int serial = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b);
        bi.setCallback(this);

        setUIComponent();
        setListeners();
    }

    private void setUIComponent() {

        bi.b01.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.b01b.getId()) {
                Clear.clearAllFields(bi.fldGrpS01);
            }
        }));

        bi.b02.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.b02b.getId()) {
                Clear.clearAllFields(bi.fldGrpS01);
            }
        }));

    }

    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            setResult(RESULT_OK, new Intent().putExtra(SERIAL_EXTRA, serial));
            finish();
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addFamilyMember(fmc);
        fmc.set_id(String.valueOf(updcount));
        if (updcount > 0) {
            fmc.setUid(MainApp.deviceId + fmc.get_id());
            db.updatesFamilyMemberColumn(FamilyMembersContract.SingleMember.COLUMN_UID, fmc.getUid(), fmc.get_id());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    private void SaveDraft() throws JSONException {

        fmc = new FamilyMembersContract();
        fmc.setUuid(MainApp.fc.get_UID());
        fmc.setFormdate(MainApp.fc.getFormDate());
        fmc.setClusterno(MainApp.fc.getClusterCode());
        fmc.setHhno(MainApp.fc.getHhno());
//        fmc.setSerialno(bi.ch01.getText().toString());
//        fmc.setName(bi.ch02.getText().toString());
//        fmc.setFather_name(bi.ch03.getText().toString());
//        fmc.setMother_name(bi.ch03b.getText().toString());

        JSONObject json = new JSONObject();

        json.put("b01", bi.b01a.isChecked() ? "1"
                : bi.b01b.isChecked() ? "2"
                : "-1");

        json.put("b02", bi.b02a.isChecked() ? "1"
                : bi.b02b.isChecked() ? "2"
                : "-1");

        json.put("b03", bi.b03.getText().toString());

        json.put("b04", bi.b04.getText().toString());

        json.put("b05", bi.b05.getText().toString());



    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnEnd() {
        finish();
    }

    private void setListeners() {

        /*EditText[] txtListener = new EditText[]{bi.ch05a, bi.ch05b};
        for (EditText txtItem : txtListener) {

            txtItem.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bi.ch06.setText(null);
                    bi.ch06a.setText(null);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }*/

    }

    public void ch05cOnTextChanged(CharSequence s, int start, int before, int count) {
        /*bi.ch06.setEnabled(false);
        bi.ch06.setText(null);
        bi.ch06a.setEnabled(false);
        bi.ch06a.setText(null);
        if (!bi.ch05a.isRangeTextValidate() || !bi.ch05b.isRangeTextValidate() || !bi.ch05c.isRangeTextValidate())
            return;
        if (bi.ch05a.getText().toString().equals("00") && bi.ch05b.getText().toString().equals("00") && bi.ch05c.getText().toString().equals("00")) {
            bi.ch06.setEnabled(true);
            bi.ch06a.setEnabled(true);
            return;
        }
        int day = bi.ch05a.getText().toString().equals("00") ? 0 : Integer.parseInt(bi.ch05a.getText().toString());
        int month = Integer.parseInt(bi.ch05b.getText().toString());
        int year = Integer.parseInt(bi.ch05c.getText().toString());

        AgeModel age = DateRepository.Companion.getCalculatedAge(year, month, day);
        if (age == null) return;
        bi.ch06.setText(String.valueOf(age.getYear()));
        bi.ch06a.setText(String.valueOf(age.getMonth()));*/
    }

    @Override
    public boolean onSupportNavigateUp() {
        setResult(RESULT_CANCELED);
        finish();
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }
}
