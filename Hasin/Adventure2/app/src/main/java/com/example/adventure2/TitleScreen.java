package com.example.adventure2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TitleScreen extends AppCompatActivity {

    MediaPlayer songSoundMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        //Ask for feedback on whether to keep this or not
//        songSoundMP = MediaPlayer.create(this, R.raw.song);
//        songSoundMP.setLooping(true);
//        songSoundMP.start();

//        Button musicPlayer = (Button) this.findViewById(R.id.music);
//
//        musicPlayer.setOnClickListener(new View.OnClickListener(){
//           @Override
//           public void onClick(View v) {
//               songSoundMP.start();
//           }
//        });
    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        songSoundMP.pause();
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        songSoundMP.start();
//    }
//
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        songSoundMP.stop();
//        songSoundMP.release();
//    }

//    public void goGameScreen(View view){
//        Intent gameScreen = new Intent(this, GameScreen.class);
//        startActivity(gameScreen);
//    }
}