INSERT INTO payments (booking_id, amount, payment_time, transaction_id, status)
VALUES 
  (101,  50.00, TIMESTAMP '2025-05-06 10:00:00', 'TXN1001', 'COMPLETED'),
  (102,  75.25, TIMESTAMP '2025-05-06 11:30:00', 'TXN1002', 'PENDING');