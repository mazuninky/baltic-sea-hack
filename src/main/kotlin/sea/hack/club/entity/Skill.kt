package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "skill")
data class Skill(
        @Column
        var name: String,
        @Id @GeneratedValue
        var id: Long? = null
)

