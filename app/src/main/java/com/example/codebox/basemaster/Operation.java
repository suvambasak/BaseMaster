package com.example.codebox.basemaster;

public class Operation {
	//index and output variable.
	int i=0;
	String out="";
	String[] part;

	private void partition(String number, String s){
		part = number.split(s);

		if(part[0].length() != part[1].length()) {
			if (part[0].length() < part[1].length()) {
				int size = part[1].length() - part[0].length();
				while (size-- > 0) {
					part[0] = "0" + part[0];
				}
			}
			if (part[0].length() > part[1].length()) {
				int size = part[0].length() - part[1].length();
				while (size-- > 0) {
					part[1] = "0" + part[1];
				}
			}
		}
	}


	//Binary AND operation.
	public String and(String number){
		partition(number,"&");

		int i=0, size = part[1].length();
		String op = "";

		while(i < size){
			op = op + (Character.getNumericValue(part[0].charAt(i)) & Character.getNumericValue(part[1].charAt(i)));
			i++;
		}
		return op;
	}


	//Binary OR operation.
	public String or(String number){
		partition(number,"v");
		int i=0, size = part[1].length();
		String op = "";
		while(i < size){
			op = op + (Character.getNumericValue(part[0].charAt(i)) | Character.getNumericValue(part[1].charAt(i)));
			i++;
		}
		return op;
	}

	//Binary XOR operation.
	public String xor(String number){
		partition(number,"x");
		int i=0, size = part[1].length();
		String op = "";

		while(i < size){
			op = op + (Character.getNumericValue(part[0].charAt(i)) ^ Character.getNumericValue(part[1].charAt(i)));
			i++;
		}
		return op;
	}

	//Binary NOT operation.
	public String binaryNot(String number){
		int s = number.length();
		while(i < s){
			if(number.charAt(i) == '1')
				out = out + "0";
			else if (number.charAt(i) == '0')
				out = out + "1";
			i++;
		}
		return out;
	}

}