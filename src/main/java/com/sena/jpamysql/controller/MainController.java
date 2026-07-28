// Indica el paquete al que pertenece esta clase
package com.sena.jpamysql.controller;

// Importa la entidad User, que representa la tabla de usuarios en la base de datos
import com.sena.jpamysql.entity.User;

// Importa el repositorio que permitirá realizar operaciones CRUD sobre la entidad User
import com.sena.jpamysql.repository.UserRepository;

// Permite que Spring inyecte automáticamente dependencias
import org.springframework.beans.factory.annotation.Autowired;

// Marca esta clase como un controlador de Spring MVC
import org.springframework.stereotype.Controller;

// Anotaciones para manejar solicitudes HTTP GET y POST
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// Permite definir una ruta base para todos los métodos del controlador
import org.springframework.web.bind.annotation.RequestMapping;

// Obtiene parámetros enviados desde la URL o desde un formulario
import org.springframework.web.bind.annotation.RequestParam;

// Indica que el valor retornado será enviado directamente al cliente
// en lugar de buscar una vista HTML
import org.springframework.web.bind.annotation.ResponseBody;

// Convierte esta clase en un controlador administrado por Spring
@Controller

// Todas las rutas de este controlador comenzarán con "/demo"
@RequestMapping(path="/demo")
public class MainController {

    // Inyección automática del repositorio UserRepository.
    // Spring crea el objeto automáticamente y lo asigna a esta variable.
    @Autowired
    private UserRepository userRepository;

    // Atiende únicamente solicitudes HTTP POST.
    // La ruta completa será: /demo/add
    @PostMapping(path="/add")

    // @ResponseBody hace que el String retornado se envíe directamente
    // como respuesta HTTP y no como el nombre de una vista.
    public @ResponseBody String addNewUser(

            // Obtiene el parámetro "name" enviado desde el formulario o URL
            @RequestParam String name,

            // Obtiene el parámetro "email"
            @RequestParam String email) {

        // Crea un nuevo objeto de tipo User
        User n = new User();

        // Asigna el nombre recibido al objeto
        n.setName(name);

        // Asigna el correo recibido al objeto
        n.setEmail(email);

        // Guarda el objeto en la base de datos.
        // Si el usuario no existe, realiza un INSERT.
        // Si ya existe (mismo ID), realiza un UPDATE.
        userRepository.save(n);

        // Devuelve un mensaje simple indicando que el registro fue exitoso
        return "Saved";
    }

    // Atiende solicitudes HTTP GET.
    // La ruta completa será: /demo/all
    @GetMapping(path="/all")

    // Devuelve directamente el resultado como JSON o XML
    public @ResponseBody Iterable<User> getAllUsers() {

        // Obtiene todos los usuarios almacenados en la base de datos.
        // findAll() es un método heredado de CrudRepository/JpaRepository.
        return userRepository.findAll();
    }
}