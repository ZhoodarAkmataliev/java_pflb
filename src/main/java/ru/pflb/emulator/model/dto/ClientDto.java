package ru.pflb.emulator.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private boolean isActive;
}
