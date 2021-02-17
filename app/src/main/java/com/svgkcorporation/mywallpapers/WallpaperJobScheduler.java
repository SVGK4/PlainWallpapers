package com.svgkcorporation.mywallpapers;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

class WallpaperJobScheduler {
    public static void scheduleJob(Context context) {
        ComponentName service = new ComponentName(context, WallpaperJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(99999, service);
        builder.setMinimumLatency(5000);
        builder.setOverrideDeadline(5000);
        JobScheduler scheduler = context.getSystemService(JobScheduler.class);
        scheduler.schedule(builder.build());
    }
}
