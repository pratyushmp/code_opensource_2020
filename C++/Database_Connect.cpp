//Pract6q2:WAP of Database connectivity using Mysql
#include <iostream>
#include <string>
#include <windows.h>
#include <mysql.h>

using namespace std;

int main()
{
    MYSQL* conn;
    MYSQL_ROW row;
    MYSQL_RES *res;
    int qstate;

       conn = mysql_init(0);
    if(conn)
        cout<<"connection object ok, conn="<<conn<<endl;
    else
        cout<<"conn object problem: "<<mysql_error(conn);

    conn = mysql_real_connect(conn,"localhost","root","","mca",0,NULL,0);

    if(conn)
    {
        cout<<"connected to database mca"<<endl;

        string id,name,phone;
        cout<<"enter id: "<<endl; cin>>id;
        cout<<"enter name: "<<endl; cin>>name;
        cout<<"enter phone: "<<endl; cin>>phone;

       
        string query="insert into mcafy(id,name,phone) values('"+id+"','"+name+"','"+phone+"')";


        const char* q = query.c_str();

        cout<<"query is: "<<q<<endl;
        qstate = mysql_query(conn,q);

        if(!qstate)
            cout<<"record inserted successfully..."<<endl;
        else
            cout<<"query problem: "<<mysql_error(conn)<<endl;

        qstate = mysql_query(conn,"select * from mcafy");

        if(!qstate)
        {
            res = mysql_store_result(conn);
            while(row=mysql_fetch_row(res))
            {
                cout<<"id: "<<row[0]<< " "
                    <<"name: "<<row[1]<< " "
                    <<"phone: "<<row[2]<<endl;
            }
        }
        else
        {
            cout<<"query error: "<<mysql_error(conn)<<endl;
        }
    }
    else
    {
        cout<<"connection problem: "<<mysql_error(conn)<<endl;
    }

    mysql_close(conn);

    return 0;
}