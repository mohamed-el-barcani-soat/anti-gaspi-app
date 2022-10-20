package com.soat.anti_gaspi.application.controller.offer.dto;

import com.soat.anti_gaspi.domain.Offer;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;

public class PaginatedOffersMapper {

    public static OfferPage map(List<Offer> offers, int pageNumber, int pageSize, String sortBy, String sortOrder) {
        var page = new PagedListHolder<>(offers);
        page.setPageSize(pageSize);
        page.setPage(pageNumber);
        page.setSort(new MutableSortDefinition(sortBy, true, "asc".equals(sortOrder)));

        return new OfferPage(page.getPageList().stream()
                .map(OfferDtoMapper::map)
                .toList(),
                page.getPageCount());
    }
}
