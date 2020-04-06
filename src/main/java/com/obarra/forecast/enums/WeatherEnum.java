package com.obarra.forecast.enums;

public enum WeatherEnum {
    RAIN(1L),
    DROUGHT(2L),
    OPTIMUM(3L);

    private Long value;

    /**
     * Constructor.
     * @param value
     */
    WeatherEnum(final Long value) {
        this.value = value;
    }

    /**
     * @return Identification of a Weather.
     */
    public Long value() {
        return value;
    }
}
