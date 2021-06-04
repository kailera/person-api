package com.example.personapi.utils;


import com.example.personapi.DTO.requests.PhoneDTO;
import com.example.personapi.entities.Phone;
import com.example.personapi.enuns.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
        return PhoneDTO
                .builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity(){
        return Phone
                .builder()
                .id(PHONE_ID)
                .type(PHONE_TYPE)
                .number(PHONE_NUMBER)
                .build();
    }

}
