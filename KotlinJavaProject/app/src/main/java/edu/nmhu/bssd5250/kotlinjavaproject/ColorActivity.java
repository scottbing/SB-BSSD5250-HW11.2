package edu.nmhu.bssd5250.kotlinjavaproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ColorActivity extends AppCompatActivity {

    public static String COLOR_REQUESTED = "edu.nmhu.bssd5250.kotlinjavaproject.color";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        Intent intent = getIntent();
        int color = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED));

        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(this);
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayoutCompat.setLayoutParams(layoutParams);
        linearLayoutCompat.setOrientation(LinearLayoutCompat.HORIZONTAL);

        float[] hsvColor = new float[3]; // will hold h, s,  and v values
        //convert rgb to hsv
        Color.RGBToHSV(Color.red(color), Color.green(color), Color.blue(color), hsvColor);

        View v = null;
        LinearLayoutCompat.LayoutParams lp = new LinearLayoutCompat.LayoutParams(
                0, 500, 1);
        for(int i=0; i<4; i++) {
            v = new View(this);
            v.setLayoutParams((lp));
            hsvColor[2] = (float) (i * 0.5);
            //change hsv back to rgb to disaply it
            v.setBackgroundColor(color);
            linearLayoutCompat.addView(v);
        }

        ConstraintLayout constraintLayout = findViewById(R.id.main_layout);
        constraintLayout.addView(linearLayoutCompat);
    }
}