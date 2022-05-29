package com.isep.rpg;

import java.util.ArrayList;

 abstract  class Hero {
     int lifePoints;
     int armor;
     int weaponDamage;
     ArrayList<Potion> potions = new ArrayList<>();
     ArrayList<Food> lembas = new ArrayList<>();

     abstract void attack(Enemy e);

     abstract void defend();

     public void useConsumable(Consumable c) {

          if (c.getClass().getName().equals(Food.class.getName()) && this.lembas.size() >= 0) {
               this.lifePoints += this.lembas.get(0).lifePointsAdded;
               this.lembas.remove(0);
          } else if (this.potions.size() >= 0) {
               this.weaponDamage += this.potions.get(0).pointsAdded;
               this.potions.remove(0);
          }
     }
}
