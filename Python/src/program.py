import asyncio

from src.game import Game


async def main():
    name = input("Enter your name please: ") or ""
    game = Game(name) # Create a Game instance
    deck_size = int(input("Enter the number of cards you want to play: "))
    await game.start_game(deck_size)


# Run the main method asynchronously
if __name__ == "__main__":
    asyncio.run(main())
