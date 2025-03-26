package org.gycoding.heraldsofchaos.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.out.characters.CharacterODTO;
import org.gycoding.heraldsofchaos.application.mapper.CharacterServiceMapper;
import org.gycoding.heraldsofchaos.application.service.CharacterService;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.repository.CharacterRepository;
import org.gycoding.heraldsofchaos.shared.util.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository repository;

    private final CharacterServiceMapper mapper;

    @Override
    public CharacterODTO get(String identifier, Boolean inGame, String language) throws APIException {
        final var character = repository.get(identifier, inGame).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(character, language);
    }

    @Override
    public List<CharacterODTO> list(Boolean inGame, String language) throws APIException {
        try {
            final var characters = repository.list(inGame);

            return characters.stream().map(character -> mapper.toODTO(character, language)).toList();
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
            final var characters = repository.page(pageable, inGame);

            return PagingConverter.listToPage(characters.stream().map(character -> mapper.toODTO(character, language)).map(CharacterODTO::toMap).toList(), pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}