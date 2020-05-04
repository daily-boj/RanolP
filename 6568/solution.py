INST_STA = 0b000
INST_LDA = 0b001
INST_BEQ = 0b010
INST_NOP = 0b011
INST_DEC = 0b100
INST_INC = 0b101
INST_JMP = 0b110
INST_HLT = 0b111


class Program:
    def __init__(self, lines):
        self.accu = 0
        self.pc = 0
        self.memory = lines

    def run(self):
        while 1:
            code = self.memory[self.pc]
            command_map = {
                INST_STA: program.sta,
                INST_LDA: program.lda,
                INST_BEQ: program.beq,
                INST_NOP: program.nop,
                INST_DEC: program.dec,
                INST_INC: program.inc,
                INST_JMP: program.jmp,
                INST_HLT: program.hlt,
            }
            command = command_map[code >> 5]
            operand = code & 0b11111

            self.pc += 1
            if self.pc >= len(self.memory):
                self.pc -= len(self.memory)
            to_continue = command(operand)

            if not to_continue:
                break
        print(bin(self.accu)[2:].zfill(8))

    def sta(self, operand):
        self.memory[operand] = self.accu
        return True

    def lda(self, operand):
        self.accu = self.memory[operand]
        return True

    def beq(self, operand):
        if self.accu == 0:
            self.pc = operand
        return True

    def nop(self, operand):
        return True

    def dec(self, operand):
        if self.accu == 0b0000_0000:
            self.accu = 0b1111_1111
        else:
            self.accu -= 1
        return True

    def inc(self, operand):
        if self.accu == 0b1111_1111:
            self.accu = 0b0000_0000
        else:
            self.accu += 1
        return True

    def jmp(self, operand):
        self.pc = operand
        return True

    def hlt(self, operand):
        return False


programs = []
lines = []
left_lines = 32

try:
    while 1:
        if left_lines == 0:
            programs.append(Program(lines))
            left_lines = 32
            lines = []
        left_lines -= 1
        lines.append(int(input(), 2))
except EOFError:
    pass

for program in programs:
    program.run()
