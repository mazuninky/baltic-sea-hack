migrate:
	flyway -user=club -password=12345 -url=jdbc:postgresql://localhost:5432/club -locations=filesystem:./db/migrations migrate
