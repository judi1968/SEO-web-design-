# 1 - le comment ca marche.md doit marcher
# 2 - on lance le script
    docker exec -it mysql_db mysql -u myuser -p

entrer le mot de passe : **mypassword** puis executer ceci : 

    SOURCE /docker-entrypoint-initdb.d/create.sql;
    SOURCE /docker-entrypoint-initdb.d/insert.sql;

# Si vous voulez supprimer tout les donnes du base 
    SOURCE /docker-entrypoint-initdb.d/delete.sql;
