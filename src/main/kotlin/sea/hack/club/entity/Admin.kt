package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "club_admin")
data class Admin(
        @Id @GeneratedValue
        var id: Long? = null,
        @ManyToOne
        @JoinColumn
        var club: Club
)
