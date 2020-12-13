/* //INSERT
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Sant','Isidoro','ErMejoSanto','divinepower', 'Planner');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Franco','Califano','FraCal','123yes','Maintainer');
INSERT INTO MATERIALE(nome) VALUES ('Salame');
INSERT INTO SITO(nome) VALUES ('Cucina');
INSERT INTO TIPOLOGIA(nome) VALUES('Culinaria');
INSERT INTO COMPETENZA(nome) VALUES('Masterchef');
INSERT INTO COMPETENZA(nome) VALUES('Pasticciere');
INSERT INTO COMPETENZA(nome) VALUES('Panettiere');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Panino al salame', 'Ricetta.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Pizza al pomodoro', 'RicettaPizza.pdf');
INSERT INTO ATTIVITA_MANUTENZIONE(sito, tipologia,intervento_stimato, procedura, settimana) VALUES ('Cucina','Culinaria',30,'Panino al salame', 32);
INSERT INTO LOGGING(username) VALUES('ErMejoSanto');
INSERT INTO ESECUZIONE(maintainer, activity_id) VALUES ('FraCal', (SELECT activity_id FROM ATTIVITA_MANUTENZIONE WHERE procedura = 'Panino al salame'));
INSERT INTO logging (username, log_time) VALUES ('FraCal', '2020-12-01');
insert into qualificazione (maintainer, competenza) values ('FraCal', 'Masterchef');
insert into qualificazione (maintainer, competenza) values ('FraCal', 'Pasticciere');
insert into assegnazione (id_procedura, competenza) values (1, 'Pasticciere');
insert into assegnazione (id_procedura, competenza) values (1, 'Panettiere');
insert into assegnazione (id_procedura, competenza) values (2, 'Masterchef');

*/

/* //DELETE
DELETE FROM TIPOLOGIA WHERE TIPOLOGIA.nome = 'Culinaria';
*/

/* //UPDATE
update UTENTE set nome = 'silvio', cognome = 'cus', username = 'silvy', pass = 'mo', attivo = 'true', ruolo = 'Planner' WHERE username = 'FraCal';

*/

/* //TRIAL
select maintainer from qualificazione where competenza = 'Masterchef' ; 
select competenza from qualificazione where maintainer = 'FraCal'; 
select competenza from assegnazione where id_procedura=2;

*/