# Project 4
This assignment is a mock banking system, based off of my Project 3 (which can be found in my CS121 portfolio repo). The main differences are that some of the data structures are changed, and I added inheritance into the project.

The data structure that was changed was the account list in the customer class. It was changed from a ArrayList to a LinkedList.

Instead of having a generic Account class, I added to classes named SavingsAccount and CheckingAccount that extend the Account class. Their behaviors differ when withdrawing and depositing, like they would in a real scenario (not exactly how they would). The user can choose which account type they want when opening an account in the program.

What I found interesting about this project is that even though you might have two different extended classes, you can still add them to an array that is directed to have items of the base class. In this case, if the behavior that I added to the extended classes was to be called, I wouldn't be able to call it due to type erasure. Cool!