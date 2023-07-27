insert into user_details(id, birth_date, name)
values(10001, current_date(), 'Daniel');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'Ravi');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'Thomas');

insert into post(id, description, user_id)
values(20001, 'I Want to learn AWS', 10001);

insert into post(id, description, user_id)
values(20002, 'I Want to learn DevOps', 10001);

insert into post(id, description, user_id)
values(20003, 'I Want to learn SvelteKit', 10002);