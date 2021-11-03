package edu.nmhu.bssd5250.kotlinjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity {

    public static String COLOR_REQUESTED_01 = "edu.nmhu.bssd5250.kotlinjavaproject.color1";
    public static String COLOR_REQUESTED_02 = "edu.nmhu.bssd5250.kotlinjavaproject.color2";
    public static String COLOR_REQUESTED_03 = "edu.nmhu.bssd5250.kotlinjavaproject.color3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        int color = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED_01));
        findViewById(R.id.main_layout).setBackgroundColor(color);
    }
}