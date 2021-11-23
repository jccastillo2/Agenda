package demo.demo.repository

import demo.demo.model.Actividades
import org.springframework.data.jpa.repository.JpaRepository

interface actividadesRepository: JpaRepository<Actividades, Long> {
    fun findById (id:Long?):Actividades?
}