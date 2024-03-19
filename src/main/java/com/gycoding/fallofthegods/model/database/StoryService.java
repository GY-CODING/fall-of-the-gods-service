package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.characters.EntityStory;

/**
 * Service for the Story entity.
 * @see EntityStory
 * @see StoryRepository
 * @see Service
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 */
@Service
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

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

    /**
     * Lists all the stories in which the specific character (specified by its identifier) is involved.
     * @param participantIdentifier Character's identifier.
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityStory
     * @see StoryRepository
     */
    public List<EntityStory> listStoriesByCharacter(String participantIdentifier) {
        return this.listStories().stream()
            .filter(story -> story.getParticipants().stream()
                .anyMatch(character -> character.getIdentifier().equals(participantIdentifier)))
            .toList();
    }
}
