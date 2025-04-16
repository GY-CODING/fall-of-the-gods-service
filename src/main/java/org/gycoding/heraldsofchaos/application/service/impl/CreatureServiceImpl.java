package org.gycoding.heraldsofchaos.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.in.creatures.CreatureIDTO;
import org.gycoding.heraldsofchaos.application.dto.out.creatures.CreatureODTO;
import org.gycoding.heraldsofchaos.application.mapper.CreatureServiceMapper;
import org.gycoding.heraldsofchaos.application.service.CreatureService;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.model.TranslatedString;
import org.gycoding.heraldsofchaos.domain.model.creatures.CreatureMO;
import org.gycoding.heraldsofchaos.domain.repository.CreatureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CreatureServiceImpl implements CreatureService {
    private final CreatureRepository repository;

    private final CreatureServiceMapper mapper;

    @Override
    public CreatureODTO save(CreatureIDTO creature) throws APIException {
        final CreatureMO savedCreature;

        try {
            savedCreature = repository.save(mapper.toMO(creature));
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(savedCreature, TranslatedString.EN);
    }

    @Override
    public CreatureODTO update(CreatureIDTO creature) throws APIException {
        final CreatureMO updatedCreature;

        try {
            updatedCreature = repository.update(mapper.toMO(creature));
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(updatedCreature, TranslatedString.EN);
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
    public CreatureODTO get(String identifier, String language) throws APIException {
        final var creature = repository.get(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(creature, language);
    }

    @Override
    public List<CreatureODTO> list(String language) throws APIException {
        try {
            final var creatures = repository.list();

            return creatures.stream().map(creature -> mapper.toODTO(creature, language)).toList();
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
            final var creatures = repository.page(pageable);

            return creatures.map(creature -> mapper.toODTO(creature, language).toMap());
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}
