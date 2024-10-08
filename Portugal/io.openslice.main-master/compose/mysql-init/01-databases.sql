# create databases
CREATE DATABASE IF NOT EXISTS `osdb`;
CREATE DATABASE IF NOT EXISTS `keycloak`;

# create root user and grant rights
CREATE USER 'portaluser'@'localhost' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON *.* TO 'portaluser'@'%' IDENTIFIED BY '12345';


# create root user and grant rights
CREATE USER 'keycloak'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'keycloak'@'%' IDENTIFIED BY 'password';
