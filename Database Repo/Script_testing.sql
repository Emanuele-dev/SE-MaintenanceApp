/*
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Sant','Isidoro','ErMejoSanto','divinepower', 'Planner');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Franco','Califano','FraCal','123yes','Maintainer');
INSERT INTO MATERIALE(nome) VALUES ('Salame');
INSERT INTO SITO(nome) VALUES ('Cucina');
INSERT INTO TIPOLOGIA(nome) VALUES('Culinaria');
INSERT INTO COMPETENZA(nome) VALUES('Masterchef');
INSERT INTO PROCEDURA(nome, SMP, competenza) VALUES ('Panino al salame', 'Ricetta.pdf', 'Masterchef');
INSERT INTO ATTIVITA_MANUTENZIONE(sito, tipologia,intervento_stimato, procedura, settimana) VALUES ('Cucina','Culinaria',30,'Panino al salame', 32);
INSERT INTO LOGGING(username) VALUES('ErMejoSanto');
INSERT INTO ESECUZIONE(maintainer, activity_id) VALUES ('FraCal', (SELECT activity_id FROM ATTIVITA_MANUTENZIONE WHERE procedura = 'Panino al salame'));

DELETE FROM TIPOLOGIA WHERE TIPOLOGIA.nome = 'Culinaria';
DELETE FROM TIPOLOGIA WHERE TIPOLOGIA.nome = 'Culinaria';
SELECT * FROM ATTIVITA_MANUTENZIONE


update UTENTE set nome = 'silvio', cognome = 'cus', username = 'silvy', pass = 'mo', attivo = 'true', ruolo = 'Planner' WHERE username = 'FraCal'
INSERT INTO logging (username, log_time) VALUES ('FraCal', '2020-12-01');

*/