package com.image.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.image.entity.Book;

public interface BookRepository extends JpaRepository<Book, Serializable>
{

}
