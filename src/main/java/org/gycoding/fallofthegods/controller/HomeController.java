package org.gycoding.fallofthegods.controller;

import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.exceptions.model.APIException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/makemeacoffee")
    public String makeCoffee() throws APIException {
        throw new APIException(
                FOTGAPIError.I_AM_A_TEAPOT.getCode(),
                FOTGAPIError.I_AM_A_TEAPOT.getMessage(),
                FOTGAPIError.I_AM_A_TEAPOT.getStatus()
        );
    }
}
