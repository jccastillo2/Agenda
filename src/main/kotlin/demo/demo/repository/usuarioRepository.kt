package demo.demo.repository

import demo.demo.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface usuarioRepository:JpaRepository<Usuario, Long> {
    fun findById (id:Long?):Usuario?
}