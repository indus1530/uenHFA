package edu.aku.hassannaqvi.uen_hfa_ml.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.uen_hfa_ml";
    public static final String PATH_FORMS = "Forms";
    private final String projectName = "UEN_HFA_ML2020";

    public static String ONE = "1";
    public static String TWO = "2";
    public static String THREE = "3";
    public static String FOUR = "4";
    public static String FIVE = "5";
    public static String SIX = "6";
    public static String SEVEN = "7";
    public static String EIGHT = "8";
    public static String NINE = "9";
    public static String TEN = "10";
    public static String ELEVEN = "11";
    public static String TWELVE = "12";
    public static String THIRTEEN = "13";
    public static String FOURTEEN = "14";
    public static String FIFTEEN = "15";
    public static String SIXTEEN = "16";



    private String _ID = "";
    private String _UID = "";
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String luid = "";
    private String endingdatetime = "";
    private String gpsLat = ""; // gpsLat
    private String gpsLng = ""; // gpsLng
    private String gpsDT = "";
    private String gpsAcc = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion = "";
    public String a14;
    public String a17;
    public String modatitle;
    public String a01;
    public String a02;
    public String a03;
    public String a04;
    public String a05;
    public String a06;
    public String a07;
    public String a08;
    public String a09;
    public String a10;
    public String a11;
    public String a12;
    public String a13;
    public String a15;
    public String a16;
    public String a18;
    public String a19;
    public String a20;
    public String a21;
    public String a22;
    public String modbtitle;
    public String b01;
    public String b02;
    public String b03;
    public String b04;
    public String b05;
    String modctitle;
    String c01;
    String c01a;
    String c01b;
    String c01c;
    String c01d;
    String c01e;
    String c01f;
    String c01g;
    String c01h;
    String c01i;
    String c01j;
    String c01k;
    String c02;
    String c02a;
    String c02d;
    String c02b;
    String c02c;
    String c03;
    String c04;
    String c04a;
    String c04d;
    String c04b;
    String c04c;
    String moddtitle;
    String d01;
    String d0101;
    String d0102;
    String d02;
    String d0201;
    String d0202;
    String d0203;
    String d03;
    String d0301;
    String d0302;
    String d0303;
    String d0304;
    String d04;
    String d0401;
    String d0402;
    String d0403;
    String d0404;
    String d05;
    String d0501;
    String d0502;
    String d0502a0a;
    String d0502a0f;
    String d0502b0a;
    String d0502b0f;
    String d0502c0a;
    String d0502c0f;
    String d0502d0a;
    String d0502d0f;
    String d0503;
    String d0503a;
    String d0503b;
    String d0503c;
    String d0503d;
    String d0503e;
    String d0503f;
    String d0503g;
    String d0503h;
    String d06;
    String d0601;
    String d0601a;
    String d0601b;
    String d0601c;
    String d0601d;
    String d0602;
    String d0603;
    String d0604;
    String d0605;
    String d07;
    String d0701;
    String d0702;
    String d0703;
    String d0704;
    String d0704a;
    String d0704b;
    String d0704c;
    String d0704d;
    String d0704e;
    String d08;
    String d0801;
    String d0801a0a;
    String d0801a0f;
    String d0801a0fq;
    String d0801b0a;
    String d0801b0f;
    String d0801b0fq;
    String d0801c0a;
    String d0801c0f;
    String d0801c0fq;
    String d0801d0a;
    String d0801d0f;
    String d0801d0fq;
    String d0801e0a;
    String d0801e0f;
    String d0801e0fq;
    String d0801f0a;
    String d0801f0f;
    String d0801f0fq;
    String d0801g0a;
    String d0801g0f;
    String d0801g0fq;
    String d0801h0a;
    String d0801h0f;
    String d0801h0fq;
    String d0801i0a;
    String d0801i0f;
    String d0801i0fq;
    String d0801j0a;
    String d0801j0f;
    String d0801j0fq;
    String modetitle;
    String e01;
    String e0101;
    String e0102;
    String e0102a;
    String e0102b;
    String e0102c;
    String e0102d;
    String e0102e;
    String e0102f;
    String e0102g;
    String e0102h;
    String e0102i;
    String e0102j;
    String e0103;
    String e0103a;
    String e0103b;
    String e0104;
    String e0104a;
    String e0104b;
    String e0104c;
    String e0104d;
    String e0103e;
    String e02;
    String e0201;
    String e0202;
    String e0202a;
    String e0202b;
    String e0202c;
    String e0202d;
    String e0202e;
    String e0202f;
    String e0203efb;
    String e0203a;
    String e0203b;
    String e0204;
    String e0204a;
    String e0204b;
    String e0204c;
    String e0204d;
    String e03;
    String e0301;
    String e0302;
    String e0302a;
    String e0302b;
    String e0302c;
    String e0302d;
    String e0302e;
    String e0303;
    String e0303a;
    String e0303b;
    String e0303c;
    String e0303d;
    String e0303e;
    String e0303f;
    String e0303g;
    String e0303h;
    String e0303i;
    String e0303j;
    String e0303k;
    String e0303l;
    String e0303m;
    String e0303n;
    String e0304;
    String e0304a;
    String e0304b;
    String e0304c;
    String e0304d;
    String e0305;
    String e0305a;
    String e0305b;
    String e0305c;
    String e0305d;
    String e0305e;
    String e0306;
    String e0306a0a;
    String e0306a0f;
    String e0306b0a;
    String e0306b0f;
    String e0306c0a;
    String e0306c0f;
    String e0306d0a;
    String e0306d0f;
    String e0306e0a;
    String e0306e0f;
    String e0306f0a;
    String e0306f0f;
    String e0306g0a;
    String e0306g0f;
    String e0306h0a;
    String e0306h0f;
    String e0306i0a;
    String e0306i0f;
    String e0306j0a;
    String e0306j0f;
    String e0306k0a;
    String e0306k0f;
    String e0306l0a;
    String e0306l0f;
    String e0306m0a;
    String e0306m0f;
    String e0306n0a;
    String e0306n0f;
    String e0306o0a;
    String e0306o0f;
    String e0306p0a;
    String e0306p0f;
    String e0306q0a;
    String e0306q0f;
    String e0306r0a;
    String e0306r0f;
    String e0307;
    String e0308;
    String e04;
    String e0401;
    String e0402;
    String e0403;
    String e0403a;
    String e0403b;
    String e0403c;
    String e0404;
    String e0405;
    String e0406;
    String e0407;
    String e0407a;
    String e0407b;
    String e0407c;
    String e0407d;
    String e0408;
    String e0409;
    String e0410;
    String e0410a;
    String e0410b;
    String e0410c;
    String e0410d;
    String e0410e;
    String e0410f;
    String e0411;
    String e0412;
    String e0413;
    String e0414;
    String e0415;
    String e0416;
    String e05;
    String e0501;
    String e0502;
    String e0502a;
    String e0502b;
    String e0502c;
    String e0502d;
    String e0502e;
    String e0502f;
    String e0502g;
    String e0502h;
    String e0502i;
    String e0503;
    String e0504;
    String e0505;
    String e0506;
    String e0507;
    String e0508;
    String e0509;
    String e06;
    String e0601;
    String e0602;
    String e0603;
    String e0604;
    String e0605;
    String e0605a;
    String e0605b;
    String e0605c;
    String e0605d;
    String e0606;
    String e0607;
    String e0608;
    String e0609;
    String e0610;
    String e0611;
    String e07;
    String e0701;
    String e0702;
    String e0702a;
    String e0702b;
    String e0702c;
    String e0702d;
    String e0702e;
    String e0702f;
    String e0702g;
    String e0702h;
    String e0702i;
    String e0702j;
    String e0702k;
    String e0702l;
    String e0703;
    String e0703a;
    String e0703b;
    String e0703c;
    String e0703d;
    String e0704;
    String e0704a;
    String e0704b;
    String e0704c;
    String e0704d;
    String e0704e;
    String e0704f;
    String e0704g;
    String e0705;
    String e0705a0a;
    String e0705a0f;
    String e0705b0a;
    String e0705b0f;
    String e0705c0a;
    String e0705c0f;
    String e0705d0a;
    String e0705d0f;
    String e0705e0a;
    String e0705e0f;
    String e08;
    String e0801;
    String e0802;
    String e0803;
    String e0804;
    String e0805;
    String e0806;
    String e0807;
    String e0808;
    String e0809;
    String e0810;
    String e0811;
    String e0812;
    String e0813;
    String e0814;
    String modftitle;
    String f01;
    String f0100;
    String f0101a;
    String f0101aa0a;
    String f0101aa0f;
    String f0101ab0a;
    String f0101ab0f;
    String f0102;
    String f0103;
    String f0104;
    String f0105;
    String f0105aa;
    String f0105aaa0a;
    String f0105aaa0f;
    String f0105aab0a;
    String f0105aab0f;
    String f0105aac0a;
    String f0105aac0f;
    String f0106;
    String f0106aa;
    String f0106aaa0a;
    String f0106aaa0f;
    String f0107;
    String f0108;
    String f0109;
    String f0110;
    String f0110aa;
    String f0110aaa0a;
    String f0110aaa0f;
    String f0110aab0a;
    String f0110aab0f;
    String f0110aac0a;
    String f0110aac0f;
    String f0110aad0a;
    String f0110aad0f;
    String f0110aae0a;
    String f0110aae0f;
    String f02;
    String f0201;
    String f0201aa;
    String f0201aaa0a;
    String f0201aaa0f;
    String f0201aab0a;
    String f0201aab0f;
    String f0202;
    String f0202aa;
    String f0202aaa0a;
    String f0202aaa0f;
    String f0202aab0a;
    String f0202aab0f;
    String f0203;
    String f0203aa;
    String f0203aaa0a;
    String f0203aaa0f;
    String f0203aab0a;
    String f0203aab0f;
    String f03;
    String f0301;
    String f0301aa;
    String f0301aaa0a;
    String f0301aaa0f;
    String f0302;
    String f0302aa;
    String f0302aaa0a;
    String f0302aaa0f;
    String f04;
    String f0401;
    String f0401aa;
    String f0401aaa0a;
    String f0401aaa0f;
    String f0401aab0a;
    String f0401aab0f;
    String f0401aac0a;
    String f0401aac0f;
    String f0402;
    String f0402aa;
    String f0402aaa0a;
    String f0402aaa0f;
    String f0403;
    String f0403aa;
    String f0403aaa0a;
    String f0403aaa0f;
    String f0404;
    String f0404aa;
    String f0404aaa0a;
    String f0404aaa0f;
    String modgtitle;
    String g01;
    String g0101;
    String g0102;
    String g0102a;
    String g0102b;
    String g0103;
    String g0104;
    String g0105;
    String g0106;
    String g0107;
    String g0108;
    String g0108a;
    String g0108b;
    String g0108c;
    String g0109;
    String g0110;
    String g0111;
    String g01112;
    String g01113;
    String g01114;
    String g01115;
    String g01116;
    String g01117;
    String g02;
    String g0201;
    String g0202;
    String g0203;
    String g0204;
    String g0205;
    String g0206;
    String g0207;
    String g0208;
    String g03;
    String g0301;
    String g0301a;
    String g0301b;
    String g0301c;
    String g0302;
    String g0302a;
    String g0302b;
    String g0302c;
    String g04;
    String g0401;
    String g040110a;
    String g040110s;
    String g040110so;
    String g040110p;
    String g040120a;
    String g040120s;
    String g040120so;
    String g040120p;
    String g04013;
    String g04010a;
    String g04010s;
    String g04010so;
    String g04010p;
    String g040150a;
    String g040150s;
    String g040150so;
    String g040150p;
    String g040150py;
    String g040150pn;
    String g040160a;
    String g040160s;
    String g040160so;
    String g040160p;
    String g040170a;
    String g040170s;
    String g040170so;
    String g040170p;
    String g040180a;
    String g040180s;
    String g040180so;
    String g040180p;
    String g040190a;
    String g040190s;
    String g040190so;
    String g040190p;
    String g0401100a;
    String g0401100s;
    String g0401100so;
    String g0401100p;
    String g0401110a;
    String g0401110s;
    String g0401110so;
    String g0401110p;
    String g0401120a;
    String g0401120s;
    String g0401120so;
    String g0401120p;
    String g0401130a;
    String g0401130s;
    String g0401130so;
    String g0401130p;
    String g0401140a;
    String g0401140s;
    String g0401140so;
    String g0401140p;
    String g0401150a;
    String g0401150s;
    String g0401150so;
    String g0401150p;
    String g0401160a;
    String g0401160s;
    String g0401160so;
    String g0401160p;
    String g0401170a;
    String g0401170s;
    String g0401170so;
    String g0401170p;
    String g0401180a;
    String g0401180s;
    String g0401180so;
    String g0401180p;
    String g0401190a;
    String g0401190s;
    String g0401190so;
    String g0401190p;
    String g0401200a;
    String g0401200s;
    String g0401200so;
    String g0401200p;
    String g0401210a;
    String g0401210s;
    String g0401210so;
    String g0401210p;
    String g0401220a;
    String g0401220s;
    String g0401220so;
    String g0401220p;
    String g0401230a;
    String g0401230s;
    String g0401230so;
    String g0401230p;
    String g0401240a;
    String g0401240s;
    String g0401240so;
    String g0401240p;
    String g0401250a;
    String g0401250s;
    String g0401250so;
    String g0401250p;
    String g0401260a;
    String g0401260s;
    String g0401260so;
    String g0401260p;
    String g0401270a;
    String g0401270s;
    String g0401270so;
    String g0401270p;
    String g0401280a;
    String g0401280s;
    String g0401280so;
    String g0401280p;
    String g0401290a;
    String g0401290s;
    String g0401290so;
    String g0401290p;
    String g0401300a;
    String g0401300s;
    String g0401300so;
    String g0401300p;
    String g0401310a;
    String g0401310s;
    String g0401310so;
    String g0401310p;
    String g0401320a;
    String g0401320s;
    String g0401320so;
    String g0401320p;
    String g0401330a;
    String g0401330s;
    String g0401330so;
    String g0401330p;
    String g0401340a;
    String g0401340s;
    String g0401340so;
    String g0401340p;
    String g0401350a;
    String g0401350s;
    String g0401350so;
    String g0401350p;
    String g0401360a;
    String g0401360s;
    String g0401360so;
    String g0401360p;
    String g0401370a;
    String g0401370s;
    String g0401370so;
    String g0401370p;
    String g0401380a;
    String g0401380s;
    String g0401380so;
    String g0401380p;
    String g0401390a;
    String g0401390s;
    String g0401390so;
    String g0401390p;
    String g0401400a;
    String g0401400s;
    String g0401400so;
    String g0401400p;
    String g0401410a;
    String g0401410s;
    String g0401410so;
    String g0401410p;
    String g0401420a;
    String g0401420s;
    String g0401420so;
    String g0401420p;
    String g0401430a;
    String g0401430s;
    String g0401430so;
    String g0401430p;
    String g0401440a;
    String g0401440s;
    String g0401440so;
    String g0401440p;
    String g0402;
    String g040210a;
    String g040210s;
    String g040210so;
    String g040210p;
    String g040220a;
    String g040220s;
    String g040220so;
    String g040220p;
    String g040230a;
    String g040230s;
    String g040230so;
    String g040230p;
    String g040240a;
    String g040240s;
    String g040240so;
    String g040240p;
    String g040250a;
    String g040250s;
    String g040250so;
    String g040250p;
    String g040260a;
    String g040260s;
    String g040260so;
    String g040260p;
    String g040270a;
    String g040270s;
    String g040270so;
    String g040270p;
    String g040280a;
    String g040280s;
    String g040280so;
    String g040280p;
    String g040290a;
    String g040290s;
    String g040290so;
    String g040290p;
    String g0402100a;
    String g0402100s;
    String g0402100so;
    String g0402100p;
    String g0403;
    String g040310a;
    String g040310s;
    String g040310so;
    String g040310p;
    String g040320a;
    String g040320s;
    String g040320so;
    String g040320p;
    String g040330a;
    String g040330s;
    String g040330so;
    String g040330p;
    String g040340a;
    String g040340s;
    String g040340so;
    String g040340p;
    String g040350a;
    String g040350s;
    String g040350so;
    String g040350p;
    String g040360a;
    String g040360s;
    String g040360so;
    String g040360p;
    String g040370a;
    String g040370s;
    String g040370so;
    String g040370p;
    String g040380a;
    String g040380s;
    String g040380so;
    String g040380p;
    String g040390a;
    String g040390s;
    String g040390so;
    String g040390p;
    String g0403100a;
    String g0403100s;
    String g0403100so;
    String g0403100p;
    String g0403110a;
    String g0403110s;
    String g0403110so;
    String g0403110p;
    String g0403120a;
    String g0403120s;
    String g0403120so;
    String g0403120p;
    String g0403130a;
    String g0403130s;
    String g0403130so;
    String g0403130p;
    String g0403140a;
    String g0403140s;
    String g0403140so;
    String g0403140p;
    String g0403150a;
    String g0403150s;
    String g0403150so;
    String g0403150p;
    String g0403160a;
    String g0403160s;
    String g0403160so;
    String g0403160p;
    String g0403170a;
    String g0403170s;
    String g0403170so;
    String g0403170p;
    String g0403180a;
    String g0403180s;
    String g0403180so;
    String g0403180p;
    String g0403190a;
    String g0403190s;
    String g0403190so;
    String g0403190p;
    String g0403200a;
    String g0403200s;
    String g0403200so;
    String g0403200p;
    String g0403210a;
    String g0403210s;
    String g0403210so;
    String g0403210p;
    String g0403220a;
    String g0403220s;
    String g0403220so;
    String g0403220p;
    String g0403230a;
    String g0403230s;
    String g0403230so;
    String g0403230p;
    String g0403240a;
    String g0403240s;
    String g0403240so;
    String g0403240p;
    String g0403250a;
    String g0403250s;
    String g0403250so;
    String g0403250p;
    String g0403260a;
    String g0403260s;
    String g0403260so;
    String g0403260p;
    String g0403270a;
    String g0403270s;
    String g0403270so;
    String g0403270p;
    String g0404;
    String g040410a;
    String g040410s;
    String g040410so;
    String g040410p;
    String g040420a;
    String g040420s;
    String g040420so;
    String g040420p;
    String g040430a;
    String g040430s;
    String g040430so;
    String g040430p;
    String g040440a;
    String g040440s;
    String g040440so;
    String g040440p;
    String g040450a;
    String g040450s;
    String g040450so;
    String g040450p;
    String g040460a;
    String g040460s;
    String g040460so;
    String g040460p;
    String modhtitle;
    String h01;
    String h0101;
    String h0101a;
    String h0101b;
    String h0101c;
    String h02;
    String h0201;
    String h0202;
    String h0203;
    String h0203a;
    String h0203b;
    String h03;
    String h0301a0a;
    String h0301a0b;
    String h0301a0c;
    String h0301b0a;
    String h0301b0b;
    String h0301b0c;
    String h0301c0a;
    String h0301c0b;
    String h0301c0c;
    String h0301d0a;
    String h0301d0b;
    String h0301d0c;
    String h0301e0a;
    String h0301e0b;
    String h0301e0c;
    String h0301f0a;
    String h0301f0b;
    String h0301f0c;
    String h0301g0a;
    String h0301g0b;
    String h0301g0c;
    String h03011h0a;
    String h03011h0b;
    String h03011h0c;
    String h0301i0a;
    String h0301i0b;
    String h0301i0c;
    String h0301j0a;
    String h0301j0b;
    String h0301j0c;
    String h0301k0a;
    String h0301k0b;
    String h0301k0c;
    String h0301l0a;
    String h0301l0b;
    String h0301l0c;
    String h0301m0a;
    String h0301m0b;
    String h0301m0c;
    String h04;
    String h0401;
    String h05;
    String h0501;
    String h06;
    String h0601;
    String h0601aa;
    String h0602;
    String h0603;
    String h0603a;
    String h0603b;
    String h0603c;
    String h08;
    String h0801;
    String h0802;
    String h09;
    String h0901;
    String h0902;
    String h0902a;
    String h0902b;
    String h0902c;
    String h10;
    String h1001;
    String h1002;
    String h1002a;
    String h1002b;
    String h11;
    String h1101;
    String h1102;
    String h1103;
    String h1104;
    String h1105;
    String h1106;
    String h1107;
    String h12;
    String h1201;
    String h1202;
    String h1203;
    String h1203a;
    String h1203b;
    String h1203c;
    String h1203d;
    String h1203e;
    String h1203f;
    String h1203g;
    String h13;
    String h1301;
    String h1302;
    String h1303;
    String h14;
    String h1401;
    String h1401a;
    String h1401b;
    String h1401c;
    String h1401d;
    String h1401e;
    String h15;
    String h1501;
    String h1501a0a;
    String h1501a0b;
    String h1501a0c;
    String h1501a0d;
    String h1501b0a;
    String h1501b0b;
    String h1501b0c;
    String h1501b0d;
    String h1501c0a;
    String h1501c0b;
    String h1501c0c;
    String h1501c0d;
    String h1501d0a;
    String h1501d0b;
    String h1501d0c;
    String h1501d0d;
    String h1501e0a;
    String h1501e0b;
    String h1501e0c;
    String h1501e0d;
    String h1501f0a;
    String h1501f0b;
    String h1501f0c;
    String h1501f0d;
    String h1501g0a;
    String h1501g0b;
    String h1501g0c;
    String h1501g0d;
    String h1501h0a;
    String h1501h0b;
    String h1501h0c;
    String h1501h0d;
    String h1501i0a;
    String h1501i0b;
    String h1501i0c;
    String h1501i0d;
    String h1501j0a;
    String h1501j0b;
    String h1501j0c;
    String h1501j0d;
    String h1501k0a;
    String h1501k0b;
    String h1501k0c;
    String h1501k0d;
    String h1501l0a;
    String h1501l0b;
    String h1501l0c;
    String h1501l0d;
    String h1501m0a;
    String h1501m0b;
    String h1501m0c;
    String h1501m0d;
    String h1501n0a;
    String h1501n0b;
    String h1501n0c;
    String h1501n0d;
    String h1501o0a;
    String h1501o0b;
    String h1501o0c;
    String h1501o0d;
    String h1501p0a;
    String h1501p0b;
    String h1501p0c;
    String h1501p0d;
    String h1501q0a;
    String h1501q0b;
    String h1501q0c;
    String h1501q0d;
    String h1501r0a;
    String h1501r0b;
    String h1501r0c;
    String h1501r0d;
    String h1501s0a;
    String h1501s0b;
    String h1501s0c;
    String h1501s0d;
    String h1501t0a;
    String h1501t0b;
    String h1501t0c;
    String h1501t0d;
    String h1501u0a;
    String h1501u0b;
    String h1501u0c;
    String h1501u0d;
    String h1501v0a;
    String h1501v0b;
    String h1501v0c;
    String h1501v0d;
    String h1501w0a;
    String h1501w0b;
    String h1501w0c;
    String h1501w0d;
    String h1501x0a;
    String h1501x0b;
    String h1501x0c;
    String h1501x0d;
    String h1501y0a;
    String h1501y0b;
    String h1501y0c;
    String h1501y0d;
    String h1501z0a;
    String h1501z0b;
    String h1501z0c;
    String h1501z0d;
    String h16;
    String h1601;
    String h1602;
    String h1603;
    String h1604;
    String h1605;
    String h07;
    String h0701;
    String h0701a;
    String h0701b;
    String h0701c;
    String h0701d;
    String h0701e;
    String h0701f;
    String h0701g;
    String modititle;
    String i01;
    String i0101;
    String i0102;
    String i0102a;
    String i0102b;
    String i0103;
    String i0104;
    String i0105;
    String i0106;
    String i0107;
    String i0108;
    String i02;
    String i0201a;
    String i0201b;
    String i0201c;
    String i0201d;
    String i0201e;
    String i0201f;
    String i0201g;
    String i0201h;
    String i0201i;
    String i0201j;
    String i0201ja;
    String i0201jb;
    String i0201jc;
    String i0201jd;
    String i0201je;
    String i0201k;
    String i0201l;
    String i0201la;
    String i0201lb;
    String i0201lc;
    String i0201m;
    String i0201n;
    String i0201o;
    String i0201p;
    String i0201pa;
    String i0201pb;
    String i0201pc;
    String i0201pd;
    String i0201pe;
    String i0201pf;
    String i0201q;
    String i03;
    String i0301a;
    String i0301b;
    String i0301c;
    String i0301d;
    String i0301e;
    String i0301f;
    String i0301g;
    String i0301h;
    String i0301i;
    String i0301j;
    String i0301k;
    String i04;
    String i0401a;
    String i0401b;
    String i0401c;
    String i0401d;
    String i0401e;
    String i0401f;
    String i0401g;
    String modjtitle;
    String j01;
    String j0100;
    String j0100aa;
    String j0101;
    String j0101a;
    String j0101b;
    String j0101c;
    String j0101d;
    String j0101e;
    String j0101f;
    String j0101g;
    String j0101h;
    String j0101i;
    String j0101ia;
    String j0101ib;
    String j0101j;
    String j0101k;
    String j0101l;
    String j0101m;
    String j0101ma;
    String j0101mb;
    String j0101mc;
    String j0101md;
    String j0101me;
    String j0101mf;
    String j0101mx;
    String j02;
    String j0200;
    String j0200aa;
    String j0201;
    String j0201a;
    String j0201b;
    String j0201c;
    String j0201d;
    String j0201e;
    String j0201f;
    String j0201g;
    String j0201ga;
    String j0201gb;
    String j0201gc;
    String j0201gd;
    String j0201ge;
    String j0201gf;
    String j0201gx;
    String j03;
    String j0300;
    String j0300aa;
    String j0i00;
    String j0301a;
    String j0301b;
    String j0301c;
    String j0301d;
    String j0301e;
    String j0301f;
    String j0301g;
    String j0301h;
    String j0301i;
    String j0301j;
    String j0301k;
    String j0301l;
    String j0301m;
    String j0301n;
    String j0301o;
    String j0301p;
    String j0301q;
    String j0301r;
    String j0301s;
    String j0301t;
    String j0301u;
    String j0301v;
    String j0301w;
    String j0301wa;
    String j0301wb;
    String j0301wc;
    String j0301wd;
    String j0301we;
    String j0301wf;
    String j0301wx;
    String j04;
    String j0400;
    String j0400aa;
    String j0401;
    String j0401a;
    String j0401b;
    String j0401c;
    String j0401d;
    String j0401e;
    String j0401f;
    String j0401g;
    String j0401h;
    String j0401i;
    String j0401j;
    String j0401k;
    String j0401l;
    String j0401m;
    String j0401ma;
    String j0401mb;
    String j0401mc;
    String j0401md;
    String j0401me;
    String j0401mf;
    String j0401mx;
    String j05;
    String j0500;
    String j0500aa;
    String j0501;
    String j0501a;
    String j0501b;
    String j0501c;
    String j0501d;
    String j0501e;
    String j0501f;
    String j0501g;
    String j0501h;
    String j0501i;
    String j0501j;
    String j0501k;
    String j0501l;
    String j0501m;
    String j0501n;
    String j0501na;
    String j0501nb;
    String j0501nc;
    String j0501nd;
    String j0501ne;
    String j0501nf;
    String j0501nx;
    String j06;
    String j0600;
    String j0600aa;
    String j0601;
    String j0601a;
    String j0601b;
    String j0601c;
    String j0601d;
    String j0601e;
    String j0601f;
    String j0601g;
    String j0601h;
    String j0601i;
    String j0601j;
    String j0601k;
    String j0601l;
    String j0601m;
    String j0601ma;
    String j0601mb;
    String j0601mc;
    String j0601md;
    String j0601me;
    String j0601mf;
    String j0601mx;
    String j07;
    String j0700;
    String j0700aa;
    String j0701;
    String j0701a;
    String j0701b;
    String j0701c;
    String j0701d;
    String j0701e;
    String j0701f;
    String j0701g;
    String j0701ga;
    String j0701gb;
    String j0701gc;
    String j0701gd;
    String j0701ge;
    String j0701gf;
    String j0701gx;
    String j08;
    String j0800;
    String j0800aa;
    String j0801;
    String j0801a;
    String j0801b;
    String j0801c;
    String j0801d;
    String j0801e;
    String j0801f;
    String j0801g;
    String j0801ga;
    String j0801gb;
    String j0801gc;
    String j0801gd;
    String j09;
    String j0900;
    String j0900aa;
    String j0901;
    String j0901a;
    String j0901b;
    String j0901c;
    String j0901d;
    String j0901e;
    String j0901f;
    String j0901fa;
    String j0901fb;
    String j0901fc;
    String j0901fd;
    String j0901fe;


    public FormsContract() {
    }

   /* public String getsA() {
        return sA;
    }

    public void setsA(String sA) {
        this.sA = sA;
    }


    public String getsB() {
        return sB;
    }

    public void setsB(String sB) {
        this.sB = sB;
    }


    public String getsC() {
        return sC;
    }

    public void setsC(String sC) {
        this.sC = sC;
    }


    public String getsD() {
        return sD;
    }

    public void setsD(String sD) {
        this.sD = sD;
    }


    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }


    public String getsF() {
        return sF;
    }

    public void setsF(String sF) {
        this.sF = sF;
    }


    public String getsG() {
        return sG;
    }

    public void setsG(String sG) {
        this.sG = sG;
    }


    public String getsH() {
        return sH;
    }

    public void setsH(String sH) {
        this.sH = sH;
    }


    public String getsI() {
        return sI;
    }

    public void setsI(String sI) {
        this.sI = sI;
    }


    public String getsJ() {
        return sJ;
    }

    public void setsJ(String sJ) {
        this.sJ = sJ;
    }*/
    

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable.COLUMN_ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.a01 = jsonObject.getString(FormsTable.COLUMN_A1);
        this.a03 = jsonObject.getString(FormsTable.COLUMN_A3);
        this.a04 = jsonObject.getString(FormsTable.COLUMN_A4);
        this.a05 = jsonObject.getString(FormsTable.COLUMN_A5);
        this.a06 = jsonObject.getString(FormsTable.COLUMN_A6);
        this.a07 = jsonObject.getString(FormsTable.COLUMN_A7);
        this.a08 = jsonObject.getString(FormsTable.COLUMN_A8);
        this.a09 = jsonObject.getString(FormsTable.COLUMN_A9);
        this.a10 = jsonObject.getString(FormsTable.COLUMN_A10);
        this.a11 = jsonObject.getString(FormsTable.COLUMN_A11);
        this.a12 = jsonObject.getString(FormsTable.COLUMN_A12);
        this.a13 = jsonObject.getString(FormsTable.COLUMN_A13);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88x);
        this.luid = jsonObject.getString(FormsTable.COLUMN_LUID);
        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
       /* this.sA = jsonObject.getString(FormsTable.COLUMN_SA);
        this.sB = jsonObject.getString(FormsTable.COLUMN_SB);
        this.sC = jsonObject.getString(FormsTable.COLUMN_SC);
        this.sD = jsonObject.getString(FormsTable.COLUMN_SD);
        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.sF = jsonObject.getString(FormsTable.COLUMN_SF);
        this.sG = jsonObject.getString(FormsTable.COLUMN_SG);
        this.sH = jsonObject.getString(FormsTable.COLUMN_SH);
        this.sI = jsonObject.getString(FormsTable.COLUMN_SI);
        this.sJ = jsonObject.getString(FormsTable.COLUMN_SJ);*/

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.a01 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A1));
        this.a03 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A3));
        this.a04 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A4));
        this.a05 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A5));
        this.a06 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A6));
        this.a07 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A7));
        this.a08 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A8));
        this.a09 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A9));
        this.a10 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A10));
        this.a11 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A11));
        this.a12 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A12));
        this.a13 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_A13));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88x));
        this.luid = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_LUID));
        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));
       /* this.sA = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA));
        this.sB = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB));
        this.sC = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SC));
        this.sD = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD));
        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.sF = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SF));
        this.sG = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SG));
        this.sH = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SH));
        this.sI = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SI));
        this.sJ = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SJ));*/

        return this;
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_A1, this.a01 == null ? JSONObject.NULL : this.a01);
        json.put(FormsTable.COLUMN_A3, this.a03 == null ? JSONObject.NULL : this.a03);
        json.put(FormsTable.COLUMN_A4, this.a04 == null ? JSONObject.NULL : this.a04);
        json.put(FormsTable.COLUMN_A5, this.a05 == null ? JSONObject.NULL : this.a05);
        json.put(FormsTable.COLUMN_A6, this.a06 == null ? JSONObject.NULL : this.a06);
        json.put(FormsTable.COLUMN_A7, this.a07 == null ? JSONObject.NULL : this.a07);
        json.put(FormsTable.COLUMN_A8, this.a08 == null ? JSONObject.NULL : this.a08);
        json.put(FormsTable.COLUMN_A9, this.a09 == null ? JSONObject.NULL : this.a09);
        json.put(FormsTable.COLUMN_A10, this.a10 == null ? JSONObject.NULL : this.a10);
        json.put(FormsTable.COLUMN_A11, this.a11 == null ? JSONObject.NULL : this.a11);
        json.put(FormsTable.COLUMN_A12, this.a12 == null ? JSONObject.NULL : this.a12);
        json.put(FormsTable.COLUMN_A13, this.a13 == null ? JSONObject.NULL : this.a13);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_LUID, this.luid == null ? JSONObject.NULL : this.luid);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);

        /*if (!this.sA.equals("")) {
            json.put(FormsTable.COLUMN_SA, this.sA.equals("") ? JSONObject.NULL : new JSONObject(this.sA));
        }

        if (!this.sB.equals("")) {
            json.put(FormsTable.COLUMN_SB, this.sB.equals("") ? JSONObject.NULL : new JSONObject(this.sB));
        }

        if (!this.sC.equals("")) {
            json.put(FormsTable.COLUMN_SC, this.sC.equals("") ? JSONObject.NULL : new JSONObject(this.sC));
        }

        if (!this.sD.equals("")) {
            json.put(FormsTable.COLUMN_SD, this.sD.equals("") ? JSONObject.NULL : new JSONObject(this.sD));
        }

        if (!this.sE.equals("")) {
            json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
        }

        if (!this.sF.equals("")) {
            json.put(FormsTable.COLUMN_SF, this.sF.equals("") ? JSONObject.NULL : new JSONObject(this.sF));
        }

        if (!this.sG.equals("")) {
            json.put(FormsTable.COLUMN_SG, this.sG.equals("") ? JSONObject.NULL : new JSONObject(this.sG));
        }

        if (!this.sH.equals("")) {
            json.put(FormsTable.COLUMN_SH, this.sH.equals("") ? JSONObject.NULL : new JSONObject(this.sH));
        }

        if (!this.sI.equals("")) {
            json.put(FormsTable.COLUMN_SI, this.sI.equals("") ? JSONObject.NULL : new JSONObject(this.sI));
        }

        if (!this.sJ.equals("")) {
            json.put(FormsTable.COLUMN_SJ, this.sJ.equals("") ? JSONObject.NULL : new JSONObject(this.sJ));
        }*/

        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }


    /*public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }


    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }


    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }


    public String getA5() {
        return a5;
    }

    public void setA5(String a5) {
        this.a5 = a5;
    }


    public String getA6() {
        return a6;
    }

    public void setA6(String a6) {
        this.a6 = a6;
    }


    public String getA7() {
        return a7;
    }

    public void setA7(String a7) {
        this.a7 = a7;
    }


    public String getA8() {
        return a8;
    }

    public void setA8(String a8) {
        this.a8 = a8;
    }


    public String getA9() {
        return a9;
    }

    public void setA9(String a9) {
        this.a9 = a9;
    }


    public String getA10() {
        return a10;
    }

    public void setA10(String a10) {
        this.a10 = a10;
    }


    public String getA11() {
        return a11;
    }

    public void setA11(String a11) {
        this.a11 = a11;
    }


    public String getA12() {
        return a12;
    }

    public void setA12(String a12) {
        this.a12 = a12;
    }


    public String getA13() {
        return a13;
    }

    public void setA13(String a13) {
        this.a13 = a13;
    }*/
    

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }

    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }

    public String getLuid() {
        return luid;
    }

    public void setLuid(String Study_Id) {
        this.luid = Study_Id;
    }


    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }


    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "Forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_A1 = "a1";
        public static final String COLUMN_A3 = "a3";
        public static final String COLUMN_A4 = "a4";
        public static final String COLUMN_A5 = "a5";
        public static final String COLUMN_A6 = "a6";
        public static final String COLUMN_A7 = "a7";
        public static final String COLUMN_A8 = "a8";
        public static final String COLUMN_A9 = "a9";
        public static final String COLUMN_A10 = "a10";
        public static final String COLUMN_A11 = "a11";
        public static final String COLUMN_A12 = "a12";
        public static final String COLUMN_A13 = "a13";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";
        public static final String COLUMN_LUID = "_luid";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_SA = "sA";
        public static final String COLUMN_SB = "sB";
        public static final String COLUMN_SC = "sC";
        public static final String COLUMN_SD = "sD";
        public static final String COLUMN_SE = "sE";
        public static final String COLUMN_SF = "sF";
        public static final String COLUMN_SG = "sG";
        public static final String COLUMN_SH = "sH";
        public static final String COLUMN_SI = "sI";
        public static final String COLUMN_SJ = "sJ";

        public static String _URL = "sync.php";
    }
}
