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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionCBinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openChildEndActivity;

public class SectionCActivity extends AppCompatActivity {

    ActivitySectionCBinding bi;
    int position;
    FamilyMembersContract selMWRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c);
        bi.setCallback(this);

        setTitle(R.string.sectionctitle);
        setupListeners();
    }

    private void setupListeners() {

        /*bi.uf14.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.uf14a.getId()) {
                Clear.clearAllFields(bi.fldGrpCVuf15, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVuf15, true);
            }
        }));

        List<String> childrenLst = new ArrayList<String>() {
            {
                add("....");
                addAll(MainApp.selectedChildren.getSecond());
            }
        };

        bi.uf09.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, childrenLst));

        bi.uf09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                if (i == 0) return;
                selMWRA = mainVModel.getMemberInfo(MainApp.selectedChildren.getFirst().get(bi.uf09.getSelectedItemPosition() - 1));
                bi.uf09a.setText(new StringBuilder("Mother name:").append(selMWRA.getMotherName()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });*/

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        long updcount = db.addChild(child);
        child.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            child.setUID(MainApp.deviceId + child.get_ID());
            db.updatesChildColumn(ChildContract.SingleChild.COLUMN_UID, child.getUID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        child = new ChildContract();
        child.set_UUID(MainApp.fc.get_UID());
        child.setDeviceId(MainApp.appInfo.getDeviceID());
        child.setDevicetagID(MainApp.appInfo.getTagName());
        child.setFormDate(MainApp.fc.getFormDate());
        child.setUser(MainApp.userName);

        JSONObject json = new JSONObject();
        //json.put("c1a", bi.c1a.getText().toString());
        json.put("c1aa", bi.c1aa.getText().toString());
        json.put("c1ab", bi.c1ab.getText().toString());
        json.put("c1ac", bi.c1ac.getText().toString());
        json.put("cad", bi.cad.getText().toString());
        json.put("c1ae", bi.c1ae.getText().toString());
        json.put("c1ba", bi.c1ba.getText().toString());
        json.put("c1bb", bi.c1bb.getText().toString());
        json.put("c1bc", bi.c1bc.getText().toString());
        json.put("c1bd", bi.c1bd.getText().toString());
        json.put("c1be", bi.c1be.getText().toString());
        //json.put("c1c", bi.c1c.getText().toString());
        json.put("c1ca", bi.c1ca.getText().toString());
        json.put("c1cb", bi.c1cb.getText().toString());
        json.put("c1cc", bi.c1cc.getText().toString());
        json.put("c1cd", bi.c1cd.getText().toString());
        json.put("c1ce", bi.c1ce.getText().toString());
        //json.put("c1d", bi.c1d.getText().toString());
        json.put("c1da", bi.c1da.getText().toString());
        json.put("c1db", bi.c1db.getText().toString());
        json.put("c1dc", bi.c1dc.getText().toString());
        json.put("c1dd", bi.c1dd.getText().toString());
        json.put("c1de", bi.c1de.getText().toString());
        //json.put("c1e", bi.c1e.getText().toString());
        json.put("c1ea", bi.c1ea.getText().toString());
        json.put("c1eb", bi.c1eb.getText().toString());
        json.put("c1ec", bi.c1ec.getText().toString());
        json.put("c1ed", bi.c1ed.getText().toString());
        json.put("c1ee", bi.c1ee.getText().toString());
        //json.put("c1f", bi.c1f.getText().toString());
        json.put("c1fa", bi.c1fa.getText().toString());
        json.put("c1fb", bi.c1fb.getText().toString());
        json.put("c1fc", bi.c1fc.getText().toString());
        json.put("c1fd", bi.c1fd.getText().toString());
        json.put("c1fe", bi.c1fe.getText().toString());
        //json.put("c1g", bi.c1g.getText().toString());
        json.put("c1ga", bi.c1ga.getText().toString());
        json.put("c1gb", bi.c1gb.getText().toString());
        json.put("c1gc", bi.c1gc.getText().toString());
        json.put("c1gd", bi.c1gd.getText().toString());
        json.put("c1ge", bi.c1ge.getText().toString());
        //json.put("c1h", bi.c1h.getText().toString());
        json.put("c1ha", bi.c1ha.getText().toString());
        json.put("c1hb", bi.c1hb.getText().toString());
        json.put("c1hc", bi.c1hc.getText().toString());
        json.put("c1hd", bi.c1hd.getText().toString());
        json.put("c1he", bi.c1he.getText().toString());
        //json.put("c1i", bi.c1i.getText().toString());
        json.put("c1ia", bi.c1ia.getText().toString());
        json.put("c1ib", bi.c1ib.getText().toString());
        json.put("c1ic", bi.c1ic.getText().toString());
        json.put("c1id", bi.c1id.getText().toString());
        json.put("c1ie", bi.c1ie.getText().toString());
        //json.put("c1j", bi.c1j.getText().toString());
        json.put("c1ja", bi.c1ja.getText().toString());
        json.put("c1jb", bi.c1jb.getText().toString());
        json.put("c1jc", bi.c1jc.getText().toString());
        json.put("c1jd", bi.c1jd.getText().toString());
        json.put("c1je", bi.c1je.getText().toString());
        //json.put("c1k", bi.c1k.getText().toString());
        json.put("c1ka", bi.c1ka.getText().toString());
        json.put("c1kb", bi.c1kb.getText().toString());
        json.put("c1kc", bi.c1kc.getText().toString());
        json.put("c1kd", bi.c1kd.getText().toString());
        json.put("c1ke", bi.c1ke.getText().toString());
        //json.put("c2", bi.c2.getText().toString());
        json.put("c2a", bi.c2a.getText().toString());
        json.put("c2b",
                bi.c2ba.isChecked() ? "1" :
                        bi.c2bb.isChecked() ? "2" :
                                "0");
        //json.put("c2c", bi.c2c.getText().toString());
        json.put("c2ca", bi.c2ca.getText().toString());
        json.put("c2cb", bi.c2cb.getText().toString());
        json.put("c3",
                bi.c3a.isChecked() ? "1" :
                        bi.c3b.isChecked() ? "2" :
                                "0");
        //json.put("c4", bi.c4.getText().toString());
        json.put("c4a", bi.c4a.getText().toString());
        json.put("c4b",
                bi.c4ba.isChecked() ? "1" :
                        bi.c4bb.isChecked() ? "2" :
                                "0");
        //json.put("c4c", bi.c4c.getText().toString());
        json.put("c4ca", bi.c4ca.getText().toString());
        json.put("c4cb", bi.c4cb.getText().toString());


        child.setsCA(String.valueOf(json));

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
                startActivity(new Intent(this, SectionCHBActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        openChildEndActivity(this);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
