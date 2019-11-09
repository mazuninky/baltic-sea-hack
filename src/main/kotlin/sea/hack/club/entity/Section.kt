package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "section")
data class Section(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        val name: String
)
