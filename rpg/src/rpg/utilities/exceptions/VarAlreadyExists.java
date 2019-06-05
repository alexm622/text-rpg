package rpg.utilities.exceptions;

public class VarAlreadyExists extends Exception{

    private static final long serialVersionUID = -791686922069119030L;

    public VarAlreadyExists(String errorMessage) {
        super(errorMessage);
    }

}