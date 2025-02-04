package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.exceptions.model.APIException;
import org.gycoding.fallofthegods.domain.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.domain.repository.AchievementRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.AchievementDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.model.achievements.AchievementEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.AchievementMongoRepository;
import org.gycoding.fallofthegods.shared.util.PagingConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementRepositoryImpl implements AchievementRepository {
    private final AchievementMongoRepository repository;

    private final AchievementDatabaseMapper mapper;

    @Override
    public AchievementMO save(AchievementMO achievement) throws APIException {
        try {
            return mapper.toMO(repository.save(mapper.toEntity(achievement)));
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }

    @Override
    public Optional<AchievementMO> get(String identifier) throws APIException {
        final var achievementEntity = repository.findByIdentifier(identifier).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.RESOURCE_NOT_FOUND.code,
                        FOTGAPIError.RESOURCE_NOT_FOUND.message,
                        FOTGAPIError.RESOURCE_NOT_FOUND.status
                )
        );

        return Optional.of(mapper.toMO(achievementEntity));
    }

    @Override
    public List<AchievementMO> list() throws APIException {
        List<AchievementEntity> achievementEntities;

        try {
            achievementEntities = repository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return achievementEntities.stream().map(mapper::toMO).toList();
    }

    @Override
    public Page<AchievementMO> page(Pageable pageable) throws APIException {
        Page<AchievementEntity> achievementEntities;

        try {
            achievementEntities = repository.findAll(pageable);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.RESOURCE_NOT_FOUND.code,
                    FOTGAPIError.RESOURCE_NOT_FOUND.message,
                    FOTGAPIError.RESOURCE_NOT_FOUND.status
            );
        }

        return PagingConverter.listToPage(achievementEntities.stream().map(mapper::toMO).toList(), pageable);
    }

    @Override
    public void delete(String identifier) throws APIException {
        try {
            repository.removeByIdentifier(identifier);
        } catch (Exception e) {
            throw new APIException(
                    FOTGAPIError.CONFLICT.code,
                    FOTGAPIError.CONFLICT.message,
                    FOTGAPIError.CONFLICT.status
            );
        }
    }
}