package com.samples.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TwoDigitAddition {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		List<String> comboUsedList = new ArrayList<String>();
		while (true) {
			int i = rand1.nextInt(150);
			int j = rand2.nextInt(150);
			if (i < 2 | j < 2 | comboUsedList.contains(Integer.toString(i) + "," + Integer.toString(j))) {
				if (comboUsedList.size() == 118) {
					// exit
					CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Addition");
				} else {
					continue;
				}
			}
			comboUsedList.add(Integer.toString(i) + "," + Integer.toString(j));
			System.out.println(sno + "). " + i + "+" + j + "=");
			int ans = i + j;
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
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Addition");
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
