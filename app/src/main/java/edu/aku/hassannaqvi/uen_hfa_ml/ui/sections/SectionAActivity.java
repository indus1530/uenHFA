package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.DistrictContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.HFContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.TehsilsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.UCsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    private List<String> districtNames, tehsilNames, ucNames, hfNames;
    private List<String> districtCodes, tehsilCodes, ucCodes, hfCodes;
    private DatabaseHelper db;
    private static final String TAG = SectionAActivity.class.getName();
    public static FormsContract fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);

        // Databinding Edit Mode (only in first activity for every contract)
        MainApp.fc = new FormsContract();
        //bi.setFormsContract(MainApp.fc);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();
        initializingComponents();


    }

    private void initializingComponents() {
        db = new DatabaseHelper(this);
        populateSpinner(this);
    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");

        Collection<DistrictContract> dc = db.getAllDistricts();

        for (DistrictContract d : dc) {
            districtNames.add(d.getDistrictName());
            districtCodes.add(d.getDistrictCode());
        }

        bi.a07.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, districtNames));

        bi.a07.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                tehsilNames = new ArrayList<>();
                tehsilCodes = new ArrayList<>();

                tehsilNames.add("....");
                tehsilCodes.add("....");

                Collection<TehsilsContract> pc = db.getAllTehsils(districtCodes.get(position));
                for (TehsilsContract p : pc) {
                    tehsilNames.add(p.getTehsilName());
                    tehsilCodes.add(p.getTehsilCode());
                }

                bi.a08.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, tehsilNames));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });


        bi.a08.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                ucNames = new ArrayList<>();
                ucCodes = new ArrayList<>();

                ucNames.add("....");
                ucCodes.add("....");
                Clear.clearAllFields(bi.fldGrpCVa10);

                Collection<UCsContract> pc = db.getAllUCs(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
                for (UCsContract p : pc) {
                    ucCodes.add(p.getUc_code());
                    ucNames.add(p.getUc_name());
                }

                bi.a09.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bi.a09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                Clear.clearAllFields(bi.fldGrpCVa10);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        bi.a10.setOnCheckedChangeListener(((radioGroup, i) -> {

            if (!Validator.emptyCheckingContainer(this, bi.fldGrpCVa07)) return;
            if (!Validator.emptyCheckingContainer(this, bi.fldGrpCVa08)) return;

            hfNames = new ArrayList<>();
            hfCodes = new ArrayList<>();
            hfNames.add("....");
            hfCodes.add("....");
            Clear.clearAllFields(bi.fldGrpCVa11);

            if (i == bi.a10a.getId()) {
                Collection<HFContract> pc = db.getAllHFs(tehsilCodes.get(bi.a08.getSelectedItemPosition()), "1");
                for (HFContract p : pc) {
                    hfCodes.add(p.getHf_code());
                    hfNames.add(p.getHf_name());
                }
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNames));
            } else {
                Collection<HFContract> pc = db.getAllHFs(tehsilCodes.get(bi.a08.getSelectedItemPosition()), "2");
                for (HFContract p : pc) {
                    hfCodes.add(p.getHf_code());
                    hfNames.add(p.getHf_name());
                }
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNames));

            }
        }));


        bi.a13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                Toast.makeText(SectionAActivity.this, "HF CODE: " + hfCodes.get(bi.a13.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }


    public void BtnContinue() {
        if (!formValidation()) return;
        SaveDraft();
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionMainActivity.class));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean UpdateDB() {
        long updcount = db.addForm(MainApp.fc);
        MainApp.fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            MainApp.fc.set_UID(MainApp.fc.getDeviceID() + MainApp.fc.get_ID());
            db.updatesFormColumn(FormsContract.FormsTable.COLUMN_UID, MainApp.fc.get_UID());
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() {

        MainApp.fc.a01 = MainApp.userName;
        MainApp.fc.a03 = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());
        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());
        MainApp.fc.setAppversion(MainApp.appInfo.getAppVersion());
        MainApp.setGPS(this); // Set GPS

        //MainApp.fc.setA6(String.valueOf(bi.a06.getSelectedItem()));

        MainApp.fc.a07 = String.valueOf(bi.a07.getSelectedItem());

        MainApp.fc.a08 = String.valueOf(bi.a08.getSelectedItem());

        MainApp.fc.a09 = String.valueOf(bi.a09.getSelectedItem());

        MainApp.fc.a10 = bi.a10a.isChecked() ? "1"
                : bi.a10b.isChecked() ? "2"
                : "-1";

        MainApp.fc.a11 = bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1";

        MainApp.fc.a12 = hfCodes.get(bi.a13.getSelectedItemPosition());


        MainApp.fc.a13 = String.valueOf(bi.a13.getSelectedItem());

    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName)) {
            return false;
        }

        if (db.CheckHF(String.valueOf(hfCodes.get(bi.a13.getSelectedItemPosition())), String.valueOf(MainApp.fc.getIstatus().equals("1")))) {
            Toast.makeText(this, "Facility already filled for this Month", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}
