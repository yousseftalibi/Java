
Les fonctionnalités implementées:
- Choisir le nombre de héros
- Déterminer le nombre d'ennemis à partir du nombre d'héros
- Choisir la classe d'héros
- L'ordre d'attaque est déterminé aléatoirement (shuffleList )
- 7 JUnit tests
- Boire les potions augmente weaponDamage; Manger augmente points de vie
- Tomber sur un boss aléatoirement: 2 fois moins de chance
- Jouer directement sur l'interface graphique JavaFx
- Après la défaite, l'ennemie disparait pour être remplacé par un autre
- Attaque sur points de vie ou défense est directement visuel
- JavaFx animations (Pause transition) pour ordonner les affichages
- Message de victoire ou perte apparaît après le dernier clique sur 'Attack'
- Héritage, Polymorphisme, abstraction, interface et static
- InputParser (utilisé au départ du projet pour jouer au terminal)

Les fonctionnalités non implementées:
- Chaque ennemie possède une arme et une attaque particulière
- Actions après victoire en combat

Erreurs :
- Quand Armor de Héro et de Enemy est null, le button Attack n'apparaît pas
- Problème avec le temps d'affichage de certains messages (pause transition)
- Quand le joueur perd ou gagne, il doit cliquer sur Attack une dernière fois pour voir le message

Autres:
- Field choix du nombre de Héro peut contenir des caractères, dans ce cas, le programme est interrompu par une erreur Java
- Dans le ComboBox (sélécteur des héros), il faut ouvrir le dropdown et choisir la valeur à chaque fois. La valeur par défault n'est pas prise en compte

