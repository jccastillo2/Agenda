package demo.demo.controller

import demo.demo.model.Actividades
import demo.demo.service.actividadesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/actividades")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class actividadesController {
    @Autowired
    lateinit var actividadesService: actividadesService

    @GetMapping
    fun list(): List<Actividades>{
        return actividadesService.list()
    }
    @PostMapping
    fun  save (@RequestBody actividades: Actividades): Actividades {
        return actividadesService.save(actividades)
    }
    @PutMapping
    fun update (@RequestBody actividades: Actividades): Actividades {
        return actividadesService.update(actividades)
    }

    @PatchMapping
    fun updateDescription (@RequestBody actividades: Actividades): Actividades {
        return actividadesService.updateDescription(actividades)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return actividadesService.delete(id)
    }

}