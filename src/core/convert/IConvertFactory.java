package core.convert;

import java.util.Map;

import core.config.ConfigConvertBean;

public interface IConvertFactory {

	Map<Integer, IConvertToType<?>> getConvertMap(ConfigConvertBean configBeans);

}
