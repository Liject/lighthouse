/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.InformationActivity.java
 * @brief LightHouse InformationActivity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    }
    public void onNetworkClicked(View v){
        Intent intent=new Intent(getApplicationContext(),Information2Activity.class);
        startActivity(intent);
    }
    public void onBackClicked(View v){
        Intent intent =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
