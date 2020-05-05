package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

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
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionJBinding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionJActivity extends AppCompatActivity {

    ActivitySectionJBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_j);
        bi.setCallback(this);
        setupSkips();

    }


    private void setupSkips() {

        /*bi.ss22.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss22b.getId()) {
                Clear.clearAllFields(bi.fldGrpCVss23, false);
            } else {
                Clear.clearAllFields(bi.fldGrpCVss23, true);
            }
        }));*/


        /*bi.ss24.setOnCheckedChangeListener(((radioGroup, i) -> {
            if (i == bi.ss24b.getId()) {
                Clear.clearAllFields(bi.ss25cvall, false);
            } else {
                Clear.clearAllFields(bi.ss25cvall, true);
            }
        }));*/

    }


    public void BtnContinue() {
        /*if (formValidation()) {
            try {
                SaveDraft();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();

                selectedChildren = FamilyMembersListActivity.mainVModel.getAllUnder12();
                Class<?> T = EndingActivity.class;
                if (selectedChildren.getFirst().size() > 0) T = SectionCHAActivity.class;
                startActivity(new Intent(this, T).putExtra("complete", true));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }*/
    }


    private boolean UpdateDB() {

        DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SM, MainApp.fc.getsM());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    private void SaveDraft() throws JSONException {

        JSONObject json = new JSONObject();

        json.put("j11",
                bi.j1a.isChecked() ? "1" :
                        bi.j1b.isChecked() ? "2" :
                                "0");
        json.put("j1aa",
                bi.j1aaa.isChecked() ? "1" :
                        bi.j1aab.isChecked() ? "2" :
                                "0");
        json.put("j11a",
                bi.j11aa.isChecked() ? "1" :
                        bi.j11ab.isChecked() ? "2" :
                                "0");
        json.put("j11b",
                bi.j11ba.isChecked() ? "1" :
                        bi.j11bb.isChecked() ? "2" :
                                "0");
        json.put("j11c",
                bi.j11ca.isChecked() ? "1" :
                        bi.j11cb.isChecked() ? "2" :
                                "0");
        json.put("j11d",
                bi.j11da.isChecked() ? "1" :
                        bi.j11db.isChecked() ? "2" :
                                "0");
        json.put("j11e",
                bi.j11ea.isChecked() ? "1" :
                        bi.j11eb.isChecked() ? "2" :
                                "0");
        json.put("j11f",
                bi.j11fa.isChecked() ? "1" :
                        bi.j11fb.isChecked() ? "2" :
                                "0");
        json.put("j11g",
                bi.j11ga.isChecked() ? "1" :
                        bi.j11gb.isChecked() ? "2" :
                                "0");
        json.put("j11h",
                bi.j11ha.isChecked() ? "1" :
                        bi.j11hb.isChecked() ? "2" :
                                "0");
        json.put("j11i",
                "0");
        json.put("j11ia",
                bi.j11iaa.isChecked() ? "1" :
                        bi.j11iab.isChecked() ? "2" :
                                "0");
        json.put("j11ib",
                bi.j11iba.isChecked() ? "1" :
                        bi.j11ibb.isChecked() ? "2" :
                                "0");
        json.put("j11j",
                bi.j11ja.isChecked() ? "1" :
                        bi.j11jb.isChecked() ? "2" :
                                "0");
        json.put("j11k",
                bi.j11ka.isChecked() ? "1" :
                        bi.j11kb.isChecked() ? "2" :
                                "0");
        json.put("j11l",
                bi.j11la.isChecked() ? "1" :
                        bi.j11lb.isChecked() ? "2" :
                                "0");
        json.put("j11ma", bi.j11ma.isChecked() ? "1" : "0");
        json.put("j11mb", bi.j11mb.isChecked() ? "2" : "0");
        json.put("j11mc", bi.j11mc.isChecked() ? "3" : "0");
        json.put("j11md", bi.j11md.isChecked() ? "4" : "0");
        json.put("j11me", bi.j11me.isChecked() ? "5" : "0");
        json.put("j11mf", bi.j11mf.isChecked() ? "6" : "0");
        json.put("j11mx", bi.j11mx.isChecked() ? "96" : "0");
        json.put("j11mxx", bi.j11mxx.getText().toString());
        json.put("j21",
                bi.j2a.isChecked() ? "1" :
                        bi.j2b.isChecked() ? "2" :
                                "0");
        json.put("j2aa",
                bi.j2aaa.isChecked() ? "1" :
                        bi.j2aab.isChecked() ? "2" :
                                "0");
        json.put("j21a",
                bi.j21aa.isChecked() ? "1" :
                        bi.j21ab.isChecked() ? "2" :
                                "0");
        json.put("j21b",
                bi.j21ba.isChecked() ? "1" :
                        bi.j21bb.isChecked() ? "2" :
                                "0");
        json.put("j21c",
                bi.j21ca.isChecked() ? "1" :
                        bi.j21cb.isChecked() ? "2" :
                                "0");
        json.put("j21d",
                bi.j21da.isChecked() ? "1" :
                        bi.j21db.isChecked() ? "2" :
                                "0");
        json.put("j21e",
                bi.j21ea.isChecked() ? "1" :
                        bi.j21eb.isChecked() ? "2" :
                                "0");
        json.put("j21f",
                bi.j21fa.isChecked() ? "1" :
                        bi.j21fb.isChecked() ? "2" :
                                "0");
        json.put("j21ga", bi.j21ga.isChecked() ? "1" : "0");
        json.put("j21gb", bi.j21gb.isChecked() ? "2" : "0");
        json.put("j21gc", bi.j21gc.isChecked() ? "3" : "0");
        json.put("j21gd", bi.j21gd.isChecked() ? "4" : "0");
        json.put("j21ge", bi.j21ge.isChecked() ? "5" : "0");
        json.put("j21gf", bi.j21gf.isChecked() ? "6" : "0");
        json.put("j21gx", bi.j21gx.isChecked() ? "96" : "0");
        json.put("j21gxx", bi.j21gxx.getText().toString());
        json.put("j31",
                bi.j3a.isChecked() ? "1" :
                        bi.j3b.isChecked() ? "2" :
                                "0");
        json.put("j3aa",
                bi.j3aaa.isChecked() ? "1" :
                        bi.j3aab.isChecked() ? "2" :
                                "0");
        json.put("j31a",
                bi.j31aa.isChecked() ? "1" :
                        bi.j31ab.isChecked() ? "2" :
                                "0");
        json.put("j31b",
                bi.j31ba.isChecked() ? "1" :
                        bi.j31bb.isChecked() ? "2" :
                                "0");
        json.put("j31c",
                bi.j31ca.isChecked() ? "1" :
                        bi.j31cb.isChecked() ? "2" :
                                "0");
        json.put("j31d",
                bi.j31da.isChecked() ? "1" :
                        bi.j31db.isChecked() ? "2" :
                                "0");
        json.put("j31e",
                bi.j31ea.isChecked() ? "1" :
                        bi.j31eb.isChecked() ? "2" :
                                "0");
        json.put("j31f",
                bi.j31fa.isChecked() ? "1" :
                        bi.j31fb.isChecked() ? "2" :
                                "0");
        json.put("j31g",
                bi.j31ga.isChecked() ? "1" :
                        bi.j31gb.isChecked() ? "2" :
                                "0");
        json.put("j31h",
                bi.j31ha.isChecked() ? "1" :
                        bi.j31hb.isChecked() ? "2" :
                                "0");
        json.put("j31i",
                bi.j31ia.isChecked() ? "1" :
                        bi.j31ib.isChecked() ? "2" :
                                "0");
        json.put("j31j",
                bi.j31ja.isChecked() ? "1" :
                        bi.j31jb.isChecked() ? "2" :
                                "0");
        json.put("j31k",
                bi.j31ka.isChecked() ? "1" :
                        bi.j31kb.isChecked() ? "2" :
                                "0");
        json.put("j31l",
                bi.j31la.isChecked() ? "1" :
                        bi.j31lb.isChecked() ? "2" :
                                "0");
        json.put("j31m",
                bi.j31ma.isChecked() ? "1" :
                        bi.j31mb.isChecked() ? "2" :
                                "0");
        json.put("j31n",
                bi.j31na.isChecked() ? "1" :
                        bi.j31nb.isChecked() ? "2" :
                                "0");
        json.put("j31o",
                bi.j31oa.isChecked() ? "1" :
                        bi.j31ob.isChecked() ? "2" :
                                "0");
        json.put("j31p",
                bi.j31pa.isChecked() ? "1" :
                        bi.j31pb.isChecked() ? "2" :
                                "0");
        json.put("j31q",
                bi.j31qa.isChecked() ? "1" :
                        bi.j31qb.isChecked() ? "2" :
                                "0");
        json.put("j31r",
                bi.j31ra.isChecked() ? "1" :
                        bi.j31rb.isChecked() ? "2" :
                                "0");
        json.put("j31s",
                bi.j31sa.isChecked() ? "1" :
                        bi.j31sb.isChecked() ? "2" :
                                "0");
        json.put("j31t",
                bi.j31ta.isChecked() ? "1" :
                        bi.j31tb.isChecked() ? "2" :
                                "0");
        json.put("j31u",
                bi.j31ua.isChecked() ? "1" :
                        bi.j31ub.isChecked() ? "2" :
                                "0");
        json.put("j31v",
                bi.j31va.isChecked() ? "1" :
                        bi.j31vb.isChecked() ? "2" :
                                "0");
        json.put("j31wa", bi.j31wa.isChecked() ? "1" : "0");
        json.put("j31wb", bi.j31wb.isChecked() ? "2" : "0");
        json.put("j31wc", bi.j31wc.isChecked() ? "3" : "0");
        json.put("j31wd", bi.j31wd.isChecked() ? "4" : "0");
        json.put("j31we", bi.j31we.isChecked() ? "5" : "0");
        json.put("j31wf", bi.j31wf.isChecked() ? "6" : "0");
        json.put("j31wx", bi.j31wx.isChecked() ? "96" : "0");
        json.put("j31wxx", bi.j31wxx.getText().toString());
        json.put("j41",
                bi.j4a.isChecked() ? "1" :
                        bi.j4b.isChecked() ? "2" :
                                "0");
        json.put("j4aa",
                bi.j4aaa.isChecked() ? "1" :
                        bi.j4aab.isChecked() ? "2" :
                                "0");
        json.put("j41a",
                bi.j41aa.isChecked() ? "1" :
                        bi.j41ab.isChecked() ? "2" :
                                "0");
        json.put("j41b",
                bi.j41ba.isChecked() ? "1" :
                        bi.j41bb.isChecked() ? "2" :
                                "0");
        json.put("j41c",
                bi.j41ca.isChecked() ? "1" :
                        bi.j41cb.isChecked() ? "2" :
                                "0");
        json.put("j41d",
                bi.j41da.isChecked() ? "1" :
                        bi.j41db.isChecked() ? "2" :
                                "0");
        json.put("j41e",
                bi.j41ea.isChecked() ? "1" :
                        bi.j41eb.isChecked() ? "2" :
                                "0");
        json.put("j41f",
                bi.j41fa.isChecked() ? "1" :
                        bi.j41fb.isChecked() ? "2" :
                                "0");
        json.put("j41g",
                bi.j41ga.isChecked() ? "1" :
                        bi.j41gb.isChecked() ? "2" :
                                "0");
        json.put("j41h",
                bi.j41ha.isChecked() ? "1" :
                        bi.j41hb.isChecked() ? "2" :
                                "0");
        json.put("j41i",
                bi.j41ia.isChecked() ? "1" :
                        bi.j41ib.isChecked() ? "2" :
                                "0");
        json.put("j41j",
                bi.j41ja.isChecked() ? "1" :
                        bi.j41jb.isChecked() ? "2" :
                                "0");
        json.put("j41k",
                bi.j41ka.isChecked() ? "1" :
                        bi.j41kb.isChecked() ? "2" :
                                "0");
        json.put("j41l",
                bi.j41la.isChecked() ? "1" :
                        bi.j41lb.isChecked() ? "2" :
                                "0");
        json.put("j41ma", bi.j41ma.isChecked() ? "1" : "0");
        json.put("j41mb", bi.j41mb.isChecked() ? "2" : "0");
        json.put("j41mc", bi.j41mc.isChecked() ? "3" : "0");
        json.put("j41md", bi.j41md.isChecked() ? "4" : "0");
        json.put("j41me", bi.j41me.isChecked() ? "5" : "0");
        json.put("j41mf", bi.j41mf.isChecked() ? "6" : "0");
        json.put("j41mx", bi.j41mx.isChecked() ? "96" : "0");
        json.put("j41mxx", bi.j41mxx.getText().toString());
        json.put("j51",
                bi.j5a.isChecked() ? "1" :
                        bi.j5b.isChecked() ? "2" :
                                "0");
        json.put("j5aa",
                bi.j5aaa.isChecked() ? "1" :
                        bi.j5aab.isChecked() ? "2" :
                                "0");
        json.put("j51a",
                bi.j51aa.isChecked() ? "1" :
                        bi.j51ab.isChecked() ? "2" :
                                "0");
        json.put("j51b",
                bi.j51ba.isChecked() ? "1" :
                        bi.j51bb.isChecked() ? "2" :
                                "0");
        json.put("j51c",
                bi.j51ca.isChecked() ? "1" :
                        bi.j51cb.isChecked() ? "2" :
                                "0");
        json.put("j51d",
                bi.j51da.isChecked() ? "1" :
                        bi.j51db.isChecked() ? "2" :
                                "0");
        json.put("j51e",
                bi.j51ea.isChecked() ? "1" :
                        bi.j51eb.isChecked() ? "2" :
                                "0");
        json.put("j51f",
                bi.j51fa.isChecked() ? "1" :
                        bi.j51fb.isChecked() ? "2" :
                                "0");
        json.put("j51g",
                bi.j51ga.isChecked() ? "1" :
                        bi.j51gb.isChecked() ? "2" :
                                "0");
        json.put("j51h",
                bi.j51ha.isChecked() ? "1" :
                        bi.j51hb.isChecked() ? "2" :
                                "0");
        json.put("j51i",
                bi.j51ia.isChecked() ? "1" :
                        bi.j51ib.isChecked() ? "2" :
                                "0");
        json.put("j51j",
                bi.j51ja.isChecked() ? "1" :
                        bi.j51jb.isChecked() ? "2" :
                                "0");
        json.put("j51k",
                bi.j51ka.isChecked() ? "1" :
                        bi.j51kb.isChecked() ? "2" :
                                "0");
        json.put("j51l",
                bi.j51la.isChecked() ? "1" :
                        bi.j51lb.isChecked() ? "2" :
                                "0");
        json.put("j51m",
                bi.j51ma.isChecked() ? "1" :
                        bi.j51mb.isChecked() ? "2" :
                                "0");
        json.put("j51na", bi.j51na.isChecked() ? "1" : "0");
        json.put("j51nb", bi.j51nb.isChecked() ? "2" : "0");
        json.put("j51nc", bi.j51nc.isChecked() ? "3" : "0");
        json.put("j51nd", bi.j51nd.isChecked() ? "4" : "0");
        json.put("j51ne", bi.j51ne.isChecked() ? "5" : "0");
        json.put("j51nf", bi.j51nf.isChecked() ? "6" : "0");
        json.put("j51nx", bi.j51nx.isChecked() ? "96" : "0");
        json.put("j51nxx", bi.j51nxx.getText().toString());
        json.put("j61",
                bi.j6a.isChecked() ? "1" :
                        bi.j6b.isChecked() ? "2" :
                                "0");
        json.put("j6aa",
                bi.j6aaa.isChecked() ? "1" :
                        bi.j6aab.isChecked() ? "2" :
                                "0");
        json.put("j61a",
                bi.j61aa.isChecked() ? "1" :
                        bi.j61ab.isChecked() ? "2" :
                                "0");
        json.put("j61b",
                bi.j61ba.isChecked() ? "1" :
                        bi.j61bb.isChecked() ? "2" :
                                "0");
        json.put("j61c",
                bi.j61ca.isChecked() ? "1" :
                        bi.j61cb.isChecked() ? "2" :
                                "0");
        json.put("j61d",
                bi.j61da.isChecked() ? "1" :
                        bi.j61db.isChecked() ? "2" :
                                "0");
        json.put("j61e",
                bi.j61ea.isChecked() ? "1" :
                        bi.j61eb.isChecked() ? "2" :
                                "0");
        json.put("j61f",
                bi.j61fa.isChecked() ? "1" :
                        bi.j61fb.isChecked() ? "2" :
                                "0");
        json.put("j61g",
                bi.j61ga.isChecked() ? "1" :
                        bi.j61gb.isChecked() ? "2" :
                                "0");
        json.put("j61h",
                bi.j61ha.isChecked() ? "1" :
                        bi.j61hb.isChecked() ? "2" :
                                "0");
        json.put("j61i",
                bi.j61ia.isChecked() ? "1" :
                        bi.j61ib.isChecked() ? "2" :
                                "0");
        json.put("j61j",
                bi.j61ja.isChecked() ? "1" :
                        bi.j61jb.isChecked() ? "2" :
                                "0");
        json.put("j61k",
                bi.j61ka.isChecked() ? "1" :
                        bi.j61kb.isChecked() ? "2" :
                                "0");
        json.put("j61l",
                bi.j61la.isChecked() ? "1" :
                        bi.j61lb.isChecked() ? "2" :
                                "0");
        json.put("j61ma", bi.j61ma.isChecked() ? "1" : "0");
        json.put("j61mb", bi.j61mb.isChecked() ? "2" : "0");
        json.put("j61mc", bi.j61mc.isChecked() ? "3" : "0");
        json.put("j61md", bi.j61md.isChecked() ? "4" : "0");
        json.put("j61me", bi.j61me.isChecked() ? "5" : "0");
        json.put("j61mf", bi.j61mf.isChecked() ? "6" : "0");
        json.put("j61mx", bi.j61mx.isChecked() ? "96" : "0");
        json.put("j61mxx", bi.j61mxx.getText().toString());
        json.put("j71",
                bi.j7a.isChecked() ? "1" :
                        bi.j7b.isChecked() ? "2" :
                                "0");
        json.put("j7aa",
                bi.j7aaa.isChecked() ? "1" :
                        bi.j7aab.isChecked() ? "2" :
                                "0");
        json.put("j71a",
                bi.j71aa.isChecked() ? "1" :
                        bi.j71ab.isChecked() ? "2" :
                                "0");
        json.put("j71b",
                bi.j71ba.isChecked() ? "1" :
                        bi.j71bb.isChecked() ? "2" :
                                "0");
        json.put("j71c",
                bi.j71ca.isChecked() ? "1" :
                        bi.j71cb.isChecked() ? "2" :
                                "0");
        json.put("j71d",
                bi.j71da.isChecked() ? "1" :
                        bi.j71db.isChecked() ? "2" :
                                "0");
        json.put("j71e",
                bi.j71ea.isChecked() ? "1" :
                        bi.j71eb.isChecked() ? "2" :
                                "0");
        json.put("j71f",
                bi.j71fa.isChecked() ? "1" :
                        bi.j71fb.isChecked() ? "2" :
                                "0");
        json.put("j71ga", bi.j71ga.isChecked() ? "1" : "0");
        json.put("j71gb", bi.j71gb.isChecked() ? "2" : "0");
        json.put("j71gc", bi.j71gc.isChecked() ? "3" : "0");
        json.put("j71gd", bi.j71gd.isChecked() ? "4" : "0");
        json.put("j71ge", bi.j71ge.isChecked() ? "5" : "0");
        json.put("j71gf", bi.j71gf.isChecked() ? "6" : "0");
        json.put("j71gx", bi.j71gx.isChecked() ? "96" : "0");
        json.put("j71gxx", bi.j71gxx.getText().toString());
        json.put("j81",
                bi.j8a.isChecked() ? "1" :
                        bi.j8b.isChecked() ? "2" :
                                "0");
        json.put("j8aa",
                bi.j8aaa.isChecked() ? "1" :
                        bi.j8aab.isChecked() ? "2" :
                                "0");
        json.put("j81a",
                bi.j81aa.isChecked() ? "1" :
                        bi.j81ab.isChecked() ? "2" :
                                "0");
        json.put("j81b",
                bi.j81ba.isChecked() ? "1" :
                        bi.j81bb.isChecked() ? "2" :
                                "0");
        json.put("j81c",
                bi.j81ca.isChecked() ? "1" :
                        bi.j81cb.isChecked() ? "2" :
                                "0");
        json.put("j81d",
                bi.j81da.isChecked() ? "1" :
                        bi.j81db.isChecked() ? "2" :
                                "0");
        json.put("j81e",
                bi.j81ea.isChecked() ? "1" :
                        bi.j81eb.isChecked() ? "2" :
                                "0");
        json.put("j81f",
                bi.j81fa.isChecked() ? "1" :
                        bi.j81fb.isChecked() ? "2" :
                                "0");
        json.put("j81ga", bi.j81ga.isChecked() ? "1" : "0");
        json.put("j81gb", bi.j81gb.isChecked() ? "2" : "0");
        json.put("j81gc", bi.j81gc.isChecked() ? "3" : "0");
        json.put("j81gd", bi.j81gd.isChecked() ? "4" : "0");
        json.put("j91",
                bi.j9a.isChecked() ? "1" :
                        bi.j9b.isChecked() ? "2" :
                                "0");
        json.put("j9aa",
                bi.j9aaa.isChecked() ? "1" :
                        bi.j9aab.isChecked() ? "2" :
                                "0");
        json.put("j91a",
                bi.j91aa.isChecked() ? "1" :
                        bi.j91ab.isChecked() ? "2" :
                                "0");
        json.put("j91b",
                bi.j91ba.isChecked() ? "1" :
                        bi.j91bb.isChecked() ? "2" :
                                "0");
        json.put("j91c",
                bi.j91ca.isChecked() ? "1" :
                        bi.j91cb.isChecked() ? "2" :
                                "0");
        json.put("j91d",
                bi.j91da.isChecked() ? "1" :
                        bi.j91db.isChecked() ? "2" :
                                "0");
        json.put("j91e",
                bi.j91ea.isChecked() ? "1" :
                        bi.j91eb.isChecked() ? "2" :
                                "0");
        json.put("j91fa", bi.j91fa.isChecked() ? "1" : "0");
        json.put("j91fb", bi.j91fb.isChecked() ? "2" : "0");
        json.put("j91fc", bi.j91fc.isChecked() ? "3" : "0");
        json.put("j91fd", bi.j91fd.isChecked() ? "4" : "0");
        json.put("j91fe", bi.j91fe.isChecked() ? "5" : "0");


        MainApp.fc.setsM(String.valueOf(json));

    }


    private boolean formValidation() {

        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionJ);

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