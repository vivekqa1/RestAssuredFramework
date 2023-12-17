package com.api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "UserData")
	public String[][] getAllData() throws IOException {

		String path = System.getProperty("user.dir") + "//TestData//Userdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);

		int rownum = xl.getRowCount("Sheet 1");
		System.out.println(rownum);
		int colcount = xl.getCellCount("Sheet 1", 1);
		System.out.println(colcount);
		String apidata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < colcount; j++) {

				apidata[i - 1][j] = xl.getCellData("Sheet 1", i, j);
			}
		}
		System.out.println(apidata[0][0]);

		return apidata;
	}

	@DataProvider(name = "UserNames")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir") + "//TestData//Userdata.xlsx";
		ExcelUtility xl = new ExcelUtility(path);

		int rownum = xl.getRowCount("Sheet 1");

		String apidata[] = new String[rownum];

		for (int i = 1; i <= rownum; i++) {
				
			apidata[i-1] = xl.getCellData("Sheet 1", i, 1);
		}
		return apidata;
	}

}
