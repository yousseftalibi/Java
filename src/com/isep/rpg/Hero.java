package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.List;

 abstract class Hero {
      int lifePoints;
      int armor;
      int weaponDamage;
      List<Potion> potions;
      List<Food> lembas;
     InputParser inputParser;

     abstract void attack(Enemy e);
     abstract void defend();
     abstract void useConsumable();


}

