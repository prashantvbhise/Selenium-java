package common;

import java.io.IOException;

public class KillProcess {

	public static void main(String[] args) {
		
		try {
			Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe /T");
			Runtime.getRuntime().exec("TASKKILL /F /IM chromedriver.exe  /T");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
