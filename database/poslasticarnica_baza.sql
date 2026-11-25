/*
SQLyog Community v13.3.0 (64 bit)
MySQL - 10.4.32-MariaDB : Database - poslasticarnica
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`poslasticarnica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `poslasticarnica`;

/*Table structure for table `kategorijakupca` */

DROP TABLE IF EXISTS `kategorijakupca`;

CREATE TABLE `kategorijakupca` (
  `idKategorijaKupca` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `popust` bigint(20) NOT NULL,
  PRIMARY KEY (`idKategorijaKupca`),
  UNIQUE KEY `uk_kategorijakupca_naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kategorijakupca` */

insert  into `kategorijakupca`(`idKategorijaKupca`,`naziv`,`popust`) values 
(1,'Standard',0),
(2,'Bronze',5),
(3,'Silver',10),
(4,'Gold',15);

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `idKupac` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `idKategorijaKupca` bigint(20) NOT NULL,
  PRIMARY KEY (`idKupac`),
  UNIQUE KEY `uk_kupac_email` (`email`),
  KEY `idKategorijaKupca` (`idKategorijaKupca`),
  CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`idKategorijaKupca`) REFERENCES `kategorijakupca` (`idKategorijaKupca`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kupac` */

insert  into `kupac`(`idKupac`,`ime`,`prezime`,`email`,`idKategorijaKupca`) values 
(1,'Marko','Marković','marko@gmail.com',1),
(2,'Jovana','Jovanović','jovana@yahoo.com',3),
(3,'Nikola','Nikolić','nikola@outlook.com',4),
(4,'Milica','Perić','milica.p@gmail.com',2),
(5,'Ana','Topalović','ana@gmail.com',2);

/*Table structure for table `kvalifikacija` */

DROP TABLE IF EXISTS `kvalifikacija`;

CREATE TABLE `kvalifikacija` (
  `idKvalifikacija` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `ustanova` varchar(50) NOT NULL,
  PRIMARY KEY (`idKvalifikacija`),
  UNIQUE KEY `uk_kvalifikacija_naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `kvalifikacija` */

insert  into `kvalifikacija`(`idKvalifikacija`,`naziv`,`ustanova`) values 
(1,'Majstor poslastičarstva','Ugostiteljsko-turistička škola'),
(2,'Specijalista za dekoraciju torti','Akademija lepih zanata i kulinarstva'),
(3,'Čokoladni somelijer','Internacionalni institut za čokoladu'),
(4,'Poslastičar','Ugostiteljsko-turistička škola');

/*Table structure for table `pk` */

DROP TABLE IF EXISTS `pk`;

CREATE TABLE `pk` (
  `idPoslasticar` bigint(20) NOT NULL,
  `idKvalifikacija` bigint(20) NOT NULL,
  `datumSticanja` date NOT NULL,
  PRIMARY KEY (`idPoslasticar`,`idKvalifikacija`),
  KEY `idKvalifikacija` (`idKvalifikacija`),
  CONSTRAINT `pk_ibfk_1` FOREIGN KEY (`idPoslasticar`) REFERENCES `poslasticar` (`idPoslasticar`),
  CONSTRAINT `pk_ibfk_2` FOREIGN KEY (`idKvalifikacija`) REFERENCES `kvalifikacija` (`idKvalifikacija`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `pk` */

insert  into `pk`(`idPoslasticar`,`idKvalifikacija`,`datumSticanja`) values 
(1,1,'2023-02-22'),
(1,3,'2024-06-21'),
(2,1,'2021-05-12'),
(2,2,'2024-06-18'),
(3,1,'0000-00-00');

/*Table structure for table `poslastica` */

DROP TABLE IF EXISTS `poslastica`;

CREATE TABLE `poslastica` (
  `idPoslastica` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) NOT NULL,
  `opis` varchar(50) NOT NULL,
  `rokTrajanja` varchar(20) NOT NULL,
  `cena` double NOT NULL,
  `jedinicaMere` enum('KG','KOMAD','PARČE','PAKET','G') NOT NULL DEFAULT 'KOMAD',
  PRIMARY KEY (`idPoslastica`),
  UNIQUE KEY `uk_poslastica_naziv` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `poslastica` */

insert  into `poslastica`(`idPoslastica`,`naziv`,`opis`,`rokTrajanja`,`cena`,`jedinicaMere`) values 
(1,'Doboš torta','Tradicionalna torta sa čokoladnim filom i karamel ','5 dana',450,'KOMAD'),
(2,'Krempita','Prhko testo sa bogatim vanila kremom','3 dana',250,'KOMAD'),
(3,'Čokoladni mafin','Mafin sa komadićima crne i mlečne čokolade','7 dana',180,'KOMAD'),
(4,'Cheesecake','Osvežavajući kolač sa podlogom od keksa i prelivom','4 dana',380,'KOMAD'),
(15,'Moskva šnit','Tradicionalni kremasti kolač sa višnjama, ananasom','4 dana',380,'PARČE'),
(16,'Makarons paket','Luksuzna kutija od 12 raznobojnih francuskih makar','7 dana',1200,'PAKET'),
(17,'Domaći sitni kolači','Miks slavskih i sitnih kolača (bounty, bajadere, r','10 dana',1800,'KG'),
(18,'Ekleri sa lešnikom','Prhko testo punjeno finim kremom od lešnika i čoko','3 dana',220,'KOMAD'),
(19,'Plazma torta','Omiljena torta sa mlevenom plazmom, maslacem i sla','5 dana',2100,'KG'),
(20,'Voćni kup','Osvežavajući miks sezonskog voća sa domaćim šlagom','1 dan',290,'KOMAD'),
(21,'Kapkejk vanila','Vazdušasti mafin sa bogatim kremom od burbon vanil','4 dana',190,'KOMAD'),
(22,'Sladoled na kilo','Porodično pakovanje zanatskog sladoleda od čokolad','30 dana',1400,'KG'),
(23,'Švarcvald parče','Slojevita čokoladna torta sa višnjama i kiselkasto','5 dana',360,'PARČE'),
(24,'Premium Praline','Ručno rađene čokoladne praline u elegantnom poklon','14 dana',950,'PAKET');

/*Table structure for table `poslasticar` */

DROP TABLE IF EXISTS `poslasticar`;

CREATE TABLE `poslasticar` (
  `idPoslasticar` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `korisnickoIme` varchar(50) NOT NULL,
  `lozinka` varchar(20) NOT NULL,
  `telefon` varchar(50) NOT NULL,
  PRIMARY KEY (`idPoslasticar`),
  UNIQUE KEY `uk_poslasticar_korisnickoIme` (`korisnickoIme`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `poslasticar` */

insert  into `poslasticar`(`idPoslasticar`,`ime`,`prezime`,`korisnickoIme`,`lozinka`,`telefon`) values 
(1,'Andrea','Babić','andrea','andrea','0628642317'),
(2,'Katarina','Vujičić','kaca','kaca','0648974678'),
(3,'Petar','Petrović','peki','peki123','064111222'),
(7,'Sara','Lazarević','sara','sara','06378211');

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `idRacun` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumIzdavanja` date NOT NULL,
  `brojStavki` bigint(20) NOT NULL,
  `ukupanIznos` double NOT NULL,
  `nacinPlacanja` varchar(50) NOT NULL,
  `popust` bigint(20) NOT NULL,
  `iznosSaPopustom` double NOT NULL,
  `idPoslasticar` bigint(20) NOT NULL,
  `idKupac` bigint(20) NOT NULL,
  PRIMARY KEY (`idRacun`),
  KEY `idPoslasticar` (`idPoslasticar`),
  KEY `idKupac` (`idKupac`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`idPoslasticar`) REFERENCES `poslasticar` (`idPoslasticar`),
  CONSTRAINT `racun_ibfk_2` FOREIGN KEY (`idKupac`) REFERENCES `kupac` (`idKupac`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `racun` */

insert  into `racun`(`idRacun`,`datumIzdavanja`,`brojStavki`,`ukupanIznos`,`nacinPlacanja`,`popust`,`iznosSaPopustom`,`idPoslasticar`,`idKupac`) values 
(1,'2026-06-19',1,180,'Gotovina',10,162,1,2),
(2,'2026-06-10',1,450,'Kartica',15,382.5,2,3),
(4,'2026-07-04',1,250,'Gotovina',15,212.5,1,3),
(5,'2026-07-05',2,880,'Kartica',5,836,7,5),
(6,'2026-07-09',2,4550,'Kartica',5,4322.5,2,4),
(7,'2026-07-09',1,500,'Gotovina',15,425,2,3);

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `idStavka` bigint(20) NOT NULL AUTO_INCREMENT,
  `idRacun` bigint(20) NOT NULL,
  `rb` bigint(20) NOT NULL,
  `cena` double NOT NULL,
  `kolicina` bigint(20) NOT NULL,
  `ukupanIznos` double NOT NULL,
  `idPoslastica` bigint(20) NOT NULL,
  PRIMARY KEY (`idStavka`,`idRacun`,`rb`),
  KEY `idPoslastica` (`idPoslastica`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`idPoslastica`) REFERENCES `poslastica` (`idPoslastica`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`idStavka`,`idRacun`,`rb`,`cena`,`kolicina`,`ukupanIznos`,`idPoslastica`) values 
(5,2,1,450,1,450,1),
(6,2,1,450,1,450,1),
(8,1,2,180,1,180,3),
(15,4,2,250,1,250,2),
(16,6,1,1800,2,3600,17),
(17,6,2,950,1,950,24),
(18,7,1,250,2,500,2),
(23,5,1,380,1,380,4),
(24,5,3,250,2,500,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
