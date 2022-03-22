package com.isep.rpg;

 class Hunter extends Hero {
     int arrows;

     Hunter() {
         super.lifePoints = 6;
         super.armor = 7;
         super.weaponDamage = 7;
         super.lembas.add(new Food("Apple", 2));
         super.potions.add(new Potion("Red", 2));
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
