package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "club_people")
data class People(
        @Id @GeneratedValue
        var id: Long? = null,
        var name: String,

        @ManyToMany
        var section: List<Section>,
        @ManyToMany
        var clubs: List<Club>
)
