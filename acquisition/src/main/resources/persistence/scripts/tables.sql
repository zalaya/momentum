USE `momentum`;

CREATE TABLE IF NOT EXISTS `processes` (
    id BIGINT PRIMARY AUTO_INCREMENT,
    pid INTEGER NOT NULL,
    name VARCHAR(255) NOT NULL,
    path VARCHAR(510) NOT NULL,
    first_seen TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_seen TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    occurrences INTEGER DEFAULT 1
);

CREATE TABLE IF NOT EXISTS `process_history` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    process_id BIGINT NOT NULL,
    usage DOUBLE NOT NULL,
    threads INTEGER NOT NULL,
    memory DOUBLE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (process_id) REFERENCES processes(id) ON DELETE RESTRICT
);

CREATE INDEX idx_process_id ON process_history(process_id);
CREATE INDEX idx_created_at ON process_history(created_at);
