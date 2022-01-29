# Game description:
In this game, players move from place to place to collect items from treasure chests located in each place. The player has a certain number of moves before the game ends. 
In each move, the player can take and / or sell an item from his/her backpack, and then move to a new place. 
Each item has a price associated with it. The goal of the game is to collect as much fortune as possible by picking up and selling items. 

# Program description:
A player in the program (an object of the player class) is controlled by a user who decides whether the player should take and / or sell something at each location and which output should be selected next. 
Users can be of two different types: Human users who communicate through a terminal-based user interface (in the command window) or robots who makes random choices. 
When several players participate in the same game, the players move from place to place in turn. 
A result list is printed with assets for each player, sorted with the winner first.

**Datastrucutre:**

A simplified game with one player and one exit from each place. 
Each place-object has a treasure chest with items. The player has a backpack that holds items. 

<img src="ver1%20single%20player/datastruktur.png" alt="datastructure" width="800"/>

# There are four versions of code. 

## Version 1 - single player, no route selection

This is a simple version, there is only one player, and there is no route-choice - each place has only one exit. 

**Screenshot showing a run:**

<img src="ver1%20single%20player/skjembildeRobot.png" alt="screenshot" width="600"/>


## Version 2 - single player with route selection

The player is given alternative exists from the current place. The player decides via the user interface which way to go next.

**New datastructure for Place:**

Each place has now multiple exits. 

<img src="ver2%20route-choice/ds.png" alt="datastructure" width="600"/>

## Version 3 - multiple players with route selection

This version is based on version 1.
The game is expanded to allow multiple players in one game. 
Main-method asks total number of players, the program creates players with name and either terminal- or robot interface. 

## Version 4 - players as threads

This version is based on version 1.
The game is expanded to allow multiple players in one game, and that each player is executed by a thread. 
Main-method asks total number of players, the program creates players with terminal- or robot interface. 

**Challenges:**
1. Only one player/thread has access to the treasure chest in one place at a time
2. Allow only one player/thread to communicate with the terminal at a time. 



