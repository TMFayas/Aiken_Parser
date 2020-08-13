Ce projet permet aux utilisateur de Moodle de créer plus facilement les question. Actuellement seul les questions de type QCM, apparaillement et réponse courte sont prise en compte. 
le système prends un fichier textuel écrit sous le format Aiken (modifié) et en sortie le système fournit un fichier XML Moodle (à importer sur Moodle), un fichier PDF avec les questions.

# Utilisation

  # Format Aiken modifié
  ## QCM
  Format
# code block
Description ? ou :
A. ChoixA 
B. ChoixB
.... 
ANSWER : A,B... 
  Exemple
# code block
Quelle est la capital de France ?
A. New York
B. Paris
C. Berlin
ANSWER: B

  ## Aparaillement
  Format
# code block
Description ? ou :
A. ChoixA
B. ChoixB
...
a. Reponsea
b. reponseb
...
LINKS: A->a, B->b,...
  Exemple


