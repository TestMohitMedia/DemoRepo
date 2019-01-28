package com.utils.excelutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.StringProgram.DateFormat;

public class ExcelReaderUtil 
{
   public static String filename="./DataSet/test.xls";
   public FileInputStream fis=null;
   public String path;
   public FileOutputStream fileout=null;
   public HSSFWorkbook wb=null;
   public HSSFSheet sheet=null;
   public HSSFRow row=null;
   public HSSFCell cell = null;
   
   public ExcelReaderUtil(String path)
   {
	   this.path=path;
	   try {
		fis=new FileInputStream(path);
		wb=new HSSFWorkbook(fis);
		sheet=wb.getSheetAt(0);
		fis.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
   }
   // return the row count in a sheet
   public int getRowCount(String SheetName)
   {
	   int index=wb.getSheetIndex(SheetName);
	   if(index==-1)
		   return 0;
	   else{
		   sheet=wb.getSheetAt(index);
		   int number=sheet.getLastRowNum()+1;
		   return number;
	   }
   }
   public String getCellData(String sheetName,int cellName,int rowNum)
   {
	   if(rowNum<=0)
		   return "";
	   int index=wb.getSheetIndex(sheetName);
	   int col_Num=-1;
	   if(index==-1)
		   return "";
	   sheet=wb.getSheetAt(index);
	   row=sheet.getRow(0);
	   for(int i=0;i<row.getLastCellNum();i++)
		   if(row.getCell(i).getStringCellValue().trim().equals(cellName))
			   col_Num=i;
	   if(col_Num==-1)
		   return "";
	   sheet = wb.getSheetAt(index);
		row = sheet.getRow(rowNum-1);
		cell=row.getCell(col_Num);
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		if(cell.getCellType()==cell.CELL_TYPE_STRING)
			return cell.getStringCellValue();
		else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
			if(HSSFDateUtil.isCellDateFormatted(cell))
				return df.format(cell.getDateCellValue());
				else
			return String.valueOf(cell.getNumericCellValue());
		else
			return "";
   }
   
   
}
