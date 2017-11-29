package library;

public interface AutoConst {
	public String xlPath = "./input1/data2.xlsx";
	public String imgPath = "C:\\Users\\shivm\\Desktop\\New folder\\ActiTIME1\\Image";
	public String CHROME_KEY = ExelLib.readExcel(xlPath,"Sheet2",1,0);
	public String CHROME_PATH = ExelLib.readExcel(xlPath,"Sheet2",1,1);
	
	
	
//	public String CHROME_PATH ="./Drivers/chromedriver.exe";
//	public String GECKO_KEY = "webdriver.gecko.driver";
//	public String GECKO_PATH= "./Drivers/geckodriver.exe";
	
}
