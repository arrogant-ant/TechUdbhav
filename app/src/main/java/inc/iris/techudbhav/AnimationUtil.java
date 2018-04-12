package inc.iris.techudbhav;

/**
 * Created by Nischaypc on 4/4/2018.
 */

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;

public class AnimationUtil {

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {


        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 200 : -200, 0);
        animatorTranslateY.setDuration(1200);


        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50, 50, -30, 30, -20, 20, -5, 5, 0);
        animatorTranslateX.setDuration(1200);

        animatorSet.playTogether(animatorTranslateX, animatorTranslateY);

        //animatorSet.playTogether(animatorTranslateY);
        animatorSet.start();

    }

    public static void animateButton(View button) {
        ObjectAnimator buttonAnimatorX = ObjectAnimator.ofFloat(button, View.SCALE_X, 0.5f, 1);
        buttonAnimatorX.setInterpolator(new DecelerateInterpolator());
        buttonAnimatorX.setDuration(500);
        buttonAnimatorX.reverse();

        ObjectAnimator buttonAnimatorY = ObjectAnimator.ofFloat(button, View.SCALE_Y, 0.5f, 1);
        buttonAnimatorY.setInterpolator(new DecelerateInterpolator());
        buttonAnimatorY.setDuration(500)
                .reverse();

        AnimatorSet set = new AnimatorSet();
        set.play(buttonAnimatorX).with(buttonAnimatorY);
        set.start();

    }
}