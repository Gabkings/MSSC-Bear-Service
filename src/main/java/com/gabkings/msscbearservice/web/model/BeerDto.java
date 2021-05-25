package com.gabkings.msscbearservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static com.gabkings.msscbearservice.web.model.BeerStyleEnum.LAGER;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BeerDto {

    private UUID id;
    private BigDecimal price;
    private Integer quantityOnHand;
    private BeerStyleEnum beerStyleEnum = LAGER;
    private Long upc;
    private String beerName;
    private Integer version;
    private OffsetDateTime createdOn;
    private OffsetDateTime lastModified;
}
