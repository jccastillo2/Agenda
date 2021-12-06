package demo.demo.service

import demo.demo.model.Actividades
import demo.demo.repository.actividadesRepository
import demo.demo.repository.horarioRepository
import demo.demo.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class actividadesService {
    @Autowired
    lateinit var actividadesRepository: actividadesRepository
    @Autowired
    lateinit var horarioRepository: horarioRepository
    @Autowired
    lateinit var usuarioRepository: usuarioRepository


    fun list(): List<Actividades> {

        return actividadesRepository.findAll()
    }

    fun save(actividades: Actividades): Actividades {
        try {
            horarioRepository.findById(actividades.horarioId)
                ?: throw Exception("Horario no encotrado")
            usuarioRepository.findById(actividades.usuarioId)
                ?: throw Exception("Usuario no encontrado")
            if (actividades.detalle.equals("")) {
                throw Exception("No se ha llenado el detalle")
            } else {
                return actividadesRepository.save(actividades)
            }
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun update (actividades: Actividades): Actividades {
        return actividadesRepository.save(actividades)
    }

    fun updateDescription (actividades: Actividades): Actividades {
        try {
            val response = actividadesRepository.findById(actividades.id)
                ?: throw Exception("Actualizad Correctamente")
            response.apply {
                this.id = actividades.id
            }
            return actividadesRepository.save(actividades)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
7
        }
    }

    fun delete (id:Long): Boolean{
        actividadesRepository.deleteById(id)
        return true
    }
}