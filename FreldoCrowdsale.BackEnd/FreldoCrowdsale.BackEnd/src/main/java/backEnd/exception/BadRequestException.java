package backEnd.exception;

public class BadRequestException extends ApiException{

    private static final long serialVersionUID = -3419256278951540065L;

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(String messageKey, String msg) {
        super(messageKey, msg);
    }
}

