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
		CharBuffer buffer = CharBuffer.allocate(7547);
		buffer.append("VZ\2607\337A\033\310\231\233\326\344\026\345\031\005\207\177c\317\204\211\303Z\024}X\221\302o)\361S`\217\324\215^3\315aF\274`\327at\207_R\331o\221\370\0332_\037\207\012\037<\021a\333\215\270\200\021\321Y\321\227\334\232\352\346\350\214\210\231\343\311\034:\035\033\017\\\315\364\316\276\321\260E~\310L\251\321\256l\015\030vu\306\270\360\350\275v\021$\362E\255S\300o\202\234\273\3742\236\2743XM\347\275{\026\300\373\2532\3126\204\002\312\331\335X\357\261F\326&\221\2413\2040\330v\334\253\247\026\2703@\255D\217\327U\246\213crD\326\374k\204\012\2304h\205\334k7-^>]\370zw\361\274\344|\236\227\340\013\243\252\026\\-\356O\002|\006\2749O.kK3\254\013!\253(\224-$\324\177U\377\200\373\340\246]\325\351\347\343\226\340\350\035\257\246\213\211\277\215M\345]_\375v9\201\271\007\036\326qc\0007\026\340G\2716\300HHU::\276O\227\221Dg:\204\313\265\372\351\356\355,\256\363\205\015\372\370\255\255\006\245\234\036\367\261g\242`\020o\273/#\363\246\021\360_A\013@.\302M\263G\346\204;~\016-b\206f\335\337\026\016;-|\253\001B\341Q|gtE\261\344J\270\354\312\373\337\3126\024\322&$\006p\245JA,u\227\251\306+}5\212\2606\255\227\244\204\247:E\006\340\264\255\307;\254\275\271\237\350\241\274\234G G\006\211*\034t\3630+\355\310U\016\233K\363_\206\233\264\304^h\317\304\267\376\364U\207\\\342PD\365\330\225\244\020{\327\340\343Md\363;K\223\244\363p\325\215\362\276\301\030\214\261\003\337\230\347\267\311\354\3410\313\234f\317\2722\030\230\201\225\345\300s\301\036y\023C\205\316\2352\265\014LW\344\256\253\016\322\226g\320\374\240\363 r2_\345v\362\212qF)D\221\004U\270\304\2506\231\004\250\231g\002?/5\327b.6\256\324<\313\244\236\006Vs\245\355\212\305\033\314r\360Dr\213\037\231GH*\275\307)\372oB\014\306\3403\214\275\207W\326\200\344E>\313\015\227\244\305M\264\205}8\370|\217^\356\3244\026\325\375#\256\332\343\213\255\2107\3659\215\023\222\317\024\232\361\242YY\310)\323\012\325\224\026\331(\207J\337~\002\331\241\005\242U\031\273rC\255\024\353S\362\211\217\366.\025\226Q\243\341K^\214\212\035z\333\321\005\366\204~\247.\236v\230\221h[\252\231\025\3007\332\235\334\376e\210\016i\262\252\336\353I@\301v\364\310\324\034\314\020\213\317{T\355\207od\303\010\202\201\001\2075\207'\231\013U\203\313\030\243v\201\033\353\2312\315\235\001\337=xj\311U\307\221\334%\351\365\206\200\234\006\361\343\337\314h$\372:\202m\006\336\037\205\374\223\307N\305\300ahW\214\317\200G\0011\026\037<\200\264-i\305:\312C\324\230\0150\247\240}w\3266\322\033\300\362*}?\347>[\004fC\225\024\275\342\037$X\007\220\275e\332Y\255\354\036,\3148\374\231[#\373\343\027\311\002:\342e\373\230\310<\362H$M\267~\337}\237RY\273OA\270\232m\217\304\356b\224O=\007\335Gt\353\211\011C\033\260\177\344%\315\243\220\276I$\025\341\216\316\227N\015\313\240\210F\256k\314\024\265\330L\246\235B\244V_?4\236\243\310\375\300\360.\212\346FBmk\014#7\301\263\035\224W\023\200\200\177\027\261.!R\020\024\276\033*\321Y\2022F\360\366J~\247\\\207\353\357\243\346\017QEj!\264\014\273N\322\240\301\355e\260\263\353\307\264\264\200\356\037\307-&\335sU\350%bh\356;\277\317+\356\250\325\006\262\306\250]\324\225\032\300n\002U\222\312\346}{\361W[\236\311\027X\342\023tZ\217\033mS\301\227`\365\250\223\012\237\3027\225a\364U\305\276\224\037\252\220\362D\331\337\317\235\210\201\335\323\366\373i\263\035\207\212\361\037]\033!*j\2549\354\005\030o\310>P^G\371\351\026\311\270\362\323\216\352\014\025\270;\362=\310\310\032\270\263\3206\220\314G\245\315\010ZF\3053DGUE5\261\013\312W\226\300\332\323jJ\377\007\367\320S\037/\365\376\357\224~C\276\372fr\247%|\224\264,\251\262\334\315\315\0378]/1\373\243~(s\212\212\255Q\337,\000\216v\260.J\344\004G\255\337\016bT\311\340\221(\220\256\024g\324\343oa\262\353lJ\367\247\233\332\333\276\021I\226\234l\340A\010\226\346}\304(\232\307#\242\200??\303\000\221\0216\234&Nc\275RUQ\345\311\355\001\2231\255!V\343=8R\346\301U\204|1\222\234\337A^}|\032\365\3555l\265\360T=\336\376\357r%=\212\035\3037\027\265\207\032\355\022\377\"\360\227\310\373\351\207\243'\202\353\271\003Z\226\231S+\376q\006\374,\003=\370\003\015\014\335B\022\212-\267|\341\\\012\337\335/\355\357+=\262\323p\265\027\226g\372xmjm#\266\250\211\317xF\0028\333\327\247\210\347\217,\254\346c{\271W\037\221\227\265l\305\351\372X\215]\336\366\235\230\372Z\023@\274\341>\202\236\375eZm\302@\361\336\210C\215\275\210\274W\000._D\374\20023\35507\222\230\002\226=\361\360\005\267\004,X\276\002p\257\014\340_\304\271\223`03,AW+\275\005\210g\361\362\335\015\271\320\346z\352y\272\274\336&\000\331\356B\362\036\253\241\243M\224\373\023\222\332\313G\005\022\355q\234\273\024\355\022C\025\346y@#G\240l\003N\271\362\307'\252X\263 \200\002\020a\312\215\224\217*Kk\302\\\320\326E\225\347\204\375\353\275\334\2137\244\242v\036'\254\244\363\365\030\354K\023\260`\247p\317b\235I\313h\037\302\361\226\206\376\340\004\005\222 Be\027\3666\005&\015\207\350\271\203\354^\260\220~\226\336\206\334\206k-J\226\365O\337\342n6\023\226\266T\220\331\023\371\213$\324\237:\0256\321a\342|\337\336\025\313\364\031\245\275)\327\273!\353&\263\341x\262\030\355\242$Z\205\307\335+\325w\365Q\201\320I\365\373l!\317\216\202\223]s\017\012\336\316\320\200\004\034\210T\310j)\244\264\011\354\225\234\013\336vG\217)\216\303[-\227>6\336~\201W\304P\256\031\205\201\322\207\200\035\353\225\361\000\223\354Er\350\304\267\340\212\023?*\365\361r\213\360\341}\345\360>\270Z\006ka\177\353\360\232\311\014\206x6\360\015\344*4\262\211X\213?\355\013^Hr\230\003\014\306s\0313\334\372D\315\325f;\313\233\007\373\003\265%\352\360q\221#\374\253R\204\035\223?\023\275H\267\034QjB\202\265cW\0117.A\3448\322\357\324\221P\365\264\216\026(\342\211g\231\217a\237N\177]\376\3115\033y\312\307>\314\300\017\345\026\247\347Q\355gX_c\232\210\023\305\266\271\232b+\024h\2331\320Ip\376\336:\345Z\3535}\025a\201R\205&:P\321\316\303\224h\311\034:\217a\350\215\224;G\355\311\212\227\313\350B\212r\252v\207<\335\023\024\2203#\250\213o\327l\020\373c\333\374'\242\017\270\270\204y\204+\340\345\317_\306\262Ub\213\375E\2173\207\263\232\006\215&\334\320T'\275d\265PE\016\210Ue\336\337\227\3369YyMl\301\334\272\214\230T\001\323R\253<w\301\"\244\302;8\220\207\253\276\370\363V'\240\012a\215\033\233/\366\355=*y\200\353OKu\222\2635-\360\205*z\211YIbD\373e.\225\200x\311G\362\352k\312H\312{\227\263\032\001\201\003\213\373\216\305\2153;\237\307\362%\254\332_ru\332\242!\345L\212j\332\221$6\354O\310\013\311\231Q\36139\220\266\203\275\365\204\236h@\210;daD\365%Q\273M^h\307\2067jAQ\340\240*\034\266\023\235\344\346\222:\0310y\331\354e\020\264\353f\345Ggyxz\311\023-\037[AN\324x\242\177#Nl\323 \300'\377\376V\306*\024h\2115l\265\360T=\336\376\357r%=\212\035\3037\027\265\207\032\355\022\377\"\360\227\310\373\351\207\243'\202\353\271\003Z\226\231S+\376q\006\374,\003=\370\003\015\014\335B\022\212-\267|\341\\\012\337\335/\355\357+=\262\323p\265\027\226g\372xmjm#\266\250\211\317xF\0028\333\327\247\210\347\217\261 Ri\205q\030\227\363sC\305VD\242 \030C \303,\264\264\367@\236\031\007\330\374\303\366\227\251T\353\303[\367\317\003qpAI\340p^\200\300I\206\204\031\256B\255#\341\326<\320\035\311\002\350\337*\270\027\366 \221\241\354W\247^b\355\370\325\276\222\251\243\326\311l\334Gjqy\372\222\006T\342P\345\256\222\005l|\301\266\325\265\205OLb\363\255\307Z\217\320K\313/\026V\307\324\301\364\204\214-\235\"\007\222c]\005\003\216p\"\015)W\273\323J\377]?je\212\013\335\033\312o8?L\211kt\027t&S\252\343\306\302{\342\247\223\243\330\260\005\377,-\276;\3001\013q\270\034\264pi\202U\336s\372\276\251\2528\207*t\304&\242\275\227)\003\357\017\257\344\234Fg\010\2115\304\327^\373\247\320\317\216\357\227F'4\032\354YI\013)2\205z\321T\333\"fC\241\301\313\232\025\020\257\223KK3W)S\277Kl\376\200\277H\274\234\005t\321\015\030,\200\252\246c\\\005\016S\311\311\260J\347\242\016)\311\376\272\264\314\000\233\274\305\177s\203yW\331a\003\360hW^)\022\260\205~\347M\204\356\256\223\3018/\374jK\036\322\266\221-\177\205,\320u\0314\362I\253?\020\177)\332\252\225\366\305jqxD>\243\005\3349\206BE,\254Q\357C.s1\022\013\340\231\002\330\365\342\222\010~)f\341G@\320\2009s\360\212\342\251{\331\212\370?M\036\367\322\302\223\242\036/=\267mv4\253\250\344Q\332\034\312\231\002\262\343\330\265\202Q\331\025/\004\307\343\262\270\306%\177\261\203s\002\013\357\344{\321{\375\201*S\026Bu^\035\230\267\225\376\250J0\345\303\037\203dm\0266z\237\272R\373Y\005\224\036\263\306\206\374e\204\216\243\234\211\376\200\252]G\271q\242p\014`\003\264\223\000\273\270\263j\204\033\220\227Q\004\254\200v\3235\014\316\317q\266\036\250j\342ck\375\235\004W=hE\011\336{\035`\316\333\313U\321\261#\371\353|\343\340\212\306\377\015a\"\326\241\031\306\345\205\355\216\264\367\246\020-c\271\205l\265\275\317\362\331\366\010'Mu\316\265\012{\005\377SbB=i}!l\035/\212/\260\213\224\303\005\373\366\325Sko[/9Y\021<h\341Qn\366\375\332N\011N-\037N\362\321\370\225\030\200\203\012}\255\370\232G#\262o\364\210\273\036%\243\317)\302:\356C\355\311\177}\253VN\025\256\340\361\177\341\357\011\0259\245\360}\311\371\355Y\264\301\204\244\2207\352\243\213\357Bn6\244\243\321\205\260\364\371\240T\302\222D\351i\250KJT\377Ea\377\252y{jb`2\231m\236'\025v\027\334\206\237\256\347\016Y3\000\311b\213\200=\344r\3775\324o\026\245C\3376\324\024nx;P\345&\327\355\010\344\365!4\302g\373\"\337j\264\321\005\270|\321m\244\233\237\003\355-\312\332\312m\350x\361'\264\005)\341\030\214\366\276#\015k\253\330\373u\350\006\000\340\227\033\212\025\224\337\254\202\015\227\002\001\253\237V\375p\330e\376\271s\311\220&\346\225\225I\204\016<\214\340tex\357\023)\002\244Hy\"W\177\200\003bS\334\222\203C*\001\270\312\250\277;\304h\374\224\203\037;Qo|jM\313\214\332\232\250\232\302aq\225_\022\214,c\271?\366\316'\360\220D\357\035Wc\374\017@\302m3!\245a\337c\310\303\256\026\276\306\315!#\251\213i=2\350\254\024\331\354&\373v\327\260D\310\006\024\273\316\375w\310\021\253\253\252\006\264\325\326\022\2439B\340;\313mb\346\337\021\231\320S\315w\241\300\303\271\327\374\216\337\034\205\243`\270@\205GO\345GB\321\304!\354\352\351\262\300\222$\224\275G\013\352+[Ii\306\265z\006g\271uk3\270\260p`\352\227g%3Q\241\2239OQa\351\326\235\325\300\343\3127\345}\215\224\026\213\006\374\0145\341\302=L\016\015\302?\325S\266\002A\240\374_\273\254\225\242\367\304\033#\254U\236gn\361\312\200\355\225o\231\211\316l~\376\222M\376\375\335j\244\013\267W\234\033\303+\371\377\305\330\316n\2320\342\331v\013oU\264\007\015\223\376i[\343\215\207\263\341\302S\010\357Q\304\215yC\2069U\350C$SV\241\006\353H\241\216\274H\330q)\015\027O\211\216\230\213}\235\237p&X\337\022\276\301DN\316\335}\325\364\355\305\2325Q\234\322\010\360\233\311\033vY\006a\352\312{\373\247\022\203&\274\306\216C\373M\017\021b\035l_\314a\035\242}\351,\307\257;\022\020X-\003\370h\"\320\321dg\267\241\257\307g\004)o\010\024P/\266qF\354?\373\306\266\225\310\336Rb\270wX\3251<\352\002\012\271\373\251`\304\002\370\204\034;0iP\262uH!\010K\244A\317\323\200\215\004,@q,KX\377z\267\037\301\331\003\363\252\245\266.\001\321\012\235\252\354J\201rf\301a\244\021\013+\253\007\346\261)\260\202P\021\225\3176\371\316\270\203`Fj\003-\325\353\3518r\244\017k\256)\362V\237\206\023\347&\177eH\240\267\371K\310E%\220\020S\200\356\374n\334\032\315\260u4\006\377q\272\273\233\231P\225sj\014\301\000X\346-\325\034\213\242\361K\036\207N\311g \015$\010\251g\021]\326Zd\321[#\260\221\2153f\222b\001-\262\320r \305_\316:\367>\375\362}\235\360\355)\012\037\255\340\004\033{\300\251o\261%\214&1rmK\346]p\024\353\273\234K\254\2007B\022\244\371r@\271&\253\037l\270\316M\346\303\014\356\301\366\310\011h\271\322ey\274\307\234\231\262X\323\026\035\306a\265\300\224\220\206\2153$\313\303\224\322\204\357\203O\365!\003\260\017^\255\203\205\276\372\221L\022\367\342\345\241#K'i\364L\033\335\207\327\316\340\357!\377\330D\024\234'\344\270E\243\301\263\247\343$r\217\341\374\230\326\237\226\345\237*\3620\256\266\242\226g\276~k\005E\234\331\317\335cb\010\245\310s\344\304`\035\205\240\233\237\236}\331\244i\235\207\033pD\353\353i(\336\233q\321\311\326\3737\3407\271gU\315\254\003\326\016-C\311\360\026(\264\227\015\316\252$\031K\333\254\312\004*&\005\246\320\235\013\363!\014c)4\334\253SC\014\355\223\361;y`<\274\206o\200U$\306hH\323\251&\241\373~Q\343\365\363\355\334\272\374T\326\007<\003\3704\260\214\230%[\362P\267,\317\000\321\0375LE\261\344J\270\354\312\373\337\3126\024\322&$\006b\207\001pzl\213\007 \344\300\364\374\246q\315s\360p\\c]\035\031\014i\266\344s(\2150p\226\325V\335\3779\024y\2153\227v\262\306\276\251\202\367\376\035\021_\321F\177\343:U\331\200\237\227p\025\217\372\360k\177\235\005.\005o\226\302\366\272PE*\3549xev\304p\016\011lh\364\273\305\022d\252\223\234D\241\322B\007_`O\307\301\325C\006<\215\001\345\351\374\337D\224\021K\006\347+\020\342{\251-&7p\355\277\311\252\303/G`\237\227\021\214\034\376\321\323\324\320\372x\014\332\277\265\214\322\251\205\311^-L\342(\243\200Jl\320\225\005\301u>\370&w\202\270\315\001\242\211\232$\254S\012\011k\225\215\323\026\351?\334\212\211\205.\342\230\302\370$\366\352\207 \272\274\376\256B\015:\217\372b\007\232\344\267j{7\353\325\004mp\215\323\300\240n\317#\033b\225r\355\264l9\\`g\310\005>\011\324\337\214\371\322\304\207\357^rX\316\215l\304\273\011\006\2252\015\315J\250N\316b\363?\261\364\304\024\005\317c\303\326\342K\324\263\247\346=\373\022\352\361\005\003\240\243\011\267\344MK2\220+\007\202\344\3051\335\275I\277\221O\334t\2156\265\3718\261\326\227\377\351+\203\270\016\322\376\026\224\371\255g\340=%\244\330\356\225\025\377\304\310\312m\002\313\341\345v\356`Sor\211\013\234wR\011\302\331>\274NbA\007\024p\213n\273e.\015B\306\314\022\314g%-\374F\2766\226\226\264\242\265\0343l\324)\206F\022\000\2741\352\326\243\247%i\017\362\237\233\221GK\212\232\015\025<\355d\010\351\217pD=i\342\215\036[\317\374`\030\010+\377\013}\324\026N\341\267\341'\277\026S#\277\034\032:0\235\200,.\204\026\334\275\251\205\371X\310c\211\035\220\376\356\253\0025w\341\023\321V\344\367\363e\256>\015*\275m@p\275\367:\246\274\337fK\322P.\226[\232\242\251#y(\362\211\272\300\307\347-tR\314\273\332\3638\244\222\025\345px\204\250a\035\2379\267/ \324\310\306\036A*]\313\322\025\023*z\374,\211-\300l@\036c\3624\200\231\213\0268\365\205\221\363Z\"\346\\\276\334o\214hT1\232f'\010\346G\265V\325\034\240\024\027\255\211\030\272\302AR\233\320\343\351\317\003\200\227\001\247\302S2\223(\210\036\261\022Z\371\324\015\337\205\035\1776\266\006\273\314^!Z\331\223\342\315{\341v}\336\202\012\224\0263lY\376\250\242\031\016\264\270\312(\265\006\227\013y\004\221\211\362\313x\330a\313\245\277\023(W#\315\010\255\004v\227_\233\277\335o\036g5,\333\224=b\305\332\265\032\237q\011M?\236,\220\300\234\235[\003^v6\200\262\256\337&\201\253\\\331\201w\260&L\304z\032\037J2\234\330J\010<\2512M\037\373\246\257wR\305\263\177\373\315d.\357G\212\325\257.X\204\310b\275E\203N\276A\262\022Bw\271\267_\351\016\266\203=\016\354\363\201)\246\376d%\006k\010\211\362\037\027\030\375\2271\034\303\225<\277\254\222\224\374\225\331\310]\014\000t]\347\273w\271\267_\351\016\266\203=\016\354\363\201)\246\376\373\262R\225\377\203\265\371\334U\353_\265-\177S\353+\325\301S\227M\321\347\037\355*\267\004\364S\3608mZ\277]\344\004\363\025c\211\270\363\241?n\216\032\025\024T\246\200\326\025\277i\302g\350\225\300\013\374[\371\232 \312\360\303\264\305\034Er\014%W\233\247-\255kJ\252D!\237 F\371M\215n\036\240\251\304\024\354\024\332\035/\015\226\251Z\0231Sv\253\263F:\363\246\017\241\253\211\\K\354\035\024\342\202\334\015c\305 'X.\017JR\010\273\222\202\264\277\367I\025@\251\215\245(\362g\011\301=\"(3W\020(U\032\341`d\005\3575\342\243\311\006\336w\254\204\374\271I\307\004[\270\024\0313F\304\320\177\270#B\360\027\033a\252\330\301\316\207\333\314\303\221\237J\376G\003\\\2037f\035h(\270dy#{\307.\337\2737x\233Z\024B\262\020\035\313]\311\363\023Q\230(m\243S\305\314\351\267B\005\246\015;\011;2\251\234\375\333\331\311\343\204\267{\373\375*\335\330\372\247\012\367\363\363\\\374K1\271v\306H\3027\371hRL\3458\332\231)\241L\335\303\354z\003\276\374bN\316pu:c'k;\256\241\246eD\301\003\036\325\205w\351\360\015\250\326\235\247\222T\013\304\2202\207\015V\251\017PZm~{D +\365`\230\254\323\241W\371\00769)\021\003x\326\270\007\205\234\032\330\301[\330\365v`\337,\013uv\253\003\221l\003\247xz2\332U\323{\037\0215u\304/\264\261\022\214\"f\007\247+\023\373\262\007\212\250`\\\035\214\\p\3651\204dHhKb\233\026!\373\377\377w\025i\270\227$\024H3\377#\325.\345%\314\010;\375\002\003\353$\312\301I\316\177\324\323\235\220\215\230\226\306\251B\361\201\255\335\366v\307\232j\033\024\362\274\025\377y}\204\325>\364\301\307<I\006\377\312\357\325\234\0168\365a\011\220\322rm\0266z\237\272R\373Y\005\224\036\263\306\206\374\230X\0029~R\002\276\010\005\234\326\356w;\3701\277\374ZQ9a\026\0261\364f\352\304<w\351\271\015\255\323\027\272]\326\251H\376\263\300Z\256K\007s\343\021\340\006\265\037|<8a\202 \233&\367\"\207W\377\361\317H6\337\212&X\036\372\375\0131\313%=\305B\027\247\277\034\237\252+#\267\2501\246V\265\363XNa\031\313\202\000\177\024\365\371>\201s\325\036T\376\033\327\263\325U\200\226\340<\321\343\247\244t<\000A\243Q\341\242b\314\321\202 \350\330\337{\231\202V\241\036\035]\213\200vE*\343\242R2\205FD_\230\322\215\013\221\177\002\255&\332\305\013\311\013Y(5J\332\005\270\271lI\237\335B\015W\035\015 \0250\274\030_F\306\302\220X\000\330\362%\026q\346\317\344\321u\267\376\371\332\347\007\242x\301R(\243\254FP\203Mz@\272\336!\021\275\222_\261\263\372vU<\234\326\244\316\033\014\270\325)\217\273\222q\313Fi\267\376\371\332\347\007\242x\301R(\243\254FP\203d\364j\272\0113|nZ(\021\026P\243\230\262\020\343\025T}\201$\372W\245TF\224\307\\\255'A\360{\307\206\206\177xW\315\032\251\257\272V\000^g\012\311\210\322\203m\346\211\341\315Q\270\022\006\315r\223\\\237\3724\203\337\034\240\325\354XR\177\225\301Ul\032S\2065\314\2012M\251\201\326a\336*\037\311G\302\332o^\"\\\316o \304\305k\313a>R\343K\331i~\362\022`\002\353\353\202\352y\330\301\341\261\177\2059Hg\266\315\303\203\362\243\371q\216\322&\354\177\037\250_\235C^\314\342\010I3\336\3274\233\336E\340\350\305\"w^\307\013\204\316+\200\310\273\"k\372\275\237\023\027\026\251\247m\206\217\257\365\015\352T\356S-\314\036N\372\307|\302G\002\203[\241\021\226\313G\373\023;\234*\357)\3515!\272\"m9\312\362\026j\216\016\210\251\003\035\305\005\202\335?\346\361j\310\004?\313\210NB^\3662\027\222R\011J\232\344i\372\313#X\251\357\346#\227\250\321\005\326\037\241\255\324\266]9=\226S\225xF\362ws\255R\204\244_ppk''[\244\255\2335\227\256\226`Z\007|Jm\242\201m7\3475\270\213\217F{\237\007\2302\3306X{\3613\364j|\314\255\354\264\227\242\220I\026<r}M\301V\220\234\330\277\225\372\325\320A\332\373\037\014c\302\347\271E\202\247\262_\345\205\"\202\336\326\315\267)4\232\346\002\177\214\306;\367\203\307\232\300\353\275\236\230\277\215\264\246\007\217 \343\344\006\340\241\204\371HK6D\034\0134(+\234\250\001E\006\242\217\027R\272\0154|\234\000\213\234cg1\011\353d\245\015\275[!Z\307U\274\001\352\001\260\345F\362B\326\366%\255\\pS\243=\003\326\004\274E\255\372\350\350c\347U\256\222!\004\231\204\234\200\266\312\221\266\235z0\213\326\232l\010wa]\347\304\215\253f\274p\030U\373g1\200 \211\344O\032:a\254\323\002:5k\0072\266\371se\236t\240\236\267\331tdL*\030\002f)\332\034\320\361\2419V>U@\316n)\316\347\015\246x\242@_\002\0217\252\233Z\377\350\310T&\237\335gm\253\232q\203\324\034\271\227\211\253\357m\243\3303\010\\jw\\\351\353\317\256?\353\330\034\014\002\256[\037m\312\372\321-B\357*\241\360p\261t\300\253\201\215\274*pN\207\300\361\301\370}\333O\000\304l\212\250\266\361\356/h\327\343\311FY\377\000\025&\316\371\330\226\336\267d\0343\236\260\245\320\370\\\241\001\341\324\235\352\256^\217\251\241O\004P{j2\026,\013\026:\264k?1\261\235b\330\034\013\214\330:\262QeH\273:\271\3176t\352$f\226Tr\027\032'6\237\365\236ry9\207\265@\265\237\336mlv\201&\210\264\317\370\245.\026\271\016\263\244\277\337/\372JJa[\371\276\251\306\343\376(4m\215K\022\213\300\355q'\034\277\242\011;\374\343\261\021\373\021\212\245\232\224\004\005\357\311\374\225\006\263x\225\261\306K\301=\225\014\316p\214nm\234\221\204\374\306\305 \036\375m\013,\230\244\276\371\234\223u\347O=\217\177\024\201)g'\342dZ\312\242?\203LS\364\306\366\361\313\324s8\220\014\303\313U:\233R\3706tT\321\001x\011\23426\000'\335\222\202'(G\306\302\212\231$G;nq\352\213\221\305\231\340\256\372&\233\220\374!\362$\030\271+\036\0326[}I\355<X\254\035\2654\313:\200P\337\223\314\012H\013m\265\034d\004|\014;3\022\255\031\216\003\341E\264\272\262<r\311\255\262\364S\240\372&\210\343\350\300\002\340\312\214l+\277Vo\243\254\230{|\310wT\317\265\"2c\312\017\\\305X\334T;\271\335\225\216\377N\007\365A\\\031\227\330\234\004\025Ni(\241F\2640\0175~\236\336u0*\354H\354@\347\224\370t\022\341\247\372o_\0060\336\232\343\254\244\202\2142\231\217$D\035\257\007\2011\003\230\360\337\362\253\000\247>\247\277\211\264\305\243\332\207\322s\275\232\363\027&\224j\214Nu(\333{\332C\0206{\020\353q@q\202\015\2676v\2021\327]g\022\326n\251n\033\350Br\355F\202s\337&\370\240\037y\035\370\262\307\201\315U\327(\371\027\265\307\036\014\262\204a\2424\032\312\200\015\312v\221\314\374\177\007A\355B\214\365\270\012u\013u\035\2109\036\325\207]_b\250\003\237\341K+\017\271}b\337K\323\023\366th\314\313\3719\006E/Wm\357\332\212\032\250\232\321\275G\014\031Zi\236\241\000\004\273\210`\004y\203r3\204\306\207!\236<mADFA\012CC\307P\234\332\310\026HN1\201\351c\021&\332^-M\2648\233'\325\360O\035\223+\021\377\274\372\362\212\321\300\365*\340\034\230Q\2142\354[\336\206\203\236\222\001\256\230\243\272\312\2535~u\235x\236\202\213\017\324\305!\345\310\252&\222\353\262V\352\026\332\347\274i!N^\34514\211q+\3738\304\323\207'\355\3067G\001yC\305xYh\030@\364*a\350w\270\346g\277\227\372-n\013ge\253\3530\306#w\311%\256\270\205a\2430\311\242\013\233*\245\337F<\255\260\272fw\225$\251\300\325\312L\366\351\354\250\177\013\222\014\323}\261\310\"?\036\364\\\261\353#\312\025\023W\352\375\302\001\255\3179\366Z\237\242'\204\366\315\021\257\251\017\031\001@\271-\215\344\313*_\224\020\375 \263\3230\211Q\374j\217\022~\362?a\231\201\240\310\015\220\364z-<Z\300X#'\375B\341\036\367j\010\020#\271,5\367f\333\224\012$\\\313\353\350\243H\275%\316GX\216\246\326\226`HPm\271z\325\241\371_J\253n\237O_r\375\033\300*r{\360\356\232\331_\227\227\214-\245\005 K\364\341\371%\233i\015\333rF\327P8\036uj \3746\253\303f\345\204\370\257-}\000g\246\301\336\346\226\223\216iu,\023a\036\346<\370\224\301\213H\336\025\226\312yY\350\035HV*8\247\276\372\300}\3166R{mZ\323\313J\023:S\341\326\2266\325\302\303\303A\263\372\014%\311\210\304d\011\266\362-\023\027Q\275Z.[P\220\000\306\"\3305Z\303\303\303A\263\372\014%\311\210\304d\011");
		buffer.rewind();
		return buffer;
	}
	private static final Map<String, Range> assets = initAssets();
	private static Map<String, Range> initAssets() {
		Map<String, Range> assets = new HashMap<String, Range>();
		assets.put("de.appwerft.signinwith.js", new Range(0, 7504));
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
