package com.classes;

import java.util.ArrayList;

import javax.sound.sampled.Line;

public class Size {

	private int Wkw= 1;
	private int Wid = 1;
	private int Wop =1;
	private int Wnv =1;
	private int Wsl =1;
	
	private String code;
	String keywrd[] = { "public","private","void",  "printf", "println", "cout", "cin", "if", "for","while", "do", "switch", "case" };
	String indentifiers[] = {"(", ";"};
	
	String operator[] = { "+","-","*", "/", "=","++", "--" ,"==","!>" ,"<" ,">" ,"<=" ,">=", "&&", "||" , "," , "."   };
	
	String numb[] = {"0", "1", "2", "3","4","5","6","7","8","9"};

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

	public void weights(int Wkw, int Wid, int Wop, int Wnv, int Wsl) {
		this.Wkw = Wkw;
		this.Wid = Wid;
		this.Wop = Wop;
		this.Wnv = Wnv;
		this.Wsl = Wsl;
		
	}

	
	public int[] getKeyWrds() {
		
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int j = 0;
		score[j]=0;

		for (String line : lines) {

			if (line.contains("class") || line.contains("public") ||line.contains("private")|| line.contains("void")
					|| line.contains("true") || line.contains("false") || line.contains("else")) {
				
				String[] words = line.split(" ");

				for (String word : words) {
					for (int i = 0; i < keywrd.length; i++) {
						if (keywrd[i] .equals(word))  {
							score[j] = score[j] + 1 * Wkw;
							break;
						} 

					}
				
				}
				j++;

			} else {
				score[j] = 0;
				j++;
			}
		}

		 return score;

	}

	public int[] getIdentifiers() {
		
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		
		int j = 0;
		score[j]=0;

		for (String line : lines) {

			if (line.contains("(") || line.contains(";")) {
				
				String[] words = line.split(" ");

				for (String word : words) {
					for (int i = 0; i < indentifiers.length; i++) {
						if (indentifiers[i] .equals(word))  {
							System.out.println(word);
							score[j] = score[j] + 1 * Wid;
							break;
						} 

					}
				
				}
				j++;

			} else {
				score[j] = 0;
				j++;
			}
		}

		 return score;
	}
	
	

	public String getMethod(String statement) {
		String newStr = statement;
		String method = null;
		String[] words = newStr.split(" ");
		
		if(statement.contains("public") ||statement.contains("private") || statement.contains("void")) 
		{
			for(String word :words) {
				if(word.contains("("))
				{
					method = word.substring(0, word.indexOf("(") +1);
					break;
				}
			}
			
		}
		return method;
		
	}
	
	public int[] ismethod(){
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int s =0;
		for(String line : lines) {
			String tline = line.trim();
			if(getMethod(tline) != null){
				score[s] = 1 * Wid;
				s++;
			}
			else
			{
				score[s] = 0;
				s++;
			}
			
		
		}
		return score;
	}
	
	
	public int[] getoperators() {

		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int j = 0;
		score[j]=0;

		for (String line : lines) {

			if (line.contains("=") 
					|| line.contains("+") 
					||line.contains("-")
					|| line.contains("/")
					|| line.contains("*") 
					|| line.contains("%") 
					|| line.contains("++")
					|| line.contains("--")
					|| line.contains("==")
					|| line.contains("!>")	
					|| line.contains("<")	
					|| line.contains(">")	
					|| line.contains("<=")
					|| line.contains(">=")
					|| line.contains("&&")
					|| line.contains("||")
					|| line.contains(",")
					|| line.contains(".")) {
				
				String[] words = line.split(" ");

				for (String word : words) {
					for (int i = 0; i < operator.length; i++) {
						if (operator[i] .equals(word))  {
							score[j] = score[j] + 1 * Wop;
							break;
						} 

					}
				
				}
				j++;

			} else {
				score[j] = 0;
				j++;
			}
		}

		 return score;

	}
	
	public String getstring(String statement) {
		String newStr = statement;
		String method = null;
		String[] words = newStr.split(" ");
		
		if(statement.contains("\" ")) 
		{
			for(String word :words) {
				if(word.contains("\""))
				{
					method = word.substring(0, word.indexOf("\"") +1);
					break;
				}
			}
			
		}
		return method;
		
	}
	
	
	
	
	public int[] isstring(){
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int s =0;
		for(String line : lines) {
			String tline = line.trim();
			if(getMethod(tline) != null){
				score[s] = 1 * Wsl;
				s++;
			}
			else
			{
				score[s] = 0;
				s++;
			}
			
		
		}
		return score;
		
		
	}
	
	
	public int[] getNumber() {
		
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int j = 0;
		score[j]=0;

		for (String line : lines) {

			if (line.contains("0") 
					|| line.contains("1") 
					||line.contains("2")
					|| line.contains("3")
					|| line.contains("4") 
					|| line.contains("5") 
					|| line.contains("6")
					|| line.contains("7")
					|| line.contains("8")
					|| line.contains("9")) {
				
				String[] words = line.split(" ");

				for (String word : words) {
					for (int i = 0; i < numb.length; i++) {
						if (numb[i] .equals(word))  {
							score[j] = score[j] + 1 * Wnv;
							break;
						} 

					}
				
				}
				j++;

			} else {
				score[j] = 0;
				j++;
			}
		}

		 return score;

	}
	
	
	
	
	public String getTable() {
		String[] lines = displayCode();
		int[] Nkw = getKeyWrds();
		int[] Nid = ismethod();
		int[] Nop = getoperators();
		int[] Nnv = getNumber();
		int[] nsl = isstring();
		
		String output = "";

		output = "<table border=\"1\">" + "<tr><th> Code Lines </th>" + "<th>Nkw</th>" +"<th>Nid</th>"+ "<th>Nop</th>" + "<th>Nnv</th>"
				+ "<th>Nsl</th>" + "<th>Cs</th></tr>";
		int i = 0;
		int j = lines.length;
		int blank = 0;
		while (j > 0) {
			output += "<tr><td>" + lines[i] + "</td>";
			output += "<td>" + Nkw[i] + "</td>";
			output += "<td>" + Nkw[i] + "</td>";
			output += "<td>" + Nop[i] + "</td>";
			output += "<td>" + Nnv[i] + "</td>";
			output += "<td>" + nsl[i] + "</td>";
			output += "<td>" +( Nkw[i] + Nnv[i] + Nkw[i] + Nop[i] + Nnv[i] + nsl[i] )+ "</td> </tr>";
			i++;
			j--;
		}
		output += "</table>";

		return output;

	}
	public int[] getToatalValue() {
		int[] tot = new int[6];
		String[] lines = displayCode();
		int[] Nkw = getKeyWrds();
		int[] Nid = ismethod();
		int[] Nop = getoperators();
		int[] Nnv = getNumber();
		int[] nsl = isstring();
			
		int totNkw = 0;
		int totNid =0;
		int totNop =0;
		int totNnv = 0;
		int totNsl =0;

		
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			totNkw = totNkw + Nkw[i];
			totNid = totNid + Nid[i];
			totNop = totNop + Nop[i];
			totNnv = totNnv + Nnv[i];
			totNsl = totNsl+nsl[i];
			System.out.println(totNkw);
			i++;
			j--;
		}
		tot[0] = totNkw ;
		tot[1] = totNid;
		tot[2] = totNop;
		tot[3] = totNnv;
		tot[4] = totNsl;

		
		return tot;
		
	}
	public int[] getcsValue() {
		String[] lines = displayCode();
		int[] cs = new int [lines.length];
		int[] Nkw = getKeyWrds();
		int[] Nid = ismethod();
		int[] Nop = getoperators();
		int[] Nnv = getNumber();
		int[] nsl = isstring();
		
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			cs[i] = Nkw[i] + Nid[i] + Nop[i] + Nnv[i] + nsl[i];
			i++;
			j--;		
		}
		return cs;
	}

	

}
