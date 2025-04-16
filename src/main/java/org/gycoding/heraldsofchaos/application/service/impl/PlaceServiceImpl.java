package org.gycoding.heraldsofchaos.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.in.worlds.PlaceIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.worlds.PlaceODTO;
import org.gycoding.heraldsofchaos.application.mapper.PlaceServiceMapper;
import org.gycoding.heraldsofchaos.application.service.PlaceService;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.gycoding.heraldsofchaos.domain.model.worlds.PlaceMO;
import org.gycoding.heraldsofchaos.domain.repository.PlaceRepository;
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
    public PlaceODTO save(PlaceIDTO place) throws APIException {
        final PlaceMO savedPlace;

        try {
            savedPlace = repository.save(mapper.toMO(place));
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(savedPlace, TranslatedString.EN);
    }

    @Override
    public PlaceODTO update(PlaceIDTO place) throws APIException {
        final PlaceMO updatedPlace;

        try {
            updatedPlace = repository.update(mapper.toMO(place));
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(updatedPlace, TranslatedString.EN);
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

            return places.map(place -> mapper.toODTO(place, language).toMap());
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}
