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

public class tes_gambar_6p extends Activity implements View.OnClickListener{
    MediaPlayer audiobtn, efekbtn;
    TextView txt1, nomorsoal;
    Button home, but_a,but_b,but_c,but_d,but_e,but_f;
    Typeface myfont;
    Animation blinks;
    ImageView imgsoalnya, benarsalahnya;
    Random acakin = new Random();
    int acaksoal = acakin.nextInt(50);
    int benar = 0;
    int urut = 0;
    int allsounds;
    CountDownTimer waktuimg;

    int[] pertanyaannya = {R.drawable.stlg_lanjut_1, R.drawable.stlg_lanjut_2, R.drawable.stlg_pola_1, R.drawable.stlg_lanjut_3, R.drawable.stlg_pola_2,
            R.drawable.stlg_lanjut_4, R.drawable.stlg_lanjut_5, R.drawable.stlg_pola_3, R.drawable.stlg_lanjut_6, R.drawable.stlg_tebak_1,
            R.drawable.stlg_lanjut_7, R.drawable.stlg_lanjut_8, R.drawable.stlg_pola_4, R.drawable.stlg_lanjut_9, R.drawable.stlg_tebak_2,
            R.drawable.stlg_lanjut_10, R.drawable.stlg_lanjut_11, R.drawable.stlg_pola_5, R.drawable.stlg_lanjut_12, R.drawable.stlg_tebak_3,
            R.drawable.stlg_lanjut_13, R.drawable.stlg_lanjut_14, R.drawable.stlg_pola_6, R.drawable.stlg_lanjut_15, R.drawable.stlg_tebak_8,
            R.drawable.stlg_lanjut_16, R.drawable.stlg_lanjut_17, R.drawable.stlg_pola_7, R.drawable.stlg_lanjut_18, R.drawable.stlg_pola_8,
            R.drawable.stlg_lanjut_19, R.drawable.stlg_lanjut_20, R.drawable.stlg_pola_9, R.drawable.stlg_lanjut_21, R.drawable.stlg_tebak_7,
            R.drawable.stlg_lanjut_22, R.drawable.stlg_lanjut_23, R.drawable.stlg_pola_10, R.drawable.stlg_lanjut_24, R.drawable.stlg_tebak_5,
            R.drawable.stlg_lanjut_25, R.drawable.stlg_lanjut_26, R.drawable.stlg_pola_11, R.drawable.stlg_lanjut_27, R.drawable.stlg_tebak_4,
            R.drawable.stlg_lanjut_28, R.drawable.stlg_lanjut_29, R.drawable.stlg_pola_12, R.drawable.stlg_lanjut_30, R.drawable.stlg_tebak_6,
            R.drawable.stlg_lanjut_1, R.drawable.stlg_lanjut_2, R.drawable.stlg_pola_1, R.drawable.stlg_lanjut_3, R.drawable.stlg_pola_2,
            R.drawable.stlg_lanjut_4, R.drawable.stlg_lanjut_5, R.drawable.stlg_pola_3, R.drawable.stlg_lanjut_6, R.drawable.stlg_tebak_1,
            R.drawable.stlg_lanjut_7, R.drawable.stlg_lanjut_8, R.drawable.stlg_pola_4, R.drawable.stlg_lanjut_9, R.drawable.stlg_tebak_2,
            R.drawable.stlg_lanjut_10, R.drawable.stlg_lanjut_11, R.drawable.stlg_pola_5, R.drawable.stlg_lanjut_12, R.drawable.stlg_tebak_3,
            R.drawable.stlg_lanjut_13, R.drawable.stlg_lanjut_14, R.drawable.stlg_pola_6, R.drawable.stlg_lanjut_15, R.drawable.stlg_tebak_8};
    String [] soal_ke = {"01/25","02/25","03/25","04/25","05/25","06/25","07/25","08/25","09/25","10/25",
            "11/25","12/25","13/25","14/25","15/25","16/25","17/25","18/25","19/25","20/25","21/25","22/25","23/25","24/25","25/25","25/25"};
    String[] opsijawaban = {"A","B","E","F","B","E","B","D","C","E","D","B","C","A","D","E","E","F","C","C","A","C","A","F","C",
            "A","D","A","A","B","B","A","C","F","D","E","E","D","C","F","D","B","E","C","A","E","A","F","A","B",
            "A","B","E","F","B","E","B","D","C","E","D","B","C","A","D","E","E","F","C","C","A","C","A","F","C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_gambar_6p);
        myfont= Typeface.createFromAsset(getAssets(), "static.otf");
        audiobtn = MediaPlayer.create(this, R.raw.btn_umum);
        efekbtn = MediaPlayer.create(this, R.raw.benartw);
        txt1 = (TextView)findViewById(R.id.txt11);
        home = (Button)findViewById(R.id.home11);
        but_a=(Button)findViewById(R.id.butA);
        but_a.setOnClickListener(this);
        but_b=(Button)findViewById(R.id.butB);
        but_b.setOnClickListener(this);
        but_c=(Button)findViewById(R.id.butC);
        but_c.setOnClickListener(this);
        but_d=(Button)findViewById(R.id.butD);
        but_d.setOnClickListener(this);
        but_e=(Button)findViewById(R.id.butE);
        but_e.setOnClickListener(this);
        but_f=(Button)findViewById(R.id.butF);
        but_f.setOnClickListener(this);
        nomorsoal = (TextView)findViewById(R.id.txtsoalke2);
        nomorsoal.setText(soal_ke[0]);
        blinks = new AlphaAnimation(0.0f,1.0f);
        blinks.setDuration(100);
        blinks.setStartOffset(20);
        blinks.setRepeatMode(Animation.REVERSE);
        blinks.setRepeatCount(2);
        imgsoalnya = (ImageView)findViewById(R.id.tg6pg);
        imgsoalnya.setBackgroundResource(pertanyaannya[acaksoal]);
        Intent a = getIntent();
        allsounds = a.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            audiobtn.setVolume(0, 0);
            efekbtn.setVolume(0, 0);
        } else {
            audiobtn.setVolume(1, 1);
            efekbtn.setVolume(1, 1);
        }

        benarsalahnya = (ImageView)findViewById(R.id.imgtruefalse2);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audiobtn.start();
                audiobtn.setLooping(false);
                new AlertDialog.Builder(tes_gambar_6p.this)
                        .setIcon(R.drawable.notificon)
                        .setTitle("Konfirmasi")
                        .setMessage("Anda yakin ingin keluar dari Tes Logika (Gambar)?")
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
        AdView adView = (AdView)findViewById(R.id.adView6);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void onClick(View v){
        if (v==but_a)
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==but_b)
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==but_c)
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==but_d)
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==but_e)
        {
            if(opsijawaban[acaksoal].equals("E")){
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if (v==but_f)
        {
            if(opsijawaban[acaksoal].equals("F")){
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
                imgsoalnya.setBackgroundResource(R.drawable.stlg_polos);
                but_a.setEnabled(false);
                but_b.setEnabled(false);
                but_c.setEnabled(false);
                but_d.setEnabled(false);
                but_e.setEnabled(false);
                but_f.setEnabled(false);
                Intent goen = new Intent(tes_gambar_6p.this, hasil_tl_gambar.class);
                goen.putExtra("Efeksuara", allsounds);
                goen.putExtra("Benars", benar);
                startActivity(goen);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.notificon)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin ingin keluar dari Tes Logika (Gambar)?")
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
