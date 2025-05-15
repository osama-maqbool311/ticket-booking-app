INSERT INTO roles (name) VALUES ('USER'), ('ADMIN');

-- Sample users
INSERT INTO users (username, email, password) VALUES
('john_doe', 'john@example.com', 'hashed_password1'),
('jane_admin', 'jane@example.com', 'hashed_password2');

-- Assign roles
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1), -- john_doe -> USER
(2, 1), -- jane_admin -> USER
(2, 2); -- jane_admin -> ADMIN