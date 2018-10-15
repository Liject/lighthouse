/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.RegisterActivity.java
 * @brief LightHouse RegisterActivity Code
 * @version 1.0.0
 * @see Need link to backend REST API
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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        EditText idText=(EditText)findViewById(R.id.idText);
        EditText passwordText=(EditText)findViewById(R.id.passwordText);
        EditText nameText=(EditText)findViewById(R.id.nameText);
        EditText ageText=(EditText)findViewById(R.id.ageText);
        Button registerButton=(Button)findViewById(R.id.registerButton);

    }
    public void onRegisterClicked(View v){
        Intent intent=new Intent(getApplicationContext(),LogincompleteActivity.class);
        startActivity(intent);
    }
}
