package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		
		//get test data from excel
        Xls_Reader reader = new Xls_Reader("D:\\HSSCM21\\Automation\\src\\com\\qa\\testdata\\HalfEbayTestData.xlsx");
        int rowCount = reader.getRowCount("RegTestData");
        
        reader.addSheet("HomePage");
	}

}
