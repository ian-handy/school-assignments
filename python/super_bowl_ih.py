#This program something something football

super_bowls = [
[2024,"LVIII","Kansas City Chiefs","San Francisco 49ers","25-22","Paradise"],
[2023,"LVII","Kansas City Chiefs","Philadelphia Eagles","38-35","Glendale"],
[2022,"LVI","Los Angeles Rams","Cincinnati Bengals","23-20","Inglewood"],
[2021,"LV","Tampa Bay Buccaneers","Kansas City Chiefs","31-9","Tampa"],
[2020,"LIV","Kansas City Chiefs","San Francisco 49ers","31-20","Miami"],
[2019,"LIII","New England Patriots","Los Angeles Rams","13-3","Atlanta"],
[2018,"LII","Philadelphia Eagles","New England Patriots","41-33","Minneapolis"],
[2017,"LI","New England Patriots","Atlanta Falcons","34-28","Houston"],
[2016,"L","Denver Broncos","Carolina Panthers","24-10","Santa Clara"],
[2015,"XLIX","New England Patriots","Seattle Seahawks","28-24","Phoenix"],
[2014,"XLVIII","Seattle Seahawks","Denver Broncos","43-8","New Jersey"],
[2013,"XLVII","Baltimore Ravens","San Francisco 49ers","34-31","New Orleans"],
[2012,"XLVI","New York Giants","New England Patriots","21-17","Indianapolis"],
[2011,"XLV","Green Bay Packers","Pittsburgh Steelers","31-25","Arlington"],
[2010,"XLIV","New Orleans Saints","Indianapolis Colts","31-17","Miami"],
[2009,"XLIII","Pittsburgh Steelers","Arizona Cardinals","27-23","Tampa"],
[2008,"XLII","New York Giants","New England Patriots","17-14","Phoenix"],
[2007,"XLI","Indianapolis Colts","Chicago Bears", "29-17","Miami"],
[2006,"XL","Pittsburgh Steelers","Seattle Seahawks","21-10","Detroit"],
[2005,"XXXIX","New England Patriots","Philadelphia Eagles","24-21","Jacksonville"],
[2004,"XXXVIII","New England Patriots","Carolina Panthers","32-29","Houston"],
[2003,"XXXVII","Tampa Bay Buccaneers","Oakland Raiders","48-21 ","San Diego"],
[2002,"XXXVI","New England Patriots","St Louis Rams","20-17","New Orleans"],
[2001,"XXXV","Baltimore Ravens","New York Giants","34-7","Tampa"],
[2000,"XXXIV","St Louis Rams","Tennessee Titans","23-16","Atlanta"],
[1999,"XXXIII","Denver Broncos","Atlanta Falcons","34-19","Miami"],
[1998,"XXXII","Denver Broncos","Green Bay Packers","31-24","San Diego"],
[1997,"XXXI","Green Bay Packers","New England Patriots","35-21","New Orleans"],
[1996,"XXX","Dallas Cowboys","Pittsburgh Steelers","27-17","Tempe"],
[1995,"XXIX","San Francisco 49ers","San Diego Chargers","49-26","Miami"],
[1994,"XXVIII","Dallas Cowboys","Buffalo Bills","30-13","Atlanta"],
[1993,"XXVII","Dallas Cowboys","Buffalo Bills","52-17","Pasadena"],
[1992,"XXVI","Washington Redskins","Buffalo Bills","37-24","Minneapolis"],
[1991,"XXV","New York Giants","Buffalo Bills","20-19","Tampa"],
[1990,"XXIV","San Francisco 49ers","Denver Broncos","55-10","New Orleans"],
[1989,"XXIII","San Francisco 49ers","Cincinnati Bengals","20-16","Miami"],
[1988,"XXII","Washington Redskins","Denver Broncos","42-10","San Diego"],
[1987,"XXI","New York Giants","Denver Broncos","39-20","Pasadena"],
[1986,"XX","Chicago Bears","New England Patriots","46-10","New Orleans"],
[1985,"XIX","San Francisco 49ers","Miami Dolphins","38-16","Stanford"],
[1984,"XVIII","Los Angeles Raiders","Washington Redskins","38-9","Tampa"],
[1983,"XVII","Washington Redskins","Miami Dolphins", "27-17","Pasadena"],
[1982,"XVI","San Francisco 49ers","Cincinnati Bengals","26-21","Pontiac"],
[1981,"XV","Oakland Raiders","Philadelphia Eagles","27-10","New Orleans"],
[1980,"XIV","Pittsburgh Steelers","Los Angeles Rams","31-19", "Pasadena"],
[1979,"XIII","Pittsburgh Steelers","Dallas Cowboys","35-31","Miami"],
[1978,"XII","Dallas Cowboys","Denver Broncos","27-10","New Orleans"],
[1977,"XI","Oakland Raiders","Minnesota Vikings","32-14","Pasadena"],
[1976,"X","Pittsburgh Steelers","Dallas Cowboys","21-17","Miami"],
[1975,"IX","Pittsburgh Steelers","Minnesota Vikings","16-6","New Orleans"],
[1974,"VIII","Miami Dolphins","Minnesota Vikings","24-7","Houston"],
[1973,"VII","Miami Dolphins","Washington Redskins","14-7","Los Angeles"],
[1972,"VI","Dallas Cowboys","Miami Dolphins","24-3","New Orleans"],
[1971,"V","Baltimore Colts","Dallas Cowboys","16-13","Miami"],
[1970,"IV","Kansas City Chiefs","Minnesota Vikings","23-7","New Orleans"],
[1969,"III","New York Jets","Baltimore Colts","16-7","Miami"],
[1968,"II","Green Bay Packers","Oakland Raiders","33-14","Miami"],
[1967,"I","Green Bay Packers","Kansas City Chiefs","35-10","Los Angeles"]
]

teams = {game[2] for game in super_bowls}

def get_stats(team):
    games_played = 0
    games_won = 0
    for game in super_bowls:
        if team in game:
            games_played +=1
        if team == game[2]:
            games_won +=1
    games_lost = games_played - games_won
    win_percent = games_won / games_played *100
    print(f'Team: {team}\nGames Played: {games_played}\nGames Won: {games_won}\nGames Lost: {games_lost}\nPercentage Won: {round(win_percent,2)}%\n')

for team in teams:
    get_stats(team)