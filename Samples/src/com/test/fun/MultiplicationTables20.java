package com.test.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTables20 {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		while (true) {
			int table = rand1.nextInt(20);
			int upto = rand2.nextInt(20);
			List<String> comboUsedList = new ArrayList<String>();
			if (table < 12 | upto < 12 | comboUsedList.contains(Integer.toString(table) + "," + Integer.toString(upto))) {
				if (comboUsedList.size() == 118) {
					// exit
					CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Adv. Multiplication");
				} else {
					continue;
				}
			}
			comboUsedList.add(Integer.toString(table) + "," + Integer.toString(upto));
			System.out.println(sno + "). " + table + "x" + upto + "=");
			int ans = table * upto;
			String userInput = scanner.nextLine();
			int sol = 0;
			try {
				sol = Integer.parseInt(userInput);
			} catch (NumberFormatException e) {
				// i know that it's not a number
				if ("".equals(userInput) || !"exit".equalsIgnoreCase(userInput) || !userInput.contains("exit")) {
					System.out.println("incorrect, answer is: " + ans);
					sno++;
					continue;
				}
			}

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Adv. Multiplication");
			}
			if (sol == ans) {
				System.out.println("correct");
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + ans);
				incorrect++;
			}
			sno++;
		}
	}
}
