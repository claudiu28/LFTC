**Automat Finit**

 ```text
<automat> ::= <number_of_states><states><dimension_alphabet><alphabet><number_of_transitions><transitions><start_state><number_of_end_states><end_states>

<number_of_states> ::= CONST
<dimension_alphabet> ::= CONST
<number_of_transitions> ::= CONST
<number_of_end_states> ::= CONST

CONST ::= <cifra><cifre> | <cifra> | <cifra><cifre> '.' <cifra><cifra>
<cifre> ::= <cifra><cifre> | <cifra>
<cifra> ::= 0 | 1 | 2 ... | 9

<states> ::= <state> | <state><states> 
<state> ::= A0 | A1 | A2 | A3 | A4 | ...

<alphabet> ::= <simbol> | <simbol><alphabet> 
<simbol> ::= 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | ... | a | b | c | d | ... | A | B | C | ... | + | - ...

<transitions> ::= <transition> | <transition><transitions>
<transition> ::= <state><symbol><state>

<start_state> ::= <state>
<end_state> ::= <state> | <state><end_state>
```