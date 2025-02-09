create table users
(
    id    integer generated always as identity,
    name  varchar(40),
    email varchar(50),
    phone varchar(15),
    type  varchar(8),
    primary key (id)
);

create table addresses
(
    id         integer generated always as identity,
    user_id    integer,
    street     varchar(30),
    number     integer,
    city       varchar(29),
    state      varchar(2),
    zip_code   varchar(9),
    complement varchar(50),
    primary key (id),
    foreign key (user_id) references users (id)
);

create table products
(
    id          integer generated always as identity,
    seller_id   integer,
    name        varchar(40),
    description varchar(256),
    price       numeric(6, 2),
    stock       integer,
    primary key (id),
    foreign key (seller_id) references users (id)
);

create table categories
(
    id   integer generated always as identity,
    name varchar(30),
    primary key (id)
);

create table product_categories
(
    product_id  integer,
    category_id integer,
    foreign key (product_id) references products (id),
    foreign key (category_id) references categories (id)
);

create table orders
(
    id          integer generated always as identity,
    order_date  date,
    status      varchar(9),
    customer_id integer,
    primary key (id),
    foreign key (customer_id) references users (id)
);

create table order_items
(
    id         integer generated always as identity,
    order_id   integer,
    product_id integer,
    quantity   integer,
    subtotal   numeric(6, 2),
    primary key (id),
    foreign key (order_id) references orders (id)
);

create table payments
(
    id             integer generated always as identity,
    order_id       integer,
    payment_method varchar(6),
    status         varchar(8),
    amount         numeric(6, 2),
    primary key (id),
    foreign key (order_id) references orders (id)
);

create table carts
(
    id          integer generated always as identity,
    customer_id integer,
    primary key (id),
    foreign key (customer_id) references users (id)
);

create table cart_items
(
    id integer generated always as identity,
    cart_id integer,
    item_id integer,
    primary key (id),
    foreign key (cart_id) references carts (id),
    foreign key (item_id) references order_items (id)
);
