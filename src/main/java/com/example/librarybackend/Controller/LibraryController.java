package com.example.librarybackend.Controller;


import com.example.librarybackend.Dao.LibraryDao;
import com.example.librarybackend.Model.LibraryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
