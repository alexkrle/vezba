set foreign_key_checks = 0;

-- delete all rows
truncate table enrollment; 
truncate table student;
truncate table course;
truncate table profesor;

set foreign_key_checks = 1;

insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra1-2014', 'Marko', 'Marković', 'Svetog Save 39', 'markom@yahoo.com', 3, 5);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra2-2014', 'Milan', 'Milanović', 'Bulevar Oslobodjenja 3', 'mmilanovic92@gmail.com', 1, 1);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra3-2014', 'Ivana', 'Novaković', 'Narodnog Fronta 54', 'ivananovakovic@gmail.com', 1, 1);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra4-2014', 'Dejan', 'Dejanović', 'Fruskogorska 12', 'dejandejanovic@yahoo.com', 3, 5);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra5-2014', 'Jelena', 'Marković', 'Zmaj Jovina 13', 'jmarkovic2@gmail.com', 3, 5);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra6-2014', 'Zoran', 'Zoranović', 'Kralja Petra 1', 'zokizoki@gmail.com', 2, 4);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra7-2014', 'Milica', 'Petrović', 'Momo Kapora 52', 'milicapetrovic@gmail.com', 2, 4);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra8-2014', 'Petar', 'Petrović', 'Ratarska 21', 'peracar@yahoo.com', 3, 5);
insert into student (br_indexa, ime, prezime, adresa, mail, godina, semestar) values ('ra9-2014', 'Igor', 'Jović', 'Cara Dusana 43', 'igorjovic@outlook.com', 1, 1);

insert into course (naziv) values ('Matematika 1');
insert into course (naziv) values ('Osnove programiranja');
insert into course (naziv) values ('Objektno programiranje');
insert into course (naziv) values ('Baza Podataka');
insert into course (naziv) values ('eObrazovanje');
insert into course (naziv) values ('Upravljanje projektima');
insert into course (naziv) values ('Matematika 2');
insert into course (naziv) values ('Web Dizajn');
insert into course (naziv) values ('Web Programiranje');

insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 1, 1);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 2, 1);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 3, 1);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 4, 1);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 1, 2);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 2, 2);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 3, 2);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 5, 1);
insert into enrollment (start_date, end_date, student_id, course_id) values ('2015-01-01', '2015-06-01', 6, 2);

insert into profesor (ime, prezime, uloga, mail) values ('Marko', 'Novakovic', 'predavac', 'mnovakovic@gmail.com');
insert into profesor (ime, prezime, uloga, mail) values ('Petar', 'Jovicic', 'asistent', 'petarjovic@yahoo.com');
insert into profesor (ime, prezime, uloga, mail) values ('Miladin', 'Markovic', 'predavac', 'miladinm@gmail.com');
insert into profesor (ime, prezime, uloga, mail) values ('Zivko', 'Aksentijevic', 'predavac', 'zivko234@gmail.com');
insert into profesor (ime, prezime, uloga, mail) values ('Aleksa', 'Zivkovic', 'predavac', 'azivkovic@gmail.com');
insert into profesor (ime, prezime, uloga, mail) values ('Sasa', 'Stanojevic', 'predavac', 'sasastanojevic@outlook.com');
insert into profesor (ime, prezime, uloga, mail) values ('Aleksandar', 'Krstajic', 'predavac', 'aleksandarkrstajic@yahoo.com');
insert into profesor (ime, prezime, uloga, mail) values ('Mateja', 'Petrovic', 'asistent', 'petrovicm@yahoo.com');
insert into profesor (ime, prezime, uloga, mail) values ('Snezana', 'Zoric', 'predavac', 'snezanazoric@gmail.com');

