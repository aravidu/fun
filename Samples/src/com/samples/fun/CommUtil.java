package com.samples.fun;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CommUtil {
	public static void computeStatsAndExit(long startTime, Scanner scanner, int sno, double correct,
			double incorrect, String operation) {
		scanner.close();
		long elapsed = System.currentTimeMillis() - startTime;
		long elapsedInSec = elapsed / 1000;
		double timeInMin = elapsedInSec/60d;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
		System.out.println();
		System.out.println(sdf.format(new Date()) + "\t"+operation+"\t" + df.format(timeInMin) + "\t"
				+ (sno - 1) + "\t" + Math.round(correct) + "\t" + Math.round(incorrect) + "\t"
				+ Math.round((correct / (sno - 1)) * 100) + " %");
		System.exit(1);
	}

}
