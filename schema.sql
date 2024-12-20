use demo;

drop table continent;
create table continent
(
    continent_code varchar(255) not null,
    continent_name varchar(255) null,
    constraint pk_continent primary key (continent_code)
);

insert into continent (continent_code, continent_name)
values ('eu', 'Europe'),
       ('af', 'Africa'),
       ('an', 'Antarctica'),
       ('as', 'Asia'),
       ('na', 'North America'),
       ('oc', 'Oceania'),
       ('sa', 'South America');

create table language
(
    language_id   bigint auto_increment not null,
    language_name varchar(255)          not null,
    country_code  varchar(255)          not null,
    constraint pk_language primary key (language_id),
    constraint fk_language_country foreign key (country_code) references country (country_code)
);

insert into language (language_name, country_code)
values
    ('Danish', 'dk'),
    ('Finnish', 'fi'),
    ('Icelandic', 'is'),
    ('Norwegian', 'no'),
    ('Swedish', 'se'),
    ('Sami', 'se'),
    ('Greenlandic', 'dk');


drop table currency;
create table currency
(
    currency_code varchar(255) not null,
    currency_name varchar(255) not null,
    country_code varchar(255) not null,
    constraint pk_currency primary key (currency_code),
    constraint fk_currency_country foreign key (country_code) references country (country_code)
);

insert into currency (currency_code, currency_name, country_code)
values
    ('DKK', 'Danish Krone', 'dk'),
    ('EUR', 'Euro', 'fi'),
    ('ISK', 'Icelandic Krona', 'is'),
    ('NOK', 'Norwegian Krone', 'no'),
    ('SEK', 'Swedish Krona', 'se');
#     ('EUR', 'Euro', 'sp'),
#     ('EUR', 'Euro', 'sl'),
#     ('EUR', 'Euro', 'sk'),
#     ('EUR', 'Romanian leu', 'ro'),
#     ('EUR', 'Euro', 'pt'),
#     ('EUR', 'Polish zloty', 'pl'),
#     ('EUR', 'Euro', 'nl'),
#     ('EUR', 'Euro', 'mt'),
#     ('EUR', 'Euro', 'lu'),
#     ('EUR', 'Euro', 'lt'),
#     ('EUR', 'Euro', 'lv'),
#     ('EUR', 'Euro', 'it'),
#     ('EUR', 'Euro', 'ie'),
#     ('EUR', 'Hungarian forint', 'hu'),
#     ('EUR', 'Euro', 'gr'),
#     ('EUR', 'Euro', 'de'),
#     ('EUR', 'Euro', 'fr'),
#     ('EUR', 'Euro', 'ee'),
#     ('EUR', 'Euro', 'cz'),
#     ('EUR', 'Euro', 'cy'),
#     ('EUR', 'Croatian kuna', 'hr'),
#     ('EUR', 'Bulgarian lev', 'bg'),
#     ('EUR', 'Euro', 'be'),
#     ('EUR', 'Euro', 'at'),
#     ('EUR', 'Albanian lek', 'al'),
#     ('EUR', 'Euro', 'ad'),
#     ('EUR', 'Ukrainian hryvnia', 'ua');

drop table country;
create table country
(
    country_code varchar(255) not null,
    country_name varchar(255) null,
    constraint pk_country primary key (country_code)
);

insert into country (country_code, country_name)
values ('dk', 'Denmark'),
       ('fi', 'Finland'),
       ('is', 'Iceland'),
       ('no', 'Norway'),
       ('se', 'Sweden'),
       ('at', 'Austria'),
       ('be', 'Belgium'),
       ('bg', 'Bulgaria'),
       ('hr', 'Croatia'),
       ('cy', 'Cyprus'),
       ('cz', 'Czech Republic'),
       ('ee', 'Estonia'),
       ('fr', 'France'),
       ('de', 'Germany'),
       ('gr', 'Greece'),
       ('hu', 'Hungary'),
       ('ie', 'Ireland'),
       ('it', 'Italy'),
       ('lv', 'Latvia'),
       ('lt', 'Lithuania'),
       ('lu', 'Luxembourg'),
       ('mt', 'Malta'),
       ('nl', 'Netherlands'),
       ('pl', 'Poland'),
       ('pt', 'Portugal'),
       ('ro', 'Romania'),
       ('sk', 'Slovakia'),
       ('sl', 'Slovenia'),
       ('sl', 'Spain');


drop table city;
create table city
(
    id           bigint auto_increment not null,
    city_name    varchar(255)   unique     not null,
    population   int                   not null,
    country_code varchar(255)          not null,
    constraint pk_city primary key (id),
    constraint fk_city_country foreign key (country_code) references country (country_code)
);

insert into city (city_name, population, country_code)
values
    ('Copenhagen', 602481, 'dk'),
    ('Aarhus', 282910, 'dk'),
    ('Odense', 179601, 'dk'),
    ('Helsinki', 631695, 'fi'),
    ('Espoo', 283632, 'fi'),
    ('Tampere', 238140, 'fi'),
    ('Reykjavik', 131136, 'is'),
    ('Kopavogur', 36875, 'is'),
    ('Hafnarfjordur', 29272, 'is'),
    ('Oslo', 634293, 'no'),
    ('Bergen', 278556, 'no'),
    ('Stavanger', 144699, 'no'),
    ('Stockholm', 975551, 'se'),
    ('Gothenburg', 583056, 'se'),
    ('Malmo', 347949, 'se'),
    ('Uppsala', 233839, 'se'),
    ('Västerås', 154049, 'se'),
    ('Örebro', 156381, 'se'),
    ('Linköping', 164616, 'se'),
    ('Helsingborg', 149280, 'se'),
    ('Jönköping', 141081, 'se'),
    ('Norrköping', 143478, 'se'),
    ('Lund', 125154, 'se'),
    ('Umeå', 130224, 'se'),
    ('Gävle', 102904, 'se');
