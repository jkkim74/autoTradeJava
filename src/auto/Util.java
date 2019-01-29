package auto;

import java.io.FileReader;
import java.util.List;

import org.json.simple.parser.JSONParser;

public class Util {
	 public static void execTrade() {
	    try 
	    {
	      List<String> result_list = getBuyStockList("D:/util/autoTrade_new/project/step-4/buy_stock.json");
	      System.out.println("###### buy stock ######");
	      System.out.println(result_list);
	      for(String stock : result_list){
		      String command = "cmd.exe /c start D:/util/autoTrade_new/project/step-4/auto.bat "+stock;
		      //String[] command = {"cmd.exe /c start python","D:/util/autoTrade_new/project/step-4/pytrader.py","006920"};
		      Runtime.getRuntime().exec(command);
		      
		      Thread.sleep(10000);
	      }
	    }
	    catch (Exception err) {
	      err.printStackTrace();
	    }
	 }
	 
	 private static List<String> getBuyStockList(String filePath)
				throws java.io.IOException{
	 JSONParser parser = new JSONParser();
	 List<String> result_list = null;
	 try {
		  Object obj = parser.parse(new FileReader(filePath));
		  result_list = (List<String>) obj;
		 
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 return result_list;
}

}
