-- Password: testpass (BCrypt hashed)
INSERT INTO users (user_id, password) VALUES
    ('testuser', '$2a$10$7fgVK7BmkLgZ7Psqg0R/8.qMgYfUtn5cADio2Gh0H1No6eKslZRQW');

-- Add a test user with incorrect password for negative test cases
INSERT INTO users (user_id, password) VALUES
    ('wronguser', '$2a$10$differenthashforwrongpassword');
