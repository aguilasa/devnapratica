/* Database: Oracle. Generation date: 2019-06-21 17:09:26:080 */
/* Entity Category */
create table category (
	id RAW(16) NOT NULL,
	description VARCHAR(255) NOT NULL
);



/* Entity ItemList */
create table item_list (
	id RAW(16) NOT NULL,
	description VARCHAR(255) NOT NULL,
	quantity NUMBER(19,4) NOT NULL,
	unit NUMBER(19) NOT NULL,
	price NUMBER(19,4) NOT NULL,
	category RAW(16) NOT NULL,
	note VARCHAR(255)
);



/* Entity ShoppingList */
create table shopping_list (
	id RAW(16) NOT NULL,
	description VARCHAR(255) NOT NULL
);



/* Join Tables */
/* master: ShoppingList as shopping_list, detail: ItemList as item_list */
create table shopping_list_items (
	shopping_list_id RAW(16) NOT NULL,
	items_id RAW(16) NOT NULL
);

/* Primary Key Constraints */
alter table category add constraint pk_category_id primary key(id);
alter table item_list add constraint pk_item_list_id primary key(id);
alter table shopping_list_items add constraint pk_shopping_list_items primary key(shopping_list_id, items_id);
alter table shopping_list add constraint pk_shopping_list_id primary key(id);

/* Foreign Key Constraints */
alter table item_list add constraint fkj9i1nrsesgxcic565k7opmz2d8bb foreign key (category) references category (id);
alter table shopping_list_items add constraint fkz0zs6bl2pxmtlzd8wx1ge67edtef foreign key (shopping_list_id) references shopping_list (id);
alter table shopping_list_items add constraint fkyvqo4ph5clfksjcfnuo3dwpdtfvj foreign key (items_id) references item_list (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
