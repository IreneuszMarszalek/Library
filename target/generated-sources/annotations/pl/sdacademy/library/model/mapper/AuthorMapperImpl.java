package pl.sdacademy.library.model.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import pl.sdacademy.library.model.dto.AuthorDto;
import pl.sdacademy.library.model.entity.Author;
import pl.sdacademy.library.model.entity.Book;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-20T20:07:05+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author map(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( authorDto.getId() );
        author.setName( authorDto.getName() );
        author.setSecondName( authorDto.getSecondName() );
        Set<Book> set = authorDto.getBooks();
        if ( set != null ) {
            author.setBooks( new HashSet<Book>( set ) );
        }

        return author;
    }

    @Override
    public AuthorDto map(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorDto authorDto = new AuthorDto();

        authorDto.setId( author.getId() );
        authorDto.setName( author.getName() );
        authorDto.setSecondName( author.getSecondName() );
        Set<Book> set = author.getBooks();
        if ( set != null ) {
            authorDto.setBooks( new HashSet<Book>( set ) );
        }

        return authorDto;
    }

    @Override
    public List<AuthorDto> map(List<Author> authorList) {
        if ( authorList == null ) {
            return null;
        }

        List<AuthorDto> list = new ArrayList<AuthorDto>( authorList.size() );
        for ( Author author : authorList ) {
            list.add( map( author ) );
        }

        return list;
    }
}
