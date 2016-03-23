package test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelWorkBook {
	//利用list集合来存放数据，其类型为String
	private List<String> list= new ArrayList<String>();
	//通过Workbook方式来读取excel
	Workbook book;
	String username;
	String sourceFile="/Users/zhouxin/Downloads/生鲜测试点完整版5.xlsx";
	/*
	* 获取excel文件第一列的值，这里取得值为username
	*/
	public List<String> readUsername(String sourceString) throws IOException,Exception{
		List<String> userList = new ArrayList<String>();
	try {
	Workbook book =Workbook.getWorkbook(new File(sourceFile));
	Sheet sheet=book.getSheet(0);
	//获取文件的行数
	int rows=sheet.getRows();
	//获取文件的列数
	int cols=sheet.getColumns();
	//获取第一行的数据，一般第一行为属性值，所以这里可以忽略
	String col1=sheet.getCell(0,0).getContents().trim();
	String col2=sheet.getCell(1,0).getContents().trim();
	System.out.println(col1+","+col2);
	//把第一列的值放在userlist中
	for(int z=1;z<rows ;z++){
	String username=sheet.getCell(0,z).getContents();
	userList.add(username);
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	//把获取的值放回出去，方便调用
	return userList;
	}
	/*
	* 获取excel文件第二列的值，这里取得值为password
	*/
	public List<String> readPassword(String sourceString) throws IOException,Exception{
	List<String> passList = new ArrayList<String>();
	try {
	Workbook book =Workbook.getWorkbook(new File(sourceFile));
	Sheet sheet=book.getSheet(0);
	int rows=sheet.getRows();
	for(int z=1;z<rows ;z++){
	String password=sheet.getCell(1,z).getContents();
	passList.add(password);
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return passList;
	}
	public List<String> getList(){
	return list;
	}

	

}
