package com.practice.springboot.entity;



import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String author;
    private String category;
    private String title;




}
