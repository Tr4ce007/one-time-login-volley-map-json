package com.hs.maplist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login_activity extends AppCompatActivity {

    private static final String appPrefList = "maplist";

    private TextView user;
    private TextView pass;
    private EditText user_name;
    private EditText pass_word;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);

        user_name = findViewById(R.id.usernameedttxt);
        pass_word = findViewById(R.id.passwordedttxt);
        login_btn = findViewById(R.id.loginbtn);
        user      = findViewById(R.id.textView2);
        pass      = findViewById(R.id.textView3);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String new_user = user_name.getText().toString();

                if(!new_user.isEmpty()) {
                    SharedPreferences setPrefData = getSharedPreferences(appPrefList, MODE_PRIVATE);
                    SharedPreferences.Editor editor = setPrefData.edit();
                    editor.putString("user", new_user);
                    editor.apply();

                    Intent i = new Intent(login_activity.this, MapsActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

    }
}