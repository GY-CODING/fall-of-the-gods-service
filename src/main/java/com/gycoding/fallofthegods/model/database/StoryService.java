package com.gycoding.fallofthegods.model.database;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gycoding.fallofthegods.model.entities.characters.EntityStory;

@Service
public class StoryService {
    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public EntityStory getStory(String id) {
        return storyRepository.findByIdentifier(id).orElse(null);
    }

    public List<EntityStory> listStories() {
        return storyRepository.findAll();
    }

    public List<EntityStory> listStoriesByCharacter(String participantIdentifier) {
        return this.listStories().stream()
            .filter(story -> story.getParticipants().stream()
                .anyMatch(character -> character.getIdentifier().equals(participantIdentifier)))
            .toList();
    }
}
