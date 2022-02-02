CREATE TABLE IF NOT EXISTS currencies
(
   id    SERIAL PRIMARY KEY,
   idcurrency CHAR(7),
   numcode CHAR(3),
   charcode CHAR(3),
   nominal   INTEGER,
   name CHAR(50),
   valuecurrency DOUBLE PRECISION,
   datecurrency TIMESTAMP
);

CREATE TABLE IF NOT EXISTS currencyconversion
(
   id    SERIAL PRIMARY KEY,
   idcurrencyfrom CHAR(7),
   numcodefrom CHAR(3),
   charcodefrom CHAR(3),
   nominalfrom   INTEGER,
   namefrom CHAR(50),
   valuefrom DOUBLE PRECISION,
   conversiondate TIMESTAMP,
   idcurrencyto CHAR(7),
   numcodeto CHAR(3),
   charcodeto CHAR(3),
   nominalto   INTEGER,
   nameto CHAR(50),
   valueto DOUBLE PRECISION,
   conversionvalue DOUBLE PRECISION,
   sumvaluefrom DOUBLE PRECISION,
   sumvalueto DOUBLE PRECISION
);