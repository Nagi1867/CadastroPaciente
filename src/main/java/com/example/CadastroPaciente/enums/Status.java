package com.example.CadastroPaciente.enums;

public enum Status {
    ATIVO(1),
    INATIVO(2);

    private Integer code;

    Status(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static Status valueOf(int code) {
        for (Status value : Status.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Ivalid status code!");
    }
}
