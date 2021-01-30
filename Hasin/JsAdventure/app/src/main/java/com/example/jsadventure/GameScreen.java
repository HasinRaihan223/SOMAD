package com.example.jsadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    MediaPlayer songSoundMP;

    ImageView image;
    TextView text, hp, weapon, money;
    Button button1, button2, button3;

    Story story = new Story( this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        songSoundMP = MediaPlayer.create(this, R.raw.song);
        songSoundMP.setLooping(true);
        songSoundMP.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        hp = findViewById(R.id.hpTextView);
        weapon = findViewById(R.id.weaponTextView);
        money = findViewById(R.id.coinTextView);

        image = findViewById(R.id.gameImageView);
        text = findViewById(R.id.gameTextView);
        button1 = findViewById(R.id.choice1);
        button2 = findViewById(R.id.choice2);
        button3 = findViewById(R.id.choice3);

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        button3.setTransformationMethod(null);

        story.startingPoint();
    }

    @Override
    public void onPause() {
        super.onPause();
        songSoundMP.pause();
    }

    @Override
    public void onResume(){
        super.onResume();
        songSoundMP.start();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        songSoundMP.stop();
        songSoundMP.release();
    }

    public void button1(View view){
        story.selectionPosition(story.nextPosition1);
    }
    public void button2(View view){
        story.selectionPosition(story.nextPosition2);
    }
    public void button3(View view) {
        story.selectionPosition(story.nextPosition3);
    }

    public void goTitleScreen(){
        Intent titleScreen = new Intent(this, TitleScreen.class);
        startActivity(titleScreen);
    }
}