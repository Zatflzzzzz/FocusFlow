CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'USER' CHECK (role IN ('ROLE_USER', 'ROLE_ADMIN')),
    telegram_link VARCHAR(50) NOT NULL,
    profile_picture VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    number_of_violations INT CHECK (number_of_violations >= 0),
    last_action TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS settings (
    notification BOOLEAN,
    theme VARCHAR(50),
    language VARCHAR(10),
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE
);

/*
CREATE TABLE IF NOT EXISTS habit (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description varchar(255) NOT NULL,
    time_to_complete TIMESTAMP NOT NULL,
    due_date DATE NOT NULL,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "user" (id)
);

CREATE TABLE IF NOT EXISTS habit_entries (
     habit_id INTEGER NOT NULL,
     scheduled_date TIMESTAMP NOT NULL,
     is_completed BOOLEAN NOT NULL,
     FOREIGN KEY (habit_id) REFERENCES habit (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS task (
id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description VARCHAR(520) NOT NULL,
deadline TIMESTAMP,
category VARCHAR(50) NOT NULL,
priority VARCHAR(50) NOT NULL,
is_completed BOOLEAN DEFAULT FALSE,
user_id INTEGER NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS task_entries (
    task_id INTEGER NOT NULL,
    scheduled_date TIMESTAMP NOT NULL,
    is_completed BOOLEAN NOT NULL,
    FOREIGN KEY (task_id) REFERENCES task (id) ON DELETE CASCADE
);*/