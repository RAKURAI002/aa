package com.rakurai.howfastareyou;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, Void> {
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;
    private WeakReference<ImageView> mClickme;
    private WeakReference<Button> mStart;

    SimpleAsyncTask(TextView tv, Button Start, ImageView Clickme, ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar = new WeakReference<>(pb);
        mClickme = new WeakReference<>(Clickme);
        mStart = new WeakReference<>(Start);
    }

    @Override
    protected Void doInBackground(Void... voids) {

        // Sleep for the random amount of time
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                publishProgress(i*100/10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
//        mTextView.get().setText("Remaining..." + Integer.toString(values[0]) + " milliseconds");
        mProgressBar.get().setProgress(values[0]);
    }

    protected void onPostExecute(Void result) {
        mProgressBar.get().setProgress(100);
        mClickme.get().setVisibility(View.INVISIBLE);
        mStart.get().setVisibility(View.VISIBLE);
    }
}
