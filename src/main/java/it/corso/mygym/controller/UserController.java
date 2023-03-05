package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/{users}")
public interface UserController {



    @PostMapping()
    ResponseEntity<User> save(@Valid @RequestBody UserDto userDto);

    @GetMapping("/{id}")
    ResponseEntity<User> findById(@PathVariable(value="id") Long id);
    @GetMapping()
    ResponseEntity <List<User>> findAll();


    @DeleteMapping("/{id}")
    ResponseEntity<User> deleteById(@PathVariable(value="id") Long id);

    @GetMapping()
    ResponseEntity<User> update(@PathVariable(value="id") Long id, @Valid @RequestBody UserDto userDto);
}