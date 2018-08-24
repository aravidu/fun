package com.test.fun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class WordsAndMeanings {

	private static List<String> list = new ArrayList<String>();

	public static void main(String args[]) {

		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		// Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		
		List<Integer> usedWords = new ArrayList<Integer>();

		// initialize
		initializeMaps();
		
		System.out.println("Choose the correct answer from the following: ");
		System.out.println();

		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String word = null;
			Map<Integer, String> wordChoices = new HashMap<Integer, String>();

			int wordNum = 0;
			int index = 138;
			// get list
			while (true) {
				wordNum = rand2.nextInt(index);
				if (usedWords.contains(wordNum)) {
					if (usedWords.size()==index) {
						CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Words & Meanings");
					}
					continue;
				} else {
					usedWords.add(wordNum);
					break;
				}
			}
			word = getChoicesForWord(list, wordChoices, wordNum, index);
		

			// randomize 4 choices
			int[] choiceArr = { 1, 2, 3, 4 };
			for (int i = 0; i < choiceArr.length; i++) {
				int randomPosition = rand3.nextInt(choiceArr.length);
				int temp = choiceArr[i];
				choiceArr[i] = choiceArr[randomPosition];
				choiceArr[randomPosition] = temp;
			}

			// present the question with 4 choices
			String ans = poseQuestion(sno, word, wordChoices, choiceArr);

			String userInput = scanner.nextLine();

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Words & Meanings");
			}

			if (ans.equalsIgnoreCase(userInput)) {
				System.out.println("correct");
				System.out.println();
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + ans);
				System.out.println();
				incorrect++;
			}
			sno++;
		}
	}

	private static String poseQuestion(int sno, String word, Map<Integer, String> choiceMap, int[] choiceArr) {
		// System.out.println(sno + "). What is the meaning of " + country + "?");
		System.out.println(sno + "). " + word + ":");
		System.out.println("--------------------------------------------------------------------------------");

		String ans = null;
		for (int i = 0; i < 4; i++) {
			if (i == 0) {
				if (choiceArr[i] == 1) {
					ans = "a";
				}
				System.out.println("a. " + choiceMap.get(choiceArr[i]));
			} else if (i == 1) {
				if (choiceArr[i] == 1) {
					ans = "b";
				}
				System.out.println("b. " + choiceMap.get(choiceArr[i]));
			} else if (i == 2) {
				if (choiceArr[i] == 1) {
					ans = "c";
				}
				System.out.println("c. " + choiceMap.get(choiceArr[i]));
			} else if (i == 3) {
				if (choiceArr[i] == 1) {
					ans = "d";
				}
				System.out.println("d. " + choiceMap.get(choiceArr[i]));
			}
		}
		return ans;
	}

	private static void initializeMaps() {
		setMap1();
	}

	private static String getChoicesForWord(List<String> list, Map<Integer, String> choiceMap, int wordNum, int index) {
		String country;
		String capital;
		List<Integer> usedWords = new ArrayList<Integer>();
		usedWords.add(wordNum);
		String wordNMeaning = list.get(wordNum);
		String[] cc1ItemAsArr = wordNMeaning.split(",");
		country = cc1ItemAsArr[0];
		capital = cc1ItemAsArr[1];
		// put right choice in map
		choiceMap.put(1, capital);

		for (int i = 2; i < 5; i++) {
			Random r = new Random();
			int otherWordNum = 0;
			while (true) {
				otherWordNum = r.nextInt(index);
				if (usedWords.contains(otherWordNum)) {
					continue;
				} else {
					usedWords.add(otherWordNum);
					break;
				}
			}
			String otherWordNMeaning = list.get(otherWordNum);
			String[] otherWordNMeaningAsArr = otherWordNMeaning.split(",");
			// put wrong choices in map
			choiceMap.put(i, otherWordNMeaningAsArr[1]);
		}
		return country;
	}

	private static void setMap1() {
		list.add("abolish,cancel; put an end to");
		list.add("absurd,ridiculous");
		list.add("abuse,cruel or inhumane treatment");
		list.add("access,a way of entering or leaving");
		list.add("accomplish,to do something by making an effort; to complete successfully");
		list.add("achievement,something done that takes skill or effort");
		list.add("aggressive,ready to attack or start fights; acting in a hostile way");
		list.add("alternate,go back and forth");
		list.add("altitude,height above sea level");
		list.add("antagonist,An opponent; one who opposes or competes");
		list.add("antonym,a word that means the opposite of another word");
		list.add("anxious,worried; concerned");
		list.add("apparent,obvious");
		list.add("approximate,be close or similar");
		list.add("aroma,a pleasant smell");
		list.add("assume,to take for granted; to suppose");
		list.add("astound,to surprise; to amaze");
		list.add("available,ready for use, at hand");
		list.add("avalanche,a slide of large masses of snow and ice and mud down a mountain");
		list.add("banquet,a ceremonial dinner party for many people");
		list.add("beverage,A liquid used as a drink");
		list.add("bland,mild; tasteless; dull");
		list.add("blizzard,a storm with widespread snowfall accompanied by strong winds");
		list.add("budge,to move or shift.");
		list.add("bungle,make a mess of, destroy or ruin");
		list.add("cautiously,carefully");
		list.add("challenge,Something difficult to accomplish");
		list.add("character,a person or animal in a story");
		list.add("combine,add together from different sources");
		list.add("companion,person who goes along with another");
		list.add("crave,to have an extremely strong desire for something");
		list.add("compassion,Sympathy for another's suffering; pity");
		list.add("compensate,do or give something to somebody in return");
		list.add("comply,to do as one is asked or ordered");
		list.add("compose,to make up");
		list.add("concept,an idea or principle");
		list.add("confident,sure of yourself");
		list.add("convert,to change from one form to another");
		list.add("course,a line or route along which something travels or moves");
		list.add("courteous,polite and gracious; considerate toward others; well-mannered");
		list.add("debate,discuss the pros and cons of an issue");
		list.add("decline,a gradual decrease");
		list.add("dedicate,To set aside for a certain purpose.");
		list.add("deprive,to take or keep something away from someone");
		list.add("detect,to discover something not easily noticed");
		list.add("dictate,to give orders");
		list.add("document,a written or printed record that gives information or proof");
		list.add("duplicate,identically copied from an original");
		list.add("edible,any substance that can be used as food");
		list.add("endanger,to expose to danger");
		list.add("escalate,to elevate, to increase in intensity");
		list.add("evade,To avoid, dodge");
		list.add("exasperate,to irritate, annoy, or anger");
		list.add("excavate,find by digging in the ground");
		list.add("exert,make a great effort at a mental or physical task");
		list.add("exhibit,something shown to the public");
		list.add("exult,feel extreme happiness or elation");
		list.add("frigid,extremely cold");
		list.add("gigantic,huge, giant, immense");
		list.add("gorge,a deep ravine (usually with a river running through it)");
		list.add("guardian,one who protects");
		list.add("hazy,unclear, misty; not readily seen or understandable");
		list.add("hearty,healthy; strong");
		list.add("homonym,a word spelled exactly like another word, but having a different meaning");
		list.add("identical,exactly alike");
		list.add("illuminate,to light up; make clear");
		list.add("immense,very large or great");
		list.add("impressive,exceptionally good");
		list.add("independent,someone who does things on his or her own");
		list.add("industrious,hardworking; not lazy");
		list.add("intense,showing great concentration or determination");
		list.add("intercept,to stop something from reaching its intended destination");
		list.add("jubilation,a feeling or expression of great joy");
		list.add("kin,one's relatives");
		list.add("luxurious,providing ease and comfort far beyond what is ordinary or necessary");
		list.add("major,more important, bigger or more serious than others of the same type");
		list.add("miniature,small; tiny");
		list.add("minor,of lesser importance or stature or rank");
		list.add("mischief,behavior that causes problems for others");
		list.add("monarch,a person who rules over a kingdom or empire");
		list.add("moral,relating to principles of right and wrong");
		list.add("myth,a traditional story accepted as history");
		list.add("narrator,someone who tells a story");
		list.add("navigate,direct carefully and safely");
		list.add("negative,bad or harmful");
		list.add("nonchalant,calm, casual, unconcerned");
		list.add("numerous,A large number; very many");
		list.add("oasis,an area in the desert with a water source");
		list.add("obsolete,out-of-date, no longer in use");
		list.add("occasion,a special event");
		list.add("overthrow,to end the rule of; to defeat, often by using force");
		list.add("pardon,legal forgiveness of a crime");
		list.add("pasture,a field of growing grass where animals can eat; a meadow");
		list.add("pedestrian,a person who travels by foot");
		list.add("perish,to die");
		list.add("petrify,turn to stone; cause to become stonelike; stun or paralyze");
		list.add("portable,capable of being easily carried");
		list.add("prefix,a syllable added to the beginning of a word");
		list.add("preserve,keep in safety and protect from harm, decay, loss, or destruction");
		list.add("protagonist,main character");
		list.add("provide,To give what is needed; to supply");
		list.add("purchase,to buy");
		list.add("reassure,to make less worried or fearful; to comfort");
		list.add("reign,to rule as a queen or king");
		list.add("reliable,Able to be depended on; trustworthy");
		list.add("require,make someone do something");
		list.add("resemble,To be like or similar to.");
		list.add("retain,keep in one's mind");
		list.add("retire,To stop working because one has reached a certain age");
		list.add("revert,go back to a previous state");
		list.add("route,The path that must be followed to get to a place");
		list.add("saunter,to stroll; walk in an easy, leisurely way");
		list.add("seldom,not often");
		list.add("senseless,foolish; pointless; ridiculous");
		list.add("sever,to separate, divide into parts");
		list.add("slither,to move with a sliding, side-to-side motion of the body");
		list.add("sluggish,slow and lazy");
		list.add("soar,the act of rising upward into the air");
		list.add("solitary,being alone; lacking the company of others");
		list.add("solo,any activity that is performed alone without assistance");
		list.add("sparse,thinly scattered");
		list.add("spurt,to shoot out quickly in a stream");
		list.add("strategy,an overall plan of action");
		list.add("suffix,a letter or syllable added to the end of a word");
		list.add("suffocate,deprive of oxygen and prevent from breathing");
		list.add("summit,the top point of a mountain or hill");
		list.add("suspend,to stop; to put on hold");
		list.add("synonym,A word that means the same as another word");
		list.add("talon,a sharp hooked claw especially on a bird of prey");
		list.add("taunt,to make fun of in an insulting way");
		list.add("thrifty,careful about money; economical");
		list.add("translate,restate (words) from one language into another language");
		list.add("tropical,very hot and humid climate");
		list.add("visible,able to be seen");
		list.add("visual,having to do with sight or seeing");
		list.add("vivid,bright, distinct, and clear");
		list.add("wilderness,An area where there are few people living; an area still in its natural state");
		list.add("withdraw,take back; remove");
	}

}
