package com.isep.rpg;

abstract class SpellCaster extends Hero {

    SpellCaster() {
        super.lifePoints = 8;
        super.armor = 8;
        super.weaponDamage = 2;
        super.lembas.add(new Food("apple", 2));
        super.lembas.add(new Food("Orange", 3));
        super.potions.add(new Potion("Red", 2));
        super.potions.add(new Potion("Blue", 3));
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
