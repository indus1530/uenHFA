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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG42Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;


public class SectionG42Activity extends AppCompatActivity {

    ActivitySectionG42Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g42);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupSkips();
    }


    private void setupSkips() {

        bi.g040210s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040210sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040210so);
            }
        }));

        bi.g040220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040220so);
            }
        }));

        bi.g040230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040230so);
            }
        }));

        bi.g040240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040240so);
            }
        }));

        bi.g040250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040250so);
            }
        }));

        bi.g040260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040260so);
            }
        }));

        bi.g040270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040270so);
            }
        }));

        bi.g040280s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040280sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040280so);
            }
        }));

        bi.g040290s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040290sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040290so);
            }
        }));

        bi.g0402100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0402100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0402100so);
            }
        }));

        bi.g040310s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040310sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040310so);
            }
        }));

        bi.g040320s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040320sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040320so);
            }
        }));

        bi.g040330s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040330sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040330so);
            }
        }));

        bi.g040340s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040340sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040340so);
            }
        }));

        bi.g040350s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040350sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040350so);
            }
        }));

        bi.g040360s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040360sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040360so);
            }
        }));

        /*bi.g040370s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040370sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040370so );
            }
        }));*/

        /*bi.g040380s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040380sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040380so );
            }
        }));*/

        /*bi.g040390s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040390sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040390so );
            }
        }));*/

        /*bi.g0403100s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403100sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403100so );
            }
        }));*/

        /*bi.g0403110s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403110sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403110so );
            }
        }));*/

        /*bi.g0403120s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403120sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403120so );
            }
        }));*/

        /*bi.g0403130s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403130sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403130so );
            }
        }));*/

        /*bi.g0403140s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403140sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403140so );
            }
        }));*/

       /* bi.g0403150s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403150sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403150so );
            }
        }));*/

        /*bi.g0403160s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403160sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403160so );
            }
        }));*/

        /*bi.g0403170s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403170sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403170so );
            }
        }));*/

        /*bi.g0403180s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403180sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403180so );
            }
        }));*/

        /*bi.g0403190s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403190sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403190so );
            }
        }));*/

        /*bi.g0403200s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403200sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403200so );
            }
        }));*/

        /*bi.g0403210s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403210sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403210so );
            }
        }));*/

        /*bi.g0403220s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403220sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403220so );
            }
        }));*/

        /*bi.g0403230s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403230sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403230so );
            }
        }));*/

        /*bi.g0403240s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403240sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403240so );
            }
        }));*/

        /*bi.g0403250s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403250sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403250so );
            }
        }));*/

        /*bi.g0403260s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403260sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403260so );
            }
        }));*/

        /*bi.g0403270s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g0403270sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg0403270so );
            }
        }));*/

        /*bi.g040410s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040410sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040410so );
            }
        }));*/

        /*bi.g040420s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040420sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040420so );
            }
        }));*/

       /* bi.g040430s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040430sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040430so );
            }
        }));*/

        /*bi.g040440s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040440sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040440so );
            }
        }));*/

        /*bi.g040450s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040450sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040450so );
            }
        }));*/

        /*bi.g040460s.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.g040460sn.getId()) {
                Clear.clearAllFields(bi.fldGrpCVg040460so );
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

        json.put("g040210a", bi.g040210ay.isChecked() ? "1"
                : bi.g040210an.isChecked() ? "2"
                : "-1");

        json.put("g040210s", bi.g040210sy.isChecked() ? "1"
                : bi.g040210sn.isChecked() ? "2"
                : "-1");

        json.put("g040210sd", bi.g040210sd.getText().toString());

        json.put("g040210sm", bi.g040210sm.getText().toString());

        json.put("g040210p", bi.g040210py.isChecked() ? "1"
                : bi.g040210pn.isChecked() ? "2"
                : "-1");

        json.put("g040220a", bi.g040220ay.isChecked() ? "1"
                : bi.g040220an.isChecked() ? "2"
                : "-1");

        json.put("g040220s", bi.g040220sy.isChecked() ? "1"
                : bi.g040220sn.isChecked() ? "2"
                : "-1");

        json.put("g040220sd", bi.g040220sd.getText().toString());

        json.put("g040220sm", bi.g040220sm.getText().toString());

        json.put("g040220p", bi.g040220py.isChecked() ? "1"
                : bi.g040220pn.isChecked() ? "2"
                : "-1");

        json.put("g040230a", bi.g040230ay.isChecked() ? "1"
                : bi.g040230an.isChecked() ? "2"
                : "-1");

        json.put("g040230s", bi.g040230sy.isChecked() ? "1"
                : bi.g040230sn.isChecked() ? "2"
                : "-1");

        json.put("g040230sd", bi.g040230sd.getText().toString());

        json.put("g040230sm", bi.g040230sm.getText().toString());

        json.put("g040230p", bi.g040230py.isChecked() ? "1"
                : bi.g040230pn.isChecked() ? "2"
                : "-1");

        json.put("g040240a", bi.g040240ay.isChecked() ? "1"
                : bi.g040240an.isChecked() ? "2"
                : "-1");

        json.put("g040240s", bi.g040240sy.isChecked() ? "1"
                : bi.g040240sn.isChecked() ? "2"
                : "-1");

        json.put("g040240sd", bi.g040240sd.getText().toString());

        json.put("g040240sm", bi.g040240sm.getText().toString());

        json.put("g040240p", bi.g040240py.isChecked() ? "1"
                : bi.g040240pn.isChecked() ? "2"
                : "-1");

        json.put("g040250a", bi.g040250ay.isChecked() ? "1"
                : bi.g040250an.isChecked() ? "2"
                : "-1");

        json.put("g040250s", bi.g040250sy.isChecked() ? "1"
                : bi.g040250sn.isChecked() ? "2"
                : "-1");

        json.put("g040250sd", bi.g040250sd.getText().toString());

        json.put("g040250sm", bi.g040250sm.getText().toString());

        json.put("g040250p", bi.g040250py.isChecked() ? "1"
                : bi.g040250pn.isChecked() ? "2"
                : "-1");

        json.put("g040260a", bi.g040260ay.isChecked() ? "1"
                : bi.g040260an.isChecked() ? "2"
                : "-1");

        json.put("g040260s", bi.g040260sy.isChecked() ? "1"
                : bi.g040260sn.isChecked() ? "2"
                : "-1");

        json.put("g040260sd", bi.g040260sd.getText().toString());

        json.put("g040260sm", bi.g040260sm.getText().toString());

        json.put("g040260p", bi.g040260py.isChecked() ? "1"
                : bi.g040260pn.isChecked() ? "2"
                : "-1");

        json.put("g040270a", bi.g040270ay.isChecked() ? "1"
                : bi.g040270an.isChecked() ? "2"
                : "-1");

        json.put("g040270s", bi.g040270sy.isChecked() ? "1"
                : bi.g040270sn.isChecked() ? "2"
                : "-1");

        json.put("g040270sd", bi.g040270sd.getText().toString());

        json.put("g040270sm", bi.g040270sm.getText().toString());

        json.put("g040270p", bi.g040270py.isChecked() ? "1"
                : bi.g040270pn.isChecked() ? "2"
                : "-1");

        json.put("g040280a", bi.g040280ay.isChecked() ? "1"
                : bi.g040280an.isChecked() ? "2"
                : "-1");

        json.put("g040280s", bi.g040280sy.isChecked() ? "1"
                : bi.g040280sn.isChecked() ? "2"
                : "-1");

        json.put("g040280sd", bi.g040280sd.getText().toString());

        json.put("g040280sm", bi.g040280sm.getText().toString());

        json.put("g040280p", bi.g040280py.isChecked() ? "1"
                : bi.g040280pn.isChecked() ? "2"
                : "-1");

        json.put("g040290a", bi.g040290ay.isChecked() ? "1"
                : bi.g040290an.isChecked() ? "2"
                : "-1");

        json.put("g040290s", bi.g040290sy.isChecked() ? "1"
                : bi.g040290sn.isChecked() ? "2"
                : "-1");

        json.put("g040290sd", bi.g040290sd.getText().toString());

        json.put("g040290sm", bi.g040290sm.getText().toString());

        json.put("g040290p", bi.g040290py.isChecked() ? "1"
                : bi.g040290pn.isChecked() ? "2"
                : "-1");

        json.put("g0402100a", bi.g0402100ay.isChecked() ? "1"
                : bi.g0402100an.isChecked() ? "2"
                : "-1");

        json.put("g0402100s", bi.g0402100sy.isChecked() ? "1"
                : bi.g0402100sn.isChecked() ? "2"
                : "-1");

        json.put("g0402100sd", bi.g0402100sd.getText().toString());

        json.put("g0402100sm", bi.g0402100sm.getText().toString());

        json.put("g0402100p", bi.g0402100py.isChecked() ? "1"
                : bi.g0402100pn.isChecked() ? "2"
                : "-1");

        json.put("g040310a", bi.g040310ay.isChecked() ? "1"
                : bi.g040310an.isChecked() ? "2"
                : "-1");

        json.put("g040310s", bi.g040310sy.isChecked() ? "1"
                : bi.g040310sn.isChecked() ? "2"
                : "-1");

        json.put("g040310sd", bi.g040310sd.getText().toString());

        json.put("g040310sm", bi.g040310sm.getText().toString());

        json.put("g040310p", bi.g040310py.isChecked() ? "1"
                : bi.g040310pn.isChecked() ? "2"
                : "-1");

        json.put("g040320a", bi.g040320ay.isChecked() ? "1"
                : bi.g040320an.isChecked() ? "2"
                : "-1");

        json.put("g040320s", bi.g040320sy.isChecked() ? "1"
                : bi.g040320sn.isChecked() ? "2"
                : "-1");

        json.put("g040320sd", bi.g040320sd.getText().toString());

        json.put("g040320sm", bi.g040320sm.getText().toString());

        json.put("g040320p", bi.g040320py.isChecked() ? "1"
                : bi.g040320pn.isChecked() ? "2"
                : "-1");

        json.put("g040330a", bi.g040330ay.isChecked() ? "1"
                : bi.g040330an.isChecked() ? "2"
                : "-1");

        json.put("g040330s", bi.g040330sy.isChecked() ? "1"
                : bi.g040330sn.isChecked() ? "2"
                : "-1");

        json.put("g040330sd", bi.g040330sd.getText().toString());

        json.put("g040330sm", bi.g040330sm.getText().toString());

        json.put("g040330p", bi.g040330py.isChecked() ? "1"
                : bi.g040330pn.isChecked() ? "2"
                : "-1");

        json.put("g040340a", bi.g040340ay.isChecked() ? "1"
                : bi.g040340an.isChecked() ? "2"
                : "-1");

        json.put("g040340s", bi.g040340sy.isChecked() ? "1"
                : bi.g040340sn.isChecked() ? "2"
                : "-1");

        json.put("g040340sd", bi.g040340sd.getText().toString());

        json.put("g040340sm", bi.g040340sm.getText().toString());

        json.put("g040340p", bi.g040340py.isChecked() ? "1"
                : bi.g040340pn.isChecked() ? "2"
                : "-1");

        json.put("g040350a", bi.g040350ay.isChecked() ? "1"
                : bi.g040350an.isChecked() ? "2"
                : "-1");

        json.put("g040350s", bi.g040350sy.isChecked() ? "1"
                : bi.g040350sn.isChecked() ? "2"
                : "-1");

        json.put("g040350sd", bi.g040350sd.getText().toString());

        json.put("g040350sm", bi.g040350sm.getText().toString());

        json.put("g040350p", bi.g040350py.isChecked() ? "1"
                : bi.g040350pn.isChecked() ? "2"
                : "-1");

        json.put("g040360a", bi.g040360ay.isChecked() ? "1"
                : bi.g040360an.isChecked() ? "2"
                : "-1");

        json.put("g040360s", bi.g040360sy.isChecked() ? "1"
                : bi.g040360sn.isChecked() ? "2"
                : "-1");

        json.put("g040360sd", bi.g040360sd.getText().toString());

        json.put("g040360sm", bi.g040360sm.getText().toString());

        json.put("g040360p", bi.g040360py.isChecked() ? "1"
                : bi.g040360pn.isChecked() ? "2"
                : "-1");


        /*json.put("g040370a", bi.g040370ay.isChecked() ? "1"
                : bi.g040370an.isChecked() ? "2"
                : "-1");

        json.put("g040370s", bi.g040370sy.isChecked() ? "1"
                : bi.g040370sn.isChecked() ? "2"
                : "-1");

        json.put("g040370sd", bi.g040370sd.getText().toString());

        json.put("g040370sm", bi.g040370sm.getText().toString());

        json.put("g040370p", bi.g040370py.isChecked() ? "1"
                : bi.g040370pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g040380a", bi.g040380ay.isChecked() ? "1"
                : bi.g040380an.isChecked() ? "2"
                : "-1");

        json.put("g040380s", bi.g040380sy.isChecked() ? "1"
                : bi.g040380sn.isChecked() ? "2"
                : "-1");

        json.put("g040380sd", bi.g040380sd.getText().toString());

        json.put("g040380sm", bi.g040380sm.getText().toString());

        json.put("g040380p", bi.g040380py.isChecked() ? "1"
                : bi.g040380pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g040390a", bi.g040390ay.isChecked() ? "1"
                : bi.g040390an.isChecked() ? "2"
                : "-1");

        json.put("g040390s", bi.g040390sy.isChecked() ? "1"
                : bi.g040390sn.isChecked() ? "2"
                : "-1");

        json.put("g040390sd", bi.g040390sd.getText().toString());

        json.put("g040390sm", bi.g040390sm.getText().toString());

        json.put("g040390p", bi.g040390py.isChecked() ? "1"
                : bi.g040390pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0403100a", bi.g0403100ay.isChecked() ? "1"
                : bi.g0403100an.isChecked() ? "2"
                : "-1");

        json.put("g0403100s", bi.g0403100sy.isChecked() ? "1"
                : bi.g0403100sn.isChecked() ? "2"
                : "-1");

        json.put("g0403100sd", bi.g0403100sd.getText().toString());

        json.put("g0403100sm", bi.g0403100sm.getText().toString());

        json.put("g0403100p", bi.g0403100py.isChecked() ? "1"
                : bi.g0403100pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0403110a", bi.g0403110ay.isChecked() ? "1"
                : bi.g0403110an.isChecked() ? "2"
                : "-1");

        json.put("g0403110s", bi.g0403110sy.isChecked() ? "1"
                : bi.g0403110sn.isChecked() ? "2"
                : "-1");

        json.put("g0403110sd", bi.g0403110sd.getText().toString());

        json.put("g0403110sm", bi.g0403110sm.getText().toString());

        json.put("g0403110p", bi.g0403110py.isChecked() ? "1"
                : bi.g0403110pn.isChecked() ? "2"
                : "-1");*/


        /*json.put("g0403120a", bi.g0403120ay.isChecked() ? "1"
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
                : "-1");*/

        /*json.put("g040460a", bi.g040460ay.isChecked() ? "1"
                : bi.g040460an.isChecked() ? "2"
                : "-1");

        json.put("g040460s", bi.g040460sy.isChecked() ? "1"
                : bi.g040460sn.isChecked() ? "2"
                : "-1");

        json.put("g040460sd", bi.g040460sd.getText().toString());

        json.put("g040460sm", bi.g040460sm.getText().toString());

        json.put("g040460p", bi.g040460py.isChecked() ? "1"
                : bi.g040460pn.isChecked() ? "2"
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
