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

    void attack(Enemy e){
        System.out.println("enemy's lifepoints reduced from "+e.lifePoints);
        e.lifePoints--;
        System.out.print(" to "+e.lifePoints);

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
     void useConsumable(){

        String food = super.inputParser.scanConsumable();

        for (int i=0; i<super.lembas.size()-1; i++){
            if(super.lembas.get(i).name.equals(food)){
                this.lifePoints++;
                super.lembas.remove(super.lembas.get(i));
            }
        }
        inputParser.closeScanner();

     }
}
