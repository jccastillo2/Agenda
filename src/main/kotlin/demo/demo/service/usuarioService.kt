package demo.demo.service

import demo.demo.model.Usuario
import demo.demo.repository.usuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: usuarioRepository


    fun list(): List<Usuario> {

        return usuarioRepository.findAll()
    }

    fun save(usuario:Usuario): Usuario {
        return usuarioRepository.save(usuario)
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