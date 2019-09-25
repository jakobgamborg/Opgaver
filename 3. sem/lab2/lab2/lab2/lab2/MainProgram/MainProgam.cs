using System;
using System.Text;
using System.Linq;


namespace lab2
{
    class MainProgram
    {
        static void Main(string[] args)
        {
            Palindrome_Checker palindrome = new Palindrome_Checker();
            var input = "";
            while (!input.Contains("exit"))
            {
                input = palindrome.GetUserInput();



                if (!(input.Length > 1))
                {
                    Console.WriteLine(
                        input + " is too short. Enter a word or number that is longer than one character.");
                }
                else
                {
                    if (!input.Contains("exit"))
                    {
                        palindrome.ReverseString(input);

                        palindrome.ShowStrings(input, palindrome.ReverseString(input));

                        palindrome.CheckResult(input);
                    }

                }
            }
        }

    }

}