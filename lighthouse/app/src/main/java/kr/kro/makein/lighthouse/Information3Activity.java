/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.Information3Activity.java
 * @brief LightHouse Information3Activity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Information3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information3);
    }
    public void onNetworkClicked(View v){
        Intent intent =new Intent(getApplicationContext(),Information2Activity.class);
        startActivity(intent);
    }
    public void onBackClicked(View v){
        Intent intent =new Intent(getApplicationContext(),InformationActivity.class);
        startActivity(intent);
    }
}
