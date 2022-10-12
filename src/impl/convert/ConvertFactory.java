package impl.convert;

import java.util.HashMap;
import java.util.Map;

import core.config.ConvertConfigBean;
import core.convert.IConvertFactory;
import core.convert.IConvertToType;

public class ConvertFactory implements IConvertFactory {

	private final ConvertConfigBean configBean;

	public ConvertFactory(ConvertConfigBean configBean) {
		this.configBean = configBean;
	}

	@Override
	public Map<Integer, IConvertToType<?>> getConvertMap() {
		Map<Integer, IConvertToType<?>> result = new HashMap<Integer, IConvertToType<?>>();

		Map<Integer, String> converters = configBean.getConverters();
		Map<String, Map<String, String>> convertSettings = configBean.getConvertSettings();

		converters.forEach((type, className) -> {
			try {
				result.put(type, getICovertInstance(className, convertSettings));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		return result;
	}

	public IConvertToType<?> getICovertInstance(String className, Map<String, Map<String, String>> convertSettings)
			throws Exception {
		return (IConvertToType<?>) Class.forName(className).getConstructor(Map.class)
				.newInstance(getSettings(convertSettings, className));
	}

	private Map<String, String> getSettings(Map<String, Map<String, String>> convertSettings, String className) {
		return convertSettings.getOrDefault(className, new HashMap<>());
	}

}
