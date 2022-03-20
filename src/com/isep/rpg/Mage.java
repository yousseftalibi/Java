package com.isep.rpg;

 class Mage extends SpellCaster {
  Mage(){
   super.lifePoints=6;
   super.armor=7;
   super.weaponDamage=7;
  }

  void attack(Enemy e){
   System.out.println("enemy's lifepoints reduced from "+e.lifePoints);
   e.lifePoints--;
   System.out.print(" to "+e.lifePoints);

  }

  void defend(){

  }

  void useConsumable(){

  }
}

