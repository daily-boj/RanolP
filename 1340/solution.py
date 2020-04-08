import re

regex = re.compile("""([a-zA-Z]+) ([0-9]+), ([0-9]+) ([0-9]+):([0-9]+)""")
month_number = {
    'January': 1,
    'February': 2,
    'March': 3,
    'April': 4,
    'May': 5,
    'June': 6,
    'July': 7,
    'August': 8,
    'September': 9,
    'October': 10,
    'November': 11,
    'December': 12,
}

result = re.match(regex, input())
month = result.group(1)
day, year, hour, minute = map(lambda i: int(result.group(i)), range(2, 6))
is_leap_year = year % 400 == 0 or (year % 100 != 0 and year % 4 == 0)
whole_year_days = 366 if is_leap_year else 365
days = [
    31,
    29 if is_leap_year else 28,
    31,
    30,
    31,
    30,
    31,
    31,
    30,
    31,
    30,
    31,
]
days_passed = 0
for i in range(month_number[month] - 1):
    days_passed += days[i]
days_passed += day

print((days_passed + hour / 24 + minute / 24 / 60 - 1) / whole_year_days * 100)