from fractions import Fraction

numerator_a, denominator_a = map(int, input().split())
numerator_b, denominator_b = map(int, input().split())

numerator_result, denominator_result = Fraction(
    numerator=numerator_a * denominator_b + numerator_b * denominator_a,
    denominator=denominator_a * denominator_b,
    _normalize=True
).as_integer_ratio()

print(numerator_result, denominator_result)