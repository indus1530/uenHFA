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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.ChildContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionDBinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp.child;
import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openChildEndActivity;

public class SectionDActivity extends AppCompatActivity {

    ActivitySectionDBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d);
        bi.setCallback(this);
        setTitle(R.string.chBsec);
        setupSkips();

    }

    private void setupSkips() {

        /*bi.cb01a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if ((bi.cb01a.getText()).hashCode() == s.hashCode()) {
                    if (bi.cb01a.getText().toString().trim().length() > 0 && Integer.parseInt(bi.cb01a.getText().toString()) == 77) {
                        bi.cb01b.setEnabled(true);
                    } else {
                        bi.cb01b.setEnabled(false);
                        bi.cb01b.setText("");
                    }
                }

            }
        });


        bi.cb02a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if ((bi.cb02a.getText()).hashCode() == s.hashCode()) {
                    if (bi.cb02a.getText().toString().trim().length() > 0 && Integer.parseInt(bi.cb02a.getText().toString()) == 77) {
                        bi.cb02b.setEnabled(true);
                    } else {
                        bi.cb02b.setEnabled(false);
                        bi.cb02b.setText(null);
                    }
                }

            }
        });*/

    }

    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesChildColumn(ChildContract.SingleChild.COLUMN_SCB, child.getsCB());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("d11",
                bi.d11a.isChecked() ? "1" :
                        bi.d11b.isChecked() ? "2" :
                                "0");
        json.put("d12",
                bi.d12a.isChecked() ? "1" :
                        bi.d12b.isChecked() ? "2" :
                                "0");
        json.put("d21",
                bi.d21a.isChecked() ? "1" :
                        bi.d21b.isChecked() ? "2" :
                                "0");
        json.put("d22",
                bi.d22a.isChecked() ? "1" :
                        bi.d22b.isChecked() ? "2" :
                                "0");
        json.put("d23",
                bi.d23a.isChecked() ? "1" :
                        bi.d23b.isChecked() ? "2" :
                                "0");
        json.put("d31",
                bi.d31a.isChecked() ? "1" :
                        bi.d31b.isChecked() ? "2" :
                                bi.d31c.isChecked() ? "3" :
                                        bi.d31d.isChecked() ? "4" :
                                                "0");
        json.put("d32",
                bi.d32a.isChecked() ? "1" :
                        bi.d32b.isChecked() ? "2" :
                                bi.d32c.isChecked() ? "3" :
                                        bi.d32d.isChecked() ? "4" :
                                                bi.d32e.isChecked() ? "5" :
                                                        "0");
        json.put("d33",
                bi.d33a.isChecked() ? "1" :
                        bi.d33b.isChecked() ? "2" :
                                "0");
        json.put("d34",
                bi.d34a.isChecked() ? "1" :
                        bi.d34b.isChecked() ? "2" :
                                "0");
        json.put("d34c",
                "0");
        json.put("d41",
                bi.d41a.isChecked() ? "1" :
                        bi.d41b.isChecked() ? "2" :
                                bi.d41c.isChecked() ? "3" :
                                        bi.d41d.isChecked() ? "4" :
                                                bi.d41e.isChecked() ? "5" :
                                                        bi.d41f.isChecked() ? "6" :
                                                                "0");
        json.put("d42",
                bi.d42a.isChecked() ? "1" :
                        bi.d42b.isChecked() ? "2" :
                                bi.d42c.isChecked() ? "3" :
                                        bi.d42d.isChecked() ? "4" :
                                                bi.d42e.isChecked() ? "5" :
                                                        bi.d42f.isChecked() ? "6" :
                                                                "0");
        json.put("d43",
                bi.d43a.isChecked() ? "1" :
                        bi.d43b.isChecked() ? "2" :
                                bi.d43c.isChecked() ? "3" :
                                        "0");
        json.put("d44",
                bi.d44a.isChecked() ? "1" :
                        bi.d44b.isChecked() ? "2" :
                                bi.d44c.isChecked() ? "3" :
                                        "0");
        json.put("d51",
                bi.d51a.isChecked() ? "1" :
                        bi.d51b.isChecked() ? "2" :
                                bi.d51c.isChecked() ? "3" :
                                        "0");
        json.put("d52",
                "0");
        json.put("d52a0av",
                bi.d52a0ay.isChecked() ? "1" :
                        bi.d52a0an.isChecked() ? "2" :
                                bi.d52a0aq.isChecked() ? "3" :
                                        "0");
        json.put("d52a0aqx", bi.d52a0aqx.getText().toString());
        json.put("d52a0f",
                "0");
        json.put("d52a0fy",
                "0");
        json.put("d52a0fn",
                bi.d52a0fq.isChecked() ? "3" :
                        "0");
        json.put("d52a0fqx", bi.d52a0fqx.getText().toString());
        json.put("d52b0av",
                bi.d52b0ay.isChecked() ? "1" :
                        bi.d52b0an.isChecked() ? "2" :
                                bi.d52b0aq.isChecked() ? "3" :
                                        "0");
        json.put("d52b0aqx", bi.d52b0aqx.getText().toString());
        json.put("d52b0f",
                "0");
        json.put("d52b0fy",
                "0");
        json.put("d52b0fn",
                bi.d52b0fq.isChecked() ? "3" :
                        "0");
        json.put("d52b0fqx", bi.d52b0fqx.getText().toString());
        json.put("d52c0av",
                bi.d52c0ay.isChecked() ? "1" :
                        bi.d52c0an.isChecked() ? "2" :
                                bi.d52c0aq.isChecked() ? "3" :
                                        "0");
        json.put("d52c0aqx", bi.d52c0aqx.getText().toString());
        json.put("d52c0f",
                "0");
        json.put("d52c0fy",
                "0");
        json.put("d52c0fn",
                bi.d52c0fq.isChecked() ? "3" :
                        "0");
        json.put("d52c0fqx", bi.d52c0fqx.getText().toString());
        json.put("d52d0av",
                bi.d52d0ay.isChecked() ? "1" :
                        bi.d52d0an.isChecked() ? "2" :
                                bi.d52d0aq.isChecked() ? "3" :
                                        "0");
        json.put("d52d0aqx", bi.d52d0aqx.getText().toString());

        json.put("d52d0f",
                "0");

        json.put("d52d0fy",
                "0");

        json.put("d52d0fn",
                bi.d52d0fq.isChecked() ? "3" :
                        "0");

        json.put("d52d0fqx", bi.d52d0fqx.getText().toString());
        json.put("d53",
                "0");
        json.put("d53a",
                bi.d53aa.isChecked() ? "1" :
                        bi.d53ab.isChecked() ? "2" :
                                "0");
        json.put("d53b",
                bi.d53ba.isChecked() ? "1" :
                        bi.d53bb.isChecked() ? "2" :
                                "0");
        json.put("d53c",
                bi.d53ca.isChecked() ? "1" :
                        bi.d53cb.isChecked() ? "2" :
                                "0");
        json.put("d53d",
                bi.d53da.isChecked() ? "1" :
                        bi.d53db.isChecked() ? "2" :
                                "0");
        json.put("d53e",
                bi.d53ea.isChecked() ? "1" :
                        bi.d53eb.isChecked() ? "2" :
                                "0");
        json.put("d53f",
                bi.d53fa.isChecked() ? "1" :
                        bi.d53fb.isChecked() ? "2" :
                                "0");
        json.put("d53g",
                bi.d53ga.isChecked() ? "1" :
                        bi.d53gb.isChecked() ? "2" :
                                "0");
        json.put("d53h",
                bi.d53ha.isChecked() ? "1" :
                        bi.d53hb.isChecked() ? "2" :
                                "0");

        json.put("d61", "0");

        json.put("d61a",
                bi.d61aa.isChecked() ? "1" :
                        bi.d61ab.isChecked() ? "2" :
                                "0");
        json.put("d61b",
                bi.d61ba.isChecked() ? "1" :
                        bi.d6bb.isChecked() ? "2" :
                                "0");
        json.put("d61c",
                bi.d61ca.isChecked() ? "1" :
                        bi.d61cb.isChecked() ? "2" :
                                "0");
        json.put("d61d",
                bi.d61da.isChecked() ? "1" :
                        bi.d61db.isChecked() ? "2" :
                                "0");
        json.put("d62",
                bi.d62a.isChecked() ? "1" :
                        bi.d62b.isChecked() ? "2" :
                                "0");
        json.put("d63",
                bi.d63a.isChecked() ? "1" :
                        bi.d63b.isChecked() ? "2" :
                                "0");
        json.put("d64",
                bi.d64a.isChecked() ? "1" :
                        bi.d64b.isChecked() ? "2" :
                                "0");
        json.put("d65",
                bi.d65a.isChecked() ? "1" :
                        bi.d65b.isChecked() ? "2" :
                                bi.d65c.isChecked() ? "3" :
                                        bi.d65d.isChecked() ? "4" :
                                                bi.d65e.isChecked() ? "5" :
                                                        bi.d65f.isChecked() ? "6" :
                                                                bi.d65g.isChecked() ? "7" :
                                                                        bi.d65h.isChecked() ? "8" :
                                                                                bi.d65i.isChecked() ? "9" :
                                                                                        "0");
        json.put("d71",
                bi.d71a.isChecked() ? "1" :
                        bi.d71b.isChecked() ? "2" :
                                bi.d71c.isChecked() ? "3" :
                                        bi.d71x.isChecked() ? "96" :
                                                "0");
        json.put("d71xx", bi.d71xx.getText().toString());
        json.put("d72",
                bi.d72a.isChecked() ? "1" :
                        bi.d72b.isChecked() ? "2" :
                                bi.d72c.isChecked() ? "3" :
                                        bi.d72d.isChecked() ? "4" :
                                                bi.d72e.isChecked() ? "5" :
                                                        bi.d72x.isChecked() ? "96" :
                                                                "0");
        json.put("d73",
                bi.d73a.isChecked() ? "1" :
                        bi.d73b.isChecked() ? "2" :
                                bi.d73c.isChecked() ? "3" :
                                        bi.d73x.isChecked() ? "98" :
                                                "0");
        json.put("d74",
                bi.d74aa.isChecked() ? "1" :
                        bi.d74ab.isChecked() ? "2" :
                                "0");
        json.put("d74a",
                "0");
        json.put("d74b",
                bi.d74ba.isChecked() ? "1" :
                        bi.d74bb.isChecked() ? "2" :
                                "0");
        json.put("d74c",
                bi.d74ca.isChecked() ? "1" :
                        bi.d74cb.isChecked() ? "2" :
                                "0");
        json.put("d74d",
                bi.d74da.isChecked() ? "1" :
                        bi.d74db.isChecked() ? "2" :
                                "0");
        json.put("d74e",
                bi.d74ea.isChecked() ? "1" :
                        bi.d74eb.isChecked() ? "2" :
                                "0");
        json.put("d81",
                "0");
        json.put("d81a0a",
                "0");
        json.put("d81a0ay",
                "0");
        json.put("d81a0an",
                "0");
        json.put("d81a0f",
                "0");
        json.put("d81a0fq", bi.d81a0fq.getText().toString());
        json.put("d81b0a",
                "0");
        json.put("d81b0ay",
                "0");
        json.put("d81b0an",
                "0");
        json.put("d81b0f",
                "0");
        json.put("d81b0fq", bi.d81b0fq.getText().toString());
        json.put("d81c0a",
                "0");
        json.put("d81c0ay",
                "0");
        json.put("d81c0an",
                "0");
        json.put("d81c0f",
                "0");
        json.put("d81c0fq", bi.d81c0fq.getText().toString());
        json.put("d81d0a",
                "0");
        json.put("d81d0ay",
                "0");
        json.put("d81d0an",
                "0");
        json.put("d81d0f",
                "0");
        json.put("d81d0fq", bi.d81d0fq.getText().toString());
        json.put("d81e0a",
                "0");
        json.put("d81e0ay",
                "0");
        json.put("d81e0an",
                "0");
        json.put("d81e0f",
                "0");
        json.put("d81e0fq", bi.d81e0fq.getText().toString());
        json.put("d81f0a",
                "0");
        json.put("d81f0ay",
                "0");
        json.put("d81f0an",
                "0");
        json.put("d81f0f",
                "0");
        json.put("d81f0fq", bi.d81f0fq.getText().toString());
        json.put("d81g0a",
                "0");
        json.put("d81g0ay",
                "0");
        json.put("d81g0an",
                "0");
        json.put("d81g0f",
                "0");
        json.put("d81g0fq", bi.d81g0fq.getText().toString());
        json.put("d81h0a",
                "0");
        json.put("d81h0ay",
                "0");
        json.put("d81h0an",
                "0");
        json.put("d81h0f",
                "0");
        json.put("d81h0fq", bi.d81h0fq.getText().toString());
        json.put("d81i0a",
                "0");
        json.put("d81i0ay",
                "0");
        json.put("d81i0an",
                "0");
        json.put("d81i0f",
                "0");
        json.put("d81i0fq", bi.d81i0fq.getText().toString());
        json.put("d81j0a",
                "0");
        json.put("d81j0ay",
                "0");
        json.put("d81j0an",
                "0");
        json.put("d81j0f",
                "0");
        json.put("d81j0fq", bi.d81j0fq.getText().toString());


        child.setsCB(String.valueOf(json));
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, SectionCHCActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        openChildEndActivity(this);
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
