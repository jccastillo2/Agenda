package demo.demo.service

import demo.demo.model.Usuario
import demo.demo.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: usuarioRepository


    fun list(): List<Usuario> {

        return usuarioRepository.findAll()
    }

    fun save(usuario:Usuario): Usuario {
        try {
            if (usuario.nombre.equals("")) {
                throw Exception("Uno de los campos no se ha llenado")
            }

            val response = usuarioRepository.findById(usuario.id)
                ?: throw Exception("El id ${usuario.id} en dieta no existe")
            response.apply {
                this.nombre = usuario.nombre
            }
            return usuarioRepository.save(usuario)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message
            )
        }

    }
    fun update (usuario: Usuario):Usuario{
        return usuarioRepository.save(usuario)
    }

    fun updateDescription (usuario: Usuario):Usuario {
        val response = usuarioRepository.findById(usuario.id)
            ?: throw Exception()
        response.apply {
            this.id=usuario.id
        }
        return usuarioRepository.save(usuario)
    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }
}