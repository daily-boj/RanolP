n, m = map(int, input().split())
knowns = sum([2 ** int(i) for i in input().split()][1:])
parties_can_lie = eval("sum([2 ** int(i) for i in input().split()][1:])," * m)


def exclude_knowns(parties, knowns):
    ok_parties = []
    update = False
    for party_people in parties:
        if party_people & knowns:
            knowns |= party_people
            update = True
        else:
            ok_parties.append(party_people)
    if update:
        return exclude_knowns(ok_parties, knowns)
    else:
        return ok_parties


print(len(exclude_knowns(parties_can_lie, knowns)))
