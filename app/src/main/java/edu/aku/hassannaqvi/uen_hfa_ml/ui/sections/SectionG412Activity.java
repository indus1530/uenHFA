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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG412Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG412Activity extends AppCompatActivity {

    ActivitySectionG412Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g412);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g0401120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401120so);
            }
        }));

        bi.g0401130s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401130sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401130so);
            }
        }));

        bi.g0401140s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401140sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401140so);
            }
        }));

        bi.g0401150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401150so);
            }
        }));

        bi.g0401160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401160so);
            }
        }));

        bi.g0401170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401170so);
            }
        }));

        bi.g0401180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401180so);
            }
        }));

        bi.g0401190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401190so);
            }
        }));

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


        /*bi.g0401220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401220so);
            }
        }));*/


        /*bi.g0401230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401230so);
            }
        }));*/


        /*bi.g0401240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401240so);
            }
        }));*/


        /*bi.g0401250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401250so);
            }
        }));*/


        /*bi.g0401260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401260so);
            }
        }));*/


        /*bi.g0401270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401270so);
            }
        }));*/

        /*bi.g0401280s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401280sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401280so);
            }
        }));*/

        /*bi.g0401290s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401290sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401290so);
            }
        }));*/

        /*bi.g0401300s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401300sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401300so);
            }
        }));

        bi.g0401310s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401310sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401310so);
            }
        }));

        bi.g0401320s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401320sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401320so);
            }
        }));

        bi.g0401330s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401330sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401330so);
            }
        }));

        bi.g0401340s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401340sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401340so);
            }
        }));

        bi.g0401350s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401350sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401350so);
            }
        }));

        bi.g0401360s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401360sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401360so);
            }
        }));

        bi.g0401370s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401370sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401370so);
            }
        }));

        bi.g0401380s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401380sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401380so);
            }
        }));

        bi.g0401390s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401390sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401390so);
            }
        }));*/

        /*bi.g0401400s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401400sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401400so);
            }
        }));*/

        /*bi.g0401410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401410so);
            }
        }));*/

        /*bi.g0401420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401420so);
            }
        }));*/

        /*bi.g0401430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401430so);
            }
        }));*/

        /*bi.g0401440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0401440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0401440so);
            }
        }));*/

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

        json.put("g0401120a", bi.g0401120ay.isChecked() ? "1"
                : bi.g0401120an.isChecked() ? "2"
                : "-1");

        json.put("g0401120s", bi.g0401120sy.isChecked() ? "1"
                : bi.g0401120sn.isChecked() ? "2"
                : "-1");

        json.put("g0401120sd", bi.g0401120sd.getText().toString());

        json.put("g0401120sm", bi.g0401120sm.getText().toString());

        json.put("g0401120p", bi.g0401120py.isChecked() ? "1"
                : bi.g0401120pn.isChecked() ? "2"
                : "-1");

        json.put("g0401130a", bi.g0401130ay.isChecked() ? "1"
                : bi.g0401130an.isChecked() ? "2"
                : "-1");

        json.put("g0401130s", bi.g0401130sy.isChecked() ? "1"
                : bi.g0401130sn.isChecked() ? "2"
                : "-1");

        json.put("g0401130sd", bi.g0401130sd.getText().toString());

        json.put("g0401130sm", bi.g0401130sm.getText().toString());

        json.put("g0401130p", bi.g0401130py.isChecked() ? "1"
                : bi.g0401130pn.isChecked() ? "2"
                : "-1");

        json.put("g0401140a", bi.g0401140ay.isChecked() ? "1"
                : bi.g0401140an.isChecked() ? "2"
                : "-1");

        json.put("g0401140s", bi.g0401140sy.isChecked() ? "1"
                : bi.g0401140sn.isChecked() ? "2"
                : "-1");

        json.put("g0401140sd", bi.g0401140sd.getText().toString());

        json.put("g0401140sm", bi.g0401140sm.getText().toString());

        json.put("g0401140p", bi.g0401140py.isChecked() ? "1"
                : bi.g0401140pn.isChecked() ? "2"
                : "-1");

        json.put("g0401150a", bi.g0401150ay.isChecked() ? "1"
                : bi.g0401150an.isChecked() ? "2"
                : "-1");

        json.put("g0401150s", bi.g0401150sy.isChecked() ? "1"
                : bi.g0401150sn.isChecked() ? "2"
                : "-1");

        json.put("g0401150sd", bi.g0401150sd.getText().toString());

        json.put("g0401150sm", bi.g0401150sm.getText().toString());

        json.put("g0401150p", bi.g0401150py.isChecked() ? "1"
                : bi.g0401150pn.isChecked() ? "2"
                : "-1");

        json.put("g0401160a", bi.g0401160ay.isChecked() ? "1"
                : bi.g0401160an.isChecked() ? "2"
                : "-1");

        json.put("g0401160s", bi.g0401160sy.isChecked() ? "1"
                : bi.g0401160sn.isChecked() ? "2"
                : "-1");

        json.put("g0401160sd", bi.g0401160sd.getText().toString());

        json.put("g0401160sm", bi.g0401160sm.getText().toString());

        json.put("g0401160p", bi.g0401160py.isChecked() ? "1"
                : bi.g0401160pn.isChecked() ? "2"
                : "-1");

        json.put("g0401170a", bi.g0401170ay.isChecked() ? "1"
                : bi.g0401170an.isChecked() ? "2"
                : "-1");

        json.put("g0401170s", bi.g0401170sy.isChecked() ? "1"
                : bi.g0401170sn.isChecked() ? "2"
                : "-1");

        json.put("g0401170sd", bi.g0401170sd.getText().toString());

        json.put("g0401170sm", bi.g0401170sm.getText().toString());

        json.put("g0401170p", bi.g0401170py.isChecked() ? "1"
                : bi.g0401170pn.isChecked() ? "2"
                : "-1");


        json.put("g0401180a", bi.g0401180ay.isChecked() ? "1"
                : bi.g0401180an.isChecked() ? "2"
                : "-1");

        json.put("g0401180s", bi.g0401180sy.isChecked() ? "1"
                : bi.g0401180sn.isChecked() ? "2"
                : "-1");

        json.put("g0401180sd", bi.g0401180sd.getText().toString());

        json.put("g0401180sm", bi.g0401180sm.getText().toString());

        json.put("g0401180p", bi.g0401180py.isChecked() ? "1"
                : bi.g0401180pn.isChecked() ? "2"
                : "-1");


        json.put("g0401190a", bi.g0401190ay.isChecked() ? "1"
                : bi.g0401190an.isChecked() ? "2"
                : "-1");

        json.put("g0401190s", bi.g0401190sy.isChecked() ? "1"
                : bi.g0401190sn.isChecked() ? "2"
                : "-1");

        json.put("g0401190sd", bi.g0401190sd.getText().toString());

        json.put("g0401190sm", bi.g0401190sm.getText().toString());

        json.put("g0401190p", bi.g0401190py.isChecked() ? "1"
                : bi.g0401190pn.isChecked() ? "2"
                : "-1");

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


        /*json.put("g0401220a", bi.g0401220ay.isChecked() ? "1"
                : bi.g0401220an.isChecked() ? "2"
                : "-1");

        json.put("g0401220s", bi.g0401220sy.isChecked() ? "1"
                : bi.g0401220sn.isChecked() ? "2"
                : "-1");

        json.put("g0401220sd", bi.g0401220sd.getText().toString());

        json.put("g0401220sm", bi.g0401220sm.getText().toString());

        json.put("g0401220p", bi.g0401220py.isChecked() ? "1"
                : bi.g0401220pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401230a", bi.g0401230ay.isChecked() ? "1"
                : bi.g0401230an.isChecked() ? "2"
                : "-1");

        json.put("g0401230s", bi.g0401230sy.isChecked() ? "1"
                : bi.g0401230sn.isChecked() ? "2"
                : "-1");

        json.put("g0401230sd", bi.g0401230sd.getText().toString());

        json.put("g0401230sm", bi.g0401230sm.getText().toString());

        json.put("g0401230p", bi.g0401230py.isChecked() ? "1"
                : bi.g0401230pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401240a", bi.g0401240ay.isChecked() ? "1"
                : bi.g0401240an.isChecked() ? "2"
                : "-1");

        json.put("g0401240s", bi.g0401240sy.isChecked() ? "1"
                : bi.g0401240sn.isChecked() ? "2"
                : "-1");

        json.put("g0401240sd", bi.g0401240sd.getText().toString());

        json.put("g0401240sm", bi.g0401240sm.getText().toString());

        json.put("g0401240p", bi.g0401240py.isChecked() ? "1"
                : bi.g0401240pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401250a", bi.g0401250ay.isChecked() ? "1"
                : bi.g0401250an.isChecked() ? "2"
                : "-1");

        json.put("g0401250s", bi.g0401250sy.isChecked() ? "1"
                : bi.g0401250sn.isChecked() ? "2"
                : "-1");

        json.put("g0401250sd", bi.g0401250sd.getText().toString());

        json.put("g0401250sm", bi.g0401250sm.getText().toString());

        json.put("g0401250p", bi.g0401250py.isChecked() ? "1"
                : bi.g0401250pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401260a", bi.g0401260ay.isChecked() ? "1"
                : bi.g0401260an.isChecked() ? "2"
                : "-1");

        json.put("g0401260s", bi.g0401260sy.isChecked() ? "1"
                : bi.g0401260sn.isChecked() ? "2"
                : "-1");

        json.put("g0401260sd", bi.g0401260sd.getText().toString());

        json.put("g0401260sm", bi.g0401260sm.getText().toString());

        json.put("g0401260p", bi.g0401260py.isChecked() ? "1"
                : bi.g0401260pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401270a", bi.g0401270ay.isChecked() ? "1"
                : bi.g0401270an.isChecked() ? "2"
                : "-1");

        json.put("g0401270s", bi.g0401270sy.isChecked() ? "1"
                : bi.g0401270sn.isChecked() ? "2"
                : "-1");

        json.put("g0401270sd", bi.g0401270sd.getText().toString());

        json.put("g0401270sm", bi.g0401270sm.getText().toString());

        json.put("g0401270p", bi.g0401270py.isChecked() ? "1"
                : bi.g0401270pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401280a", bi.g0401280ay.isChecked() ? "1"
                : bi.g0401280an.isChecked() ? "2"
                : "-1");

        json.put("g0401280s", bi.g0401280sy.isChecked() ? "1"
                : bi.g0401280sn.isChecked() ? "2"
                : "-1");

        json.put("g0401280sd", bi.g0401280sd.getText().toString());

        json.put("g0401280sm", bi.g0401280sm.getText().toString());

        json.put("g0401280p", bi.g0401280py.isChecked() ? "1"
                : bi.g0401280pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401290a", bi.g0401290ay.isChecked() ? "1"
                : bi.g0401290an.isChecked() ? "2"
                : "-1");

        json.put("g0401290s", bi.g0401290sy.isChecked() ? "1"
                : bi.g0401290sn.isChecked() ? "2"
                : "-1");

        json.put("g0401290sd", bi.g0401290sd.getText().toString());

        json.put("g0401290sm", bi.g0401290sm.getText().toString());

        json.put("g0401290p", bi.g0401290py.isChecked() ? "1"
                : bi.g0401290pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401300a", bi.g0401300ay.isChecked() ? "1"
                : bi.g0401300an.isChecked() ? "2"
                : "-1");

        json.put("g0401300s", bi.g0401300sy.isChecked() ? "1"
                : bi.g0401300sn.isChecked() ? "2"
                : "-1");

        json.put("g0401300sd", bi.g0401300sd.getText().toString());

        json.put("g0401300sm", bi.g0401300sm.getText().toString());

        json.put("g0401300p", bi.g0401300py.isChecked() ? "1"
                : bi.g0401300pn.isChecked() ? "2"
                : "-1");

        json.put("g0401310a", bi.g0401310ay.isChecked() ? "1"
                : bi.g0401310an.isChecked() ? "2"
                : "-1");

        json.put("g0401310s", bi.g0401310sy.isChecked() ? "1"
                : bi.g0401310sn.isChecked() ? "2"
                : "-1");

        json.put("g0401310sd", bi.g0401310sd.getText().toString());

        json.put("g0401310sm", bi.g0401310sm.getText().toString());

        json.put("g0401310p", bi.g0401310py.isChecked() ? "1"
                : bi.g0401310pn.isChecked() ? "2"
                : "-1");

        json.put("g0401320a", bi.g0401320ay.isChecked() ? "1"
                : bi.g0401320an.isChecked() ? "2"
                : "-1");

        json.put("g0401320s", bi.g0401320sy.isChecked() ? "1"
                : bi.g0401320sn.isChecked() ? "2"
                : "-1");

        json.put("g0401320sd", bi.g0401320sd.getText().toString());

        json.put("g0401320sm", bi.g0401320sm.getText().toString());

        json.put("g0401320p", bi.g0401320py.isChecked() ? "1"
                : bi.g0401320pn.isChecked() ? "2"
                : "-1");

        json.put("g0401330a", bi.g0401330ay.isChecked() ? "1"
                : bi.g0401330an.isChecked() ? "2"
                : "-1");

        json.put("g0401330s", bi.g0401330sy.isChecked() ? "1"
                : bi.g0401330sn.isChecked() ? "2"
                : "-1");

        json.put("g0401330sd", bi.g0401330sd.getText().toString());

        json.put("g0401330sm", bi.g0401330sm.getText().toString());

        json.put("g0401330p", bi.g0401330py.isChecked() ? "1"
                : bi.g0401330pn.isChecked() ? "2"
                : "-1");

        json.put("g0401340a", bi.g0401340ay.isChecked() ? "1"
                : bi.g0401340an.isChecked() ? "2"
                : "-1");

        json.put("g0401340s", bi.g0401340sy.isChecked() ? "1"
                : bi.g0401340sn.isChecked() ? "2"
                : "-1");

        json.put("g0401340sd", bi.g0401340sd.getText().toString());

        json.put("g0401340sm", bi.g0401340sm.getText().toString());

        json.put("g0401340p", bi.g0401340py.isChecked() ? "1"
                : bi.g0401340pn.isChecked() ? "2"
                : "-1");

        json.put("g0401350a", bi.g0401350ay.isChecked() ? "1"
                : bi.g0401350an.isChecked() ? "2"
                : "-1");

        json.put("g0401350s", bi.g0401350sy.isChecked() ? "1"
                : bi.g0401350sn.isChecked() ? "2"
                : "-1");

        json.put("g0401350sd", bi.g0401350sd.getText().toString());

        json.put("g0401350sm", bi.g0401350sm.getText().toString());

        json.put("g0401350p", bi.g0401350py.isChecked() ? "1"
                : bi.g0401350pn.isChecked() ? "2"
                : "-1");

        json.put("g0401360a", bi.g0401360ay.isChecked() ? "1"
                : bi.g0401360an.isChecked() ? "2"
                : "-1");

        json.put("g0401360s", bi.g0401360sy.isChecked() ? "1"
                : bi.g0401360sn.isChecked() ? "2"
                : "-1");

        json.put("g0401360sd", bi.g0401360sd.getText().toString());

        json.put("g0401360sm", bi.g0401360sm.getText().toString());

        json.put("g0401360p", bi.g0401360py.isChecked() ? "1"
                : bi.g0401360pn.isChecked() ? "2"
                : "-1");

        json.put("g0401370a", bi.g0401370ay.isChecked() ? "1"
                : bi.g0401370an.isChecked() ? "2"
                : "-1");

        json.put("g0401370s", bi.g0401370sy.isChecked() ? "1"
                : bi.g0401370sn.isChecked() ? "2"
                : "-1");

        json.put("g0401370sd", bi.g0401370sd.getText().toString());

        json.put("g0401370sm", bi.g0401370sm.getText().toString());

        json.put("g0401370p", bi.g0401370py.isChecked() ? "1"
                : bi.g0401370pn.isChecked() ? "2"
                : "-1");

        json.put("g0401380a", bi.g0401380ay.isChecked() ? "1"
                : bi.g0401380an.isChecked() ? "2"
                : "-1");

        json.put("g0401380s", bi.g0401380sy.isChecked() ? "1"
                : bi.g0401380sn.isChecked() ? "2"
                : "-1");

        json.put("g0401380sd", bi.g0401380sd.getText().toString());

        json.put("g0401380sm", bi.g0401380sm.getText().toString());

        json.put("g0401380p", bi.g0401380py.isChecked() ? "1"
                : bi.g0401380pn.isChecked() ? "2"
                : "-1");

        json.put("g0401390a", bi.g0401390ay.isChecked() ? "1"
                : bi.g0401390an.isChecked() ? "2"
                : "-1");

        json.put("g0401390s", bi.g0401390sy.isChecked() ? "1"
                : bi.g0401390sn.isChecked() ? "2"
                : "-1");

        json.put("g0401390sd", bi.g0401390sd.getText().toString());

        json.put("g0401390sm", bi.g0401390sm.getText().toString());

        json.put("g0401390p", bi.g0401390py.isChecked() ? "1"
                : bi.g0401390pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401400a", bi.g0401400ay.isChecked() ? "1"
                : bi.g0401400an.isChecked() ? "2"
                : "-1");

        json.put("g0401400s", bi.g0401400sy.isChecked() ? "1"
                : bi.g0401400sn.isChecked() ? "2"
                : "-1");

        json.put("g0401400sd", bi.g0401400sd.getText().toString());

        json.put("g0401400sm", bi.g0401400sm.getText().toString());

        json.put("g0401400p", bi.g0401400py.isChecked() ? "1"
                : bi.g0401400pn.isChecked() ? "2"
                : "-1");


        json.put("g0401410a", bi.g0401410ay.isChecked() ? "1"
                : bi.g0401410an.isChecked() ? "2"
                : "-1");

        json.put("g0401410s", bi.g0401410sy.isChecked() ? "1"
                : bi.g0401410sn.isChecked() ? "2"
                : "-1");

        json.put("g0401410sd", bi.g0401410sd.getText().toString());

        json.put("g0401410sm", bi.g0401410sm.getText().toString());

        json.put("g0401410p", bi.g0401410py.isChecked() ? "1"
                : bi.g0401410pn.isChecked() ? "2"
                : "-1");


        json.put("g0401420a", bi.g0401420ay.isChecked() ? "1"
                : bi.g0401420an.isChecked() ? "2"
                : "-1");

        json.put("g0401420s", bi.g0401420sy.isChecked() ? "1"
                : bi.g0401420sn.isChecked() ? "2"
                : "-1");

        json.put("g0401420sd", bi.g0401420sd.getText().toString());

        json.put("g0401420sm", bi.g0401420sm.getText().toString());

        json.put("g0401420p", bi.g0401420py.isChecked() ? "1"
                : bi.g0401420pn.isChecked() ? "2"
                : "-1");


        json.put("g0401430a", bi.g0401430ay.isChecked() ? "1"
                : bi.g0401430an.isChecked() ? "2"
                : "-1");

        json.put("g0401430s", bi.g0401430sy.isChecked() ? "1"
                : bi.g0401430sn.isChecked() ? "2"
                : "-1");

        json.put("g0401430sd", bi.g0401430sd.getText().toString());

        json.put("g0401430sm", bi.g0401430sm.getText().toString());

        json.put("g0401430p", bi.g0401430py.isChecked() ? "1"
                : bi.g0401430pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0401440a", bi.g0401440ay.isChecked() ? "1"
                : bi.g0401440an.isChecked() ? "2"
                : "-1");

        json.put("g0401440s", bi.g0401440sy.isChecked() ? "1"
                : bi.g0401440sn.isChecked() ? "2"
                : "-1");

        json.put("g0401440sd", bi.g0401440sd.getText().toString());

        json.put("g0401440sm", bi.g0401440sm.getText().toString());

        json.put("g0401440p", bi.g0401440py.isChecked() ? "1"
                : bi.g0401440pn.isChecked() ? "2"
                : "-1");*/


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
                startActivity(new Intent(this, SectionG421Activity.class));

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
