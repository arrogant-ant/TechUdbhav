package inc.iris.techudbhav;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView tech, udbhav,mascot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        tech = findViewById(R.id.tech);
        udbhav = findViewById(R.id.udbhav);
        mascot=findViewById(R.id.mascot);
        startAnimation();

        Thread background = new Thread() {
            public void run() {

                try {


                    // Thread will sleep for 1 seconds
                    sleep(2500);
                    Intent i = new Intent(getBaseContext(), Home.class);
                    startActivity(i);

                    //Remove activity
                    finish();


                } catch (Exception e) {

                }
            }
        };

        // start thread
        background.start();
    }

    private void startAnimation() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth= displayMetrics.widthPixels;
        int halfWidth =screenWidth/ 2;
        int techWidth = tech.getMeasuredWidth();
        int udbhavWidth = udbhav.getMeasuredWidth();

        ObjectAnimator techAnimator = ObjectAnimator.ofFloat(tech, View.TRANSLATION_X, 0, halfWidth - techWidth);
        techAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        techAnimator.setDuration(2000);

        ObjectAnimator udbhavAnimator = ObjectAnimator.ofFloat(udbhav, View.TRANSLATION_X,screenWidth , -halfWidth);
        udbhavAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        udbhavAnimator.setDuration(2000);

        ObjectAnimator mascotAnimatorX=ObjectAnimator.ofFloat(mascot,View.SCALE_X,1,0.5f);
        mascotAnimatorX.setInterpolator(new DecelerateInterpolator());
        mascotAnimatorX.setDuration(2000);

        ObjectAnimator mascotAnimatorY=ObjectAnimator.ofFloat(mascot,View.SCALE_Y,1,0.5f);
        mascotAnimatorY.setInterpolator(new DecelerateInterpolator());
        mascotAnimatorY.setDuration(2000);

        AnimatorSet set=new AnimatorSet();
        set.play(techAnimator).with(udbhavAnimator).with(mascotAnimatorX).with(mascotAnimatorY);
        set.start();
    }
}
