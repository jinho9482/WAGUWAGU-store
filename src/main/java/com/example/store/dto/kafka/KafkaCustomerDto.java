package com.example.store.dto.kafka;

import java.time.LocalDateTime;

public record KafkaCustomerDto(
        Long customerId,
        double longitude,
        double latitude
) {
}