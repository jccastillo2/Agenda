package demo.demo.model

import javax.persistence.*

@Entity
@Table(name = "Usuario")
class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var nombre: String? =  null
    var direccion: String? = null
    var correo: String?= null
    var contacto: Int?= null

}
