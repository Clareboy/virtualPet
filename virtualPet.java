import java.util.Scanner;

/**
 * This virtualPet program implements the knowledge that I have learned so far
 * to create a kind of virtual pet game.
 * 
 * @author kuobear
 * @version 1.0
 * @since May->July of 2019
 */

public class virtualPet extends Dog{

	public virtualPet(String n, String g, int f, int c, int h) {
		super(n, g, f, c, h);
		// TODO Auto-generated constructor stub
	}
//TODO: Comment your code!
//TODO: Actually describe the variables in your java docs (see numValidation function for an example)
//TODO: Make sure your variables are descriptive and not just 'x'
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean on = true;
		String input = null;
		System.out.println("Welcome to Virtual Dog Machine!");
		dogPic();
		System.out.println("What do you want to name your dog?");
		String dogName = validation(in.nextLine().trim());
		dogName = Character.toUpperCase(dogName.charAt(0)) + dogName.substring(1).toLowerCase();
		dogName = dogName.trim();
		dogName = checkDogName(dogName);
		on = true;
		System.out.println("Your dog's name is now " + dogName + ".");
		int randomGender = (int) (Math.random() * 2) + 1;
		String dogGender = null;
		String genderPronoun = null;
		String genderSingularPronoun = null;
		if (randomGender == 1) {
			dogGender = "Male"; 
			genderPronoun = "him";
			genderSingularPronoun = "he";
		} else if (randomGender == 2) {
			dogGender = "Female";
			genderPronoun = "her";
			genderSingularPronoun = "she";
		}
		System.out.println("Let's welcome " + dogName + "!");
		Dog dog1 = new Dog(dogName, dogGender, 5, 5, 5);
		while (on) {
			System.out.println(" ");
			displayStat(dog1.getHappy(), dog1.getFull(), dog1.getClean());
			System.out.println(" ");
			menu(genderPronoun);
//TODO: Check out switch statements instead of these "if/else" statements
			input = numValidation(in.nextLine());
			switch (input) {
			case "1":
				clean(dogName);
				input = numValidation(in.nextLine());
				switch (input) {
					case "1":
						System.out.println(dogName + " wiggles and splashes around as you wash " + genderPronoun + "!");
						dog1.setClean(8);
						dog1.setHappy(-3);
						dog1.setFull(-2);
						break;
					case "2":
						System.out.println("You rinsed " + dogName + " off with some water.");
						dog1.setClean(3);
						dog1.setHappy(-1);
						break;
					case "3":
						System.out.println("You dirted off " + dogName +" as he wiggles his tail.");
						dog1.setClean(1);
						break;
					default:
						System.out.println("Invalid Option. Try again.");
						break;
					}
				break;
			case "2":
				System.out.println(dogName + " is really happy!");
//				System.out.println("");
				dog1.setHappy(1);
				dog1.setFull(-1);
				break;
			case "3":
				feed(dogName);
				input = numValidation(in.nextLine());
				switch (input) {
				case "1":
					System.out.println(dogName + " is eating the dog food.");
					dog1.setFull(3);
					dog1.setHappy(-1);
					break;
				case "2":
					System.out.println(dogName + " is eating the full course meal.");
					dog1.setFull(10);
					dog1.setHappy(3);
					dog1.setClean(-2);
					break;
				case "3":
					System.out.println(dogName + " is chumping down on his own feces.");
					dog1.setClean(-4);
					dog1.setFull(2);
					dog1.setHappy(-1);
					break;
				default:
					System.out.println("Invalid Option. Try again.");
					break;
				}
				break;
			case "4":
//				System.out.println();
				play(dogName);
				input = numValidation(in.nextLine());
				switch(input) {
				case "1":
					System.out.println(dogName + " went and fetched the frisbee to you.");
					dog1.setClean(-1);
					dog1.setFull(-2);
					dog1.setHappy(3);
					break;
				case "2":
					System.out.println("Where did " + dogName + " go...?");
					dog1.setClean(-1);
					dog1.setFull(-2);
					dog1.setHappy(2);
					break;
				case "3":
					System.out.println(dogName + " has passed away...\nSIKE! He is just playing dead.");
					dog1.setFull(-1);
					dog1.setHappy(3);
					break;
				default:
					System.out.println("Invalid Option. Try again.");
					break;
				}
				break;
			case "5":
				deadDog();
				System.out.println("Game has ended...which also means your virtual " + dogName + " has died.");
				on = false;
			}
		if (dog1.getClean() == 10 && dog1.getFull() == 10 && dog1.getHappy() == 10) {
			deadDog();
			System.out.println(dogName + " exploded from being way too happy, full, and clean!\nGame End.");
			on = false;
		} else if (on == dog1.isDead()) { //condition to check if boolean 'on' (true) matches with boolean '.isDead()'
			deadDog();
			System.out.println("Oops! You found that " + dogName + " has died!\nGame End.");
			on = false; //setting to false to stop the run of the program
		}
		}
	}
			
//TODO: Think about how to condense this section
//			on = deadWhy(dogName, dog1.getClean(), on); //making the boolean 'on' set to 'false' by using the deadWhy method 
//			on = deadWhy(dogName, dog1.getFull(), on);
//			on = deadWhy(dogName, dog1.getHappy(), on);
			
//			if (dog1.getFull() == 0) {//If your dog's fullness = 0, it is dead!
//				deadDog();
//				System.out.println("Oops! You found that " + dogName + " has died of hunger!\nGame End.");
//				on = false;
//			}
//			if (dog1.getHappy() == 0) { //If your dog's happiness = 0, it runs away!
//				runawayDog();
//				System.out.println("Oops! " + dogName + " despises you and ran away!\nGame End.");
//				on = false;
//			} 
//			if (dog1.getClean() == 0) { //If your dog's cleanliness = 0, it dies from it's own smell!
//				deadDog();
//				System.out.println("Oops! " + dogName + " is so stinky that " + genderSingularPronoun + " died from the smell!\nGame End.");
//				on = false;
//			} 
//			if (dog1.getClean() == 10 && dog1.getFull() == 10 && dog1.getHappy() == 10) {
//				deadDog();
//				System.out.println(dogName + " exploded from being way too happy, full, and clean!\nGame End.");
//				System.out.println("Game End.");
//				on = false;
	/**
	 * Checks string input to make sure it is only numerical values
	 * @param stringNumber - the string to check 
	 * @return The string once it's a valid input
	 */
	public static String numValidation(String stringNumber) { //checks to see if its a valid num input
		Scanner in = new Scanner(System.in);
		while (stringNumber.isEmpty() || !stringNumber.matches("[0-9]")) {
			System.out.println("Invalid Option.\nEnter a correct number.");
			stringNumber = in.nextLine();
		}
		return stringNumber;
	}
	/**
	 * Checks string input to make sure it contains only alphabets 
	 * @param stringAlphabet - the string to check
	 * @return The string once it's a valid input
	 */
	public static String validation(String stringAlphabet) { //checks to see if its a valid String input
		Scanner in = new Scanner(System.in);
		while (stringAlphabet.isEmpty() || !stringAlphabet.matches("[a-zA-Z]+")) {
			System.out.println("Invalid Input.");
			stringAlphabet = in.nextLine();
		}
		return stringAlphabet;
	}
	/**
	 * Checks to see if the user would like to keep their initial input name or change it
	 * @param name - the string to check
	 * @return The string once it's a valid input
	 */
	public static String checkDogName(String name) { //checks and sees if user wants to keep/replace the dog name
		boolean on = true;
		Scanner in = new Scanner(System.in);
		while (on) {
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase(); //this will allow the correct capitalization of any name
			System.out.println("Would you like your dog's name to be " + name +"? Y or N");
			String answer = validation(in.nextLine());
			if (answer.matches("Y")) {
				on = false;
			} else if (answer.matches("N")) {
				System.out.println("What then would you like to name your dog?");
				name = name.trim();
				name = validation(in.nextLine());
				name = Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
			} else {
				System.out.println("Invalid input.");
			}
		}
		return name;
	}
	/**
	 * Display the menu
	 * @param noun
	 */
	public static void menu(String noun) { 
		System.out.println("Virtual Dog");
		System.out.println("-----------");
		System.out.println("1. Clean " + noun);
		System.out.println("2. Pet " + noun);
		System.out.println("3. Feed " + noun);
		System.out.println("4. Play with " + noun);
		System.out.println("5. Quit");
	}
	/**
	 * Display the different statuses that the dog has with displayBar
	 * @param happy - the numerical amount of happy 
	 * @param hungry - the numerical amount of hunger 
	 * @param clean - the numerical amount of clean
	 */
	public static void displayStat(int happy, int hungry, int clean) { //display the statuses of the dog
		System.out.print("Happy:  ");
		int xHappy = happy;
		displayBar(xHappy);
		int xHungry = hungry;
		System.out.print("Hungry: ");
		displayBar(xHungry);
		int xClean = clean;
		System.out.print("Clean:  ");
		displayBar(xClean);
	}
	/**
	 * Display the dog
	 */
	public static void dogPic() { 
		System.out.println("  /^ ^\\\n" + 
					       " / 0 0 \\\n" + 
					       " V\\ Y /V\n" + 
					       "  / - \\\n" + 
					       " / |_||\n" + 
						   "V__) ||");
	}
	/**
	 * Display the dog but DEAD
	 */
	public static void deadDog() { 
		System.out.println("  /^ ^\\\n" + 
					       " / X X \\\n" + 
					       " V\\ Y /V\n" + 
					       "  / - \\\n" + 
					       " / |_||\n" + 
						   "V__) ||");
	}
	/**
	 * Display the dog running away
	 */
	public static void runawayDog() { 
		System.out.println("~~~      /^ ^\\\n" + 
					       "   ~~~  / 0 0 \\\n" + 
					       "~~~     V\\ Y /V\n" + 
					       "   ~~~   / - \\\n" + 
					       "~~~     / |_||\n" +
						   "   ~~~ V__) |\\");
	}
	/**
	 * display the horizontal bar graph in "-"s
	 * @param displayAmount - the amount to display
	 */
	public static void displayBar(int displayAmount) { 
		System.out.print("+");
		for (int i = 0; i < displayAmount; i++) {
			System.out.print("-");
		}
		for (int i = 0; i < (10 - displayAmount); i++) {
			System.out.print(" ");
		}
		System.out.print("+\n");
	}
	/**
	 * display the options for clean
	 * @param name - the string name to display
	 */
	public static void clean(String name) { 
		System.out.println("Cleaning");
		System.out.println("--------");
		System.out.println("1. Bath time for " + name);
		System.out.println("2. Rinse off " + name);
		System.out.println("3. Brush dirt off " + name);
	}
	/**
	 * Display the options for feed
	 * @param name - the string name to display
	 */
	public static void feed(String name) { 
		System.out.println("Feed");
		System.out.println("----");
		System.out.println("1. Dog food for " + name);
		System.out.println("2. Full course meal for " + name);
		System.out.println("3. Poop");
	}
	/**
	 * Display the options for play
	 * @param name - the string name to display
	 */ 
	public static void play(String name) { 
		System.out.println("Play");
		System.out.println("----");
		System.out.println("1. Play frisbee with " + name);
		System.out.println("2. Play hide and seek with " + name);
		System.out.println("3. Play dead with " + name);
	}
}
//	/** (Made it better by using dog.isDead() from the Dog.java
//	 * Display 
//	 * @param dog - the name of the dog
//	 * @param dogStat - the method/status of which dog in Dog class
//	 * @param turnOff - turning off the boolean so it doesn't continue running
//	 * @return Whether or not the dog is dead.
//	 */
//	public static boolean deadWhy(String dog, int dogStat, boolean turnOff) {
//		if (dogStat == 0) {//If your dog's status = 0, it is dead!
//			deadDog();
//			System.out.println("Oops! You found that " + dog + " has died!\nGame End.");
//			turnOff = false;
//		}
//		System.out.println("Turn off value: " + turnOff);
//		System.out.println("Dog stat " + dogStat);
//		return turnOff; 
//	}

	