import urllib.request

def getPose(): 
    r = urllib.request.urlopen('http://localhost:8080')
    msg = str(r.read())
    msg = msg.replace('b', '')
    msg = msg.replace("'", '')
    msg = msg.replace(" ", '')
    msg = msg.split(",")

    return [int(msg[0]), int(msg[1]), float(msg[2])]

if if __name__ == "__main__":
    print("hey")
    pass