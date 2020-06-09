package edu.aku.hassannaqvi.uen_hfa_ml.ui.sections;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.validatorcrawler.aliazaz.Validator;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import edu.aku.hassannaqvi.uen_hfa_ml.R;
import edu.aku.hassannaqvi.uen_hfa_ml.databinding.ActivitySectionK6Binding;

import static edu.aku.hassannaqvi.uen_hfa_ml.utils.UtilKt.openEndActivity;

public class SectionK6Activity extends AppCompatActivity {

    ActivitySectionK6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_k6);
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
                startActivity(new Intent(this, SectionK7Activity.class));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private boolean UpdateDB() {
        /*DatabaseHelper db = MainApp.appInfo.getDbHelper();
        int updcount = db.updatesFormColumn(FormsContract.FormsTable.COLUMN_SK, MainApp.fc.getsK());
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

        json.put("k60101", bi.k60101a.isChecked() ? "1"
                : bi.k60101b.isChecked() ? "2"
                : "-1");

        json.put("k6010100", "-1");

        json.put("k6010101", bi.k6010101a.isChecked() ? "1"
                : bi.k6010101b.isChecked() ? "2"
                : bi.k6010101c.isChecked() ? "3"
                : "-1");

        json.put("k6010101cx", bi.k6010101cx.getText().toString());
        json.put("k6010102", bi.k6010102a.isChecked() ? "1"
                : bi.k6010102b.isChecked() ? "2"
                : bi.k6010102c.isChecked() ? "3"
                : "-1");

        json.put("k6010102cx", bi.k6010102cx.getText().toString());
        json.put("k6010103", bi.k6010103a.isChecked() ? "1"
                : bi.k6010103b.isChecked() ? "2"
                : bi.k6010103c.isChecked() ? "3"
                : "-1");

        json.put("k6010103cx", bi.k6010103cx.getText().toString());
        json.put("k6010104", bi.k6010104a.isChecked() ? "1"
                : bi.k6010104b.isChecked() ? "2"
                : bi.k6010104c.isChecked() ? "3"
                : "-1");

        json.put("k6010104cx", bi.k6010104cx.getText().toString());
        json.put("k60102", bi.k60102a.isChecked() ? "1"
                : bi.k60102b.isChecked() ? "2"
                : "-1");

        json.put("k60103", bi.k60103a.isChecked() ? "1"
                : bi.k60103b.isChecked() ? "2"
                : "-1");

        json.put("k60104", bi.k60104a.isChecked() ? "1"
                : bi.k60104b.isChecked() ? "2"
                : "-1");

        json.put("k60105", bi.k60105a.isChecked() ? "1"
                : bi.k60105b.isChecked() ? "2"
                : "-1");

        json.put("k6010500", "-1");

        json.put("k6010501", bi.k6010501a.isChecked() ? "1"
                : bi.k6010501b.isChecked() ? "2"
                : bi.k6010501c.isChecked() ? "3"
                : "-1");

        json.put("k6010501cx", bi.k6010501cx.getText().toString());
        json.put("k6010502", bi.k6010502a.isChecked() ? "1"
                : bi.k6010502b.isChecked() ? "2"
                : bi.k6010502c.isChecked() ? "3"
                : "-1");

        json.put("k6010502cx", bi.k6010502cx.getText().toString());
        json.put("k6010503", bi.k6010503a.isChecked() ? "1"
                : bi.k6010503b.isChecked() ? "2"
                : bi.k6010503c.isChecked() ? "3"
                : "-1");

        json.put("k6010503cx", bi.k6010503cx.getText().toString());
        json.put("k6010504", bi.k6010504a.isChecked() ? "1"
                : bi.k6010504b.isChecked() ? "2"
                : bi.k6010504c.isChecked() ? "3"
                : "-1");

        json.put("k6010504cx", bi.k6010504cx.getText().toString());
        json.put("k6010505", bi.k6010505a.isChecked() ? "1"
                : bi.k6010505b.isChecked() ? "2"
                : bi.k6010505c.isChecked() ? "3"
                : "-1");

        json.put("k6010505cx", bi.k6010505cx.getText().toString());
        json.put("k6010506", bi.k6010506a.isChecked() ? "1"
                : bi.k6010506b.isChecked() ? "2"
                : bi.k6010506c.isChecked() ? "3"
                : "-1");

        json.put("k6010506cx", bi.k6010506cx.getText().toString());
        json.put("k60106", bi.k60106a.isChecked() ? "1"
                : bi.k60106b.isChecked() ? "2"
                : "-1");

        json.put("k6010600", "-1");

        json.put("k6010601", bi.k6010601a.isChecked() ? "1"
                : bi.k6010601b.isChecked() ? "2"
                : bi.k6010601c.isChecked() ? "3"
                : "-1");

        json.put("k6010601cx", bi.k6010601cx.getText().toString());
        json.put("k6010602", bi.k6010602a.isChecked() ? "1"
                : bi.k6010602b.isChecked() ? "2"
                : bi.k6010602c.isChecked() ? "3"
                : "-1");

        json.put("k6010602cx", bi.k6010602cx.getText().toString());
        json.put("k60107", bi.k60107a.isChecked() ? "1"
                : bi.k60107b.isChecked() ? "2"
                : "-1");

        json.put("k60108", bi.k60108a.isChecked() ? "1"
                : bi.k60108b.isChecked() ? "2"
                : "-1");

        json.put("k60109", bi.k60109a.isChecked() ? "1"
                : bi.k60109b.isChecked() ? "2"
                : "-1");

        json.put("k60110", bi.k60110a.isChecked() ? "1"
                : bi.k60110b.isChecked() ? "2"
                : "-1");

        json.put("k601100", "-1");

        json.put("k6011001", bi.k6011001a.isChecked() ? "1"
                : bi.k6011001b.isChecked() ? "2"
                : bi.k6011001c.isChecked() ? "3"
                : "-1");

        json.put("k6011001cx", bi.k6011001cx.getText().toString());
        json.put("k6011002", bi.k6011002a.isChecked() ? "1"
                : bi.k6011002b.isChecked() ? "2"
                : bi.k6011002c.isChecked() ? "3"
                : "-1");

        json.put("k6011002cx", bi.k6011002cx.getText().toString());
        json.put("k6011003", bi.k6011003a.isChecked() ? "1"
                : bi.k6011003b.isChecked() ? "2"
                : bi.k6011003c.isChecked() ? "3"
                : "-1");

        json.put("k6011003cx", bi.k6011003cx.getText().toString());
        json.put("k6011004", bi.k6011004a.isChecked() ? "1"
                : bi.k6011004b.isChecked() ? "2"
                : bi.k6011004c.isChecked() ? "3"
                : "-1");

        json.put("k6011004cx", bi.k6011004cx.getText().toString());
        json.put("k6011005", bi.k6011005a.isChecked() ? "1"
                : bi.k6011005b.isChecked() ? "2"
                : bi.k6011005c.isChecked() ? "3"
                : "-1");

        json.put("k6011005cx", bi.k6011005cx.getText().toString());
        json.put("k6011006", bi.k6011006a.isChecked() ? "1"
                : bi.k6011006b.isChecked() ? "2"
                : bi.k6011006c.isChecked() ? "3"
                : "-1");

        json.put("k6011006cx", bi.k6011006cx.getText().toString());
        json.put("k6011007", bi.k6011007a.isChecked() ? "1"
                : bi.k6011007b.isChecked() ? "2"
                : bi.k6011007c.isChecked() ? "3"
                : "-1");

        json.put("k6011007cx", bi.k6011007cx.getText().toString());
        json.put("k6011008", bi.k6011008a.isChecked() ? "1"
                : bi.k6011008b.isChecked() ? "2"
                : bi.k6011008c.isChecked() ? "3"
                : "-1");

        json.put("k6011008cx", bi.k6011008cx.getText().toString());
        json.put("k6011009", bi.k6011009a.isChecked() ? "1"
                : bi.k6011009b.isChecked() ? "2"
                : bi.k6011009c.isChecked() ? "3"
                : "-1");

        json.put("k6011009cx", bi.k6011009cx.getText().toString());
        json.put("k6011010", bi.k6011010a.isChecked() ? "1"
                : bi.k6011010b.isChecked() ? "2"
                : bi.k6011010c.isChecked() ? "3"
                : "-1");

        json.put("k6011010cx", bi.k6011010cx.getText().toString());
        json.put("k60201", bi.k60201a.isChecked() ? "1"
                : bi.k60201b.isChecked() ? "2"
                : "-1");

        json.put("k6020100", "-1");

        json.put("k6020101", bi.k6020101a.isChecked() ? "1"
                : bi.k6020101b.isChecked() ? "2"
                : bi.k6020101c.isChecked() ? "3"
                : "-1");

        json.put("k6020101cx", bi.k6020101cx.getText().toString());
        json.put("k6020102", bi.k6020102a.isChecked() ? "1"
                : bi.k6020102b.isChecked() ? "2"
                : bi.k6020102c.isChecked() ? "3"
                : "-1");

        json.put("k6020102cx", bi.k6020102cx.getText().toString());
        json.put("k6020103", bi.k6020103a.isChecked() ? "1"
                : bi.k6020103b.isChecked() ? "2"
                : bi.k6020103c.isChecked() ? "3"
                : "-1");

        json.put("k6020103cx", bi.k6020103cx.getText().toString());
        json.put("k6020104", bi.k6020104a.isChecked() ? "1"
                : bi.k6020104b.isChecked() ? "2"
                : bi.k6020104c.isChecked() ? "3"
                : "-1");

        json.put("k6020104cx", bi.k6020104cx.getText().toString());
        json.put("k60202", bi.k60202a.isChecked() ? "1"
                : bi.k60202b.isChecked() ? "2"
                : "-1");

        json.put("k6020200", "-1");

        json.put("k6020201", bi.k6020201a.isChecked() ? "1"
                : bi.k6020201b.isChecked() ? "2"
                : bi.k6020201c.isChecked() ? "3"
                : "-1");

        json.put("k6020201cx", bi.k6020201cx.getText().toString());
        json.put("k6020202", bi.k6020202a.isChecked() ? "1"
                : bi.k6020202b.isChecked() ? "2"
                : bi.k6020202c.isChecked() ? "3"
                : "-1");

        json.put("k6020202cx", bi.k6020202cx.getText().toString());
        json.put("k6020203", bi.k6020203a.isChecked() ? "1"
                : bi.k6020203b.isChecked() ? "2"
                : bi.k6020203c.isChecked() ? "3"
                : "-1");

        json.put("k6020203cx", bi.k6020203cx.getText().toString());
        json.put("k6020204", bi.k6020204a.isChecked() ? "1"
                : bi.k6020204b.isChecked() ? "2"
                : bi.k6020204c.isChecked() ? "3"
                : "-1");

        json.put("k6020204cx", bi.k6020204cx.getText().toString());
        json.put("k60203", bi.k60203a.isChecked() ? "1"
                : bi.k60203b.isChecked() ? "2"
                : "-1");

        json.put("k6020300", "-1");

        json.put("k6020301", bi.k6020301a.isChecked() ? "1"
                : bi.k6020301b.isChecked() ? "2"
                : bi.k6020301c.isChecked() ? "3"
                : "-1");

        json.put("k6020301cx", bi.k6020301cx.getText().toString());
        json.put("k6020302", bi.k6020302a.isChecked() ? "1"
                : bi.k6020302b.isChecked() ? "2"
                : bi.k6020302c.isChecked() ? "3"
                : "-1");

        json.put("k6020302cx", bi.k6020302cx.getText().toString());
        json.put("k6020303", bi.k6020303a.isChecked() ? "1"
                : bi.k6020303b.isChecked() ? "2"
                : bi.k6020303c.isChecked() ? "3"
                : "-1");

        json.put("k6020303cx", bi.k6020303cx.getText().toString());
        json.put("k6020304", bi.k6020304a.isChecked() ? "1"
                : bi.k6020304b.isChecked() ? "2"
                : bi.k6020304c.isChecked() ? "3"
                : "-1");

        json.put("k6020304cx", bi.k6020304cx.getText().toString());
        json.put("k60301", bi.k60301a.isChecked() ? "1"
                : bi.k60301b.isChecked() ? "2"
                : "-1");

        json.put("k6030100", "-1");

        json.put("k6030101", bi.k6030101a.isChecked() ? "1"
                : bi.k6030101b.isChecked() ? "2"
                : bi.k6030101c.isChecked() ? "3"
                : "-1");

        json.put("k6030101cx", bi.k6030101cx.getText().toString());
        json.put("k6030102", bi.k6030102a.isChecked() ? "1"
                : bi.k6030102b.isChecked() ? "2"
                : bi.k6030102c.isChecked() ? "3"
                : "-1");

        json.put("k6030102cx", bi.k6030102cx.getText().toString());
        json.put("k60302", bi.k60302a.isChecked() ? "1"
                : bi.k60302b.isChecked() ? "2"
                : "-1");

        json.put("k6030200", "-1");

        json.put("k6030201", bi.k6030201a.isChecked() ? "1"
                : bi.k6030201b.isChecked() ? "2"
                : bi.k6030201c.isChecked() ? "3"
                : "-1");

        json.put("k6030201cx", bi.k6030201cx.getText().toString());
        json.put("k6030202", bi.k6030202a.isChecked() ? "1"
                : bi.k6030202b.isChecked() ? "2"
                : bi.k6030202c.isChecked() ? "98"
                : "-1");

        json.put("k60401", bi.k60401a.isChecked() ? "1"
                : bi.k60401b.isChecked() ? "2"
                : "-1");

        json.put("k6040101", bi.k6040101a.isChecked() ? "1"
                : bi.k6040101b.isChecked() ? "2"
                : bi.k6040101c.isChecked() ? "3"
                : "-1");

        json.put("k6040101cx", bi.k6040101cx.getText().toString());
        json.put("k6040102", bi.k6040102a.isChecked() ? "1"
                : bi.k6040102b.isChecked() ? "2"
                : bi.k6040102c.isChecked() ? "3"
                : "-1");

        json.put("k6040102cx", bi.k6040102cx.getText().toString());
        json.put("k6040103", bi.k6040103a.isChecked() ? "1"
                : bi.k6040103b.isChecked() ? "2"
                : bi.k6040103c.isChecked() ? "3"
                : "-1");

        json.put("k6040103cx", bi.k6040103cx.getText().toString());
        json.put("k6040104", bi.k6040104a.isChecked() ? "1"
                : bi.k6040104b.isChecked() ? "2"
                : bi.k6040104c.isChecked() ? "3"
                : "-1");

        json.put("k6040104cx", bi.k6040104cx.getText().toString());
        json.put("k6040105", bi.k6040105a.isChecked() ? "1"
                : bi.k6040105b.isChecked() ? "2"
                : bi.k6040105c.isChecked() ? "3"
                : "-1");

        json.put("k6040105cx", bi.k6040105cx.getText().toString());
        json.put("k6040106", bi.k6040106a.isChecked() ? "1"
                : bi.k6040106b.isChecked() ? "2"
                : bi.k6040106c.isChecked() ? "3"
                : "-1");

        json.put("k6040106cx", bi.k6040106cx.getText().toString());
        json.put("k60402", bi.k60402a.isChecked() ? "1"
                : bi.k60402b.isChecked() ? "2"
                : "-1");

        json.put("k6040200", "-1");

        json.put("k6040201", bi.k6040201a.isChecked() ? "1"
                : bi.k6040201b.isChecked() ? "2"
                : bi.k6040201c.isChecked() ? "3"
                : "-1");

        json.put("k6040201cx", bi.k6040201cx.getText().toString());
        json.put("k6040202", bi.k6040202a.isChecked() ? "1"
                : bi.k6040202b.isChecked() ? "2"
                : bi.k6040202c.isChecked() ? "3"
                : "-1");

        json.put("k6040202cx", bi.k6040202cx.getText().toString());
        json.put("k60403", bi.k60403a.isChecked() ? "1"
                : bi.k60403b.isChecked() ? "2"
                : "-1");

        json.put("k6040300", "-1");

        json.put("k6040301", bi.k6040301a.isChecked() ? "1"
                : bi.k6040301b.isChecked() ? "2"
                : bi.k6040301c.isChecked() ? "3"
                : "-1");

        json.put("k6040301cx", bi.k6040301cx.getText().toString());
        json.put("k6040302", bi.k6040302a.isChecked() ? "1"
                : bi.k6040302b.isChecked() ? "2"
                : bi.k6040302c.isChecked() ? "3"
                : "-1");

        json.put("k6040302cx", bi.k6040302cx.getText().toString());
        json.put("k60404", bi.k60404a.isChecked() ? "1"
                : bi.k60404b.isChecked() ? "2"
                : "-1");

        json.put("k6040400", "-1");

        json.put("k6040401", bi.k6040401a.isChecked() ? "1"
                : bi.k6040401b.isChecked() ? "2"
                : bi.k6040401c.isChecked() ? "3"
                : "-1");

        json.put("k6040401cx", bi.k6040401cx.getText().toString());
        json.put("k6040402", bi.k6040402a.isChecked() ? "1"
                : bi.k6040402b.isChecked() ? "2"
                : bi.k6040402c.isChecked() ? "3"
                : "-1");

        json.put("k6040402cx", bi.k6040402cx.getText().toString());

    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpNameSectionK6);
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
