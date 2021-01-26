package com.example.gamejava;

import android.content.Intent;
import android.icu.text.TimeZoneFormat;
import android.view.View;

public class Story {

    GameScreen gs;

    String nextPosition0, nextPosition1, nextPosition2, nextPosition3;

    int oniHealth;

    int playerHealth = 27;

    boolean ocarina = false;
    boolean killedRouge = false;


    public Story(GameScreen gs) {

        this.gs = gs;
    }

    public void selectPosition(String position) {
        switch (position) {
            case "startingPoint": case "sword": startingPoint(); break;
            case "obamarang": obamarang(); break;
            case "attack": attack(); break;
            case "battery": battery(); break;
            case "rogue": rogue(); break;
            case "dead": dead(); break;
            case "ocarina": ocarina(); break;
            case "oni": oni(); break;
            case "goTitleScreen": ocarina = false; gs.goTitleScreen(); break;
            case "victory": victory(); break;
        }
    }

    public void showAllButtons() {
        gs.button0.setVisibility(View.VISIBLE);
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);

    }


    public void startingPoint() {
        gs.image.setImageResource(R.drawable.dekutree);
        gs.text.setText("You are doing a thing when you see a tree. You think it wants to transform. \n Que usted va a hacer?");
        gs.button0.setText("Leave.");
        gs.button1.setText("Think two steps ahead \n and call the \n tree a sap.");
        gs.button2.setText("Do literally nothing.");
        gs.button3.setText("Commit death on the tree.");
        oniHealth = 50;
        showAllButtons();

        nextPosition0 = "obamarang";
        nextPosition1 = "battery";
        nextPosition2 = "ocarina";
        nextPosition3 = "oni";
    }

    public void obamarang() {
        gs.text.setText("As you head back, you see a wild obamarang appear. Seek to battle it?");
        gs.image.setImageResource(R.drawable.obama);
        gs.button0.setText("too scary. I go back");
        gs.button1.setText("");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button1.setVisibility(View.INVISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "startingPoint";
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "";

        if (ocarina) gs.text.setText("The ocarina has no effect on obamarang.");
    }

    public void battery() {
        gs.text.setText("The tree becomes what you call it - sap. \n In the midst of the sap, you see a pile of batteries.");
        gs.image.setImageResource(R.drawable.battery);
        gs.button0.setText("Consume the batteries.");
        gs.button1.setText("Leafe the area.");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "rogue";
        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void rogue() {
        if (ocarina) {
            gs.text.setText("You trip on battery acid and see a rogue. You play the ocarina. You are so bad at it the rogue runs away, crying in agony.");
            gs.image.setImageResource(R.drawable.rogue);
            gs.button0.setText("The rogue has done the leaving.");
            gs.button1.setText("");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button1.setVisibility(View.INVISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition0 = "startingPoint";
            nextPosition1 = "";
            nextPosition2 = "";
            nextPosition3 = "";

        }
        else {
            gs.text.setText("You start tripping. You trip so hard, \n you think you see a rogue. Funnily enough, it \n is a rogue. ");
            gs.image.setImageResource(R.drawable.rogue);
            gs.button0.setText("Die by way of rogue.");
            gs.button1.setText("");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button1.setVisibility(View.INVISIBLE);
            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            killedRouge = true;

            nextPosition0 = "dead";
            nextPosition1 = "";
            nextPosition2 = "";
            nextPosition3 = "";
        }
    }

    public void oni() {
        gs.text.setText("The tree does the dying. Behind the dying tree, you see an oni. He is just standing there, menacingly.");
        gs.image.setImageResource(R.drawable.oni);
        gs.button0.setText("Attack");
        gs.button1.setText("Run");
        gs.button2.setText("");
        gs.button3.setText("");


        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "attack";
        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void dead() {
        gs.text.setText("You are deaded. That sucks, I guess.");
        gs.image.setImageResource(R.drawable.haunting);
        gs.button0.setText("Return to sender");
        gs.button1.setText("");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button1.setVisibility(View.INVISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "goTitleScreen";
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void ocarina() {
        gs.text.setText("The tree finishes its transformation. It becomes an ocarina. Que extrana!");
        gs.image.setImageResource(R.drawable.ocarina);
        gs.button0.setText("Pick it up and go.");
        gs.button1.setText("");
        gs.button2.setText("");
        gs.button3.setText("");

        ocarina = true;

        gs.button1.setVisibility(View.INVISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "startingPoint";
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void victory() {
        gs.text.setText(" 'There is no treasure. We lied.' As you turn around to face the speaker, you feel a sharp pain in your back. Then, you start to see darkness. 'Don't worry young one. We appreciate your services.' Then everything fades to dark. \n TO NOT BE CONTINUED.");
        gs.image.setImageResource(R.drawable.allforone);
        gs.button0.setText("Return to where it all began.");
        gs.button1.setText("");
        gs.button2.setText("");
        gs.button3.setText("");

        ocarina = true;

        gs.button1.setVisibility(View.INVISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition0 = "goTitleScreen";
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "";
    }



    public void attack() {
            int playerDmg = (int) (Math.random() * 5 + 2);
            int oniDmg;
            String battleText;
            if (ocarina) {
                oniDmg = (int) (Math.random() * 12 + 4);
                battleText = "You sing the oni a horrible melody. \n You deal " + oniDmg + " points of damage to the oni.\n The oni yells in pain, and slashes you for " + playerDmg + " points of damage to you.";
            }
            else {
                oniDmg = (int) (Math.random() * 3);
                battleText = "You slap the oni for " + oniDmg + " points of damage. \n The oni slaps you for " + playerDmg + " points of damage.";
            }

            playerHealth -= playerDmg;
            oniHealth -= oniDmg;

            if (playerHealth <= 0) {
                dead();
                gs.text.setText("You have fallen in battle to the oni. That sucks, I guess.");
            }
            else if (oniHealth <= 0) {
                gs.text.setText("You have done the beating of the oni. Use the button below to claim your prize.");
                gs.image.setImageResource(R.drawable.haunting);
                gs.button0.setText("Treasure time...");
                gs.button1.setText("");
                gs.button2.setText("");
                gs.button3.setText("");

                gs.button1.setVisibility(View.INVISIBLE);
                gs.button2.setVisibility(View.INVISIBLE);
                gs.button3.setVisibility(View.INVISIBLE);

                nextPosition0 = "victory";
                nextPosition1 = "";
                nextPosition2 = "";
                nextPosition3 = "";
            }

            else {
                gs.text.setText(battleText + "\n Your health: " + playerHealth + "\n Oni health: " + oniHealth);
                gs.image.setImageResource(R.drawable.oni);
                gs.button0.setText("Attack");
                gs.button1.setText("Run");
                gs.button2.setText("");
                gs.button3.setText("");

                gs.button2.setVisibility(View.INVISIBLE);
                gs.button3.setVisibility(View.INVISIBLE);

                nextPosition0 = "attack";
                nextPosition1 = "startingPoint";
                nextPosition2 = "";
                nextPosition3 = "";
            }

    }
}


