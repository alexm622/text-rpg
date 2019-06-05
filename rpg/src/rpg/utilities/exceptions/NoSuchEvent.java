package rpg.utilities.exceptions;

public class NoSuchEvent extends Exception{
    private static final long serialVersionUID = 1L;

    public NoSuchEvent(String errorMessage) {
        super(errorMessage);
    }
}