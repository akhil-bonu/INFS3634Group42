package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity {

    private static final String TAG = "YoutubeActivity";
    YouTubePlayerView youtubePlay;
    TextView videoTitleTV;
    TextView videoDescriptionTV;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Log.d(TAG, "onCreate: Starting");

        // find resources
        youtubePlay = (YouTubePlayerView)findViewById(R.id.youtubePlay);
        videoTitleTV = (TextView)findViewById(R.id.videoTitleTV);
        videoDescriptionTV = (TextView)findViewById(R.id.videoDescriptionTV);



        //retrieve intent
        Intent intent = getIntent();
        int videoID = intent.getExtras().getInt("examplesMap");
        Log.d(TAG, "onCreate: intent data retrieved");
        Content yc = LearnContentData.getVideoById(videoID);
        final String video = yc.getYoutubeVideo();
        final String title = yc.getTopic();
        final String description = yc.getVideoDescription();


        // initialise listener
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onCreate: Done initialising");
                youTubePlayer.loadVideo(video);
                videoTitleTV.setText(title);
                videoDescriptionTV.setText(description);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onCreate: Failed to initialise");
            }
        };
        Log.d(TAG, "onCreate: Initialising YouTube Player");
        youtubePlay.initialize(YoutubeConfig.getApiKey(), mOnInitializedListener);


    }
}
