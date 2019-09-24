using System;
using System.Linq;
using System.Text;
using Stack_Implementation;

class Palindrome_Checker
{
    public string GetUserInput()
    {
        Console.Write("Enter a string (or exit to quit): ");
        string userInput = Console.ReadLine();
        return userInput;
    }

    public void ShowStrings(string input, string reverse)
    {
        Console.WriteLine("Your input string is: " + input);
        Console.WriteLine("The reverse is: " + reverse);
    }

    public string ReverseString(string userInput)
    {

        var newstr = new StringBuilder();
        Stack s = new Stack();


        foreach (var c in userInput.ToArray())
        {
            s.Push(c);

        }



        while (s.Size() > 0)
        {
            newstr.Append(s.Pop());

        }

        return newstr.ToString();

    }


    public void CheckResult(string input)
    {
        if (isPalindrome(input))
            Console.WriteLine(input + " is a Palindrome");
        else
            Console.WriteLine(input + " is not a palindrome");
    }

    public bool isPalindrome(string str)
    {
        return str.Equals(ReverseString(str));
    }
}