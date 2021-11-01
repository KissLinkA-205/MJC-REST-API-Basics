DROP DATABASE IF EXISTS module2test;

CREATE DATABASE IF NOT EXISTS module2test;

USE module2test;

-- -----------------------------------------------------
-- Table module2test.tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tags
(
    id       BIGINT UNSIGNED AUTO_INCREMENT,
    tag_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module2test.gift_certificates
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates
(
    id               BIGINT UNSIGNED AUTO_INCREMENT,
    name             VARCHAR(45)            NOT NULL,
    description      TEXT(300),
    price            DECIMAL(8, 2) UNSIGNED NOT NULL,
    duration         SMALLINT UNSIGNED      NOT NULL,
    create_date      VARCHAR(24)            NOT NULL,
    last_update_date VARCHAR(24)            NOT NULL,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table module2test.gift_certificates_tags
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS gift_certificates_tags
(
    id                  BIGINT UNSIGNED AUTO_INCREMENT,
    gift_certificate_id BIGINT UNSIGNED,
    tag_id              BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (gift_certificate_id) REFERENCES Gift_certificates (id),
    FOREIGN KEY (tag_id) REFERENCES Tags (id)
);