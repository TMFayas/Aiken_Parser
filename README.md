Ce projet permet aux utilisateur de Moodle de créer plus facilement les question. Actuellement seul les questions de type QCM, apparaillement et réponse courte sont prise en compte. 
le système prends un fichier textuel écrit sous le format Aiken (modifié) et en sortie le système fournit un fichier XML Moodle (à importer sur Moodle), un fichier PDF avec les questions.

# Utilisation

  # Format Aiken modifié
    ## QCM
      Format
Description ? ou :\n
A. ChoixA \n
B. ChoixB \n
.... \n
ANSWER : A,B... \n
      Exemple\n
Quelle est la capital de France ?\n
A. New York\n
B. Paris\n
C. Berlin\n
ANSWER: B\n

    ## Aparaillement
      Format
Description ? ou :
A. ChoixA
B. ChoixB
...
a. Reponsea
b. reponseb
...
LINKS: A->a, B->b,...
      Exemple


