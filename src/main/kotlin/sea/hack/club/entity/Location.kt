package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "location")
data class Location(
        @Column
        var name: String,
        @Column
        var locationLatitude: Float,
        @Column
        var locationLongitude: Float,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
)
