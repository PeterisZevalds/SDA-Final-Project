package SdaFinalProject.service;

import SdaFinalProject.database.NoSQLDatabaseService;
import SdaFinalProject.dto.ParticipantDTO;
import SdaFinalProject.dto.mapper.ParticipantMapper;
import SdaFinalProject.entity.Participant;
import SdaFinalProject.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;
    private final NoSQLDatabaseService noSQLDatabaseService;

    @Autowired
    public ParticipantService (NoSQLDatabaseService noSQLDatabaseService, ParticipantRepository participantRepository, ParticipantMapper participantMapper) {
        this.participantMapper = participantMapper;
        this.participantRepository = participantRepository;
        this.noSQLDatabaseService = noSQLDatabaseService;
    }

    public ParticipantDTO createParticipant(ParticipantDTO participantDTO, String hashPassword) {
        Participant participant = participantMapper.fromDTO(participantDTO);
        participant.setPassword(hashPassword);
        noSQLDatabaseService.putValue(participant.getEmail(), "12345678910111213141516");
        Participant participantCreated = participantRepository.save(participant);
        return participantMapper.participantToDTO(participantCreated);
    }

    public List<ParticipantDTO> getAllParticipants() {

        try {

            String strkey = "blowfish";
            SecretKeySpec key = null;
            key = new SecretKeySpec(strkey.getBytes(StandardCharsets.UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");

            cipher.init(Cipher.ENCRYPT_MODE, key);

            String encryptedData = null;
            encryptedData = new String(cipher.doFinal("encrypt".getBytes(StandardCharsets.UTF_8)));

            System.out.println("ENCRYPTES: " + encryptedData);
            System.out.println("ENCRYPTES: " + Base64.getEncoder()
                    .encodeToString(encryptedData.getBytes()));
            System.out.println("ENCRYPTES: " +
                    Arrays.toString(Base64.getEncoder()
                            .encodeToString(encryptedData.getBytes()).getBytes()));
            System.out.println("ENCRYPTES: " + Arrays.toString(encryptedData.getBytes(StandardCharsets.UTF_8)));
            cipher.init(Cipher.DECRYPT_MODE, key);


        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | BadPaddingException | IllegalBlockSizeException | InvalidKeyException e) {
            e.printStackTrace();
        } return participantRepository.findAll().stream().map(participantMapper::participantToDTO)
                                      .collect(Collectors.toList());
    }

}

