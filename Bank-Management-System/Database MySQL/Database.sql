 create database bankmanagementsystem;
  use bankmanagementsystem;
  
 select*from signup;
 select*from signuptwo;
 select*from signupthree;
 select*from login;
 select*from bank;
 
  create table signup(formular varchar(20), nume varchar(40), nume_tata varchar(40), zdn varchar(20), sex varchar(20), mail varchar(40), statut_civil varchar(20), adresa varchar(35), oras varchar(20), judet varchar(15), cod_postal varchar(20));
  
   
   
   create table signuptwo (formular varchar(20), mostenitori varchar(20), persoana varchar(40), venit_lunar varchar(40), educatie varchar(20), ocupatie varchar(20), CNP varchar(40), numar_telefon varchar(20), persoana_majora varchar(35), cont_existent varchar(15));
   
   create table signupthree  (formular varchar(20), tip_cont varchar(20), numar_card varchar(40), pin_card varchar(40), servicii_necesare varchar(20));
   
   create table login (formular varchar(20), numar_card varchar(40), pin_card varchar(15));
   
   create table bank(pin varchar(20), date varchar(60), type varchar(20), suma varchar(20));
   
   drop table bank;
   