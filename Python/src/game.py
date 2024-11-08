from src.deck import Deck, fetch_random_sentence


class Game:

    def __init__(self, player_name):
        self.__total_score = 0
        self.__color_score = 0
        self.__suit_score = 0
        self.__number_score = 0
        self.player_name = player_name

    # A function that manages the game
    async def start_game(self, deck_size):
        print("Welcome To The Guess Game...")
        print(f"{self.player_name} , Please follow the instructions.");
        deck = Deck(deck_size)
        for i in range(deck_size):
            card = deck.get_card()
            self.turn(card.get_color(), card.get_number(), card.get_suit())
            print("The real card is:")
            card.draw_card()
            if i % 2 == 1:
                await fetch_random_sentence()
        print("Champion!! You finished the game.")
        print("________________________")
        print(f"Color Score: {self.__color_score}/{deck_size}")
        print(f"Suit Score: {self.__suit_score}/{deck_size}")
        print(f"Number Score: {self.__number_score}/{deck_size}")
        print("________________________")
        print(f"Total Score: {self.__total_score}/{deck_size * 3}")
        print("________________________")

    # For each turn, it receives the necessary inputs, compares them to the real card, and responds accordingly.
    def turn(self, Ccolor, Cnumber, Csuit):
        color = input("Guess the color: ").lower()
        suit = input("Guess the suit: ").lower()
        number = int(input("Guess the number: "))
        # Create a results map
        results = {"color": Ccolor.lower() == color, "suit": Csuit.lower() == suit, "number": Cnumber == number}
        # Count the correct answers
        correct_count = sum(1 for value in results.values() if value)
        if correct_count == 3:
            print("You beat it!! All the guesses are correct")
            self.__total_score += 3
            self.__color_score += 1
            print("color++")
            self.__suit_score += 1
            print("suit++")
            self.__number_score += 1
            print("number++")
        elif correct_count == 2:
            correct_items = [key for key, value in results.items() if value]
            print(f"You almost beat it!! {', '.join(correct_items)} are correct")
            self.__total_score += 2
            if results["color"]:
                self.__color_score += 1
            if results["suit"]:
                self.__suit_score += 1
            if results["number"]:
                self.__number_score += 1
        elif correct_count == 1:
            correct_item = next((key for key, value in results.items() if value), "")
            print(f"You almost beat it!! {correct_item} is correct")
            self.__total_score += 1
            if results["color"]:
                self.__color_score += 1
            if results["suit"]:
                self.__suit_score += 1
            if results["number"]:
                self.__number_score += 1
        else:
            print("What a loser, everything was wrong.")
