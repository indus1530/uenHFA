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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ModuleJContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ1Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;
import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.modj;

public class SectionJ1Activity extends AppCompatActivity {

    ActivitySectionJ1Binding bi;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j1);
        bi.setCallback(this);
        modj = new ModuleJContract();
        db = MainApp.appInfo.getDbHelper();

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
            Intent intent;

            if (MainApp.fc.getA10().equals("2") && MainApp.fc.getDistrictType().equals("1")) {
                intent = new Intent(this, SectionJ4Activity.class);
            } else {
                intent = new Intent(this, SectionJ2Activity.class);
            }
            startActivity(intent);
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addModuleJ(modj);
        modj.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            modj.set_UID(modj.getDeviceID() + modj.get_ID());
            db.updatesMJColumn(ModuleJContract.ModuleJ.COLUMN_UID, modj.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        modj.setFormDate(fc.getFormdate());
        modj.setDeviceID(MainApp.appInfo.getDeviceID());
        modj.setDevicetagID(MainApp.appInfo.getTagName());
        modj.setAppversion(MainApp.appInfo.getAppVersion());
        modj.set_UUID(MainApp.fc.get_UID());
        modj.setDistrictCode(MainApp.fc.getDistrictCode());
        modj.setTehsilCode(MainApp.fc.getTehsilCode());
        modj.setUcCode(MainApp.fc.getUcCode());
        modj.setHfCode(MainApp.fc.getHfCode());
//        psc.serialno = serial.toString()

        JSONObject json = new JSONObject();

        json.put("moduleDate", new SimpleDateFormat("dd-MM-yyyy").format(new Date().getTime()));
        json.put("moduleTime", new SimpleDateFormat("HH:mm").format(new Date().getTime()));

        json.put("j0100a", bi.j0100a.getText().toString().trim().length() > 0 ? bi.j0100a.getText().toString() : "-1");
        json.put("j0100b", bi.j0100b.getText().toString().trim().length() > 0 ? bi.j0100b.getText().toString() : "-1");

        json.put("j0100c", bi.j0100ca.isChecked() ? "1"
                : bi.j0100cb.isChecked() ? "2"
                : "-1");

        json.put("j0101a", bi.j0101aa.isChecked() ? "1"
                : bi.j0101ab.isChecked() ? "2"
                : "-1");

        json.put("j0101b", bi.j0101ba.isChecked() ? "1"
                : bi.j0101bb.isChecked() ? "2"
                : "-1");

        json.put("j0101c", bi.j0101ca.isChecked() ? "1"
                : bi.j0101cb.isChecked() ? "2"
                : "-1");

        json.put("j0101d", bi.j0101da.isChecked() ? "1"
                : bi.j0101db.isChecked() ? "2"
                : "-1");

        json.put("j0101e", bi.j0101ea.isChecked() ? "1"
                : bi.j0101eb.isChecked() ? "2"
                : "-1");

        json.put("j0101f", bi.j0101fa.isChecked() ? "1"
                : bi.j0101fb.isChecked() ? "2"
                : "-1");

        json.put("j0101g", bi.j0101ga.isChecked() ? "1"
                : bi.j0101gb.isChecked() ? "2"
                : "-1");

        json.put("j0101h", bi.j0101ha.isChecked() ? "1"
                : bi.j0101hb.isChecked() ? "2"
                : "-1");


        json.put("j0101ia", bi.j0101iaa.isChecked() ? "1"
                : bi.j0101iab.isChecked() ? "2"
                : "-1");

        json.put("j0101ib", bi.j0101iba.isChecked() ? "1"
                : bi.j0101ibb.isChecked() ? "2"
                : "-1");

        json.put("j0101j", bi.j0101ja.isChecked() ? "1"
                : bi.j0101jb.isChecked() ? "2"
                : "-1");

        json.put("j0101k", bi.j0101ka.isChecked() ? "1"
                : bi.j0101kb.isChecked() ? "2"
                : "-1");

        json.put("j0101l", bi.j0101la.isChecked() ? "1"
                : bi.j0101lb.isChecked() ? "2"
                : "-1");

        json.put("j0101ma", bi.j0101ma.isChecked() ? "1" : "-1");
        json.put("j0101mb", bi.j0101mb.isChecked() ? "2" : "-1");
        json.put("j0101mc", bi.j0101mc.isChecked() ? "3" : "-1");
        json.put("j0101md", bi.j0101md.isChecked() ? "4" : "-1");
        json.put("j0101me", bi.j0101me.isChecked() ? "5" : "-1");
        json.put("j0101mf", bi.j0101mf.isChecked() ? "6" : "-1");
        json.put("j0101mx", bi.j0101mx.isChecked() ? "96" : "-1");
        json.put("j0101mxx", bi.j0101mxx.getText().toString());

        modj.setsJ(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ1);

    }

}