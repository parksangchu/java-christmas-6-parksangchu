package christmas.domain;

public enum ErrorMessage {
    VISIT_DAY("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    private static final String ERROR = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return message;
    }
}
