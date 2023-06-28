INSERT INTO online_wallet.public.transactions (profile_id, category_id, is_income, amount, message, transaction_date)
VALUES (1, 1, true, 100.00, 'Received salary', '2023-01-01'),
       (1, 2, false, 50.00, 'Bought groceries', '2023-01-05'),
       (1, 3, true, 200.00, 'Received bonus', '2023-02-10'),
       (1, 4, false, 25.00, 'Paid for transportation', '2023-03-15'),
       (1, 5, true, 50.00, 'Received gift', '2023-04-20'),
       (1, 6, false, 10.00, 'Paid for monthly subscription', '2023-05-25'),
       (1, 7, false, 150.00, 'Paid for online course', '2023-06-02')