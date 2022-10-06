package impl;

import java.util.HashMap;
import java.util.Map;

import core.IConvertFactory;
import core.IConvertToType;

public class ConvertFactory implements IConvertFactory {

	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap(ConfigBean configBean) {
		Map<Integer, IConvertToType<?>> result = new HashMap<Integer, IConvertToType<?>>();

		Map<Integer, String> converters = configBean.getConverters();
		Map<String, Map<String, String>> convertSettings = configBean.getConvertSettings();
		for (Map.Entry<Integer, String> entry : converters.entrySet()) {
			Map<String, String> settings = convertSettings.get(entry.getValue());
			try {
				int dbType = entry.getKey();
				IConvertToType<?> convert;
				if (settings != null) {
					convert = (IConvertToType<?>) Class.forName(entry.getValue()).getConstructor(Map.class)
							.newInstance(settings);
				} else {
					convert = (IConvertToType<?>) Class.forName(entry.getValue()).newInstance();
				}
				result.put(dbType, convert);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
