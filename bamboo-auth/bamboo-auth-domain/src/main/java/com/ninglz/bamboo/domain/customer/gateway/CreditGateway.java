package com.ninglz.bamboo.domain.customer.gateway;

import com.ninglz.bamboo.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
