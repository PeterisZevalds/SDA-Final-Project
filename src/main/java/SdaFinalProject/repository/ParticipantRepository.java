package SdaFinalProject.repository;

import SdaFinalProject.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findBySurname(String surname);
    Participant findByEmail(String email);
}
