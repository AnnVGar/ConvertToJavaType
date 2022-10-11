package core.convert;

import core.exception.PermissibleErrorException;
import core.exception.IncorrectDataException;
import core.exception.TooLargeNumberException;

public interface IConvertToType <T> {

	T convert(byte[] bytes) throws IncorrectDataException, PermissibleErrorException, TooLargeNumberException;
}
