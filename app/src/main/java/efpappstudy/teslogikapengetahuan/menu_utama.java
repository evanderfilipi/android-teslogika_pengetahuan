package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class menu_utama extends Activity {
    Animation muter;
    TextView ket;
    Button tlogika, tebakan, tentang, rating, share;
    ToggleButton myToogle2;
    MediaPlayer audiobtnmenu, audiobtnumum;
    Typeface fonts;
    SharedPreferences prefsss;
    int tgprefs2, allsounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);
        muter = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        tlogika = (Button) findViewById(R.id.kuis_logika);
        tlogika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menu_utama.this, jenis_tl.class);
                i.putExtra("Efeksuara", allsounds);
                startActivity(i);
                overridePendingTransition(R.anim.animation_enterup, R.anim.animation_leaveup);
                audiobtnmenu.start();
            }
        });
        tebakan = (Button) findViewById(R.id.tebak_tebakan);
        tebakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(menu_utama.this, level_tebak_kata.class);
                j.putExtra("Efeksuara", allsounds);
                startActivity(j);
                overridePendingTransition(R.anim.animation_enterdown, R.anim.animation_leavedown);
                audiobtnmenu.start();
            }
        });
        tentang = (Button) findViewById(R.id.aboutbtn);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent k = new Intent(menu_utama.this, tentangapk.class);
                startActivity(k);
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
                audiobtnumum.start();
            }
        });
        share = (Button) findViewById(R.id.shared);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audiobtnumum.start();
                Intent sharingScore = new Intent(Intent.ACTION_SEND);
                sharingScore.setType("text/plain");
                String shareBody = "Download aplikasi Tes Logika & Pengetahuan di Google Play Store. " +
                        "\n" +
                        "\nhttps://play.google.com/store/apps/details?id=efpappstudy.teslogikapengetahuan";
                sharingScore.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                String shareSub = "Share Aplikasi";
                sharingScore.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(sharingScore, "Share via"));
            }
        });
        rating = (Button)findViewById(R.id.ratebtn);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audiobtnumum.start();
                Toast.makeText(menu_utama.this, "Aplikasi belum di-upload ke PlayStore!", Toast.LENGTH_LONG).show();
                /*Intent intent = new Intent (android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=efpappstudy.teslogikapengetahuan"));
                startActivity(intent);*/
            }
        });

        prefsss = this.getSharedPreferences("preferin", Context.MODE_PRIVATE);
        tgprefs2 = prefsss.getInt("tgprefss", 0);

        ket = (TextView)findViewById(R.id.keterangan);
        ket.setVisibility(View.INVISIBLE);
        fonts = Typeface.createFromAsset(getAssets(), "static.otf");
        ket.setTypeface(fonts);
        myToogle2 = (ToggleButton)findViewById(R.id.soundbtn);
        audiobtnmenu = MediaPlayer.create(this, R.raw.btn_menu);
        audiobtnumum = MediaPlayer.create(this, R.raw.btn_umum);
        audiobtnmenu.setLooping(false);
        audiobtnumum.setLooping(false);

        AdView adView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        myToogle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audiobtnumum.start();
                if (myToogle2.isChecked()) {
                    audiobtnmenu.setVolume(0, 0);
                    audiobtnumum.setVolume(0, 0);
                    ket.setText("Hidupkan Efek Suara");
                    tgprefs2 = 1;
                    allsounds = 1;
                    prefsss.edit().putInt("tgprefss", tgprefs2).commit();
                } else {
                    ket.setText("Matikan Efek Suara");
                    audiobtnmenu.setVolume(1, 1);
                    audiobtnumum.setVolume(1, 1);
                    tgprefs2 = 0;
                    allsounds = 0;
                    prefsss.edit().putInt("tgprefss", tgprefs2).commit();
                }
            }
        });

        if(tgprefs2 == 0){
            ket.setText("Matikan Efek Suara");
            allsounds = 0;
            audiobtnmenu.setVolume(1, 1);
            audiobtnumum.setVolume(1, 1);
            myToogle2.setChecked(false);
        } else {
            myToogle2.setChecked(true);
            allsounds = 1;
            audiobtnmenu.setVolume(0, 0);
            audiobtnumum.setVolume(0, 0);
        }

        myToogle2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ket.setVisibility(View.VISIBLE);
                        myToogle2.startAnimation(muter);
                        if(tgprefs2 == 0){
                            ket.setText("Matikan Efek Suara");
                        } else {
                            ket.setText("Hidupkan Efek Suara");
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        ket.setVisibility(View.INVISIBLE);
                        myToogle2.clearAnimation();
                }
                return false;
            }
        });
        rating.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ket.setVisibility(View.VISIBLE);
                        ket.setText("Rate Aplikasi Ini");
                        rating.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        ket.setVisibility(View.INVISIBLE);
                        rating.clearAnimation();
                }
                return false;
            }
        });
        tentang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ket.setVisibility(View.VISIBLE);
                        ket.setText("Tentang Aplikasi");
                        tentang.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        ket.setVisibility(View.INVISIBLE);
                        tentang.clearAnimation();
                }
                return false;
            }
        });
        share.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ket.setVisibility(View.VISIBLE);
                        ket.setText("Share Aplikasi Ini");
                        share.startAnimation(muter);
                        break;
                    case MotionEvent.ACTION_UP:
                        ket.setVisibility(View.INVISIBLE);
                        share.clearAnimation();
                }
                return false;
            }
        });
    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setMessage("Anda yakin ingin keluar?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
