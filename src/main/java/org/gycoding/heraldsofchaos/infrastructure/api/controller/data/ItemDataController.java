package org.gycoding.heraldsofchaos.infrastructure.api.controller.data;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.service.ItemService;
import org.gycoding.heraldsofchaos.infrastructure.api.mapper.ItemControllerMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemDataController {
    private final ItemService service;

    private final ItemControllerMapper mapper;

    @GetMapping("/get")
    public ResponseEntity<?> getItem(@RequestParam String id, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(mapper.toRSDTO(service.get(id, lang)));
    }

    @GetMapping("/list")
    public ResponseEntity<?> listItems(@RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.list(lang).stream().map(mapper::toRSDTO).toList());
    }

    @GetMapping("/page")
    public ResponseEntity<?> pageItems(Pageable pageable, @RequestParam String lang) throws APIException {
        return ResponseEntity.ok(service.page(pageable, lang).getContent());
    }
}
