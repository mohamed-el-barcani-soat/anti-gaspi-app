create table if not exists OFFER
(
    id                varchar(200) PRIMARY KEY,
    natural_id        varchar(200) UNIQUE NOT NULL,
    title             varchar(200),
    description       varchar(200),
    email             varchar(200),
    street            varchar(200),
    zipcode           varchar(5),
    city              varchar(500),
    country           varchar(150),
    availability_date date,
    expiration_date   date
);