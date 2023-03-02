package it.corso.mygym.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gym")
public class Gym implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;
    private String email;

    @Column(unique = true)
    private String partitaIva;

    @OneToMany(mappedBy = "gym")
    private List<Subscription> subscriptions;




}
