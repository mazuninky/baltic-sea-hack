package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "skill_points")
data class SkillPoints(
        @Id @GeneratedValue
        var id: Long? = null,
        @ManyToOne
        @JoinColumn
        var skill: Skill,
        @ManyToOne
        @JoinColumn
        var user: People,
        var value: Int
)

