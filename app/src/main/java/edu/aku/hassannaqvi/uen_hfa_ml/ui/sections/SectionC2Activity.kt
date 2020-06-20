package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.validatorcrawler.aliazaz.Validator
import edu.aku.hassannaqvi.uen_hfa_ml.R
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionC2Binding
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.MainActivity
import edu.aku.hassannaqvi.uen_hfa_ml.ui.other.SectionMainActivity
import edu.aku.hassannaqvi.uen_hfa_ml.utils.openEndActivity
import ru.whalemare.sheetmenu.ActionItem
import ru.whalemare.sheetmenu.SheetMenu
import ru.whalemare.sheetmenu.layout.GridLayoutProvider

class SectionC2Activity : AppCompatActivity() {
    lateinit var bi: ActivitySectionC2Binding
    var pofpa15List: List<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2)
        bi.callback = this
        setupSkips()
    }

    private fun setupSkips() {

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


    private fun UpdateDB(): Boolean {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SC, fc.getsC());
        if (updcount == 1) {
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true
    }

    private fun SaveDraft() {

        /* MainApp.fc.c021a = bi.c021a.getText().toString().trim().length() > 0 ? bi.c021a.getText().toString() : "-1";

        MainApp.fc.c021b = bi.c021ba.isChecked() ? "1"
                : bi.c021bb.isChecked() ? "2"
                : bi.c021bc.isChecked() ? "3"
                : bi.c021bd.isChecked() ? "4"
                : bi.c021be.isChecked() ? "5"
                : bi.c021bf.isChecked() ? "96"
                : "-1";
        MainApp.fc.c021bfx = bi.c021bfx.getText().toString().trim().length() > 0 ? bi.c021bfx.getText().toString() : "-1";

        MainApp.fc.c021c = bi.c021c.getText().toString().trim().length() > 0 ? bi.c021c.getText().toString() : "-1";

        MainApp.fc.c021d = bi.c021da.isChecked() ? "1"
                : bi.c021db.isChecked() ? "2"
                : bi.c021dc.isChecked() ? "3"
                : bi.c021dd.isChecked() ? "4"
                : bi.c021de.isChecked() ? "5"
                : bi.c021df.isChecked() ? "6"
                : bi.c021dg.isChecked() ? "96"
                : "-1";
        MainApp.fc.c021dgx = bi.c021dgx.getText().toString().trim().length() > 0 ? bi.c021dgx.getText().toString() : "-1";

        MainApp.fc.c021e = bi.c021e.getText().toString().trim().length() > 0 ? bi.c021e.getText().toString() : "-1";*/
    }

    private fun formValidation(): Boolean {
        return Validator.emptyCheckingContainer(this, bi.GrpName)
    }

    fun btnContinue(v: View) {
        routingNextActivity(MainActivity::class.java)
    }

    private fun routingNextActivity(activity: Class<*>) {
        if (!formValidation()) return
        SaveDraft()
        if (UpdateDB()) {
            finish()
            startActivity(Intent(this, activity))
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show()
        }
    }

    fun btnAddMore(v: View) {

        SheetMenu(
                "Select your Action",
                listOf(
                        ActionItem(
                                0,
                                "Add More",
                                getDrawable(R.drawable.ic_account_circle_black_24dp)
                        )
                        ,
                        ActionItem(
                                1,
                                "Next Section",
                                getDrawable(R.drawable.ic_keyboard_arrow_right_black_24dp)
                        )
                        ,
                        ActionItem(
                                2,
                                "End Activity",
                                getDrawable(R.drawable.ic_closed_caption_black_24dp)
                        )
                ),
                onClick = { item: ActionItem ->
                    run {
                        when (item.id) {
                            0 -> routingNextActivity(this::class.java)
                            1 -> routingNextActivity(SectionMainActivity::class.java)
                            else -> openEndActivity(this)
                        }
                    }

                }, layoutProvider = GridLayoutProvider()
        ).show(this)

    }

    fun btnEnd(v: View) {
        openEndActivity(this)
    }

    override fun onBackPressed() {
        Toast.makeText(this, "Back Press Not Allowed", Toast.LENGTH_SHORT).show()
    }
}