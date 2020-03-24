package com.obarra.forecast.enums;

public enum FileJobEnum {
    FILE_JOB_DIAS_LLUVIA("/archivos_mleo/insert-dias-lluvia.sql"),
    FILE_JOB_DIAS_SEQUIA("/archivos_mleo/insert-dias-sequia.sql"),
    FILE_JOB_DIAS_IDEAL("/archivos_mleo/insert-dias-ideal.sql");

    private String value;

    FileJobEnum(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
