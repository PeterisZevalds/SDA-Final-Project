package SdaFinalProject.service;

import SdaFinalProject.dto.LecturerDTO;
import SdaFinalProject.dto.mapper.LecturerMapper;
import SdaFinalProject.entity.Lecturer;
import SdaFinalProject.repository.LecturerRepository;
//import com.sun.deploy.security.BlacklistedCerts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LecturerService {
    private final LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;

    @Autowired
    public LecturerService (LecturerRepository lecturerRepository, LecturerMapper lecturerMapper) {
        this.lecturerRepository = lecturerRepository;
        this.lecturerMapper = lecturerMapper;
    }

    public LecturerDTO createLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.lecturerFromDTO(lecturerDTO);
        Lecturer lecturerCreated = lecturerRepository.save(lecturer);
        return lecturerMapper.lecturerToDTO(lecturerCreated);
    }

    public List<LecturerDTO> allLecturers() {
        return lecturerRepository.findAll()
                .stream().map(lecturerMapper::lecturerToDTO)
                .collect(Collectors.toList());
    }

    public void deleteLecturer(int id) {
        Lecturer lecturer = lecturerRepository.getOne(id);
        lecturerRepository.delete(lecturer);
    }

    public LecturerDTO updateLecturer(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerMapper.lecturerFromDTO(lecturerDTO);
        Lecturer updateLecturer = lecturerRepository.save(lecturer);
        return lecturerMapper.lecturerToDTO(updateLecturer);
    }

}
