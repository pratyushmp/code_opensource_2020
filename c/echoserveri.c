/*
 * echoserveri.c - An iterative echo server
 */
/* $begin echoserverimain */
#include "csapp.h"

void echo(int connfd);

int main(int argc, char **argv)
{
    int listenfd, connfd;
    socklen_t clientlen;
    struct sockaddr_storage clientaddr;  /* Enough space for any address */  //line:netp:echoserveri:sockaddrstorage
    char client_hostname[MAXBUF], client_port[MAXBUF];

    if (argc != 2) {
	fprintf(stderr, "usage: %s <port>\n", argv[0]);
	exit(0);
    }

    listenfd = Open_listenfd(argv[1]);
 
    while (1) {
	clientlen = sizeof(struct sockaddr_storage);
        fprintf(stdout, "clientlen %d", clientlen);
	connfd = Accept(listenfd, (SA *)&clientaddr, &clientlen);
	fprintf(stdout, "connfd %d", connfd);
  
	echo(connfd);
	Close(connfd);
    }
    exit(0);
}
/* $end echoserverimain */


void echo(int connfd)
{
    size_t n;
    char buf[MAXBUF];


    while((n = read(connfd, buf, MAXBUF)) != 0) { //line:netp:echo:eof
	printf("server received %d bytes\n", (int)n);
	write(connfd, buf, n);
    }
}
