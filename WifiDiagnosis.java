/*
 * Class: CMSC203 
 * Instructor:Gregory Grinberg
 * Description: : This program is a Wifi Diagnostic tool that prompts the user and provides assistance.
 * The program can be used to troubleshoot common internet issues.
 * Due: 6/14/2021
 * Platform/compiler:Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Rony Stephan
*/

import java.util.Scanner;
public class WifiDiagnosis {
	public static void main(String [] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("If you have a problem with internet connectivity, this Wifi Diagnosis might work.");//introductory statements
		System.out.println("First step: reboot your computer");

		String step1, step2, step3, step4;//declaring strings for steps so scope is program wide

		do {//do-while loop 1
			System.out.println("Are you able to connect with the internet? (yes or no)");//prompt for step 1
			step1= sc.nextLine();//grabbing input from scanner

			if(step1.equalsIgnoreCase("yes")) {//if the solution works
				System.out.println("Rebooting your computer seemed to work");//solution statements
				System.out.println("Thank you for using the diagnostic tool, please re-run the tool if you have another issue!");
			}
			else if(step1.equalsIgnoreCase("no")) {//if solution does not work
				do {
					System.out.println("Second step: reboot your router");//move on to second step
					System.out.println("Now are you able to connect with the internet? (yes or no)");
					step2=sc.nextLine();//grabbing second step from next input
					if(step2.equalsIgnoreCase("yes")) {//if solutions work
						System.out.println("Rebooting your router seemed to work");//solution statements
						System.out.println("Thank you for using the diagnostic tool, please re-run the tool if you have another issue!");
					}
					else if(step2.equalsIgnoreCase("no")) {//if step 2 doesnt work
						do {
							System.out.println("Third step: make sure the cables to your router are plugged in firmly and your router is getting power");
							System.out.println("Now are you able to connect with the internet? (yes or no)");//move on to step 3
							step3=sc.nextLine();//grabbing third step from scanner
							if(step3.equalsIgnoreCase("yes")) {//if third step works
								System.out.println("Plugging in the cables seemed to work");//solution statements
								System.out.println("Thank you for using the diagnostic tool, please re-run the tool if you have another issue!");
							}
							else if(step3.equalsIgnoreCase("no")) {//if third step doesnt work
								do {
									System.out.println("Fourth step: Move the computer closer to the router and try to connect");
									System.out.println("Now are you able to connect with the internet? (yes or no)");//prompts for step 4
									step4=sc.nextLine();//grabbing step 
									if(step4.equalsIgnoreCase("yes")) {//if step 4 works
										System.out.println("Moving your computer closer to the router seeemed to work");//solution statements
										System.out.println("Thank you for using the diagnostic tool, please re-run the tool if you have another issue!");
									}
									else if(step4.equalsIgnoreCase("no")) {//if step 4 doesnt work
										System.out.println("Fifth step: contact your ISP");//fifth step statements
										System.out.println("Make sure your ISP is hooked up to your router.");
										System.out.println("Thank you for using the diagnostic tool, please re-run the tool if you have another issue!");
									}
									else {
										System.out.println("Invalid input");//step 4 invalid input
									}
								}while ((!step4.equalsIgnoreCase("Yes")) && (!step4.equalsIgnoreCase("No")));//step 4 data validation

							}
							else {
								System.out.println("Invalid input");//step 3 invalid input
							}
						}while ((!step3.equalsIgnoreCase("Yes")) && (!step3.equalsIgnoreCase("No")));//step 3 data validation

					}
					else {
						System.out.println("Invalid input");//step 2 invalid input
					}
				}while ((!step2.equalsIgnoreCase("Yes")) && (!step2.equalsIgnoreCase("No")));//step 2 data validation

			}
			else {
				System.out.println("Invalid input");//step 1 invalid input
			}
		}while ((!step1.equalsIgnoreCase("Yes")) && (!step1.equalsIgnoreCase("No")));//step 1 data validation

	}
}
