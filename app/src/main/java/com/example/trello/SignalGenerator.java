package com.example.trello;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;


public class SignalGenerator {
    private static SignalGenerator instance = null;
    private final Context context;
    private final Vibrator vibrator;
    private MediaPlayer mediaPlayer;


    private SignalGenerator(Context context) {
        this.context = context;
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);


    }


    public static void init(Context context) {
        if (instance == null) {
            instance = new SignalGenerator(context);
        }
    }


    public static SignalGenerator getInstance() {
        if (instance == null) {
            throw new IllegalStateException("SignalGenerator is not initialized. Call init() first.");
        }
        return instance;
    }


    public void toast(String text, int length) {
        Toast.makeText(context, text, length).show();
    }


    public void vibrate(long length) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(length, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {

            vibrator.vibrate(length);
        }
    }


}
