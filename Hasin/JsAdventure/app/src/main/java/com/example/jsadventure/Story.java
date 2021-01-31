package com.example.jsadventure;

import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class Story {

    GameScreen gs;
    String nextPosition1, nextPosition2, nextPosition3;

    Random damage = new Random();

    int HP = 100;
    int Gold = 10;

    int axeDamage = 21;
    int dualSwordsDamage = 26;
    int scytheDamage = 21;
    int relicSwordDamage = 41;
    int crossBowDamage = 16;
    int stilettoDamage = 16;

    int slimeHP = 50;
    int orcHP = 100;
    int golemHP = 100;
    int demonLordHP = 200;

    String currentWeapon = "Bare Fists";
    int currentWeaponDamage = 2;

    boolean hasRelicSword = false;

    boolean defeatedSlime = false;
    boolean defeatedOrc = false;
    boolean defeatedGolem = false;

//    ArrayList<String> Inventory;

    public Story(GameScreen gs){
        this.gs = gs;
    }

    public void selectionPosition(String position){
        switch(position){
            case "startingPoint": startingPoint(); break;
            case "merchant": merchant(); break;
            case "secondStartingPoint": secondStartingPoint(); break;
            case "getKilled": getKilled(); break;
            case "death": death(); break;
            case "goTitleScreen": gs.goTitleScreen(); break;
            case "getWeapon": getWeapon(); break;
            case "rollDice": rollDice(); break;
            case "randomWeaponGenerator": randomWeaponGenerator(); break;
            case "witch": witch(); break;
            case "buyPotion": buyPotion(); break;
            case "equipAxe": equipAxe(); break;
            case "equipCrossBow": equipCrossBow(); break;
            case "equipDualSwords": equipDualSwords(); break;
            case "equipScythe": equipScythe(); break;
            case "equipStiletto": equipStiletto(); break;
            case "equipRelicSword": equipRelicSword(); break;
            case "stay": stay(); break;
            case "slime": slime(); break;
            case "slimeFight": fightSlime(); break;
            case "orc": orc(); break;
            case "orcFight": fightOrc(); break;
            case "golem": golem(); break;
            case "golemFight": fightGolem(); break;
            case "nothingLeft": nothingLeft(); break;
            case "sike": sike(); break;
            case "lordFight": fightLord(); break;
            case "ending1": ending1(); break;
            case "ending2": ending2(); break;
            case "ending3": ending3(); break;
            case "ending4": ending4(); break;
        }
    }

    public void showAllButton(){
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
    }

    public void startingPoint(){

        gs.hp.setText("Player HP: "+ HP);
        gs.weapon.setText("Current Weapon: "+ currentWeapon);
        gs.money.setText("Gold Coins: "+Gold);

        gs.text.setText("Welcome to this game player! Apparently the game creator thought it was best for you to start in dungeon!\n\nWhat do you do?");

        gs.button1.setText("Exit the dungeon");
        gs.button2.setText("Go deeper into Dungeon");
        gs.button3.setText("Do nothing and cry");

        showAllButton();

        nextPosition1 = "merchant";
        nextPosition2 = "slime";
        nextPosition3 = "getKilled";
    }

    public void secondStartingPoint(){
        if (defeatedSlime==false){
            gs.image.setImageResource(R.drawable.dunge);
            gs.text.setText("You are inside a dungeon! It's rumored to be ruled by a demon lord. Better avoid him until you're strong enough.\n\nWhat do you do?");

            gs.button1.setText("Exit the dungeon");
            gs.button2.setText("Go deeper into Dungeon");
            gs.button3.setText("Do nothing and cry");

            showAllButton();

            nextPosition1 = "merchant";
            nextPosition2 = "slime";
            nextPosition3 = "getKilled";
        }
        if (defeatedSlime==true && defeatedOrc==false && defeatedGolem==false){
            gs.image.setImageResource(R.drawable.dunge);
            gs.text.setText("You are inside a dungeon!\n\nWhat do you do?");

            gs.button1.setText("Exit the dungeon");
            gs.button2.setText("Go deeper into Dungeon");
            gs.button3.setText("Do nothing and cry");

            showAllButton();

            nextPosition1 = "merchant";
            nextPosition2 = "orc";
            nextPosition3 = "getKilled";
        }
        if (defeatedSlime==true && defeatedOrc==true && defeatedGolem==false){
            gs.image.setImageResource(R.drawable.dunge);
            gs.text.setText("You are inside a dungeon!\n\nWhat do you do?");

            gs.button1.setText("Exit the dungeon");
            gs.button2.setText("Go deeper into Dungeon");
            gs.button3.setText("Do nothing and cry");

            showAllButton();

            nextPosition1 = "merchant";
            nextPosition2 = "golem";
            nextPosition3 = "getKilled";
        }
        if (defeatedSlime==true && defeatedOrc==true && defeatedGolem==true){
            gs.image.setImageResource(R.drawable.dunge);
            gs.text.setText("You are inside a dungeon!\n\nWhat do you do?");

            gs.button1.setText("Exit the dungeon");
            gs.button2.setText("Go deeper into Dungeon");
            gs.button3.setText("Do nothing and cry");

            showAllButton();

            nextPosition1 = "merchant";
            nextPosition2 = "nothingLeft";
            nextPosition3 = "getKilled";
        }
    }

    public void nothingLeft(){
        gs.image.setImageResource(R.drawable.gate);
        gs.text.setText("You explore the dungeon as much as can; however, you seem to find nothing more. All that's left to do is to confront the demon lord, but he is too powerful. Hmm...we need a weapon of great power.\n\nWhat do you do?");

        gs.button1.setText("Exit the dungeon");
        gs.button2.setText("Do nothing and cry");
        gs.button3.setText("");

        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "getKilled";
        nextPosition3 = "";
    }

    //Buy and/or get weapons
    public void merchant(){
        gs.image.setImageResource(R.drawable.merchant);
        gs.text.setText("You arrive upon a merchant. He says for 5 gold coins he will give you a random weapon.\n\n***Disclaimer you can get duplicate weapons***\n\nWhat do you do?");

        gs.button1.setText("Pay him");
        gs.button2.setText("Go back to dungeon");
        gs.button3.setText("Ignore and go past the merchant");

        showAllButton();

        nextPosition1 = "getWeapon";
        nextPosition2 = "secondStartingPoint";
        nextPosition3 = "witch";
    }

    public void getWeapon(){
        if (Gold >= 5){
            gs.image.setImageResource(R.drawable.paymoney);
            gs.text.setText("You pay the merchant 5 gold coins. The merchant says he will roll a dice to decide which random which to give you.");
            Gold -= 5;
            gs.money.setText("Gold Coins: " + Gold);
            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "rollDice";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            gs.image.setImageResource(R.drawable.merchant);
            gs.text.setText("Sorry player, it seems like you don't have enough money to buy a weapon. Maybe go fight some monsters, who might drop some money as loot.");

            gs.button1.setText("Go back");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "merchant";
            nextPosition2 = "";
            nextPosition3 = "";
        }
    }

    public void rollDice(){
        gs.image.setImageResource(R.drawable.chance);
        gs.text.setText("The merchant rolls the dice! I wonder what you're going to get!");

        gs.button1.setText(">>>");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "randomWeaponGenerator";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void randomWeaponGenerator(){
        Random dice = new Random();
        int number = dice.nextInt(6) + 1;
        switch(number) {
            case 1: getAxe(); break;
            case 2: getCrossBow(); break;
            case 3: getDualSwords(); break;
            case 4: getScythe(); break;
            case 5: getStiletto(); break;
            case 6: getRelicSword(); break;
        }
    }

    //Roll 1
    public void getAxe(){
        gs.image.setImageResource(R.drawable.axe);
        gs.text.setText("The merchant rolled a 1 and he awards you with a Battle Axe! Sturdy and strong, it'll never fail you. \n\nBattle Axe Max Damage: 20\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipAxe";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipAxe(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Axe";
        currentWeaponDamage = axeDamage;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Roll 2
    public void getCrossBow(){
        gs.image.setImageResource(R.drawable.crossbow);
        gs.text.setText("The merchant rolled a 2 and he awards you with a cross bow! Great at ranged combat.\n\nCross Bow Max Damage: 15\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipCrossBow";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipCrossBow(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Crossbow";
        currentWeaponDamage = crossBowDamage;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Roll 3
    public void getDualSwords(){
        gs.image.setImageResource(R.drawable.dualswords);
        gs.text.setText("The merchant rolled a 3 and he awards you with dual swords! Double the swords, double the fun!\n\nDual Swords Max Damage: 25\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipDualSwords";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipDualSwords(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Dual Swords";
        currentWeaponDamage = dualSwordsDamage;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Roll 4
    public void getScythe(){
        gs.image.setImageResource(R.drawable.scythe);
        gs.text.setText("The merchant rolled a 4 and he awards you with a scythe! The weapon of death himself. \n\nScythe Max Damage: 20\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipScythe";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipScythe(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Scythe";
        currentWeaponDamage = scytheDamage;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Roll 5
    public void getStiletto(){
        gs.image.setImageResource(R.drawable.stiletto);
        gs.text.setText("The merchant rolled a 5 and he awards you with a stiletto! A sturdy long and thin blade, it'll pierce just fine.\n\nStiletto Max Damage: 15\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipStiletto";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipStiletto(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Stiletto";
        currentWeaponDamage = stilettoDamage;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Roll 6
    public void getRelicSword(){
        gs.image.setImageResource(R.drawable.relicblade);
        gs.text.setText("The merchant rolled a 6 and he awards you with an ancient relic blade! The blade is said to hold great power.\n\nRelic Blade Max Damage: 40\n\nCurrent Weapon Max Damage: " + (currentWeaponDamage - 1) + "\n\nWhat do you do?");

        gs.button1.setText("Equip new weapon");
        gs.button2.setText("Stay with current weapon");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "equipRelicSword";
        nextPosition2 = "stay";
        nextPosition3 = "";
    }

    public void equipRelicSword(){
        gs.image.setImageResource(R.drawable.switchweapon);
        gs.text.setText("So you decided to equip your new weapon. Good choice.");

        currentWeapon = "Relic Sword";
        currentWeaponDamage = relicSwordDamage;
        hasRelicSword = true;
        gs.weapon.setText("Current Weapon: "+ currentWeapon);

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void stay(){
        gs.image.setImageResource(R.drawable.merchant);
        gs.text.setText("So you decided to stay with your current weapon. Fine by me.");

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "merchant";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    //Healing and stuff
    public void witch(){
        gs.image.setImageResource(R.drawable.witch);
        gs.text.setText("You arrive upon a witch's hut. She says for 2 gold coins she will give you a potion that can restore your health.\n\nWhat do you do?");

        gs.button1.setText("Pay her");
        gs.button2.setText("Go back");
        gs.button3.setText("");

        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "buyPotion";
        nextPosition2 = "merchant";
        nextPosition3 = "";
    }

    public void buyPotion(){
        if (HP >= 100  || Gold < 2){
            HP = 100;
            gs.image.setImageResource(R.drawable.witch);
            gs.text.setText("Sorry you either are full health or don't have enough money to buy a potion. Maybe come back later.");

            gs.button1.setText("Go back");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "witch";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            getPotion();
        }
    }

    public void getPotion(){
        gs.image.setImageResource(R.drawable.potion);
        gs.text.setText("You receive a potion from the witch. You drink it and it heals you. You gain back 10 HP!");

        Gold -= 2;
        HP += 10;
        checkGold();
        checkHP();

        gs.button1.setText("Go back");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "witch";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void checkGold(){
        if (Gold <= 0){
            Gold = 0;
            gs.money.setText("Gold Coins: "+Gold);
        }
        else {
            gs.money.setText("Gold Coins: "+Gold);
        }
    }

    public void checkHP(){
        if (HP > 100) {
            HP = 100;
            gs.hp.setText("Player HP: "+HP);
        }
        else {
            gs.hp.setText("Player HP: "+ HP);
        }
    }

    //Overlord boss battle
    public void getKilled(){
        if (hasRelicSword==true && defeatedGolem==false){
            gs.image.setImageResource(R.drawable.overlord);
            gs.text.setText("You plop down and start crying. You realize you have a sword of great power; however, you haven't cleared the dungeon. The demon lord of the dungeon and his minions overhear you sobbing. There are too many to fight all at once. You put up a good fight, but in the end it was all for nothing.");

            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "death";
            nextPosition2 = "";
            nextPosition3 = "";
        }
       else if (hasRelicSword==true && defeatedGolem==true){
           gs.image.setImageResource(R.drawable.overlord);
           gs.text.setText("You plop down and start crying, however you realize you have a sword of great power and that you cleared the dungeon. You decide to confront the demon lord of the dungeon.\n\nWhat do you do next?");

           gs.button1.setText("Fight");
           gs.button2.setText("Run away");
           gs.button3.setText("");

           gs.button2.setVisibility(View.INVISIBLE);
           gs.button3.setVisibility(View.INVISIBLE);

           nextPosition1 = "lordFight";
           nextPosition2 = "sike";
           nextPosition3 = "";
       }
       else{
           gs.image.setImageResource(R.drawable.overlord);
           gs.text.setText("You plop down and start crying. An ancient demon lord overhears you sobbing and decides to permanently end your misery.");

           gs.button1.setText(">>>");
           gs.button2.setText("");
           gs.button3.setText("");

           gs.button2.setVisibility(View.INVISIBLE);
           gs.button3.setVisibility(View.INVISIBLE);

           nextPosition1 = "death";
           nextPosition2 = "";
           nextPosition3 = "";
       }
    }

    public void fightLord(){
        String battleText;
        gs.image.setImageResource(R.drawable.overlord);
        int playerDmg = damage.nextInt(currentWeaponDamage);
        //CHANGE THE DAMAGE FOR FINAL GAME TO 31!!!
        int lordDmg = damage.nextInt(16);

        battleText = "You use your current weapon to attack the slime and deal it " + playerDmg + " damage.\n\nThe demon lord attacks you for " + lordDmg + " damage.";

        HP -= lordDmg;
        demonLordHP -= playerDmg;

        if (HP <= 0) {
            death();
            gs.hp.setText("Player HP: 0");
            gs.text.setText("Well this sucks player. You were so close to winning the game...well never give up and try again!");
        }
        else if (demonLordHP <= 0){
            gs.text.setText("WOW!!! You actually managed to kill the demon lord! Nice player. Here's a final high five! Now proceed to collect your reward.\n\nYou are at: " + HP + " HP\nThe demon lord is at: 0 HP\n\n");
            gs.image.setImageResource(R.drawable.highfive);
            gs.hp.setText("Player HP: "+ HP);

            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "ending1";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            gs.text.setText(battleText + "\n\nPlayer's health: " + HP + "\nDemon lord's health: " + demonLordHP);
            gs.image.setImageResource(R.drawable.overlord);
            gs.hp.setText("Player HP: "+ HP);

            gs.button1.setText("Attack");
            gs.button2.setText("Run away");
            gs.button3.setText("");

            gs.button2.setVisibility(View.VISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "lordFight";
            nextPosition2 = "sike";
            nextPosition3 = "";
        }
    }

    public void ending1(){
        gs.text.setText("Looks like the demon king was hoarding a chest full of treasures. Let's see what's inside!\n\nInside the chest is 100 Gold Coins!!! (Player obtains 100 gold coins)");
        Gold += 100;
        gs.money.setText("Gold Coins: " + Gold);
        gs.image.setImageResource(R.drawable.treasure);

        gs.button1.setText(">>>");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "ending2";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void ending2(){
        gs.text.setText("You look over to the demon king. You see that his demon blood sword is lying on the ground. You decide to pick it up. The moment you pick it up you can feel its immense power!\n\nDemon blood sword's max damage: 80");
        currentWeapon = "Demon Blood Sword";
        currentWeaponDamage = 81;
        gs.weapon.setText("Current Weapon: " + currentWeapon);
        gs.image.setImageResource(R.drawable.demonsword);

        gs.button1.setText(">>>");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "ending3";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void ending3(){
        gs.text.setText("Right after you equip the demon blood sword you hear a parrot squawking from deep in the dungeon...why is there a parrot in a dungeon?\n\nTo Be Continued...");
        gs.image.setImageResource(R.drawable.demonsword);

        gs.button1.setText(">>>");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "ending4";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void ending4(){
        gs.text.setText("Well that's it player...for now that is. I hope you enjoyed the game.\n\nClick the button below to restart");
        gs.image.setImageResource(R.drawable.win);

        gs.button1.setText("Restart");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
    }


    public void sike(){
        gs.image.setImageResource(R.drawable.laugh);
        gs.text.setText("HA (laughs in skeleton)! Did you really think you could run away from a boss fight. Go back and fight the boss ya lazy bum!");

        gs.button1.setText(">>>");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "getKilled";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void death(){
        gs.image.setImageResource(R.drawable.death);
        gs.text.setText("Sadly you have died :(\n\nSorry but you have to restart from the beginning.");

        gs.button1.setText("Restart the game");
        gs.button2.setText("");
        gs.button3.setText("");

        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "goTitleScreen";
        nextPosition2 = "";
        nextPosition3 = "";
    }

    public void slime(){
        gs.image.setImageResource(R.drawable.slime);
        gs.text.setText("As you venture into the dungeon an evil slime suddenly jumps up and attacks you!\n\nWhat do you do?");

        gs.button1.setText("Fight");
        gs.button2.setText("Run away");
        gs.button3.setText("");

        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "slimeFight";
        nextPosition2 = "secondStartingPoint";
        nextPosition3 = "";
    }

    public void fightSlime(){
        String battleText;
        gs.image.setImageResource(R.drawable.slime);
        int playerDmg = damage.nextInt(currentWeaponDamage);
        int slimeDmg = damage.nextInt(11);

        battleText = "You use your current weapon to attack the slime and deal it " + playerDmg + " damage.\n\nThe slime attacks you for " + slimeDmg + " damage.";

        HP -= slimeDmg;
        slimeHP -= playerDmg;

        if (HP <= 0) {
            death();
            gs.hp.setText("Player HP: 0");
            gs.text.setText("What a noob. Did you really just die to a slime, the lowest tier monster in this game. I am disappointed in you.");
        }
        else if (slimeHP <= 0){
            defeatedSlime = true;
            gs.text.setText("Hey would you look at that, you beat the slime. High five!!!\n\nYou are at: " + HP + " HP\nThe slime is at: 0 HP\n\nThe slime dropped 10 gold coins! (You obtain 10 gold)");
            gs.image.setImageResource(R.drawable.highfive);
            Gold += 10;
            gs.hp.setText("Player HP: " + HP);
            gs.money.setText("Gold Coins: "+ Gold);

            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "secondStartingPoint";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            gs.text.setText(battleText + "\n\nPlayer's health: " + HP + "\nSlime's health: " + slimeHP);
            gs.image.setImageResource(R.drawable.slime);
            gs.hp.setText("Player HP: "+ HP);

            gs.button1.setText("Attack");
            gs.button2.setText("Run away");
            gs.button3.setText("");

            gs.button2.setVisibility(View.VISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "slimeFight";
            nextPosition2 = "secondStartingPoint";
            nextPosition3 = "";
        }
    }

    public void orc(){
        gs.image.setImageResource(R.drawable.orc);
        gs.text.setText("You venture deeper into the dungeon. You happen to bump into something large. You look up and realize it's an enormous orc and I don't think he's the friendly kind.\n\nWhat do you do?");

        gs.button1.setText("Fight");
        gs.button2.setText("Run away");
        gs.button3.setText("");

        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "orcFight";
        nextPosition2 = "secondStartingPoint";
        nextPosition3 = "";
    }

    public void fightOrc(){
        String battleText;
        gs.image.setImageResource(R.drawable.orc);
        int playerDmg = damage.nextInt(currentWeaponDamage);
        int orcDmg = damage.nextInt(16);

        battleText = "You use your current weapon to attack the orc and deal it " + playerDmg + " damage.\n\nThe orc swings his heavy club and inflicts " + orcDmg + " damage to you.";

        HP -= orcDmg;
        orcHP -= playerDmg;

        if (HP <= 0) {
            death();
            gs.hp.setText("Player HP: 0");
            gs.text.setText("Oh no you died...well better luck next time!");
        }
        else if (orcHP <= 0){
            defeatedOrc = true;
            gs.text.setText("Good job on defeating the orc. Have another high five!!!\n\nYou are at: " + HP + " HP\nThe orc is at: 0 HP\n\nThe orc dropped 20 gold coins! (You obtain 20 gold)");
            gs.image.setImageResource(R.drawable.highfive);
            Gold += 20;
            gs.hp.setText("Player HP: " + HP);
            gs.money.setText("Gold Coins: "+ Gold);

            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "secondStartingPoint";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            gs.text.setText(battleText + "\n\nPlayer's health: " + HP + "\nOrc's health: " + orcHP);
            gs.image.setImageResource(R.drawable.orc);
            gs.hp.setText("Player HP: " + HP);

            gs.button1.setText("Attack");
            gs.button2.setText("Run away");
            gs.button3.setText("");

            gs.button2.setVisibility(View.VISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "orcFight";
            nextPosition2 = "secondStartingPoint";
            nextPosition3 = "";
        }
    }

    public void golem(){
        gs.image.setImageResource(R.drawable.golem);
        gs.text.setText("The deeper you go the darker the dungeon gets. Suddenly you hear the ground rumble. You turn the corner and you see a large rock golem towering over you.\n\nWhat do you do?");

        gs.button1.setText("Fight");
        gs.button2.setText("Run away");
        gs.button3.setText("");

        gs.button3.setVisibility(View.INVISIBLE);

        nextPosition1 = "golemFight";
        nextPosition2 = "secondStartingPoint";
        nextPosition3 = "";
    }

    public void fightGolem(){
        String battleText;
        gs.image.setImageResource(R.drawable.golem);
        int playerDmg = damage.nextInt(currentWeaponDamage);
        int golemDmg = damage.nextInt(21);

        battleText = "You use your current weapon to attack the rock golem and deal it " + playerDmg + " damage.\n\nThe golem stomps on you and deals " + golemDmg + " damage to you.";

        HP -= golemDmg;
        golemHP -= playerDmg;

        if (HP <= 0) {
            death();
            gs.hp.setText("Player HP: 0");
            gs.text.setText("Sucks that you got crushed to death by a rock golem...bad way to go...");
        }
        else if (golemHP <= 0){
            defeatedGolem = true;
            gs.text.setText("Nice job player. That was a tough battle and you pulled through. Here have yet another high five!!!\n\nYou are at: " + HP + " HP\nThe rock golem is at: 0 HP\n\nThe golem dropped 30 gold coins! (You obtain 30 gold)");
            gs.image.setImageResource(R.drawable.highfive);
            Gold += 30;
            gs.hp.setText("Player HP: "+ HP);
            gs.money.setText("Gold Coins: "+ Gold);

            gs.button1.setText(">>>");
            gs.button2.setText("");
            gs.button3.setText("");

            gs.button2.setVisibility(View.INVISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "secondStartingPoint";
            nextPosition2 = "";
            nextPosition3 = "";
        }
        else {
            gs.text.setText(battleText + "\n\nPlayer's health: " + HP + "\nGolem's health: " + golemHP);
            gs.image.setImageResource(R.drawable.golem);
            gs.hp.setText("Player HP: "+ HP);

            gs.button1.setText("Attack");
            gs.button2.setText("Run away");
            gs.button3.setText("");

            gs.button2.setVisibility(View.VISIBLE);
            gs.button3.setVisibility(View.INVISIBLE);

            nextPosition1 = "golemFight";
            nextPosition2 = "secondStartingPoint";
            nextPosition3 = "";
        }
    }

}
