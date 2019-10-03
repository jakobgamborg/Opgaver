using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace MyCV.Models
{
    public class MyCVContext : DbContext
    {
        public MyCVContext (DbContextOptions<MyCVContext> options)
            : base(options)
        {
        }

        public DbSet<MyCV.Models.Cv> Cv { get; set; }
    }
}
