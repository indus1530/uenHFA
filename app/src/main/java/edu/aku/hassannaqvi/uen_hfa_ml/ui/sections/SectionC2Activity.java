package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionC2Activity extends AppCompatActivity {

    ActivitySectionC2Binding bi;
    List<View> pofpa15List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);
        setupSkips();
    }


    private void setupSkips() {

        /*bi.c03.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.c03b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVc0401);
            }
        }));*/

        /*bi.pofpa15Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pofpa15List.size() == 4) {
                    Toast.makeText(SectionC2Activity.this, "Can't add more than 5 medicine", Toast.LENGTH_SHORT).show();
                    return;
                }

                addViewInPof15();

            }
        });*/

    }




    /*private void addViewInPof15() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.c200, null);
        bi.pofpa15Items.addView(rowView);
        pofpa15List.add(rowView);

        C200Binding c200Binding = DataBindingUtil.bind(rowView);
        c200Binding.btnClearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bi.pofpa15Items.removeView(rowView);
                pofpa15List.remove(rowView);
            }
        });

    }*/


    private boolean UpdateDB() {
        DatabaseHelper db = MainApp.appInfo.getDbHelper();
     /*   int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, fc.getsC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return false;
    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("c021a", bi.c021a.getText().toString().trim().length() > 0 ? bi.c021a.getText().toString() : "-1");

        json.put("c021b", bi.c021ba.isChecked() ? "1"
                : bi.c021bb.isChecked() ? "2"
                : bi.c021bc.isChecked() ? "3"
                : bi.c021bd.isChecked() ? "4"
                : bi.c021be.isChecked() ? "5"
                : bi.c021bf.isChecked() ? "6"
                : "-1");
        json.put("c021bfx", bi.c021bfx.getText().toString().trim().length() > 0 ? bi.c021bfx.getText().toString() : "-1");

        json.put("c021c", bi.c021c.getText().toString().trim().length() > 0 ? bi.c021c.getText().toString() : "-1");

        json.put("c021d", bi.c021da.isChecked() ? "1"
                : bi.c021db.isChecked() ? "2"
                : bi.c021dc.isChecked() ? "3"
                : bi.c021dd.isChecked() ? "4"
                : bi.c021de.isChecked() ? "5"
                : bi.c021df.isChecked() ? "6"
                : bi.c021dg.isChecked() ? "6"
                : "-1");
        json.put("c021dgx", bi.c021dgx.getText().toString().trim().length() > 0 ? bi.c021dgx.getText().toString() : "-1");

        json.put("c021e", bi.c021e.getText().toString().trim().length() > 0 ? bi.c021e.getText().toString() : "-1");

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
                startActivity(new Intent(this, SectionMainActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }


    public void BtnEnd() {
        openEndActivity(this);
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show();
    }

}
