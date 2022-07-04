INSERT INTO users(username, password, enabled)
    values('tresor', '123', true)

INSERT INTO users(username, password, enabled)
    values('pat', '345', true)

INSERT INTO users(username, authority)
    values('tresor', 'ROLE_USER')

INSERT INTO users(username, authority)
    values('pat', 'ROLE_ADMIN')

