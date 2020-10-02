
#include "csapp.h"

int main(int argc, char **argv)
{
    int clientfd;
    char *host, *port, buf[MAXBUF] , bufRead[MAXBUF];

    if (argc != 3) {
	fprintf(stderr, "usage: %s <host> <port>\n", argv[0]);
	exit(0);
    }
    host = argv[1];
    port = argv[2];

    clientfd = Open_clientfd(host, port);
 	
int fd1 ; 
	fd1 = Open("input.txt" , O_RDWR | O_CREAT , 0b111111111); 

    
while (Read(0 ,buf, MAXBUF) != 0 ) {
	write(fd1, buf, strlen(buf)); // write to file 
        write(clientfd, buf, strlen(buf)); // write to socket 
	read(clientfd, bufRead, MAXBUF);
	write(1, bufRead, strlen(bufRead)); // write to out(screen) 
	
    }
    Close(clientfd); 
    exit(0);
}

