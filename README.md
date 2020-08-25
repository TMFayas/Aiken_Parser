Ce projet permet aux utilisateurs de Moodle de créer plus facilement les questions. Actuellement seules les questions du type QCM, appariement et réponse courte sont prises en compte. 
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

Récupérer tous le projet dans son ensemble. Une fois les dossiers récupérés il faut exécuter le fichier execute.sh avec comme option le nom du fichier Aiken qui comporte les questions, le nom du fichier XML à la sortie et ainsi que le nom du fichier PDF à la sortie (le fichier PDF est créé à partir d'un fichier LaTex).

  `./execute.sh Exemple.txt fileXML.xml filePDF.tex`

En cas d'échec vérifier que vous avez bien installé JavaCC et pdflatex.
**JavaCC**
suivre les instruction sur https://javacc.github.io/javacc/#download

**pdflatex**
  
  `sudo apt install texlive-base


