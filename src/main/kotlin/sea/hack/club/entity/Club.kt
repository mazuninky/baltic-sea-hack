package sea.hack.club.entity

import javax.persistence.*

@Entity
@Table(name = "club")
data class Club(
        @Column
        var name: String,
        //References
        @ManyToOne
        @JoinColumn
        var location: Location,
        @ManyToMany(mappedBy = "clubs")
        var people: List<People>,
        @OneToMany(mappedBy = "club")
        var admins: List<Admin>,
        @ManyToMany
        var sections: List<Section>,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
)
