# NHS BSA Assignment 1

**TO BUILD AND RUN TESTS**

`mvn clean package`

**ISSUES**

 - One recorded in the Issues section of the repo

**KEY KNOWLEDGE**

 - JSR-303 annotations
 - ConstraintValidator -- Extend Hibernate Validator (ref impl)

   See https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/ 
   for docs on using Constraint Validators and writing annotations. 

**DONE**

Set up IntelliJ with maven

Set up GitHub Project

Create and checkout 0.1-devel branch

Develop
 - Play
 - Design
 - Write Tests
 - Code
 - Run Tests
 - Iterate
 - Increment
 
Merge 0.1-devel into master
    
Release

**POINTS TO THINK ABOUT**
  
  Constraints
   - if frequency is multiple of week, amount must be divisible to weekly amount that is whole pence
   - assumption - the form data will consist of amount and frequency
   
**TODO IN FUTURE INCREMENTS**

 - More tests
 - More javadocs
 - More documentation
