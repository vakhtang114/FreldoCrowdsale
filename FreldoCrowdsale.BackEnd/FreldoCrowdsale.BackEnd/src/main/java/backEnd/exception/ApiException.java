package backEnd.exception;

public class ApiException extends Exception {

    private static final long serialVersionUID = 377062597601683681L;

    private String messageKey;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String messageKey, String msg) {
        super(msg);
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
