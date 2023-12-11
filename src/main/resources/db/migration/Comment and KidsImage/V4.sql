create table UserImageLikes
(
    user_id  int                                   not null,
    img_id   int                                   not null,
    liked_at timestamp default current_timestamp() null,
    primary key (user_id, img_id),
    constraint userimagelikes_ibfk_1
        foreign key (img_id) references soholight.KidsImage (img_id),
    constraint userimagelikes_ibfk_2
        foreign key (user_id) references soholight.UserLogin (user_id)
);



