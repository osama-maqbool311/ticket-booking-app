INSERT INTO SHOWS (id, title, location, start_time, end_time) VALUES
  (1, 'Hamilton',    'The Majestic Theatre', '2025-06-01 19:00:00', '2025-06-01 22:30:00'),
  (2, 'Wicked',      'Gershwin Theatre',     '2025-06-02 18:00:00', '2025-06-02 21:30:00'),
  (3, 'Lion King',   'Minskoff Theatre',     '2025-06-03 20:00:00', '2025-06-03 23:00:00');

INSERT INTO SEATS (id, seat_number, show_id, booked) VALUES
  ( 1, 'S1', 1, FALSE), ( 2, 'S2', 1, FALSE), ( 3, 'S3', 1, FALSE), ( 4, 'S4', 1, FALSE), ( 5, 'S5', 1, FALSE),
  ( 6, 'S1', 2, FALSE), ( 7, 'S2', 2, FALSE), ( 8, 'S3', 2, FALSE), ( 9, 'S4', 2, FALSE), (10, 'S5', 2, FALSE),
  (11, 'S1', 3, FALSE), (12, 'S2', 3, FALSE), (13, 'S3', 3, FALSE), (14, 'S4', 3, FALSE), (15, 'S5', 3, FALSE);

INSERT INTO BOOKINGS (id, email, mobile, show_id, seat_count, status, booking_time) VALUES
  (1, 'alice@example.com', '+15550001111', 1, 2, 'CONFIRMED', '2025-05-01 10:15:00'),
  (2, 'bob@example.com',   '+15550002222', 2, 3, 'CONFIRMED', '2025-05-01 11:00:00');

INSERT INTO BOOKING_SEATS (booking_id, seat_id) VALUES
  (1, 1),
  (1, 2);

UPDATE SEATS SET booked = TRUE WHERE id IN (1, 2);

INSERT INTO BOOKING_SEATS (booking_id, seat_id) VALUES
  (2, 8),
  (2, 9),
  (2, 10);

UPDATE SEATS SET booked = TRUE WHERE id IN (8, 9, 10);