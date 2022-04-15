# HVACareTaker
Spring MVC HVAC systems management application

Technologies
- Java 17
- Thymeleaf
- HTML
- CSS
- JS
- Bootstrap
- Spring (Web, Security, Data JPA, Boot Devtools, H2 DB, MySQL DB, Spring Mail)
- Maven
- Git VCS
- Liquibase
- MySQL
- Docker

<h3>Implementacja</h3>
<p>Aby zaimplementować poprawnie aplikację HVACareTaker należy wykonać poniższe kroki dokonując zmian w kodzie:</p>
<ol>
<li>W pliku application-prod.properties należy w linii "spring.datasource.url=jdbc:mysql://HVACareTaker:3306/hvacaretaker" dokonać zmiany adresu URL na adres wykorzystywanej w produkcji bazy danych MySQL.</li>
<li>W pliku application-prod.properties należy w liniach "username" i "password" podać dane do logowania na konto administratora bazy danych MySQL.</li>
<li>W pliku EmailConfig.java w metodzie getJavaMailSender należy podać dane do logowania do konta pocztowego, które będzie pośredniczyło w komunikacji między aplikacją, a użytkownikami.</li>
<li>W podłączonym serwerze MySQL należy utworzyć bazę danych o nazwie wskazanej w kroku 1.</li>
<li>Za pomocą linii komend i polecenia 'mvn clean package' utworzyć plik .jar z aplikacją.</li>
<li>Uruchomić za pomocą linii komend i polecenia 'java -jar nazwaaplikacji.jar' aplikację do działania.</li>
<li>Aplikacja jest przygotowana do utworzenia obrazu Docker w celu dalszej konteneryzacji. Można to dokonać za pomocą linii komend 'docker build' lub buildpacks mavena 'mvn image-build'</li>
</ol>
