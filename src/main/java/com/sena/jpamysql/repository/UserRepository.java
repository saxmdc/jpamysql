// Indica el paquete al que pertenece esta interfaz
package com.sena.jpamysql.repository;

// Importa la entidad User sobre la cual se realizarán las operaciones CRUD
import com.sena.jpamysql.entity.User;

// Importa la interfaz CrudRepository de Spring Data.
// Esta interfaz proporciona automáticamente los métodos CRUD
// (Crear, Leer, Actualizar y Eliminar) sin necesidad de implementarlos.
import org.springframework.data.repository.CrudRepository;

// Declara la interfaz UserRepository.
// Al extender CrudRepository, Spring genera automáticamente
// la implementación de esta interfaz durante la ejecución.
public interface UserRepository extends CrudRepository<User, Integer> {

    // No es necesario escribir ningún método para disponer
    // de las operaciones básicas sobre la entidad User.

    // Spring Data JPA implementa automáticamente métodos como:

    // save(User entity)
    // Guarda un nuevo usuario o actualiza uno existente.

    // findById(Integer id)
    // Busca un usuario por su clave primaria.

    // findAll()
    // Obtiene todos los usuarios de la base de datos.

    // deleteById(Integer id)
    // Elimina un usuario mediante su ID.

    // delete(User entity)
    // Elimina el objeto recibido.

    // existsById(Integer id)
    // Verifica si existe un usuario con ese ID.

    // count()
    // Devuelve la cantidad total de usuarios registrados.
}