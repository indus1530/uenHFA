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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG413Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG413Activity extends AppCompatActivity {

    ActivitySectionG413Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g413);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0401200s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401200sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401200so);
            }
        }));

        bi.g0401210s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401210sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401210so);
            }
        }));


        bi.g0401220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401220so);
            }
        }));


        bi.g0401230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401230so);
            }
        }));


        bi.g0401240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401240so);
            }
        }));


        bi.g0401250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401250so);
            }
        }));


        bi.g0401260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401260so);
            }
        }));


        bi.g0401270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401270so);
            }
        }));

        bi.g0401280s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401280sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401280so);
            }
        }));

        bi.g0401290s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401290sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401290so);
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

        json.put("g0401200a", bi.g0401200ay.isChecked() ? "1"
                : bi.g0401200an.isChecked() ? "2"
                : "-1");

        json.put("g0401200s", bi.g0401200sy.isChecked() ? "1"
                : bi.g0401200sn.isChecked() ? "2"
                : "-1");

        json.put("g0401200sd", bi.g0401200sd.getText().toString());

        json.put("g0401200sm", bi.g0401200sm.getText().toString());

        json.put("g0401200p", bi.g0401200py.isChecked() ? "1"
                : bi.g0401200pn.isChecked() ? "2"
                : "-1");

        json.put("g0401210a", bi.g0401210ay.isChecked() ? "1"
                : bi.g0401210an.isChecked() ? "2"
                : "-1");

        json.put("g0401210s", bi.g0401210sy.isChecked() ? "1"
                : bi.g0401210sn.isChecked() ? "2"
                : "-1");

        json.put("g0401210sd", bi.g0401210sd.getText().toString());

        json.put("g0401210sm", bi.g0401210sm.getText().toString());

        json.put("g0401210p", bi.g0401210py.isChecked() ? "1"
                : bi.g0401210pn.isChecked() ? "2"
                : "-1");


        json.put("g0401220a", bi.g0401220ay.isChecked() ? "1"
                : bi.g0401220an.isChecked() ? "2"
                : "-1");

        json.put("g0401220s", bi.g0401220sy.isChecked() ? "1"
                : bi.g0401220sn.isChecked() ? "2"
                : "-1");

        json.put("g0401220sd", bi.g0401220sd.getText().toString());

        json.put("g0401220sm", bi.g0401220sm.getText().toString());

        json.put("g0401220p", bi.g0401220py.isChecked() ? "1"
                : bi.g0401220pn.isChecked() ? "2"
                : "-1");


        json.put("g0401230a", bi.g0401230ay.isChecked() ? "1"
                : bi.g0401230an.isChecked() ? "2"
                : "-1");

        json.put("g0401230s", bi.g0401230sy.isChecked() ? "1"
                : bi.g0401230sn.isChecked() ? "2"
                : "-1");

        json.put("g0401230sd", bi.g0401230sd.getText().toString());

        json.put("g0401230sm", bi.g0401230sm.getText().toString());

        json.put("g0401230p", bi.g0401230py.isChecked() ? "1"
                : bi.g0401230pn.isChecked() ? "2"
                : "-1");


        json.put("g0401240a", bi.g0401240ay.isChecked() ? "1"
                : bi.g0401240an.isChecked() ? "2"
                : "-1");

        json.put("g0401240s", bi.g0401240sy.isChecked() ? "1"
                : bi.g0401240sn.isChecked() ? "2"
                : "-1");

        json.put("g0401240sd", bi.g0401240sd.getText().toString());

        json.put("g0401240sm", bi.g0401240sm.getText().toString());

        json.put("g0401240p", bi.g0401240py.isChecked() ? "1"
                : bi.g0401240pn.isChecked() ? "2"
                : "-1");


        json.put("g0401250a", bi.g0401250ay.isChecked() ? "1"
                : bi.g0401250an.isChecked() ? "2"
                : "-1");

        json.put("g0401250s", bi.g0401250sy.isChecked() ? "1"
                : bi.g0401250sn.isChecked() ? "2"
                : "-1");

        json.put("g0401250sd", bi.g0401250sd.getText().toString());

        json.put("g0401250sm", bi.g0401250sm.getText().toString());

        json.put("g0401250p", bi.g0401250py.isChecked() ? "1"
                : bi.g0401250pn.isChecked() ? "2"
                : "-1");


        json.put("g0401260a", bi.g0401260ay.isChecked() ? "1"
                : bi.g0401260an.isChecked() ? "2"
                : "-1");

        json.put("g0401260s", bi.g0401260sy.isChecked() ? "1"
                : bi.g0401260sn.isChecked() ? "2"
                : "-1");

        json.put("g0401260sd", bi.g0401260sd.getText().toString());

        json.put("g0401260sm", bi.g0401260sm.getText().toString());

        json.put("g0401260p", bi.g0401260py.isChecked() ? "1"
                : bi.g0401260pn.isChecked() ? "2"
                : "-1");


        json.put("g0401270a", bi.g0401270ay.isChecked() ? "1"
                : bi.g0401270an.isChecked() ? "2"
                : "-1");

        json.put("g0401270s", bi.g0401270sy.isChecked() ? "1"
                : bi.g0401270sn.isChecked() ? "2"
                : "-1");

        json.put("g0401270sd", bi.g0401270sd.getText().toString());

        json.put("g0401270sm", bi.g0401270sm.getText().toString());

        json.put("g0401270p", bi.g0401270py.isChecked() ? "1"
                : bi.g0401270pn.isChecked() ? "2"
                : "-1");


        json.put("g0401280a", bi.g0401280ay.isChecked() ? "1"
                : bi.g0401280an.isChecked() ? "2"
                : "-1");

        json.put("g0401280s", bi.g0401280sy.isChecked() ? "1"
                : bi.g0401280sn.isChecked() ? "2"
                : "-1");

        json.put("g0401280sd", bi.g0401280sd.getText().toString());

        json.put("g0401280sm", bi.g0401280sm.getText().toString());

        json.put("g0401280p", bi.g0401280py.isChecked() ? "1"
                : bi.g0401280pn.isChecked() ? "2"
                : "-1");


        json.put("g0401290a", bi.g0401290ay.isChecked() ? "1"
                : bi.g0401290an.isChecked() ? "2"
                : "-1");

        json.put("g0401290s", bi.g0401290sy.isChecked() ? "1"
                : bi.g0401290sn.isChecked() ? "2"
                : "-1");

        json.put("g0401290sd", bi.g0401290sd.getText().toString());

        json.put("g0401290sm", bi.g0401290sm.getText().toString());

        json.put("g0401290p", bi.g0401290py.isChecked() ? "1"
                : bi.g0401290pn.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionG414Activity.class));

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
