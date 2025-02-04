package org.gycoding.fallofthegods.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.out.creatures.CreatureODTO;
import org.gycoding.fallofthegods.application.mapper.CreatureServiceMapper;
import org.gycoding.fallofthegods.application.service.CreatureService;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.creatures.CreatureMO;
import org.gycoding.fallofthegods.domain.repository.CreatureRepository;
import org.gycoding.fallofthegods.shared.util.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    public CreatureODTO get(String identifier, Boolean inGame, String language) throws APIException {
        final var creature = repository.get(identifier, inGame).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(creature, language);
    }

    @Override
    public List<CreatureODTO> list(Boolean inGame, String language) throws APIException {
        try {
            final var creatures = repository.list(inGame);

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
    public Page<Map<String, Object>> page(Pageable pageable, Boolean inGame, String language) throws APIException {
        try {
            final var creatures = repository.page(pageable, inGame);

            return PagingConverter.listToPage(creatures.stream().map(creature -> mapper.toODTO(creature, language)).map(CreatureODTO::toMap).toList(), pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}
