package demo.demo.repository

import demo.demo.model.Horario
import org.springframework.data.jpa.repository.JpaRepository

interface horarioRepository: JpaRepository<Horario, Long> {
    fun findById (id:Long?):Horario?
}