package jtm.extra03;

import java.util.ArrayList;

public class PracticalNumbers {

	// TODO Read article https://en.wikipedia.org/wiki/Practical_number
	// Implement method, which returns practical numbers in given range
	// including

	public String getPracticalNumbers(int from, int to) {
		ArrayList<Integer> practicalNumbers = new ArrayList<Integer>();
		ArrayList<Integer> divisors = new ArrayList<Integer>();

		for (int i = from; i <= to; i++) {
			if (checkPracticalNumbers(i)) {
				practicalNumbers.add(i);
			}
		}
		StringBuilder temp = new StringBuilder();
		String delim = "[";

		for(int number : practicalNumbers){
			temp.append(delim).append(Integer.toString(number));
			delim = ", ";
		}
		temp.append(']');
		return temp.toString();
	}

	boolean checkPracticalNumbers(Integer number) {
		ArrayList<Integer> divisors = new ArrayList<Integer>();

		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				divisors.add(i);
			}
		}

		for (int i = number - 1; i > 0; i--) {
			int temp = i;
			for (int j = divisors.size() - 1; j >= 0; j--) {
				if (temp-divisors.get(j) > 0) {
					temp -= divisors.get(j);
				}
				else if (temp-divisors.get(j) == 0) {
					temp = 0;
					break;
				}
			}
			if (temp != 0)
				return false;
		}
		return true;
	}


}