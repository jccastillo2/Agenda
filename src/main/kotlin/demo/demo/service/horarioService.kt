package demo.demo.service

import demo.demo.model.Horario
import demo.demo.repository.horarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class horarioService {
    @Autowired
    lateinit var horarioRepository: horarioRepository


    fun list(): List<Horario> {

        return horarioRepository.findAll()
    }

    fun save(horario: Horario): Horario {

            return horarioRepository.save(horario)

    }
    fun update (horario: Horario):Horario{
        return horarioRepository.save(horario)
    }

    fun updateDescription (horario: Horario):Horario {
        val response = horarioRepository.findById(horario.id)
            ?: throw Exception()
        response.apply {
            this.id=horario.id
        }
        return horarioRepository.save(horario)
    }

    fun delete (id:Long): Boolean{
        horarioRepository.deleteById(id)
        return true
    }
}