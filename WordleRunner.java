import java.util.*;

public class WordleRunner
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        Wordle w = new Wordle();
        
        while (true)
        {
            System.out.print("Would you like to play (p), test (t), or quit (q)? >>> ");
            String res = console.nextLine();
            
            if (res.equalsIgnoreCase("t"))
            {
                System.out.print("\nWhat method would you like to test: randomize (r), sort (s), or print (p)? >>> ");
                String ans = console.nextLine();
                System.out.println();
                
                if (ans.equalsIgnoreCase("r"))
                {
                    w.randomize();
                }
                else if (ans.equalsIgnoreCase("s"))
                {
                    w.sort();
                }
                else
                {
                    System.out.println(w);
                }
            }
            else if (res.equalsIgnoreCase("p"))
            {
                System.out.println();
                int i;
                for (i = 0; i < 6; i++)
                {
                    System.out.print("Please enter your guess (5 letter word) >>> ");
                    String s = console.nextLine();
                    System.out.println();
                    
                    if (s.length() > 5 || s.length() < 5)
                    {
                        System.out.println("That word is not 5 letters. Try again!\n");
                        i--;
                        continue;
                    }
                    
                    String[][] words = w.showGuess(s);
                    int cnt = 0;
                    
                    for (String[] str : words)
                    {
                        cnt = 0;
                        for (String g : str)
                        {
                            if (g != null)
                            {
                                System.out.print(g + "  ");
                                
                                if (g.toUpperCase().equals(g))
                                    cnt++;
                            }
                            else
                            {
                                break;
                            }
                        }
                        
                        System.out.println();
                        
                        if (cnt == 5)
                        {
                            break;
                        }
                        if (str[0] == null)
                        {
                            break;
                        }
                    }
                    if (cnt == 5)
                    {
                        System.out.print("\nGreat Job! You guessed it!\n\n");
                        break;
                    }
                    else
                    {
                        System.out.println();
                        w.printKeyboard();
                        System.out.println();
                    }
                }
                if (i == 6)
                {
                    w.revealAnswer();
                }
            }
            else
            {
                System.out.println("\nCome again!");
                break;
            }
        }
    }
}
