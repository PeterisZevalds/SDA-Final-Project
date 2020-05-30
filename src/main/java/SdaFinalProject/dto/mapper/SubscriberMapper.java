package SdaFinalProject.dto.mapper;


import SdaFinalProject.dto.SubscriberDTO;
import SdaFinalProject.entity.Subscriber;
import org.springframework.stereotype.Service;

@Service
public class SubscriberMapper {
    public SubscriberDTO subscriberToDTO(Subscriber subscriber) {
        SubscriberDTO subscriberDTO = new SubscriberDTO();
        subscriberDTO.setId(subscriber.getId());
        subscriberDTO.setEmail(subscriber.getEmail());
        subscriberDTO.setActive(true);
        return subscriberDTO;
    }

    public Subscriber subscriberFromDTO(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = new Subscriber();
        subscriber.setId(subscriberDTO.getId());
        subscriber.setEmail(subscriberDTO.getEmail());
        subscriber.setActive(subscriberDTO.isActive());
        return subscriber;
    }
}
