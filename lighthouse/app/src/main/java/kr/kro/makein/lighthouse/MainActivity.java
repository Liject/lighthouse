/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.MainActivity.java
 * @brief LightHouse MainActivity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onShipClicked(View v){
        Intent intent=new Intent(getApplicationContext(),ShipActivity.class);
        startActivity(intent);
    }
    public void onDiaryClicked(View v){
        Intent intent=new Intent(getApplicationContext(),DiaryActivity.class);
        startActivity(intent);
    }
    public void onCompassClicked(View v){
        Intent intent=new Intent(getApplicationContext(),Compass2Activity.class);
        startActivity(intent);
    }
    public void onInformationClicked(View v){
        Intent intent=new Intent(getApplicationContext(),InformationActivity.class);
        startActivity(intent);
    }
    public void onLoginClicked(View v){
        Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
