package com.vakya.productservicesfeb29.controllers.webhooks;

import com.stripe.net.Webhook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks/stripe")
public class StripeWebHookController {
    @PostMapping("/")
    public void handleWebhookRequest(Webhook webhook){

    }
}
