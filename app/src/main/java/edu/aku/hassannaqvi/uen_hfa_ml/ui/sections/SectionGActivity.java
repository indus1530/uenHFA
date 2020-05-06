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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionGBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionGActivity extends AppCompatActivity {

    ActivitySectionGBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g);
        bi.setCallback(this);
        setTitle(R.string.sectiongtitle);
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

        json.put("g11", bi.g11b.isChecked() ? "2"
                : bi.g11c.isChecked() ? "3"
                : bi.g11d.isChecked() ? "4"
                : bi.g11e.isChecked() ? "5"
                : bi.g11f.isChecked() ? "6"
                : bi.g11x.isChecked() ? "96"
                : "0");
        json.put("g11xx", bi.g11xx.getText().toString());

        json.put("g11a", "0");

        json.put("g12", "0");

        json.put("g12a",
                bi.g12aa.isChecked() ? "1" :
                        bi.g12ab.isChecked() ? "2" :
                                "0");
        json.put("g12b",
                bi.g12ba.isChecked() ? "1" :
                        bi.g12bb.isChecked() ? "2" :
                                "0");
        json.put("g13",
                bi.g13a.isChecked() ? "1" :
                        bi.g13b.isChecked() ? "98" :
                                bi.g13x.isChecked() ? "96" :
                                        "0");
        json.put("g14",
                bi.g14a.isChecked() ? "1" :
                        bi.g14b.isChecked() ? "2" :
                                bi.g14c.isChecked() ? "3" :
                                        bi.g14d.isChecked() ? "4" :
                                                bi.g14e.isChecked() ? "5" :
                                                        bi.g14f.isChecked() ? "6" :
                                                                bi.g14g.isChecked() ? "7" :
                                                                        "0");
        json.put("g15",
                bi.g15a.isChecked() ? "1" :
                        bi.g15b.isChecked() ? "2" :
                                bi.g15c.isChecked() ? "3" :
                                        "0");
        json.put("g15ax", bi.g15ax.getText().toString());
        json.put("g15bx", bi.g15bx.getText().toString());
        json.put("g15cx", bi.g15cx.getText().toString());
        json.put("g16",
                bi.g16a.isChecked() ? "1" :
                        bi.g16b.isChecked() ? "2" :
                                bi.g16c.isChecked() ? "3" :
                                        bi.g16d.isChecked() ? "4" :
                                                bi.g16x.isChecked() ? "96" :
                                                        "0");
        json.put("g16xx", bi.g16xx.getText().toString());
        json.put("g17",
                bi.g17a.isChecked() ? "1" :
                        bi.g17b.isChecked() ? "2" :
                                bi.g17c.isChecked() ? "3" :
                                        bi.g17x.isChecked() ? "96" :
                                                "0");
        json.put("g17xx", bi.g17xx.getText().toString());
        json.put("g18",
                bi.g18aa.isChecked() ? "1" :
                        bi.g18ab.isChecked() ? "2" :
                                "0");
        json.put("g18a",
                "0");
        json.put("g18b",
                bi.g18ba.isChecked() ? "1" :
                        bi.g18bb.isChecked() ? "2" :
                                "0");
        json.put("g18c",
                bi.g18ca.isChecked() ? "1" :
                        bi.g18cb.isChecked() ? "2" :
                                "0");
        json.put("g19",
                bi.g19a.isChecked() ? "1" :
                        bi.g19b.isChecked() ? "2" :
                                bi.g19c.isChecked() ? "3" :
                                        bi.g19d.isChecked() ? "4" :
                                                "0");
        json.put("g110",
                bi.g110a.isChecked() ? "1" :
                        bi.g110b.isChecked() ? "2" :
                                bi.g110c.isChecked() ? "3" :
                                        "0");
        json.put("g110ax", bi.g110ax.getText().toString());
        json.put("g110bx", bi.g110bx.getText().toString());
        json.put("g110cx", bi.g110cx.getText().toString());
        json.put("g111",
                bi.g111a.isChecked() ? "1" :
                        bi.g111b.isChecked() ? "2" :
                                "0");
        json.put("g112",
                bi.g112a.isChecked() ? "1" :
                        bi.g112b.isChecked() ? "2" :
                                bi.g112x.isChecked() ? "96" :
                                        "0");
        json.put("g112xx", bi.g112xx.getText().toString());
        json.put("g113",
                bi.g113a.isChecked() ? "1" :
                        bi.g113b.isChecked() ? "2" :
                                "0");
        json.put("g114",
                bi.g114a.isChecked() ? "1" :
                        bi.g114b.isChecked() ? "2" :
                                bi.g114c.isChecked() ? "3" :
                                        "0");
        json.put("g115",
                bi.g115a.isChecked() ? "1" :
                        bi.g115b.isChecked() ? "2" :
                                bi.g115c.isChecked() ? "3" :
                                        "0");
        json.put("g116",
                bi.g116a.isChecked() ? "1" :
                        bi.g116b.isChecked() ? "2" :
                                "0");
        json.put("g117",
                bi.g117a.isChecked() ? "1" :
                        bi.g117b.isChecked() ? "2" :
                                bi.g117c.isChecked() ? "3" :
                                        bi.g117d.isChecked() ? "4" :
                                                bi.g117e.isChecked() ? "5" :
                                                        "0");
        json.put("g21",
                bi.g21a.isChecked() ? "1" :
                        bi.g21b.isChecked() ? "2" :
                                bi.g21c.isChecked() ? "3" :
                                        "0");
        json.put("g22",
                bi.g22a.isChecked() ? "1" :
                        bi.g22b.isChecked() ? "2" :
                                bi.g22c.isChecked() ? "3" :
                                        "0");
        json.put("g23",
                bi.g23a.isChecked() ? "1" :
                        bi.g23b.isChecked() ? "2" :
                                bi.g23c.isChecked() ? "3" :
                                        "0");
        json.put("g24",
                bi.g24a.isChecked() ? "1" :
                        bi.g24b.isChecked() ? "2" :
                                bi.g24c.isChecked() ? "3" :
                                        "0");
        json.put("g25",
                bi.g25a.isChecked() ? "1" :
                        bi.g25b.isChecked() ? "2" :
                                "0");
        json.put("g26",
                bi.g26a.isChecked() ? "1" :
                        bi.g26b.isChecked() ? "2" :
                                "0");
        json.put("g27",
                bi.g27a.isChecked() ? "1" :
                        bi.g27b.isChecked() ? "2" :
                                bi.g27c.isChecked() ? "3" :
                                        "0");
        json.put("g28",
                bi.g28a.isChecked() ? "1" :
                        bi.g28b.isChecked() ? "2" :
                                bi.g28c.isChecked() ? "3" :
                                        bi.g28d.isChecked() ? "4" :
                                                bi.g28e.isChecked() ? "5" :
                                                        "0");

        json.put("g31",
                "0");

        //json.put("g31a", bi.g31a.getText().toString());

        json.put("g31aa", bi.g31aa.getText().toString());
        json.put("g31ab", bi.g31ab.getText().toString());

        //json.put("g31b", bi.g31b.getText().toString());

        json.put("g31ba", bi.g31ba.getText().toString());
        json.put("g31bb", bi.g31bb.getText().toString());

        // json.put("g31c", bi.g31c.getText().toString());

        json.put("g31ca", bi.g31ca.getText().toString());
        json.put("g31cb", bi.g31cb.getText().toString());

        json.put("g32",
                "0");

        //json.put("g32a", bi.g32a.getText().toString());

        json.put("g32a10r", bi.g32a10r.getText().toString());
        json.put("g32a10i", bi.g32a10i.getText().toString());
        json.put("g32a10d", bi.g32a10d.getText().toString());
        json.put("g32a10b", bi.g32a10b.getText().toString());
        json.put("g32a20r", bi.g32a20r.getText().toString());
        json.put("g32a20i", bi.g32a20i.getText().toString());
        json.put("g32a20d", bi.g32a20d.getText().toString());
        json.put("g32a20b", bi.g32a20b.getText().toString());
        json.put("g32a30r", bi.g32a30r.getText().toString());
        json.put("g32a30i", bi.g32a30i.getText().toString());
        json.put("g32a30d", bi.g32a30d.getText().toString());
        json.put("g32a30b", bi.g32a30b.getText().toString());
        json.put("g32a40r", bi.g32a40r.getText().toString());
        json.put("g32a40i", bi.g32a40i.getText().toString());
        json.put("g32a40d", bi.g32a40d.getText().toString());
        json.put("g32a40b", bi.g32a40b.getText().toString());
        json.put("g32a50r", bi.g32a50r.getText().toString());
        json.put("g32a50i", bi.g32a50i.getText().toString());
        json.put("g32a50d", bi.g32a50d.getText().toString());
        json.put("g32a50b", bi.g32a50b.getText().toString());
        json.put("g32a60r", bi.g32a60r.getText().toString());
        json.put("g32a60i", bi.g32a60i.getText().toString());
        json.put("g32a60d", bi.g32a60d.getText().toString());
        json.put("g32a60b", bi.g32a60b.getText().toString());
        json.put("g32a70r", bi.g32a70r.getText().toString());
        json.put("g32a70i", bi.g32a70i.getText().toString());
        json.put("g32a70d", bi.g32a70d.getText().toString());
        json.put("g32a70b", bi.g32a70b.getText().toString());

//        json.put("g32b", bi.g32b.getText().toString());
        json.put("g32b10r", bi.g32b10r.getText().toString());
        json.put("g32b10i", bi.g32b10i.getText().toString());
        json.put("g32b10d", bi.g32b10d.getText().toString());
        json.put("g32b10b", bi.g32b10b.getText().toString());
        json.put("g32b20r", bi.g32b20r.getText().toString());
        json.put("g32b20i", bi.g32b20i.getText().toString());
        json.put("g32b20d", bi.g32b20d.getText().toString());
        json.put("g32b20b", bi.g32b20b.getText().toString());
        json.put("g32b30r", bi.g32b30r.getText().toString());
        json.put("g32b30i", bi.g32b30i.getText().toString());
        json.put("g32b30d", bi.g32b30d.getText().toString());
        json.put("g32b30b", bi.g32b30b.getText().toString());
        json.put("g32b40r", bi.g32b40r.getText().toString());
        json.put("g32b40i", bi.g32b40i.getText().toString());
        json.put("g32b40d", bi.g32b40d.getText().toString());
        json.put("g32b40b", bi.g32b40b.getText().toString());
        json.put("g32b50r", bi.g32b50r.getText().toString());
        json.put("g32b50i", bi.g32b50i.getText().toString());
        json.put("g32b50d", bi.g32b50d.getText().toString());
        json.put("g32b50b", bi.g32b50b.getText().toString());
        json.put("g32b60r", bi.g32b60r.getText().toString());
        json.put("g32b60i", bi.g32b60i.getText().toString());
        json.put("g32b60d", bi.g32b60d.getText().toString());
        json.put("g32b60b", bi.g32b60b.getText().toString());
        json.put("g32b70r", bi.g32b70r.getText().toString());
        json.put("g32b70i", bi.g32b70i.getText().toString());
        json.put("g32b70d", bi.g32b70d.getText().toString());
        json.put("g32b70b", bi.g32b70b.getText().toString());
//        json.put("g32c", bi.g32c.getText().toString());
        json.put("g32c10r", bi.g32c10r.getText().toString());
        json.put("g32c10i", bi.g32c10i.getText().toString());
        json.put("g32c10d", bi.g32c10d.getText().toString());
        json.put("g32c10b", bi.g32c10b.getText().toString());
        json.put("g32c20r", bi.g32c20r.getText().toString());
        json.put("g32c20i", bi.g32c20i.getText().toString());
        json.put("g32c20d", bi.g32c20d.getText().toString());
        json.put("g32c20b", bi.g32c20b.getText().toString());
        json.put("g32c30r", bi.g32c30r.getText().toString());
        json.put("g32c30i", bi.g32c30i.getText().toString());
        json.put("g32c30d", bi.g32c30d.getText().toString());
        json.put("g32c30b", bi.g32c30b.getText().toString());
        json.put("g32c40r", bi.g32c40r.getText().toString());
        json.put("g32c40i", bi.g32c40i.getText().toString());
        json.put("g32c40d", bi.g32c40d.getText().toString());
        json.put("g32c40b", bi.g32c40b.getText().toString());
        json.put("g32c50r", bi.g32c50r.getText().toString());
        json.put("g32c50i", bi.g32c50i.getText().toString());
        json.put("g32c50d", bi.g32c50d.getText().toString());
        json.put("g32c50b", bi.g32c50b.getText().toString());
        json.put("g32c60r", bi.g32c60r.getText().toString());
        json.put("g32c60i", bi.g32c60i.getText().toString());
        json.put("g32c60d", bi.g32c60d.getText().toString());
        json.put("g32c60b", bi.g32c60b.getText().toString());
        json.put("g32c70r", bi.g32c70r.getText().toString());
        json.put("g32c70i", bi.g32c70i.getText().toString());
        json.put("g32c70d", bi.g32c70d.getText().toString());
        json.put("g32c70b", bi.g32c70b.getText().toString());

        json.put("g4110a",
                bi.g4110ay.isChecked() ? "1" :
                        bi.g4110an.isChecked() ? "2" :
                                "0");

        json.put("g4110s",
                bi.g4110sy.isChecked() ? "1" :
                        bi.g4110sn.isChecked() ? "2" :
                                "0");
        json.put("g4110so",
                bi.g4110sd.isChecked() ? "1" :
                        bi.g4110sm.isChecked() ? "2" :
                                "0");
        json.put("g4110sdx", bi.g4110sdx.getText().toString());
        json.put("g4110smx", bi.g4110smx.getText().toString());
        json.put("g4110p",
                bi.g4110py.isChecked() ? "1" :
                        bi.g4110pn.isChecked() ? "2" :
                                "0");
        json.put("g4120a",
                bi.g4120ay.isChecked() ? "1" :
                        bi.g4120an.isChecked() ? "2" :
                                "0");
        json.put("g4120s",
                bi.g4120sy.isChecked() ? "1" :
                        bi.g4120sn.isChecked() ? "2" :
                                "0");
        json.put("g4120so",
                bi.g4120sd.isChecked() ? "1" :
                        bi.g4120sm.isChecked() ? "2" :
                                "0");
        json.put("g4120sdx", bi.g4120sdx.getText().toString());
        json.put("g4120smx", bi.g4120smx.getText().toString());
        json.put("g4120p",
                bi.g4120py.isChecked() ? "1" :
                        bi.g4120pn.isChecked() ? "2" :
                                "0");
        json.put("g413",
                bi.g413a.isChecked() ? "1" :
                        bi.g413b.isChecked() ? "2" :
                                "0");
        json.put("g4140a",
                bi.g4140ay.isChecked() ? "1" :
                        bi.g4140an.isChecked() ? "2" :
                                "0");
        json.put("g4140s",
                bi.g4140sy.isChecked() ? "1" :
                        bi.g4140sn.isChecked() ? "2" :
                                "0");
        json.put("g4140so",
                bi.g4140sd.isChecked() ? "1" :
                        bi.g4140sm.isChecked() ? "2" :
                                "0");
        json.put("g4140sdx", bi.g4140sdx.getText().toString());
        json.put("g4140smx", bi.g4140smx.getText().toString());
        json.put("g4140p",
                bi.g4140py.isChecked() ? "1" :
                        bi.g4140pn.isChecked() ? "2" :
                                "0");
        json.put("g4150a",
                bi.g4150ay.isChecked() ? "1" :
                        bi.g4150an.isChecked() ? "2" :
                                "0");
        json.put("g4150s",
                bi.g4150sy.isChecked() ? "1" :
                        bi.g4150sn.isChecked() ? "2" :
                                "0");
        json.put("g4150so",
                bi.g4150sd.isChecked() ? "1" :
                        bi.g4150sm.isChecked() ? "2" :
                                "0");
        json.put("g4150sdx", bi.g4150sdx.getText().toString());
        json.put("g4150smx", bi.g4150smx.getText().toString());
        json.put("g4150p",
                bi.g4150py.isChecked() ? "1" :
                        bi.g4150pn.isChecked() ? "2" :
                                "0");
        json.put("g4160a",
                bi.g4160ay.isChecked() ? "1" :
                        bi.g4160an.isChecked() ? "2" :
                                "0");
        json.put("g4160s",
                bi.g4160sy.isChecked() ? "1" :
                        bi.g4160sn.isChecked() ? "2" :
                                "0");
        json.put("g4160so",
                bi.g4160sd.isChecked() ? "1" :
                        bi.g4160sm.isChecked() ? "2" :
                                "0");
        json.put("g4160sdx", bi.g4160sdx.getText().toString());
        json.put("g4160smx", bi.g4160smx.getText().toString());
        json.put("g4160p",
                bi.g4160py.isChecked() ? "1" :
                        bi.g4160pn.isChecked() ? "2" :
                                "0");
        json.put("g4170a",
                bi.g4170ay.isChecked() ? "1" :
                        bi.g4170an.isChecked() ? "2" :
                                "0");
        json.put("g4170s",
                bi.g4170sy.isChecked() ? "1" :
                        bi.g4170sn.isChecked() ? "2" :
                                "0");
        json.put("g4170so",
                bi.g4170sd.isChecked() ? "1" :
                        bi.g4170sm.isChecked() ? "2" :
                                "0");
        json.put("g4170sdx", bi.g4170sdx.getText().toString());
        json.put("g4170smx", bi.g4170smx.getText().toString());
        json.put("g4170p",
                bi.g4170py.isChecked() ? "1" :
                        bi.g4170pn.isChecked() ? "2" :
                                "0");
        json.put("g4180a",
                bi.g4180ay.isChecked() ? "1" :
                        bi.g4180an.isChecked() ? "2" :
                                "0");
        json.put("g4180s",
                bi.g4180sy.isChecked() ? "1" :
                        bi.g4180sn.isChecked() ? "2" :
                                "0");
        json.put("g4180so",
                bi.g4180sd.isChecked() ? "1" :
                        bi.g4180sm.isChecked() ? "2" :
                                "0");
        json.put("g4180sdx", bi.g4180sdx.getText().toString());
        json.put("g4180smx", bi.g4180smx.getText().toString());
        json.put("g4180p",
                bi.g4180py.isChecked() ? "1" :
                        bi.g4180pn.isChecked() ? "2" :
                                "0");
        json.put("g4190a",
                bi.g4190ay.isChecked() ? "1" :
                        bi.g4190an.isChecked() ? "2" :
                                "0");
        json.put("g4190s",
                bi.g4190sy.isChecked() ? "1" :
                        bi.g4190sn.isChecked() ? "2" :
                                "0");
        json.put("g4190so",
                bi.g4190sd.isChecked() ? "1" :
                        bi.g4190sm.isChecked() ? "2" :
                                "0");
        json.put("g4190sdx", bi.g4190sdx.getText().toString());
        json.put("g4190smx", bi.g4190smx.getText().toString());
        json.put("g4190p",
                bi.g4190py.isChecked() ? "1" :
                        bi.g4190pn.isChecked() ? "2" :
                                "0");
        json.put("g41100a",
                bi.g41100ay.isChecked() ? "1" :
                        bi.g41100an.isChecked() ? "2" :
                                "0");
        json.put("g41100s",
                bi.g41100sy.isChecked() ? "1" :
                        bi.g41100sn.isChecked() ? "2" :
                                "0");
        json.put("g41100so",
                bi.g41100sd.isChecked() ? "1" :
                        bi.g41100sm.isChecked() ? "2" :
                                "0");
        json.put("g41100sdx", bi.g41100sdx.getText().toString());
        json.put("g41100smx", bi.g41100smx.getText().toString());
        json.put("g41100p",
                bi.g41100py.isChecked() ? "1" :
                        bi.g41100pn.isChecked() ? "2" :
                                "0");
        json.put("g41110a",
                bi.g41110ay.isChecked() ? "1" :
                        bi.g41110an.isChecked() ? "2" :
                                "0");
        json.put("g41110s",
                bi.g41110sy.isChecked() ? "1" :
                        bi.g41110sn.isChecked() ? "2" :
                                "0");
        json.put("g41110so",
                bi.g41110sd.isChecked() ? "1" :
                        bi.g41110sm.isChecked() ? "2" :
                                "0");
        json.put("g41110sdx", bi.g41110sdx.getText().toString());
        json.put("g41110smx", bi.g41110smx.getText().toString());
        json.put("g41110p",
                bi.g41110py.isChecked() ? "1" :
                        bi.g41110pn.isChecked() ? "2" :
                                "0");
        json.put("g41120a",
                bi.g41120ay.isChecked() ? "1" :
                        bi.g41120an.isChecked() ? "2" :
                                "0");
        json.put("g41120s",
                bi.g41120sy.isChecked() ? "1" :
                        bi.g41120sn.isChecked() ? "2" :
                                "0");
        json.put("g41120so",
                bi.g41120sd.isChecked() ? "1" :
                        bi.g41120sm.isChecked() ? "2" :
                                "0");
        json.put("g41120sdx", bi.g41120sdx.getText().toString());
        json.put("g41120smx", bi.g41120smx.getText().toString());
        json.put("g41120p",
                bi.g41120py.isChecked() ? "1" :
                        bi.g41120pn.isChecked() ? "2" :
                                "0");
        json.put("g41130a",
                bi.g41130ay.isChecked() ? "1" :
                        bi.g41130an.isChecked() ? "2" :
                                "0");
        json.put("g41130s",
                bi.g41130sy.isChecked() ? "1" :
                        bi.g41130sn.isChecked() ? "2" :
                                "0");
        json.put("g41130so",
                bi.g41130sd.isChecked() ? "1" :
                        bi.g41130sm.isChecked() ? "2" :
                                "0");
        json.put("g41130sdx", bi.g41130sdx.getText().toString());
        json.put("g41130smx", bi.g41130smx.getText().toString());
        json.put("g41130p",
                bi.g41130py.isChecked() ? "1" :
                        bi.g41130pn.isChecked() ? "2" :
                                "0");
        json.put("g41140a",
                bi.g41140ay.isChecked() ? "1" :
                        bi.g41140an.isChecked() ? "2" :
                                "0");
        json.put("g41140s",
                bi.g41140sy.isChecked() ? "1" :
                        bi.g41140sn.isChecked() ? "2" :
                                "0");
        json.put("g41140so",
                bi.g41140sd.isChecked() ? "1" :
                        bi.g41140sm.isChecked() ? "2" :
                                "0");
        json.put("g41140sdx", bi.g41140sdx.getText().toString());
        json.put("g41140smx", bi.g41140smx.getText().toString());
        json.put("g41140p",
                bi.g41140py.isChecked() ? "1" :
                        bi.g41140pn.isChecked() ? "2" :
                                "0");
        json.put("g41150a",
                bi.g41150ay.isChecked() ? "1" :
                        bi.g41150an.isChecked() ? "2" :
                                "0");
        json.put("g41150s",
                bi.g41150sy.isChecked() ? "1" :
                        bi.g41150sn.isChecked() ? "2" :
                                "0");
        json.put("g41150so",
                bi.g41150sd.isChecked() ? "1" :
                        bi.g41150sm.isChecked() ? "2" :
                                "0");
        json.put("g41150sdx", bi.g41150sdx.getText().toString());
        json.put("g41150smx", bi.g41150smx.getText().toString());
        json.put("g41150p",
                bi.g41150py.isChecked() ? "1" :
                        bi.g41150pn.isChecked() ? "2" :
                                "0");
        json.put("g41160a",
                bi.g41160ay.isChecked() ? "1" :
                        bi.g41160an.isChecked() ? "2" :
                                "0");
        json.put("g41160s",
                bi.g41160sy.isChecked() ? "1" :
                        bi.g41160sn.isChecked() ? "2" :
                                "0");
        json.put("g41160so",
                bi.g41160sd.isChecked() ? "1" :
                        bi.g41160sm.isChecked() ? "2" :
                                "0");
        json.put("g41160sdx", bi.g41160sdx.getText().toString());
        json.put("g41160smx", bi.g41160smx.getText().toString());
        json.put("g41160p",
                bi.g41160py.isChecked() ? "1" :
                        bi.g41160pn.isChecked() ? "2" :
                                "0");
        json.put("g41170a",
                bi.g41170ay.isChecked() ? "1" :
                        bi.g41170an.isChecked() ? "2" :
                                "0");
        json.put("g41170s",
                bi.g41170sy.isChecked() ? "1" :
                        bi.g41170sn.isChecked() ? "2" :
                                "0");
        json.put("g41170so",
                bi.g41170sd.isChecked() ? "1" :
                        bi.g41170sm.isChecked() ? "2" :
                                "0");
        json.put("g41170sdx", bi.g41170sdx.getText().toString());
        json.put("g41170smx", bi.g41170smx.getText().toString());
        json.put("g41170p",
                bi.g41170py.isChecked() ? "1" :
                        bi.g41170pn.isChecked() ? "2" :
                                "0");
        json.put("g41180a",
                bi.g41180ay.isChecked() ? "1" :
                        bi.g41180an.isChecked() ? "2" :
                                "0");
        json.put("g41180s",
                bi.g41180sy.isChecked() ? "1" :
                        bi.g41180sn.isChecked() ? "2" :
                                "0");
        json.put("g41180so",
                bi.g41180sd.isChecked() ? "1" :
                        bi.g41180sm.isChecked() ? "2" :
                                "0");
        json.put("g41180sdx", bi.g41180sdx.getText().toString());
        json.put("g41180smx", bi.g41180smx.getText().toString());
        json.put("g41180p",
                bi.g41180py.isChecked() ? "1" :
                        bi.g41180pn.isChecked() ? "2" :
                                "0");
        json.put("g41190a",
                bi.g41190ay.isChecked() ? "1" :
                        bi.g41190an.isChecked() ? "2" :
                                "0");
        json.put("g41190s",
                bi.g41190sy.isChecked() ? "1" :
                        bi.g41190sn.isChecked() ? "2" :
                                "0");
        json.put("g41190so",
                bi.g41190sd.isChecked() ? "1" :
                        bi.g41190sm.isChecked() ? "2" :
                                "0");
        json.put("g41190sdx", bi.g41190sdx.getText().toString());
        json.put("g41190smx", bi.g41190smx.getText().toString());
        json.put("g41190p",
                bi.g41190py.isChecked() ? "1" :
                        bi.g41190pn.isChecked() ? "2" :
                                "0");
        json.put("g41200a",
                bi.g41200ay.isChecked() ? "1" :
                        bi.g41200an.isChecked() ? "2" :
                                "0");
        json.put("g41200s",
                bi.g41200sy.isChecked() ? "1" :
                        bi.g41200sn.isChecked() ? "2" :
                                "0");
        json.put("g41200so",
                bi.g41200sd.isChecked() ? "1" :
                        bi.g41200sm.isChecked() ? "2" :
                                "0");
        json.put("g41200sdx", bi.g41200sdx.getText().toString());
        json.put("g41200smx", bi.g41200smx.getText().toString());
        json.put("g41200p",
                bi.g41200py.isChecked() ? "1" :
                        bi.g41200pn.isChecked() ? "2" :
                                "0");
        json.put("g41210a",
                bi.g41210ay.isChecked() ? "1" :
                        bi.g41210an.isChecked() ? "2" :
                                "0");
        json.put("g41210s",
                bi.g41210sy.isChecked() ? "1" :
                        bi.g41210sn.isChecked() ? "2" :
                                "0");
        json.put("g41210so",
                bi.g41210sd.isChecked() ? "1" :
                        bi.g41210sm.isChecked() ? "2" :
                                "0");
        json.put("g41210sdx", bi.g41210sdx.getText().toString());
        json.put("g41210smx", bi.g41210smx.getText().toString());
        json.put("g41210p",
                bi.g41210py.isChecked() ? "1" :
                        bi.g41210pn.isChecked() ? "2" :
                                "0");
        json.put("g41220a",
                bi.g41220ay.isChecked() ? "1" :
                        bi.g41220an.isChecked() ? "2" :
                                "0");
        json.put("g41220s",
                bi.g41220sy.isChecked() ? "1" :
                        bi.g41220sn.isChecked() ? "2" :
                                "0");
        json.put("g41220so",
                bi.g41220sd.isChecked() ? "1" :
                        bi.g41220sm.isChecked() ? "2" :
                                "0");
        json.put("g41220sdx", bi.g41220sdx.getText().toString());
        json.put("g41220smx", bi.g41220smx.getText().toString());
        json.put("g41220p",
                bi.g41220py.isChecked() ? "1" :
                        bi.g41220pn.isChecked() ? "2" :
                                "0");
        json.put("g41230a",
                bi.g41230ay.isChecked() ? "1" :
                        bi.g41230an.isChecked() ? "2" :
                                "0");
        json.put("g41230s",
                bi.g41230sy.isChecked() ? "1" :
                        bi.g41230sn.isChecked() ? "2" :
                                "0");
        json.put("g41230so",
                bi.g41230sd.isChecked() ? "1" :
                        bi.g41230sm.isChecked() ? "2" :
                                "0");
        json.put("g41230sdx", bi.g41230sdx.getText().toString());
        json.put("g41230smx", bi.g41230smx.getText().toString());
        json.put("g41230p",
                bi.g41230py.isChecked() ? "1" :
                        bi.g41230pn.isChecked() ? "2" :
                                "0");
        json.put("g41240a",
                bi.g41240ay.isChecked() ? "1" :
                        bi.g41240an.isChecked() ? "2" :
                                "0");
        json.put("g41240s",
                bi.g41240sy.isChecked() ? "1" :
                        bi.g41240sn.isChecked() ? "2" :
                                "0");
        json.put("g41240so",
                bi.g41240sd.isChecked() ? "1" :
                        bi.g41240sm.isChecked() ? "2" :
                                "0");
        json.put("g41240sdx", bi.g41240sdx.getText().toString());
        json.put("g41240smx", bi.g41240smx.getText().toString());
        json.put("g41240p",
                bi.g41240py.isChecked() ? "1" :
                        bi.g41240pn.isChecked() ? "2" :
                                "0");
        json.put("g41250a",
                bi.g41250ay.isChecked() ? "1" :
                        bi.g41250an.isChecked() ? "2" :
                                "0");
        json.put("g41250s",
                bi.g41250sy.isChecked() ? "1" :
                        bi.g41250sn.isChecked() ? "2" :
                                "0");
        json.put("g41250so",
                bi.g41250sd.isChecked() ? "1" :
                        bi.g41250sm.isChecked() ? "2" :
                                "0");
        json.put("g41250sdx", bi.g41250sdx.getText().toString());
        json.put("g41250smx", bi.g41250smx.getText().toString());
        json.put("g41250p",
                bi.g41250py.isChecked() ? "1" :
                        bi.g41250pn.isChecked() ? "2" :
                                "0");
        json.put("g41260a",
                bi.g41260ay.isChecked() ? "1" :
                        bi.g41260an.isChecked() ? "2" :
                                "0");
        json.put("g41260s",
                bi.g41260sy.isChecked() ? "1" :
                        bi.g41260sn.isChecked() ? "2" :
                                "0");
        json.put("g41260so",
                bi.g41260sd.isChecked() ? "1" :
                        bi.g41260sm.isChecked() ? "2" :
                                "0");
        json.put("g41260sdx", bi.g41260sdx.getText().toString());
        json.put("g41260smx", bi.g41260smx.getText().toString());
        json.put("g41260p",
                bi.g41260py.isChecked() ? "1" :
                        bi.g41260pn.isChecked() ? "2" :
                                "0");
        json.put("g41270a",
                bi.g41270ay.isChecked() ? "1" :
                        bi.g41270an.isChecked() ? "2" :
                                "0");
        json.put("g41270s",
                bi.g41270sy.isChecked() ? "1" :
                        bi.g41270sn.isChecked() ? "2" :
                                "0");
        json.put("g41270so",
                bi.g41270sd.isChecked() ? "1" :
                        bi.g41270sm.isChecked() ? "2" :
                                "0");
        json.put("g41270sdx", bi.g41270sdx.getText().toString());
        json.put("g41270smx", bi.g41270smx.getText().toString());
        json.put("g41270p",
                bi.g41270py.isChecked() ? "1" :
                        bi.g41270pn.isChecked() ? "2" :
                                "0");
        json.put("g41280a",
                bi.g41280ay.isChecked() ? "1" :
                        bi.g41280an.isChecked() ? "2" :
                                "0");
        json.put("g41280s",
                bi.g41280sy.isChecked() ? "1" :
                        bi.g41280sn.isChecked() ? "2" :
                                "0");
        json.put("g41280so",
                bi.g41280sd.isChecked() ? "1" :
                        bi.g41280sm.isChecked() ? "2" :
                                "0");
        json.put("g41280sdx", bi.g41280sdx.getText().toString());
        json.put("g41280smx", bi.g41280smx.getText().toString());
        json.put("g41280p",
                bi.g41280py.isChecked() ? "1" :
                        bi.g41280pn.isChecked() ? "2" :
                                "0");
        json.put("g41290a",
                bi.g41290ay.isChecked() ? "1" :
                        bi.g41290an.isChecked() ? "2" :
                                "0");
        json.put("g41290s",
                bi.g41290sy.isChecked() ? "1" :
                        bi.g41290sn.isChecked() ? "2" :
                                "0");
        json.put("g41290so",
                bi.g41290sd.isChecked() ? "1" :
                        bi.g41290sm.isChecked() ? "2" :
                                "0");
        json.put("g41290sdx", bi.g41290sdx.getText().toString());
        json.put("g41290smx", bi.g41290smx.getText().toString());
        json.put("g41290p",
                bi.g41290py.isChecked() ? "1" :
                        bi.g41290pn.isChecked() ? "2" :
                                "0");
        json.put("g41300a",
                bi.g41300ay.isChecked() ? "1" :
                        bi.g41300an.isChecked() ? "2" :
                                "0");
        json.put("g41300s",
                bi.g41300sy.isChecked() ? "1" :
                        bi.g41300sn.isChecked() ? "2" :
                                "0");
        json.put("g41300so",
                bi.g41300sd.isChecked() ? "1" :
                        bi.g41300sm.isChecked() ? "2" :
                                "0");
        json.put("g41300sdx", bi.g41300sdx.getText().toString());
        json.put("g41300smx", bi.g41300smx.getText().toString());
        json.put("g41300p",
                bi.g41300py.isChecked() ? "1" :
                        bi.g41300pn.isChecked() ? "2" :
                                "0");
        json.put("g41310a",
                bi.g41310ay.isChecked() ? "1" :
                        bi.g41310an.isChecked() ? "2" :
                                "0");
        json.put("g41310s",
                bi.g41310sy.isChecked() ? "1" :
                        bi.g41310sn.isChecked() ? "2" :
                                "0");
        json.put("g41310so",
                bi.g41310sd.isChecked() ? "1" :
                        bi.g41310sm.isChecked() ? "2" :
                                "0");
        json.put("g41310sdx", bi.g41310sdx.getText().toString());
        json.put("g41310smx", bi.g41310smx.getText().toString());
        json.put("g41310p",
                bi.g41310py.isChecked() ? "1" :
                        bi.g41310pn.isChecked() ? "2" :
                                "0");
        json.put("g41320a",
                bi.g41320ay.isChecked() ? "1" :
                        bi.g41320an.isChecked() ? "2" :
                                "0");
        json.put("g41320s",
                bi.g41320sy.isChecked() ? "1" :
                        bi.g41320sn.isChecked() ? "2" :
                                "0");
        json.put("g41320so",
                bi.g41320sd.isChecked() ? "1" :
                        bi.g41320sm.isChecked() ? "2" :
                                "0");
        json.put("g41320sdx", bi.g41320sdx.getText().toString());
        json.put("g41320smx", bi.g41320smx.getText().toString());
        json.put("g41320p",
                bi.g41320py.isChecked() ? "1" :
                        bi.g41320pn.isChecked() ? "2" :
                                "0");
        json.put("g41330a",
                bi.g41330ay.isChecked() ? "1" :
                        bi.g41330an.isChecked() ? "2" :
                                "0");
        json.put("g41330s",
                bi.g41330sy.isChecked() ? "1" :
                        bi.g41330sn.isChecked() ? "2" :
                                "0");
        json.put("g41330so",
                bi.g41330sd.isChecked() ? "1" :
                        bi.g41330sm.isChecked() ? "2" :
                                "0");
        json.put("g41330sdx", bi.g41330sdx.getText().toString());
        json.put("g41330smx", bi.g41330smx.getText().toString());
        json.put("g41330p",
                bi.g41330py.isChecked() ? "1" :
                        bi.g41330pn.isChecked() ? "2" :
                                "0");
        json.put("g41340a",
                bi.g41340ay.isChecked() ? "1" :
                        bi.g41340an.isChecked() ? "2" :
                                "0");
        json.put("g41340s",
                bi.g41340sy.isChecked() ? "1" :
                        bi.g41340sn.isChecked() ? "2" :
                                "0");
        json.put("g41340so",
                bi.g41340sd.isChecked() ? "1" :
                        bi.g41340sm.isChecked() ? "2" :
                                "0");
        json.put("g41340sdx", bi.g41340sdx.getText().toString());
        json.put("g41340smx", bi.g41340smx.getText().toString());
        json.put("g41340p",
                bi.g41340py.isChecked() ? "1" :
                        bi.g41340pn.isChecked() ? "2" :
                                "0");
        json.put("g41350a",
                bi.g41350ay.isChecked() ? "1" :
                        bi.g41350an.isChecked() ? "2" :
                                "0");
        json.put("g41350s",
                bi.g41350sy.isChecked() ? "1" :
                        bi.g41350sn.isChecked() ? "2" :
                                "0");
        json.put("g41350so",
                bi.g41350sd.isChecked() ? "1" :
                        bi.g41350sm.isChecked() ? "2" :
                                "0");
        json.put("g41350sdx", bi.g41350sdx.getText().toString());
        json.put("g41350smx", bi.g41350smx.getText().toString());
        json.put("g41350p",
                bi.g41350py.isChecked() ? "1" :
                        bi.g41350pn.isChecked() ? "2" :
                                "0");
        json.put("g41360a",
                bi.g41360ay.isChecked() ? "1" :
                        bi.g41360an.isChecked() ? "2" :
                                "0");
        json.put("g41360s",
                bi.g41360sy.isChecked() ? "1" :
                        bi.g41360sn.isChecked() ? "2" :
                                "0");
        json.put("g41360so",
                bi.g41360sd.isChecked() ? "1" :
                        bi.g41360sm.isChecked() ? "2" :
                                "0");
        json.put("g41360sdx", bi.g41360sdx.getText().toString());
        json.put("g41360smx", bi.g41360smx.getText().toString());
        json.put("g41360p",
                bi.g41360py.isChecked() ? "1" :
                        bi.g41360pn.isChecked() ? "2" :
                                "0");
        json.put("g41370a",
                bi.g41370ay.isChecked() ? "1" :
                        bi.g41370an.isChecked() ? "2" :
                                "0");
        json.put("g41370s",
                bi.g41370sy.isChecked() ? "1" :
                        bi.g41370sn.isChecked() ? "2" :
                                "0");
        json.put("g41370so",
                bi.g41370sd.isChecked() ? "1" :
                        bi.g41370sm.isChecked() ? "2" :
                                "0");
        json.put("g41370sdx", bi.g41370sdx.getText().toString());
        json.put("g41370smx", bi.g41370smx.getText().toString());
        json.put("g41370p",
                bi.g41370py.isChecked() ? "1" :
                        bi.g41370pn.isChecked() ? "2" :
                                "0");
        json.put("g41380a",
                bi.g41380ay.isChecked() ? "1" :
                        bi.g41380an.isChecked() ? "2" :
                                "0");
        json.put("g41380s",
                bi.g41380sy.isChecked() ? "1" :
                        bi.g41380sn.isChecked() ? "2" :
                                "0");
        json.put("g41380so",
                bi.g41380sd.isChecked() ? "1" :
                        bi.g41380sm.isChecked() ? "2" :
                                "0");
        json.put("g41380sdx", bi.g41380sdx.getText().toString());
        json.put("g41380smx", bi.g41380smx.getText().toString());
        json.put("g41380p",
                bi.g41380py.isChecked() ? "1" :
                        bi.g41380pn.isChecked() ? "2" :
                                "0");
        json.put("g41390a",
                bi.g41390ay.isChecked() ? "1" :
                        bi.g41390an.isChecked() ? "2" :
                                "0");
        json.put("g41390s",
                bi.g41390sy.isChecked() ? "1" :
                        bi.g41390sn.isChecked() ? "2" :
                                "0");
        json.put("g41390so",
                bi.g41390sd.isChecked() ? "1" :
                        bi.g41390sm.isChecked() ? "2" :
                                "0");
        json.put("g41390sdx", bi.g41390sdx.getText().toString());
        json.put("g41390smx", bi.g41390smx.getText().toString());
        json.put("g41390p",
                bi.g41390py.isChecked() ? "1" :
                        bi.g41390pn.isChecked() ? "2" :
                                "0");
        json.put("g41400a",
                bi.g41400ay.isChecked() ? "1" :
                        bi.g41400an.isChecked() ? "2" :
                                "0");
        json.put("g41400s",
                bi.g41400sy.isChecked() ? "1" :
                        bi.g41400sn.isChecked() ? "2" :
                                "0");
        json.put("g41400so",
                bi.g41400sd.isChecked() ? "1" :
                        bi.g41400sm.isChecked() ? "2" :
                                "0");
        json.put("g41400sdx", bi.g41400sdx.getText().toString());
        json.put("g41400smx", bi.g41400smx.getText().toString());
        json.put("g41400p",
                bi.g41400py.isChecked() ? "1" :
                        bi.g41400pn.isChecked() ? "2" :
                                "0");
        json.put("g41410a",
                bi.g41410ay.isChecked() ? "1" :
                        bi.g41410an.isChecked() ? "2" :
                                "0");
        json.put("g41410s",
                bi.g41410sy.isChecked() ? "1" :
                        bi.g41410sn.isChecked() ? "2" :
                                "0");
        json.put("g41410so",
                bi.g41410sd.isChecked() ? "1" :
                        bi.g41410sm.isChecked() ? "2" :
                                "0");
        json.put("g41410sdx", bi.g41410sdx.getText().toString());
        json.put("g41410smx", bi.g41410smx.getText().toString());
        json.put("g41410p",
                bi.g41410py.isChecked() ? "1" :
                        bi.g41410pn.isChecked() ? "2" :
                                "0");
        json.put("g41420a",
                bi.g41420ay.isChecked() ? "1" :
                        bi.g41420an.isChecked() ? "2" :
                                "0");
        json.put("g41420s",
                bi.g41420sy.isChecked() ? "1" :
                        bi.g41420sn.isChecked() ? "2" :
                                "0");
        json.put("g41420so",
                bi.g41420sd.isChecked() ? "1" :
                        bi.g41420sm.isChecked() ? "2" :
                                "0");
        json.put("g41420sdx", bi.g41420sdx.getText().toString());
        json.put("g41420smx", bi.g41420smx.getText().toString());
        json.put("g41420p",
                bi.g41420py.isChecked() ? "1" :
                        bi.g41420pn.isChecked() ? "2" :
                                "0");
        json.put("g41430a",
                bi.g41430ay.isChecked() ? "1" :
                        bi.g41430an.isChecked() ? "2" :
                                "0");
        json.put("g41430s",
                bi.g41430sy.isChecked() ? "1" :
                        bi.g41430sn.isChecked() ? "2" :
                                "0");
        json.put("g41430so",
                bi.g41430sd.isChecked() ? "1" :
                        bi.g41430sm.isChecked() ? "2" :
                                "0");
        json.put("g41430sdx", bi.g41430sdx.getText().toString());
        json.put("g41430smx", bi.g41430smx.getText().toString());
        json.put("g41430p",
                bi.g41430py.isChecked() ? "1" :
                        bi.g41430pn.isChecked() ? "2" :
                                "0");
        json.put("g41440a",
                bi.g41440ay.isChecked() ? "1" :
                        bi.g41440an.isChecked() ? "2" :
                                "0");
        json.put("g41440s",
                bi.g41440sy.isChecked() ? "1" :
                        bi.g41440sn.isChecked() ? "2" :
                                "0");
        json.put("g41440so",
                bi.g41440sd.isChecked() ? "1" :
                        bi.g41440sm.isChecked() ? "2" :
                                "0");
        json.put("g41440sdx", bi.g41440sdx.getText().toString());
        json.put("g41440smx", bi.g41440smx.getText().toString());
        json.put("g41440p",
                bi.g41440py.isChecked() ? "1" :
                        bi.g41440pn.isChecked() ? "2" :
                                "0");
        json.put("g4210a",
                bi.g4210ay.isChecked() ? "1" :
                        bi.g4210an.isChecked() ? "2" :
                                "0");
        json.put("g4210s",
                bi.g4210sy.isChecked() ? "1" :
                        bi.g4210sn.isChecked() ? "2" :
                                "0");
        json.put("g4210so",
                bi.g4210sd.isChecked() ? "1" :
                        bi.g4210sm.isChecked() ? "2" :
                                "0");
        json.put("g4210sdx", bi.g4210sdx.getText().toString());
        json.put("g4210smx", bi.g4210smx.getText().toString());
        json.put("g4210p",
                bi.g4210py.isChecked() ? "1" :
                        bi.g4210pn.isChecked() ? "2" :
                                "0");
        json.put("g4220a",
                bi.g4220ay.isChecked() ? "1" :
                        bi.g4220an.isChecked() ? "2" :
                                "0");
        json.put("g4220s",
                bi.g4220sy.isChecked() ? "1" :
                        bi.g4220sn.isChecked() ? "2" :
                                "0");
        json.put("g4220so",
                bi.g4220sd.isChecked() ? "1" :
                        bi.g4220sm.isChecked() ? "2" :
                                "0");
        json.put("g4220sdx", bi.g4220sdx.getText().toString());
        json.put("g4220smx", bi.g4220smx.getText().toString());
        json.put("g4220p",
                bi.g4220py.isChecked() ? "1" :
                        bi.g4220pn.isChecked() ? "2" :
                                "0");
        json.put("g4230a",
                bi.g4230ay.isChecked() ? "1" :
                        bi.g4230an.isChecked() ? "2" :
                                "0");
        json.put("g4230s",
                bi.g4230sy.isChecked() ? "1" :
                        bi.g4230sn.isChecked() ? "2" :
                                "0");
        json.put("g4230so",
                bi.g4230sd.isChecked() ? "1" :
                        bi.g4230sm.isChecked() ? "2" :
                                "0");
        json.put("g4230sdx", bi.g4230sdx.getText().toString());
        json.put("g4230smx", bi.g4230smx.getText().toString());
        json.put("g4230p",
                bi.g4230py.isChecked() ? "1" :
                        bi.g4230pn.isChecked() ? "2" :
                                "0");
        json.put("g4240a",
                bi.g4240ay.isChecked() ? "1" :
                        bi.g4240an.isChecked() ? "2" :
                                "0");
        json.put("g4240s",
                bi.g4240sy.isChecked() ? "1" :
                        bi.g4240sn.isChecked() ? "2" :
                                "0");
        json.put("g4240so",
                bi.g4240sd.isChecked() ? "1" :
                        bi.g4240sm.isChecked() ? "2" :
                                "0");
        json.put("g4240sdx", bi.g4240sdx.getText().toString());
        json.put("g4240smx", bi.g4240smx.getText().toString());
        json.put("g4240p",
                bi.g4240py.isChecked() ? "1" :
                        bi.g4240pn.isChecked() ? "2" :
                                "0");
        json.put("g4250a",
                bi.g4250ay.isChecked() ? "1" :
                        bi.g4250an.isChecked() ? "2" :
                                "0");
        json.put("g4250s",
                bi.g4250sy.isChecked() ? "1" :
                        bi.g4250sn.isChecked() ? "2" :
                                "0");
        json.put("g4250so",
                bi.g4250sd.isChecked() ? "1" :
                        bi.g4250sm.isChecked() ? "2" :
                                "0");
        json.put("g4250sdx", bi.g4250sdx.getText().toString());
        json.put("g4250smx", bi.g4250smx.getText().toString());
        json.put("g4250p",
                bi.g4250py.isChecked() ? "1" :
                        bi.g4250pn.isChecked() ? "2" :
                                "0");
        json.put("g4260a",
                bi.g4260ay.isChecked() ? "1" :
                        bi.g4260an.isChecked() ? "2" :
                                "0");
        json.put("g4260s",
                bi.g4260sy.isChecked() ? "1" :
                        bi.g4260sn.isChecked() ? "2" :
                                "0");
        json.put("g4260so",
                bi.g4260sd.isChecked() ? "1" :
                        bi.g4260sm.isChecked() ? "2" :
                                "0");
        json.put("g4260sdx", bi.g4260sdx.getText().toString());
        json.put("g4260smx", bi.g4260smx.getText().toString());
        json.put("g4260p",
                bi.g4260py.isChecked() ? "1" :
                        bi.g4260pn.isChecked() ? "2" :
                                "0");
        json.put("g4270a",
                bi.g4270ay.isChecked() ? "1" :
                        bi.g4270an.isChecked() ? "2" :
                                "0");
        json.put("g4270s",
                bi.g4270sy.isChecked() ? "1" :
                        bi.g4270sn.isChecked() ? "2" :
                                "0");
        json.put("g4270so",
                bi.g4270sd.isChecked() ? "1" :
                        bi.g4270sm.isChecked() ? "2" :
                                "0");
        json.put("g4270sdx", bi.g4270sdx.getText().toString());
        json.put("g4270smx", bi.g4270smx.getText().toString());
        json.put("g4270p",
                bi.g4270py.isChecked() ? "1" :
                        bi.g4270pn.isChecked() ? "2" :
                                "0");
        json.put("g4280a",
                bi.g4280ay.isChecked() ? "1" :
                        bi.g4280an.isChecked() ? "2" :
                                "0");
        json.put("g4280s",
                bi.g4280sy.isChecked() ? "1" :
                        bi.g4280sn.isChecked() ? "2" :
                                "0");
        json.put("g4280so",
                bi.g4280sd.isChecked() ? "1" :
                        bi.g4280sm.isChecked() ? "2" :
                                "0");
        json.put("g4280sdx", bi.g4280sdx.getText().toString());
        json.put("g4280smx", bi.g4280smx.getText().toString());
        json.put("g4280p",
                bi.g4280py.isChecked() ? "1" :
                        bi.g4280pn.isChecked() ? "2" :
                                "0");
        json.put("g4290a",
                bi.g4290ay.isChecked() ? "1" :
                        bi.g4290an.isChecked() ? "2" :
                                "0");
        json.put("g4290s",
                bi.g4290sy.isChecked() ? "1" :
                        bi.g4290sn.isChecked() ? "2" :
                                "0");
        json.put("g4290so",
                bi.g4290sd.isChecked() ? "1" :
                        bi.g4290sm.isChecked() ? "2" :
                                "0");
        json.put("g4290sdx", bi.g4290sdx.getText().toString());
        json.put("g4290smx", bi.g4290smx.getText().toString());
        json.put("g4290p",
                bi.g4290py.isChecked() ? "1" :
                        bi.g4290pn.isChecked() ? "2" :
                                "0");
        json.put("g42100a",
                bi.g42100ay.isChecked() ? "1" :
                        bi.g42100an.isChecked() ? "2" :
                                "0");
        json.put("g42100s",
                bi.g42100sy.isChecked() ? "1" :
                        bi.g42100sn.isChecked() ? "2" :
                                "0");
        json.put("g42100so",
                bi.g42100sd.isChecked() ? "1" :
                        bi.g42100sm.isChecked() ? "2" :
                                "0");
        json.put("g42100sdx", bi.g42100sdx.getText().toString());
        json.put("g42100smx", bi.g42100smx.getText().toString());
        json.put("g42100p",
                bi.g42100py.isChecked() ? "1" :
                        bi.g42100pn.isChecked() ? "2" :
                                "0");
        json.put("g4310a",
                bi.g4310ay.isChecked() ? "1" :
                        bi.g4310an.isChecked() ? "2" :
                                "0");
        json.put("g4310s",
                bi.g4310sy.isChecked() ? "1" :
                        bi.g4310sn.isChecked() ? "2" :
                                "0");
        json.put("g4310so",
                bi.g4310sd.isChecked() ? "1" :
                        bi.g4310sm.isChecked() ? "2" :
                                "0");
        json.put("g4310sdx", bi.g4310sdx.getText().toString());
        json.put("g4310smx", bi.g4310smx.getText().toString());
        json.put("g4310p",
                bi.g4310py.isChecked() ? "1" :
                        bi.g4310pn.isChecked() ? "2" :
                                "0");
        json.put("g4320a",
                bi.g4320ay.isChecked() ? "1" :
                        bi.g4320an.isChecked() ? "2" :
                                "0");
        json.put("g4320s",
                bi.g4320sy.isChecked() ? "1" :
                        bi.g4320sn.isChecked() ? "2" :
                                "0");
        json.put("g4320so",
                bi.g4320sd.isChecked() ? "1" :
                        bi.g4320sm.isChecked() ? "2" :
                                "0");
        json.put("g4320sdx", bi.g4320sdx.getText().toString());
        json.put("g4320smx", bi.g4320smx.getText().toString());
        json.put("g4320p",
                bi.g4320py.isChecked() ? "1" :
                        bi.g4320pn.isChecked() ? "2" :
                                "0");
        json.put("g4330a",
                bi.g4330ay.isChecked() ? "1" :
                        bi.g4330an.isChecked() ? "2" :
                                "0");
        json.put("g4330s",
                bi.g4330sy.isChecked() ? "1" :
                        bi.g4330sn.isChecked() ? "2" :
                                "0");
        json.put("g4330so",
                bi.g4330sd.isChecked() ? "1" :
                        bi.g4330sm.isChecked() ? "2" :
                                "0");
        json.put("g4330sdx", bi.g4330sdx.getText().toString());
        json.put("g4330smx", bi.g4330smx.getText().toString());
        json.put("g4330p",
                bi.g4330py.isChecked() ? "1" :
                        bi.g4330pn.isChecked() ? "2" :
                                "0");
        json.put("g4340a",
                bi.g4340ay.isChecked() ? "1" :
                        bi.g4340an.isChecked() ? "2" :
                                "0");
        json.put("g4340s",
                bi.g4340sy.isChecked() ? "1" :
                        bi.g4340sn.isChecked() ? "2" :
                                "0");
        json.put("g4340so",
                bi.g4340sd.isChecked() ? "1" :
                        bi.g4340sm.isChecked() ? "2" :
                                "0");
        json.put("g4340sdx", bi.g4340sdx.getText().toString());
        json.put("g4340smx", bi.g4340smx.getText().toString());
        json.put("g4340p",
                bi.g4340py.isChecked() ? "1" :
                        bi.g4340pn.isChecked() ? "2" :
                                "0");
        json.put("g4350a",
                bi.g4350ay.isChecked() ? "1" :
                        bi.g4350an.isChecked() ? "2" :
                                "0");
        json.put("g4350s",
                bi.g4350sy.isChecked() ? "1" :
                        bi.g4350sn.isChecked() ? "2" :
                                "0");
        json.put("g4350so",
                bi.g4350sd.isChecked() ? "1" :
                        bi.g4350sm.isChecked() ? "2" :
                                "0");
        json.put("g4350sdx", bi.g4350sdx.getText().toString());
        json.put("g4350smx", bi.g4350smx.getText().toString());
        json.put("g4350p",
                bi.g4350py.isChecked() ? "1" :
                        bi.g4350pn.isChecked() ? "2" :
                                "0");
        json.put("g4360a",
                bi.g4360ay.isChecked() ? "1" :
                        bi.g4360an.isChecked() ? "2" :
                                "0");
        json.put("g4360s",
                bi.g4360sy.isChecked() ? "1" :
                        bi.g4360sn.isChecked() ? "2" :
                                "0");
        json.put("g4360so",
                bi.g4360sd.isChecked() ? "1" :
                        bi.g4360sm.isChecked() ? "2" :
                                "0");
        json.put("g4360sdx", bi.g4360sdx.getText().toString());
        json.put("g4360smx", bi.g4360smx.getText().toString());
        json.put("g4360p",
                bi.g4360py.isChecked() ? "1" :
                        bi.g4360pn.isChecked() ? "2" :
                                "0");
        json.put("g4370a",
                bi.g4370ay.isChecked() ? "1" :
                        bi.g4370an.isChecked() ? "2" :
                                "0");
        json.put("g4370s",
                bi.g4370sy.isChecked() ? "1" :
                        bi.g4370sn.isChecked() ? "2" :
                                "0");
        json.put("g4370so",
                bi.g4370sd.isChecked() ? "1" :
                        bi.g4370sm.isChecked() ? "2" :
                                "0");
        json.put("g4370sdx", bi.g4370sdx.getText().toString());
        json.put("g4370smx", bi.g4370smx.getText().toString());
        json.put("g4370p",
                bi.g4370py.isChecked() ? "1" :
                        bi.g4370pn.isChecked() ? "2" :
                                "0");
        json.put("g4380a",
                bi.g4380ay.isChecked() ? "1" :
                        bi.g4380an.isChecked() ? "2" :
                                "0");
        json.put("g4380s",
                bi.g4380sy.isChecked() ? "1" :
                        bi.g4380sn.isChecked() ? "2" :
                                "0");
        json.put("g4380so",
                bi.g4380sd.isChecked() ? "1" :
                        bi.g4380sm.isChecked() ? "2" :
                                "0");
        json.put("g4380sdx", bi.g4380sdx.getText().toString());
        json.put("g4380smx", bi.g4380smx.getText().toString());
        json.put("g4380p",
                bi.g4380py.isChecked() ? "1" :
                        bi.g4380pn.isChecked() ? "2" :
                                "0");
        json.put("g4390a",
                bi.g4390ay.isChecked() ? "1" :
                        bi.g4390an.isChecked() ? "2" :
                                "0");
        json.put("g4390s",
                bi.g4390sy.isChecked() ? "1" :
                        bi.g4390sn.isChecked() ? "2" :
                                "0");
        json.put("g4390so",
                bi.g4390sd.isChecked() ? "1" :
                        bi.g4390sm.isChecked() ? "2" :
                                "0");
        json.put("g4390sdx", bi.g4390sdx.getText().toString());
        json.put("g4390smx", bi.g4390smx.getText().toString());
        json.put("g4390p",
                bi.g4390py.isChecked() ? "1" :
                        bi.g4390pn.isChecked() ? "2" :
                                "0");
        json.put("g43100a",
                bi.g43100ay.isChecked() ? "1" :
                        bi.g43100an.isChecked() ? "2" :
                                "0");
        json.put("g43100s",
                bi.g43100sy.isChecked() ? "1" :
                        bi.g43100sn.isChecked() ? "2" :
                                "0");
        json.put("g43100so",
                bi.g43100sd.isChecked() ? "1" :
                        bi.g43100sm.isChecked() ? "2" :
                                "0");
        json.put("g43100sdx", bi.g43100sdx.getText().toString());
        json.put("g43100smx", bi.g43100smx.getText().toString());
        json.put("g43100p",
                bi.g43100py.isChecked() ? "1" :
                        bi.g43100pn.isChecked() ? "2" :
                                "0");
        json.put("g43110a",
                bi.g43110ay.isChecked() ? "1" :
                        bi.g43110an.isChecked() ? "2" :
                                "0");
        json.put("g43110s",
                bi.g43110sy.isChecked() ? "1" :
                        bi.g43110sn.isChecked() ? "2" :
                                "0");
        json.put("g43110so",
                bi.g43110sd.isChecked() ? "1" :
                        bi.g43110sm.isChecked() ? "2" :
                                "0");
        json.put("g43110sdx", bi.g43110sdx.getText().toString());
        json.put("g43110smx", bi.g43110smx.getText().toString());
        json.put("g43110p",
                bi.g43110py.isChecked() ? "1" :
                        bi.g43110pn.isChecked() ? "2" :
                                "0");
        json.put("g43120a",
                bi.g43120ay.isChecked() ? "1" :
                        bi.g43120an.isChecked() ? "2" :
                                "0");
        json.put("g43120s",
                bi.g43120sy.isChecked() ? "1" :
                        bi.g43120sn.isChecked() ? "2" :
                                "0");
        json.put("g43120so",
                bi.g43120sd.isChecked() ? "1" :
                        bi.g43120sm.isChecked() ? "2" :
                                "0");
        json.put("g43120sdx", bi.g43120sdx.getText().toString());
        json.put("g43120smx", bi.g43120smx.getText().toString());
        json.put("g43120p",
                bi.g43120py.isChecked() ? "1" :
                        bi.g43120pn.isChecked() ? "2" :
                                "0");
        json.put("g43130a",
                bi.g43130ay.isChecked() ? "1" :
                        bi.g43130an.isChecked() ? "2" :
                                "0");
        json.put("g43130s",
                bi.g43130sy.isChecked() ? "1" :
                        bi.g43130sn.isChecked() ? "2" :
                                "0");
        json.put("g43130so",
                bi.g43130sd.isChecked() ? "1" :
                        bi.g43130sm.isChecked() ? "2" :
                                "0");
        json.put("g43130sdx", bi.g43130sdx.getText().toString());
        json.put("g43130smx", bi.g43130smx.getText().toString());
        json.put("g43130p",
                bi.g43130py.isChecked() ? "1" :
                        bi.g43130pn.isChecked() ? "2" :
                                "0");
        json.put("g43140a",
                bi.g43140ay.isChecked() ? "1" :
                        bi.g43140an.isChecked() ? "2" :
                                "0");
        json.put("g43140s",
                bi.g43140sy.isChecked() ? "1" :
                        bi.g43140sn.isChecked() ? "2" :
                                "0");
        json.put("g43140so",
                bi.g43140sd.isChecked() ? "1" :
                        bi.g43140sm.isChecked() ? "2" :
                                "0");
        json.put("g43140sdx", bi.g43140sdx.getText().toString());
        json.put("g43140smx", bi.g43140smx.getText().toString());
        json.put("g43140p",
                bi.g43140py.isChecked() ? "1" :
                        bi.g43140pn.isChecked() ? "2" :
                                "0");
        json.put("g43150a",
                bi.g43150ay.isChecked() ? "1" :
                        bi.g43150an.isChecked() ? "2" :
                                "0");
        json.put("g43150s",
                bi.g43150sy.isChecked() ? "1" :
                        bi.g43150sn.isChecked() ? "2" :
                                "0");
        json.put("g43150so",
                bi.g43150sd.isChecked() ? "1" :
                        bi.g43150sm.isChecked() ? "2" :
                                "0");
        json.put("g43150sdx", bi.g43150sdx.getText().toString());
        json.put("g43150smx", bi.g43150smx.getText().toString());
        json.put("g43150p",
                bi.g43150py.isChecked() ? "1" :
                        bi.g43150pn.isChecked() ? "2" :
                                "0");
        json.put("g43160a",
                bi.g43160ay.isChecked() ? "1" :
                        bi.g43160an.isChecked() ? "2" :
                                "0");
        json.put("g43160s",
                bi.g43160sy.isChecked() ? "1" :
                        bi.g43160sn.isChecked() ? "2" :
                                "0");
        json.put("g43160so",
                bi.g43160sd.isChecked() ? "1" :
                        bi.g43160sm.isChecked() ? "2" :
                                "0");
        json.put("g43160sdx", bi.g43160sdx.getText().toString());
        json.put("g43160smx", bi.g43160smx.getText().toString());
        json.put("g43160p",
                bi.g43160py.isChecked() ? "1" :
                        bi.g43160pn.isChecked() ? "2" :
                                "0");
        json.put("g43170a",
                bi.g43170ay.isChecked() ? "1" :
                        bi.g43170an.isChecked() ? "2" :
                                "0");
        json.put("g43170s",
                bi.g43170sy.isChecked() ? "1" :
                        bi.g43170sn.isChecked() ? "2" :
                                "0");
        json.put("g43170so",
                bi.g43170sd.isChecked() ? "1" :
                        bi.g43170sm.isChecked() ? "2" :
                                "0");
        json.put("g43170sdx", bi.g43170sdx.getText().toString());
        json.put("g43170smx", bi.g43170smx.getText().toString());
        json.put("g43170p",
                bi.g43170py.isChecked() ? "1" :
                        bi.g43170pn.isChecked() ? "2" :
                                "0");
        json.put("g43180a",
                bi.g43180ay.isChecked() ? "1" :
                        bi.g43180an.isChecked() ? "2" :
                                "0");
        json.put("g43180s",
                bi.g43180sy.isChecked() ? "1" :
                        bi.g43180sn.isChecked() ? "2" :
                                "0");
        json.put("g43180so",
                bi.g43180sd.isChecked() ? "1" :
                        bi.g43180sm.isChecked() ? "2" :
                                "0");
        json.put("g43180sdx", bi.g43180sdx.getText().toString());
        json.put("g43180smx", bi.g43180smx.getText().toString());
        json.put("g43180p",
                bi.g43180py.isChecked() ? "1" :
                        bi.g43180pn.isChecked() ? "2" :
                                "0");
        json.put("g43190a",
                bi.g43190ay.isChecked() ? "1" :
                        bi.g43190an.isChecked() ? "2" :
                                "0");
        json.put("g43190s",
                bi.g43190sy.isChecked() ? "1" :
                        bi.g43190sn.isChecked() ? "2" :
                                "0");
        json.put("g43190so",
                bi.g43190sd.isChecked() ? "1" :
                        bi.g43190sm.isChecked() ? "2" :
                                "0");
        json.put("g43190sdx", bi.g43190sdx.getText().toString());
        json.put("g43190smx", bi.g43190smx.getText().toString());
        json.put("g43190p",
                bi.g43190py.isChecked() ? "1" :
                        bi.g43190pn.isChecked() ? "2" :
                                "0");
        json.put("g43200a",
                bi.g43200ay.isChecked() ? "1" :
                        bi.g43200an.isChecked() ? "2" :
                                "0");
        json.put("g43200s",
                bi.g43200sy.isChecked() ? "1" :
                        bi.g43200sn.isChecked() ? "2" :
                                "0");
        json.put("g43200so",
                bi.g43200sd.isChecked() ? "1" :
                        bi.g43200sm.isChecked() ? "2" :
                                "0");
        json.put("g43200sdx", bi.g43200sdx.getText().toString());
        json.put("g43200smx", bi.g43200smx.getText().toString());
        json.put("g43200p",
                bi.g43200py.isChecked() ? "1" :
                        bi.g43200pn.isChecked() ? "2" :
                                "0");
        json.put("g43210a",
                bi.g43210ay.isChecked() ? "1" :
                        bi.g43210an.isChecked() ? "2" :
                                "0");
        json.put("g43210s",
                bi.g43210sy.isChecked() ? "1" :
                        bi.g43210sn.isChecked() ? "2" :
                                "0");
        json.put("g43210so",
                bi.g43210sd.isChecked() ? "1" :
                        bi.g43210sm.isChecked() ? "2" :
                                "0");
        json.put("g43210sdx", bi.g43210sdx.getText().toString());
        json.put("g43210smx", bi.g43210smx.getText().toString());
        json.put("g43210p",
                bi.g43210py.isChecked() ? "1" :
                        bi.g43210pn.isChecked() ? "2" :
                                "0");
        json.put("g43220a",
                bi.g43220ay.isChecked() ? "1" :
                        bi.g43220an.isChecked() ? "2" :
                                "0");
        json.put("g43220s",
                bi.g43220sy.isChecked() ? "1" :
                        bi.g43220sn.isChecked() ? "2" :
                                "0");
        json.put("g43220so",
                bi.g43220sd.isChecked() ? "1" :
                        bi.g43220sm.isChecked() ? "2" :
                                "0");
        json.put("g43220sdx", bi.g43220sdx.getText().toString());
        json.put("g43220smx", bi.g43220smx.getText().toString());
        json.put("g43220p",
                bi.g43220py.isChecked() ? "1" :
                        bi.g43220pn.isChecked() ? "2" :
                                "0");
        json.put("g43230a",
                bi.g43230ay.isChecked() ? "1" :
                        bi.g43230an.isChecked() ? "2" :
                                "0");
        json.put("g43230s",
                bi.g43230sy.isChecked() ? "1" :
                        bi.g43230sn.isChecked() ? "2" :
                                "0");
        json.put("g43230so",
                bi.g43230sd.isChecked() ? "1" :
                        bi.g43230sm.isChecked() ? "2" :
                                "0");
        json.put("g43230sdx", bi.g43230sdx.getText().toString());
        json.put("g43230smx", bi.g43230smx.getText().toString());
        json.put("g43230p",
                bi.g43230py.isChecked() ? "1" :
                        bi.g43230pn.isChecked() ? "2" :
                                "0");
        json.put("g43240a",
                bi.g43240ay.isChecked() ? "1" :
                        bi.g43240an.isChecked() ? "2" :
                                "0");
        json.put("g43240s",
                bi.g43240sy.isChecked() ? "1" :
                        bi.g43240sn.isChecked() ? "2" :
                                "0");
        json.put("g43240so",
                bi.g43240sd.isChecked() ? "1" :
                        bi.g43240sm.isChecked() ? "2" :
                                "0");
        json.put("g43240sdx", bi.g43240sdx.getText().toString());
        json.put("g43240smx", bi.g43240smx.getText().toString());
        json.put("g43240p",
                bi.g43240py.isChecked() ? "1" :
                        bi.g43240pn.isChecked() ? "2" :
                                "0");
        json.put("g43250a",
                bi.g43250ay.isChecked() ? "1" :
                        bi.g43250an.isChecked() ? "2" :
                                "0");
        json.put("g43250s",
                bi.g43250sy.isChecked() ? "1" :
                        bi.g43250sn.isChecked() ? "2" :
                                "0");
        json.put("g43250so",
                bi.g43250sd.isChecked() ? "1" :
                        bi.g43250sm.isChecked() ? "2" :
                                "0");
        json.put("g43250sdx", bi.g43250sdx.getText().toString());
        json.put("g43250smx", bi.g43250smx.getText().toString());
        json.put("g43250p",
                bi.g43250py.isChecked() ? "1" :
                        bi.g43250pn.isChecked() ? "2" :
                                "0");
        json.put("g43260a",
                bi.g43260ay.isChecked() ? "1" :
                        bi.g43260an.isChecked() ? "2" :
                                "0");
        json.put("g43260s",
                bi.g43260sy.isChecked() ? "1" :
                        bi.g43260sn.isChecked() ? "2" :
                                "0");
        json.put("g43260so",
                bi.g43260sd.isChecked() ? "1" :
                        bi.g43260sm.isChecked() ? "2" :
                                "0");
        json.put("g43260sdx", bi.g43260sdx.getText().toString());
        json.put("g43260smx", bi.g43260smx.getText().toString());
        json.put("g43260p",
                bi.g43260py.isChecked() ? "1" :
                        bi.g43260pn.isChecked() ? "2" :
                                "0");
        json.put("g43270a",
                bi.g43270ay.isChecked() ? "1" :
                        bi.g43270an.isChecked() ? "2" :
                                "0");
        json.put("g43270s",
                bi.g43270sy.isChecked() ? "1" :
                        bi.g43270sn.isChecked() ? "2" :
                                "0");
        json.put("g43270so",
                bi.g43270sd.isChecked() ? "1" :
                        bi.g43270sm.isChecked() ? "2" :
                                "0");
        json.put("g43270sdx", bi.g43270sdx.getText().toString());
        json.put("g43270smx", bi.g43270smx.getText().toString());
        json.put("g43270p",
                bi.g43270py.isChecked() ? "1" :
                        bi.g43270pn.isChecked() ? "2" :
                                "0");
        json.put("g4410a",
                bi.g4410ay.isChecked() ? "1" :
                        bi.g4410an.isChecked() ? "2" :
                                "0");
        json.put("g4410s",
                bi.g4410sy.isChecked() ? "1" :
                        bi.g4410sn.isChecked() ? "2" :
                                "0");
        json.put("g4410so",
                bi.g4410sd.isChecked() ? "1" :
                        bi.g4410sm.isChecked() ? "2" :
                                "0");
        json.put("g4410sdx", bi.g4410sdx.getText().toString());
        json.put("g4410smx", bi.g4410smx.getText().toString());
        json.put("g4410p",
                bi.g4410py.isChecked() ? "1" :
                        bi.g4410pn.isChecked() ? "2" :
                                "0");
        json.put("g4420a",
                bi.g4420ay.isChecked() ? "1" :
                        bi.g4420an.isChecked() ? "2" :
                                "0");
        json.put("g4420s",
                bi.g4420sy.isChecked() ? "1" :
                        bi.g4420sn.isChecked() ? "2" :
                                "0");
        json.put("g4420so",
                bi.g4420sd.isChecked() ? "1" :
                        bi.g4420sm.isChecked() ? "2" :
                                "0");
        json.put("g4420sdx", bi.g4420sdx.getText().toString());
        json.put("g4420smx", bi.g4420smx.getText().toString());
        json.put("g4420p",
                bi.g4420py.isChecked() ? "1" :
                        bi.g4420pn.isChecked() ? "2" :
                                "0");
        json.put("g4430a",
                bi.g4430ay.isChecked() ? "1" :
                        bi.g4430an.isChecked() ? "2" :
                                "0");
        json.put("g4430s",
                bi.g4430sy.isChecked() ? "1" :
                        bi.g4430sn.isChecked() ? "2" :
                                "0");
        json.put("g4430so",
                bi.g4430sd.isChecked() ? "1" :
                        bi.g4430sm.isChecked() ? "2" :
                                "0");
        json.put("g4430sdx", bi.g4430sdx.getText().toString());
        json.put("g4430smx", bi.g4430smx.getText().toString());
        json.put("g4430p",
                bi.g4430py.isChecked() ? "1" :
                        bi.g4430pn.isChecked() ? "2" :
                                "0");
        json.put("g4440a",
                bi.g4440ay.isChecked() ? "1" :
                        bi.g4440an.isChecked() ? "2" :
                                "0");
        json.put("g4440s",
                bi.g4440sy.isChecked() ? "1" :
                        bi.g4440sn.isChecked() ? "2" :
                                "0");
        json.put("g4440so",
                bi.g4440sd.isChecked() ? "1" :
                        bi.g4440sm.isChecked() ? "2" :
                                "0");

        json.put("g4440sdx", bi.g4440sdx.getText().toString());

        json.put("g4440smx", bi.g4440smx.getText().toString());

        json.put("g4440p",
                bi.g4440py.isChecked() ? "1" :
                        bi.g4440pn.isChecked() ? "2" :
                                "0");
        json.put("g4450a",
                bi.g4450ay.isChecked() ? "1" :
                        bi.g4450an.isChecked() ? "2" :
                                "0");
        json.put("g4450s",
                bi.g4450sy.isChecked() ? "1" :
                        bi.g4450sn.isChecked() ? "2" :
                                "0");
        json.put("g4450so",
                bi.g4450sd.isChecked() ? "1" :
                        bi.g4450sm.isChecked() ? "2" :
                                "0");
        json.put("g4450sdx", bi.g4450sdx.getText().toString());
        json.put("g4450smx", bi.g4450smx.getText().toString());
        json.put("g4450p",
                bi.g4450py.isChecked() ? "1" :
                        bi.g4450pn.isChecked() ? "2" :
                                "0");
        json.put("g4460a",
                bi.g4460ay.isChecked() ? "1" :
                        bi.g4460an.isChecked() ? "2" :
                                "0");
        json.put("g4460s",
                bi.g4460sy.isChecked() ? "1" :
                        bi.g4460sn.isChecked() ? "2" :
                                "0");
        json.put("g4460so",
                bi.g4460sd.isChecked() ? "1" :
                        bi.g4460sm.isChecked() ? "2" :
                                "0");
        json.put("g4460sdx", bi.g4460sdx.getText().toString());
        json.put("g4460smx", bi.g4460smx.getText().toString());
        json.put("g4460p",
                bi.g4460py.isChecked() ? "1" :
                        bi.g4460pn.isChecked() ? "2" :
                                "0");


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
