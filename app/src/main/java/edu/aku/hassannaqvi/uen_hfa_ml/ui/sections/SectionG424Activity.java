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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG424Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG424Activity extends AppCompatActivity {

    ActivitySectionG424Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g424);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0403200s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403200sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403200so);
            }
        }));

        bi.g0403210s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403210sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403210so);
            }
        }));

        bi.g0403220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403220so);
            }
        }));

        bi.g0403230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403230so);
            }
        }));

        bi.g0403240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403240so);
            }
        }));

        bi.g0403250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403250so);
            }
        }));

        bi.g0403260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403260so);
            }
        }));

        bi.g0403270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403270so);
            }
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SG, fc.getsG());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("g0403200a", bi.g0403200ay.isChecked() ? "1"
                : bi.g0403200an.isChecked() ? "2"
                : "-1");

        json.put("g0403200s", bi.g0403200sy.isChecked() ? "1"
                : bi.g0403200sn.isChecked() ? "2"
                : "-1");

        json.put("g0403200sd", bi.g0403200sd.getText().toString());

        json.put("g0403200sm", bi.g0403200sm.getText().toString());

        json.put("g0403200p", bi.g0403200py.isChecked() ? "1"
                : bi.g0403200pn.isChecked() ? "2"
                : "-1");

        json.put("g0403210a", bi.g0403210ay.isChecked() ? "1"
                : bi.g0403210an.isChecked() ? "2"
                : "-1");

        json.put("g0403210s", bi.g0403210sy.isChecked() ? "1"
                : bi.g0403210sn.isChecked() ? "2"
                : "-1");

        json.put("g0403210sd", bi.g0403210sd.getText().toString());

        json.put("g0403210sm", bi.g0403210sm.getText().toString());

        json.put("g0403210p", bi.g0403210py.isChecked() ? "1"
                : bi.g0403210pn.isChecked() ? "2"
                : "-1");

        json.put("g0403220a", bi.g0403220ay.isChecked() ? "1"
                : bi.g0403220an.isChecked() ? "2"
                : "-1");

        json.put("g0403220s", bi.g0403220sy.isChecked() ? "1"
                : bi.g0403220sn.isChecked() ? "2"
                : "-1");

        json.put("g0403220sd", bi.g0403220sd.getText().toString());

        json.put("g0403220sm", bi.g0403220sm.getText().toString());

        json.put("g0403220p", bi.g0403220py.isChecked() ? "1"
                : bi.g0403220pn.isChecked() ? "2"
                : "-1");

        json.put("g0403230a", bi.g0403230ay.isChecked() ? "1"
                : bi.g0403230an.isChecked() ? "2"
                : "-1");

        json.put("g0403230s", bi.g0403230sy.isChecked() ? "1"
                : bi.g0403230sn.isChecked() ? "2"
                : "-1");

        json.put("g0403230sd", bi.g0403230sd.getText().toString());

        json.put("g0403230sm", bi.g0403230sm.getText().toString());

        json.put("g0403230p", bi.g0403230py.isChecked() ? "1"
                : bi.g0403230pn.isChecked() ? "2"
                : "-1");

        json.put("g0403240a", bi.g0403240ay.isChecked() ? "1"
                : bi.g0403240an.isChecked() ? "2"
                : "-1");

        json.put("g0403240s", bi.g0403240sy.isChecked() ? "1"
                : bi.g0403240sn.isChecked() ? "2"
                : "-1");

        json.put("g0403240sd", bi.g0403240sd.getText().toString());

        json.put("g0403240sm", bi.g0403240sm.getText().toString());

        json.put("g0403240p", bi.g0403240py.isChecked() ? "1"
                : bi.g0403240pn.isChecked() ? "2"
                : "-1");

        json.put("g0403250a", bi.g0403250ay.isChecked() ? "1"
                : bi.g0403250an.isChecked() ? "2"
                : "-1");

        json.put("g0403250s", bi.g0403250sy.isChecked() ? "1"
                : bi.g0403250sn.isChecked() ? "2"
                : "-1");

        json.put("g0403250sd", bi.g0403250sd.getText().toString());

        json.put("g0403250sm", bi.g0403250sm.getText().toString());

        json.put("g0403250p", bi.g0403250py.isChecked() ? "1"
                : bi.g0403250pn.isChecked() ? "2"
                : "-1");

        json.put("g0403260a", bi.g0403260ay.isChecked() ? "1"
                : bi.g0403260an.isChecked() ? "2"
                : "-1");

        json.put("g0403260s", bi.g0403260sy.isChecked() ? "1"
                : bi.g0403260sn.isChecked() ? "2"
                : "-1");

        json.put("g0403260sd", bi.g0403260sd.getText().toString());

        json.put("g0403260sm", bi.g0403260sm.getText().toString());

        json.put("g0403260p", bi.g0403260py.isChecked() ? "1"
                : bi.g0403260pn.isChecked() ? "2"
                : "-1");

        json.put("g0403270a", bi.g0403270ay.isChecked() ? "1"
                : bi.g0403270an.isChecked() ? "2"
                : "-1");

        json.put("g0403270s", bi.g0403270sy.isChecked() ? "1"
                : bi.g0403270sn.isChecked() ? "2"
                : "-1");

        json.put("g0403270sd", bi.g0403270sd.getText().toString());

        json.put("g0403270sm", bi.g0403270sm.getText().toString());

        json.put("g0403270p", bi.g0403270py.isChecked() ? "1"
                : bi.g0403270pn.isChecked() ? "2"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(MainApp.fc.getsG()), json);

            MainApp.fc.setsG(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

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
                startActivity(new Intent(this, SectionG425Activity.class));

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
