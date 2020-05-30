package SdaFinalProject.controllers;

import SdaFinalProject.dto.SubscriberDTO;
import SdaFinalProject.dto.request.SubscriberCreateRequestDTO;
import SdaFinalProject.service.SubscriberService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/Subscriber")
public class SubscriberController {

    @Autowired
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping(value="/createSubscriber", consumes = "application/json")
    public SubscriberDTO createSubscriber(@RequestBody SubscriberCreateRequestDTO subscriberCreateRequestDTO) {
        System.out.println(ReflectionToStringBuilder.reflectionToString(subscriberCreateRequestDTO));

        return subscriberService.createSubscriber(subscriberCreateRequestDTO.getSubscriberDTO());
    }

    @GetMapping("/subscribers")
    public List<SubscriberDTO> allSubscribers() {
        return subscriberService.allSubscribers();
    }


}
