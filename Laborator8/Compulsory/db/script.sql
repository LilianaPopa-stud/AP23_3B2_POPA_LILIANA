DROP TABLE IF EXISTS albums;
CREATE TABLE albums(
    id INTEGER PRIMARY KEY,
    release_year INTEGER,
    title TEXT,
    artist TEXT,
    genre TEXT
);
DROP TABLE IF EXISTS artists;
CREATE TABLE artists(
    id INTEGER PRIMARY KEY,
    name TEXT UNIQUE
);

DROP TABLE IF EXISTS genres;
CREATE TABLE genres(
    id INTEGER PRIMARY KEY,
    name TEXT UNIQUE

);
DROP TABLE IF EXISTS album_genres;
CREATE TABLE album_genres (
  album_id INTEGER,
  genre_id INTEGER,
  FOREIGN KEY(album_id) REFERENCES albums(id),
  FOREIGN KEY(genre_id) REFERENCES genres(id)
);
