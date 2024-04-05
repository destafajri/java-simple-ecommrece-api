CREATE TABLE "user_roles" (
  "user_id" bigint,
  "role_id" int,
  "created_at" timestamptz NOT NULL DEFAULT 'now()',
  PRIMARY KEY ("user_id", "role_id")
);