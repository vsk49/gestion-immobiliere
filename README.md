# SAE3A.01
Application de gestion de biens immobiliers

# Description du Projet
Cette application est conçue pour fournir une solution complète de gestion immobilière. Elle permet de recenser et de gérer facilement les biens immobiliers, les locataires et les baux associés. Que vous soyez un propriétaire individuel ou une agence de gestion immobilière, cette application vous offre des outils puissants et intuitifs pour :

* Recenser les biens immobiliers : Enregistrez et gérez les détails de vos propriétés, y compris les adresses, les caractéristiques, les diagnosstics et les travaux réalisés.
* Gérer les locataires : Gardez une trace précise de vos locataires, incluant leurs informations de contact, leurs historiques de location, la régularisation de charges et leurs soldes du compte. 
* Suivre les baux : Gérez les contrats de location, les dates de début et de fin, les termes de location, et les renouvellements.

Grâce à notre interface conviviale et nos fonctionnalités avancées, vous pouvez optimiser la gestion de votre portefeuille immobilier, améliorer la communication avec vos locataires, et assurer une gestion efficace et sans tracas de vos locations.

# Membres
| SCRUM Master | Product Owner | Developer | Developer |
| -------- | ------- | ------- | ------- |
| POUX--BORIES Yoan | KOH Virgil-Shaun | DEHER Enzo | MIEGEMOLLE Romain |
| yoan.poux-bories@etu.iut-tlse3.fr | virgil-shaun.koh@etu.iut-tlse3.fr | enzo.deher@etu.iut-tlse3.fr | romain.miegemolle@etu.iut-tlse3.fr |
| [@pxn4923a](https://gitlab.info.iut-tlse3.fr/pxn4923a) | [@khv4609a](https://gitlab.info.iut-tlse3.fr/khv4609a) | [@dhn5130a](https://gitlab.info.iut-tlse3.fr/dhn5130a) | [@mgr5145a](https://gitlab.info.iut-tlse3.fr/mgr5145a) |

# Board Gitlab
Sur ce [board](https://gitlab.info.iut-tlse3.fr/pxn4923a/saea3.01/-/boards) vous pourrez suivre l'avancement de notre projet !

# Configuration du Projet
Cette section est divisée en deux parties :
* [L'importation du projet]()
* [Mise en place de la base de données]()

# Partie 1 : Importer le projet
Vous avez le choix d'utiliser entre VS Code, IntelliJ IDEA ou Eclipse pour importer ce projet. Pour ce faire :
* Téléchargez le code source de votre manière.
* Ouvrez votre IDE préféré et y importez le code source.
* Le projet est un projet Maven. Assurez que votre projet est bien mis en place.

Normalement vous avez réussi cette partie. 

# Partie 2 : Mise en place de la base de données
Maintenant on passe à la partie la plus difficile. Cette étape a plusieurs situations, donc il faut faire attention.

## Téléchargement d'Oracle Database XE 21
Si vous n'avez pas encore téléchargé la base de données Oracle, téléchargez-la en cliquant ce [lien](https://download.oracle.com/otn-pub/otn_software/db-express/OracleXE213_Win64.zip).
* Remarque : lors de l'installation de la BD, il faut que vous mémorisiez votre mot de passe pour continuer cette configuration.

## Configuration de la base de données
Pour commencer, il faut créer un utilisateur pour la base de données. Dans ce cas, on veut créer l'utilisateur "SAE3A01" avec mot de passe "$iutinfo".

Ouvrez votre terminal et tapez cette commande :
```
sqlplus / as sysdba
```
Il vous demande ensuite le mot de passe, tapez le mot de passe que vous avez crée lors de l'installation de la BD.


