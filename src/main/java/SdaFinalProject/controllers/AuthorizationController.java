package SdaFinalProject.controllers;

import SdaFinalProject.authorization.CryptService;
import SdaFinalProject.database.NoSQLDatabaseService;
import SdaFinalProject.dto.AuthorizationOkResponse;
import SdaFinalProject.dto.AuthorizationTokenResponse;
import SdaFinalProject.dto.request.AuthorizationRequestDTO;
import SdaFinalProject.exceptions.ServiceException;
import SdaFinalProject.handler.ErrorCode;
import SdaFinalProject.service.AuthorizationService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rest/Authorization")
public class AuthorizationController {

    private final NoSQLDatabaseService noSQLDatabaseService;
    private final AuthorizationService authorizationService;
    private final CryptService cryptService;

    @Autowired
    public AuthorizationController (NoSQLDatabaseService noSQLDatabaseService,
                                    AuthorizationService authorizationService,
                                    CryptService cryptService) {

        this.noSQLDatabaseService = noSQLDatabaseService;
        this.authorizationService = authorizationService;
        this.cryptService = cryptService;
    }

    @GetMapping("/authorization({email})")
    public AuthorizationTokenResponse getRandomString(@PathVariable String participantname) {
        String generatedString = RandomStringUtils.random(8, true, true);
        noSQLDatabaseService.putValue(participantname, generatedString);
        return createAuthorizationTokenResponse(participantname, generatedString);
    }

    private AuthorizationTokenResponse createAuthorizationTokenResponse(@PathVariable String participantname, String generatedString) {
    AuthorizationTokenResponse authorizationTokenResponse = new AuthorizationTokenResponse();
    authorizationTokenResponse.setToken(generatedString);
    authorizationTokenResponse.setParticipantName(participantname);
    return authorizationTokenResponse;
    }

    @PostMapping("authorization/login")
    public AuthorizationOkResponse login(@RequestBody AuthorizationRequestDTO authorizationRequestDTO) {
        String cryptedPassword = authorizationService.getParticipantPassword(authorizationRequestDTO.getEmail());
        String originalPassword = cryptService.decrypt(cryptedPassword, CryptService.APP_KEY);
        String tokenWeSentToClient = noSQLDatabaseService.getValue(authorizationRequestDTO.getEmail());
        String cryptedTokenResult = cryptService.encrypt(tokenWeSentToClient, originalPassword);

        if (authorizationRequestDTO.getCryptedToken().equals(cryptedTokenResult)) {
            AuthorizationOkResponse authorizationOkResponse = new AuthorizationOkResponse();
            authorizationOkResponse.setSecretContent("very secret content");
            noSQLDatabaseService.remove(authorizationRequestDTO.getEmail());
            return authorizationOkResponse;
        } else {
            noSQLDatabaseService.remove(authorizationRequestDTO.getEmail());
            throw new ServiceException(ErrorCode.ERROR_01);
        }
    }

}
