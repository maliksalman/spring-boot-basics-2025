delete from hero;
insert into hero (name, secret_identity, universe, age) values ('Batman', 'Bruce Wayne', 'dc', 45);
insert into hero (name, secret_identity, universe, age) values ('Hulk', 'Bruce Banner', 'marvel', 35);
insert into hero (name, secret_identity, universe, age) values ('Ironman', 'Tony Clark', 'marvel', 40);

delete from universe;
insert into universe(name, fictional_cities) values('dc', true);
insert into universe(name, fictional_cities) values('marvel', false);