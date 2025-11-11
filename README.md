# Honey Bee Defense

A Tower Defense-style game where players strategically deploy honey bees to defend the hive from advancing hornets. This project was developed as part of the **COMP 250 Fall 2025** course at McGill University, focusing on class design, object-oriented programming, and custom data structures in Java.

## Game Overview

In this game, hornets march toward the hive across a meadow, and the player's goal is to protect the queen by deploying honey bees. Each insect has unique abilities and limitations:

- **Hornets:** Attack the hive and bees with varying health and damage.
- **Honey Bees:** Defend the hive; different types have different abilities:
  - **BusyBee:** Collects resources (pollen) to help support the hive.
  - **AngryBee:** Attacks hornets at melee range with specific attack damage.

Players must manage food resources to place bees strategically and balance offense and defense to prevent hornets from reaching the hive.

## Project Structure

This project follows strict class design guidelines and custom data structures without using Java collections. The main classes include:

- `Tile.java` — Represents a square on the game board.
- `Insect.java` — Abstract base class for all insects.
- `Hornet.java` — Represents a hornet with attack capabilities.
- `HoneyBee.java` — Abstract class for honey bee types.
- `BusyBee.java` — A bee that collects pollen.
- `AngryBee.java` — A bee that attacks hornets.
- `SwarmOfHornets.java` — A custom linear data structure to manage a group of hornets.

## Features

- Object-oriented design emphasizing inheritance and encapsulation.
- Custom linear data structure (`SwarmOfHornets`) for managing hornets.
- Multiple bee types with unique abilities.
- Simple turn-based game logic for defending the hive.
- Easy to extend with new bee types or insect behaviors.

## Getting Started

### Prerequisites

- Java JDK 17 or higher
- A Java IDE or command-line environment for compiling and running Java files

### Compilation

Compile all files in the `assignment1` package:

```bash
javac assignment1/*.java
