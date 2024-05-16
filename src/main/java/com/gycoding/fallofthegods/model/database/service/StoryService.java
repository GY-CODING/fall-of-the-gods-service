package com.gycoding.fallofthegods.model.database.service;

import com.gycoding.fallofthegods.model.database.repository.StoryRepository;
import com.gycoding.fallofthegods.model.entities.ServerStatus;
import com.gycoding.fallofthegods.model.entities.characters.EntityStory;
import com.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service for the Story entity.
 * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
 * @see EntityStory
 * @see StoryRepository
 * @see Service
 * @throws FOTGAPIException
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
     * @throws FOTGAPIException
     */
    public EntityStory getStory(String id) throws FOTGAPIException {
        return storyRepository.findByIdentifier(id).orElseThrow(() ->
                new FOTGAPIException(ServerStatus.STORY_NOT_FOUND)
        );
    }

    /**
     * Lists all stories.
     * @return List of EntityStory
     * @author Ivan Vicente Morales (<a href="https://toxyc.dev/">ToxYc</a>)
     * @see List
     * @see EntityStory
     * @see StoryRepository
     * @throws FOTGAPIException
     */
    public List<EntityStory> listStories() throws FOTGAPIException {
        try {
            return storyRepository.findAll();
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_STORY_NOT_FOUND);
        }
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
     * @throws FOTGAPIException
     */
    public Page<Map<String, Object>> pageStories(Pageable pageable) throws FOTGAPIException {
        try {
            return storyRepository.findAll(pageable)
                    .map(EntityStory::toMap);
        } catch (NullPointerException e) {
            throw new FOTGAPIException(ServerStatus.LIST_STORY_NOT_FOUND);
        }
    }
}
