import java.util.Random;
import java.util.ArrayList;

public class Wordle {
    
    private String[] words;
    private String[][] guesses;
    private String[][] keyboard;
    
    private String str;
    private int guess;
    private Random rand;
    
    public Wordle()
    {
        rand = new Random();
        words = new String[]{"elude", "flirt", "crave", "count", "maize", "beefy", "worry", "adopt", "mucky", "alter", "human", "pixie", "koala", "leapt", "sedan", "spire", "skirt", "antic", "layer", "sleek", "lemon", "opera", "judge", "havoc", "molar", "manly", "whine", "zebra", "cross"};
        guesses = new String[6][5];
        keyboard = new String[][]{{"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"}, {"", "a", "s", "d", "f", "g", "h", "j", "k", "l", ""}, {"", "", "z", "x", "c", "v", "b", "n", "m", "", ""}};
        
        str = words[rand.nextInt(words.length)];
        guess = 0;
    }
    
    public String[][] showGuess(String g)
    {
        
        for (int i = 0; i < guesses[0].length; i++)
        {
            if (guess > 0 && g.substring(i, i + 1).toUpperCase().equals(str.substring(i, i + 1)))
            {
                guesses[guess][i] = g.substring(i, i + 1).toUpperCase();
                continue;
            }
            if (str.indexOf(g.substring(i, i + 1)) != -1)
            {
                if (str.indexOf(g.substring(i, i + 1)) == i)
                {
                    guesses[guess][i] = str.substring(i, i + 1).toUpperCase();
                    
                    for (int j = 0; j < keyboard.length; j++)
                    {
                        for (int k = 0; k < keyboard[0].length; k++)
                        {
                            if (keyboard[j][k].equals(str.substring(i, i + 1)))
                            {
                                keyboard[j][k] = str.substring(i, i + 1).toUpperCase();
                                String temp = "";
                                
                                for (int n = 0; n < str.length(); n++)
                                {
                                    if (n == i)
                                    {
                                        temp += str.substring(n, n + 1).toUpperCase();
                                    }
                                    else
                                    {
                                        temp += str.substring(n, n + 1);
                                    }
                                }
                                str = temp;
                                break;
                            }
                        }
                    }
                }
                else
                {
                    guesses[guess][i] = g.substring(i, i + 1);
                    
                    for (int j = 0; j < keyboard.length; j++)
                    {
                        for (int k = 0; k < keyboard[0].length; k++)
                        {
                            if (keyboard[j][k].equals(g.substring(i, i + 1)))
                            {
                                keyboard[j][k] = g.substring(i, i + 1).toUpperCase();
                            }
                        }
                    }
                }
            }
            else
            {
                guesses[guess][i] = "\u0336" + g.substring(i, i + 1);
                
                for (int j = 0; j < keyboard.length; j++)
                {
                    for (int k = 0; k < keyboard[0].length; k++)
                    {
                        if (keyboard[j][k].equals(g.substring(i, i + 1)))
                        {
                            keyboard[j][k] = " ";
                            break;
                        }
                    }
                }
            }
            
        }
        
        guess++;
        return guesses;
    }
    
    public void printKeyboard()
    {
        for (String[] arr : keyboard)
        {
            for (String s : arr)
            {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    
    public void randomize()
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int count = 0;
        
        for (String s : words)
        {
            nums.add(count);
            count++;
        }
        
        while (nums.size() > 1)
        {
            int first = nums.remove(rand.nextInt(nums.size()));
            int second = nums.remove(rand.nextInt(nums.size()));
            
            String temp = words[first];
            words[first] = words[second];
            words[second] = temp;
        }
    }
    
    public void sort()
    {
        for (int i = 1; i < words.length; i++)
        {
            String temp = words[i];
            
            for (int j = i - 1; j >= 0; j--)
            {
                if (words[j].compareTo(temp) > 0)
                {
                    words[j + 1] = words[j];
                    words[j] = temp;
                }
                else
                {
                    break;
                }
            }
        }
    }
    
    public void revealAnswer()
    {
        System.out.print("The answer was " + str.toUpperCase() + ". Better luck next time!\n");
        System.out.println();
    }
    
    public String toString()
    {
        String res = "";
        
        for (String s : words)
        {
            res += s + "\n";    
        }
        
        return res;
    }
}
