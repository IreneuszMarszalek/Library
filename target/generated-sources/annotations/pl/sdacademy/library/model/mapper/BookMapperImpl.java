package pl.sdacademy.library.model.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import pl.sdacademy.library.model.dto.BookDto;
import pl.sdacademy.library.model.entity.Book;
import pl.sdacademy.library.model.entity.BookTurnover;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-20T22:21:49+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
public class BookMapperImpl implements BookMapper {

    @Override
    public Book map(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDto.getId() );
        book.setTitle( bookDto.getTitle() );
        book.setAuthor( bookDto.getAuthor() );
        Set<BookTurnover> set = bookDto.getTurnovers();
        if ( set != null ) {
            book.setTurnovers( new HashSet<BookTurnover>( set ) );
        }

        return book;
    }

    @Override
    public BookDto map(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setId( book.getId() );
        bookDto.setTitle( book.getTitle() );
        bookDto.setAuthor( book.getAuthor() );
        Set<BookTurnover> set = book.getTurnovers();
        if ( set != null ) {
            bookDto.setTurnovers( new HashSet<BookTurnover>( set ) );
        }

        return bookDto;
    }

    @Override
    public List<BookDto> map(List<Book> bookList) {
        if ( bookList == null ) {
            return null;
        }

        List<BookDto> list = new ArrayList<BookDto>( bookList.size() );
        for ( Book book : bookList ) {
            list.add( map( book ) );
        }

        return list;
    }
}
