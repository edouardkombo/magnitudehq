

# Introduction #

Ce wiki a été réalisé dans le cadre du projet tutoré de 4ème année Informatique à l'INSA Toulouse. Pour ce projet, nous avons composé deux groupes de 5 étudiants et nous avons proposé un sujet portant sur la réalité augmentée appliquée aux périphériques mobiles Android.

Voici la liste des étudiants participant au projet global :
  * AYMARD Romain
  * BENATTAR Jonathan
  * BESSAGNET Mélanie
  * BRICHE Romain
  * FORMANCZAK Yahn
  * HADJEDJ David
  * LIU Xiyuan
  * MONTAGNE Thomas
  * PIEL Romain
  * RODRIGUEZ Yannick

Les deux groupes qui travailleront en collaboration sur le projet sont composés de la manière suivante :
  * Client / Technologies mobiles : AYMARD Romain, BENATTAR Jonathan, BESSAGNET Melanie, BRICHE Romain, LIU Xiyuan
  * Serveur / Fournisseur de services et données applicatives : FORMANCZAK Yahn, HADJEDJ David, MONTAGNE Thomas, PIEL Romain, RODRIGUEZ Yannick

Notre tuteur pour ce projet est M. Ernesto Exposito (Enseignant au DGEI à l'INSA Toulouse et chercheur au LAAS-CNRS).

L'idée de réaliser ce rapport final sous la forme d'un wiki plutôt que sous une forme plus classique nous a été suggérée par M. EXPOSITO, étant donné la nature ouverte du projet que nous avons réalisé. Nous avons choisi la solution d'hébergement Google Code pour faciliter la réutilisation et la diffusion du projet.

# Présentation générale #

## Fonctionnement global ##

L'objectif principal du projet est de fournir aux étudiants et personnels de l'INSA un medium novateur pour accéder à diverses informations à l'intérieur du campus de l'INSA. En utilisant la réalité augmentée et une plateforme mobile Android, on veut améliorer la circulation de l'information au sein de notre campus.

Le projet propose de concevoir et d'implémenter une application utilisant la réalité augmentée pour fournir des informations utiles aux étudiants et personnels de l'INSA Toulouse possédant des téléphones mobiles de dernière génération. Pour remplir cet objectif, nous avons réalisé deux composants applicatifs :
  * Une application mobile (fonctionnant sous le système d'exploitation Google Android) gérant les interactions avec l'utilisateur
  * Un serveur applicatif (fonctionnant sur une plateforme Java EE) obtenant et présentant aux terminaux les données appropriées

Afin de maximiser la ré-utilisabilité de notre application, nous avons fait le choix de privilégier une application sous forme modulaire : l'application met en place une plateforme fournissant des services de réalité augmentée. Il est possible à l'utilisateur d'insérer des modules au cœur de cette plateforme pour répondre à un besoin particulier. Dans le cadre du projet, nous avons implémenté les modules suivants :
  * Sauvegarde de points d'intérêt personnalisés
  * Étiquetage des bâtiments de l'INSA
  * Affichage de l'emploi du temps
  * Affichage des salles libres
  * Affichage de la position d'autres utilisateurs de l'application (aspect réseau social) (en cours de développement)

On peut imaginer de développer des modules offrant des services plus sophistiquées, par exemple en utilisant l'infrastructure informatique de l'INSA pour déterminer le poste informatique de l'INSA libre le plus proche...

Le développement de plugins n'est pas limité au projet Magnitude. Tout développeur désirant créer un module s'intégrant à notre système peut facilement réutiliser le code source existant pour répondre à un besoin auquel l'un de nos propres modules existants ne répond pas. L'intégralité du système est hautement personnalisable et peut être facilement utilisé sans faire appel à l'infrastructure de notre projet.

### Réalité assistée ###

La notion de réalité assistée désigne pour nous les systèmes (au sens informatique) qui utilisent la réalité augmentée pour ajouter des informations pratiques au réel, l’objectif étant d’assister l’utilisateur. De manière générale, la réalité augmentée consiste à ajouter des éléments virtuels à une capture du monde réel. Ici, les éléments ajoutées sont de type informatifs et peuvent être par exemple touristiques, historiques, sociaux etc...

Nous avons imaginé ce terme afin de souligner l’utilité du projet Magnitude. L’idée générale est d’ajouter des informations utiles à l’écran du téléphone mobile de l’utilisateur d'une manière novatrice. Celui-ci pourra ainsi se déplacer et obtenir des renseignements concernant l’environnement qui l’entoure.

## Cas d'utilisation ##

### Utilisateurs ###

#### Partie client ####

Les fonctionnalités utilisateurs du CORE de l'application magnitude sont très limitées. En effet, le CORE est une base permettant de recevoir des fonctionnalités via des plugins que l'utilisateur choisira d'installer et d'activer.

Un diagramme de Cas d'utilisation de l'application Magnitude Client :

![http://img710.imageshack.us/img710/9682/usecase.jpg](http://img710.imageshack.us/img710/9682/usecase.jpg)

Ce diagramme décrit les cas d'utilisation à un niveau abstrait. C'est-à-dire que les fonctionnalités des plugins ne sont pas détaillées.

Quelques exemples de plugins :

  * Localisation de bâtiments
  * Plugin social (twitter-like)
  * Sauvegarde de POI
  * Affichage d'information lié à des bâtiments

### Développeurs ###

Le CORE de l'application Magnitude peut être étendu grâce au développement de plugins. Nous encourageons d'ailleurs fortement les développeurs souhaitant s'investir dans le projet à bien distinguer les deux aspects sur lesquels ils pourront travailler.

  * Le premier aspect est l'amélioration du CORE. Il s'agit ici d'améliorer des fonctionnalités qui seront communes à tous les plugins.

  * Le second aspect est le développement de plugins pour le CORE. Dans ce cas là, le developpeur pourra créer un plugin permettant de fournir des fonctionnalités ayant du sens pour un utilisateur. Dans l'idéal, le développement d'un plugin ne doit pas entraîner de modification du composant CORE. Si une modification du composant CORE doit être faite pour le fonctionnement d'un plugin, celle ci doit être minimale et ne pas affecter le fonctionnement des autres plugins.

> Ex : Localisation de bâtiments, Sauvegarde de points d'interêts. (Le détail technique des plugins developpés peut être trouvé dans la seconde partie du rapport).

## Aspects projet ##

### Cycle de développement ###

Les deux équipes correspondant aux deux parties du projet ont fonctionné sensiblement de la même manière pour la réalisation du projet. Nous avons découpé le projet en 5 phases :

  * 1ère phase (commune aux deux équipes): Cette phase a été réalisée au premier semestre de l'année universitaire 2009/2010, et a consisté pour tous les membres du projet à réaliser un état de l'art sur la réalité augmentée : étudier les technologies disponibles, les dernières avancées, domaines d'application et commencer à délimiter les fonctionnalités et le périmètre de notre futur projet.

  * 2ème phase (séparée entre les deux équipes) : Une fois l'état de l'art réalisé, chaque équipe a réalisé des tests sur les technologies abordées lors de l'état de l'art afin d'identifier celles qui allaient être utilisées pour le projet.
> Certains choix sont apparus clairement, tandis que d'autres ont mérité plus de réflexion et parfois un peu plus d'avancement dans le projet pour pouvoir être figés.

  * 3ème phase (séparée entre les deux équipes) : La 3ème phase du projet a consisté à écrire le composant CORE de chaque partie du système (client et serveur). Ce composant permet de gérer sur chaque partie le comportement de base du système mais surtout est extensible par des plugins.

  * 4ème phase (séparée entre les deux équipes) : Le composant CORE étant terminé, chaque équipe a réalisé des plugins de démonstration en appliquant le projet à des fonctionnalités utiles aux étudiants de l'INSA.

  * 5ème phase (commune aux deux équipes) : Intégration. Il s'agit d'utiliser tout le travail effectué précédemment et de faire communiquer les deux parties client et serveur afin d'obtenir un fonctionnement normal et final de l'application.

### Outils de collaboration et de gestion de projet ###

Étant donné le nombre conséquent de développeurs impliqués dans le projet (10 étudiants), il nous a semblé utile de mettre en oeuvre des processus de collaboration plus élaborés que l'échange de pièces jointes par email sur lequel nombre de projets étudiants d'une plus faible envergure s'appuient. Les processus de communication que nous avons tenté de mettre en oeuvre s'appuient sur une infrastructure informatique composée de :
  * un wiki (Atlassian Confluence)
  * une plateforme de gestion des demandes et des bugs (Atlassian JIRA)
  * un dépôt Subversion par projet, éventuellement présentés par l'intermédiaire de l'outil FishEye.
  * un serveur d'intégration continue basé sur Atlassian Bamboo.

Une grande partie de ces outils est basée sur une plateforme Java EE, et leur installation a permis à l'équipe serveur de se familiariser avec cette famille de technologie.

#### Wiki et gestion des demandes ####

Le wiki (Confluence) et la plateforme de gestion des demandes (JIRA) ont tout deux eu comme rôle principal de faciliter la communication à la fois à l'intérieur de chaque équipe et entre les deux équipes client et serveur.

Leur rôle peut cependant être différencié par le type de contenu et par l'objectif de la communication qu'ils supportent :
  * le wiki permet l'hébergement de contenu rédigé, par exemple de spécifications fonctionnelles ou de documentation technique. Il présente un avantage crucial par rapport à de simples documents de type Word: toute modification est immédiatement accessible à l'ensemble de l'équipe, et aucune problématique de partage ou de versionnement de ces fichiers ne se pose. Il est même possible d'éditer simultanément des parties différentes du même document sans conséquences néfastes.
  * la plateforme de gestion des demandes n'a quant à elle pas un rôle de documentation : son utilisation a pour objectif principal la gestion du projet et le coordonnement des tâches. Une telle plateforme permet d'utiliser les outils classiques de gestion de projet (diagramme de Gantt par exemple) en restant à un niveau d'abstraction relativement haut au delà duquel leur utilisation est rapidement fastidieuse. En utilisant une plateforme comme JIRA, il est relativement facile de coordonner le travail d'une équipe. Nous avons cependant fait l'expérience que une telle plateforme n'a réellement d'intérêt que si l'ensemble des acteurs du cycle de développement sont impliqués dans son utilisation, et que même dans ce cas, la gestion de ces demandes peut nécessiter une quantité de travail non négligeable.

#### Subversion ####

Nous avons fait le choix d'utiliser Subversion comme outil de gestion de versions. Notre expérience à la fois avant et pendant ce projet nous suggère que tout projet, même d'une envergure minimale, béneficie grandement de l'utilisation de ces outils, notamment en réduisant dratiquement le temps nécessaire au partage des sources et à la résolution des bugs introduits dans le logiciel.

#### Serveur d'intégration continue ####

Le rôle d'un serveur d'intégration continue est relativement simple : chaque fois qu'un développeur effectue une modification dans l'un des projets qu'il surveille, le serveur automatiquement :

  * récupère les sources sur Subversion ;
  * compile le projet ;
  * exécute les tests définis par le projet ;
  * exécute un outil pour mesurer le pourcentage du programme couvert par les tests ;
  * si il rencontre une erreur ou une anomalie, envoie un mail d'avertissement aux développeurs ;
  * déclenche la même procédure pour tous les projets qui dépendent du projet en cours ;
  * si il faut déployer le projet vers un environnement de test, déploie le projet.

Ce genre d'outil permet d'augmenter la qualité logicielle en forçant les développeurs à écrire des tests unitaires et permet d'attraper les erreurs immédiatement.

Cet outil a été deployé relativement tard dans la vie du projet et nous n'avons pas véritablement profité de son utilisation, qui n'a pas été généralisé à l'ensemble des modules du projet. Nous restons cependant persuadés de son utilité et de la valeur ajoutée qu'il apporte à tout projet en terme de qualité logicielle.


# Composants #

## Composants clients ##

### Réalisation réalité augmenté ###

La réalisation de réalité augmenté s'agit de faire des calculs avec les données des différents capteurs. Ces calculs nous permettent de simuler d'affichage de Points d'interêrt en mettant en place ses positions dans l'ecran et dans le surface de radar.

#### Données accossiés aux calculs: ####

  * GPS:
    * La longitude et la latitude locales
    * La distance au POI
    * L'azimuth du POI
  * Boussole:
    * La direction du caméra
  * Accéléromètre:
    * L'inclination du caméra
  * Autres:
    * L'angle de vue de la caméra(horizontal et vertical)

#### Gestion camera: ####

La position du chaque point d'interêt dans la caméra est définie par son azimuth et la direction de caméra. La caméra possède un angle de vue qui est prédéfini par le materiel. Nous introduisons une notion de bras de caméra. Le bras gauche "leftarm" signifie la vue le plus à gauche et idem pour le bras droite "rightarm". Ces 2 valeurs mettent à jours en chaque changement de la direction de caméra.

  * leftarm = direction - angleDeVue/2
  * rightarm = direction + angleDeVue/2

![http://farm5.static.flickr.com/4032/4676708890_cb5a5fd515.jpg](http://farm5.static.flickr.com/4032/4676708890_cb5a5fd515.jpg)

Une fois qu'on a modélisé la vue de caméra, il faut définir la position du point d'interêt dans l'écran. Nous allons d'abord calculer la différence entre l'azimuth du point d'interêt et leftarm. Le rapport de cette valeur à l'angle de vue représente le pourcentage de la position du point d'interêt dans l'écran. L'équation est suivant:

  * angleEcart = arzimuth - leftarm
  * rapport = angleEcart / angleDeVue
  * position = screenWidth × rapport

![http://farm2.static.flickr.com/1269/4676083819_1cbff55766.jpg](http://farm2.static.flickr.com/1269/4676083819_1cbff55766.jpg)

#### Gestion radar: ####

La représentation des points d'interêt dans le radar peut être modélisé par une coordonnée polaire. L'angle du point d'interêt dans la coordonnée "Alpha" égal la différence entre l'azimuth du point d'interêt et la direction de caméra. La distance du point "L" peut être représentée par le rapport de vrai distance entre le point d'interêt et où on est à la distance maximale. Les équations sont suivantes:

  * distance <= distqnceTo()
  * L = distance / distanceMax
  * Alpha = azimuth - direction

Pour dessiner les points dans l'ecran de téléphone, il faut transformer la coordonnée en cartesien.

  * x = L × sin(Alpha)
  * y = L × cos(Alpha)

![http://farm2.static.flickr.com/1266/4676824516_118da2bf2e.jpg](http://farm2.static.flickr.com/1266/4676824516_118da2bf2e.jpg)

### CORE ###

Le CORE de l'application prend en charge :

  * La récupération des données des différents capteurs (GPS, Accéléromètre, Boussole)
  * L'image de la caméra
  * L'interface graphique (Vues statiques et Points d'intêret)
  * La réalisation des calculs permettant l'affichage de points d'interêt à l'écran
  * L'installation / Desinstallation de plugins.

Pour les calculs et l'affichage de Points d'interêt, le core est basé sur une API Android déjà existante
nommée ARKIT, que nous décrirons ci-après. Cette API représentait une bonne base de départ, mais un gros
travail de modification et d'amélioration a été effectué.

L'utilisation de l'API ARKit a été encapsulé dans une Activité android nommée ARKitActivity. Cela permet
d'avoir un niveau d'abstraction plus important et de permettre à un developpeur non experimenté de comprendre
et manipuler notre code sans s'occuper de la couche complexe liée au calcul des points d'interêt.

### ARKIT ###

ARKit est une API Open Source développée à l’origine pour iPhone en 2009 et qui propose un système basique mais fonctionnel. C’est un membre de l’équipe de développement qui a exporté le projet pour la plateforme Android de Google. Le développement est arrêté depuis fin 2009 avec une version instable, non commentée et non officiellement distribuée (accès aux sources via le dépôt du projet sur github).

C’est sur cette dernière release que nous avons commencé le développement de Magnitude Client. Notre premier travail a été de  prendre en main l'API (à l'aide de M. Vincent Demay), et surtout, nous nous sommes consacrés à :
  * La correction de bug
  * Le nettoyage et le refactoring du code
  * La portabilité pour plusieurs types de téléphones
  * L'ajout de nouvelles fonctionnalités

Le principe de l’API Arkit est de détruire l’architecture originale proposée par Android pour la reconstruire couche par couche _(fig. ARKit schéma)_

![http://img31.imageshack.us/img31/6165/arkit.png](http://img31.imageshack.us/img31/6165/arkit.png)

Les 2 premières couches (Frame Layout et CameraView) ne sont utilisées et configurées qu'à l'initialisation, contrairement à la couche ARLayout qui constitue le coeur de l'API. C'est dans cette couche que tous les calculs sont effectués et que toutes les données relatives à la réalité augmentée sont stockées. C'est aussi à partir de cette couche là que l'interface utilisateur est définie et que le lien avec les plugin est fait. Enfin c'est l'ARLayout qui pilote les interactions avec l'utilisateur sur les différents éléménts de l'interface graphique.

### GUI ###

_(Graphical User Interface - Interface utilisateur graphique)_

Nous avons réalisé une interface claire et épurée de façon à focaliser l'action sur la caméra et les informations ajoutés, et non sur les outils de configuration. Ces outils ont donc été réduits au minimum. Nous sommes partis d'une simple vue de la caméra et nous nous sommes demandés ce dont nous avions vraiment besoin, afin d'utiliser au mieux Magnitude.
Ainsi, nous avons intégré une icone affichant le statut de la connections GPS, un radar pour afficher les POI, et une roulette pour pouvoir filtrer les POI en fonction de leur distance. _(fig Screenshot par défault)_

![http://img683.imageshack.us/img683/5425/screenbasic.png](http://img683.imageshack.us/img683/5425/screenbasic.png)

L'idée principale de l'interface utilisateur est simplement **"Faites ce que dont vous avez envie."**.

Fort de cette philosophie, nous avons intégré de petits systèmes destinés à prendre en main simplement Magnitude :
  * Si deux POI se superposent, déplacez les en les faisant glisser.
  * Pour les replacer, une simple pression sur la flèche en bas a gauche de l'écran.
  * Un simple clic sur un POI ouvre une fenêtre d'information.
  * Tournez la roulette pour filtrer les POI et afficher seulement les plus proches.

![http://img717.imageshack.us/img717/3861/screenpoimove.png](http://img717.imageshack.us/img717/3861/screenpoimove.png)

#### Personnaliser l'interface ####

Les éléments graphiques sont décomposés en 2 classes : ARKitStaticView et ARKitSphericalView permettant chacune de configurer la gestion des clics, le type de contenu (texte, images etc...) ainsi que les différents effets. Pour plus de précision, rendez vous dans la section Tutorial.

### Plugin ###

Magnitude permet des développeurs de créer des plugins pour compléter les fonctionnalités de l'application.
Nous proposons 2 types de plugin: SERVICE\_TYPE\_TOUCHEABLE et SERVICE\_TYPE\_GETTER. Il faut déclarer le type à la création du plugin pour que l'application principale puisse faire des traitements correspondants.

L'application principale et les plugins communiquent par des intents. Les 2 cotés possèdent ses propres intent-filter. Ils spécifie les types d'intents qu'un activité, un service ou un broadcast receiver peuvent répondre.

Pour démarrer le service du plugin, l'application principale doit envoyer un signal startService() avec un intent qui contient l'action spécifiée dans l'intent-filter du plugin. Après avoir reçu le signal de démarrage, le plugin commence à faire son traitement, puis créer un autre intent en capsulant toutes les informations. Pareil, il faut que cet intent contienne l'action spécifiée dans l'intent-filter de l'application principale. Le plugin envoie cet intent par un broadcast. Le broadcast receiver va activer quand il recoit cet intent. L'application principale peut donc faire tout ce qu'elle veut avec ces informations.

![http://farm5.static.flickr.com/4068/4676919330_96c161b7f5_b.jpg](http://farm5.static.flickr.com/4068/4676919330_96c161b7f5_b.jpg)

## Composants serveurs ##

### Architecture globale ###

Notre serveur se décompose en 3 grandes parties et peut être résumée par le diagramme suivant :

![http://img88.imageshack.us/img88/6479/architectureglobaledusy.png](http://img88.imageshack.us/img88/6479/architectureglobaledusy.png)

Le mobile client est implémenté par l'équipe client du projet.

Le module ADMIN-UI est implémenté par une application SmartGWT écrite en Java qui une fois compilée fonctionne à l'intérieur du navigateur du développeur ou de l'administrateur.

Les modules ADMIN-SERVER et CORE sont implémentés par des applications Web de type Spring MVC. Ces deux modules partagent un dernier module, DOMAIN, qui gère l'accès à la persistance des données.

Les 3 modules utilisent l'outil Maven 2 pour faciliter la gestion des différentes étapes de leur cycle de vie.

#### Core ####
Le module CORE est un module web permettant d'interfacer les clients mobiles au système. Le module est identifié par le nom de package com.magnitudehq.server.core.

Pour remplir sa mission, le module utilise le framework Spring dans sa version 3.0.2, en particulier son module MVC. On se réfère à la documentation du projet Spring pour plus de détails.

#### Domain ####
Le module DOMAIN est un module utilitaire permettant de gérer la persistance des données de l'application. Le module est identifié par le nom de package com.magnitudehq.com.server.domain.

Pour remplir sa mission, le module fournit à ses utilisateurs plusieurs éléments :

  * une implémentation des objets métiers de l'application sous la forme de classes Java (package model) ;
  * des interfaces de type Data Access Object (DAO) permettant de gérer de manière simple la persistance (package dao) ;
  * une implémentation des interfaces DAO utilisant la Java Persistence API (JPA) (package jpa) ;
  * un fichier de configuration de contexte Spring permettant une configuration et injection automatique des ces dépendances dans une application Spring.

#### Admin ####
Nous regroupons ici les deux modules ADMIN-SERVER et ADMIN-UI puisqu'ils sont étroitement liés.
  * Le module ADMIN-UI sert à interfacer les développeurs et administrateurs du système à notre système. Le module est identifié par le nom de package com.magnitudehq.server.adminui.
  * Le module ADMIN-SERVER est le module permettant de fournir les demandes faites par ADMIN-UI. Le module est identifié par le nom de package com.magnitudehq.server.adminserver.

### Fonctionnement général des plugins ###

Comme décris plus haut, Magnitude est entièrement basé sur un système de plugins pour améliorer la modularité et surtout l'évolutivité. En effet c'est grâce aux plugins qu'on peut voir de nouvelles options arriver sur Magnitude sans y avoir pensé avant.

Afin de gérer facilement ce système de plugins, nous nous sommes tout d'abord orientés vers l'utilisation d'[OSGi](http://en.wikipedia.org/wiki/OSGi). OSGi est une plate-forme de services Java qui peut être gérée de façon distance et complètement dynamique. En effet, le gros avantage d'OSGi aurait été lorsque nous déployons un nouveau plugin sur le serveur, nous n'aurions pas eu l'obligation de réinitialiser le serveur. Tout aurait été fait dynamiquement sans poser de problèmes. Malheureusement cette solution s'est avérée trop lourde à mettre en place dans le temps que nous avions.

Nous avons donc opté pour une solution plus simple à mettre en place mais moins pratique à utiliser. Chacun des plugins devient une application web complètement séparée de notre serveur. Deux possibilités s'offrent aux développeurs, soit ils peuvent déposer un fichier war sur notre serveur qui sera déployé dans le module PLUGINS, avec toutes les correspondances avec les autres modules. Soit il peut le déployer sur un autre serveur, en précisant toutes les informations nécessaires. Il doit cependant déposer le code du mobile sur notre serveur pour qu'il soit téléchargeable via nos serveurs, et dans ce cas, nos serveurs n'auraient que cette utilité, puisque tous les services seraient fournis par le serveur distant sur lequel est déployé le plugin.
Il en va de fait que le plugin serveur doit fournir un service web lisible par la partie client (sur le mobile).

### Détails techniques des différents plugins ###

#### Plugin INSA Toulouse ####

#### Plugin Open Street Map ####

### Gestion du projet ###

![http://img205.imageshack.us/img205/7637/slide1copie.png](http://img205.imageshack.us/img205/7637/slide1copie.png)

La masse de recherches nous a paru très large au début. Il a donc fallu se concentrer sur cette partie pendant un certain temps. Nous nous sommes donc partagé les recherches et une fois ces point réalisés, il a fallu passer à la phase de conception et de développement.

Nous n'avons pas travaillé tous sur les mêmes parties. Deux personnes se sont penchées sur la partie interface d'administration tandis que les trois autres ont travaillé sur la partie core.

L'interface d'administration a été séparée en  deux sous-parties back et front office.

Les tâches relatives au core serveur étaient basiquement l'administration du serveur d'application, la gestion et la mise en place de la base de donnée, la communication entre composants internes et la communication avec la partie client. Finalement, le développement du core a été plus long que prévu et l'interface d'administration a été réduite a une preuve de concept, car trop lourde à implémenter en considérant les contraintes de temps.

Deux personnes se sont donc attaqués aux deux plugins, à savoir ADE et openstreetmap tandis que les autres terminaient le core.

### Recherches ###

#### Interface d'administration ####
Le choix s'est très vite orienté vers GWT pour ses qualités et sa nouveauté. Nous étions donc curieux de savoir comment fonctionnait cette technologie. Une fois que nous avons compris son fonctionnement, nous nous sommes porté sur son dérivé SmartGWT.

#### Base de données ####
Le choix n'a pas été très simple. Nous avons exploré les diverses possibilité avec notamment le moteur de base de données relationnelle Apache Derby. Nous avons aussi pensé à stocker les données dans des fichiers xml et utiliser des transformations xslt pour les récupérer. Finalement nous avons choisi d'implémenter une base de donnée mySQL car nous maîtrisons complètement son fonctionnement.

#### Communication ####
Le format de données pour la communication avec la partie client a été imposée. Nous avons donc utilisé le format JSON. En interne nous avons le plus souvent utilisé le format XML excepté pour la communication core/adminUI. Les recherches ont donc concerné ces deux schémas de données.

#### Plugins ####
Nous avons réalisé de nombreuses recherches sur les plugins, à savoir les API suivantes :
google maps, ADEweb, google lattitude(logo), openstreetmap, twitter, facebook

#### Recherches complémentaires ####
Nous avons réalisé des recherches complémentaires sur le serveur d'application Apache Tomcatet  le framework OSGi. Concernant la possibilité d'authentification sur l'interface d'administration, nous avons élaboré des recherches sur Spring security et la technique de l'openID.

### GWT ###

[Google Web Toolkit](http://code.google.com/intl/fr-FR/webtoolkit/) est un ensemble d’outils logiciels développé par Google permettant de  créer et maintenir des applications web dynamiques. Il met en oeuvre du JavaScript après compilation de Java. Ce logiciel est libre, placé sous licence Apache 2.0.


#### Principe ####

Le principe est simple. GWT propose une API Java qui permet de développer comme à l’habitude avec la possibilité de débugger avec des points d’arrêt. La compilation se fait grâce à un compilateur fourni parmi les outils GWT. Il permet d’obtenir des objets JavaScript à partir d’instances Java. Le compilateur est basé sur une correspondance de source Java/source JavaScript. À un type d’objet Java défini depuis l’API GWT est associé un objet JavaScript. Le compilateur permet de coder pour différents navigateurs grâce à ses règles de permutation. Ces règles de permutation s’appuient sur le principe d’un javascript pour un navigateur donné. L’internationalisation est gérée de la même façon. Au final, un objet JavaScript correspondra à un objet Java pour un navigateur donné et une langue donnée. Par défaut, une version anglaise par navigateur est générée mais d’autres spécification sont possibles dans les fichiers de configuration. Le code JavaScript généré utilise les techniques de HTML dynamique et de manipulation du Document Object Model pour l’animation de l’interface. Après compilation, on peut obtenir l’ensemble de ces objets graphiques :
  * Panneaux
  * Boutons
  * Cases à cocher
  * Tables / Grilles
  * Boîtes de dialogues
  * Primitive HTML (dont les images et les hyperliens)
  * Menus et barres de menus
  * Fenêtres défilantes
  * Onglets
  * Arbres


GWT comporte :
  * un compilateur Java vers JavaScript
  * un navigateur spécialement modifié pour permettre l'exécution (et le débogage) de code Java natif sans nécessiter la compilation JavaScript
  * une bibliothèque d'émulation JRE
une bibliothèque de composants graphiques contenant des widgets de base permettant la construction d'une interface graphique

Google propose un plugin Eclipse fournissant tous le outils nécessaires pour développer et compiler avec GWT.


#### Pourquoi utiliser GWT? ####

Le développement web en est facilité. Coder une page revient seulement à créer un ensemble de classes Java utilisant l’API proposée. L’aperçu est plus clair et le rendu est facilement débuggable.
L'internationalisation et les différences entre navigateurs est immédiate. Le développeur n’a pas à s’en soucier.
Le JavaScript généré est «comprimé». Cela veut dire qu’il est optimisé et ainsi rapidement téléchargeable depuis un navigateur.


#### SmartGWT ####

[SmartGWT](http://code.google.com/p/smartgwt/) est un framework basé sur Google Web Toolkit qui propose des objets plus esthétiques et une API plus intuitive. SmartGWT possède une communauté très riche et un [showcase](http://www.smartclient.com/smartgwt/showcase/#main) offrant plus de 250 exemples de code.

### Spring ###

Spring est un framework d'application du monde Java EE. Son rôle principal est de fournir à l'architecte logiciel une grande facilité pour intégrer et configurer différents modules logiciels dans un tout applicatif. Il s'appuie pour cela sur le patron de conception IoC (Invertion of Control) qui dans son implémentation Spring permet l'instantiation, la configuration et l'injection de dépendances logicielles spécifiées à l'aide de fichiers de configuration XML ou d'annotations Java.

Le projet Spring permet la réalisation et l'intégration de nombreux types d'application, utilisant des fonctionnalités très diverses : c'est à la fois une boite à outil et un "moule" applicatif qui est paradoxal dans la mesure où il est conçu pour créer le moins de dépendances possibles vers le framework dans les projets qui l'utilisent.

Nous utilisons un sous-ensemble étroit des fonctionnalités offertes par Spring. Nous l'utilisons pour :
  * configurer et gérer les transactions liés aux accès à la base de données (module domain)
  * gérer la dépendance des modules du projet vers le module domain (modules core et admin-server)
  * implémenter l'interface web de certains modules (modules core, admin-server et tous les plugins coté serveur)

### Apache Maven ###

Nous utilisons l'outil de gestion Maven pour gérer la compilation et le déploiement des modules serveur du projet. Le rôle de Maven est d'interpréter le fichier de configuration du projet (pom.xml) pour :
  * automatiquement récupérer l'ensemble des bibliothèques logicielles utilisées par le projet, ainsi que leurs dépendances
  * compiler le projet
  * exécuter les tests du projet
  * déployer le produit logiciel, sous la forme de module utilitaire, d'application web, etc.

L'utilisation d'un tel outil évite la gestion manuelle et fastidieuse des bibliothèques et dépendances, même s'il rajoute une couche de compléxité au projet. Nous avons également constaté que son utilisation dans un projet où les machines de développement n'ont pas un accès constant à l'Internet est problématique.

### Apache Tomcat ###

Nous utilisons le conteneur de servlets Apache Tomcat pour héberger les modules serveurs du projet. Ce choix est basé sur la popularité de ce produit, et sa relative facilité de configuration et légèreté.

# Perspectives du projet #

## Communication ##

## Evolution ##

# Conclusion #