package SdaFinalProject.service;

import SdaFinalProject.dto.LecturerDTO;
import SdaFinalProject.dto.mapper.LecturerMapper;
import SdaFinalProject.entity.Lecturer;
import SdaFinalProject.repository.LecturerRepository;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;


class LecturerServiceTest {

    private LecturerRepository lecturerRepository = mock(LecturerRepository.class);
    LecturerService lecturerService = new LecturerService(lecturerRepository, new LecturerMapper());

    @Test
    void createLecturer() {
        List<LecturerDTO> lecturersBeforeAdd = lecturerService.allLecturers();

        Lecturer lecturer = new Lecturer();
        lecturer.setId(1);

        when(lecturerRepository.findAll()).thenReturn(Collections.singletonList(lecturer));

        List<LecturerDTO> lecturersAfterAdd = lecturerService.allLecturers();
        assertEquals(lecturersAfterAdd.size(), lecturersBeforeAdd.size()+1);
    }

    @Test
    void allLecturers() {
    }


}
