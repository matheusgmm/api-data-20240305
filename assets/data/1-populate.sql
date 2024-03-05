USE application;

-- INSERT INTO users(email, password) VALUES ('admin', 'root');
INSERT INTO users(email, password, role) VALUES ('admin', '$2a$12$1GmHef9B8zUeLlLNbvLVCu.TgN4qFzzEUStH0IelVD9sVz.AdmhqC', 'ADMIN');
INSERT INTO users(email, password, role) VALUES ('comum', '$2a$12$73weTtc/bCFzd4ac6W40IOy34QsAHRFnBbofiY3yRL9ipQUeELvW.', 'USER');