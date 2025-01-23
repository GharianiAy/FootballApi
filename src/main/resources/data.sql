-- Insérer des équipes
INSERT INTO equipe (id, name, acronym, budget) VALUES (1, 'Paris Saint-Germain', 'PSG', 500.0);
INSERT INTO equipe (id, name, acronym, budget) VALUES (2, 'Real Madrid', 'RMA', 600.0);
INSERT INTO equipe (id, name, acronym, budget) VALUES (3, 'Manchester United', 'MU', 450.0);

-- Insérer des joueurs pour PSG
INSERT INTO joueur (id, name, position, equipe_id) VALUES (1, 'Kylian Mbappé', 'Attaquant', 1);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (2, 'Lionel Messi', 'Attaquant', 1);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (3, 'Marco Verratti', 'Milieu', 1);

-- Insérer des joueurs pour Real Madrid
INSERT INTO joueur (id, name, position, equipe_id) VALUES (4, 'Karim Benzema', 'Attaquant', 2);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (5, 'Luka Modrić', 'Milieu', 2);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (6, 'Thibaut Courtois', 'Gardien', 2);

-- Insérer des joueurs pour Manchester United
INSERT INTO joueur (id, name, position, equipe_id) VALUES (7, 'Cristiano Ronaldo', 'Attaquant', 3);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (8, 'Bruno Fernandes', 'Milieu', 3);
INSERT INTO joueur (id, name, position, equipe_id) VALUES (9, 'David de Gea', 'Gardien', 3);
