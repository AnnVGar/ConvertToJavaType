package main;

import java.io.File;

import core.convert.Convertor;
import core.convert.IConvertFactory;
import core.provide.IDataProvider;
import core.receive.IDataReceiver;
import impl.config.ConvertXMLConfig;
import impl.config.DBXMLConfig;
import impl.convert.ConvertFactory;
import impl.provide.DBProvider;
import impl.receive.ConsoleReceiver;

public class ConvertToJavaType {

	public static final String xmlConvertFilePath = "src" + File.separator + "convertConfig.xml";
	public static final String xmlDBFilePath = "src" + File.separator + "dbConfig.xml";

	public static void main(String[] args) {

		IConvertFactory convertFactory = new ConvertFactory(new ConvertXMLConfig(xmlConvertFilePath).getConfig());
		IDataProvider dataProvider = new DBProvider(new DBXMLConfig(xmlDBFilePath).getConfig());
		IDataReceiver dataReceiver = new ConsoleReceiver();

		Convertor convertor = new Convertor(convertFactory, dataProvider, dataReceiver);

		convertor.start();

	}

}