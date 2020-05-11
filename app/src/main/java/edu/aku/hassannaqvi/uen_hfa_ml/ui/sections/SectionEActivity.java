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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionEBinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionEActivity extends AppCompatActivity {

    ActivitySectionEBinding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupListeners();
    }

    private void setupListeners() {


        /*bi.im01.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.im011.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02, false);
                Clear.clearAllFields(bi.fldGrpCVim02a, false);
            } else if (i == bi.im012.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02, false);
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim02, true);
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
            }

        }));*/

        /*bi.im02.setOnCheckedChangeListener((radioGroup, i) -> {
            if (i == bi.im021.getId()) {
                Clear.clearAllFields(bi.fldGrpCVim02a, false);
//                Clear.clearAllFields(bi.fldGrpSecChc2, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVim02a, true);
//                Clear.clearAllFields(bi.fldGrpSecChc2, true);
            }

            Clear.clearAllFields(bi.fldGrpCVim02a, i == bi.im022.getId());
            im02Flag = i == bi.im021.getId();

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
        json.put("e11",
                bi.e11a.isChecked() ? "1" :
                        bi.e11b.isChecked() ? "2" :
                                "-1");
        json.put("e12",
                "-1");
        json.put("e12a",
                bi.e12aa.isChecked() ? "1" :
                        bi.e12ab.isChecked() ? "2" :
                                "-1");
        json.put("e12b",
                bi.e12ba.isChecked() ? "1" :
                        bi.e12bb.isChecked() ? "2" :
                                "-1");
        json.put("e12c",
                bi.e12ca.isChecked() ? "1" :
                        bi.e12cb.isChecked() ? "2" :
                                "-1");
        json.put("e12d",
                bi.e12da.isChecked() ? "1" :
                        bi.e12db.isChecked() ? "2" :
                                "-1");
        json.put("e12e",
                bi.e12ea.isChecked() ? "1" :
                        bi.e12eb.isChecked() ? "2" :
                                "-1");
        json.put("e12f",
                bi.e12fa.isChecked() ? "1" :
                        bi.e12fb.isChecked() ? "2" :
                                "-1");
        json.put("e12g",
                bi.e12ga.isChecked() ? "1" :
                        bi.e12gb.isChecked() ? "2" :
                                "-1");
        json.put("e12h",
                bi.e12ha.isChecked() ? "1" :
                        bi.e12hb.isChecked() ? "2" :
                                "-1");
        json.put("e12i",
                bi.e12ia.isChecked() ? "1" :
                        bi.e12ib.isChecked() ? "2" :
                                "-1");
        json.put("e12j",
                bi.e12ja.isChecked() ? "1" :
                        bi.e12jb.isChecked() ? "2" :
                                "-1");
        json.put("e13",
                "-1");
        json.put("e13a",
                bi.e13aa.isChecked() ? "1" :
                        bi.e13ab.isChecked() ? "2" :
                                bi.e13ac.isChecked() ? "3" :
                                        "-1");
        json.put("e13b",
                bi.e13ba.isChecked() ? "1" :
                        bi.e13bb.isChecked() ? "2" :
                                bi.e13bc.isChecked() ? "3" :
                                        "-1");
        json.put("e14",
                "-1");
        json.put("e14a",
                bi.e14aa.isChecked() ? "1" :
                        bi.e14ab.isChecked() ? "2" :
                                "-1");
        json.put("e14b",
                bi.e14ba.isChecked() ? "1" :
                        bi.e14bb.isChecked() ? "2" :
                                "-1");
        json.put("e14c", bi.e14c.getText().toString());
        json.put("e14d",
                bi.e14da.isChecked() ? "1" :
                        bi.e14db.isChecked() ? "2" :
                                bi.e14dc.isChecked() ? "3" :
                                        bi.e14dd.isChecked() ? "4" :
                                                "-1");
        //json.put("e13e", bi.e13e.getText().toString());
        json.put("e21",
                bi.e21a.isChecked() ? "1" :
                        bi.e21b.isChecked() ? "2" :
                                "-1");
        json.put("e22",
                "-1");
        json.put("e22a",
                bi.e22aa.isChecked() ? "1" :
                        bi.e22ab.isChecked() ? "2" :
                                "-1");
        json.put("e22b",
                bi.e22ba.isChecked() ? "1" :
                        bi.e22bb.isChecked() ? "2" :
                                "-1");
        json.put("e22c",
                bi.e22ca.isChecked() ? "1" :
                        bi.e22cb.isChecked() ? "2" :
                                "-1");
        json.put("e22d",
                bi.e22da.isChecked() ? "1" :
                        bi.e22db.isChecked() ? "2" :
                                "-1");
        json.put("e22e",
                bi.e22ea.isChecked() ? "1" :
                        bi.e22eb.isChecked() ? "2" :
                                "-1");
        json.put("e22f",
                bi.e22fa.isChecked() ? "1" :
                        bi.e22fb.isChecked() ? "2" :
                                "-1");
        json.put("e23",
                "-1");
        json.put("e23a",
                bi.e23aa.isChecked() ? "1" :
                        bi.e23ab.isChecked() ? "2" :
                                bi.e23ec.isChecked() ? "3" :
                                        "-1");
        json.put("e23b",
                bi.e23ba.isChecked() ? "1" :
                        bi.e23bb.isChecked() ? "2" :
                                bi.e23bc.isChecked() ? "3" :
                                        "-1");
        json.put("e24",
                "-1");
        json.put("e24a",
                bi.e24aa.isChecked() ? "1" :
                        bi.e24ab.isChecked() ? "2" :
                                "-1");
        json.put("e24b", bi.e24b.getText().toString());
        json.put("e24c",
                bi.e24ca.isChecked() ? "1" :
                        bi.e24cb.isChecked() ? "2" :
                                bi.e24cc.isChecked() ? "3" :
                                        bi.e24cd.isChecked() ? "4" :
                                                "-1");
        //json.put("e24d", bi.e24d.getText().toString());
        json.put("e31",
                bi.e31a.isChecked() ? "1" :
                        bi.e31b.isChecked() ? "2" :
                                "-1");
        json.put("e32",
                "-1");
        json.put("e32a",
                bi.e32aa.isChecked() ? "1" :
                        bi.e32ab.isChecked() ? "2" :
                                "-1");
        json.put("e32b",
                bi.e32ba.isChecked() ? "1" :
                        bi.e32bb.isChecked() ? "2" :
                                "-1");
        json.put("e32c",
                bi.e32ca.isChecked() ? "1" :
                        bi.e32cb.isChecked() ? "2" :
                                "-1");
        json.put("e32d",
                bi.e32da.isChecked() ? "1" :
                        bi.e32db.isChecked() ? "2" :
                                "-1");
        json.put("e32e",
                bi.e32ea.isChecked() ? "1" :
                        bi.e32eb.isChecked() ? "2" :
                                "-1");
        json.put("e33",
                "-1");
        json.put("e33a",
                bi.e33aa.isChecked() ? "1" :
                        bi.e33ab.isChecked() ? "2" :
                                "-1");
        json.put("e33b",
                bi.e33ba.isChecked() ? "1" :
                        bi.e33bb.isChecked() ? "2" :
                                "-1");
        json.put("e33c",
                bi.e33ca.isChecked() ? "1" :
                        bi.e33cb.isChecked() ? "2" :
                                "-1");
        json.put("e33d",
                bi.e33da.isChecked() ? "1" :
                        bi.e33db.isChecked() ? "2" :
                                "-1");
        json.put("e33e",
                bi.e33ea.isChecked() ? "1" :
                        bi.e33eb.isChecked() ? "2" :
                                "-1");
        json.put("e33f",
                bi.e33fa.isChecked() ? "1" :
                        bi.e33fb.isChecked() ? "2" :
                                "-1");
        json.put("e33g",
                bi.e33ga.isChecked() ? "1" :
                        bi.e33gb.isChecked() ? "2" :
                                "-1");
        json.put("e33h",
                bi.e33ha.isChecked() ? "1" :
                        bi.e33hb.isChecked() ? "2" :
                                "-1");
        json.put("e33i",
                bi.e33ia.isChecked() ? "1" :
                        bi.e33ib.isChecked() ? "2" :
                                "-1");
        json.put("e33j",
                bi.e33ja.isChecked() ? "1" :
                        bi.e33jb.isChecked() ? "2" :
                                "-1");
        json.put("e33k",
                bi.e33ka.isChecked() ? "1" :
                        bi.e33kb.isChecked() ? "2" :
                                "-1");
        json.put("e33l",
                bi.e33la.isChecked() ? "1" :
                        bi.e33lb.isChecked() ? "2" :
                                "-1");
        json.put("e33m",
                bi.e33ma.isChecked() ? "1" :
                        bi.e33mb.isChecked() ? "2" :
                                "-1");
        json.put("e33n",
                bi.e33na.isChecked() ? "1" :
                        bi.e33nb.isChecked() ? "2" :
                                "-1");
        json.put("e34",
                "-1");
        json.put("e34a",
                bi.e34aa.isChecked() ? "1" :
                        bi.e34ab.isChecked() ? "2" :
                                bi.e34ac.isChecked() ? "3" :
                                        "-1");
        json.put("e34b",
                bi.e34ba.isChecked() ? "1" :
                        bi.e34bb.isChecked() ? "2" :
                                bi.e34bc.isChecked() ? "3" :
                                        "-1");
        json.put("e34c",
                bi.e34ca.isChecked() ? "1" :
                        bi.e34cb.isChecked() ? "2" :
                                bi.e34cc.isChecked() ? "3" :
                                        "-1");
        json.put("e34d",
                bi.e34da.isChecked() ? "1" :
                        bi.e34db.isChecked() ? "2" :
                                bi.e34dc.isChecked() ? "3" :
                                        "-1");
        json.put("e35",
                "-1");
        json.put("e35a",
                bi.e35aa.isChecked() ? "1" :
                        bi.e35ab.isChecked() ? "2" :
                                bi.e35ac.isChecked() ? "3" :
                                        "-1");
        json.put("e35b",
                bi.e35ba.isChecked() ? "1" :
                        bi.e35bb.isChecked() ? "2" :
                                bi.e35bc.isChecked() ? "3" :
                                        "-1");
        json.put("e35c",
                bi.e35ca.isChecked() ? "1" :
                        bi.e35cb.isChecked() ? "2" :
                                bi.e35cc.isChecked() ? "3" :
                                        "-1");
        json.put("e35d",
                bi.e35da.isChecked() ? "1" :
                        bi.e35db.isChecked() ? "2" :
                                bi.e35dc.isChecked() ? "3" :
                                        bi.e35dd.isChecked() ? "4" :
                                                "-1");
        //json.put("e35e", bi.e35e.getText().toString());
        json.put("e36",
                "-1");
        json.put("e36a0a",
                bi.e36a0ay.isChecked() ? "1" :
                        bi.e36a0an.isChecked() ? "2" :
                                bi.e36a0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36a0aqx", bi.e36a0aqx.getText().toString());
        json.put("e36a0f",
                bi.e36a0fy.isChecked() ? "1" :
                        bi.e36a0fn.isChecked() ? "2" :
                                bi.e36a0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36a0fqx", bi.e36a0fqx.getText().toString());
        json.put("e36b0a",
                bi.e36b0ay.isChecked() ? "1" :
                        bi.e36b0an.isChecked() ? "2" :
                                bi.e36b0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36b0aqx", bi.e36b0aqx.getText().toString());
        json.put("e36b0f",
                bi.e36b0fy.isChecked() ? "1" :
                        bi.e36b0fn.isChecked() ? "2" :
                                bi.e36b0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36b0fqx", bi.e36b0fqx.getText().toString());
        json.put("e36c0a",
                bi.e36c0ay.isChecked() ? "1" :
                        bi.e36c0an.isChecked() ? "2" :
                                bi.e36c0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36c0aqx", bi.e36c0aqx.getText().toString());
        json.put("e36c0f",
                bi.e36c0fy.isChecked() ? "1" :
                        bi.e36c0fn.isChecked() ? "2" :
                                bi.e36c0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36c0fqx", bi.e36c0fqx.getText().toString());
        json.put("e36d0a",
                bi.e36d0ay.isChecked() ? "1" :
                        bi.e36d0an.isChecked() ? "2" :
                                bi.e36d0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36d0aqx", bi.e36d0aqx.getText().toString());
        json.put("e36d0f",
                bi.e36d0fy.isChecked() ? "1" :
                        bi.e36d0fn.isChecked() ? "2" :
                                bi.e36d0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36d0fqx", bi.e36d0fqx.getText().toString());
        json.put("e36e0a",
                bi.e36e0ay.isChecked() ? "1" :
                        bi.e36e0an.isChecked() ? "2" :
                                bi.e36e0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36e0aqx", bi.e36e0aqx.getText().toString());
        json.put("e36e0f",
                bi.e36e0fy.isChecked() ? "1" :
                        bi.e36e0fn.isChecked() ? "2" :
                                bi.e36e0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36e0fqx", bi.e36e0fqx.getText().toString());
        json.put("e36f0a",
                bi.e36f0ay.isChecked() ? "1" :
                        bi.e36f0an.isChecked() ? "2" :
                                bi.e36f0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36f0aqx", bi.e36f0aqx.getText().toString());
        json.put("e36f0f",
                bi.e36f0fy.isChecked() ? "1" :
                        bi.e36f0fn.isChecked() ? "2" :
                                bi.e36f0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36f0fqx", bi.e36f0fqx.getText().toString());
        json.put("e36g0a",
                bi.e36g0ay.isChecked() ? "1" :
                        bi.e36g0an.isChecked() ? "2" :
                                bi.e36g0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36g0aqx", bi.e36g0aqx.getText().toString());
        json.put("e36g0f",
                bi.e36g0fy.isChecked() ? "1" :
                        bi.e36g0fn.isChecked() ? "2" :
                                bi.e36g0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36g0fqx", bi.e36g0fqx.getText().toString());
        json.put("e36h0a",
                bi.e36h0ay.isChecked() ? "1" :
                        bi.e36h0an.isChecked() ? "2" :
                                bi.e36h0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36h0aqx", bi.e36h0aqx.getText().toString());
        json.put("e36h0f",
                bi.e36h0fy.isChecked() ? "1" :
                        bi.e36h0fn.isChecked() ? "2" :
                                bi.e36h0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36h0fqx", bi.e36h0fqx.getText().toString());
        json.put("e36i0a",
                bi.e36i0ay.isChecked() ? "1" :
                        bi.e36i0an.isChecked() ? "2" :
                                bi.e36i0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36i0aqx", bi.e36i0aqx.getText().toString());
        json.put("e36i0f",
                bi.e36i0fy.isChecked() ? "1" :
                        bi.e36i0fn.isChecked() ? "2" :
                                bi.e36i0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36i0fqx", bi.e36i0fqx.getText().toString());
        json.put("e36j0a",
                bi.e36j0ay.isChecked() ? "1" :
                        bi.e36j0an.isChecked() ? "2" :
                                bi.e36j0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36j0aqx", bi.e36j0aqx.getText().toString());
        json.put("e36j0f",
                bi.e36j0fy.isChecked() ? "1" :
                        bi.e36j0fn.isChecked() ? "2" :
                                bi.e36j0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36j0fqx", bi.e36j0fqx.getText().toString());
        json.put("e36k0a",
                bi.e36k0ay.isChecked() ? "1" :
                        bi.e36k0an.isChecked() ? "2" :
                                bi.e36k0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36k0aqx", bi.e36k0aqx.getText().toString());
        json.put("e36k0f",
                bi.e36k0fy.isChecked() ? "1" :
                        bi.e36k0fn.isChecked() ? "2" :
                                bi.e36k0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36k0fqx", bi.e36k0fqx.getText().toString());
        json.put("e36l0a",
                bi.e36l0ay.isChecked() ? "1" :
                        bi.e36l0an.isChecked() ? "2" :
                                bi.e36l0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36l0aqx", bi.e36l0aqx.getText().toString());
        json.put("e36l0f",
                bi.e36l0fy.isChecked() ? "1" :
                        bi.e36l0fn.isChecked() ? "2" :
                                bi.e36l0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36l0fqx", bi.e36l0fqx.getText().toString());
        json.put("e36m0a",
                bi.e36m0ay.isChecked() ? "1" :
                        bi.e36m0an.isChecked() ? "2" :
                                bi.e36m0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36m0aqx", bi.e36m0aqx.getText().toString());
        json.put("e36m0f",
                bi.e36m0fy.isChecked() ? "1" :
                        bi.e36m0fn.isChecked() ? "2" :
                                bi.e36m0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36m0fqx", bi.e36m0fqx.getText().toString());
        json.put("e36n0a",
                "-1");
        json.put("e36n0ay",
                "-1");
        json.put("e36n0an",
                "-1");
        json.put("e36n0aq", bi.e36n0aq.getText().toString());
        json.put("e36n0f",
                bi.e36n0fy.isChecked() ? "1" :
                        bi.e36n0fn.isChecked() ? "2" :
                                bi.e36n0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36n0fqx", bi.e36n0fqx.getText().toString());
        json.put("e36o0a",
                bi.e36o0ay.isChecked() ? "1" :
                        bi.e36o0an.isChecked() ? "2" :
                                bi.e36o0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36o0aqx", bi.e36o0aqx.getText().toString());
        json.put("e36o0f",
                bi.e36o0fy.isChecked() ? "1" :
                        bi.e36o0fn.isChecked() ? "2" :
                                bi.e36o0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36o0fqx", bi.e36o0fqx.getText().toString());
        json.put("e36p0a",
                bi.e36p0ay.isChecked() ? "1" :
                        bi.e36p0an.isChecked() ? "2" :
                                bi.e36p0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36p0aqx", bi.e36p0aqx.getText().toString());
        json.put("e36p0f",
                bi.e36p0fy.isChecked() ? "1" :
                        bi.e36p0fn.isChecked() ? "2" :
                                bi.e36p0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36p0fqx", bi.e36p0fqx.getText().toString());
        json.put("e36q0a",
                bi.e36q0ay.isChecked() ? "1" :
                        bi.e36q0an.isChecked() ? "2" :
                                bi.e36q0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36q0aqx", bi.e36q0aqx.getText().toString());
        json.put("e36q0f",
                bi.e36q0fy.isChecked() ? "1" :
                        bi.e36q0fn.isChecked() ? "2" :
                                bi.e36q0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36q0fqx", bi.e36q0fqx.getText().toString());
        json.put("e36r0a",
                bi.e36r0ay.isChecked() ? "1" :
                        bi.e36r0an.isChecked() ? "2" :
                                bi.e36r0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e36r0aqx", bi.e36r0aqx.getText().toString());
        json.put("e36r0f",
                bi.e36r0fy.isChecked() ? "1" :
                        bi.e36r0fn.isChecked() ? "2" :
                                bi.e36r0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e36r0fqx", bi.e36r0fqx.getText().toString());
        json.put("e37",
                bi.e37a.isChecked() ? "1" :
                        bi.e37b.isChecked() ? "2" :
                                "-1");
        json.put("e38",
                bi.e38a.isChecked() ? "1" :
                        bi.e38b.isChecked() ? "2" :
                                "-1");
        json.put("e41",
                bi.e41a.isChecked() ? "1" :
                        bi.e41b.isChecked() ? "2" :
                                "-1");
        json.put("e42",
                bi.e42a.isChecked() ? "1" :
                        bi.e42b.isChecked() ? "2" :
                                "-1");
        json.put("e43",
                "-1");
        json.put("e43a",
                bi.e43aa.isChecked() ? "1" :
                        bi.e43ab.isChecked() ? "2" :
                                bi.e43ac.isChecked() ? "3" :
                                        bi.e43ad.isChecked() ? "4" :
                                                "-1");
        json.put("e43b",
                bi.e43ba.isChecked() ? "1" :
                        bi.e43bb.isChecked() ? "2" :
                                bi.e43bc.isChecked() ? "3" :
                                        bi.e43bd.isChecked() ? "4" :
                                                "-1");
        json.put("e43c",
                bi.e43ca.isChecked() ? "1" :
                        bi.e43cb.isChecked() ? "2" :
                                bi.e43cc.isChecked() ? "3" :
                                        bi.e43cd.isChecked() ? "4" :
                                                "-1");
        json.put("e44",
                bi.e44a.isChecked() ? "1" :
                        bi.e44b.isChecked() ? "2" :
                                bi.e44c.isChecked() ? "3" :
                                        bi.e44d.isChecked() ? "4" :
                                                "-1");
        json.put("e45",
                bi.e45a.isChecked() ? "1" :
                        bi.e45b.isChecked() ? "2" :
                                bi.e45c.isChecked() ? "3" :
                                        bi.e45d.isChecked() ? "4" :
                                                "-1");
        json.put("e46",
                bi.e46a.isChecked() ? "1" :
                        bi.e46b.isChecked() ? "2" :
                                bi.e46c.isChecked() ? "3" :
                                        "-1");
        json.put("e47",
                "-1");
        json.put("e47a",
                bi.e47aa.isChecked() ? "1" :
                        bi.e47ab.isChecked() ? "2" :
                                bi.e47ac.isChecked() ? "3" :
                                        "-1");
        json.put("e47b",
                bi.e47ba.isChecked() ? "1" :
                        bi.e47bb.isChecked() ? "2" :
                                bi.e47bc.isChecked() ? "3" :
                                        "-1");
        json.put("e47c",
                bi.e47ca.isChecked() ? "1" :
                        bi.e47cb.isChecked() ? "2" :
                                bi.e47cc.isChecked() ? "3" :
                                        "-1");
        json.put("e47d",
                bi.e47da.isChecked() ? "1" :
                        bi.e47db.isChecked() ? "2" :
                                bi.e47dc.isChecked() ? "3" :
                                        "-1");
        json.put("e48",
                bi.e48a.isChecked() ? "1" :
                        bi.e48b.isChecked() ? "2" :
                                bi.e48c.isChecked() ? "3" :
                                        bi.e48d.isChecked() ? "4" :
                                                "-1");
        //json.put("e49", bi.e49.getText().toString());
        json.put("e410",
                "-1");
        json.put("e410a",
                bi.e410aa.isChecked() ? "1" :
                        bi.e410ab.isChecked() ? "2" :
                                bi.e410ac.isChecked() ? "3" :
                                        "-1");
        json.put("e410b",
                bi.e410ba.isChecked() ? "1" :
                        bi.e410bb.isChecked() ? "2" :
                                bi.e410bc.isChecked() ? "3" :
                                        "-1");
        json.put("e410c",
                bi.e410ca.isChecked() ? "1" :
                        bi.e410cb.isChecked() ? "2" :
                                bi.e410cc.isChecked() ? "3" :
                                        "-1");
        json.put("e410d",
                bi.e410da.isChecked() ? "1" :
                        bi.e410db.isChecked() ? "2" :
                                bi.e410dc.isChecked() ? "3" :
                                        "-1");
        json.put("e410e",
                bi.e410ea.isChecked() ? "1" :
                        bi.e410eb.isChecked() ? "2" :
                                bi.e410ec.isChecked() ? "3" :
                                        "-1");
        json.put("e410f",
                bi.e410fa.isChecked() ? "1" :
                        bi.e410fb.isChecked() ? "2" :
                                bi.e410fc.isChecked() ? "3" :
                                        "-1");
        json.put("e411",
                bi.e411a.isChecked() ? "1" :
                        bi.e411b.isChecked() ? "2" :
                                bi.e411c.isChecked() ? "3" :
                                        bi.e411d.isChecked() ? "4" :
                                                "-1");
        json.put("e412",
                bi.e412a.isChecked() ? "1" :
                        bi.e412b.isChecked() ? "2" :
                                bi.e412c.isChecked() ? "3" :
                                        bi.e412d.isChecked() ? "4" :
                                                "-1");
        json.put("e413",
                bi.e413a.isChecked() ? "1" :
                        bi.e413b.isChecked() ? "2" :
                                "-1");
        json.put("e414",
                bi.e414a.isChecked() ? "1" :
                        bi.e414b.isChecked() ? "2" :
                                bi.e414c.isChecked() ? "3" :
                                        "-1");
        json.put("e415",
                bi.e415a.isChecked() ? "1" :
                        bi.e415b.isChecked() ? "2" :
                                bi.e415c.isChecked() ? "3" :
                                        "-1");
        json.put("e416",
                bi.e416a.isChecked() ? "1" :
                        bi.e416b.isChecked() ? "2" :
                                bi.e416c.isChecked() ? "3" :
                                        bi.e416d.isChecked() ? "4" :
                                                "-1");
        json.put("e51",
                bi.e51a.isChecked() ? "1" :
                        bi.e51b.isChecked() ? "2" :
                                "-1");
        json.put("e52",
                "-1");
        json.put("e52a",
                bi.e52aa.isChecked() ? "1" :
                        bi.e52ab.isChecked() ? "2" :
                                "-1");
        json.put("e52b",
                bi.e52ba.isChecked() ? "1" :
                        bi.e52bb.isChecked() ? "2" :
                                "-1");
        json.put("e52c",
                bi.e52ca.isChecked() ? "1" :
                        bi.e52cb.isChecked() ? "2" :
                                "-1");
        json.put("e52d",
                bi.e52da.isChecked() ? "1" :
                        bi.e52db.isChecked() ? "2" :
                                "-1");
        json.put("e52e",
                bi.e52ea.isChecked() ? "1" :
                        bi.e52eb.isChecked() ? "2" :
                                "-1");
        json.put("e52f",
                bi.e52fa.isChecked() ? "1" :
                        bi.e52fb.isChecked() ? "2" :
                                "-1");
        json.put("e52g",
                bi.e52ga.isChecked() ? "1" :
                        bi.e52gb.isChecked() ? "2" :
                                "-1");
        json.put("e52h",
                bi.e52ha.isChecked() ? "1" :
                        bi.e52hb.isChecked() ? "2" :
                                "-1");
        json.put("e52i",
                bi.e52ia.isChecked() ? "1" :
                        bi.e52ib.isChecked() ? "2" :
                                "-1");
        json.put("e53",
                bi.e53a.isChecked() ? "1" :
                        bi.e53b.isChecked() ? "2" :
                                bi.e53c.isChecked() ? "3" :
                                        "-1");
        json.put("e54",
                bi.e54a.isChecked() ? "1" :
                        bi.e54b.isChecked() ? "2" :
                                "-1");
        json.put("e55",
                bi.e55a.isChecked() ? "1" :
                        bi.e55b.isChecked() ? "2" :
                                bi.e55c.isChecked() ? "3" :
                                        "-1");
        json.put("e56",
                bi.e56a.isChecked() ? "1" :
                        bi.e56b.isChecked() ? "2" :
                                "-1");
        json.put("e57",
                bi.e57a.isChecked() ? "1" :
                        bi.e57b.isChecked() ? "2" :
                                "-1");
        json.put("e58",
                bi.e58a.isChecked() ? "1" :
                        bi.e58b.isChecked() ? "2" :
                                "-1");
        json.put("e59",
                bi.e59a.isChecked() ? "1" :
                        bi.e59b.isChecked() ? "2" :
                                "-1");
        json.put("e61",
                bi.e61a.isChecked() ? "1" :
                        bi.e61b.isChecked() ? "2" :
                                "-1");
        json.put("e62",
                bi.e62a.isChecked() ? "1" :
                        bi.e62b.isChecked() ? "2" :
                                "-1");
        json.put("e63",
                bi.e63a.isChecked() ? "1" :
                        bi.e63b.isChecked() ? "2" :
                                "-1");
        json.put("e64",
                bi.e64a.isChecked() ? "1" :
                        bi.e64b.isChecked() ? "2" :
                                "-1");
        json.put("e65",
                "-1");
        json.put("e65a",
                bi.e65aa.isChecked() ? "1" :
                        bi.e65ab.isChecked() ? "2" :
                                bi.e65ac.isChecked() ? "3" :
                                        bi.e65ad.isChecked() ? "4" :
                                                "-1");
        json.put("e65b",
                bi.e65ba.isChecked() ? "1" :
                        bi.e65bb.isChecked() ? "2" :
                                bi.e65bc.isChecked() ? "3" :
                                        bi.e65bd.isChecked() ? "4" :
                                                "-1");
        json.put("e65c",
                bi.e65ca.isChecked() ? "1" :
                        bi.e65cb.isChecked() ? "2" :
                                bi.e65cc.isChecked() ? "3" :
                                        bi.e65cd.isChecked() ? "4" :
                                                "-1");
        json.put("e65d",
                bi.e65da.isChecked() ? "1" :
                        bi.e65db.isChecked() ? "2" :
                                bi.e65dc.isChecked() ? "3" :
                                        bi.e65dd.isChecked() ? "4" :
                                                "-1");
        json.put("e66",
                bi.e66a.isChecked() ? "1" :
                        bi.e66b.isChecked() ? "2" :
                                bi.e66c.isChecked() ? "3" :
                                        bi.e66d.isChecked() ? "4" :
                                                "-1");
        json.put("e67",
                bi.e67a.isChecked() ? "1" :
                        bi.e67b.isChecked() ? "2" :
                                bi.e67c.isChecked() ? "3" :
                                        "-1");
        json.put("e68",
                bi.e68a.isChecked() ? "1" :
                        bi.e68b.isChecked() ? "2" :
                                bi.e68c.isChecked() ? "3" :
                                        "-1");
        json.put("e69",
                bi.e69a.isChecked() ? "1" :
                        bi.e69b.isChecked() ? "2" :
                                bi.e69c.isChecked() ? "3" :
                                        bi.e69d.isChecked() ? "4" :
                                                "-1");
        json.put("e610",
                bi.e610a.isChecked() ? "1" :
                        bi.e610b.isChecked() ? "2" :
                                bi.e610c.isChecked() ? "3" :
                                        "-1");
        json.put("e611",
                bi.e611a.isChecked() ? "1" :
                        bi.e611b.isChecked() ? "2" :
                                "-1");
        json.put("e71",
                bi.e71a.isChecked() ? "1" :
                        bi.e71b.isChecked() ? "2" :
                                "-1");
        json.put("e72",
                "-1");
        json.put("e72a",
                bi.e72aa.isChecked() ? "1" :
                        bi.e72ab.isChecked() ? "2" :
                                "-1");
        json.put("e72b",
                bi.e72ba.isChecked() ? "1" :
                        bi.e72bb.isChecked() ? "2" :
                                "-1");
        json.put("e72c",
                bi.e72ca.isChecked() ? "1" :
                        bi.e72cb.isChecked() ? "2" :
                                "-1");
        json.put("e72d",
                bi.e72da.isChecked() ? "1" :
                        bi.e72db.isChecked() ? "2" :
                                "-1");
        json.put("e72e",
                bi.e72ea.isChecked() ? "1" :
                        bi.e72eb.isChecked() ? "2" :
                                "-1");
        json.put("e72f",
                bi.e72fa.isChecked() ? "1" :
                        bi.e72fb.isChecked() ? "2" :
                                "-1");
        json.put("e72g",
                bi.e72ga.isChecked() ? "1" :
                        bi.e72gb.isChecked() ? "2" :
                                "-1");
        json.put("e72h",
                bi.e72ha.isChecked() ? "1" :
                        bi.e72hb.isChecked() ? "2" :
                                "-1");
        json.put("e72i",
                bi.e72ia.isChecked() ? "1" :
                        bi.e72ib.isChecked() ? "2" :
                                "-1");
        json.put("e72j",
                bi.e72ja.isChecked() ? "1" :
                        bi.e72jb.isChecked() ? "2" :
                                "-1");
        json.put("e72k",
                bi.e72ka.isChecked() ? "1" :
                        bi.e72kb.isChecked() ? "2" :
                                "-1");
        json.put("e72l",
                bi.e72la.isChecked() ? "1" :
                        bi.e72lb.isChecked() ? "2" :
                                "-1");
        json.put("e73",
                "-1");
        json.put("e73a",
                bi.e73aa.isChecked() ? "1" :
                        bi.e73ab.isChecked() ? "2" :
                                bi.e73ac.isChecked() ? "3" :
                                        "-1");
        json.put("e73b",
                bi.e73ba.isChecked() ? "1" :
                        bi.e73bb.isChecked() ? "2" :
                                bi.e73bc.isChecked() ? "3" :
                                        "-1");
        json.put("e73c",
                bi.e73ca.isChecked() ? "1" :
                        bi.e73cb.isChecked() ? "2" :
                                bi.e73cc.isChecked() ? "3" :
                                        "-1");
        json.put("e73d",
                bi.e73da.isChecked() ? "1" :
                        bi.e73db.isChecked() ? "2" :
                                bi.e73dc.isChecked() ? "3" :
                                        "-1");
        json.put("e74",
                "-1");
        json.put("e74a",
                bi.e74aa.isChecked() ? "1" :
                        bi.e74ab.isChecked() ? "2" :
                                "-1");
        json.put("e74b",
                bi.e74ba.isChecked() ? "1" :
                        bi.e74bb.isChecked() ? "2" :
                                "-1");
        json.put("e74c",
                bi.e74ca.isChecked() ? "1" :
                        bi.e74cb.isChecked() ? "2" :
                                "-1");
        json.put("e74d",
                bi.e74da.isChecked() ? "1" :
                        bi.e74db.isChecked() ? "2" :
                                "-1");
        json.put("e74e", bi.e74e.getText().toString());
        json.put("e74f",
                bi.e74fa.isChecked() ? "1" :
                        bi.e74fb.isChecked() ? "2" :
                                bi.e74fc.isChecked() ? "3" :
                                        bi.e74fd.isChecked() ? "4" :
                                                "-1");
        //json.put("e74g", bi.e74g.getText().toString());
        json.put("e75",
                "-1");
        json.put("e75a0a",
                bi.e75a0ay.isChecked() ? "1" :
                        bi.e75a0an.isChecked() ? "2" :
                                bi.e75a0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e75a0aqx", bi.e75a0aqx.getText().toString());
        json.put("e75a0f",
                bi.e75a0fy.isChecked() ? "1" :
                        bi.e75a0fn.isChecked() ? "2" :
                                bi.e75a0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e75a0fqx", bi.e75a0fqx.getText().toString());
        json.put("e75b0a",
                bi.e75b0ay.isChecked() ? "1" :
                        bi.e75b0an.isChecked() ? "2" :
                                bi.e75b0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e75b0aqx", bi.e75b0aqx.getText().toString());
        json.put("e75b0f",
                bi.e75b0fy.isChecked() ? "1" :
                        bi.e75b0fn.isChecked() ? "2" :
                                bi.e75b0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e75b0fqx", bi.e75b0fqx.getText().toString());
        json.put("e75c0a",
                bi.e75c0ay.isChecked() ? "1" :
                        bi.e75c0an.isChecked() ? "2" :
                                bi.e75c0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e75c0aqx", bi.e75c0aqx.getText().toString());
        json.put("e75c0f",
                bi.e75c0fy.isChecked() ? "1" :
                        bi.e75c0fn.isChecked() ? "2" :
                                bi.e75c0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e75c0fqx", bi.e75c0fqx.getText().toString());
        json.put("e75d0a",
                bi.e75d0ay.isChecked() ? "1" :
                        bi.e75d0an.isChecked() ? "2" :
                                bi.e75d0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e75d0aqx", bi.e75d0aqx.getText().toString());
        json.put("e75d0f",
                bi.e75d0fy.isChecked() ? "1" :
                        bi.e75d0fn.isChecked() ? "2" :
                                bi.e75d0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e75d0fqx", bi.e75d0fqx.getText().toString());
        json.put("e75e0a",
                bi.e75e0ay.isChecked() ? "1" :
                        bi.e75e0an.isChecked() ? "2" :
                                bi.e75e0aq.isChecked() ? "3" :
                                        "-1");
        json.put("e75e0aqx", bi.e75e0aqx.getText().toString());
        json.put("e75e0f",
                bi.e75e0fy.isChecked() ? "1" :
                        bi.e75e0fn.isChecked() ? "2" :
                                bi.e75e0fq.isChecked() ? "3" :
                                        "-1");
        json.put("e75e0fqx", bi.e75e0fqx.getText().toString());
        json.put("e81",
                bi.e81a.isChecked() ? "1" :
                        bi.e81b.isChecked() ? "2" :
                                "-1");
        json.put("e82",
                bi.e82a.isChecked() ? "1" :
                        bi.e82b.isChecked() ? "2" :
                                "-1");
        json.put("e83",
                bi.e83a.isChecked() ? "1" :
                        bi.e83b.isChecked() ? "2" :
                                "-1");
        json.put("e84",
                bi.e84a.isChecked() ? "1" :
                        bi.e84b.isChecked() ? "2" :
                                "-1");
        json.put("e85",
                bi.e85a.isChecked() ? "1" :
                        bi.e85b.isChecked() ? "2" :
                                "-1");
        json.put("e86",
                bi.e86a.isChecked() ? "1" :
                        bi.e86b.isChecked() ? "2" :
                                "-1");
        json.put("e87",
                bi.e87a.isChecked() ? "1" :
                        bi.e87b.isChecked() ? "2" :
                                "-1");
        json.put("e88",
                bi.e88a.isChecked() ? "1" :
                        bi.e88b.isChecked() ? "2" :
                                "-1");
        json.put("e89",
                bi.e89a.isChecked() ? "1" :
                        bi.e89b.isChecked() ? "2" :
                                "-1");
        json.put("e810",
                bi.e810a.isChecked() ? "1" :
                        bi.e810b.isChecked() ? "2" :
                                "-1");
        json.put("e811",
                bi.e811a.isChecked() ? "1" :
                        bi.e811b.isChecked() ? "2" :
                                "-1");
        json.put("e812",
                bi.e812a.isChecked() ? "1" :
                        bi.e812b.isChecked() ? "2" :
                                "-1");
        json.put("e813",
                bi.e813a.isChecked() ? "1" :
                        bi.e813b.isChecked() ? "2" :
                                "-1");
        json.put("e814",
                bi.e814a.isChecked() ? "1" :
                        bi.e814b.isChecked() ? "2" :
                                "-1");

        child.setsCC(String.valueOf(json));
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
                startActivity(new Intent(this, SectionFActivity.class).putExtra(IM02FLAG, !im02Flag));

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
