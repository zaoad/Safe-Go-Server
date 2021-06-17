package com.example.safegoserver.firebase.controller;

import com.example.safegoserver.firebase.model.PushNotificationRequest;
import com.example.safegoserver.firebase.model.PushNotificationResponse;
import com.example.safegoserver.firebase.service.PushNotificationService;
import com.example.safegoserver.model.AppToken;
import com.example.safegoserver.service.AppTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {
    @Autowired
    private PushNotificationService pushNotificationService;
    @Autowired
    AppTokenService appTokenService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/notification/topic")
    public ResponseEntity sendNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationWithoutData(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(),
                "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/notification/topic/{receiverPhoneNumber}/{fullNotificationString}")
    public void sendNotificationToFriends(@PathVariable String receiverPhoneNumber,
                                                    @PathVariable String fullNotificationString ) {
        AppToken appToken=appTokenService.getAppTokenByPhoneNumber(receiverPhoneNumber);
        String token=appToken.getToken();
        PushNotificationRequest request=new PushNotificationRequest();
        request.setMessage(fullNotificationString);
        request.setTitle("SafeGo");
        request.setToken(token);
        request.setTopic("safety");
        pushNotificationService.sendPushNotificationToToken(request);
        return;
    }
    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

    @PostMapping("/notification/data")
    public ResponseEntity sendDataNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotification(request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}