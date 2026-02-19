#This program will determine your risk level for a loan based on the given amount to borrow, income, credit score, and existing debts.

def loan_risk():
    print("This program will determine your risk level for a loan based on the given amount to borrow, income, credit score, and existing debts.")
    borrow= float(input("Please enter the amount you would like to borrow: "))
    income= float(input("Please enter your annual income: "))
    score= float(input("Please enter your credit score: "))
    debt= float(input("Please enter the total amount of your existing debts: "))
    risk_level = ''
    if income>75000 and score>750 and debt/income<.2:
        risk_level = 'low'
    elif income>50000 and score>650 and debt/income<.35:
        risk_level = 'medium'
    else:
        risk_level = 'high'
    return f'Your risk level is {risk_level}'
print(loan_risk())