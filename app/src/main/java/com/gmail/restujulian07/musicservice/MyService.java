package com.gmail.restujulian07.musicservice;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer mediaPlayer;
    Vibrator getar;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(this, R.raw.perfect);
        mediaPlayer.setLooping(true);

        getar = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (getar != null) {
            getar.vibrate(10000);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        getar.cancel();
        mediaPlayer.stop();
    }
}