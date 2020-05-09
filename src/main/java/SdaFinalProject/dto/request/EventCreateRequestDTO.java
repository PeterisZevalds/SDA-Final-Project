package SdaFinalProject.dto.request;

import SdaFinalProject.dto.EventDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("")
public class EventCreateRequestDTO {

    @JsonProperty("event_dto")
    private EventDTO eventDTO;

    public EventDTO getEventDTO() {
        return eventDTO;
    }

    public void setEventDTO(EventDTO eventDTO) {
        this.eventDTO = eventDTO;
    }

}
