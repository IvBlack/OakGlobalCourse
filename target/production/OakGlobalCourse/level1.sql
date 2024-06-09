--CREATE DATABASE  book_repository;

--table 1
create table author
(
    id serial primary key,
    first_name varchar(128) not null,
    last_name varchar(128) not null
);

--table 2 with FK
create table book
(
    id bigserial primary key,
    name varchar(128) not null,
    year smallint not null,
    pages smallint not null,
    author_id int references author (id)
);

insert into author (first_name, last_name)
values ('Key', 'Horsman'),
       ('Stiven', 'Kovi'),
       ('Tony', 'Robbins'),
       ('Napoleon', 'Hill'),
       ('Robert', 'Kiyosaki'),
       ('Dale', 'Karnegi');

select  * from author;

insert into book (name, year, pages, author_id)
values ('JS', 2000, 1547, (select  id from author where last_name = 'Horsman')),
       ('Java', 2001, 1567, (select  id from author where last_name = 'Horsman')),
       ('JAVA SE', 2012, 547, (select  id from author where last_name = 'Horsman')),
       ('7 habits of ...', 1998, 747, (select  id from author where last_name = 'Kovi')),
       ('Awake ...', 2000, 265, (select  id from author where last_name = 'Robbins')),
       ('THINK AND THIN', 1930, 336, (select  id from author where last_name = 'Hill')),
       ('Rich papa', 1997, 337, (select  id from author where last_name = 'Kiyosaki')),
       ('Kvadrant ...', 1998, 336, (select  id from author where last_name = 'Kiyosaki')),
       ('How to ...', 1948, 368, (select  id from author where last_name = 'Karnegi')),
       ('How to get ...', 1936, 352, (select  id from author where last_name = 'Karnegi'));

drop table book;

--practice
--выбрать название книги, год и имя автора, отсортированные по году названия.
--Решение без joins:
select name,
       year,
       (select a.first_name from author a where a.id = book.author_id)
from book
order by year DESC;

--количество книг у заданного автора.
--count аггрегирует количество в одно значение.
--если имена совпадают, то будет ошибка. Используйте IN в фильтрации.
select count(*)
from book
where author_id = (select id from author where first_name = 'Dale');


--запрос выбирает книги, у которых количество страниц больше среднего количества страниц по всем внигам:
select *
from book where pages > 640.2;

select avg(pages)
from book;

--комбинируем два запроса:
select *
from book where pages > (select avg(pages)
                         from book);

--выбрать 5 самых старых книг
--посчитать их суммарное кол-во страниц
select  *
from book
order by year
limit 5;

select sum(pages)
from book;

--объединим запросы
--подзапрос д. возвращать столько значений, сколько подхожит для него по контексту.
select sum(b.pages)
from (select *
      from book
      order by year
      limit 5) as b;

--изменить количество страниц одной из книг
update book
set pages = pages + 5
where id = 2
returning name, year, pages;


--удалить автора самой большой книги
delete from author
where id = (select author_id
            from book
            where pages = (select max(pages)
                           from book));

select author_id
from book
where pages = (select max(pages)
               from book);

select max(pages)
from book;