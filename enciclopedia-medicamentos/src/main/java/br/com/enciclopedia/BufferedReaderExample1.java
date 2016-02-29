package br.com.enciclopedia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;

public class BufferedReaderExample1 {
	public static void main(String[] args) throws Exception {

		try {
			// Open input stream for reading the text file MyTextFile.txt
			InputStream is = new FileInputStream("C:\\Users\\Luiz\\Downloads\\AnoAnterior.xml");

			// create new input stream reader
			InputStreamReader instrm = new InputStreamReader(is);

			// Create the object of BufferedReader object
			BufferedReader br = new BufferedReader(instrm);

			String strLine;
			String content = "";
			// Read one line at a time
			while ((strLine = br.readLine()) != null) {
				if (content == "") {
					content = strLine;
				}
				// Print line
			}
			System.out.println(content.substring(0, 100));
			//content = content.replaceAll(" ", "");
			System.out.println(content.substring(0, 100));

			//JSONObject json = XML.toJSONObject(content);
			 byte[] lines = Files.readAllBytes(Paths.get("C:\\Users\\Luiz\\Downloads\\AnoAtual.xml"));
			
			System.out.println(new String(lines).substring(0, 200));
			
			//Files.write(Paths.get("C:\\Users\\Luiz\\Downloads\\AnoAtual.json"), json.toString().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}