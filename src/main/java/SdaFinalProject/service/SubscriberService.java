package SdaFinalProject.service;

import SdaFinalProject.dto.SubscriberDTO;
import SdaFinalProject.dto.mapper.SubscriberMapper;
import SdaFinalProject.entity.Subscriber;
import SdaFinalProject.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;
    private final SubscriberMapper subscriberMapper;

    public SubscriberService(SubscriberRepository subscriberRepository, SubscriberMapper subscriberMapper) {
        this.subscriberRepository = subscriberRepository;
        this.subscriberMapper = subscriberMapper;
    }

    public SubscriberDTO createSubscriber(SubscriberDTO subscriberDTO) {
        Subscriber subscriber = subscriberMapper.subscriberFromDTO(subscriberDTO);
        Subscriber subscriberCreated = subscriberRepository.save(subscriber);
        return subscriberMapper.subscriberToDTO(subscriberCreated);
    }

    public List<SubscriberDTO> allSubscribers() {
        return subscriberRepository.findAll()
                .stream().filter(Subscriber::isActive).map(subscriberMapper::subscriberToDTO)
                .collect(Collectors.toList());
    }

    public void deleteSubscriber(int id) {
        Subscriber subscriber = subscriberRepository.getOne(id);
        subscriberRepository.delete(subscriber);
    }
}
