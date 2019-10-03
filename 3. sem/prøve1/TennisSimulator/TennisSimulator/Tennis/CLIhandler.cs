using System;
using System.Threading;

namespace TennisSimulator.Tennis
{
    internal class CLIhandler
    {
        public CLIhandler()
        {
            userInput = " ";
            Console.WriteLine("Hello and welcome to Tennis simulator!");
            Console.WriteLine("Play against your friend too see who wins the game!");
            Console.WriteLine("Write The name of the first player:");

            userInput = Console.ReadLine();
            p1Name = userInput;
            Console.WriteLine("Write the name of the second player:");
            userInput = Console.ReadLine();
            p2Name = userInput;
            var game = new Game(p1Name, p2Name);
            Console.Clear();
            Console.WriteLine("Okay " + p1Name + " and " + p2Name + "! Let the game begin!");
            Thread.Sleep(3000);
            
            while ((game.player1.winner == false) & (game.player2.winner == false))
            {
                Console.Clear();
                roundCounter++;
                Console.WriteLine("Round " + roundCounter + " !");
                Thread.Sleep(2000);
                game.PointGiver();
                game.Conditions();
                Thread.Sleep(5000);
            }

            if (game.player1.winner)
                Console.WriteLine("YOU ARE THE WINNER " + game.player1.name);
            else
                Console.WriteLine("YOU ARE THE WINNER " + game.player2.name);
        }

        public string userInput { get; set; }
        public string p1Name { get; set; }
        public string p2Name { get; set; }
        public int roundCounter { get; set; }
    }
}