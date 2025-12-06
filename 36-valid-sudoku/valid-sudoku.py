class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        if(len(board)!=9 or any(len(row)!=9 for row in board)):
            return False

        rows=[[False]*9 for _ in range(9)]
        cols=[[False]*9 for _ in range(9)]
        boxes=[[False]*9 for _ in range(9)]

        for i in range(9):
            for j in range(9):
                if board[i][j]!='.':
                    num=ord(board[i][j])-ord('1')
                    box_index=(i//3)*3+(j//3)
                    if rows[i][num] or cols[j][num] or boxes[box_index][num]:
                        return False
                    rows[i][num]=cols[j][num]=boxes[box_index][num]=True
        return True