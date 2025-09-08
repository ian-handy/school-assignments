import random

ec = {'Alabama': [9,'U'],
'Kentucky' : [8,'U'],
'North Dakota' : [3,'U'],
'Alaska' : [3,'U'],
'Louisiana' : [8,'U'],
'Ohio' : [18,'U'],
'Arizona' : [11,'U'],
'Maine' : [4,'U'],
'Oklahoma' : [7,'U'],
'Arkansas' : [6,'U'],
'Maryland' : [10,'U'],
'Oregon' : [7,'U'],
'California' : [55,'U'],
'Massachusetts' : [11,'U'],
'Pennsylvania' : [20,'U'],
'Colorado': [9,'U'],
'Michigan' : [16,'U'],
'Rhode Island' : [4,'U'],
'Connecticut' : [7,'U'],
'Minnesota' : [10,'U'],
'South Carolina' : [9,'U'],
'Delaware' : [3,'U'],
'Mississippi' : [6,'U'],
'South Dakota' : [3,'U'],
'District of Columbia' : [3,'U'],
'Missouri' : [10,'U'],
'Tennessee' : [11,'U'],
'Florida' : [29,'U'],
'Montana' : [3,'U'],
'Texas' : [38,'U'],
'Georgia' : [16,'U'],
'Nebraska' : [5,'U'],
'Utah' : [6,'U'],
'Hawaii' : [4,'U'],
'Nevada' : [6,'U'],
'Vermont' : [3,'U'],
'Idaho' : [4,'U'],
'New Hampshire' : [4,'U'],
'Virginia' : [13,'U'],
'Illinois' : [20,'U'],
'New Jersey' : [14,'U'],
'Washington' : [12,'U'],
'Indiana' : [11,'U'],
'New Mexico' : [5,'U'],
'West Virginia' : [5,'U'],
'Iowa' : [6,'U'],
'New York' : [29,'U'],
'Wisconsin' : [10,'U'],
'Kansas' : [6,'U'],
'North Carolina' : [15,'U'],
'Wyoming' : [3,'U'],
 }

candidates = ['Winston', 'Charlotte', 'Penny']

def hold_election():
    for key in ec.keys():
        candidate = candidates[random.randint(0,2)]
        ec[key][1] = candidate

election_won = False
election_winner = ''
elections_held = 0
while election_won == False:
    elections_held +=1
    hold_election()
    for candidate in candidates:
        total_votes = sum([value[0] for key,value in ec.items() if value[1] == candidate])
        if total_votes >= 270:
            election_won = True
            election_winner = candidate
print(f'\nNumber of elections held: {elections_held}\n')
print(f'Final Tally:')
for candidate in candidates:
    print(f'{candidate}: {sum([value[0] for _,value in ec.items() if value[1] == candidate])}')
print(f'\nThe winner of the election is {election_winner}')
for candidate in candidates:
    states_won = [state for state,value in ec.items() if value[1] == candidate]
    print(f'States won by {candidate}: \n\n{states_won}\n')


        


