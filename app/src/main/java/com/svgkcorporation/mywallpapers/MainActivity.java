package com.svgkcorporation.mywallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getPreferences(MODE_PRIVATE);

        if( !sharedPreferences.contains("RED") ) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putInt("RED", 0);
            prefEditor.putInt("GREEN", 0);
            prefEditor.putInt("BLUE", 0);
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