package efpappstudy.teslogikapengetahuan;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class tentangapk extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentangapk);
        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "static.otf");
        AdView adView = (AdView)findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
    }
}
