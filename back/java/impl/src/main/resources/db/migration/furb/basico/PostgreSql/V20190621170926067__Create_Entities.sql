/* Database: PostgreSql. Generation date: 2019-06-21 17:09:26:067 */
/* Entity Category */
create table category (
	id UUID NOT NULL,
	description VARCHAR(255) NOT NULL
);



/* Entity ItemList */
create table item_list (
	id UUID NOT NULL,
	description VARCHAR(255) NOT NULL,
	quantity NUMERIC(19,4) NOT NULL,
	unit NUMERIC(19) NOT NULL,
	price NUMERIC(19,4) NOT NULL,
	category UUID NOT NULL,
	note VARCHAR(255)
);



/* Entity ShoppingList */
create table shopping_list (
	id UUID NOT NULL,
	description VARCHAR(255) NOT NULL
);



/* Join Tables */
/* master: ShoppingList as shopping_list, detail: ItemList as item_list */
create table shopping_list_items (
	shopping_list_id UUID NOT NULL,
	items_id UUID NOT NULL
);

/* Primary Key Constraints */
alter table category add constraint pk_category_id primary key(id);
alter table item_list add constraint pk_item_list_id primary key(id);
alter table shopping_list_items add constraint pk_shopping_list_items primary key(shopping_list_id, items_id);
alter table shopping_list add constraint pk_shopping_list_id primary key(id);

/* Foreign Key Constraints */
alter table item_list add constraint fkyvlmitfadrfkeqcoc2gtmlyibwmm foreign key (category) references category (id);
alter table shopping_list_items add constraint fkvd7gmz0q8c8ucfyisdia3hoyjxip foreign key (shopping_list_id) references shopping_list (id);
alter table shopping_list_items add constraint fky9awg2gobyuaivpulhnjlgn73ta6 foreign key (items_id) references item_list (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
