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
import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionH1Binding;


public class SectionH1Activity extends AppCompatActivity {

    ActivitySectionH1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h1);
        bi.setCallback(this);
        //setupSpinner(this);
        setupSkips();


        /*if (!MainApp.fc.getsG().isEmpty()) {
            bi.h0101a.setText(getMon1());
            bi.h0101b.setText(getMon2());
            bi.h0101c.setText(getMon3());

            String[] one = getMon1().split("-");
            bi.h0101aa.setText(one[0]);
            bi.h0101ab.setText(one[1]);

            String[] two = getMon2().split("-");
            bi.h0101ba.setText(two[0]);
            bi.h0101bb.setText(two[1]);

            String[] three = getMon3().split("-");
            bi.h0101ca.setText(three[0]);
            bi.h0101cb.setText(three[1]);
        }*/

    }


    /*private void setupSpinner(final Context context) {

        bi.h0101b.setEnabled(false);
        bi.h0101c.setEnabled(false);

        bi.h0101a.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Arrays.asList(getResources().getStringArray(R.array.months_array))));
        bi.h0101a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;
                List<String> items = new LinkedList<>(Arrays.asList(getResources().getStringArray(R.array.months_array)));
                items.remove(bi.h0101a.getSelectedItemPosition());
                bi.h0101b.setAdapter(new ArrayAdapter<>(SectionH1Activity.this, android.R.layout.simple_spinner_dropdown_item, items));
                bi.h0101b.setEnabled(true);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bi.h0101b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;
                List<String> items = new LinkedList<>(Arrays.asList(getResources().getStringArray(R.array.months_array)));
                items.remove(bi.h0101a.getSelectedItemPosition());
                items.remove(bi.h0101b.getSelectedItemPosition());
                bi.h0101c.setAdapter(new ArrayAdapter<>(SectionH1Activity.this, android.R.layout.simple_spinner_dropdown_item, items));
                bi.h0101c.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }*/


    private void setupSkips() {

        /*bi.ss04.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss04b.getId()) {
                Clear.clearAllFields(bi.ss05cv, false);
            } else {
                Clear.clearAllFields(bi.ss05cv, true);
            }
        }));*/

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
                startActivity(new Intent(this, SectionH2Activity.class));
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


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h0101a", bi.h0101a.getText().toString());

        json.put("h0101b", bi.h0101b.getText().toString());

        json.put("h0101c", bi.h0101c.getText().toString());

        //json.put("h0101", bi.h0101.getText().toString());

        json.put("h0101aa", bi.h0101aa.getText().toString());

        json.put("h0101ab", bi.h0101ab.getText().toString());

        json.put("h0101ba", bi.h0101ba.getText().toString());

        json.put("h0101bb", bi.h0101bb.getText().toString());

        json.put("h0101ca", bi.h0101ca.getText().toString());

        json.put("h0101cb", bi.h0101cb.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
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
