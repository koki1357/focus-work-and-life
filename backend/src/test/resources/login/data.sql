-- Password: testpass (BCrypt hashed)
INSERT INTO user (user_id, password) VALUES
    ('testuser', '$2a$10$6pGBgfXGwH.jVIaJD3yrJO3KxuRkUQ/aRrxeF1aXGsW0FZ9p8RrxO');

-- Add a test user with incorrect password for negative test cases
INSERT INTO user (user_id, password) VALUES
    ('wronguser', '$2a$10$differenthashforwrongpassword');
