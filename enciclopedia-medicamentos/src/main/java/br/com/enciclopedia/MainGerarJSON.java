package br.com.enciclopedia;

import java.io.File;

import org.json.JSONObject;
import org.json.XML;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class MainGerarJSON {

	public static void main(String[] args) {
//		XStream x = new XStream();
//
//		Object obj = x.fromXML(new File("C:\\Users\\Luiz\\Downloads\\AnoAtual.xml"));
//
//		System.out.println(obj);

		JSONObject json = XML.toJSONObject("");

		System.out.println(json);
	}

}
