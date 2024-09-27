INSERT INTO Television (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality, smart_tv, wifi, voice_control, hdr, bluetooth, ambilight, original_stock, sold)
VALUES
    (1, 'LED', 'Samsung', 'Samsung Series 7', 799.99, 55.0, 120, 'Flat', '4K', TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, 100, 30),
    (2, 'OLED', 'LG', 'LG CX', 1499.99, 65.0, 144, 'Curved', '8K', TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, 80, 20),
    (3, 'QLED', 'Sony', 'Sony Bravia X900H', 1299.99, 75.0, 120, 'Flat', '4K', TRUE, TRUE, FALSE, TRUE, TRUE, FALSE, 60, 15),
    (4, 'LED', 'Philips', 'Philips 6700', 599.99, 50.0, 60, 'Flat', 'Full HD', FALSE, TRUE, FALSE, FALSE, FALSE, TRUE, 120, 50),
    (5, 'LCD', 'TCL', 'TCL 6-Series', 499.99, 43.0, 60, 'Flat', 'Full HD', TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, 150, 100);

INSERT INTO remotes (id, name, brand, compatible_with, battery_type, price, original_stock, sold)
VALUES
    (1, 'Samsung Remote', 'Samsung', 'Samsung Series 7', 'AA', 19.99, 200, 50),
    (2, 'LG Remote', 'LG', 'LG CX', 'AAA', 24.99, 100, 30),
    (3, 'Sony Remote', 'Sony', 'Sony Bravia X900H', 'AA', 29.99, 150, 40),
    (4, 'Philips Remote', 'Philips', 'Philips 6700', 'AAA', 14.99, 300, 100),
    (5, 'TCL Remote', 'TCL', 'TCL 6-Series', 'AA', 9.99, 250, 150);

INSERT INTO ci_modules (id, name, type, price, original_stock, sold)
VALUES
    (1, 'Samsung CI Module', 'CAM', 59.99, 50, 10),
    (2, 'LG CI Module', 'CAM', 64.99, 30, 5),
    (3, 'Sony CI Module', 'CAM', 54.99, 20, 3),
    (4, 'Philips CI Module', 'CAM', 49.99, 40, 15),
    (5, 'TCL CI Module', 'CAM', 44.99, 60, 25);

INSERT INTO Wall_brackets (id, name, size, price, original_stock, sold)
VALUES
    (1, 'Samsung Wall Bracket', 'Large', 79.99, 50, 20),
    (2, 'LG Wall Bracket', 'Medium', 69.99, 60, 10),
    (3, 'Sony Wall Bracket', 'Large', 89.99, 40, 15),
    (4, 'Philips Wall Bracket', 'Medium', 59.99, 80, 30),
    (5, 'TCL Wall Bracket', 'Small', 39.99, 100, 50);

INSERT INTO television_wallbrackets (wall_bracket_id, television_id)
VALUES
    (1, 1), -- Samsung TV and Samsung Wall Bracket
    (2, 2), -- LG TV and LG Wall Bracket
    (3, 3), -- Sony TV and Sony Wall Bracket
    (4, 4), -- Philips TV and Philips Wall Bracket
    (5, 5), -- TCL TV and TCL Wall Bracket
    (1, 3), -- Sony TV compatible with Samsung Wall Bracket as well
    (2, 5); -- TCL TV compatible with LG Wall Bracket as well
