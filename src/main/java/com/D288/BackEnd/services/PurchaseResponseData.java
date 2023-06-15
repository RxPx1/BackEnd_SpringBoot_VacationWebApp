package com.D288.BackEnd.services;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Data
public class PurchaseResponseData {

    private final String orderTrackingNumber;

}
