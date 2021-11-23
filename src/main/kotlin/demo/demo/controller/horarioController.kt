package demo.demo.controller

import demo.demo.model.Horario
import demo.demo.model.Usuario
import demo.demo.service.UsuarioService
import demo.demo.service.horarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/horario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])


class horarioController {
    @Autowired
    lateinit var horarioService: horarioService

    @GetMapping
    fun list(): List<Horario>{
        return horarioService.list()
    }
    @PostMapping
    fun  save (@RequestBody horario: Horario): Horario {
        return horarioService.save(horario)
    }
    @PutMapping
    fun update (@RequestBody horario: Horario):Horario{
        return horarioService.update(horario)
    }

    @PatchMapping
    fun updateDescription (@RequestBody horario: Horario):Horario{
        return horarioService.updateDescription(horario)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return horarioService.delete(id)
    }

}
