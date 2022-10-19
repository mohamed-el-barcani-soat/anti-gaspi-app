package com.soat.anti_gaspi.controller;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Setter
// TODO remove setter or data
public class OfferPage {
    List<SavedOffer> offers;
    int pageCount;
}
