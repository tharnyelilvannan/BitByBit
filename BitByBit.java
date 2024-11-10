import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitByBit {

    public static void main(String[] args) {

        PasswordSafe p = new PasswordSafe();

    } // end of main method

} // end of BitByBit class

class PasswordSafe {

    private String generatedPassword = "";
    String[] usernamePassword;
    int logInOrCreateAccount = 0;
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    // username, website, password
    private static Map<String, Map<String, String>> usernameMap = new HashMap<>();


    PasswordSafe() {

        while (!exit) {
            System.out.println("Would you like to log in or create an account?\nPress 1 for log in.\nPress 2 for create account.");
            logInOrCreateAccount = scanner.nextInt();

            if (logInOrCreateAccount == 1) {

                login(usernamePassword[0], usernamePassword[1]);
                
            }
            else if (logInOrCreateAccount == 2) {

                this.usernamePassword = createAccount();
                System.out.println("Account successsfully created. You may log in now.");

            } // end of if/else statement

        } // end of while loop

    } // end of BitByBit method

    private int login(String username, String password){

        boolean loginp = false;
        boolean loginu = false;
        int i = 3;
        
        
        while (!loginu) {

            System.out.println("Please enter your username");
            String usernameinput = scanner.next();
            
            if (username.compareTo(usernameinput) != 0) {

                System.out.println("Incorrect username entered");

            }
            else {

                loginu = true;
                System.out.println("Username accepted!");

            }
        }
        
        while (!loginp && i>0) { 

            System.out.println("Please enter password");
            String passwordinput = scanner.next();
            
            if (password.compareTo(passwordinput) == 0) {
                loginp = true;
            }
            else {
                i=i-1;
                System.out.printf("Incorrect password entered, %d attempts remaining\n", i);

            }
        }
            
        if (i==0) {

            System.out.println("Ran out of attempts.");
            return 0; 

        } 
        else {

            System.out.println("Login Success!");
            return 1;

        }

    } // end of login method

    private String generateStrongPassword() {

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

            switch (nextItem) {
                case 0:
                    // number
                    nextInt = random.nextInt(10);
                    generatedPassword = generatedPassword + nextInt;
                    nextItem = random.nextInt(3);
                    break;
                case 1:
                    // character
                    nextInt = random.nextInt(50);
                    nextChar = characters[nextInt];
                    generatedPassword = generatedPassword + nextChar;
                    nextItem = random.nextInt(3);
                    break;
                case 2:
                    nextInt = random.nextInt(5);
                    nextPunctuation = punctuation[nextInt];
                    generatedPassword = generatedPassword + nextPunctuation;
                    nextItem = random.nextInt(3);
                    break;
                default:
                    break;
            } // end of switch statement

        } // end of for loop

        return generatedPassword;

    } // end of generateStrongPassword method


    private String[] createAccount() {

        String username = "";
        String password = "";
        //String[] data;

        // Scanner scanner = new Scanner(System.in);
        
        Pattern specialchar = Pattern.compile("[@!#$%^&*]");
        Pattern numberchar = Pattern.compile("\\d");
        boolean complete = false;    
        
        System.out.println("please enter username");
        username = scanner.next(); // include map check for each username

        while (!complete){

            System.out.println("please enter a password: must be at least 15 characters long and must include both a special character and a number");
            password = scanner.next();
            
            Matcher matcher_s = specialchar.matcher(password);
            Matcher matcher_n = numberchar.matcher(password);
            
            boolean s_check = matcher_s.find();
            boolean n_check = matcher_n.find();
            
            if (s_check){

                if (n_check){

                    if (password.length() >= 15) {

                        System.out.println("password accepted");
                        complete = true;
                        //add user and password function

                    }
                    else {

                        System.out.println("please use at least 15 characters in your password");

                    }

                }
            
                else{

                    System.out.println("please use a number in your password");

                }

            }
            else {

                System.out.println("please use one of the special characters: !@#$%^&* in your password");

            }
        }
    
        String[] data = {username, password};
        return data;
    
    } // end of createAccount method

    // method that returns the map for the coressponding user
    private static Map getUsernameMap(String username) { 

        Map userMap = usernameMap.get(username);
        return userMap;

    } // end of getUsernameMap

    public static void setUserToPassword(String username, String website, String password) {

        // if the username already exists, get the map
        if (usernameMap.containsKey(username)) {

            Map userPassword = getUsernameMap(username); // get map
            userPassword.put(website, password); // generate new key value pair

        }
        else { // if the username does not exist, create a new map

            Map<String, String> userPassword = new HashMap<>(); // make new map
            userPassword.put(website, password); // store website password pair in new map
            usernameMap.put(username, userPassword); // set the userPassword to the corresponding username

        }

    } // end of setUserToPassword method

    // fetch the website's corresponding password
    private static String getWebsitePassword(String website, Map map) {

        String password = (String) map.get(website);
        return password;

    } // end of getWebsitePassword

    // fetch the username's password
    public static String getUsernamePassword(String username, String website) {

        Map userMap = getUsernameMap(username);
        String password = getWebsitePassword(website, userMap);
        return password;

    } // end of getUsernamePassword method

} // end of PasswordSafe class