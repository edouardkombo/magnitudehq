# Plugins #
Chaque plugin a pour but de gérer un type de données. Du coté serveur, chaque plugin sera une application web Java.

A ceci peut s'ajouter si nécessaire des paramètres en POST. Exemple :

```
longitude=1.45
latitude=42.5
```

Les plugins suivants ont été réalisés :


## Bâtiments de l'INSA Toulouse ##
Plugin indiquant les bâtiments de l'INSA Toulouse.
L'utilisateur peut ensuite demander la liste des salles disponible pour un bâtiment particulier grâce au gestionnaire d'emploi du temps ADE.
### Liste des fonctions disponibles ###
| **Clé** | **Paramètres** | **Action** |
|:---------|:----------------|:-----------|
|pois|deviceId|Retourne les coordonnées des bâtiments |
|availablerooms|deviceId,buildingId,year,month,day,hour,minute|Retourne les salles libres d'un bâtiment à un moment donné |
|mytodaycourses|deviceId,groupId,year,month,day|Retourne les cours de la journée d'un groupe donné |
|groups|deviceId|Retourne les groupes et leur id de l'insa de toulouse |

Il est possible de simuler ces fonctions à l'adresse suivante : http://demo.magnitudehq.com/insatoulouse/

### Fonctionnement ###
Les coordonnées ont été récupérées grâce au site Open Street Map (voir [plugin du même nom](#Open_Street_Map.md)) et sont stockées dans un fichier XML du plugin.
Les données ADE du plugin ont été récupérées via l'API d'[ADEweb](http://cri-srv-ade.insa-toulouse.fr:8080/) proposée par le CRI de l'INSA de Toulouse. La doc de l'API est disponible dans la zone de [téléchargements](http://code.google.com/p/magnitudehq/downloads/detail?name=Web%20Api.pdf&can=2&q=)

### Un exemple ###

Obtenir les cours du groupe B2 de la journée du 14/06/2010
```
http://demo.magnitudehq.com/insatoulouse/mytodaycourses?deviceId=test&groupId=870&&year=2010&month=06&day=14
```

Retour :
```
{

    
     
      55755: {
          start: "9:30"
          teacher: "HLADIK P-E."
          room: "GEI TP Informatique"
          stop: "12:15"
          name: "TP Système d'exploitation temps réel"
          
            
            date: {
                formattedDate: "06/14/2010"
                year: "2010"
                month: "06"
                day: "14"
            }
          group: "4GEI_INFO_B2"
      }
    
     
      56641: {
          start: "14:00"
          teacher: "LEHAUX T."
          room: "GEI TP Informatique"
          stop: "16:45"
          name: "TP IA 4/4"
          
            
            date: {
                formattedDate: "06/14/2010"
                year: "2010"
                month: "06"
                day: "14"
            }
          group: "4GEI_INFO_B2"
      }

}
```

## Open Street Map ##
Plugin informant sur l'environnement voisin de l'utilisateur grâce aux données d'[Open Street Map](http://www.openstreetmap.org/), site de cartographie aux données ouvertes, disponibles sous la licence [Creative Commons Attribution-ShareAlike 2.0](http://creativecommons.org/licenses/by-sa/2.0/) (CC-BY-SA).

### Liste des fonctions disponibles ###
| **Clé** | **Paramètres** | **Valeurs** |
|:---------|:----------------|:------------|
|getPOI|longitude, latitude|Retourne tous les POI à proximité|
|getPOI| 	+ building=false|	Enlève les bâtiments de la liste des POI retournés|
|getPOI| 	+ subway=false|	Enlève les métros de la liste des POI retournés|
|getPOI| 	+ bicycle=false|	Enlève les station de vélo de la liste des POI retournés|
|getPOI|	+ bus=false|	Enlève les arrêts de bus de la liste des POI retournés |

Open Street map stockant un très grand nombre de type de POI, il serait possible d'étendre cette liste de fonctionnalités avec par exemple : les cafés, restaurants, distributeurs de billets...

### Fonctionnement ###
Open Street Map met à disposition ses données dans différents formats : HTML, PNG, XML...
Nous utilisons donc les données au format XML pour ensuite les traiter afin de sélectionner les informations qui nous intéressent.
Pour récupérer les données, il est nécessaire de spécifier une zone de sélection des informations. Nous utilisons pour cela l'URL suivante :
```
http://api.openstreetmap.org/api/0.6/map?bbox=<latMin>,<lonMin>,<latMax>,<lonMax>
<latMin> : Latitude minimale de la zone de sélection
<lonMin> : Longitude minimale de la zone de sélection
<latMax> : Latitude maximale de la zone de sélection
<lonMax> : Longitude minimale de la zone de sélection
```
Pour limiter le nombre d'informations à traiter tout en laissant une distance acceptable de visibilité des POI, nous avons choisi de sélectionner les informations sur un peu plus d'un 1km². Le plugin recherche donc dans un périmètre de moins à plus 0,005° en longitude et latitude par rapport à la position du téléphone.

Le fichier XML récupéré est ensuite converti grâce à des transformations XSLT. Nous utilisons un fichier XSL par fonctionnalité. Le principe est cependant globalement le même : Le plugin parcourt le fichier à la recherche des POI qui l'intéressent et pour chacun, il récupère chaque coordonnées de ce POI.

## Where is my ##
Plugin permettant de se fabriquer sa propre liste de Points d'Intérêts.

### Liste des fonctions disponibles ###
| **Clé** | **Paramètres** | **Action** |
|:---------|:----------------|:-----------|
|getPOI|userId|Retourne la liste des POI de l'utilisateur|
|addPOI|userId, longitude, latitude, altitude, name|Ajoute le nouveau POI à l'utilisateur et retourne la nouvelle liste|
|deletePOI|userId, poiId|Supprime le POI concerné et retourne la nouvelle liste|

### Fonctionnement ###