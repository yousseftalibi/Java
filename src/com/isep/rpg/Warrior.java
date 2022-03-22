package com.isep.rpg;


import java.util.Scanner;

class Warrior extends Hero {

     public Warrior(){
         super.lifePoints=4;
         super.armor=7;
         super.weaponDamage=9;
         super.lembas.add(new Food("apple", 2));
         super.lembas.add( new Food("Orange", 3));
         super.potions.add(new Potion("Red", 2));
         super.potions.add(new Potion("Blue", 3));

     }

    void attack(Enemy e) {
        if(e.lifePoints>0){
            System.out.print("Enemy's lifepoints reduced from " + e.lifePoints);
            e.lifePoints--;
            System.out.println(" to " + e.lifePoints);
        }
        else {
            System.out.println("Enemy defeated");
        }
    }
    void defend() {
        if (this.armor > 0) {
            System.out.print("Your armor has been reduced from " + this.armor);
            this.armor--;
            System.out.println(" to " + this.armor);
        } else {
            System.out.print("Your lifepoints have been reduced from " + this.lifePoints);
            this.lifePoints--;
            System.out.println(" to " + this.lifePoints);
        }
    }

    void eat(){
        this.lifePoints = lifePoints + this.lembas.get(lembas.size()-1).lifePointsAdded;
        this.lembas.remove(lembas.size()-1);
    }

    void drink(){
        this.armor = armor + this.potions.get(potions.size()-1).pointsAdded;
        this.potions.remove(potions.size()-1);
    }
}
