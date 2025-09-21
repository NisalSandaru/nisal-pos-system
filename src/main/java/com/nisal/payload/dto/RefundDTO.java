package com.nisal.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nisal.domain.PaymentType;
import com.nisal.model.Branch;
import com.nisal.model.Order;
import com.nisal.model.ShiftReport;
import com.nisal.model.User;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RefundDTO {
    private Long id;

    private OrderDTO order;
    private Long orderId;

    private String reason;

    private Double amount;

//    private ShiftReport shiftReport;
    private Long shiftReportId;

    private UserDto cashier;
    private String cashierName;

    private BranchDTO branch;
    private Long branchId;

    private PaymentType paymentType;

    private LocalDateTime createdAt;
}
