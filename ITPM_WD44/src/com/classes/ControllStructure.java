package com.classes;

import java.io.Console;
import java.util.ArrayList;
import java.util.Stack;
import com.servlet.codeServlet;

public class ControllStructure {

	private String code;
	
	private int weightIf = 2;
	private int weightCase = 1;
	private int weightFor = 3;	
	
	public void weights(int weightIf,int weightCase,int weightFor) {
		this.weightIf = weightIf;
		this.weightCase = weightCase;
		this.weightFor=weightFor;
	
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public String[] displayCode() {

		String[] lines = getCode().split("\\r?\\n");
		for (String line : lines) {
			String tLine = line.trim();
		}

		return lines;
	}

	public static boolean hasaBracket(String line, String text, int size, int gap) {
		boolean val = false;
		if (line.length() > (line.indexOf(text) + size + gap)) {
			if (line.charAt(line.indexOf(text) + size + gap) == '(') {
				val = true;
			} else if (line.charAt(line.indexOf(text) + size + gap) == ' ') {
				gap = gap + 1;
				return hasaBracket(line, text, size, gap);
			} else {
				val = false;
			}
		}
		return val;
	}

	public static boolean forDoMEthod(String line, String text, int size, int gap) {
		boolean val = true;
		if (line.length() > (line.indexOf(text) + size + gap)) {
			if (line.charAt(line.indexOf(text) + size + gap) == ' ') {
				val = true;
				gap = gap + 1;
				return forDoMEthod(line, text, size, gap);
			} else {
				val = false;
			}
		}
		return val;
	}

	public static boolean hasaCurlyBracket(String line, String text, int size, int gap) {
		boolean val = false;
		if (line.length() > (line.indexOf(text) + size + gap)) {
			if (line.charAt(line.indexOf(text) + size + gap) == '{') {
				val = true;
			} else if (line.charAt(line.indexOf(text) + size + gap) == ' ') {
				gap = gap + 1;
				return hasaCurlyBracket(line, text, size, gap);
			} else {
				val = false;
			}
		}
		return val;
	}

	public int[] getWeight() {

		String[] lines = code.split("\\r?\\n");

		int[] weight = new int[lines.length];
		int w = 0;
		weight[w] = 0;

		for (String line : lines) {

			String tline = line;

			if (tline.contains("if") && (hasaBracket(tline, "if", 2, 0))
					|| tline.contains("else if") && (hasaBracket(tline, "else if", 7, 0))
					|| tline.contains("switch") && (hasaBracket(tline, "switch", 6, 0))) {
				weight[w] = weightIf;
				w++;

			}

			else if (tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0))
					|| tline.contains("while") && (hasaBracket(tline, "while", 5, 0))
					|| tline.contains("for") && (hasaBracket(tline, "for", 3, 0))) {
				weight[w] = weightFor;
				w++;

			}

			else if (tline.contains("case") && tline.contains(":")) {
				weight[w] = weightCase;
				w++;

			}

			else {
				weight[w] = 0;
				w++;
			}
		}

		return weight;

	}

	public int[] countCon() {

		char opArray[] = { '<', '>', '=', '!' };

		String[] lines = code.split("\\r?\\n");

		int[] score = new int[lines.length];
		int nc = 0;
		int s = 0;
		score[s] = 0;
		String seq = new String(opArray);

		for (String line : lines) {

			String tline = line;
			int count = 0;

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| (tline.contains("case ") && tline.contains(":"))) {

				for (int y = 0; y < tline.length() - 1; y++) {

					if (tline.charAt(y) == '&') {
						count++;
						if (tline.charAt(y + 1) == '&')
							count--;
					}
				}
				for (int z = 0; z < tline.length() - 1; z++) {

					if (tline.charAt(z) == '|') {
						count++;
						if (tline.charAt(z + 1) == '|')
							count--;
					}

				}

				nc = count + 1;

				score[s] = nc;
				s++;

			} else {
				score[s] = 0;
				s++;
			}

		}

		return score;

	}

	public String getTable() {

		String[] lines = displayCode();

		int[] weight = getWeight();
		int[] count2 = countCon();
		int weight2 = 0;
		int nc = 0;
		int n = 0;

		// boolean thireisstatement =false;
		int[] ccs = new int[lines.length];
		int[] ccsppslast = new int[lines.length];
		int[] ccspps = new int[lines.length];
		int s = 0;
		int k = 0;
		int l = 0;
		ccs[s] = 0;

		ccspps[k] = 0;
		int brack = 0;
		int nested = 0;
		ccsppslast[l] = 0;
		for (String line : lines) {

			String tline = line;
			System.out.println(tline);
			if (tline.contains("if") && (hasaBracket(tline, "if", 2, 0))
					|| tline.contains("else if") && (hasaBracket(tline, "else if", 7, 0))
					|| tline.contains("switch") && (hasaBracket(tline, "switch", 6, 0))) {
				weight2 = weightIf;
			}

			else if ((tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))
					|| tline.contains("while") && (hasaBracket(tline, "while", 5, 0))
					|| tline.contains("for") && (hasaBracket(tline, "for", 3, 0))) {
				weight2 = weightFor;
			}

			else if (tline.contains("case") && (tline.contains(":"))) {
				weight2 = weightCase;

			}

			else {
				weight2 = 0;

			}
			if (tline.contains("{")) {
				brack++;
			}
			if (tline.contains("}")) {
				brack--;
				nested--;
			}

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| (tline.contains("else")
							&& (forDoMEthod(tline, "else", 4, 0) || hasaCurlyBracket(tline, "else", 4, 0)))
					|| (tline.contains("do")
							&& (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))) {
				nested++;

			}
			if (nested == 1) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 1;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 2;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}

			}

			else if (nested == 2) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 2;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 3;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else if (nested == 3) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 3;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 4;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else {
				ccspps[k] = 0;
				k++;
			}

			int count = 0;

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| ((tline.contains("case ") && tline.contains(":")))) {

				for (int y = 0; y < tline.length() - 1; y++) {

					if (tline.charAt(y) == '&') {
						count++;
						if (tline.charAt(y + 1) == '&')
							count--;
					}
				}
				for (int z = 0; z < tline.length(); z++) {

					if (tline.charAt(z) == '|') {
						count++;
						if (tline.charAt(z + 1) == '|')
							count--;
					}

				}

				nc = count + 1;

				ccs[s] = nc * weight2;
				s++;
			} else {
				ccs[s] = 0;

				s++;
			}
		}

		int first = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;

		for (int i = 0; i < ccspps.length; i++) {
			if (ccspps[i] == 1) {
				first = i;
				System.out.println("1 " + i);
				for (int g = (i + 1); g < ccspps.length; g++) {
					if (ccspps[g] == 1) {
						break;
					} else if (ccspps[g] == 2) {
						second = g;
						System.out.println("2 " + g);
						if (first < second) {
							ccs[second] = ccs[second] + ccs[first];
							ccsppslast[second] = ccs[first];
						}
						for (int h = (g + 1); h < ccspps.length; h++) {
							if (ccspps[h] == 1) {
								break;
							} else if (ccspps[h] == 2) {
								break;
							} else if (ccspps[h] == 3) {
								third = h;
								System.out.println("3 " + h);
								if (second < third) {
									ccs[third] = ccs[third] + ccs[second];
									ccsppslast[third] = ccs[second];
								}
								for (int x = (h + 1); x < ccspps.length; x++) {
									if (ccspps[x] == 1) {
										break;
									} else if (ccspps[x] == 2) {
										break;
									} else if (ccspps[x] == 3) {
										break;
									} else if (ccspps[x] == 4) {
										fourth = x;
										System.out.println("4 " + x);
										if (third < fourth) {
											ccs[fourth] = ccs[fourth] + ccs[third];
											ccsppslast[fourth] = ccs[third];
										}
									}

								}
							}

						}
					}

				}

			}


		String output = "";
		output = "<div class='table-responsive text-center'><table class= 'table table-hover' border='1'>" + "<thead class='black white-text'><tr><th>Code Lines</th><th>Wtcs</th><th>NC</th><th>Ccspps</th><th>Ccs</th>";

		int i = 0;
		int j = lines.length;
		while (j > 0) {

			output += "<tr><td>" + lines[i] + "</td>";
			output += "<td>" + weight[i] + "</td>";
			output += "<td>" + count2[i] + "</td>";
			output += "<td>" + ccsppslast[i] + "</td>";
			output += "<td>" + ccs[i] + "</td></tr>";

			i++;
			j--;
		}
		
			output += "</table></div>";
		}

		return output;

	}
	public int[] gettotalValue() {
		int[] tot = new int[3];
		String[] lines = displayCode();

		int[] weight = getWeight();
		int[] count2 = countCon();
		int weight2 = 0;
		int nc = 0;
		int n = 0;

		int[] ccs = new int[lines.length];
		int[] ccsppslast = new int[lines.length];
		int[] ccspps = new int[lines.length];
		int s = 0;
		int k = 0;
		int l = 0;
		ccs[s] = 0;

		ccspps[k] = 0;
		int brack = 0;
		int nested = 0;
		ccsppslast[l] = 0;
		for (String line : lines) {

			String tline = line;
			System.out.println(tline);
			if (tline.contains("if") && (hasaBracket(tline, "if", 2, 0))
					|| tline.contains("else if") && (hasaBracket(tline, "else if", 7, 0))
					|| tline.contains("switch") && (hasaBracket(tline, "switch", 6, 0))) {
				weight2 = weightIf;


			}

			else if ((tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))
					|| tline.contains("while") && (hasaBracket(tline, "while", 5, 0))
					|| tline.contains("for") && (hasaBracket(tline, "for", 3, 0))) {
				weight2 = weightFor;


			}

			else if (tline.contains("case") && (tline.contains(":"))) {
				weight2 = weightCase;

			}

			else {
				weight2 = 0;

			}
			if (tline.contains("{")) {
				brack++;
			}
			if (tline.contains("}")) {
				brack--;
				nested--;
			}


			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| (tline.contains("else")
							&& (forDoMEthod(tline, "else", 4, 0) || hasaCurlyBracket(tline, "else", 4, 0)))
					|| (tline.contains("do")
							&& (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))) {
				nested++;

			}
			if (nested == 1) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 1;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 2;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}

			}

			else if (nested == 2) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 2;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 3;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else if (nested == 3) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 3;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 4;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else {
				ccspps[k] = 0;
				k++;
			}

			int count = 0;

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| ((tline.contains("case ") && tline.contains(":")))) {

				for (int y = 0; y < tline.length() - 1; y++) {

					if (tline.charAt(y) == '&') {
						count++;
						if (tline.charAt(y + 1) == '&')
							count--;
					}
				}
				for (int z = 0; z < tline.length(); z++) {

					if (tline.charAt(z) == '|') {
						count++;
						if (tline.charAt(z + 1) == '|')
							count--;
					}

				}

				nc = count + 1;

				ccs[s] = nc * weight2;
				s++;
			} else {
				ccs[s] = 0;

				s++;
			}
		}

		int first = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;

		for (int i = 0; i < ccspps.length; i++) {
			if (ccspps[i] == 1) {
				first = i;
				System.out.println("1 " + i);
				for (int g = (i + 1); g < ccspps.length; g++) {
					if (ccspps[g] == 1) {
						break;
					} else if (ccspps[g] == 2) {
						second = g;
						System.out.println("2 " + g);
						if (first < second) {
							ccs[second] = ccs[second] + ccs[first];
							ccsppslast[second] = ccs[first];
						}
						for (int h = (g + 1); h < ccspps.length; h++) {
							if (ccspps[h] == 1) {
								break;
							} else if (ccspps[h] == 2) {
								break;
							} else if (ccspps[h] == 3) {
								third = h;
								System.out.println("3 " + h);
								if (second < third) {
									ccs[third] = ccs[third] + ccs[second];
									ccsppslast[third] = ccs[second];
								}
								for (int x = (h + 1); x < ccspps.length; x++) {
									if (ccspps[x] == 1) {
										break;
									} else if (ccspps[x] == 2) {
										break;
									} else if (ccspps[x] == 3) {
										break;
									} else if (ccspps[x] == 4) {
										fourth = x;
										System.out.println("4 " + x);
										if (third < fourth) {
											ccs[fourth] = ccs[fourth] + ccs[third];
											ccsppslast[fourth] = ccs[third];
										}
									}

								}
							}

						}
					}

				}

			}



		}


		int totWeigth = 0;
		int totCount = 0;
		int totccppslast = 0;
		int i = 0;
		int j = lines.length;
		while (j > 0) {

			
			totWeigth=totWeigth + weight[i];
			totCount=totCount + count2[i] ;
			totccppslast=totccppslast + ccsppslast[i];
			

			i++;
			j--;
		}
		tot[0] = totWeigth;
		tot[1] = totCount;
		tot[2] = totccppslast;
		
		


		return tot;
	}
	public int[] getccsValue() {
		String[] lines = displayCode();
		int[] CCS = new int [lines.length];	
		int[] weight = getWeight();
		int[] count2 = countCon();
		int weight2 = 0;
		int nc = 0;
		int n = 0;

		
		int[] ccs = new int[lines.length];
		int[] ccsppslast = new int[lines.length];
		int[] ccspps = new int[lines.length];
		int s = 0;
		int k = 0;
		int l = 0;
		ccs[s] = 0;

		ccspps[k] = 0;
		int brack = 0;
		int nested = 0;
		ccsppslast[l] = 0;
		for (String line : lines) {

			String tline = line;
			System.out.println(tline);
			if (tline.contains("if") && (hasaBracket(tline, "if", 2, 0))
					|| tline.contains("else if") && (hasaBracket(tline, "else if", 7, 0))
					|| tline.contains("switch") && (hasaBracket(tline, "switch", 6, 0))) {
				weight2 = weightIf;

			
			}

			else if ((tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))
					|| tline.contains("while") && (hasaBracket(tline, "while", 5, 0))
					|| tline.contains("for") && (hasaBracket(tline, "for", 3, 0))) {
				weight2 = weightFor;

			
			}

			else if (tline.contains("case") && (tline.contains(":"))) {
				weight2 = weightCase;

			}

			else {
				weight2 = 0;

			}
			if (tline.contains("{")) {
				brack++;
			}
			if (tline.contains("}")) {
				brack--;
				nested--;
			}

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| (tline.contains("else")
							&& (forDoMEthod(tline, "else", 4, 0) || hasaCurlyBracket(tline, "else", 4, 0)))
					|| (tline.contains("do")
							&& (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0)))) {
				nested++;

			}
			if (nested == 1) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 1;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 2;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}

			}

			else if (nested == 2) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 2;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 3;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else if (nested == 3) {
				if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
						|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
						|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
						|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
						|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))) {

					ccspps[k] = 3;
					k++;
				} else if (((tline.contains("case") && tline.contains(":")))) {
					ccspps[k] = 4;
					k++;
				} else {
					ccspps[k] = 0;
					k++;
				}
			} else {
				ccspps[k] = 0;
				k++;
			}

			int count = 0;

			if ((tline.contains("if") && hasaBracket(tline, "if", 2, 0))
					|| (tline.contains("else if") && hasaBracket(tline, "else if", 7, 0))
					|| (tline.contains("while") && hasaBracket(tline, "while", 5, 0))
					|| tline.contains("do") && (forDoMEthod(tline, "do", 2, 0) || hasaCurlyBracket(tline, "do", 2, 0))
					|| (tline.contains("for") && hasaBracket(tline, "for", 3, 0))
					|| (tline.contains("switch") && hasaBracket(tline, "switch", 6, 0))
					|| ((tline.contains("case ") && tline.contains(":")))) {

				for (int y = 0; y < tline.length() - 1; y++) {

					if (tline.charAt(y) == '&') {
						count++;
						if (tline.charAt(y + 1) == '&')
							count--;
					}
				}
				for (int z = 0; z < tline.length(); z++) {

					if (tline.charAt(z) == '|') {
						count++;
						if (tline.charAt(z + 1) == '|')
							count--;
					}

				}

				nc = count + 1;

				ccs[s] = nc * weight2;
				s++;
			} else {
				ccs[s] = 0;

				s++;
			}
		}

		int first = 0;
		int second = 0;
		int third = 0;
		int fourth = 0;

		for (int i = 0; i < ccspps.length; i++) {
			if (ccspps[i] == 1) {
				first = i;
				System.out.println("1 " + i);
				for (int g = (i + 1); g < ccspps.length; g++) {
					if (ccspps[g] == 1) {
						break;
					} else if (ccspps[g] == 2) {
						second = g;
						System.out.println("2 " + g);
						if (first < second) {
							ccs[second] = ccs[second] + ccs[first];
							ccsppslast[second] = ccs[first];
						}
						for (int h = (g + 1); h < ccspps.length; h++) {
							if (ccspps[h] == 1) {
								break;
							} else if (ccspps[h] == 2) {
								break;
							} else if (ccspps[h] == 3) {
								third = h;
								System.out.println("3 " + h);
								if (second < third) {
									ccs[third] = ccs[third] + ccs[second];
									ccsppslast[third] = ccs[second];
								}
								for (int x = (h + 1); x < ccspps.length; x++) {
									if (ccspps[x] == 1) {
										break;
									} else if (ccspps[x] == 2) {
										break;
									} else if (ccspps[x] == 3) {
										break;
									} else if (ccspps[x] == 4) {
										fourth = x;
										System.out.println("4 " + x);
										if (third < fourth) {
											ccs[fourth] = ccs[fourth] + ccs[third];
											ccsppslast[fourth] = ccs[third];
										}
									}

								}
							}

						}
					}

				}

			}



		}


		
		int i = 0;
		int j = lines.length;
		while (j > 0) {

			
			 CCS[i] =  ccs[i] ;
			

			i++;
			j--;
		}		
		return CCS;
	}

}
