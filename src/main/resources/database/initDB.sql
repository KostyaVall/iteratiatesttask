CREATE TABLE IF NOT EXISTS currencies
(
   id    SERIAL PRIMARY KEY,
   idCurrency CHAR,
   numCode CHAR,
   charCode CHAR,
   nominal   INTEGER,
   name CHAR,
   valueCurrency DOUBLE PRECISION,
   dateCurrency TIMESTAMP
);