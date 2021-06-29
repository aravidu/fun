package com.samples.fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MultiplicationTables {
	public static void main(String args[]) {
		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		List<String> comboUsedList = new ArrayList<String>();
		List<String> wrongAnswersList = new ArrayList<String>();
		while (true) {
			int table = rand1.nextInt(20);
			int upto = rand2.nextInt(20);
			// System.out.println(comboUsedList.toString());
			if (table < 11 | upto < 2 | comboUsedList.contains(Integer.toString(table) + "," + Integer.toString(upto))) {
				// if (comboUsedList.size() == 324) { // from 2..19 upto 19 table = 324 entries in list
				if (comboUsedList.size() == 162) { // from 11..19 upto 19 table = 162 entries in list
					// exit
					if (wrongAnswersList.size() != 0) {
						System.out.println();
						System.out.println("Great job!! But.. before we end it all, here are the questions you got wrong.. with correct answers: ");
						for (String item : wrongAnswersList) {
							System.out.println(item);
						}
					}
					CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Multiplication");
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
					wrongAnswersList.add(Integer.toString(table) + "x" + Integer.toString(upto) + "="+ (table * upto));
					System.out.println("incorrect, answer is: " + ans);
					sno++;
					continue;
				}
			}

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				if (wrongAnswersList.size() != 0) {
					System.out.println();
					System.out.println("Great job!! But.. before we end it all, here are the questions you got wrong.. with correct answers: ");
					for (String item : wrongAnswersList) {
						System.out.println(item);
					}
				}
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Multiplication");
			}
			if (sol == ans) {
				System.out.println("correct");
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + ans);
				wrongAnswersList.add(Integer.toString(table) + "x" + Integer.toString(upto) + "="+ (table * upto));
				incorrect++;
			}
			sno++;
		}
	}
}
