package demo.demo.model
import javax.persistence.*

@Entity
@Table(name = "Actividades")

class Actividades {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var detalle: String? =  null
    var tipo: String? = null
    @Column(name="usuario_id")
    var usuarioId:Long?= null
    @Column(name="horario_id")
    var horarioId:Long?= null
}

