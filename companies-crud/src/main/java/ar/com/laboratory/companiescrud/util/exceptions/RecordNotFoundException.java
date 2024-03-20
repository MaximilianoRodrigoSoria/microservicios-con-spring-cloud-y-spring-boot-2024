package ar.com.laboratory.companiescrud.util.exceptions;

public class RecordNotFoundException extends RuntimeException{

    private final static String ERROR_MESSAGE = "Record no exist in %s";

    public RecordNotFoundException(String tableName){
        super(String.format(ERROR_MESSAGE,tableName));
    }
}