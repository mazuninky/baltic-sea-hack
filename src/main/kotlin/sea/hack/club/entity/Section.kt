package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "section")
data class Section(
        @Column
        var name: String,
        @ManyToMany
        @JoinColumn
        var skills: List<Skill>,
        @Id @GeneratedValue
        var id: Long? = null
)
