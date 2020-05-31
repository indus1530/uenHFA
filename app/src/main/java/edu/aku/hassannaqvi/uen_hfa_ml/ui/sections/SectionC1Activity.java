package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionC1Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding bi;
    boolean imFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);
        setupSkips();
        setupTextWatchers();
    }


    private void setupTextWatchers() {
        editTextImplementation(bi.c01aa, new EditTextPicker[]{bi.c01ab, bi.c01ad, bi.c01ae}, bi.c01ac);
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
                if ((edit01.getText()).hashCode() == editable.hashCode()) {
                    for (EditTextPicker item : editTextsArray)
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
                if ((editTextsArray[0].getText()).hashCode() == charSequence.hashCode()) {
                    edit02.setText(null);
                    edit02.setEnabled(false);
                    edit02.setText((Integer.parseInt(edit01.getText().toString().trim()) - Integer.parseInt(editTextsArray[0].getText().toString().trim())));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

    }


    private void setupSkips() {

        /*bi.uf14.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.uf14a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVuf15, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVuf15, true);
            }
        }));*/

        /*bi.c01ab.setMaxvalue(bi.c01aa.getText().toString().trim().length() > 0 ?
                Float.parseFloat(bi.c01aa.getText().toString().trim())
                : Float.parseFloat(bi.c01ab.getText().toString().trim()));*/
    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, fc.getsC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("c01aa", bi.c01aa.getText().toString());

        json.put("c01ab", bi.c01ab.getText().toString());

        json.put("c01ac", bi.c01ac.getText().toString());

        json.put("c01ad", bi.c01ad.getText().toString());

        json.put("c01ae", bi.c01ae.getText().toString());

        json.put("c01ba", bi.c01ba.getText().toString());

        json.put("c01bb", bi.c01bb.getText().toString());

        json.put("c01bc", bi.c01bc.getText().toString());

        json.put("c01bd", bi.c01bd.getText().toString());

        json.put("c01be", bi.c01be.getText().toString());

        json.put("c01ca", bi.c01ca.getText().toString());

        json.put("c01cb", bi.c01cb.getText().toString());

        json.put("c01cc", bi.c01cc.getText().toString());

        json.put("c01cd", bi.c01cd.getText().toString());

        json.put("c01ce", bi.c01ce.getText().toString());

        json.put("c01da", bi.c01da.getText().toString());

        json.put("c01db", bi.c01db.getText().toString());

        json.put("c01dc", bi.c01dc.getText().toString());

        json.put("c01dd", bi.c01dd.getText().toString());

        json.put("c01de", bi.c01de.getText().toString());

        json.put("c01ea", bi.c01ea.getText().toString());

        json.put("c01eb", bi.c01eb.getText().toString());

        json.put("c01ec", bi.c01ec.getText().toString());

        json.put("c01ed", bi.c01ed.getText().toString());

        json.put("c01ee", bi.c01ee.getText().toString());

        json.put("c01fa", bi.c01fa.getText().toString());

        json.put("c01fb", bi.c01fb.getText().toString());

        json.put("c01fc", bi.c01fc.getText().toString());

        json.put("c01fd", bi.c01fd.getText().toString());

        json.put("c01fe", bi.c01fe.getText().toString());

        json.put("c01ga", bi.c01ga.getText().toString());

        json.put("c01gb", bi.c01gb.getText().toString());

        json.put("c01gc", bi.c01gc.getText().toString());

        json.put("c01gd", bi.c01gd.getText().toString());

        json.put("c01ge", bi.c01ge.getText().toString());

        json.put("c01ha", bi.c01ha.getText().toString());

        json.put("c01hb", bi.c01hb.getText().toString());

        json.put("c01hc", bi.c01hc.getText().toString());

        json.put("c01hd", bi.c01hd.getText().toString());

        json.put("c01he", bi.c01he.getText().toString());

        json.put("c01ia", bi.c01ia.getText().toString());

        json.put("c01ib", bi.c01ib.getText().toString());

        json.put("c01ic", bi.c01ic.getText().toString());

        json.put("c01id", bi.c01id.getText().toString());

        json.put("c01ie", bi.c01ie.getText().toString());

        json.put("c01ja", bi.c01ja.getText().toString());

        json.put("c01jb", bi.c01jb.getText().toString());

        json.put("c01jc", bi.c01jc.getText().toString());

        json.put("c01jd", bi.c01jd.getText().toString());

        json.put("c01je", bi.c01je.getText().toString());

        json.put("c01ka", bi.c01ka.getText().toString());

        json.put("c01kb", bi.c01kb.getText().toString());

        json.put("c01kc", bi.c01kc.getText().toString());

        json.put("c01kd", bi.c01kd.getText().toString());

        json.put("c01ke", bi.c01ke.getText().toString());

        MainApp.fc.setsC(String.valueOf(json));

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
                startActivity(new Intent(this, SectionC2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
