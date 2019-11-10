package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "time")
data class Time(
        @Column
        var start: String,
        @Column
        var end: String,
        @Id @GeneratedValue
        var id: Long? = null
)
