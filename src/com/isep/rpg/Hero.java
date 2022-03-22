package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;

 abstract class Hero {
      int lifePoints;
      int armor;
      int weaponDamage;
      ArrayList<Potion> potions = new ArrayList<>();
      ArrayList<Food> lembas = new ArrayList<>();
      InputParser inputParser;

     abstract void attack(Enemy e);
     abstract void defend();
     abstract void eat();
     abstract void drink();


}

