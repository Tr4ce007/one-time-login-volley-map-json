package com.hs.maplist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

// AIzaSyC16RXIlmWkG-etGu_tbISrBkpiS6UA8UM

public class MainActivity extends AppCompatActivity {

    private static final String appPrefList = "maplist";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences retrievePrefData = getSharedPreferences(appPrefList,MODE_PRIVATE);
        String curr_user = retrievePrefData.getString("user","no_user_exist");
        if(curr_user == "no_user_exist"){
            Intent i = new Intent(MainActivity.this,login_activity.class);
            startActivity(i);
            finish();
        }else{
            Intent i = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(i);
            finish();
        }
    }
}