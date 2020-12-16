INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('admin','admin','admin','admin', 'SystemAdministrator');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Mario','Rossi','supermario','brosGO','Planner');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Maristella','Agosti','mary','star200','Planner');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Lucio','Benfante','BenLu','75car','Planner');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Franco','Califano','FraCal','123yes','Maintainer');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Massimo','Melucci','Max','delfinoCurioso','Maintainer');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Silvia','Giarletta','Silvietta','story31','Maintainer');
INSERT INTO UTENTE(Nome, Cognome, Username, Pass, ruolo) VALUES('Luca','Conte','LukeSkywalker','Mjedi','Maintainer');

INSERT INTO SITO(nome) VALUES ('Fisciano - Molding');
INSERT INTO SITO(nome) VALUES ('Nusco - Carpentry');
INSERT INTO SITO(nome) VALUES ('Morra - Painting');
INSERT INTO SITO(nome) VALUES ('Salerno - Soldering');

INSERT INTO TIPOLOGIA(nome) VALUES('Mechanical');
INSERT INTO TIPOLOGIA(nome) VALUES('Electric');
INSERT INTO TIPOLOGIA(nome) VALUES('Hydraulic');
INSERT INTO TIPOLOGIA(nome) VALUES('Electronics');
INSERT INTO TIPOLOGIA(nome) VALUES('Chemical');

INSERT INTO MATERIALE(nome) VALUES('Solder');
INSERT INTO MATERIALE(nome) VALUES('Compressor');
INSERT INTO MATERIALE(nome) VALUES('Clean product');
INSERT INTO MATERIALE(nome) VALUES('Plexiglass');
INSERT INTO MATERIALE(nome, descrizione) VALUES('Clippers', 'Shear pliers');
INSERT INTO MATERIALE(nome, descrizione) VALUES('Clippers', 'Nipper pliers');
INSERT INTO MATERIALE(nome, descrizione) VALUES('Clippers', 'Paroot forceps');

INSERT INTO COMPETENZA(nome) VALUES('PAV certification');
INSERT INTO COMPETENZA(nome) VALUES('Electric maintenance');
INSERT INTO COMPETENZA(nome) VALUES('Knowledge of cable types');
INSERT INTO COMPETENZA(nome) VALUES('Knowledge of robot workstation');
INSERT INTO COMPETENZA(nome) VALUES('Knowledge of soldering temperature');
INSERT INTO COMPETENZA(nome) VALUES('Electronics fundations');

INSERT INTO PROCEDURA(nome, SMP) VALUES ('Replacement of robot', 'Replacement.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Replacement pieces', 'Replacement.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Soldering wires', 'HowToSold.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Clean tank', 'CleaningProcedure.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Glass molding', 'Molding.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Activate the turbine  ', 'Commands.pdf');

INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Compressor replacement', 40, 8, 'Replacement pieces', 'Fisciano - Molding', 'Mechanical');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Replace the robot in the xSCab', 70, 11, 'Replacement of robot', 'Nusco - Carpentry', 'Mechanical');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Restore electric cabinet', 120, 20, 'Soldering wires', 'Salerno - Soldering', 'Electric');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Cleaning tunks in the C sector', 180, 1, 'Clean tank', 'Morra - Painting', 'Hydraulic');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Substitute panel in machine ST24', 50, 1, 'Glass molding', 'Fisciano - Molding', 'Mechanical');

INSERT INTO QUALIFICAZIONE(maintainer, competenza) values ('FraCal', 'Knowledge of robot workstation');
INSERT INTO QUALIFICAZIONE(maintainer, competenza) values ('FraCal', 'Electronics fundations');
INSERT INTO QUALIFICAZIONE(maintainer, competenza) values ('Max', 'Electronics fundations');
INSERT INTO QUALIFICAZIONE(maintainer, competenza) values ('Max', 'Electric maintenance');
INSERT INTO QUALIFICAZIONE(maintainer, competenza) values ('Silvietta', 'PAV certification');

INSERT INTO ESECUZIONE(maintainer, activity_id) VALUES ('FraCal', 1);
INSERT INTO ESECUZIONE(maintainer, activity_id) VALUES ('Silvietta', 2);
INSERT INTO ESECUZIONE(maintainer, activity_id) VALUES ('Max', 3);

INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (1, 'Electric maintenance');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (2, 'Electric maintenance');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (2, 'Electronics fundations');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (2, 'Knowledge of cable types');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (3, 'Knowledge of cable types');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (3, 'Electronics fundations');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (3, 'Electric maintenance');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (4, 'PAV certification');
INSERT INTO ASSEGNAZIONE(id_procedura, competenza) values (5, 'Knowledge of robot workstation');

INSERT INTO UTILIZZO(activity_id, materiale) VALUES (1, 'Clippers');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (1, 'Compressor');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (2, 'Solder');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (2, 'Clippers');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (3, 'Clippers');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (3, 'Solder');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (4, 'Clean product');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (5, 'Plexiglass');
INSERT INTO UTILIZZO(activity_id, materiale) VALUES (5, 'Clippers');
