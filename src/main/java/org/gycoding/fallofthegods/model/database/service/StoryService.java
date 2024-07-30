package org.gycoding.fallofthegods.model.database.service;

import org.gycoding.fallofthegods.model.database.repository.StoryRepository;
import org.gycoding.fallofthegods.model.entities.exceptions.FOTGAPIError;
import org.gycoding.fallofthegods.model.entities.characters.EntityStory;
import org.gycoding.springexceptions.model.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StoryService {
    @Autowired
    private final StoryRepository storyRepository = null;

    public EntityStory getStory(String id) throws APIException {
        return storyRepository.findByIdentifier(id).orElseThrow(() ->
                new APIException(
                        FOTGAPIError.STORY_NOT_FOUND.getCode(),
                        FOTGAPIError.STORY_NOT_FOUND.getMessage(),
                        FOTGAPIError.STORY_NOT_FOUND.getStatus()
                )
        );
    }

    public List<EntityStory> listStories() throws APIException {
        try {
            return storyRepository.findAll();
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getStatus()
            );
        }
    }

    public Page<Map<String, Object>> pageStories(Pageable pageable) throws APIException {
        try {
            return storyRepository.findAll(pageable)
                    .map(EntityStory::toMap);
        } catch (NullPointerException e) {
            throw new APIException(
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getCode(),
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getMessage(),
                    FOTGAPIError.LIST_STORY_NOT_FOUND.getStatus()
            );
        }
    }
}
