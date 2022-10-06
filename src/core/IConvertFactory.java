package core;

import java.util.Map;

import impl.ConfigBean;

public interface IConvertFactory {

	Map<Integer, IConvertToType<?>> getConvertMap(ConfigBean configBeans);

}
