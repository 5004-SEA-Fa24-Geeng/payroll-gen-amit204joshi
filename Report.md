# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for?

    Comma-Separated Values

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

    This allows to switch implementations, from ArrayList to LinkedList, later without breaking dependent code.
    Also, it accepts any class implementing IEmployee enabling polymorphism, both SalaryEmployee and HourlyEmployee can be stored in this list.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

   This is a "has-a" relationship.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

    PayrollGenerator class has Employee objects and TimeCard objects.

5. Can you provide an example of an is-a relationship in your code (if one exists)?

    HourlyEmployee and SalaryEmployee are the subclasses of Employee class, which are is-a relationships.

6. What is the difference between an interface and an abstract class?

    An interface defines a contract with abstract methods and allows multiple inheritance, 
    while an abstract class can provide partial method implementations, instance variables, and constructors but restricts subclasses to single inheritance.

7. What is the advantage of using an interface over an abstract class?

    Interfaces enable greater flexibility by supporting multiple inheritance, allowing classes to adopt unrelated behaviors across hierarchies. 
    It is unlike abstract classes, which lock subclasses into a single inheritance hierarchy.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

    It is invalid. Java generics do not support primitive types like int as type parameters. Generics require reference types (objects), and int is a primitive type, not an object.
    Use the wrapper class Integer instead of int: List<Integer> numbers = new ArrayList<>() could fix this issue.

9. Which class/method is described as the "driver" for your application? 

    PayrollGenerator is the driver, because it has the main function, which is the entrance for the whole program.

10. How do you create a temporary folder for JUnit Testing? 

    Use the @TempDir annotation to auto-create and clean up a temporary directory:<br>
    @TempDir<br>
    Path tempDir;


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

I need to add Demographic information (e.g., gender, race, age) and Years of experience as the properties into Employee class. By hiding them and using Control variable method, I could analyze the gross income gaps between different groups of people to determine if there exists discrimination between them.

Specifically, at the hiring Stage, I could flag disparities during offer letter generation by comparing proposed salaries to equitable benchmarks. Also, conducting annual reviews regularly could audit salary adjustments for consistency across demographics, by controlling for legitimate factors like performance.

Resources:

[1]: What’s Behind the Pay Gap in STEM Jobs? https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs. Accessed: 2025-02-09.

[2]: STEM Jobs See Uneven Progress in Increasing Gender, Racial and Ethnic Diversity https://www.pewresearch.org/social-trends/2021/04/01/stem-jobs-see-uneven-progress-in-increasing-gender-racial-and-ethnic-diversity/. Accessed: 2025-02-09. 