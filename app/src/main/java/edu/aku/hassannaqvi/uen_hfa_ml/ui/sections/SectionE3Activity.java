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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE3Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.CONSTANTS.IM02FLAG;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionE3Activity extends AppCompatActivity {

    ActivitySectionE3Binding bi;
    boolean im02Flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e3);
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
        json.put("e0301", bi.e0301a.isChecked() ? "1"
                : bi.e0301b.isChecked() ? "2"
                : "-1");

        json.put("e0302", "-1");

        json.put("e0302a", bi.e0302aa.isChecked() ? "1"
                : bi.e0302ab.isChecked() ? "2"
                : "-1");

        json.put("e0302b", bi.e0302ba.isChecked() ? "1"
                : bi.e0302bb.isChecked() ? "2"
                : "-1");

        json.put("e0302c", bi.e0302ca.isChecked() ? "1"
                : bi.e0302cb.isChecked() ? "2"
                : "-1");

        json.put("e0302d", bi.e0302da.isChecked() ? "1"
                : bi.e0302db.isChecked() ? "2"
                : "-1");

        json.put("e0302e", bi.e0302ea.isChecked() ? "1"
                : bi.e0302eb.isChecked() ? "2"
                : "-1");

        json.put("e0303", "-1");

        json.put("e0303a", bi.e0303aa.isChecked() ? "1"
                : bi.e0303ab.isChecked() ? "2"
                : "-1");

        json.put("e0303b", bi.e0303ba.isChecked() ? "1"
                : bi.e0303bb.isChecked() ? "2"
                : "-1");

        json.put("e0303c", bi.e0303ca.isChecked() ? "1"
                : bi.e0303cb.isChecked() ? "2"
                : "-1");

        json.put("e0303d", bi.e0303da.isChecked() ? "1"
                : bi.e0303db.isChecked() ? "2"
                : "-1");

        json.put("e0303e", bi.e0303ea.isChecked() ? "1"
                : bi.e0303eb.isChecked() ? "2"
                : "-1");

        json.put("e0303f", bi.e0303fa.isChecked() ? "1"
                : bi.e0303fb.isChecked() ? "2"
                : "-1");

        json.put("e0303g", bi.e0303ga.isChecked() ? "1"
                : bi.e0303gb.isChecked() ? "2"
                : "-1");

        json.put("e0303h", bi.e0303ha.isChecked() ? "1"
                : bi.e0303hb.isChecked() ? "2"
                : "-1");

        json.put("e0303i", bi.e0303ia.isChecked() ? "1"
                : bi.e0303ib.isChecked() ? "2"
                : "-1");

        json.put("e0303j", bi.e0303ja.isChecked() ? "1"
                : bi.e0303jb.isChecked() ? "2"
                : "-1");

        json.put("e0303k", bi.e0303ka.isChecked() ? "1"
                : bi.e0303kb.isChecked() ? "2"
                : "-1");

        json.put("e0303l", bi.e0303la.isChecked() ? "1"
                : bi.e0303lb.isChecked() ? "2"
                : "-1");

        json.put("e0303m", bi.e0303ma.isChecked() ? "1"
                : bi.e0303mb.isChecked() ? "2"
                : "-1");

        json.put("e0303n", bi.e0303na.isChecked() ? "1"
                : bi.e0303nb.isChecked() ? "2"
                : "-1");

        json.put("e0304", "-1");

        json.put("e0304a", bi.e0304aa.isChecked() ? "1"
                : bi.e0304ab.isChecked() ? "2"
                : bi.e0304ac.isChecked() ? "3"
                : "-1");

        json.put("e0304b", bi.e0304ba.isChecked() ? "1"
                : bi.e0304bb.isChecked() ? "2"
                : bi.e0304bc.isChecked() ? "3"
                : "-1");

        json.put("e0304c", bi.e0304ca.isChecked() ? "1"
                : bi.e0304cb.isChecked() ? "2"
                : bi.e0304cc.isChecked() ? "3"
                : "-1");

        json.put("e0304d", bi.e0304da.isChecked() ? "1"
                : bi.e0304db.isChecked() ? "2"
                : bi.e0304dc.isChecked() ? "3"
                : "-1");

        json.put("e0305", "-1");

        json.put("e0305a", bi.e0305aa.isChecked() ? "1"
                : bi.e0305ab.isChecked() ? "2"
                : bi.e0305ac.isChecked() ? "3"
                : "-1");

        json.put("e0305b", bi.e0305ba.isChecked() ? "1"
                : bi.e0305bb.isChecked() ? "2"
                : bi.e0305bc.isChecked() ? "3"
                : "-1");

        json.put("e0305c", bi.e0305ca.isChecked() ? "1"
                : bi.e0305cb.isChecked() ? "2"
                : bi.e0305cc.isChecked() ? "3"
                : "-1");

        json.put("e0305d", bi.e0305da.isChecked() ? "1"
                : bi.e0305db.isChecked() ? "2"
                : bi.e0305dc.isChecked() ? "3"
                : bi.e0305dd.isChecked() ? "4"
                : "-1");

        json.put("e0305e", bi.e0305ea.isChecked() ? "1"
                : bi.e0305ex.isChecked() ? "96"
                : "-1");

        //json.put("e0306", "-1");

        /*json.put("e0306a0a", bi.e0306a0ay.isChecked() ? "1"
                : bi.e0306a0an.isChecked() ? "2"
                : bi.e0306a0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306a0aqx", bi.e0306a0aqx.getText().toString());
        json.put("e0306a0f", bi.e0306a0fy.isChecked() ? "1"
                : bi.e0306a0fn.isChecked() ? "2"
                : bi.e0306a0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306a0fqx", bi.e0306a0fqx.getText().toString());
        json.put("e0306b0a", bi.e0306b0ay.isChecked() ? "1"
                : bi.e0306b0an.isChecked() ? "2"
                : bi.e0306b0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306b0aqx", bi.e0306b0aqx.getText().toString());
        json.put("e0306b0f", bi.e0306b0fy.isChecked() ? "1"
                : bi.e0306b0fn.isChecked() ? "2"
                : bi.e0306b0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306b0fqx", bi.e0306b0fqx.getText().toString());
        json.put("e0306c0a", bi.e0306c0ay.isChecked() ? "1"
                : bi.e0306c0an.isChecked() ? "2"
                : bi.e0306c0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306c0aqx", bi.e0306c0aqx.getText().toString());
        json.put("e0306c0f", bi.e0306c0fy.isChecked() ? "1"
                : bi.e0306c0fn.isChecked() ? "2"
                : bi.e0306c0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306c0fqx", bi.e0306c0fqx.getText().toString());
        json.put("e0306d0a", bi.e0306d0ay.isChecked() ? "1"
                : bi.e0306d0an.isChecked() ? "2"
                : bi.e0306d0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306d0aqx", bi.e0306d0aqx.getText().toString());
        json.put("e0306d0f", bi.e0306d0fy.isChecked() ? "1"
                : bi.e0306d0fn.isChecked() ? "2"
                : bi.e0306d0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306d0fqx", bi.e0306d0fqx.getText().toString());
        json.put("e0306e0a", bi.e0306e0ay.isChecked() ? "1"
                : bi.e0306e0an.isChecked() ? "2"
                : bi.e0306e0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306e0aqx", bi.e0306e0aqx.getText().toString());
        json.put("e0306e0f", bi.e0306e0fy.isChecked() ? "1"
                : bi.e0306e0fn.isChecked() ? "2"
                : bi.e0306e0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306e0fqx", bi.e0306e0fqx.getText().toString());
        json.put("e0306f0a", bi.e0306f0ay.isChecked() ? "1"
                : bi.e0306f0an.isChecked() ? "2"
                : bi.e0306f0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306f0aqx", bi.e0306f0aqx.getText().toString());
        json.put("e0306f0f", bi.e0306f0fy.isChecked() ? "1"
                : bi.e0306f0fn.isChecked() ? "2"
                : bi.e0306f0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306f0fqx", bi.e0306f0fqx.getText().toString());
        json.put("e0306g0a", bi.e0306g0ay.isChecked() ? "1"
                : bi.e0306g0an.isChecked() ? "2"
                : bi.e0306g0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306g0aqx", bi.e0306g0aqx.getText().toString());
        json.put("e0306g0f", bi.e0306g0fy.isChecked() ? "1"
                : bi.e0306g0fn.isChecked() ? "2"
                : bi.e0306g0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306g0fqx", bi.e0306g0fqx.getText().toString());
        json.put("e0306h0a", bi.e0306h0ay.isChecked() ? "1"
                : bi.e0306h0an.isChecked() ? "2"
                : bi.e0306h0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306h0aqx", bi.e0306h0aqx.getText().toString());
        json.put("e0306h0f", bi.e0306h0fy.isChecked() ? "1"
                : bi.e0306h0fn.isChecked() ? "2"
                : bi.e0306h0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306h0fqx", bi.e0306h0fqx.getText().toString());
        json.put("e0306i0a", bi.e0306i0ay.isChecked() ? "1"
                : bi.e0306i0an.isChecked() ? "2"
                : bi.e0306i0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306i0aqx", bi.e0306i0aqx.getText().toString());
        json.put("e0306i0f", bi.e0306i0fy.isChecked() ? "1"
                : bi.e0306i0fn.isChecked() ? "2"
                : bi.e0306i0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306i0fqx", bi.e0306i0fqx.getText().toString());
        json.put("e0306j0a", bi.e0306j0ay.isChecked() ? "1"
                : bi.e0306j0an.isChecked() ? "2"
                : bi.e0306j0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306j0aqx", bi.e0306j0aqx.getText().toString());
        json.put("e0306j0f", bi.e0306j0fy.isChecked() ? "1"
                : bi.e0306j0fn.isChecked() ? "2"
                : bi.e0306j0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306j0fqx", bi.e0306j0fqx.getText().toString());
        json.put("e0306k0a", bi.e0306k0ay.isChecked() ? "1"
                : bi.e0306k0an.isChecked() ? "2"
                : bi.e0306k0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306k0aqx", bi.e0306k0aqx.getText().toString());
        json.put("e0306k0f", bi.e0306k0fy.isChecked() ? "1"
                : bi.e0306k0fn.isChecked() ? "2"
                : bi.e0306k0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306k0fqx", bi.e0306k0fqx.getText().toString());
        json.put("e0306l0a", bi.e0306l0ay.isChecked() ? "1"
                : bi.e0306l0an.isChecked() ? "2"
                : bi.e0306l0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306l0aqx", bi.e0306l0aqx.getText().toString());
        json.put("e0306l0f", bi.e0306l0fy.isChecked() ? "1"
                : bi.e0306l0fn.isChecked() ? "2"
                : bi.e0306l0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306l0fqx", bi.e0306l0fqx.getText().toString());
        json.put("e0306m0a", bi.e0306m0ay.isChecked() ? "1"
                : bi.e0306m0an.isChecked() ? "2"
                : bi.e0306m0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306m0aqx", bi.e0306m0aqx.getText().toString());
        json.put("e0306m0f", bi.e0306m0fy.isChecked() ? "1"
                : bi.e0306m0fn.isChecked() ? "2"
                : bi.e0306m0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306m0fqx", bi.e0306m0fqx.getText().toString());
        json.put("e0306n0a", bi.e0306n0ay.isChecked() ? "1"
                : bi.e0306n0an.isChecked() ? "2"
                : bi.e0306n0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306n0aqx", bi.e0306n0aqx.getText().toString());
        json.put("e0306n0f", bi.e0306n0fy.isChecked() ? "1"
                : bi.e0306n0fn.isChecked() ? "2"
                : bi.e0306n0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306n0fqx", bi.e0306n0fqx.getText().toString());
        json.put("e0306o0a", bi.e0306o0ay.isChecked() ? "1"
                : bi.e0306o0an.isChecked() ? "2"
                : bi.e0306o0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306o0aqx", bi.e0306o0aqx.getText().toString());
        json.put("e0306o0f", bi.e0306o0fy.isChecked() ? "1"
                : bi.e0306o0fn.isChecked() ? "2"
                : bi.e0306o0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306o0fqx", bi.e0306o0fqx.getText().toString());
        json.put("e0306p0a", bi.e0306p0ay.isChecked() ? "1"
                : bi.e0306p0an.isChecked() ? "2"
                : bi.e0306p0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306p0aqx", bi.e0306p0aqx.getText().toString());
        json.put("e0306p0f", bi.e0306p0fy.isChecked() ? "1"
                : bi.e0306p0fn.isChecked() ? "2"
                : bi.e0306p0fq.isChecked() ? "3"
                : "-1");

        json.put("e0306p0fqx", bi.e0306p0fqx.getText().toString());
        json.put("e0306q0a", bi.e0306q0ay.isChecked() ? "1"
                : bi.e0306q0an.isChecked() ? "2"
                : bi.e0306q0aq.isChecked() ? "3"
                : "-1");

        json.put("e0306q0aqx", bi.e0306q0aqx.getText().toString());
        json.put("e0306q0f", bi.e0306q0fy.isChecked() ? "1"
                : bi.e0306q0fn.isChecked() ? "2"
                : bi.e0306q0fq.isChecked() ? "3"
                : "-1");
        json.put("e0306q0fqx", bi.e0306q0fqx.getText().toString());

        json.put("e0306r0a", bi.e0306r0ay.isChecked() ? "1"
                : bi.e0306r0an.isChecked() ? "2"
                : bi.e0306r0aq.isChecked() ? "3"
                : "-1");
        json.put("e0306r0aqx", bi.e0306r0aqx.getText().toString());*/

        /*json.put("e0306r0f", bi.e0306r0fy.isChecked() ? "1"
                : bi.e0306r0fn.isChecked() ? "2"
                : bi.e0306r0fq.isChecked() ? "3"
                : "-1");
        json.put("e0306r0fqx", bi.e0306r0fqx.getText().toString());*/

        /*json.put("e0307", bi.e0307a.isChecked() ? "1"
                : bi.e0307b.isChecked() ? "2"
                : "-1");*/

        /*json.put("e0308", bi.e0308a.isChecked() ? "1"
                : bi.e0308b.isChecked() ? "2"
                : "-1");*/

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
                startActivity(new Intent(this, SectionE4Activity.class).putExtra(IM02FLAG, !im02Flag));

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
