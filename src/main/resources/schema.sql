CREATE TABLE IF NOT EXISTS users (
     id SERIAL PRIMARY KEY,
     email VARCHAR(255) NOT NULL UNIQUE,
     password VARCHAR(255) NOT NULL,
     username VARCHAR(255) NOT NULL UNIQUE,
     role VARCHAR(50) DEFAULT 'USER',
     telegram_link VARCHAR(50) NOT NULL UNIQUE,
     profile_picture VARCHAR(255),
     status VARCHAR(50) NOT NULL,
     number_of_violations INT CHECK (number_of_violations >= 0),
     last_action TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS habits (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  time_to_complete VARCHAR(255) NOT NULL,
  frequency VARCHAR(255) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  person INTEGER NOT NULL,
  foreign key (person) REFERENCES users(id)
);