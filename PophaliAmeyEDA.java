import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EDA {

	private static int EmpCount = 0;
	private static Scanner scanner = new Scanner(System.in);

	private static Employee[] employee = new Employee[100];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while(true) {

			// Function call to print the menu for user
			printMainMenu();

			int userInput= scanner.nextInt();

			// Check for invalid inputs
			if (userInput!= 1 && userInput!= 2 && userInput!= 3 && userInput!= 4 && userInput!= 5) {
				System.out
						.println("Invalid input provided. Please press one of the following -");
				printMainMenu();
				userInput= scanner.nextInt();
			}

			// Terminate if still invalid
			if (userInput!= 1 && userInput!= 2 && userInput!= 3 && userInput!= 4 && userInput!= 5) {
				System.out
						.println("Wrong input attempts limit reached. Program terminating!!");
			}

			// Enter this only if user wants to ADD an employee
			if (userInput== 1) {

				System.out
						.println("Please select of the following options"
								+ "\n"
								+ "- PRESS 1 to ADD only First Name and Last Name"
								+ "\n"
								+ "- PRESS 2 to ADD only First Name, Last Name and Department"
								+ "\n" + "- PRESS 3 to ADD all the parameters"
								+ "\n"
								+ "- PRESS 4 to go BACK to the previous menu");

				int userInputAdd = scanner.nextInt();

				if (userInputAdd != 1 && userInputAdd != 2 && userInputAdd != 3 && userInputAdd != 4) {
					System.out
							.println("Wrong input. Please provide a valid input");

					System.out
							.println("Please select of the following options"
									+ "\n"
									+ "- PRESS 1 to ADD only First Name and Last Name"
									+ "\n"
									+ "- PRESS 2 to ADD only First Name, Last Name and Department"
									+ "\n"
									+ "- PRESS 3 to ADD all the parameters");

					userInputAdd = scanner.nextInt();
				}

				// Check for invalid inputs and terminate
				if (userInputAdd != 1 && userInputAdd != 2 && userInputAdd != 3 && userInputAdd != 4) {
					System.out
							.println("Wrong input attempts limit reached. Program terminating!!");
				}

				String Values1[] = new String[4];
				scanner.nextLine();

				for (int i = 0; i < 100; i++) {

					if (userInputAdd == 1) {

						// If user wants to add two parameters
						if (checkEmployeeEmpty(employee[i])) // Check if the
																// employee
																// object is
																// empty.
																// Skip if not
																// null
						{

							System.out
									.println("Enter employee's Last Name and First Name seperated by space - ");
							String dataInput1 = scanner.nextLine();

							Values1 = dataInput1.split("\\s");

							String lname = Values1[0];
							String fname = Values1[1];

							addEmployee(lname, fname, i);
							EmpCount++;
							System.out.println("Total employees in database = "
									+ EmpCount + "\n");
							break;
						}

					}

					// If user wants to add three parameters
					else if (userInputAdd == 2) {

						if (checkEmployeeEmpty(employee[i])) {

							System.out
									.println("Enter Last Name, Fisrt Name and Department seperated by space - ");
							String dataInput1 = scanner.nextLine();

							Values1 = dataInput1.split("\\s");

							String lname = Values1[0];
							String fname = Values1[1];
							String dept = Values1[2];

							addEmployee(lname, fname, dept, i);
							EmpCount++;
							System.out.println("Total employees in database = "
									+ EmpCount + "\n");
							break;
						}
					}

					// If user wants to add all parameters
					else if (userInputAdd == 3) {
						if (checkEmployeeEmpty(employee[i])) {

							System.out
									.println("Enter employee's Last Name, First Name, Department and Job seperated by space - ");
							String dataInput1 = scanner.nextLine();

							Values1 = dataInput1.split("\\s");

							String lname = Values1[0];
							String fname = Values1[1];
							String dept = Values1[2];
							String job = Values1[3];

							addEmployee(lname, fname, dept, job, i);
							EmpCount++;
							System.out.println("Total employees in database = "
									+ EmpCount + "\n");
							break;
						}

						// If user wants to go out to the main menu
						else if (userInputAdd == 4)
							break;
					}
				}
			}

			// Call ModifyEmployee if the user inputs '2' i.e. a modification
			// request
			else if (userInput== 2) {
				System.out.println("Please select one of the following options"
						+ "\n" + "- PRESS 1 to Modify the First Name" + "\n"
						+ "- PRESS 2 to Modify the Last Name" + "\n"
						+ "- PRESS 3 to Modify the Department" + "\n"
						+ "- PRESS 4 to Modify the Job" + "\n");

				String dataInput = null;
				int Input = scanner.nextInt();
				String Values[] = new String[2];

				scanner.nextLine();
				if (Input == 1) {
					System.out
							.println("Input the first name of the employee you want to modify (Old New)");
					dataInput = scanner.nextLine();
					Values = dataInput.split("\\s");
				} else if (Input == 2) {
					System.out
							.println("Please input Last name of the employee you want to modify (Old New)");
					dataInput = scanner.nextLine();
					Values = dataInput.split("\\s");
				} else if (Input == 3) {
					System.out
							.println("Please input Department of the employee you want to modify (Old New)");
					dataInput = scanner.nextLine();
					Values = dataInput.split("\\s");
				} else if (Input == 4) {
					System.out
							.println("Please input Department of the employee you want to modify (Old New)");
					dataInput = scanner.nextLine();
					Values = dataInput.split("\\s");
				}

				String MV = Values[0];
				String RV = Values[1];

				// If user inputs '1' to modify the first name
				if (Input == 1) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].getFirstName().equalsIgnoreCase(MV))//
						{
							employee[k].setFirstName(RV);

							printHeading();
							printEmployee(k);
						}
					}
				}

				// If user inputs '2' to modify the last name
				else if (Input == 2) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].getLastName().equalsIgnoreCase(MV)) {
							employee[k].setLastName(RV);

							printHeading();
							printEmployee(k);
						}
					}
				}
				// If user inputs '3' to modify the department
				else if (Input == 3) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].getDep().equalsIgnoreCase(MV)) {
							employee[k].setDep(RV);

							printHeading();
							printEmployee(k);
						}

					}
				}

				// If user inputs '4' to modify the job
				else if (Input == 4) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].getJob().equalsIgnoreCase(MV)) {
							employee[k].setJob(RV);

							printHeading();
							printEmployee(k);
						}
					}
				}
			}

			// if the user inputs '3' to find an employee
			else if (userInput== 3) {

				// The menu for Find
				System.out.println("Please select one of the following options"
						+ "\n" + "- PRESS 1 to Find by First Name" + "\n"
						+ "- PRESS 2 to Find by Last Name" + "\n"
						+ "- PRESS 3 to Find by Department" + "\n"
						+ "- PRESS 4 to Find by Job" + "\n");

				String MV = null;
				int recordFound = 0;
				int Input = scanner.nextInt();

				if (Input == 1) {
					System.out
							.println("Input the first name of the employee you want to find");
					MV = scanner.next();
				} else if (Input == 2) {
					System.out
							.println("Please input Last name of the employee you want to find");
					MV = scanner.next();

				} else if (Input == 3) {
					System.out
							.println("Please input Department of the employee you want to find");
					MV = scanner.next();
				} else if (Input == 4) {
					System.out
							.println("Please input Department of the employee you want to find");
					MV = scanner.next();
				}

				// Display the heading for the fields
				printHeading();

				// The loop to find the employee. Break when found and go back
				// to the main FOR Loop.
				for (int k = 0; k < 100; k++) {
					if (employee[k] != null) {
						MV = MV.replaceAll("\\*", "\\.\\*");

						switch (Input) {

						case 1:
							if (employee[k].getFirstName() != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].getFirstName()); // get
																				// a
																				// matcher
																				// object

								if (m.matches()) {
									printEmployee(k);
									recordFound++;
								}
								break;
							}
						case 2:
							if (employee[k].getLastName() != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].getLastName());

								if (m.matches()) {
									printEmployee(k);
									recordFound++;
								}
								break;
							}
						case 3:
							if (employee[k].getDep() != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].getDep());

								if (m.matches()) {
									printEmployee(k);
									recordFound++;
								}
								break;
							}
						case 4:
							if (employee[k].getJob() != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].getJob());

								if (m.matches()) {
									printEmployee(k);
									recordFound++;
								}
								break;
							}
						default:
							System.out
									.println("*****--Invalid Option, Please Enter Again--*****");
							break;
						}
					}
				}
				if (recordFound == 0) {
					System.out.println("***No Records Found***");
				} else
					System.out.println(recordFound
							+ " employee record(s) found." + "\n");
			}

			// If the user inputs '4' to delete an employee
			else if (userInput== 4) {

				scanner.nextLine();
				String Values1[] = new String[4];
				System.out
						.println("Please input Last name, first name, Department and Job of the employee seperated by space -");
				String dataInput1 = scanner.nextLine();

				Values1 = dataInput1.split("\\s");

				String LN = Values1[0];
				String FN = Values1[1];
				String DP = Values1[2];
				String JB = Values1[3];

				deleteEmployee(LN, FN, DP, JB);
				EmpCount--;
				System.out.println("Total employees in database = " + EmpCount
						+ "\n");

			}

			// If the user wants to EXIT the program
			else if (userInput== 5)
				break;

		} // Bracket close for infinite FOR Loop

	} // Bracket close for main() function

	// Function to add a new employee to the array with First and Last Name as
	// inputs
	private static void addEmployee(String lname, String fname, int i) {

		Employee e = new Employee(lname, fname);
		employee[i] = e;

		System.out.println("Employee Added -");
		printEmployee(i);
	}

	// Function to add an employee with three parameters
	private static void addEmployee(String lname, String fname, String dept,
			int i) {

		Employee e = new Employee(lname, fname, dept);
		employee[i] = e;

		System.out.println("Employee Added -");
		printEmployee(i);
	}

	private static void addEmployee(String lname, String fname, String dept,
			String jb, int i) {

		Employee e = new Employee(lname, fname, dept, jb);
		employee[i] = e;

		System.out.println("Employee Added -");
		printEmployee(i);
	}

	// Check if element in array is empty. Returns true if empty
	private static boolean checkEmployeeEmpty(Employee e) {
		if (e == null)
			return true;

		else
			return false;
	}

	// Deletes an employee element from array
	private static void deleteEmployee(String LN, String FN, String DP, String JB) {
		int recordDEL = 0;

		System.out.println("Record deleted - ");
		System.out.println("--------------------------");

		for (int k = 0; k < 100; k++) {
			if (employee[k] != null
					&& employee[k].getLastName().equalsIgnoreCase(LN)
					&& employee[k].getFirstName().equalsIgnoreCase(FN)
					&& employee[k].getDep().equalsIgnoreCase(DP)
					&& employee[k].getJob().equalsIgnoreCase(JB)) {
				printEmployee(k);
				employee[EmpCount-1] = employee[k];
				employee[EmpCount-1] = null;
				EmpCount--;
				recordDEL++;
			}
		}

		if (recordDEL == 0)
			System.out.println("***No Records deleted***");
		else
			System.out.println(recordDEL + " employee record deleted." + "\n");
	}

	/* Print functions */
	private static void printEmployee(int i) {

		System.out.println(employee[i].getLastName() + ","
				+ employee[i].getFirstName() + "," + employee[i].getDep() + ","
				+ employee[i].getJob());
	}

	public static void printMainMenu() {

		System.out.println("Please select of the following options" + "\n"
				+ "- PRESS 1 to ADD an employee" + "\n"
				+ "- PRESS 2 to MODIFY existing employee" + "\n"
				+ "- PRESS 3 to FIND an employee" + "\n"
				+ "- PRESS 4 to DELETE an employee" + "\n"
				+ "- PRESS 5 to EXIT");
	}

	public static void printHeading() {

		System.out.println("Last Name" + "," + "First Name" + ","
				+ "Department" + "," + "Job");
		System.out.println("---------------------------------------");
	}

} // End of EDA class

class Employee {

	// Variables for employee
	private String LastName, FirstName, Dep, Job;

	// Constructor with two parameters. Set "Unknown" if not passed
	public Employee(String ln, String fn) {
		setLastName(ln);
		setFirstName(fn);
		Dep = "Unknown";
		Job = "Unknown";
	}

	// Constructor with three parameters
	public Employee(String ln, String fn, String dp) {
		setLastName(ln);
		setFirstName(fn);
		setDep(dp);
		Job = "Unknown";
	}

	// Constructor with all parameters
	public Employee(String ln, String fn, String dp, String jb) {
		setLastName(ln);
		setFirstName(fn);
		setDep(dp);
		setJob(jb);
	}

	/* Functions to return the employee data */
	public String getLastName() {
		return LastName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getJob() {
		return Job;
	}

	public String getDep() {
		return Dep;
	}

	/* Functions to set the employee data */
	public void setDep(String s) {
		Dep = s;
	}

	public void setJob(String s) {
		Job = s;
	}

	public void setLastName(String s) {
		LastName = s;
	}

	public void setFirstName(String s) {
		FirstName = s;
	}

}
