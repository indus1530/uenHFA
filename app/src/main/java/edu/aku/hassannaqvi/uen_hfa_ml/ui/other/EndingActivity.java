package edu.aku.hassannaqvi.uen_hfa_ml.ui.other;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivityEndingBinding;

public class EndingActivity extends AppCompatActivity {

    ActivityEndingBinding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_ending);
        bi.setCallback(this);

        boolean check = getIntent().getBooleanExtra("complete", false);

        if (check) {
            bi.istatusa.setEnabled(true);
            bi.istatusb.setEnabled(false);
            bi.istatus96.setEnabled(false);
        } else {
            bi.istatusa.setEnabled(false);
            bi.istatusb.setEnabled(true);
            bi.istatus96.setEnabled(true);
        }

//
    }


    public void BtnEnd() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void SaveDraft() {

        MainApp.fc.setIstatus(bi.istatusa.isChecked() ? "1"
                : bi.istatusb.isChecked() ? "2"
                : bi.istatus96.isChecked() ? "96"
                : "0");

        MainApp.fc.setIstatus88x(bi.istatus96x.getText().toString());
        MainApp.fc.setEndingdatetime(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
    }


    public boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updateEnding();
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.fldGrpEnd);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
    }

}
