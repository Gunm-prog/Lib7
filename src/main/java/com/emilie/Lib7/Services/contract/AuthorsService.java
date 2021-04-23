package com.emilie.Lib7.Services.contract;


import com.emilie.Lib7.Models.Dtos.AuthorDto;
import com.emilie.Lib7.Models.Entities.Author;

import java.util.List;

public interface AuthorsService {
    List<AuthorDto> findAll();
    AuthorDto findById(Long id);
    AuthorDto findByFirstName(String firstName);
    AuthorDto findByLastName(String lastName);
    AuthorDto save(AuthorDto authorDto);
    AuthorDto update(AuthorDto authorDto);
    boolean deleteById(Long id);

}
