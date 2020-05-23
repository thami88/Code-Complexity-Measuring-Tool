package com.classes;

import com.servlet.codeServlet;
import com.sun.org.apache.xpath.internal.operations.Variable;

public class AllFactors {

	private String code;	
	int[] ccsValue;
	int[] csValue;
	int[] cvValue;
	
	int totccsValue = 0;
	int totcsValue =0;
	int totcvValue = 0;

	public void getCCSValue() {
		ControllStructure cnts = new ControllStructure();
		cnts.setCode(code);
		ccsValue = cnts.getccsValue();
		
	}
	public void getCSValue() {
		Size si = new Size();
		si.setCode(code);
		csValue = si.getcsValue();
		
	}
	public void getCVValue() {
		variable va = new variable();
		va.setCode(code);
		cvValue = va.getcvValue();
		
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String gettable() {
		getCCSValue();
		getCSValue();
		getCVValue();
		String output = "";
		String test = "0";
		String[] lines = code.split("\\r?\\n");
		int totCCS = 0;		
		int totCS = 0;
		int totCV = 0;
		int total = 0;
		
		output = "<div class='table-responsive text-center'> <table class= 'table table-hover' border='1'>"
				+ "<thead class='black white-text'><tr><th>Line NO.</th><th >Code Lines</th><th>Cs</th><th>Cv</th><th>Ci</th><th>Ccs</th><th>TCPS</th></tr>";
		int i = 0;
		int k = 1;
		int j = lines.length;
		while(j > 0) {
			
			totCCS = totCCS + ccsValue[i];
			totCS = totCS + csValue[i];
			totCV = totCV + cvValue[i];
			
			output += "<tr><th>" + k++ + "</th>";
			output += "<td>" + lines[i] + "</td>";
			output += "<td>" + csValue[i] + "</td>";
			output += "<td>" + cvValue[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + ccsValue[i] + "</td>";
			output += "<td>" + ( ccsValue[i] + csValue[i] + cvValue[i]) + "</td></tr>";
			i++;
			j--;
		}
		
		total =  totCCS + totCS + totCV;
		
		output += "<tr><th></th>";
		output += "<th>" +"TOTAL"+"</th>";
		output += "<th>" +totCS+"</th>";
		output += "<th>" +totCV+"</th>";
		output += "<th>" +test+"</th>";
		output += "<th>" +totCCS+"</th>";
		output += "<th>" +total+"</th></tr>";
		
		output += "</table></div>"; 
		return output;
	}
	
 // Control Structure /=======================================	
		public void getTotCCS() {
			
			ControllStructure cnts = new ControllStructure();
			cnts.setCode(code);
			ccsValue = cnts.getccsValue();
			String[] lines = code.split("\\r?\\n");
			int i = 0;
			int j = lines.length;
			while(j > 0) {				
				totccsValue = totccsValue + ccsValue[i];
				i++;
				j--;
			}
		
	}
		public void getTotCS() {
			
			Size si = new Size();
			si.setCode(code);
			csValue = si.getcsValue();
			String[] lines = code.split("\\r?\\n");
			int i = 0;
			int j = lines.length;
			while(j > 0) {
				totcsValue = totcsValue + csValue[i];
				i++;
				j--;
			}
		
	}

		public void getTotCV() {
	
			variable va = new variable();
			va.setCode(code);
			cvValue = va.getcvValue();
			String[] lines = code.split("\\r?\\n");
			int i = 0;
			int j = lines.length;
			while(j > 0) {
				totcvValue = totcvValue + cvValue[i];
				i++;
				j--;
	}

}
	
	public int[] gettotalValue() {
		
		getTotCCS();
		getTotCS();
		getTotCV();
		int[] tot = new int[4];
		tot[0] = totcsValue;
		tot[1] = totcvValue;
		tot[2] = 0;
		tot[3] = totccsValue;		
		//System.out.println(totccpValue);
		return tot;
	}
}
