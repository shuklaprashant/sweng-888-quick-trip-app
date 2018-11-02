CREATE SCHEMA IF NOT EXISTS ${schema~};
CREATE TABLE IF NOT EXISTS ${schema~}.review
(
    id uuid PRIMARY KEY,
    user uuid NOT NULL,
    product uuid NOT NULL,
    rating integer
    description text
)

CREATE TABLE IF NOT EXISTS ${schema~}.attachments
(
    id uuid PRIMARY KEY,
    review uuid NOT NULL,
    image uuid NOT NULL
)