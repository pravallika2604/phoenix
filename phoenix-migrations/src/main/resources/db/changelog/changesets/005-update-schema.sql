ALTER table movie_languages
    drop column language_id,
    add column language VARCHAR(50);

ALTER table movie_genres
    drop column genre_id,
    add column genre VARCHAR(50);

ALTER table seats
    drop column category_id,
    add column category VARCHAR(50);

ALTER TABLE seat_show_prices
    rename to seat_category_show_prices;

ALTER table seat_category_show_prices
    drop column category_id,
    add column category VARCHAR(50);

ALTER table screens
    drop column status;


Drop table languages;
Drop table genres;
Drop table seat_categories;