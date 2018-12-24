package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class splash_screens extends Activity {
    CountDownTimer splasher;
    ImageView iv;

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screens);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anims = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anims.reset();
        RelativeLayout l=(RelativeLayout) findViewById(R.id.vander);
        l.clearAnimation();
        l.startAnimation(anims);
        iv = (ImageView) findViewById(R.id.splash);
        iv.setVisibility(View.INVISIBLE);

        splasher = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                Animation anim = AnimationUtils.loadAnimation(splash_screens.this, R.anim.bounce2);
                anim.reset();
                BounceInterpolator interpolator = new BounceInterpolator(0.2, 20);
                anim.setInterpolator(interpolator);
                iv.setVisibility(View.VISIBLE);
                iv.clearAnimation();
                iv.startAnimation(anim);
            }
        }.start();

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(splash_screens.this,
                            menu_utama.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    splash_screens.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    splash_screens.this.finish();
                }

            }
        };
        splashTread.start();

    }
}
