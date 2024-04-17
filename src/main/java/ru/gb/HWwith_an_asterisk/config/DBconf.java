package ru.gb.HWwith_an_asterisk.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "db")//при помощи этой аннотации мы
//связываем данные из класса UserRepository с Application.properties
@Getter
@Setter

public class DBconf {
    private String findAll;
    private String save;
    private String deleteById;
    private String updateById;
}
