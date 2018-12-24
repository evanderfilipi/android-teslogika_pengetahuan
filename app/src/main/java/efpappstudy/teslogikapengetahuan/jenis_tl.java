package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class jenis_tl extends Activity {
    Typeface myfont;
    MediaPlayer press;
    Button menu1, menu2, menu3;
    Animation blinks;
    int allsounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_tl);
        menu1 = (Button) findViewById(R.id.tg);
        menu2 = (Button) findViewById(R.id.tp);
        menu3 = (Button) findViewById(R.id.tw);
        blinks = new AlphaAnimation(0.0f,1.0f);
        blinks.setDuration(80);
        blinks.setStartOffset(20);
        blinks.setRepeatMode(Animation.REVERSE);
        blinks.setRepeatCount(2);
        myfont = Typeface.createFromAsset(getAssets(), "static.otf");
        AdView adView = (AdView)findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        press = MediaPlayer.create(this, R.raw.btn_menu);
        Intent i = getIntent();
        allsounds = i.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            press.setVolume(0, 0);
        } else {
            press.setVolume(1, 1);
        }

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent (jenis_tl.this, tes_gambar_6p.class);
                a.putExtra("Efeksuara", allsounds);
                press.start();
                press.setLooping(false);
                startActivity(a);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(jenis_tl.this, pertanyaan_4p.class);
                b.putExtra("Efeksuara", allsounds);
                press.start();
                press.setLooping(false);
                startActivity(b);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c = new Intent(jenis_tl.this, tes_warna.class);
                c.putExtra("Efeksuara", allsounds);
                press.start();
                press.setLooping(false);
                startActivity(c);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
