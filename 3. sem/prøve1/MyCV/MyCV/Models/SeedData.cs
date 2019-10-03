using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using System;
using System.Linq;
using MyCV.Models;

namespace MvcMovie.Models
{
    public static class SeedData
    {
        public static void Initialize(IServiceProvider serviceProvider)
        {
            using (var context = new MyCVContext(
                serviceProvider.GetRequiredService<
                    DbContextOptions<MyCVContext>>()))
            {
                // Look for any movies.
                if (context.Cv.Any())
                {
                    return;   // DB has been seeded
                }

                context.Cv.AddRange(
                    new Cv
                    {
                        Name = "Jakob Gamborg",
                        Age = 25,
                        Courses = "Computersystemer, Objektorienteret Programmering, Introduktion til software Engineering, Videregående Objektorienteret Programmering, Programmering og Database, Organisation og software Engineering, Design af softwaresystemer, Cross Cultural Management, Operativsystemer og netværk",
                        Description = "Before i startet my education in Software engineering, i did not have alot of programming background. As i a teenager i did a little bit of HTML coding, and thats all. Anyway," +
                                      "i have always been interesting in computer, and been using a lot of my time on the computer. My skills is primary in Java, with objective oriented programming, but also i have been working with Spring Boot. " +
                                      "Also i have been touching C#, primary with ASP.net Core Web application. Furthermore i got slightly experience with SQL. I´m beginning to learn using Docker, and there we are using a little bit of python. "
                    }

                  
                );
                context.SaveChanges();
            }
        }
    }
}