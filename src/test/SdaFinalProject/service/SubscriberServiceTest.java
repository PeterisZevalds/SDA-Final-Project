package SdaFinalProject.service;

import SdaFinalProject.database.NoSQLDatabaseService;
import SdaFinalProject.dto.SubscriberDTO;
import SdaFinalProject.dto.mapper.SubscriberMapper;
import SdaFinalProject.entity.Subscriber;
import SdaFinalProject.repository.SubscriberRepository;

import org.junit.jupiter.api.Test;

import org.mockito.configuration.IMockitoConfiguration;

import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;



class SubscriberServiceTest {

    private SubscriberRepository subscriberRepository = mock(SubscriberRepository.class);

    SubscriberService subscriberService = new SubscriberService(subscriberRepository, new SubscriberMapper());




    @Test
    public void createSubscriber() {
        List<SubscriberDTO> subscribersBeforeAdd = subscriberService.allSubscribers();

        Subscriber subscriber = new Subscriber();
        subscriber.setId(1);

        when(subscriberRepository.findAll()).thenReturn(Collections.singletonList(subscriber));
        List<SubscriberDTO> subscribersAfterAdd = subscriberService.allSubscribers();

        assertEquals(subscribersAfterAdd.size() +1, subscribersBeforeAdd.size()+1);
    }

    @Test
    public void allSubscribers() {
//        List<SubscriberDTO> subscribersBeforeAdd = subscriberService.allSubscribers();
//
//        Subscriber subscriber = new Subscriber();
//        subscriber.setId(1);
//
//        when(subscriberRepository.findAll()).thenReturn(Collections.singletonList(subscriber));
//        List<SubscriberDTO> subscribersAfterAdd = subscriberService.allSubscribers();
//
//        assertEquals(subscribersAfterAdd.size()+1, subscribersBeforeAdd.size()+1);
    }

//    @org.junit.Test
//    public void deleteSubscriber() {
//    }
}
