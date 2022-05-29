package com.isep.rpg;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;
import static com.isep.rpg.Game.*;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    Image backgroundImage = new Image("file:src\\com\\isep\\resources\\battlefront"+".jpg");
    Image heroImage = new Image("file:src\\com\\isep\\resources\\hero"+".png");

    Image enemyBossImage = new Image("file:src\\com\\isep\\resources\\boss"+".png");
    Image enemyBasicImage = new Image("file:src\\com\\isep\\resources\\basic"+".png");
    ImageView hero = new ImageView(heroImage);
    ImageView enemy = new ImageView();

    ImagePattern background = new ImagePattern(backgroundImage);

    Button playButton = new Button("Start");
    Button submitButton = new Button("Submit");

    Button rulesButton = new Button("Rules");
    Button attackButton = new Button("Attack");
    Button eatButton = new Button("Eat");
    Button drinkButton = new Button("Drink");

    double W = 780, H = 300;

    @Override
    public void start(Stage theStage) {

        Group menuGroup = new Group(submitButton, rulesButton);
        Scene menuScene = new Scene(menuGroup, W / 2, H / 2);
        Stage menuStage = new Stage();

        rulesButton.relocate(W / 4 - 30, H / 4 + 40);
        submitButton.relocate(W / 4 + 30, H / 4 + 40);
        menuScene.setFill(background);
        menuStage.setTitle("welcome to RPG Game!");

        Label labelHeroes = new Label("Choose number of Heroes ");
        setFontandColor(labelHeroes, Color.WHITE);
        labelHeroes.relocate(W / 4 - 65, H / 4 - 40);

        TextField fieldHeroes = new TextField();
        fieldHeroes.setPrefWidth(50);
        fieldHeroes.relocate(W / 4 - 10, H / 4 - 10);
        fieldHeroes.setStyle("-fx-width: 10px;");

        menuGroup.getChildren().addAll(labelHeroes, fieldHeroes);

        menuStage.setScene(menuScene);
        menuStage.show();

        final int[] j = { 1 };
        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Hunter");
        comboBox.getItems().add("Warrior");
        comboBox.getItems().add("Mage");
        comboBox.getItems().add("Healer");
        comboBox.setLayoutX(H / 4 + 100); comboBox.setLayoutY( H / 4 - 10);

        comboBox.setVisible(false);

        menuGroup.getChildren().addAll(comboBox);
        submitButton.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                menuGroup.getChildren().remove(fieldHeroes);

                comboBox.setVisible(true);

            }

            int numberOfHeroes = Integer.parseInt(fieldHeroes.getText());


            if (j[0] <= numberOfHeroes) {
                labelHeroes.setText("Choose hero " + j[0]++);
                comboBox.setOnAction( event1 -> {

                    generateHero(comboBox.getValue().toString());
                    comboBox.setOnKeyReleased( event2 -> {
                        comboBox.getSelectionModel().clearSelection();
                        comboBox.getItems().clear();
                    });
                });


            }
            else {
                menuGroup.getChildren().removeAll(submitButton, comboBox);
                labelHeroes.setText("Play now!");
                labelHeroes.relocate(labelHeroes.getLayoutX() + 30, labelHeroes.getLayoutY());


                playButton.relocate(W / 4 + 30, H / 4 + 40);
                menuGroup.getChildren().add(playButton);
            }
            generateEnemies(numberOfHeroes);

        });

        playButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                shuffleList();
                menuStage.close();
                theStage.setTitle("RPG Jeu");

                attackButton.relocate(W / 2, 80);
                eatButton.relocate(W / 2, 140);
                drinkButton.relocate(W / 2, 200);
                hero.relocate(500, 25);
                enemy.relocate(30, 25);


                Label typeHero = new Label(heroes.get(0).getClass().getSimpleName());
                Label lifePointsHero = new Label(heroes.get(0).lifePoints + " HP");
                Label armorPointsHero = new Label(heroes.get(0).armor + " Armor");
                Label weaponDamageHero = new Label(heroes.get(0).weaponDamage + " Damage ");
                Label lembasHero = new Label(heroes.get(0).lembas.size() + " Lembas ");
                Label potionsHero = new Label(heroes.get(0).potions.size() + " Potions ");

                typeHero.relocate(hero.getLayoutX() + 100, hero.getLayoutY() - 25);
                setFontandColor(typeHero, Color.WHITE);

                lifePointsHero.relocate(hero.getLayoutX() + 200, hero.getLayoutY() + 25);
                setFontandColor(lifePointsHero, Color.WHITE);

                armorPointsHero.relocate(hero.getLayoutX() + 200, hero.getLayoutY() + 100);
                setFontandColor(armorPointsHero, Color.WHITE);

                weaponDamageHero.relocate(hero.getLayoutX() + 200, hero.getLayoutY() + 175);
                setFontandColor(weaponDamageHero, Color.WHITE);

                lembasHero.relocate(hero.getLayoutX() + 230, hero.getLayoutY() - 20);
                lembasHero.setTextFill(Color.WHITE);
                lembasHero.setStyle(" -fx-font-weight:bold; -fx-font-size:small;");
                potionsHero.relocate(hero.getLayoutX() + 180, hero.getLayoutY() - 20);
                potionsHero.setTextFill(Color.WHITE);
                potionsHero.setStyle(" -fx-font-weight:bold; -fx-font-size:small;");


                Label typeEnemy = new Label(enemies.get(0).getClass().getSimpleName());
                Label lifePointsEnemy = new Label(enemies.get(0).lifePoints + " HP");

                Label armorPointsEnemy = new Label(enemies.get(0).armor + " Armor");
                Label weaponDamageEnemy = new Label(enemies.get(0).weaponDamage + " Damage ");

                typeEnemy.relocate(enemy.getLayoutX() + 100, enemy.getLayoutY() - 25);
                setFontandColor(typeEnemy, Color.WHITE);

                lifePointsEnemy.relocate(enemy.getLayoutX() - 20, enemy.getLayoutY() + 25);
                setFontandColor(lifePointsEnemy, Color.WHITE);

                armorPointsEnemy.relocate(enemy.getLayoutX() - 20, enemy.getLayoutY() + 100);
                setFontandColor(armorPointsEnemy, Color.WHITE);

                weaponDamageEnemy.relocate(enemy.getLayoutX() - 20, enemy.getLayoutY() + 175);
                setFontandColor(weaponDamageEnemy, Color.WHITE);
                PauseTransition pauseAttackButton = new PauseTransition(Duration.seconds(3));

                Label damageEnemy = new Label("#!?");
                setFontandColor(damageEnemy, Color.RED);

                Label defend = new Label(enemies.get(0).getClass().getSimpleName() + " is attacking");
                setFontandColor(defend, Color.RED);

                Label damageHero = new Label("#!?");
                setFontandColor(damageHero, Color.RED);

                if (enemies.get(0).getClass().getSimpleName().equals("Boss")) {
                    enemy.setImage(enemyBossImage);

                } else {
                    enemy.setImage(enemyBasicImage);
                }
                Group root = new Group(hero, enemy, attackButton, eatButton, drinkButton, typeHero, lifePointsHero,
                        armorPointsHero,
                        weaponDamageHero, lembasHero, potionsHero);
                root.getChildren().addAll(typeEnemy, lifePointsEnemy, armorPointsEnemy, weaponDamageEnemy);

                eatButton.setOnMouseClicked(Event -> {
                    Eat(heroes.get(0));
                    lifePointsHero.setText(heroes.get(0).lifePoints + " HP");
                    lembasHero.setText(heroes.get(0).lembas.size() + " Lembas");
                    if (heroes.get(0).lembas.size() == 0) {
                        root.getChildren().remove(eatButton);
                    }
                });

                drinkButton.setOnMouseClicked(Event -> {
                    Drink(heroes.get(0));
                    weaponDamageHero.setText(heroes.get(0).weaponDamage + " Damage");
                    potionsHero.setText(heroes.get(0).potions.size() + " Potions");
                    if (heroes.get(0).potions.size() == 0) {
                        root.getChildren().remove(drinkButton);
                    }
                });

                attackButton.setOnMouseClicked(Event -> {

                    if(heroes.size() > 0 && enemies.size()>0 ){
                    Attack(heroes.get(0), enemies.get(0));


                    if (enemies.get(0).armor >= 1) {

                        armorPointsEnemy.setText(enemies.get(0).armor + " Armor");
                        damageEnemy.relocate(armorPointsEnemy.getLayoutX() + 60, armorPointsEnemy.getLayoutY());
                        root.getChildren().add(damageEnemy);


                        PauseTransition pauseDamage = new PauseTransition(Duration.seconds(1));
                        pauseDamage.setOnFinished(e -> {

                        root.getChildren().remove(damageEnemy);
                        root.getChildren().remove(attackButton);
                        defend.relocate(attackButton.getLayoutX() - 30, attackButton.getLayoutY() - 70);
                        root.getChildren().add(defend);
                        pauseAttackButton.play();

                        });
                        pauseDamage.play();

                    }
                    else if (enemies.get(0).armor == 0 ) {
                        armorPointsEnemy.setText("0 Armor");
                        root.getChildren().add(damageEnemy);

                        PauseTransition pause = new PauseTransition(Duration.seconds(2));
                        PauseTransition pauseDefend2 = new PauseTransition(Duration.seconds(2.5));

                        pause.setOnFinished(e -> {
                            root.getChildren().remove(armorPointsEnemy);
                            root.getChildren().remove(damageEnemy);
                            root.getChildren().remove(attackButton);
                            defend.relocate(eatButton.getLayoutX() - 60 , eatButton.getLayoutY() - 100);
                            root.getChildren().add(defend);
                        });

                        pause.play();


                        pauseDefend2.setOnFinished(e -> {
                            root.getChildren().add(attackButton);
                            root.getChildren().remove(defend);
                        });

                        enemies.get(0).armor=-1;
                    }


                    else if (enemies.get(0).lifePoints >= 1  && enemies.get(0).armor==-1) {
                        lifePointsEnemy.setText(enemies.get(0).lifePoints + " HP");
                        damageEnemy.relocate(lifePointsEnemy.getLayoutX() + 60, lifePointsEnemy.getLayoutY());
                        root.getChildren().add(damageEnemy);

                        PauseTransition pauseE = new PauseTransition(Duration.seconds(1));
                        PauseTransition pauseEnemyAttacking = new PauseTransition(Duration.seconds(2));
                        pauseE.setOnFinished(e -> {
                            root.getChildren().remove(damageEnemy);
                            root.getChildren().add(defend);
                            pauseEnemyAttacking.play();
                        });
                        pauseE.play();

                        pauseEnemyAttacking.setOnFinished(e -> {
                            root.getChildren().remove(defend);
                        });
                    }
                    if (enemies.get(0).lifePoints == 0 ) {
                        lifePointsEnemy.setText("0 HP");
                        root.getChildren().remove(defend);
                        Label enemyDown = new Label(enemies.get(0).getClass().getSimpleName() + " down");
                        setFontandColor(enemyDown, Color.RED);
                        enemyDown.relocate(eatButton.getLayoutX()-60, eatButton.getLayoutY());

                        root.getChildren().remove(enemy);

                        root.getChildren().add(enemyDown);
                        root.getChildren().remove(lifePointsEnemy);
                        root.getChildren().remove(weaponDamageEnemy);
                        root.getChildren().remove(typeEnemy);

                        Attack(heroes.get(0), enemies.get(0));

                        PauseTransition pause = new PauseTransition(Duration.seconds(1));
                        pause.setOnFinished(e -> {
                            root.getChildren().remove(lifePointsEnemy);
                            lifePointsEnemy.setText(enemies.get(0).lifePoints + " HP");

                            root.getChildren().remove(armorPointsEnemy);
                            armorPointsEnemy.setText(enemies.get(0).armor + "  Armor");

                            root.getChildren().remove(typeEnemy);
                            typeEnemy.setText(enemies.get(0).getClass().getSimpleName());
                            root.getChildren().remove(enemyDown);
                            setEnemy();
                            root.getChildren().add(enemy);
                            root.getChildren().add(weaponDamageEnemy);
                            root.getChildren().add(armorPointsEnemy);
                            root.getChildren().add(typeEnemy);
                            root.getChildren().add(lifePointsEnemy);

                        });
                        pause.play();

                    }

                    Defend(heroes.get(0), enemies.get(0));

                    if (heroes.get(0).armor >= 1) {
                        PauseTransition removeDamageMessage = new PauseTransition(Duration.seconds(1));
                        root.getChildren().remove(attackButton);
                        pauseAttackButton.setOnFinished(e -> {
                            root.getChildren().add(attackButton);
                            root.getChildren().remove(defend);
                            armorPointsHero.setText(heroes.get(0).armor + " Armor");
                            root.getChildren().add(damageHero);
                            removeDamageMessage.play();
                        });
                        damageHero.relocate(armorPointsHero.getLayoutX() + 60, armorPointsHero.getLayoutY());
                        pauseAttackButton.play();

                        removeDamageMessage.setOnFinished(e -> {
                           root.getChildren().remove(damageHero);
                        });

                    }
                       else  if (heroes.get(0).armor ==0) {
                        armorPointsHero.setText("0 Armor");
                        root.getChildren().remove(attackButton);
                        pauseAttackButton.setOnFinished(e -> {
                            root.getChildren().add(attackButton);
                            root.getChildren().remove(defend);
                            root.getChildren().remove(armorPointsHero);
                        });
                        damageHero.relocate(armorPointsHero.getLayoutX() + 60, armorPointsHero.getLayoutY());
                        pauseAttackButton.play();


                        heroes.get(0).armor=-1;
                    } else if (heroes.get(0).lifePoints >= 1 && heroes.get(0).armor ==-1) {

                        PauseTransition pauseE = new PauseTransition(Duration.seconds(3));
                        PauseTransition pauseEnemyAttacking = new PauseTransition(Duration.seconds(1));
                        pauseE.setOnFinished(e -> {
                            damageHero.relocate(lifePointsHero.getLayoutX() +40, lifePointsHero.getLayoutY());
                            root.getChildren().add(damageHero);
                            root.getChildren().remove(defend);
                            lifePointsHero.setText(heroes.get(0).lifePoints + " HP");
                            pauseEnemyAttacking.play();
                        });
                        pauseE.play();
                        pauseEnemyAttacking.setOnFinished(e -> {
                            root.getChildren().remove(damageHero);
                        });
                    }

                    if (heroes.get(0).lifePoints == 0) {
                        lifePointsEnemy.setText("0 HP");

                        Label heroDown = new Label(heroes.get(0).getClass().getSimpleName() + " down");
                        setFontandColor(heroDown, Color.RED);
                        heroDown.relocate(attackButton.getLayoutX() - 30, lifePointsEnemy.getLayoutY() - 50);

                        root.getChildren().remove(hero);

                        root.getChildren().add(heroDown);

                        root.getChildren().remove(weaponDamageHero);

                        Defend(heroes.get(0), enemies.get(0));

                        PauseTransition pause2 = new PauseTransition(Duration.seconds(2));
                        pause2.setOnFinished(e -> {
                            root.getChildren().remove(lifePointsHero);
                            lifePointsHero.setText(heroes.get(0).lifePoints + " HP");
                            root.getChildren().remove(armorPointsHero);
                            armorPointsHero.setText(heroes.get(0).armor + " HP");
                            root.getChildren().remove(typeHero);
                            typeHero.setText(heroes.get(0).getClass().getSimpleName());

                            root.getChildren().remove(heroDown);
                            root.getChildren().add(weaponDamageHero);
                            root.getChildren().add(armorPointsHero);
                            root.getChildren().add(typeHero);
                            root.getChildren().add(lifePointsHero);
                            root.getChildren().add(hero);

                        });
                        pause2.play();

                    }
                }

                    else if(enemies.size()==0 && heroes.size()>0){
                        showWon();

                    }

                    else{
                        showLost();
                    }


            });

                Scene theScene = new Scene(root, W, H);

                theScene.setFill(background);


                theStage.setScene(theScene);
                theStage.show();

            }

        });

        rulesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Group secondLayout = new Group();
                Label description = new Label("This is an RPG Game, here how to play\n Here are the rules..");
                secondLayout.getChildren().add(description);
                Scene secondScene = new Scene(secondLayout, W / 2, H / 2);
                Stage secondStage = new Stage();
                secondStage.setTitle("Rules");
                secondStage.setScene(secondScene);
                secondStage.show();

            }
        });

    }

    private void showWon(){
        Alert won = new Alert(Alert.AlertType.CONFIRMATION);
        won.setTitle("Well done");
        won.setHeaderText("Result:");
        won.setContentText("You won!");
        won.showAndWait();

    }

    private void showLost(){
        Alert lost = new Alert(Alert.AlertType.WARNING);
        lost.setTitle("Try again");
        lost.setHeaderText("Result:");
        lost.setContentText("You lost!");
        lost.showAndWait();

    }

    private void setFontandColor(Label l, Color Color){

        l.setTextFill(Color);
        l.setStyle(" -fx-font-weight:bold; -fx-font-size:large;");
    }
    private void setEnemy() {
        if (enemies.get(0).getClass().getSimpleName().equals("Boss")) {
            enemy.setImage(enemyBossImage);

        } else {
            enemy.setImage(enemyBasicImage);
        }
    }

}
