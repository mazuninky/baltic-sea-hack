package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table
data class PeopleMeeting(
        @OneToOne
        @JoinColumn
        var event: Event,
        @OneToOne
        @JoinColumn
        var people: People,
        @Id @GeneratedValue
        var id: Long? = null
)
