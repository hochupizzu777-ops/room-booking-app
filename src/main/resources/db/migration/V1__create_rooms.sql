CREATE TABLE rooms (
                       id VARCHAR(36) PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       capacity INTEGER NOT NULL,
                       active BOOLEAN NOT NULL DEFAULT TRUE,

                       CONSTRAINT rooms_capacity_positive CHECK (capacity > 0)
);