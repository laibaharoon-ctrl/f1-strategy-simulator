# 🏎️ F1 Race Strategy Simulator

A Java-based Formula 1 race strategy simulator where you make real-time pit stop and tire decisions to try to win the Grand Prix.

![Java](https://img.shields.io/badge/Java-17+-orange)
![BlueJ](https://img.shields.io/badge/IDE-BlueJ-blue)

## 🎮 What It Does

Simulates a full F1 race lap-by-lap. You play as a driver and make strategic decisions about when to pit and which tire compound to use. AI opponents run their own strategies — aggressive, balanced, or conservative — and you have to beat them to the checkered flag.

## ✨ Features

- 🏁 **Lap-by-lap race simulation** with realistic tire degradation
- 🛞 **5 tire compounds** (Soft, Medium, Hard, Intermediate, Wet) — each with unique pace, wear rate, and lifespan
- 🌧️ **Dynamic weather system** affecting tire performance
- ⛽ **Fuel load simulation** — heavier car = slower laps
- 🤖 **AI opponents** using different strategies (Aggressive, Balanced, Conservative)
- 📊 **Live position tracking** and final classification
- ⌨️ **Interactive pit decisions** — you choose when to pit and which tire to take

## 🧠 Concepts Demonstrated

- **Object-Oriented Programming** — inheritance, polymorphism, encapsulation
- **Strategy Pattern** — swappable AI behaviors via the `Strategy` interface
- **Enums** — `TireCompound`, `Weather`
- **Collections Framework** — `List`, `Comparator`, `Stream` API
- **File I/O** — loading track and driver data
- **Clean code organization** — model / strategy / sim / util separation

## 📁 Project Structure

- `Main.java` — Entry point
- `Race.java` — Core race loop
- `ConsoleUI.java` — Terminal I/O
- `DataLoader.java` — File loading utilities
- `Driver.java` — A driver + their car + strategy
- `Team.java` — Constructor team
- `Car.java` — Car state (fuel, tires, wear)
- `Track.java` — Track config (laps, base time)
- `TireCompound.java` — Enum: tire types
- `Weather.java` — Enum: weather conditions
- `Strategy.java` — Strategy interface
- `AggressiveStrategy.java` — Pits early, pushes hard
- `BalancedStrategy.java` — Standard pit windows
- `ConservativeStrategy.java` — Pits late, protects tires

## ▶️ How to Run

**Using BlueJ (easiest):**
1. Download [BlueJ](https://www.bluej.org/)
2. Open BlueJ → Project → Open Project → select this folder
3. Right-click the `Main` class → `void main(String[] args)`
4. Interact with the race in the terminal at the bottom

**Using the command line:**
```bash
javac *.java
java Main

🏁 ================================
   MONZA GRAND PRIX
   Laps: 53 | Weather: DRY
🏁 ================================

Lap 1/53 | Tire: MEDIUM (age 0, wear 0%) | Fuel: 100.0kg
Pit this lap? (y/n): n

--- Lap 1 ---
P1 Verstappen  84.196s (tire: MEDIUM)
P2 Norris      84.337s (tire: SOFT)
P3 Hamilton    85.456s (tire: HARD)
P4 YOU         86.800s (tire: MEDIUM)


🚀 Future Improvements
□ Safety car periods
□ DRS zones and overtaking mechanics
□ Multiple tracks (Monaco, Spa, Silverstone)
□ JavaFX GUI version
□ JUnit test suite
📜 License
MIT — free to use, modify, and learn from.