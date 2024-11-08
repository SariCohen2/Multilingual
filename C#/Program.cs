namespace C_
{
    internal class Program
    {
        static async Task Main(string[] args)
        {
            Console.WriteLine("Enter your name please:");
            String name = Console.ReadLine()??"";
            Game game = new Game(name);//Create a Game instance
            Console.WriteLine("Enter the number of cards you want to play.:");
            int deckSize =int.Parse(Console.ReadLine());
            await game.StartGame(deckSize);
        }
    }
}
