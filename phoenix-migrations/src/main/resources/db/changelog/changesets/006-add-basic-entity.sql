ALTER TABLE movie_languages
    add column created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    add column updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    add column created_by VARCHAR(255),
    add column updated_by VARCHAR(255);

ALTER TABLE movie_genres
    add column created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    add column updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    add column created_by VARCHAR(255),
    add column updated_by VARCHAR(255);