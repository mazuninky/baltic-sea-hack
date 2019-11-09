package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "event")
data class Event(
        @Id @GeneratedValue
        var id: Long? = null,
        var name: String,
        @ManyToOne
        @JoinColumn
        var location: Location
)
