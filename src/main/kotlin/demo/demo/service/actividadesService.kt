package demo.demo.service

import demo.demo.model.Actividades
import demo.demo.model.Horario
import demo.demo.repository.actividadesRepository
import demo.demo.repository.horarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class actividadesService {
    @Autowired
    lateinit var actividadesRepository: actividadesRepository


    fun list(): List<Actividades> {

        return actividadesRepository.findAll()
    }

    fun save(actividades: Actividades): Actividades {
        return actividadesRepository.save(actividades)
    }
    fun update (actividades: Actividades): Actividades {
        return actividadesRepository.save(actividades)
    }

    fun updateDescription (actividades: Actividades): Actividades {
        val response = actividadesRepository.findById(actividades.id)
            ?: throw Exception()
        response.apply {
            this.id=actividades.id
        }
        return actividadesRepository.save(actividades)
    }

    fun delete (id:Long): Boolean{
        actividadesRepository.deleteById(id)
        return true
    }
}