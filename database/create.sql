USE myapp_db;

CREATE TABLE IF NOT EXISTS news(
    id INT AUTO_INCREMENT PRIMARY KEY,
    contenu LONGTEXT NOT NULL,
    date_publication DATE NOT NULL, 
    images_couverture TEXT,
    alt_images_couverture TEXT
);

CREATE TABLE IF NOT EXISTS images_news(
    id INT AUTO_INCREMENT PRIMARY KEY,
    url_image TEXT NOT NULL,
    alt_image TEXT NOT NULL,
    id_news INT NOT NULL,
    FOREIGN KEY (id_news) REFERENCES news(id)
);