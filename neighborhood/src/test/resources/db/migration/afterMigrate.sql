
delete from offer;
delete from user;
insert into user (id, first_name, last_name, create_date, update_date, email)
values (1011, 'Anuradha', 'Sahar', now(), now(), 'anuradha@sahar.com');
insert into user (id, first_name, last_name, create_date, update_date, email)
values (1021, 'Dhan', 'Maha', now(), now(), 'dhan@maha.com');
insert into offer values( 1, 'Item 1', 'S', now(), now(), 1011);
insert into offer values( 2, 'Item 1', 'S', now(), now(), 1021);