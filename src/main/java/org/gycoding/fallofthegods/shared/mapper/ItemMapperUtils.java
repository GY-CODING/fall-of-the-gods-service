package org.gycoding.fallofthegods.shared.mapper;

import org.gycoding.fallofthegods.application.dto.in.StatIDTO;
import org.gycoding.fallofthegods.application.dto.in.items.ItemIDTO;
import org.gycoding.fallofthegods.application.dto.in.items.ItemStatIDTO;
import org.gycoding.fallofthegods.application.dto.out.StatODTO;
import org.gycoding.fallofthegods.application.dto.out.characters.AbilityODTO;
import org.gycoding.fallofthegods.application.dto.out.characters.AttributeODTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemODTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemStatODTO;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.characters.AbilityMO;
import org.gycoding.fallofthegods.domain.model.characters.AttributeMO;
import org.gycoding.fallofthegods.domain.model.items.ItemMO;
import org.gycoding.fallofthegods.domain.model.items.ItemStatMO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.StatRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.in.items.ItemStatRQDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.StatRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemRSDTO;
import org.gycoding.fallofthegods.infrastructure.api.dto.out.items.ItemStatRSDTO;
import org.gycoding.fallofthegods.shared.util.StringTranslator;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapperUtils {
    private static ItemStatODTO toItemStatODTO(ItemStatMO stat) {
        return ItemStatODTO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    public static StatODTO<ItemStatODTO> toStatODTO(StatMO<ItemStatMO> stats) {
        if (stats == null) {
            return null;
        }

        return StatODTO.<ItemStatODTO>builder()
                .physicalDamage(toItemStatODTO(stats.getPhysicalDamage()))
                .magicalDamage(toItemStatODTO(stats.getMagicalDamage()))
                .physicalArmor(toItemStatODTO(stats.getPhysicalArmor()))
                .magicalArmor(toItemStatODTO(stats.getMagicalArmor()))
                .movementSpeed(toItemStatODTO(stats.getMovementSpeed()))
                .attackSpeed(toItemStatODTO(stats.getAttackSpeed()))
                .criticalStrike(toItemStatODTO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toItemStatODTO(stats.getCriticalStrikeProbability()))
                .health(toItemStatODTO(stats.getHealth()))
                .ether(toItemStatODTO(stats.getEther()))
                .build();
    }

    private static ItemStatMO toItemStatMO(ItemStatIDTO stat) {
        return ItemStatMO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    public static StatMO<ItemStatMO> toStatMO(StatIDTO<ItemStatIDTO> stats) {
        if (stats == null) {
            return null;
        }

        return StatMO.<ItemStatMO>builder()
                .physicalDamage(toItemStatMO(stats.getPhysicalDamage()))
                .magicalDamage(toItemStatMO(stats.getMagicalDamage()))
                .physicalArmor(toItemStatMO(stats.getPhysicalArmor()))
                .magicalArmor(toItemStatMO(stats.getMagicalArmor()))
                .movementSpeed(toItemStatMO(stats.getMovementSpeed()))
                .attackSpeed(toItemStatMO(stats.getAttackSpeed()))
                .criticalStrike(toItemStatMO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toItemStatMO(stats.getCriticalStrikeProbability()))
                .health(toItemStatMO(stats.getHealth()))
                .ether(toItemStatMO(stats.getEther()))
                .build();
    }

    private static ItemStatIDTO toItemStatIDTO(ItemStatRQDTO stat) {
        return ItemStatIDTO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    public static StatIDTO<ItemStatIDTO> toStatIDTO(StatRQDTO<ItemStatRQDTO> stats) {
        if (stats == null) {
            return null;
        }

        return StatIDTO.<ItemStatIDTO>builder()
                .physicalDamage(toItemStatIDTO(stats.getPhysicalDamage()))
                .magicalDamage(toItemStatIDTO(stats.getMagicalDamage()))
                .physicalArmor(toItemStatIDTO(stats.getPhysicalArmor()))
                .magicalArmor(toItemStatIDTO(stats.getMagicalArmor()))
                .movementSpeed(toItemStatIDTO(stats.getMovementSpeed()))
                .attackSpeed(toItemStatIDTO(stats.getAttackSpeed()))
                .criticalStrike(toItemStatIDTO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toItemStatIDTO(stats.getCriticalStrikeProbability()))
                .health(toItemStatIDTO(stats.getHealth()))
                .ether(toItemStatIDTO(stats.getEther()))
                .build();
    }

    private static ItemStatRSDTO toItemStatRSDTO(ItemStatODTO stat) {
        return ItemStatRSDTO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    public static StatRSDTO<ItemStatRSDTO> toStatRSDTO(StatODTO<ItemStatODTO> stats) {
        if (stats == null) {
            return null;
        }

        return StatRSDTO.<ItemStatRSDTO>builder()
                .physicalDamage(toItemStatRSDTO(stats.getPhysicalDamage()))
                .magicalDamage(toItemStatRSDTO(stats.getMagicalDamage()))
                .physicalArmor(toItemStatRSDTO(stats.getPhysicalArmor()))
                .magicalArmor(toItemStatRSDTO(stats.getMagicalArmor()))
                .movementSpeed(toItemStatRSDTO(stats.getMovementSpeed()))
                .attackSpeed(toItemStatRSDTO(stats.getAttackSpeed()))
                .criticalStrike(toItemStatRSDTO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toItemStatRSDTO(stats.getCriticalStrikeProbability()))
                .health(toItemStatRSDTO(stats.getHealth()))
                .ether(toItemStatRSDTO(stats.getEther()))
                .build();
    }

    public static List<ItemODTO> toItemODTOList(List<ItemMO> items, String language) {
        return items.stream()
                .map(item -> toItemODTO(item, language))
                .toList();
    }

    public static ItemODTO toItemODTO(ItemMO item, String language) {
        if (item == null) {
            return null;
        }

        return ItemODTO.builder()
                .identifier(item.identifier())
                .name(StringTranslator.translate(item.name(), language))
                .description(StringTranslator.translate(item.description(), language))
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(ItemMapperUtils.toStatODTO(item.stats()))
                .fragments(null)
                .build();
    }

    public static List<ItemMO> toItemMOList(List<ItemIDTO> items) {
        return items.stream()
                .map(ItemMapperUtils::toItemMO)
                .toList();
    }

    public static ItemMO toItemMO(ItemIDTO item) {
        if (item == null) {
            return null;
        }

        return ItemMO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(toStatMO(item.stats()))
                .fragments(null)
                .build();
    }

    public static List<ItemIDTO> toItemIDTOList(List<ItemRQDTO> items) {
        return items.stream()
                .map(ItemMapperUtils::toItemIDTO)
                .toList();
    }

    public static ItemIDTO toItemIDTO(ItemRQDTO item) {
        if (item == null) {
            return null;
        }

        return ItemIDTO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(toStatIDTO(item.stats()))
                .fragments(toItemIDTOList(item.fragments()))
                .build();
    }

    public static List<ItemRSDTO> toItemRSDTOList(List<ItemODTO> items) {
        return items.stream()
                .map(ItemMapperUtils::toItemRSDTO)
                .toList();
    }

    public static ItemRSDTO toItemRSDTO(ItemODTO item) {
        if (item == null) {
            return null;
        }

        return ItemRSDTO.builder()
                .identifier(item.identifier())
                .name(item.name())
                .description(item.description())
                .inGame(item.inGame())
                .image(item.image())
                .type(item.type())
                .stats(toStatRSDTO(item.stats()))
                .fragments(toItemRSDTOList(item.fragments()))
                .build();
    }
}
