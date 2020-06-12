package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.edittextpicker.aliazaz.EditTextPicker;
import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH14Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionH14Activity extends AppCompatActivity {

    ActivitySectionH14Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h14);
        bi.setCallback(this);
        setupTextWatchers();

    }


    private void setupTextWatchers() {
        editTextImplementation(bi.h1401aa, bi.h1401ab);
        editTextImplementation(bi.h1401ba, bi.h1401bb);
        editTextImplementation(bi.h1401ca, bi.h1401cb);
        editTextImplementation(bi.h1401da, bi.h1401db);
        editTextImplementation(bi.h1401ea, bi.h1401eb);
    }


    public void editTextImplementation(EditTextPicker edit01, EditTextPicker edit02) {

        edit01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(edit01.getText()))
                    return;
                edit02.setMaxvalue(Integer.parseInt(edit01.getText().toString().trim()));
            }
        });

    }


    public void BtnContinue() {
        if (formValidation()) {
            SaveDraft();
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionH151Activity.class));
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

        MainApp.fc.h1401aa = bi.h1401aa.getText().toString().trim().length() > 0 ? bi.h1401aa.getText().toString() : "-1";
        MainApp.fc.h1401ab = bi.h1401ab.getText().toString().trim().length() > 0 ? bi.h1401ab.getText().toString() : "-1";

        MainApp.fc.h1401ba = bi.h1401ba.getText().toString().trim().length() > 0 ? bi.h1401ba.getText().toString() : "-1";
        MainApp.fc.h1401bb = bi.h1401bb.getText().toString().trim().length() > 0 ? bi.h1401bb.getText().toString() : "-1";

        MainApp.fc.h1401ca = bi.h1401ca.getText().toString().trim().length() > 0 ? bi.h1401ca.getText().toString() : "-1";
        MainApp.fc.h1401cb = bi.h1401cb.getText().toString().trim().length() > 0 ? bi.h1401cb.getText().toString() : "-1";

        MainApp.fc.h1401da = bi.h1401da.getText().toString().trim().length() > 0 ? bi.h1401da.getText().toString() : "-1";
        MainApp.fc.h1401db = bi.h1401db.getText().toString().trim().length() > 0 ? bi.h1401db.getText().toString() : "-1";

        MainApp.fc.h1401ea = bi.h1401ea.getText().toString().trim().length() > 0 ? bi.h1401ea.getText().toString() : "-1";
        MainApp.fc.h1401eb = bi.h1401eb.getText().toString().trim().length() > 0 ? bi.h1401eb.getText().toString() : "-1";

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH14);

    }


    public void BtnEnd() {
        openEndActivity(this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
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
