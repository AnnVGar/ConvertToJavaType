package impl.receive;

import core.receive.IDataReceiver;

public class ConsoleReceiver implements IDataReceiver {

	@Override
	public void receiveData(Object o) {
		if (o != null) {
			String className = o.getClass().getSimpleName().toString();
			String phrase;
			switch(className) {
			case "String" : phrase = "�������� ������"; break;
			case "Date" : phrase = "�������� ����"; break;
			case "Long" : phrase = "�������� ����� �����"; break;
			case "Double" : phrase = "�������� ������������ �����"; break;
			default: phrase = "��� ������ ���� � ������, ���� ������� ����������";
			}
			System.out.println(phrase+" "+className+" �������� =  "+ o.toString());
		}
	}	

}
