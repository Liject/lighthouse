/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.WriteActivity.java
 * @brief LightHouse WriteActivity Code
 * @version 1.0.0
 * @see incomplete actvity
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }
    public void onSaveClicked(View v){
        Intent intent =new Intent(getApplicationContext(),DiarysaveActivity.class);
        startActivity(intent);
    }
}
