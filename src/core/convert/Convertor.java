package core.convert;

import java.util.Map;

import core.exception.IncorrectDataException;
import core.exception.PermissibleErrorException;
import core.exception.TooLargeNumberException;
import core.exception.UndefinedConvertException;
import core.provide.IDataProvider;
import core.receive.IDataReceiver;
import main.DataToConvert;

public class Convertor {
	private final Map<Integer, IConvertToType<?>> convertMapping;
	private final IDataProvider dataProvider;
	private final IDataReceiver dataReceiver;

	public Convertor(IConvertFactory factory, IDataProvider dataProvider, IDataReceiver dataReceiver) {
		this.convertMapping = factory.getConvertMap();
		this.dataProvider = dataProvider;
		this.dataReceiver = dataReceiver;
	}

	public void convertData(DataToConvert data) throws UndefinedConvertException {
		if (!convertMapping.containsKey(data.getType())) {
			throw new UndefinedConvertException("Convert for dataType =  " + data.getType() + " is undefined");
		}
		System.out.println();
		System.out.println(data);
		try {
			Object o = convertMapping.get(data.getType()).convert(data.getBytes());
			dataReceiver.receiveData(o);
		} catch (IncorrectDataException | PermissibleErrorException | TooLargeNumberException e) {
			e.printStackTrace();
		}
//			ТоварищЗабиратель.забирай(convertMapping.get(data.getType()).convert(data.getBytes()))

	}

	public void start() {
		dataProvider.getData().forEach(t -> {
			try {
				convertData(t);
			} catch (UndefinedConvertException e) {
				e.printStackTrace();
			}
		});
	}

}
