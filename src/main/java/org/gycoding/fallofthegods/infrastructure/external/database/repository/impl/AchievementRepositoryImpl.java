package org.gycoding.fallofthegods.infrastructure.external.database.repository.impl;

import lombok.AllArgsConstructor;
import org.gycoding.fallofthegods.domain.model.achievements.AchievementMO;
import org.gycoding.fallofthegods.domain.repository.AchievementRepository;
import org.gycoding.fallofthegods.infrastructure.external.database.mapper.AchievementDatabaseMapper;
import org.gycoding.fallofthegods.infrastructure.external.database.repository.AchievementMongoRepository;
import org.gycoding.fallofthegods.shared.PagingConverter;
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
    public AchievementMO save(AchievementMO achievement) {
        return mapper.toMO(repository.save(mapper.toEntity(achievement)));
    }

    @Override
    public void delete(String identifier) {
        repository.removeByIdentifier(identifier);
    }

    @Override
    public Optional<AchievementMO> get(String identifier) {
        return repository.findByIdentifier(identifier)
                .map(mapper::toMO);
    }

    @Override
    public List<AchievementMO> list() {
        return repository.findAll().stream()
                .map(mapper::toMO)
                .toList();
    }

    @Override
    public Page<AchievementMO> page(Pageable pageable) {
        return PagingConverter.listToPage(
                repository.findAll(pageable).stream()
                        .map(mapper::toMO)
                        .toList(),
                pageable
        );
    }
}