package com.copayment.controllers;

import com.copayment.models.UserModel;
import com.copayment.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@RestController se utiliza para marcar una clase como un controlador REST

public class UsersController {
    @Autowired
    private  UserService userService;
  /**
   * Login
   *  valida el usuario y la contrasena de los
   * usuarios registrados, si el usuario y la contrasena son validos
   * regresara el mensaje Inicio corrrecto, de lo contrario debera mostrar el mensaje de usuario incorrecto.
   * */
    @PostMapping("/login")
    public String validUser(@RequestBody UserModel userModel){
        if (userService.ValidUser(userModel.getUsuario(), userModel.getPassword())) {
            return "Login, Inicio correcto.";
        }
            return "El usuario o contrasena es incorrecto.";

    }

}
