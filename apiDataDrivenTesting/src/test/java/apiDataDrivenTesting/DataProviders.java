package apiDataDrivenTesting;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	@DataProvider
	public Object[][]  ExceldataProvider() throws IOException {
		String path = ".\\testData\\orders_excel_data.xlsx";
		ExcelUtils x1 = new ExcelUtils(path,"Sheet1");
		
		int rowcount = x1.getRowCount();
		int colcount = x1.getCellCount(1);
		Object[][] dataArray = new Object[rowcount][colcount];
		
		for(int i=1;1<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				dataArray[i-1][j]=x1.getCellData(i, j);
			}
		}
	
		return dataArray;
		
	}
}
