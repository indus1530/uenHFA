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

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionC1Binding;

import static java.lang.Float.parseFloat;

public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.c01aa, new EditTextPicker[]{bi.c01ab, bi.c01ad, bi.c01ae}, bi.c01ac);
        editTextImplementation(bi.c01ba, new EditTextPicker[]{bi.c01bb, bi.c01bd, bi.c01be}, bi.c01bc);
        editTextImplementation(bi.c01ca, new EditTextPicker[]{bi.c01cb, bi.c01cd, bi.c01ce}, bi.c01cc);
        editTextImplementation(bi.c01da, new EditTextPicker[]{bi.c01db, bi.c01dd, bi.c01de}, bi.c01dc);
        editTextImplementation(bi.c01ea, new EditTextPicker[]{bi.c01eb, bi.c01ed, bi.c01ee}, bi.c01ec);
        editTextImplementation(bi.c01fa, new EditTextPicker[]{bi.c01fb, bi.c01fd, bi.c01fe}, bi.c01fc);
        editTextImplementation(bi.c01ga, new EditTextPicker[]{bi.c01gb, bi.c01gd, bi.c01ge}, bi.c01gc);
        editTextImplementation(bi.c01ha, new EditTextPicker[]{bi.c01hb, bi.c01hd, bi.c01he}, bi.c01hc);
        editTextImplementation(bi.c01ia, new EditTextPicker[]{bi.c01ib, bi.c01id, bi.c01ie}, bi.c01ic);
        editTextImplementation(bi.c01ja, new EditTextPicker[]{bi.c01jb, bi.c01jd, bi.c01je}, bi.c01jc);
        editTextImplementation(bi.c01ka, new EditTextPicker[]{bi.c01kb, bi.c01kd, bi.c01ke}, bi.c01kc);
    }


    public void editTextImplementation(EditTextPicker edit01, EditTextPicker[] editTextsArray, EditTextPicker edit02) {

        edit01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(edit01.getText()))
                    return;
                for (EditTextPicker item : editTextsArray) {
                    item.setMaxvalue(Integer.parseInt(edit01.getText().toString().trim()));
                }
            }
        });


        editTextsArray[0].addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(edit01.getText()) || TextUtils.isEmpty(editTextsArray[0].getText()))
                    return;
                edit02.setText("");
                edit02.setEnabled(false);
                editTextsArray[1].setMaxvalue(Integer.parseInt(editTextsArray[0].getText().toString().trim()));
                editTextsArray[2].setMaxvalue(Integer.parseInt(editTextsArray[0].getText().toString().trim()));
                edit02.setText(String.valueOf(parseFloat(edit01.getText().toString().trim()) - parseFloat(editTextsArray[0].getText().toString().trim())));

            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, fc.getsC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return false;
    }


    private void SaveDraft() {

        MainApp.fc.c01aa = bi.c01aa.getText().toString().trim().length() > 0 ? bi.c01aa.getText().toString() : "-1";
        MainApp.fc.c01ab = bi.c01ab.getText().toString().trim().length() > 0 ? bi.c01ab.getText().toString() : "-1";
        MainApp.fc.c01ac = bi.c01ac.getText().toString().trim().length() > 0 ? bi.c01ac.getText().toString() : "-1";
        MainApp.fc.c01ad = bi.c01ad.getText().toString().trim().length() > 0 ? bi.c01ad.getText().toString() : "-1";
        MainApp.fc.c01ae = bi.c01ae.getText().toString().trim().length() > 0 ? bi.c01ae.getText().toString() : "-1";

        MainApp.fc.c01ba = bi.c01ba.getText().toString().trim().length() > 0 ? bi.c01ba.getText().toString() : "-1";
        MainApp.fc.c01bb = bi.c01bb.getText().toString().trim().length() > 0 ? bi.c01bb.getText().toString() : "-1";
        MainApp.fc.c01bc = bi.c01bc.getText().toString().trim().length() > 0 ? bi.c01bc.getText().toString() : "-1";
        MainApp.fc.c01bd = bi.c01bd.getText().toString().trim().length() > 0 ? bi.c01bd.getText().toString() : "-1";
        MainApp.fc.c01be = bi.c01be.getText().toString().trim().length() > 0 ? bi.c01be.getText().toString() : "-1";

        MainApp.fc.c01ca = bi.c01ca.getText().toString().trim().length() > 0 ? bi.c01ca.getText().toString() : "-1";
        MainApp.fc.c01cb = bi.c01cb.getText().toString().trim().length() > 0 ? bi.c01cb.getText().toString() : "-1";
        MainApp.fc.c01cc = bi.c01cc.getText().toString().trim().length() > 0 ? bi.c01cc.getText().toString() : "-1";
        MainApp.fc.c01cd = bi.c01cd.getText().toString().trim().length() > 0 ? bi.c01cd.getText().toString() : "-1";
        MainApp.fc.c01ce = bi.c01ce.getText().toString().trim().length() > 0 ? bi.c01ce.getText().toString() : "-1";

        MainApp.fc.c01da = bi.c01da.getText().toString().trim().length() > 0 ? bi.c01da.getText().toString() : "-1";
        MainApp.fc.c01db = bi.c01db.getText().toString().trim().length() > 0 ? bi.c01db.getText().toString() : "-1";
        MainApp.fc.c01dc = bi.c01dc.getText().toString().trim().length() > 0 ? bi.c01dc.getText().toString() : "-1";
        MainApp.fc.c01dd = bi.c01dd.getText().toString().trim().length() > 0 ? bi.c01dd.getText().toString() : "-1";
        MainApp.fc.c01de = bi.c01de.getText().toString().trim().length() > 0 ? bi.c01de.getText().toString() : "-1";

        MainApp.fc.c01ea = bi.c01ea.getText().toString().trim().length() > 0 ? bi.c01ea.getText().toString() : "-1";
        MainApp.fc.c01eb = bi.c01eb.getText().toString().trim().length() > 0 ? bi.c01eb.getText().toString() : "-1";
        MainApp.fc.c01ec = bi.c01ec.getText().toString().trim().length() > 0 ? bi.c01ec.getText().toString() : "-1";
        MainApp.fc.c01ed = bi.c01ed.getText().toString().trim().length() > 0 ? bi.c01ed.getText().toString() : "-1";
        MainApp.fc.c01ee = bi.c01ee.getText().toString().trim().length() > 0 ? bi.c01ee.getText().toString() : "-1";

        MainApp.fc.c01fa = bi.c01fa.getText().toString().trim().length() > 0 ? bi.c01fa.getText().toString() : "-1";
        MainApp.fc.c01fb = bi.c01fb.getText().toString().trim().length() > 0 ? bi.c01fb.getText().toString() : "-1";
        MainApp.fc.c01fc = bi.c01fc.getText().toString().trim().length() > 0 ? bi.c01fc.getText().toString() : "-1";
        MainApp.fc.c01fd = bi.c01fd.getText().toString().trim().length() > 0 ? bi.c01fd.getText().toString() : "-1";
        MainApp.fc.c01fe = bi.c01fe.getText().toString().trim().length() > 0 ? bi.c01fe.getText().toString() : "-1";

        MainApp.fc.c01ga = bi.c01ga.getText().toString().trim().length() > 0 ? bi.c01ga.getText().toString() : "-1";
        MainApp.fc.c01gb = bi.c01gb.getText().toString().trim().length() > 0 ? bi.c01gb.getText().toString() : "-1";
        MainApp.fc.c01gc = bi.c01gc.getText().toString().trim().length() > 0 ? bi.c01gc.getText().toString() : "-1";
        MainApp.fc.c01gd = bi.c01gd.getText().toString().trim().length() > 0 ? bi.c01gd.getText().toString() : "-1";
        MainApp.fc.c01ge = bi.c01ge.getText().toString().trim().length() > 0 ? bi.c01ge.getText().toString() : "-1";

        MainApp.fc.c01ha = bi.c01ha.getText().toString().trim().length() > 0 ? bi.c01ha.getText().toString() : "-1";
        MainApp.fc.c01hb = bi.c01hb.getText().toString().trim().length() > 0 ? bi.c01hb.getText().toString() : "-1";
        MainApp.fc.c01hc = bi.c01hc.getText().toString().trim().length() > 0 ? bi.c01hc.getText().toString() : "-1";
        MainApp.fc.c01hd = bi.c01hd.getText().toString().trim().length() > 0 ? bi.c01hd.getText().toString() : "-1";
        MainApp.fc.c01he = bi.c01he.getText().toString().trim().length() > 0 ? bi.c01he.getText().toString() : "-1";

        MainApp.fc.c01ia = bi.c01ia.getText().toString().trim().length() > 0 ? bi.c01ia.getText().toString() : "-1";
        MainApp.fc.c01ib = bi.c01ib.getText().toString().trim().length() > 0 ? bi.c01ib.getText().toString() : "-1";
        MainApp.fc.c01ic = bi.c01ic.getText().toString().trim().length() > 0 ? bi.c01ic.getText().toString() : "-1";
        MainApp.fc.c01id = bi.c01id.getText().toString().trim().length() > 0 ? bi.c01id.getText().toString() : "-1";
        MainApp.fc.c01ie = bi.c01ie.getText().toString().trim().length() > 0 ? bi.c01ie.getText().toString() : "-1";

        MainApp.fc.c01ja = bi.c01ja.getText().toString().trim().length() > 0 ? bi.c01ja.getText().toString() : "-1";
        MainApp.fc.c01jb = bi.c01jb.getText().toString().trim().length() > 0 ? bi.c01jb.getText().toString() : "-1";
        MainApp.fc.c01jc = bi.c01jc.getText().toString().trim().length() > 0 ? bi.c01jc.getText().toString() : "-1";
        MainApp.fc.c01jd = bi.c01jd.getText().toString().trim().length() > 0 ? bi.c01jd.getText().toString() : "-1";
        MainApp.fc.c01je = bi.c01je.getText().toString().trim().length() > 0 ? bi.c01je.getText().toString() : "-1";

        MainApp.fc.c01ka = bi.c01ka.getText().toString().trim().length() > 0 ? bi.c01ka.getText().toString() : "-1";
        MainApp.fc.c01kb = bi.c01kb.getText().toString().trim().length() > 0 ? bi.c01kb.getText().toString() : "-1";
        MainApp.fc.c01kc = bi.c01kc.getText().toString().trim().length() > 0 ? bi.c01kc.getText().toString() : "-1";
        MainApp.fc.c01kd = bi.c01kd.getText().toString().trim().length() > 0 ? bi.c01kd.getText().toString() : "-1";
        MainApp.fc.c01ke = bi.c01ke.getText().toString().trim().length() > 0 ? bi.c01ke.getText().toString() : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        SaveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionC2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

}
