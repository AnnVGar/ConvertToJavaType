package impl.receive;

import core.receive.IDataReceiver;

public class ConsoleReceiver implements IDataReceiver {

	@Override
	public void receiveData(Object o) {
		if (o != null) {
			String className = o.getClass().getSimpleName().toString();
			String phrase;
			switch(className) {
			case "String" : phrase = "Принимаю строку"; break;
			case "Date" : phrase = "Принимаю дату"; break;
			case "Long" : phrase = "Принимаю целое число"; break;
			case "Double" : phrase = "Принимаю вещественное число"; break;
			default: phrase = "Нет такого типа в списке, пора вызвать исключение";
			}
			System.out.println(phrase+" "+className+" значение =  "+ o.toString());
		}
	}	

}
