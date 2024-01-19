# Semester Project: Java Programming


*<font color =  "lightblue">
Sidenote: Things for Future Improvements*
- *Constellation naming logic: the program has to iterate through the Greek alphabet letters anew everytime a new constellation is introduced.*
</font>

## Class: Star

The `Star` class has the following fields:

- **Name:** Any designation for the star. Assumes the name consists of 3 capital letters and 4 digits.

- **Catalog Name:** The catalog name consists of a Greek alphabet letter and the name of the constellation. The brightest star is alpha, the next beta, and so on. Consecutive Greek letters are assigned in the order they were added to the constellation.

- **Declination:** Astronomical coordinate ranging from 0 to 90 degrees for stars in the northern hemisphere and from 0 to -90 degrees for stars in the southern hemisphere. Value given as xx degrees yy minutes zz.zz seconds.

- **Right Ascension:** Second astronomical coordinate ranging from 00h to 24h. Value given as xx h yy m zz s.

- **Observed Stellar Magnitude:** Magnitude used to determine brightness expressed in magnitudes. Lower value indicates greater brightness. Minimum allowable magnitude is -26.74 (value for the Sun). Maximum magnitude is 15.00.

- **Absolute Stellar Magnitude:** Magnitude value from a specified distance. M = m − 5· log10r + 5 (logarithm to base 10 of r). Assumes 1 parsec = 3.26 light-years.

- **Constellation:** The constellation in which a given star can be seen.

- **Hemisphere N/S:** The hemisphere in which a given star can be seen.

- **Temperature:** Given in degrees Celsius. Minimum temperature is 2000 degrees; no upper limit.

- **Mass:** Given in relation to the mass of the Sun. Minimum mass is 0.1 solar masses, and the maximum allowable mass is 50.

### Adding a New Star
When adding a new object, consider all parameters, their ranges, and dependencies between them.

### Additional Operations
- Display all stars in the database.
- Remove an object with a selected catalog name. Update remaining catalog names when removing a star.

### Searching in the Database
Search for objects based on the following criteria:
- Stars in a specific constellation.
- Stars at a distance of x parsecs from Earth (considering the object is described in light-years).
- Stars with temperature in a specified range.
- Stars with stellar magnitude in a specified range.
- Stars in the northern/southern hemisphere.
- Potential supernovae (mass exceeding the Chandrasekhar limit of 1.44 solar masses).

### Data Storage
All data is saved in an object file.

### Implementation
Individual project elements are realized as functions or methods of the class.


