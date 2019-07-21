INSERT INTO movie_app.movie(title, rating, released) VALUES( 'Ransom', 'TWO', '1998-11-16 09:15:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Taken', 'FOUR', '2010-04-06 13:25:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Kung Fu Hustle', 'FIVE', '2006-09-16 19:35:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('The Matrix', 'FIVE', '1999-11-21 17:00:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Hell or High Water', 'FIVE', '2018-07-02 09:15:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Wind River', 'FOUR', '2018-10-23 09:15:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('A Quite Place', 'ONE', '2018-12-18 09:15:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Point Break', 'FIVE', '1991-7-18 22:45:00');
INSERT INTO movie_app.movie(title, rating, released) VALUES('Predators', 'THREE', '2015-9-11 20:45:00');


INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Tom', 'Hardy', 41, 'English');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Jeremy', 'Riener', 39, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Liam', 'Neeson', 62, 'Irish');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Liz', 'Olsan', 29, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Scarlet', 'Johansan', 34, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Dick', 'Kazinski', 31, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Chris', 'Pine', 33, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Ben', 'Foster', 35, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Mel', 'Gibson', 62, 'Australian');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Carrie Anne', 'Moss', 46, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Lawerence', 'Fishbourne', 64, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Keaneu', 'Reeves', 54, 'American');
INSERT INTO movie_app.actor(f_name, l_name, age, nationality) VALUES('Adrian', 'Brody', 41, 'American');

INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES((SELECT id FROM movie WHERE title = 'A Quite Place'), (SELECT id FROM actor WHERE f_name = 'Dick' AND l_name = 'Kazinski'));
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(6, 2);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(5, 7);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(5, 8);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(2, 3);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(1, 9);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(4, 10);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(4,11);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(4, 12);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(8, 12);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(9, 11);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(9, 13);
--INSERT INTO movie_app.movies_and_actors(movie_id, actor_id) VALUES(6, 4);


