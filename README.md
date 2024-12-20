# Geo Learn Projekt

## Beskrivning
Geo Learn Projekt är en interaktiv applikation för att lära sig geografi. Med hjälp av **JPA** och **MySQL** erbjuder projektet funktionalitet för att hantera kontinenter, länder, städer och andra geografiska data. Dessutom inkluderar projektet en **quiz-funktion** där användaren kan testa sina geografikunskaper.

# Systemarkitektur

## Projektet är strukturerat enligt följande:

Paketstruktur

## entity:
# Innehåller entiteter som representerar databastabeller, inklusive:

City

Continent

Country

Currency

Language

## methods:
# Innehåller logik för affärslogik och metoder håller även huvudmenyn clean:

CityMethod

ContinentMethod

LanguageMethod

QuizMethod

StatisticMethod

## repository:
# Hanterar databasoperationer för respektive entitet och CRUD:

CityRepository

ContinentRepository

CountryRepository

CurrencyRepository

LanguageRepository

## resources:
#Innehåller konfigurationsfiler som schema.sql och docker-compose.yml.

## Funktioner

### Huvudmeny
Vid körning möts användaren av följande meny:

Welcome to Geo Learn Projekt! Välj:

Continent.
Population.
Statistik.
Quiz!
Quit.
markdown
Kopiera kod

### Undermenyer

#### Continent Menu
Hantera kontinenter med CRUD-operationer:

- Visa alla kontinenter.
- Skapa en ny kontinent.
- Uppdatera en existerande kontinent.
- Ta bort en kontinent.
- Gå tillbaka till huvudmenyn.

#### Quiz
En interaktiv frågesport där användaren kan testa sina geografikunskaper genom att svara på flervalsfrågor. Exempel:

Welcome to our Quiz! Answer with 1, 2, 3, or type 0 to go back. What should be the Capital of Sweden?

Stockholm
Gothenburg
Malmö Your answer: 1 Rätt!
markdown
Kopiera kod

## Teknisk Information

- **Backend**: Java med JPA och Hibernate för databasinteraktion.
- **Databas**: MySQL (använd JDBC URL: `jdbc:mysql://localhost:3306/demo`).
- **ORM**: Hibernate ORM version 7.0.0.Beta3.

## Kompilera och köra

1. Klona detta repository:
   ```bash
   git clone https://github.com/your-repository/GeoLearnProjekt.git
Navigera till projektmappen:
bash
Kopiera kod
cd GeoLearnProjekt
Konfigurera MySQL-databasen genom att uppdatera persistence.xml med rätt databasuppgifter.
Bygg projektet med Maven:
bash
Kopiera kod
mvn clean install
Kör programmet:
bash
Kopiera kod
java -jar target/GeoLearnProjekt.jar
Exempel på Konsolutdata
Vid körning kan du se liknande utdata i konsolen:

markdown
Kopiera kod
Welcome to Geo Learn Projekt!
Välj:
1.  - Continent.
2.  - Population.
3.  - Statistik.
4.  - Quiz!
5.  - Quit.

Ange ditt val (1-5): 1
Continent Menu:
1. Show Continents
2. Create a Continent
3. Update a Continent
4. Delete a Continent
5. Back to Main Menu
Förbättringar
Lägg till mer statistik och dataanalys i Statistik-delen.
Lägg till fler frågesportfrågor och en poängräknare.
Implementera internationell support för olika språk.
css
Kopiera kod

Kopiera och klistra in detta till din README.md så att det ser bra ut på GitHub. Det inkluderar sektioner, kodblock och rubriker som följer Markdown-standarder.
