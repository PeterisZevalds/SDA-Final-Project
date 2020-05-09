package SdaFinalProject.dto.request;

import SdaFinalProject.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class UserCreateRequestDTO {

    @JsonProperty("user_dto")
    private UserDTO userDTO;
    @JsonProperty("password_hash")
    private String passHash;

    public UserDTO getUserDTO() {
        return  userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
