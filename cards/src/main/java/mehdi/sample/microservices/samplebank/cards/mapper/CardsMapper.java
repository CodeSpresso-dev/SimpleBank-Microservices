package mehdi.sample.microservices.samplebank.cards.mapper;

import mehdi.sample.microservices.samplebank.cards.dto.CardsDto;
import mehdi.sample.microservices.samplebank.cards.entity.Cards;
import org.springframework.beans.BeanUtils;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
//        cardsDto.setCardNumber(cards.getCardNumber());
//        cardsDto.setCardType(cards.getCardType());
//        cardsDto.setMobileNumber(cards.getMobileNumber());
//        cardsDto.setTotalLimit(cards.getTotalLimit());
//        cardsDto.setAvailableAmount(cards.getAvailableAmount());
//        cardsDto.setAmountUsed(cards.getAmountUsed());
        BeanUtils.copyProperties(cards,cardsDto);
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
//        cards.setCardNumber(cardsDto.getCardNumber());
//        cards.setCardType(cardsDto.getCardType());
//        cards.setMobileNumber(cardsDto.getMobileNumber());
//        cards.setTotalLimit(cardsDto.getTotalLimit());
//        cards.setAvailableAmount(cardsDto.getAvailableAmount());
//        cards.setAmountUsed(cardsDto.getAmountUsed());
        BeanUtils.copyProperties(cardsDto,cards);
        return cards;
    }

}
