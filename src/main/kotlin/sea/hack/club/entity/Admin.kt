package sea.hack.club.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "club_admin")
data class Admin(
        @Id @GeneratedValue
        var id: Long? = null
)
