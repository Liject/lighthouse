/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.LogincompleteActivity.java
 * @brief LightHouse LogincompleteActivity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LogincompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincomplete);

        EditText idText=(EditText)findViewById(R.id.idText);
        EditText passwordText=(EditText)findViewById(R.id.passwordText);
        TextView welcomeMessage=(TextView)findViewById(R.id.welcomeMessage);
    }
    public void onBackClicked(View v){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
