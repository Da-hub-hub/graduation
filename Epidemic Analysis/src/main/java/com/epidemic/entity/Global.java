package com.epidemic.entity;

import lombok.Data;

@Data
public class Global {
    Integer id;
    String provinceName;
    String countryEnglishName;
    Integer confirmedCount;
    Integer currentConfirmedCount;
    Integer curedCount;
    Integer deadCount;
    String countryName;


}
