package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class gameover_tw extends Activity {
    TextView sc, hsc, tsc, thsc, gov, ketnya;
    Typeface fonts;
    Button reset, mainlagi, share;
    int scores, hiscores, allsounds;
    SharedPreferences prefs3;
    Animation muter, getar;
    MediaPlayer aubtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover_tw);
        aubtn = MediaPlayer.create(this, R.raw.btn_umum);
        muter = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        fonts = Typeface.createFromAsset(getAssets(), "static.otf");
        Intent go = getIntent();
        allsounds = go.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            aubtn.setVolume(0, 0);
        } else {
            allsounds = 0;
            aubtn.setVolume(1, 1);
        }
        getar = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake);
        reset = (Button) findViewById(R.id.resetBtn);
        mainlagi = (Button)findViewById(R.id.play);
        share = (Button)findViewById(R.id.shareBtn);
        scores = go.getIntExtra("Score",0);
        sc = (TextView)findViewById(R.id.txtscore);
        sc.setText(""+scores);
        hsc = (TextView)findViewById(R.id.txthighscore);
        gov = (TextView)findViewById(R.id.textView2);
        tsc = (TextView)findViewById(R.id.textView5);
        thsc = (TextView)findViewById(R.id.textView6);
        ketnya = (TextView)findViewById(R.id.txtket);
        ketnya.setVisibility(View.INVISIBLE);
        prefs3 = this.getSharedPreferences("prefs_warna", Context.MODE_PRIVATE);
        hiscores = prefs3.getInt("score",0);

        if (scores==200){
            gov.setText("CONGRATS!");
        }

        if (hiscores > scores) {
            hsc.setText(Integer.toString(hiscores));
        } else {
            hiscores = scores;
            hsc.setText(Integer.toString(hiscores));
            prefs3.edit().putInt("score", hiscores).apply();
        }
        gov.setTypeface(fonts);
        sc.setTypeface(fonts);
        hsc.setTypeface(fonts);
        tsc.setTypeface(fonts);
        thsc.setTypeface(fonts);
        ketnya.setTypeface(fonts);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aubtn.start();
                hiscores = 0;
                hsc.setText("0");
                hsc.startAnimation(getar);
                prefs3.edit().putInt("score", hiscores).apply();
            }
        });
        mainlagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aubtn.start();
                Intent c = new Intent(gameover_tw.this, tes_warna.class);
                c.putExtra("Efeksuara", allsounds);
                startActivity(c);
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
                String shareBody = "Hai! Saya telah mencapai score "+scores+" point saat menyelesaikan tes logika (warna). " +
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
                        ketnya.setVisibility(View.VISIBLE);
                        ketnya.setText("Reset Score Tertinggi");
                        reset.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        reset.clearAnimation();
                        ketnya.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        mainlagi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ketnya.setVisibility(View.VISIBLE);
                        ketnya.setText("Main Lagi");
                        mainlagi.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        mainlagi.clearAnimation();
                        ketnya.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        share.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ketnya.setVisibility(View.VISIBLE);
                        ketnya.setText("Share Score Tertinggi");
                        share.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        share.clearAnimation();
                        ketnya.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
        AdView adView = (AdView)findViewById(R.id.adView8);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
