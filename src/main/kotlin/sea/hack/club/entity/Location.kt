package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "location")
data class Location(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        val name: String,
        @Column
        val locationLatitude: Float,
        @Column
        val locationLongitude: Float
)
