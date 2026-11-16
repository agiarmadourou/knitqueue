CREATE TABLE app_user (
	user_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	email VARCHAR(254) UNIQUE NOT NULL,
	password_hash VARCHAR(255) NOT NULL,
	first_name VARCHAR(100)	
);

CREATE TABLE project (
	project_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	user_id INT NOT NULL REFERENCES app_user(user_id),
	project_name VARCHAR(254) NOT NULL,
	notes TEXT,
	reference_url VARCHAR(2048),
	image_url VARCHAR(2048),
	project_state VARCHAR(20) NOT NULL DEFAULT 'IDEA'
		CHECK (project_state IN ('IDEA','UP_NEXT','WIP','FINISHED'))
);

CREATE TABLE shopping_item (
	shopping_item_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
	project_id INT REFERENCES project(project_id) ON DELETE CASCADE,
	user_id INT NOT NULL REFERENCES app_user(user_id),
	description VARCHAR(254) NOT NULL,
	purchase_url VARCHAR(2048),	
	is_purchased BOOLEAN NOT NULL DEFAULT FALSE
);
