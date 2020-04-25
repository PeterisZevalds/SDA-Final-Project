package SdaFinalProject.handler;

public enum ErrorCode {

    ERROR_01("Can't find user");

    private String massage;

    ErrorCode(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
