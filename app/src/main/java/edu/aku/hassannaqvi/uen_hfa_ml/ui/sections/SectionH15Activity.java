package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleHContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH15Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.modh;

public class SectionH15Activity extends AppCompatActivity {

    ActivitySectionH15Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h15);
        bi.setCallback(this);
        modh = new ModuleHContract();
        db = MainApp.appInfo.getDbHelper();
        setupSkips();

    }


    private void setupSkips() {
        bi.h1601.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.h1601a.getId() || i == bi.h1601b.getId()) {
                Clear.clearAllFields(bi.fldGrpSech1601);
                Clear.clearAllFields(bi.fldGrpCVh1605);
            }
        }));

    }


    public void BtnContinue() {
        if (!formValidation()) return;
        try {
            SaveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addModuleH(modh);
        modh.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            modh.set_UID(modh.getDeviceID() + modh.get_ID());
            db.updatesMHColumn(ModuleHContract.ModuleH.COLUMN_UID, modh.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        modh.setFormDate(fc.getFormdate());
        modh.setDeviceID(MainApp.appInfo.getDeviceID());
        modh.setDevicetagID(MainApp.appInfo.getTagName());
        modh.setAppversion(MainApp.appInfo.getAppVersion());
        modh.set_UUID(MainApp.fc.get_UID());
        modh.setDistrictCode(MainApp.fc.getDistrictCode());
        modh.setTehsilCode(MainApp.fc.getTehsilCode());
        modh.setUcCode(MainApp.fc.getUcCode());
        modh.setHfCode(MainApp.fc.getHfCode());
//        psc.serialno = serial.toString()

        JSONObject json = new JSONObject();

        json.put("h1601", bi.h1601a.isChecked() ? "1"
                : bi.h1601b.isChecked() ? "2"
                : "-1");

        json.put("h1602", bi.h1602a.isChecked() ? "1"
                : bi.h1602b.isChecked() ? "2"
                : bi.h1602c.isChecked() ? "3"
                : bi.h1602x.isChecked() ? "96"
                : "-1");
        json.put("h1602xx", bi.h1602xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1602xx.getText().toString());

        json.put("h1603", bi.h1603a.isChecked() ? "1"
                : bi.h1603b.isChecked() ? "2"
                : bi.h1603c.isChecked() ? "3"
                : bi.h1603x.isChecked() ? "96"
                : "-1");
        json.put("h1603xx", bi.h1603xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1603xx.getText().toString());

        json.put("h1604", bi.h1604a.isChecked() ? "1"
                : bi.h1604b.isChecked() ? "2"
                : "-1");

        json.put("h1605", bi.h1605a.isChecked() ? "1"
                : bi.h1605b.isChecked() ? "2"
                : bi.h1605c.isChecked() ? "3"
                : bi.h1605d.isChecked() ? "4"
                : bi.h1605e.isChecked() ? "5"
                : bi.h1605x.isChecked() ? "96"
                : "-1");
        json.put("h1605xx", bi.h1605xx.getText().toString().trim().isEmpty() ? "-1" : bi.h1605xx.getText().toString());


        modh.setsH(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH16);
    }


    public void showTooltip(@NotNull View view) {
        if (view.getId() != View.NO_ID) {
            String package_name = getApplicationContext().getPackageName();

            // Question Number Textview ID must be prefixed with q_ e.g.: 'q_aa12a'
            String infoid = view.getResources().getResourceName(view.getId()).replace(package_name + ":id/q_", "");

            // Question info text must be suffixed with _info e.g.: aa12a_info
            int stringRes = this.getResources().getIdentifier(infoid + "_info", "string", getApplicationContext().getPackageName());

            // Fetch info text from strings.xml
            //String infoText = (String) getResources().getText(stringRes);

            // Check if string resource exists to avoid crash on missing info string
            if (stringRes != 0) {

                // Fetch info text from strings.xml
                String infoText = (String) getResources().getText(stringRes);

                new AlertDialog.Builder(this)
                        .setTitle("Info: " + infoid.toUpperCase())
                        .setMessage(infoText)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show();
            } else {
                Toast.makeText(this, "No information available on this question.", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "No ID Associated with this question.", Toast.LENGTH_SHORT).show();

        }
    }
}
