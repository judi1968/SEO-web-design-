# 🐳 Guide : Lancer le Projet avec Docker

## 📋 Prérequis

Avant de commencer, assurez-vous que vous avez :
- **Docker** installé ([Télécharger Docker](https://www.docker.com/))
- **Docker Compose** installé (généralement inclus avec Docker Desktop)
- Le projet téléchargé sur votre machine

## 🚀 Étapes pour Lancer le Projet

### 1️⃣ Ouvrir le Terminal

- Sur **Windows** : Ouvrir PowerShell ou Command Prompt
- Sur **Mac/Linux** : Ouvrir le Terminal

### 2️⃣ Naviguer vers le Projet

```bash
cd "d:\IT University\S6\Mr Rojo Web design\2 - SEO\1 - Miniprojet web\application\SEO-web-design-"
```

### 3️⃣ Lancer Docker Compose

```bash
docker-compose up
```

**Attendez quelques minutes** pour que :
- La base de données MySQL démarre ✅
- L'application Spring Boot se compile et se lance ✅

### 4️⃣ Accéder à l'Application

Une fois que vous voyez ce message dans le terminal :
```
[INFO] Started ProjectApplication in X.XXX seconds
```

Ouvrez votre navigateur et allez à :
```
http://localhost:5050/
```

## 📊 Architecture Docker

Votre projet utilise **2 conteneurs** :

### 🗄️ **MySQL Container**
- **Port** : `6060:3306`
- **Identifiant** : `mysql_db`
- **Base de données** : `myapp_db`
- **Utilisateur** : `myuser`
- **Mot de passe** : `mypassword`

### ☕ **Java Spring Boot Container**
- **Port** : `5050:8080`
- **Identifiant** : `java_app`
- **Port interne** : `8080` (configuré dans `application.properties`)

## ⚙️ Configuration Importante

### `docker-compose.yml`
- Mappe le port `5050` (local) → `8080` (conteneur)
- Mappe le port `6060` (local) → `3306` (MySQL)

### `application.properties`
```properties
server.port=8080
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

## 🛑 Arrêter le Projet

Pour arrêter les conteneurs :
```bash
docker-compose down
```

## 🔧 Commandes Utiles

### Voir les conteneurs en cours d'exécution
```bash
docker ps
```

### Voir les logs en direct
```bash
docker-compose logs -f
```

### Supprimer les volumes (base de données)
```bash
docker-compose down -v
```

### Reconstruire l'image
```bash
docker-compose up --build
```



## ❓ Dépannage

### Le projet ne démarre pas ?
1. Vérifiez que Docker est bien lancé
2. Vérifiez que le port `5050` n'est pas utilisé
3. Vérifiez les logs : `docker-compose logs`

### La base de données ne se connecte pas ?
1. Attendez quelques secondes que MySQL soit prêt
2. Vérifiez les identifiants dans `docker-compose.yml`

### L'application affiche une erreur ?
1. Vérifiez que le fichier `home.jsp` existe dans `src/main/webapp/WEB-INF/views/`
2. Vérifiez les logs de l'application

---

**Bon développement ! 🚀**
