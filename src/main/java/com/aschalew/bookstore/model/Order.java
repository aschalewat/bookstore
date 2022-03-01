package com.aschalew.bookstore.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;
    private Long customerId;
    private Double price;
    private int amount;
}
