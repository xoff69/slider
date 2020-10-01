# scoring
faire un composant swing équivalent à nutriscore
"
Afin de montrer le composant en action, faire un programme "main" de demo qui instancie le composant dans une fenêtre avec en dessous un indicateur de la valeur sélectionnée mis à jour dynamiquement. Le programme va requêter en HTTP le site https://www.random.org toutes les 10 secondes un entier compris entre 0 et 4 et mettre à jour le composant en fonction de l'entier reçu (0=A, 1= B, etc).

 

Le travail réalisé sera livré sur un dépôt bitbucket ou github publique. Le projet sera documenté et accompagné de scripts permettant la construction du jar final."
 

#### Author
- [Christophe PICHON] https://www.linkedin.com/in/christophe-pichon-25003b48/



#### License

`scoring` is licensed under the [GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007" license](./LICENSE.md).

#### Installation
L'application a été compilée et testée avec Java Se 14 mais n'utilise pas de spécificités de cette version. L'IDE utilisé Netbeans.

utilisation:
récupérer les sources du projet sur ce référentiel.

* en ligne de commande:
compiler le projet avec maven: mvn clean package
se placer dans le repertoire target lancer avec java : java com.cpichon.slider.Main ou java -jar Slider-1.0-SNAPSHOT.jar

* depuis votre IDE: executer la classe com.cpichon.slider.Main

Remarque: Pas de librairie additionnelle. Je n'ai pas utilisé JUnit notamment, ni de librairie de Logging. 
La classe principale est la classe Main dont la méthode main permet de déterminer le processus d'exécution.

