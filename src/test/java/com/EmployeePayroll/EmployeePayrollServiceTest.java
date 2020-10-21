package com.EmployeePayroll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class EmployeePayrollServiceTest {

	@Test
	public void given3Employee_WhenWrittenToFile_ShouldMatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(1, "Sneha", 12000.0),
				new EmployeePayrollData(2, "Meena", 15000.0),
				new EmployeePayrollData(3, "Ritu", 20000.0),
		};
		EmployeePayrollService test;
		test = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		test.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		test.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries = test.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3, entries);
	
	}

}
