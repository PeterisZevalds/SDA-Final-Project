package SdaFinalProject.controllers;

import SdaFinalProject.dto.LecturerDTO;
import SdaFinalProject.dto.request.LecturerCreateRequestDTO;
import SdaFinalProject.service.LecturerService;
import SdaFinalProject.service.ParticipantService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rest/Lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping("/lecturers")
    public List<LecturerDTO> getAllLecturers() {
        return lecturerService.allLecturers();
    }

    @PostMapping(value="/createLecturer", consumes = "application/json")
    public LecturerDTO createLecturer(@RequestBody LecturerCreateRequestDTO lecturerCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(lecturerCreateRequestDTO));
        return lecturerService.createLecturer(lecturerCreateRequestDTO.getLecturerDTO());
    }

    @DeleteMapping("/user({id})")
    public void deleteLecturer (@PathVariable int id) {
        lecturerService.deleteLecturer(id);
    }

    @PutMapping("/lecturer/update")
    public LecturerDTO updateLecturer(@RequestBody LecturerDTO lecturerDTO) {
        return lecturerService.updateLecturer(lecturerDTO);
    }



}
