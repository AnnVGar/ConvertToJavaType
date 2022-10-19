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
		case "String" : phrase = "�������� ������"; break;
		case "Date" : phrase = "�������� ����"; break;
		case "Long" : phrase = "�������� ����� �����"; break;
		case "Double" : phrase = "�������� ������������ �����"; break;
		default: phrase = "��� ������ ���� � ������, ���� ������� ����������";
		}
		System.out.println(phrase+" "+className+" �������� =  "+ data.toString());

		
	}	

}
