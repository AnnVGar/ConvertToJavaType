package core.convert;

import java.util.Map;

import core.provide.IDataProvider;
import core.receive.IDataReceiver;

public class Convertor {
	private final Map<Integer, IConvertToType<?>> convertMapping;
	private final IDataProvider dataProvider;
	private final IDataReceiver dataReceiver;

	public Convertor(IConvertFactory factory, IDataProvider dataProvider, IDataReceiver dataReceiver) {
		this.convertMapping = factory.getConvertMap();
		this.dataProvider = dataProvider;
		this.dataReceiver = dataReceiver;
	}

	public void convertData(DataToConvert data) {
		if (!convertMapping.containsKey(data.getType())) {
			System.err.println("Convert for dataType =  " + data.getType() + " is undefined");
			return;
		}
		System.out.println();
		System.out.println(data);
		try {
			dataReceiver.receiveData(convertMapping.get(data.getType()).convert(data.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		dataProvider.getData().forEach(t -> convertData(t));

	}

}
