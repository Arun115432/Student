package com.imaginnovate.utils;

import com.imaginnovate.model.StudentMarks;

public class StudentDetailsValidator {

	public static boolean isValidAge(int age) {
		if (age < 10)
			return false;

		return true;

	}
	
	public static boolean isValidMark(StudentMarks studentMarks) {
		if (studentMarks.getMath() > 100|| studentMarks.getScience()>100||studentMarks.getEnglish()>100)
			return false;

		return true;

	}

}
