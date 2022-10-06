package impl;

import java.util.HashMap;
import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;
import core.IConfig;

public class ConvertFactory implements IConvertFactory {

	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap(ConfigBean configBeans) {
		Map<Integer, IConvertToType<?>> result = new HashMap<Integer, IConvertToType<?>>();

		Map<Integer, String> converters = configBeans.getConverters();
		for (Map.Entry<Integer, String> entry : converters.entrySet()) {
			try {
				result.put(entry.getKey(), (IConvertToType<?>) Class.forName(entry.getValue()).newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
