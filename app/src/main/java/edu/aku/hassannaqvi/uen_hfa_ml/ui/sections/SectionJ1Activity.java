package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJ1Binding;

public class SectionJ1Activity extends AppCompatActivity {

    ActivitySectionJ1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j1);
        bi.setCallback(this);

    }




    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionJ2Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SJ, MainApp.fc.getsJ());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }


    private void SaveDraft() {

        MainApp.fc.j0100a = bi.j0100a.getText().toString().trim().length() > 0 ? bi.j0100a.getText().toString() : "-1";
        MainApp.fc.j0100b = bi.j0100b.getText().toString().trim().length() > 0 ? bi.j0100b.getText().toString() : "-1";

        MainApp.fc.j0100c = bi.j0100ca.isChecked() ? "1"
                : bi.j0100cb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101a = bi.j0101aa.isChecked() ? "1"
                : bi.j0101ab.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101b = bi.j0101ba.isChecked() ? "1"
                : bi.j0101bb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101c = bi.j0101ca.isChecked() ? "1"
                : bi.j0101cb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101d = bi.j0101da.isChecked() ? "1"
                : bi.j0101db.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101e = bi.j0101ea.isChecked() ? "1"
                : bi.j0101eb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101f = bi.j0101fa.isChecked() ? "1"
                : bi.j0101fb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101g = bi.j0101ga.isChecked() ? "1"
                : bi.j0101gb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101h = bi.j0101ha.isChecked() ? "1"
                : bi.j0101hb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101ia = bi.j0101iaa.isChecked() ? "1"
                : bi.j0101iab.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101ib = bi.j0101iba.isChecked() ? "1"
                : bi.j0101ibb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101j = bi.j0101ja.isChecked() ? "1"
                : bi.j0101jb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101k = bi.j0101ka.isChecked() ? "1"
                : bi.j0101kb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101l = bi.j0101la.isChecked() ? "1"
                : bi.j0101lb.isChecked() ? "2"
                : "-1";

        MainApp.fc.j0101ma = bi.j0101ma.isChecked() ? "1" : "-1";
        MainApp.fc.j0101mb = bi.j0101mb.isChecked() ? "2" : "-1";
        MainApp.fc.j0101mc = bi.j0101mc.isChecked() ? "3" : "-1";
        MainApp.fc.j0101md = bi.j0101md.isChecked() ? "4" : "-1";
        MainApp.fc.j0101me = bi.j0101me.isChecked() ? "5" : "-1";
        MainApp.fc.j0101mf = bi.j0101mf.isChecked() ? "6" : "-1";
        MainApp.fc.j0101mx = bi.j0101mx.isChecked() ? "96" : "-1";
        MainApp.fc.j0101mxx = bi.j0101mxx.getText().toString().trim().length() > 0 ? bi.j0101mxx.getText().toString() : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ1);

    }


    public void showTooltip(@NotNull View view) {
        if (view.getId() != View.NO_ID) {
            String package_name = getApplicationContext().getPackageName();

            // Question Number Textview ID must be prefixed with q_ e.g.: 'q_aa12a'
            String infoid = view.getResources().getResourceName(view.getId()).replace(package_name + ":id/q_", "");

            // Question info text must be suffixed with _info e.g.: aa12a_info
            int stringRes = this.getResources().getIdentifier(infoid + "_info", "string", getApplicationContext().getPackageName());

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