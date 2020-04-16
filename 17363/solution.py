replace = lambda c: {
    "-": "|",
    "|": "-",
    "/": "\\",
    "\\": "/",
    "^": "<",
    "<": "v",
    "v": ">",
    ">": "^",
}.get(c, c)
[
    print(x)
    for x in reversed(
        [
            *map(
                lambda *a: "".join(a),
                *eval("map(replace, input())," * int(input().split()[0])),
            )
        ]
    )
]
