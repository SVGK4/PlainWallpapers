package com.svgkcorporation.mywallpapers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
          // start service here
//        Intent i = new Intent(context,WallpaperService.class);
//        context.startService(i);
        WallpaperJobScheduler.scheduleJob(context);
    }
}
