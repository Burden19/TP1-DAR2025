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
15 + abc


//activite 2-1
en utilsant la methode BufferedInputStream et BufferedOutputStream le client envoit l'operation comme une Objet
de type String(pas comme dans l'activite 1-2 ou il l'envoi comme une octet
on a implimente une verification de syntax de l'opertion (pas d'erreurs)


 // activite 2-2
dans cette activitee on utlise les methode ObjectInputStream et ObjectOutputStream pour que le client envoi
l'operation comme un objet du classe Operation et le serveur fait la calculation selon les argument
apres fair la validation du syntax.

// activite 3-1
