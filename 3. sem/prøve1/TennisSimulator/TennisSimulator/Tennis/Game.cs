using System;
using System.Threading;

namespace TennisSimulator.Tennis
{
    internal class Game
    {
        private readonly Random rnd = new Random();

        public Player player1 { get; set; }
        public Player player2 { get; set; }

        public Game(string p1Name, string p2Name)
        {
            player1 = new Player(p1Name);
            player2 = new Player(p2Name);
            player2.random = -1;
        }


        public void PointGiver()
        {
            player1.random = rnd.Next(100);
            player2.random = rnd.Next(100);

            if (player1.random > player2.random)
            {
                player1.points += 1;
                Console.WriteLine("Congratulations " + player1.name + " you wun the round and now have " +
                                  player1.points + " Points!");
                player1.random = 0;
                player2.random = -1;
                return;
            }

            if (player1.random < player2.random)
            {
                player2.points += 1;
                Console.WriteLine("Congratulations " + player2.name + " you wun the round and now have " +
                                  player2.points + " Points!");
                player1.random = 0;
                player2.random = -1;
            }

            Thread.Sleep(3000);
            Console.Clear();
        }


        public void Conditions()
        {
            if ((player1.points == 4) & (player2.points < 3))
            {
                player1.winner = true;
                return;
            }

            if ((player2.points == 4) & (player1.points < 3))
            {
                player2.winner = true;
                return;
            }

            if ((player1.points >= 3) & (player2.points >= 3))
            {
                if (player1.points > player2.points + 1)
                {
                    player1.winner = true;
                    return;
                }

                if (player2.points > player1.points + 1)
                {
                    player2.winner = true;
                }
            }
        }
    }
}