package com.codestates.CordJg.cafe.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mapstruct.MapperConfig;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long coffeeId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CoffeeStatus coffeeStatus = CoffeeStatus.COFFEE_FOR_SALE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false, name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public enum CoffeeStatus {
        COFFEE_FOR_SALE("판매중"),
        COFFEE_SOLD_OUT("판매중지"),
        ;

        @Getter
        private String status;

        CoffeeStatus(String status) {
            this.status = status;
        }
    }


}


