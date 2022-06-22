package ru.knshnkn.RFNGfinal.serivce;

// Параметры для генерации случайного имени, получаемые из POST HTTP запроса
public class NameParams {
    private String gender;
    private String race;

    public NameParams() {}

    public NameParams(String gender, String race) {
        this.gender = gender;
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
