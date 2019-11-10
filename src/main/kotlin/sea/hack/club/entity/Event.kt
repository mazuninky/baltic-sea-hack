package sea.hack.club.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "event")
data class Event(
        @Column
        var name: String,
        @Lob
        @Column(length = 512)
        var description: String,
        @ManyToOne
        @JoinColumn
        var location: Location,
        @OneToOne
        @JoinColumn
        var time: Time,
        @OneToOne
        @JoinColumn
        var admin: Admin?,
        @ManyToMany
        var skills: List<Skill>,
        @Id @GeneratedValue
        var id: Long? = null,
        @OneToOne
        @JoinColumn
        @JsonIgnore
        var section: Section
)
