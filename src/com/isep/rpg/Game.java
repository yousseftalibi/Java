package com.isep.rpg;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;

public class Game {
    public static ArrayList<Hero> heroes = new ArrayList<>();
    public static ArrayList<Enemy> enemies = new ArrayList<>();

    public static void generateHero(String heroName) {

        if (heroName.equals("Hunter")) {
            heroes.add(new Hunter());
        }  else if (heroName.equals("Warrior")) {
            heroes.add(new Warrior());
        }  else if (heroName.equals("Mage")) {
            heroes.add(new Mage());
        } else if(heroName.equals("Healer") ){
            heroes.add(new Healer());
        }

    }

    public static void shuffleList(){
         Collections.shuffle(heroes);
        Collections.shuffle(enemies);
    }

    public static void generateEnemies(int numberOfHeroes) {
        int numberOfEnemies = 2 * numberOfHeroes;
        while (numberOfEnemies > 0) {
            Random rand = new Random();
            int randNumber = rand.nextInt(3);
            switch (randNumber) {
                case 0: {
                    enemies.add(new Boss());
                    break;
                }
                default: {
                    enemies.add(new BasicEnemy());
                    break;
                }
            }
            numberOfEnemies--;
        }
    }

    public static void Eat(Hero hero) {
        Food food = new Food();
        hero.useConsumable(food);
    }

    public static void Drink(Hero hero) {
        Potion potion = new Potion();
        hero.useConsumable(potion);
    }

    public static void Attack(Hero h, Enemy e) {
        
        if (enemies.size() > 0) {
            if (e.lifePoints <= 0) {
                enemies.remove(e);
            }
            else {
                h.attack(e);
            }
        }
    }

    public static void Defend(Hero h, Enemy e) {
        if (heroes.size() > 0) {
            if (h.lifePoints <= 0) {
                heroes.remove(h);
            }

            else {
                h.defend();
            }
        }
    }
}
