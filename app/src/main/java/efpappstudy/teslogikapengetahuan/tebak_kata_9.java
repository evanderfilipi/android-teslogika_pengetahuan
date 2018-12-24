package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.concurrent.TimeUnit;

public class tebak_kata_9 extends Activity implements View.OnClickListener{

    String FORMAT = "%02d:%02d";
    MediaPlayer audiobtn, benarsound, salahsound, jwbsound, horeee, telolet;
    EditText isi;
    ImageView benarsalah;
    TextView txt1, txthuruf, waktumundur, jumlahsoal, slmt, soal;
    Button jawab, lanjut;
    Typeface myTypeface, soalTypeface;
    CountDownTimer imgtimer, waktu, waktu2;
    RelativeLayout tamat;
    Animation anim, animasi, blink;
    int indeks = 0;
    int unlock9, allsounds;
    String [] pertanyaan = {"Program rancangan belajar mengajar yang diberikan oleh lembaga pendidikan", "Nama Sistem Operasi yang dibuat oleh Linus Torvalds", "Ibukota negara Fiji",
            "Lapisan atmosfer ke-2", "Tanpa nama atau tidak beridentitas", "Kumpulan atom yang terikat secara kimia", "Hambatan (sinonim)",
            "Perjanjian yang dilakukan oleh Belanda dan Jepang pada 8 Maret 1942", "Huruf ke-5 dalam abjad Yunani", "Keadaan hidup bersama secara erat antara dua organisme yang berbeda"};
    String [] jawaban = {"KURIKULUM", "LINUX", "SUVA", "STRATOSFER", "ANONIM", "MOLEKUL", "KENDALA", "KALIJATI", "EPSILON", "SIMBIOSIS"};
    String [] jumlahhuruf = {"9 Huruf", "5 Huruf", "4 Huruf", "10 Huruf", "6 Huruf", "7 Huruf", "7 Huruf", "8 Huruf", "7 Huruf", "9 Huruf"};
    String [] nomor = {"01/10","02/10","03/10","04/10","05/10","06/10","07/10","08/10","09/10","10/10"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_kata_9);
        myTypeface = Typeface.createFromAsset(getAssets(), "static.otf");
        soalTypeface = Typeface.createFromAsset(getAssets(), "Sitka.ttc");
        audiobtn = MediaPlayer.create(this, R.raw.btn_umum);
        benarsound = MediaPlayer.create(this, R.raw.benar);
        salahsound = MediaPlayer.create(this, R.raw.salah);
        jwbsound = MediaPlayer.create(this, R.raw.jawabsound);
        txthuruf = (TextView)findViewById(R.id.hurufTxt9);
        tamat = (RelativeLayout)findViewById(R.id.rldone9);
        txthuruf.setText(jumlahhuruf[0]);
        jumlahsoal = (TextView)findViewById(R.id.persoalan9);
        slmt = (TextView)findViewById(R.id.txtSelamat9);
        jumlahsoal.setText(nomor[0]);
        animasi = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out2);
        blink = new AlphaAnimation(0.0f,1.0f);
        blink.setDuration(50);
        blink.setStartOffset(20);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(Animation.INFINITE);
        soal = (TextView) findViewById(R.id.question9);
        soal.setText(pertanyaan[0]);
        benarsalah = (ImageView) findViewById(R.id.benarsalahimg9);
        horeee = MediaPlayer.create(this, R.raw.applause);
        waktumundur = (TextView)findViewById(R.id.timertxt9);
        telolet = MediaPlayer.create(this, R.raw.waktuhabis);
        txt1 = (TextView)findViewById(R.id.textView333333333);
        Button home = (Button)findViewById(R.id.home_9);
        isi = (EditText)findViewById(R.id.jawabTxt9);
        lanjut = (Button)findViewById(R.id.okbtn9);
        AdView adView = (AdView)findViewById(R.id.adView17);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        jawab = (Button)findViewById(R.id.jawabBtn9);
        jawab.setOnClickListener(this);
        Intent level9 = getIntent();
        allsounds = level9.getIntExtra("Efeksuara", 0);
        if (allsounds == 1){
            audiobtn.setVolume(0, 0);
            benarsound.setVolume(0, 0);
            salahsound.setVolume(0, 0);
            jwbsound.setVolume(0, 0);
            horeee.setVolume(0, 0);
            telolet.setVolume(0, 0);
        } else {
            audiobtn.setVolume(1, 1);
            benarsound.setVolume(1, 1);
            salahsound.setVolume(1, 1);
            jwbsound.setVolume(1, 1);
            horeee.setVolume(1, 1);
            telolet.setVolume(1, 1);
        }
        waktu = new CountDownTimer(601000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                waktumundur.setText(""+String.format(FORMAT, TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            @Override
            public void onFinish() {
                waktumundur.startAnimation(blink);
                waktumundur.setText("00:00");
                txthuruf.setText("WAKTU HABIS!!!");
                jawab.setVisibility(View.INVISIBLE);
                isi.setEnabled(false);
                telolet.start();
                Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(400);
                waktu2.start();
            }
        }.start();
        waktu2 = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent un9 = new Intent(tebak_kata_9.this, level_tebak_kata.class);
                un9.putExtra("Efeksuara", allsounds);
                startActivity(un9);
                finish();
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            }
        };
        imgtimer = new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
                benarsalah.setVisibility(View.VISIBLE);
                benarsalah.startAnimation(animasi);
            }
            public void onFinish() {
                benarsalah.setVisibility(View.INVISIBLE);
            }
        };
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                audiobtn.start();
                audiobtn.setLooping(false);
                new AlertDialog.Builder(tebak_kata_9.this)
                        .setIcon(R.drawable.notificon)
                        .setTitle("Konfirmasi")
                        .setMessage("Anda yakin ingin keluar dari Tes Pengetahuan?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener(){

                            public void onClick(DialogInterface dialog, int id){
                                finish();
                                waktu.cancel();
                                imgtimer.cancel();
                                waktu2.cancel();
                                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jwbsound.start();
                Intent un9 = new Intent(tebak_kata_9.this, level_tebak_kata.class);
                unlock9 = 1;
                un9.putExtra("buka9", unlock9);
                un9.putExtra("Efeksuara", allsounds);
                startActivity(un9);
                finish();
                overridePendingTransition(R.anim.animation_enter2, R.anim.animation_leave2);
            }
        });
        txt1.setTypeface(myTypeface);
        txthuruf.setTypeface(myTypeface);
        waktumundur.setTypeface(myTypeface);
        jumlahsoal.setTypeface(myTypeface);
        slmt.setTypeface(myTypeface);
        soal.setTypeface(soalTypeface);

    }

    public void onClick(View v)
    {
        if (v==jawab) {

            isi.setTypeface(myTypeface);
            String jawabannya = isi.getText().toString();
            if (jawabannya.equalsIgnoreCase(jawaban[indeks]))
            {
                benarsalah.setImageResource(R.drawable.benar);
                imgtimer.start();
                benarsound.start();
                benarsound.setLooping(false);

                if (indeks<pertanyaan.length-1){
                    indeks++;
                    soal.setText(pertanyaan[indeks]);
                    jumlahsoal.setText(nomor[indeks]);
                    txthuruf.setText(jumlahhuruf[indeks]);
                    isi.setText("");
                } else {
                    benarsound.stop();
                    tamat.setVisibility(View.VISIBLE);
                    tamat.startAnimation(anim);
                    jawab.setClickable(false);
                    isi.setEnabled(false);
                    horeee.start();
                    imgtimer.cancel();
                    waktu.cancel();
                }
            }
            else if (jawabannya.matches(""))
            {
                jwbsound.start();
                jwbsound.setLooping(false);
                Toast.makeText(this, "Jawaban tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
            else
            {
                benarsalah.setImageResource(R.drawable.salah);
                salahsound.start();
                imgtimer.start();
                salahsound.setLooping(false);
            }
        }
    }

    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.notificon)
                .setTitle("Konfirmasi")
                .setMessage("Anda yakin ingin keluar dari Tes Pengetahuan?")
                .setCancelable(false)
                .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        finish();
                        waktu.cancel();
                        imgtimer.cancel();
                        waktu2.cancel();
                        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                    }
                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
