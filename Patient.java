/*
 * Stores the data for each Patient.
 */
public class Patient {
	private int priority;
	private String name;
	/*
	 * Constructs a new Patient object and initialises the global variables.
	 */
	Patient(int priority, String name){
		this.priority = priority;
		this.name = name;
	}
	/*
	 * Returns the priority of the patient as an int.
	 */
	int getPriority () {
		return priority;
	}
	/*
	 * Sets the value of priority to a value that is passed in.
	 */
	void setPriority (int priority) {
		this.priority = priority;
	}
	/*
	 * Returns the name of the patient as a string.
	 */
	String getName () {
			return name;
	}
	/*
	 * Sets the value of name to a value that is passed in.
	 */
	void setName (String name) {
			this.name = name;
	}
	/*
	 * Returns a string representation of the data in this class.
	 */
	public String toString() {
		return name + " " + priority;
	}
}
