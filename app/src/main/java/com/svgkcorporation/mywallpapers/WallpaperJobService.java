package com.svgkcorporation.mywallpapers;

import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;

public class WallpaperJobService extends JobService {

    public Bitmap createWallpaperBitmap() {
        SharedPreferences preferences = getSharedPreferences("RGBvalues", MODE_PRIVATE);

        int height = preferences.getInt("height", 1920);
        int width = preferences.getInt("width", 1080);
        int red = preferences.getInt("RED", 126);
        int green = preferences.getInt("GREEN", 126);
        int blue = preferences.getInt("BLUE", 126);

        Bitmap bmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[height * width];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = Color.argb(255, red, green, blue);
        }

        SharedPreferences.Editor prefEditor = preferences.edit();
        blue++;
        if(blue/256 == 1)
        {
            blue = 0;
            green++;
            if(green/256 == 1)
            {
                green = 0;
                red++;
                if(red == 256)
                {
                    red = 0;
                    green = 0;
                    blue = 0;
                }
            }
        }
        prefEditor.putInt("RED",red);
        prefEditor.putInt("GREEN",green);
        prefEditor.putInt("BLUE", blue);
        prefEditor.apply();
        bmap.setPixels(pixels, 0, bmap.getWidth(), 0, 0, width, height);
        return bmap;
    }

    public void changeWallpaper() {
        WallpaperManager manager = WallpaperManager.getInstance(this);
        Bitmap bmap = createWallpaperBitmap();

        try {
            manager.setBitmap(bmap, null, true, WallpaperManager.FLAG_LOCK);
            manager.setBitmap(bmap, null, true, WallpaperManager.FLAG_SYSTEM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        changeWallpaper();

        WallpaperJobScheduler.scheduleJob(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
