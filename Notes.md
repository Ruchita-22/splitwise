Start with model which do not depend on other
group expense - expense
group - user

Main entity - User, Expense, Group, UserExpense

Mapping
first L->R
second R->L

    User Expense
    1:M       
    M:1   

    User Group
    1:M
    M:1

    Group Expense
    1:M
    1:1
    
    User UserExpense 
    1:M
    1:1

    Expense UserExpense
    1:M
    1:1
Bydefault mapping table is created for @OneToMany, @ManyToMany(uni -1, bi-2)

private HashMap<User, Double>  paidByUsers;
private HashMap<User, Double>  hasToPayUsers;
These things cant store in  mysql db

maintaining two list in db is not optimise as two mapping


    Expense - 
    {
        "description": "Dinner",
        "amount": 1000,
        "group": 1,
        "currency": "INR",
        "userExpenses": [
            {
                "name" : "Rituraj",
                "amount" : 500,
                "userExpenseType" : "paid"
            },
            {
                "name" : "Omkar",
                "amount" : 500,
                "userExpenseType" : "paid"
            },
            {
                "name" : "A",
                "amount" : 250,
                "userExpenseType" : "hasToPay"
            
            } 
        ]
    }



For each modal table you should have repository


**Settle Up Algo**

    1. Go through all the expenses and find the outstanding amount for each user
            a. Loop through each expense, and for each expense
            b. We will loop through all the userExpense
            If userExpense type is PAID, it will be added as +ve
            If userExpense type is HASTOPAY, it will be subtracted as -ve
            from each user
       2. All the users with negative balance [hasToPay] => minHeap
       3. All the users with positive balance [paid] => maxHeap
       4. We will find the transactions



       {A:-200, B:-100} - minHeap
       {C:150, D:150} - maxHeap

       A => -200
       C => 150

       A will transfer to C -> 150

       C + A => 150 - 200 =>  -50 -> minHeap


       B => -100
       D => 150

       D + B => 150 - 100 =>  50 -> maxHeap


       OP : 0 -> nothing will go back || settled
