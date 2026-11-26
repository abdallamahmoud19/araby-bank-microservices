package com.araby.cards.mapper;

import com.araby.cards.dto.CardsDto;
import com.araby.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards) {
        CardsDto cardsDto = new CardsDto();
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        if (cardsDto.getCardNumber() != null) {
            cards.setCardNumber(cardsDto.getCardNumber());
        }
        if (cardsDto.getCardType() != null) {
            cards.setCardType(cardsDto.getCardType());
        }
        if (cardsDto.getMobileNumber() != null) {
            cards.setMobileNumber(cardsDto.getMobileNumber());
        }
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }

}
