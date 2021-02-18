package com.svgkcorporation.mywallpapers;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

class WallpaperJobScheduler {
    public static void scheduleJob(Context context) {
        ComponentName service = new ComponentName(context, WallpaperJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(99999, service);
        builder.setMinimumLatency(15*60*1000);
        builder.setOverrideDeadline(10*1000);
        JobScheduler scheduler = context.getSystemService(JobScheduler.class);
        scheduler.schedule(builder.build());
    }
}
