INSERT INTO
    refrigerant(id, name, gwp)
VALUES
    (1, 'R410A', 2088),
    (2, 'R134A', 1430);

INSERT INTO
    producent(id, name, contact_info)
VALUES
    (1, 'Carrier', 'qwefqwergqwer'),
    (2, 'STULZ', 'wqerghhaerherhewawefbtshrth');

INSERT INTO
    category(id, name, description)
VALUES
    (1, 'Wentylacja', 'Urządzenia do nawiewania i wywiewania powietrza z obsługiwnaych pomieszczeń'),
    (2, 'Klimatyzacja', 'Urządzenia do kontroli klimatu wewnętrznego w obsługiwanych pomieszczeniach'),
    (3, 'Chłodnictwo', 'Urządzenia do wytwarzania chłodu');

INSERT INTO
    device(id, name, serial_number, model, production_date, producent_id, value, cooling_power, refrigerant_id, refrigerant_mass, localization, category_id)
VALUES
    (1, 'Agregat chłodniczy Carrier 30KAV', '12345678', '30KAV', '2020-06-25', 1, 500000.00, 580.00, 2, 120, 'podest techniczny', 2);

INSERT INTO
    users(id, email, password, first_name, last_name, account_expiration, account_lock, credential_expiration, account_activation)
VALUES
    (1, 'l.skarbek@wp.pl', '$2a$12$p7f..QR.17qcbB6Qd0.Hku2cEyCsXsa4x.xe4KrZPPVFg9lQNkRGm', 'Łukasz', 'Skarbek', true, true,true, true);