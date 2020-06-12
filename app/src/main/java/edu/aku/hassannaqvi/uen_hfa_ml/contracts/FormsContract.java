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

    public static String one = "1";
    public static String two = "2";
    public static String three = "3";
    public static String four = "4";
    public static String five = "5";
    public static String six = "6";
    public static String seven = "7";
    public static String eight = "8";
    public static String nine = "9";
    public static String ten = "10";
    public static String eleven = "11";
    public static String twelve = "12";
    public static String thirteen = "13";
    public static String fourteen = "14";
    public static String fifteen = "15";
    public static String sixteen = "16";
    public static String nSix = "96";
    public static String nSeven = "97";
    public static String nEight = "98";
    public static String nNine = "99";



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
    public String a14;
    public String a15;
    public String a16;
    public String a17;
    public String a18;
    public String a18xx;
    public String a19;
    public String a19xx;
    public String a20;
    public String a21;
    public String a22;

    public String modbtitle;
    public String b01;
    public String b02;
    public String b03;
    public String b04;
    public String b05;

    public String modctitle;
    public String c01;
    public String c01a;
    public String c01b;
    public String c01c;
    public String c01d;
    public String c01e;
    public String c01f;
    public String c01g;
    public String c01h;
    public String c01i;
    public String c01j;
    public String c01k;
    public String c02;
    public String c02a;
    public String c02d;
    public String c02b;
    public String c02c;
    public String c03;
    public String c04;
    public String c04a;
    public String c04d;
    public String c04b;
    public String c04c;

    public String moddtitle;
    public String d01;
    public String d0101;
    public String d0102;
    public String d02;
    public String d0201;
    public String d0202;
    public String d0203;
    public String d03;
    public String d0301;
    public String d0302;
    public String d0303;
    public String d0304;
    public String d04;
    public String d0401;
    public String d0402;
    public String d0403;
    public String d0404;
    public String d05;
    public String d0501;
    public String d0502;

    public String d0502a0a;
    public String d0502a0ayx;
    public String d0502a0f;
    public String d0502a0fyx;

    public String d0502b0a;
    public String d0502b0ayx;
    public String d0502b0f;
    public String d0502b0fyx;

    public String d0502c0a;
    public String d0502c0ayx;
    public String d0502c0f;
    public String d0502c0fyx;

    public String d0502d0a;
    public String d0502d0ayx;
    public String d0502d0f;
    public String d0502d0fyx;

    public String d0503;
    public String d0503a;
    public String d0503b;
    public String d0503c;
    public String d0503d;
    public String d0503e;
    public String d0503f;
    public String d0503g;
    public String d0503h;

    public String d06;
    public String d0601;
    public String d0601a;
    public String d0601b;
    public String d0601c;
    public String d0601d;
    public String d0602;
    public String d0603;
    public String d0604;
    public String d0605;
    public String d07;
    public String d0701;
    public String d0701xx;
    public String d0702;
    public String d0702xx;
    public String d0703;
    public String d0704;
    public String d0704a;
    public String d0704b;
    public String d0704c;
    public String d0704d;
    public String d0704e;
    public String d08;
    public String d0801;
    public String d0801a0a;
    public String d0801a0f;
    public String d0801a0fq;
    public String d0801b0a;
    public String d0801b0f;
    public String d0801b0fq;
    public String d0801c0a;
    public String d0801c0f;
    public String d0801c0fq;
    public String d0801d0a;
    public String d0801d0f;
    public String d0801d0fq;
    public String d0801e0a;
    public String d0801e0f;
    public String d0801e0fq;
    public String d0801f0a;
    public String d0801f0f;
    public String d0801f0fq;
    public String d0801g0a;
    public String d0801g0f;
    public String d0801g0fq;
    public String d0801h0a;
    public String d0801h0f;
    public String d0801h0fq;
    public String d0801i0a;
    public String d0801i0f;
    public String d0801i0fq;
    public String d0801j0a;
    public String d0801j0f;
    public String d0801j0fq;
    public String modetitle;
    public String e01;
    public String e0101;
    public String e0102;
    public String e0102a;
    public String e0102b;
    public String e0102c;
    public String e0102d;
    public String e0102e;
    public String e0102f;
    public String e0102g;
    public String e0102h;
    public String e0102i;
    public String e0102j;
    public String e0103;
    public String e0103a;
    public String e0103b;
    public String e0104;
    public String e0104a;
    public String e0104b;
    public String e0104c;
    public String e0104d;
    public String e0104e;
    public String e0104exx;
    public String e02;
    public String e0201;
    public String e0202;
    public String e0202a;
    public String e0202b;
    public String e0202c;
    public String e0202d;
    public String e0202e;
    public String e0202f;
    public String e0203efb;
    public String e0203a;
    public String e0203b;
    public String e0204;
    public String e0204a;
    public String e0204b;
    public String e0204c;
    public String e0204d;
    public String e0204dxx;
    public String e03;
    public String e0301;
    public String e0302;
    public String e0302a;
    public String e0302b;
    public String e0302c;
    public String e0302d;
    public String e0302e;
    public String e0303;
    public String e0303a;
    public String e0303b;
    public String e0303c;
    public String e0303d;
    public String e0303e;
    public String e0303f;
    public String e0303g;
    public String e0303h;
    public String e0303i;
    public String e0303j;
    public String e0303k;
    public String e0303l;
    public String e0303m;
    public String e0303n;

    public String e0304a;
    public String e0304b;
    public String e0304c;
    public String e0304d;

    public String e0305a;
    public String e0305b;
    public String e0305c;
    public String e0305d;
    public String e0305e;
    public String e0305exx;

    public String e0306a0a;
    public String e0306a0ayx;
    public String e0306a0f;
    public String e0306a0fyx;

    public String e0306b0a;
    public String e0306b0ayx;
    public String e0306b0f;
    public String e0306b0fyx;

    public String e0306c0a;
    public String e0306c0ayx;
    public String e0306c0f;
    public String e0306c0fyx;

    public String e0306d0a;
    public String e0306d0ayx;
    public String e0306d0f;
    public String e0306d0fyx;

    public String e0306e0a;
    public String e0306e0ayx;
    public String e0306e0f;
    public String e0306e0fyx;

    public String e0306f0a;
    public String e0306f0ayx;
    public String e0306f0f;
    public String e0306f0fyx;

    public String e0306g0a;
    public String e0306g0ayx;
    public String e0306g0f;
    public String e0306g0fyx;

    public String e0306h0a;
    public String e0306h0ayx;
    public String e0306h0f;
    public String e0306h0fyx;

    public String e0306i0a;
    public String e0306i0ayx;
    public String e0306i0f;
    public String e0306i0fyx;

    public String e0306j0a;
    public String e0306j0ayx;
    public String e0306j0f;
    public String e0306j0fyx;

    public String e0306k0a;
    public String e0306k0ayx;
    public String e0306k0f;
    public String e0306k0fyx;

    public String e0306l0a;
    public String e0306l0ayx;
    public String e0306l0f;
    public String e0306l0fyx;

    public String e0306m0a;
    public String e0306m0ayx;
    public String e0306m0f;
    public String e0306m0fyx;

    public String e0306n0a;
    public String e0306n0ayx;
    public String e0306n0f;
    public String e0306n0fyx;

    public String e0306o0a;
    public String e0306o0ayx;
    public String e0306o0f;
    public String e0306o0fyx;

    public String e0306p0a;
    public String e0306p0ayx;
    public String e0306p0f;
    public String e0306p0fyx;

    public String e0306q0a;
    public String e0306q0ayx;
    public String e0306q0f;
    public String e0306q0fyx;

    public String e0306r0a;
    public String e0306r0ayx;
    public String e0306r0f;
    public String e0306r0fyx;

    public String e0307;
    public String e0308;
    public String e04;
    public String e0401;
    public String e0402;
    public String e0403;
    public String e0403a;
    public String e0403b;
    public String e0403c;
    public String e0404;
    public String e0405;
    public String e0406;
    public String e0407;
    public String e0407a;
    public String e0407b;
    public String e0407c;
    public String e0407d;
    public String e0408;
    public String e0409;
    public String e0410;
    public String e0410a;
    public String e0410b;
    public String e0410c;
    public String e0410d;
    public String e0410e;
    public String e0410f;
    public String e0411;
    public String e0412;
    public String e0413;
    public String e0414;
    public String e0415;
    public String e0416;
    public String e05;
    public String e0501;
    public String e0502;
    public String e0502a;
    public String e0502b;
    public String e0502c;
    public String e0502d;
    public String e0502e;
    public String e0502f;
    public String e0502g;
    public String e0502h;
    public String e0502i;
    public String e0503;
    public String e0504;
    public String e0505;
    public String e0506;
    public String e0507;
    public String e0508;
    public String e0509;
    public String e06;
    public String e0601;
    public String e0602;
    public String e0603;
    public String e0604;
    public String e0605;
    public String e0605a;
    public String e0605b;
    public String e0605c;
    public String e0605d;
    public String e0606;
    public String e0607;
    public String e0608;
    public String e0609;
    public String e0610;
    public String e0611;
    public String e07;
    public String e0701;
    public String e0702;
    public String e0702a;
    public String e0702b;
    public String e0702c;
    public String e0702d;
    public String e0702e;
    public String e0702f;
    public String e0702g;
    public String e0702h;
    public String e0702i;
    public String e0702j;
    public String e0702k;
    public String e0702l;
    public String e0703;
    public String e0703a;
    public String e0703b;
    public String e0703c;
    public String e0703d;
    public String e0704;
    public String e0704a;
    public String e0704b;
    public String e0704c;
    public String e0704d;
    public String e0704e;
    public String e0704f;
    public String e0704g;
    public String e0704gxx;
    public String e0705;
    public String e0705a0a;
    public String e0705a0ayx;
    public String e0705a0f;
    public String e0705a0fyx;
    public String e0705b0a;
    public String e0705b0ayx;
    public String e0705b0f;
    public String e0705b0fyx;
    public String e0705c0a;
    public String e0705c0ayx;
    public String e0705c0f;
    public String e0705c0fyx;
    public String e0705d0a;
    public String e0705d0ayx;
    public String e0705d0f;
    public String e0705d0fyx;
    public String e0705e0a;
    public String e0705e0ayx;
    public String e0705e0f;
    public String e0705e0fyx;
    public String e08;
    public String e0801;
    public String e0802;
    public String e0803;
    public String e0804;
    public String e0805;
    public String e0806;
    public String e0807;
    public String e0808;
    public String e0809;
    public String e0810;
    public String e0811;
    public String e0812;
    public String e0813;
    public String e0814;
    public String modftitle;
    public String f01;
    public String f0100;
    public String f01001;

    public String f0101aa0a;
    public String f0101aa0ayx;
    public String f0101aa0f;
    public String f0101aa0fyx;

    public String f0101ab0a;
    public String f0101ab0ayx;
    public String f0101ab0f;
    public String f0101ab0fyx;

    public String f0102;
    public String f0103;
    public String f0104;
    public String f0105;
    public String f0105aa;

    public String f0105aaa0a;
    public String f0105aaa0ayx;
    public String f0105aaa0f;
    public String f0105aaa0fyx;

    public String f0105aab0a;
    public String f0105aab0ayx;
    public String f0105aab0f;
    public String f0105aab0fyx;

    public String f0105aac0a;
    public String f0105aac0ayx;
    public String f0105aac0f;
    public String f0105aac0fyx;

    public String f0106;
    public String f0106aa;

    public String f0106aaa0a;
    public String f0106aaa0ayx;
    public String f0106aaa0f;
    public String f0106aaa0fyx;

    public String f0107;
    public String f0108;
    public String f0109;
    public String f0110;
    public String f0110aa;

    public String f0110aaa0a;
    public String f0110aaa0ayx;
    public String f0110aaa0f;
    public String f0110aaa0fyx;
    public String f0110aab0a;
    public String f0110aab0ayx;
    public String f0110aab0f;
    public String f0110aab0fyx;
    public String f0110aac0a;
    public String f0110aac0ayx;
    public String f0110aac0f;
    public String f0110aac0fyx;
    public String f0110aad0a;
    public String f0110aad0ayx;
    public String f0110aad0f;
    public String f0110aad0fyx;
    public String f0110aae0a;
    public String f0110aae0ayx;
    public String f0110aae0f;
    public String f0110aae0fyx;

    public String f02;
    public String f0201;
    public String f0201aa;

    public String f0201aaa0a;
    public String f0201aaa0ayx;
    public String f0201aaa0f;
    public String f0201aaa0fyx;
    public String f0201aab0a;
    public String f0201aab0ayx;
    public String f0201aab0f;
    public String f0201aab0fyx;

    public String f0202;
    public String f0202aa;

    public String f0202aaa0a;
    public String f0202aaa0ayx;
    public String f0202aaa0f;
    public String f0202aaa0fyx;
    public String f0202aab0a;
    public String f0202aab0ayx;
    public String f0202aab0f;
    public String f0202aab0fyx;

    public String f0203;
    public String f0203aa;
    public String f0203aaa0a;
    public String f0203aaa0ayx;
    public String f0203aaa0f;
    public String f0203aaa0fyx;
    public String f0203aab0a;
    public String f0203aab0ayx;
    public String f0203aab0f;
    public String f0203aab0fyx;

    public String f03;
    public String f0301;
    public String f0301aa;

    public String f0301aaa0a;
    public String f0301aaa0ayx;
    public String f0301aaa0f;
    public String f0301aaa0fyx;

    public String f0302;
    public String f0302aa;

    public String f0302aaa0a;
    public String f0302aaa0ayx;
    public String f0302aaa0f;
    public String f0302aaa0fyx;

    public String f04;
    public String f0401;
    public String f0401aa;

    public String f0401aaa0a;
    public String f0401aaa0ayx;
    public String f0401aaa0f;
    public String f0401aaa0fyx;
    public String f0401aab0a;
    public String f0401aab0ayx;
    public String f0401aab0f;
    public String f0401aab0fyx;
    public String f0401aac0a;
    public String f0401aac0ayx;
    public String f0401aac0f;
    public String f0401aac0fyx;

    public String f0402;
    public String f0402aa;
    public String f0402aaa0a;
    public String f0402aaa0ayx;
    public String f0402aaa0f;
    public String f0402aaa0fyx;
    public String f0403;
    public String f0403aa;
    public String f0403aaa0a;
    public String f0403aaa0ayx;
    public String f0403aaa0f;
    public String f0403aaa0fyx;
    public String f0404;
    public String f0404aa;
    public String f0404aaa0a;
    public String f0404aaa0ayx;
    public String f0404aaa0f;
    public String f0404aaa0fyx;
    public String modgtitle;
    public String g01;
    public String g0101;
    public String g0101xx;
    public String g0102;
    public String g0102a;
    public String g0102b;
    public String g0103;
    public String g0103xx;
    public String g0104;
    public String g0105ax;
    public String g0105bx;
    public String g0105cx;
    public String g0106;
    public String g0106xx;
    public String g0107;
    public String g0107xx;

    public String g0108a;
    public String g0108b;
    public String g0108c;

    public String g0109;
    public String g0110ax;
    public String g0110bx;
    public String g0110cx;
    public String g0111;
    public String g01112;
    public String g01112xx;
    public String g01113;
    public String g01114;
    public String g01115;
    public String g01116;
    public String g01117;

    public String g0201;
    public String g0202;
    public String g0203;
    public String g0203x;
    public String g0204;
    public String g0205;
    public String g0206;
    public String g0207;
    public String g0208;

    public String g0301aa;
    public String g0301ab;

    public String g0301ba;
    public String g0301bb;

    public String g0301ca;
    public String g0301cb;

    public String g0302a10r;
    public String g0302a10i;
    public String g0302a10d;
    public String g0302a10b;

    public String g0302a20r;
    public String g0302a20i;
    public String g0302a20d;
    public String g0302a20b;

    public String g0302a30r;
    public String g0302a30i;
    public String g0302a30d;
    public String g0302a30b;

    public String g0302a40r;
    public String g0302a40i;
    public String g0302a40d;
    public String g0302a40b;

    public String g0302a50r;
    public String g0302a50i;
    public String g0302a50d;
    public String g0302a50b;

    public String g0302a60r;
    public String g0302a60i;
    public String g0302a60d;
    public String g0302a60b;

    public String g0302a70r;
    public String g0302a70i;
    public String g0302a70d;
    public String g0302a70b;

    public String g0302b10r;
    public String g0302b10i;
    public String g0302b10d;
    public String g0302b10b;

    public String g0302b20r;
    public String g0302b20i;
    public String g0302b20d;
    public String g0302b20b;

    public String g0302b30r;
    public String g0302b30i;
    public String g0302b30d;
    public String g0302b30b;

    public String g0302b40r;
    public String g0302b40i;
    public String g0302b40d;
    public String g0302b40b;

    public String g0302b50r;
    public String g0302b50i;
    public String g0302b50d;
    public String g0302b50b;

    public String g0302b60r;
    public String g0302b60i;
    public String g0302b60d;
    public String g0302b60b;

    public String g0302b70r;
    public String g0302b70i;
    public String g0302b70d;
    public String g0302b70b;

    public String g0302c10r;
    public String g0302c10i;
    public String g0302c10d;
    public String g0302c10b;

    public String g0302c20r;
    public String g0302c20i;
    public String g0302c20d;
    public String g0302c20b;

    public String g0302c30r;
    public String g0302c30i;
    public String g0302c30d;
    public String g0302c30b;

    public String g0302c40r;
    public String g0302c40i;
    public String g0302c40d;
    public String g0302c40b;

    public String g0302c50r;
    public String g0302c50i;
    public String g0302c50d;
    public String g0302c50b;

    public String g0302c60r;
    public String g0302c60i;
    public String g0302c60d;
    public String g0302c60b;

    public String g0302c70r;
    public String g0302c70i;
    public String g0302c70d;
    public String g0302c70b;

    public String g04;
    public String g0401;

    public String g040110a;
    public String g040110s;
    public String g040110sd;
    public String g040110sm;
    public String g040110p;

    public String g040120a;
    public String g040120s;
    public String g040120sm;
    public String g040120sd;
    public String g040120p;

    public String g04013;

    public String g04010a;
    public String g04010s;
    public String g04010sd;
    public String g04010sm;
    public String g04010p;

    public String g040150a;
    public String g040150s;
    public String g040150sd;
    public String g040150sm;
    public String g040150p;

    public String g040160a;
    public String g040160s;
    public String g040160sd;
    public String g040160sm;
    public String g040160p;

    public String g040170a;
    public String g040170s;
    public String g040170sd;
    public String g040170sm;
    public String g040170p;

    public String g040180a;
    public String g040180s;
    public String g040180sd;
    public String g040180sm;
    public String g040180p;

    public String g040190a;
    public String g040190s;
    public String g040190sd;
    public String g040190sm;
    public String g040190p;

    public String g0401100a;
    public String g0401100s;
    public String g0401100sd;
    public String g0401100sm;
    public String g0401100p;

    public String g0401110a;
    public String g0401110s;
    public String g0401110sd;
    public String g0401110sm;
    public String g0401110p;

    public String g0401120a;
    public String g0401120s;
    public String g0401120sd;
    public String g0401120sm;
    public String g0401120p;

    public String g0401130a;
    public String g0401130s;
    public String g0401130sd;
    public String g0401130sm;
    public String g0401130p;

    public String g0401140a;
    public String g0401140s;
    public String g0401140sd;
    public String g0401140sm;
    public String g0401140p;

    public String g0401150a;
    public String g0401150s;
    public String g0401150sd;
    public String g0401150sm;
    public String g0401150p;

    public String g0401160a;
    public String g0401160s;
    public String g0401160sd;
    public String g0401160sm;
    public String g0401160p;

    public String g0401170a;
    public String g0401170s;
    public String g0401170sd;
    public String g0401170sm;
    public String g0401170p;

    public String g0401180a;
    public String g0401180s;
    public String g0401180sd;
    public String g0401180sm;
    public String g0401180p;

    public String g0401190a;
    public String g0401190s;
    public String g0401190sd;
    public String g0401190sm;
    public String g0401190p;

    public String g0401200a;
    public String g0401200s;
    public String g0401200sd;
    public String g0401200sm;
    public String g0401200p;

    public String g0401210a;
    public String g0401210s;
    public String g0401210sd;
    public String g0401210sm;
    public String g0401210p;

    public String g0401220a;
    public String g0401220s;
    public String g0401220sd;
    public String g0401220sm;
    public String g0401220p;

    public String g0401230a;
    public String g0401230s;
    public String g0401230sd;
    public String g0401230sm;
    public String g0401230p;

    public String g0401240a;
    public String g0401240s;
    public String g0401240sd;
    public String g0401240sm;
    public String g0401240p;

    public String g0401250a;
    public String g0401250s;
    public String g0401250sd;
    public String g0401250sm;
    public String g0401250p;

    public String g0401260a;
    public String g0401260s;
    public String g0401260sd;
    public String g0401260sm;
    public String g0401260p;

    public String g0401270a;
    public String g0401270s;
    public String g0401270sd;
    public String g0401270sm;
    public String g0401270p;

    public String g0401280a;
    public String g0401280s;
    public String g0401280sd;
    public String g0401280sm;
    public String g0401280p;

    public String g0401290a;
    public String g0401290s;
    public String g0401290sd;
    public String g0401290sm;
    public String g0401290p;

    public String g0401300a;
    public String g0401300s;
    public String g0401300sd;
    public String g0401300sm;
    public String g0401300p;

    public String g0401310a;
    public String g0401310s;
    public String g0401310sd;
    public String g0401310sm;
    public String g0401310p;

    public String g0401320a;
    public String g0401320s;
    public String g0401320sd;
    public String g0401320sm;
    public String g0401320p;

    public String g0401330a;
    public String g0401330s;
    public String g0401330sd;
    public String g0401330sm;
    public String g0401330p;

    public String g0401340a;
    public String g0401340s;
    public String g0401340sd;
    public String g0401340sm;
    public String g0401340p;

    public String g0401350a;
    public String g0401350s;
    public String g0401350sd;
    public String g0401350sm;
    public String g0401350p;

    public String g0401360a;
    public String g0401360s;
    public String g0401360sd;
    public String g0401360sm;
    public String g0401360p;

    public String g0401370a;
    public String g0401370s;
    public String g0401370sd;
    public String g0401370sm;
    public String g0401370p;

    public String g0401380a;
    public String g0401380s;
    public String g0401380sd;
    public String g0401380sm;
    public String g0401380p;

    public String g0401390a;
    public String g0401390s;
    public String g0401390sd;
    public String g0401390sm;
    public String g0401390p;

    public String g0401400a;
    public String g0401400s;
    public String g0401400sd;
    public String g0401400sm;
    public String g0401400p;

    public String g0401410a;
    public String g0401410s;
    public String g0401410sd;
    public String g0401410sm;
    public String g0401410p;

    public String g0401420a;
    public String g0401420s;
    public String g0401420sd;
    public String g0401420sm;
    public String g0401420p;

    public String g0401430a;
    public String g0401430s;
    public String g0401430sd;
    public String g0401430sm;
    public String g0401430p;

    public String g0401440a;
    public String g0401440s;
    public String g0401440sd;
    public String g0401440sm;
    public String g0401440p;

    public String g0402;

    public String g040210a;
    public String g040210s;
    public String g040210sd;
    public String g040210sm;
    public String g040210p;

    public String g040220a;
    public String g040220s;
    public String g040220sd;
    public String g040220sm;
    public String g040220p;

    public String g040230a;
    public String g040230s;
    public String g040230sd;
    public String g040230sm;
    public String g040230p;

    public String g040240a;
    public String g040240s;
    public String g040240sd;
    public String g040240sm;
    public String g040240p;

    public String g040250a;
    public String g040250s;
    public String g040250sd;
    public String g040250sm;
    public String g040250p;

    public String g040260a;
    public String g040260s;
    public String g040260sd;
    public String g040260sm;
    public String g040260p;

    public String g040270a;
    public String g040270s;
    public String g040270sd;
    public String g040270sm;
    public String g040270p;

    public String g040280a;
    public String g040280s;
    public String g040280sd;
    public String g040280sm;
    public String g040280p;

    public String g040290a;
    public String g040290s;
    public String g040290sd;
    public String g040290sm;
    public String g040290p;

    public String g0402100a;
    public String g0402100s;
    public String g0402100sd;
    public String g0402100sm;
    public String g0402100p;

    public String g0403;

    public String g040310a;
    public String g040310s;
    public String g040310sd;
    public String g040310sm;
    public String g040310p;

    public String g040320a;
    public String g040320s;
    public String g040320sd;
    public String g040320sm;
    public String g040320p;

    public String g040330a;
    public String g040330s;
    public String g040330sd;
    public String g040330sm;
    public String g040330p;

    public String g040340a;
    public String g040340s;
    public String g040340sd;
    public String g040340sm;
    public String g040340p;

    public String g040350a;
    public String g040350s;
    public String g040350sd;
    public String g040350sm;
    public String g040350p;

    public String g040360a;
    public String g040360s;
    public String g040360sd;
    public String g040360sm;
    public String g040360p;

    public String g040370a;
    public String g040370s;
    public String g040370sd;
    public String g040370sm;
    public String g040370p;

    public String g040380a;
    public String g040380s;
    public String g040380sd;
    public String g040380sm;
    public String g040380p;

    public String g040390a;
    public String g040390s;
    public String g040390sd;
    public String g040390sm;
    public String g040390p;

    public String g0403100a;
    public String g0403100s;
    public String g0403100sd;
    public String g0403100sm;
    public String g0403100p;

    public String g0403110a;
    public String g0403110s;
    public String g0403110sd;
    public String g0403110sm;
    public String g0403110p;

    public String g0403120a;
    public String g0403120s;
    public String g0403120sd;
    public String g0403120sm;
    public String g0403120p;

    public String g0403130a;
    public String g0403130s;
    public String g0403130sd;
    public String g0403130sm;
    public String g0403130p;

    public String g0403140a;
    public String g0403140s;
    public String g0403140sd;
    public String g0403140sm;
    public String g0403140p;

    public String g0403150a;
    public String g0403150s;
    public String g0403150sd;
    public String g0403150sm;
    public String g0403150p;

    public String g0403160a;
    public String g0403160s;
    public String g0403160sd;
    public String g0403160sm;
    public String g0403160p;

    public String g0403170a;
    public String g0403170s;
    public String g0403170sd;
    public String g0403170sm;
    public String g0403170p;

    public String g0403180a;
    public String g0403180s;
    public String g0403180sd;
    public String g0403180sm;
    public String g0403180p;

    public String g0403190a;
    public String g0403190s;
    public String g0403190sd;
    public String g0403190sm;
    public String g0403190p;

    public String g0403200a;
    public String g0403200s;
    public String g0403200sd;
    public String g0403200sm;
    public String g0403200p;

    public String g0403210a;
    public String g0403210s;
    public String g0403210sd;
    public String g0403210sm;
    public String g0403210p;

    public String g0403220a;
    public String g0403220s;
    public String g0403220sd;
    public String g0403220sm;
    public String g0403220p;

    public String g0403230a;
    public String g0403230s;
    public String g0403230sd;
    public String g0403230sm;
    public String g0403230p;

    public String g0403240a;
    public String g0403240s;
    public String g0403240sd;
    public String g0403240sm;
    public String g0403240p;

    public String g0403250a;
    public String g0403250s;
    public String g0403250sd;
    public String g0403250sm;
    public String g0403250p;

    public String g0403260a;
    public String g0403260s;
    public String g0403260sd;
    public String g0403260sm;
    public String g0403260p;

    public String g0403270a;
    public String g0403270s;
    public String g0403270sd;
    public String g0403270sm;
    public String g0403270p;

    public String g0404;

    public String g040410a;
    public String g040410s;
    public String g040410sd;
    public String g040410sm;
    public String g040410p;

    public String g040420a;
    public String g040420s;
    public String g040420sd;
    public String g040420sm;
    public String g040420p;

    public String g040430a;
    public String g040430s;
    public String g040430sd;
    public String g040430sm;
    public String g040430p;

    public String g040440a;
    public String g040440s;
    public String g040440sd;
    public String g040440sm;
    public String g040440p;

    public String g040450a;
    public String g040450s;
    public String g040450sd;
    public String g040450sm;
    public String g040450p;

    public String g040460a;
    public String g040460s;
    public String g040460sd;
    public String g040460sm;
    public String g040460p;

    public String modhtitle;
    public String h01;
    public String h0101;
    public String h0101a;
    public String h0101b;
    public String h0101c;
    public String h0101aa;
    public String h0101ab;
    public String h0101ba;
    public String h0101bb;
    public String h0101ca;
    public String h0101cb;

    public String h0201;
    public String h0202;
    public String h0203a;
    public String h0203b;

    public String h03;
    public String h0301a0a;
    public String h0301a0b;
    public String h0301a0c;
    public String h0301b0a;
    public String h0301b0b;
    public String h0301b0c;
    public String h0301c0a;
    public String h0301c0b;
    public String h0301c0c;
    public String h0301d0a;
    public String h0301d0b;
    public String h0301d0c;
    public String h0301e0a;
    public String h0301e0b;
    public String h0301e0c;
    public String h0301f0a;
    public String h0301f0b;
    public String h0301f0c;
    public String h0301g0a;
    public String h0301g0b;
    public String h0301g0c;
    public String h03011h0a;
    public String h03011h0b;
    public String h03011h0c;
    public String h0301i0a;
    public String h0301i0b;
    public String h0301i0c;
    public String h0301j0a;
    public String h0301j0b;
    public String h0301j0c;
    public String h0301k0a;
    public String h0301k0b;
    public String h0301k0c;
    public String h0301l0a;
    public String h0301l0b;
    public String h0301l0c;
    public String h0301m0a;
    public String h0301m0b;
    public String h0301m0c;
    public String h04;
    public String h0401;
    public String h05;
    public String h0501;
    public String h06;
    public String h0601;
    public String h0601aa;
    public String h0602;
    public String h0603;
    public String h0603a;
    public String h0603b;
    public String h0603c;
    public String h08;
    public String h0801;
    public String h0802;
    public String h09;
    public String h0901;
    public String h0902;
    public String h0902a;
    public String h0902b;
    public String h0902c;
    public String h10;
    public String h1001;
    public String h1002;
    public String h1002a;
    public String h1002b;
    public String h11;
    public String h1101;
    public String h1102;
    public String h1103;
    public String h1104;
    public String h1105;
    public String h1106;
    public String h1107;
    public String h12;
    public String h1201;
    public String h1202;
    public String h1203;
    public String h1203a;
    public String h1203b;
    public String h1203c;
    public String h1203d;
    public String h1203e;
    public String h1203f;
    public String h1203g;
    public String h13;
    public String h1301;
    public String h1302;
    public String h1303;
    public String h14;
    public String h1401;
    public String h1401a;
    public String h1401b;
    public String h1401c;
    public String h1401d;
    public String h1401e;
    public String h15;
    public String h1501;
    public String h1501a0a;
    public String h1501a0b;
    public String h1501a0c;
    public String h1501a0d;
    public String h1501b0a;
    public String h1501b0b;
    public String h1501b0c;
    public String h1501b0d;
    public String h1501c0a;
    public String h1501c0b;
    public String h1501c0c;
    public String h1501c0d;
    public String h1501d0a;
    public String h1501d0b;
    public String h1501d0c;
    public String h1501d0d;
    public String h1501e0a;
    public String h1501e0b;
    public String h1501e0c;
    public String h1501e0d;
    public String h1501f0a;
    public String h1501f0b;
    public String h1501f0c;
    public String h1501f0d;
    public String h1501g0a;
    public String h1501g0b;
    public String h1501g0c;
    public String h1501g0d;
    public String h1501h0a;
    public String h1501h0b;
    public String h1501h0c;
    public String h1501h0d;
    public String h1501i0a;
    public String h1501i0b;
    public String h1501i0c;
    public String h1501i0d;
    public String h1501j0a;
    public String h1501j0b;
    public String h1501j0c;
    public String h1501j0d;
    public String h1501k0a;
    public String h1501k0b;
    public String h1501k0c;
    public String h1501k0d;
    public String h1501l0a;
    public String h1501l0b;
    public String h1501l0c;
    public String h1501l0d;
    public String h1501m0a;
    public String h1501m0b;
    public String h1501m0c;
    public String h1501m0d;
    public String h1501n0a;
    public String h1501n0b;
    public String h1501n0c;
    public String h1501n0d;
    public String h1501o0a;
    public String h1501o0b;
    public String h1501o0c;
    public String h1501o0d;
    public String h1501p0a;
    public String h1501p0b;
    public String h1501p0c;
    public String h1501p0d;
    public String h1501q0a;
    public String h1501q0b;
    public String h1501q0c;
    public String h1501q0d;
    public String h1501r0a;
    public String h1501r0b;
    public String h1501r0c;
    public String h1501r0d;
    public String h1501s0a;
    public String h1501s0b;
    public String h1501s0c;
    public String h1501s0d;
    public String h1501t0a;
    public String h1501t0b;
    public String h1501t0c;
    public String h1501t0d;
    public String h1501u0a;
    public String h1501u0b;
    public String h1501u0c;
    public String h1501u0d;
    public String h1501v0a;
    public String h1501v0b;
    public String h1501v0c;
    public String h1501v0d;
    public String h1501w0a;
    public String h1501w0b;
    public String h1501w0c;
    public String h1501w0d;
    public String h1501x0a;
    public String h1501x0b;
    public String h1501x0c;
    public String h1501x0d;
    public String h1501y0a;
    public String h1501y0b;
    public String h1501y0c;
    public String h1501y0d;
    public String h1501z0a;
    public String h1501z0b;
    public String h1501z0c;
    public String h1501z0d;
    public String h16;
    public String h1601;
    public String h1602;
    public String h1603;
    public String h1604;
    public String h1605;
    public String h07;
    public String h0701;
    public String h0701a;
    public String h0701b;
    public String h0701c;
    public String h0701d;
    public String h0701e;
    public String h0701f;
    public String h0701g;
    public String modititle;
    public String i01;
    public String i0101;
    public String i0102;
    public String i0102a;
    public String i0102b;
    public String i0103;
    public String i0104;
    public String i0105;
    public String i0106;
    public String i0107;
    public String i0108;
    public String i02;
    public String i0201a;
    public String i0201b;
    public String i0201c;
    public String i0201d;
    public String i0201e;
    public String i0201f;
    public String i0201g;
    public String i0201h;
    public String i0201i;
    public String i0201j;
    public String i0201ja;
    public String i0201jb;
    public String i0201jc;
    public String i0201jd;
    public String i0201je;
    public String i0201k;
    public String i0201l;
    public String i0201la;
    public String i0201lb;
    public String i0201lc;
    public String i0201m;
    public String i0201n;
    public String i0201o;
    public String i0201p;
    public String i0201pa;
    public String i0201pb;
    public String i0201pc;
    public String i0201pd;
    public String i0201pe;
    public String i0201pf;
    public String i0201q;
    public String i03;
    public String i0301a;
    public String i0301b;
    public String i0301c;
    public String i0301d;
    public String i0301e;
    public String i0301f;
    public String i0301g;
    public String i0301h;
    public String i0301i;
    public String i0301j;
    public String i0301k;
    public String i04;
    public String i0401a;
    public String i0401b;
    public String i0401c;
    public String i0401d;
    public String i0401e;
    public String i0401f;
    public String i0401g;
    public String modjtitle;
    public String j01;
    public String j0100;
    public String j0100aa;
    public String j0101;
    public String j0101a;
    public String j0101b;
    public String j0101c;
    public String j0101d;
    public String j0101e;
    public String j0101f;
    public String j0101g;
    public String j0101h;
    public String j0101i;
    public String j0101ia;
    public String j0101ib;
    public String j0101j;
    public String j0101k;
    public String j0101l;
    public String j0101m;
    public String j0101ma;
    public String j0101mb;
    public String j0101mc;
    public String j0101md;
    public String j0101me;
    public String j0101mf;
    public String j0101mx;
    public String j02;
    public String j0200;
    public String j0200aa;
    public String j0201;
    public String j0201a;
    public String j0201b;
    public String j0201c;
    public String j0201d;
    public String j0201e;
    public String j0201f;
    public String j0201g;
    public String j0201ga;
    public String j0201gb;
    public String j0201gc;
    public String j0201gd;
    public String j0201ge;
    public String j0201gf;
    public String j0201gx;
    public String j03;
    public String j0300;
    public String j0300aa;
    public String j0i00;
    public String j0301a;
    public String j0301b;
    public String j0301c;
    public String j0301d;
    public String j0301e;
    public String j0301f;
    public String j0301g;
    public String j0301h;
    public String j0301i;
    public String j0301j;
    public String j0301k;
    public String j0301l;
    public String j0301m;
    public String j0301n;
    public String j0301o;
    public String j0301p;
    public String j0301q;
    public String j0301r;
    public String j0301s;
    public String j0301t;
    public String j0301u;
    public String j0301v;
    public String j0301w;
    public String j0301wa;
    public String j0301wb;
    public String j0301wc;
    public String j0301wd;
    public String j0301we;
    public String j0301wf;
    public String j0301wx;
    public String j04;
    public String j0400;
    public String j0400aa;
    public String j0401;
    public String j0401a;
    public String j0401b;
    public String j0401c;
    public String j0401d;
    public String j0401e;
    public String j0401f;
    public String j0401g;
    public String j0401h;
    public String j0401i;
    public String j0401j;
    public String j0401k;
    public String j0401l;
    public String j0401m;
    public String j0401ma;
    public String j0401mb;
    public String j0401mc;
    public String j0401md;
    public String j0401me;
    public String j0401mf;
    public String j0401mx;
    public String j05;
    public String j0500;
    public String j0500aa;
    public String j0501;
    public String j0501a;
    public String j0501b;
    public String j0501c;
    public String j0501d;
    public String j0501e;
    public String j0501f;
    public String j0501g;
    public String j0501h;
    public String j0501i;
    public String j0501j;
    public String j0501k;
    public String j0501l;
    public String j0501m;
    public String j0501n;
    public String j0501na;
    public String j0501nb;
    public String j0501nc;
    public String j0501nd;
    public String j0501ne;
    public String j0501nf;
    public String j0501nx;
    public String j06;
    public String j0600;
    public String j0600aa;
    public String j0601;
    public String j0601a;
    public String j0601b;
    public String j0601c;
    public String j0601d;
    public String j0601e;
    public String j0601f;
    public String j0601g;
    public String j0601h;
    public String j0601i;
    public String j0601j;
    public String j0601k;
    public String j0601l;
    public String j0601m;
    public String j0601ma;
    public String j0601mb;
    public String j0601mc;
    public String j0601md;
    public String j0601me;
    public String j0601mf;
    public String j0601mx;
    public String j07;
    public String j0700;
    public String j0700aa;
    public String j0701;
    public String j0701a;
    public String j0701b;
    public String j0701c;
    public String j0701d;
    public String j0701e;
    public String j0701f;
    public String j0701g;
    public String j0701ga;
    public String j0701gb;
    public String j0701gc;
    public String j0701gd;
    public String j0701ge;
    public String j0701gf;
    public String j0701gx;
    public String j08;
    public String j0800;
    public String j0800aa;
    public String j0801;
    public String j0801a;
    public String j0801b;
    public String j0801c;
    public String j0801d;
    public String j0801e;
    public String j0801f;
    public String j0801g;
    public String j0801ga;
    public String j0801gb;
    public String j0801gc;
    public String j0801gd;
    public String j09;
    public String j0900;
    public String j0900aa;
    public String j0901;
    public String j0901a;
    public String j0901b;
    public String j0901c;
    public String j0901d;
    public String j0901e;
    public String j0901f;
    public String j0901fa;
    public String j0901fb;
    public String j0901fc;
    public String j0901fd;
    public String j0901fe;

    public String k0101a;
    public String k0101b;
    public String k0101c;
    public String k0101xx;
    public String k0102;
    public String k0103;
    public String k0104;
    public String k0104aa;
    public String k0104aaxx;
    public String k0105;
    public String k0201a;
    public String k0201b;
    public String k0202;
    public String k0203;
    public String k0204;
    public String k0401;
    public String k0402;
    public String k0403;
    public String k0404;
    public String k0405;
    public String k0406;
    public String k0501;
    public String k0502;
    public String k0503;
    public String k0504;
    public String k0505;
    public String k0506;
    public String k0701a;
    public String k0701b;
    public String k0701c;
    public String k0702a;
    public String k0702b;
    public String k0702c;
    public String k0801a;
    public String k0801b;
    public String k0801c;
    public String k0802a;
    public String k0802b;
    public String k0802c;
    public String k0803a;
    public String k0803b;
    public String k0803c;
    public String k0804a;
    public String k0804b;
    public String k0804c;
    public String k0805a;
    public String k0805b;
    public String k0805c;
    public String k0806a;
    public String k0806b;
    public String k0806c;

    public String k0901a;
    public String k0901b;
    public String k0901c;
    public String k0902a;
    public String k0902b;
    public String k0902c;
    public String k0903a;
    public String k0903b;
    public String k0903c;
    public String k0904a;
    public String k0904b;
    public String k0904c;
    public String k0905a;
    public String k0905b;
    public String k0905c;

    public String k10;
    public String k100;
    public String k1001;
    public String k1002;
    public String k1003;
    public String k1004;
    public String k1005;
    public String k1006;
    public String k1007;
    public String k1008;
    public String k1009;
    public String k1010;
    public String k1011;
    public String k101;
    public String k1012;
    public String k1013;
    public String k1014;
    public String k1015;
    public String k11;
    public String k1100;
    public String k1101;
    public String k1102;
    public String k1103;
    public String k1104;
    public String k1105;
    public String k1106;
    public String k1107;
    public String k1108;
    public String k1109;
    public String k1110;
    public String k1111;

    public FormsContract() {
    }


    

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


        public static String _URL = "sync.php";
    }
}
