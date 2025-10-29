% Family Tree 
% Facts

parent(rajesh, neha).
parent(rajesh, rohit).
parent(geeta, neha).
parent(geeta, rohit).

parent(neha, anjali).
parent(neha, arjun).
parent(sameer, anjali).
parent(sameer, arjun).

% Gender facts
male(rajesh).
male(rohit).
male(sameer).
male(arjun).

female(geeta).
female(neha).
female(anjali).

% Rules

father(X, Y) :- parent(X, Y), male(X).

mother(X, Y) :- parent(X, Y), female(X).

sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

grandparent(X, Y) :- parent(X, Z), parent(Z, Y).

% Sample queries:
% ?- father(rajesh, Child).
% ?- mother(geeta, Child).
% ?- sibling(neha, rohit).
% ?- grandparent(rajesh, anjali).
