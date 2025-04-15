package org.gycoding.fallofthegods.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.application.mapper.WorldServiceMapper;
import org.gycoding.fallofthegods.application.service.WorldService;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.repository.WorldRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class WorldServiceImpl implements WorldService {
    private final WorldRepository repository;

    private final WorldServiceMapper mapper;

    public WorldODTO get(String identifier, String language) throws APIException {
        final var world = repository.get(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(world, language);
    }

    public List<WorldODTO> list(String language) throws APIException {
        try {
            final var worlds = repository.list();

            return worlds.stream().map(world -> mapper.toODTO(world, language)).toList();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    public Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException {
        try {
            final var worlds = repository.page(pageable);

            return PagingConverter.listToPage(worlds.stream().map(world -> mapper.toODTO(world, language)).map(WorldODTO::toMap).toList(), pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    @Override
    public PlaceODTO getPlace(String idWorld, String idPlace, String language) throws APIException {
        final var world = this.get(idWorld, language);

        return world.places().stream()
                .filter(place -> place.identifier().equals(idPlace))
                .findFirst()
                .orElseThrow(() ->
                    new APIException(
                            FOTGAPIError.RESOURCE_NOT_FOUND.code,
                            FOTGAPIError.RESOURCE_NOT_FOUND.message,
                            FOTGAPIError.RESOURCE_NOT_FOUND.status
                    )
                );
    }

    @Override
    public List<PlaceODTO> listPlaces(String idWorld, String language) throws APIException {
        final var world = this.get(idWorld, language);

        return world.places();
    }

    @Override
    public Page<Map<String, Object>> pagePlaces(String idWorld, Pageable pageable, String language) throws APIException {
        final var world = this.get(idWorld, language);

        return PagingConverter.listToPage(world.places().stream().map(PlaceODTO::toMap).toList(), pageable);
    }
}
