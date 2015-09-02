package com.lifeline.lifelineforyou;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.lifeline.lifelineforyou.dboperation.DBLogin;
import com.lifeline.lifelineforyou.dboperation.DBLoginBean;

import java.util.ArrayList;

public class SplashScreen extends Activity {
 
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2500;
    Animation anim;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView ivlogo=(ImageView) findViewById(R.id.imgLogo);
        anim = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.slide_down);
        ivlogo.startAnimation(anim);
 
        new Handler().postDelayed(new Runnable() {
 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                DBLoginBean dbhb=new DBLoginBean("1","aas","","","");
                DBLogin dbh=new DBLogin(SplashScreen.this);
//		dbh.addHistory(dbhb);
                ArrayList<DBLoginBean> dblist=new ArrayList<DBLoginBean>();
                dblist=dbh.Get_Login();
                if(dblist.size()!=0) {
                    Intent p = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(p);
                }else {

                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    startActivity(i);
                }

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
 
}
