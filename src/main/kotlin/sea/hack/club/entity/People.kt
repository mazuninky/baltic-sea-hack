package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "club_people")
data class People(
        var name: String,
        var age: Int,
        @ManyToMany
        var section: List<Section>,
        @ManyToMany
        var clubs: List<Club>,
        @Id @GeneratedValue
        var id: Long? = null
)
