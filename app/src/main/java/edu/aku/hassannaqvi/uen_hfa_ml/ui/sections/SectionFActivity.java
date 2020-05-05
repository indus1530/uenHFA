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
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionFBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.datecollection.AgeModel;
import edu.aku.hassannaqvi.uen_hfa_ml.datecollection.DateRepository;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openChildEndActivity;

public class SectionFActivity extends AppCompatActivity {

    ActivitySectionFBinding bi;
    boolean imFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
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

        /*Clear.clearAllFields(bi.fldGrpSecChc2, getIntent().getBooleanExtra(IM02FLAG, true));

        bi.im05.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i != bi.im051.getId()) {
                *//*bi.qIm06.setEnabled(false);
                Clear.clearAllFields(bi.qIm08, false);*//*
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
        });

        bi.im08.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (i == bi.im081.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim09, true);
                Clear.clearAllFields(bi.fldGrpCVim10, true);
                Clear.clearAllFields(bi.fldGrpSecChc5, true);
                Clear.clearAllFields(bi.fldGrpSecChc6, true);
                Clear.clearAllFields(bi.fldGrpCVim23, true);
                Clear.clearAllFields(bi.fldGrpCVim23a, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim09, false);
                Clear.clearAllFields(bi.fldGrpCVim10, false);
                Clear.clearAllFields(bi.fldGrpSecChc5, false);
                Clear.clearAllFields(bi.fldGrpSecChc6, false);
                Clear.clearAllFields(bi.fldGrpCVim23, false);
                Clear.clearAllFields(bi.fldGrpCVim23a, false);
            }

        }));

        bi.im10.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im101.getId()) {
                Clear.clearAllFields(bi.fldGrpSecChc5, true);
            } else {
                Clear.clearAllFields(bi.fldGrpSecChc5, false);
            }

        });

        bi.im14.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im141.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim15, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim15, false);
            }
        });

        bi.im16.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im161.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim17, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim17, false);
            }
        });

        bi.im18.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im181.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim19, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim19, false);
            }
        });

        bi.im21.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im211.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim22, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim22, false);
            }
        });

        bi.im23.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im231.getId() || i == bi.im232.getId() || i == bi.im233.getId()) {
                Clear.clearAllFields(bi.fldGrpSecChc4, false);
            } else if (i == bi.im234.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim23a, false);
                Clear.clearAllFields(bi.fldGrpSecChc4, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim23a, true);
                Clear.clearAllFields(bi.fldGrpSecChc4, true);
            }

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
        json.put("f11",
                bi.f1a.isChecked() ? "1" :
                        bi.f1b.isChecked() ? "2" :
                                "0");
        json.put("f11a",
                "0");
        json.put("f11aa0a",
                bi.f11aa0ay.isChecked() ? "1" :
                        bi.f11aa0an.isChecked() ? "2" :
                                bi.f11aa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f11aa0aqx", bi.f11aa0aqx.getText().toString());
        json.put("f11aa0f",
                bi.f11aa0fy.isChecked() ? "1" :
                        bi.f11aa0fn.isChecked() ? "2" :
                                bi.f11aa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f11aa0fqx", bi.f11aa0fqx.getText().toString());
        json.put("f11ab0a",
                bi.f11ab0ay.isChecked() ? "1" :
                        bi.f11ab0an.isChecked() ? "2" :
                                bi.f11ab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f11ab0aqx", bi.f11ab0aqx.getText().toString());
        json.put("f11ab0f",
                bi.f11ab0fy.isChecked() ? "1" :
                        bi.f11ab0fn.isChecked() ? "2" :
                                bi.f11ab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f11ab0fqx", bi.f11ab0fqx.getText().toString());
        json.put("f12",
                bi.f12a.isChecked() ? "1" :
                        bi.f12b.isChecked() ? "2" :
                                "0");
        json.put("f13",
                bi.f13a.isChecked() ? "1" :
                        bi.f13b.isChecked() ? "2" :
                                "0");
        json.put("f14",
                bi.f14a.isChecked() ? "1" :
                        bi.f14b.isChecked() ? "2" :
                                "0");
        json.put("f15",
                bi.f15a.isChecked() ? "1" :
                        bi.f15b.isChecked() ? "2" :
                                "0");
        json.put("f15aa",
                "0");
        json.put("f15aaa0a",
                bi.f15aaa0ay.isChecked() ? "1" :
                        bi.f15aaa0an.isChecked() ? "2" :
                                bi.f15aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f15aaa0aqx", bi.f15aaa0aqx.getText().toString());
        json.put("f15aaa0f",
                bi.f15aaa0fy.isChecked() ? "1" :
                        bi.f15aaa0fn.isChecked() ? "2" :
                                bi.f15aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f15aaa0fqx", bi.f15aaa0fqx.getText().toString());
        json.put("f15aab0a",
                bi.f15aab0ay.isChecked() ? "1" :
                        bi.f15aab0an.isChecked() ? "2" :
                                bi.f15aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f15aab0aqx", bi.f15aab0aqx.getText().toString());
        json.put("f15aab0f",
                bi.f15aab0fy.isChecked() ? "1" :
                        bi.f15aab0fn.isChecked() ? "2" :
                                bi.f15aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f15aab0fqx", bi.f15aab0fqx.getText().toString());
        json.put("f15aac0a",
                bi.f15aac0ay.isChecked() ? "1" :
                        bi.f15aac0an.isChecked() ? "2" :
                                bi.f15aac0aq.isChecked() ? "3" :
                                        "0");
        json.put("f15aac0aqx", bi.f15aac0aqx.getText().toString());
        json.put("f15aac0f",
                bi.f15aac0fy.isChecked() ? "1" :
                        bi.f15aac0fn.isChecked() ? "2" :
                                bi.f15aac0fq.isChecked() ? "3" :
                                        "0");
        json.put("f15aac0fqx", bi.f15aac0fqx.getText().toString());
        json.put("f16",
                bi.f16a.isChecked() ? "1" :
                        bi.f16b.isChecked() ? "2" :
                                "0");
        json.put("f16aa",
                "0");
        json.put("f116aaa0a",
                bi.f116aaa0ay.isChecked() ? "1" :
                        bi.f116aaa0an.isChecked() ? "2" :
                                bi.f116aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f116aaa0aqx", bi.f116aaa0aqx.getText().toString());
        json.put("f116aaa0f",
                bi.f116aaa0fy.isChecked() ? "1" :
                        bi.f116aaa0fn.isChecked() ? "2" :
                                bi.f116aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f116aaa0fqx", bi.f116aaa0fqx.getText().toString());
        json.put("f17",
                bi.f17a.isChecked() ? "1" :
                        bi.f17b.isChecked() ? "2" :
                                "0");
        json.put("f18",
                bi.f18a.isChecked() ? "1" :
                        bi.f18b.isChecked() ? "2" :
                                "0");
        json.put("f19",
                bi.f19a.isChecked() ? "1" :
                        bi.f19f.isChecked() ? "2" :
                                "0");
        json.put("f110",
                bi.f110a.isChecked() ? "1" :
                        bi.f110b.isChecked() ? "2" :
                                "0");
        json.put("f110aa",
                "0");
        json.put("f110aaa0a",
                bi.f110aaa0ay.isChecked() ? "1" :
                        bi.f110aaa0an.isChecked() ? "2" :
                                bi.f110aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f110aaa0aqx", bi.f110aaa0aqx.getText().toString());
        json.put("f110aaa0f",
                bi.f110aaa0fy.isChecked() ? "1" :
                        bi.f110aaa0fn.isChecked() ? "2" :
                                bi.f110aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f110aaa0fqx", bi.f110aaa0fqx.getText().toString());
        json.put("f110aab0a",
                bi.f110aab0ay.isChecked() ? "1" :
                        bi.f110aab0an.isChecked() ? "2" :
                                bi.f110aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f110aab0aqx", bi.f110aab0aqx.getText().toString());
        json.put("f110aab0f",
                bi.f110aab0fy.isChecked() ? "1" :
                        bi.f110aab0fn.isChecked() ? "2" :
                                bi.f110aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f110aab0fqx", bi.f110aab0fqx.getText().toString());
        json.put("f110aac0a",
                bi.f110aac0ay.isChecked() ? "1" :
                        bi.f110aac0an.isChecked() ? "2" :
                                bi.f110aac0aq.isChecked() ? "3" :
                                        "0");
        json.put("f110aac0aqx", bi.f110aac0aqx.getText().toString());
        json.put("f110aac0f",
                bi.f110aac0fy.isChecked() ? "1" :
                        bi.f110aac0fn.isChecked() ? "2" :
                                bi.f110aac0fq.isChecked() ? "3" :
                                        "0");
        json.put("f110aac0fqx", bi.f110aac0fqx.getText().toString());
        json.put("f110aad0a",
                bi.f110aad0ay.isChecked() ? "1" :
                        bi.f110aad0an.isChecked() ? "2" :
                                bi.f110aad0aq.isChecked() ? "3" :
                                        "0");
        json.put("f110aad0aqx", bi.f110aad0aqx.getText().toString());
        json.put("f110aad0f",
                bi.f110aad0fy.isChecked() ? "1" :
                        bi.f110aad0fn.isChecked() ? "2" :
                                bi.f110aad0fq.isChecked() ? "3" :
                                        "0");
        json.put("f110aad0fqx", bi.f110aad0fqx.getText().toString());
        json.put("f110aae0a",
                bi.f110aae0ay.isChecked() ? "1" :
                        bi.f110aae0an.isChecked() ? "2" :
                                bi.f110aae0aq.isChecked() ? "3" :
                                        "0");
        json.put("f110aae0aqx", bi.f110aae0aqx.getText().toString());
        json.put("f110aae0f",
                bi.f110aae0fy.isChecked() ? "1" :
                        bi.f110aae0fn.isChecked() ? "2" :
                                bi.f110aae0fq.isChecked() ? "3" :
                                        "0");
        json.put("f110aae0fqx", bi.f110aae0fqx.getText().toString());
        json.put("f21",
                bi.f21a.isChecked() ? "1" :
                        bi.f21b.isChecked() ? "2" :
                                "0");
        json.put("f21aa",
                "0");
        json.put("f21aaa0a",
                bi.f21aaa0ay.isChecked() ? "1" :
                        bi.f21aaa0an.isChecked() ? "2" :
                                bi.f21aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f21aaa0aqx", bi.f21aaa0aqx.getText().toString());
        json.put("f21aaa0f",
                bi.f21aaa0fy.isChecked() ? "1" :
                        bi.f21aaa0fn.isChecked() ? "2" :
                                bi.f21aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f21aaa0fqx", bi.f21aaa0fqx.getText().toString());
        json.put("f21aab0a",
                bi.f21aab0ay.isChecked() ? "1" :
                        bi.f21aab0an.isChecked() ? "2" :
                                bi.f21aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f21aab0aqx", bi.f21aab0aqx.getText().toString());
        json.put("f21aab0f",
                bi.f21aab0fy.isChecked() ? "1" :
                        bi.f21aab0fn.isChecked() ? "2" :
                                bi.f21aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f21aab0fqx", bi.f21aab0fqx.getText().toString());
        json.put("f22",
                bi.f22a.isChecked() ? "1" :
                        bi.f22b.isChecked() ? "2" :
                                "0");
        json.put("f22aa",
                "0");
        json.put("f22aaa0a",
                bi.f22aaa0ay.isChecked() ? "1" :
                        bi.f22aaa0an.isChecked() ? "2" :
                                bi.f22aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f22aaa0aqx", bi.f22aaa0aqx.getText().toString());
        json.put("f22aaa0f",
                bi.f22aaa0fy.isChecked() ? "1" :
                        bi.f22aaa0fn.isChecked() ? "2" :
                                bi.f22aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f22aaa0fqx", bi.f22aaa0fqx.getText().toString());
        json.put("f22aab0a",
                bi.f22aab0ay.isChecked() ? "1" :
                        bi.f22aab0an.isChecked() ? "2" :
                                bi.f22aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f22aab0aqx", bi.f22aab0aqx.getText().toString());
        json.put("f22aab0f",
                bi.f22aab0fy.isChecked() ? "1" :
                        bi.f22aab0fn.isChecked() ? "2" :
                                bi.f22aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f22aab0fqx", bi.f22aab0fqx.getText().toString());
        json.put("f23",
                bi.f23a.isChecked() ? "1" :
                        bi.f23b.isChecked() ? "2" :
                                "0");
        json.put("f23aa",
                "0");
        json.put("f23aaa0a",
                bi.f23aaa0ay.isChecked() ? "1" :
                        bi.f23aaa0an.isChecked() ? "2" :
                                bi.f23aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f23aaa0aqx", bi.f23aaa0aqx.getText().toString());
        json.put("f23aaa0f",
                bi.f23aaa0fy.isChecked() ? "1" :
                        bi.f23aaa0fn.isChecked() ? "2" :
                                bi.f23aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f23aaa0fqx", bi.f23aaa0fqx.getText().toString());
        json.put("f23aab0a",
                bi.f23aab0ay.isChecked() ? "1" :
                        bi.f23aab0an.isChecked() ? "2" :
                                bi.f23aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f23aab0aqx", bi.f23aab0aqx.getText().toString());
        json.put("f23aab0f",
                bi.f23aab0fy.isChecked() ? "1" :
                        bi.f23aab0fn.isChecked() ? "2" :
                                bi.f23aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f23aab0fqx", bi.f23aab0fqx.getText().toString());
        json.put("f31",
                bi.f31a.isChecked() ? "1" :
                        bi.f31b.isChecked() ? "2" :
                                "0");
        json.put("f31aa",
                "0");
        json.put("f31aaa0a",
                bi.f31aaa0ay.isChecked() ? "1" :
                        bi.f31aaa0an.isChecked() ? "2" :
                                bi.f31aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f31aaa0aqx", bi.f31aaa0aqx.getText().toString());
        json.put("f31aaa0f",
                bi.f31aaa0fy.isChecked() ? "1" :
                        bi.f31aaa0fn.isChecked() ? "2" :
                                bi.f31aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f31aaa0fqx", bi.f31aaa0fqx.getText().toString());
        json.put("f32",
                bi.f32a.isChecked() ? "1" :
                        bi.f32b.isChecked() ? "2" :
                                "0");
        json.put("f32aa",
                "0");
        json.put("f32aaa0a",
                bi.f32aaa0ay.isChecked() ? "1" :
                        bi.f32aaa0an.isChecked() ? "2" :
                                bi.f32aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f32aaa0aqx", bi.f32aaa0aqx.getText().toString());
        json.put("f32aaa0f",
                bi.f32aaa0fy.isChecked() ? "1" :
                        bi.f32aaa0fn.isChecked() ? "2" :
                                bi.f32aaa0fq.isChecked() ? "98" :
                                        "0");
        json.put("f41",
                bi.f41a.isChecked() ? "1" :
                        bi.f41b.isChecked() ? "2" :
                                "0");
        json.put("f41aa",
                "0");
        json.put("f41aaa0a",
                bi.f41aaa0ay.isChecked() ? "1" :
                        bi.f41aaa0an.isChecked() ? "2" :
                                bi.f41aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f41aaa0aqx", bi.f41aaa0aqx.getText().toString());
        json.put("f41aaa0f",
                bi.f41aaa0fy.isChecked() ? "1" :
                        bi.f41aaa0fn.isChecked() ? "2" :
                                bi.f41aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f41aaa0fqx", bi.f41aaa0fqx.getText().toString());
        json.put("f41aab0a",
                bi.f41aab0ay.isChecked() ? "1" :
                        bi.f41aab0an.isChecked() ? "2" :
                                bi.f41aab0aq.isChecked() ? "3" :
                                        "0");
        json.put("f41aab0aqx", bi.f41aab0aqx.getText().toString());
        json.put("f41aab0f",
                bi.f41aab0fy.isChecked() ? "1" :
                        bi.f41aab0fn.isChecked() ? "2" :
                                bi.f41aab0fq.isChecked() ? "3" :
                                        "0");
        json.put("f41aab0fqx", bi.f41aab0fqx.getText().toString());
        json.put("f41aac0a",
                bi.f41aac0ay.isChecked() ? "1" :
                        bi.f41aac0an.isChecked() ? "2" :
                                bi.f41aac0aq.isChecked() ? "3" :
                                        "0");
        json.put("f41aac0aqx", bi.f41aac0aqx.getText().toString());
        json.put("f41aac0f",
                bi.f41aac0fy.isChecked() ? "1" :
                        bi.f41aac0fn.isChecked() ? "2" :
                                bi.f41aac0fq.isChecked() ? "3" :
                                        "0");
        json.put("f41aac0fqx", bi.f41aac0fqx.getText().toString());
        json.put("f42",
                bi.f42a.isChecked() ? "1" :
                        bi.f42b.isChecked() ? "2" :
                                "0");
        json.put("f42aa",
                "0");
        json.put("f42aaa0a",
                bi.f42aaa0ay.isChecked() ? "1" :
                        bi.f42aaa0an.isChecked() ? "2" :
                                bi.f42aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f42aaa0aqx", bi.f42aaa0aqx.getText().toString());
        json.put("f42aaa0f",
                bi.f42aaa0fy.isChecked() ? "1" :
                        bi.f42aaa0fn.isChecked() ? "2" :
                                bi.f42aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f42aaa0fqx", bi.f42aaa0fqx.getText().toString());
        json.put("f43",
                bi.f43a.isChecked() ? "1" :
                        bi.f43b.isChecked() ? "2" :
                                "0");
        json.put("f43aa",
                "0");
        json.put("f43aaa0a",
                bi.f43aaa0ay.isChecked() ? "1" :
                        bi.f43aaa0an.isChecked() ? "2" :
                                bi.f43aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f43aaa0aqx", bi.f43aaa0aqx.getText().toString());
        json.put("f43aaa0f",
                bi.f43aaa0fy.isChecked() ? "1" :
                        bi.f43aaa0fn.isChecked() ? "2" :
                                bi.f43aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f43aaa0fqx", bi.f43aaa0fqx.getText().toString());
        json.put("f44",
                bi.f44a.isChecked() ? "1" :
                        bi.f44b.isChecked() ? "2" :
                                "0");
        json.put("f44aa",
                "0");
        json.put("f44aaa0a",
                bi.f44aaa0ay.isChecked() ? "1" :
                        bi.f44aaa0an.isChecked() ? "2" :
                                bi.f44aaa0aq.isChecked() ? "3" :
                                        "0");
        json.put("f44aaa0aqx", bi.f44aaa0aqx.getText().toString());
        json.put("f44aaa0f",
                bi.f44aaa0fy.isChecked() ? "1" :
                        bi.f44aaa0fn.isChecked() ? "2" :
                                bi.f44aaa0fq.isChecked() ? "3" :
                                        "0");
        json.put("f44aaa0fqx", bi.f44aaa0fqx.getText().toString());

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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        openChildEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
