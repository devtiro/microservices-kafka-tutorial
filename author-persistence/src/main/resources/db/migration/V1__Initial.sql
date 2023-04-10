DROP TABLE IF EXISTS "authors";
DROP SEQUENCE IF EXISTS authors_id_seq;
CREATE SEQUENCE authors_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "authors" (
    "id" bigint DEFAULT nextval('authors_id_seq') NOT NULL,
    "name" text,
    "age" integer,
    CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);