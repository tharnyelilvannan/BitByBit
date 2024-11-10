import java.util.*;
import java.security.SecureRandom;

/** 
 * Author: Tharny Elilvannan
 * Last Updated: November 10, 2024
 * Purpose: Generate a strong password.
 */

public class generatePassword {

    public static void main(String[] args) {
        
        PasswordGenerator p = new PasswordGenerator();
        System.out.println(p.generateStrongPassword());

    } // end of main method

} // end of Main class

class PasswordGenerator {

    private String password = "";

    public String generateStrongPassword() {

        SecureRandom random = new SecureRandom();
        int nextItem = random.nextInt(3);
        
        int i;

        int nextInt = 0;
        
        char nextChar;
        char[] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
          'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        char[] punctuation = {'.', '/', '!', '-', ';'};
        char nextPunctuation;
        

        for (i = 0; i < 15; i++) {

            if (nextItem == 0) { // number
                nextInt = random.nextInt(10);
                password = password + nextInt;
                nextItem = random.nextInt(3);
                
            }
            else if (nextItem == 1) { // character
              nextInt = random.nextInt(50);
              nextChar = characters[nextInt];
              password = password + nextChar;
              nextItem = random.nextInt(3);
  
            }
            else if (nextItem == 2) {
              nextInt = random.nextInt(5);
              nextPunctuation = punctuation[nextInt];
              password = password + nextPunctuation;
              nextItem = random.nextInt(3);
            }

        } // end of for loop

        return password;
        
    } // end of generateStrongPassword class

 } // end of PasswordGenerator class