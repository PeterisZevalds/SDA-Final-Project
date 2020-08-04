package SdaFinalProject.dto;

public class AuthorizationOkResponse extends AbstractResponseDTO {

    private String secretContent;

    public String getSecretContent() {
        return secretContent;
    }

    public void setSecretContent(String secretContent) {
        this.secretContent = secretContent;
    }
}
