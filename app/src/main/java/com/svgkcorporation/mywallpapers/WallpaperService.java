package com.svgkcorporation.mywallpapers;

import android.app.Service;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.IBinder;
import android.preference.PreferenceManager;

import java.io.IOException;

import androidx.annotation.Nullable;

public class WallpaperService extends Service {

    private Context context;

    public WallpaperService(Context context)
    {
        this.context = context;
    }

    public WallpaperService(){}

    @Override
    public void onCreate() {
        super.onCreate();
        WallpaperManager manager = WallpaperManager.getInstance(context);
        SharedPreferences preferences = getSharedPreferences("RGBvalues",MODE_PRIVATE);
        int height = preferences.getInt("height",1920);
        int width = preferences.getInt("width",1080);
        int red = preferences.getInt("RED",126);
        int green = preferences.getInt("GREEN",126);
        int blue = preferences.getInt("BLUE",126);
        Bitmap bmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        int[] pixels = new int[height*width];
        for (int i = 0 ; i < pixels.length ; i++)
        {
            pixels[i] = Color.argb(255,red,green,blue);
        }
        bmap.setPixels(pixels,0,bmap.getWidth(),0,0,width,height);

        try {
            manager.setBitmap(bmap,null,true,WallpaperManager.FLAG_LOCK);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
