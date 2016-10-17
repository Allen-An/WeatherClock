package com.allen.weatherclock.activities;

import android.animation.FloatEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.allen.weatherclock.MainActivity;
import com.allen.weatherclock.R;
import com.allen.weatherclock.utils.CommonUtils;

/**
 * Created by Allen on 2016/10/17.
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!this.isTaskRoot()) {
            Intent mainIntent = getIntent();
            String action = mainIntent.getAction();
            if (mainIntent.hasCategory(Intent.CATEGORY_LAUNCHER) && action.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }

        overridePendingTransition(R.anim.zoomin, 0);
        setContentView(R.layout.activity_splash);
        CommonUtils.setStatusBarTranslucent(this);
        startAnimation();
    }

    private void startAnimation() {
        final View splashView = findViewById(R.id.iv_splash);
        ValueAnimator animator = ValueAnimator.ofObject(new FloatEvaluator(), 1.0f, 1.2f);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float) valueAnimator.getAnimatedValue();
                if (value < 1.2f) {
                    splashView.setScaleX(value);
                    splashView.setScaleY(value);
                } else {
                    CommonUtils.startActivity(SplashActivity.this, MainActivity.class);
                    overridePendingTransition(0, android.R.anim.fade_out);
                    finish();
                }
            }
        });
        animator.start();
    }

}
