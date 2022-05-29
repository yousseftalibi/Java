package com.isep.rpg;

class Potion implements Consumable {
  String name;
  int pointsAdded;

  Potion() {
  }

  Potion(String name, int pointsAdded) {
    this.name = name;
    this.pointsAdded = pointsAdded;
  }

}
