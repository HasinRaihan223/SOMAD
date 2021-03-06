package com.example.fortnite;

import android.view.View;

public class Story {

    GameScreen gs;
    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public Story(GameScreen gs){
        this.gs = gs;
    }

    public void selectPosition(String position){

        switch(position){
            case "enterScreen": enterScreen(); break;
            case "startingPoint": startingPoint(); break;
            case "guardTalk": guardTalk(); break;
            case "guardTalk2": guardTalk2(); break;
            case "crossroads": crossroads(); break;
            case "guardFight": guardFight(); break;
            case "guardFight2": guardFight2(); break;
            case "oldMan": oldMan(); break;
            case "oldMan2": oldMan2(); break;
            case "oldManNo": oldManNo(); break;
            case "forest": forest(); break;
            case "treePunch": treePunch(); break;
            case "river": river(); break;
            case "tac": tac(); break;
            case "victory": victory(); break;
            case "goTitleScreen": gs.goTitleScreen(); break;
        }

    }

    boolean tac = false;
    boolean wood = false;

    public void enterScreen(){
        gs.text.setText("Hello, player. Welcome to the world of Fortnite.\nYou have been sent by your mafia boss to go infiltrate the town of Tilted Towers.");

        gs.button1.setText("lets a go");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";

    }

    public void startingPoint(){
        gs.text.setText("There is a giant gate with a guard next to it.\nWhat do you do?");

        gs.button1.setText("Talk to the guard");
        gs.button2.setText("Go away from the gate");
        gs.button3.setText("Fight the guard");
        gs.button4.setText("");

        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "guardTalk";
        nextPosition2 = "crossroads";
        nextPosition3 = "guardFight";
        nextPosition4 = "";
    }

    public void guardTalk(){
        gs.image.setImageResource(R.drawable.guardtalk);
        gs.text.setText("Please identify yourself, stranger. This is the town of Tilted Towers. You may not pass without identification.");

        gs.button1.setText("I am a traveler.");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "guardTalk2";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void guardTalk2(){
        gs.image.setImageResource(R.drawable.guardtalk);
        gs.text.setText("This is a private town. Travelers are not allowed, for the security of the town. Please go to back to the crossroads and do not come back.");

        gs.button1.setText("Fine.");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossroads";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void crossroads(){
        gs.image.setImageResource(R.drawable.crossroads);
        gs.text.setText("You have arrived at a crossroads, with four directions to go to.\nWhich way do you go?");

        gs.button1.setText("North (forest)");
        gs.button2.setText("South (back to the gate)");
        gs.button3.setText("East (river)");
        gs.button4.setText("West (shack)");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);

        nextPosition1 = "forest";
        nextPosition2 = "startingPoint";
        nextPosition3 = "river";
        nextPosition4 = "oldMan";
    }

    public void guardFight(){
        gs.image.setImageResource(R.drawable.guardfight);
        gs.text.setText("square up bro");

        gs.button1.setText("come at me homie");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "guardFight2";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void guardFight2(){
        if(tac == true) {
            gs.image.setImageResource(R.drawable.kms);
            gs.text.setText("hacker!!!");

            gs.button1.setText("ggez");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "victory";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }

        else{
            gs.image.setImageResource(R.drawable.takethel);
            gs.text.setText("ur trash bro get outta here\n\nYou are sent back to the crossroads.");

            gs.button1.setText("what the heck!");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "crossroads";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void oldMan(){
        gs.image.setImageResource(R.drawable.bruh);
        gs.text.setText("Hello traveler. I have been expecting you. Your plan is to infiltrate the town of Tilted Towers. Correct?");

        gs.button1.setText("Yes..");
        gs.button2.setText("Uhhh.. no...");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "oldMan2";
        nextPosition2 = "oldManNo";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void oldMan2(){
        gs.image.setImageResource(R.drawable.mmm);
        gs.text.setText("East is your friend. That is all I have to say.\nNow hurry and infiltrate the town so I can get my paycheck!");

        gs.button1.setText("Alright, thanks. I'll head to the crossroads, I guess.");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossroads";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void oldManNo(){
        gs.image.setImageResource(R.drawable.noo);
        gs.text.setText("No need to hide your plan from me. I am a good friend of your boss.");

        gs.button1.setText("Oh.");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "oldMan2";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void river(){
        if (wood == true) {
            gs.image.setImageResource(R.drawable.building);
            gs.text.setText("Without a bridge in sight, some things you just have to do for yourself.");

            gs.button1.setText("Time to build");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "tac";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }

        else {
            gs.image.setImageResource(R.drawable.river);
            gs.text.setText("There is a very strong river, flowing stupidly fast. There's no bridge in sight. If only there was a place to get materials to build a bridge.\nGuess it's best to head back to the crossroads for now.");

            gs.button1.setText("If only...");
            gs.button2.setText("");
            gs.button3.setText("");
            gs.button4.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);
            gs.button4.setVisibility(View.INVISIBLE);

            nextPosition1 = "crossroads";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void tac(){
        gs.image.setImageResource(R.drawable.tac);
        gs.text.setText("You got a Tactical Shotgun!");

        tac = true;

        gs.button1.setText("lets GOOOOOOOOOOOOOOOOOOOOOOOOOO");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossroads";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void forest(){
        gs.image.setImageResource(R.drawable.tree);
        gs.text.setText("There is a dense forest.\nWhat do you do?");

        gs.button1.setText("Punch some trees");
        gs.button2.setText("Leave");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "treePunch";
        nextPosition2 = "crossroads";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void treePunch(){
        gs.image.setImageResource(R.drawable.treepunch);
        gs.text.setText("You got wood!");

        wood = true;

        gs.button1.setText("Leave");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "crossroads";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

    public void victory(){
        gs.image.setImageResource(R.drawable.victory);
        gs.text.setText("you won vicotry roaleye woooooo");

        wood = true;

        gs.button1.setText("Title Screen");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }

}
