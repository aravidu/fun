package com.samples.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MeaningsToWordsFIB {

	private static List<String> list = new ArrayList<String>();

	public static void main(String args[]) {

		int sno = 1;
		double correct = 0;
		double incorrect = 0;
		Random rand2 = new Random();

		List<Integer> usedWords = new ArrayList<Integer>();

		// initialize
		initializeMaps();

		System.out.println("Fill in the blanks: ");
		System.out.println();

		long startTime = System.currentTimeMillis();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String meaning = null;

			int wordNum = 0;
			int index = 50;
			// get list
			while (true) {
				wordNum = rand2.nextInt(index);
				if (usedWords.contains(wordNum)) {
					if (usedWords.size() == index) {
						CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Meanings To Words");
					}
					continue;
				} else {
					usedWords.add(wordNum);
					break;
				}
			}
			// meaning = getMeaningForWord(list, wordNum, index);
			String meaningToWord = list.get(wordNum);
			String[] cc1ItemAsArr = meaningToWord.split("\\|");
			meaning = cc1ItemAsArr[0];
			String word = cc1ItemAsArr[1];

			// present the question.. fill in the blank
			System.out.println(sno + "). \"" + meaning + "\" means _________________________");

			String userInput = scanner.nextLine();

			if ("exit".equalsIgnoreCase(userInput) || userInput.contains("exit")) {
				CommUtil.computeStatsAndExit(startTime, scanner, sno, correct, incorrect, "Meanings To Words");
			}

			if (word.equalsIgnoreCase(userInput)) {
				System.out.println("correct");
				System.out.println();
				correct++;
			} else {
				System.out.println("incorrect, answer is: " + word);
				System.out.println();
				incorrect++;
			}
			sno++;
		}
	}

	private static void initializeMaps() {
		setMap1();
	}

	private static void setMap1() {
		list.add("100 years|century");
		list.add("a case used to carry belongings when traveling|baggage");
		list.add("a ceremonial dinner party for many people|banquet");
		list.add("a deep ravine (usually with a river running through it)|gorge");
		list.add("a feeling of sympathy for someone or something|concern");
		list.add("a feeling or expression of great joy|jubilation");
		list.add("A field of grass or wildflowers.|meadow");
		list.add("a field of growing grass where animals can eat; a meadow|pasture");
		list.add("a gradual decrease|decline");
		list.add("a hole in the ground made by an animal for shelter|burrow");
		list.add("A large number; very many|numerous");
		list.add("a legal document giving official permission to do something|permit");
		list.add("a letter or syllable added to the end of a word|suffix");
		list.add("a line or route along which something travels or moves|course");
		list.add("A liquid used as a drink|beverage");
		list.add("a natural or artificial enclosed space|chamber");
		list.add("A number of different kinds; assortment|variety");
		list.add("a part or share of the whole|portion");
		list.add("a person or animal in a story|character");
		list.add("a person who invites guests to a social event|host");
		list.add("a person who rules over a kingdom or empire|monarch");
		list.add("a person who travels by foot|pedestrian");
		list.add("a place where fruit trees grow|orchard");
		list.add("a pleasant smell|aroma");
		list.add("a sharp hooked claw especially on a bird of prey|talon");
		list.add("a slide of large masses of snow and ice and mud down a mountain|avalanche");
		list.add("a special event|occasion");
		list.add("a statement (either spoken or written) that is made in reply to a question, request, criticism, or accusation|response");
		list.add("a storm with widespread snowfall accompanied by strong winds|blizzard");
		list.add("a syllable added to the beginning of a word|prefix");
		list.add("a traditional story accepted as history|myth");
		list.add("A trip or journey in which one usually returns to the starting point.|tour");
		list.add("a way of entering or leaving|access");
		list.add("a wilderness at the edge of a settled area of a country|frontier");
		list.add("a word spelled exactly like another word, but having a different meaning|homonym");
		list.add("a word that means the opposite of another word|antonym");
		list.add("A word that means the same as another word|synonym");
		list.add("a written or printed record that gives information or proof|document");
		list.add("Able to be depended on; trustworthy|reliable");
		list.add("able to be seen|visible");
		list.add("absolutely necessary|essential");
		list.add("act of giving to others, willingness to contribute|generosity");
		list.add("add together from different sources|combine");
		list.add("alert and watchful; considerate; thoughtful|attentive");
		list.add("an area in the desert with a water source|oasis");
		list.add("An area where there are few people living; an area still in its natural state|wilderness");
		list.add("an arm, leg, or wing|limb");
		list.add("an article giving opinions or perspectives, usually in a newspaper|column");
		list.add("an automatic signal (usually a sound) warning of danger|alert");
		list.add("an equal in age or position|peer");
//		list.add("an idea or principle|concept");
//		list.add("an occasion on which a winner is selected from among two or more contestants|competition");
//		list.add("An opponent; one who opposes or competes|antagonist");
//		list.add("an overall plan of action|strategy");
//		list.add("an overwhelming feeling of fear and anxiety|terror");
//		list.add("any activity that is performed alone without assistance|solo");
//		list.add("any substance that can be used as food|edible");
//		list.add("bad or harmful|negative");
//		list.add("be close or similar|approximate");
//		list.add("be or become completely proficient or skilled in|master");
//		list.add("behavior that causes problems for others|mischief");
//		list.add("being alone; lacking the company of others|solitary");
//		list.add("bending and snapping back readily without breaking|flexible");
//		list.add("beyond what is ordinary or usual|extraordinary");
//		list.add("brave, courageous|valiant");
//		list.add("bright, distinct, and clear|vivid");
//		list.add("bring into existence|create");
//		list.add("calm, casual, unconcerned|nonchalant");
//		list.add("cancel; put an end to|abolish");
//		list.add("capable of being easily carried|portable");
//		list.add("careful about money; economical|thrifty");
//		list.add("carefully|cautiously");
//		list.add("causing great sadness; terrible or dreadful|tragic");
//		list.add("causing harm or damage|destructive");
//		list.add("characteristic of maturity, characteristic of maturity|mature");
//		list.add("come into existence|develop");
//		list.add("continue to live|survive");
//		list.add("continue with one's activities|proceed");
//		list.add("cruel or inhumane treatment|abuse");
//		list.add("decide by reasoning|conclude");
//		list.add("deprive of oxygen and prevent from breathing|suffocate");
//		list.add("develop or come to a promising stage|blossom");
//		list.add("direct a question at someone|address");
//		list.add("direct carefully and safely|navigate");
//		list.add("direct one's attention on something|focus");
//		list.add("discuss the pros and cons of an issue|debate");
//		list.add("distinguished from others in excellence|outstanding");
//		list.add("do or give something to somebody in return|compensate");
//		list.add("doubt about someone's honesty|mistrust");
//		list.add("draw someone's attention away from something|distract");
//		list.add("easily broken or damaged or destroyed|fragile");
//		list.add("Empty; unoccupied|vacant");
//		list.add("essential, fundamental|basic");
//		list.add("exactly alike|identical");
//		list.add("exactly correct|accurate");
//		list.add("exceptionally good|impressive");
//		list.add("expect and wish|desire");
//		list.add("extremely cold|frigid");
//		list.add("feel extreme happiness or elation|exult");
//		list.add("find by digging in the ground|excavate");
//		list.add("foolish; pointless; ridiculous|senseless");
//		list.add("free from worries; having no problems|carefree");
//		list.add("full of energy and desire to do something|eager");
//		list.add("go back and forth|alternate");
//		list.add("go back to a previous state|revert");
//		list.add("great in amount, size, importance|considerable");
//		list.add("greet enthusiastically or joyfully|hail");
//		list.add("happening often|frequent");
//		list.add("Happening once a year|annual");
//		list.add("hardworking; not lazy|industrious");
//		list.add("have the financial means to do something or buy something|afford");
//		list.add("have the skills and qualifications to do things well|capable");
//		list.add("having a sharp, pointed edge or outline|jagged");
//		list.add("Having nothing left out; whole; complete|entire");
//		list.add("having the shape of a circle|circular");
//		list.add("having to do with sight or seeing|visual");
//		list.add("healthy; strong|hearty");
//		list.add("height above sea level|altitude");
//		list.add("huge, giant, immense|gigantic");
//		list.add("identically copied from an original|duplicate");
//		list.add("impossible or nearly impossible to see|invisible");
//		list.add("in great supply, easily available; more than enough|plentiful");
//		list.add("influencing strongly|Impact");
//		list.add("jealousy|envy");
//		list.add("keep in one's mind|retain");
//		list.add("keep in safety and protect from harm, decay, loss, or destruction|preserve");
//		list.add("lacking grace or skill in manner or movement or performance|awkward");
//		list.add("learn by repetition|practice");
//		list.add("legal forgiveness of a crime|pardon");
//		list.add("like better|prefer");
//		list.add("main character|protagonist");
//		list.add("make a great effort at a mental or physical task|exert");
//		list.add("make a mess of, destroy or ruin|bungle");
//		list.add("make bigger or more|increase");
//		list.add("make easier|ease");
//		list.add("make smaller|reduce");
//		list.add("make someone do something|require");
//		list.add("make visible|reveal");
//		list.add("mild; tasteless; dull|bland");
//		list.add("mistake one thing for another|confuse");
//		list.add("mix together different elements|blend");
//		list.add("more important, bigger or more serious than others of the same type|major");
//		list.add("neat and in good order|tidy");
//		list.add("not deep|shallow");
//		list.add("not having strength, or walking unevenly|limp");
//		list.add("not often|seldom");
//		list.add("not proud; modest|humble");
//		list.add("Obvious; easy to see|apparent");
//		list.add("obvious|apparent");
//		list.add("of a time just before the present|recent");
//		list.add("of lesser importance or stature or rank|minor");
//		list.add("one who protects|guardian");
//		list.add("one's relatives|kin");
//		list.add("out-of-date, no longer in use|obsolete");
//		list.add("person who goes along with another|companion");
//		list.add("pleasing to the eye or mind|attractive");
//		list.add("polite and gracious; considerate toward others; well-mannered|courteous");
//		list.add("provide evidence for|demonstrate");
//		list.add("providing ease and comfort far beyond what is ordinary or necessary|luxurious");
//		list.add("ready for use, at hand|available");
//		list.add("ready to attack or start fights; acting in a hostile way|aggressive");
//		list.add("regular way of doing something|routine");
//		list.add("regular; normal; usual|typical");
//		list.add("relating to principles of right and wrong|moral");
//		list.add("restate (words) from one language into another language|translate");
//		list.add("ridiculous|absurd");
//		list.add("satisfied|content");
//		list.add("serving no useful purpose|pointless");
//		list.add("showing extreme courage|heroic");
//		list.add("showing great concentration or determination|intense");
//		list.add("showing greatness of character by unselfish behavior|noble");
//		list.add("showing signs of wear and tear|shabby");
//		list.add("sick to one's stomach; nauseated|queasy");
//		list.add("Simple; not fancy or extreme|modest");
//		list.add("skilled at tricking others|crafty");
//		list.add("slow and lazy|sluggish");
//		list.add("small; tiny|miniature");
//		list.add("someone from whom you are descended (but usually more remote than a grandparent)|ancestor");
//		list.add("someone who does things on his or her own|independent");
//		list.add("someone who tells a story|narrator");
//		list.add("Something difficult to accomplish|challenge");
//		list.add("something done that takes skill or effort|achievement");
//		list.add("something shown to the public|exhibit");
//		list.add("something that causes great damage or harm|disaster");
//		list.add("something that is a source of danger|threat");
//		list.add("something that is hard to bear; difficulty|hardship");
//		list.add("something that provides access; a way to get into something|entrance");
//		list.add("Strongly built|sturdy");
//		list.add("suitable for a particular person or place or condition|appropriate");
//		list.add("sure of yourself|confident");
//		list.add("Sympathy for another's suffering; pity|compassion");
//		list.add("take back; remove|withdraw");
//		list.add("the act of apprehending (especially apprehending a criminal)|arrest");
//		list.add("the act of making something (a product) from raw materials|manufacture");
//		list.add("the act of rising upward into the air|soar");
//		list.add("the outside layer; the top|surface");
//		list.add("The path that must be followed to get to a place|route");
//		list.add("the place where something begins, where it springs into being|source");
//		list.add("the power or skill to do something|ability");
//		list.add("the state of being held against one's will; loss of freedom|captivity");
//		list.add("the time of day immediately following sunset|dusk");
//		list.add("the top point of a mountain or hill|summit");
//		list.add("the underside of the foot|sole");
//		list.add("thinly scattered|sparse");
//		list.add("to aid; to help|assist");
//		list.add("to ask for|request");
//		list.add("To avoid, dodge|evade");
//		list.add("To be like or similar to.|resemble");
//		list.add("to be without|lack");
//		list.add("to beg|plead");
//		list.add("to buy|purchase");
//		list.add("To cause pain or sorrow; to trouble or worry.|distress");
//		list.add("to change from one form to another|convert");
//		list.add("to die|perish");
//		list.add("to discover something not easily noticed|detect");
//		list.add("to do as one is asked or ordered|comply");
//		list.add("to do something by making an effort; to complete successfully|accomplish");
//		list.add("to elevate, to increase in intensity|escalate");
//		list.add("to end the rule of; to defeat, often by using force|overthrow");
//		list.add("To examine carefully; study closely|analyze");
//		list.add("to expose to danger|endanger");
//		list.add("to express pleasure over someone's success|congratulate");
//		list.add("to finish|complete");
//		list.add("To focus all one's thoughts or efforts on.|concentrate");
//		list.add("to gain or receive good results from something|benefit");
//		list.add("to give orders|dictate");
//		list.add("To give what is needed; to supply|provide");
//		list.add("to give, along with others who are giving|contribute");
//		list.add("to go down|descend");
//		list.add("to go somewhere despite the risk of possible dangers|venture");
//		list.add("to have an extremely strong desire for something|crave");
//		list.add("to identify someone or something seen before|recognize");
//		list.add("to interest and amuse|entertain");
//		list.add("to irritate, annoy, or anger|exasperate");
//		list.add("to let go|release");
//		list.add("to light up; make clear|illuminate");
//		list.add("to make fun of in an insulting way|taunt");
//		list.add("to make fun of|mock");
//		list.add("To make known; to give or exchange information|communicate");
//		list.add("to make known|disclose");
//		list.add("to make less worried or fearful; to comfort|reassure");
//		list.add("to make or get ready|prepare");
//		list.add("to make up|compose");
//		list.add("to motivate, guide, or influence; to give hope and courage.|inspire");
//		list.add("to move or shift.|budge");
//		list.add("To move upward|ascend");
//		list.add("to move with a sliding, side-to-side motion of the body|slither");
//		list.add("To persuade or urge in a gentle way|coax");
//		list.add("to rule as a queen or king|reign");
//		list.add("to separate, divide into parts|sever");
//		list.add("To set aside for a certain purpose.|dedicate");
//		list.add("to shoot out quickly in a stream|spurt");
//		list.add("to show|indicate");
//		list.add("to stand for or in place of|represent");
//		list.add("to stop something from reaching its intended destination|intercept");
//		list.add("To stop working because one has reached a certain age|retire");
//		list.add("to stop; to put on hold|suspend");
//		list.add("to stroll; walk in an easy, leisurely way|saunter");
//		list.add("to surprise; to amaze|astound");
//		list.add("to take for granted; to suppose|assume");
//		list.add("to take or keep something away from someone|deprive");
//		list.add("To try; to make an effort|attempt");
//		list.add("to work or fight against|resist");
//		list.add("to work out by using arithmetic|calculate");
//		list.add("turn to stone; cause to become stonelike; stun or paralyze|petrify");
//		list.add("Type of performance space with audience surrounding all sides of the stage.|arena");
//		list.add("unclear, misty; not readily seen or understandable|hazy");
//		list.add("unusual, strange|peculiar");
//		list.add("values and beliefs passed from generation to generation|tradition");
//		list.add("very angry|furious");
//		list.add("very bad or serious|severe");
//		list.add("very great or very large|vast");
//		list.add("very hot and humid climate|tropical");
//		list.add("very large or great|immense");
//		list.add("very tired|weary");
//		list.add("very valuable|precious");
//		list.add("wildly excited|frantic");
//		list.add("without delay; happening at once|instant");
//		list.add("worried; concerned|anxious");
	}

}
