% Murder Mystery
% Facts
person(husband, male, 45).
person(alice, female, 40).
person(victim, male, 30).
person(twin, male, 30).
person(killer, male, 25).
person(child, male, 10).

location(victim, beach).
location(killer, beach).
location(husband, bar).
location(alice, home).
location(child, home).

% Rules

% Husband and Alice were not together on the night of murder
not_together(husband, alice).

% On the night of murder, one male and one female was in the bar
in_bar(male).
in_bar(female).

% Victim was twin, counterpart was innocent
innocent(twin).

% Killer was younger than victim
younger(killer, victim).

% One child was alone at home
alone(child, home).

% Murder conditions
murderer(X) :-
    location(X, beach), % Killer was on beach with victim
    younger(X, victim),
    \+ innocent(X).

% Queries:
% ?- murderer(killer).  % Should return true if killer is murderer
% ?- in_bar(male). in_bar(female).
% ? - murderer(killer).
% ?- in_bar(male).
% ?- innocent(twin).
