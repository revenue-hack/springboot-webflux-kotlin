CREATE TABLE IF NOT EXISTS `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(256) NOT NULL,
  `created_at` TIMESTAMP NULL DEFAULT current_timestamp,
  `is_delete` TINYINT DEFAULT 0,
  PRIMARY KEY (`id`));

INSERT INTO users (name) VALUES ('e1'), ('e2'), ('e3');