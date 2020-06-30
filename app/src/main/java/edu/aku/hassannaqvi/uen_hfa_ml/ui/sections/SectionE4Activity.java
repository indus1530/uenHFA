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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionE4Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.utils.JSONUtils;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openSectionMainActivity;

public class SectionE4Activity extends AppCompatActivity {

    ActivitySectionE4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e4);
        bi.setCallback(this);
        setTitle(R.string.chsec);
        setupSkips();
    }


    private void setupSkips() {

        bi.e0401.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.e0401b.getId()) {
                Clear.clearAllFields(bi.fldGrpSece401);
            }
        }));


        bi.e0407a.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece407);
        }));

        bi.e0407b.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece407);
        }));

        bi.e0407c.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece407);
        }));

        bi.e0407d.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece407);
        }));


        bi.e0411.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpSece411);
        }));

    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("e0401", bi.e0401a.isChecked() ? "1"
                : bi.e0401b.isChecked() ? "2"
                : "-1");

        json.put("e0402", bi.e0402a.isChecked() ? "1"
                : bi.e0402b.isChecked() ? "2"
                : "-1");

        json.put("e0403a", bi.e0403aa.isChecked() ? "1"
                : bi.e0403ab.isChecked() ? "2"
                : bi.e0403ac.isChecked() ? "3"
                : bi.e0403ad.isChecked() ? "4"
                : "-1");

        json.put("e0403b", bi.e0403ba.isChecked() ? "1"
                : bi.e0403bb.isChecked() ? "2"
                : bi.e0403bc.isChecked() ? "3"
                : bi.e0403bd.isChecked() ? "4"
                : "-1");

        json.put("e0403c", bi.e0403ca.isChecked() ? "1"
                : bi.e0403cb.isChecked() ? "2"
                : bi.e0403cc.isChecked() ? "3"
                : bi.e0403cd.isChecked() ? "4"
                : "-1");

        json.put("e0404", bi.e0404a.isChecked() ? "1"
                : bi.e0404b.isChecked() ? "2"
                : bi.e0404c.isChecked() ? "3"
                : bi.e0404d.isChecked() ? "4"
                : "-1");

        json.put("e0405", bi.e0405a.isChecked() ? "1"
                : bi.e0405b.isChecked() ? "2"
                : bi.e0405c.isChecked() ? "3"
                : bi.e0405d.isChecked() ? "4"
                : "-1");

        json.put("e0406", bi.e0406a.isChecked() ? "1"
                : bi.e0406b.isChecked() ? "2"
                : bi.e0406c.isChecked() ? "3"
                : "-1");

        json.put("e0407a", bi.e0407aa.isChecked() ? "1"
                : bi.e0407ab.isChecked() ? "2"
                : bi.e0407ac.isChecked() ? "3"
                : "-1");

        json.put("e0407b", bi.e0407ba.isChecked() ? "1"
                : bi.e0407bb.isChecked() ? "2"
                : bi.e0407bc.isChecked() ? "3"
                : "-1");

        json.put("e0407c", bi.e0407ca.isChecked() ? "1"
                : bi.e0407cb.isChecked() ? "2"
                : bi.e0407cc.isChecked() ? "3"
                : "-1");

        json.put("e0407d", bi.e0407da.isChecked() ? "1"
                : bi.e0407db.isChecked() ? "2"
                : bi.e0407dc.isChecked() ? "3"
                : "-1");

        json.put("e0408", bi.e0408a.isChecked() ? "1"
                : bi.e0408b.isChecked() ? "2"
                : bi.e0408c.isChecked() ? "3"
                : bi.e0408d.isChecked() ? "4"
                : "-1");

        json.put("e0409", bi.e0409a.isChecked() ? "1"
                : bi.e0409x.isChecked() ? "96"
                : "-1");

        json.put("e0409xx", bi.e0409xx.getText().toString().trim().isEmpty() ? "-1" : bi.e0409xx.getText().toString());

        json.put("e0410a", bi.e0410aa.isChecked() ? "1"
                : bi.e0410ab.isChecked() ? "2"
                : bi.e0410ac.isChecked() ? "3"
                : "-1");

        json.put("e0410b", bi.e0410ba.isChecked() ? "1"
                : bi.e0410bb.isChecked() ? "2"
                : bi.e0410bc.isChecked() ? "3"
                : "-1");

        json.put("e0410c", bi.e0410ca.isChecked() ? "1"
                : bi.e0410cb.isChecked() ? "2"
                : bi.e0410cc.isChecked() ? "3"
                : "-1");

        json.put("e0410d", bi.e0410da.isChecked() ? "1"
                : bi.e0410db.isChecked() ? "2"
                : bi.e0410dc.isChecked() ? "3"
                : "-1");

        json.put("e0410e", bi.e0410ea.isChecked() ? "1"
                : bi.e0410eb.isChecked() ? "2"
                : bi.e0410ec.isChecked() ? "3"
                : "-1");

        json.put("e0410f", bi.e0410fa.isChecked() ? "1"
                : bi.e0410fb.isChecked() ? "2"
                : bi.e0410fc.isChecked() ? "3"
                : "-1");

        json.put("e0411", bi.e0411a.isChecked() ? "1"
                : bi.e0411b.isChecked() ? "2"
                : bi.e0411c.isChecked() ? "3"
                : bi.e0411d.isChecked() ? "4"
                : "-1");

        json.put("e0412", bi.e0412a.isChecked() ? "1"
                : bi.e0412b.isChecked() ? "2"
                : bi.e0412c.isChecked() ? "3"
                : bi.e0412d.isChecked() ? "4"
                : "-1");

        json.put("e0413", bi.e0413a.isChecked() ? "1"
                : bi.e0413b.isChecked() ? "2"
                : "-1");

        json.put("e0414", bi.e0414a.isChecked() ? "1"
                : bi.e0414b.isChecked() ? "2"
                : bi.e0414c.isChecked() ? "3"
                : "-1");

        json.put("e0415", bi.e0415a.isChecked() ? "1"
                : bi.e0415b.isChecked() ? "2"
                : bi.e0415c.isChecked() ? "3"
                : "-1");

        json.put("e0416", bi.e0416a.isChecked() ? "1"
                : bi.e0416b.isChecked() ? "2"
                : bi.e0416c.isChecked() ? "3"
                : bi.e0416d.isChecked() ? "4"
                : "-1");

        try {
            JSONObject json_merge = JSONUtils.mergeJSONObjects(new JSONObject(fc.getsE()), json);

            fc.setsE(String.valueOf(json_merge));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionE5Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        openSectionMainActivity(this, "E");
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
