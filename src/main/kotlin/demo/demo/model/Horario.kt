package demo.demo.model

import java.sql.Date
import java.sql.Time
import javax.persistence.*

@Entity
@Table(name = "Horario")

class Horario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var inicio: Time? =  null
    var fin: Time? = null
    var fecha: Date?= null
}