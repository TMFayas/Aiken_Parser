Ce projet permet aux utilisateur de Moodle de créer plus facilement les questions. Actuellement seul les questions de type QCM, apparaillement et réponse courte sont prise en compte. 
le système prends un fichier textuel écrit sous le format Aiken (modifié) et en sortie le système fournit un fichier XML Moodle (à importer sur Moodle), un fichier PDF avec les questions.

# Utilisation

  # Format Aiken modifié
  ## QCM
  Format

Description ? ou :\
A. ChoixA \
B. ChoixB\
.... \
ANSWER : A,B...

**Exemple**

Quelle est la capital de France ?\
A. New York\
B. Paris\
C. Berlin\
ANSWER: B

  ## Appariement
**Format**

Description ? ou :\
A. ChoixA\
B. ChoixB\
...\
a. Reponsea\
b. reponseb\
...\
LINKS: A->a, B->b,...

**Exemple**

Appariez la capitale à son pays :\
A. Canada
B. Italie
C. Japon
a. Tokyo
b. Rome
c. Ottawa
LINKS: A->c, B->b, C->a

  ##Réponses courte
  
**Format**

Description ? ou :
RESPONSES: Choix1, Choix2,...

**Exemple**

Quel est le résultat de 2+2 ?
RESPONSES: 4, Quatre, IV


# Instruction

Récuperer tous le projet dans son ensemble. Une fois les dossiers récupérés il faut exécuté le fichier execute.sh avec comme option le nom du fichier Aiken qui comporte les questions, le nom du fichiers XML à la sortie et ainsi que le nom du fichier PDF à la sortie (le fichier PDF est créer à partir d'un fichier LaTex).

  `./execute.sh Exemple.txt fileXML.xml filePDF.tex`




