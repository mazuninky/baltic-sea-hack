package sea.hack.club.entity

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.Id

data class Skill(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        var name: String
)

