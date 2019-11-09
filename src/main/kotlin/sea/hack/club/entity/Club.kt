package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "club")
data class Club(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column(unique = true)
        val name: String,
        @ManyToOne
        @JoinColumn
        var location: Location
)
