package com.opencart.utils;

import java.util.ArrayList;

public class ReadExcelFile {
	

	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getExcelData()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try
		{
			reader = new Xls_Reader("./DataSheet/opencart_data.xlsx");
		}
		catch(Exception e)
		{
			
		}
		
		for(int i=2;i<=reader.getRowCount("sheet1");i++)
		{
			String fname=reader.getCellData("sheet1", "fname", i);
			String lname=reader.getCellData("sheet1", "lname", i);
			String email=reader.getCellData("sheet1", "email", i);
			String phno=reader.getCellData("sheet1", "phno", i);
			String pass1=reader.getCellData("sheet1", "pass1", i);
			String pass2=reader.getCellData("sheet1", "pass2", i);
			
			myData.add(new Object[] {fname,lname,email,phno,pass1,pass2});
			
		}
		return myData;
	}
	
}	


	



