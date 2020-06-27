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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionI1Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.validator.ValidatorClass;


public class SectionI1Activity extends AppCompatActivity {

    ActivitySectionI1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_i1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.i0103.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVi0104);
        }));

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

            startActivity(new Intent(this, bi.i0108b.isChecked() ? SectionI3Activity.class : SectionI2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SI, MainApp.fc.getsI());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("i0101", bi.i0101a.isChecked() ? "1"
                : bi.i0101b.isChecked() ? "2"
                : "-1");

        json.put("i0102a", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("i0102b", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("i0103", bi.i0103a.isChecked() ? "1"
                : bi.i0103b.isChecked() ? "2"
                : "-1");

        json.put("i0104", bi.i0104a.isChecked() ? "1"
                : bi.i0104b.isChecked() ? "2"
                : bi.i0104c.isChecked() ? "3"
                : bi.i0104d.isChecked() ? "4"
                : "-1");

        json.put("i0105", bi.i0105a.isChecked() ? "1"
                : bi.i0105b.isChecked() ? "2"
                : "-1");

        json.put("i0106a", bi.i0106a.getText().toString().trim().isEmpty() ? "-1" : bi.i0106a.getText().toString());
        json.put("i0106b", bi.i0106b.getText().toString().trim().isEmpty() ? "-1" : bi.i0106b.getText().toString());

        json.put("i0107", bi.i0107a.isChecked() ? "1"
                : bi.i0107b.isChecked() ? "2"
                : "-1");

        json.put("i0108", bi.i0108a.isChecked() ? "1"
                : bi.i0108b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setsI(String.valueOf(json));

    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (bi.i0106a.getText().toString().trim().length() > 0 && bi.i0106b.getText().toString().trim().length() > 0) {
            if (Integer.parseInt(bi.i0106a.getText().toString().trim()) + Integer.parseInt(bi.i0106a.getText().toString().trim()) == 0) {
                return ValidatorClass.EmptyCustomeTextBox(this, bi.i0106a, "Both!! Month & Year Can't be Zero!");
                //return Validator.emptyCheckingContainer(this, bi.i0106a);
            }
        }
        return true;
    }

}
