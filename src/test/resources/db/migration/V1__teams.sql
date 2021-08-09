CREATE TABLE `teams`
(
    `id`   BIGINT(20) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
    PRIMARY KEY (`id`) USING BTREE
) COLLATE='utf8_general_ci'
;
