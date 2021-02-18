# LFPC-labs
Tasks:
1. Write a program which converts regular grammar to Finite Automaton (FA).
2. Using Finite Automaton (FA) check if some input string is accepted by FA. 
3. Determine the grammar type by the Chomsky classification.
4. Bonus Point -> Using some graphic library plot FA graph.

Variant 17. VN={S, A, B, C}, VT={a, b, c, d},
P={
 1. S-dA
 2. A-aB
 3. B-bC
 4. C-cB
 5. A-bA
 6. B-aB
 7. B-d }
 
After Chomsky classification this grammar is of Type 3 (Regular Grammar). Also it is a right-linear grammar 
because it consists of a terminal symbol perceded by a single nonterminal symbol (at the right).

For graph plot I used JFLAP (just to represent).
