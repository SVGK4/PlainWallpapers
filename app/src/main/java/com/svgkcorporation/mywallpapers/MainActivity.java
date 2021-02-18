package com.svgkcorporation.mywallpapers;

import android.app.job.JobScheduler;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
            prefEditor.apply();
        }

        Button start,stop;
        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);



        start.setOnClickListener(view -> {
            WallpaperJobScheduler.scheduleJob(getApplicationContext());
        });

        stop.setOnClickListener(view -> {
            JobScheduler scheduler = (JobScheduler)this.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            if(scheduler.getPendingJob(99999) != null)
            {
                scheduler.cancel(99999);
            }
            
        });

    }
}