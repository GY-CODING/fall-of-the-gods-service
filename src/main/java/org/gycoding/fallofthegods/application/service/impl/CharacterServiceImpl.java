package org.gycoding.fallofthegods.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.application.dto.in.characters.CharacterIDTO;
import org.gycoding.fallofthegods.application.dto.out.characters.CharacterODTO;
import org.gycoding.fallofthegods.application.mapper.CharacterServiceMapper;
import org.gycoding.fallofthegods.application.service.CharacterService;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.TranslatedString;
import org.gycoding.fallofthegods.domain.model.characters.CharacterMO;
import org.gycoding.fallofthegods.domain.repository.CharacterRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
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
    public CharacterODTO save(CharacterIDTO character) throws APIException {
        final CharacterMO savedCharacter;

        try {
            savedCharacter = repository.save(mapper.toMO(character));
        } catch(Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }

        return mapper.toODTO(savedCharacter, TranslatedString.EN);
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

            return characters.stream()
                    .map(character -> mapper.toODTO(character, language))
                    .toList();
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

            return PagingConverter.listToPage(
                    characters.stream()
                            .map(character -> mapper.toODTO(character, language))
                            .map(CharacterODTO::toMap)
                            .toList(),
                    pageable
            );
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}