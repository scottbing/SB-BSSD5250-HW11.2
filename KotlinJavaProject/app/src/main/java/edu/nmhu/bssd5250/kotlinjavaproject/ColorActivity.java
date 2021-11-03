package edu.nmhu.bssd5250.kotlinjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

public class ColorActivity extends AppCompatActivity {

    public static String COLOR_REQUESTED = "edu.nmhu.bssd5250.kotlinjavaproject.color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        int color = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED));
        findViewById(R.id.main_layout).setBackgroundColor(color);
    }
}