
[Read this in Hebrew](README_HE.md)
# Multilingual Card Guessing Game 🎮

## Overview

The **Multilingual Cards Guessing Game** is a cross-platform project designed to demonstrate the implementation of a simple card guessing game across multiple programming languages. The project includes implementations in the following languages:

- **Java**
- **C#**
- **C++**
- **Python**
- **Node.js**

This project showcases the differences and similarities between these languages in terms of syntax, structure, and performance. It also integrates an API to handle the game's logic, making it easy to compare how each language handles external service communication.

## Features

- A **card guessing game** where the computer selects a random card and the user must guess it.
- **API integration** for fetching random facts about numbers.
- Game logic implemented in **five different languages**.
- User-friendly prompts and instructions in each language's implementation.

## Project Structure

The project is structured as follows:

```
Multilingual/
├── Java/
│   ├── Program.java
│   ├── Card.java
│   ├── Deck.java
│   └── Game.java
├── C#/
│   ├── Program.cs
│   ├── Card.cs
│   ├── Deck.cs
│   └── Game.cs
├── C++/
│   ├── Program.cpp
│   ├── Card.cpp
│   ├── Deck.cpp
│   └── Game.cpp
├── Python/
│   ├── program.py
│   ├── card.py
│   ├── deck.py
│   └── game.py
└── Node.js/
    ├── program.js
    ├── card.js
    ├── deck.js
    └── game.js
```

## How to Run the Game

### 1. **Java** ☕
To run the Java version of the game:
1. Ensure **Java 8+** is installed.
2. Navigate to the `Java` folder.
3. Compile the code:
   ```bash
   javac Program.java
   ```
4. Run the program:
   ```bash
   java Program
   ```

### 2. **C#** 💻
To run the C# version of the game:
1. Ensure **.NET Core 3.1+** is installed.
2. Navigate to the `C#` folder.
3. Build and run the program:
   ```bash
   dotnet run
   ```

### 3. **C++** 💾
To run the C++ version of the game:
1. Ensure a C++ compiler (e.g., `g++`) is installed.
2. Navigate to the `C++` folder.
3. Compile the code:
   ```bash
   g++ -o Program Program.cpp
   ```
4. Run the program:
   ```bash
   ./Program
   ```

### 4. **Python** 🐍
To run the Python version of the game:
1. Ensure **Python 3.x** is installed.
2. Navigate to the `Python` folder.
3. Run the program:
   ```bash
   python program.py
   ```

### 5. **Node.js** 🌐
To run the Node.js version of the game:
1. Ensure **Node.js** is installed.
2. Navigate to the `Node.js` folder.
3. Install the dependencies:
   ```bash
   npm install
   ```
4. Run the program:
   ```bash
   node program.js
   ```

## API Integration

The game uses the **Numbers API** (`http://numbersapi.com/random/trivia`) for fetching random facts about numbers. This public API provides random trivia about numbers, such as "7 is a lucky number" or "4 is the number of seasons in a year." These facts are displayed during the game to enrich the user experience and provide interesting knowledge about numbers.

### API Endpoint:
- **GET `/random/trivia`** – Returns a random fact about a number.

## **We Highly Encourage Contributions!** 🌍

We **strongly invite** you to **contribute** to this project by implementing the game in **additional programming languages** or improving existing implementations! Your contributions will help make this project accessible to an even larger audience worldwide.

When contributing, please:
- Ensure **consistent naming conventions** for files and variables across different languages (e.g., `cardGuessingGame` in JavaScript should have the same name in Python and C++).
- Follow language-specific **naming standards** (e.g., **camelCase** in JavaScript, **PascalCase** in C#).
- Share your **ideas and suggestions** for improving the user experience and game functionality.
By contributing, you’ll help enrich the project and make it a comprehensive tool for learning and comparing different programming languages🤝.

## Contact

For any questions or additional information, feel free to contact us:

- **Email**: [saracohen.cp@gmail.com](mailto:saracohen.cp@gmail.com)
- **GitHub**: [https://github.com/SariCohen2](https://github.com/SariCohen2)

---

Thank you for checking out the **Multilingual Number Guessing Game**! We hope you enjoy trying out the different versions and contributing your improvements! 🎉

