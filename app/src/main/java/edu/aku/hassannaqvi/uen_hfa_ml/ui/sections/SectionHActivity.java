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
import edu.aku.hassannaqvi.uen_hfa_ml.contracts.FormsContract;
import edu.aku.hassannaqvi.uen_hfa_ml.core.DatabaseHelper;
import edu.aku.hassannaqvi.uen_hfa_ml.core.MainApp;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionHBinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionHActivity extends AppCompatActivity {

    ActivitySectionHBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_h);
        bi.setCallback(this);
        //setTitle(R.string.sssec);
        setupSkips();


    }


    private void setupSkips() {

        /*bi.ss04.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss04b.getId()) {
                Clear.clearAllFields(bi.ss05cv, false);
            } else {
                Clear.clearAllFields(bi.ss05cv, true);
            }
        }));*/


        /*bi.ss07.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss07h.getId() || i == bi.ss07i.getId()) {
                Clear.clearAllFields(bi.ss08cv, false);
                Clear.clearAllFields(bi.ss09cv, false);
                Clear.clearAllFields(bi.ss10cv, false);
                Clear.clearAllFields(bi.ss11cv, false);
                Clear.clearAllFields(bi.ss12cv, false);
            } else {
                Clear.clearAllFields(bi.ss08cv, true);
                Clear.clearAllFields(bi.ss09cv, true);
                Clear.clearAllFields(bi.ss10cv, true);
                Clear.clearAllFields(bi.ss11cv, true);
                Clear.clearAllFields(bi.ss12cv, true);
            }
        }));*/


        /*bi.ss09.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss09b.getId()) {
                Clear.clearAllFields(bi.ss10cv, false);
                Clear.clearAllFields(bi.ss11cv, false);
                Clear.clearAllFields(bi.ss12cv, false);

            } else {
                Clear.clearAllFields(bi.ss10cv, true);
                Clear.clearAllFields(bi.ss11cv, true);
                Clear.clearAllFields(bi.ss12cv, true);

            }
        }));*/


        /*bi.ss11.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss11b.getId()) {
                Clear.clearAllFields(bi.ss12cv, false);
                Clear.clearAllFields(bi.ss13cv, false);
            } else {
                Clear.clearAllFields(bi.ss12cv, true);
                Clear.clearAllFields(bi.ss13cv, true);
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
                startActivity(new Intent(this, SectionIActivity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SE, MainApp.fc.getsE());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("h11", bi.h11.getText().toString());
        json.put("h11aa", bi.h11aa.getText().toString());
        json.put("h11ab", bi.h11ab.getText().toString());
        json.put("h11ba", bi.h11ba.getText().toString());
        json.put("h11bb", bi.h11bb.getText().toString());
        json.put("h11ca", bi.h11ca.getText().toString());
        json.put("h11cb", bi.h11cb.getText().toString());
        json.put("h21",
                bi.h21a.isChecked() ? "1" :
                        bi.h21b.isChecked() ? "2" :
                                "0");
        json.put("h22",
                bi.h22a.isChecked() ? "1" :
                        bi.h22b.isChecked() ? "2" :
                                bi.h22c.isChecked() ? "3" :
                                        "0");
        json.put("h23",
                "0");
        json.put("h23a",
                bi.h23aa.isChecked() ? "1" :
                        bi.h23ab.isChecked() ? "2" :
                                bi.h23ac.isChecked() ? "3" :
                                        bi.h23ad.isChecked() ? "4" :
                                                "0");
        json.put("h23b",
                bi.h23ba.isChecked() ? "1" :
                        bi.h23bb.isChecked() ? "2" :
                                bi.h23bc.isChecked() ? "3" :
                                        bi.h23bd.isChecked() ? "4" :
                                                "0");
        json.put("h31a0a",
                bi.h31a0ay.isChecked() ? "1" :
                        bi.h31a0an.isChecked() ? "2" :
                                "0");
        json.put("h31a0b",
                bi.h31a0by.isChecked() ? "1" :
                        bi.h31a0bn.isChecked() ? "2" :
                                "0");
        json.put("h31a0c",
                bi.h31a0cy.isChecked() ? "1" :
                        bi.h31a0cn.isChecked() ? "2" :
                                "0");
        json.put("h31b0a",
                bi.h31b0ay.isChecked() ? "1" :
                        bi.h31b0an.isChecked() ? "2" :
                                "0");
        json.put("h31b0b",
                bi.h31b0by.isChecked() ? "1" :
                        bi.h31b0bn.isChecked() ? "2" :
                                "0");
        json.put("h31b0c",
                bi.h31b0cy.isChecked() ? "1" :
                        bi.h31b0cn.isChecked() ? "2" :
                                "0");
        json.put("h31c0a",
                bi.h31c0ay.isChecked() ? "1" :
                        bi.h31c0an.isChecked() ? "2" :
                                "0");
        json.put("h31c0b",
                bi.h31c0by.isChecked() ? "1" :
                        bi.h31c0bn.isChecked() ? "2" :
                                "0");
        json.put("h31c0c",
                bi.h31c0cy.isChecked() ? "1" :
                        bi.h31c0cn.isChecked() ? "2" :
                                "0");
        json.put("h31d0a",
                bi.h31d0ay.isChecked() ? "1" :
                        bi.h31d0an.isChecked() ? "2" :
                                "0");
        json.put("h31d0b",
                bi.h31d0by.isChecked() ? "1" :
                        bi.h31d0bn.isChecked() ? "2" :
                                "0");
        json.put("h31d0c",
                bi.h31d0cy.isChecked() ? "1" :
                        bi.h31d0cn.isChecked() ? "2" :
                                "0");
        json.put("h31e0a",
                bi.h31e0ay.isChecked() ? "1" :
                        bi.h31e0an.isChecked() ? "2" :
                                "0");
        json.put("h31e0b",
                bi.h31e0by.isChecked() ? "1" :
                        bi.h31e0bn.isChecked() ? "2" :
                                "0");
        json.put("h31e0c",
                bi.h31e0cy.isChecked() ? "1" :
                        bi.h31e0cn.isChecked() ? "2" :
                                "0");
        json.put("h31f0a",
                bi.h31f0ay.isChecked() ? "1" :
                        bi.h31f0an.isChecked() ? "2" :
                                "0");
        json.put("h31f0b",
                bi.h31f0by.isChecked() ? "1" :
                        bi.h31f0bn.isChecked() ? "2" :
                                "0");
        json.put("h31f0c",
                bi.h31f0cy.isChecked() ? "1" :
                        bi.h31f0cn.isChecked() ? "2" :
                                "0");
        json.put("h31g0a",
                bi.h31g0ay.isChecked() ? "1" :
                        bi.h31g0an.isChecked() ? "2" :
                                "0");
        json.put("h31g0b",
                bi.h31g0by.isChecked() ? "1" :
                        bi.h31g0bn.isChecked() ? "2" :
                                "0");
        json.put("h31g0c",
                bi.h31g0cy.isChecked() ? "1" :
                        bi.h31g0cn.isChecked() ? "2" :
                                "0");
        json.put("h31h0a",
                bi.h31h0ay.isChecked() ? "1" :
                        bi.h31h0an.isChecked() ? "2" :
                                "0");
        json.put("h31h0b",
                bi.h31h0by.isChecked() ? "1" :
                        bi.h31h0bn.isChecked() ? "2" :
                                "0");
        json.put("h31h0c",
                bi.h31h0cy.isChecked() ? "1" :
                        bi.h31h0cn.isChecked() ? "2" :
                                "0");
        json.put("h31i0a",
                bi.h31i0ay.isChecked() ? "1" :
                        bi.h31i0an.isChecked() ? "2" :
                                "0");
        json.put("h31i0b",
                bi.h31i0by.isChecked() ? "1" :
                        bi.h31i0bn.isChecked() ? "2" :
                                "0");
        json.put("h31i0c",
                bi.h31i0cy.isChecked() ? "1" :
                        bi.h31i0cn.isChecked() ? "2" :
                                "0");
        json.put("h31j0a",
                bi.h31j0ay.isChecked() ? "1" :
                        bi.h31j0an.isChecked() ? "2" :
                                "0");
        json.put("h31j0b",
                bi.h31j0by.isChecked() ? "1" :
                        bi.h31j0bn.isChecked() ? "2" :
                                "0");
        json.put("h31j0c",
                bi.h31j0cy.isChecked() ? "1" :
                        bi.h31j0cn.isChecked() ? "2" :
                                "0");
        json.put("h31k0a",
                bi.h31k0ay.isChecked() ? "1" :
                        bi.h31k0an.isChecked() ? "2" :
                                "0");
        json.put("h31k0b",
                bi.h31k0by.isChecked() ? "1" :
                        bi.h31k0bn.isChecked() ? "2" :
                                "0");
        json.put("h31k0c",
                bi.h31k0cy.isChecked() ? "1" :
                        bi.h31k0cn.isChecked() ? "2" :
                                "0");
        json.put("h31l0a",
                bi.h31l0ay.isChecked() ? "1" :
                        bi.h31l0an.isChecked() ? "2" :
                                "0");
        json.put("h31l0b",
                bi.h31l0by.isChecked() ? "1" :
                        bi.h31l0bn.isChecked() ? "2" :
                                "0");
        json.put("h31l0c",
                bi.h31l0cy.isChecked() ? "1" :
                        bi.h31l0cn.isChecked() ? "2" :
                                "0");
        json.put("h31m0a",
                bi.h31m0ay.isChecked() ? "1" :
                        bi.h31m0an.isChecked() ? "2" :
                                "0");
        json.put("h31m0b",
                bi.h31m0by.isChecked() ? "1" :
                        bi.h31m0bn.isChecked() ? "2" :
                                "0");
        json.put("h31m0c",
                bi.h31m0cy.isChecked() ? "1" :
                        bi.h31m0cn.isChecked() ? "2" :
                                "0");
        json.put("h41",
                bi.h41a.isChecked() ? "1" :
                        bi.h41b.isChecked() ? "2" :
                                bi.h41c.isChecked() ? "3" :
                                        bi.h41d.isChecked() ? "4" :
                                                bi.h41x.isChecked() ? "96" :
                                                        "0");
        json.put("h41xx", bi.h41xx.getText().toString());
        json.put("h51",
                bi.h51a.isChecked() ? "1" :
                        bi.h51b.isChecked() ? "2" :
                                bi.h51c.isChecked() ? "3" :
                                        bi.h51x.isChecked() ? "96" :
                                                "0");
        json.put("h51xx", bi.h51xx.getText().toString());
        json.put("h61",
                bi.h61a.isChecked() ? "1" :
                        bi.h61b.isChecked() ? "2" :
                                "0");
        json.put("h61aa",
                bi.h61aaa.isChecked() ? "1" :
                        "0");
        json.put("h61aaax", bi.h61aaax.getText().toString());
        json.put("h62",
                bi.h62a.isChecked() ? "1" :
                        bi.h62b.isChecked() ? "2" :
                                "0");
        json.put("h63",
                "0");
        json.put("h63a",
                bi.h63aa.isChecked() ? "1" :
                        bi.h63ab.isChecked() ? "2" :
                                "0");
        json.put("h63b",
                bi.h63ba.isChecked() ? "1" :
                        bi.h63bb.isChecked() ? "2" :
                                "0");
        json.put("h63c",
                bi.h63ca.isChecked() ? "1" :
                        bi.h63cb.isChecked() ? "2" :
                                "0");
        json.put("h71",
                "0");
        json.put("h71a",
                bi.h71aa.isChecked() ? "1" :
                        bi.h71ab.isChecked() ? "2" :
                                "0");
        json.put("h71b",
                bi.h71ba.isChecked() ? "1" :
                        bi.h71bb.isChecked() ? "2" :
                                "0");
        json.put("h71c",
                bi.h71ca.isChecked() ? "1" :
                        bi.h71cb.isChecked() ? "2" :
                                "0");
        json.put("h71d",
                bi.h71da.isChecked() ? "1" :
                        bi.h71db.isChecked() ? "2" :
                                "0");
        json.put("h71e",
                bi.h71ea.isChecked() ? "1" :
                        bi.h71eb.isChecked() ? "2" :
                                "0");
        json.put("h71f",
                bi.h71fa.isChecked() ? "1" :
                        bi.h71fb.isChecked() ? "2" :
                                "0");
        json.put("h71g",
                bi.h71ga.isChecked() ? "1" :
                        bi.h71gb.isChecked() ? "2" :
                                "0");
        json.put("h81",
                bi.h81a.isChecked() ? "1" :
                        bi.h81b.isChecked() ? "2" :
                                "0");
        json.put("h82",
                bi.h82a.isChecked() ? "1" :
                        bi.h82b.isChecked() ? "2" :
                                "0");
        json.put("h91",
                bi.h91a.isChecked() ? "1" :
                        bi.h91b.isChecked() ? "2" :
                                "0");
        json.put("h92",
                "0");
        json.put("h92a",
                bi.h92aa.isChecked() ? "1" :
                        bi.h92ab.isChecked() ? "2" :
                                "0");
        json.put("h92b",
                bi.h92ba.isChecked() ? "1" :
                        bi.h93bb.isChecked() ? "2" :
                                "0");
        json.put("h92c",
                bi.h92ca.isChecked() ? "1" :
                        bi.h932cb.isChecked() ? "2" :
                                "0");
        json.put("h101",
                bi.h101a.isChecked() ? "1" :
                        bi.h101b.isChecked() ? "2" :
                                "0");
        json.put("h102",
                "0");
        json.put("h102a",
                bi.h102aa.isChecked() ? "1" :
                        bi.h102ab.isChecked() ? "2" :
                                "0");
        json.put("h102b",
                bi.h012ba.isChecked() ? "1" :
                        bi.b102bb.isChecked() ? "2" :
                                "0");
        json.put("h111",
                bi.h111a.isChecked() ? "1" :
                        bi.h111b.isChecked() ? "2" :
                                "0");
        json.put("h112",
                bi.h112a.isChecked() ? "1" :
                        bi.h112b.isChecked() ? "2" :
                                "0");
        json.put("h113",
                bi.h113a.isChecked() ? "1" :
                        bi.h113b.isChecked() ? "2" :
                                bi.h113c.isChecked() ? "3" :
                                        bi.h113d.isChecked() ? "4" :
                                                bi.h113e.isChecked() ? "5" :
                                                        bi.h113f.isChecked() ? "6" :
                                                                "0");
        json.put("h114",
                bi.h114a.isChecked() ? "1" :
                        bi.h114b.isChecked() ? "2" :
                                bi.h114c.isChecked() ? "3" :
                                        bi.h114d.isChecked() ? "4" :
                                                bi.h114e.isChecked() ? "5" :
                                                        bi.h114f.isChecked() ? "6" :
                                                                "0");
        json.put("h115",
                bi.h115a.isChecked() ? "1" :
                        bi.h115b.isChecked() ? "2" :
                                "0");
        json.put("h116a", bi.h116a.getText().toString());
        json.put("h117",
                bi.h117a.isChecked() ? "1" :
                        bi.h117b.isChecked() ? "2" :
                                "0");
        json.put("h121",
                bi.h121a.isChecked() ? "1" :
                        bi.h121b.isChecked() ? "2" :
                                "0");
        json.put("h122",
                bi.h122a.isChecked() ? "1" :
                        bi.h122b.isChecked() ? "2" :
                                "0");
        json.put("h123",
                "0");
        json.put("h123a",
                bi.h123aa.isChecked() ? "1" :
                        bi.h123ab.isChecked() ? "2" :
                                "0");
        json.put("h123b",
                bi.h123ba.isChecked() ? "1" :
                        bi.h123bb.isChecked() ? "2" :
                                "0");
        json.put("h123c",
                bi.h123ca.isChecked() ? "1" :
                        bi.h123cb.isChecked() ? "2" :
                                "0");
        json.put("h123e",
                bi.h123ea.isChecked() ? "1" :
                        bi.h123eb.isChecked() ? "2" :
                                "0");
        json.put("h123d",
                bi.h123da.isChecked() ? "1" :
                        bi.h123db.isChecked() ? "2" :
                                "0");
        json.put("h123f",
                bi.h123fa.isChecked() ? "1" :
                        bi.h123fb.isChecked() ? "2" :
                                "0");
        json.put("h123g",
                bi.h123ga.isChecked() ? "1" :
                        bi.h123gb.isChecked() ? "2" :
                                "0");
        json.put("h131",
                bi.h131a.isChecked() ? "1" :
                        bi.h131b.isChecked() ? "2" :
                                bi.h131c.isChecked() ? "3" :
                                        bi.h131d.isChecked() ? "4" :
                                                bi.h131e.isChecked() ? "5" :
                                                        bi.h131f.isChecked() ? "6" :
                                                                "0");
        json.put("h132",
                bi.h132a.isChecked() ? "1" :
                        bi.h132b.isChecked() ? "2" :
                                "0");
        json.put("h133",
                bi.h133a.isChecked() ? "1" :
                        bi.h133b.isChecked() ? "2" :
                                "0");
        json.put("h141", bi.h141.getText().toString());
        json.put("h141aa", bi.h141aa.getText().toString());
        json.put("h141ab", bi.h141ab.getText().toString());
        json.put("h141ba", bi.h141ba.getText().toString());
        json.put("h141bb", bi.h141bb.getText().toString());
        json.put("h141ca", bi.h141ca.getText().toString());
        json.put("h141cb", bi.h141cb.getText().toString());
        json.put("h141da", bi.h141da.getText().toString());
        json.put("h141db", bi.h141db.getText().toString());
        json.put("h141ea", bi.h141ea.getText().toString());
        json.put("h141eb", bi.h141eb.getText().toString());
        json.put("81501",
                "0");
        json.put("h151a0a",
                bi.h151a0ay.isChecked() ? "1" :
                        bi.h151a0an.isChecked() ? "2" :
                                "0");
        json.put("h151a0b",
                bi.h151a0by.isChecked() ? "1" :
                        bi.h151a0bn.isChecked() ? "2" :
                                "0");
        json.put("h151a0c",
                bi.h151a0cy.isChecked() ? "1" :
                        bi.h151a0cn.isChecked() ? "2" :
                                "0");
        json.put("h151a0dy", bi.h151a0dy.getText().toString());
        json.put("h151a0dn", bi.h151a0dn.getText().toString());
        json.put("h151b0a",
                bi.h151b0ay.isChecked() ? "1" :
                        bi.h151b0an.isChecked() ? "2" :
                                "0");
        json.put("h151b0b",
                bi.h151b0by.isChecked() ? "1" :
                        bi.h151b0bn.isChecked() ? "2" :
                                "0");
        json.put("h151b0c",
                bi.h151b0cy.isChecked() ? "1" :
                        bi.h151b0cn.isChecked() ? "2" :
                                "0");
        json.put("h151b0dy", bi.h151b0dy.getText().toString());
        json.put("h151b0dn", bi.h151b0dn.getText().toString());
        json.put("h151c0a",
                bi.h151c0ay.isChecked() ? "1" :
                        bi.h151c0an.isChecked() ? "2" :
                                "0");
        json.put("h151c0b",
                bi.h151c0by.isChecked() ? "1" :
                        bi.h151c0bn.isChecked() ? "2" :
                                "0");
        json.put("h151c0c",
                bi.h151c0cy.isChecked() ? "1" :
                        bi.h151c0cn.isChecked() ? "2" :
                                "0");
        json.put("h151c0dy", bi.h151c0dy.getText().toString());
        json.put("h151c0dn", bi.h151c0dn.getText().toString());
        json.put("h151d0a",
                bi.h151d0ay.isChecked() ? "1" :
                        bi.h151d0an.isChecked() ? "2" :
                                "0");
        json.put("h151d0b",
                bi.h151d0by.isChecked() ? "1" :
                        bi.h151d0bn.isChecked() ? "2" :
                                "0");
        json.put("h151d0c",
                bi.h151d0cy.isChecked() ? "1" :
                        bi.h151d0cn.isChecked() ? "2" :
                                "0");
        json.put("h151d0dy", bi.h151d0dy.getText().toString());
        json.put("h151d0dn", bi.h151d0dn.getText().toString());
        json.put("h151e0a",
                bi.h151e0ay.isChecked() ? "1" :
                        bi.h151e0an.isChecked() ? "2" :
                                "0");
        json.put("h151e0b",
                bi.h151e0by.isChecked() ? "1" :
                        bi.h151e0bn.isChecked() ? "2" :
                                "0");
        json.put("h151e0c",
                bi.h151e0cy.isChecked() ? "1" :
                        bi.h151e0cn.isChecked() ? "2" :
                                "0");
        json.put("h151e0dy", bi.h151e0dy.getText().toString());
        json.put("h151e0dn", bi.h151e0dn.getText().toString());
        json.put("h151f0a",
                bi.h151f0ay.isChecked() ? "1" :
                        bi.h151f0an.isChecked() ? "2" :
                                "0");
        json.put("h151f0b",
                bi.h151f0by.isChecked() ? "1" :
                        bi.h151f0bn.isChecked() ? "2" :
                                "0");
        json.put("h151f0c",
                bi.h151f0cy.isChecked() ? "1" :
                        bi.h151f0cn.isChecked() ? "2" :
                                "0");
        json.put("h151f0dy", bi.h151f0dy.getText().toString());
        json.put("h151f0dn", bi.h151f0dn.getText().toString());
        json.put("h151g0a",
                bi.h151g0ay.isChecked() ? "1" :
                        bi.h151g0an.isChecked() ? "2" :
                                "0");
        json.put("h151g0b",
                bi.h151g0by.isChecked() ? "1" :
                        bi.h151g0bn.isChecked() ? "2" :
                                "0");
        json.put("h151g0c",
                bi.h151g0cy.isChecked() ? "1" :
                        bi.h151g0cn.isChecked() ? "2" :
                                "0");
        json.put("h151g0dy", bi.h151g0dy.getText().toString());
        json.put("h151g0dn", bi.h151g0dn.getText().toString());
        json.put("h151h0a",
                bi.h151h0ay.isChecked() ? "1" :
                        bi.h151h0an.isChecked() ? "2" :
                                "0");
        json.put("h151h0b",
                bi.h151h0by.isChecked() ? "1" :
                        bi.h151h0bn.isChecked() ? "2" :
                                "0");
        json.put("h151h0c",
                bi.h151h0cy.isChecked() ? "1" :
                        bi.h151h0cn.isChecked() ? "2" :
                                "0");
        json.put("h151h0dy", bi.h151h0dy.getText().toString());
        json.put("h151h0dn", bi.h151h0dn.getText().toString());
        json.put("h151i0a",
                bi.h151i0ay.isChecked() ? "1" :
                        bi.h151i0an.isChecked() ? "2" :
                                "0");
        json.put("h151i0b",
                bi.h151i0by.isChecked() ? "1" :
                        bi.h151i0bn.isChecked() ? "2" :
                                "0");
        json.put("h151i0c",
                bi.h151i0cy.isChecked() ? "1" :
                        bi.h151i0cn.isChecked() ? "2" :
                                "0");
        json.put("h151i0dy", bi.h151i0dy.getText().toString());
        json.put("h151i0dn", bi.h151i0dn.getText().toString());
        json.put("h151j0a",
                bi.h151j0ay.isChecked() ? "1" :
                        bi.h151j0an.isChecked() ? "2" :
                                "0");
        json.put("h151j0b",
                bi.h151j0by.isChecked() ? "1" :
                        bi.h151j0bn.isChecked() ? "2" :
                                "0");
        json.put("h151j0c",
                bi.h151j0cy.isChecked() ? "1" :
                        bi.h151j0cn.isChecked() ? "2" :
                                "0");
        json.put("h151j0dy", bi.h151j0dy.getText().toString());
        json.put("h151j0dn", bi.h151j0dn.getText().toString());
        json.put("h151k0a",
                bi.h151k0ay.isChecked() ? "1" :
                        bi.h151k0an.isChecked() ? "2" :
                                "0");
        json.put("h151k0b",
                bi.h151k0by.isChecked() ? "1" :
                        bi.h151k0bn.isChecked() ? "2" :
                                "0");
        json.put("h151k0c",
                bi.h151k0cy.isChecked() ? "1" :
                        bi.h151k0cn.isChecked() ? "2" :
                                "0");
        json.put("h151k0dy", bi.h151k0dy.getText().toString());
        json.put("h151k0dn", bi.h151k0dn.getText().toString());
        json.put("h151l0a",
                bi.h151l0ay.isChecked() ? "1" :
                        bi.h151l0an.isChecked() ? "2" :
                                "0");
        json.put("h151l0b",
                bi.h151l0by.isChecked() ? "1" :
                        bi.h151l0bn.isChecked() ? "2" :
                                "0");
        json.put("h151l0c",
                bi.h151l0cy.isChecked() ? "1" :
                        bi.h151l0cn.isChecked() ? "2" :
                                "0");
        json.put("h151l0dy", bi.h151l0dy.getText().toString());
        json.put("h151l0dn", bi.h151l0dn.getText().toString());
        json.put("h151m0a",
                bi.h151m0ay.isChecked() ? "1" :
                        bi.h151m0an.isChecked() ? "2" :
                                "0");
        json.put("h151m0b",
                bi.h151m0by.isChecked() ? "1" :
                        bi.h151m0bn.isChecked() ? "2" :
                                "0");
        json.put("h151m0c",
                bi.h151m0cy.isChecked() ? "1" :
                        bi.h151m0cn.isChecked() ? "2" :
                                "0");
        json.put("h151m0dy", bi.h151m0dy.getText().toString());
        json.put("h151m0dn", bi.h151m0dn.getText().toString());
        json.put("h151n0a",
                bi.h151n0ay.isChecked() ? "1" :
                        bi.h151n0an.isChecked() ? "2" :
                                "0");
        json.put("h151n0b",
                bi.h151n0by.isChecked() ? "1" :
                        bi.h151n0bn.isChecked() ? "2" :
                                "0");
        json.put("h151n0c",
                bi.h151n0cy.isChecked() ? "1" :
                        bi.h151n0cn.isChecked() ? "2" :
                                "0");
        json.put("h151n0dy", bi.h151n0dy.getText().toString());
        json.put("h151n0dn", bi.h151n0dn.getText().toString());
        json.put("h151o0a",
                bi.h151o0ay.isChecked() ? "1" :
                        bi.h151o0an.isChecked() ? "2" :
                                "0");
        json.put("h151o0b",
                bi.h151o0by.isChecked() ? "1" :
                        bi.h151o0bn.isChecked() ? "2" :
                                "0");
        json.put("h151o0c",
                bi.h151o0cy.isChecked() ? "1" :
                        bi.h151o0cn.isChecked() ? "2" :
                                "0");
        json.put("h151o0dy", bi.h151o0dy.getText().toString());
        json.put("h151o0dn", bi.h151o0dn.getText().toString());
        json.put("h151p0a",
                bi.h151p0ay.isChecked() ? "1" :
                        bi.h151p0an.isChecked() ? "2" :
                                "0");
        json.put("h151p0b",
                bi.h151p0by.isChecked() ? "1" :
                        bi.h151p0bn.isChecked() ? "2" :
                                "0");
        json.put("h151p0c",
                bi.h151p0cy.isChecked() ? "1" :
                        bi.h151p0cn.isChecked() ? "2" :
                                "0");
        json.put("h151p0dy", bi.h151p0dy.getText().toString());
        json.put("h151p0dn", bi.h151p0dn.getText().toString());
        json.put("h151q0a",
                bi.h151q0ay.isChecked() ? "1" :
                        bi.h151q0an.isChecked() ? "2" :
                                "0");
        json.put("h151q0b",
                bi.h151q0by.isChecked() ? "1" :
                        bi.h151q0bn.isChecked() ? "2" :
                                "0");
        json.put("h151q0c",
                bi.h151q0cy.isChecked() ? "1" :
                        bi.h151q0cn.isChecked() ? "2" :
                                "0");
        json.put("h151q0dy", bi.h151q0dy.getText().toString());
        json.put("h151q0dn", bi.h151q0dn.getText().toString());
        json.put("h151r0a",
                bi.h151r0ay.isChecked() ? "1" :
                        bi.h151r0an.isChecked() ? "2" :
                                "0");
        json.put("h151r0b",
                bi.h151r0by.isChecked() ? "1" :
                        bi.h151r0bn.isChecked() ? "2" :
                                "0");
        json.put("h151r0c",
                bi.h151r0cy.isChecked() ? "1" :
                        bi.h151r0cn.isChecked() ? "2" :
                                "0");
        json.put("h151r0dy", bi.h151r0dy.getText().toString());
        json.put("h151r0dn", bi.h151r0dn.getText().toString());
        json.put("h151s0a",
                bi.h151s0ay.isChecked() ? "1" :
                        bi.h151s0an.isChecked() ? "2" :
                                "0");
        json.put("h151s0b",
                bi.h151s0by.isChecked() ? "1" :
                        bi.h151s0bn.isChecked() ? "2" :
                                "0");
        json.put("h151s0c",
                bi.h151s0cy.isChecked() ? "1" :
                        bi.h151s0cn.isChecked() ? "2" :
                                "0");
        json.put("h151s0dy", bi.h151s0dy.getText().toString());
        json.put("h151s0dn", bi.h151s0dn.getText().toString());
        json.put("h151t0a",
                bi.h151t0ay.isChecked() ? "1" :
                        bi.h151t0an.isChecked() ? "2" :
                                "0");
        json.put("h151t0b",
                bi.h151t0by.isChecked() ? "1" :
                        bi.h151t0bn.isChecked() ? "2" :
                                "0");
        json.put("h151t0c",
                bi.h151t0cy.isChecked() ? "1" :
                        bi.h151t0cn.isChecked() ? "2" :
                                "0");
        json.put("h151t0dy", bi.h151t0dy.getText().toString());
        json.put("h151t0dn", bi.h151t0dn.getText().toString());
        json.put("h151u0a",
                bi.h151u0ay.isChecked() ? "1" :
                        bi.h151u0an.isChecked() ? "2" :
                                "0");
        json.put("h151u0b",
                bi.h151u0by.isChecked() ? "1" :
                        bi.h151u0bn.isChecked() ? "2" :
                                "0");
        json.put("h151u0c",
                bi.h151u0cy.isChecked() ? "1" :
                        bi.h151u0cn.isChecked() ? "2" :
                                "0");
        json.put("h151u0dy", bi.h151u0dy.getText().toString());
        json.put("h151u0dn", bi.h151u0dn.getText().toString());
        json.put("h151v0a",
                bi.h151v0ay.isChecked() ? "1" :
                        bi.h151v0an.isChecked() ? "2" :
                                "0");
        json.put("h151v0b",
                bi.h151v0by.isChecked() ? "1" :
                        bi.h151v0bn.isChecked() ? "2" :
                                "0");
        json.put("h151v0c",
                bi.h151v0cy.isChecked() ? "1" :
                        bi.h151v0cn.isChecked() ? "2" :
                                "0");
        json.put("h151v0dy", bi.h151v0dy.getText().toString());
        json.put("h151v0dn", bi.h151v0dn.getText().toString());
        json.put("h151w0a",
                bi.h151w0ay.isChecked() ? "1" :
                        bi.h151w0an.isChecked() ? "2" :
                                "0");
        json.put("h151w0b",
                bi.h151w0by.isChecked() ? "1" :
                        bi.h151w0bn.isChecked() ? "2" :
                                "0");
        json.put("h151w0c",
                bi.h151w0cy.isChecked() ? "1" :
                        bi.h151w0cn.isChecked() ? "2" :
                                "0");
        json.put("h151w0dy", bi.h151w0dy.getText().toString());
        json.put("h151w0dn", bi.h151w0dn.getText().toString());
        json.put("h151x0a",
                bi.h151x0ay.isChecked() ? "1" :
                        bi.h151x0an.isChecked() ? "2" :
                                "0");
        json.put("h151x0b",
                bi.h151x0by.isChecked() ? "1" :
                        bi.h151x0bn.isChecked() ? "2" :
                                "0");
        json.put("h151x0c",
                bi.h151x0cy.isChecked() ? "1" :
                        bi.h151x0cn.isChecked() ? "2" :
                                "0");
        json.put("h151x0dy", bi.h151x0dy.getText().toString());
        json.put("h151x0dn", bi.h151x0dn.getText().toString());
        json.put("h151y0a",
                bi.h151y0ay.isChecked() ? "1" :
                        bi.h151y0an.isChecked() ? "2" :
                                "0");
        json.put("h151y0b",
                bi.h151y0by.isChecked() ? "1" :
                        bi.h151y0bn.isChecked() ? "2" :
                                "0");
        json.put("h151y0c",
                bi.h151y0cy.isChecked() ? "1" :
                        bi.h151y0cn.isChecked() ? "2" :
                                "0");
        json.put("h151y0dy", bi.h151y0dy.getText().toString());
        json.put("h151y0dn", bi.h151y0dn.getText().toString());
        json.put("h151z0a",
                bi.h151z0ay.isChecked() ? "1" :
                        bi.h151z0an.isChecked() ? "2" :
                                "0");
        json.put("h151z0b",
                bi.h151z0by.isChecked() ? "1" :
                        bi.h151z0bn.isChecked() ? "2" :
                                "0");
        json.put("h151z0c",
                bi.h151z0cy.isChecked() ? "1" :
                        bi.h151z0cn.isChecked() ? "2" :
                                "0");
        json.put("h151z0dy", bi.h151z0dy.getText().toString());
        json.put("h151z0dn", bi.h151z0dn.getText().toString());
        json.put("h161",
                bi.h161a.isChecked() ? "1" :
                        bi.h161b.isChecked() ? "2" :
                                "0");
        json.put("h162",
                bi.h162a.isChecked() ? "1" :
                        bi.h162b.isChecked() ? "2" :
                                bi.h162c.isChecked() ? "3" :
                                        bi.h162x.isChecked() ? "96" :
                                                "0");
        json.put("h162xx", bi.h162xx.getText().toString());
        json.put("h163",
                bi.h163a.isChecked() ? "1" :
                        bi.h163b.isChecked() ? "2" :
                                bi.h163c.isChecked() ? "3" :
                                        bi.h163x.isChecked() ? "96" :
                                                "0");
        json.put("h163xx", bi.h163xx.getText().toString());
        json.put("h164",
                bi.h164a.isChecked() ? "1" :
                        bi.h164b.isChecked() ? "2" :
                                "0");
        json.put("h165",
                bi.h165a.isChecked() ? "1" :
                        bi.h165b.isChecked() ? "2" :
                                bi.h165c.isChecked() ? "3" :
                                        bi.h165d.isChecked() ? "4" :
                                                bi.h165e.isChecked() ? "5" :
                                                        bi.h165x.isChecked() ? "96" :
                                                                "0");
        json.put("h165xx", bi.h165xx.getText().toString());

        MainApp.fc.setsE(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionH);

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
