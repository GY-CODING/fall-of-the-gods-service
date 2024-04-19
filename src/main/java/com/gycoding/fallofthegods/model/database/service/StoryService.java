package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see EntityStory
     * @see StoryRepository
     */
    public EntityStory getStory(String id) {
        return storyRepository.findByIdentifier(id).orElse(null);
    }

    /**
     * Lists all stories.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityStory
     * @see StoryRepository
     */
    public List<EntityStory> listStories() {
        return storyRepository.findAll();
    }
}
