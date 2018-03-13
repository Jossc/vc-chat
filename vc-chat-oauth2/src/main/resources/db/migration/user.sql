-- oauth用户
INSERT INTO `vc_chat`.`authorities` (`id`, `username`, `authority`) VALUES ('1', 'admin', 'ROLE_ADMIN,ROLE_USER');
-- 账户 admin 密码 admin
INSERT INTO `vc_chat`.`users` (`id`, `username`, `password`, `nick_name`, `image`, `enabled`) VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', NULL, '1');
INSERT INTO `vc_chat`.`oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`, `web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`) VALUES ('acme', '', 'acmesecret', 'openid', 'authorization_code,refresh_token,password,implicit,client_credentials', NULL, 'ROLE_ADMIN,ROLE_USER', NULL, NULL, '{\"loginType\":\"shijue\",\"company\":\"500px\"}', '1');
