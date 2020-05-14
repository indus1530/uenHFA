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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionABinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        setTitle(R.string.modatitle);
        setupSkips();

    }


    private void setupSkips() {

       bi.a18.setOnCheckedChangeListener(((radioGroup, i) -> {
           if (i != bi.a18b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVa19);
            }
        }));

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
                startActivity(new Intent(this, SectionJ1Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SA, MainApp.fc.getsA());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        MainApp.fc = new FormsContract();
        MainApp.fc.setA1(MainApp.userName);
        MainApp.fc.setA3(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.fc.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.setGPS(this); // Set GPS

        MainApp.fc.setA6(String.valueOf(bi.a06.getSelectedItem()));

        MainApp.fc.setA7(String.valueOf(bi.a07.getSelectedItem()));

        MainApp.fc.setA8(String.valueOf(bi.a08.getSelectedItem()));

        MainApp.fc.setA9(String.valueOf(bi.a09.getSelectedItem()));

        MainApp.fc.setA10(bi.a10a.isChecked() ? "1"
                : bi.a10b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setA12(String.valueOf(bi.a13.getSelectedItemId()));

        MainApp.fc.setA13(String.valueOf(bi.a13.getSelectedItem()));

        JSONObject json = new JSONObject();

        /*json.put("a11", bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1");*/

        json.put("a14", bi.a14a.isChecked() ? "1"
                : bi.a14b.isChecked() ? "2"
                : "-1");

        json.put("a15", bi.a15a.isChecked() ? "1"
                : bi.a15b.isChecked() ? "2"
                : "-1");

        json.put("a16", bi.a16.getText().toString());

        json.put("a17", bi.a17a.isChecked() ? "1"
                : bi.a17b.isChecked() ? "2"
                : bi.a17c.isChecked() ? "3"
                : bi.a17d.isChecked() ? "4"
                : bi.a17e.isChecked() ? "5"
                : bi.a17f.isChecked() ? "6"
                : bi.a17g.isChecked() ? "7"
                : bi.a17h.isChecked() ? "8"
                : bi.a17i.isChecked() ? "9"
                : bi.a17j.isChecked() ? "10"
                : "-1");

        json.put("a18", bi.a18a.isChecked() ? "1"
                : bi.a18b.isChecked() ? "2"
                : bi.a18c.isChecked() ? "3"
                : bi.a18d.isChecked() ? "4"
                : bi.a18x.isChecked() ? "96"
                : "-1");
        json.put("a18xx", bi.a18xx.getText().toString());

        json.put("a19", bi.a19a.isChecked() ? "1"
                : bi.a19b.isChecked() ? "2"
                : bi.a19c.isChecked() ? "3"
                : bi.a19d.isChecked() ? "4"
                : bi.a19e.isChecked() ? "5"
                : bi.a19f.isChecked() ? "6"
                : bi.a19g.isChecked() ? "7"
                : bi.a19x.isChecked() ? "96"
                : "-1");
        json.put("a19xx", bi.a19xx.getText().toString());

        json.put("a20", bi.a20a.isChecked() ? "1"
                : bi.a20b.isChecked() ? "2"
                : "-1");

        json.put("a21", bi.a21.getText().toString());

        json.put("a22", bi.a22a.isChecked() ? "1"
                : bi.a22b.isChecked() ? "2"
                : bi.a22c.isChecked() ? "3"
                : bi.a22d.isChecked() ? "4"
                : bi.a22e.isChecked() ? "5"
                : "-1");

        MainApp.fc.setsA(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);

    }


    public void BtnEnd() {
        openEndActivity(this);
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
