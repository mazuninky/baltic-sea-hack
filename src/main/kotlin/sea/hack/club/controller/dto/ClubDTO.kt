package sea.hack.club.controller.dto

data class ClubDTO(
        val id: Long,
        val name: String,
        val address: String,
        val lat: Float,
        val lon: Float,
        val sections: List<SectionDTO>)

/*
*
* @Entity
@Table(name = "club")
data class Club(
        @Column
        var name: String,
        //References
        @ManyToOne
        @JoinColumn
        var location: Location,
        @ManyToMany(mappedBy = "section")
        var people: List<People>,
        @OneToMany(mappedBy = "club")
        var admins: List<Admin>,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null
)
*/
