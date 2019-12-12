
    create table `administrator` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `announcement` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `more_info` varchar(255),
        `text` varchar(1024),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `anonymous` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `application` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `qualifications` varchar(1024),
        `reference` varchar(255),
        `skills` varchar(1024),
        `statements` varchar(1024),
        `status` varchar(255),
        `job_id` integer not null,
        `worker_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `firm` varchar(255),
        `responsibility_statement` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `auditor_record` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(1024),
        `moment` datetime(6),
        `status` bit,
        `title` varchar(255),
        `auditor_id` integer not null,
        `job_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `authenticated` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `challenge` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(1024),
        `goal_bronze` varchar(255),
        `goal_gold` varchar(255),
        `goal_silver` varchar(255),
        `reward_bronze` varchar(255),
        `reward_gold` varchar(255),
        `reward_silver` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `card` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `consumer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `customization_parameters` (
       `id` integer not null,
        `version` integer not null,
        `spam_threshold` double precision,
        primary key (`id`)
    ) engine=InnoDB;

    create table `customization_parameters_spam_words` (
       `customization_parameters_id` integer not null,
        `spam_words` varchar(255)
    ) engine=InnoDB;

    create table `descriptor` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(1024),
        primary key (`id`)
    ) engine=InnoDB;

    create table `descriptor_duty` (
       `descriptor_id` integer not null,
        `dutys_id` integer not null
    ) engine=InnoDB;

    create table `duty` (
       `id` integer not null,
        `version` integer not null,
        `description` varchar(1024),
        `percentaje` double precision,
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `employer` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `investor_record` (
       `id` integer not null,
        `version` integer not null,
        `investing_statement` double precision,
        `name` varchar(255),
        `sector` varchar(255),
        `stars` double precision,
        primary key (`id`)
    ) engine=InnoDB;

    create table `job` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `more_info` varchar(255),
        `reference` varchar(255),
        `salary_amount` double precision,
        `salary_currency` varchar(255),
        `status` bit,
        `title` varchar(255),
        `descriptor_id` integer,
        `employer_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `justification` (
       `id` integer not null,
        `version` integer not null,
        `reason` varchar(1024),
        `application_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message` (
       `id` integer not null,
        `version` integer not null,
        `body` varchar(255),
        `moment` datetime(6),
        `title` varchar(255),
        `user_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread` (
       `id` integer not null,
        `version` integer not null,
        `moment` datetime(6),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `message_thread_message` (
       `message_thread_id` integer not null,
        `messages_id` integer not null
    ) engine=InnoDB;

    create table `message_tags` (
       `message_id` integer not null,
        `tags` varchar(255)
    ) engine=InnoDB;

    create table `non_commercial_banner` (
       `id` integer not null,
        `version` integer not null,
        `jingle` varchar(255),
        `picture` varchar(255),
        `slogan` varchar(255),
        `url` varchar(255),
        `sponsor_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `offer` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `text` varchar(1024),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `provider` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `company` varchar(255),
        `sector` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `records` (
       `id` integer not null,
        `version` integer not null,
        `ceo` varchar(255),
        `description` varchar(1024),
        `incorporated` bit,
        `mail` varchar(255),
        `name` varchar(255),
        `phone` varchar(255),
        `sector` varchar(255),
        `stars` double precision,
        `website` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request` (
       `id` integer not null,
        `version` integer not null,
        `deadline` datetime(6),
        `description` varchar(255),
        `moment` datetime(6),
        `reward_amount` double precision,
        `reward_currency` varchar(255),
        `ticker` varchar(255),
        `title` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `request_auditor` (
       `id` integer not null,
        `version` integer not null,
        `firm` varchar(255),
        `responsibility_statement` varchar(255),
        `user_id` integer,
        primary key (`id`)
    ) engine=InnoDB;

    create table `sponsor` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `credit_card` varchar(255),
        `name` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_account` (
       `id` integer not null,
        `version` integer not null,
        `enabled` bit not null,
        `identity_email` varchar(255),
        `identity_name` varchar(255),
        `identity_surname` varchar(255),
        `password` varchar(255),
        `username` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `user_involved` (
       `id` integer not null,
        `version` integer not null,
        `message_thread_id` integer not null,
        `user_id` integer not null,
        primary key (`id`)
    ) engine=InnoDB;

    create table `worker` (
       `id` integer not null,
        `version` integer not null,
        `user_account_id` integer,
        `qualifications_record` varchar(255),
        `skills_record` varchar(255),
        primary key (`id`)
    ) engine=InnoDB;

    create table `hibernate_sequence` (
       `next_val` bigint
    ) engine=InnoDB;

    insert into `hibernate_sequence` values ( 1 );
create index IDXg54pxa1gngqheaipukeg8jypk on `application` (`moment`);
create index IDX2q2747fhp099wkn3j2yt05fhs on `application` (`status`);
create index IDX5wwxv107kvi5si12nh4226lnx on `application` (`moment`, `status`);

    alter table `application` 
       add constraint UK_ct7r18vvxl5g4c4k7aefpa4do unique (`reference`);

    alter table `descriptor_duty` 
       add constraint UK_gicb7at1idsamnu3xgj4i91vc unique (`dutys_id`);
create index IDXfdmpnr8o4phmk81sqsano16r on `job` (`deadline`);
create index IDX28ur9xm72oo1df9g14xhnh8h3 on `job` (`status`);
create index IDXal59yunywnkwi09ps7jxpr18c on `job` (`deadline`, `status`);

    alter table `job` 
       add constraint UK_7jmfdvs0b0jx7i33qxgv22h7b unique (`reference`);

    alter table `justification` 
       add constraint UK_2ctploatlatw5btxcjwembifo unique (`application_id`);

    alter table `message_thread_message` 
       add constraint UK_bx8ll7j8be93gcj4mnbmvm2rk unique (`messages_id`);

    alter table `offer` 
       add constraint UK_iex7e8fs0fh89yxpcnm1orjkm unique (`ticker`);

    alter table `request` 
       add constraint UK_9mxq3powq8tqctclj0fbi2nih unique (`ticker`);

    alter table `user_account` 
       add constraint UK_castjbvpeeus0r8lbpehiu0e4 unique (`username`);

    alter table `administrator` 
       add constraint FK_2a5vcjo3stlfcwadosjfq49l1 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `anonymous` 
       add constraint FK_6lnbc6fo3om54vugoh8icg78m 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `application` 
       add constraint `FKoa6p4s2oyy7tf80xwc4r04vh6` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `application` 
       add constraint `FKmbjdoxi3o93agxosoate4sxbt` 
       foreign key (`worker_id`) 
       references `worker` (`id`);

    alter table `auditor` 
       add constraint FK_clqcq9lyspxdxcp6o4f3vkelj 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `auditor_record` 
       add constraint `FKjx5w0xtdjllmdj2el2rlx4wdj` 
       foreign key (`auditor_id`) 
       references `auditor` (`id`);

    alter table `auditor_record` 
       add constraint `FKcpwoo69w5dhtr8nvg0xhl9qv9` 
       foreign key (`job_id`) 
       references `job` (`id`);

    alter table `authenticated` 
       add constraint FK_h52w0f3wjoi68b63wv9vwon57 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `commercial_banner` 
       add constraint `FKd0k52g7lcacefcp62kb4p9aor` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `consumer` 
       add constraint FK_6cyha9f1wpj0dpbxrrjddrqed 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `customization_parameters_spam_words` 
       add constraint `FKhcqquyqtys40tece78apjsbyt` 
       foreign key (`customization_parameters_id`) 
       references `customization_parameters` (`id`);

    alter table `descriptor_duty` 
       add constraint `FKkm3m3388tiixfsn63295m8n13` 
       foreign key (`dutys_id`) 
       references `duty` (`id`);

    alter table `descriptor_duty` 
       add constraint `FKqitedkrksd2w8qyp1fp5eao9f` 
       foreign key (`descriptor_id`) 
       references `descriptor` (`id`);

    alter table `employer` 
       add constraint FK_na4dfobmeuxkwf6p75abmb2tr 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `job` 
       add constraint `FKfqwyynnbcsq0htxho3vchpd2u` 
       foreign key (`descriptor_id`) 
       references `descriptor` (`id`);

    alter table `job` 
       add constraint `FK3rxjf8uh6fh2u990pe8i2at0e` 
       foreign key (`employer_id`) 
       references `employer` (`id`);

    alter table `justification` 
       add constraint `FK8ma9xucf9mh9736jhtdumt8x3` 
       foreign key (`application_id`) 
       references `application` (`id`);

    alter table `message` 
       add constraint `FKik4epe9dp5q6uenarfyia7xin` 
       foreign key (`user_id`) 
       references `authenticated` (`id`);

    alter table `message_thread_message` 
       add constraint `FKka0a2jm3m6obl7wa6586cqyp4` 
       foreign key (`messages_id`) 
       references `message` (`id`);

    alter table `message_thread_message` 
       add constraint `FKp1bkunf5gyu1vtt1q3f2djagy` 
       foreign key (`message_thread_id`) 
       references `message_thread` (`id`);

    alter table `message_tags` 
       add constraint `FKk6j00y1eiyu6qe5gad8rvefed` 
       foreign key (`message_id`) 
       references `message` (`id`);

    alter table `non_commercial_banner` 
       add constraint `FKpcpr0xb5k7s4rxv5pulstt5v9` 
       foreign key (`sponsor_id`) 
       references `sponsor` (`id`);

    alter table `provider` 
       add constraint FK_b1gwnjqm6ggy9yuiqm0o4rlmd 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `request_auditor` 
       add constraint `FKg9gmiivm111rnb6yd8eq82kbk` 
       foreign key (`user_id`) 
       references `user_account` (`id`);

    alter table `sponsor` 
       add constraint FK_20xk0ev32hlg96kqynl6laie2 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);

    alter table `user_involved` 
       add constraint `FKevpise8r0ofnf4xpw18mkgesw` 
       foreign key (`message_thread_id`) 
       references `message_thread` (`id`);

    alter table `user_involved` 
       add constraint `FKn5kf90daeyb1rcq0soeax5tx3` 
       foreign key (`user_id`) 
       references `authenticated` (`id`);

    alter table `worker` 
       add constraint FK_l5q1f33vs2drypmbdhpdgwfv3 
       foreign key (`user_account_id`) 
       references `user_account` (`id`);
