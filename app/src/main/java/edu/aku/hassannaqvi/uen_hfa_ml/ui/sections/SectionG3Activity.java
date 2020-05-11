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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionG3Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionG3Activity extends AppCompatActivity {

    ActivitySectionG3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g3);
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

        json.put("g0301", "-1");

        json.put("g0301aa", bi.g0301aa.getText().toString());

        json.put("g0301ab", bi.g0301ab.getText().toString());

        json.put("g0301ba", bi.g0301ba.getText().toString());

        json.put("g0301bb", bi.g0301bb.getText().toString());

        json.put("g0301ca", bi.g0301ca.getText().toString());

        json.put("g0301cb", bi.g0301cb.getText().toString());

        json.put("g0302", "-1");

        json.put("g0302a10r", bi.g0302a10r.getText().toString());

        json.put("g0302a10i", bi.g0302a10i.getText().toString());

        json.put("g0302a10d", bi.g0302a10d.getText().toString());

        json.put("g0302a10b", bi.g0302a10b.getText().toString());

        json.put("g0302a20r", bi.g0302a20r.getText().toString());

        json.put("g0302a20i", bi.g0302a20i.getText().toString());

        json.put("g0302a20d", bi.g0302a20d.getText().toString());

        json.put("g0302a20b", bi.g0302a20b.getText().toString());

        json.put("g0302a0r", bi.g0302a0r.getText().toString());

        json.put("g0302a0i", bi.g0302a0i.getText().toString());

        json.put("g0302a0d", bi.g0302a0d.getText().toString());

        json.put("g0302a0b", bi.g0302a0b.getText().toString());

        json.put("g0302a40r", bi.g0302a40r.getText().toString());

        json.put("g0302a40i", bi.g0302a40i.getText().toString());

        json.put("g0302a40d", bi.g0302a40d.getText().toString());

        json.put("g0302a40b", bi.g0302a40b.getText().toString());

        json.put("g0302a50r", bi.g0302a50r.getText().toString());

        json.put("g0302a50i", bi.g0302a50i.getText().toString());

        json.put("g0302a50d", bi.g0302a50d.getText().toString());

        json.put("g0302a50b", bi.g0302a50b.getText().toString());

        json.put("g0302a60r", bi.g0302a60r.getText().toString());

        json.put("g0302a60i", bi.g0302a60i.getText().toString());

        json.put("g0302a60d", bi.g0302a60d.getText().toString());

        json.put("g0302a60b", bi.g0302a60b.getText().toString());

        json.put("g0302a70r", bi.g0302a70r.getText().toString());

        json.put("g0302a70i", bi.g0302a70i.getText().toString());

        json.put("g0302a70d", bi.g0302a70d.getText().toString());

        json.put("g0302a70b", bi.g0302a70b.getText().toString());

        json.put("g0302b10r", bi.g0302b10r.getText().toString());

        json.put("g0302b10i", bi.g0302b10i.getText().toString());

        json.put("g0302b10d", bi.g0302b10d.getText().toString());

        json.put("g0302b10b", bi.g0302b10b.getText().toString());

        json.put("g0302b20r", bi.g0302b20r.getText().toString());

        json.put("g0302b20i", bi.g0302b20i.getText().toString());

        json.put("g0302b20d", bi.g0302b20d.getText().toString());

        json.put("g0302b20b", bi.g0302b20b.getText().toString());

        json.put("g0302b0r", bi.g0302b0r.getText().toString());

        json.put("g0302b0i", bi.g0302b0i.getText().toString());

        json.put("g0302b0d", bi.g0302b0d.getText().toString());

        json.put("g0302b0b", bi.g0302b0b.getText().toString());

        json.put("g0302b40r", bi.g0302b40r.getText().toString());

        json.put("g0302b40i", bi.g0302b40i.getText().toString());

        json.put("g0302b40d", bi.g0302b40d.getText().toString());

        json.put("g0302b40b", bi.g0302b40b.getText().toString());

        json.put("g0302b50r", bi.g0302b50r.getText().toString());

        json.put("g0302b50i", bi.g0302b50i.getText().toString());

        json.put("g0302b50d", bi.g0302b50d.getText().toString());

        json.put("g0302b50b", bi.g0302b50b.getText().toString());

        json.put("g0302b60r", bi.g0302b60r.getText().toString());

        json.put("g0302b60i", bi.g0302b60i.getText().toString());

        json.put("g0302b60d", bi.g0302b60d.getText().toString());

        json.put("g0302b60b", bi.g0302b60b.getText().toString());

        json.put("g0302b70r", bi.g0302b70r.getText().toString());

        json.put("g0302b70i", bi.g0302b70i.getText().toString());

        json.put("g0302b70d", bi.g0302b70d.getText().toString());

        json.put("g0302b70b", bi.g0302b70b.getText().toString());

        json.put("g0302c10r", bi.g0302c10r.getText().toString());

        json.put("g0302c10i", bi.g0302c10i.getText().toString());

        json.put("g0302c10d", bi.g0302c10d.getText().toString());

        json.put("g0302c10b", bi.g0302c10b.getText().toString());

        json.put("g0302c20r", bi.g0302c20r.getText().toString());

        json.put("g0302c20i", bi.g0302c20i.getText().toString());

        json.put("g0302c20d", bi.g0302c20d.getText().toString());

        json.put("g0302c20b", bi.g0302c20b.getText().toString());

        json.put("g0302c30r", bi.g0302c30r.getText().toString());

        json.put("g0302c30i", bi.g0302c30i.getText().toString());

        json.put("g0302c30d", bi.g0302c30d.getText().toString());

        json.put("g0302c30b", bi.g0302c30b.getText().toString());

        json.put("g0302c40r", bi.g0302c40r.getText().toString());

        json.put("g0302c40i", bi.g0302c40i.getText().toString());

        json.put("g0302c40d", bi.g0302c40d.getText().toString());

        json.put("g0302c40b", bi.g0302c40b.getText().toString());

        json.put("g0302c50r", bi.g0302c50r.getText().toString());

        json.put("g0302c50i", bi.g0302c50i.getText().toString());

        json.put("g0302c50d", bi.g0302c50d.getText().toString());

        json.put("g0302c50b", bi.g0302c50b.getText().toString());

        json.put("g0302c60r", bi.g0302c60r.getText().toString());

        json.put("g0302c60i", bi.g0302c60i.getText().toString());

        json.put("g0302c60d", bi.g0302c60d.getText().toString());

        json.put("g0302c60b", bi.g0302c60b.getText().toString());

        json.put("g0302c70r", bi.g0302c70r.getText().toString());

        json.put("g0302c70i", bi.g0302c70i.getText().toString());

        json.put("g0302c70d", bi.g0302c70d.getText().toString());

        json.put("g0302c70b", bi.g0302c70b.getText().toString());

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
                startActivity(new Intent(this, SectionG4Activity.class).putExtra("complete", true));

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
