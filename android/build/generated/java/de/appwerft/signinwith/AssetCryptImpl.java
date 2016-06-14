package de.appwerft.signinwith;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import java.lang.System;
import org.appcelerator.kroll.util.KrollAssetHelper;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import android.os.Debug;

public class AssetCryptImpl implements KrollAssetHelper.AssetCrypt
{
  private static class Range {
    int offset;
    int length;
    public Range(int offset, int length) {
      this.offset = offset;
      this.length = length;
    }
  }

	private static final byte[] assetsBytes = Charset.forName("ISO-8859-1").encode(initAssetsBytes()).array();
	private static CharBuffer initAssetsBytes() {
		CharBuffer buffer = CharBuffer.allocate(7595);
		buffer.append("VZ\2607\337A\033\310\231\233\326\344\026\345\031\005\207\177c\317\204\211\303Z\024}X\221\302o)\361S`\217\324\215^3\315aF\274`\327at\207_R\331o\221\370\0332_\037\207\012\037<\021a\333\215\270\200\021\321Y\321\227\334\232\352\346\350\214\210\231\343\311\034:\035\033\017\\\315\364\316\276\321\260E~\310L\251\321\256l\015\030vu\306\270\360\350\275v\021$\362E\255S\300o\202\234\273\3742\236\2743XM\347\275{\026\300\373\2532\3126\204\002\312\331\335X\357\261F\326&\221\2413\2040\330v\334\253\247\026\2703@\255D\217\327U\246\213crD\326\374k\204\012\2304h\205\334k7-^>]\370zw\361\274\344|\236\227\340\013\243\252\026\\-\356O\002|\006\2749O.kK3\254\013!\253(\224-$\324\177U\377\200\373\340\246]\325\351\347\343\226\340\350\035\257\246\213\211\277\215M\345]_\375v9\201\271\007\036\326qc\0007\026\340G\2716\300HHU::\276O\227\221Dg:\204\313\265\372\351\356\355,\256\363\205\015\372\370\255\255\006\245\234\036\367\261g\242`\020o\273/#\363\246\021\360_A\013@.\302M\263G\346\204;~\016-b\206f\335\337\026\016;-|\253\001B\341Q|gtE\261\344J\270\354\312\373\337\3126\024\322&$\006p\245JA,u\227\251\306+}5\212\2606\255\227\244\204\247:E\006\340\264\255\307;\254\275\271\237\350\241\274\234G G\006\211*\034t\3630+\355\310U\016\233K\363_\206\233\264\304^h\317\304\267\376\364U\207\\\342PD\365\330\225\244\020{\327\340\343Md\363;K\223\244\363p\325\215\362\276\301\030\214\261\003\337\230\347\267\311\354\3410\313\234f\317\2722\030\230\201\225\345\300s\301\036y\023C\205\316\2352\265\014LW\344\256\253\016\322\226g\320\374\240\363 r2_\345v\362\212qF)D\221\004U\270\304\2506\231\004\250\231g\002?/5\327b.6\256\324<\313\244\236\006Vs\245\355\212\305\033\314r\360Dr\213\037\231GH*\275\307)\372oB\014\306\3403\214\275\207W\326\200\344E>\313\015\227\244\305M\264\205}8\370|\217^\356\3244\026\325\375#\256\332\343\213\255\2107\3659\215\023\222\317\024\232\361\242YY\310)\323\012\325\224\026\331(\207J\337~\002\331\241\005\242U\031\273rC\255\024\353S\362\211\217\366.\025\226Q\243\341K^\214\212\035z\333\321\005\366\204~\247.\236v\230\221h[\252\231\025\3007\332\235\334\376e\210\016i\262\252\336\353I@\301v\364\310\324\034\314\020\213\317{T\355\207od\303\010\202\201\001\2075\207'\231\013U\203\313\030\243v\201\033\353\2312\315\235\001\337=xj\311U\307\221\334%\351\365\206\200\234\006\361\343\337\314h$\372:\202m\006\336\037\205\374\223\307N\305\300ahW\214\317\200G\0011\026\037<\200\264-i\305:\312C\324\230\0150\247\240}w\3266\322\033\300\362*}?\347>[\004fC\225\024\275\342\037$X\007\220\275e\332Y\255\354\036,\3148\374\231[#\373\343\027\311\002:\342e\373\230\310<\362H$M\267~\337}\237RY\273OA\270\232m\217\304\356b\224O=\007\335Gt\353\211\011C\033\260\177\344%\315\243\220\276I$\025\341\216\316\227N\015\313\240\210F\256k\314\024\265\330L\246\235B\244V_?4\236\243\310\375\300\360.\212\346FBmk\014#7\020\337\273\314\336K\321\324\253\212M\337y\271\320\243\276\033*\321Y\2022F\360\366J~\247\\\207\353\357\243\346\017QEj!\264\014\273N\322\240\301\355e\260\263\353\307\264\264\200\356\037\307-&\335sU\350%bh\356;\277\317+\356\250\325\006\262\306\250]\324\225\032\300n\002U\222\312\346}{\361W[\236\311\027X\342\023tZ\217\033mS\301\227`\365\250\223\012\237\3027\225a\364U\305\276\224\037\252\220\362D\331\337\317\235\210\201\335\323\366\373i\263\035\207\212\361\037]\033!*j\2549\354\005\030o\310>P^G\371\351\026\311\270\362\323\216\352\014\025\270;\362=\310\310\032\270\263\3206\220\314G\245\315\010ZF\3053DGUE5\261\013\312W\226\300\332\323jJ\377\007\367\320S\037/\365\376\357\224~C\276\372fr\247%|\224\264,\251\262\334\315\315\0378]/1\373\243~(s\212\212\255Q\337,\000\216v\260.J\344\004G\255\337\016bT\311\340\221(\220\256\024g\324\343oa\262\353lJ\367\247\233\332\333\276\021I\226\234l\340A\010\226\346}\304(\232\307#\242\200??\303\000\221\0216\234&Nc\275RUQ\345\311\355\001\2231\255!V\343=8R\346\301U\204|1\222\234\337A^}|\032\365\3555l\265\360T=\336\376\357r%=\212\035\3037\027\265\207\032\355\022\377\"\360\227\310\373\351\207\243'\202\353\271\003Z\226\231S+\376q\006\374,\003=\370\003\015\014\335B\022\212-\267|\341\\\012\337\335/\355\357+=\262\323p\265\027\226g\372xmj\024\276;\215A\337^\264\363Deh\375\311\0271,\254\346c{\271W\037\221\227\265l\305\351\372X\215]\336\366\235\230\372Z\023@\274\341>\202\236\375eZm\302@\361\336\210C\215\275\210\274W\000._D\374\20023\35507\222\230\002\226=\361\360\005\267\004,X\276\002p\257\014\340_\304\271\223`03,AW+\275\005\210g\361\362\335\015\271\320\346z\352y\272\274\336&\000\331\356B\362\036\253\241\243M\224\373\023\222\332\313G\005\022\355q\234\273\024\355\022C\025\346y@#G\240l\003N\271\362\307'\252X\263 \200\002\020a\312\215\224\217*Kk\302\\\320\326E\225\347\204\375\353\275\334\2137\244\242v\036'\254\244\363\365\030\354K\023\260`\247p\317b\235I\313h\037\302\361\226\206\376\340\004\005\222 Be\027\3666\005&\015\207\350\271\203\354^\260\220~\226\336\206\334\206k-J\226\365O\337\342n6\023\226\266T\220\331\023\371\213$\324\237:\0256\321a\342|\337\336\025\313\364\031\245\275)\327\273!\353&\263\341x\262\030\355\242$Z\205\307\335+\325w\365Q\201\320I\365\373l!\317\216\202\223]s\017\012\336\316\320\200\004\034\210T\310j)\244\264\011\354\225\234\013\336vG\217)\216\303[-\227>6\336~\201W\304P\256\031\205\201\322\207\200\035\353\225\361\000\223\354Er\350\304\267\340\212\023?*\365\361r\213\360\341}\345\360>\270Z\006ka\177\353\360\232\311\014\206x6\360\015\344*4\262\211X\213?\355\013^Hr\230\003\014\306s\0313\334\372D\315\325f;\313\233\007\373\003\265%\352\360q\221#\374\253\207~u'\020\300\002\240\340\276\325\237\337\325\230>W\0117.A\3448\322\357\324\221P\365\264\216\026(\342\211g\231\217a\237N\177]\376\3115\033y\312\307>\314\300\017\345\026\247\347Q\355gX_c\232\210\023\305\266\271\232b+\024h\2331\320Ip\376\336:\345Z\3535}\025a\201R\205&:P\321\316\303\224h\311\034:\217a\350\215\224;G\355\227V\372\345\244Jg8\202o\"\317\352\352\236\035kuO'\241\254\362\256(V\012\232\271/\236\233$\35467U`li\240'+Qq\313\012IF\241\272\347\021o\026C5r\007\323\020\357\350)\274\0257J\027\211\312Y[\355\"\012\036Sl+\264;V\2468\277S\371\253\027\240!\226V}H\326\374k\204\012\2304h\205\334k7-^>]w\371\015\323X++\327\231\221\237@4\267\244\025o\000\240\241\335\336\177H\356p\271;\377\270\357p\024\363\224/\221\015\232z,@\000jy\317\327\210\026\357\317\215/\3236\245\360\212\260CE\3744\331a\342|\337\336\025\313\364\031\245\275)\327\273!\353&\263\341x\262\030\355\242$Z\205\307\335+\325w\365Q\201\320I\365\373l!\317\216\202\223]s\017\012\336\316\320\200\004\034\210T\310j)\244\264\011\354;\232\373\266\372z\000\234+OH\306a~]\363\012'\371\364<g\205\023B?\016\333\344\002,\367\255\225\"\324\035w3J\371\272\333l\207Q\375\363\003\022\357P\342ig\375\260\341\236\213\264H\013Y/p\245\211\340t\345\341\256\375\212\351\016\237[\001.\333W\203\3003/\323v[^\312_\276\341\2415\206z\002L\352\015\302e\267\362\367\3228\377\224\355\336\326\325\320\315`\344\220\015E\005 \245\336\035'\252X\263 \200\002\020a\312\215\224\217*KkW\"\230\204\313\254!\373\215\230\247\303\234g\335Pog_\300\212\222\010\322\340\331fRZ\272\027\316\010\340t\315\344`q.]|j\2347\223I\377_D\374\20023\35507\222\230\002\226=\361\360\005\267\004,X\276\002p\257\014\340_\304\271\223`03,AW+\275\005\210g\361\362\335\015\271\320\346z\352y\272\274\336&\000\331\356B\362\036\253\241\243M\224\373\023\222\332\313G\005\022\355q\234\273\024\355\022C\025\346y@#G\240l\003N\271\362\307'\252X\263 \200\002\020a\312\215\224\217*Kk\302\\\320\326E\225\347\204\375\353\275\334\2137\244\242v\036'\254\244\363\365\030\354K\023\260`\247p\317b\235I\313h\037\302\361\226\206\376\340\004\005\222 Be\027\3666\005&\015\207\350\271\203\354^\260\220~\226\336\206\334\206k-J\226\365O\337\342n6\333\346\177\352\\/\322\020l\245\334\351\345\373$\007\030\223\250{ \327\027P0\273\220$\361e\213\"K\303\220\270\221\334(\226\372Dm\221\323p\224a\372\035\247\200pj\300\276\240'\307#\222!\327\024G\341E\013\250b\025\247\014\343f\274\237\022\370l-\034]:\260\033l\361\362\246W\27288\0341>\037V\016\230\360{3\352\2436]Z\300\373\332\032J\352\303\301]\005\025`\245\246=\244\\\255\003\237\240\273\2021,1\212\000=\321\253\177\015\021U\272r5\023.\234\2655{Kw\305i\265v\225!\224c\214\341\3624\031\376-W\354\251\324k\303t\027\235l\346\032\356\212\352\200G+\236\220\000MyG`\317\245=\376\033\026b\352\0205\260\330&W\0117.A\3448\322\357\324\221P\365\264\216\026(\342\211g\231\217a\237N\177]\376\3115\033y\301\221\025\0144\005E73 f\322\215\003#\2757A\377\233>\200\364\212\324\330.\374iI\263\252!\033-\374\321\346\273S]\212\344\303}w\324\250\016(\012\2670a6\257\234(o\027\234\264k+1\274&\347\374\270\"\372UeXc\377\242\200\\\230\304\300H\205\023\204\232\036\032\2152\235\225\023g\336\306\330\372oB\231\307\261\200x*L\2628\362\311\324\034\226\037\276\326\255 U\247\371K\370\314v8\021\372Kw|\344\246M\221\341!:\020\222\355\363I\215vW\032.\215\373\3474\016\276~\362\326Ro\225`\307\007m\204PY\0355\3154\203\203\216=\362\367\031\314\333J\353vR\355\343\310\036\261F\341\317R\177\017\246\344\214y\375\363\341\222ja\031\265W\320\226\246\304\251\006g\202q>X9\233\310b\310\223\371N\001\356\011\263=F\322tRA?\000\0061ns\304\377r=\202\214\227/5+K\247<\010\246H\0204\3060\026\360\334\310{\220\020\361\322A\353\221D1-2\243o\216\366\217\357i\364\350\377\307Y)|\241\371\376Q\2208z\251\361\362\2409u)\3000\011-\222\363\356\367>Q\002\370\353K\323\004\011S\266 \002\335\236\2347\001gVR\205\375\330\345\377\027\357\260\201\344R\024\352\367\014\356!u\256E\007L\234\214!B\031c\313D\245h\317\204\242\273VE\014\344u&^\027\274\200K\365\273\351y\324\215\311\305^)J\345\310\025\036\322\266\221-\177\205,\320u\0314\362I\253?q\320\223\370\237\035\351\010\001B\004\233\032\2235\364d\\#\261n\356\232\0109\\\365B\2019\371\374\201bY\244~\337\311\351\267\230\2369\255\021\004(!x\200\204\252\012b\034\351\256\204\3708\232\023D\331\031\314\357C\341Dv<\266\212!\375\241v\227L^]\231\372\257\026Z\236\200\303\212?\265\210.\317\231N\026\266\361\313\210\317$\320L\323\302qF/\025\337p>\230\034\006A\304\011\261w1\020\341\332\230\002\234\360\006\300\007\023\370Y\365{6v\203\2373r\273@\345\365\006\271\372I\0025\332g\241\315Hu\360C+\301\331g\363 .L\264\214\233\356\351o\032\177\375\310\330;\344\250\336\306\243\034\253\341\357\011\0259\245\360}\311\371\355Y\264\301\204\244\2207\352\243\213\357Bn6\244\243\321\205\260\364\371\240T\302\222D\351i\250KJT\377Ea\377\252XH\357\367:\316U\262\254\340\012YH\350\303\313.\000-{\331+{\321\217\325m\265s\227\033\247\252k\346\347l\014)\200el\233,UNm\364\207+\363\376\231\025\260j\350?Qa\306\203vD\020\214\201\037\003\241\325\224#\313\036o\360\312?p\244*#\224\304\364Y\312\344\200\226\016\251w\233\317*\374\254V9\303v#\023\307\360\036\3075\313#\253\0145\203eFWJ$EM\237f\031\373\024\357\313<\340v|=\242\341\225$\3573\267\377\224\357a\235\235\347'\244\237c\277ojd\300\220W:\005\334\302\271\356._\272(\261\312Z\340I\355?h\204\310\004\253Hj5\033\344h\026Z\0122\"$M\305\217\212\340\376\265\204\001\023`\252\003\317\240\331\363^\205)\301\023\325\015\271p%\010&\377\204}rq]6\230\316d\012\203\010\205\252.\232D\336\307\2543\006L\322\226c\256\346\344\024\346\026\203b\027?*F\363kJ8e\307[\226\"\312\321N\3601\330\355 T\320A\362\037\015\251>\321p\300\005M\006\343\270\034\265<\202\016\344\347\3251\316L\304\000\254^\361&\307\253\3324\037\313\2146\317\231N\026\266\361\313\210\317$\320L\323\302qF/\025\337p>\230\034\006A\304\011\261w1\020\341u\315\020\377\030\010i''x<\376\254q\214\200\024FU.\210\370'\204\336^{\365\246\334\272\364\314\307\006\333\334\221\333\325\233\3225]\256\316\273\301\247\3766\017s5\373C{\326\026C\305j\242\367\365SnR\231\275\254u\206\301\357\300M\253\020)X\236\354wu0\0059t\225\000J\275\202\031\316H\313g\321\337P~8X\272(T\022\356\217\356\013\321\\.`\240\316\366\342\370\324\315\326V\324\200[fK?\311\002\221L\240(\215\352\315\340O-/*\003\013\213\\\277%,\300+\301\303\364\242aW\270z\360\005\352!\261\230\231Gc)\351-Z\254\260_\336\325t!\300\033!\012PH\235\313\362`'\211\201d\310\313\305\330?8\002\376\253c,\276\"\020\001\"-V\334\015\274\237m\026\264Y\215@\230\206o2\305\014\325\"\214\033\350T=\2677]e\353'8qHq\012$)'d\317\302\260i\243\240\313\372\331F\370\002\250\331+\365\242\222\331\351\220L\242\002\002+\330\235\273X\005\003,\006\216\337\011n\032c\263\212\201\033\011v\210\352\242\265=\242\224\327\315\233\007xC\217\213T\362tp\015\317ENcOY\000\226X(\024@<R\207#\330By8\303\361@k.Zd\275\275K\3772\276\311\243B8\330\263\360e^\026\2079\012\325\240\325?\272\243\300\225d\242x\226dKD\004\315\371\010\301\177\023b\256\302\344\017\365M\225\352\033c\037\316\246\365;\242\370D?\312@\343\177\360U\350\222%\017[O\250&\300\301\217\227q\347\212\350\233U\210C\240\361\305h\304u\331\311,^\230zV\264\262\022|\251\377\266\337\300h\2177\361ri\221\004\3674(+\234\250\001E\006\242\217\027R\272\0154|\234\000\213\234cg1\011\353d\245\015\275[!Z\376\016|-O\271\015\223\333\":5\262\331\305~\337\202\244\340\310\245_\2554\026\205\310\375\317\360B\240\303([\341[-\024\213\015\212\244\343+{7@\333U\310\004HP\251t\342,\177I\334KJdO\"r\036\320\224\316D\343\202\236\370\177\031\307\266\252l\257\354\335\2740\373l\030&d\214\276\272x\314T\255\266\2177\304U(W{*\321\341P\230\305ih\"tP5y\015\231\311\3510Q\376\234\245)G\225\007\227O[p\331@\265>ln\244Ga\250$L\254X\250M\301\327aa\251s\211\005'\337Z\303\311\3038c\306\015\233\332w$\022\217\340\365e\235\276\343\240\177q\337}\222\266Q)7\350\236\004\323\363\360\323\007\002XP\210\364\017.LS]\334uL\333]\247L\030\214\020#h\345\231\354\213s\273\316,\375\245\360t\206\254\020\350\360bd\300u:qJ\257\270\346\203y\004\363-\353\204;\340(\201\344\2000\031bF\347\261\237G\203s\034\006\204\220\036\2748\224b\343F\214S\216y\320!\202\203\241*\334\311c\304\221\264\214h\030\016\362\302\252\315\367:\252\233p\262\007\321x\233#\306\374\314;oGO\337\177W\316\237\232\2565\243\027\276\003\026\211@bD\005b\256\300VOx6\003\245\2757\325\256\323\016C\363\220\263j!\261\016\257\200\364\026tT\350<\220\224i\356\256\236\302\315\332*\022\232\377\355\377\243\016\204\237\024\202\205\355\335\215b\346KBu\320>\253b$H\036\200\354\012\315*\001s\031\035)G\375\240 4\205\224J3\013\246\304=nop\274\030n\033\245n\313\340\315\273V(B\210s\272\357\247\232\273\340\017\307\036\204C7v\276\3514\340\272J\3660;\345\332\254\220F\233\204\000\331\331Y\365\030\255\271!f\363\011\270\243\204\354\334\271\307\250\261\320!\235\342\267\025XV\325&\334\324\233.#\206\025\037;W/)\023^\003#\242\3627\244\235\2110@8\036G\233\245\374G\204\010_\355\352I\2102Y#\304\237Y\230\272l\310\326\001\236\004W\263E0\217\311\323y\014+\240\231\315'O\374\347\371'u|\001\316\000\006Lw\271\267_\351\016\266\203=\016\354\363\201)\246\376d%\006k\010\211\362\037\027\030\375\2271\034\303\225<\277\254\222\224\374\225\331\310]\014\000t]\347\273\353u\225\366)>Q\253\327?Z6\207\274\260\355\204\260XWGj85`G\376\263\257qI\367\027\344\205\0302\313IM\223\0257H\227\364^ww\271\267_\351\016\266\203=\016\354\363\201)\246\376d%\006k\010\211\362\037\027\030\375\2271\034\303\225<\277\254\222\224\374\225\331\310]\014\000t]\347\273w\271\267_\351\016\266\203=\016\354\363\201)\246\376d%\006k\010\211\362\037\027\030\375\2271\034\303\225\023\320|\233L`\275\032\336\237W\303\262\036k\015\363\236Hjs]\245\324\013\021\200xb\307\265\317\350\360\365B>\272\332\264\005%\216\200\242\007\023\2472\307\011_\344x+\262U\201\250$\004n\2501OO\020dx\362\3362\037kxx\011^\3436HAJ\247\030\374db\334\346\376*\212\370\302E\345\015\010,\352s\317\"T\003\214\204\001\325\205\3624(>\036\205$x\330\332C\214\"\376X\027\367\343k\365\024\223\031\374D|\366\345y\016\316\034l\376G\233\300\346\315G\227>:?\273\2356\016\215\233\314a\214\313\272\205\225\005\320\262\235U*\350ji\315^\270:k\312:\307NR\232\374\247$g\374\302S\030c\264\330\251\304\207c\232\220\352fX\201\243\254\005q\252y\251\177\002y\350\037\2173\242\343\226\354\030\367E\351;\305^\025\371\331)a\204lE!Q!\000/\266\006k\257\202\323\221\203\331\252o\001dX$\307R\323\200\002j\222\016\017e\177\235+\241\032\274\376\262\207Y\337\301~\242:\271\322\333^\205\3654r\201:\317Cf0\253/\316\232\221\342\333\236\230\336\216\263k\234V[IpNSp\226\311\300\202N\265\216\324v\025XS\250)\306\300\371e\341\0272\013~\277cS\0138T\020\030\325P%Z\340\363\022\035\3753C>\024\246$E\263\331r\0168\2076\203x\277\357\256\336\260\021)\223\3062_ \203\200\304\221I\327d\2440\261\016\264D\210\201/0\257\205\276\"\276v\352A\327Y\021\033H,\204\247\216\\\231&m\334}JT\323\336\236\2345\320=\346\265N\223\3106\344:\033]\300\203\345\341.\001X\3025n\314e\000\231xb\251\260s\220\365Q\305\304\363\205r@\006\327\354_*\341\202\001\242\"\343\206\214,[^6o\354\264\375w1x\345\\\337>\356\010\303J\014\242\210\245\3165:z\033\351?\376=\324\216\334\233\374\270-XvT\225\030\010:\370\222\342\325\310\354i\037\375\332N\011N-\037N\362\321\370\225\030\200\203\012}\255\370\232G#\262o\364\210\273\036%\243\317)\344\214\2101im\031s\021\352\210\035\264lf\335\266\002\334\026\236Z\305[\272\343\311\363\204\231\233d\324\016%\364\311\000\215\013\320\277\311\032K\334\177{G\250@\025?~&Tz\2436\322\307\265\302P\344\263\300\327\227\335\333\361\346\245\224\312\342\310\224\216\210Sr\376\351\272\235\265}\346\313\345\277\331\002 #\336\332\354\"\301\354X/\316\026\361\352PT\367\\\305\304\241\351\305\320\305\037UN\326>\326\2132 \275\254RscGaIO\372\271#\357I\266E\022\2252\331\306-\271\225\250\255\221\215\266a\032\220\0241V[#\207\230\325\360\301\350~\\\275^\251\273\315&\370\357\222\023=\233,\302\213\233\355D\330\273R\356.\363\371$\375\240\230d]h\340_\374io\353e#\275\267\243\340&\024t\004\233\210Y\352\263!\322K>)\005\247@K4\243\204\345\014\255\2165\203\2240'\322\274!\316\220\331\345\220\374io\353e#\275\267\243\340&\024t\004\233\210\315\232\270\257B\336\266\250\235\264|m>\262\2758\024suZ\262\241e\344~\377+\3378\356a\243\235\022:\253a\275l\310\333\005\374JFp9\270\304\007\000\362\015\021\314B\005\245V\221/\233\272\255\227\331~\\\011I\331\207\251@\334\225+~\255\177N\351\011\027\200\354\002[\206\357y\253\015\317\217S0c\316\240N\310n~7I\215\300d`\2140.\026^\012\331\275?b3\250of\0332\272\231\270j\232\331\317\016L\215#\255\254\264\353\224k\245\226[R8\177\2229\031\352\236\332\004\367\267\360.\222\306s\200\257<\023,\317%p2\374O\031\240r\322\275\3137,]\266\311+\3674-\013\202\245\024\313\247y\312w>\343\\\370\306\336\232\244\242\014\367\003\314\202\204\003\224\024\3551;\022W\273\370\313U\2616\014$\207\230a0\322w-m\011\353\230\312x\037z\264\276,i\015\323\347W\264\242\030m\202rb\011M\247\356&9\026\316\032,fn{\021k/\370\302\321G\203r\222:\262\272\005z\012i\243\240\313\372\331F\370\002\250\331+\365\242\222\331\242\373+T\350\261u0\374?J\340\255\002\035\354l\241*~\031\305\270\333Gpqc\223\021\367\205\340\354\235\211e\027\006\267\342\221[\224\021;\377\016NJ\343\026R\007\2120\0343\371\243\003\227\240f\256\016B\307\343\265q\035+\255\276!\011\234%\015\234,\324f\236\316\330od\023\013\376;/8\3231X\273N$\267S?\203C\264R\2629D\037Lb\3304\030}\032Q2}\330\015\367Fb2$\004*I\201\007\211>\270\372Z\377$\222\372>c\313\305\214u\206%\226K\271\206D\015L \243\326\217Mx\224FB\302\326\035\316\275o\242\251\320\333|3\302\250\236\376(\347`\230\\w\264 \247\224\014\000>\357i\377I\223D$N\024(\034\007G\014L\213\300\3345\0259\322qG\253\373#!\337\277\232'\242\012\201Q\031c\3717\244\016\210B\232oi\023{\350\2367\3355\002\204Z\305D`\301V\347L\256\353\001\304\2511\213\314-\303\363\343\360\027\222\334n\305A\007\331\026 \026\230\023\327+0)\005F\321\343\303D\262NO\204\226\374&\306\214\200\205\2108`(\340\361\254\274\340\317\312\323\375P\374@\276ro\261\236;\332\250\374J%J[9(\261&\271\301\014W\324\321\244\342\212\030\310z\272L\317;MZ8\3454\335\350n\203\265:lm\211\274\014\027j\364i,rgD\177t\250z'[\271\273\356\331\253\012{\356\375\005\32624\007\177j<I\254v\252\234\326\304{\303=wcV\242M\331\367\224n9\020\301\327\237\374\337\344\025\206U'^/\373h%\270\347;<RB\344\032A\306/cE\240-\224\344\005S\233\302;\335\002\014K?\340\253ZQ\006\200\011\3247Ony\214\273\000\271Du\241\022Q\027\316!O\376\263\017t8)\253\256\017\374\276\026$\221X}\252z\2335\321\354\212Y\216\225\027\0308\211\035\227M\035\226 HR\362\327(\335\230j'\234=\240\347\277[\211\276+yrJ\372\212\374\301\314\356.\360\013Y\333jY\216\277\362\230\311\030x\216#\025\021&p\356\315^^\253\324\343\227\035J\230\3549\326sE>\222\007\230\003\024\005{]\212;\306f!\247\252\3134\262~\223E\353p\352\233\247f\224\332\340\375v,\261\366\371\204v\237#\244Z\022\005\214#\200`\344\350Q\315\374\274V\352av\314\357\271P\362.\340\027P\306\001\270\345\242t1\012\325|\326\3320]\302-\363\325\351\020\261x\357'Cl\364\363\260\331\202\377q%\2218\303F\003\265A\301\030\340\027\261\321\272\262\327\036\342\317\023\273\300\026f$\366o^P\012\273U\021\014\303\314/7\252\031\212\001\033%\010\2203\015$\214\237~9\343\027\"-I\330\365\364\232\225\347\353\213\363\335\224\246\302n\007\203\237\373\221U\233\235\342t\347\275\345\330\251\030\334\312\337-\026\224\371\255g\340=%\244\330\356\225\025\377\304\310r\355F\202s\337&\370\240\037y\035\370\262\307\201\315U\327(\371\027\265\307\036\014\262\204a\2424\032\312\200\015\312v\221\314\374\177\007A\355B\214\365\270\012u\013u\035\2109\036\325\207]_b\250\003\237]\003\031\334c\273\036sQ\341\267\025\307\201\367\241\227mC\3676YER\\\272\020EI\370\241\365\014\031Zi\236\241\000\004\273\210`\004y\203r3\204\306\207!\236<mADFA\012CC\307P\234\332\310\026HN1\201\351c\021&\332^-M\2648\233'\325\360O\035\223+\021\377\274\372\362\212\245U\3224\200\373\362;\225#\200\307\326\353v \274\231\206\207\304\356\200\\Z\006\022\177\247\353\325[\353\252\300\363D\254;\312\374\352\000l\350\215V\320M\313\246\015\201\201\2106\306\224\274:\230\330\347a'\355\3067G\001yC\305xYh\030@\364*a\350w\270\346g\277\227\372-n\013ge\253\353\231\355\350\233R\351l-=\270\365\3301\312\214\203\210\035\004\377\262\244\016w\024\340\271\326\235;\016\364\006]\033\327\370\214\302j\177\313\227-\005\321\014\373\012\177\274\376\037\364\272X\340&\341\322\326\303 \267\366Z\237\242'\204\366\315\021\257\251\017\031\001@\271-\215\344\313*_\224\020\375 \263\3230\211Q\374j\217\022~\362?a\231\201\240\310\015\220\364z-I\225\372\2310\0205>\032\211b\237\261\016\257&\216\320\270\333BG\371\227\322\3603{k\"/\237/!\317\251\270\300\361\272\331|\234\314\270\015\235\252_J\253n\237O_r\375\033\300*r{\360\356\232\331_\227\227\214-\245\005 K\364\341\371%\233i\015\333rF\327P8\036uj \3746\253\303f\345\204\370\257-}\000g\246\301\336\346\226\223\216iu,\023a\036\346<\370\224\301\213H\336\025\226\312yY\350\035HV*8\247\276\372\300}\3166R{mZ\323\313J\023:S\341\326\2266\325\302\303\303A\263\372\014%\311\210\304d\011\266\362-\023\027Q\275Z.[P\220\000\306\"\3305Z\303\303\303A\263\372\014%\311\210\304d\011");
		buffer.rewind();
		return buffer;
	}
	private static final Map<String, Range> assets = initAssets();
	private static Map<String, Range> initAssets() {
		Map<String, Range> assets = new HashMap<String, Range>();
		assets.put("de.appwerft.signinwith.js", new Range(0, 7552));
		return Collections.unmodifiableMap(assets);
	}


  public String readAsset(String path)
  {
    TiApplication application = TiApplication.getInstance();
    boolean isProduction = false;
    if (application != null) {
      isProduction = TiApplication.DEPLOY_TYPE_PRODUCTION.equals(application.getAppInfo().getDeployType());
    }

    if (isProduction && Debug.isDebuggerConnected()) {
      Log.e("AssetCryptImpl", "Illegal State. Exit.");
      System.exit(1);
    }

    Range range = assets.get(path);
    if (range == null) {
      return null;
    }
    return new String(filterDataInRange(assetsBytes, range.offset, range.length)); // charset encoding?
  }

  private static byte[] filterDataInRange(byte[] data, int offset, int length)
  {
    try {
      Class clazz = Class.forName("org.appcelerator.titanium.TiVerify");
      Method method = clazz.getMethod("filterDataInRange", new Class[] {data.getClass(), int.class, int.class});
      return (byte[])method.invoke(clazz, new Object[] { data, offset, length });
    } catch (Exception e) {
      Log.e("AssetCryptImpl", "Unable to load asset data.", e);
    }
    return new byte[0];
  }
}
