package com.aschalew.bookstore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity(name = "categories")
public class Category {

    @Id
    @GeneratedValue
    private Long catId;

    private String name;

    /*@OneToMany
    private List<Book> books = new ArrayList<>();*/

   /* @OneToMany
    private Collection<Book> books = new ArrayList<>();*/


}
