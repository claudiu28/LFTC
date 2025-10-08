# Laborator 1 – LFTC

**1. Specificarea minilimbajului de programare (MLP).**

**Tipuri de date:**

| MLP       | C++    |
| --------- | ------ |
| Intreg    | int    |
| Real      | float  |
| Structura | struct |

**Instrucțiuni:**

| MLP      | C++   |
| -------- | ----- |
| atribuim | =     |
| Citeste  | cin   |
| Scrie    | cout  |
| Daca     | if    |
| Altfel   | else  |
| CatTimp  | while |

**Operatori:**

| MLP  | C++          |
| ---- | ------------ |
| +    | +            |
| -    | -            |
| \*   | \*           |
| /    | /            |
| %    | %            |
| Egal | ==           |
| !=   | !=           |
| <    | <            |
| <=   | <=           |
| >    | >            |
| >=   | >=           |
| si   | &&           |
| sau  | &#124;&#124; |

**Separators**

| MLP | C++ |
| --- | --- |
| ;   | ;   |
| ,   | ,   |
| {   | {   |
| }   | }   |
| (   | (   |
| )   | )   |
| "   | "   |

**Other symbols:**

| MLP           | C++                                          |
| ------------- | -------------------------------------------- |
| Import        | #include<iostream> </b> using namespace std; |
| End_Program   | return 0;                                    |
| Start_Program | int main()                                   |

**Restrictii:**

- ID: doar litere si incepe cu litera mica mereu, lungime maxim 250, se permit cifire, nu se permit virguale sau underscoare, etc.;
- Constante: intregi, maxim 9 cifre si reale maxim 2 zecimale;
  Regex pentru ID: `[a-z][a-zA-Z0-9]{0,249}`
  Regex pentru intregi: `[+-]?(0|[1-9][0-9]{0-8})`
  Regex pentru reale: `[+-]?(0|[1-9][0-9]{0-8})(\.[0-9]{1,2})`

**Tabela de codificare:**

| Simbol        | Cod |
| ------------- | --- |
| ID            | 00  |
| CONST         | 01  |
| (             | 02  |
| )             | 03  |
| ,             | 04  |
| ;             | 05  |
| {             | 06  |
| }             | 07  |
| +             | 08  |
| -             | 09  |
| \*            | 10  |
| /             | 11  |
| %             | 12  |
| Egal          | 13  |
| !=            | 14  |
| <             | 15  |
| <=            | 16  |
| \>            | 17  |
| >=            | 18  |
| Si            | 19  |
| Sau           | 20  |
| atribuim      | 21  |
| Intreg        | 22  |
| Real          | 23  |
| Structura     | 24  |
| Citeste       | 25  |
| Scrie         | 26  |
| Daca          | 27  |
| Altfel        | 28  |
| CatTimp       | 29  |
| Import        | 30  |
| Start_Program | 31  |
| End_Program   | 32  |
| "             | 33  |

**BNF**

```text
<program> ::= <import><start_program><declarari><lista_instr><end_program> |
<import><start_program><end_program>

<import> ::= 'Import'
<start_program> ::= 'Start_Program''{'
<end_program> ::= 'End_Program'';''}'

<declarari> ::= <declarare> | <declarare><declarari>
<declarare> ::= <tip><lista_ID>';'
<lista_ID> ::= ID | ID','<lista_ID>
<tip> ::= 'Intreg' | 'Real' | 'Structura'

<lista_instr> ::= <instr> | <instr><lista_instr>
<instr> ::= <atribuire>';' | <citeste>';' | <scrie>';' | <daca> | <cat_timp>
<atribuire> ::= ID 'atribuim' <exp>
<citeste> ::= 'Citeste' <lista_id>
<scrie> ::= 'Scrie' <lista_id>
<daca> ::= 'Daca''(' <exp> ')''{'<lista_instr>'}' | 'Daca''(' <exp> ')''{'<lista_instr>'}'<altfel>
<altfel> ::= 'Altfel' '{' <lista_instr> '}'
<cat_timp> ::= 'CatTimp' '(' <exp> ')' '{' <lista_instr> '}'

<exp> ::= <termen> | <termen><termeni>
<termen> ::= <factor><factori> | <factor>
<factor> ::= ID | CONST | '('<exp>')'
<termeni> ::= <relational_logic><termen><termeni> | <relational_logic><termen>
<factori> ::= <aritmetic><factor><factori> | <aritmetic><factor>
<relational_logic> ::= 'Egal' | '!=' | '<' | '<=' | '>' | '>=' | 'si' | 'sau'
<aritmetic> :: = '+' | '-' | '*' | '/'

ID ::= <litera_mica><continuare> | <litera_mica>
<continuare> ::= <caractere><continuare> | <caractere>
<caractere> ::=  <litera_mica> | <litera_mare> | <cifra>
<litera_mica> ::= 'a' | ... | 'z'
<litera_mare> ::= 'A' | ... | 'Z'
<cifra> ::= '0' | ... | '9'

CONST ::= <cifra><cifre> | <cifra> | <cifra><cifre> '.' <cifra><cifra>
<cifre> ::= <cifra><cifre> | <cifra>
```

**2 se cer textele sursa a 3 mini-programe**

- calculeaza suma a n numere citite de la tastatura

```text
      Import
      Start_Program {
        Scrie "N = ";
        Intreg n, s;
        Citeste n;
        s atribuim 0;
        CatTimp (n > 0) {
          Citeste x;
          s atribuim s + x;
          n atribuim n - 1;
        }
        Scrie "Suma este: ", s;
        End_Program;
      }
```

**- determina cmmdc a 2 nr naturale**

```text
     Import
      Start_Program {
      Scrie "A = ";
      Intreg a, b, r;
      Citeste a;
      Scrie "B = ";
      Citeste b;
      CatTimp (b != 0) {
        r atribuim a % b;
        a atribuim b;
        b atribuim r;
      }
      Scrie "Cmmdc este: ", a;
      End_Program;
    }
```

**- calculeaza perimetrul si aria cercului de o raza data data**

```text
    Import
    Start_Program {
      Scrie "N = ";
      Real p, a, r;
      Citeste r;
      a atribuim 3.14 * r * r;
      p atribuim 2 * 3.14 * r;
      Scrie "Aria este: ", a;
      Scrie "Perimetrul este: ", p;
      End_Program;
    }
```

**Errori**

- Unul dintre programe contine doua erori care sunt in acelasi timp
  erori in limbajul original (pentru care MLP defineste un subset)

```text
    Start_Program {
      Scrie "N = ";
      double p, a, r;
      Citeste r;
      a atribuim 3.14 * r * r
      p atribuim 2 * 3.14 * r;
      Scrie "Aria este: ", a;
      Scrie "Perimetrul este: ", p;
      End_Program;
    }
```

1. tip de data double nu este definit in MLP
2. lipseste Import fara este programul nu este valid (practic in c++ nu am avea nici iostream si std si nu ar rula
   programul)

- Al doilea program contine doua erori conform MLP, dar care nu sunt erori in limbajul original. Se cere ca acesta sa
  fie compilat si
  executat in limbajul original ales.

```text
   Import
   Start_Program {
   Scrie "N = ";
   double p, a, r;
   Citeste r;
   a atribuim 3.141 * r * r
   p atribuim 2 * 3.141 * r;
   Scrie "Aria este: ", a;
   Scrie "Perimetrul este: ", p;
   End_Program;
   }
```

1. tipul de data double nu este definit in MLP, dar este valid in C++
2. constanta de tip real are mai mult de 2 zecimale, dar este valid in C++
