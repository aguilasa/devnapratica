/* Database: PostgreSql. Generation date: 2019-06-25 17:08:38:862 */
/* Entity Category */
create table category (
	id UUID NOT NULL,
	description VARCHAR(255) NOT NULL
);



/* Entity Product */
create table product (
	id UUID NOT NULL,
	description VARCHAR(255) NOT NULL,
	unit NUMERIC(19) NOT NULL,
	category UUID NOT NULL
);



/* Entity ItemList */
create table item_list (
	id UUID NOT NULL,
	product UUID NOT NULL,
	quantity NUMERIC(19,4) NOT NULL,
	price NUMERIC(19,4) NOT NULL,
	checked BOOLEAN NOT NULL,
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
alter table product add constraint pk_product_id primary key(id);
alter table item_list add constraint pk_item_list_id primary key(id);
alter table shopping_list_items add constraint pk_shopping_list_items primary key(shopping_list_id, items_id);
alter table shopping_list add constraint pk_shopping_list_id primary key(id);

/* Foreign Key Constraints */
alter table product add constraint fk3zwoocxxsrpptdzyefwwigz1tx36 foreign key (category) references category (id);
alter table item_list add constraint fkyi371joi3i1fljjq7wwj3eukqwug foreign key (product) references product (id);
alter table shopping_list_items add constraint fkshu1n7ys8us9q5wya5j8344i7xso foreign key (shopping_list_id) references shopping_list (id);
alter table shopping_list_items add constraint fkuzqqpfqgbmj6c2saxilog5zopaac foreign key (items_id) references item_list (id);

/* Unique Key Constraints */

/* Sequences for auto increment entity ids */
