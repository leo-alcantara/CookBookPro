package se.lexicom.jpa_assignement.entity;

public enum Measurement {

    GRAM(1),
    KILO(1000),
    MILLILITER(1),
    LITER(1000);


    private int value;


    //Constructor
    Measurement(int value) {
        this.value = value;
    }

    //Getter
    public int getValue() {
        return value;
    }




}
