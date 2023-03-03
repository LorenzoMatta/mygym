package it.corso.mygym.model;

import jdk.jfr.BooleanFlag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String name;
    @Column(length = 30)
    private String surname;
    @Column(length = 30)
    private String email;

    private LocalDate birthDate;

    @BooleanFlag
    private boolean medicCertificate;
    @BooleanFlag
    private boolean activeFlag=true;

    @OneToMany(mappedBy = "user")
    private List<Subscription> subscriptions;
}
