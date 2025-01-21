package com.example.jobrunr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 */
@SpringBootApplication
public class SpringJobrRunrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJobrRunrApplication.class, args);
    }

    // Alternative schedulers and storage providers.
//    @Bean(name = "in-memory-storage")
//    public StorageProvider inMemoryStorageProvider(JobMapper jobMapper) {
//        InMemoryStorageProvider storageProvider = new InMemoryStorageProvider();
//        storageProvider.setJobMapper(new JobMapper(new JacksonJsonMapper()));
//        return storageProvider;
//    }
//    @Bean(name = "custom-in-memory-scheduler")
//    public JobScheduler inMemory(JobActivator jobActivator, @Qualifier("in-memory-storage") StorageProvider storageProvider) {
//        return JobRunr.configure()
//                .useJobActivator(jobActivator)
//                .useStorageProvider(storageProvider)
//                .useBackgroundJobServer()
//                .initialize()
//                .getJobScheduler();
//    }
//    @Bean(name = "sql-storage-provider")
//    public StorageProvider sqlStorageProvider(JobMapper jobMapper, DataSource source) {
//        StorageProvider storageProvider = SqlStorageProviderFactory.using(source);
//        storageProvider.setJobMapper(jobMapper);
//        return storageProvider;
//    }
//    @Bean(name = "custom-sql-scheduler")
//    public JobScheduler custom(JobActivator jobActivator, @Qualifier("sql-storage-provider") StorageProvider storageProvider) {
//        return JobRunr.configure()
//                .useJobActivator(jobActivator)
//                .useStorageProvider(storageProvider)
//                .useBackgroundJobServer()
//                .initialize()
//                .getJobScheduler();
//    }
}
