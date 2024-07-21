CREATE TABLE public.cars (
        cars_id INTEGER NULL,
        cars_brand VARCHAR NULL,
        cars_model VARCHAR NULL,
        cars_price NUMERIC NULL
);

ALERT TABLE cars ALTER COLUMN cars_brand SET NOT NULL,
ADD CONSTRAINT cars_model_unique UNIQUE (cars_model),
ADD CONSTRAINT cars_price_constraint CHECK (cars_price > 0);

ALERT TABLE cars ADD PRIMARY KEY (cars_id);

CREATE TABLE public.person (
        person_id INTEGER NULL,
        person_name VARCHAR NULL,
        person_age INTEGER NULL,
        person_driver_license BOOLEAN NULL
);

ALERT TABLE person ALTER COLUMN person_name SET NOT NULL,
ADD CONSTRAINT person_age CONSTRAINT CHECK (person_age > 18),
ADD CONSTRAINT person_driver_license SET NOT NULL;

ALERT TABLE cars ADD FOREIGN KEY (person_id) REFERENCES person (person_id);