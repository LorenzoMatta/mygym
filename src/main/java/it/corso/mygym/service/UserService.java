package it.corso.mygym.service;


    import it.corso.mygym.model.User;
import it.corso.mygym.model.dto.UserDto;

import java.util.List;

    public interface UserService {

        User save(UserDto userDto);
         User update(Long id, UserDto userDto);

        User findById(Long id);


        User deleteById(Long id);

        List<User> findAll(boolean includeInactiveFlag);
    }

