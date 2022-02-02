package kg.aleksandrov;

public class BlackList {
    private String name;
    private String surname;
    private String patr;
    private String birthDate;

    public BlackList(String name, String surname, String patr, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.patr = patr;
        this.birthDate = birthDate;
    }

    public BlackList() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatr() {
        return patr;
    }

    public void setPatr(String patr) {
        this.patr = patr;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
