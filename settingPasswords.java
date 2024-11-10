import java.util.*;
public class Password {

    // username, website, password
    private static Map<String, Map<String, String>> usernameMap = new HashMap<>();

    // method that returns the map for the coressponding user
    private static Map getUsernameMap(String username) {
        Map userMap = usernameMap.get(username);
        return userMap;
    }

    public static void setUserToPassword(String username, String website, String password){
        // if the username already exits, get the map
        if (usernameMap.containsKey(username)){
            Map userPassword = getUsernameMap(username); // get map
            userPassword.put(website, password); // generate new key value pair
        }
        else{ // if the username does not exist, create a new map
            Map<String, String> userPassword = new HashMap<>(); // make new map
            userPassword.put(website, password); // store website password pair in new map
            usernameMap.put(username, userPassword); // set the userPassword to the corresponding username
        }
    }

    // fetch the website's corresponding password
    private static String getWebsitePassword(String website, Map map){
        String password = (String) map.get(website);
        return password;
    }

    // fetch the username's password
    public static String getUsernamePassword(String username, String website){
        Map userMap = getUsernameMap(username);
        String password = getWebsitePassword(website, userMap);
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
    }
}