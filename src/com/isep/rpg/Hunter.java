package com.isep.rpg;

 class Hunter extends Hero{
     int arrows;

      Hunter(){
          super.lifePoints=6;
          super.armor=7;
          super.weaponDamage=7;
     }

     void attack(Enemy e){
         e.lifePoints--;
     }

     void defend(){

     }

     void useConsumable(){

     }
}
