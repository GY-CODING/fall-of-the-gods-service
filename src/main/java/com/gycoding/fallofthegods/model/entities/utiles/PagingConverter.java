package com.gycoding.fallofthegods.model.entities.utiles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PagingConverter {
    public static <T> Page<T> listToPage(List<T> list, Pageable pageable) {
        int start       = (int) pageable.getOffset();
        int end         = Math.min((start + pageable.getPageSize()), list.size());

        List<T> subList = list.subList(start, end);

        return new PageImpl<>(subList, pageable, list.size());
    }
}
