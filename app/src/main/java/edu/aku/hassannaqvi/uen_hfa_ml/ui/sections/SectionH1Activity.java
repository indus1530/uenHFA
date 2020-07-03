package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleHContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH1Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.modh;


public class SectionH1Activity extends AppCompatActivity {

    ActivitySectionH1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1);
        bi.setCallback(this);
        modh = new ModuleHContract();
        db = MainApp.appInfo.getDbHelper();

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
            startActivity(new Intent(this, SectionH2Activity.class));
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

        json.put("moduleDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("moduleTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("h0201", bi.h0201a.isChecked() ? "1"
                : bi.h0201b.isChecked() ? "2"
                : "-1");

        json.put("h0202", bi.h0202a.isChecked() ? "1"
                : bi.h0202b.isChecked() ? "2"
                : bi.h0202c.isChecked() ? "3"
                : "-1");

        json.put("h0203a", bi.h0203aa.isChecked() ? "1"
                : bi.h0203ab.isChecked() ? "2"
                : bi.h0203ac.isChecked() ? "3"
                : bi.h0203ad.isChecked() ? "4"
                : "-1");

        json.put("h0203b", bi.h0203ba.isChecked() ? "1"
                : bi.h0203bb.isChecked() ? "2"
                : bi.h0203bc.isChecked() ? "3"
                : bi.h0203bd.isChecked() ? "4"
                : "-1");

        modh.setsH(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
