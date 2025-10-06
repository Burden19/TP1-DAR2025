// Activite 1-1

////apres la creation du server :

//Resultat du serveur :
Je suis un serveur en attente la connexion d'un client


////apres la creation du client :

//Resultat du serveur:
Je suis un serveur en attente la connexion d'un client
Un client est connecté
Connexion terminée

//Resultat du client :
Je suis un client pas encore connecté...
Je suis un client connecté
Connexion terminée

//Activite 1-2
En utilisant la methode InputStream et OutputStream le programme ne fonctionne pas correctement avec
les nombres negative et avec zero
donc on utilise la methode DataInputStream et DataOutputStream pour manipuler les entiers negatives
////partie 2 : implementation d'un saisie successive des entiers sans la fermeture du connexion
on utilise un boucle while:
// resultat affiche par le client :
Je suis un client pas encore connecté...
Je suis un client connecté
Entrez un entier (tapez 0 pour quitter) : 17
Résultat reçu du serveur : 119
Entrez un entier (tapez 0 pour quitter) : -17
Résultat reçu du serveur : -119
Entrez un entier (tapez 0 pour quitter) : 0
Fermeture de la connexion..
Connexion terminée