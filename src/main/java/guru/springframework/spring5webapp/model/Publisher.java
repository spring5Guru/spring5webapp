package guru.springframework.spring5webapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created By danielhwang on Jun, 2018
 */
@Data
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @OneToOne
    private Book book;


    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
        this.book = book;
    }
}
