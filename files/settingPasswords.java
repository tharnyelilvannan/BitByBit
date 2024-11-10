import java.util.*;
public class Password {

    private static Map<String, Map<String, String>> usernameMap = new HashMap<>();

    // method that returns the map for the corresponding user
    private static Map getUsernameMap(String username) {
        Map userMap = usernameMap.get(username);
        return userMap;
    }

    public static boolean setUserToPassword(String username, String website, String password){

        // if the username already exits, get the map
        if (usernameMap.containsKey(username)){
            Map userPassword = getUsernameMap(username); // get map

            // check if website already has a password
            if (userPassword.containsKey(website)){
                System.out.println("password for this website already exists!");
                return false;
            }
            else{ // generate new key value pair
                userPassword.put(website, password);
            }
        }
        else{ // if the username does not exist, create a new map
            Map<String, String> userPassword = new HashMap<>(); // make new map
            userPassword.put(website, password); // store website password pair in new map
            usernameMap.put(username, userPassword); // set the userPassword to the corresponding username
        }
        return true;
    }

    // fetch the website's corresponding password
    private static String getWebsitePassword(String website, Map map){
        String password = (String) map.get(website);
        return password;
    }

    // fetch the username's password
    public static String getUsernamePassword(String username, String website){

        if (usernameMap.containsKey(username) == false){
            return null;
        }
        Map userMap = getUsernameMap(username); // get the map for the usernames
        String password = getWebsitePassword(website, userMap); // get the
        return password;
    }

    public static void main(String[] args){
        setUserToPassword("numberOne", "websiteOne", "abc");
        setUserToPassword("numberOne", "websiteTwo", "def");
        setUserToPassword("numberTwo", "websiteThree", "ghi");

        String password = getUsernamePassword("numberOne", "websiteTwo");
        System.out.println(password);

        String password2 = getUsernamePassword("numberTwo", "websiteThree");
        System.out.println(password2);

        String password3 = getUsernamePassword("numberTwo", "websiteFour"); // if website doesn't exist, return null
        System.out.println(password3);

        // if username doesn't exist return null
        String password4 = getUsernamePassword("numberThree", "websiteOne");
        System.out.println(password4);
    }
}