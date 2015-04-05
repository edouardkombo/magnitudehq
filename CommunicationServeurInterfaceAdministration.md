# Principe #

Le communication client serveur est bâtie sur l'architecture, inventée par Roy Fielding, Representational State Transfer (REST).

Ce style architectural est de plus en plus utilisé pour la réalisation d’architectures orientées services utilisant des services Web destinés à la communication entre machines. REST se pose en alternative au style architectural RPC et à la plupart des cas d’utilisation de SOAP. C'est une alternative censée être plus simple à mettre en œuvre. Les systèmes qui suivent ces principes sont souvent appelés [RESTful](http://fr.wikipedia.org/wiki/REST).

On invoque les différentes fonction par une combinaison d'une URI et d'une opération HTTP (GET, POST, …). Dans notre cas les réponses au requêtes sont en [JSON](http://json.org/json-fr.html).

# Fonctions disponibles #

Une ensemble de fonction se basant sur cette architecture est disponible. Par exemple, pour la partie gestion de plugins, il existe les cinq fonctions suivantes :
  * ajout d'un plugin
  * suppression d'un plugin
  * modification d'un plugin
  * liste de tous les plugins
  * détails d'un plugin

## Un exemple : la récupération des détails d'un plugin ##

Méthode: GET <br />
Chemin: `<url-serveur>`/plugins/details <br />
Paramètres HTTP: id: `<plugin-id>` <br />
Sortie:

```
{
    "id": <plugin id>,
    "name": <name>,
    "description": <description>,
    "versions": [
        {
            "version": <version number>,
            "status": <version status>,
            "dependencies": [
                {
                    "pluginId": <dependency plugin id>,
                    "version": <dependency version number>
                },
                <...>
            ]
        },
        <...>
    ]
}
```

Et un code de réponse HTTP : 200 si OK, un code différent de 200 sinon.

## Evolutivité ##

L'architecture REST peut être utilisée par l'ensemble des solutions permettant de se connecter à internet. Ainsi, on peut facilement envisager d'administrer le serveur au travers des fonctions précédentes depuis l'application ou le navigateur web du mobile, ou depuis un client lourd.

# REST et SmartGWT #

Une architecture REST est simple à mettre en place, puisqu'elle ne fait appel qu'à des requêtes HTTP. SmartGWT intègre une gestion avancée des requêtes dans la classe `com.smartgwt.client.data.DataSource`. Cette classe permet de gérer les GET. Pour les POST, afin d'avoir un contrôle total sur la requête nous avons créé nous même une fonction d'envoie de requête en utilisant la classe `com.google.gwt.http.client.Request de GWT`.