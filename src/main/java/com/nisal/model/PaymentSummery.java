package com.nisal.model;

import com.nisal.domain.PaymentType;
import lombok.Data;

@Data
public class PaymentSummery {

    private PaymentType type;
    private Double totalAmount;
    private int transactionCount;
    private double percentage;

}
