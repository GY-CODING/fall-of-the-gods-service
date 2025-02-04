package org.gycoding.fallofthegods.shared.util;

import org.gycoding.fallofthegods.application.dto.in.StatIDTO;
import org.gycoding.fallofthegods.application.dto.in.items.ItemStatIDTO;
import org.gycoding.fallofthegods.application.dto.out.StatODTO;
import org.gycoding.fallofthegods.application.dto.out.items.ItemStatODTO;
import org.gycoding.fallofthegods.domain.model.StatMO;
import org.gycoding.fallofthegods.domain.model.items.ItemStatMO;
import org.gycoding.fallofthegods.infrastructure.external.database.model.StatEntity;
import org.gycoding.fallofthegods.infrastructure.external.database.model.items.ItemStatEntity;

public class MapperUtil {
    public static StatMO<ItemStatMO> toMOForItems(StatIDTO<ItemStatIDTO> stats) {
        return StatMO.<ItemStatMO>builder()
                .physicalDamage(toMO(stats.getPhysicalDamage()))
                .magicalDamage(toMO(stats.getMagicalDamage()))
                .physicalArmor(toMO(stats.getPhysicalArmor()))
                .magicalArmor(toMO(stats.getMagicalArmor()))
                .movementSpeed(toMO(stats.getMovementSpeed()))
                .attackSpeed(toMO(stats.getAttackSpeed()))
                .criticalStrike(toMO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toMO(stats.getCriticalStrikeProbability()))
                .health(toMO(stats.getHealth()))
                .ether(toMO(stats.getEther()))
                .build();
    }

    public static StatMO<ItemStatMO> toMOForItems(StatEntity<ItemStatEntity> stats) {
        return StatMO.<ItemStatMO>builder()
                .physicalDamage(toMO(stats.getPhysicalDamage()))
                .magicalDamage(toMO(stats.getMagicalDamage()))
                .physicalArmor(toMO(stats.getPhysicalArmor()))
                .magicalArmor(toMO(stats.getMagicalArmor()))
                .movementSpeed(toMO(stats.getMovementSpeed()))
                .attackSpeed(toMO(stats.getAttackSpeed()))
                .criticalStrike(toMO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toMO(stats.getCriticalStrikeProbability()))
                .health(toMO(stats.getHealth()))
                .ether(toMO(stats.getEther()))
                .build();
    }

    public static StatEntity<ItemStatEntity> toEntityForItems(StatMO<ItemStatMO> stats) {
        return StatEntity.<ItemStatEntity>builder()
                .physicalDamage(toEntity(stats.getPhysicalDamage()))
                .magicalDamage(toEntity(stats.getMagicalDamage()))
                .physicalArmor(toEntity(stats.getPhysicalArmor()))
                .magicalArmor(toEntity(stats.getMagicalArmor()))
                .movementSpeed(toEntity(stats.getMovementSpeed()))
                .attackSpeed(toEntity(stats.getAttackSpeed()))
                .criticalStrike(toEntity(stats.getCriticalStrike()))
                .criticalStrikeProbability(toEntity(stats.getCriticalStrikeProbability()))
                .health(toEntity(stats.getHealth()))
                .ether(toEntity(stats.getEther()))
                .build();
    }

    public static StatODTO<ItemStatODTO> toODTOForItems(StatMO<ItemStatMO> stats) {
        return StatODTO.<ItemStatODTO>builder()
                .physicalDamage(toODTO(stats.getPhysicalDamage()))
                .magicalDamage(toODTO(stats.getMagicalDamage()))
                .physicalArmor(toODTO(stats.getPhysicalArmor()))
                .magicalArmor(toODTO(stats.getMagicalArmor()))
                .movementSpeed(toODTO(stats.getMovementSpeed()))
                .attackSpeed(toODTO(stats.getAttackSpeed()))
                .criticalStrike(toODTO(stats.getCriticalStrike()))
                .criticalStrikeProbability(toODTO(stats.getCriticalStrikeProbability()))
                .health(toODTO(stats.getHealth()))
                .ether(toODTO(stats.getEther()))
                .build();
    }

    public static StatMO<Double> toMOForCharacters(StatIDTO<Double> stats) {
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

    public static StatMO<Double> toMOForCharacters(StatEntity<Double> stats) {
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

    public static StatEntity<Double> toEntityForCharacters(StatMO<Double> stats) {
        return StatEntity.<Double>builder()
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

    public static StatODTO<Double> toODTOForCharacters(StatMO<Double> stats) {
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

    private static ItemStatMO toMO(ItemStatIDTO stat) {
        return ItemStatMO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    private static ItemStatMO toMO(ItemStatEntity stat) {
        return ItemStatMO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    private static ItemStatEntity toEntity(ItemStatMO stat) {
        return ItemStatEntity.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }

    private static ItemStatODTO toODTO(ItemStatMO stat) {
        return ItemStatODTO.builder()
                .type(stat.type())
                .value(stat.value())
                .build();
    }
}
