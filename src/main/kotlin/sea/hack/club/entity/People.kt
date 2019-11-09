package sea.hack.club.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "club_people")
data class People(
        @Id @GeneratedValue
        var id: Long? = null,
        var name: String
)
