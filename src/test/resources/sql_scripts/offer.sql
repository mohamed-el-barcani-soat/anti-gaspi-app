create table OFFER
(
    id               varchar PRIMARY KEY,
    naturalId        varchar UNIQUE NOT NULL,
    title            varchar(200),
    description      varchar(200),
    email            varchar(200),
    street           varchar(200),
    zipCode          varchar(5),
    country          varchar(150),
    availabilityDate date,
    expirationDate   date
);