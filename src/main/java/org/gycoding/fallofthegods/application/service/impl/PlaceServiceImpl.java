package org.gycoding.fallofthegods.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.mapper.PlaceServiceMapper;
import org.gycoding.fallofthegods.application.service.PlaceService;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.repository.PlaceRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository repository;

    private final PlaceServiceMapper mapper;

    @Override
    public PlaceODTO get(String identifier, String language) throws APIException {
        final var place = repository.get(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(place, language);
    }

    @Override
    public List<PlaceODTO> list(String language) throws APIException {
        try {
            final var places = repository.list();

            return places.stream().map(place -> mapper.toODTO(place, language)).toList();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    @Override
    public Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException {
        try {
            final var places = repository.page(pageable);

            return PagingConverter.listToPage(places.stream().map(place -> mapper.toODTO(place, language)).map(PlaceODTO::toMap).toList(), pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}
