package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher pub1 = new Publisher("대니얼","포항");
        Book  ddd = new Book("Domain Driven Design", "1234");


        eric.getBooks().add(ddd);

        pub1.setBook(ddd);

        ddd.setPublisher(pub1);
        ddd.getAuthors().add(eric);

        publisherRepository.save(pub1);
        authorRepository.save(eric);
        bookRepository.save(ddd);


        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher pub2 = new Publisher("Gin", "HaYa");
        Book noEJB = new Book("J2EE Development without EJB", "23444");

        rod.getBooks().add(noEJB);
        pub2.setBook(noEJB);
        noEJB.setPublisher(pub2);
        noEJB.getAuthors().add(rod);

        publisherRepository.save(pub2);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
