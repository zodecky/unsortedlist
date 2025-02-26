J’ai dû créer un projet Maven car ce ne serait pas compliqué. Je l’ai réalisé avec IntelliJ, mais j’ai également importé le projet dans Eclipse et cela fonctionne là aussi (en tant que projet Maven). Si cela ne fonctionne pas, veuillez copier les fichiers manuellement (ils se trouvent dans les dossiers src et test).

J’ai trouvé deux bugs :
		
1.	Dans remove(int pos) :
Il manque un décrément de la taille après avoir supprimé un nœud (sauf lors de la suppression du premier élément, qui appelle pop()). J’ai donc ajouté size--;.
	
2.	Dans equals(Object obj) :
La vérification de l’égalité n’est pas sécurisée pour les valeurs null. Si la liste contient des éléments null, appeler .equals sur une référence null lancera une exception. J’ai modifié le code en utilisant !java.util.Objects.equals(thisLink.element, thatLink.element), ce qui est null-safe.

Coverage : line 98 %, branches 92 %.