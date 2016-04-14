1. Home page provides the list of Movie.
2. We can Edit and Delete the Saved Movie.
3. We can add Movie and Search Movie by Title, Year and Artist Name.
4. Created a two controlloer (Movie and Search Controler)
5. In Search Controller called Movie Dao, in case of Search by Movie Name: 
	Used the JPA Query(From Movie mov where mov.title like :name), Similarly in case of Year and Artist.
6. In case of Add we can add mltiple artist and Director on the same movie, 
	and called the Movie Controller to save the Movie and associated Artist and Director.
7. We can delete the specific movie.

