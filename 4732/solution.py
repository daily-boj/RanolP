note_sequence = ["A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"]
same_note = {
    "B#": "C",
    "E#": "F",
    "Bb": "A#",
    "Db": "C#",
    "Eb": "D#",
    "Gb": "F#",
    "Ab": "G#",
}

while 1:
    note_list = input().split()
    if note_list[0] == "***":
        break
    move = int(input())
    result = [
        note_sequence[
            (note_sequence.index(same_note.get(note, note)) + move) % len(note_sequence)
        ]
        for note in note_list
    ]
    print(" ".join(result))
