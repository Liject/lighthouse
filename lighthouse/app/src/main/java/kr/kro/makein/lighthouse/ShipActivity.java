/* Copyright (C) MakeIN <http://www.makein.kro.kr> */

/**
 * @auther MakeIN (hyeokju1313@newsecu.kr)
 * @file app.java.kr.kro.makein.lighthouse.ShipActivity.java
 * @brief LightHouse ShipActivity Code
 * @version 1.0.0
 * @see spinner has critical error
 *
 * GitHub PAGE <https://github.com/Team-Makein/Lighthouse>
 */

package kr.kro.makein.lighthouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ShipActivity extends AppCompatActivity {
    ArrayAdapter<CharSequence> adspin1, adspin2;
    String choice_first = "";
    String choice_second = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship);
        // Init
        Log.e("MyApps","@Info: Init...");
        final Spinner spin1 = findViewById(R.id.spinner1);
        final Spinner spin2 = findViewById(R.id.spinner2);
        Button btn_refresh = findViewById(R.id.btn_refresh);
        Log.e("MyApps","Info: Successful!");
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spiner_inter, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //here
        Log.e("MyApps","Info: Set commit");
            spin1.setAdapter(adspin1);
            /*
            Log.e("MyApps","Info: Adapter set finally!");
            spin1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (adspin1.getItem(position).equals("문과")) {
                        choice_first = "문과";
                        adspin2 = ArrayAdapter.createFromResource(ShipActivity.this, R.array.spiner_inter1, android.R.layout.simple_spinner_dropdown_item);
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                choice_second = adspin2.getItem(position).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    } else if (adspin1.getItem(position).equals("이과")) {
                        choice_first = "이과";
                        adspin2 = ArrayAdapter.createFromResource(ShipActivity.this, R.array.spiner_inter2, android.R.layout.simple_spinner_dropdown_item);
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                choice_second = adspin2.getItem(position).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    } else if (adspin1.getItem(position).equals("예체능")) {
                        choice_first = "예체능";
                        adspin2 = ArrayAdapter.createFromResource(ShipActivity.this, R.array.spiner_inter3, android.R.layout.simple_spinner_dropdown_item);
                        adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spin2.setAdapter(adspin2);
                        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                choice_second = adspin2.getItem(position).toString();
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });
                    }
                }
            });
*/
        btn_refresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(ShipActivity.this,choice_first+"->"+choice_second,Toast.LENGTH_SHORT).show();
            }
        });
    }
}