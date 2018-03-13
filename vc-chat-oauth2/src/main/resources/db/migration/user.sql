
-- oauth用户
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('1', 'admin', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('2', 'admin2', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('3', 'admin3', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('4', 'admin4', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('5', 'admin5', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('6', 'admin6', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('7', 'admin7', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('8', 'admin8', 'ROLE_ADMIN,ROLE_USER');
-- 账户 admin 密码 123456
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '/webjars/adminlte/2.3.6/dist/img/user1-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('2', 'admin2', 'e10adc3949ba59abbe56e057f20f883e', 'admin2', '/webjars/adminlte/2.3.6/dist/img/user2-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('3', 'admin3', 'e10adc3949ba59abbe56e057f20f883e', 'admin3', '/webjars/adminlte/2.3.6/dist/img/user3-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('4', 'admin4', 'e10adc3949ba59abbe56e057f20f883e', 'admin4', '/webjars/adminlte/2.3.6/dist/img/user4-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('5', 'admin5', 'e10adc3949ba59abbe56e057f20f883e', 'admin5', '/webjars/adminlte/2.3.6/dist/img/user5-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('6', 'admin6', 'e10adc3949ba59abbe56e057f20f883e', 'admin6', '/webjars/adminlte/2.3.6/dist/img/user6-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('7', 'admin7', 'e10adc3949ba59abbe56e057f20f883e', 'admin7', '/webjars/adminlte/2.3.6/dist/img/user7-128x128.jpg', '1');
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nickname`, `avatar`, `enabled`) VALUES ('8', 'admin8', 'e10adc3949ba59abbe56e057f20f883e', 'admin8', '/webjars/adminlte/2.3.6/dist/img/user8-128x128.jpg', '1');
INSERT INTO `vc_chat`.`oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('acme', '', 'acmesecret', 'openid', 'authorization_code,refresh_token,password,implicit,client_credentials', NULL, 'ROLE_ADMIN,ROLE_USER', NULL, NULL, '{\"loginType\":\"shijue\",\"company\":\"500px\"}', '1');
