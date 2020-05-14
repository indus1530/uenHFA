package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionF1Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.datecollection.AgeModel;
import edu.aku.hassannaqvi.uen_hfa_ml.datecollection.DateRepository;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionF1Activity extends AppCompatActivity {

    ActivitySectionF1Binding bi;
    boolean imFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f1);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupListeners();
        setupTextWatchers();

    }

    private void setupTextWatchers() {
       /* editTextImplementation(new EditTextPicker[]{bi.im41bcgdd, bi.im41bcgmm, bi.im41bcgyy});
        editTextImplementation(new EditTextPicker[]{bi.im42opv0dd, bi.im42opv0mm, bi.im42opv0yy});
        editTextImplementation(new EditTextPicker[]{bi.im43opv1dd, bi.im43opv1mm, bi.im43opv1yy});
        editTextImplementation(new EditTextPicker[]{bi.im44penta1dd, bi.im44penta1mm, bi.im44penta1yy});
        editTextImplementation(new EditTextPicker[]{bi.im45pcv1dd, bi.im45pcv1mm, bi.im45pcv1yy});
        editTextImplementation(new EditTextPicker[]{bi.im46rv1dd, bi.im46rv1mm, bi.im46rv1yy});
        editTextImplementation(new EditTextPicker[]{bi.im47opv2dd, bi.im47opv2mm, bi.im47opv2yy});
        editTextImplementation(new EditTextPicker[]{bi.im48penta2dd, bi.im48penta2mm, bi.im48penta2yy});
        editTextImplementation(new EditTextPicker[]{bi.im49pcv2dd, bi.im49pcv2mm, bi.im49pcv2yy});
        editTextImplementation(new EditTextPicker[]{bi.im410rv2dd, bi.im410rv2mm, bi.im410rv2yy});
        editTextImplementation(new EditTextPicker[]{bi.im411opv3dd, bi.im411opv3mm, bi.im411opv3yy});
        editTextImplementation(new EditTextPicker[]{bi.im412penta3dd, bi.im412penta3mm, bi.im412penta3yy});
        editTextImplementation(new EditTextPicker[]{bi.im413pcv3dd, bi.im413pcv3mm, bi.im413pcv3yy});
        editTextImplementation(new EditTextPicker[]{bi.im414ipvdd, bi.im414ipvmm, bi.im414ipvyy});
        editTextImplementation(new EditTextPicker[]{bi.im415measles1dd, bi.im415measles1mm, bi.im415measles1yy});
        editTextImplementation(new EditTextPicker[]{bi.im416measles2dd, bi.im416measles2mm, bi.im416measles2yy});*/
    }

    public void editTextImplementation(EditTextPicker[] editTextsArray) {
        if (editTextsArray.length != 3) return;
        EditTextPicker editTextPicker01 = editTextsArray[0];
        EditTextPicker editTextPicker02 = editTextsArray[1];
        EditTextPicker editTextPicker03 = editTextsArray[2];

        for (EditTextPicker item : new EditTextPicker[]{editTextPicker01, editTextPicker02}) {
            item.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    editTextPicker03.setText(null);
                    editTextPicker03.setError(null);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }

        editTextPicker03.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String txt01, txt02, txt03;
                editTextPicker01.setEnabled(true);
                editTextPicker02.setEnabled(true);
                if (!TextUtils.isEmpty(editTextPicker01.getText()) && !TextUtils.isEmpty(editTextPicker02.getText()) && !TextUtils.isEmpty(editTextPicker03.getText())) {
                    txt01 = editTextPicker01.getText().toString();
                    txt02 = editTextPicker02.getText().toString();
                    txt03 = editTextPicker03.getText().toString();
                } else return;
                if ((!editTextPicker01.isRangeTextValidate() || txt01.trim().equals("44") || txt01.trim().equals("97")) ||
                        (!editTextPicker02.isRangeTextValidate() || txt02.trim().equals("44") || txt02.trim().equals("97")) ||
                        (!editTextPicker03.isRangeTextValidate() || txt03.trim().equals("44") || txt03.trim().equals("97")))
                    return;
                int day = Integer.parseInt(txt01);
                int month = Integer.parseInt(txt02);
                int year = Integer.parseInt(txt03);
                AgeModel age = DateRepository.Companion.getCalculatedAge(year, month, day);
                if (age == null) {
                    editTextPicker03.setError("Invalid date!!");
                    imFlag = false;
                } else {
                    imFlag = true;
                    editTextPicker01.setEnabled(false);
                    editTextPicker02.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void setupListeners() {

//        Clear.clearAllFields(bi.fldGrpSecChc2, getIntent().getBooleanExtra(IM02FLAG, true));

        /*bi.im05.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i != bi.im051.getId()) {
                bi.qIm06.setEnabled(false);
                Clear.clearAllFields(bi.qIm08, false);
                Clear.clearAllFields(bi.fldGrpCVim06, false);
                Clear.clearAllFields(bi.fldGrpSecChc3, false);
                Clear.clearAllFields(bi.fldGrpCVim08, false);
                Clear.clearAllFields(bi.fldGrpCVim23, true);
                Clear.clearAllFields(bi.fldGrpCVim23a, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim06, true);
                Clear.clearAllFields(bi.fldGrpSecChc3, true);
                Clear.clearAllFields(bi.fldGrpCVim08, true);
                Clear.clearAllFields(bi.fldGrpCVim23, false);
                Clear.clearAllFields(bi.fldGrpCVim23a, false);
            }
        });*/


        bi.f0100.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0100b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf101);
            }
        });

        bi.f0101aa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0101aa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0101aa0f);
            }
        });

        bi.f0101ab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0101ab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0101ab0f);
            }
        });

        bi.f0105.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0105b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf102);
            }
        });

        bi.f0105aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0105aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0105aaa0f);
            }
        });

        bi.f0105aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0105aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0105aab0f);
            }
        });

        bi.f0105aac0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0105aac0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0105aac0f);
            }
        });

        bi.f0106.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0106b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf103);
            }
        });

        bi.f0110.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110b.getId()) {
                Clear.clearAllFields(bi.fldGrpSecf104);
            }
        });

        bi.f0110aaa0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110aaa0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0110aaa0f);
            }
        });

        bi.f0110aab0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110aab0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0110aab0f);
            }
        });

        bi.f0110aac0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110aac0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0110aac0f);
            }
        });

        bi.f0110aad0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110aad0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0110aad0f);
            }
        });

        bi.f0110aae0a.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.f0110aae0an.getId()) {
                Clear.clearAllFields(bi.fldGrpCVf0110aae0f);
            }
        });

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

        json.put("f0100", bi.f0100a.isChecked() ? "1"
                : bi.f0100b.isChecked() ? "2"
                : "-1");

        json.put("f0101a", "-1");

        json.put("f0101aa0a", bi.f0101aa0ay.isChecked() ? "1"
                : bi.f0101aa0an.isChecked() ? "2"
                : bi.f0101aa0aq.isChecked() ? "3"
                : "-1");

        json.put("f0101aa0aqx", bi.f0101aa0aqx.getText().toString());
        json.put("f0101aa0f", bi.f0101aa0fy.isChecked() ? "1"
                : bi.f0101aa0fn.isChecked() ? "2"
                : bi.f0101aa0fq.isChecked() ? "3"
                : "-1");

        json.put("f0101aa0fqx", bi.f0101aa0fqx.getText().toString());
        json.put("f0101ab0a", bi.f0101ab0ay.isChecked() ? "1"
                : bi.f0101ab0an.isChecked() ? "2"
                : bi.f0101ab0aq.isChecked() ? "3"
                : "-1");

        json.put("f0101ab0aqx", bi.f0101ab0aqx.getText().toString());
        json.put("f0101ab0f", bi.f0101ab0fy.isChecked() ? "1"
                : bi.f0101ab0fn.isChecked() ? "2"
                : bi.f0101ab0fq.isChecked() ? "3"
                : "-1");

        json.put("f0101ab0fqx", bi.f0101ab0fqx.getText().toString());
        json.put("f0102", bi.f0102a.isChecked() ? "1"
                : bi.f0102b.isChecked() ? "2"
                : "-1");

        json.put("f0103", bi.f0103a.isChecked() ? "1"
                : bi.f0103b.isChecked() ? "2"
                : "-1");

        json.put("f0104", bi.f0104a.isChecked() ? "1"
                : bi.f0104b.isChecked() ? "2"
                : "-1");

        json.put("f0105", bi.f0105a.isChecked() ? "1"
                : bi.f0105b.isChecked() ? "2"
                : "-1");

        json.put("f0105aa", "-1");

        json.put("f0105aaa0a", bi.f0105aaa0ay.isChecked() ? "1"
                : bi.f0105aaa0an.isChecked() ? "2"
                : bi.f0105aaa0aq.isChecked() ? "3"
                : "-1");

        json.put("f0105aaa0aqx", bi.f0105aaa0aqx.getText().toString());
        json.put("f0105aaa0f", bi.f0105aaa0fy.isChecked() ? "1"
                : bi.f0105aaa0fn.isChecked() ? "2"
                : bi.f0105aaa0fq.isChecked() ? "3"
                : "-1");

        json.put("f0105aaa0fqx", bi.f0105aaa0fqx.getText().toString());
        json.put("f0105aab0a", bi.f0105aab0ay.isChecked() ? "1"
                : bi.f0105aab0an.isChecked() ? "2"
                : bi.f0105aab0aq.isChecked() ? "3"
                : "-1");

        json.put("f0105aab0aqx", bi.f0105aab0aqx.getText().toString());
        json.put("f0105aab0f", bi.f0105aab0fy.isChecked() ? "1"
                : bi.f0105aab0fn.isChecked() ? "2"
                : bi.f0105aab0fq.isChecked() ? "3"
                : "-1");

        json.put("f0105aab0fqx", bi.f0105aab0fqx.getText().toString());
        json.put("f0105aac0a", bi.f0105aac0ay.isChecked() ? "1"
                : bi.f0105aac0an.isChecked() ? "2"
                : bi.f0105aac0aq.isChecked() ? "3"
                : "-1");

        json.put("f0105aac0aqx", bi.f0105aac0aqx.getText().toString());
        json.put("f0105aac0f", bi.f0105aac0fy.isChecked() ? "1"
                : bi.f0105aac0fn.isChecked() ? "2"
                : bi.f0105aac0fq.isChecked() ? "3"
                : "-1");

        json.put("f0105aac0fqx", bi.f0105aac0fqx.getText().toString());
        json.put("f0106", bi.f0106a.isChecked() ? "1"
                : bi.f0106b.isChecked() ? "2"
                : "-1");

        json.put("f0106aa", "-1");

        json.put("f0106aaa0a", bi.f0106aaa0ay.isChecked() ? "1"
                : bi.f0106aaa0an.isChecked() ? "2"
                : bi.f0106aaa0aq.isChecked() ? "3"
                : "-1");

        json.put("f0106aaa0aqx", bi.f0106aaa0aqx.getText().toString());
        json.put("f0106aaa0f", bi.f0106aaa0fy.isChecked() ? "1"
                : bi.f0106aaa0fn.isChecked() ? "2"
                : bi.f0106aaa0fq.isChecked() ? "3"
                : "-1");

        json.put("f0106aaa0fqx", bi.f0106aaa0fqx.getText().toString());
        json.put("f0107", bi.f0107a.isChecked() ? "1"
                : bi.f0107b.isChecked() ? "2"
                : "-1");

        json.put("f0108", bi.f0108a.isChecked() ? "1"
                : bi.f0108b.isChecked() ? "2"
                : "-1");

        json.put("f0109", bi.f0109a.isChecked() ? "1"
                : bi.f0109b.isChecked() ? "2"
                : "-1");

        json.put("f0110", bi.f0110a.isChecked() ? "1"
                : bi.f0110b.isChecked() ? "2"
                : "-1");

        json.put("f0110aa", "-1");

        json.put("f0110aaa0a", bi.f0110aaa0ay.isChecked() ? "1"
                : bi.f0110aaa0an.isChecked() ? "2"
                : bi.f0110aaa0aq.isChecked() ? "3"
                : "-1");

        json.put("f0110aaa0aqx", bi.f0110aaa0aqx.getText().toString());
        json.put("f0110aaa0f", bi.f0110aaa0fy.isChecked() ? "1"
                : bi.f0110aaa0fn.isChecked() ? "2"
                : bi.f0110aaa0fq.isChecked() ? "3"
                : "-1");

        json.put("f0110aaa0fqx", bi.f0110aaa0fqx.getText().toString());
        json.put("f0110aab0a", bi.f0110aab0ay.isChecked() ? "1"
                : bi.f0110aab0an.isChecked() ? "2"
                : bi.f0110aab0aq.isChecked() ? "3"
                : "-1");

        json.put("f0110aab0aqx", bi.f0110aab0aqx.getText().toString());
        json.put("f0110aab0f", bi.f0110aab0fy.isChecked() ? "1"
                : bi.f0110aab0fn.isChecked() ? "2"
                : bi.f0110aab0fq.isChecked() ? "3"
                : "-1");

        json.put("f0110aab0fqx", bi.f0110aab0fqx.getText().toString());
        json.put("f0110aac0a", bi.f0110aac0ay.isChecked() ? "1"
                : bi.f0110aac0an.isChecked() ? "2"
                : bi.f0110aac0aq.isChecked() ? "3"
                : "-1");

        json.put("f0110aac0aqx", bi.f0110aac0aqx.getText().toString());
        json.put("f0110aac0f", bi.f0110aac0fy.isChecked() ? "1"
                : bi.f0110aac0fn.isChecked() ? "2"
                : bi.f0110aac0fq.isChecked() ? "3"
                : "-1");

        json.put("f0110aac0fqx", bi.f0110aac0fqx.getText().toString());
        json.put("f0110aad0a", bi.f0110aad0ay.isChecked() ? "1"
                : bi.f0110aad0an.isChecked() ? "2"
                : bi.f0110aad0aq.isChecked() ? "3"
                : "-1");

        json.put("f0110aad0aqx", bi.f0110aad0aqx.getText().toString());
        json.put("f0110aad0f", bi.f0110aad0fy.isChecked() ? "1"
                : bi.f0110aad0fn.isChecked() ? "2"
                : bi.f0110aad0fq.isChecked() ? "3"
                : "-1");

        json.put("f0110aad0fqx", bi.f0110aad0fqx.getText().toString());
        json.put("f0110aae0a", bi.f0110aae0ay.isChecked() ? "1"
                : bi.f0110aae0an.isChecked() ? "2"
                : bi.f0110aae0aq.isChecked() ? "3"
                : "-1");

        json.put("f0110aae0aqx", bi.f0110aae0aqx.getText().toString());
        json.put("f0110aae0f", bi.f0110aae0fy.isChecked() ? "1"
                : bi.f0110aae0fn.isChecked() ? "2"
                : bi.f0110aae0fq.isChecked() ? "3"
                : "-1");

        json.put("f0110aae0fqx", bi.f0110aae0fqx.getText().toString());


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
                startActivity(new Intent(this, SectionF2Activity.class));

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
