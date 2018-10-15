/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.LoginActivity.java
 * @brief LightHouse LoginActivity Code
 * @version 1.0.0
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText idText=(EditText)findViewById(R.id.idText);
        EditText passwordText=(EditText)findViewById(R.id.passwordText);
        Button loginButton=(Button)findViewById(R.id.loginButton);
        TextView registerButton=(TextView)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent registerIntent=new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }
        });
    }
}
