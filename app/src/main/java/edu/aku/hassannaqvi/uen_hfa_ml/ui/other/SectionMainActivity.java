package edu.aku.hassannaqvi.uen_hfa_ml.ui.other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionMainBinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionAActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionBActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionC1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionD1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionE1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionF1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionG1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionH1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionI1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionJ1Activity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionMainActivity extends AppCompatActivity {
    ActivitySectionMainBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_main);
        bi.setCallback(this);

        if (!fc.getsB().isEmpty())
            bi.form01.setEnabled(false);

        if (!fc.getsC().equals(""))
            bi.form02.setEnabled(false);

        if (!fc.getsD().equals(""))
            bi.form03.setEnabled(false);

        if (!fc.getsE().equals(""))
            bi.form04.setEnabled(false);

        if (!fc.getsF().equals(""))
            bi.form05.setEnabled(false);

        if (!fc.getsG().equals(""))
            bi.form06.setEnabled(false);

        if (!fc.getsH().equals(""))
            bi.form07.setEnabled(false);

        if (!fc.getsI().equals(""))
            bi.form08.setEnabled(false);

        if (!fc.getsJ().equals(""))
            bi.form09.setEnabled(false);

    }


    public void openForm(View v) {
        OpenFormFunc(v.getId());
    }


    public void BtnContinue() {

        if (!bi.form01.isEnabled()
                && !bi.form02.isEnabled()
                && !bi.form03.isEnabled()
                && !bi.form04.isEnabled()
                && !bi.form05.isEnabled()
                && !bi.form06.isEnabled()
                && !bi.form07.isEnabled()
                && !bi.form08.isEnabled()
                && !bi.form09.isEnabled()) {
            //startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            MainApp.endActivity(this, this, EndingActivity.class, true, SectionAActivity.fc);
        } else {
            Toast.makeText(this, "Sections still in Pending!", Toast.LENGTH_SHORT).show();
        }
    }


    public void BtnEnd() {
        if (bi.form01.isEnabled()
                || bi.form02.isEnabled()
                || bi.form03.isEnabled()
                || bi.form04.isEnabled()
                || bi.form05.isEnabled()
                || bi.form06.isEnabled()) {
            //startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            MainApp.endActivity(this, this, EndingActivity.class, false, SectionAActivity.fc);
        } else {
            Toast.makeText(this, "ALL SECTIONS FILLED \n Good to GO GREEN!", Toast.LENGTH_SHORT).show();
        }

    }


    private void OpenFormFunc(int id) {
        Intent oF = new Intent();
        if (!MainApp.userName.equals("0000")) {
            switch (id) {
                case R.id.form01:
                    oF = new Intent(SectionMainActivity.this, SectionBActivity.class);
                    break;
                case R.id.form02:
                    oF = new Intent(SectionMainActivity.this, SectionC1Activity.class);
                    break;
                case R.id.form03:
                    oF = new Intent(SectionMainActivity.this, SectionD1Activity.class);
                    break;
                case R.id.form04:
                    oF = new Intent(SectionMainActivity.this, SectionE1Activity.class);
                    break;
                case R.id.form05:
                    oF = new Intent(SectionMainActivity.this, SectionF1Activity.class);
                    break;
                case R.id.form06:
                    oF = new Intent(SectionMainActivity.this, SectionG1Activity.class);
                    break;
                case R.id.form07:
                    oF = new Intent(SectionMainActivity.this, SectionH1Activity.class);
                    break;
                case R.id.form08:
                    oF = new Intent(SectionMainActivity.this, SectionI1Activity.class);
                    break;
                case R.id.form09:
                    oF = new Intent(SectionMainActivity.this, SectionJ1Activity.class);
                    break;
            }
            startActivity(oF);
        } else {
            Toast.makeText(getApplicationContext(), "Please login Again!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
