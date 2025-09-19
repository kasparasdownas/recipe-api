INSERT INTO recipe (id, title, description, created_at)
VALUES (100, 'Pancakes', 'Fluffy pancakes with syrup', CURRENT_TIMESTAMP);

INSERT INTO ingredient (id, name, quantity, recipe_id)
VALUES
  (1001, 'Flour', '200g', 100),
  (1002, 'Milk', '250ml', 100),
  (1003, 'Eggs', '2 pcs', 100);