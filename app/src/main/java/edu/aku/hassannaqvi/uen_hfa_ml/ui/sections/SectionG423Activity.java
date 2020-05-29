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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG423Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG423Activity extends AppCompatActivity {

    ActivitySectionG423Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g423);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0403100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403100so);
            }
        }));

        bi.g0403110s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403110sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403110so);
            }
        }));

        bi.g0403120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403120so);
            }
        }));

        bi.g0403130s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403130sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403130so);
            }
        }));

        bi.g0403140s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403140sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403140so);
            }
        }));

        bi.g0403150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403150so);
            }
        }));

        bi.g0403160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403160so);
            }
        }));

        bi.g0403170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403170so);
            }
        }));

        bi.g0403180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403180so);
            }
        }));

        bi.g0403190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403190so);
            }
        }));

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

        bi.g040410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040410so);
            }
        }));

        bi.g040420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040420so);
            }
        }));

        bi.g040430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040430so);
            }
        }));

        bi.g040440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040440so);
            }
        }));

        bi.g040450s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040450sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040450so);
            }
        }));

        bi.g040460s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040460sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040460so);
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


        json.put("g0403100a", bi.g0403100ay.isChecked() ? "1"
                : bi.g0403100an.isChecked() ? "2"
                : "-1");

        json.put("g0403100s", bi.g0403100sy.isChecked() ? "1"
                : bi.g0403100sn.isChecked() ? "2"
                : "-1");

        json.put("g0403100sd", bi.g0403100sd.getText().toString());

        json.put("g0403100sm", bi.g0403100sm.getText().toString());

        json.put("g0403100p", bi.g0403100py.isChecked() ? "1"
                : bi.g0403100pn.isChecked() ? "2"
                : "-1");


        json.put("g0403110a", bi.g0403110ay.isChecked() ? "1"
                : bi.g0403110an.isChecked() ? "2"
                : "-1");

        json.put("g0403110s", bi.g0403110sy.isChecked() ? "1"
                : bi.g0403110sn.isChecked() ? "2"
                : "-1");

        json.put("g0403110sd", bi.g0403110sd.getText().toString());

        json.put("g0403110sm", bi.g0403110sm.getText().toString());

        json.put("g0403110p", bi.g0403110py.isChecked() ? "1"
                : bi.g0403110pn.isChecked() ? "2"
                : "-1");


        json.put("g0403120a", bi.g0403120ay.isChecked() ? "1"
                : bi.g0403120an.isChecked() ? "2"
                : "-1");

        json.put("g0403120s", bi.g0403120sy.isChecked() ? "1"
                : bi.g0403120sn.isChecked() ? "2"
                : "-1");

        json.put("g0403120sd", bi.g0403120sd.getText().toString());

        json.put("g0403120sm", bi.g0403120sm.getText().toString());

        json.put("g0403120p", bi.g0403120py.isChecked() ? "1"
                : bi.g0403120pn.isChecked() ? "2"
                : "-1");

        json.put("g0403130a", bi.g0403130ay.isChecked() ? "1"
                : bi.g0403130an.isChecked() ? "2"
                : "-1");

        json.put("g0403130s", bi.g0403130sy.isChecked() ? "1"
                : bi.g0403130sn.isChecked() ? "2"
                : "-1");

        json.put("g0403130sd", bi.g0403130sd.getText().toString());

        json.put("g0403130sm", bi.g0403130sm.getText().toString());

        json.put("g0403130p", bi.g0403130py.isChecked() ? "1"
                : bi.g0403130pn.isChecked() ? "2"
                : "-1");

        json.put("g0403140a", bi.g0403140ay.isChecked() ? "1"
                : bi.g0403140an.isChecked() ? "2"
                : "-1");

        json.put("g0403140s", bi.g0403140sy.isChecked() ? "1"
                : bi.g0403140sn.isChecked() ? "2"
                : "-1");

        json.put("g0403140sd", bi.g0403140sd.getText().toString());

        json.put("g0403140sm", bi.g0403140sm.getText().toString());

        json.put("g0403140p", bi.g0403140py.isChecked() ? "1"
                : bi.g0403140pn.isChecked() ? "2"
                : "-1");

        json.put("g0403150a", bi.g0403150ay.isChecked() ? "1"
                : bi.g0403150an.isChecked() ? "2"
                : "-1");

        json.put("g0403150s", bi.g0403150sy.isChecked() ? "1"
                : bi.g0403150sn.isChecked() ? "2"
                : "-1");

        json.put("g0403150sd", bi.g0403150sd.getText().toString());

        json.put("g0403150sm", bi.g0403150sm.getText().toString());

        json.put("g0403150p", bi.g0403150py.isChecked() ? "1"
                : bi.g0403150pn.isChecked() ? "2"
                : "-1");

        json.put("g0403160a", bi.g0403160ay.isChecked() ? "1"
                : bi.g0403160an.isChecked() ? "2"
                : "-1");

        json.put("g0403160s", bi.g0403160sy.isChecked() ? "1"
                : bi.g0403160sn.isChecked() ? "2"
                : "-1");

        json.put("g0403160sd", bi.g0403160sd.getText().toString());

        json.put("g0403160sm", bi.g0403160sm.getText().toString());

        json.put("g0403160p", bi.g0403160py.isChecked() ? "1"
                : bi.g0403160pn.isChecked() ? "2"
                : "-1");

        json.put("g0403170a", bi.g0403170ay.isChecked() ? "1"
                : bi.g0403170an.isChecked() ? "2"
                : "-1");

        json.put("g0403170s", bi.g0403170sy.isChecked() ? "1"
                : bi.g0403170sn.isChecked() ? "2"
                : "-1");

        json.put("g0403170sd", bi.g0403170sd.getText().toString());

        json.put("g0403170sm", bi.g0403170sm.getText().toString());

        json.put("g0403170p", bi.g0403170py.isChecked() ? "1"
                : bi.g0403170pn.isChecked() ? "2"
                : "-1");

        json.put("g0403180a", bi.g0403180ay.isChecked() ? "1"
                : bi.g0403180an.isChecked() ? "2"
                : "-1");

        json.put("g0403180s", bi.g0403180sy.isChecked() ? "1"
                : bi.g0403180sn.isChecked() ? "2"
                : "-1");

        json.put("g0403180sd", bi.g0403180sd.getText().toString());

        json.put("g0403180sm", bi.g0403180sm.getText().toString());

        json.put("g0403180p", bi.g0403180py.isChecked() ? "1"
                : bi.g0403180pn.isChecked() ? "2"
                : "-1");

        json.put("g0403190a", bi.g0403190ay.isChecked() ? "1"
                : bi.g0403190an.isChecked() ? "2"
                : "-1");

        json.put("g0403190s", bi.g0403190sy.isChecked() ? "1"
                : bi.g0403190sn.isChecked() ? "2"
                : "-1");

        json.put("g0403190sd", bi.g0403190sd.getText().toString());

        json.put("g0403190sm", bi.g0403190sm.getText().toString());

        json.put("g0403190p", bi.g0403190py.isChecked() ? "1"
                : bi.g0403190pn.isChecked() ? "2"
                : "-1");

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

        json.put("g040410a", bi.g040410ay.isChecked() ? "1"
                : bi.g040410an.isChecked() ? "2"
                : "-1");

        json.put("g040410s", bi.g040410sy.isChecked() ? "1"
                : bi.g040410sn.isChecked() ? "2"
                : "-1");

        json.put("g040410sd", bi.g040410sd.getText().toString());

        json.put("g040410sm", bi.g040410sm.getText().toString());

        json.put("g040410p", bi.g040410py.isChecked() ? "1"
                : bi.g040410pn.isChecked() ? "2"
                : "-1");

        json.put("g040420a", bi.g040420ay.isChecked() ? "1"
                : bi.g040420an.isChecked() ? "2"
                : "-1");

        json.put("g040420s", bi.g040420sy.isChecked() ? "1"
                : bi.g040420sn.isChecked() ? "2"
                : "-1");

        json.put("g040420sd", bi.g040420sd.getText().toString());

        json.put("g040420sm", bi.g040420sm.getText().toString());

        json.put("g040420p", bi.g040420py.isChecked() ? "1"
                : bi.g040420pn.isChecked() ? "2"
                : "-1");

        json.put("g040430a", bi.g040430ay.isChecked() ? "1"
                : bi.g040430an.isChecked() ? "2"
                : "-1");

        json.put("g040430s", bi.g040430sy.isChecked() ? "1"
                : bi.g040430sn.isChecked() ? "2"
                : "-1");

        json.put("g040430sd", bi.g040430sd.getText().toString());

        json.put("g040430sm", bi.g040430sm.getText().toString());

        json.put("g040430p", bi.g040430py.isChecked() ? "1"
                : bi.g040430pn.isChecked() ? "2"
                : "-1");

        json.put("g040440a", bi.g040440ay.isChecked() ? "1"
                : bi.g040440an.isChecked() ? "2"
                : "-1");

        json.put("g040440s", bi.g040440sy.isChecked() ? "1"
                : bi.g040440sn.isChecked() ? "2"
                : "-1");

        json.put("g040440sd", bi.g040440sd.getText().toString());

        json.put("g040440sm", bi.g040440sm.getText().toString());

        json.put("g040440p", bi.g040440py.isChecked() ? "1"
                : bi.g040440pn.isChecked() ? "2"
                : "-1");

        json.put("g040450a", bi.g040450ay.isChecked() ? "1"
                : bi.g040450an.isChecked() ? "2"
                : "-1");

        json.put("g040450s", bi.g040450sy.isChecked() ? "1"
                : bi.g040450sn.isChecked() ? "2"
                : "-1");

        json.put("g040450sd", bi.g040450sd.getText().toString());

        json.put("g040450sm", bi.g040450sm.getText().toString());

        json.put("g040450p", bi.g040450py.isChecked() ? "1"
                : bi.g040450pn.isChecked() ? "2"
                : "-1");

        json.put("g040460a", bi.g040460ay.isChecked() ? "1"
                : bi.g040460an.isChecked() ? "2"
                : "-1");

        json.put("g040460s", bi.g040460sy.isChecked() ? "1"
                : bi.g040460sn.isChecked() ? "2"
                : "-1");

        json.put("g040460sd", bi.g040460sd.getText().toString());

        json.put("g040460sm", bi.g040460sm.getText().toString());

        json.put("g040460p", bi.g040460py.isChecked() ? "1"
                : bi.g040460pn.isChecked() ? "2"
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
                startActivity(new Intent(this, SectionMainActivity.class));

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
