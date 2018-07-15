# hibernate-enum-map-index

This is just some code to play around with how `enums` behave when used with the Hibernate JPA implementation, especially when used as an index on a `Map`.

The tests are hackneyed and the build pom is over engineered.

This branch shows the `enums` being mapped using the standard JPA annotations `@Enumerated` and `@MapKeyEnumerated`.
