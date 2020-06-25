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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK1Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK1Activity extends AppCompatActivity {

    ActivitySectionK1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k1);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        bi.k0101a.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.k0101ab.getId()) {
                Clear.clearAllFields(bi.fldGrpSecK101);
            }
        }));

        bi.k0104.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.k0104b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVk0104aa);
            }
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
            startActivity(new Intent(this, SectionK2Activity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("k0101a", bi.k0101aa.isChecked() ? "1"
                : bi.k0101ab.isChecked() ? "2"
                : "-1");

        json.put("k0101b", bi.k0101ba.isChecked() ? "1"
                : bi.k0101bb.isChecked() ? "2"
                : "-1");

        json.put("k0101c", bi.k0101ca.isChecked() ? "1"
                : bi.k0101cb.isChecked() ? "2"
                : bi.k0101cc.isChecked() ? "3"
                : bi.k0101cd.isChecked() ? "4"
                : bi.k0101ce.isChecked() ? "5"
                : bi.k0101cf.isChecked() ? "6"
                : bi.k0101cg.isChecked() ? "7"
                : bi.k0101cx.isChecked() ? "96"
                : "-1");
        json.put("k0101cxx", bi.k0101cxx.getText().toString().trim().isEmpty() ? "-1" : bi.k0101cxx.getText().toString());

        json.put("k0102", bi.k0102a.isChecked() ? "1"
                : bi.k0102b.isChecked() ? "2"
                : bi.k0102c.isChecked() ? "3"
                : "-1");

        json.put("k0103", bi.k0103a.isChecked() ? "1"
                : bi.k0103b.isChecked() ? "2"
                : "-1");

        json.put("k0104", bi.k0104a.isChecked() ? "1"
                : bi.k0104b.isChecked() ? "2"
                : "-1");

        json.put("k0104aa", bi.k0104aaa.isChecked() ? "1"
                : bi.k0104aab.isChecked() ? "2"
                : bi.k0104aac.isChecked() ? "3"
                : bi.k0104aad.isChecked() ? "4"
                : bi.k0104aax.isChecked() ? "96"
                : "-1");
        json.put("k0104aaxx", bi.k0104aaxx.getText().toString().trim().isEmpty() ? "-1" : bi.k0104aaxx.getText().toString());

        json.put("k0105", bi.k0105a.isChecked() ? "1"
                : bi.k0105b.isChecked() ? "2"
                : bi.k0105c.isChecked() ? "3"
                : "-1");

        MainApp.fc.setsK(String.valueOf(json));

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK1);
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
