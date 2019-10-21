"""
Modify the recursive tree program using one or all of the following ideas:

Modify the thickness of the branches so that as the branchLen gets smaller, the line gets thinner.

Modify the color of the branches so that as the branchLen gets very short it is colored like a leaf.

Modify the angle used in turning the turtle so that at each branch point the angle is selected at random in some range. For example choose the angle between 15 and 45 degrees. Play around to see what looks good.

Modify the branchLen recursively so that instead of always subtracting the same amount you subtract a random amount in some range.

If you implement all of the above ideas you will have a very realistic looking tree.
"""
"""
Modify the recursive tree program using one or all of the following ideas:

Modify the thickness of the branches so that as the branchLen gets smaller, the line gets thinner.

Modify the color of the branches so that as the branchLen gets very short it is colored like a leaf.

Modify the angle used in turning the turtle so that at each branch point the angle is selected at random in some range. For example choose the angle between 15 and 45 degrees. Play around to see what looks good.

Modify the branchLen recursively so that instead of always subtracting the same amount you subtract a random amount in some range.

If you implement all of the above ideas you will have a very realistic looking tree.
"""

"""
I'll come back to this if I have time.  I'm tired of dealing with it atm.
"""

import turtle

def tree(branchLen,t):
    if branchLen > 5:
        drawRect(t,branchLen)
        t.right(20)
        tree(branchLen-15,t)
        t.left(40)
        tree(branchLen-15,t)
        t.right(20)
        t.backward(branchLen)
        
def drawRect(t, len):
    width = ((len // 15)*2)

    x, y = t.xcor(), t.ycor()

    t.fillcolor("brown")
    t.fill(True)
    t.left(90)
    t.forward(width//2)
    for i in range(2):
        t.forward(len)
        t.left(90)
        t.forward(width)
        t.left(90)

    t.fill(False)
    t.setx(x)
    t.sety(y+40)   
def main():
    t = turtle.Turtle()
    myWin = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    myWin.exitonclick()
    tree(75,t)
main()