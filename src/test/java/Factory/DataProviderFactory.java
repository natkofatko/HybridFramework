package Factory;

import DataProvider.ConfigDataProvider;
import DataProvider.ExcelDataProvider;

public class DataProviderFactory {

	public static ConfigDataProvider getCOnfig()
	{
	ConfigDataProvider config1 = new ConfigDataProvider(); 
			return config1; 
	}

	public static ExcelDataProvider getExcel ()
	{
		ExcelDataProvider Excel = new ExcelDataProvider(); 
		return Excel; 
			
	}

	

}
