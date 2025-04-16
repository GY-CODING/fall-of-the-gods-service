package org.gycoding.fallofthegods.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.in.worlds.WorldIDTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.PlaceODTO;
import org.gycoding.fallofthegods.application.dto.out.worlds.WorldODTO;
import org.gycoding.fallofthegods.application.mapper.WorldServiceMapper;
import org.gycoding.fallofthegods.application.service.WorldService;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.worlds.WorldMO;
import org.gycoding.fallofthegods.domain.repository.WorldRepository;
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

    @Override
    public WorldODTO save(WorldIDTO world) throws APIException {
        final WorldMO savedWorld;

        try {
            savedWorld = repository.save(mapper.toMO(world), world.places());
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(savedWorld, TranslatedString.EN);
    }

    @Override
    public WorldODTO update(WorldIDTO world) throws APIException {
        final WorldMO updatedWorld;

        try {
            updatedWorld = repository.update(mapper.toMO(world), world.places());
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(updatedWorld, TranslatedString.EN);
    }

    @Override
    public void delete(String identifier) throws APIException {
        try {
            repository.delete(identifier);
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
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

    @Override
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

    @Override
    public Page<Map<String, Object>> page(Pageable pageable, String language) throws APIException {
        try {
            final var worlds = repository.page(pageable);

            return worlds.map(world -> mapper.toODTO(world, language).toMap());
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }

    @Override
    public List<PlaceODTO> listPlaces(String idWorld, String language) throws APIException {
        final var world = this.get(idWorld, language);

        return world.places();
    }
}
