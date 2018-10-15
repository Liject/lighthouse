/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.SplashActivity.java
 * @brief LightHouse SplashActivity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SpalshActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
