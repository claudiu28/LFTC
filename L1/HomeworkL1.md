# Laborator 1 – LFTC

**1. Specificarea minilimbajului de programare (MLP).**

<table>
<tr>
<td>
Tipuri de date

| MLP       | C++    |
|-----------|--------|
| Intreg    | int    |
| Real      | float  |
| Structura | struct |

</td>
<td>
Instructiuni

| MLP       | C++   |
|-----------|-------|
| Atribuire | =     |
| Citeste   | cin   | 
| Scrie     | cout  | 
| Daca      | if    |
| Altfel    | else  | 
| CatTimp   | while |

</td>
</tr>
<tr>
<td>
Operatori

| MLP  | C++  |
|------|------|
| +    | +    |
| -    | -    |
| *    | *    |
| /    | /    |
| %    | %    |
| Egal | ==   |
| !=   | !=   |
| <    | <    |
| <=   | <=   |
| >    | >    |
| >=   | >=   |
| si   | &&   |
| sau  | \|\| |

</td>
<td>
Separators

| MLP | C++ |
|-----|-----|
| ;   | ;   |
| ,   | ,   |
| {   | {   |
| }   | }   |
| (   | (   |
| )   | )   |

</td>
</tr>
</table>


**Other symbols:**

| MLP           | C++                                          |
|---------------|----------------------------------------------|
| Import        | #include<iostream> </b> using namespace std; |
| End_Program   | return 0;                                    |
| Start_Program | int main()                                   |

**Restrictii:**

- ID: doar litere si incepe cu litera mica mereu, lungime maxim 20;
- Constante: intregi (fara semn, maxim 9 cifre) si reale (maxim 2 zecimale);

Regex pentru ID: `[a-z][a-zA-Z0-9]{0,19}`
Regex pentru intregi: `[0-9]{1,9}`
Regex pentru reale: `[0-9]{1,7}(\.[0-9]{1,2})?`

**Tabela de codificare:**

