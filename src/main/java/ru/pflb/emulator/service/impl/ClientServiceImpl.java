package ru.pflb.emulator.service.impl;

import ch.qos.logback.core.net.server.Client;
import org.springframework.stereotype.Service;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ClientServiceImpl implements ClientService {
    List<ClientDto> clientsList = new ArrayList<>();
    @Override
    public ClientDto getUserById(long id) {
        ClientDto client = ClientDto.builder()
                .id(id)
                .firstName(randomString(7))
                .cardNumber("" + getRandomNumber(0, 10))
                .isActive(getRandomBool())
                .lastName(randomString(10))
                .build();
        return client;
    }

    @Override
    public int addClient(long id) {
        ClientDto client = ClientDto.builder()
                .id(id)
                .firstName(randomString(7))
                .cardNumber("" + getRandomNumber(0, 10))
                .isActive(getRandomBool())
                .lastName(randomString(10))
                .build();
        clientsList.add(client);
        return 1;
    }

    private boolean getRandomBool() {
        if (getRandomNumber(0,11) > 5)
            return false;
        else
            return true;
    }

    public String randomString( int length) {
        String generatedString = "";
        String temp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < length; i++)
            generatedString += temp.charAt(getRandomNumber(0,25));
        return generatedString;
    }

    public static int getRandomNumber(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
}
