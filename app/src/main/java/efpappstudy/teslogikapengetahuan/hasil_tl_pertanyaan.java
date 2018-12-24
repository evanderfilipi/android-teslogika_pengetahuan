package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class hasil_tl_pertanyaan extends Activity {
    TextView ha,teks,textbenar,nilaibenar,textsalah,nilaisalah,textscore,nilaiscore,textgrade,nilaigrade,texthighscore,nilaihighscore,keterangan;
    ImageView emot;
    Button reset,mainlagi,share;
    Animation getar, goyang, muter;
    int benar,score,highscore,allsounds;
    SharedPreferences prefs2;
    Typeface fontnya;
    CountDownTimer animtimer;
    MediaPlayer aubtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_tl_pertanyaan);
        fontnya = Typeface.createFromAsset(getAssets(), "static.otf");
        aubtn = MediaPlayer.create(this, R.raw.btn_umum);
        teks = (TextView)findViewById(R.id.teks2);
        ha = (TextView)findViewById(R.id.txtjudulhasil2);
        textbenar = (TextView)findViewById(R.id.txtbenar2);
        nilaibenar = (TextView)findViewById(R.id.scorebenar2);
        textsalah = (TextView)findViewById(R.id.txtsalah2);
        nilaisalah = (TextView)findViewById(R.id.scoresalah2);
        textscore = (TextView)findViewById(R.id.txtscore2);
        nilaiscore = (TextView)findViewById(R.id.totalscore2);
        textgrade = (TextView)findViewById(R.id.txtgrade2);
        nilaigrade = (TextView)findViewById(R.id.gradenya2);
        texthighscore = (TextView)findViewById(R.id.txtscoretertinggi2);
        nilaihighscore = (TextView)findViewById(R.id.scoretertinggi2);
        keterangan = (TextView)findViewById(R.id.txtket2);
        keterangan.setVisibility(View.INVISIBLE);
        emot = (ImageView)findViewById(R.id.imgemot2);
        reset = (Button)findViewById(R.id.resetbtn2);
        mainlagi = (Button)findViewById(R.id.playbtn2);
        share = (Button)findViewById(R.id.sharebtn2);
        getar = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake3);
        goyang = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotater);
        muter = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        animtimer = new CountDownTimer(1000, 500) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                emot.setVisibility(View.VISIBLE);
                emot.startAnimation(goyang);
            }
        }.start();

        Intent goes = getIntent();
        allsounds = goes.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            aubtn.setVolume(0, 0);
        } else {
            allsounds = 0;
            aubtn.setVolume(1, 1);
        }
        benar = goes.getIntExtra("Benar",0);
        nilaibenar.setText(""+benar);
        nilaisalah.setText(""+(25-benar));
        AdView adView = (AdView)findViewById(R.id.adView20);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        prefs2 = this.getSharedPreferences("prefs_tlp", Context.MODE_PRIVATE);
        highscore = prefs2.getInt("scoring",0);
        score = benar*4;
        nilaiscore.setText(""+score);
        if(score<=100 && score>=84){
            nilaigrade.setText("A");
            emot.setBackgroundResource(R.drawable.emotgrade_a);
        }
        else if(score<=83 && score>=64){
            nilaigrade.setText("B");
            emot.setBackgroundResource(R.drawable.emotgrade_b);
        }
        else if(score<=63 && score>=44){
            nilaigrade.setText("C");
            emot.setBackgroundResource(R.drawable.emotgrade_c);
        }
        else if(score<=43 && score>=24){
            nilaigrade.setText("D");
            emot.setBackgroundResource(R.drawable.emotgrade_d);
        }
        else{
            nilaigrade.setText("E");
            emot.setBackgroundResource(R.drawable.emotgrade_e);
        }

        if (highscore > score) {
            nilaihighscore.setText(Integer.toString(highscore));
        } else {
            highscore = score;
            nilaihighscore.setText(Integer.toString(highscore));
            prefs2.edit().putInt("scoring", highscore).apply();
        }
        ha.setTypeface(fontnya);
        teks.setTypeface(fontnya);
        textbenar.setTypeface(fontnya);
        nilaibenar.setTypeface(fontnya);
        textsalah.setTypeface(fontnya);
        nilaisalah.setTypeface(fontnya);
        textscore.setTypeface(fontnya);
        nilaiscore.setTypeface(fontnya);
        textgrade.setTypeface(fontnya);
        nilaigrade.setTypeface(fontnya);
        texthighscore.setTypeface(fontnya);
        nilaihighscore.setTypeface(fontnya);
        keterangan.setTypeface(fontnya);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aubtn.start();
                highscore = 0;
                nilaihighscore.setText("0");
                nilaihighscore.startAnimation(getar);
                prefs2.edit().putInt("scoring", highscore).apply();
            }
        });
        mainlagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aubtn.start();
                emot.clearAnimation();
                Intent b = new Intent(hasil_tl_pertanyaan.this, pertanyaan_4p.class);
                b.putExtra("Efeksuara", allsounds);
                startActivity(b);
                finish();
                overridePendingTransition(R.anim.alpha, R.anim.alpha2);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aubtn.start();
                Intent sharingScore = new Intent(Intent.ACTION_SEND);
                sharingScore.setType("text/plain");
                String shareBody = "Hai! Saya telah mencapai score "+score+" point saat menyelesaikan tes logika (pertanyaan). " +
                        "\nDapatkah anda mengalahkan score saya? Download aplikasi Tes Logika & Pengetahuan di Google Play Store. " +
                        "\n" +
                        "\nhttps://play.google.com/store/apps/details?id=efpappstudy.teslogikapengetahuan";
                sharingScore.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                String shareSub = "Share Score";
                sharingScore.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(sharingScore, "Share via"));
            }
        });

        reset.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        keterangan.setVisibility(View.VISIBLE);
                        keterangan.setText("Reset Score Tertinggi");
                        reset.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        keterangan.setVisibility(View.INVISIBLE);
                        reset.clearAnimation();
                }
                return false;
            }
        });
        mainlagi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        keterangan.setVisibility(View.VISIBLE);
                        keterangan.setText("Main Lagi");
                        mainlagi.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        keterangan.setVisibility(View.INVISIBLE);
                        mainlagi.clearAnimation();
                }
                return false;
            }
        });
        share.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        keterangan.setVisibility(View.VISIBLE);
                        keterangan.setText("Share Score Tertinggi");
                        share.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        keterangan.setVisibility(View.INVISIBLE);
                        share.clearAnimation();
                }
                return false;
            }
        });
    }
    public void onBackPressed() {
        emot.clearAnimation();
        finish();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
