package ru.pflb.emulator.service;

import ru.pflb.emulator.model.dto.ClientDto;

public interface ClientService {
    ClientDto getUserById(long id);
    int addClient(long id);
}
