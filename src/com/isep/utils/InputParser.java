package com.isep.utils;

import java.util.Scanner;

public class InputParser {

  public Scanner sc= new Scanner(System.in);


 public String scanHeroName(){
   System.out.println("please choose your Hero: Hunter, Warrior, Mage, Healer");

   /*if( sc.nextLine()!="Hunter" && sc.nextLine()!="Warrior"  && sc.nextLine()!="Mage" && sc.nextLine()!="Healer"){
     System.out.println("Error");
    }*/
    return sc.nextLine();
  }

  public int scanHeroNumber(){
   System.out.println(" please enter the number of heroes: ");
   int number = sc.nextInt();
   sc.nextLine();
   return number;
  }
 public String scanConsumable(){
  System.out.println("Enter name of food you wish to consume: ");

  if(!sc.nextLine().matches("[a-zA-Z]+")){
   System.out.println("Food name must contain caracters only");
  }
  return sc.nextLine();
 }

 public String scanAction(){
  System.out.println("Choose your action: Attack, Defend, Eat or Drink ");

return sc.nextLine();
 }
 public void closeScanner(){
   sc.close();
 }



}
