using System;
using System.Collections.Generic;
using System.Text;

namespace TennisSimulator.Tennis
{
    class Player
    {
        public int points { get; set; }
        public bool winner { get; set; }
        public string name { get; set; }
        public int random { get; set; }

        public Player(string name)
        {
            this.name = name;
        }
    }
}
