Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
For **House.java**:
    1. I decided to 'overload' the constructor so that without elevator information, it defaults to no elevator;
    2. I decided to 'overload' the moveIn method so that it accepts a student's name instead of a Student object. This doesn't make too much of a difference, just another way of achieving the same thing;
    3. I decided to 'overload' the moveOut method so that it accepts a student's name instead of a Student object. Same as 2;
    4. In order to make the two overload methods in 2 and 3 run without errors, I also overload the constructor of Student so that it can accepts only a name.
For **Library.java**:
    1. I decided to 'overload' the constructor so that without elevator information, it defaults to no elevator(most libraries have elevators but let's just prepare for the worst);
    2. I decided to 'overload' the addTitle method so that we can add multiple titles as once. This is because it makes adding much easier if we are trying add a lot of books;
    3. I decided to 'overload' the removeTitle method so that we can remove multiple titles as once. Same as 2.
For **Cafe.java**:
    1. I decided to 'overload' the constructor and set the default to 1 floor.
    2. I decided to 'overload' the sellCoffee method ad set for default coffee formula. This is because it makes easier if customers just want a regular cup of coffee and we don't need to write out the ingredients again.
- What worked, what didn't, what advice would you give someone taking this course in the future?
I forgot the difference between 'override' and 'overload' easily. So I decided to write the definitions here again to remind myself.
**Override**：modify or replace an inherited method
**Overload**: define muliple versions of the same method to accommodate different type/number of parameters
I would suggest people to keep a notebook and writes down similar definitions that might confuse you so that you can refer to whenever unsure.