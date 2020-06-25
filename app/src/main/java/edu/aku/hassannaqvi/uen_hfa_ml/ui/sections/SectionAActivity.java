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
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<String> districtNames, tehsilNames, ucNames;
    private List<String> districtCodes, tehsilCodes, ucCodes;
    private DatabaseHelper db;
    public static FormsContract fc;

    private List<String> hfNamesPrv, hfNamesPub;
    private Map<String, String> hfMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        //bi.setFormsContract(MainApp.fc);
        initializingComponents();
        initializeHF();
    }

    private void initializingComponents() {
        // Databinding Edit Mode (only in first activity for every contract)
        MainApp.fc = new FormsContract();
        db = MainApp.appInfo.getDbHelper();
        populateSpinner(this);
    }

    private void initializeHF() {
        //For HF
        hfNamesPrv = new ArrayList<String>() {
            {
                add("....");
            }
        };
        hfNamesPub = new ArrayList<String>() {
            {
                add("....");
            }
        };
        hfMap = new HashMap<>();
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

                //For HF
                initializeHF();

                Collection<UCsContract> pc = db.getAllUCs(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
                for (UCsContract p : pc) {
                    ucCodes.add(p.getUc_code());
                    ucNames.add(p.getUc_name());
                }

                bi.a09.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, ucNames));
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, Collections.emptyList()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.a09.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Clear.clearAllFields(bi.fldGrpCVa10);

                if (position == 0) return;
                if (hfMap.size() > 0) return;
                Collection<HFContract> pc = db.getAllHFs(tehsilCodes.get(bi.a08.getSelectedItemPosition()));
                for (HFContract p : pc) {
                    if (p.getHf_type().equals("1")) hfNamesPub.add(p.getHf_name());
                    else hfNamesPrv.add(p.getHf_name());
                    hfMap.put(p.getHf_name(), p.getHf_code());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.a10.setOnCheckedChangeListener(((radioGroup, i) -> {
            Clear.clearAllFields(bi.fldGrpCVa11);
            if (i == bi.a10a.getId()) {
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNamesPub));
            } else if (i == bi.a10b.getId()) {
                bi.a13.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, hfNamesPrv));
            }
        }));

        bi.a13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
//                Toast.makeText(SectionAActivity.this, String.valueOf(hfCodes.get(bi.a13.getSelectedItemPosition())), Toast.LENGTH_SHORT).show();
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

        MainApp.fc = new FormsContract();

        MainApp.fc.setFormdate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));

        MainApp.fc.setA01(MainApp.userName);

        MainApp.fc.setDeviceID(MainApp.appInfo.getDeviceID());

        MainApp.fc.setDevicetagID(MainApp.appInfo.getTagName());

        MainApp.fc.setAppversion(MainApp.appInfo.getAppVersion());

        MainApp.fc.setA03d(bi.a03d.getText().toString().trim().isEmpty() ? "-1" : bi.a03d.getText().toString());
        MainApp.fc.setA03m(bi.a03m.getText().toString().trim().isEmpty() ? "-1" : bi.a03m.getText().toString());
        MainApp.fc.setA03y(bi.a03y.getText().toString().trim().isEmpty() ? "-1" : bi.a03y.getText().toString());

        MainApp.fc.setA07(bi.a07.getSelectedItem().toString());
        MainApp.fc.setA08(bi.a08.getSelectedItem().toString());
        MainApp.fc.setA09(bi.a09.getSelectedItem().toString());

        MainApp.fc.setA10(bi.a10a.isChecked() ? "1"
                : bi.a10b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setA11(bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setA12(hfMap.get(bi.a13.getSelectedItem().toString()));
        MainApp.fc.setA13(bi.a13.getSelectedItem().toString());

        MainApp.setGPS(this); // Set GPS
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
        /*if (db.CheckHF(String.valueOf(hfMap.get(bi.a13.getSelectedItem().toString())))) {
            Toast.makeText(this, "Facility already filled", Toast.LENGTH_LONG).show();
            return false;
        }*/
    }

}
