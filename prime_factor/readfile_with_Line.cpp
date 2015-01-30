#include <iostream>
#include <fstream>
#include <string>
#include <cstdio>
#include <cstdlib>
using namespace std;
void usage(){
	cout <<"usage:\n"
	       "1) readfile_with_Line $file_name $number_Line_delete\n";
	cout <<"2) readfile_with_Line $file_name $Tag_remove\n";
}
int main(int argc,char** argv)
{
	if(argc!=3)
        {
	  cerr<<"para number error\n";
          return -1;
        }

	string file_name=argv[1];
	int LineLast_delete = atoi(argv[2]);
	string Tag_remove = argv[2];
	string buffer;
	int Line_counter=0;
        fstream fin(file_name.c_str(),ios::in);
        fstream fout("tempfile",ios::out);
        while(getline(fin,buffer)){
		Line_counter++;
		if(Line_counter > LineLast_delete &&
	           buffer.find(Tag_remove)==string::npos)
                {
                  fout << buffer<<endl;
		}

	}	
	fin.close();
	fout.close();
	remove(file_name.c_str());
	rename("tempfile",file_name.c_str());
	return 0;
}
