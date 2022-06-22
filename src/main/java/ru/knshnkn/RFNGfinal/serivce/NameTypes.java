package ru.knshnkn.RFNGfinal.serivce;

// Типы: имя и фамилия
public enum NameTypes {
    FIRST_NAME("f"), LAST_NAME("l");

    private String type;

    NameTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
