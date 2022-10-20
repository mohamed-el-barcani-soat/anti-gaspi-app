package com.soat.anti_gaspi.application.controller.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class OfferPage {
    List<SavedOfferDto> elements;
    int pageCount;
}
