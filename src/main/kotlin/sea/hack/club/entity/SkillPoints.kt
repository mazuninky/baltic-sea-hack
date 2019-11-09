package sea.hack.club.entity

import org.apache.catalina.User
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

data class SkillPoints(
        @Id @GeneratedValue
        var id: Long? = null,
        @ManyToOne
        @JoinColumn
        var skill: Skill,
        @ManyToOne
        @JoinColumn
        var user: User,
        var value: Int
)

