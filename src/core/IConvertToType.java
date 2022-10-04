package core;

import exception.ExceedMarginOfError;
import exception.IncorrectDataException;
import exception.TooLargeNumberException;

public interface IConvertToType <T> {

	T convert(byte[] bytes) throws IncorrectDataException, ExceedMarginOfError, TooLargeNumberException;
}
