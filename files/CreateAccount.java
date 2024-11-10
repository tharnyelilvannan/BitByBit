import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CreateAccount {
    private static String[] CreateAccount(){
        String sitename = null;
        String username = null;
        String password = null;
        //String[] data;
        
        Pattern specialchar = Pattern.compile("[@!#$%^&*]");
        Pattern numberchar = Pattern.compile("\\d");
        boolean complete = false;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter website name");
        sitename = scanner.nextLine();        
        
        System.out.println("please enter username");
        username = scanner.nextLine(); //include map check for each username
        
        while (!complete){
            System.out.println("please enter a password: must be at least 15 characters long and must include both a special character and a number");
            password = scanner.nextLine();
            
            Matcher matcher_s = specialchar.matcher(password);
            Matcher matcher_n = numberchar.matcher(password);
            
            boolean s_check = matcher_s.find();
            boolean n_check = matcher_n.find();
            
            if (s_check){
                if (n_check){
                    if (password.length() >= 15){
                        System.out.println("password accepted");
                        complete = true;
                        //add user and password function
                    }
                    else{
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
    
    String[] data = {sitename, username, password};
    return data;
    
    }
    public static void main(String[] args) {
        P thing = new P();
        CreateAccount();
    }
}