package impl.receive;

import core.receive.IDataReceiver;

public class ConsoleReceiver implements IDataReceiver {

	@Override
	public <T> void receiveData(T data) {
		if(data == null) {
			System.out.println("Data is null");
			return;
		}

		String className = data.getClass().getSimpleName().toString();
		String phrase;
		switch(className) {
		case "String" : phrase = "Receive String "; break;
		case "Date" : phrase = "Receive Date "; break;
		case "Long" : phrase = "Receive Long "; break;
		case "Double" : phrase = "Receive Double "; break;
		default: phrase = "Type can't be received: "+className;
		}
		System.out.println(phrase+" value = "+ data.toString());

		
	}	

}
