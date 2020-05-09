import re
from fractions import Fraction

lv = lambda x: 10 ** len(str(x)) if x != "0" else 1
lvten = lambda x: 10 ** len(str(x))

result = re.match(
    r"^(?P<int>\d+)(?:\.(?P<just>\d+)?(?:\((?P<rep>\d+)\))?)?$", input()
).groupdict()
integral = result["int"]
just = result["just"] or ""
rep = result["rep"] or ""

numerator = (
    int(integral + just + rep) - int(integral + just) if rep else int(integral + just)
)
denominator = int(("9" * len(rep) + "0" * len(just)) or "1") or int(
    "1" + "0" * len(just)
)

frac = Fraction(numerator, denominator)
print(f"{frac.numerator}/{frac.denominator}")
