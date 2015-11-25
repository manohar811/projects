package com.crossover.trial.properties.converter;

public class StringToDoubleConverter implements Converter<Double> {

	@Override
	public Double convert(String value) {
		if (value == null || value.trim().length() == 0) {
			return null;
		}
		String val = value.trim().toLowerCase();

		Double result = null;
		try {
			result = Double.valueOf(val);
		} catch (NumberFormatException e) {
			return null;
		}
		return result;
	}
}
