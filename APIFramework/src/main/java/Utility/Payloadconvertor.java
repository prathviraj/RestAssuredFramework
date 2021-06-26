package Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Payloadconvertor {
	//Basically to convert the body into string
	public static String genericpayloadstring(String filename) throws IOException
	{
		//String filepath = "C:\\Users\\PrathvirajMeenkeri\\Rest-Assured\\APIFramework\\resources\\" + filename;
		String filepath =System.getProperty("user.dir")+"\\resource\\"+ filename;
		//System.out.println(filepath);
		return new String(Files.readAllBytes(Paths.get(filepath)));
	}

}
