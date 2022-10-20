package com.soat.anti_gaspi.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class OfferPage {
    List<SavedOfferDto> offers;
    int pageCount;
}
