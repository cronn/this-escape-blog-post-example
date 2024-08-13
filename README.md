# Example Code for the Blog Post About Java’s `this-escape` Linter Warning

The project combines the listings used in this [blog post](https://blog.cronn.de/en/java/2024/08/13/this-escape.html) into one project. The code is not suitable for production and are used for illustrative purposes only.

The related code for the individual chapters can be found in the following packages:

| Chapter                                           | Package                            |
|---------------------------------------------------|------------------------------------|
| Using the keywords `final`, `private` or `static` | `de.cronn.escape.usefinal`         |
| Usage of the annotation `@PostConstruct`          | `de.cronn.escape.usepostconstruct` |
| Revise the class design                           | `de.cronn.escape.restructure`      |

To see the linter warning, the flawed code must be commented in the specific class (see comments  there). The Java Linter is configured in the `build.gralde.kts` in such a way that it verifies all rules.