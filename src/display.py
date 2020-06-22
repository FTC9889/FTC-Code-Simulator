import json
import numpy as np
import math
import pygame
from pygame.locals import *

# Used for loading settings
def getFromSettings(setting):
    with open("settings.json", "r") as read_file:
        data = json.load(read_file)
    return data[str(setting)]

# Rotate a rectangle
def epicRect(Surface, color, center, width, height, rotation):
    s = np.sin(np.deg2rad(rotation))
    c = np.cos(np.deg2rad(rotation))

    topRight = [center[0] + width/2, center[1] + height/2]
    topLeft = [center[0] - width/2, center[1] + height/2]
    bottomRight = [center[0] + width/2, center[1] - height/2]
    bottomLeft = [center[0] - width/2, center[1] - height/2]

    topRight[0] -= center[0]
    topRight[1] -= center[1]
    xnew = topRight[0]*c - topRight[1]*s
    ynew = topRight[0]*s + topRight[1]*c
    topRight[0] = xnew + center[0]
    topRight[1] = ynew + center[1]
    
    topLeft[0] -= center[0]
    topLeft[1] -= center[1]
    xnew = topLeft[0]*c - topLeft[1]*s
    ynew = topLeft[0]*s + topLeft[1]*c
    topLeft[0] = xnew + center[0]
    topLeft[1] = ynew + center[1]
    
    bottomRight[0] -= center[0]
    bottomRight[1] -= center[1]
    xnew = bottomRight[0]*c - bottomRight[1]*s
    ynew = bottomRight[0]*s + bottomRight[1]*c
    bottomRight[0] = xnew + center[0]
    bottomRight[1] = ynew + center[1]
    
    bottomLeft[0] -= center[0]
    bottomLeft[1] -= center[1]
    xnew = bottomLeft[0]*c - bottomLeft[1]*s
    ynew = bottomLeft[0]*s + bottomLeft[1]*c
    bottomLeft[0] = xnew + center[0]
    bottomLeft[1] = ynew + center[1]

    pygame.draw.line(Surface, color, (topLeft[0], topLeft[1]), (topRight[0], topRight[1])) 
    pygame.draw.line(Surface, color, (topRight[0], topRight[1]), (bottomRight[0], bottomRight[1]))  
    pygame.draw.line(Surface, color, (bottomRight[0], bottomRight[1]), (bottomLeft[0], bottomLeft[1]))
    pygame.draw.line(Surface, color, (bottomLeft[0], bottomLeft[1]), (topLeft[0], topLeft[1]))
    pygame.draw.circle(Surface, (0, 255, 0), (int((topLeft[0] + topRight[0])/2), int((topLeft[1] + topRight[1])/2)), 4)

def angleCal(dx, dy):
    return np.degrees(np.arctan2(dy, dx))

# Icon
def loadIcon(pygame):
    try:
        icon = pygame.image.load("22845596.png")
        pygame.display.set_icon(icon)
    except:
        print("Icon not found.")

global lastx_error, lasty_error
lastx_error, lasty_error = 1000, 1000
def responce(currentPosition, wantedPosition, currentAngle, dt, lastx_error, lasty_error):
    x_error = wantedPosition[0] - currentPosition[0]
    y_error = wantedPosition[1] - currentPosition[1]

    d_x = (x_error - lastx_error) / dt
    d_y = (y_error - lasty_error) / dt

    p = 0.1
    d = -0.00000000001

    cos = math.cos(math.radians(currentAngle))
    sin = math.sin(math.radians(currentAngle))
    dx = (x_error * p + d_x * d)
    dy = (y_error * p + d_y * d)

    lastx_error = x_error
    lasty_error = y_error

    return [int(currentPosition[0] + dx), int(currentPosition[1] + dy)]

def changePointCondition(currentPosition, wantedPosition, radius):
    x_ = wantedPosition[0] - currentPosition[0]
    y_ = wantedPosition[1] - currentPosition[1]

    dist = (x_ * x_) + (y_ * y_)
    return dist <= (radius * radius)

def angle_responce(current, wantedAngle):
    error = wantedAngle - current
    dAngle = error * 0.25
    return current + dAngle

# Init pygame
pygame.init()
pygame.font.init()
myfont = pygame.font.SysFont(None, 20)
clock = pygame.time.Clock()

# Display
DISPLAYSURF = pygame.display.set_mode((640, 800), 1, 32)
pygame.display.set_caption('Cruise Planner')

loadIcon(pygame)

fieldImg = pygame.image.load(getFromSettings('regularView'))
fieldImg = pygame.transform.scale(fieldImg, (640, 640))

# Display Field Image
DISPLAYSURF.blit(fieldImg, (0, 0))

# Button for generating path
buttonRect = pygame.Rect

# Pixel Per Inch
pixelPerInch = fieldImg.get_rect().size[0] / getFromSettings('fieldWidth')  

outerRadiusOfRobot = int(0.5 * pixelPerInch * ((getFromSettings("robotWidth")**2 + getFromSettings("robotLength")**2)**0.5))

# Points to drive too
points = [[320,320], [320, 200], [200, 320], [430, 500]] # Inches
angles = [0, 0, 90, 180] # Degrees

currentPosition = [320, 320]
currentAngle = 0

running = True
step = 0

listOfPastCurrentPoints = [currentPosition]
# Loop
while running:
    DISPLAYSURF.blit(fieldImg, (0, 0))
    pygame.draw.rect(DISPLAYSURF, (0,0,0), (0, 640, 640, 800))

    for point in points:
        pygame.draw.circle(DISPLAYSURF, (0,0,0), point, 6)
        lastPoint = (point[0], point[1])


    currentAngle = angle_responce(currentAngle, angles[step])
    epicRect(DISPLAYSURF, (0,0,0), currentPosition, getFromSettings("robotWidth")*pixelPerInch, getFromSettings("robotLength")*pixelPerInch, currentAngle)
    
    for currentPosition in listOfPastCurrentPoints:
        pygame.draw.circle(DISPLAYSURF, (0,255,0), (currentPosition[0], currentPosition[1]), 3)
    
    if(changePointCondition(currentPosition, points[step], 20) and step<len(points)-1):
        step += 1
    
    currentPosition = responce(currentPosition, points[step], currentAngle, 1/40, lastx_error, lasty_error)
    pygame.draw.circle(DISPLAYSURF, (255,0,0), (currentPosition[0], currentPosition[1]), 6)

    if(not (currentPosition == listOfPastCurrentPoints[-1])):
        listOfPastCurrentPoints.append(currentPosition)

    # On Event
    for event in pygame.event.get():
        if event.type == MOUSEBUTTONDOWN:
            currentPosition = [event.pos[0], event.pos[1]]
        if event.type == QUIT: # Quit
            pygame.quit()
        elif event.type == pygame.KEYDOWN:
            if event.key == pygame.K_ESCAPE:
                running = False

    #cap the framerate
    clock.tick(10)
    pygame.display.update()

pygame.quit()

if if __name__ == "__main__":
    print("hey")
    pass