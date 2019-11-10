package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "event")
data class Event(
        @Id @GeneratedValue
        var id: Long? = null,
        @Column
        var name: String,
        @Column
        var description: String,
        @ManyToOne
        @JoinColumn
        var location: Location,
        @OneToOne
        @JoinColumn
        var time: Time,
        @OneToOne
        @JoinColumn
        var admin: Admin,
        @ManyToMany
        var skills: List<Skill>
)
