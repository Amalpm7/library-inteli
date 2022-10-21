package com.example.librarybackend.Controller;


import com.example.librarybackend.Dao.LibraryDao;
import com.example.librarybackend.Model.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class LibraryController {

    @Autowired
    private LibraryDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String addLibrary(@RequestBody LibraryModel library){
        dao.save(library);
        return "{'status':'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<LibraryModel>viewLibrary(){
        return (List<LibraryModel>) dao.findAll();
    }


    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deletebook", consumes = "application/json", produces = "application/json")
    public String deletebook(@RequestBody LibraryModel library){
        dao.deleteBookById(library.getId());
        return "{status:success}";
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchBook", consumes = "application/json",produces = "application/json")
    public List<LibraryModel> searchBook(@RequestBody LibraryModel library){
        return (List<LibraryModel>) dao.searchBook(library.getBook_name());
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/editBook",consumes = "application/json",produces = "application/json")
    public String editBook(@RequestBody LibraryModel library){
        dao.updateBookById(  library.getBook_name(),library.getAuthor(),  library.getDate(), library.getVolume(), library.getId());
        return "(status:'success')";
    }
}
