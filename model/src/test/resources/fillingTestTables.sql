/* --------------filling in the table "tags"---------------------*/
INSERT INTO tags (tag_name)
VALUES ('tagName1');

INSERT INTO tags (tag_name)
VALUES ('tagName3');

INSERT INTO tags (tag_name)
VALUES ('tagName5');

INSERT INTO tags (tag_name)
VALUES ('tagName4');

INSERT INTO tags (tag_name)
VALUES ('tagName2');

/* --------------filling in the table "gift_certificates"---------------------*/
INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate1', 'description1', 10.1, 1, '2020-08-29T06:12:15.156', '2020-08-29T06:12:15.156');

INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate3', 'description3', 30.3, 3, '2019-08-29T06:12:15.156', '2019-08-29T06:12:15.156');

INSERT INTO gift_certificates (name, description, price, duration, create_date, last_update_date)
VALUES ('giftCertificate2', 'description2', 20.2, 2, '2018-08-29T06:12:15.156', '2018-08-29T06:12:15.156');

/* --------------filling in the table "gift_certificates_tags"---------------------*/

INSERT INTO gift_certificates_tags (gift_certificate_id, tag_id)
VALUES (1, 2);

INSERT INTO gift_certificates_tags (gift_certificate_id, tag_id)
VALUES (2, 2);