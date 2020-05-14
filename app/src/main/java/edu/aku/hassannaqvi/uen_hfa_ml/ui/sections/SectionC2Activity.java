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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionC2Activity extends AppCompatActivity {

    ActivitySectionC2Binding bi;
    int position;
    FamilyMembersContract selMWRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setTitle(R.string.modctitle);
        setupListeners();
    }

    private void setupListeners() {

        bi.c03.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.c03b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVc04 );
            }
        }));

       /* List<String> childrenLst = new ArrayList<String>() {
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
        child.setFormDate(MainApp.fc.getA3());
        child.setUser(MainApp.userName);

        JSONObject json = new JSONObject();

        json.put("c02a", bi.c02a.getText().toString());

        json.put("c02b", bi.c02ba.isChecked() ? "1"
                : bi.c02bb.isChecked() ? "2"
                : "-1");

        json.put("c02ca", bi.c02ca.getText().toString());

        json.put("c02cb", bi.c02cb.getText().toString());

        json.put("c03", bi.c03a.isChecked() ? "1"
                : bi.c03b.isChecked() ? "2"
                : "-1");

        json.put("c04", bi.c04.getText().toString());

        json.put("c04a", bi.c04a.getText().toString());

        json.put("c04b", bi.c04ba.isChecked() ? "1"
                : bi.c04bb.isChecked() ? "2"
                : "-1");

        json.put("c04ca", bi.c04ca.getText().toString());

        json.put("c04cb", bi.c04cb.getText().toString());


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
                startActivity(new Intent(this, EndingActivity.class));
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
