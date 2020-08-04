package SdaFinalProject.dto.mapper;

import SdaFinalProject.dto.LecturerDTO;
import SdaFinalProject.entity.Lecturer;
import org.springframework.stereotype.Service;

@Service
public class LecturerMapper {

    public LecturerDTO lecturerToDTO (Lecturer lecturer) {
        LecturerDTO lecturerDTO = new LecturerDTO();
        lecturerDTO.setId(lecturer.getId());
        lecturerDTO.setName(lecturer.getName());
        lecturerDTO.setSurname(lecturer.getSurname());
        lecturerDTO.setDescription(lecturer.getDescription());
        return lecturerDTO;
    }

    public Lecturer lecturerFromDTO (LecturerDTO lecturerDTO) {
        Lecturer lecturer = new Lecturer();
        lecturer.setId(lecturerDTO.getId());
        lecturer.setName(lecturerDTO.getName());
        lecturer.setSurname(lecturerDTO.getSurname());
        lecturer.setDescription(lecturerDTO.getDescription());
        lecturer.setEmail(lecturerDTO.getEmail());
        return lecturer;
    }


}
