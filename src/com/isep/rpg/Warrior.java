package com.isep.rpg;


import java.util.Scanner;

class Warrior extends Hero {

     public Warrior(){
         super.lifePoints=4;
         super.armor=7;
         super.weaponDamage=9;

     }

     void attack(Enemy e){
        e.lifePoints--;

     }

     void defend(){
        this.armor--;
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
