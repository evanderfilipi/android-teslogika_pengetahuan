package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class pertanyaan_4p extends Activity implements View.OnClickListener{
    MediaPlayer audiobtn, efekbtn;
    TextView txt1, nomorsoal;
    Button home,opsiA,opsiB,opsiC,opsiD;;
    Typeface myfont;
    Animation blinks;
    ImageView imgsoalnya, benarsalahnya;
    Random acakin = new Random();
    int acaksoal = acakin.nextInt(50);
    int benar=0;
    int urut = 0;
    int allsounds;
    CountDownTimer waktuimg;

    int [] pertanyaannya = {R.drawable.tp_soal_01,R.drawable.tp_soal_02,R.drawable.tp_soal_03,R.drawable.tp_soal_04,R.drawable.tp_soal_05,
            R.drawable.tp_soal_06,R.drawable.tp_soal_07,R.drawable.tp_soal_08,R.drawable.tp_soal_09,R.drawable.tp_soal_10,
            R.drawable.tp_soal_11,R.drawable.tp_soal_12,R.drawable.tp_soal_13,R.drawable.tp_soal_14,R.drawable.tp_soal_15,
            R.drawable.tp_soal_16,R.drawable.tp_soal_17,R.drawable.tp_soal_18,R.drawable.tp_soal_19,R.drawable.tp_soal_20,
            R.drawable.tp_soal_21,R.drawable.tp_soal_22,R.drawable.tp_soal_23,R.drawable.tp_soal_24,R.drawable.tp_soal_25,
            R.drawable.tp_soal_26,R.drawable.tp_soal_27,R.drawable.tp_soal_28,R.drawable.tp_soal_29,R.drawable.tp_soal_30,
            R.drawable.tp_soal_31,R.drawable.tp_soal_32,R.drawable.tp_soal_33,R.drawable.tp_soal_34,R.drawable.tp_soal_35,
            R.drawable.tp_soal_36,R.drawable.tp_soal_37,R.drawable.tp_soal_38,R.drawable.tp_soal_39,R.drawable.tp_soal_40,
            R.drawable.tp_soal_41,R.drawable.tp_soal_42,R.drawable.tp_soal_43,R.drawable.tp_soal_44,R.drawable.tp_soal_45,
            R.drawable.tp_soal_46,R.drawable.tp_soal_47,R.drawable.tp_soal_48,R.drawable.tp_soal_49,R.drawable.tp_soal_50,
            R.drawable.tp_soal_01,R.drawable.tp_soal_02,R.drawable.tp_soal_03,R.drawable.tp_soal_04,R.drawable.tp_soal_05,
            R.drawable.tp_soal_06,R.drawable.tp_soal_07,R.drawable.tp_soal_08,R.drawable.tp_soal_09,R.drawable.tp_soal_10,
            R.drawable.tp_soal_11,R.drawable.tp_soal_12,R.drawable.tp_soal_13,R.drawable.tp_soal_14,R.drawable.tp_soal_15,
            R.drawable.tp_soal_16,R.drawable.tp_soal_17,R.drawable.tp_soal_18,R.drawable.tp_soal_19,R.drawable.tp_soal_20,
            R.drawable.tp_soal_21,R.drawable.tp_soal_22,R.drawable.tp_soal_23,R.drawable.tp_soal_24,R.drawable.tp_soal_25};
    String [] soal_ke = {"01/25","02/25","03/25","04/25","05/25","06/25","07/25","08/25","09/25","10/25",
            "11/25","12/25","13/25","14/25","15/25","16/25","17/25","18/25","19/25","20/25","21/25","22/25","23/25","24/25","25/25","25/25"};
    String [] opsijawaban = {"B","C","D","B","B","B","A","B","D","A","C","B","D","C","A","B","A","D","D","C","A","A","C","C","C","B","A","B","C","D","D","C","B","B","A","C","A","A","B","C","C","C","B","C","C","A","B","B","D","D",
            "B","C","D","B","B","B","A","B","D","A","C","B","D","C","A","B","A","D","D","C","A","A","C","C","C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan_4p);
        myfont = Typeface.createFromAsset(getAssets(), "static.otf");
        audiobtn = MediaPlayer.create(this, R.raw.btn_umum);
        efekbtn = MediaPlayer.create(this, R.raw.benartw);
        txt1 = (TextView)findViewById(R.id.txt111);
        opsiA = (Button)findViewById(R.id.btn3A);
        opsiA.setOnClickListener(this);
        opsiB = (Button)findViewById(R.id.btn3B);
        opsiB.setOnClickListener(this);
        opsiC = (Button)findViewById(R.id.btn3C);
        opsiC.setOnClickListener(this);
        opsiD = (Button)findViewById(R.id.btn3D);
        opsiD.setOnClickListener(this);
        nomorsoal = (TextView)findViewById(R.id.txtsoalke1);
        nomorsoal.setText(soal_ke[0]);
        blinks = new AlphaAnimation(0.0f,1.0f);
        blinks.setDuration(100);
        blinks.setStartOffset(20);
        blinks.setRepeatMode(Animation.REVERSE);
        blinks.setRepeatCount(2);
        imgsoalnya = (ImageView)findViewById(R.id.tg4pg);
        imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
        Intent b = getIntent();
        allsounds = b.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            audiobtn.setVolume(0, 0);
            efekbtn.setVolume(0, 0);
        } else {
            audiobtn.setVolume(1, 1);
            efekbtn.setVolume(1, 1);
        }

        benarsalahnya = (ImageView)findViewById(R.id.imgtruefalse1);
        home = (Button)findViewById(R.id.home111);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audiobtn.start();
                audiobtn.setLooping(false);
                new AlertDialog.Builder(pertanyaan_4p.this)
                        .setIcon(R.drawable.notificon)
                        .setTitle("Konfirmasi")
                        .setMessage("Anda yakin ingin keluar dari Tes Logika (Pertanyaan)?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                finish();
                                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
        waktuimg = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {
                benarsalahnya.setVisibility(View.VISIBLE);
                benarsalahnya.startAnimation(blinks);
            }

            @Override
            public void onFinish() {
                benarsalahnya.setVisibility(View.INVISIBLE);
            }
        };
        txt1.setTypeface(myfont);
        nomorsoal.setTypeface(myfont);
        AdView adView = (AdView)findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
    public void onClick(View v){
        if (v==opsiA)
        {
            if(opsijawaban[acaksoal].equals("A")){
                efekbtn.start();
                urut++;
                acaksoal++;
                benar++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgbenar);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            else {
                efekbtn.start();
                urut++;
                acaksoal++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgsalah);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            if(urut==25){
                imgsoalnya.setBackgroundResource(R.drawable.tl_soal_polos);
                opsiA.setEnabled(false);
                opsiB.setEnabled(false);
                opsiC.setEnabled(false);
                opsiD.setEnabled(false);
                Intent goes = new Intent(pertanyaan_4p.this, hasil_tl_pertanyaan.class);
                goes.putExtra("Efeksuara", allsounds);
                goes.putExtra("Benar", benar);
                startActivity(goes);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==opsiB)
        {
            if(opsijawaban[acaksoal].equals("B")){
                efekbtn.start();
                urut++;
                acaksoal++;
                benar++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgbenar);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            else {
                efekbtn.start();
                urut++;
                acaksoal++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgsalah);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            if(urut==25){
                imgsoalnya.setBackgroundResource(R.drawable.tl_soal_polos);
                opsiA.setEnabled(false);
                opsiB.setEnabled(false);
                opsiC.setEnabled(false);
                opsiD.setEnabled(false);
                Intent goes = new Intent(pertanyaan_4p.this, hasil_tl_pertanyaan.class);
                goes.putExtra("Efeksuara", allsounds);
                goes.putExtra("Benar", benar);
                startActivity(goes);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==opsiC)
        {
            if(opsijawaban[acaksoal].equals("C")){
                efekbtn.start();
                urut++;
                acaksoal++;
                benar++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgbenar);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            else {
                efekbtn.start();
                urut++;
                acaksoal++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgsalah);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            if(urut==25){
                imgsoalnya.setBackgroundResource(R.drawable.tl_soal_polos);
                opsiA.setEnabled(false);
                opsiB.setEnabled(false);
                opsiC.setEnabled(false);
                opsiD.setEnabled(false);
                Intent goes = new Intent(pertanyaan_4p.this, hasil_tl_pertanyaan.class);
                goes.putExtra("Efeksuara", allsounds);
                goes.putExtra("Benar", benar);
                startActivity(goes);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==opsiD)
        {
            if(opsijawaban[acaksoal].equals("D")){
                efekbtn.start();
                urut++;
                acaksoal++;
                benar++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgbenar);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            else {
                efekbtn.start();
                urut++;
                acaksoal++;
                waktuimg.start();
                benarsalahnya.setImageResource(R.drawable.imgsalah);
                nomorsoal.setText(soal_ke[urut]);
                imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
            }
            if(urut==25){
                imgsoalnya.setBackgroundResource(R.drawable.tl_soal_polos);
                opsiA.setEnabled(false);
                opsiB.setEnabled(false);
                opsiC.setEnabled(false);
                opsiD.setEnabled(false);
                Intent goes = new Intent(pertanyaan_4p.this, hasil_tl_pertanyaan.class);
                goes.putExtra("Efeksuara", allsounds);
                goes.putExtra("Benar", benar);
                startActivity(goes);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
    }

    public void onBackPressed(){
        new AlertDialog.Builder(pertanyaan_4p.this)
                .setIcon(R.drawable.notificon)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin ingin keluar dari Tes Logika (Pertanyaan)?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
