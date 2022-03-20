package com.isep.rpg;
import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public ArrayList<Hero> heroes = new ArrayList<>();
    public int playTurn;
    public InputParser inputParser = new InputParser();

    public  Hero ChooseHero(){
        String heroName = inputParser.scanHeroName();
        Hero h;

        if(heroName.equals("Hunter")){
            h = new Hunter();
            heroes.add(h);
        }
       else if(heroName.equals("Warrior")) {
            h = new Warrior();
            heroes.add(h);
        }
        else if(heroName.equals("Mage")) {
            h = new Mage();
            heroes.add(h);
        }

       else{
            h = new Healer();
            heroes.add(h);
        }
        return h;
    }
    public Game(){


    }

    public void playGame(){


    }

    public Enemy generateEnemy(){


        Random rand = new Random();
        int randNumber = rand.nextInt(2);
        Enemy e ;

        switch (randNumber){
            case 0: {
                e = new Boss();
                break;
            }
            default:{
                e = new BasicEnemy();
                break;
            }
        }
        return e;
    }

    public void gameStatus(Hero h, Enemy enemy){
        System.out.println("Game started, you are:"+ h.getClass().getName());
        System.out.println("Your state is :\n"+ h.armor + " armor, "+h.lifePoints+" life points, "+ h.weaponDamage+ " weapon damage");
        System.out.println("You have the following lembas: ");
      /*  for (Food food: h.lembas) {
            System.out.println(food.name + " adds "+ food.lifePointsAdded +" life points");
        }*/

        System.out.println("Your enemy is "+enemy.getClass().getName() + " with "+ enemy.lifePoints+ " life points");

    }
    public void generateCombat(){
        Hero h = ChooseHero();
        String action;
        Enemy enemy = generateEnemy();

        gameStatus(h, enemy);

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
