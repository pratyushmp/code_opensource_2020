import socket

def is_valid_ip(host):
    try:
        socket.inet_aton(host)
        print "Valid ip address"
        return True
    except socket.error:
        print "Not a valid host:"+host
        return False

is_valid_ip("10.1.2.23")
is_valid_ip("122.22.34.98")
is_valid_ip("234.345.421.1")