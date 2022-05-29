package com.isep.rpg;

 class Mage extends SpellCaster {
  Mage(){
   lifePoints=6;
   armor=7;
   weaponDamage=4;
   lembas.add(new Food("apple", 2));
   lembas.add( new Food("Orange", 3));
   potions.add(new Potion("Red", 2));
   potions.add(new Potion("Blue", 3));
  }

  void attack(Enemy e) {
   if(e.armor>0){
    e.armor--;
   }
   else{
    e.lifePoints--;
   }
  }

  void defend() {
   if (this.armor > 0) {
    this.armor--;
   } else {
    this.lifePoints--;
   }

  }

}

