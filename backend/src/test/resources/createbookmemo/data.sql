-- Insert books first
INSERT INTO books (title, author, user_id) VALUES
('CreateMemo Test Book 1', 'Author 1', 'user1');

INSERT INTO books (title, author, user_id) VALUES
('CreateMemo Test Book 2', 'Author 2', 'useri');

INSERT INTO books (title, author, user_id) VALUES
('CreateMemo Test Book 3', 'Author 3', 'user2');

-- Insert memos using the auto-incremented IDs (1, 2, 3)
INSERT INTO memos (book_id, user_id, content) VALUES 
(1, 'user1', '物語の設定が興味深い。社会の在り方について考えさせられる。'),
(2, 'useri', NULL),
(3, 'user2', '著者不明だが、タイトルに惹かれて購入。早く読みたい。');
