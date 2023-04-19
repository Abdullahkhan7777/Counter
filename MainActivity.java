package com.example.tasbeeh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a= 1;
    String string;
    String get;
    int put;
    int empty = 0;
    String show;
    ImageView imageView;
    SharedPreferences sharedPreferences;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.click);
        TextView tv = findViewById(R.id.showntext);
        Button reset = findViewById(R.id.resetbtn);
        imageView=findViewById(R.id.power);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                get = sharedPreferences.getString("hello", "");
                tv.setText(get);
                empty = Integer.valueOf(get);
                onnn();

            }
        });

        get = sharedPreferences.getString("hello", "");
        tv.setText(get);

        SharedPreferences prffff = getSharedPreferences("prefss", MODE_PRIVATE);
        boolean firstStart = prffff.getBoolean("firstStart", true);
        if (firstStart){
            firststart();
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("hello", "1");
                editor.apply();
                tv.setText("0");
            }
        });

    }
    private void onnn(){
        a = empty+1;
        string = String.valueOf(a);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hello", string);
        editor.apply();
    }
    private void firststart(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("hello", "1");
        editor.apply();

        SharedPreferences prefss = getSharedPreferences("prefss", MODE_PRIVATE);
        SharedPreferences.Editor et = prefss.edit();
        et.putBoolean("firstStart", false);
        et.apply();
    }
}