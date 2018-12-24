package efpappstudy.teslogikapengetahuan;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class level_tebak_kata extends Activity {

    Button lvl1,lvl2,lvl3,lvl4,lvl5,lvl6,lvl7,lvl8,lvl9,lvl10,resetlvl;
    SharedPreferences prefs, lan1, lan2, lan3, lan4, lan5, lan6, lan7, lan8, lan9;
    int unlevel2, unlevels, unlevel3, unlevel4, unlevel5, unlevel6, unlevel7, unlevel8, unlevel9, unlevel10;
    int levels = 0;
    int lanjut1, lanjut2, lanjut3, lanjut4, lanjut5, lanjut6, lanjut7, lanjut8, lanjut9;
    int suara1, suara2, suara3, suara4, suara5, suara6, suara7, suara8, suara9, suara10, allsounds;
    Animation getar;
    Typeface myfont;
    MediaPlayer soundbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_tebak_kata);
        getar = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shake2);
        myfont = Typeface.createFromAsset(getAssets(), "static.otf");
        AdView adView = (AdView)findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        soundbtn = MediaPlayer.create(this, R.raw.btn_menu);
        Intent i = getIntent();
        allsounds = i.getIntExtra("Efeksuara", 0);

        if (allsounds == 1){
            soundbtn.setVolume(0, 0);
        } else {
            soundbtn.setVolume(1, 1);
        }
        lvl1 = (Button)findViewById(R.id.level1);
        lvl2 = (Button)findViewById(R.id.level2);
        lvl3 = (Button)findViewById(R.id.level3);
        lvl4 = (Button)findViewById(R.id.level4);
        lvl5 = (Button)findViewById(R.id.level5);
        lvl6 = (Button)findViewById(R.id.level6);
        lvl7 = (Button)findViewById(R.id.level7);
        lvl8 = (Button)findViewById(R.id.level8);
        lvl9 = (Button)findViewById(R.id.level9);
        lvl10 = (Button)findViewById(R.id.level10);
        Intent un1 = getIntent();
        Intent un2 = getIntent();
        Intent un3 = getIntent();
        Intent un4 = getIntent();
        Intent un5 = getIntent();
        Intent un6 = getIntent();
        Intent un7 = getIntent();
        Intent un8 = getIntent();
        Intent un9 = getIntent();
        unlevel2 = un1.getIntExtra("buka1", 0);
        unlevel3 = un2.getIntExtra("buka2", 0);
        unlevel4 = un3.getIntExtra("buka3", 0);
        unlevel5 = un4.getIntExtra("buka4", 0);
        unlevel6 = un5.getIntExtra("buka5", 0);
        unlevel7 = un6.getIntExtra("buka6", 0);
        unlevel8 = un7.getIntExtra("buka7", 0);
        unlevel9 = un8.getIntExtra("buka8", 0);
        unlevel10 = un9.getIntExtra("buka9", 0);
        suara1 = un1.getIntExtra("Efeksuara", allsounds);
        suara2 = un1.getIntExtra("Efeksuara", allsounds);
        suara3 = un1.getIntExtra("Efeksuara", allsounds);
        suara4 = un1.getIntExtra("Efeksuara", allsounds);
        suara5 = un1.getIntExtra("Efeksuara", allsounds);
        suara6 = un1.getIntExtra("Efeksuara", allsounds);
        suara7 = un1.getIntExtra("Efeksuara", allsounds);
        suara8 = un1.getIntExtra("Efeksuara", allsounds);
        suara9 = un1.getIntExtra("Efeksuara", allsounds);
        suara10 = un1.getIntExtra("Efeksuara", allsounds);
        prefs = this.getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        lan1 = this.getSharedPreferences("myPrefs1", Context.MODE_PRIVATE);
        lan2 = this.getSharedPreferences("myPrefs2", Context.MODE_PRIVATE);
        lan3 = this.getSharedPreferences("myPrefs3", Context.MODE_PRIVATE);
        lan4 = this.getSharedPreferences("myPrefs4", Context.MODE_PRIVATE);
        lan5 = this.getSharedPreferences("myPrefs5", Context.MODE_PRIVATE);
        lan6 = this.getSharedPreferences("myPrefs6", Context.MODE_PRIVATE);
        lan7 = this.getSharedPreferences("myPrefs7", Context.MODE_PRIVATE);
        lan8 = this.getSharedPreferences("myPrefs8", Context.MODE_PRIVATE);
        lan9 = this.getSharedPreferences("myPrefs9", Context.MODE_PRIVATE);
        unlevels = prefs.getInt("unlvl", 0);
        lanjut1 = lan1.getInt("l1", 0);
        lanjut2 = lan2.getInt("l2", 0);
        lanjut3 = lan3.getInt("l3", 0);
        lanjut4 = lan4.getInt("l4", 0);
        lanjut5 = lan5.getInt("l5", 0);
        lanjut6 = lan6.getInt("l6", 0);
        lanjut7 = lan7.getInt("l7", 0);
        lanjut8 = lan8.getInt("l8", 0);
        lanjut9 = lan9.getInt("l9", 0);

        if (levels == 0 || unlevels == 0) {
            lvl2.setEnabled(false);
            lvl2.setBackgroundResource(R.drawable.terkunci);
            lvl3.setEnabled(false);
            lvl3.setBackgroundResource(R.drawable.terkunci);
            lvl4.setEnabled(false);
            lvl4.setBackgroundResource(R.drawable.terkunci);
            lvl5.setEnabled(false);
            lvl5.setBackgroundResource(R.drawable.terkunci);
            lvl6.setEnabled(false);
            lvl6.setBackgroundResource(R.drawable.terkunci);
            lvl7.setEnabled(false);
            lvl7.setBackgroundResource(R.drawable.terkunci);
            lvl8.setEnabled(false);
            lvl8.setBackgroundResource(R.drawable.terkunci);
            lvl9.setEnabled(false);
            lvl9.setBackgroundResource(R.drawable.terkunci);
            lvl10.setEnabled(false);
            lvl10.setBackgroundResource(R.drawable.terkunci);
        }
        if (unlevel2 == 1) {
            unlevels = 1;
            lanjut1 = 10;
            lvl2.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan1.edit().putInt("l1", lanjut1).commit();
        }
        if (unlevel3 == 1) {
            unlevels = 2;
            lanjut2 = 10;
            lvl3.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan2.edit().putInt("l2", lanjut2).commit();
        }
        if (unlevel4 == 1) {
            unlevels = 3;
            lanjut3 = 10;
            lvl4.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan3.edit().putInt("l3", lanjut3).commit();
        }
        if (unlevel5 == 1) {
            unlevels = 4;
            lanjut4 = 10;
            lvl5.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan4.edit().putInt("l4", lanjut4).commit();
        }
        if (unlevel6 == 1) {
            unlevels = 5;
            lanjut5 = 10;
            lvl6.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan5.edit().putInt("l5", lanjut5).commit();
        }
        if (unlevel7 == 1) {
            unlevels = 6;
            lanjut6 = 10;
            lvl7.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan6.edit().putInt("l6", lanjut6).commit();
        }
        if (unlevel8 == 1) {
            unlevels = 7;
            lanjut7 = 10;
            lvl8.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan7.edit().putInt("l7", lanjut7).commit();
        }
        if (unlevel9 == 1) {
            unlevels = 8;
            lanjut8 = 10;
            lvl9.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan8.edit().putInt("l8", lanjut8).commit();
        }
        if (unlevel10 == 1) {
            unlevels = 9;
            lanjut9 = 10;
            lvl10.setEnabled(true);
            prefs.edit().putInt("unlvl", unlevels).commit();
            lan9.edit().putInt("l9", lanjut9).commit();
        }

        if (unlevels==1 || lanjut1 == 10) {
            lvl2.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
        }
        if (unlevels==2 || lanjut2 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
        }
        if (unlevels==3 || lanjut3 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
        }
        if (unlevels==4 || lanjut4 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
        }
        if (unlevels==5 || lanjut5 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl6.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
            lvl6.setBackgroundResource(R.drawable.btn_tp_6);
        }
        if (unlevels==6 || lanjut6 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl6.setEnabled(true);
            lvl7.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
            lvl6.setBackgroundResource(R.drawable.btn_tp_6);
            lvl7.setBackgroundResource(R.drawable.btn_tp_7);
        }
        if (unlevels==7 || lanjut7 == 10) {
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl6.setEnabled(true);
            lvl7.setEnabled(true);
            lvl8.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
            lvl6.setBackgroundResource(R.drawable.btn_tp_6);
            lvl7.setBackgroundResource(R.drawable.btn_tp_7);
            lvl8.setBackgroundResource(R.drawable.btn_tp_8);
        }
        if (unlevels==8 || lanjut8 == 10) {
            lanjut8 = 10;
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl6.setEnabled(true);
            lvl7.setEnabled(true);
            lvl8.setEnabled(true);
            lvl9.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
            lvl6.setBackgroundResource(R.drawable.btn_tp_6);
            lvl7.setBackgroundResource(R.drawable.btn_tp_7);
            lvl8.setBackgroundResource(R.drawable.btn_tp_8);
            lvl9.setBackgroundResource(R.drawable.btn_tp_9);
        }
        if (unlevels==9 || lanjut9 == 10) {
            lanjut9 = 10;
            lvl2.setEnabled(true);
            lvl3.setEnabled(true);
            lvl4.setEnabled(true);
            lvl5.setEnabled(true);
            lvl6.setEnabled(true);
            lvl7.setEnabled(true);
            lvl8.setEnabled(true);
            lvl9.setEnabled(true);
            lvl10.setEnabled(true);
            lvl2.setBackgroundResource(R.drawable.btn_tp_2);
            lvl3.setBackgroundResource(R.drawable.btn_tp_3);
            lvl4.setBackgroundResource(R.drawable.btn_tp_4);
            lvl5.setBackgroundResource(R.drawable.btn_tp_5);
            lvl6.setBackgroundResource(R.drawable.btn_tp_6);
            lvl7.setBackgroundResource(R.drawable.btn_tp_7);
            lvl8.setBackgroundResource(R.drawable.btn_tp_8);
            lvl9.setBackgroundResource(R.drawable.btn_tp_9);
            lvl10.setBackgroundResource(R.drawable.btn_tp_10);
        }

        resetlvl = (Button)findViewById(R.id.resetlevel);
        resetlvl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                soundbtn.setLooping(false);
                new AlertDialog.Builder(level_tebak_kata.this)
                        .setIcon(R.drawable.notificon)
                        .setTitle("Konfirmasi")
                        .setMessage("Semua level akan terkunci kembali. Lanjutkan?")
                        .setCancelable(false)
                        .setPositiveButton("Iya", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){
                                unlevels = 0;
                                lanjut1 = 0;
                                lanjut2 = 0;
                                lanjut3 = 0;
                                lanjut4 = 0;
                                lanjut5 = 0;
                                lanjut6 = 0;
                                lanjut7 = 0;
                                lanjut8 = 0;
                                lanjut9 = 0;
                                lvl1.startAnimation(getar);
                                lvl2.setEnabled(false);
                                lvl2.startAnimation(getar);
                                lvl2.setBackgroundResource(R.drawable.terkunci);
                                lvl3.setEnabled(false);
                                lvl3.startAnimation(getar);
                                lvl3.setBackgroundResource(R.drawable.terkunci);
                                lvl4.setEnabled(false);
                                lvl4.startAnimation(getar);
                                lvl4.setBackgroundResource(R.drawable.terkunci);
                                lvl5.setEnabled(false);
                                lvl5.startAnimation(getar);
                                lvl5.setBackgroundResource(R.drawable.terkunci);
                                lvl6.setEnabled(false);
                                lvl6.startAnimation(getar);
                                lvl6.setBackgroundResource(R.drawable.terkunci);
                                lvl7.setEnabled(false);
                                lvl7.startAnimation(getar);
                                lvl7.setBackgroundResource(R.drawable.terkunci);
                                lvl8.setEnabled(false);
                                lvl8.startAnimation(getar);
                                lvl8.setBackgroundResource(R.drawable.terkunci);
                                lvl9.setEnabled(false);
                                lvl9.startAnimation(getar);
                                lvl9.setBackgroundResource(R.drawable.terkunci);
                                lvl10.setEnabled(false);
                                lvl10.startAnimation(getar);
                                lvl10.setBackgroundResource(R.drawable.terkunci);
                                prefs.edit().putInt("unlvl", unlevels).commit();
                                lan1.edit().putInt("l1", lanjut1).commit();
                                lan2.edit().putInt("l2", lanjut2).commit();
                                lan3.edit().putInt("l3", lanjut3).commit();
                                lan4.edit().putInt("l4", lanjut4).commit();
                                lan5.edit().putInt("l5", lanjut5).commit();
                                lan6.edit().putInt("l6", lanjut6).commit();
                                lan7.edit().putInt("l7", lanjut7).commit();
                                lan8.edit().putInt("l8", lanjut8).commit();
                                lan9.edit().putInt("l9", lanjut9).commit();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
            }
        });
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level1 = new Intent(level_tebak_kata.this, tebak_kata.class);
                level1.putExtra("Efeksuara", allsounds);
                startActivity(level1);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level2 = new Intent(level_tebak_kata.this, tebak_kata_2.class);
                level2.putExtra("Efeksuara", allsounds);
                startActivity(level2);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level3 = new Intent(level_tebak_kata.this, tebak_kata_3.class);
                level3.putExtra("Efeksuara", allsounds);
                startActivity(level3);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level4 = new Intent(level_tebak_kata.this, tebak_kata_4.class);
                level4.putExtra("Efeksuara", allsounds);
                startActivity(level4);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level5 = new Intent(level_tebak_kata.this, tebak_kata_5.class);
                level5.putExtra("Efeksuara", allsounds);
                startActivity(level5);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level6 = new Intent(level_tebak_kata.this, tebak_kata_6.class);
                level6.putExtra("Efeksuara", allsounds);
                startActivity(level6);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level7 = new Intent(level_tebak_kata.this, tebak_kata_7.class);
                level7.putExtra("Efeksuara", allsounds);
                startActivity(level7);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level8 = new Intent(level_tebak_kata.this, tebak_kata_8.class);
                level8.putExtra("Efeksuara", allsounds);
                startActivity(level8);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level9 = new Intent(level_tebak_kata.this, tebak_kata_9.class);
                level9.putExtra("Efeksuara", allsounds);
                startActivity(level9);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
        lvl10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundbtn.start();
                Intent level10 = new Intent(level_tebak_kata.this, tebak_kata_10.class);
                level10.putExtra("Efeksuara", allsounds);
                startActivity(level10);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                finish();
            }
        });
    }
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
