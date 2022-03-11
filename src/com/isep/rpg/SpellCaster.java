package com.isep.rpg;

abstract class SpellCaster extends Hero{
    int manaPoints;

    void attack(){
        super.lifePoints=8;
        super.armor=8;
        super.weaponDamage=4;
    }

    void defend(){

    }

    void useConsumable(){

    }

}
