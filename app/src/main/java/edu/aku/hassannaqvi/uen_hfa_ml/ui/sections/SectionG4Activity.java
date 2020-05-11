package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG4Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionG4Activity extends AppCompatActivity {

    ActivitySectionG4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g4);
        bi.setCallback(this);
        setTitle(R.string.modgtitle);
        setupListeners();
    }

    private void setupListeners() {

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

        json.put("g040110a", bi.g040110ay.isChecked() ? "1"
                : bi.g040110an.isChecked() ? "2"
                : "-1");

        json.put("g040110s", bi.g040110sy.isChecked() ? "1"
                : bi.g040110sn.isChecked() ? "2"
                : "-1");

        json.put("g040110sd", bi.g040110sd.getText().toString());

        json.put("g040110sm", bi.g040110sm.getText().toString());

        json.put("g040110p", bi.g040110py.isChecked() ? "1"
                : bi.g040110pn.isChecked() ? "2"
                : "-1");

        json.put("g040120a", bi.g040120ay.isChecked() ? "1"
                : bi.g040120an.isChecked() ? "2"
                : "-1");

        json.put("g040120s", bi.g040120sy.isChecked() ? "1"
                : bi.g040120sn.isChecked() ? "2"
                : "-1");

        json.put("g040120sd", bi.g040120sd.getText().toString());

        json.put("g040120sm", bi.g040120sm.getText().toString());

        json.put("g040120p", bi.g040120py.isChecked() ? "1"
                : bi.g040120pn.isChecked() ? "2"
                : "-1");

        json.put("g04013", bi.g04013a.isChecked() ? "1"
                : bi.g04013b.isChecked() ? "2"
                : "-1");

        json.put("g04010a", bi.g04010ay.isChecked() ? "1"
                : bi.g04010an.isChecked() ? "2"
                : "-1");

        json.put("g04010s", bi.g04010sy.isChecked() ? "1"
                : bi.g04010sn.isChecked() ? "2"
                : "-1");

        json.put("g04010sd", bi.g04010sd.getText().toString());

        json.put("g04010sm", bi.g04010sm.getText().toString());

        json.put("g04010p", bi.g04010py.isChecked() ? "1"
                : bi.g04010pn.isChecked() ? "2"
                : "-1");

        json.put("g040150a", bi.g040150ay.isChecked() ? "1"
                : bi.g040150an.isChecked() ? "2"
                : "-1");

        json.put("g040150s", bi.g040150sy.isChecked() ? "1"
                : bi.g040150sn.isChecked() ? "2"
                : "-1");

        json.put("g040150sd", bi.g040150sd.getText().toString());

        json.put("g040150sm", bi.g040150sm.getText().toString());

        json.put("g040150p", "-1");

        json.put("g040150py", "-1");

        json.put("g040150pn", "-1");

        json.put("g040160a", bi.g040160ay.isChecked() ? "1"
                : bi.g040160an.isChecked() ? "2"
                : "-1");

        json.put("g040160s", bi.g040160sy.isChecked() ? "1"
                : bi.g040160sn.isChecked() ? "2"
                : "-1");

        json.put("g040160sd", bi.g040160sd.getText().toString());

        json.put("g040160sm", bi.g040160sm.getText().toString());

        json.put("g040160p", bi.g040160py.isChecked() ? "1"
                : bi.g040160pn.isChecked() ? "2"
                : "-1");

        json.put("g040170a", bi.g040170ay.isChecked() ? "1"
                : bi.g040170an.isChecked() ? "2"
                : "-1");

        json.put("g040170s", bi.g040170sy.isChecked() ? "1"
                : bi.g040170sn.isChecked() ? "2"
                : "-1");

        json.put("g040170sd", bi.g040170sd.getText().toString());

        json.put("g040170sm", bi.g040170sm.getText().toString());

        json.put("g040170p", bi.g040170py.isChecked() ? "1"
                : bi.g040170pn.isChecked() ? "2"
                : "-1");

        json.put("g040180a", bi.g040180ay.isChecked() ? "1"
                : bi.g040180an.isChecked() ? "2"
                : "-1");

        json.put("g040180s", bi.g040180sy.isChecked() ? "1"
                : bi.g040180sn.isChecked() ? "2"
                : "-1");

        json.put("g040180sd", bi.g040180sd.getText().toString());

        json.put("g040180sm", bi.g040180sm.getText().toString());

        json.put("g040180p", bi.g040180py.isChecked() ? "1"
                : bi.g040180pn.isChecked() ? "2"
                : "-1");

        json.put("g040190a", bi.g040190ay.isChecked() ? "1"
                : bi.g040190an.isChecked() ? "2"
                : "-1");

        json.put("g040190s", bi.g040190sy.isChecked() ? "1"
                : bi.g040190sn.isChecked() ? "2"
                : "-1");

        json.put("g040190sd", bi.g040190sd.getText().toString());

        json.put("g040190sm", bi.g040190sm.getText().toString());

        json.put("g040190p", bi.g040190py.isChecked() ? "1"
                : bi.g040190pn.isChecked() ? "2"
                : "-1");

        json.put("g0401100a", bi.g0401100ay.isChecked() ? "1"
                : bi.g0401100an.isChecked() ? "2"
                : "-1");

        json.put("g0401100s", bi.g0401100sy.isChecked() ? "1"
                : bi.g0401100sn.isChecked() ? "2"
                : "-1");

        json.put("g0401100sd", bi.g0401100sd.getText().toString());

        json.put("g0401100sm", bi.g0401100sm.getText().toString());

        json.put("g0401100p", bi.g0401100py.isChecked() ? "1"
                : bi.g0401100pn.isChecked() ? "2"
                : "-1");

        json.put("g0401110a", bi.g0401110ay.isChecked() ? "1"
                : bi.g0401110an.isChecked() ? "2"
                : "-1");

        json.put("g0401110s", bi.g0401110sy.isChecked() ? "1"
                : bi.g0401110sn.isChecked() ? "2"
                : "-1");

        json.put("g0401110sd", bi.g0401110sd.getText().toString());

        json.put("g0401110sm", bi.g0401110sm.getText().toString());

        json.put("g0401110p", bi.g0401110py.isChecked() ? "1"
                : bi.g0401110pn.isChecked() ? "2"
                : "-1");

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

        json.put("g0401300a", bi.g0401300ay.isChecked() ? "1"
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
                : "-1");

        json.put("g0401400a", bi.g0401400ay.isChecked() ? "1"
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
                : "-1");

        json.put("g0401440a", bi.g0401440ay.isChecked() ? "1"
                : bi.g0401440an.isChecked() ? "2"
                : "-1");

        json.put("g0401440s", bi.g0401440sy.isChecked() ? "1"
                : bi.g0401440sn.isChecked() ? "2"
                : "-1");

        json.put("g0401440sd", bi.g0401440sd.getText().toString());

        json.put("g0401440sm", bi.g0401440sm.getText().toString());

        json.put("g0401440p", bi.g0401440py.isChecked() ? "1"
                : bi.g0401440pn.isChecked() ? "2"
                : "-1");

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

        json.put("g040370a", bi.g040370ay.isChecked() ? "1"
                : bi.g040370an.isChecked() ? "2"
                : "-1");

        json.put("g040370s", bi.g040370sy.isChecked() ? "1"
                : bi.g040370sn.isChecked() ? "2"
                : "-1");

        json.put("g040370sd", bi.g040370sd.getText().toString());

        json.put("g040370sm", bi.g040370sm.getText().toString());

        json.put("g040370p", bi.g040370py.isChecked() ? "1"
                : bi.g040370pn.isChecked() ? "2"
                : "-1");

        json.put("g040380a", bi.g040380ay.isChecked() ? "1"
                : bi.g040380an.isChecked() ? "2"
                : "-1");

        json.put("g040380s", bi.g040380sy.isChecked() ? "1"
                : bi.g040380sn.isChecked() ? "2"
                : "-1");

        json.put("g040380sd", bi.g040380sd.getText().toString());

        json.put("g040380sm", bi.g040380sm.getText().toString());

        json.put("g040380p", bi.g040380py.isChecked() ? "1"
                : bi.g040380pn.isChecked() ? "2"
                : "-1");

        json.put("g040390a", bi.g040390ay.isChecked() ? "1"
                : bi.g040390an.isChecked() ? "2"
                : "-1");

        json.put("g040390s", bi.g040390sy.isChecked() ? "1"
                : bi.g040390sn.isChecked() ? "2"
                : "-1");

        json.put("g040390sd", bi.g040390sd.getText().toString());

        json.put("g040390sm", bi.g040390sm.getText().toString());

        json.put("g040390p", bi.g040390py.isChecked() ? "1"
                : bi.g040390pn.isChecked() ? "2"
                : "-1");

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

       /* try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(child.getsCC()), json);

            child.setsCC(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
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
        openEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
