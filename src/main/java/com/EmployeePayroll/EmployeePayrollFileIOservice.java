package com.EmployeePayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOservice {
	public static String PAYROLL_FILE_NAME = "payroll-file.txt";

	public void writeData(List<EmployeePayrollData> employeePayrollList) {
		StringBuffer empBuffer =  new StringBuffer();
		employeePayrollList.forEach(employee -> {
			String employeeString = employee.toString().concat("\n");
			empBuffer.append(employeeString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * print the data
	 */
	public void printData() {
		try {
			Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * count the input entries
	 * @return
	 */
	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File("payroll-file.txt").toPath()).count();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return entries;
	}




}
