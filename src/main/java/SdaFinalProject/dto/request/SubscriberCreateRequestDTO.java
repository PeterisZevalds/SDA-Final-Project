package SdaFinalProject.dto.request;

import SdaFinalProject.dto.SubscriberDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class SubscriberCreateRequestDTO {

    @JsonProperty("subscriber_dto")
    private SubscriberDTO subscriberDTO;

    public SubscriberDTO getSubscriberDTO() {
        return subscriberDTO;
    }

    public void setSubscriberDTO(SubscriberDTO subscriberDTO) {
        this.subscriberDTO = subscriberDTO;
    }
}

