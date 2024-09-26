package com.emazon.msvc_transaction.adapters.driving.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddSupplyRequestDto {
    private Long articleId;
    private int quantityAdded;
    private Date dateNextSupply;
    private int quantityNextSupply;
}
