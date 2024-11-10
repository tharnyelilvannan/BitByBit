# BitByBit
MEC - Programming - Team Bit-By-Bit - Project Report 

Cybersecurity has become more important than ever in our modern era. As technology becomes increasingly important across different aspects of our lives, its potential security risks only rise. Thus, when storing our personal information, it is incredibly important to have secure passwords to reduce the risks of data breaches compromising our accounts. However, this is often a struggle for the common user, as secure passwords are difficult to come up with and even harder to remember.  

Our team intends to tackle this issue with our program, which is a text-based password management system intended to store and create strong new passwords for its users. The program has no GUI and must be run from the command line. From there, the user can respond to the prompts given to the program and give their responses as indicated in its instructions. 

To start, the user will create an account on our app to access its various features. The user will be prompted to create a unique username, and a password fulfilling our requirements that greatly enhance password security (must be at least 15 characters long and must include a number and a special character). The user can then login to their account and use the app to save passwords and their corresponding usernames and websites. The app also has a “safe” password generator feature that automatically generates safe passwords that the user can use to sign up to any service of their choice. From this point onwards the user can return to the program at any time to recover their passwords, as long as they have the corresponding website and username to match. 

The program is quite secure, as all of the variables and methods used in it are private, and “getter” methods are used to return variables when required. Since no code outside of the class can access the program’s content under these conditions, these design choices greatly increase the security of the program. 

Our program addresses the issue of cybersecurity by providing its users with a simple and secure way to store and create safe passwords. It keeps the user’s data safe, as the program’s contents are only accessible when the correct username and password are entered in. On top of that, the user’s password must abide by our guidelines for safety, making the system even more secure. The program is also completely composed of private variables and methods, which protects it from potential malware and data breaches. The program can also be used to increase the user’s cybersecurity across the internet as a whole, as they can use its password generator and storage system to create and save strong passwords to use on any website they want.  

One notable limitation of our program is that it can only store info within one session of being run, as there is no central database for it. It also assumes its users are familiar with running a text-based program from the command line, as the program has no GUI. Also, at the very beginning, if an account hasn’t been made first, then the login won’t be successful. The program also does not allow users to change their passwords after storing them, and assumes each website and username are permanently linked to the first password they are entered with. 
