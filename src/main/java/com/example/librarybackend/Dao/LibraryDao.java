package com.example.librarybackend.Dao;

import com.example.librarybackend.Model.LibraryModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryDao extends CrudRepository<LibraryModel,Integer> {
    @Modifying
    @Query(value = "DELETE FROM `libraries` WHERE `id`=:id",nativeQuery = true)
    void deleteBookById(Integer id);


    @Query(value = "SELECT `id`, `author`, `book_name`, `date`, `volume` FROM `libraries` WHERE `book_name`=:name",nativeQuery = true)
    List<LibraryModel> searchBook(String name);



    @Modifying
    @Query(value = "UPDATE `libraries` SET `book_name` =:book_name,`author` =:author,`date` =:date,`volume` =:volume WHERE `id`=:id",nativeQuery = true)
    void updateBookById(String book_name,String author, String date,String volume,Integer id );
}
