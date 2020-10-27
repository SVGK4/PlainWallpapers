package com.svgkcorporation.mywallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("RGBvalues",MODE_PRIVATE);

        if( !sharedPreferences.contains("RED") ) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putInt("RED", 0);
            prefEditor.putInt("GREEN", 0);
            prefEditor.putInt("BLUE", 0);
            int width = Resources.getSystem().getDisplayMetrics().widthPixels;
            int height = Resources.getSystem().getDisplayMetrics().heightPixels;
            prefEditor.putInt("height",height);
            prefEditor.putInt("width",width);
            prefEditor.commit();
        }

        Button previous,next;
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}