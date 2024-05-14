package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service for the Story entity.
 * @see EntityStory
 * @see StoryRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class StoryService {
    @Autowired
    private final StoryRepository storyRepository = null;

    /**
     * Finds a Story by its identifier.
     * @param id
     * @return EntityStory
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityStory
     * @see StoryRepository
     */
    public EntityStory getStory(String id) {
        return storyRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all stories.
     * @return List of EntityStory
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityStory
     * @see StoryRepository
     */
    public List<EntityStory> listStories() {
        return storyRepository.findAll();
    }

    /**
     * Lists all stories with pagination.
     * @return List of EntityStory
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see Pageable
     * @see Page
     * @see Map
     * @see EntityStory
     * @see StoryRepository
     */
    public Page<Map<String, Object>> pageStories(Pageable pageable) {
        return storyRepository.findAll(pageable)
                .map(EntityStory::toMap);
    }
}
