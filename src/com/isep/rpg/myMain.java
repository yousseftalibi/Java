package com.isep.rpg;

import com.isep.utils.InputParser;

public class myMain {
    public static void main(String[] args) {
      Game g = new Game();
      System.out.println("Game started");
      g.generateCombat();
    }
}
