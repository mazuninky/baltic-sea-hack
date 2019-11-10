package sea.hack.club

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import sea.hack.club.entity.Club
import sea.hack.club.entity.Location
import sea.hack.club.entity.Section
import sea.hack.club.repository.ClubRepository
import sea.hack.club.repository.LocationRepository
import sea.hack.club.repository.SectionRepository
import java.io.File


@Component
class AppStartupRunner(private val clubRepository: ClubRepository,
                       private val locationRepository: LocationRepository,
                       private val sectionRepository: SectionRepository)
    : ApplicationRunner {

    object ClubsHeaders {
        //        const val Id = "Id"
        const val Title = "Title"
        const val Address = "Address"
        const val Sections = "Sections"
        const val lat = "lat"
        const val lon = "lon"
    }

    override fun run(args: ApplicationArguments) {
        val sections = initSections()
        val clubsCSV = File(this::class.java.getResource("/data/clubs.csv").file)
        val rows = csvReader {
            delimiter = ','
            quoteChar = '"'
        }.readAllWithHeader(clubsCSV)
        rows.forEach {
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
        println(rows.size)
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
