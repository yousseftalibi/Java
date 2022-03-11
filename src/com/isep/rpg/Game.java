package com.isep.rpg;
import com.isep.utils.InputParser;
import java.util.List;
import java.util.Random;

public class Game {

    public List<Hero> heroes;
    public int playTurn;
    public InputParser inputParser;


    public Hero ChooseHero(){
        String hero = inputParser.scanHeroName();
        Hero h = new Hunter();
        switch(hero){
            case "Hunter":{
                h = new Hunter();
                heroes.add(h);
                break;
            }
            case "Warrior":{
                h= new Warrior();
                heroes.add(h);
                break;
            }
            case "Mage": {
                h = new Mage();
                heroes.add(h);
                break;

            }
            case "Healer":{
                h = new Healer();
                heroes.add(h);
                break;
            }
        }
        inputParser.closeScanner();
        return h;
    }
    public Game(){


    }

    public void playGame(){


    }

    public Enemy generateEnemy(){


        Random rand = new Random();
        int randNumber = rand.nextInt(2);
        Enemy e = new BasicEnemy();

        switch (randNumber){
            case 0: {
                e = new Boss();
                break;
            }
            case 1:{
                e = new BasicEnemy();
                break;
            }
        }
        return e;
    }
    public void generateCombat(Hero h){
        h=ChooseHero();

        String action;
        Enemy enemy = generateEnemy();

        action = inputParser.scanAction();
        switch (action){
            case "Attack": {
                h.attack(enemy);
                break;
            }
            case "Defend":{
                h.defend();
                break;
            }

            case "Eat":{
                System.out.println("you ate");
                break;
            }
            case "Drink":{
                System.out.println("you drank");
                break;
            }
        }


    }



}
