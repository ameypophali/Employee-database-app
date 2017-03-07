import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EDA {

	public static final String YES = "yes";
	public static final String NO = "no";
	public static int EmpCount = 0;
	public static Scanner scanner = new Scanner(System.in);

	static Employee[] employee = new Employee[100];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (;;) {

			// Function call to print the menu for user
			PrintMainMenu();

			int j = scanner.nextInt();

			// Check for invalid inputs
			if (j != 1 && j != 2 && j != 3 && j != 4 && j != 5) {
				System.out
						.println("Invalid input provided. Please press one of the following -");
				PrintMainMenu();
				j = scanner.nextInt();
			}

			// Terminate if still invalid
			if (j != 1 && j != 2 && j != 3 && j != 4 && j != 5) {
				System.out
						.println("Wrong input attempts limit reached. Program terminating!!");
			}

			// Enter this only if user wants to ADD an employee
			if (j == 1) {

				System.out
						.println("Please select of the following options"
								+ "\n"
								+ "- PRESS 1 to ADD only First Name and Last Name"
								+ "\n"
								+ "- PRESS 2 to ADD only First Name, Last Name and Department"
								+ "\n" + "- PRESS 3 to ADD all the parameters"
								+ "\n"
								+ "- PRESS 4 to go BACK to the previous menu");

				int h = scanner.nextInt();

				if (h != 1 && h != 2 && h != 3 && h != 4) {
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

					h = scanner.nextInt();
				}

				// Check for invalid inputs and terminate
				if (h != 1 && h != 2 && h != 3 && h != 4) {
					System.out
							.println("Wrong input attempts limit reached. Program terminating!!");
				}

				String Values1[] = new String[4];
				scanner.nextLine();

				for (int i = 0; i < 100; i++) {

					if (h == 1) {

						// If user wants to add two parameters
						if (CheckEmployeeEmpty(employee[i])) // Check if the
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
					else if (h == 2) {

						if (CheckEmployeeEmpty(employee[i])) {

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
					else if (h == 3) {
						if (CheckEmployeeEmpty(employee[i])) {

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
						else if (h == 4)
							break;
					}
				}
			}

			// Call ModifyEmployee if the user inputs '2' i.e. a modification
			// request
			else if (j == 2) {
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
								&& employee[k].FirstName.equalsIgnoreCase(MV))//
						{
							employee[k].setFirstName(RV);

							PrintHeading();
							PrintEmployee(k);
						}
					}
				}

				// If user inputs '2' to modify the last name
				else if (Input == 2) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].LastName.equalsIgnoreCase(MV)) {
							employee[k].setLastName(RV);

							PrintHeading();
							PrintEmployee(k);
						}
					}
				}
				// If user inputs '3' to modify the department
				else if (Input == 3) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].Dep.equalsIgnoreCase(MV)) {
							employee[k].setDep(RV);

							PrintHeading();
							PrintEmployee(k);
						}

					}
				}

				// If user inputs '4' to modify the job
				else if (Input == 4) {

					for (int k = 0; k < 100; k++) {
						if (employee[k] != null
								&& employee[k].Job.equalsIgnoreCase(MV)) {
							employee[k].setJob(RV);

							PrintHeading();
							PrintEmployee(k);
						}
					}
				}
			}

			// if the user inputs '3' to find an employee
			else if (j == 3) {

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
				PrintHeading();

				// The loop to find the employee. Break when found and go back
				// to the main FOR Loop.
				for (int k = 0; k < 100; k++) {
					if (employee[k] != null) {
						MV = MV.replaceAll("\\*", "\\.\\*");

						switch (Input) {

						case 1:
							if (employee[k].FirstName != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].FirstName); // get
																				// a
																				// matcher
																				// object

								if (m.matches()) {
									PrintEmployee(k);
									recordFound++;
								}
								break;
							}
						case 2:
							if (employee[k].LastName != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].LastName);

								if (m.matches()) {
									PrintEmployee(k);
									recordFound++;
								}
								break;
							}
						case 3:
							if (employee[k].Dep != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].Dep);

								if (m.matches()) {
									PrintEmployee(k);
									recordFound++;
								}
								break;
							}
						case 4:
							if (employee[k].Job != null) {
								Pattern p = Pattern.compile(MV);
								Matcher m = p.matcher(employee[k].Job);

								if (m.matches()) {
									PrintEmployee(k);
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
			else if (j == 4) {

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

				DeleteEmployee(LN, FN, DP, JB);
				EmpCount--;
				System.out.println("Total employees in database = " + EmpCount
						+ "\n");

			}

			// If the user wants to EXIT the program
			else if (j == 5)
				break;

		} // Bracket close for infinite FOR Loop

	} // Bracket close for main() function

	// Function to add a new employee to the array with First and Last Name as
	// inputs
	public static void addEmployee(String lname, String fname, int i) {

		Employee e = new Employee(lname, fname);
		employee[i] = e;

		System.out.println("Employee Added -");
		PrintEmployee(i);
	}

	// Function to add an employee with three parameters
	public static void addEmployee(String lname, String fname, String dept,
			int i) {

		Employee e = new Employee(lname, fname, dept);
		employee[i] = e;

		System.out.println("Employee Added -");
		PrintEmployee(i);
	}

	public static void addEmployee(String lname, String fname, String dept,
			String jb, int i) {

		Employee e = new Employee(lname, fname, dept, jb);
		employee[i] = e;

		System.out.println("Employee Added -");
		PrintEmployee(i);
	}

	// Check if element in array is empty. Returns true if empty
	public static boolean CheckEmployeeEmpty(Employee e) {
		if (e == null)
			return true;

		else
			return false;
	}

	// Deletes an employee element from array
	public static void DeleteEmployee(String LN, String FN, String DP, String JB) {
		int recordDEL = 0;

		System.out.println("Record deleted - ");
		System.out.println("--------------------------");

		for (int k = 0; k < 100; k++) {
			if (employee[k] != null
					&& employee[k].LastName.equalsIgnoreCase(LN)
					&& employee[k].FirstName.equalsIgnoreCase(FN)
					&& employee[k].Dep.equalsIgnoreCase(DP)
					&& employee[k].Job.equalsIgnoreCase(JB)) {
				PrintEmployee(k);
				employee[k] = null;
				recordDEL++;
			}
		}

		if (recordDEL == 0)
			System.out.println("***No Records deleted***");
		else
			System.out.println(recordDEL + " employee record deleted." + "\n");
	}

	/* Print functions */
	public static void PrintEmployee(int i) {

		System.out.println(employee[i].getLastName() + ","
				+ employee[i].getFirstName() + "," + employee[i].getDep() + ","
				+ employee[i].getJob());
	}

	public static void PrintMainMenu() {

		System.out.println("Please select of the following options" + "\n"
				+ "- PRESS 1 to ADD an employee" + "\n"
				+ "- PRESS 2 to MODIFY existing employee" + "\n"
				+ "- PRESS 3 to FIND an employee" + "\n"
				+ "- PRESS 4 to DELETE an employee" + "\n"
				+ "- PRESS 5 to EXIT");
	}

	public static void PrintHeading() {

		System.out.println("Last Name" + "," + "First Name" + ","
				+ "Department" + "," + "Job");
		System.out.println("---------------------------------------");
	}

} // End of EDA class

class Employee {

	// Variables for employee
	public String LastName, FirstName, Dep, Job;

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
