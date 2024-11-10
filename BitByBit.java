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
    private String[] usernamePassword;
    private int logInOrCreateAccount = 0;
    Scanner scanner = new Scanner(System.in);
    private int exit = 0;
    private int loginSuccess;
    private int existingOrNew;
    private String websiteName;
    private int signOut = 0;
    private int generateOrEnter;
    private String websitePassword;
    private String userName;

    // username, website, password
    private static Map<String, Map<String, String>> usernameMap = new HashMap<>();


    PasswordSafe() {

        while (exit == 0) {

            try {

                System.out.println("\nWould you like to log in or create an account?\nPress 1 for log in.\nPress 2 for create account.");
                logInOrCreateAccount = scanner.nextInt();

                if (logInOrCreateAccount == 1) {

                    loginSuccess = login(usernamePassword[0], usernamePassword[1]);
                    
                    if (loginSuccess == 0) {

                        System.out.println("Sorry! Try Again.");

                    }
                    else {

                        while (signOut == 0) {
                            
                            System.out.println("\nWould you like to acess an existing password or add a new password?\nPress 1 to access an existing password.\nPress 2 to add a new password.");
                            existingOrNew = scanner.nextInt();

                            if (existingOrNew == 1) {

                                System.out.println("\nEnter the website you'd like to access: ");
                                websiteName = scanner.next();

                                System.out.println("\nEnter the username for the website: ");
                                userName = scanner.next();

                                System.out.println("\nThe password is " + getUsernamePassword(userName, websiteName));

                                System.out.println("\nWould you like to sign out?\nPress 0 for no.\nPress 1 for yes.");
                                signOut = scanner.nextInt();

                            }
                            else if (existingOrNew == 2) {

                                System.out.println("\nEnter the website you'd like to add: ");
                                websiteName = scanner.next();

                                System.out.println("\nEnter the username you'd like to add: ");
                                userName = scanner.next();

                                System.out.println("\nWould you like to generate a password or enter a password yourself?\nEnter 1 for generate a password.\nEnter 2 to enter a password yourself.");
                                generateOrEnter = scanner.nextInt();

                                if (generateOrEnter == 1) {

                                    websitePassword = generateStrongPassword();
                                    System.out.println(websitePassword);

                                }
                                else if (generateOrEnter == 2) { 

                                    System.out.println("Enter a password: ");
                                    websitePassword = scanner.next();

                                }
                                else {

                                    System.out.println("Error.");

                                }

                                setUserToPassword(userName, websiteName, websitePassword);

                                System.out.println("\nWould you like to sign out?\nPress 0 for no.\nPress 1 for yes.");
                                signOut = scanner.nextInt();

                            }
                            else {

                                System.out.println("Error.");

                            } // end of if/else

                        } // end of while loop

                    } // end of if/else statement

                }
                else if (logInOrCreateAccount == 2) {

                    this.usernamePassword = createAccount();
                    System.out.println("Account successsfully created. You may log in now.");

                } // end of if/else statement

            } catch (Exception e) {

                System.out.println(e.getMessage()); 
    
            } // end of try/catch statement

            System.out.println("\nWould you like to exit the app?\nPress 0 for no.\nPress 1 for yes.");
            exit = scanner.nextInt();

        } // end of while loop

    } // end of BitByBit method


    // logs the user in to their account
    private int login(String username, String password){

        boolean loginp = false;
        boolean loginu = false;
        int i = 3;
        
        
        while (!loginu) {

            System.out.println("\nPlease enter your username.");
            String usernameinput = scanner.next();
            
            if (username.compareTo(usernameinput) != 0) {

                System.out.println("Incorrect username entered.");

            }
            else {

                loginu = true;
                System.out.println("Username accepted!");

            }
        }
        
        while (!loginp && i>0) { 

            System.out.println("\nPlease enter password");
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


    // generates a strong password for the user
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

                    // punctuation
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


    // creates a new account for the user
    private String[] createAccount() {

        String username = "";
        String password = "";
        //String[] data;

        // Scanner scanner = new Scanner(System.in);
        
        Pattern specialchar = Pattern.compile("[@!#$%^&*]");
        Pattern numberchar = Pattern.compile("\\d");
        boolean complete = false;    
        
        System.out.println("Please Enter Username: ");
        username = scanner.next(); // include map check for each username

        while (!complete){

            System.out.println("Please enter a password\nMust be at least 15 characters long and must include both a special character and a number.");
            password = scanner.next();
            
            Matcher matcher_s = specialchar.matcher(password);
            Matcher matcher_n = numberchar.matcher(password);
            
            boolean s_check = matcher_s.find();
            boolean n_check = matcher_n.find();
            
            if (s_check){

                if (n_check){

                    if (password.length() >= 15) {

                        System.out.println("Password Accepted");
                        complete = true;
                        //add user and password function

                    }
                    else {

                        System.out.println("Please use at least 15 characters in your password.");

                    }

                }
            
                else{

                    System.out.println("Please use a number in your password.");

                }

            }
            else {

                System.out.println("Please use one of the special characters !@#$%^&* in your password.");

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


    // sets a new website username and password
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