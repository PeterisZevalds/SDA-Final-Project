package SdaFinalProject.dto.request;

import SdaFinalProject.dto.LecturerDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class LecturerCreateRequestDTO {

    @JsonProperty("lecturer_dto")
    private LecturerDTO lecturerDTO;

    public LecturerDTO getLecturerDTO() {
        return lecturerDTO;
    }

    public void setLecturerDTO (LecturerDTO lecturerDTO) {
        this.lecturerDTO = lecturerDTO;
    }
}
