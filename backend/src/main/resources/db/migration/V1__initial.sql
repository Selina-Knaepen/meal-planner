CREATE SEQUENCE hibernate_sequence;
ALTER SEQUENCE hibernate_sequence OWNER TO mealplanner;

CREATE TABLE meal
(
	id BIGINT NOT NULL PRIMARY KEY,
	name VARCHAR(255),
	portionsize INTEGER NOT NULL
);

CREATE TABLE ingredient
(
	id BIGINT NOT NULL,
	meal_id BIGINT,
	name VARCHAR(255),
	unit VARCHAR(255),
	amount FLOAT,
	CONSTRAINT pk_ingredient PRIMARY KEY (id)
);

ALTER TABLE ingredient
	ADD CONSTRAINT fk_ingredient_on_meal FOREIGN KEY (meal_id) REFERENCES meal (id);

CREATE TABLE ingredientblacklist
(
	id BIGINT NOT NULL,
	meal_id BIGINT,
	day INTEGER,
	CONSTRAINT pk_ingredientblacklist PRIMARY KEY (id)
);

ALTER TABLE ingredientblacklist
	ADD CONSTRAINT fk_ingredientblacklist_on_meal FOREIGN KEY (meal_id) REFERENCES meal (id);

CREATE TABLE dayplan
(
	id BIGINT NOT NULL,
	meal_id BIGINT,
	date DATE,
	CONSTRAINT pk_dayplan PRIMARY KEY (id)
);

ALTER TABLE dayplan
	ADD CONSTRAINT fk_dayplan_on_meal FOREIGN KEY (meal_id) REFERENCES meal;

CREATE TABLE mealblacklist
(
	id BIGINT NOT NULL,
	meal_id BIGINT,
	day INTEGER,
	CONSTRAINT pk_mealblacklist PRIMARY KEY (id)
);

ALTER TABLE mealblacklist
	ADD CONSTRAINT fk_mealblacklist_on_meal FOREIGN KEY (meal_id) REFERENCEs meal;
