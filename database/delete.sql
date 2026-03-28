USE myapp_db;

-- Désactiver les vérifications de clés étrangères temporairement
SET FOREIGN_KEY_CHECKS = 0;

-- Supprimer les tables si elles existent (ordre inverse des dépendances)
DROP TABLE IF EXISTS images_news;
DROP TABLE IF EXISTS news;

-- Réactiver les vérifications de clés étrangères
SET FOREIGN_KEY_CHECKS = 1;

-- Recréer les tables
CREATE TABLE IF NOT EXISTS news(
    id INT AUTO_INCREMENT PRIMARY KEY,
    contenu TEXT NOT NULL,
    date_publication DATE NOT NULL,
    images_couverture TEXT,
    alt_images_couverture TEXT
);

CREATE TABLE IF NOT EXISTS images_news(
    id INT AUTO_INCREMENT PRIMARY KEY,
    url_image TEXT NOT NULL,
    alt_image TEXT NOT NULL,
    id_news INT NOT NULL,
    FOREIGN KEY (id_news) REFERENCES news(id) ON DELETE CASCADE
);

-- Réinitialiser les auto-incréments (au cas où)
ALTER TABLE news AUTO_INCREMENT = 1;
ALTER TABLE images_news AUTO_INCREMENT = 1;