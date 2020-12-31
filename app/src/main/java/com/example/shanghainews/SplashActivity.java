package com.example.shanghainews;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class SplashActivity extends Activity {
    private RelativeLayout rl_splash_root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root=findViewById(R.id.rl_splash_root);
        //渐变动画、缩放动画、旋转动画
        AlphaAnimation aa=new AlphaAnimation(0,1);
        aa.setDuration(500);//持续播放时间
        aa.setFillAfter(true);
        ScaleAnimation sa=new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(500);
        sa.setFillAfter(true);
        RotateAnimation ra=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet as=new AnimationSet(false);
        //添加三个旋转动画，没有顺序
        as.addAnimation(ra);
        as.addAnimation(sa);
        as.addAnimation(aa);
        as.setDuration(2000);
        rl_splash_root.startAnimation(as);

        as.setAnimationListener(new MyAnimational());
    }
    class MyAnimational implements Animation.AnimationListener{
        /**
         * 当动画开始播放的时候
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         * 当动画播放结束的时候
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {
            Toast.makeText(SplashActivity.this,"动画播放完成",Toast.LENGTH_SHORT).show();
        }
        /**
         * 当动画播放重复的时候
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
