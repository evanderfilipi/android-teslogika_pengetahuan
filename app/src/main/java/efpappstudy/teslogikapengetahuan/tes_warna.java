package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.Random;

public class tes_warna extends Activity implements View.OnClickListener {
    MediaPlayer audiobtn, suarabenar, suarasalah;
    TextView txt1, soal;
    Button home, benar, salah;
    Typeface myfont;
    int score = 0;
    int allsounds;
    CountDownTimer timer;
    ImageView fully;
    Animation anime;
    Random ngacak = new Random();
    int acak = ngacak.nextInt(200);
    String [] warna ={"#ffffff","#ff0000","#8b4513","#000fff","#ffffff","#800080","#ff1493","#ffff00","#ffa500","#808080",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#ffa500","#008000","#ffffff","#ffa500","#ff1493",
            "#ff0000","#008000","#ffa500","#ffff00","#808080","#ff1493","#008000","#8b4513","#000fff","#800080",
            "#808080","#000fff","#8b4513","#ffffff","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#008000","#ffa500","#ffffff","#ffff00","#008000","#ffffff","#ffff00","#800080","#8b4513","#ffa500",
            "#ffffff","#ff0000","#8b4513","#000fff","#ffffff","#800080","#ff1493","#ffff00","#ffa500","#808080",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#008000","#800080","#8b4513","#808080","#000fff",
            "#ff0000","#008000","#ffa500","#ffff00","#808080","#ff1493","#008000","#8b4513","#000fff","#800080",
            "#008000","#8b4513","#ffff00","#ffa500","#ffffff","#ff1493","#ff0000","#000fff","#808080","#800080",
            "#ff1493","#ffffff","#000fff","#8b4513","#800080","#ff1493","#000fff","#ffff00","#808080","#008000",
            "#ffa500","#8b4513","#ffff00","#8b4513","#ffffff","#808080","#ff0000","#008000","#8b4513","#800080",
            "#808080","#000fff","#8b4513","#ffffff","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#ffffff","#8b4513","#008000","#000fff","#ff0000","#808080","#ff0000","#ffa500","#ff1493","#ff0000",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#800080","#000fff","#8b4513","#008000","#ff1493","#808080","#ffff00","#ffa500","#008000","#ff0000",
            "#808080","#ffffff","#8b4513","#008000","#ffff00","#ff0000","#ffffff","#000fff","#ff1493","#ffa500",
            "#ffffff","#ffa500","#ff1493","#ff0000","#800080","#ffff00","#ffff00","#ffa500","#808080","#ffffff",
            "#008000","#ffffff","#808080","#800080","#000fff","#8b4513","#ffff00","#000fff","#808080","#008000",
            "#000fff","#8b4513","#800080","#ff1493","#000fff","#8b4513","#ffffff","#808080","#ff0000","#008000",
            "#ffffff","#ffffff","#ffff00","#008000","#ffffff","#ffff00","#8b4513","#ff1493","#808080","#ff0000",
            "#ffffff","#ff0000","#8b4513","#000fff","#ffffff","#800080","#ff1493","#ffff00","#ffa500","#808080",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#ffa500","#008000","#ffffff","#ffa500","#ff1493",
            "#ff0000","#008000","#ffa500","#ffff00","#808080","#ff1493","#008000","#8b4513","#000fff","#800080",
            "#808080","#000fff","#8b4513","#ffffff","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#008000","#ffa500","#ffffff","#ffff00","#008000","#ffffff","#ffff00","#800080","#8b4513","#ffa500",
            "#ffffff","#ff0000","#8b4513","#000fff","#ffffff","#800080","#ff1493","#ffff00","#ffa500","#808080",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#008000","#800080","#8b4513","#808080","#000fff",
            "#ff0000","#008000","#ffa500","#ffff00","#808080","#ff1493","#008000","#8b4513","#000fff","#800080",
            "#008000","#8b4513","#ffff00","#ffa500","#ffffff","#ff1493","#ff0000","#000fff","#808080","#800080",
            "#ff1493","#ffffff","#000fff","#8b4513","#800080","#ff1493","#000fff","#ffff00","#808080","#008000",
            "#ffa500","#8b4513","#ffff00","#8b4513","#ffffff","#808080","#ff0000","#008000","#8b4513","#800080",
            "#808080","#000fff","#8b4513","#ffffff","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#ffffff","#8b4513","#008000","#000fff","#ff0000","#808080","#ff0000","#ffa500","#ff1493","#ff0000",
            "#000fff","#ff0000","#ffff00","#808080","#ff1493","#ffffff","#808080","#ff0000","#800080","#ffff00",
            "#800080","#000fff","#8b4513","#008000","#ff1493","#808080","#ffff00","#ffa500","#008000","#ff0000",
            "#808080","#ffffff","#8b4513","#008000","#ffff00","#ff0000","#ffffff","#000fff","#ff1493","#ffa500",
            "#ffffff","#ffa500","#ff1493","#ff0000","#800080","#ffff00","#ffff00","#ffa500","#808080","#ffffff",
            "#008000","#ffffff","#808080","#800080","#000fff","#8b4513","#ffff00","#000fff","#808080","#008000",
            "#000fff","#8b4513","#800080","#ff1493","#000fff","#8b4513","#ffffff","#808080","#ff0000","#008000",
            "#ffffff","#ffffff","#ffff00","#008000","#ffffff","#ffff00","#8b4513","#ff1493","#808080","#ff0000"};
    String [] soalnya = {"MERAH","HIJAU","COKLAT","BIRU","PUTIH","ABU-ABU","PINK","KUNING","UNGU","JINGGA",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","BIRU","PUTIH","UNGU","JINGGA","PUTIH",
            "MERAH","HIJAU","KUNING","MERAH","ABU-ABU","PINK","BIRU","COKLAT","PUTIH","UNGU",
            "JINGGA","HIJAU","COKLAT","ABU-ABU","MERAH","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "COKLAT","JINGGA","PINK","KUNING","HIJAU","PUTIH","ABU-ABU","BIRU","COKLAT","PINK",
            "MERAH","HIJAU","COKLAT","BIRU","PUTIH","ABU-ABU","PINK","KUNING","UNGU","JINGGA",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","HIJAU","UNGU","JINGGA","PUTIH","BIRU",
            "MERAH","HIJAU","KUNING","MERAH","ABU-ABU","PINK","BIRU","COKLAT","PUTIH","UNGU",
            "HIJAU","COKLAT","ABU-ABU","UNGU","MERAH","PINK","MERAH","KUNING","ABU-ABU","BIRU",
            "PINK","ABU-ABU","JINGGA","HIJAU","UNGU","PUTIH","BIRU","KUNING","COKLAT","HIJAU",
            "JINGGA","PINK","KUNING","HIJAU","ABU-ABU","PUTIH","MERAH","BIRU","COKLAT","UNGU",
            "JINGGA","HIJAU","COKLAT","ABU-ABU","MERAH","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "COKLAT","PINK","HIJAU","BIRU","JINGGA","ABU-ABU","MERAH","KUNING","PUTIH","MERAH",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "UNGU","PUTIH","COKLAT","BIRU","PINK","MERAH","UNGU","ABU-ABU","COKLAT","HIJAU",
            "COKLAT","PUTIH","MERAH","HIJAU","KUNING","MERAH","ABU-ABU","BIRU","PINK","HIJAU",
            "UNGU","JINGGA","PUTIH","KUNING","UNGU","BIRU","KUNING","UNGU","JINGGA","PUTIH",
            "JINGGA","MERAH","PINK","UNGU","BIRU","COKLAT","HIJAU","UNGU","ABU-ABU","HIJAU",
            "JINGGA","HIJAU","UNGU","PUTIH","BIRU","HIJAU","ABU-ABU","PUTIH","MERAH","BIRU",
            "MERAH","PUTIH","KUNING","HIJAU","PUTIH","ABU-ABU","BIRU","COKLAT","ABU-ABU","JINGGA",
            "MERAH","HIJAU","COKLAT","BIRU","PUTIH","ABU-ABU","PINK","KUNING","UNGU","JINGGA",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","BIRU","PUTIH","UNGU","JINGGA","PUTIH",
            "MERAH","HIJAU","KUNING","MERAH","ABU-ABU","PINK","BIRU","COKLAT","PUTIH","UNGU",
            "JINGGA","HIJAU","COKLAT","ABU-ABU","MERAH","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "COKLAT","JINGGA","PINK","KUNING","HIJAU","PUTIH","ABU-ABU","BIRU","COKLAT","PINK",
            "MERAH","HIJAU","COKLAT","BIRU","PUTIH","ABU-ABU","PINK","KUNING","UNGU","JINGGA",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","HIJAU","UNGU","JINGGA","PUTIH","BIRU",
            "MERAH","HIJAU","KUNING","MERAH","ABU-ABU","PINK","BIRU","COKLAT","PUTIH","UNGU",
            "HIJAU","COKLAT","ABU-ABU","UNGU","MERAH","PINK","MERAH","KUNING","ABU-ABU","BIRU",
            "PINK","ABU-ABU","JINGGA","HIJAU","UNGU","PUTIH","BIRU","KUNING","COKLAT","HIJAU",
            "JINGGA","PINK","KUNING","HIJAU","ABU-ABU","PUTIH","MERAH","BIRU","COKLAT","UNGU",
            "JINGGA","HIJAU","COKLAT","ABU-ABU","MERAH","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "COKLAT","PINK","HIJAU","BIRU","JINGGA","ABU-ABU","MERAH","KUNING","PUTIH","MERAH",
            "BIRU","MERAH","COKLAT","ABU-ABU","KUNING","PUTIH","ABU-ABU","KUNING","UNGU","BIRU",
            "UNGU","PUTIH","COKLAT","BIRU","PINK","MERAH","UNGU","ABU-ABU","COKLAT","HIJAU",
            "COKLAT","PUTIH","MERAH","HIJAU","KUNING","MERAH","ABU-ABU","BIRU","PINK","HIJAU",
            "UNGU","JINGGA","PUTIH","KUNING","UNGU","BIRU","KUNING","UNGU","JINGGA","PUTIH",
            "JINGGA","MERAH","PINK","UNGU","BIRU","COKLAT","HIJAU","UNGU","ABU-ABU","HIJAU",
            "JINGGA","HIJAU","UNGU","PUTIH","BIRU","HIJAU","ABU-ABU","PUTIH","MERAH","BIRU",
            "MERAH","PUTIH","KUNING","HIJAU","PUTIH","ABU-ABU","BIRU","COKLAT","ABU-ABU","JINGGA"};
    String [] jawaban = {"S","S","B","B","B","S","B","B","S","S",
            "B","B","S","B","S","S","S","S","B","S",
            "B","B","S","S","B","B","S","B","S","B",
            "S","S","B","S","S","B","B","S","B","S",
            "S","B","S","B","B","B","S","S","B","S",
            "S","S","B","B","B","S","B","B","S","S",
            "B","B","S","B","S","B","B","S","S","B",
            "B","B","S","S","B","B","S","B","S","B",
            "B","B","S","S","S","B","B","S","B","S",
            "B","S","S","S","B","S","B","B","S","B",
            "B","S","B","S","S","S","B","S","B","B",
            "S","S","B","S","S","B","B","S","B","S",
            "S","S","B","B","S","B","B","S","S","B",
            "B","B","S","B","S","B","B","S","B","S",
            "B","S","B","S","B","S","S","S","B","B",
            "S","B","S","B","B","B","S","B","B","S",
            "S","B","S","S","B","S","B","S","S","B",
            "S","S","S","B","B","B","S","S","B","B",
            "S","S","B","S","B","S","S","S","B","S",
            "S","B","B","B","B","S","S","S","B","S",
            "S","S","B","B","B","S","B","B","S","S",
            "B","B","S","B","S","S","S","S","B","S",
            "B","B","S","S","B","B","S","B","S","B",
            "S","S","B","S","S","B","B","S","B","S",
            "S","B","S","B","B","B","S","S","B","S",
            "S","S","B","B","B","S","B","B","S","S",
            "B","B","S","B","S","B","B","S","S","B",
            "B","B","S","S","B","B","S","B","S","B",
            "B","B","S","S","S","B","B","S","B","S",
            "B","S","S","S","B","S","B","B","S","B",
            "B","S","B","S","S","S","B","S","B","B",
            "S","S","B","S","S","B","B","S","B","S",
            "S","S","B","B","S","B","B","S","S","B",
            "B","B","S","B","S","B","B","S","B","S",
            "B","S","B","S","B","S","S","S","B","B",
            "S","B","S","B","B","B","S","B","B","S",
            "S","B","S","S","B","S","B","S","S","B",
            "S","S","S","B","B","B","S","S","B","B",
            "S","S","B","S","B","S","S","S","B","S",
            "S","B","B","B","B","S","S","S","B","S"};

    /*
    #ffffff = putih
    #ff0000 = merah
    #000fff = biru
    #008000 = hijau
    #ffff00 = kuning
    #ffa500 = jingga
    #800080 = ungu
    #808080 = abu-abu
    #ff1493 = pink
    #8b4513 = coklat
    #000000 = hitam
    (warna hitam tidak dipakai, karena sudah warna background)

    jumlah soal = 400
    soal yang ditampilkan = 200
    max high score = 200
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes_warna);
        myfont = Typeface.createFromAsset(getAssets(), "static.otf");
        audiobtn = MediaPlayer.create(this, R.raw.btn_umum);
        suarabenar = MediaPlayer.create(this, R.raw.benartw);
        suarasalah = MediaPlayer.create(this, R.raw.salahtw);
        fully = (ImageView)findViewById(R.id.imageload);
        fully.setVisibility(View.INVISIBLE);
        soal = (TextView)findViewById(R.id.txtsoal);
        soal.setText(soalnya[acak]);
        anime = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.loads);
        soal.setTextColor(Color.parseColor(warna[acak]));
        txt1 = (TextView)findViewById(R.id.txt11111);
        home = (Button)findViewById(R.id.home11111);
        benar = (Button)findViewById(R.id.benarbtn);
        benar.setOnClickListener(this);
        salah = (Button)findViewById(R.id.salahbtn);
        salah.setOnClickListener(this);

        Intent c = getIntent();
        allsounds = c.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            audiobtn.setVolume(0, 0);
            suarabenar.setVolume(0, 0);
            suarasalah.setVolume(0, 0);
        } else {
            audiobtn.setVolume(1, 1);
            suarabenar.setVolume(1, 1);
            suarasalah.setVolume(1, 1);
        }
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audiobtn.start();
                audiobtn.setLooping(false);
                new AlertDialog.Builder(tes_warna.this)
                        .setIcon(R.drawable.notificon)
                        .setTitle("Konfirmasi")
                        .setMessage("Anda yakin ingin keluar dari Tes Logika (Warna)?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                finish();
                                timer.cancel();
                                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
        txt1.setTypeface(myfont);
        soal.setTypeface(myfont);
        AdView adView = (AdView)findViewById(R.id.adView7);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        timer = new CountDownTimer(1500, 1000) {
            public void onTick(long millisUntilFinished) {
                fully.setVisibility(View.VISIBLE);
                fully.startAnimation(anime);
            }
            public void onFinish() {
                suarasalah.start();
                benar.setEnabled(false);
                salah.setEnabled(false);
                Intent go = new Intent (tes_warna.this, gameover_tw.class);
                go.putExtra("Efeksuara", allsounds);
                go.putExtra("Score", score);
                startActivity(go);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        };
    }

    public void onClick (View view){

        if(view==benar){
            if (jawaban[acak].equals("B")){
                suarabenar.start();
                suarabenar.setLooping(false);
                score++;
                acak++;
                timer.cancel();
                timer.start();
                soal.setText(soalnya[acak]);
                soal.setTextColor(Color.parseColor(warna[acak]));
            }
            else{
                Intent go = new Intent (tes_warna.this, gameover_tw.class);
                go.putExtra("Efeksuara", allsounds);
                go.putExtra("Score", score);
                suarasalah.start();
                timer.cancel();
                suarasalah.setLooping(false);
                startActivity(go);
                finish();
                overridePendingTransition(R.anim.animation_enterdown, R.anim.animation_leavedown);
            }
            if (score==200){
                soal.setText("");
                benar.setEnabled(false);
                salah.setEnabled(false);
                Intent go = new Intent (tes_warna.this, gameover_tw.class);
                go.putExtra("Efeksuara", allsounds);
                go.putExtra("Score", score);
                timer.cancel();
                startActivity(go);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
        else if(view==salah){
            if (jawaban[acak].equals("S")){
                suarabenar.start();
                suarabenar.setLooping(false);
                score++;
                acak++;
                timer.cancel();
                timer.start();
                soal.setText(soalnya[acak]);
                soal.setTextColor(Color.parseColor(warna[acak]));
            }
            else{
                Intent go = new Intent (tes_warna.this, gameover_tw.class);
                go.putExtra("Efeksuara", allsounds);
                go.putExtra("Score", score);
                suarasalah.start();
                timer.cancel();
                suarasalah.setLooping(false);
                startActivity(go);
                finish();
                overridePendingTransition(R.anim.animation_enterup, R.anim.animation_leaveup);
            }
            if (score==200) {
                soal.setText("");
                benar.setEnabled(false);
                salah.setEnabled(false);
                Intent go = new Intent(tes_warna.this, gameover_tw.class);
                go.putExtra("Efeksuara", allsounds);
                go.putExtra("Score", score);
                timer.cancel();
                startActivity(go);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        }
    }
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.notificon)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin ingin keluar dari Tes Logika (Warna)?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                        timer.cancel();
                        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}