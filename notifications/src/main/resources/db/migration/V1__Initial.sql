DROP TABLE IF EXISTS "notifications";
CREATE SEQUENCE notifications_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "notifications" (
    "id" bigint,
    "timestamp" timestamp NOT NULL,
    "message" TEXT,
    "service" TEXT,
    CONSTRAINT "notifications_pkey" PRIMARY KEY ("id")
);