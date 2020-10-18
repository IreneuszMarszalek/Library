package pl.sdacademy.library.model.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.sdacademy.library.model.dto.BookTurnoverDto;
import pl.sdacademy.library.model.entity.BookTurnover;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-10-18T19:59:09+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.8 (JetBrains s.r.o.)"
)
public class BookTurnoverMapperImpl implements BookTurnoverMapper {

    @Override
    public BookTurnover map(BookTurnoverDto bookTurnoverDto) {
        if ( bookTurnoverDto == null ) {
            return null;
        }

        BookTurnover bookTurnover = new BookTurnover();

        bookTurnover.setId( bookTurnoverDto.getId() );
        bookTurnover.setLoanDate( bookTurnoverDto.getLoanDate() );
        bookTurnover.setReturnDate( bookTurnoverDto.getReturnDate() );
        bookTurnover.setPeriod( bookTurnoverDto.getPeriod() );
        bookTurnover.setUser( bookTurnoverDto.getUser() );
        bookTurnover.setBook( bookTurnoverDto.getBook() );

        return bookTurnover;
    }

    @Override
    public BookTurnoverDto map(BookTurnover bookTurnover) {
        if ( bookTurnover == null ) {
            return null;
        }

        BookTurnoverDto bookTurnoverDto = new BookTurnoverDto();

        bookTurnoverDto.setId( bookTurnover.getId() );
        bookTurnoverDto.setLoanDate( bookTurnover.getLoanDate() );
        bookTurnoverDto.setReturnDate( bookTurnover.getReturnDate() );
        bookTurnoverDto.setPeriod( bookTurnover.getPeriod() );
        bookTurnoverDto.setUser( bookTurnover.getUser() );
        bookTurnoverDto.setBook( bookTurnover.getBook() );

        return bookTurnoverDto;
    }

    @Override
    public List<BookTurnoverDto> map(List<BookTurnover> bookTurnovers) {
        if ( bookTurnovers == null ) {
            return null;
        }

        List<BookTurnoverDto> list = new ArrayList<BookTurnoverDto>( bookTurnovers.size() );
        for ( BookTurnover bookTurnover : bookTurnovers ) {
            list.add( map( bookTurnover ) );
        }

        return list;
    }
}
