package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "skill")
data class Skill(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        var name: String
)

