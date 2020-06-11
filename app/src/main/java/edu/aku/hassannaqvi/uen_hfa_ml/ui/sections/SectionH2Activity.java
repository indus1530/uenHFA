package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH2Binding;


public class SectionH2Activity extends AppCompatActivity {

    ActivitySectionH2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h2);
        bi.setCallback(this);

    }


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionH3Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SH, MainApp.fc.getsH());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() {

        MainApp.fc.h0201 = bi.h0201a.isChecked() ? "1"
                : bi.h0201b.isChecked() ? "2"
                : "-1";

        MainApp.fc.h0201 = bi.h0202a.isChecked() ? "1"
                : bi.h0202b.isChecked() ? "2"
                : bi.h0202c.isChecked() ? "3"
                : "-1";

        MainApp.fc.h0203a = bi.h0203aa.isChecked() ? "1"
                : bi.h0203ab.isChecked() ? "2"
                : bi.h0203ac.isChecked() ? "3"
                : bi.h0203ad.isChecked() ? "4"
                : "-1";

        MainApp.fc.h0203b = bi.h0203ba.isChecked() ? "1"
                : bi.h0203bb.isChecked() ? "2"
                : bi.h0203bc.isChecked() ? "3"
                : bi.h0203bd.isChecked() ? "4"
                : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


}
