package com.svgkcorporation.mywallpapers;

import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

public class WallpaperJobService extends JobService {

    private void changeWallpaper() {
        WallpaperManager manager = WallpaperManager.getInstance(this);
        SharedPreferences preferences = getSharedPreferences("RGBvalues", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = preferences.edit();
        int height = preferences.getInt("height", 1920);
        int width = preferences.getInt("width", 1080);
        int red = preferences.getInt("RED", 126);
        int green = preferences.getInt("GREEN", 126);
        int blue = preferences.getInt("BLUE", 126);
        prefEditor.putInt("BLUE", blue + 1);
        prefEditor.apply();
        Log.d("TAG", "onCreate: " + red + " " + green + " " + blue);
        Bitmap bmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[height * width];
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = Color.argb(255, red, green, blue);
        }
        bmap.setPixels(pixels, 0, bmap.getWidth(), 0, 0, width, height);

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
