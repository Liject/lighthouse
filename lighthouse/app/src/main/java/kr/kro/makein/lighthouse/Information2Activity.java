/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.Information2Activity.java
 * @brief LightHouse Information2Activity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Information2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information2);
    }
    public void onSystemClicked(View v){
        Intent intent=new Intent(getApplicationContext(),Information3Activity.class);
        startActivity(intent);
    }
    public void onBackClicked(View v){
        Intent intent =new Intent(getApplicationContext(),InformationActivity.class);
        startActivity(intent);
    }
}
