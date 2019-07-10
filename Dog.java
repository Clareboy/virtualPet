//May 31, 2019 Project 11 - virtual pet
/**
 * This class is a representation of a dog.
 * 
 * @author kuobear
 * @since 2019-07-03
 */
//TODO: Document your code - see example on name and on the getFull function
public class Dog {
	/** The name of the dog **/
	private String name;
	private int age = 0;
	private String gender;
	private int fullness;
	private int cleaniness;
	private int happiness;
	
	public Dog(String n, String sex, int full, int clean, int happy) {
		this.name = n;
		this.gender = sex;
		this.fullness = full;
		this.cleaniness = clean;
		this.happiness = happy;
	}
	/**
	 * Returns how full the dog is.
	 * @return An integer representing how full this dog is.
	 */
	public int getFull() {
		return this.fullness;
	}
	/**
	 * Sets how full the dog is.
	 * @return An integer representing how full this dog is.
	 */
	public int setFull(int full) {
		this.fullness += full;
		if (this.fullness > 10) {
			this.fullness = 10;
		} else if (this.fullness < 0) {
			this.fullness = 0;
		} 
		return this.fullness;
	}
	/**
	 * Returns how clean the dog is.
	 * @return An integer representing how clean this dog is.
	 */
	public int getClean() {
		return this.cleaniness;
	}
	/**
	 * Sets how clean the dog is.
	 * @return An integer representing how clean this dog is.
	 */
	public int setClean(int clean) {
		this.cleaniness += clean;
		if (this.cleaniness > 10) {
			this.cleaniness = 10;
		} else if (this.cleaniness < 0) {
			this.cleaniness = 0;
		}
		return this.cleaniness;
	}
	/**
	 * Returns how happy the dog is.
	 * @return An integer representing how happy this dog is.
	 */
	public int getHappy() {
		return this.happiness;
	}
	/**
	 * Sets how happy the dog is.
	 * @return An integer representing how happy this dog is.
	 */
	public int setHappy(int happy) {
		this.happiness += happy;
		if (this.happiness > 10) {
			this.happiness = 10;
		} else if (this.happiness < 0) {
			this.happiness = 0;
		}
		return this.happiness;
	}
	
	public boolean isDead() {
		boolean happiness = this.happiness == 0;
		boolean cleanliness = this.cleaniness == 0;
		boolean fullness = this.fullness == 0;
		return happiness || cleanliness || fullness;
	}
}
