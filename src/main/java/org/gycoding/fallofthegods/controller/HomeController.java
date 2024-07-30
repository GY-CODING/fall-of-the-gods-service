package org.gycoding.fallofthegods.controller;

import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() throws APIException {
        Resource resource = new ClassPathResource("static/index.html");

        try {
            return new String(Files.readAllBytes(Paths.get(resource.getURI())));
        } catch (IOException e) {
            throw new APIException(
                    FOTGAPIError.HOME_NOT_FOUND.getCode(),
                    FOTGAPIError.HOME_NOT_FOUND.getMessage(),
                    FOTGAPIError.HOME_NOT_FOUND.getStatus()
            );
        }
    }

    @GetMapping("/makemeacoffee")
    public String makeCoffee() throws APIException {
        throw new APIException(
                FOTGAPIError.I_AM_A_TEAPOT.getCode(),
                FOTGAPIError.I_AM_A_TEAPOT.getMessage(),
                FOTGAPIError.I_AM_A_TEAPOT.getStatus()
        );
    }
}
