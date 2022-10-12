package core.convert;

import java.util.Map;

public interface IConvertFactory {

	Map<Integer, IConvertToType<?>> getConvertMap();

}
