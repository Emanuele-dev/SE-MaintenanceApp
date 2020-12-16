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
INSERT INTO MATERIALE(nome) VALUES('Clippers');
INSERT INTO MATERIALE(nome) VALUES('Plexiglass');

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
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Glass molding  ', 'Molding.pdf');
INSERT INTO PROCEDURA(nome, SMP) VALUES ('Activate the turbine  ', 'Commands.pdf');

INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Compressor replacement', 40, 8, 'Replacement pieces', 'Fisciano - Molding', 'Mechanical');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Replace the robot in the xSCab', 70, 11, 'Replacement of robot', 'Nusco - Carpentry', 'Mechanical');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Restore electric cabinet', 120, 20, 'Soldering wires', 'Salerno - Soldering', 'Electric');
INSERT INTO ATTIVITA_MANUTENZIONE(nome, intervento_stimato, settimana, procedura, sito, tipologia) VALUES ('Restore electric cabinet', 120, 20, 'Soldering wires', 'Salerno - Soldering', 'Electronics');
