
package com.emilie.Lib7.Services.impl;

import com.emilie.Lib7.Exceptions.AuthorAlreadyExistException;
import com.emilie.Lib7.Exceptions.AuthorNotFoundException;
import com.emilie.Lib7.Models.Dtos.AuthorDto;
import com.emilie.Lib7.Models.Dtos.BookDto;
import com.emilie.Lib7.Models.Entities.Author;
import com.emilie.Lib7.Models.Entities.Book;
import com.emilie.Lib7.Repositories.AuthorsRepository;
import com.emilie.Lib7.Services.contract.AuthorsService;
import com.emilie.Lib7.Services.contract.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorsServiceImpl implements AuthorsService {


    private final AuthorsRepository authorsRepository;




    @Autowired
    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository=authorsRepository;


    }

    @Override
    public List<AuthorDto> findAll() {
        return null;
    }

    @Override
    public AuthorDto findById(Long id) throws AuthorNotFoundException {
        Optional<Author> optionalAuthor=authorsRepository.findById( id );
        if (!optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException( "Author not found" );
        }
        Author author=optionalAuthor.get();
        return authorToAuthorDto( author );
    }


    @Override
    public AuthorDto save(AuthorDto authorDto) throws AuthorAlreadyExistException {
        Optional<Author> optionalAuthor=authorsRepository.findById( authorDto.getAuthorId() );
        if (optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException( "author already exists" );
        }
        Author author=authorDtoToAuthor( authorDto );
        author=authorsRepository.save( author );

        return authorToAuthorDto( author );
    }


    @Override
    public AuthorDto update(AuthorDto authorDto) {
        Optional<Author> optionalAuthor=authorsRepository.findById( authorDto.getAuthorId() );
        Author author=authorDtoToAuthor( authorDto );
        author=authorsRepository.save( author );
        return authorToAuthorDto( author );
    }

    @Override
    public boolean deleteById(Long id) throws AuthorNotFoundException {
        Optional<Author> optionalAuthor=authorsRepository.findById( id );
        if (!optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException( "author not found" );
        }
        try {
            authorsRepository.deleteById( id );
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public AuthorDto findByFirstName(String firstName) {
        Optional<Author> optionalAuthor=authorsRepository.findByFirstName( firstName );
        if (!optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException( "author not found" );
        }
        Author author=optionalAuthor.get();

        return authorToAuthorDto( author );
    }

    @Override
    public AuthorDto findByLastName(String lastName) {
        Optional<Author> optionalAuthor=authorsRepository.findByLastName( lastName );
        if (!optionalAuthor.isPresent()) {
            throw new AuthorNotFoundException( "author not found" );
        }
        Author author=optionalAuthor.get();

        return authorToAuthorDto( author );
    }


    private AuthorDto authorToAuthorDto(Author author) {
        AuthorDto authorDto=new AuthorDto();
        authorDto.setAuthorId( author.getAuthorId() );
        authorDto.setFirstName( author.getFirstName() );
        authorDto.setLastName( author.getLastName() );

        ArrayList<BookDto> bookDtos=new ArrayList<BookDto>();

        for (Book book : author.getBooks()) {
            BookDto bookDto=new BookDto();
            bookDto.setBookId( book.getBookId() );
            bookDto.setTitle( book.getTitle() );
            bookDto.setIsbn( book.getIsbn() );
            bookDto.setSummary( book.getSummary() );
            /*bookDto.setCopy(book.ge);*/
            bookDtos.add( bookDto );
        }
        authorDto.setBooks( bookDtos );
        return authorDto;
    }

    private Author authorDtoToAuthor(AuthorDto authorDto) {
        Author author=new Author();
        author.setAuthorId( authorDto.getAuthorId() );
        author.setFirstName( authorDto.getFirstName() );
        author.setLastName( authorDto.getLastName() );


        Set<Book> books=new HashSet<>();

        for (BookDto bookDto : authorDto.getBooks()) {
            Book book=new Book();
            book.setBookId( bookDto.getBookId() );
            book.setTitle( bookDto.getTitle() );
            book.setIsbn( bookDto.getIsbn() );
            book.setSummary( bookDto.getSummary() );
            books.add( book );
        }
        author.setBooks( books );
        return author;
    }
}
