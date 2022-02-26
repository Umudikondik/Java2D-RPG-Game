Create table highscores
(
    rank integer NOT NULL,
    nickname character varying(20) NOT NULL,
    point double precision NOT NULL
)

Insert into highscores(
    rank, nickname, point)
	Values(1, 'Derin', 3000), (2, 'Umudi', 1200), (3, 'CanBaba', 950), (4, 'Wow!', 800), (5, 'deneme', 600);

