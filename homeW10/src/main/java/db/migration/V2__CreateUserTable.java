package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class V2__CreateUserTable extends BaseJavaMigration {
    @Override
    public void migrate(Context context) throws Exception {
        new JdbcTemplate(new SingleConnectionDataSource(context.getConnection(), true))
                .execute("create table users\n" +
                        "(\n" +
                        "    id        serial primary key,\n" +
                        "    username  varchar not null unique,\n" +
                        "    password  varchar not null,\n" +
                        "    firstname varchar not null,\n" +
                        "    lastname  varchar not null,\n" +
                        "    role_id   int,\n" +
                        "    foreign key (role_id) references roles (id)\n" +
                        ")");
    }

}