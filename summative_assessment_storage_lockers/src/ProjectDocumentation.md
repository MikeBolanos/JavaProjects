Project Journal

I started the project by reading through the initial problem being presented and making note of 
all the nouns and verbs. I marked nouns (locker, menu, etc.) as potential classes and verbs
(Rent, Access, Release, Quit) as potential methods. 

From there, for each potential class, I listed attributes and methods relative to that object. For the Locker clss,
I listed attributes such as: a boolean to check if it was available, a string variable to store a PIN
code, and possibly a locker number. Methods for Locker included a way to store the locker's
PIN and availability. For Locker Service, I listed attributes like an array of 
lockers and methods to manipulate what to do with the lockers, such as: the renting process, the access process,
generating a PIN, and releasing process. The Main class would hold the menu and run the app with a loop. I was attempting
to implement the DRY method by ensuring each class had only one responsibility. 

I started with a plan for only four classes: Main, Locker, LockerService, and Utils (this class
stores the Scanner and methods to prompt and print messages.) On the JRE I used pseudocode to
make a basic skeleton of each class. I attempted to make the menu first, but then I realized I could only make the quit option,
I wouldn't have enough data to test much, so I started filling out the Locker Class. Then I filled out the LockerService class 
and Utils. I learned would be having to refactor code as I brought up new problems I wasn't thinking about while initializing. 

Problems such as having to match the PIN to the individual lockers, not just generating a PIN and validating the input. 
I had to add this method to Lockers, so I could call it in another method in LockerService. And because I 
built the Utils class last, I had to refactor code to call those methods. 

As I built the LockerService class, I would stop and update the main menu to include the options
(Rent, Access, Release) as I finished them, and then try testing the processes. If it wasn't doing its job, I would refactor
until it did. When I was done with all processes, I began looking to clean up my code. 

I realized I could use an enum for my menu options, so I created that and set it as another object outside of Main.
I also had made a Result class to call a tuple result for booleans and strings. I then refactored my menu switch cases again. 
I eventually made another class, MenuService, to manage the menu. This left me with only the calling of the method for looping 
the menu and running the app for the Main class. 
