package org.cassandrabase.cassandrabasedemo;

import com.datastax.oss.driver.api.core.CqlSession;
import lombok.RequiredArgsConstructor;
import org.cassandrabase.lite.Cassandrabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class CassandrabaseDemoApplication implements CommandLineRunner {
    private final CqlSession cqlSession;

    public static void main(String[] args) {
        SpringApplication.run(CassandrabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try (Cassandrabase cassandrabase = new Cassandrabase(cqlSession, UUID.randomUUID().toString(), this)) {
            cassandrabase.validate();
        }
    }
}
