You've demonstrated a solid understanding of object-oriented programming concepts and created a functional locker management system. The code is well-structured with good separation of concerns across different classes. 

**OVERALL: PASSED**

Minor Tweaks:

* **Spacing / Formatting**: Java devs are pretty strict about spacing and formatting, look for things like this:

  ```java
  // Current:
  for (int i =1; i < lockers.length; i++) {  // Missing space before =1
  // Better:
  for (int i = 1; i < lockers.length; i++) {
  ```

* **Array Size Manipulation**: I see you added 1 to the capacity instead of using it to offset the index when displaying information. This works, but it would confuse other developers because now all your for loops have to start from index 1.

  ```java
  // In LockerService constructor:
  lockers = new Locker[numberOfLockers + 1];
  ```

* **Menu Service**: The `menuLoop()` method is doing a lot of different things. This would be a place I'd target breaking into submethods. I do really like that you changed the menu based on availability.



