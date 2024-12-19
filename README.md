Geo Learn Projekt

Beskrivning

Geo Learn Projekt är en interaktiv applikation för att lära sig geografi. Med hjälp av JPA och MySQL erbjuder projektet funktionalitet för att hantera kontinenter, länder, städer och andra geografiska data. Dessutom inkluderar projektet en quiz-funktion där användaren kan testa sina geografikunskaper.

Funktioner

Huvudmeny

Vid körning möts användaren av följande meny:

Welcome to Geo Learn Projekt!
Välj:
1.  - Continent.
2.  - Population.
3.  - Statistik.
4.  - Quiz!
5.  - Quit.

Undermenyer

Continent Menu:
Hanterar kontinenter med CRUD-operationer:

Visa alla kontinenter.

Skapa, uppdatera eller ta bort kontinenter.

Population:
Visa befolkningsdata (under utveckling).

Statistik:
Genererar statistik baserat på geografiska data (under utveckling).

Quiz:
Ett quiz där användaren svarar på frågor om geografi.

Systemarkitektur

Projektet är strukturerat enligt följande:

Paketstruktur

entity:
Innehåller entiteter som representerar databastabeller, inklusive:

City

Continent

Country

Currency

Language

methods:
Innehåller affärslogik och methoder för att hålla huvudklassen clean:

CityMethod

ContinentMethod

LanguageMethod

QuizMethod

StatisticMethod

repository:
Hanterar databasoperationer för respektive entitet och logik för CRUD och annan:

CityRepository

ContinentRepository

CountryRepository

CurrencyRepository

LanguageRepository

resources:
Innehåller konfigurationsfiler som schema.sql och docker-compose.yml.

Teknologier

Java

JPA (Hibernate)

MySQL

Docker (för containerisering)

Installation

Klona projektet:

git clone <repository-url>

Starta Docker-containern:

docker-compose up

Bygg och kör projektet:

mvn clean install
mvn exec:java

Navigera genom menyn och utforska applikationen.

Krav

Java 17

Maven

MySQL-server

Docker (valfritt för enkel installation)

Exempel på användning

Continent CRUD

Continent Menu:
1. Show Continents
2. Create a Continent
3. Update a Continent
4. Delete a Continent
5. Back to Main Menu

Quiz

Welcome to our Quiz! Answer with 1, 2, 3, or type 0 to go back.
What should be the Capital of Sweden?
1. Stockholm
2. Gothenburg
3. Malmö
Your answer: 2
Rätt!

Bidra

Vi välkomnar bidrag från andra utvecklare! Skapa en pull request eller öppna en issue om du har idéer.

Kontakt

För frågor, kontakta teammedlemmarna:

Raffi02k

Stelle

Linus

Markus
