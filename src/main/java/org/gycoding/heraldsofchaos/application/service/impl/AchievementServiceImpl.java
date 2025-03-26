package org.gycoding.heraldsofchaos.application.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.heraldsofchaos.application.dto.out.achievements.AchievementODTO;
import org.gycoding.heraldsofchaos.application.mapper.AchievementServiceMapper;
import org.gycoding.heraldsofchaos.application.service.AchievementService;
import org.gycoding.heraldsofchaos.domain.exceptions.FOTGAPIError;
import org.gycoding.heraldsofchaos.domain.repository.AchievementRepository;
import org.gycoding.heraldsofchaos.shared.util.PagingConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private final AchievementRepository repository;

    private final AchievementServiceMapper mapper;

    public AchievementODTO get(String identifier, String language) throws APIException {
        final var achievement = repository.get(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return mapper.toODTO(achievement, language);
    }

    public List<AchievementODTO> list(String language) throws APIException {
        try {
            final var achievements = repository.list();

            return achievements.stream().map(achievement -> mapper.toODTO(achievement, language)).toList();
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
            final var achievements = repository.page(pageable);

            return PagingConverter.listToPage(achievements.stream().map(achievement -> mapper.toODTO(achievement, language)).map(AchievementODTO::toMap).toList(), pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }
    }
}
