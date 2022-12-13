Bases du langage

Java

== 

## Anatomie d'un programme

On a coutume de dire que « Tout est objet en Java ». Cela signifie que
pour écrire le moindre programme, il est nécessaire de créer au moins
une classe dont la structure doit être la suivante :

....
1    public class NomDeLaClasse 
2    { 
3        //LE CODE DE VOTRE PROGRAMME 
4        public static void main(String[] args) 
5        { 
6            //LE CODE DE VOTRE PROGRAMME 
7        } 
8        //LE CODE DE VOTRE PROGRAMME 
9    }
....

Pour plus d’informations sur la création d’une telle classe, veuillez
vous référer au chapitre précédent au niveau de la section Premier
programme.

Le point d’entrée de votre programme est la méthode `main` dont la
signature doit être celle présentée dans l’exemple à la ligne 4. Le code
de cette méthode est délimité par les accolades ouvrantes et fermantes
des lignes 5 et 7.

Cette méthode est incluse dans une classe dont la déclaration est
réalisée à la ligne 1. Le code de la classe se situe entre les accolades
ouvrantes et fermantes des lignes 2 et 9.

Tous les exemples de ce chapitre respecteront cette organisation.

== 

## Les variables

=== 

# Introduction

Les variables permettent de mémoriser pendant l'exécution d’une
application différentes valeurs utiles à son bon fonctionnement. Avant
d'utiliser des variables dans un programme, il convient de savoir où les
déclarer, quel nom leur donner et quel type leur donner. C'est
l'objectif des prochaines sections.

=== Les emplacements

Les variables en Java peuvent être déclarées n'importe où dans le
programme. Il n'y a pas d'emplacements réservés. Cela dit, il y a juste
une règle à respecter : les variables doivent être déclarées uniquement
entre les accolades délimitant les classes, les interfaces ou les
énumérations. Elles ne peuvent pas être en dehors de ces éléments.

Une variable doit obligatoirement être déclarée avant son utilisation
dans le code. En fonction de l'emplacement de sa déclaration, une
variable appartiendra à une des catégories suivantes :

* Déclarée à l'intérieur d'une classe, la variable est une _variable
d'instance_. Elle n'existera que si une instance de la classe est
disponible (autrement dit un objet). Chaque instance de classe aura son
propre exemplaire de la variable.
* Déclarée à l'intérieur d'une classe avec le modificateur `static`, un
mot-clé du langage, la variable est une _variable de classe_. Elle est
accessible directement par le nom de la classe et n'existe qu'en un seul
exemplaire, quel que soit le nombre d'objets créés à partir de cette
classe.
* Déclarée à l'intérieur d'une méthode, la variable est une _variable
locale_. Elle n'existe que pendant l'exécution de la méthode et n'est
accessible que par le code de celle-ci.
* Les _paramètres_ des méthodes peuvent être considérés comme des
variables locales. La seule différence réside dans l'initialisation de
la variable qui est effectuée lors de l'appel de celle-ci. La structure
de programme suivante permet de visualiser l’emplacement de ces
différentes catégories de variables :

....
1    public class EmplacementDesVariables 
2    { 
3        //VARIABLES D’INSTANCE 
4        //VARIABLES DE CLASSE 
5        ... uneMethode(/*PARAMETRES*/) 
6        { 
7            //VARIABLES LOCALES 
8        } 
9    }
....

=== Le nom

Le nom des variables doit respecter certaines règles même si une assez
grande liberté est accordée au développeur :

* Le nom d'une variable commence obligatoirement par une lettre.
* Il peut être constitué de lettres, de chiffres ou du caractère
souligné (_).
* Il peut contenir un nombre quelconque de caractères (en pratique, il
vaut mieux se limiter à une taille raisonnable).
* Il y a une distinction entre minuscules et majuscules (la variable
`AGEDUCAPITAINE` est différente de la variable `ageducapitaine`).
* Les mots-clés du langage ne doivent pas être utilisés comme nom de
variable. 
* Par convention, le nom des variables est orthographié en lettres
minuscules sauf la première lettre de chaque mot (à partir du second
mot) si le nom de la variable en comporte plusieurs (`ageDuCapitaine`).

=== Les types

==== Présentation

En spécifiant un type pour une variable, nous indiquons quel type
d’informations nous allons pouvoir stocker dans cette variable et par
conséquent les opérations que nous allons pouvoir effectuer dessus.

Deux catégories de types de variables sont disponibles :

* Les types valeurs : la variable contient réellement les informations.
* Les types références : la variable contient l'adresse mémoire où se
trouvent les informations.

Le schéma suivant résume ce concept. Il représente la mémoire d’une
application et les variables qu’elle utilise. Il est important de
maîtriser ce concept, car cela a des impacts que l’on étudiera par la
suite.

image:images/02RI01.png[image,width=344,height=169]

La variable nommée `variableTypeValeur` est associée à un espace
mémoire contenant directement la valeur. Dans l'exemple, la valeur est
un numérique entier (`10`).

La variable nommée `variableTypeReference` est associée à un espace
mémoire contenant une adresse d'un autre espace mémoire. Cette adresse
est matérialisée par le `@`. À cette adresse se trouve un espace mémoire
contenant lui-même deux informations : une variable `variable1` de type
valeur et une variable `variable2` de type référence. Derrière ce
mécanisme se cache la notion de _pointeurs_ largement utilisée par les
développeurs C++ notamment. C'est la représentation classique d'un
objet.

==== Les types valeurs

Les types valeurs représentent les types de plus bas niveau à partir
desquels il est possible de manipuler n'importe quelle information,
aussi complexe soit-elle. Ils sont représentés par les types primitifs.

Java met à disposition sept types primitifs regroupés en quatre
catégories : les numériques entiers, les numériques décimaux, les
caractères et les booléens. Avec ces quatre catégories, il est possible
de manipuler n'importe quelle information de base, comme par exemple :

* l'âge d'une personne,

image:images/02RI02.png[image,width=47,height=42]

* la distance entre deux villes,
* une lettre,
* …

==== Les types références

Lorsque l'information à manipuler est plus complexe, une variable de
type référence est plus adaptée. Une variable de type référence permet
de regrouper un ensemble de variables cohérentes entre elles.

C'est le cas par exemple d'une date. Une date ne peut pas être
représentée par un type primitif, car il faut une variable pour l'année,
une variable pour le mois et une variable pour le jour. Une date est
représentée par l'utilisation de trois variables de type numérique
entier.

image:images/02RI03.png[image,width=169,height=128]

Une variable de type référence est tout simplement une variable
référençant un objet. Le chapitre suivant Programmation Objet est dédié
à ce sujet. Les types références incontournables sont toutefois abordés
dans une prochaine section de ce chapitre (Les types références) pour
aborder la manipulation des tableaux, des chaînes de caractères et des
dates.

=== La déclaration, l'initialisation, l'affectation

==== La déclaration

À présent que les catégories de variables sont connues, il est temps de
s'attacher à la déclaration de variables. La déclaration d'une variable
doit respecter la structure suivante :

....
[modificateur] type nomDeLaVariable;
....

Après d'éventuels modificateurs, une variable est déclarée en
définissant son type suivi de son nom. La déclaration se termine par un
point-virgule.

Il est possible de déclarer plusieurs variables du même type sur la même
ligne en séparant le nom des variables par une virgule :

....
type variable1, variable2, ...;
....

Voici quelques exemples :

....
int age; 
Date aujourdhui, hier;
....

==== L'initialisation

L'initialisation est l'étape par laquelle on fournit la première valeur
à une variable.

L'initialisation peut être réalisée au même moment que la déclaration :

....
[modificateur] type nomDeLaVariable = valeur;
....

L'initialisation peut être réalisée après la déclaration de la
variable :

....
[modificateur] type nomDeLaVariable; 
nomDeLaVariable = valeur;
....

L'opérateur nécessaire pour initialiser une variable est le `=`.

`valeur`, dans l'exemple, peut prendre différentes formes :

* Une valeur littérale :

....
age = 41;
....

* Une autre variable :

....
int agePremierJumeau = 25; 
int ageSecondJumeau = premierJumeau;
....

La représentation de ce cas de figure en mémoire est le suivant :

image:images/02RI04.png[image,width=179,height=36]

Comme vous pouvez l'observer, chaque variable gère sa valeur
indépendamment de l'autre. Il y a eu une copie de la valeur de la
variable `agePremierJumeau` dans l'espace mémoire alloué à la variable
`ageSecondJumeau`. Si je modifie l'âge d'un des jumeaux, la valeur n'est
pas reportée pour l'autre jumeau. C'est le comportement que l'on peut
observer pour tous les types valeurs.

Ce n'est pas la même chose pour les types références. Prenons l'exemple
suivant :

....
Date d1 = new Date(2019,3,6); 
Date d2 = d1;
....

Cet exemple n'a pas de réalité en Java, une date étant créée d'une
manière plus complexe. Cela n'a pas d'impact pour la démonstration
actuelle.

La représentation de ce cas de figure en mémoire est le suivant :

image:images/02RI05.png[image,width=175,height=121]

Comme vous pouvez l'observer, la valeur de la variable `d2` correspond à
la même adresse que la variable `d1`. Le comportement est donc le même
que pour les variables de types valeurs : il y a eu une copie de la
variable `d1` (en l'occurrence une adresse) dans l'espace mémoire alloué
à la variable `d2`. Les conséquences sont cependant différentes. En
effet, les variables `d1` et `d2` sont étroitement liées, car elles
partagent les mêmes variables `jour`, `mois` et `annee`. 

* Un appel de fonction retournant une valeur :

....
int age = calculerAge(dateNaissance);
....

==== L'affectation

L'affectation est l'étape par laquelle on change la valeur d'une
variable. L'initialisation peut donc être considérée comme une
affectation particulière.

L'affectation d'une variable respecte la déclaration suivante :

....
nomDeLaVariable = valeur;
....

Pour plus de détails, référez-vous à la section L'initialisation.

Il est nécessaire maintenant de connaître les types disponibles.

=== Les types valeurs

==== Les types numériques entiers

Il existe quatre types différents pour manipuler des numériques. Chacun
de ces types utilise un espace de stockage différent permettant de
manipuler des valeurs plus ou moins grandes. Le tableau suivant présente
ces quatre types avec les valeurs minimales et maximales acceptées et
l'espace de stockage utilisé.

[width="100%",cols="17%,34%,32%,17%",options="header",]
|==========================================================
|Types entiers signés | | |
|`byte` |-128 |127 |8 bits
|`short` |-32768 |32767 |16 bits
|`int` |-2147483648 |2147483647 |32 bits
|`long` |-9223372036854775808 |9223372036854775807 |64 bits
|==========================================================

Lorsque vous choisissez un type pour vos variables entières, vous devez
prendre en compte les valeurs minimales et maximales que vous envisagez
de stocker dans la variable afin d'optimiser la mémoire utilisée par la
variable. Il est en effet inutile d'utiliser un type `long` pour une
variable dont la valeur n'excédera pas 50, un type `byte` est dans ce
cas suffisant. L'économie de mémoire semble dérisoire pour une variable
unique, mais devient appréciable lors de l'utilisation de tableaux de
grande dimension.

Prenons l’exemple de la classe `GestionValeurs` qui a pour objectif
d’additionner des valeurs numériques entières. Pour répondre à ce
besoin, il est possible de déclarer les deux variables locales
suivantes, de type `int` et `long`, dans la méthode `main` :

....
1    public class GestionValeurs 
2    { 
3        public static void main(String[] args) 
4        { 
5            int valeur; 
6            long sommeValeur; 
7        } 
8    }
....

La variable `valeur` acceptera successivement des `valeurs` entre
-2147483648 et 2147483647. Cette valeur sera ensuite ajoutée à la
variable `sommeValeur`. Si l'analyse fonctionnelle indique que la somme
peut dépasser la limite d'un numérique entier de type `int`, il convient
de déclarer la variable `sommeValeur` avec le type `long`. Si ce n'est
pas le cas, le type `int` peut être suffisant.

Tous les types entiers sont signés, c’est-à-dire qu’ils permettent de
gérer des valeurs positives et négatives. Il est cependant possible de
travailler avec des valeurs entières non signées en utilisant les
classes `Integer` et `Long`. Ceci permet d'étendre la valeur positive
maximale admissible jusqu'à 4294967296 pour un type `int` et jusqu'à
18446744073709551616 pour un type `long`.

==== Les types numériques décimaux

[width="100%",cols="22%,26%,35%,17%",options="header",]
|===================================================
|Types numériques signés | | |
|`float` |1.4E-45 |3.4028235E38 |32 bits
|`double` |4.9E-324 |1.7976931348623157E308 |64 bits
|===================================================

Tous les types décimaux sont signés et peuvent donc contenir des valeurs
positives ou négatives.

Les variables de types `float` et `double` occupent le même espace de
stockage que les variables de types `int` et `long`. Cependant, elles
sont capables de stocker des valeurs d'une plage beaucoup plus grande.
Ceci est possible en sacrifiant la précision. En effet, ces types
décimaux ne sont que des approximations. Le type `float` enregistre au
maximum huit chiffres significatifs et le type `double` 17 chiffres
significatifs.

==== L'utilisation de valeurs littérales

Il est très fréquent d'initialiser les variables d'un type numérique
avec une valeur littérale :

....
int populationFrancaise = 66990000; 
double pourcentageFemme = 51.649;
....

Le compilateur (`javac`) interprète les valeurs numériques entières
comme des valeurs de type int et les valeurs numériques décimales comme
des valeurs de type `double`. En conséquence, les deux déclarations
ci-dessus compilent.

Dans les déclarations suivantes, une erreur de compilation intervient :

....
byte b = 153;
....

Le compilateur indique l'erreur suivante :

image:images/02RI06.png[image,width=224,height=83]

La valeur `153` est en dehors de la plage de valeurs acceptable par une
variable de type `byte`. Le compilateur indique qu'il est impossible
pour lui de convertir cette valeur de type `int` et en `byte`. Si la
valeur définie est comprise dans la plage du type, le problème
disparaît.

Le même comportement est observable pour le type `short` lorsque l'on
tente d'initialiser la variable avec une valeur en dehors de la plage
acceptable par ce type.

La même erreur survient lorsque le développeur tente d'initialiser une
variable de type `float` avec une valeur littérale décimale (considérée
comme un type `double`). La différence est que le compilateur lèvera une
erreur même si la valeur est dans la plage acceptable du type `float`
comme dans l'exemple suivant :

....
float f = 10.1;
....

Le compilateur indique l'erreur suivante :

image:images/02RI09.png[image,width=245,height=83]

Pour corriger ce problème, il faut indiquer au compilateur d'interpréter
la valeur littérale comme une valeur de type `float`. Pour réaliser
cette opération, il suffit de suffixer le nombre par la lettre `F` (pour
`float`) en majuscule ou minuscule :

....
float f = 10.1F;
....

Le deuxième cas de figure où il est possible de rencontrer une erreur
est lorsque le développeur souhaite initialiser une variable de type
`long` avec une valeur numérique dépassant la plage de valeurs
acceptables pour une variable de type `int`.

....
long l = 10123456789;
....

Je vous rappelle que le compilateur interprète les valeurs littérales
numériques entières comme des valeurs de type `int`. L'erreur rencontrée
avec l'exemple précédent est la suivante :

image:images/02RI07.png[image,width=234,height=42]

Pour corriger ce problème, il faut indiquer au compilateur d'interpréter
la valeur littérale comme une valeur de type `long`. Pour réaliser cette
opération, il suffit de suffixer le nombre par la lettre `L` (pour
`long`) en majuscule ou minuscule :

....
long l = 10123456789L;
....

Les valeurs numériques décimales peuvent être exprimées avec la notation
décimale ou la notation scientifique.

....
float surface=2356.8f;  
float surface=2.3568e3f;
....

Vous pouvez insérer des caractères _ dans les valeurs numériques
littérales pour faciliter la lecture. Les deux syntaxes suivantes sont
équivalentes.

....
long quantite=1234876567; 
long quantite=1_234_876_567; 
....

==== Le type caractère

Le type `char` est utilisé pour stocker un caractère unique. Une
variable de type `char` utilise deux octets pour stocker le code
_Unicode_ du caractère. Dans le jeu de caractères Unicode, les 128
premiers caractères sont identiques au jeu de caractères _ASCII_, les
caractères suivants, jusqu'à 255, correspondent aux caractères spéciaux
de l'alphabet latin (par exemple les caractères accentués), le reste est
utilisé pour les symboles ou les caractères d'autres alphabets.

....
char caractereC = 'c';
....

Les caractères spécifiques ou ceux ayant une signification particulière
pour le langage Java sont représentés par une séquence d'échappement.
Elle est constituée du caractère `\` suivi d'un autre caractère
indiquant la signification de la séquence d'échappement. Le tableau
suivant présente la liste des séquences d'échappement et leurs
significations.

[width="100%",cols="50%,50%",options="header",]
|=======================
|Séquence |Signification
|`\t` |Tabulation
|`\b` |BackSpace
|`\n` |Saut de ligne
|`\r` |Retour chariot
|`\f` |Saut de page
|`\'` |Simple quote
|`\"` |Double quote
|`\\` |Antislash
|=======================

Les caractères Unicode non accessibles au clavier sont eux aussi
représentés par une séquence d'échappement constituée des caractères
`\u` suivis de la valeur hexadécimale du code Unicode du caractère. Le
symbole euro est par exemple représenté par la séquence `\u20AC`.

....
char euro1 = '€'; 
char euro2 = '\u20AC';
....

Pour acquérir des connaissances sur les caractères Unicode, vous pouvez
consulter la ressource Wikipedia qui constitue un bon point de démarrage
à l'adresse suivante :
_https://fr.wikipedia.org/wiki/Table_des_caractères_Unicode_

Une chaîne de caractères est représentée par la classe `String`. Cette
classe manipule un tableau de caractères. La notion de tableau et la
classe String sont abordées un peu plus loin dans ce chapitre dans la
section Les types références.

==== Le type boolean

Le type `boolean` permet d'avoir une variable qui peut prendre deux
états : vrai/faux, oui/non, on/off.

L'affectation se fait directement avec les valeurs `true` ou `false`
comme dans l'exemple suivant :

....
boolean disponible, modifiable;  
disponible=true;  
modifiable=false;
....

Il est impossible d'affecter une autre valeur à une variable de type
`boolean`.

=== Les types références

Les tableaux, les chaînes de caractères, les variables complexes sont
des variables de types références. Les tableaux permettent de gérer des
ensembles de variables (souvent de même type). Les chaînes de caractères
permettent de gérer des ensembles de caractères. Les variables complexes
permettent elles aussi de gérer un ensemble de variables. Le type des
variables complexes est souvent une classe. Par exemple, une classe
`Personne` permet de caractériser une personne en regroupant différentes
informations dans autant de variables que nécessaire : le nom (de type
`String`), le prénom (de type `String`), l'âge (de type `int`).

Le chapitre suivant traite de la programmation orientée objet avec la
création et la manipulation des classes. Les prochaines sections du
chapitre actuel traitent des types références incontournables : les
tableaux, les chaînes de caractères et les dates.

==== Les tableaux

Les tableaux permettent de faire référence à un ensemble de variables de
même type par le même nom et d'utiliser un index pour les différencier.
Un tableau peut avoir une ou plusieurs dimensions. Le premier élément
d'un tableau a toujours pour index zéro. Le nombre de cases du tableau
est spécifié au moment de la création du tableau.

Le plus grand index d'un tableau est donc égal au nombre de cases moins
un. Après sa création, les caractéristiques d'un tableau ne peuvent plus
être modifiées (nombre de cases, type des éléments stockés dans le
tableau). La manipulation d'un tableau doit être décomposée en trois
étapes :

* Déclaration d'une variable permettant de manipuler le tableau.
* Création du tableau (allocation mémoire).
* Stockage et manipulation des éléments du tableau.

*Déclaration du tableau*

La déclaration se fait comme une variable classique sauf que l'on doit
ajouter à la suite du type de données ou du nom de la variable une paire
de crochets `[]`. Il est préférable, pour une meilleure lisibilité du
code, d'associer les crochets au type de données. La ligne suivante
déclare une variable de type tableau d'entiers.

....
int[] chiffreAffaire;
....

*Création du tableau*

Après la déclaration de la variable, il faut créer le tableau en
obtenant de la mémoire pour stocker ces éléments. C'est à ce moment que
nous indiquons la taille du tableau. Les tableaux étant assimilés à des
objets, c'est donc l'opérateur `new` qui va être utilisé pour créer une
instance du tableau. La valeur fournie par l'opérateur `new` est stockée
dans la variable déclarée au préalable.

....
chiffreAffaire=new int[12];
....

Cette déclaration va créer un tableau avec douze cases numérotées de `0`
à `11`. La taille du tableau est définitive, il n'est donc pas possible
d'agrandir ou de rétrécir un tableau déjà créé.

Une autre solution est disponible pour la création d'un tableau. Elle
permet la création et l'initialisation de son contenu. La syntaxe est la
suivante :

....
int[] chiffreAffaire={123,563,657,453,986,678,564,234,786,123,534,975};
....

Il n'y a, dans ce cas, pas besoin de préciser de taille pour le tableau.
Le dimensionnement se fera automatiquement en fonction du nombre de
valeurs placées entre les accolades.

Voici la représentation en mémoire que l'on peut faire de ce tableau :

image:images/02RI10.png[image,width=348,height=103]

La variable `chiffreAffaire` contient l'adresse mémoire du tableau. Le
tableau est composé de 12 cases contiguës numérotées de `0` à `11`.

*Utilisation du tableau*

Les éléments des tableaux sont accessibles de la même manière qu'une
variable classique. Il suffit d'ajouter l'index de l'élément que l'on
veut manipuler. L'exemple suivant montre la lecture d'une case dans le
tableau :

....
int chiffreAffaireMoisJanvier = chiffreAffaire[0];
....

L'exemple suivant montre la modification du contenu d'une case du
tableau :

....
chiffreAffaire[0]=354;
....

Il faut être vigilant en manipulant un tableau et ne pas tenter
d'accéder à une case du tableau qui n'existe pas, sous peine d'obtenir
une exception du type `ArrayIndexOutOfBoundException`.

*Tableaux à plusieurs dimensions*

Les tableaux à plusieurs dimensions sont très utilisés pour représenter
des tableaux à double entrée (lignes et colonnes). Ils permettent
cependant de représenter des structures plus complexes à trois
dimensions, voire plus. Pour représenter la logique d'un tableur, il est
possible d'utiliser un tableau à trois dimensions faisant référence aux
feuilles, aux lignes et aux colonnes.

Les tableaux à plusieurs dimensions sont en fait des tableaux contenant
d'autres tableaux. La représentation suivante montre un tableau à deux
dimensions :

image:images/02RI11.png[image,width=352,height=150]

Ce tableau représente le chiffre d'affaires par région et par mois. La
première dimension contient deux cases pour les deux régions où exerce
l'entreprise. La deuxième dimension contient douze cases pour le chiffre
d'affaires mensuel réalisé par l'entreprise en fonction de la région.

Admettons que la Bretagne corresponde à la première case de la première
dimension et que les Pays de la Loire correspondent à la seconde case de
la première dimension.

Pour connaître le chiffre d'affaires réalisé en Bretagne en février,
l'instruction est la suivante :

....
int CABretagneFevrier = chiffreAffaireParRegion[0][1];
....

`[0]` représentant la première case de la première dimension (Bretagne).

`[1]` représentant la seconde case de la seconde dimension (Février).

Pour modifier le chiffre d'affaires réalisé dans les Pays de la Loire en
juin, l'instruction est la suivante :

....
chiffreAffaireParRegion[1][5]=1238;
....

`[1]` représentant la seconde case de la première dimension (Pays de la
Loire).

`[5]` représentant la sixième case de la seconde dimension (Juin).

La syntaxe de déclaration est semblable à celle d'un tableau, mis à part
que l'on doit spécifier autant de paires de crochets qu'il y a de
dimensions.

....
int[][] matrice;
....

La création varie quelque peu. Le nombre de cases dans la première
dimension doit obligatoirement être mentionné. Le nombre de cases dans
les autres dimensions peut être défini plus tard si :

* on ne connaît pas au moment de la création la taille nécessaire ;
* la taille du tableau dans les autres dimensions varie.

Dans la plupart des cas, la taille des différentes dimensions est connue
à l'avance et est homogène dans chaque dimension. La création du tableau
se fait alors ainsi :

....
matrice=new int[2][3];
....

Lorsque ces conditions ne sont pas remplies, il est possible de différer
la création des autres dimensions. La première étape consiste à créer la
première dimension de cette manière :

....
matrice=new int[2][];
....

Ensuite, pour chaque case de la première dimension, il est possible de
créer un tableau correspondant à la deuxième dimension :

....
matrice[0]=new int[3]; 
matrice[1]=new int[2];
....

La représentation suivante illustre cette matrice :

image:images/02RI12.png[image,width=147,height=181]

La syntaxe permettant l'initialisation d'un tableau à plusieurs
dimensions au moment de sa déclaration est un petit peu plus complexe.

....
int[][] matrice={{11,12,13},{21,22,23}};
....

L'utilisation imbriquée d'accolades permet de définir les différentes
dimensions. Les valeurs sont situées dans les cases de la dernière
dimension. L'exemple ci-dessus permet d'initialiser un tableau à deux
dimensions avec deux lignes et trois colonnes.

*Manipulations courantes avec des tableaux*

Lorsque l'on travaille avec les tableaux, certaines opérations doivent
être fréquemment réalisées. Cette section décrit les opérations les plus
courantes réalisées sur les tableaux. La plupart d'entre elles sont
disponibles grâce à la classe `java.util.Arrays` fournissant de
nombreuses méthodes `static` de manipulation de tableaux.

Obtenir la taille d'un tableau : il suffit d'utiliser la propriété
`length` du tableau pour connaître le nombre d'éléments qu'il peut
contenir. Dans le cas d'un tableau multidimensionnel, il faut se
souvenir qu'il s'agit en fait de tableaux de tableaux. La propriété
`length` indique alors le nombre d'éléments sur la première dimension.

Pour obtenir la même information sur les autres dimensions, il faut
utiliser la propriété `length` de chaque case du tableau de niveau
inférieur.

....
int[][] matrice=new int[8][3];  
System.out.println("le tableau comporte " + matrice.length +  
                   " cases sur " + matrice[0].length +   
                   " cases");
....

Afficher un tableau : la méthode `toString` permet d'obtenir une
représentation sous forme d'une chaîne de caractères du tableau passé en
paramètre. Cette méthode retourne une représentation textuelle du
tableau. Le retour de cette méthode est alors passé en paramètre de la
fonction `System.out.println` pour avoir un affichage sur la console.

....
System.out.println(Arrays.toString(chiffreAffaire));
....

L'instruction précédente affiche le résultat suivant :

....
[123, 234, 453, 534, 563, 564, 657, 678, 786, 975, 986, 1234]
....

La méthode `deepToString` effectue la même opération pour un tableau à
plusieurs dimensions.

....
int[][] grille={{11,12,13},{21,22,23},{31,32,33}};  
System.out.println(Arrays.deepToString(grille));
....

L'instruction précédente affiche le résultat suivant :

....
[[11, 12, 13], [21, 22, 23], [31, 32, 33]]
....

Trier un tableau : la méthode `sort` assure le tri du tableau qu'elle
reçoit en paramètre. Le tri se fait par ordre alphabétique pour les
tableaux de chaînes de caractères et par ordre croissant pour les
tableaux de valeurs numériques.

....
Arrays.sort(chiffreAffaire);  
System.out.println(Arrays.toString(chiffreAffaire));
....

L'instruction précédente affiche le résultat suivant :

....
[123,123,234,453,534,563,564,657,678,786,975,986]
....

La méthode `parallelSort` effectue elle aussi le tri du tableau, mais en
utilisant un algorithme exploitant les capacités d'une machine
multiprocesseur.

Rechercher un élément dans un tableau : la méthode `binarySearch` permet
d'effectuer une recherche dans un tableau. Elle accepte comme paramètres
le tableau dans lequel se fait la recherche et l'élément recherché dans
le tableau. La valeur retournée correspond à l'index où l'élément a été
trouvé dans le tableau, ou une valeur négative si l'élément ne se trouve
pas dans le tableau. Pour que cette méthode fonctionne correctement, le
tableau doit être au préalable trié.

....
Arrays.sort(chiffreAffaire);  
System.out.println(Arrays.binarySearch(chiffreAffaire, 123));
....

Copier un tableau : deux méthodes sont disponibles pour la copie de
tableaux.

La méthode `copyOf` copie la totalité d'un tableau reçu en paramètre
avec la possibilité de modifier la taille du tableau avec un second
paramètre.

....
int[] copieChiffreAffaire;  
copieChiffreAffaire=Arrays.copyOf(chiffreAffaire, 24);  
System.out.println(Arrays.toString(copieChiffreAffaire));
....

L'instruction précédente affiche le résultat suivant :

....
[123, 563, 657, 453, 986, 678, 564, 234, 786, 123, 534, 975, 0,  
0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
....

Le tableau a été entièrement copié dans un tableau de 24 cases. Les
nouvelles cases se situent à la fin du tableau et sont initialisées avec
la valeur par défaut d'un entier (`0`).

La méthode `copyOfRange` effectue la copie d'une partie d'un tableau
reçu en paramètre. L'index de la case à partir de laquelle commence la
copie et le nombre de cases concernées constituent les deux autres
paramètres de cette fonction.

....
int[] premierTrimestre;  
premierTrimestre=Arrays.copyOfRange(chiffreAffaire, 0, 3);  
System.out.println(Arrays.toString(premierTrimestre));
....

L'instruction précédente affiche le résultat suivant :

....
[123, 563, 657]
....

La copie du tableau débute à l'index `0` et concerne `3` cases. La
taille du nouveau tableau correspond exactement à la taille nécessaire
pour copier les cellules visées par l'instruction.

Remplir un tableau : la méthode `fill` est utilisable pour remplir
toutes les cases d'un `tableau` avec la même valeur. L'exemple suivant
permet de remplir le tableau `tableau` avec la valeur `2`.

....
int[] tableau = new int[5]; 
Arrays.fill(tableau,2); 
System.out.println(Arrays.toString(tableau));
....

L'instruction précédente affiche le résultat suivant :

....
[2,2,2,2,2]
....

==== Les chaînes de caractères

*Présentation*

Pour pouvoir stocker des chaînes de caractères, il faut utiliser le type
`String` qui représente une suite de zéro à n caractères. Ce type n'est
pas un type de base, mais une classe. Cependant, pour faciliter son
emploi, il peut être utilisé comme un type de base du langage. Les
chaînes de caractères sont invariables, car lors de l'affectation d'une
valeur à une variable de type chaîne de caractères, de l'espace est
réservé en mémoire pour le stockage de la chaîne. Si par la suite, cette
variable reçoit une nouvelle valeur, un nouvel emplacement lui est
assigné en mémoire. Heureusement, ce mécanisme est transparent pour nous
et la variable fera toujours automatiquement référence à la valeur qui
lui a été assignée. Avec ce mécanisme, les chaînes de caractères peuvent
avoir une taille variable. L'espace occupé en mémoire est
automatiquement ajusté en fonction de la longueur de la chaîne de
caractères. Pour affecter une chaîne de caractères à une variable, il
faut saisir le contenu de la chaîne entre guillemets comme dans
l'exemple ci-dessous.

....
String nomDuCapitaine = "Crochet";
....

La représentation mémoire de cette variable peut être matérialisée
ainsi :

image:images/02RI13.png[image,width=244,height=110]

De nombreuses méthodes de la classe `String` permettent la manipulation
des chaînes de caractères et sont détaillées dans la suite ce chapitre.

*Créer une chaîne de caractères*

La méthode la plus simple pour créer une chaîne de caractères consiste à
considérer le type `String` comme un type de base du langage et non
comme un type objet. C'est dans ce cas l'affectation d'une valeur à la
variable qui va provoquer la création d'une instance de la classe
`String`. La création d'une chaîne de caractères comme un objet est bien
sûr également possible en utilisant l'opérateur `new` et un des nombreux
constructeurs disponibles dans la classe `String`. L'exemple de code
suivant présente les deux solutions.

....
String chaine1="eni";  
String chaine2=new String("eni");
....

Après sa création, une chaîne de caractères ne peut plus être modifiée.
L'affectation d'une autre valeur à la variable provoque la création
d'une nouvelle instance de la classe `String`. La classe `String`
contient de nombreuses méthodes permettant la modification de chaînes de
caractères. À l'utilisation, nous avons l'impression que la fonction
modifie le contenu de la chaîne initiale, mais en fait c'est une
nouvelle instance contenant le résultat qui est renvoyée par la
fonction.

*Affecter une valeur à une chaîne*

Pour affecter une valeur à une chaîne, il faut la spécifier entre
guillemets. Un problème se pose donc si le caractère " fait partie de la
chaîne. Pour qu'il ne soit pas interprété comme caractère de début ou de
fin de chaîne, il faut le protéger par une séquence d'échappement (en
utilisant le caractère `\`) comme dans l'exemple ci-dessous :

....
String chaine;  
chaine=" il a dit : \" ça suffit ! \"";  
System.out.println(chaine);
....

Le résultat à l'affichage est le suivant :

....
il a dit : "ça suffit ! "
....

Pour les exemples suivants, nous allons travailler avec deux chaînes :

....
String chaine1 = "l'hiver sera pluvieux";  
String chaine2 = "l'hiver sera froid";
....

*Extraire un caractère particulier*

Pour obtenir le caractère présent à une position donnée d'une chaîne de
caractères, il faut utiliser la fonction `charAt` en fournissant comme
argument l'index du caractère que l'on souhaite obtenir. Le premier
caractère est à l'index zéro comme pour un tableau. Cette fonction
retourne un caractère (`char`).

....
System.out.println("le 3ème caractère de la chaine 1 est " +   
                    chaine1.charAt(2));
....

L'exécution de cette instruction donne le résultat suivant :

....
le 3ème caractère de la chaine 1 est h
....

*Obtenir la longueur d'une chaîne*

Pour déterminer la longueur d'une chaîne, la fonction `length` de la
classe `String` est disponible.

....
System.out.println("la chaine 1 contient " +  
                    chaine1.length() +  
                   " caractères");
....

L'exécution de cette instruction donne le résultat suivant :

....
la chaine 1 contient 21 caractères
....

*Découper une chaîne*

La fonction `substring` de la classe `String` retourne une portion d'une
chaîne de caractères en fonction de la position de départ et de la
position de fin qui lui sont passées comme paramètres. La chaîne obtenue
commence par le caractère situé à la position de départ et se termine au
caractère précédant la position de fin.

....
System.out.println("un morceau de la chaine 1 : " +  
                    chaine1.substring(2,7));
....

L'exécution de cette instruction donne le résultat suivant :

....
un morceau de la chaine 1 : hiver
....

*Tester l'égalité de deux chaînes*

Lorsqu'on fait une comparaison de deux chaînes, on est tenté d'utiliser
le double égal (`==`), comme pour les types valeurs (cf. la section Les
opérateurs un peu plus loin dans le chapitre). Cet opérateur fonctionne
correctement sur les types de base, mais il ne faut pas perdre de vue
que les chaînes de caractères sont des types objet. L'opérateur `==`
vérifie l'égalité des variables (donc les valeurs pour les types
valeurs, mais les adresses pour les types références).

Il faut donc utiliser les méthodes de la classe `String` pour effectuer
des comparaisons de chaînes de caractères. La méthode `equals` effectue
une comparaison de la chaîne avec celle qui est passée en paramètre.
Elle retourne un booléen égal à `true` si les deux chaînes sont
identiques (en valeur) et bien sûr un booléen égal à `false` dans le cas
contraire. Cette fonction fait une distinction entre minuscules et
majuscules lors de la comparaison. La fonction `equalsIgnoreCase`
effectue un traitement identique, mais sans tenir compte de cette
distinction.

....
if(chaine1.equals(chaine2))  
{  
    System.out.println("les deux chaines sont identiques");  
}  
else  
{  
    System.out.println("les deux chaines sont différentes");  
}
....

_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
*Note*

Ne vous laissez pas tromper par les apparences. Dans certains cas,
l'opérateur `==` est bien capable de réaliser une comparaison correcte
de chaînes de caractères. Le code ci-dessous fonctionne correctement et
fournit bien le résultat attendu en considérant que les deux chaînes
sont identiques.
_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

....
String s1="toto";  
String s2="toto";  
if(s1==s2)  
{  
  System.out.println("chaines identiques");  
}  
else  {  
  System.out.println("chaines différentes");  
}
....

En fait, pour économiser de l'espace en mémoire, Java n'utilise dans ce
cas qu'une seule instance de la classe `String` pour les variables `s1`
et `s2` car le contenu des deux chaînes est identique.

Les deux variables `s1` et `s2` référencent donc la même zone mémoire et
l'opérateur `==` constate donc l'égalité (des adresses).

Si en revanche nous utilisons le code suivant qui demande explicitement
la création d'une instance de la classe `String` pour chacune des
variables `s1` et `s2`, l'opérateur `==` ne constate bien sûr plus
l'égalité des chaînes.

....
String s1=new String("toto");  
String s2=new String("toto");  
if(s1==s2)  
{  
  System.out.println("chaines identiques");  
}  
else  
{  
  System.out.println("chaines différentes");  
}
....

*Comparer deux chaînes*

Pour réaliser une comparaison, vous pouvez utiliser la méthode
`compareTo` de la classe `String` ou la méthode `compareToIgnoreCase` si
vous ne souhaitez pas prendre en compte la casse. Ces deux méthodes
attendent en paramètres la chaîne à comparer avec l'instance courante
sur laquelle on appelle la méthode. Le résultat de la comparaison est
retourné sous forme d'un entier inférieur à zéro si la chaîne est
inférieure à celle reçue comme paramètre, égal à zéro si les deux
chaînes sont identiques, et supérieur à zéro si la chaîne est supérieure
à celle reçue comme paramètre.

....
if(chaine1.compareTo(chaine2)>0)  
{  
  System.out.println("chaine1 est supérieure a chaine2");  
}  
else if(chaine1.compareTo(chaine2)<0)  
{  
  System.out.println("chaine1 est inférieure a chaine2");  
}  
else  
{  
  System.out.println("les deux chaines sont identiques");  
}
....

Les fonctions `startsWith` et `endsWith` permettent de tester si la
chaîne débute par la chaîne reçue en paramètre ou si la chaîne se
termine par la chaîne reçue en paramètre. La fonction `endsWith` peut
par exemple être utilisée pour tester l'extension d'un nom de fichier.

....
String nom="Code.java";  
  
if(nom.endsWith(".java"))  
{  
    System.out.println("c\'est un fichier source java");  
}
....

*Supprimer les espaces*

La fonction `trim` permet de supprimer les espaces situés avant le
premier caractère significatif et après le dernier caractère
significatif d'une chaîne.

....
String eni="          eni         ";  
System.out.println("longueur de la chaine : " +  
                    eni.length());  
System.out.println("longueur de la chaine nettoyée : " +  
                    eni.trim().length());
....

*Changer la casse*

Tout en majuscules :

....
System.out.println(chaine1.toUpperCase());
....

Tout en minuscules :

....
System.out.println(chaine1.toLowerCase());
....

*Rechercher dans une chaîne*

La méthode `indexOf` de la classe `String` permet la recherche d'une
chaîne à l'intérieur d'une autre. Le paramètre correspond à la chaîne
recherchée. La fonction retourne un entier indiquant la position à
laquelle la chaîne a été trouvée ou `-1` si la chaîne n'a pas été
trouvée. Par défaut, la recherche commence au début de la chaîne, sauf
si vous utilisez une autre version de la fonction `indexOf` qui, elle,
attend deux paramètres, le premier paramètre étant la chaîne recherchée
et le deuxième la position de départ de la recherche.

....
String recherche;  
int position;  
recherche = "e";  
position = chaine1.indexOf(recherche);  
while (position >= 0)  
{  
  System.out.println("chaine trouvée à la position " + 
                      position);  
  position = chaine1.indexOf(recherche,position+1);  
}  
System.out.println("fin de la recherche");   
....

Nous obtenons à l'affichage :

....
chaîne trouvée à la position 5  
chaîne trouvée à la position 9  
chaîne trouvée à la position 18  
fin de la recherche
....

*Remplacer une partie d'une chaîne*

Il est parfois souhaitable de pouvoir rechercher la présence d'une
chaîne à l'intérieur d'une autre, comme dans l'exemple précédent, mais
également remplacer les portions de chaîne trouvées. La fonction
`replace` permet de spécifier une chaîne de substitution pour la chaîne
recherchée. Elle attend deux paramètres :

* la chaîne recherchée,
* la chaîne de remplacement.

....
String chaine3;  
chaine3= chaine1.replace("hiver", "été");  
System.out.println(chaine3);
....

Nous obtenons à l'affichage :

....
l'été sera pluvieux
....

*Formater une chaîne*

La méthode `format` de la classe `String` permet d'éviter de longues et
fastidieuses opérations de conversion et de concaténation. C'est une
méthode de classe et non une méthode d'instance. Le premier paramètre
attendu par cette fonction est une chaîne de caractères spécifiant sous
quelle forme on souhaite obtenir le résultat. Cette chaîne contient un
ou plusieurs motifs de formatage représentés par le caractère `%`,
suivis d'un caractère spécifique indiquant sous quelle forme doit être
présentée l'information. Il doit ensuite y avoir autant de paramètres
qu'il y a de motifs de formatage. La chaîne renvoyée est construite par
le remplacement de chacun des motifs de formatage par la valeur du
paramètre correspondant, le remplacement se faisant dans l'ordre
d'apparition des motifs. Le tableau suivant présente les principaux
motifs de formatage disponibles.

[width="100%",cols="18%,82%",options="header",]
|=======================================================================
|Motif |Description
|`%b` |Insertion d'un booléen

|`%s` |Insertion d'une chaîne de caractères

|`%d` |Insertion d'un nombre entier

|`%o` |Insertion d'un entier affiché en octal

|`%x` |Insertion d'un entier affiché en hexadécimal

|`%f` |Insertion d'un nombre décimal

|`%e` |Insertion d'un nombre décimal affiché au format scientifique

|`%n` |Insertion d'un saut de ligne. Équivalent à la séquence `\n` mais
ne fonctionne que dans les méthodes de formatage comme `format`.
|=======================================================================

Voici un exemple de code utilisant cette fonction :

....
boolean b=true;  
String s="chaine";  
int i=56;  
double d=5.5;  
System.out.println(String.format("boolean : %b %n" +  
                 "chaine de caractères : %s %n" +  
                 "entier : %d %n" +  
                 "entier en hexadécimal : %x %n" +  
                 "entier en octal : %o %n" +  
                 "décimal : %f %n" +  
                 "décimal précis au dixième : %.1f %n" +  
                 "décimal au format scientifique : %e %n",  
                 b,s,i,i,i,d,d,d));
....

Remarquez la séquence `%.1f` pour l'affichage en décimal. Cette
instruction permet d'indiquer le nombre de chiffres significatifs
souhaités après la virgule.

L'exécution de ce code donne le résultat suivant :

....
boolean : true   
chaine de caractères : chaine   
entier : 56   
entier en hexadécimal : 38   
entier en octal : 70   
décimal : 5,500000   
décimal précis au dixième : 5,5 
décimal au format scientifique : 5.500000e+00
....

==== La notion de Text Blocks

L’utilisation de la méthode `format` devient rapidement limitative par
sa complexité d’écriture. Au lieu d’utiliser l’opérateur de
concaténation `+` et le caractère `\n` pour matérialiser le retour à la
ligne, il est désormais possible d’utiliser un _Text Block_. C’est tout
simplement une chaîne de caractères délimitée par la séquence _`"""`_
(triple guillemets). Après la séquence ouvrante, il est nécessaire de
faire un retour à la ligne avant de rédiger la valeur.

....
String chaineTextBlock1="""  
           Bonjour,  
           ceci est une chaîne sur plusieurs   
           lignes (affichée sur plusieurs lignes)""";
....

L’affichage de cette chaîne de caractères dans la console donne le
résultat suivant :

....
Bonjour,  
ceci est une chaîne sur plusieurs  
lignes (affichée sur plusieurs lignes)
....

Il faut noter que :

* l’indentation (espaces, tabulations…) présente devant chaque ligne du
_Text Block_ est retirée automatiquement,
* l’ajout d’un guillemet (`"`) est possible sans utiliser la séquence
d’échappement (`\`).

Si, toutefois, l’affichage doit se faire sur une seule ligne, il est
possible d’utiliser la séquence d’échappement `\` pour annuler
l’interprétation du retour à la ligne.

....
String chaineTextBlock2="""  
           Bonjour, \  
           ceci est une chaîne sur plusieurs \  
           lignes (affichée sur une ligne)""";  
 
Bonjour, ceci est une chaîne sur plusieurs lignes (affichée sur une ligne)
....

L’interpolation n’est cependant pas possible dans les _Text Blocks_.
L’interpolation est la capacité à placer un élément variable à
l’intérieur d’une chaîne de caractères sans réaliser de concaténation
avec le caractère `+`.

Voici un exemple théorique d’interpolation :

....
String uneValeur = "ensoleillé";  
String meteo = """  
           le temps est   
           ${uneValeur}""";
....

Pour ne pas se retrouver à faire des concaténations de chaînes de
caractères dans un _Text Block_ (qui avait pour but de les retirer),
Oracle a choisi de mettre à disposition une nouvelle méthode
(`formatted`) sur la classe `String`. Il est ainsi possible d’écrire le
code suivant :

....
String meteo ="""  
                  le temps est  
                  %s""".formatted(uneValeur);
....

L’affichage de cette chaîne de caractères dans la console donne le
résultat suivant :

....
le temps est  
ensoleillé
....

==== Les dates et les heures

La gestion des date et heure a longtemps été la bête noire des
développeurs Java. La classe `java.util.Date` était la référence pour
stocker des variables de ce type. Les classes `Calendar` et
`GregorianCalendar` étaient disponibles pour répondre aux problèmes de
manipulation de date et d'heure. La classe `SimpleDateFormat`
permettait, quant à elle, la transition entre une variable de type Date
et sa représentation textuelle. De nombreuses fonctionnalités étaient
prévues, mais leur utilisation relevait parfois du casse-tête. Il est
vrai que le problème est complexe. Travailler en base 60 pour les
secondes et les minutes puis en base 24 pour les heures n'est pas très
simple.

Mais la palme revient à la gestion des mois qui n'ont pas tous le même
nombre de jours, voire pire puisque certains mois ont un nombre de jours
variable suivant les années. Les ordinateurs utilisent une technique
différente, en ne travaillant pas directement avec des dates et heures,
mais en nombre de secondes ou de millisecondes depuis une date de
référence (généralement le 1^er^ janvier 1970 à 0 heure). Ce mode de
représentation n'est cependant pas très pratique pour un humain. La
valeur 1552345200000 n'est pas très évocatrice, en revanche 12/03/2019
est beaucoup plus parlant. C'est pourquoi de nombreuses fonctions
permettent le passage d'un format à l'autre.

Dans la version 8 de Java, la gestion des dates et des heures a été
complètement repensée. De nombreuses classes spécialisées ont fait leur
apparition. Voici un bref aperçu de ces classes :

[width="100%",cols="35%,65%",options="header",]
|=======================================================================
|Classe |Description
|`LocalDate` |Représente une date (jour, mois, année) sans heure.

|`LocalDateTime` |Représente une date et une heure sans prise en compte
du fuseau horaire.

|`LocalTime` |Représente une heure sans prise en compte du fuseau
horaire.

|`OffsetDateTime` |Représente une date et une heure avec le décalage
UTC.

|`OffsetTime` |Représente une heure avec le décalage UTC.

|`ZonedDateTime` |Représente une date et une heure avec le fuseau
horaire correspondant.

|`Duration` |Représente une durée exprimée en heures, minutes et
secondes.

|`Period` |Représente une durée exprimée en jours, mois et années.

|`MonthDay` |Représente un jour et un mois sans année.

|`YearMonth` |Représente un mois et une année sans jour.
|=======================================================================

Toutes ces classes proposent une série de méthodes permettant la
manipulation de leurs éléments. Ces méthodes respectent une convention
de nommage facilitant l'identification de leur usage.

* `of` : retourne une instance de la classe initialisée avec les
différentes valeurs passées comme paramètres.

....
LocalDate noel;  
noel=LocalDate.of(2019, 12,25);
....

* `from` : permet une conversion entre ces différents types. En cas de
conversion vers un type moins complet, il y a perte d'informations.

....
LocalDateTime maintenant;  
maintenant=LocalDateTime.now();  
// transformation en LocalDate  
// avec perte de l'heure  
LocalDate aujourdhui;  
aujourdhui=LocalDate.from(maintenant);
....

* `parse` : transforme la chaîne de caractères passée comme paramètre
vers le type correspondant.

....
LocalTime horloge;  
horloge=LocalTime.parse("22:45:03");
....

* `withXxx` : retourne une nouvelle instance en modifiant la composante
indiquée par `Xxx` par la valeur passée comme paramètre.

....
LocalTime horloge;  
horloge=LocalTime.parse("22:45:03");  
LocalTime nouvelleHeure;  
nouvelleHeure=horloge.withHour(9);
....

* `plusXxx` et `minusXxx` : retourne une nouvelle instance de la classe
après ajout ou retrait du nombre d'unités indiqué par le paramètre.
`Xxx` indique ce qui est ajouté ou retranché.

....
LocalDate paques;  
paques=LocalDate.of(2019,4,22);  
LocalDate ascension;  
ascension=paques.plusDays(39);
....

* `atXxx` : combine l'objet reçu comme paramètre avec l'objet courant et
retourne le résultat de cette association. On peut par exemple combiner
un objet `LocalDate` et un objet `LocalTime` pour obtenir un objet
`LocalDateTime`.

....
LocalDate jourMatch;  
jourMatch=LocalDate.of(2019,7,13);  
         
LocalTime heureMatch;  
heureMatch=LocalTime.of(21,00);  
         
LocalDateTime debut;  
debut=jourMatch.atTime(heureMatch);
....

Le formatage d'une date pour un affichage adapté passe par l'utilisation
de la classe `DateTimeFormatter`. Il est possible de construire une
instance de cette classe avec la méthode de classe `ofPattern`. Cette
méthode attend en paramètre une chaîne de caractères définissant le
format d'affichage. Pour l'affichage au format JJ/MM/AAAA, le pattern
correspondant est `dd/MM/yyyy`. Le formatage est ensuite possible en
utilisant la méthode `format` :

....
LocalDate aujourdhui = LocalDate.now(); 
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
System.out.println(dtf.format(aujourdhui));
....

Le petit exemple de code ci-dessous illustre quelques opérations sur les
dates en comptant le nombre de jours fériés tombant un samedi ou un
dimanche pour chaque année entre 2019 et 2030.

....
MonthDay[] fetes;  
fetes=new MonthDay[8];  
fetes[0]=MonthDay.of(1,1);  
fetes[1]=MonthDay.of(5,1);  
fetes[2]=MonthDay.of(5,8);  
fetes[3]=MonthDay.of(7,14);  
fetes[4]=MonthDay.of(8,15);  
fetes[5]=MonthDay.of(11,1);  
fetes[6]=MonthDay.of(11,11);  
fetes[7]=MonthDay.of(12,25);  
         
int nbJours;  
int annee;  
LocalDate jourTest;  
for (annee=2019;annee<2030;annee++)  
{  
    nbJours=0;  
    for(MonthDay test:fetes)  
    {  
         jourTest=test.atYear(annee);  
         if (jourTest.getDayOfWeek()==DayOfWeek.SATURDAY 
             ||jourTest.getDayOfWeek()==DayOfWeek.SUNDAY)  
         {  
              nbJours++;  
         }  
    }  
    System.out.println("en " + annee +  
                       " il y a " + nbJours +  
                       " jour(s) ferie(s)" + 
                       " un samedi ou un dimanche");  
}  
....

=== Les valeurs par défaut

L'initialisation des variables n'est pas toujours obligatoire. C'est par
exemple le cas pour les variables d'instance et de classes qui sont
initialisées avec les valeurs par défaut suivantes.

[width="100%",cols="50%,50%",options="header",]
|============================
|Type |Valeur par défaut
|`byte` |`0`
|`short` |`0`
|`int` |`0`
|`long` |`0`
|`float` |`0.0`
|`double` |`0.0`
|`char` |`\u0000`
|`boolean` |`false`
|Les types références |`null`
|============================

En revanche, les variables locales doivent être initialisées avant
d'être utilisées. Le compilateur effectue d'ailleurs une vérification
lorsqu'il rencontre l’utilisation d’une variable locale et déclenche une
erreur si la variable n'a pas été initialisée. 

Pour rappel, la structure suivante rappelle la localisation des
variables :

....
1    public class NomDeLaClasse 
2    { 
3        //VARIABLES D’INSTANCE 
4        //VARIABLES DE CLASSE 
5        ... uneMethode(PARAMETRES) 
5        { 
7            //VARIABLES LOCALES 
8        } 
9    }
....

=== La portée des variables

La portée d'une variable est la portion de code à partir de laquelle on
peut manipuler cette variable. Elle est fonction de l'emplacement où est
située la déclaration.

Cette déclaration peut être faite dans :

* le bloc de code d'une classe,
* le bloc de code d'une fonction,
* un bloc de code à l'intérieur d'une fonction.

Une variable ne peut être utilisée que dans le bloc où elle est déclarée
et dans les sous-blocs. Si le même bloc de code est exécuté plusieurs
fois pendant l'exécution de la fonction, cas d'une boucle `while` par
exemple, la variable sera créée à chaque passage dans la boucle. Il ne
peut pas y avoir deux variables portant le même nom avec la même portée.

Vous avez cependant la possibilité de déclarer une variable interne à
une fonction, ou un paramètre d'une fonction avec le même nom qu'une
variable déclarée au niveau de la classe. Le principe de localité est
alors mis en œuvre. Ainsi, la variable locale est prioritaire sur la
variable déclarée au niveau de la classe. Pour accéder à cette variable,
il faut la préfixer par le mot-clé `this` (dans le cas d'une variable
d'instance) ou par le nom de la classe (dans le cas d'une variable de
classe).

....
1    public class NomDeLaClasse 
2    { 
3        int maVariableDInstance; 
4        static int maVariableDeClasse; 
5        ... uneMethode(PARAMETRES) 
6        { 
7            int maVariableLocale; 
8            if(expression booléenne) 
9            { 
10               int maVariableDeBloc; 
11          }            
12        } 
13    }
....

Les variables `maVariableDInstance` et `maVariableDeClasse` sont
accessibles dans toute la classe (toutes les méthodes et tous les blocs
à l'intérieur des méthodes). La variable `maVariableLocale` est
accessible depuis sa déclaration jusqu'à la fin de la méthode dans
laquelle elle est déclarée (dans le bloc dans lequel elle est déclarée
et dans tous les blocs à l'intérieur de la méthode). La variable
`maVariableDeBloc` est accessible depuis sa déclaration jusqu'à la fin
du bloc dans lequel elle est déclarée (elle est aussi accessible dans
les sous-blocs de ce bloc).

=== La durée de vie des variables

La durée de vie d'une variable permet de spécifier pendant combien de
temps durant l'exécution de l'application le contenu d'une variable sera
disponible.

Pour une variable déclarée dans une méthode, la durée de vie correspond
à la durée d'exécution de celle-ci. Dès la fin de l'exécution de la
méthode, la variable est éliminée de la mémoire. Elle est recréée lors
du prochain appel de la méthode.

Une variable d'instance est utilisable tant que l'instance est
disponible.

Une variable de classe (déclarée avec le mot-clé `static`) est
accessible pendant toute la durée de fonctionnement de l'application.

=== La conversion de type

==== Présentation

La conversion de type est un mécanisme incontournable dans un programme
informatique. Entre la saisie clavier d'un utilisateur qui est une
chaîne de caractères et l'utilisation de cette saisie, il est très
souvent nécessaire de réaliser une conversion.

Il faut différencier la conversion des types valeurs qui change aussi la
valeur et la conversion des types références qui change uniquement le
type de la variable. Ce point sera abordé dans le chapitre suivant sur
la programmation orientée objet.

La suite de ce chapitre traite de la conversion des types primitifs et
des chaînes de caractères qui, je le rappelle, sont immuables et donc se
comportent comme des types valeurs.

==== La conversion entre numériques

La conversion entre numériques consiste à transformer une variable d'un
type dans un autre type. La conversion peut se faire vers un type
supérieur ou vers un type inférieur. Si une conversion vers un type
inférieur est utilisée, il risque d'y avoir une perte d'information. Par
exemple, la conversion d'un type `double` vers un type `long` fera
perdre au minimum la partie décimale de la valeur. C'est pour cette
raison que le compilateur exige dans ce cas que vous indiquiez
explicitement que vous souhaitez effectuer cette opération. Pour
cela, vous devez préfixer l'élément que vous souhaitez convertir avec le
type que vous voulez obtenir en plaçant celui-ci entre parenthèses.

....
float surface;  
surface=2356.8f;  
//Conversion implicite 
double grandeSurface=surface;  
//Conversion explicite 
int approximation=(int)surface;
....

La variable `approximation` contient la valeur `2356`.

La conversion vers un type supérieur est sans risque de perte
d'information et peut donc se faire directement par une simple
affectation.

Le tableau suivant résume les conversions possibles et indique si elles
doivent être explicites () ou non ().

[width="100%",cols="18%,12%,10%,10%,9%,10%,10%,12%,9%",options="header",]
|=============================================================
|  |  |Type de données à obtenir | | | | | |
| | |`byte` |`short` |`int` |`long` |`float` |`double` |`char`
|_Type de données d'origine_ |`byte` |  | | | | | |
|`short` | |  | | | | | |
|`int` | | |  | | | | |
|`long` | | | |  | | | |
|`float` | | | | |  | | |
|`double` | | | | | |  | |
|`char` | | | | | | |  |
|=============================================================

Remarquez la présence du type `char`. Pour rappel, un `char` est stocké
sous la forme du code Unicode sur deux octets.

==== La conversion vers une chaîne de caractères

Les fonctions de conversion vers le type chaîne de caractères sont
accessibles par l'intermédiaire de la classe `String`. La méthode de
classe `valueOf` assure la conversion d'une valeur d'un type de base
vers une chaîne de caractères.

image:images/02RI14.png[image,width=437,height=208]

Dans certaines situations, l'utilisation de ces fonctions est
optionnelle, car la conversion est effectuée implicitement. C'est le cas
par exemple lorsqu'une variable d'un type de base est concaténée avec
une chaîne de caractères. Les deux versions de code suivantes ont le
même effet.

* Version 1

....
double prixHt;  
prixHt=152;  
String recap;  
recap="le montant de la commande est : " +  
       prixHt*1.20;
....

* Version 2

....
double prixHt;  
prixHt=152;  
String recap;  
recap="le montant de la commande est : " +  
       String.valueOf(prixHt*1.20);
....

Pour plus d'informations sur le sujet, vous pouvez consulter la section
Les chaînes de caractères - Formater une chaîne, un peu plus haut dans
ce chapitre.

==== La conversion depuis une chaîne de caractères

Il arrive fréquemment qu'une valeur numérique soit disponible dans une
application sous forme d'une chaîne de caractères (saisie de
l'utilisateur, lecture d'un fichier...).

Pour pouvoir être manipulée par l'application, elle doit être convertie
en un type numérique. Ce type de conversion est accessible par
l'intermédiaire des classes équivalentes aux types de base. Elles
permettent la manipulation de valeurs numériques sous forme d'objets.
Chaque type de base possède sa classe associée.

[width="100%",cols="50%,50%",options="header",]
|===================================
|Type de base |Classe correspondante
|`byte` |`Byte`
|`short` |`Short`
|`int` |`Integer`
|`long` |`Long`
|`float` |`Float`
|`double` |`Double`
|`boolean` |`Boolean`
|`char` |`Character`
|===================================

Ces classes sont appelées classes _wrappers_, car elles sont utilisées
pour « emballer » dans un objet les types de base du langage. Elles
peuvent être utilisées comme des classes normales en créant une instance
à partir de la méthode de classe `valueof`, le constructeur étant
déprécié depuis Java 9. Différentes surcharges de la méthode `valueOf`
sont disponibles :

....
Integer entier=Integer.valueOf(10); 
entier=Integer.valueOf("10");
....

Cette solution peut être contournée grâce au mécanisme appelé
«_ autoboxing _» du compilateur.

Ce mécanisme permet l'affectation d'un type de base du langage à une
variable du type _wrapper_ correspondant.

....
Integer entier=10;
....

______________________________________________________________________________________________________________________
*Note*

Attention, le comportement des instances de ces classes wrappers est
identique au type `String`. Elles sont immuables.
______________________________________________________________________________________________________________________

Le mécanisme inverse, appelé «_ unboxing _», permet la conversion
automatique d'un type _wrapper_ vers un type de base. La variable
`entier` de l'exemple précédent peut être affectée à une variable de
type `int`.

....
int x=entier;
....

Ces classes fournissent une méthode `parseXxx` acceptant comme paramètre
une chaîne de caractères et retournant une valeur dans le type de base
associé à la classe.

[width="100%",cols="18%,82%",options="header",]
|==============================
|Classe |Méthode
|`Byte` |`public static
byte parseByte(String s)`
|`Short` |`public static
short parseShort(String s)`
|`Integer` |`public static
int parseInt(String s)`
|`Long` |`public static
long parseLong(String s)`
|`Float` |`public static
float parseFloat(String s)`
|`Double` |`public static
double parseDouble(String s)`
|`Boolean` |`public static
boolean parseBoolean(String s)`
|==============================

Pour retenir comment procéder pour effectuer une conversion, il faut
appliquer le principe suivant : la méthode à utiliser se trouve dans la
classe correspondante au type de données que l'on souhaite obtenir.

=== L'inférence de type

L'inférence de type est un mécanisme qui laisse au compilateur le soin
de déterminer le type d'une variable en fonction de l'expression qui
permet son initialisation. C'est un mécanisme très intéressant pour la
programmation avancée en Java notamment avec les expressions lambda.
L'objectif principal est de simplifier les lignes de code en ne se
préoccupant pas de définir explicitement le type de certaines variables.
Cependant, c'est un mécanisme simple qui a toute sa place dans ce
chapitre traitant des variables et de leurs types.

L'inférence de type ne veut pas dire qu'il n'y a plus de typage. La
différence réside dans le fait que c'est le compilateur qui définit le
type de la variable.

Pour que l'inférence de type soit mise en œuvre, il est nécessaire de
déclarer la variable avec le mot-clé `var` et non plus avec son type
comme le montre l'exemple suivant :

....
var chaine = "Bonjour je suis une chaine de caractères";
....

Il y a quelques règles à respecter pour que l'inférence de type
fonctionne :

* La variable doit être initialisée à sa déclaration pour que le
compilateur puisse déterminer son type sous peine d'avoir l'erreur
suivante :

image:images/02RI15.png[image,width=249,height=48]

* La variable ne peut pas être initialisée avec `null` car cette valeur
ne correspond à aucun type sous peine d'avoir l'erreur suivante :

image:images/02RI16.png[image,width=286,height=52]

_____________________________________________________________________________________________________
*Note*

Pour découvrir un usage concret de l’inférence de type, consultez le
chapitre Les expressions lambda.
_____________________________________________________________________________________________________

== Les constantes

Dans une application, il arrive fréquemment que l'on utilise des valeurs
numériques ou chaînes de caractères qui ne seront pas modifiées pendant
le fonctionnement de l'application. Il est conseillé, pour faciliter la
lecture du code, de définir ces valeurs sous forme de constantes.

La définition d'une constante se fait en ajoutant le mot-clé `final`
devant la déclaration d'une variable. Il est obligatoire d'initialiser
la constante au moment de sa déclaration (c'est le seul endroit où il
est possible de faire une affectation à la constante).

....
final double TAUXTVA=1.20;
....

La constante peut être alors utilisée dans le code à la place de la
valeur littérale qu'elle représente.

....
prixTtc=prixHt*TAUXTVA;
....

Les règles concernant la durée de vie et la portée des constantes sont
identiques à celles concernant les variables.

La valeur d'une constante peut également être calculée à partir d'une
autre constante.

....
final int TOTAL=100;  
final int DEMI=TOTAL/2;
....

De nombreuses constantes sont déjà définies au niveau du langage Java.
Elles sont définies comme membres `static` des nombreuses classes du
langage. Par convention, les noms des constantes sont orthographiés
entièrement en majuscules.

== Les énumérations

Une énumération va nous permettre de définir un ensemble de constantes
qui sont fonctionnellement liées entre elles. La déclaration se fait de
la manière suivante :

....
public enum Jour  
{  
   DIMANCHE,  
   LUNDI,  
   MARDI,  
   MERCREDI,  
   JEUDI,  
   VENDREDI,  
   SAMEDI  
}
....

La première valeur de l'énumération est initialisée à zéro. Les
constantes suivantes sont ensuite initialisées avec un incrément de un.
La déclaration précédente aurait donc pu s'écrire :

....
public class Jour  
{  
   public static final int DIMANCHE=0;  
   public static final int LUNDI=1;  
   public static final int MARDI=2;  
   public static final int MERCREDI=3;  
   public static final int JEUDI=4;  
   public static final int VENDREDI=5;  
   public static final int SAMEDI=6;  
}
....

C'est approximativement ce que fait le compilateur lorsqu'il analyse le
code de l'énumération.

En fait, la déclaration d'une énumération est une déclaration de classe
« déguisée ». Cette classe hérite implicitement de la classe
`java.lang.Enum`. Les éléments définis dans l'énumération sont les
seules instances possibles de cette classe. Comme n'importe quelle
classe, elle peut contenir des attributs, des constructeurs et des
méthodes. L'exemple de code suivant présente ces possibilités.

....
public enum Dalton   
{  
  JOE (1.40, 52),  
  WILLIAM (1.68, 72),  
  JACK (1.93, 83),  
  AVERELL (2.13, 89);  
   
  private final double taille;    
  private final double poids;  
  
  private Dalton(double taille, double poids)   
  {  
     this.taille = taille;  
     this.poids = poids;  
  }  
  public double taille() { return taille; }  
  public double poids() { return poids; }  
  
   double imc()   
  {  
            
     return poids/(taille+taille);  
  }  
   
}
....

Le constructeur est utilisé de manière implicite pour initialiser les
constantes de chacun des éléments de l'énumération. Le constructeur
d'une énumération doit obligatoirement être déclaré `private`. Plusieurs
méthodes définies dans la classe de base (`java.lang.Enum`) permettent
d'obtenir des informations sur les éléments de l'énumération. La méthode
`toString` retourne une chaîne de caractères représentant le nom de la
constante de l'énumération.

....
Dalton d = Dalton.JACK;  
System.out.println(d.toString());
....

La méthode `valueOf` effectue l'opération inverse en fournissant un des
éléments de l'énumération dont le nom est indiqué par la chaîne de
caractères passée en paramètre.

....
d = Dalton.valueOf("JOE");  
System.out.println("poids : "+ d.poids());  
System.out.println("taille : "+ d.taille());
....

La méthode `values` retourne sous forme d'un tableau toutes les valeurs
possibles de l'énumération.

....
System.out.println("les frères Dalton");  
for(Daltons dalton: Dalton.values())  
{  
   System.out.println(dalton.toString());  
}
....

Une fois définie, une énumération peut être utilisée comme un nouveau
type de données. Vous pouvez donc déclarer une variable avec pour type
votre énumération.

....
Jour repere;
....

Il est alors possible d'utiliser la variable en lui affectant une des
valeurs définies dans l'énumération.

....
repere=Jour.LUNDI;
....

Lorsque vous faites référence à un élément de votre énumération, vous
devez le faire précéder du nom de l'énumération comme dans l'exemple
précédent. L'affectation à la variable d'autre chose qu'une des valeurs
contenues dans l'énumération est interdite et provoque une erreur de
compilation.

La déclaration d'une énumération ne peut pas se faire dans une méthode.
Elle peut en revanche être déclarée dans une classe, mais il faudra dans
ce cas préfixer le nom de l'énumération par le nom de la classe dans
laquelle elle est définie lors de son utilisation. Pour que
l'énumération soit autonome, il suffit de la déclarer dans son propre
fichier.

La portée d'une énumération suit les mêmes règles que celle des
variables.

Une variable de type énumération peut facilement être utilisée dans une
structure `switch ... case`. Il n'est dans ce cas pas nécessaire de
faire précéder les membres de l'énumération du nom de l'énumération.

....
switch (repere)  
{  
   case LUNDI:  
   case MARDI:  
   case MERCREDI:  
   case JEUDI:  
        System.out.println("C\'est dur de travailler");  
        break;  
   case VENDREDI:  
        System.out.println("Bientôt le week end !");  
        break;  
   case SAMEDI:  
        System.out.println("Enfin !");  
         break;  
   case DIMANCHE:  
         System.out.println("Et ça recommence !");  
         break;  
} 
....

Pour plus de détails, veuillez vous référer à la section Les structures
de contrôle un peu plus loin dans ce chapitre.

== Les arguments d'un programme

=== Fonctionnement

Il est possible de passer des arguments à un programme pour que celui-ci
adapte son comportement en fonction des valeurs fournies.

Les arguments fournis sont disponibles dans le tableau de chaînes de
caractères nommé `args` en paramètre de la méthode `main`.

Pour passer des arguments lors de l'exécution du programme, il suffit
d'exécuter le programme avec l'outil `java`, et d'ajouter, après le nom
du programme, les arguments sur la même ligne de commande. Le séparateur
est l'espace. Ainsi la commande suivante initialise le paramètre `args`
avec un tableau composé de trois cases :

....
java MonProgramme arg1 arg2 arg3
....

Le tableau `args` contient les chaînes de caractères suivantes : `arg1`,
`arg2` et `arg3`.

Si un argument contient un espace dans sa valeur, il suffit de délimiter
la valeur avec des guillemets :

....
java MonProgramme arg1 arg2 "arg 3"
....

Le tableau `args` contient dans ce cas les chaînes de caractères
suivantes : `arg1`, `arg2` et `arg 3`.

Si un argument contient un guillemet, il suffit de l'échapper avec le
caractère `\` :

....
java MonProgramme arg1 arg2 "arg \"3\""
....

Le tableau `args` contient dans ce cas les chaînes de caractères
suivantes : `arg1`, `arg2` et `arg "3"`.

Pour plus d'informations sur la manipulation d'un tableau, veuillez vous
référer à la section Les tableaux un peu plus haut dans ce chapitre.

=== Utilisation dans Eclipse

Pour définir des arguments à un programme au travers d'Eclipse, voici la
marche à suivre :

Créez une classe `MonProgramme` avec le code suivant :

....
public class MonProgramme { 
   public static void main(String[] args) { 
       for(String arg:args) { 
           System.out.println(arg); 
       } 
   } 
}
....

Exécutez votre programme en effectuant un clic droit sur la classe et en
sélectionnant le menu _Run As - 1 Java Application_. Cette action permet
de créer facilement une configuration d'exécution modifiable pour
ajouter notamment des arguments.

Éditez cette configuration d'exécution en effectuant un clic droit sur
la classe et en sélectionnant le menu _Run As - Run Configurations…_.
L'écran suivant apparaît :

image:images/02RI17.png[image,width=484,height=319]

Positionnez-vous sur le nœud correspondant à votre application sur
l'arborescence de gauche (_Java Application - MonProgramme_).

Affichez l'onglet _Arguments_.

Définissez les arguments de votre programme (_Program arguments_).

Cliquez sur le bouton _Run_ et visualisez le résultat sur la console.

== Les opérateurs

Les opérateurs sont des mots-clés du langage permettant l'exécution
d'opérations sur le contenu de certains éléments, en général des
variables, des constantes, des valeurs littérales, ou des retours de
fonctions. La combinaison d'un ou de plusieurs opérateurs et d'éléments
sur lesquels les opérateurs vont s'appuyer se nomme une expression. Ces
expressions sont évaluées au moment de l'exécution en fonction des
opérateurs et des valeurs qui sont associées. 

Deux types d'opérateurs sont disponibles :

* Les opérateurs unaires qui ne travaillent que sur un seul opérande.
* Les opérateurs binaires qui nécessitent deux opérandes.

Les opérateurs peuvent être répartis en sept catégories.

=== Les opérateurs unaires

[width="99%",cols="25%,75%",options="header",]
|========================================
|Opérateur |Action
|`-` |Valeur négative
|`~` |Complément à 1 (inversion des bits)
|`++` |Incrémentation
|`--` |Décrémentation
|`!` |Négation
|========================================

L'opérateur `!` n'est utilisable que sur des variables de type `boolean`
ou sur des expressions produisant un type `boolean` (comparaison).

Les opérateurs unaires peuvent être utilisés avec la notation préfixée,
dans ce cas l'opérateur est placé avant l'opérande, et avec la notation
postfixée, dans ce cas l'opérateur placé après l'opérande. La position
de l'opérateur détermine le moment où celui-ci est appliqué sur la
variable. Si l'opérateur est préfixé, il s'applique sur l'opérande avant
que celui-ci ne soit utilisé dans l'expression. Avec la notation
postfixée, l'opérateur n'est appliqué sur la variable qu'après
utilisation de celle-ci dans l'expression. Cette distinction peut avoir
une influence sur le résultat d'une expression.

L'exécution de l'exemple suivant affiche `3` car l'incrémentation est
exécutée après utilisation de la variable par l'instruction `println` :

....
int i;  
i=3;  
System.out.println(i++);
....

L'exécution de l'exemple suivant affiche `4` car l'incrémentation est
exécutée avant l'utilisation de la variable par l'instruction
`println` :

....
int i;  
i=3;  
System.out.println(++i);
....

Si la variable n'est pas utilisée dans une expression, les deux versions
conduisent au même résultat.

Les deux lignes de code suivantes sont équivalentes :

....
i++; 
++i;
....

=== L'opérateur d'affectation

Le seul opérateur disponible dans cette catégorie est l'opérateur `=`.
Il permet d'affecter une valeur à une variable. Le même opérateur est
utilisé, quel que soit le type de la variable (numérique, chaîne de
caractères...).

Cet opérateur peut être combiné avec un opérateur arithmétique, logique
ou binaire.

La syntaxe suivante :

....
x+=2;
....

est équivalente à :

....
x=x+2;
....

=== Les opérateurs arithmétiques

Les opérateurs arithmétiques permettent d'effectuer des calculs sur le
contenu des variables. Le type du résultat de l'opération correspond au
type le plus grand des deux opérandes.

[width="100%",cols="22%,44%,17%,17%",options="header",]
|=======================================================================
|Opérateur |Opération réalisée |Exemple |Résultat
|`+` |Addition pour des valeurs numériques ou concaténation pour des
chaînes |`6+4` |`10`

|`-` |Soustraction |`12-06` |`6`

|`*` |Multiplication |`3*4` |`12`

|`/` |Division |`25/03` |`8` ou `8.333...`

|`%` |Modulo (reste de la division entière) |`25%3` |`1`
|=======================================================================

Il est à noter que pour la division, il y a une subtilité :

Si les deux opérandes sont des numériques entiers, la division opérée
est une division entière. Ainsi, le résultat de l'opération 25/3 sera 8.

En revanche, si au moins un des deux opérandes est un numérique décimal,
alors le résultat de la même opération sera 8.333... La précision du
résultat dépend du type le plus grand dans l'opération. Veuillez vous
référer à la section Les types numériques décimaux pour plus de
précisions.

=== Les opérateurs bit à bit

==== La représentation binaire des entiers

Pour utiliser les opérateurs bit à bit, il est nécessaire de comprendre
la représentation binaire des entiers. Le mécanisme est le même, quel
que soit le type (`byte`, `short`, `int`, `long`). Pour des raisons de
facilité, la suite de cette section s'appuiera sur le type `byte` stocké
sur uniquement huit bits.

Un bit est l'unité de mémoire la plus élémentaire. Il peut contenir la
valeur `0` ou la valeur `1`. On parle de représentation binaire parce
que seules deux valeurs sont possibles.

Un `byte`, étant une suite de huit bits, est composé de huit `0/1`.

Voici des représentations binaires valides de valeurs de type `byte` :

image:images/02RI18.png[image,width=314,height=71]

Comme vous pouvez l'observer, chaque bit n'a pas le même poids. Le bit
de droite est le bit de poids faible et le bit de gauche est le bit de
poids fort.

Lorsque le bit de poids faible vaut `1`, il représente `2^0` en base 10
soit `1`. Lorsque le bit suivant en allant vers la droite vaut `1`, il
représente `2^1` en base 10 soit `2`. Les bits suivants représentent les
valeurs suivantes en base 10 : `8`, `16`, `32`, `64`, `128`.

Pour les types plus grands (`short`, `int`, `long`), il suffit d'ajouter
des puissances de deux supplémentaires : `2^8`, `2^9`… `2^63`.

Donc, avec cette explication, les valeurs d'un type `byte` peuvent aller
de `0` à `255` en base 10 (de `00000000` à `11111111` en base 2). Or la
plage de valeurs possibles pour un `byte` est `-128` à `+127`.

Effectivement, seuls les 7 bits de droite permettent de définir la
valeur. La valeur maximale étant donc `127` (`64+32+16+8+4+2+1`).

Le bit de gauche est utilisé comme bit de signe. Si la valeur est `0`,
le `byte` est un entier positif. Si la valeur est `1`, le `byte` est un
entier négatif. En suivant cette règle basique, la valeur minimale
serait `-127` or, la valeur minimale réelle est `-128`.

Les opérations basiques comme l'addition ne fonctionneraient plus non
plus :

image:images/02RI19.png[image,width=342,height=106]

L'exemple suivant montre une erreur au niveau de l'addition. `-3 + 8` en
base 10 donne `5`. Avec la représentation binaire actuelle, on aurait la
valeur `-11` !

La représentation des entiers négatifs est donc un peu plus complexe. Il
faut réaliser une opération qui s'appelle le _complément à 2_ sur la
valeur absolue d'un entier pour avoir la représentation binaire de
l'entier négatif correspondant. L'opération est réversible. Si vous avez
une représentation binaire d'un entier négatif, pour connaître sa valeur
en base 10, il suffit de réaliser le complément à 2.

Pour représenter la valeur `-3` en base 2, suivez les étapes suivantes :

Commencez par déterminer la représentation binaire de la valeur `3` sur
7 bits : `0000011`.

Inversez l'ensemble des bits:`1111100`.

Ajoutez `1: 1111101`.

La représentation de `-3` est donc `11111101`. Le bit de signe a été
ajouté.

Le complément consiste en deux opérations binaires : l'inversion des
bits et l'ajout de `1`.

L'opération`-3 + 8` en binaire devient donc l'opération suivante :

image:images/02RI20.png[image,width=342,height=106]

Cette représentation des entiers négatifs permet de résoudre cette
problématique.

==== Les opérations logiques

Maintenant que les représentations binaires des entiers sont connues, il
est nécessaire de comprendre les opérations logiques qu'il est possible
de faire sur les bits. Il existe trois opérations de base à connaître :
le Et logique, le Ou logique et le Ou exclusif.

*Et*

Le Et permet de réaliser une opération entre deux bits selon la règle
suivante : si les deux bits valent `1` alors le résultat est `1` sinon,
le résultat est `0`. Les différentes possibilités sont résumées dans le
tableau suivant :

[width="100%",cols="34%,33%,33%",]
|========
|Et |1 |0
|1 |1 |0
|0 |0 |0
|========

*Ou*

Le Ou permet de réaliser une opération entre deux bits selon la règle
suivante : si le deux bits valent `0` alors le résultat est `0` sinon,
le résultat est `1`. Les différentes possibilités sont résumées dans le
tableau suivant :

[width="100%",cols="34%,33%,33%",]
|========
|Ou |1 |0
|1 |1 |1
|0 |1 |0
|========

*Ou exclusif*

Le Ou exclusif permet de réaliser une opération entre deux bits selon la
règle suivante : si un seul des deux bits vaut `1` alors le résultat est
`1` sinon, le résultat est `0`. Les différentes possibilités sont
résumées dans le tableau suivant :

[width="100%",cols="34%,33%,33%",]
|=================
|Ou exclusif |1 |0
|1 |0 |1
|0 |1 |0
|=================

*Les opérateurs*

Ces opérateurs effectuent des opérations sur des entiers uniquement
(`byte`, `short`, `int`, `long`). Ils travaillent au niveau du bit sur
les variables qu'ils manipulent.

[width="99%",cols="22%,40%,17%,21%",options="header",]
|===================================================================
|Opérateur |Opération réalisée |Exemple |Résultat
|`&` |Et binaire |`45 & 22` |`4`
|`|` |Ou binaire |`99 | 46` |`111`
|`^` |Ou exclusif |`99 ^ 46` |`77`
|`>>` |Décalage signé vers la droite (division par 2) a|
`26>>1`

`-26>>1`

a|
`13`

`-13`

|`<<` |Décalage vers la gauche (multiplication par 2) |`26<<1` |`52`
|`>>>` |Décalage non signé vers la droite a|
`26>>>1`

`-26>>>1`

a|
`13`

`21474835635`

|===================================================================

Les opérations binaires (Et binaire, Ou binaire, Ou exclusif)
s'effectuent bit à bit. Cela signifie que l'opération est effectuée sur
chaque bit de même poids. Voici un exemple de l'opération `45 & 22` :

image:images/02RI21.png[image,width=302,height=74]

L'opération de décalage signé vers la droite consiste à ajouter des bits
à gauche correspondant à la valeur du bit de signe (le bit de poids le
plus fort). On en ajoute autant que le nombre défini à droite de
l'opération. Le fait d'ajouter des bits à gauche signifie que l'on perd
autant de bits à droite. L'opération `26>>1` permet d'ajouter un `0`
(valeur du bit de signe) à gauche et de perdre un bit à droite.
L'opération `-26>>1` permet d'ajouter un `1` (valeur du bit de signe)
à gauche et de perdre un bit à droite.

L'opération de décalage vers la gauche consiste à ajouter des `0` à
droite. On en ajoute autant que le nombre défini à droite de
l'opération. Le fait d'ajouter des bits à droite signifie que l'on perd
autant de bits à gauche. L'opération `26<<1` permet d'ajouter un `0` à
droite et de perdre un bit à gauche.

L'opération de décalage non signé vers la droite consiste à ajouter
uniquement des `0` à gauche. Le mécanisme reste ensuite le même que
l'opération de décalage vers la droite.

=== Les opérateurs de comparaison

Les opérateurs de comparaison sont utilisés dans les structures de
contrôle d'une application. Ils renvoient une valeur de type `boolean`
en fonction du résultat de la comparaison effectuée. Cette valeur sera
ensuite utilisée par la structure de contrôle.

[width="99%",cols="24%,28%,21%,27%",options="header",]
|=======================================================================
|Opérateur |Test réalisé |Exemple |Résultat
|`==` |Egalité |`2 == 5` |`false`

|`!=` |Inégalité |`2 != 5` |`true`

|`<` |Infériorité |`2 < 5` |`true`

|`>` |Supériorité |`2 > 5` |`false`

|`<=` |Infériorité ou égalité |`2 <= 5` |`true`

|`>=` |Supériorité ou égalité |`2 >= 5` |`false`

|`instanceof` |Comparaison du type de la variable avec le type indiqué
|`O1  instanceof Client` |`true` si la variable `O1` référence un objet
créé à partir de la classe client ou d'une sous-classe
|=======================================================================

L'opérateur `instanceof` est commenté plus en détail dans le chapitre
Programmation objet.

=== L'opérateur de concaténation

L'opérateur +, déjà utilisé pour l'addition, est également utilisé pour
la concaténation de chaînes de caractères. Le fonctionnement de
l'opérateur est déterminé par le type des opérandes. Si un des opérandes
est du type `String`, alors l'opérateur + effectue une concaténation
avec éventuellement une conversion implicite de l'autre opérande en
chaîne de caractères.

Le petit inconvénient de l'opérateur `+` est qu'il ne brille pas par sa
rapidité pour les concaténations. En fait, ce n'est pas réellement
l'opérateur qui est en cause, mais la technique utilisée par Java pour
gérer les chaînes de caractères (elles ne peuvent pas être modifiées
après création). Si vous avez de nombreuses concaténations à exécuter
sur une chaîne, il est préférable d'utiliser la classe `StringBuilder`
(ou `StringBuffer` uniquement si vous travaillez en
environnement multi-thread).

Exemple

....
long duree;  
String lievre;  
String tortue="";  
long debut, fin;  
debut = System.currentTimeMillis();  
for (int i = 0; i <= 10000; i++)  
{  
    tortue = tortue + " " + i;  
}  
fin = System.currentTimeMillis();  
duree = fin-debut;  
System.out.println("durée pour la tortue : " + duree + "ms");  
debut = System.currentTimeMillis();  
StringBuilder sb = new StringBuilder();  
for (int i = 0; i <= 10000; i++)  
{  
    sb.append(" ");  
    sb.append(i);  
}  
lievre = sb.toString();  
fin = System.currentTimeMillis();  
duree = fin-debut;  
System.out.println("durée pour le lièvre : " + duree + "ms");  
if (lievre.equals(tortue))  
{  
    System.out.println("les deux chaînes sont identiques");  
}
....

Résultat de la course :

....
durée pour la tortue : 249ms  
durée pour le lièvre : 10ms  
les deux chaînes sont identiques
....

Ce résultat se passe de commentaire ! Remarquez tout de même le nombre
d'itérations au niveau de la boucle. Pour quelques concaténations
successives, l'opérateur `+` reste adapté.

=== Les opérateurs logiques

Les opérateurs logiques permettent de combiner les expressions dans des
structures conditionnelles ou des structures de boucle.

[width="100%",cols="20%,17%,27%,36%",options="header",]
|=======================================================================
|Opérateur |Opération |Exemple |Résultat
|`&` |Et logique |`test1 & test2` |`true` si test1 et test2 valent
`true`

|`|` |Ou logique |`test1 | test2` |`true` si test1 ou test2 vaut `true`

|`^` |Ou exclusif |`test1 ^ test2` |`true` si test1 ou test2 vaut `true`
mais `false` si les deux valent `true` simultanément

|`!` |Négation |`!test1` |Inverse le résultat du test

|`&&` |Et logique |`test1 && test2` |Comme le `&` mais test2 ne sera
évalué que si test1 vaut `true`

|`||` |Ou logique |`test1 || test2` |Comme le `|` mais test2 ne sera
évalué que si test1 vaut `false`
|=======================================================================

Il faudra être prudent avec les opérateurs `&&` et `||` car l'expression
que vous testerez en second (test2 dans notre cas) pourra parfois ne pas
être exécutée. Si cette deuxième expression modifie une variable,
celle-ci ne sera modifiée que dans les cas suivants :

* Si test1 vaut `true` dans le cas du `&&`.
* Si test1 vaut `false` dans le cas du `||`.

__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
*Note*

Il est donc préférable d'éviter l'appel de fonctions modifiant certaines
informations dans une expression avec des opérateurs logiques. L'intérêt
des opérateurs `&&` et `||` étant d'éviter des tests inutiles, ils sont
à privilégier par rapport à leurs homologues `&` et `|`.
__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

=== Ordre d'évaluation des opérateurs

Lorsque plusieurs opérateurs sont combinés dans une expression, ils sont
évalués dans un ordre bien précis. Les incrémentations et
décrémentations préfixées sont exécutées en premier, puis les opérations
arithmétiques, les opérations de comparaison, les opérateurs logiques et
enfin les affectations.

Les opérateurs arithmétiques ont entre eux également un ordre
d'évaluation dans une expression. L'ordre d'évaluation est le suivant :

* Négation (–)
* Multiplication et division (`*`, `/`)
* Modulo (`%`)
* Addition et soustraction (`+`, `–`), concaténation de chaînes (`+`)

Si un ordre d'évaluation différent est nécessaire dans votre expression,
il faut placer les portions à évaluer en priorité entre parenthèses
comme dans l'expression suivante :

....
x= (z * 4) ^ (y * (a + 2));
....

Vous pouvez utiliser autant de niveaux de parenthèses que vous le
souhaitez dans une expression. Il importe cependant que l'expression
contienne autant de parenthèses fermantes que de parenthèses ouvrantes
sinon le compilateur générera une erreur.

== Les structures de contrôle

=== Présentation

Les structures de contrôle permettent de contrôler l'exécution des
instructions dans votre code. Deux types de structures sont
disponibles :

* Les structures de décision : elles aiguilleront l'exécution du code en
fonction des valeurs que pourra prendre une expression de test.
* Les structures de boucle : elles feront exécuter une portion de code
un certain nombre de fois, jusqu'à ce qu'une condition soit remplie ou
tant qu'une condition est remplie.

=== Structures de décision

Deux solutions sont possibles.

==== Structure if

Quatre syntaxes sont utilisables pour l'instruction if.

....
if (condition)instruction;
....

Si la condition vaut `true` alors l'instruction est exécutée. La
condition doit être une expression qui, une fois évaluée, doit fournir
un booléen (`true` ou `false`). Avec cette syntaxe, seule l'instruction
située après le `if` sera exécutée si la condition vaut `true`. Pour
exécuter plusieurs instructions en fonction d'une condition, il faut
utiliser la syntaxe ci-après.

....
if (condition)  
{  
     instruction 1;  
     ...  
     instruction n;  
}
....

Dans ce cas, le groupe d'instructions situé entre les accolades sera
exécuté si la condition vaut `true`.

Vous pouvez également spécifier une ou plusieurs instructions qui seront
exécutées si la condition vaut `false` en ajoutant un bloc `else`.

....
if (condition)  
{  
     instruction 1;  
     ...  
     instruction n;  
}  
else  
{  
     instruction 1;  
     ...  
     instruction n;  
}
....

Vous pouvez également imbriquer les conditions avec la syntaxe
suivante :

....
if (condition1)  
{  
     instruction 1  
     ...  
     instruction n  
}  
else if (condition 2)  
{  
     instruction 1  
     ...  
     instruction n  
}  
else  
{  
     instruction 1  
     ...  
     instruction n  
}
....

Dans ce cas, on teste la première condition. Si elle est vraie, alors le
bloc de code correspondant est exécuté, sinon on teste la suivante et
ainsi de suite. Si aucune condition n'est vérifiée, le bloc de code
spécifié après le `else` est exécuté. L'instruction `else` n'est pas
obligatoire dans cette structure. Dans ce cas, il se peut qu'aucune
instruction ne soit exécutée si aucune des conditions n'est vraie.

==== Structure ternaire

Cette structure particulière correspond à une instruction `if...else`.
Elle n'est utilisable que pour l'affectation d'une valeur. C'est une
structure concise remplaçant avantageusement l'instruction `if...else`.

....
String message = condition ? "si true" : "si false";
....

Le `?` permet de déclencher l'évaluation de la condition. Si la
condition vaut `true` alors c'est la valeur fournie après le `?` qui est
retournée, sinon c'est la valeur fournie après les `:` qui est
retournée.

L'instruction équivalente à un `if...else` est la suivante :

....
if(condition) 
   message="si true"; 
else 
   message="si false";
....

==== Structure switch historique

La structure `switch` permet un fonctionnement équivalent, mais offre
une meilleure lisibilité du code. La syntaxe historique est la suivante
:

....
switch (expression)  
{  
    case valeur1:  
              instruction 1  
              ...  
              instruction n  
              break;  
    case valeur2:  
              instruction 1  
              ...  
              instruction n  
              break;  
    default:  
              instruction 1  
              ...  
              instruction n  
}
....

La valeur de l'expression est évaluée au début de la structure (par le
`switch`) puis la valeur obtenue est comparée avec la valeur spécifiée
dans le premier `case`.

Si les deux valeurs sont égales, alors le bloc de code sous-jacent est
exécuté.

Sinon, la valeur obtenue est comparée avec la valeur du `case` suivant.
S'il y a correspondance, le bloc de code est exécuté et ainsi de suite
jusqu'au dernier `case`.

Si aucune valeur concordante n'est trouvée dans les différents `case`,
alors le bloc de code spécifié par le mot-clé `default` est exécuté.

Chacun des blocs de code doit se terminer par l'instruction `break`. Si
ce n'est pas le cas, l'exécution se poursuivra par le bloc de code
suivant jusqu'à ce qu'une instruction `break` soit rencontrée ou jusqu'à
la fin de la structure `switch`. Cette solution peut être utilisée pour
pouvoir exécuter un même bloc de code pour différentes valeurs testées.

La valeur à tester peut être contenue dans une variable, mais peut
également être le résultat d'un calcul. Dans ce cas, le calcul n'est
effectué qu'une seule fois au début du `switch`. Le type de la valeur
testée peut être numérique entière, caractère, chaîne de caractères ou
énumération. Il faut bien sûr que le type de la variable testée
corresponde au type des valeurs dans les différents `case`.

Si l’expression est de type chaîne de caractères, la méthode `equals`
est utilisée pour vérifier l’égalité avec les valeurs des différents
`case`. La comparaison fait donc une distinction entre minuscules et
majuscules.

....
System.out.println("Répondez oui, non ou n'importe quoi:"); 
BufferedReader br;  
br=new BufferedReader(new InputStreamReader(System.in));  
String reponse="";  
reponse=br.readLine();  
switch (reponse)  
{  
    case "oui":  
    case "OUI":  
         System.out.println("réponse positive");  
         break;  
    case "non":  
    case "NON":  
         System.out.println("réponse négative");  
         break;  
    default:   
         System.out.println("mauvaise réponse");  
}
....

==== Structure switch nouvelle génération

La structure `switch` historique souffrait de quelques limitations :

* Obligation de répéter le mot-clé `case` pour chaque valeur à évaluer.
* Obligation d’utiliser le mot clé `break` pour sortir du `switch`.
* Impossibilité d’initialiser simplement une variable à partir de cette
structure.

La nouvelle version du `switch` répond à ces problématiques. Voici la
nouvelle syntaxe de la structure (l’ancienne syntaxe est bien sûr
toujours compatible) :

....
[TypeRetour variableRetour=]  
switch (expression)   
{   
    case valeur1, valeur2 -> instruction 
    case valeur3 -> {  
              TypeRetour valeurRetour; 
              instruction 1   
              ...   
              instruction n  
              [yield valeurRetour]  
            } 
    default -> instruction 
}
....

Voici les nouveautés :

* Les valeurs pour lesquelles le traitement est identique peuvent se
suivre séparées d’une virgule.
* L’opérateur séparant les valeurs des instructions à exécuter n’est
plus les deux points (`:`) mais l’opérateur _arrow_ (flèche `->`). Il
s’agit d’une expression lambda. Pour plus d’informations sur cette
syntaxe, référez-vous au chapitre Les expressions lambda.
* S’il y a plusieurs instructions à effectuer, elles doivent être
placées dans un bloc de code délimité par des accolades.
* Le `switch` peut éventuellement retourner une valeur. Cette valeur
correspond au résultat des instructions. Si une seule instruction est
exécutée, la valeur retournée est implicitement le résultat de
l’instruction. Le mot-clé `return` n’est pas utile. S’il y a plusieurs
instructions et que le compilateur ne détecte pas le retour implicite,
il faut utiliser le mot-clé `yield` pour indiquer la valeur à retourner.

Reprenons en exemple l’énumération `JOUR` :

....
public enum Jour   
{   
   DIMANCHE,   
   LUNDI,   
   MARDI,   
   MERCREDI,   
   JEUDI,   
   VENDREDI,   
   SAMEDI   
}
....

Le code suivant permet d’avoir une syntaxe concise pour afficher une
information en fonction du jour de la semaine :

....
Jour unJour = Jour.DIMANCHE;  
switch (unJour) {  
case LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI   
-> System.out.println("On est en semaine");  
case SAMEDI, DIMANCHE   
-> System.out.println("On est en week-end");  
}
....

Le code suivant permet d’initialiser simplement une variable en fonction
de la valeur passée au `switch`. Dans l’exemple suivant, les
instructions retournent implicitement un entier (sans utilisation du
mot-clé `return`) :

....
Jour unJour = Jour.DIMANCHE;  
int typeJour =   
switch(unJour) {  
                    case LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI 
                                        -> 0;  
                    case SAMEDI, DIMANCHE   
                                        -> 1;  
};  
System.out.println(typeJour);
....

Pour terminer, les instructions peuvent être plus complexes pour
retourner la bonne valeur, et dans cette situation, le compilateur peut
ne pas savoir quelle est la valeur à retourner. Il est possible de
l’aider en utilisant le mot-clé `yield` (dont le rôle est finalement
équivalent au mot-clé `return` classique).

....
Jour unJour = Jour.DIMANCHE;  
int typeJourSiContientUnM =   
switch(unJour) {  
       case MARDI, MERCREDI, SAMEDI, DIMANCHE -> {  
             if(unJour==Jour.MARDI || unJour==Jour.MERCREDI) { 
                    yield 0;  
             }  
             else {  
                    yield 1;  
             }  
       }  
       default -> -1;  
};  
System.out.println(typeJourSiContientUnM);
....

Dans le cadre du `case` de la structure ci-dessus, une conditionnelle a
été ajoutée pour mettre en évidence l’utilisation du mot-clé `yield`.
Bien sûr, le code pouvait être écrit différemment pour ne pas se
retrouver dans cette situation.

=== Les structures de boucle

Trois structures sont à notre disposition :

....
while (condition)  
do ... while (condition)  
for
....

Elles ont toutes pour but de faire exécuter un bloc de code un certain
nombre de fois en fonction d'une condition.

==== Structure while

Cette structure exécute un bloc de façon répétitive tant que la
condition est vraie.

....
while (condition)  
{  
    instruction 1  
    ...  
    instruction n  
}
....

La condition est évaluée avant le premier passage dans la boucle. Si le
résultat est faux à cet instant, alors le bloc de code n'est pas
exécuté. Après chaque exécution du bloc de code, la condition est à
nouveau évaluée pour vérifier si une nouvelle exécution du bloc de code
est nécessaire. Il est recommandé que l'exécution du bloc de code
contienne une ou plusieurs instructions susceptibles de faire évoluer la
condition. Si ce n'est pas le cas, la boucle s'exécutera sans fin. Il ne
faut surtout pas placer le caractère "`;`" à la fin de la ligne du
`while` car dans ce cas, le bloc de code n'est plus associé à la boucle.

....
int i=0;  
while (i<=10)//Pas de ; ici. Sinon le bloc sous-jacent n'est pas 
            //lié à la boucle 
{  
    System.out.println(i);  
    i++;  
}
....

==== Structure do ... while

....
do  
{  
    instruction 1  
    ...  
    instruction n  
}  
while (condition);
....

Cette structure a un fonctionnement identique à la précédente. La
différence réside dans le fait que la condition est examinée après
l'exécution du bloc de code. Elle permet de garantir que le bloc de code
est exécuté au moins une fois puisque la condition est évaluée pour la
première fois après la première exécution du bloc de code. Si la
condition est vraie, alors le bloc est exécuté une nouvelle fois
jusqu'à ce que la condition soit fausse. Faites attention à ne pas
oublier le point-virgule après le `while` sinon le compilateur détecte
une erreur de syntaxe.

....
do  
{  
    System.out.println(i);  
    i++;  
}  
while(i<=10);
....

==== Structure for

Lorsque vous connaissez le nombre d'itérations à réaliser dans une
boucle, il est préférable d'utiliser la structure `for`. Pour pouvoir
utiliser cette instruction, une variable de compteur doit être déclarée.
Cette variable peut être déclarée dans la structure `for` ou à
l'extérieur, elle doit dans ce cas être déclarée avant la structure
`for`.

La syntaxe générale est la suivante :

....
for(initialisation;condition;instruction d'itération)  
{  
    instruction 1  
    ...  
    instruction n  
}
....

La partie `initialisation` est exécutée une seule fois lors de l'entrée
dans la boucle. La partie `condition` est évaluée lors de l'entrée dans
la boucle puis à chaque itération. Le résultat de l'évaluation de la
condition détermine si le bloc de code est exécuté. Si le résultat est
vrai, une nouvelle itération de la boucle est effectuée. Après
l'exécution du bloc de code, l'instruction d'itération est à son tour
exécutée. Puis la condition est à nouveau testée et ainsi de suite tant
que la condition est vraie.

Voici ci-dessous deux boucles `for` en action pour afficher une table de
multiplication.

....
int multiplicateur;  
for(multiplicateur=1;multiplicateur<=10;multiplicateur++)  
{  
   for (int table = 1; table <= 10; table++)  
   {  
      System.out.print(table*multiplicateur + "\t");  
   }  
   System.out.println();  
}
....

Nous obtenons le résultat suivant :

....
1    2     3     4     5     6     7     8     9     10 
2    4     6     8     10    12    14    16    18    20 
3    6     9     12    15    18    21    24    27    30  
4    8     12    16    20    24    28    32    36    40 
5    10    15    20    25    30    35    40    45    50 
6    12    18    24    30    36    42    48    54    60  
7    14    21    28    35    42    49    56    63    70 
8    16    24    32    40    48    56    64    72    80 
9    18    27    36    45    54    63    72    81    90 
10   20    30    40    50    60    70    80    90    100
....

Une autre syntaxe de la boucle `for` permet d'exécuter un bloc de code
pour chaque élément contenu dans un tableau ou dans une instance de
classe implémentant l'interface `Iterable`. C'est la boucle `foreach`.
La syntaxe générale de cette instruction est la suivante :

....
for (type elementDuTableau : tableau)  
{  
    instruction 1  
    ...  
    instruction n  
}
....

Il n’y a pas de notion de compteur dans cette structure puisqu'elle
effectue elle-même les itérations sur tous les éléments présents dans le
tableau ou la collection.

La variable déclarée dans la structure (nommée `elementDuTableau` dans
l'exemple) sert à extraire un à un les éléments du tableau ou de la
collection pour que le bloc de code puisse les manipuler. Il faut bien
sûr que le type de la variable soit compatible avec le type des éléments
stockés dans le tableau ou la collection. La variable doit
obligatoirement être déclarée dans la structure `for` et non à
l'extérieur. Elle ne sera utilisable qu'à l'intérieur de la structure.
En revanche, vous n'avez pas à vous soucier du nombre d'éléments, car la
structure est capable de gérer elle-même le déplacement dans le tableau
ou la collection. Voici un petit exemple pour clarifier la situation !

Avec une boucle classique :

....
String[] tablo={"rouge","vert","bleu","blanc"};  
for (int cpt = 0; cpt < tablo.length; cpt++)  
{  
     System.out.println(tablo[cpt]);  
}
....

Avec la boucle `for` d'itération :

....
String[] tablo={"rouge","vert","bleu","blanc"};  
for (String s : tablo)  
{  
    System.out.println(s);  
}
....

____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
*Note*

Le code placé à l'intérieur de cette structure `for` ne doit pas
modifier le contenu de la collection, car l’élément parcouru est placé
en lecture seule. Dans le cas d'un tableau ou d'une collection d'objets,
il est possible de changer les valeurs des propriétés de ces objets (la
variable référençant l'objet n'étant pas modifiée).
____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________

Il est donc interdit d'ajouter ou de supprimer des éléments pendant le
parcours de la collection. Le problème ne se pose pas avec un tableau.
La taille d'un tableau étant fixe, il est bien impossible d'y ajouter ou
d’y supprimer un élément. Le code suivant met en évidence cette
limitation lors du parcours d'une `ArrayList`. L'ajout d'un élément à
l’`Arraylist` en cours d'itération déclenche une exception de type
`ConcurrentModificationException`.

....
ArrayList<String> lst;  
st=new ArrayList<String>();  
lst.add("client 1");  
lst.add("client 2");  
lst.add("client 3");  
lst.add("client 5");  
    
for(String st:lst)  
{  
   System.out.println(st);  
   if(st.endsWith("3"))  
   {  
      lst.add("client 4");  
   }  
}
....

=== Interruption d'une structure de boucle

Trois instructions peuvent modifier le fonctionnement normal des
structures de boucle.

==== break

Si cette instruction est placée à l'intérieur du bloc de code d'une
structure de boucle, elle provoque la sortie immédiate de ce bloc de
code. L'exécution se poursuit par l'instruction placée après le bloc de
code. L'instruction `break` doit en général être exécutée de manière
conditionnelle, sinon les instructions situées après à l'intérieur de la
boucle ne seront jamais exécutées.

Dans le cas de boucles imbriquées, il est possible d'utiliser
l'instruction `break` associée avec une étiquette. L'exemple de code
suivant effectue le parcours d'un tableau à deux dimensions et s’arrête
dès qu'une case contenant la valeur 0 est rencontrée.

....
int[][] points = {   
              { 10,10,},  
              { 0,10 },  
              { 45,24 }};  
int x=0,y=0;  
boolean trouve=false;  
 
recherche:  
for (x = 0; x <points.length; x++)  
{  
  for (y = 0; y < points[x].length;y++)   
   {  
      if (points[x][y] == 0)  
      {  
         trouve = true;  
         break recherche;  
      }  
   }  
} 
 
 if (trouve)  
{  
  System.out.println("resultat trouvé dans la case "  
                     + x + "-" + y);  
}  
else  
{  
  System.out.println("recherche infructueuse");  
}
....

==== continue

Cette instruction permet d'interrompre l'exécution de l'itération
courante d'une boucle et de continuer l'exécution à l'itération suivante
après vérification de la condition de sortie de boucle. Comme pour
l'instruction `break`, elle doit être exécutée de manière conditionnelle
et accepte également l'utilisation d'une étiquette.

Voici un exemple de code permettant de calculer le nombre de nombres
pairs consécutifs à partir de la première case dans un tableau trié.

....
int[] nombres = new int[20]; 
Random rd = new Random(); 
for (int i = 0; i < nombres.length; i++) { 
   nombres[i]=rd.nextInt(20); 
} 
Arrays.sort(nombres); 
System.out.println(Arrays.toString(nombres)); 
int nbPaire; 
for(nbPaire=0;nbPaire<nombres.length;nbPaire++) 
{ 
    
if(nombres[nbPaire]%2==0) 
    
{ 
       continue; 
   } 
   break; 
} 
System.out.println("nombre de paires : " + nbPaire);
....

==== return

L'instruction `return` est utilisée pour sortir immédiatement de la
méthode en cours d'exécution et poursuivre l'exécution par l'instruction
suivant celle qui a appelé cette méthode. Si elle est placée dans une
structure de boucle, elle provoque bien sûr la sortie immédiate de la
boucle puis de la méthode dans laquelle se trouve la boucle.
L'utilisation de cette instruction dans une fonction dont le type de
retour est autre que `void` oblige à fournir à l'instruction `return`
une valeur compatible avec le type de retour de la fonction. Cette
instruction sera abordée dans le chapitre sur la programmation objet.

== Exercices

=== Exercice 1

Créer un tableau de dix chaînes de caractères puis remplir ce tableau
avec des adresses e-mail. Calculer ensuite, à partir des informations
présentes dans le tableau, la part de marché de chacun des fournisseurs.

Indice : dans une adresse e-mail, le nom du fournisseur est la partie
située après le caractère @.

=== Exercice 2

Générer trois nombres aléatoires compris entre 0 et 1000, puis vérifier
si vous avez deux nombres pairs suivis par un nombre impair. Si ce n'est
pas le cas, recommencer jusqu'à ce que vous ayez la combinaison pair,
pair, impair. Afficher ensuite le nombre d'essais nécessaires pour
obtenir cette combinaison.

Indice : la classe `Random` propose un ensemble de méthodes permettant
d'obtenir un nombre aléatoire. Concentrez-vous sur la méthode suivante
en lisant la javadoc :

....
public int nextInt​(int bound)
....

Pour utiliser cette méthode, il est nécessaire d'avoir un objet de type
`Random` :

....
Random rd = new Random(); 
rd.nextInt(…);
....

=== Exercice 3

Générer un nombre aléatoire compris entre 0 et 1000. Demander ensuite à
l'utilisateur de deviner le nombre choisi par l'ordinateur. Il doit
saisir un nombre compris entre 0 et 1000 lui aussi. Comparer le nombre
saisi avec celui choisi par l'ordinateur et afficher sur la console
« c'est plus » ou « c'est moins » selon le cas. Recommencer jusqu'à ce
que l'utilisateur trouve le bon nombre. Afficher alors le nombre
d'essais nécessaires pour trouver la bonne réponse.

Indice : pour récupérer les caractères saisis au clavier, nous avons à
notre disposition le flux `System.in`. Malheureusement, celui-ci ne
propose que des fonctions rudimentaires pour la récupération des saisies
de l'utilisateur (lecture caractère par caractère). Pour une utilisation
plus confortable, il vaut mieux utiliser un objet de type `Scanner`.
Nous aurons ainsi à notre disposition une série de fonctions permettant
la récupération d'entiers, de décimaux, de chaînes de caractères... Ces
fonctions sont nommées `nextXxx` où `Xxx` doit être remplacé par le type
de données que l'on souhaite obtenir, par exemple la méthode `nextInt`
pour un entier, `nextLine` pour une chaîne de caractères, etc.

....
String chaine; 
Scanner sc; 
sc=new Scanner(System.in); 
chaine=sc.nextLine();
....

=== Exercice 4

Ajouter au jeu de l'exercice 3 l'affichage du temps mis par
l'utilisateur pour obtenir la bonne réponse.

Indice : intéressez-vous aux classes `OffsetTime` et `Duration`.

== Corrections

=== Exercice 1

Voici une proposition (et ce n'est qu'une proposition) pour résoudre ce
premier exercice. Le code est agrémenté d'un grand nombre de
commentaires pour bien comprendre la démarche entreprise. Le code a été
écrit dans une seule méthode pour se focaliser sur l'algorithme. Une
amélioration peut consister à découper ce programme en méthodes.

....
import java.util.Arrays; 
 
public  class Exercice1  
{      
 
    static String[] adresses; 
    static String[] listeBruteFournisseurs; 
    static String[] listeFournisseursDistincts;  
    static int[] nombreClients; 
 
    public static void main(String[] args)  
    {  
         //INITIALISATION DU TABLEAU 
        adresses=new String[10];  
        adresses[0]="jpp@sfr.fr";  
        adresses[1]="tom@gmail.com";  
        adresses[2]="fred@sfr.fr";  
        adresses[3]="victor@sfr.fr";  
        adresses[4]="chris@sfr.fr";  
        adresses[5]="robert@orange.fr";  
        adresses[6]="paul@sfr.fr";  
        adresses[7]="lise@gmail.com";  
        adresses[8]="thierry@eni.fr";  
        adresses[9]="marie@eni.fr";  
         
        //RECUPERATION DES FOURNISSEURS DE CHAQUE ADRESSE 
        listeBruteFournisseurs =new String[10];  
        for (int i=0;i<adresses.length;i++)  
        {  
            //Pour chaque adresse, récupération de la chaine après le @: 
            listeBruteFournisseurs[i]= 
adresses[i].substring(adresses[i].indexOf('@')+1); 
        }  
        System.out.println("Liste brute des fournisseurs:"); 
        System.out.println(Arrays.toString(listeBruteFournisseurs)); 
         
        //RECUPERATION DE LA LISTE DES FOURNISSEURS DISTINCTS ET NOMBRE CLIENTS 
        //1-Trier le tableau 
        Arrays.sort(listeBruteFournisseurs); 
        System.out.println("Liste triée des fournisseurs:"); 
        System.out.println(Arrays.toString(listeBruteFournisseurs)); 
        //2-Initialiser le tableau des fournisseurs distincts avec une 
taille de 1 (car il y a au moins 1 fournisseur) 
        //et initialiser le tableau du nombre de clients par fournisseur 
        listeFournisseursDistincts = new String[1]; 
        nombreClients = new int[1]; 
        //3-Ajouter le premier fournisseur et lui associer 1 client: 
        listeFournisseursDistincts[0]=listeBruteFournisseurs[0]; 
        nombreClients[0]=1; 
        //4-Parcourir le tableau trié des fournisseurs pour détecter 
d'éventuels autres fournisseurs 
        //Le parcours commence à l'index 1 car celui de l'index 0 a été 
ajouté à la liste des fournisseurs distincts 
        for(int i=1;i<listeBruteFournisseurs.length;i++) 
        { 
            //5-Si le fournisseur actuel est différent du dernier 
fournisseur distinct ajouté 
            //C'est que c'est un nouveau fournisseur. 
 
if(!listeBruteFournisseurs[i].equals(listeFournisseursDistincts
[listeFournisseursDistincts.length-1])) 
            { 
               //Agrandir le tableau des fournisseurs distincts d'une case 
              //et agrandir le tableau du nompbre de clients d'une case 
               listeFournisseursDistincts = 
Arrays.copyOf(listeFournisseursDistincts, 
listeFournisseursDistincts.length+1); 
               nombreClients = Arrays.copyOf(nombreClients, 
nombreClients.length+1); 
               //Ajouter ce nouveau fournisseur dans le tableau et lui 
associer 1 client 
 
               listeFournisseursDistincts[listeFournisseursDistincts. 
length-1]=listeBruteFournisseurs[i]; 
               nombreClients[nombreClients.length-1]=1; 
            } 
            else 
            { 
              //C'est un fournisseur déjà référencé, il suffit d'ajouter 
un client 
              nombreClients[nombreClients.length-1]+=1; 
            } 
        } 
        System.out.println("Liste des fournisseurs distincts:"); 
        System.out.println(Arrays.toString(listeFournisseursDistincts)); 
        System.out.println("Nombre de clients pour chaque fournisseur"); 
        System.out.println(Arrays.toString(nombreClients)); 
         
        //AFFICHAGE DE LA PART DE MARCHE DE CHACUN DES FOURNISSEURS: 
        System.out.println("Parts de marché:"); 
        for(int i=0;i<listeFournisseursDistincts.length;i++) 
        { 
            System.out.println(
               String.format("=> %s \t: %d clients sur %d (%.1f%%)", 
               listeFournisseursDistincts[i], 
               nombreClients[i], 
               adresses.length, 
               (nombreClients[i]*100.0/adresses.length))
); 
        } 
         
    }  
}
....

=== Exercice 2

Le code de cet exercice débute, comme le précédent, par les
initialisations.

La boucle `do...while` permet de tirer au sort trois nombres et de
vérifier leurs valeurs pour savoir si la combinaison pair/pair/impair
est obtenue ou s'il faut effectuer une nouvelle tentative.

....
import java.util.Random; 
 
public class Exercice2 
{ 
   public static void main(String[] args) 
   { 
       int nombreTentative=0; 
       int nb1,nb2,nb3; 
       Random rd = new Random(); 
       //La boucle do...while est adaptée car il faut au moins une tentative 
       do  
       { 
           //Tirage au sort des 3 variables 
           nb1=rd.nextInt(1000); 
           nb2=rd.nextInt(1000); 
           nb3=rd.nextInt(1000); 
           //Incrémentation du nombre de tentatives 
           nombreTentative++; 
           //Affichage de la tentative 
           System.out.println("nombre 1:" + nb1 + " nombre 2:" + 
nb2 + " nombre 3:" + nb3); 
           //On recommence si nb1 est impair ou si nb2 est impair 
ou si nb3 est pair. 
           //pour cela, on évalue le reste de la division entière par 2. 
           //si le reste égale 1, le nombre est impair 
           //si le reste égale 0, le nombre est pair 
       } while(nb1 % 2==1 || nb2 % 2==1 || nb3 % 2==0); 
 
       System.out.println("Résultat obtenu en " + nombreTentative 
+ " essai(s)"); 
   } 
}
....

=== Exercice 3

Le code de cet exercice débute, une nouvelle fois, par les
initialisations.

La boucle `do...while` gère ensuite la saisie d'un entier par
l'utilisateur puis la comparaison avec le nombre secret et enfin
l'affichage du message correspondant au résultat de cette comparaison.
Cette boucle est à nouveau exécutée tant que le nombre saisi est
différent du nombre secret.

À la sortie de la boucle, le score est affiché.

....
import java.util.Random; 
import java.util.Scanner;  
 
public class Exercice3 
{ 
   public static void main(String[] args) 
   { 
        int nbEssais=0; 
        int secret; 
        int nbSaisi; 
        Random rd = new Random(); 
        
        secret=rd.nextInt(1000); 
        Scanner sc=new Scanner(System.in); 
        System.out.println("Veuillez saisir un entier entre 0 et 1000"); 
        do 
        { 
            //récupération de la valeur saisie par l'utilisateur 
            nbSaisi=sc.nextInt(); 
            //incrémentation du nombre d'essais 
            nbEssais++; 
            //comparaison avec le nombre secret 
            //affichage d'un message si le nombre est différent 
            if(nbSaisi<secret) 
            { 
                 System.out.println("c'est plus"); 
            } 
            else if(nbSaisi>secret) 
            { 
                 System.out.println("c'est moins"); 
            } 
            //On continue si le nbSaisi n'est pas égal au nombre secret! 
       } while (nbSaisi!=secret); 
       System.out.println("Bravo vous avez trouvé en " + nbEssais + " essai(s)"); 
    } 
}
....

=== Exercice 4

Pour faire évoluer l'application précédente, nous ajoutons simplement
l'initialisation de la variable `debut` avec l'heure courante avant le
début de la boucle. À la fin de la boucle (donc du jeu) nous faisons la
même chose avec la variable `fin`. La durée de la partie est la
différence entre ces deux heures. Le résultat est ensuite affiché en
secondes.

....
import java.time.Duration; 
import java.time.OffsetTime; 
import java.util.Random; 
import java.util.Scanner; 
 
public class Exercice4  { 
   public static void main(String[] args) 
   { 
        int nbEssais=0; 
        int secret; 
        int nbSaisi; 
        Random rd = new Random(); 
 
        secret=rd.nextInt(1000); 
        Scanner sc=new Scanner(System.in); 
        //Enregistrement du temps au début du programme 
        OffsetTime debut = OffsetTime.now(); 
        System.out.println("Veuillez saisir un entier entre 0 et 1000"); 
        do 
        { 
            //récupération de la valeur saisie par l'utilisateur 
            nbSaisi=sc.nextInt(); 
            //incrémentation du nombre d'essais 
            nbEssais++; 
            //comparaison avec le nombre secret 
            //affichage d'un message si le nombre est différent 
            if(nbSaisi<secret) 
            { 
                 System.out.println("c'est plus"); 
            }             else if(nbSaisi>secret) 
            { 
                 System.out.println("c'est moins"); 
            }             //On continue si le nbSaisi n'est pas égal 
au nombre secret! 
        } while (nbSaisi!=secret); 
        //Enregistrement du temps à la fin du programme  
      OffsetTime fin = OffsetTime.now(); 
       //Calcul de la durée entre le début et la fin 
       Duration duree = Duration.between(debut, fin); 
       System.out.println("Bravo vous avez trouvé en " + nbEssais + 
" essai(s)"); 
       //Affichage du temps pris en secondes 
       System.out.println("Vous avez utilisé " + duree.getSeconds() + 
" secondes"); 
   } 
}
....

== Conclusion

Vous disposez à présent des techniques de base pour écrire des
algorithmes (déclaration des variables, utilisation des opérateurs
disponibles et utilisation des structures de contrôle). Pour progresser,
il faudra passer des heures à découvrir les fonctionnalités offertes par
l'API Java. Rapidement, vous allez avoir besoin de connaître les bases
de la programmation objet pour approfondir vos connaissances. C'est
l'objectif du prochain chapitre.
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEyMjAxMTQ4Nl19
-->