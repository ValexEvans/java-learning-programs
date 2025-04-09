## HW4 Origninal 

### **Issues & Fixes:**

1. **Potential Array Index Out of Bounds**
   - You're storing books in an array (`bookstoreBooks` and `libraryBooks`) with a fixed size (100 and 200 respectively).
   - If the count exceeds this limit, it will throw an `ArrayIndexOutOfBoundsException`.
   - **Fix:** Use an `ArrayList<BookstoreBook>` and `ArrayList<LibraryBook>` instead of arrays.

2. **Logic in `choice.equals("no")` condition**
   - Inside the `while (!choice.equalsIgnoreCase("yes"))` loop, if the user enters `"no"`, the outer loop still continues because `choice.equals("no")` only breaks the inner loop.
   - **Fix:** Add a `break` after detecting `"no"` in the outer loop.

3. **Spacing Issue in Error Message**
   ```java
   System.out.println("My apologies, " + choice + "is not an answer that I can accept.");
   ```
   - **Fix:** Add a space after `choice`: 
     ```java
     System.out.println("My apologies, " + choice + " is not an answer that I can accept.");
     ```

4. **Incorrect Handling of `Scanner.nextDouble()`**
   - When you use `nextDouble()`, it does not consume the newline character.
   - After calling `nextDouble()`, you need to consume the newline using `myScan.nextLine()` before calling `nextLine()` again.
   - **Fix:** Already handled correctly in some places but double-check after every `nextDouble()`.

5. **Potential `ArrayIndexOutOfBoundsException` in `bookInfoArray`**
   ```java
   String author = bookInfoArray[0];
   String title = bookInfoArray[1];
   String isbn = bookInfoArray[2];
   ```
   - If the user doesn't input enough values, this will throw an error.
   - **Fix:** Validate input length before accessing elements:
     ```java
     if (bookInfoArray.length < 3) {
         System.out.println("Invalid input format. Please enter author/title/isbn separated by '/'.");
         continue;
     }
     ```

6. **String Comparison: Use `.equalsIgnoreCase()` Consistently**
   - You're sometimes using `.equals()` and sometimes `.equalsIgnoreCase()`. Be consistent to avoid case sensitivity issues.

7. **`amntOfBooks` Naming**
   - The variable `amntOfBooks` in `LibraryBook` should be `amountOfBooks` or `numOfBooks` for clarity.

8. **Calling `System.exit(0);`**
   - `System.exit(0);` is not needed unless you have a specific reason to force the program to terminate. The program will exit naturally after `main` finishes execution.

### **Recommended Improvements:**
- Replace arrays with `ArrayList<BookstoreBook>` and `ArrayList<LibraryBook>`.
- Improve user input validation for robustness.
- Use consistent naming conventions and spacing.

## HW4 Improved 

### **Improvements & Fixes:**
1. **Replaced arrays with `ArrayList`** → No more `ArrayIndexOutOfBoundsException`.
2. **Added input validation** → Ensures correct input format before processing.
3. **Fixed scanner issues** → Prevents `nextDouble()` from skipping subsequent `nextLine()`.
4. **Used `.trim()` and `.toLowerCase()` consistently** → Prevents case sensitivity and input formatting issues.
5. **Improved error handling for missing book info** → Ensures user provides `author/title/isbn`.
6. **Formatted output for better readability** → Cleaner, more user-friendly interaction.

Now your program runs smoothly without unexpected crashes. 🚀