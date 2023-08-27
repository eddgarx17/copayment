package com.copayment.services;

import com.copayment.models.UserModel;
import com.copayment.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service

public class UserService {
    @Autowired
    private  IUserRepository usersRepository;
//    @Autowired
//    private  PasswordEncoder passwordEncoder;
    public boolean ValidUser(String usuario, String password) {
        /** Buscamos el usuario por el nombre de usuario en el repositorio**/

        UserModel users = usersRepository.findByusuario(usuario);
        /**
         *  Verificamos si el usuario existe y si la contraseña coincide
         *  **/
        if (users != null &&  users.getPassword().equals(password)) {
            /**
             * Si existe y coincide el usuario y contrasena devolvera true
             * */
            return true;
           // return passwordEncoder.matches(password, users.getPassword());
        }
        /**
        *Si el usuario o contrasena no coinciden devolera false
        * */
        return false;
    }
}
