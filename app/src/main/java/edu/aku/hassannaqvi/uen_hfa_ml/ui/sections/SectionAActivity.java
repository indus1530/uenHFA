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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionABinding;
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity;

public class SectionAActivity extends AppCompatActivity {

    ActivitySectionABinding bi;
    private DatabaseHelper db;
    private static final String TAG = SectionAActivity.class.getName();
    public static FormsContract fc;
    private List<String> reportingMonth, districtNames, districtCodes, tehsilName, tehsilCode, UcNames, ucCode, hfName, hfCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a);
        bi.setCallback(this);
        db = MainApp.appInfo.getDbHelper();
        //tempVisible(this);

    }




    /*private void tempVisible(final Context context) {

        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");
        Collection<District> districts;
        try {
            districts = (Collection<District>) new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getAllDistricts").execute().get();

            if (districts != null) {
                for (District d : districts) {
                    districtNames.add(d.getDistrict_name());
                    districtCodes.add(d.getDistrict_code());
                }
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_dropdown_item, districtNames);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                bi.hfDistrict.setAdapter(dataAdapter);

            } else {
                Toast.makeText(this, "District not found!!", Toast.LENGTH_SHORT).show();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        if (!type.equals(MainApp.DHMT)) {
            bi.hfDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) return;

                    tehsilName = new ArrayList<>();
                    tehsilCode = new ArrayList<>();
                    tehsilName.add("....");
                    tehsilCode.add("....");

                    Collection<Tehsil> tehsils;
                    try {
                        tehsils =
                                (Collection<Tehsil>)
                                        new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getTehsil")
                                                .execute(districtCodes.get(position)).get();

                        if (tehsils.size() != 0) {
                            for (Tehsil fp : tehsils) {
                                tehsilName.add(fp.getTehsil_name());
                                tehsilCode.add(fp.getTehsil_code());
                            }
                        }

                        bi.hfTehsil.setAdapter(new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, tehsilName));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            bi.hfTehsil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) return;

                    hfName = new ArrayList<>();
                    hfCode = new ArrayList<>();
                    hfCode.add("....");
                    hfName.add("....");

                    Collection<FacilityProvider> hfp;
                    try {
                        hfp =
                                *//*(Collection<FacilityProvider>)
                                        new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getFacilityProvider")
                                                .execute(tehsilName.get(position)).get();*//*


                                (Collection<FacilityProvider>)
                                        new GetAllDBData(db, GetFncDAO.class.getName(), "getFncDao", "getFacilityProvider")
                                                .execute("%" + tehsilCode.get(position) + "%", hf_type).get();

                        if (hfp.size() != 0) {
                            for (FacilityProvider fp : hfp) {
                                hfName.add(fp.getHf_name());
                                hfCode.add(fp.getHf_uen_code());

                            }
                        }

                        bi.hfname.setAdapter(new ArrayAdapter<>(context,
                                android.R.layout.simple_spinner_dropdown_item, hfName));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }

        reportingMonth = new ArrayList<>();
        reportingMonth.add("....");
        reportingMonth.add(mon.toUpperCase());
        reportingMonth.add(DateUtils.getMonthsBack("MMM-yy", -1).toUpperCase());
        reportingMonth.add(DateUtils.getMonthsBack("MMM-yy", -2).toUpperCase());
        // Creating adapter for spinner
        ArrayAdapter<String> monAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_dropdown_item, reportingMonth);
        // Drop down layout style - list view with radio button
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        bi.reportMonth.setAdapter(monAdapter);
        bi.reportMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setTitle(type.equals(MainApp.RSD) ? "DHIS Data-Validation Tools for Decision Making (" + bi.reportMonth.getSelectedItem() + ")"
                        : type.equals(MainApp.DHMT) ? "Performance Evaluation of District Team Meetings (" + bi.reportMonth.getSelectedItem() + ")"
                        : type.equals(MainApp.QOC) ? "Key Quality Indicator Tool for Health Facility (" + bi.reportMonth.getSelectedItem() + ")" : " ");

                ClearClass.ClearAllFields(bi.llrsdInfo01, null);
                ClearClass.ClearAllFields(bi.llrsdInfo02, null);
                ClearClass.ClearAllFields(bi.llrsdInfo03, null);
                ClearClass.ClearAllFields(bi.llrsdInfo04, null);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }*/


    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
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

        MainApp.fc.setA11(bi.a11a.isChecked() ? "1"
                : bi.a11b.isChecked() ? "2"
                : "-1");

        MainApp.fc.setA12(String.valueOf(bi.a13.getSelectedItemId()));

        MainApp.fc.setA13(String.valueOf(bi.a13.getSelectedItem()));

    }


    private boolean formValidation() {
        /*if (!Validator.emptyCheckingContainer(this, spinners))
            return;*/
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
