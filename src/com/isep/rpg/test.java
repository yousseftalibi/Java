package com.isep.rpg;

import org.junit.Test;
import static com.isep.rpg.Game.*;
import static org.junit.Assert.*;

public class test {
    private class MockGame{
        public MockGame(){
            heroes.add(new Hunter());
            heroes.add(new Warrior());
            heroes.add(new Mage());

            enemies.add(new BasicEnemy());
            enemies.add(new BasicEnemy());
            enemies.add(new Boss());
        }
    }

    @Test
    public void testHeroDefeat() {
        new MockGame();
        int totalPoints = heroes.get(0).lifePoints + heroes.get(0).armor;
        for (int i = 0; i < totalPoints; i++) {
            heroes.get(0).defend();
        }
        assertEquals(heroes.get(0).lifePoints, 0);
    }

    @Test
    public void testAllHeroesLost() {
        new MockGame();
        assertNotNull(heroes);
    }

    @Test
    public void testEat() {
        new MockGame();

        int lembasNumber = heroes.get(0).lembas.size();
        int lifePointsBefore = heroes.get(0).lifePoints;
        for (int i = 0; i < lembasNumber; i++) {
            Eat(heroes.get(0));
        }
        assertNotEquals(lifePointsBefore, heroes.get(0).lifePoints);
    }
    @Test
    public void testDrink() {
        new MockGame();

        int potionNumber = heroes.get(0).potions.size();
        int weaponDamageBefore = heroes.get(0).weaponDamage;
        for (int i = 0; i < potionNumber; i++) {
            Drink(heroes.get(0));
        }
        assertNotEquals(weaponDamageBefore, heroes.get(0).weaponDamage);
    }

    @Test
    public void testAttack() {
        new MockGame();
        int oldArmor = enemies.get(0).armor;
        heroes.get(0).attack(enemies.get(0));

        assertNotEquals(enemies.get(0).armor, oldArmor);
    }

    @Test
    public void testDefense() {
        new MockGame();
        int oldArmor = heroes.get(0).armor;
        heroes.get(0).defend();

        assertEquals(heroes.get(0).armor, oldArmor--);
    }

    @Test
    public void testGenerateEnemies() {
        generateEnemies(3);
        assertNotNull(enemies);
    }

}
