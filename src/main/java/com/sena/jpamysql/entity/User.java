// Indica el paquete donde se encuentra la clase
package com.sena.jpamysql.entity;

// Importa la anotación @Nullable para indicar que un atributo puede contener un valor nulo
import org.jspecify.annotations.Nullable;

// Importaciones de JPA (Jakarta Persistence)
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Indica que esta clase es una entidad JPA.
// Hibernate la convertirá automáticamente en una tabla de la base de datos.
@Entity
public class User {

    // Indica que este atributo será la clave primaria (Primary Key) de la tabla.
    @Id

    // Especifica que el valor del ID será generado automáticamente.
    // GenerationType.AUTO permite que Hibernate elija la mejor estrategia
    // según la base de datos utilizada.
    @GeneratedValue(strategy = GenerationType.AUTO)

    // El identificador puede ser nulo antes de guardar el objeto en la base de datos.
    // Una vez guardado, Hibernate asignará un valor automáticamente.
    private @Nullable Integer id;

    // Campo que almacenará el nombre del usuario.
    // Se convertirá en una columna llamada "name".
    private String name;

    // Campo que almacenará el correo electrónico del usuario.
    // Se convertirá en una columna llamada "email".
    private String email;

    // ==========================
    // MÉTODOS GETTERS Y SETTERS
    // ==========================

    // Devuelve el valor del ID
    public Integer getId() {
        return id;
    }

    // Modifica el valor del ID.
    // Normalmente no se utiliza porque Hibernate lo genera automáticamente.
    public void setId(Integer id) {
        this.id = id;
    }

    // Devuelve el nombre del usuario
    public String getName() {
        return name;
    }

    // Asigna un nuevo nombre al usuario
    public void setName(String name) {
        this.name = name;
    }

    // Devuelve el correo electrónico del usuario
    public String getEmail() {
        return email;
    }

    // Asigna un nuevo correo electrónico al usuario
    public void setEmail(String email) {
        this.email = email;
    }
}