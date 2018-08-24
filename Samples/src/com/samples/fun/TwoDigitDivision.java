package com.samples.fun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class TwoDigitDivision {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		while (true) {
			int dividend = rand1.nextInt(99);
			//System.out.println("dividend: "+dividend);
			int divisor = rand2.nextInt(20);
			//System.out.println("divisor: "+divisor);
			if (divisor < 2 || dividend < 2 || (dividend >= 2 && dividend < divisor)) {
				continue;
			}
			// System.out.println(sno + "). " + dividend + " / " + divisor + " = ");
			System.out.println();
			System.out.println("     "+dividend);
			System.out.println(sno + "). ---");
			System.out.println("     "+divisor);

			String userInput = scanner.nextLine();

			if ("".equals(userInput.trim()) || userInput.trim().contains(" ")) {
				System.out.println("enter a number..");
				continue;
			}
			int quotient = dividend / divisor;
			int remainder = dividend % divisor;

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				scanner.close();
				long elapsed = System.currentTimeMillis() - startTime;
				long elapsedInSec = elapsed / 1000;
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
				System.out.println();
				System.out.println(sdf.format(new Date()) + "\tDivision\t" + ((elapsedInSec / 60)+"."+(elapsedInSec % 60)) + "\t" + (sno - 1)
						+ "\t" + Math.round(correct) + "\t" + Math.round(incorrect) + "\t"
						+ Math.round((correct / (sno - 1)) * 100) + " %");
				System.exit(1);
			}
			if (userInput != null || !"".equals(userInput)) {
				int userQuotient = 0;
				int userRemainder = 0;
				String[] tokens = null;
				//boolean flag = false;
				if (remainder != 0) {
					// if string has r - ok
					if (userInput.contains("r")) {
						tokens = userInput.split("r"); // 3r2
						try {
							userQuotient = Integer.parseInt(tokens[0]);
							userRemainder = Integer.parseInt(tokens[1]);	
						} catch (Exception ex) {
							System.out.println("incorrect, answer is: " + quotient + " r" + remainder);
							sno++;
							continue;
						}
					} else {
						// if string has no r - incorrect
						System.out.println("incorrect, answer is: " + quotient + " r" + remainder);
						sno++;
						continue;
					}
				} else {
					// if string is a num - ok - check later
					try {
						userQuotient = Integer.parseInt(userInput);
					} catch (Exception e) {
						// if string has r - ok - check later
						if (userInput.contains("r")) {
							tokens = userInput.split("r"); // 3r2
							try {
								userQuotient = Integer.parseInt(tokens[0]);
								userRemainder = Integer.parseInt(tokens[1]);	
							} catch (Exception ex) {
								System.out.println("incorrect, answer is: " + quotient + " r" + remainder);
								sno++;
								continue;
							}
						} else {
							// if string has others - incorrect	
							System.out.println("incorrect, answer is: " + quotient + " r" + remainder);
							sno++;
							continue;
						}
					}
				}

				if (userQuotient == quotient && remainder == userRemainder) {
					System.out.println("correct");
					correct++;
				} else {
					System.out.println("incorrect, answer is: " + quotient + " r" + remainder);
					incorrect++;
				}
			}
			sno++;
		}
	}
}
