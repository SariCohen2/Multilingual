import asyncio
import random
import urllib.request
from card import Card


class Deck:
    def __init__(self, deck_size):
        self.__deck_size = deck_size
        self.__cards = [Card() for _ in range(deck_size)]  # Creating cards in a pack as the number received

    # Returns a string of the object's properties.
    def __str__(self):
        input_str = ""
        for card in self.__cards:
            input_str += str(card) + "\n"
        return input_str

    # Gives a random card and cuts it from the array
    def get_card(self):
        random_index = -1
        while True:
            random_index = random.randint(0, len(self.__cards) - 1)  # Get random index within the range of the list
            if self.__cards[random_index] is not None:
                break  # Exit loop if the card is not None
        temp_card = self.__cards[random_index]
        self.__cards[random_index] = None
        return temp_card

    # A function that returns an interesting fact about numbers


async def fetch_random_sentence():
    url = "http://numbersapi.com/random/trivia"
    sentence = ""
    try:
        loop = asyncio.get_event_loop()
        response = await loop.run_in_executor(None, urllib.request.urlopen, url)
        sentence = response.read().decode('utf-8')
        print(f"💡Fun fact: {sentence}")
    except Exception as e:
        print(f"Error: {e}")
    return sentence
