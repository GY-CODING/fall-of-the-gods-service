package org.gycoding.fallofthegods.shared.mapper;

import org.gycoding.fallofthegods.application.dto.in.StatIDTO;
import org.gycoding.fallofthegods.application.dto.in.characters.AbilityIDTO;
import org.gycoding.fallofthegods.application.dto.in.characters.AttributeIDTO;
import org.gycoding.fallofthegods.application.dto.out.StatODTO;
import org.gycoding.fallofthegods.application.dto.out.characters.AbilityODTO;
import org.gycoding.fallofthegods.application.dto.out.characters.AttributeODTO;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.characters.AbilityMO;
import org.gycoding.fallofthegods.domain.model.characters.AttributeMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.StatRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.AbilityRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.characters.AttributeRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.StatRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.AbilityRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.characters.AttributeRSDTO;
import org.gycoding.fallofthegods.shared.util.StringTranslator;

import java.util.List;

public class CharacterMapperUtils {
    public static List<AbilityODTO> toAbilityODTOList(List<AbilityMO> abilities, String language) {
        return abilities.stream()
                .map(ability -> toAbilityODTO(ability, language))
                .toList();
    }

    public static AbilityODTO toAbilityODTO(AbilityMO ability, String language) {
        if (ability == null) {
            return null;
        }

        return AbilityODTO.builder()
                .identifier(ability.identifier())
                .name(StringTranslator.translate(ability.name(), language))
                .description(StringTranslator.translate(ability.description(), language))
                .cooldown(ability.cooldown())
                .damage(ability.damage())
                .life(ability.life())
                .timeToHit(ability.timeToHit())
                .build();
    }

    public static List<AbilityMO> toAbilityMOList(List<AbilityIDTO> abilities) {
        return abilities.stream()
                .map(CharacterMapperUtils::toAbilityMO)
                .toList();
    }

    public static AbilityMO toAbilityMO(AbilityIDTO ability) {
        if (ability == null) {
            return null;
        }

        return AbilityMO.builder()
                .identifier(ability.identifier())
                .name(ability.name())
                .description(ability.description())
                .cooldown(ability.cooldown())
                .damage(ability.damage())
                .life(ability.life())
                .timeToHit(ability.timeToHit())
                .build();
    }

    public static List<AbilityIDTO> toAbilityIDTOList(List<AbilityRQDTO> abilities) {
        return abilities.stream()
                .map(CharacterMapperUtils::toAbilityIDTO)
                .toList();
    }

    public static AbilityIDTO toAbilityIDTO(AbilityRQDTO ability) {
        if (ability == null) {
            return null;
        }

        return AbilityIDTO.builder()
                .identifier(ability.identifier())
                .name(ability.name())
                .description(ability.description())
                .cooldown(ability.cooldown())
                .damage(ability.damage())
                .life(ability.life())
                .timeToHit(ability.timeToHit())
                .build();
    }

    public static List<AbilityRSDTO> toAbilityRSDTOList(List<AbilityODTO> abilities) {
        return abilities.stream()
                .map(CharacterMapperUtils::toAbilityRSDTO)
                .toList();
    }

    public static AbilityRSDTO toAbilityRSDTO(AbilityODTO ability) {
        if (ability == null) {
            return null;
        }

        return AbilityRSDTO.builder()
                .identifier(ability.identifier())
                .name(ability.name())
                .description(ability.description())
                .cooldown(ability.cooldown())
                .damage(ability.damage())
                .life(ability.life())
                .timeToHit(ability.timeToHit())
                .build();
    }

    public static List<AttributeODTO> toAttributeODTOList(List<AttributeMO> attributes, String language) {
        return attributes.stream()
                .map(attribute -> toAttributeODTO(attribute, language))
                .toList();
    }

    public static AttributeODTO toAttributeODTO(AttributeMO attribute, String language) {
        if (attribute == null) {
            return null;
        }

        return AttributeODTO.builder()
                .identifier(attribute.identifier())
                .name(StringTranslator.translate(attribute.name(), language))
                .description(StringTranslator.translate(attribute.description(), language))
                .build();
    }

    public static List<AttributeMO> toAttributeMOList(List<AttributeIDTO> attributes) {
        return attributes.stream()
                .map(CharacterMapperUtils::toAttributeMO)
                .toList();
    }

    public static AttributeMO toAttributeMO(AttributeIDTO attribute) {
        if (attribute == null) {
            return null;
        }

        return AttributeMO.builder()
                .identifier(attribute.identifier())
                .name(attribute.name())
                .description(attribute.description())
                .build();
    }

    public static List<AttributeIDTO> toAttributeIDTOList(List<AttributeRQDTO> attributes) {
        return attributes.stream()
                .map(CharacterMapperUtils::toAttributeIDTO)
                .toList();
    }

    public static AttributeIDTO toAttributeIDTO(AttributeRQDTO attribute) {
        if (attribute == null) {
            return null;
        }

        return AttributeIDTO.builder()
                .identifier(attribute.identifier())
                .name(attribute.name())
                .description(attribute.description())
                .build();
    }

    public static List<AttributeRSDTO> toAttributeRSDTOList(List<AttributeODTO> attributes) {
        return attributes.stream()
                .map(CharacterMapperUtils::toAttributeRSDTO)
                .toList();
    }

    public static AttributeRSDTO toAttributeRSDTO(AttributeODTO attribute) {
        if (attribute == null) {
            return null;
        }

        return AttributeRSDTO.builder()
                .identifier(attribute.identifier())
                .name(attribute.name())
                .description(attribute.description())
                .build();
    }

    public static StatODTO<Double> toStatODTO(StatMO<Double> stats) {
        if (stats == null) {
            return null;
        }

        return StatODTO.<Double>builder()
                .physicalDamage(stats.getPhysicalDamage())
                .magicalDamage(stats.getMagicalDamage())
                .physicalArmor(stats.getPhysicalArmor())
                .magicalArmor(stats.getMagicalArmor())
                .movementSpeed(stats.getMovementSpeed())
                .attackSpeed(stats.getAttackSpeed())
                .criticalStrike(stats.getCriticalStrike())
                .criticalStrikeProbability(stats.getCriticalStrikeProbability())
                .health(stats.getHealth())
                .ether(stats.getEther())
                .build();
    }

    public static StatMO<Double> toStatMO(StatIDTO<Double> stats) {
        if (stats == null) {
            return null;
        }

        return StatMO.<Double>builder()
                .physicalDamage(stats.getPhysicalDamage())
                .magicalDamage(stats.getMagicalDamage())
                .physicalArmor(stats.getPhysicalArmor())
                .magicalArmor(stats.getMagicalArmor())
                .movementSpeed(stats.getMovementSpeed())
                .attackSpeed(stats.getAttackSpeed())
                .criticalStrike(stats.getCriticalStrike())
                .criticalStrikeProbability(stats.getCriticalStrikeProbability())
                .health(stats.getHealth())
                .ether(stats.getEther())
                .build();
    }

    public static StatIDTO<Double> toStatIDTO(StatRQDTO<Double> stats) {
        if (stats == null) {
            return null;
        }

        return StatIDTO.<Double>builder()
                .physicalDamage(stats.getPhysicalDamage())
                .magicalDamage(stats.getMagicalDamage())
                .physicalArmor(stats.getPhysicalArmor())
                .magicalArmor(stats.getMagicalArmor())
                .movementSpeed(stats.getMovementSpeed())
                .attackSpeed(stats.getAttackSpeed())
                .criticalStrike(stats.getCriticalStrike())
                .criticalStrikeProbability(stats.getCriticalStrikeProbability())
                .health(stats.getHealth())
                .ether(stats.getEther())
                .build();
    }

    public static StatRSDTO<Double> toStatRSDTO(StatODTO<Double> stats) {
        if (stats == null) {
            return null;
        }

        return StatRSDTO.<Double>builder()
                .physicalDamage(stats.getPhysicalDamage())
                .magicalDamage(stats.getMagicalDamage())
                .physicalArmor(stats.getPhysicalArmor())
                .magicalArmor(stats.getMagicalArmor())
                .movementSpeed(stats.getMovementSpeed())
                .attackSpeed(stats.getAttackSpeed())
                .criticalStrike(stats.getCriticalStrike())
                .criticalStrikeProbability(stats.getCriticalStrikeProbability())
                .health(stats.getHealth())
                .ether(stats.getEther())
                .build();
    }
}
