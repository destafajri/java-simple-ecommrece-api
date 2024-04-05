CREATE INDEX idx_token ON "user_tokens" ("token");
CREATE INDEX idx_token_type ON "user_tokens" ("token_type");
CREATE INDEX idx_revoked ON "user_tokens" ("revoked");
CREATE INDEX idx_user_id ON "user_tokens" ("user_id");
