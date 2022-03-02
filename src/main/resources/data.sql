INSERT INTO
    refrigerant(id, name)
VALUES
    (1, 'R410A'),
    (2, 'R134A');

INSERT INTO
    producent(id, name)
VALUES
    (1, 'Carrier'),
    (2, 'STULZ');

INSERT INTO
    category(id, name, description)
VALUES
    (1, 'Wentylacja', 'Urządzenia do nawiewania i wywiewania powietrza z obsługiwnaych pomieszczeń'),
    (2, 'Klimatyzacja', 'Urządzenia do kontroli klimatu wewnętrznego w obsługiwanych pomieszczeniach');

INSERT INTO
    device(id, name, serial_number, model, production_date, producent_id, value, cooling_power, refrigerant_id, refrigerant_mass, localization, category_id)
VALUES
    (1, 'Agregat chłodniczy Carrier 30KAV', '12345678', '30KAV', '2020-06-25', 1, 500000.00, 580.00, 2, 120, 'podest techniczny', 2);