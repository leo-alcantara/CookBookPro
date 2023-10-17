package se.lexicom.jpa_assignement.exceptions;

public class Violation {

    private final String fieldName;
    private final String message;

    //Constructor
    public Violation(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    //Getters
    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
