# hibernate-enum-map-index

This is just some code to play around with how `enums` behave when used with the Hibernate JPA implementation, especially when used as an index on a `Map`.

The tests are hackneyed and the build pom is over engineered.

This branch shows the `enums` being mapped using Hibernate specific custom types (BasicType) and the @Type annotation. This removes the dependency on the enum ordinal and allows new enum entries to be added without breaking the tests.
