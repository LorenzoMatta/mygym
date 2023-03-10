package it.corso.mygym.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GymDto {
    private Long id;

    private String name;

    private String address;
    private String email;


    private String partitaIva;
}
