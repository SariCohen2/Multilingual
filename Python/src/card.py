import math
from random import randint


class Card:
    suits = ["heart", "diamond", "club", "spade"]
    colors = ["red", "black"]

    def __init__(self):
        self.__number = randint(1, 10)
        self.__color = self.colors[randint(0, len(self.colors)-1)]
        self.__suit = self.suits[randint(0, len(self.suits)-1)]

    # Number lottery function
    def generate_random_number(self, min, max):
        return randint(min, max)

    def __str__(self):
        return "Card {"+self.__color+", "+self.__suit+", "+str(self.__number)+"}\n"

    def draw_card(self):
        print("__________\n  " + self.__suit + "\n  " + str(self.__number) + "\n  " + self.__color + "\n__________");


    def get_number(self):
        return self.__number

    def get_color(self):
        return self.__color

    def get_suit(self):
        return self.__suit
