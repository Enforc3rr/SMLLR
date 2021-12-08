CREATE TABLE IF NOT EXISTS smllr(
                      shortenUrlPart VARCHAR(64) PRIMARY KEY NOT NULL ,
                      numberOfClicks INT ,
                      mainUrl MEDIUMTEXT NOT NULL,
                      creationDate VARCHAR(64)
);