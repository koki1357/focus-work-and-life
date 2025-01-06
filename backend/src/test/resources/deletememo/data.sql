-- First insert books with explicit IDs
INSERT INTO books (id, title, author, user_id) VALUES
(1, 'DeleteMemo Test Book 1', 'Author 1', 'user1'),
(2, 'DeleteMemo Test Book 2', 'Author 2', 'useri'),
(3, 'DeleteMemo Test Book 3', 'Author 3', 'user2');

-- Then insert memos with direct book_id references
INSERT INTO memos (book_id, user_id, content) VALUES 
(1, 'user1', '物語の設定が興味深い。社会の在り方について考えさせられる。'),
(2, 'useri', NULL),
(3, 'user2', '著者不明だが、タイトルに惹かれて購入。早く読みたい。');
