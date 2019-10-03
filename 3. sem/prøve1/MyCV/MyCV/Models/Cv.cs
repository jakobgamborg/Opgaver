using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyCV.Models
{
    public class Cv
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }
        public string Courses { get; set; }
        public string Description { get; set; }
    }
}
