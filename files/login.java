import java.util.Scanner;

class login {
    private static int login(String username, String password){
        boolean loginp = false;
        boolean loginu = false;
        int i = 3;
        
        Scanner scanner = new Scanner(System.in);
        
        while (!loginu){
            System.out.println("Please enter your username");
            String usernameinput = scanner.nextLine();
            
            if (username.compareTo(usernameinput) != 0){
                System.out.println("Incorrect username entered");
            }
            
            else{
                loginu = true;
                System.out.println("Username accepted!");
            }
        }
        
            while (!loginp && i>0){
                System.out.println("Please enter password");
                String passwordinput = scanner.nextLine();
            
                if (password.compareTo(passwordinput) == 0){
                    loginp = true;
                }
            
                else {
                    i=i-1;
                    System.out.printf("Incorrect password entered, %d attempts remaining\n", i);
                }
            }
            
            if (i==0){
                System.out.println("Ran out of attempts");
                return 0;
            }
            
            else {
                System.out.println("Login success!");
                return 1;
            }
    }
    
    public static void main(String[] args) {
        login thing = new login();
        login("skibidirizzler", "secret90");
    }
}