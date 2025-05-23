CREATE TABLE payments (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    booking_id BIGINT             NOT NULL,
    amount NUMERIC(19,4)          NOT NULL,
    payment_time TIMESTAMP        NOT NULL,
    transaction_id VARCHAR(100)   NOT NULL UNIQUE,
    status VARCHAR(30)            NOT NULL
);