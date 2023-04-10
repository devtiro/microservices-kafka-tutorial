DROP TABLE IF EXISTS "books";

CREATE TABLE "books" (
    "isbn" text NOT NULL,
    "title" text,
    "author_id" bigint,
    CONSTRAINT "books_pkey" PRIMARY KEY ("isbn")
);