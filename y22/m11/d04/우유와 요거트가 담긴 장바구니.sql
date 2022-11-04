SELECT cart_id
FROM cart_products
WHERE name IN ('milk', 'yogurt')
GROUP BY cart_id
HAVING COUNT(DISTINCT name) = 2;

SELECT cart_id
FROM cart_products
GROUP BY cart_id
HAVING GROUP_CONCAT(name) LIKE '%Yogurt%'
   AND GROUP_CONCAT(name) LIKE '%Milk%';

SELECT m.cart_id
FROM (SELECT DISTINCT cart_id FROM cart_products WHERE name = "Yogurt") y
         INNER JOIN (SELECT DISTINCT cart_id FROM cart_products WHERE name = "Milk") m
                    ON y.cart_id = m.cart_id;

SELECT DISTINCT(cp.cart_id)
FROM cart_products cp,
     cart_products cp2
WHERE cp.cart_id = cp2.cart_id
  AND (cp.name = 'Milk' AND cp2.name = 'Yogurt');