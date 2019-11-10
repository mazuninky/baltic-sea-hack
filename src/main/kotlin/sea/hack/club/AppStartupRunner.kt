package sea.hack.club

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import sea.hack.club.entity.*
import sea.hack.club.repository.*
import java.io.File


@Component
class AppStartupRunner(private val clubRepository: ClubRepository,
                       private val locationRepository: LocationRepository,
                       private val peopleRepository: PeopleRepository,
                       private val sectionRepository: SectionRepository,
                       private val skillRepository: SkillRepository)
    : ApplicationRunner {

    object ClubsHeaders {
        //        const val Id = "Id"
        const val Title = "Title"
        const val Address = "Address"
        const val Sections = "Sections"
        const val lat = "lat"
        const val lon = "lon"
    }

    object PeopleHeaders {
        const val Name = "Name"
        const val Age = "Age"
        const val Sections = "sections"
    }

    override fun run(args: ApplicationArguments) {
        val sections = initSections()
        val clubsCSV = File(this::class.java.getResource("/data/clubs.csv").file)
        val clubsRows = csvReader {
            delimiter = ','
            quoteChar = '"'
        }.readAllWithHeader(clubsCSV)
        clubsRows.forEach {
            if (!it.values.any { it -> it.isEmpty() }) {

                val location = Location(name = it.getValue(ClubsHeaders.Address),
                        locationLatitude = it.getValue(ClubsHeaders.lat).toFloat(),
                        locationLongitude = it.getValue(ClubsHeaders.lon).toFloat())

                locationRepository.save(location)

                val sectionText = it.getValue(ClubsHeaders.Sections).split(",").map { it.toLong() }

                val clubSections = sectionText.filter { key -> sections.containsKey(key) }.map { sections.getValue(it) }

                val club = Club(name = it.getValue(ClubsHeaders.Title),
                        location = location,
                        people = emptyList(),
                        admins = emptyList(),
                        sections = clubSections
                )

                clubRepository.save(club)
            }
        }

        val peopleCSV = File(this::class.java.getResource("/data/people.csv").file)
        val peopleRows = csvReader {
            delimiter = ','
            quoteChar = '"'
        }.readAllWithHeader(peopleCSV)
        peopleRows.forEach {
            var clubSections: List<Section> = emptyList()
            if (!it.getValue(PeopleHeaders.Sections).isBlank()) {
                val sectionText = it.getValue(PeopleHeaders.Sections).split(",").map { it.toLong() }

                clubSections = sectionText.filter { key -> sections.containsKey(key) }.map { sections.getValue(it) }
            }

            val people = People(name = it.getValue(PeopleHeaders.Name), age = it.getValue(PeopleHeaders.Age).toInt(),
                    section = clubSections, clubs = emptyList()
            )

            peopleRepository.save(people)
        }

        initSkills()
    }


    fun initSkills() {
        val skillsFile = File(this::class.java.getResource("/data/skills.csv").file)
        val rows = csvReader {
            delimiter = ','
            quoteChar = '"'
        }.readAll(skillsFile)
        rows.forEach {
            val section = Skill(it[1])

            skillRepository.save(section)
//            val id = checkNotNull(section.id)
//            sectionMaps[id] = section
        }
    }


    fun initSections(): Map<Long, Section> {
        val sectionMaps = mutableMapOf<Long, Section>()
        val sectionsFile = File(this::class.java.getResource("/data/sections.csv").file)
        val rows = csvReader {
            delimiter = ','
            quoteChar = '"'
        }.readAll(sectionsFile)
        rows.forEach {
            val section = Section(it[1], listOf())

            sectionRepository.save(section)
            val id = checkNotNull(section.id)
            sectionMaps[id] = section
        }

        return sectionMaps
    }
}
