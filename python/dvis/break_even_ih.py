#Break Even Assignment

def break_even():
    print("This program will calculate your break even point for a given Total Fixed Costs, Sales Price per Unit, and Variable Cost per Unit.")
    fixed_costs = float(input("Please enter the Total Fixed Costs: "))
    sales_price = float(input("Please enter the Sales Price Per Unit: "))
    variable_cost = float(input("Please enter the Variable Cost Per Unit: "))
    bep_units = fixed_costs / (sales_price - variable_cost)
    margin_per_unit = sales_price - variable_cost
    margin_per_unit_ratio = margin_per_unit / sales_price
    sales_dollars = fixed_costs / margin_per_unit_ratio
    print(f'BEP Units: {bep_units}\nContribution Margin Per Unit: {margin_per_unit}\nContribution Margin Ratio Per Unit: {margin_per_unit_ratio}\nBEP Sales Dollars: {sales_dollars}')
break_even()