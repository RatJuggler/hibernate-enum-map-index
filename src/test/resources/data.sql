DELETE FROM Damage;
DELETE FROM Monster;
INSERT INTO Monster(id, name, size) VALUES (1, 'Godzilla', 0);
INSERT INTO Monster(id, name, size) VALUES (2, 'Giant Badger', 1);
INSERT INTO Monster(id, name, size) VALUES (3, 'Gremlin', 2);
INSERT INTO Damage(monsterId, attack, multiplier) VALUES (1, 4, 1000);
INSERT INTO Damage(monsterId, attack, multiplier) VALUES (1, 2, 100);
INSERT INTO Damage(monsterId, attack, multiplier) VALUES (2, 0, 1);
INSERT INTO Damage(monsterId, attack, multiplier) VALUES (2, 1, 2);
INSERT INTO Damage(monsterId, attack, multiplier) VALUES (3, 3, 5);
