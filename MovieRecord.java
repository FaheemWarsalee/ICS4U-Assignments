class MovieRecord {
  
  String title;
  String director;
  int yearRelease;
  int runTime;  //Length of movie in minutes
  float rating; //Same as double but less precise
  
  
  String printData(){    
    return ""+title+"\n"+director+"\n"+yearRelease+"\n"+runTime+"\n"+rating;
  } 
}