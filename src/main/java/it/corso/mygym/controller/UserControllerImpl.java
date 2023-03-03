package it.corso.mygym.controller;

import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;
import it.corso.mygym.model.exception.UserNotFoundException;
import it.corso.mygym.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserControllerImpl(final UserService userService) {this.userService = userService;}

    @Override
    @PostMapping(

    )
    public ResponseEntity<User> save(@Valid @RequestBody UserDto userDto) {
        User userSaved = userService.save(userDto);

        // TODO: create UserSuccessResponse
        // TODO: add metadata
        // TODO: add status

        ModelMapper modelMapper = new ModelMapper();

        //return userService.save(modelMapper.map(userDto, ResponseEntity.class));

        // TODO: return complete response
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User userFind = userService.findById(id);
        return new ResponseEntity<>(userFind,HttpStatus.FOUND);
    }

    @RequestMapping( method = RequestMethod.GET )
    @ResponseBody
    public ResponseEntity<List<User>> findAll(){
        List<User> usersFind = userService.findAll(true);
        return new ResponseEntity<>(usersFind,HttpStatus.FOUND);


    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(value="id") Long id, @Valid @RequestBody UserDto userDto) throws UserNotFoundException{
        User userUpdated = userService.update(id, userDto);

        return ResponseEntity.ok(userUpdated);
    }

    @ExceptionHandler({UserNotFoundException.class})
    private ResponseEntity <?> userNotFound(RuntimeException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}