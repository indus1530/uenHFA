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
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionBActivity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionC1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionD1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionE1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionF1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionG1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionH16Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionH2Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionI1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionJ1Activity;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.sections.SectionK1Activity;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.fc;

public class SectionMainActivity extends AppCompatActivity {
    ActivitySectionMainBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_main);
        bi.setCallback(this);





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
                && !bi.form09.isEnabled()
                && !bi.form10.isEnabled()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
            //MainApp.endActivity(this, SectionBActivity.class);
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
                || bi.form06.isEnabled()
                || bi.form07.isEnabled()
                || bi.form08.isEnabled()
                || bi.form09.isEnabled()
                || bi.form10.isEnabled()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            //MainApp.endActivity(this, EndingActivity.class).putExtra("complete", false);
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
                    oF = new Intent(SectionMainActivity.this, fc.a10.equals("2") ? SectionH16Activity.class : SectionH2Activity.class);
                    break;
                case R.id.form08:
                    oF = new Intent(SectionMainActivity.this, SectionI1Activity.class);
                    break;
                case R.id.form09:
                    oF = new Intent(SectionMainActivity.this, SectionJ1Activity.class);
                    break;
                case R.id.form10:
                    oF = new Intent(SectionMainActivity.this, SectionK1Activity.class);
                    break;
            }
            startActivity(oF);
        } else {
            Toast.makeText(getApplicationContext(), "Please login Again!", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
