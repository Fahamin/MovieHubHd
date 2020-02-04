package movie.hd.moviehubhd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import movie.hd.moviehubhd.R;
import movie.hd.moviehubhd.api.YoutubeAdd;

public class PlayerAct extends YouTubeBaseActivity {
    YouTubePlayerView playerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    String videoIdlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        playerView = findViewById(R.id.youtubePlayID);

      //  videoIdlink = getIntent().getStringExtra("video_id");

          videoIdlink ="MU9Wai0aIHs&t=65s";

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

/*
                List<String> videolist = new ArrayList<>();

                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();
                videolist.add();*/

                youTubePlayer.loadVideo(videoIdlink);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        playerView.initialize(YoutubeAdd.getApi_KEY(), onInitializedListener);

    }
}

